
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


## Part 4 - QA

According to Amdahls' Law:

where S(n) is the theoretical performance improvement, P is the parallelizable fraction of the algorithm, and n is the number of threads. The larger n is, the greater the improvement should be.

- Why isn't the best performance achieved with 500 threads? 

- How does this performance compare when using 200 threads?

- How does the solution behave using as many processing threads as cores compared to the result of using twice as many?

Based on the above, if for this problem, instead of 100 threads on a single CPU, one thread could be used on each of 100 hypothetical machines, would Amdahls' Law apply better? If, instead, c threads were used on 100/c distributed machines (where c is the number of cores on these machines), would the performance improve? Explain your answer.


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

Para compilar y ejecutar el proyecto:

```bash
mvn compile
```

## Pruebas

Ejecutar las pruebas unitarias:

```bash
mvn test
```

## Build in

* **Java 8+** - Programming language.
* **Maven** - Dependecy management and projects building.
* **JUnit** - Framework for unit test.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for more details.