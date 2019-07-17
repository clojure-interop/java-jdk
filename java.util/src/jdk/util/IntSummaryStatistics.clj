(ns jdk.util.IntSummaryStatistics
  "A state object for collecting statistics such as count, min, max, sum, and
  average.

  This class is designed to work with (though does not require)
  streams. For example, you can compute
  summary statistics on a stream of ints with:


  IntSummaryStatistics stats = intStream.collect(IntSummaryStatistics::new,
                                                 IntSummaryStatistics::accept,
                                                 IntSummaryStatistics::combine);

  IntSummaryStatistics can be used as a
  reduction
  target for a java.util.stream.stream. For example:



  IntSummaryStatistics stats = people.stream()
                                     .collect(Collectors.summarizingInt(Person::getDependents));

  This computes, in a single pass, the count of people, as well as the minimum,
  maximum, sum, and average of their number of dependents."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IntSummaryStatistics]))

(defn ->int-summary-statistics
  "Constructor.

  Construct an empty instance with zero count, zero sum,
   Integer.MAX_VALUE min, Integer.MIN_VALUE max and zero
   average."
  ([]
    (new IntSummaryStatistics )))

(defn accept
  "Records a new value into the summary information

  value - the input value - `int`"
  ([this value]
    (-> this (.accept value))))

(defn combine
  "Combines the state of another IntSummaryStatistics into this one.

  other - another IntSummaryStatistics - `java.util.IntSummaryStatistics`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.combine other))))

(defn get-count
  "Returns the count of values recorded.

  returns: the count of values - `long`"
  ([this]
    (-> this (.getCount))))

(defn get-sum
  "Returns the sum of values recorded, or zero if no values have been
   recorded.

  returns: the sum of values, or zero if none - `long`"
  ([this]
    (-> this (.getSum))))

(defn get-min
  "Returns the minimum value recorded, or Integer.MAX_VALUE if no
   values have been recorded.

  returns: the minimum value, or Integer.MAX_VALUE if none - `int`"
  ([this]
    (-> this (.getMin))))

(defn get-max
  "Returns the maximum value recorded, or Integer.MIN_VALUE if no
   values have been recorded.

  returns: the maximum value, or Integer.MIN_VALUE if none - `int`"
  ([this]
    (-> this (.getMax))))

(defn get-average
  "Returns the arithmetic mean of values recorded, or zero if no values have been
   recorded.

  returns: the arithmetic mean of values, or zero if none - `double`"
  ([this]
    (-> this (.getAverage))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

