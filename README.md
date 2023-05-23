# REST API with MongoDb example

This is a simple example demonstrating how to create a REST API using Spring Boot, MongoDB, and Docker Compose. 
The application follows best practices for building RESTful applications.

## Technologies

- Spring:Boot, Web, Validation, 
- MongoDb, Mongo Express
- Lombok
- Docker

## Build and run
To run the application, make sure you have Docker installed on your computer. Then follow these steps:
Run the `docker-compose.yml` file. Remember to set the necessary environmental variables, which are also provided in the 
`env-variables.env` file. 

If you have already set the variables on your computer, you can simply run the following command:

```cmd
docker-compose up -d
```
if you want to use provided `env-variables.env` type:
```cmd
docker-compose --env-file env-variables.env up -d
```
After starting the MongoDB and Mongo Express containers, you need to run the application itself. 

Make sure to provide the following environmental variables: `MONGO_USERNAME` and `MONGO_PASSWORD`. 
The values should match the ones given during the docker-compose up command. 
You can set these variables on your computer or declare them when running the project.

## Docker connection between containers issue
I have provided a Dockerfile to run the application as a container, but unfortunately, it is not working.
There is an issue that I'm currently unable to resolve. 
When the container is created, the application is unable to connect to MongoDB, resulting in an `org.mongodb.driver.cluster:Exception error`.

The problem lies in how the application handles the connection. It attempts to connect to `localhost:27017` instead of using 
the specified MongoDB container name as the host. Even after creating a config class with a `MongoClient` bean to 
provide correct connection configuration and after excluding certain auto-configuration classes such as `MongoAutoConfiguration` and `MongoDataAutoConfiguration`, 
the application still insists on connecting to `localhost:27017`.

I'm aware of this problem and currently working on finding a solution. However, it may take some time to identify and solve the issue due to its complexity.

Apart from the Dockerfile and the issue with connecting containers, the rest of the application works as intended. 
Therefore, you can still use it as a starting point for your project, leveraging the benefits of Spring Boot, MongoDB, and Docker.