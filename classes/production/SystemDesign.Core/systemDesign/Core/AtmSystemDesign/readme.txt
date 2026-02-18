ATM System design	
------------------------

Problem ->
----------
Design an ATM machine


Design ->
----------
Using chain of responsibility design pattern + State design pattern


Operations in an atm machine

User enters card (IDLE state) -> pin authentication -> operation options (change pin, withdraw, balance, statement etc)
-> user performs operation -> once the operation is done atm goes to IDLE state

Atm has set of operations
Insert card
Authenticate pin
Select operation (withdraw, balance, change pin, statement)
Perform the operation

The state design pattern is used here:
State wise operation 
Idle - Insert card
HasCard - Authenticate pin
Operation State - choose function to be done by the atm
Perform operation state - perform the selected operation

The chain of responsibility design pattern is used
to Withdraw

Let's assume we have 3 types of notes, 
2000 rupees notes, 
500 rupees notes, 
200 rupees notes and 
100 rupee notes
cash withdraw happens in descending order

3000 -> 1 * 2000 + 2 * 500 RUPEE note

Withdraw amount 3000,
3000 comes -> 2000 rupee processor -> processes 2000, 
difference -> 1000 -> 500 rupee processor -> can only process 500 rupee due
to limited notes 
-> difference -> 500 -> goes to 100 rupee processor -> processes 5 notes



1> Create atm machine, having machineState as paramater
2> On every operation, update the machine state accoridngly
3> Keep neccessary classes


Pattern Type ->
----------
Behavioral design pattern
-----------------------