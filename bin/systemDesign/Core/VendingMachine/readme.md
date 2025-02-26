vending Machine design	
------------------------

Problem ->
----------
Design a vending machine


Design ->
----------

Design overview 
![Alt Text](assets/Vending machine.jpg)


Happy flow
![Alt Text](assets/HF.jpg)

In Every state certain operations are allowed

Idle -> push button to add money
HasMoney -> Insert coin, select product, cancel/refund button
Selection state -> Choose product, Cancel/refund, return change
Dispense -> product Dispense

Whenever in a state there are different operations (state vise operations)
its a question of state design pattern.


Vending machine has following state

1. Idle state - vending machine untouched
2. HasMoney state - When the user clicked on add coins, state is changed to HasMoney state, user has refund option
3. ProductSelection state - When the user added coins and clicked on select product button, user has refund option
4. Dispense state - When the user entered the product code number and coins added to the machine are sufficient
to buy the product then dispense the product and give user the change, otherwise refund.


There are only specific actions which can be done based on state of the Machine

All action list = Press Add coin, insert coin, select product, refund, add product code, dispense, get change

and state vise allowed operations ->
Idle state - Press Add coin button/action
HasMoney state - Insert coin, select product, refund button/actions
SelectProductState - Add product code, refund button/actions
Dispense state - dispense the product, get change actions. Note: Inventory needs to be reduced in this state
-----------------------