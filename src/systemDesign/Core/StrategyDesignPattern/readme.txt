Strategy design pattern	
------------------------

Problem ->
----------
When multiple child classes inherit from a base class and each class has 
some method which are common for other child classes as well
For example - sport car and off-road car both has a drive method
which will print "Sport drive" while electric car and goods truck
have a drive method which will print "Normal drive".
If we write method in each of the child classes individually there will
be a lot of code duplication. That's why this pattern is introduced.


Pattern ->
----------
In the parent class, define an interface driveStrategy, that interface will have a 
method signature Drive() and define implementations of the interface only once
in other classes Like SportDriveStrategy, NormalDriveStrategy etc.

Use that interface in the parent class and inject in inside the constructor
using constructor injection.

In the child classes, call the super constructor in the child constructor and
pass the respective class strategy which is needed in that class
This will avoid duplication of the drive methods inside respective classes
which needs same capability.
-----------------------