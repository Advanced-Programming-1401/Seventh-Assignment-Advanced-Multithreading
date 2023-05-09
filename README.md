1. For the first problem (PI calculator) I used a formula found by mathematician Breeler in 1972. For further readings you can checkout [this link](https://www.quora.com/How-can-we-calculate-with-pi-if-we-don%E2%80%99t-know-the-exact-value-of-pi)

2. For the second problem I created a CountDownLatch for each colorThreads with number of each Thread, so that it counts each of thread executions and then executed the threads.

3. For the third problem, I first created a Semaphore that premits 2 threads to access the critical section at the same time. Then added this semaphore to Operator class and then aquired it every time i needed to use it and then release it. 

