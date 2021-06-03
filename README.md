# Java Springboot redis Message Borker

Redis can be widely used in microservices architecture. Use Redis  as Message broker using Spring Boot. 

## Features

- Expose REST Controller
- Publish to Redis topic and subscribe two Subscribers
- Display the message


## Installation

Java Springboot redis Message Borker requires JDK11

Run the server.

```sh
cd <dir>
./gradle bootRun
```

REST

```sh
URI: http://localhost:8081/employees
HTTP Method: POST
Body type: application/json
Body:
{
"firstname": "siva",
"lastname": "selvi",
"age": 23,
"empID": 11
}
```

For running logs...

```sh
2021-06-03 20:31:43.752  INFO 20252 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-06-03 20:31:43.753  INFO 20252 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2021-06-03 20:31:43.839  INFO 20252 --- [nio-8081-exec-1] c.c.radis.publish.EmployeePublisher      : Sending: Employee(firstname=siva, lastname=selvi, age=23, empID=11)
2021-06-03 20:31:43.872  INFO 20252 --- [    container-3] c.c.r.subscribe.EmployeeITSubscriber     : Message received from EmployeeITSubscriber: Employee(firstname=siva, lastname=selvi, age=23, empID=11)
2021-06-03 20:31:43.872  INFO 20252 --- [    container-2] c.c.r.subscribe.EmployeeHRSubscriber     : Message received from EmployeeHRSubscriber: Employee(firstname=siva, lastname=selvi, age=23, empID=11)

```


## License

MIT

