variable "flavor" { default = "m1.large" }
variable "image" { default = "CentOS 7 20200205" }
variable "instance" { default = "tf_instance" }

variable "name" { default = "Test_CentOS_server" }

variable "network" { default = "KrisNetwork" }   # you need to change this
variable "keypair" { default = "tmpKey" }       # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server_script" { default = "./server.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_security_jenkins2" }