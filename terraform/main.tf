#----------------------------------------------------------------------------
# Environment variable fetching.
#----------------------------------------------------------------------------
data "external" "env" {
  program = ["python3", "${path.module}/env.py"]
  # For Windows (or Powershell core on MacOS and Linux),
  # run a Powershell script instead
  #program = ["${path.module}/env.ps1"]
}

# Show the results of running the data source. This is a map of environment
# variable names to their values.
output "env" {
  value = data.external.env.result
}

# Test.
output "GetUser" {
  value = data.external.env.result["XCP_USER"]
}
#----------------------------------------------------------------------------

#----------------------------------------------------------------------------
# Provider for xen orchestra.
#----------------------------------------------------------------------------
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
