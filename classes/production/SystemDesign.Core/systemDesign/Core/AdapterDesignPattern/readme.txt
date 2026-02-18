Adapter design pattern	
------------------------

Problem ->
----------
Whenever there is a mismatch between client and the resource, in 
that case an adapter is required to handle that synchronization

For that case adapter pattern is used

Use cases
1. We are consuming an api that return xml response but our 
system handles json objects, in that case we need adapter pattern
2. Weighing machine is giving output in pounds but needed in kg in 
some locations
3.Wrapping an old payment gateway API so it can work with a 
new e-commerce system.

Pattern ->
----------

The Adapter Design Pattern is used when you need to bridge the
gap between incompatible interfaces. It acts as a wrapper that 
allows two different systems to communicate without 
modifying their existing code

Existing interface is WeightMachine which returns in pounds, as per
adapter pattern we are not modifying existing resources, just creating 
an adapter over the top of it such that client can use that adapter
for its use.

WeightMachineAdapter is created which can define any type of weight
like gram, kg etc and many more implementations as per client needs

WeightMachineAdapter has a dependency of WeightMachine's implementation 
injected in it.

Pattern Type ->
----------
Structural design pattern
-----------------------