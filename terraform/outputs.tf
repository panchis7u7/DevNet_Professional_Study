#############################################################################
# Display instances id's of the created node VM's after creating them.
#############################################################################

output "Instances" {
  description = "IDs of Ubuntu Server instances"
  value       = xenorchestra_vm.Ubuntu-Server.*.id
}
