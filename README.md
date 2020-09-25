# Version Check Service Demo from Zhongjie Shen

## Where to test
### Local - default port is 8080 
``./mvnw spring-boot:run``

## How to test
You can send the POST request from Postman directly.
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

My LinkedIn: https://www.linkedin.com/in/zhongjis/