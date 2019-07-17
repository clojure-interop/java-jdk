(ns jdk.util.stream.Collector$Characteristics
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream Collector$Characteristics]))

(def CONCURRENT
  "Enum Constant.

  Indicates that this collector is concurrent, meaning that
   the result container can support the accumulator function being
   called concurrently with the same result container from multiple
   threads.

   If a CONCURRENT collector is not also UNORDERED,
   then it should only be evaluated concurrently if applied to an
   unordered data source.

  type: java.util.stream.Collector.Characteristics"
  Collector$Characteristics/CONCURRENT)

(def UNORDERED
  "Enum Constant.

  Indicates that the collection operation does not commit to preserving
   the encounter order of input elements.  (This might be true if the
   result container has no intrinsic order, such as a Set.)

  type: java.util.stream.Collector.Characteristics"
  Collector$Characteristics/UNORDERED)

(def IDENTITY_FINISH
  "Enum Constant.

  Indicates that the finisher function is the identity function and
   can be elided.  If set, it must be the case that an unchecked cast
   from A to R will succeed.

  type: java.util.stream.Collector.Characteristics"
  Collector$Characteristics/IDENTITY_FINISH)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Collector.Characteristics c : Collector.Characteristics.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.util.stream.Collector.Characteristics[]`"
  ([]
    (Collector$Characteristics/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.util.stream.Collector.Characteristics`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.util.stream.Collector.Characteristics [^java.lang.String name]
    (Collector$Characteristics/valueOf name)))

