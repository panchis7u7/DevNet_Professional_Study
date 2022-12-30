#########################################################
Installation. (Arch-Linux)
#########################################################

Xen-Orchestra:
---------------------------------------------------------
https://hub.docker.com/r/ronivay/xen-orchestra
docker run --name xen -itd -p 80:80 ronivay/xen-orchestra

OpenJDK components:
---------------------------------------------------------
sudo pacman -S jdk-openjdk jre-openjdk
java --version

Postgres-SQL-Database:
---------------------------------------------------------
# Delete all volumes.
sudo docker volume rm $(sudo docker volume ls -q)
sudo docker run -itd -p 5432:5432 \
	--name postgres-alpine \
	--env-file .env/Postgres_Credentials.env \
	postgres:15.1-alpine


Spring:
---------------------------------------------------------
https://start.spring.io/