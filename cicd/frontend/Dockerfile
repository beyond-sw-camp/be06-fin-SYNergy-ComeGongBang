FROM  nginx:latest
EXPOSE 80
COPY /frontend/dist /usr/share/nginx/html
COPY /cicd/frontend/default.conf /etc/nginx/conf.d/
CMD ["nginx", "-g", "daemon off;"]