(ns jdk.util.LongSummaryStatistics
  "A state object for collecting statistics such as count, min, max, sum, and
  average.

  This class is designed to work with (though does not require)
  streams. For example, you can compute
  summary statistics on a stream of longs with:


  LongSummaryStatistics stats = longStream.collect(LongSummaryStatistics::new,
                                                   LongSummaryStatistics::accept,
                                                   LongSummaryStatistics::combine);

  LongSummaryStatistics can be used as a
  Stream.collect(Collector) reduction}
  target for a java.util.stream.stream. For example:



  LongSummaryStatistics stats = people.stream()
                                      .collect(Collectors.summarizingLong(Person::getAge));

  This computes, in a single pass, the count of people, as well as the minimum,
  maximum, sum, and average of their ages."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util LongSummaryStatistics]))

(defn ->long-summary-statistics
  "Constructor.

  Construct an empty instance with zero count, zero sum,
   Long.MAX_VALUE min, Long.MIN_VALUE max and zero
   average."
  (^LongSummaryStatistics []
    (new LongSummaryStatistics )))

(defn accept
  "Records a new int value into the summary information.

  value - the input value - `int`"
  ([^LongSummaryStatistics this ^Integer value]
    (-> this (.accept value))))

(defn combine
  "Combines the state of another LongSummaryStatistics into this
   one.

  other - another LongSummaryStatistics - `java.util.LongSummaryStatistics`

  throws: java.lang.NullPointerException - if other is null"
  ([^LongSummaryStatistics this ^java.util.LongSummaryStatistics other]
    (-> this (.combine other))))

(defn get-count
  "Returns the count of values recorded.

  returns: the count of values - `long`"
  (^Long [^LongSummaryStatistics this]
    (-> this (.getCount))))

(defn get-sum
  "Returns the sum of values recorded, or zero if no values have been
   recorded.

  returns: the sum of values, or zero if none - `long`"
  (^Long [^LongSummaryStatistics this]
    (-> this (.getSum))))

(defn get-min
  "Returns the minimum value recorded, or Long.MAX_VALUE if no
   values have been recorded.

  returns: the minimum value, or Long.MAX_VALUE if none - `long`"
  (^Long [^LongSummaryStatistics this]
    (-> this (.getMin))))

(defn get-max
  "Returns the maximum value recorded, or Long.MIN_VALUE if no
   values have been recorded

  returns: the maximum value, or Long.MIN_VALUE if none - `long`"
  (^Long [^LongSummaryStatistics this]
    (-> this (.getMax))))

(defn get-average
  "Returns the arithmetic mean of values recorded, or zero if no values have been
   recorded.

  returns: The arithmetic mean of values, or zero if none - `double`"
  (^Double [^LongSummaryStatistics this]
    (-> this (.getAverage))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^LongSummaryStatistics this]
    (-> this (.toString))))

