URL Shortener

Requirement
Given a long URL, Convert it to a short url

Expected behavior of the service
Uniqueness → every long URL maps to a unique short one
No collisions (or extremely controlled)
Short length (5–8 chars)
Fast lookup (O(1))
Deterministic or controllable behavior

What are the possible options
1. Generating random string for short urls
Like "ksndjsd" for a big url
Limitations :
- The collision chances are very high (as same random string might be generated if the limit
if fixed, (6 characters))
- We need to implement collision handling
- Not scalable

2. Hashing the long url into a short string
Examples - MD5, SHA-256
Limitations
- Too big output - MD5 hash generates 128 bits = 32 hex character string like
https://google.com → 5d41402abc4b2a76b9719d911017c592
- Shortening the hash - If we take the first 6 characters of the hash output, there are
chances of collision and it will need handling

3. So, because of the above issues we will use encoding

What is encoding
Encoding is the process of converting a number to a different number
Like converting decimal to base2 encoding, decimal to base16, decimal to base64

What do we need to encode?
This problem is more of designing a distributed id generator
1. First someone gives a long url
2. Then we create an ID corresponding to that entry using the distributed ID generator (like zookeeper or SnowFlake)
3. Then we encode the ID, the BASE_URL + encoded ID will act as a short URL
4. For example - Id = 293203, Lets assume encoded Id = fyt2, then the short URL
would be - https://bit.ly/fyt2
5. Now If the short url is passed to the service, we will parse the encoded ID from it
and then find the long URL corresponding to that entry.

Like in DB

EncodedID(shortUrl)      LongURL
fyt2                     https://google.com/search?q=system+design


Which encoding to choose

1. Base2 Encoding - Because only two digit representation of ID's (0, 1)
The tiny url will become very long and it will require trimming which again leads
to collision
2. Base10 Encoding - Similar issues as Base2
3. Base16 Encoding - Similar issues as Base2

So we use Base62 encoding
Why - Because base 62 has the character set which we want to use for the short url
like
"0123456789" - Digits '0' - '9'
"ABCDEFGHIJKLMNOPQRSTUVWXYZ" - Characters 'A' - 'Z'
"abcdefghijklmnopqrstuvwxyz" - Characters 'a' - 'z'

Total characters = 62
That's why its called Base62 Encoding

How encoding works
Lets assume an ID = 125 has come
Num = 125

125/62 -> Remainder = 1, Divisor = 2
Num becomes the divisor
2/62 -> Remainder = 2, Divisor = 0

The encoded value is reverse of the Remainder string concatenated
so 125 -> (21) Base62

Assume if the remainder was anywhere between 10-62, characters will take over then

this is the order
CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

Lets assume an ID = 165 has come
Num = 165

165/62 -> Remainder = 41, Divisor = 2
Num becomes the divisor
2/62 -> Remainder = 2, Divisor = 0

So the Encoded number = ("2" + "41") = 2f (41th index char in the string CHARS)

Why not Base64
Because Base64 encoding has elements which are not allowed in urls
0–25   → A–Z
26–51  → a–z
52–61  → 0–9
62     → +
63     → /

- The "+", "/" are not allowed for urls as they have entirely different meanings
in terms of http urls
- Works on bytes, not integers
- Adds unnecessary complexity

