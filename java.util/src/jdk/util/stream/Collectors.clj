(ns jdk.util.stream.Collectors
  "Implementations of Collector that implement various useful reduction
  operations, such as accumulating elements into collections, summarizing
  elements according to various criteria, etc.

  The following are examples of using the predefined collectors to perform
  common mutable reduction tasks:



      // Accumulate names into a List
      List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

      // Accumulate names into a TreeSet
      Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

      // Convert elements to strings and concatenate them, separated by commas
      String joined = things.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(`, `));

      // Compute sum of salaries of employee
      int total = employees.stream()
                           .collect(Collectors.summingInt(Employee::getSalary)));

      // Group employees by department
      Map<Department, List<Employee>> byDept
          = employees.stream()
                     .collect(Collectors.groupingBy(Employee::getDepartment));

      // Compute sum of salaries by department
      Map<Department, Integer> totalByDept
          = employees.stream()
                     .collect(Collectors.groupingBy(Employee::getDepartment,
                                                    Collectors.summingInt(Employee::getSalary)));

      // Partition students into passing and failing
      Map<Boolean, List<Student>> passingFailing =
          students.stream()
                  .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream Collectors]))

(defn *to-concurrent-map
  "Returns a concurrent Collector that accumulates elements into a
   ConcurrentMap whose keys and values are the result of applying
   the provided mapping functions to the input elements.

   If the mapped keys contains duplicates (according to Object.equals(Object)),
   the value mapping function is applied to each equal element, and the
   results are merged using the provided merging function.  The
   ConcurrentMap is created by a provided supplier function.

   This is a concurrent and
   unordered Collector.

  key-mapper - a mapping function to produce keys - `java.util.function.Function`
  value-mapper - a mapping function to produce values - `java.util.function.Function`
  merge-function - a merge function, used to resolve collisions between values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction) - `java.util.function.BinaryOperator`
  map-supplier - a function which returns a new, empty Map into which the results will be inserted - `java.util.function.Supplier`

  returns: a concurrent, unordered Collector which collects elements into a
   ConcurrentMap whose keys are the result of applying a key mapping
   function to the input elements, and whose values are the result of
   applying a value mapping function to all input elements equal to the key
   and combining them using the merge function - `<T,K,U,M extends java.util.concurrent.ConcurrentMap<K,U>> java.util.stream.Collector<T,?,M>`"
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper ^java.util.function.BinaryOperator merge-function ^java.util.function.Supplier map-supplier]
    (Collectors/toConcurrentMap key-mapper value-mapper merge-function map-supplier))
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper ^java.util.function.BinaryOperator merge-function]
    (Collectors/toConcurrentMap key-mapper value-mapper merge-function))
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper]
    (Collectors/toConcurrentMap key-mapper value-mapper)))

(defn *averaging-double
  "Returns a Collector that produces the arithmetic mean of a double-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

   The average returned can vary depending upon the order in which
   values are recorded, due to accumulated rounding error in
   addition of values of differing magnitudes. Values sorted by increasing
   absolute magnitude tend to yield more accurate results.  If any recorded
   value is a NaN or the sum is at any point a NaN then the
   average will be NaN.

  mapper - a function extracting the property to be summed - `java.util.function.ToDoubleFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Double>`"
  ([^java.util.function.ToDoubleFunction mapper]
    (Collectors/averagingDouble mapper)))

(defn *averaging-long
  "Returns a Collector that produces the arithmetic mean of a long-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

  mapper - a function extracting the property to be summed - `java.util.function.ToLongFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Double>`"
  ([^java.util.function.ToLongFunction mapper]
    (Collectors/averagingLong mapper)))

(defn *summing-double
  "Returns a Collector that produces the sum of a double-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

   The sum returned can vary depending upon the order in which
   values are recorded, due to accumulated rounding error in
   addition of values of differing magnitudes. Values sorted by increasing
   absolute magnitude tend to yield more accurate results.  If any recorded
   value is a NaN or the sum is at any point a NaN then the
   sum will be NaN.

  mapper - a function extracting the property to be summed - `java.util.function.ToDoubleFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Double>`"
  ([^java.util.function.ToDoubleFunction mapper]
    (Collectors/summingDouble mapper)))

(defn *summing-long
  "Returns a Collector that produces the sum of a long-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

  mapper - a function extracting the property to be summed - `java.util.function.ToLongFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Long>`"
  ([^java.util.function.ToLongFunction mapper]
    (Collectors/summingLong mapper)))

(defn *joining
  "Returns a Collector that concatenates the input elements,
   separated by the specified delimiter, with the specified prefix and
   suffix, in encounter order.

  delimiter - the delimiter to be used between each element - `java.lang.CharSequence`
  prefix - the sequence of characters to be used at the beginning of the joined result - `java.lang.CharSequence`
  suffix - the sequence of characters to be used at the end of the joined result - `java.lang.CharSequence`

  returns: A Collector which concatenates CharSequence elements,
   separated by the specified delimiter, in encounter order - `java.util.stream.Collector<java.lang.CharSequence,?,java.lang.String>`"
  (^java.util.stream.Collector [^java.lang.CharSequence delimiter ^java.lang.CharSequence prefix ^java.lang.CharSequence suffix]
    (Collectors/joining delimiter prefix suffix))
  (^java.util.stream.Collector [^java.lang.CharSequence delimiter]
    (Collectors/joining delimiter))
  (^java.util.stream.Collector []
    (Collectors/joining )))

(defn *reducing
  "Returns a Collector which performs a reduction of its
   input elements under a specified mapping function and
   BinaryOperator. This is a generalization of
   reducing(Object, BinaryOperator) which allows a transformation
   of the elements before reduction.

  identity - the identity value for the reduction (also, the value that is returned when there are no input elements) - `U`
  mapper - a mapping function to apply to each input value - `java.util.function.Function`
  op - a BinaryOperator<U> used to reduce the mapped values - `java.util.function.BinaryOperator`

  returns: a Collector implementing the map-reduce operation - `<T,U> java.util.stream.Collector<T,?,U>`"
  ([identity ^java.util.function.Function mapper ^java.util.function.BinaryOperator op]
    (Collectors/reducing identity mapper op))
  ([identity ^java.util.function.BinaryOperator op]
    (Collectors/reducing identity op))
  ([^java.util.function.BinaryOperator op]
    (Collectors/reducing op)))

(defn *to-list
  "Returns a Collector that accumulates the input elements into a
   new List. There are no guarantees on the type, mutability,
   serializability, or thread-safety of the List returned; if more
   control over the returned List is required, use toCollection(Supplier).

  returns: a Collector which collects all the input elements into a
   List, in encounter order - `<T> java.util.stream.Collector<T,?,java.util.List<T>>`"
  ([]
    (Collectors/toList )))

(defn *min-by
  "Returns a Collector that produces the minimal element according
   to a given Comparator, described as an Optional<T>.

  comparator - a Comparator for comparing elements - `java.util.Comparator`

  returns: a Collector that produces the minimal value - `<T> java.util.stream.Collector<T,?,java.util.Optional<T>>`"
  ([^java.util.Comparator comparator]
    (Collectors/minBy comparator)))

(defn *summing-int
  "Returns a Collector that produces the sum of a integer-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

  mapper - a function extracting the property to be summed - `java.util.function.ToIntFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Integer>`"
  ([^java.util.function.ToIntFunction mapper]
    (Collectors/summingInt mapper)))

(defn *max-by
  "Returns a Collector that produces the maximal element according
   to a given Comparator, described as an Optional<T>.

  comparator - a Comparator for comparing elements - `java.util.Comparator`

  returns: a Collector that produces the maximal value - `<T> java.util.stream.Collector<T,?,java.util.Optional<T>>`"
  ([^java.util.Comparator comparator]
    (Collectors/maxBy comparator)))

(defn *to-collection
  "Returns a Collector that accumulates the input elements into a
   new Collection, in encounter order.  The Collection is
   created by the provided factory.

  collection-factory - a Supplier which returns a new, empty Collection of the appropriate type - `java.util.function.Supplier`

  returns: a Collector which collects all the input elements into a
   Collection, in encounter order - `<T,C extends java.util.Collection<T>> java.util.stream.Collector<T,?,C>`"
  ([^java.util.function.Supplier collection-factory]
    (Collectors/toCollection collection-factory)))

(defn *to-set
  "Returns a Collector that accumulates the input elements into a
   new Set. There are no guarantees on the type, mutability,
   serializability, or thread-safety of the Set returned; if more
   control over the returned Set is required, use
   toCollection(Supplier).

   This is an unordered
   Collector.

  returns: a Collector which collects all the input elements into a
   Set - `<T> java.util.stream.Collector<T,?,java.util.Set<T>>`"
  ([]
    (Collectors/toSet )))

(defn *grouping-by-concurrent
  "Returns a concurrent Collector implementing a cascaded `group by`
   operation on input elements of type T, grouping elements
   according to a classification function, and then performing a reduction
   operation on the values associated with a given key using the specified
   downstream Collector.  The ConcurrentMap produced by the
   Collector is created with the supplied factory function.

   This is a concurrent and
   unordered Collector.

   The classification function maps elements to some key type K.
   The downstream collector operates on elements of type T and
   produces a result of type D. The resulting collector produces a
   Map<K, D>.

   For example, to compute the set of last names of people in each city,
   where the city names are sorted:


       ConcurrentMap<City, Set<String>> namesByCity
           = people.stream().collect(groupingBy(Person::getCity, ConcurrentSkipListMap::new,
                                                mapping(Person::getLastName, toSet())));

  classifier - a classifier function mapping input elements to keys - `java.util.function.Function`
  map-factory - a function which, when called, produces a new empty ConcurrentMap of the desired type - `java.util.function.Supplier`
  downstream - a Collector implementing the downstream reduction - `java.util.stream.Collector`

  returns: a concurrent, unordered Collector implementing the cascaded group-by operation - `<T,K,A,D,M extends java.util.concurrent.ConcurrentMap<K,D>> java.util.stream.Collector<T,?,M>`"
  ([^java.util.function.Function classifier ^java.util.function.Supplier map-factory ^java.util.stream.Collector downstream]
    (Collectors/groupingByConcurrent classifier map-factory downstream))
  ([^java.util.function.Function classifier ^java.util.stream.Collector downstream]
    (Collectors/groupingByConcurrent classifier downstream))
  ([^java.util.function.Function classifier]
    (Collectors/groupingByConcurrent classifier)))

(defn *to-map
  "Returns a Collector that accumulates elements into a
   Map whose keys and values are the result of applying the provided
   mapping functions to the input elements.

   If the mapped
   keys contains duplicates (according to Object.equals(Object)),
   the value mapping function is applied to each equal element, and the
   results are merged using the provided merging function.  The Map
   is created by a provided supplier function.

  key-mapper - a mapping function to produce keys - `java.util.function.Function`
  value-mapper - a mapping function to produce values - `java.util.function.Function`
  merge-function - a merge function, used to resolve collisions between values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction) - `java.util.function.BinaryOperator`
  map-supplier - a function which returns a new, empty Map into which the results will be inserted - `java.util.function.Supplier`

  returns: a Collector which collects elements into a Map
   whose keys are the result of applying a key mapping function to the input
   elements, and whose values are the result of applying a value mapping
   function to all input elements equal to the key and combining them
   using the merge function - `<T,K,U,M extends java.util.Map<K,U>> java.util.stream.Collector<T,?,M>`"
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper ^java.util.function.BinaryOperator merge-function ^java.util.function.Supplier map-supplier]
    (Collectors/toMap key-mapper value-mapper merge-function map-supplier))
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper ^java.util.function.BinaryOperator merge-function]
    (Collectors/toMap key-mapper value-mapper merge-function))
  ([^java.util.function.Function key-mapper ^java.util.function.Function value-mapper]
    (Collectors/toMap key-mapper value-mapper)))

(defn *averaging-int
  "Returns a Collector that produces the arithmetic mean of an integer-valued
   function applied to the input elements.  If no elements are present,
   the result is 0.

  mapper - a function extracting the property to be summed - `java.util.function.ToIntFunction`

  returns: a Collector that produces the sum of a derived property - `<T> java.util.stream.Collector<T,?,java.lang.Double>`"
  ([^java.util.function.ToIntFunction mapper]
    (Collectors/averagingInt mapper)))

(defn *summarizing-double
  "Returns a Collector which applies an double-producing
   mapping function to each input element, and returns summary statistics
   for the resulting values.

  mapper - a mapping function to apply to each element - `java.util.function.ToDoubleFunction`

  returns: a Collector implementing the summary-statistics reduction - `<T> java.util.stream.Collector<T,?,java.util.DoubleSummaryStatistics>`"
  ([^java.util.function.ToDoubleFunction mapper]
    (Collectors/summarizingDouble mapper)))

(defn *summarizing-int
  "Returns a Collector which applies an int-producing
   mapping function to each input element, and returns summary statistics
   for the resulting values.

  mapper - a mapping function to apply to each element - `java.util.function.ToIntFunction`

  returns: a Collector implementing the summary-statistics reduction - `<T> java.util.stream.Collector<T,?,java.util.IntSummaryStatistics>`"
  ([^java.util.function.ToIntFunction mapper]
    (Collectors/summarizingInt mapper)))

(defn *counting
  "Returns a Collector accepting elements of type T that
   counts the number of input elements.  If no elements are present, the
   result is 0.

  returns: a Collector that counts the input elements - `<T> java.util.stream.Collector<T,?,java.lang.Long>`"
  ([]
    (Collectors/counting )))

(defn *mapping
  "Adapts a Collector accepting elements of type U to one
   accepting elements of type T by applying a mapping function to
   each input element before accumulation.

  mapper - a function to be applied to the input elements - `java.util.function.Function`
  downstream - a collector which will accept mapped values - `java.util.stream.Collector`

  returns: a collector which applies the mapping function to the input
   elements and provides the mapped results to the downstream collector - `<T,U,A,R> java.util.stream.Collector<T,?,R>`"
  ([^java.util.function.Function mapper ^java.util.stream.Collector downstream]
    (Collectors/mapping mapper downstream)))

(defn *collecting-and-then
  "Adapts a Collector to perform an additional finishing
   transformation.  For example, one could adapt the toList()
   collector to always produce an immutable list with:


       List<String> people
           = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));

  downstream - a collector - `java.util.stream.Collector`
  finisher - a function to be applied to the final result of the downstream collector - `java.util.function.Function`

  returns: a collector which performs the action of the downstream collector,
   followed by an additional finishing step - `<T,A,R,RR> java.util.stream.Collector<T,A,RR>`"
  ([^java.util.stream.Collector downstream ^java.util.function.Function finisher]
    (Collectors/collectingAndThen downstream finisher)))

(defn *partitioning-by
  "Returns a Collector which partitions the input elements according
   to a Predicate, reduces the values in each partition according to
   another Collector, and organizes them into a
   Map<Boolean, D> whose values are the result of the downstream
   reduction.

   There are no guarantees on the type, mutability,
   serializability, or thread-safety of the Map returned.

  predicate - a predicate used for classifying input elements - `java.util.function.Predicate`
  downstream - a Collector implementing the downstream reduction - `java.util.stream.Collector`

  returns: a Collector implementing the cascaded partitioning
           operation - `<T,D,A> java.util.stream.Collector<T,?,java.util.Map<java.lang.Boolean,D>>`"
  ([^java.util.function.Predicate predicate ^java.util.stream.Collector downstream]
    (Collectors/partitioningBy predicate downstream))
  ([^java.util.function.Predicate predicate]
    (Collectors/partitioningBy predicate)))

(defn *summarizing-long
  "Returns a Collector which applies an long-producing
   mapping function to each input element, and returns summary statistics
   for the resulting values.

  mapper - the mapping function to apply to each element - `java.util.function.ToLongFunction`

  returns: a Collector implementing the summary-statistics reduction - `<T> java.util.stream.Collector<T,?,java.util.LongSummaryStatistics>`"
  ([^java.util.function.ToLongFunction mapper]
    (Collectors/summarizingLong mapper)))

(defn *grouping-by
  "Returns a Collector implementing a cascaded `group by` operation
   on input elements of type T, grouping elements according to a
   classification function, and then performing a reduction operation on
   the values associated with a given key using the specified downstream
   Collector.  The Map produced by the Collector is created
   with the supplied factory function.

   The classification function maps elements to some key type K.
   The downstream collector operates on elements of type T and
   produces a result of type D. The resulting collector produces a
   Map<K, D>.

   For example, to compute the set of last names of people in each city,
   where the city names are sorted:


       Map<City, Set<String>> namesByCity
           = people.stream().collect(groupingBy(Person::getCity, TreeMap::new,
                                                mapping(Person::getLastName, toSet())));

  classifier - a classifier function mapping input elements to keys - `java.util.function.Function`
  map-factory - a function which, when called, produces a new empty Map of the desired type - `java.util.function.Supplier`
  downstream - a Collector implementing the downstream reduction - `java.util.stream.Collector`

  returns: a Collector implementing the cascaded group-by operation - `<T,K,D,A,M extends java.util.Map<K,D>> java.util.stream.Collector<T,?,M>`"
  ([^java.util.function.Function classifier ^java.util.function.Supplier map-factory ^java.util.stream.Collector downstream]
    (Collectors/groupingBy classifier map-factory downstream))
  ([^java.util.function.Function classifier ^java.util.stream.Collector downstream]
    (Collectors/groupingBy classifier downstream))
  ([^java.util.function.Function classifier]
    (Collectors/groupingBy classifier)))

