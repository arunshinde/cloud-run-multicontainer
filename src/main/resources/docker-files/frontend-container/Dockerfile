# Use the official Nginx image as the base image
FROM docker.io/nginx:alpine

#Set metadata labels
LABEL maintainer="aroon4uu <example@gmail.com>" 
LABEL version="2.0"
LABEL application="Cloud Run MultiContainer Frontend"

RUN apk add --no-cache libcap nginx-mod-http-headers-more && rm -rf /var/cache/apk/* /var/lib/apt/lists/*
    
RUN addgroup -g 1001 appwebgroup && adduser -D -u 1001 -G appwebgroup appwebuser

# Remove the default Nginx configuration 
RUN rm /etc/nginx/nginx.conf

RUN mkdir -p /run/nginx /var/run

#RUN touch -p /var/run/nginx.pid

#set permission for the user and group
RUN chown -R appwebuser:appwebgroup /etc/nginx /etc/nginx/conf.d /usr/share/nginx/html /run/nginx/ /var/run/ /var/log/nginx /var/cache/nginx

# Copy the default Nginx configuration 
COPY /src/main/resources/docker-files/frontend-container/nginx.conf /etc/nginx/
COPY /src/main/resources/docker-files/frontend-container/default.conf /etc/nginx/conf.d/
COPY /src/main/resources/static /usr/share/nginx/html


RUN setcap 'cap_net_bind_service=+ep' /usr/sbin/nginx

USER appwebuser

#Permissions set for the root user
RUN find / -perm /6000 -type f -exec chmod a-s {} \; || true

# Define the command to run when the container starts
EXPOSE 8080
#CMD ["nginx", "-g", "daemon off;"]
ENTRYPOINT ["nginx", "-g", "daemon off;"]