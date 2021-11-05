FROM maven:3.6.3-openjdk-15
RUN mkdir job4j_tracker
WORKDIR job4j_tracker
COPY . .
RUN mvn package -Dmaven.test.skip=true
CMD ["java", "-jar", "target/mem-tracker.jar"]