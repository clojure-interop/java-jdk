# Bindings for java.util.concurrent

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.util.concurrent "1.0.2"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- class **java.util.concurrent.AbstractExecutorService**
- class **java.util.concurrent.ArrayBlockingQueue**
- interface **java.util.concurrent.BlockingDeque**
- interface **java.util.concurrent.BlockingQueue**
- class **java.util.concurrent.BrokenBarrierException**
- interface **java.util.concurrent.Callable**
- class **java.util.concurrent.CancellationException**
- interface **java.util.concurrent.CompletableFuture$AsynchronousCompletionTask**
- class **java.util.concurrent.CompletableFuture**
- class **java.util.concurrent.CompletionException**
- interface **java.util.concurrent.CompletionService**
- interface **java.util.concurrent.CompletionStage**
- class **java.util.concurrent.ConcurrentHashMap$KeySetView**
- class **java.util.concurrent.ConcurrentHashMap**
- class **java.util.concurrent.ConcurrentLinkedDeque**
- class **java.util.concurrent.ConcurrentLinkedQueue**
- interface **java.util.concurrent.ConcurrentMap**
- interface **java.util.concurrent.ConcurrentNavigableMap**
- class **java.util.concurrent.ConcurrentSkipListMap**
- class **java.util.concurrent.ConcurrentSkipListSet**
- class **java.util.concurrent.CopyOnWriteArrayList**
- class **java.util.concurrent.CopyOnWriteArraySet**
- class **java.util.concurrent.CountDownLatch**
- class **java.util.concurrent.CountedCompleter**
- class **java.util.concurrent.CyclicBarrier**
- class **java.util.concurrent.DelayQueue**
- interface **java.util.concurrent.Delayed**
- class **java.util.concurrent.Exchanger**
- class **java.util.concurrent.ExecutionException**
- interface **java.util.concurrent.Executor**
- class **java.util.concurrent.ExecutorCompletionService**
- interface **java.util.concurrent.ExecutorService**
- class **java.util.concurrent.Executors**
- interface **java.util.concurrent.ForkJoinPool$ForkJoinWorkerThreadFactory**
- interface **java.util.concurrent.ForkJoinPool$ManagedBlocker**
- class **java.util.concurrent.ForkJoinPool**
- class **java.util.concurrent.ForkJoinTask**
- class **java.util.concurrent.ForkJoinWorkerThread**
- interface **java.util.concurrent.Future**
- class **java.util.concurrent.FutureTask**
- class **java.util.concurrent.LinkedBlockingDeque**
- class **java.util.concurrent.LinkedBlockingQueue**
- class **java.util.concurrent.LinkedTransferQueue**
- class **java.util.concurrent.Phaser**
- class **java.util.concurrent.PriorityBlockingQueue**
- class **java.util.concurrent.RecursiveAction**
- class **java.util.concurrent.RecursiveTask**
- class **java.util.concurrent.RejectedExecutionException**
- interface **java.util.concurrent.RejectedExecutionHandler**
- interface **java.util.concurrent.RunnableFuture**
- interface **java.util.concurrent.RunnableScheduledFuture**
- interface **java.util.concurrent.ScheduledExecutorService**
- interface **java.util.concurrent.ScheduledFuture**
- class **java.util.concurrent.ScheduledThreadPoolExecutor**
- class **java.util.concurrent.Semaphore**
- class **java.util.concurrent.SynchronousQueue**
- interface **java.util.concurrent.ThreadFactory**
- class **java.util.concurrent.ThreadLocalRandom**
- class **java.util.concurrent.ThreadPoolExecutor$AbortPolicy**
- class **java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy**
- class **java.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy**
- class **java.util.concurrent.ThreadPoolExecutor$DiscardPolicy**
- class **java.util.concurrent.ThreadPoolExecutor**
- enum **java.util.concurrent.TimeUnit**
- class **java.util.concurrent.TimeoutException**
- interface **java.util.concurrent.TransferQueue**
- class **java.util.concurrent.atomic.AtomicBoolean**
- class **java.util.concurrent.atomic.AtomicInteger**
- class **java.util.concurrent.atomic.AtomicIntegerArray**
- class **java.util.concurrent.atomic.AtomicIntegerFieldUpdater**
- class **java.util.concurrent.atomic.AtomicLong**
- class **java.util.concurrent.atomic.AtomicLongArray**
- class **java.util.concurrent.atomic.AtomicLongFieldUpdater**
- class **java.util.concurrent.atomic.AtomicMarkableReference**
- class **java.util.concurrent.atomic.AtomicReference**
- class **java.util.concurrent.atomic.AtomicReferenceArray**
- class **java.util.concurrent.atomic.AtomicReferenceFieldUpdater**
- class **java.util.concurrent.atomic.AtomicStampedReference**
- class **java.util.concurrent.atomic.DoubleAccumulator**
- class **java.util.concurrent.atomic.DoubleAdder**
- class **java.util.concurrent.atomic.LongAccumulator**
- class **java.util.concurrent.atomic.LongAdder**
- class **java.util.concurrent.locks.AbstractOwnableSynchronizer**
- class **java.util.concurrent.locks.AbstractQueuedLongSynchronizer**
- class **java.util.concurrent.locks.AbstractQueuedSynchronizer**
- interface **java.util.concurrent.locks.Condition**
- interface **java.util.concurrent.locks.Lock**
- class **java.util.concurrent.locks.LockSupport**
- interface **java.util.concurrent.locks.ReadWriteLock**
- class **java.util.concurrent.locks.ReentrantLock**
- class **java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock**
- class **java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock**
- class **java.util.concurrent.locks.ReentrantReadWriteLock**
- class **java.util.concurrent.locks.StampedLock**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
