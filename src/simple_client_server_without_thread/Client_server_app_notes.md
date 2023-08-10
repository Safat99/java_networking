# Client Server App 


## Without Threading Problems:
Suppose, we have one server, and two clients are now connected.

In this case, the server will serve sequentially no matter which client requests it first; rather, the client that was connected first will receive the first response from the server.

So in this case all the clients have to wait after server serves the previous of them.

## With Threading Mechanism

* when a client hits to the server, server will open a thread (suppose we name it ServerThread).
* For each client, server will open a new ServerThread.
* 