Problem
“Count number of hits in last 5 minutes (300 seconds)”

Example

Example
hit(1)
hit(2)
hit(3)

getHits(4) → 3

after 300 seconds.....

hit(300)
getHits(300) → 4

One more second passed, hit(1) discarded
getHits(301) → 3 (hit at 1 expired)



-------------------------------------------
Approaches

1. Naive
Just store the hit timestamps in an array, whenever a getHits() request comes
then get the result as the last 300 seconds element by comparing the current time
with the timestamps in the array.

Problems
Store each hit in the array requires lot of space
Its not thread safe
Stale hits in the array (older hits)
The complexity of getHits() depends on O(arraySize) order

-----------------------------------------------------------------------
2. Better
Use a queue to store the timeStamps, whenever a getHits() request comes
then poll the elements from the queue until the time difference between the first
element in the queue and the (now) is > 300 seconds (last 5 minutes)
After polling, return the size of the queue as total hits in last 5 minutes

Advantages
Queue doesn't keep stale entries saved

Problems
Storing each hit in the queue
It's not thread safe
The complexity of getHits() depends on O(n) order

-----------------------------------------------------------------------
3. Optimized
Since we are only considering the last 5 minutes hit count
We can store the hit of every second in an array of 300 entries only

We can take 2 arrays, one to store hitCount and other to store hitTimeStamps

Example

Lets say a hit comes at 72th second
Then we will mark
hitCount[72] = 1;
hitTimeStamp[72] = 72;

Now when a getHits() request is hit, then we calculate the count
by looping through the 300 entries and
if(now - hitTimeStamp[i] <= 300)
{
  count += hitCount[i];
}

How this helps?
The time is always circular (old entries are discarded)

Lets assume a hit comes at 372th second
Then we will first calculate the circular timeIndex
= 372 % 300 = 72
so
hitCount[72] = 1; // reset the count

but hitTimeStamp will change from 72 to 372
hitTimeStamp[72] = 72; Discard this and the new value would be
hitTimeStamp[72] = 372;

This is done so that if there are old entries, those will not be involved in
counting total hits in the last 300 seconds

Advantages
Data size is fixed, no memory issues
Fast, O(1) lookup and hit complexity
Not storing every entry, just incrementing hitCounts for a particular second

Problems
It's not thread safe, multiple threads can affect hitTimeStamp and hitCount array

-----------------------------------------------------------------------
4. Thread safe - basic version
Use Synchronized function for getHits() and hit() so that they become thread safe

Advantages
All advantages of optimized hit counter
Thread safe

Disadvantages
Locks the entire method
Not scalable
Blocks threads which are trying to invoke the hit() method at different seconds
(lets say that the method is locked by thread which called hit() at 100th second,
now it blocks the 101th second thread as well)
Thread will pile up request and they all will wait for previous thread to complete
the execution

-----------------------------------------------------------------------
5.Thread Safe Granular locking
Use AtomicInteger[] for HitTimeStamps and HitCounts[]
Use ReentrantLock[] locks = new ReentrantLocks[300] // Each second level lock
When doing hit()
While performing the updates on AtomicInteger, lock the current second

try{
    locks[circularCurrentTime].lock() // lock the 100th second
}
finally{
    locks[circularCurrentTime].unlock() // unlock the 100th second lock
}

During the getHits(), Since the hitCounts is an atomic array

a simple count += hitCounts[i].get();

Can do the job fine as AtomicInteger supports single variable concurrent operations.
So no lock is required.


