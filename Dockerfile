FROM openjdk:17

COPY target/institute_docker_app.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT [ "java","-jar","institute_docker_app.jar" ]
