# Synchronization in Java
Example Scenario --> Printer and person's assignment case analogy.. Why synchronization is needed. The printer must print one assignment no matter multiple person enters into the printing room.

Before a method name if we use `synchronized` keyword then the method maintains its synchronicity.



Also we can use `synchornized` block to make a read only class (which cannot be changed)




``` 

synchronized(object) { 

Method calling; 

} 

 

``` 

In that case we have to make the object `final` using `final` keyword. 