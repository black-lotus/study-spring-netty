##Install Dependencies
```$ mvn clean install```

##Run Application
```$ mvn spring-boot:run```

##Swagger
http://localhost:8080/swagger-ui.html

##Current Issues
- application.properties does not recognize by spring-boot
- someRepository.findById(id) does not works
- find() then save() error `Optimistic lock exception on saving entity`