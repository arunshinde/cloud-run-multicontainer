FROM eclipse-temurin:23-jre-alpine

# Set metadata labels
LABEL maintainer="aroon4uu <example@gmail.com>" 
LABEL version="2.0"
LABEL application="Cloud Run MultiContainer Backend"

#The JAR will be copied into the image
ARG JAR_FILE=target//cloud-run-multicontainer-0.0.1-SNAPSHOT.jar

RUN apk update && apk upgrade --no-cache
RUN apk add gcompat
ENV LD_PRELOAD=/lib/libgcompat.so.0

COPY ${JAR_FILE} app.jar

#Permissions set for the root user
RUN find / -perm /6000 -type f -exec chmod a-s {} \; || true


#Expose the port
EXPOSE 8081

#Default docker run
ENTRYPOINT ["java","-jar","app.jar"]