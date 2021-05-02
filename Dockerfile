FROM java:8
MAINTAINER biber

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

VOLUME /tmp
ADD target/*.jar ddmall.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","ddmall.jar"]