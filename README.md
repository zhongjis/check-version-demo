# Version Check Service Demo from Zhongjie Shen

## Where to test
### Local - default port is 8080
In terminal, under your project directory and run ``./mvnw spring-boot:run``
endpoint: localhost:8080/api/v1/version/check
### Cloud - AWS (Available until xxx)
endpoint: Will be added soon.

## How to test
You can send the POST request from Postman directly [LINK](https://stackoverflow.com/questions/29364862/how-to-send-post-request-to-the-below-post-method-using-postman-rest-client)
Here's an example JSON body 
```json
{
    "firstVersionId": "3.1",
    "secondVersionId": "2.2.0"
}
```

## Project Highlight
### Build Tool
This project is built with Maven on Spring Boot v2.3.4.
### Service:
- VersionCheckController.java
- VersionCheckService.java
### Testing
- VersionCheckServiceUnitTest.java
- VersionCheckControllerIntegrationTest.java (TODO)

My LinkedIn: https://www.linkedin.com/in/zhongjis/