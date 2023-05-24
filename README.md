# REST API with MongoDb example

This is a simple example demonstrating how to create a REST API using Spring Boot, MongoDB, and Docker Compose. 
The application follows best practices for building RESTful applications.

## Technologies

- Spring Boot (Web, Validation)
- MongoDb 
- Mongo Express
- Lombok
- Docker

## Build and run
To run the application, ensure that Docker is installed on your computer. 
You also need to set the required environmental variables either on your computer or in a provided file: 
`MONGO_USERNAME`, `MONGO_PASSWORD`, `MONGO_DB_NAME`, `MONGO_EXPRESS_PORT`, `APP_PORT`

If you have already set the variables on your computer, you can run the following command:
```cmd
docker compose up -d
```
If you want to use the provided env-variables.env file, use the following command:
```cmd
docker compose --env-file env-variables.env up -d
```
This command starts all three containers, including the application itself, MongoDB, and Mongo Express. 

If you use the provided variables file, the app will be available at `localhost:8080` and Mongo Express will be accessible at `localhost:8081`
