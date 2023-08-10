# Client Server App 


## Without Threading Problems:
Suppose, we have one server, and two clients are now connected.

In this case, the server will serve sequentially no matter which client requests it first; rather, the client that was connected first will receive the first response from the server.

So in this case all the clients have to wait after server serves the previous of them.

## With Threading Mechanism
* There will be ServerThread class just like the previous Server Class.
* when a client hits to the server, server will open a thread (suppose we name it ServerThread).
* For each client, server will open a new ServerThread. Each ServerThread servers only one client.
* Then the client-serverThread are isolated and they are bind through their sockets.

To do that, 
If the client wants to connect to the server it will have to open a socket.

Client-Socket = Server IP + Server Port Address;

<b>limitations of using thread(till video 6/9)</b>
```
as read and write are completely independent tasks we have to create other threads to handle this.
Otherwise the client has to wait for the message until he sends anything. 
But there could be some cases, where incoming message are come before/during typing.
```

