FROM java:8

ADD /target/UST-VehicleApp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]

EXPOSE 7006