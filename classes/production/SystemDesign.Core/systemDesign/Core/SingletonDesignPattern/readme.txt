Singleton Design Pattern
------------------------

Problem ->
----------
Whenever we want to create only one instance of a class and use it everywhere.
If we use new keyword, it will create new instance of the class everytime.
That's why Singleton design pattern is used.


Pattern ->
----------
We define a static instance in a class, a private constructor so that the class cannot
be instantiated outside its scope.
We make a method to return the static object,
check if the static instance has value, if not then instantiate and give otherwise
we give already instantiated instance.

Problem ->
----------
2 threads can create an instance together and that will create 2 instance.
For that we use synchronized method for instance creation or make the block synchronized


Pattern Type ->
----------
Creational design pattern
-----------------------