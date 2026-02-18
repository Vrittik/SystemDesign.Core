Decorator design pattern	
------------------------

Problem ->
----------
When an object has f1 features, it can be decorated to another object having
f2 features and so on
resulting object can have f1 + f2 + f3 ........ + fn features

We need decoration pattern due to class explosion
because we have a base coffee class, now it can have multiple child
base coffee + extra milk
base coffee + chocolate
base coffee + ice
base coffee + ice + water
etc etc so there will be n number of classes

So we are just going to define a base class and add toppings thats it

Pattern ->
----------

In decorator pattern
The decorator has a pizza and it is also is a pizza (implementation)
because on decorator we can add more decorator

Used in Pizza
Base pizza
Base pizza + extra cheese
Base pizza + extra cheese + mushrooms
etc etc

Used in Coffee
Base coffee + extra milk + extra coffee

only decorators take instance of the base class so that they have has a base
capability and they also extends BasePizza

Pattern Type ->
----------
Structural design pattern
-----------------------