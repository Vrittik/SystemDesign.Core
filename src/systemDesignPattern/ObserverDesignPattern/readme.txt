Observer design pattern	
------------------------

Problem ->
----------
In amazon shopping, whenever an item goes out of stock, send notification
to all the users whenever the products comes back to stock.
Whoever has subscribed to the product's count should get the notification


Pattern ->
----------
There are 2 components observable and observer
whenever state of observable is changes (s1 -> s2 and s2->s3), it will update 
every observer that its state has changed and whatever operation
is required to be done on new state can be done.

There is an 

observable interface
it has methods like
add(IObserver observer) or register(IObserver observer) // add observer(observer which is subscribing)
remove(IObserver observer),  // remove an observer
notify()  // whenever state has changed, notify all observers
setData() // to store change in some state
getData() // to get the change

and its storing list of observers in parameters
List<IObservers> listOfObservers;

and 

observer interface,
it has method like
update()

implementation of observer interface -> has update()
and its storing the observable in its parameters
IObservable obj;

its defined explicitly because if Observable is passed into update(Iobservable obj) parameters
then it has to be resolved first, because there can be multiple
observable implementing the observable Interface.


Define concrete classes for observable and observer


Example:

Lets take a WhetherStationObservable and TvObserver and MobileObserver

WhetherStationObservable has property currentTemp, it will update currentTemp
and it will notify the observers in each 10 seconds.



-----------------------