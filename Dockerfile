FROM openjdk:8

EXPOSE 8087

ADD target/loan-management-retrieval-service.jar loan-management-retrieval-service.jar

ENTRYPOINT ["java","-jar","loan-management-retrieval-service.jar"]
