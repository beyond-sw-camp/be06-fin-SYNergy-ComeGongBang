FROM  nginx:alpine
EXPOSE 80
COPY /frontend/dist /usr/share/nginx/html
ADD /cicd/frontend/docker/default.conf /etc/nginx/conf.d/
CMD ["nginx", "-g", "daemon off;"]