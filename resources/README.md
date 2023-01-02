### Ubuntu Server:
```shell
# Change the IP Address.
sudo nano /etc/netplan/<init-file>
```

### Xen-Orchestra:
Docker Image: https://hub.docker.com/r/ronivay/xen-orchestra
```shell
docker run --name xen -itd -p 80:80 ronivay/xen-orchestra
```

### OpenJDK components:
```shell
sudo pacman -S jdk-openjdk jre-openjdk
java --version
```

### Postgres-SQL-Database:
```shell
# Delete all volumes.
sudo docker volume rm $(sudo docker volume ls -q)
```
```shell
# Run postgres container:
sudo docker run -itd -p 5432:5432 \
	--name postgres-alpine \
	--env-file .env/Postgres_Credentials.env \
	postgres:15.1-alpine
```

### Spring:
https://start.spring.io/

### Kubernetes k0s:
```shell
# Generate ssh certificates for all 3 vm servers and controller pc.
# (Provisioned with terraform xen-orchestra provider)
ssh-keygen -t Ed25519 -b 256 -C "<machine_name> <user> <email>"
```
Once all the certificates are generated, copy the id's from the controller pc to each vm.
```shell
ssh-copy-id <user>@<server_ip>
```
If wanted to avoid strict host checking, use the aliased versions. (place in .zshrc)
```shell
alias ssh0='ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -o LogLevel=ERROR'
alias sshy='ssh -o CheckHostIP=no'
```
Install k0s from https://github.com/k0sproject/k0sctl.
```shell
wget https://github.com/k0sproject/k0sctl/releases/download/v0.15.0/k0sctl-linux-x64 && mv k0sctl-linux-x64 ~/k0sctl && chmod 777 k0sctl
```
Configuration directory.
```shell
~/k0sctl init > k0sctl.yaml
```
Apply configuration.
```shell
~/k0sctl apply --config k0sctl.yaml
```