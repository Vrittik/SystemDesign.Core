Factory design pattern	
----------------------

Problem ->
----------
Whenever you want to instantiate new objects inside a class
we have to define dependency of those objects inside the class
either through constructor injection or autowiring.
This creates tight coupling amongst the classes.


Pattern ->
----------
Define a factory class that gets object of particular type and use
only that factory as a dependency inside the main class
and get the objects using that factory.

Pattern Type ->
----------
Creational design pattern
-----------------------