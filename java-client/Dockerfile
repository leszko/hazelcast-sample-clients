FROM maven:3.6.3-openjdk-16
ADD src/ src/
ADD pom.xml .
RUN mvn package

CMD java -cp target/java-sample-client-1.0-SNAPSHOT-jar-with-dependencies.jar com.rafalleszko.Main