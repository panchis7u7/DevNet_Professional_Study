To activate/override them, you just need to set spring.profiles.active on the according environment.

```shell
java -jar -Dspring.profiles.active=prod target/myApp.jar 
```
```shell
# in windows: SET SPRING_PROFILES_ACTIVE=prod
export SPRING_PROFILES_ACTIVE=prod
java -jar target/myApp.jar
```
```shell
java -jar target/myApp.jar --spring.profiles.active=prod
```