# springboot-docker-starterkit

Here I'll show how to deploy SpringBoot RESTful web service application with Docker

### Prerequisite
Installed: [Docker](https://www.docker.com/), [Java 1.8](https://www.oracle.com/technetwork/java/javase/overview/index.html), [Maven 3.x](https://maven.apache.org/install.html), [Git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)

### Steps
**Clone source code from git**
```
$ git clone https://github.com/exceptionalcode/springboot-docker-starterkit.git
```

**Maven build source code**\
To build spring-boot-client/spring-boot-server cd inside the directory
```
$ mvn clean install
```

**Build a Docker Image**\
To build an image go inside the spring-boot-client project directory on the location of **Dockerfile**
```
$ docker build -t spring-boot-client .
```
> **Note:** If you run this command for first time it will take some time in order to download base image from [DockerHub](https://hub.docker.com/)\

Same for the spring-boot-server
```
$ docker build -t spring-boot-server .
```
> (-t) represents the tag\
>(.) repesents the current directory for Dockerfile

**Docker Images**
```
$ docker images
REPOSITORY                           TAG                                              IMAGE ID            CREATED              SIZE
spring-boot-server                   latest                                           7026789d8203        12 seconds ago       121MB
spring-boot-client                   latest                                           fcba08ef1fb4        About a minute ago   121MB

```
> With comamnd '$ docker images' you'll see two images build above

**Run Docker Container** 
```
$ docker run --rm -d -p 9001:9001 spring-boot-client
```
> --rm stands for exited when the container is stopped or removed\
> -d to start a container in the backgroud\
> -p ports to map from container to ouside the world

Same with run the spring-boot-server container
```
$ docker run --rm -d -p 9002:9002 spring-boot-server
```

**Test the container**\
Client application endopoint
```
$ curl http://localhost:9001/
```
Output : Hello from client


Server application endpoint 
```
$ curl http://localhost:9002/
```
Output : Hi!!!

**Call Client to Server App**\
To call Server endpoint(Container) from Client endpoint(Container)
```
$ curl http://localhost:9001/callServerFromClient
```
Output : {"timestamp":"2020-06-06T14:50:56.717+00:00","status":500,"error":"Internal Server Error","message":"","path":"/callServerFromClient"}

> **Here you can observer you can not communicate from one container to other**
<p align="center">
  <img src="images/docker-no-communication.png" height="315" width="600" align="center">
</p>
