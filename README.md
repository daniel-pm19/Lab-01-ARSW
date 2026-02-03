
# Laboratory 1 - Arquitectura de Software 2026-1

## Members
- **Daniel Patiño Mejia** - [github.com/daniel-pm19](https://github.com/daniel-pm19)
- **Nestor Isidro Lopez Guzman** - [github.com/nestorlop](https://github.com/nestorlop)

## Objective

This lab aims to provide practical experience in the topics covered in the lectures, including concurrency, threads, and best practices in Java. Students will implement solutions involving blacklist validation, concurrent processing, and multithreaded mathematical calculations.

## Laboratory Content

- **HostBlackListsValidator**: IP address validator against blacklists with multithreaded processing.

- **CountThread/CountThreadsMain**: Example of using threads for concurrent counting.

- **HostBlacklistsDataSourceFacade**: Facade for accessing blacklist data sources.

- **PiCalcTest**: Unit tests to validate system functionality.

## Part 1 - Introduction to threads in java

Based on what you've read, complete the CountThread classes so that they define the lifecycle of a thread that prints the numbers between A and B to the screen.

![alt text](/img/pt1.png)

1. As we can see in the image we insert two digits as a range and it start printing all the numbers between them, a curious thing is that we put at the final of the code a print that says "All threads have finished" but is the first one to be printed, it happens because the main is also a thread and it proccess first the message than printing the numbers.

2. Complete the `main` method of the `CountMainThreads` class so that it:

 - Creates three threads of type `CountThread`, assigning the range [0..99] to the first, [99..199] to the second, and [200..299] to the third.
 - Starts all three threads with `start()`.
 - Runs the method and displays the output.
   - What happened was that the numbers started printing out of order. This is because all three threads were working at the same time, so any of them waited for another to finish as it would if it were sequential; since it wasn't sequential, they printed out of order.

   ![alt text](/img/pt12.png)

 - Change the `start()` method to `run()`. How does the output change? Why?

   - What happened is that all the numbers started printing sequentially and in order up to the final text we discussed earlier. This is because we're not calling any function that creates threads and executes the run method; instead, we're calling a method of the class that only executes the main` thread, so it will run in the order we specified.

   ![alt text](/img/pt123.png)


## Part 2 - Black List Search Excersise

A component is being developed for automated computer security monitoring software that validates IP addresses against several thousand known blacklists (of malicious hosts), and reports those that exist on at least five of these lists.


For this part, we designed and implemented a solution to the problem using threads. We created a Thread class to represent the thread's lifecycle. Each thread performs a search across a pre-divided segment, based on the number of threads present. Each thread is responsible for finding occurrences of the IP address against blacklists. If more than five occurrences are found, the IP address is categorized as Thrustworthy; otherwise, it is considered Not Thrustworthy. Once finished, each thread waits for the others to complete before tallying the occurrences and making a decision.


![alt text](/img/1ThreadTest.png)



## Part 3 - Performance Evaluation

Based on the above, implement the following sequence of experiments to validate sparse IP addresses (e.g., 202.24.34.55), recording the execution times (make sure to run them on the same machine):

1. Single thread.

   Compiling:

   ![alt text](/img/1Thread.png)

   Monitor graphic:

   ![alt text](/img/1ThreadMonitor.png)

   Thread Graphic:

   ![alt text](/img/1ThreadGraph.png)

   Del siguiente experimento podemos evidenciar un tiempo muy alto de respuesta, al ser un unico hilo procesando 80,000 listas, es normal que tarde todo ese tiempo en darnos una respuesta.

2. **As many threads as processing cores (have the program determine this using the Runtime API).**

   Compiling:

   ![alt text](/img/12Thread.png)

   Monitor graphic:

   ![alt text](/img/12ThreadMonitor.png)

   Thread Graphic:

   ![alt text](/img/12ThreadGraph.png)

   Our JVM has 12 cores; using them, we can see an improvement over the previous experiment. By having more threads, tasks can be segmented into smaller ranges, speeding up the program's response.

3. As many threads as twice the number of processing cores.

   Compiling:

   ![alt text](/img/24Thread.png)

   Monitor graphic:

   ![alt text](/img/24ThreadMonitor.png)

   Thread Graphic:

   ![alt text](/img/24ThreadGraph.png)

   Here we can see that the time improved by double what it had with 12 threads, from which we can conclude that the more threads, the lower the response time.

4. 50 threads.

   Compiling:

   ![alt text](/img/50Thread.png)

   Monitor graphic:

   ![alt text](/img/50ThreadMonitor.png)

   Thread Graphic:

   ![alt text](/img/50ThreadGraph.png)

   For 50 threads the program responds much faster; something that happened to us was that the program responded so fast that the monitoring and graphs didn't detect it.

5. 100 threads.

   Compiling:

   ![alt text](/img/100Thread.png)

   Monitor graphic:

   ![alt text](/img/100ThreadMonitor.png)

   Thread Graphic:

   ![alt text](/img/100ThreadGraph.png)

   Finally, with 100 threads, the response time continues to improve steadily, as can be seen; it has better times than the others. For this specific one, it needs to be monitored a little more so that the respective graphs can appear. In all tests, a 10-second delay was expected so that the start would be equitable and the times more realistic.




**Graph of solution time vs. number of threads.**


## Part 4 – Quality Analysis (QA)

According to Amdahl’s Law, the theoretical speedup of a parallel algorithm depends on the
parallelizable fraction of the code and the number of threads used. In theory, increasing the
number of threads should improve performance, but in practice this improvement has clear limits.

---

### Why isn’t the best performance achieved with 500 threads?

Although Amdahl’s Law suggests that performance increases with more threads, the best
performance is not achieved with 500 threads because the execution environment only has
12 processing cores.

When the number of threads greatly exceeds the number of available cores, the system suffers
from significant overhead caused by:

- Thread scheduling
- Context switching
- Synchronization costs
- Contention for shared resources

As observed in the experiment, most of the 500 threads are not executed in parallel but spend
their time waiting for CPU resources, which outweighs the benefits of parallelism.

---

### How does this performance compare when using 200 threads?

Using 200 threads shows a behavior very similar to the 500-thread case. Even though the
number of threads is lower, it is still far greater than the number of available cores.

As a result:

- The CPU remains oversubscribed
- Context-switching overhead remains high
- No significant performance improvement is observed

Compared to 500 threads, 200 threads slightly reduce overhead, but performance is still very
similar or worse than when using a number of threads closer to the number of cores.

---

### How does the solution behave when using as many threads as cores versus twice as many?

When using 12 threads, matching the number of processing cores, the solution achieves
near-optimal performance:

- Each thread can be mapped to a dedicated core
- Minimal context switching
- Efficient use of parallelism

When using twice as many threads (24 threads), performance does not improve and may even
slightly degrade because:

- Threads compete for the same cores
- Context-switching overhead increases
- The parallelizable portion of the algorithm is already fully utilized

---

### Distributed execution and Amdahl’s Law

If instead of running 100 threads on a single CPU, one thread were executed on each of
100 hypothetical machines, Amdahl’s Law would apply more effectively because:

- Each thread would have dedicated processing resources
- CPU contention would be eliminated
- Context-switching overhead would be minimal

However, if c threads were executed on each of 100/c distributed machines, performance would only improve if communication and
synchronization costs between machines remain low.

In distributed environments, network latency and coordination overhead increase the
non-parallelizable fraction of the algorithm, limiting the achievable speedup.


## Prerequisites

- **Java 8 +**
- **Maven 3.6 +**

##

## Instalation

1. Clone the repository:
   ```bash
   git clone https://github.com/daniel-pm19/Lab-01-ARSW
   ```
2. Navigate to the directory
   ```bash
   cd Lab-01-ARSW
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```

## Execution

To compile and execute the project:

```bash
mvn compile
```

## Testing

To execute the unit tests:

```bash
mvn test
```

## Build in

* **Java 8+** - Programming language.
* **Maven** - Dependecy management and projects building.
* **JUnit** - Framework for unit test.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for more details.