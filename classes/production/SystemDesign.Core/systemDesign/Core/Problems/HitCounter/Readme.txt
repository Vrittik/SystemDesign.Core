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

