# changAndRoberts-Spring-

This is an application that simulates the CHANG AND ROBERTS nwtworking algorithm. First, a trigger call is started.
The nodes run on ports: **8081,8082,8083** , and the tower control on 8090.

After running all 3 projects, access as a GET request: `localhost:{whatever port except the tower control}/election`.
The algorithm will go through all the nodes and will send to the next node, the maximum between the node's value and the incomed value.
After the maximum is known, another **leader** call will be triggered and when the node's value equlas the leader's value, a POST request will be sent to the tower cotrol.

To run the application, just clone the repo and start each project individually.
