Median in Stream
--------------------------------------------------

Idea is simple — split numbers into two halves.

1 2      |      3 4
Left side → smaller numbers (max heap, max element at the start (2 here)
Right side → larger numbers (min heap, min element at the start (3 here)

So median will always lie around the boundary of these two heaps.

Approach:

left size is always <= right size

Whenever a new number comes:

Add it to left heap first
If left becomes bigger than right → move top of left to right

If ordering breaks (left.peek() > right.peek()) → swap tops

for example

leftHalf                               rightHalf
1 4(added in left first)               2 3

then swap the first element of both

leftHalf                               rightHalf
1 2                                    3 4

Invariants:

right size is always >= left size
difference between sizes is at most 1
max(left) <= min(right)

Median:

if right has more elements → median = right.peek()
if equal size → median = avg(left.peek(), right.peek())

Time Complexity:

add → log n
get median → O(1)
