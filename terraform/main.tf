#############################################################################
# Environment variable fetching.
#############################################################################
data "external" "env" {
  program = ["python3", "${path.module}/env.py"]
  # For Windows (or Powershell core on MacOS and Linux),
  # run a Powershell script instead
  #program = ["${path.module}/env.ps1"]
}

# Show the results of running the data source. This is a map of environment
# variable names to their values.
output "GetUser" {
  value = data.external.env.result["XCP_USER"]
}

#############################################################################
# Template, Storage and Networking referencing.
#############################################################################
data "xenorchestra_pool" "pool" {
  name_label = "xeon-server"
}

data "xenorchestra_sr" "smb_arch_sr" {
  name_label = "ISO Files Arch"
}

data "xenorchestra_network" "net" {
  name_label = "Pool-wide network associated with eth0"
}

data "xenorchestra_template" "ubuntu_template" {
  name_label = "Ubuntu Focal Fossa 20.04"
}

data "xenorchestra_template" "other_template" {
  name_label = "Other install media"
}

#############################################################################
# Provider configuration for xen orchestra.
#############################################################################
# Instruct terraform to download the provider on `terraform init`
terraform {
  required_providers {
    xenorchestra = {
      source = "terra-farm/xenorchestra"
    }
  }
}

# Configure the XenServer Provider
provider "xenorchestra" {
  # Must be ws or wss
  url      = data.external.env.result["XCP_HOSTNAME"] # Or set XOA_URL environment variable
  username = data.external.env.result["XCP_USER"]     # Or set XOA_USER environment variable
  password = data.external.env.result["XCP_PASSWORD"] # Or set XOA_PASSWORD environment variable

  # This is false by default and
  # will disable ssl verification if true.
  # This is useful if your deployment uses
  # a self signed certificate but should be
  # used sparingly!
  insecure = true # Or set XOA_INSECURE environment variable to any value
}

#############################################################################
# TrueNAS vm configuration.
#############################################################################
resource "xenorchestra_vm" "TrueNAS" {
  memory_max       = 8589934592
  cpus             = 2
  name_label       = "TrueNAS"
  name_description = "Storage Server VM."
  #affinity_host    = data.xenorchestra_pool.pool.id
  template          = data.xenorchestra_template.other_template.id
  auto_poweron      = true
  exp_nested_hvm    = true
  hvm_boot_firmware = "bios"
  cdrom {
    id = "7efb593b-160a-4fdc-9c8d-9b9f98537331"
  }
  network {
    network_id = data.xenorchestra_network.net.id
  }

  disk {
    sr_id      = "ef1d6d1e-843d-d387-b6f1-d581ea75b8a2"
    name_label = "TrueNAS-Disk"
    size       = 107374182400
  }

  tags = [
    "TrueNAS",
    "NAS",
    "Storage"
  ]

  # Override the default create timeout from 5 mins to 20.
  timeouts {
    create = "20m"
  }
}

#############################################################################
# Future VM.
#############################################################################
