Abstract factory design pattern	
-------------------------------

Problem ->
----------
Whenever you want to instantiate new objects inside a class
we have to define dependency of those objects inside the class
either through constructor injection or autowiring.
This creates tight coupling amongst the classes.
Also when the objects can be logically grouped into some components
like Vehicles is the abstract, there can be vehicles like
mercedes, bmw, maruti, hyundai. Now mercedes and bmw can be places as 
luxury vehicles and maruti and hyundai as oridinar vehicles.


Pattern ->
----------
Its a factory of factory. First a factory is returned based on which type of
vehicle is required to be instantiated. Using that factory, only the object
will be returned that are logically placed inside that factory.

Ordinary vehicle factory can only return hyundai, maruti
and luxury vehicle factory can only return bmw and mercedes.

In main method, only abstractVehicleFactory will be defined and 
then different factories will be extracted from it, and then 
vehicles will be extracted from the abstracted factories.

Pattern Type ->
----------
Creational design pattern
-----------------------