(ns jdk.util.DoubleSummaryStatistics
  "A state object for collecting statistics such as count, min, max, sum, and
  average.

  This class is designed to work with (though does not require)
  streams. For example, you can compute
  summary statistics on a stream of doubles with:


  DoubleSummaryStatistics stats = doubleStream.collect(DoubleSummaryStatistics::new,
                                                       DoubleSummaryStatistics::accept,
                                                       DoubleSummaryStatistics::combine);

  DoubleSummaryStatistics can be used as a
  reduction
  target for a java.util.stream.stream. For example:



  DoubleSummaryStatistics stats = people.stream()
      .collect(Collectors.summarizingDouble(Person::getWeight));

  This computes, in a single pass, the count of people, as well as the minimum,
  maximum, sum, and average of their weights."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util DoubleSummaryStatistics]))

(defn ->double-summary-statistics
  "Constructor.

  Construct an empty instance with zero count, zero sum,
   Double.POSITIVE_INFINITY min, Double.NEGATIVE_INFINITY
   max and zero average."
  ([]
    (new DoubleSummaryStatistics )))

(defn accept
  "Records another value into the summary information.

  value - the input value - `double`"
  ([^java.util.DoubleSummaryStatistics this ^Double value]
    (-> this (.accept value))))

(defn combine
  "Combines the state of another DoubleSummaryStatistics into this
   one.

  other - another DoubleSummaryStatistics - `java.util.DoubleSummaryStatistics`

  throws: java.lang.NullPointerException - if other is null"
  ([^java.util.DoubleSummaryStatistics this ^java.util.DoubleSummaryStatistics other]
    (-> this (.combine other))))

(defn get-count
  "Return the count of values recorded.

  returns: the count of values - `long`"
  (^Long [^java.util.DoubleSummaryStatistics this]
    (-> this (.getCount))))

(defn get-sum
  "Returns the sum of values recorded, or zero if no values have been
   recorded.

   If any recorded value is a NaN or the sum is at any point a NaN
   then the sum will be NaN.

    The value of a floating-point sum is a function both of the
   input values as well as the order of addition operations. The
   order of addition operations of this method is intentionally
   not defined to allow for implementation flexibility to improve
   the speed and accuracy of the computed result.

   In particular, this method may be implemented using compensated
   summation or other technique to reduce the error bound in the
   numerical sum compared to a simple summation of double
   values.

  returns: the sum of values, or zero if none - `double`"
  (^Double [^java.util.DoubleSummaryStatistics this]
    (-> this (.getSum))))

(defn get-min
  "Returns the minimum recorded value, Double.NaN if any recorded
   value was NaN or Double.POSITIVE_INFINITY if no values were
   recorded. Unlike the numerical comparison operators, this method
   considers negative zero to be strictly smaller than positive zero.

  returns: the minimum recorded value, Double.NaN if any recorded
   value was NaN or Double.POSITIVE_INFINITY if no values were
   recorded - `double`"
  (^Double [^java.util.DoubleSummaryStatistics this]
    (-> this (.getMin))))

(defn get-max
  "Returns the maximum recorded value, Double.NaN if any recorded
   value was NaN or Double.NEGATIVE_INFINITY if no values were
   recorded. Unlike the numerical comparison operators, this method
   considers negative zero to be strictly smaller than positive zero.

  returns: the maximum recorded value, Double.NaN if any recorded
   value was NaN or Double.NEGATIVE_INFINITY if no values were
   recorded - `double`"
  (^Double [^java.util.DoubleSummaryStatistics this]
    (-> this (.getMax))))

(defn get-average
  "Returns the arithmetic mean of values recorded, or zero if no
   values have been recorded.

   If any recorded value is a NaN or the sum is at any point a NaN
   then the average will be code NaN.

   The average returned can vary depending upon the order in
   which values are recorded.

   This method may be implemented using compensated summation or
   other technique to reduce the error bound in the numerical sum used to compute the average.

  returns: the arithmetic mean of values, or zero if none - `double`"
  (^Double [^java.util.DoubleSummaryStatistics this]
    (-> this (.getAverage))))

(defn to-string
  "Returns a string representation of the object. In general, the
   toString method returns a string that
   `textually represents` this object. The result should
   be a concise but informative representation that is easy for a
   person to read.
   It is recommended that all subclasses override this method.

   The toString method for class Object
   returns a string consisting of the name of the class of which the
   object is an instance, the at-sign character `@', and
   the unsigned hexadecimal representation of the hash code of the
   object. In other words, this method returns a string equal to the
   value of:



   getClass().getName()  '@'  Integer.toHexString(hashCode())

   Returns a non-empty string representation of this object suitable for
   debugging. The exact presentation format is unspecified and may vary
   between implementations and versions.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.util.DoubleSummaryStatistics this]
    (-> this (.toString))))

