FROM openjdk:13-alpine
Volume /tmp
ADD books/target/*.jar bookstore-0.0.1-SNAPSHOT.jar
ADD carts/target/*.jar bookstore-0.0.1-SNAPSHOT.jar
ADD orders/target/*.jar bookstore-0.0.1-SNAPSHOT.jar
ADD payments/target/*.jar bookstore-0.0.1-SNAPSHOT.jar
ADD users/target/*.jar bookstore-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bookstore-0.0.1-SNAPSHOT.jar"]
