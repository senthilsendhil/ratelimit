# sliding-window-counter
Sliding window counter implementation based on In memory Storage

Please Test the Application with Client.Java main method in Client_test Folder

1) The Test Client having Situmulated Task Consists of Clinet and User

2) All the user belong to one client, and RateLimiter having option of 
configuring client and user level rate limit

For Sample I have configured Each User can perform 100 Request Per 60 sec (1 Minute)
and I have mimic the 5 user request

# Sample Output

user 3 : total request count : 0 <Br>
user 3 : request number : 1 allowed<Br>
user 4 : total request count : 0<Br>
user 4 : request number : 1 allowed<Br>
user 2 : total request count : 0<Br>
user 2 : request number : 1 allowed<Br>
user 3 : total request count : 1<Br>
user 3 : request number : 2 allowed<Br>
..<Br>
..<Br>
.<Br>
..<Br>
...<Br>

user 2 : request number : 81 allowed <Br>
user 2 : total request count : 81 <Br>
user 2 : request number : 82 allowed <Br>
user 2 : total request count : 82 <Br>
user 2 : request number : 83 allowed <Br>
user 4 : total request count : 82 <Br>
user 4 : request number : 83 allowed <Br>
user 2 : total request count : 83 <Br>
user 3 : total request count : 86 <Br>
user 2 : request number : 84 allowed <Br>

..<Br>
..<Br>
.<Br>
..<Br>
...<Br>

user 1 : total request count : 90 <br>
user 1 : request number : 91 allowed<br>
user 1 : total request count : 91<br>
user 1 : request number : 92 allowed<br>
user 2 : total request count : 100<br>
user 4 : total request count : 88<br>
user 4 : request number : 89 allowed<br>
user 4 : total request count : 89<br>
user 4 : request number : 90 allowed<br>
user 1 : total request count : 92<br>
user 1 : request number : 93 allowed<br>
user 4 : total request count : 90<br>
user 2 : request got rejected<br>
user 4 : request number : 91 allowed<br>
# User one counter adjusted after the window time
**_`user 1 : total request count : 62<br>`_**  



