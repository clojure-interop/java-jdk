# Bindings for java.util

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.util "1.0.5"]
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

- class **java.util.AbstractCollection**
- class **java.util.AbstractList**
- class **java.util.AbstractMap$SimpleEntry**
- class **java.util.AbstractMap$SimpleImmutableEntry**
- class **java.util.AbstractMap**
- class **java.util.AbstractQueue**
- class **java.util.AbstractSequentialList**
- class **java.util.AbstractSet**
- class **java.util.ArrayDeque**
- class **java.util.ArrayList**
- class **java.util.Arrays**
- class **java.util.Base64$Decoder**
- class **java.util.Base64$Encoder**
- class **java.util.Base64**
- class **java.util.BitSet**
- class **java.util.Calendar$Builder**
- class **java.util.Calendar**
- interface **java.util.Collection**
- class **java.util.Collections**
- interface **java.util.Comparator**
- class **java.util.ConcurrentModificationException**
- class **java.util.Currency**
- class **java.util.Date**
- interface **java.util.Deque**
- class **java.util.Dictionary**
- class **java.util.DoubleSummaryStatistics**
- class **java.util.DuplicateFormatFlagsException**
- class **java.util.EmptyStackException**
- class **java.util.EnumMap**
- class **java.util.EnumSet**
- interface **java.util.Enumeration**
- interface **java.util.EventListener**
- class **java.util.EventListenerProxy**
- class **java.util.EventObject**
- class **java.util.FormatFlagsConversionMismatchException**
- interface **java.util.Formattable**
- class **java.util.FormattableFlags**
- enum **java.util.Formatter$BigDecimalLayoutForm**
- class **java.util.Formatter**
- class **java.util.FormatterClosedException**
- class **java.util.GregorianCalendar**
- class **java.util.HashMap**
- class **java.util.HashSet**
- class **java.util.Hashtable**
- class **java.util.IdentityHashMap**
- class **java.util.IllegalFormatCodePointException**
- class **java.util.IllegalFormatConversionException**
- class **java.util.IllegalFormatException**
- class **java.util.IllegalFormatFlagsException**
- class **java.util.IllegalFormatPrecisionException**
- class **java.util.IllegalFormatWidthException**
- class **java.util.IllformedLocaleException**
- class **java.util.InputMismatchException**
- class **java.util.IntSummaryStatistics**
- class **java.util.InvalidPropertiesFormatException**
- interface **java.util.Iterator**
- class **java.util.LinkedHashMap**
- class **java.util.LinkedHashSet**
- class **java.util.LinkedList**
- interface **java.util.List**
- interface **java.util.ListIterator**
- class **java.util.ListResourceBundle**
- class **java.util.Locale$Builder**
- enum **java.util.Locale$Category**
- enum **java.util.Locale$FilteringMode**
- class **java.util.Locale$LanguageRange**
- class **java.util.Locale**
- class **java.util.LongSummaryStatistics**
- interface **java.util.Map$Entry**
- interface **java.util.Map**
- class **java.util.MissingFormatArgumentException**
- class **java.util.MissingFormatWidthException**
- class **java.util.MissingResourceException**
- interface **java.util.NavigableMap**
- interface **java.util.NavigableSet**
- class **java.util.NoSuchElementException**
- class **java.util.Objects**
- class **java.util.Observable**
- interface **java.util.Observer**
- class **java.util.Optional**
- class **java.util.OptionalDouble**
- class **java.util.OptionalInt**
- class **java.util.OptionalLong**
- interface **java.util.PrimitiveIterator$OfDouble**
- interface **java.util.PrimitiveIterator$OfInt**
- interface **java.util.PrimitiveIterator$OfLong**
- interface **java.util.PrimitiveIterator**
- class **java.util.PriorityQueue**
- class **java.util.Properties**
- class **java.util.PropertyPermission**
- class **java.util.PropertyResourceBundle**
- interface **java.util.Queue**
- class **java.util.Random**
- interface **java.util.RandomAccess**
- class **java.util.ResourceBundle$Control**
- class **java.util.ResourceBundle**
- class **java.util.Scanner**
- class **java.util.ServiceConfigurationError**
- class **java.util.ServiceLoader**
- interface **java.util.Set**
- class **java.util.SimpleTimeZone**
- interface **java.util.SortedMap**
- interface **java.util.SortedSet**
- interface **java.util.Spliterator$OfDouble**
- interface **java.util.Spliterator$OfInt**
- interface **java.util.Spliterator$OfLong**
- interface **java.util.Spliterator$OfPrimitive**
- interface **java.util.Spliterator**
- class **java.util.Spliterators$AbstractDoubleSpliterator**
- class **java.util.Spliterators$AbstractIntSpliterator**
- class **java.util.Spliterators$AbstractLongSpliterator**
- class **java.util.Spliterators$AbstractSpliterator**
- class **java.util.Spliterators**
- class **java.util.SplittableRandom**
- class **java.util.Stack**
- class **java.util.StringJoiner**
- class **java.util.StringTokenizer**
- class **java.util.TimeZone**
- class **java.util.Timer**
- class **java.util.TimerTask**
- class **java.util.TooManyListenersException**
- class **java.util.TreeMap**
- class **java.util.TreeSet**
- class **java.util.UUID**
- class **java.util.UnknownFormatConversionException**
- class **java.util.UnknownFormatFlagsException**
- class **java.util.Vector**
- class **java.util.WeakHashMap**
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
- interface **java.util.function.BiConsumer**
- interface **java.util.function.BiFunction**
- interface **java.util.function.BiPredicate**
- interface **java.util.function.BinaryOperator**
- interface **java.util.function.BooleanSupplier**
- interface **java.util.function.Consumer**
- interface **java.util.function.DoubleBinaryOperator**
- interface **java.util.function.DoubleConsumer**
- interface **java.util.function.DoubleFunction**
- interface **java.util.function.DoublePredicate**
- interface **java.util.function.DoubleSupplier**
- interface **java.util.function.DoubleToIntFunction**
- interface **java.util.function.DoubleToLongFunction**
- interface **java.util.function.DoubleUnaryOperator**
- interface **java.util.function.Function**
- interface **java.util.function.IntBinaryOperator**
- interface **java.util.function.IntConsumer**
- interface **java.util.function.IntFunction**
- interface **java.util.function.IntPredicate**
- interface **java.util.function.IntSupplier**
- interface **java.util.function.IntToDoubleFunction**
- interface **java.util.function.IntToLongFunction**
- interface **java.util.function.IntUnaryOperator**
- interface **java.util.function.LongBinaryOperator**
- interface **java.util.function.LongConsumer**
- interface **java.util.function.LongFunction**
- interface **java.util.function.LongPredicate**
- interface **java.util.function.LongSupplier**
- interface **java.util.function.LongToDoubleFunction**
- interface **java.util.function.LongToIntFunction**
- interface **java.util.function.LongUnaryOperator**
- interface **java.util.function.ObjDoubleConsumer**
- interface **java.util.function.ObjIntConsumer**
- interface **java.util.function.ObjLongConsumer**
- interface **java.util.function.Predicate**
- interface **java.util.function.Supplier**
- interface **java.util.function.ToDoubleBiFunction**
- interface **java.util.function.ToDoubleFunction**
- interface **java.util.function.ToIntBiFunction**
- interface **java.util.function.ToIntFunction**
- interface **java.util.function.ToLongBiFunction**
- interface **java.util.function.ToLongFunction**
- interface **java.util.function.UnaryOperator**
- class **java.util.jar.Attributes$Name**
- class **java.util.jar.Attributes**
- class **java.util.jar.JarEntry**
- class **java.util.jar.JarException**
- class **java.util.jar.JarFile**
- class **java.util.jar.JarInputStream**
- class **java.util.jar.JarOutputStream**
- class **java.util.jar.Manifest**
- interface **java.util.jar.Pack200$Packer**
- interface **java.util.jar.Pack200$Unpacker**
- class **java.util.jar.Pack200**
- class **java.util.logging.ConsoleHandler**
- class **java.util.logging.ErrorManager**
- class **java.util.logging.FileHandler**
- interface **java.util.logging.Filter**
- class **java.util.logging.Formatter**
- class **java.util.logging.Handler**
- class **java.util.logging.Level**
- class **java.util.logging.LogManager**
- class **java.util.logging.LogRecord**
- class **java.util.logging.Logger**
- interface **java.util.logging.LoggingMXBean**
- class **java.util.logging.LoggingPermission**
- class **java.util.logging.MemoryHandler**
- class **java.util.logging.SimpleFormatter**
- class **java.util.logging.SocketHandler**
- class **java.util.logging.StreamHandler**
- class **java.util.logging.XMLFormatter**
- class **java.util.prefs.AbstractPreferences**
- class **java.util.prefs.BackingStoreException**
- class **java.util.prefs.InvalidPreferencesFormatException**
- class **java.util.prefs.NodeChangeEvent**
- interface **java.util.prefs.NodeChangeListener**
- class **java.util.prefs.PreferenceChangeEvent**
- interface **java.util.prefs.PreferenceChangeListener**
- class **java.util.prefs.Preferences**
- interface **java.util.prefs.PreferencesFactory**
- interface **java.util.regex.MatchResult**
- class **java.util.regex.Matcher**
- class **java.util.regex.Pattern**
- class **java.util.regex.PatternSyntaxException**
- class **java.util.spi.CalendarDataProvider**
- class **java.util.spi.CalendarNameProvider**
- class **java.util.spi.CurrencyNameProvider**
- class **java.util.spi.LocaleNameProvider**
- class **java.util.spi.LocaleServiceProvider**
- interface **java.util.spi.ResourceBundleControlProvider**
- class **java.util.spi.TimeZoneNameProvider**
- interface **java.util.stream.BaseStream**
- enum **java.util.stream.Collector$Characteristics**
- interface **java.util.stream.Collector**
- class **java.util.stream.Collectors**
- interface **java.util.stream.DoubleStream$Builder**
- interface **java.util.stream.DoubleStream**
- interface **java.util.stream.IntStream$Builder**
- interface **java.util.stream.IntStream**
- interface **java.util.stream.LongStream$Builder**
- interface **java.util.stream.LongStream**
- interface **java.util.stream.Stream$Builder**
- interface **java.util.stream.Stream**
- class **java.util.stream.StreamSupport**
- class **java.util.zip.Adler32**
- class **java.util.zip.CRC32**
- class **java.util.zip.CheckedInputStream**
- class **java.util.zip.CheckedOutputStream**
- interface **java.util.zip.Checksum**
- class **java.util.zip.DataFormatException**
- class **java.util.zip.Deflater**
- class **java.util.zip.DeflaterInputStream**
- class **java.util.zip.DeflaterOutputStream**
- class **java.util.zip.GZIPInputStream**
- class **java.util.zip.GZIPOutputStream**
- class **java.util.zip.Inflater**
- class **java.util.zip.InflaterInputStream**
- class **java.util.zip.InflaterOutputStream**
- class **java.util.zip.ZipEntry**
- class **java.util.zip.ZipError**
- class **java.util.zip.ZipException**
- class **java.util.zip.ZipFile**
- class **java.util.zip.ZipInputStream**
- class **java.util.zip.ZipOutputStream**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
