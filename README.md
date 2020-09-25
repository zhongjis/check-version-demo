# Version Check Service Demo from Zhongjie Shen

## Where to test
### Local - default port is 8080
1. In terminal, under your project directory and run ``./mvnw spring-boot:run`` to build <br>
2. test the endpoint on Postman: http://localhost:8080/api/v1/version/check.
### Cloud - AWS (Available until Oct 10, 2020) 
1. check this [Link](http://3.128.186.177:8080/version-check-0.0.1-SNAPSHOT/api/v1/version/hellowrold) 
to see if the server is online (You will see "*Hello World from Zhongjie Shen*" if the server is up)
2. test the endpoint on Postman: http://3.128.186.177:8080/version-check-0.0.1-SNAPSHOT/api/v1/version/check.

## How to test
You can send the POST request from Postman directly [LINK](https://stackoverflow.com/questions/29364862/how-to-send-post-request-to-the-below-post-method-using-postman-rest-client) <br>
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
### Cloud
- AWS EC2
- EC2 Security group
- Tomcat 9
- Java 11

My LinkedIn: https://www.linkedin.com/in/zhongjis/
My AWS Certified Solutions Architect - Associate [Badge](https://www.youracclaim.com/badges/c924b3dc-3e96-44c0-b3fc-b6487c0f0f87/public_url)