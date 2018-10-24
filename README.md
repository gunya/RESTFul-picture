# RESTFul-picture

Your task is to implement RESTful facade backend API with two mock up services:

1. Picture details service (picture: id, title, description)
2. Picture comments service (comment: pictureId, username, message) Picture details service and Picture comments service are simple standalone services providing mock up data. You can use any mock server library. Requirements for the facade:
3. Endpoint for providing combined picture details and picture comments by picture id (in JSON)
4. Dummy endpoint for creating picture details. No communication with Picture details service. Endpoint should be authorized with ROLE_ADMIN
5. Dummy endpoint for creating Comment. No communication with Comments service. Endpoint should be authorized with ROLE_USER
6. Basic authentication
7. No user registration required. You can store mocked user data in memory.
8. Calls to the backend services should be implemented asynchronously
9. Picture details service responses should be cached with Least Frequently Used strategy
10. Comments service responses should also be cached but only as fallback. When the backend service is down, comments should be taken from cache.

1. Implemented with JAVA 8
2. Should start as a normal java application with embedded servlet container Things that will be evaluated:
1. Implementation
2. REST principles, proper status codes, headers, error responses
3. Tests
4. Clean code
5. Commits
6. You can use any open source library or framework you wish. Please create an open repository on github and send us the link with your final implementation. GOOD LUCK!
