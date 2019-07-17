(ns jdk.util.Optional
  "A container object which may or may not contain a non-null value.
  If a value is present, isPresent() will return true and
  get() will return the value.

  Additional methods that depend on the presence or absence of a contained
  value are provided, such as orElse()
  (return a default value if value not present) and
  ifPresent() (execute a block
  of code if the value is present).

  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  Optional may have unpredictable results and should be avoided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Optional]))

(defn *empty
  "Returns an empty Optional instance.  No value is present for this
   Optional.

  returns: an empty Optional - `<T> java.util.Optional<T>`"
  ([]
    (Optional/empty )))

(defn *of
  "Returns an Optional with the specified present non-null value.

  value - the value to be present, which must be non-null - `T`

  returns: an Optional with the value present - `<T> java.util.Optional<T>`

  throws: java.lang.NullPointerException - if value is null"
  ([value]
    (Optional/of value)))

(defn *of-nullable
  "Returns an Optional describing the specified value, if non-null,
   otherwise returns an empty Optional.

  value - the possibly-null value to describe - `T`

  returns: an Optional with a present value if the specified value
   is non-null, otherwise an empty Optional - `<T> java.util.Optional<T>`"
  ([value]
    (Optional/ofNullable value)))

(defn map
  "If a value is present, apply the provided mapping function to it,
   and if the result is non-null, return an Optional describing the
   result.  Otherwise return an empty Optional.

  mapper - a mapping function to apply to the value, if present - `U>`

  returns: an Optional describing the result of applying a mapping
   function to the value of this Optional, if a value is present,
   otherwise an empty Optional - `<U> java.util.Optional<U>`

  throws: java.lang.NullPointerException - if the mapping function is null"
  ([^java.util.Optional this mapper]
    (-> this (.map mapper))))

(defn or-else-throw
  "Return the contained value, if present, otherwise throw an exception
   to be created by the provided supplier.

  exception-supplier - The supplier which will return the exception to be thrown - `X>`

  returns: the present value - `<X extends java.lang.Throwable> Optional.T`

  throws: X - if there is no value present"
  ([^java.util.Optional this exception-supplier]
    (-> this (.orElseThrow exception-supplier))))

(defn present?
  "Return true if there is a value present, otherwise false.

  returns: true if there is a value present, otherwise false - `boolean`"
  ([^java.util.Optional this]
    (-> this (.isPresent))))

(defn to-string
  "Returns a non-empty string representation of this Optional suitable for
   debugging. The exact presentation format is unspecified and may vary
   between implementations and versions.

  returns: the string representation of this instance - `java.lang.String`"
  ([^java.util.Optional this]
    (-> this (.toString))))

(defn flat-map
  "If a value is present, apply the provided Optional-bearing
   mapping function to it, return that result, otherwise return an empty
   Optional.  This method is similar to map(Function),
   but the provided mapper is one whose result is already an Optional,
   and if invoked, flatMap does not wrap it with an additional
   Optional.

  mapper - a mapping function to apply to the value, if present the mapping function - `Optional.T,java.util.Optional<U>>`

  returns: the result of applying an Optional-bearing mapping
   function to the value of this Optional, if a value is present,
   otherwise an empty Optional - `<U> java.util.Optional<U>`

  throws: java.lang.NullPointerException - if the mapping function is null or returns a null result"
  ([^java.util.Optional this ^Optional.T,java.util.Optional> mapper]
    (-> this (.flatMap mapper))))

(defn or-else-get
  "Return the value if present, otherwise invoke other and return
   the result of that invocation.

  other - a Supplier whose result is returned if no value is present - `Optional.T>`

  returns: the value if present otherwise the result of other.get() - `Optional.T`

  throws: java.lang.NullPointerException - if value is not present and other is null"
  ([^java.util.Optional this ^Optional.T> other]
    (-> this (.orElseGet other))))

(defn filter
  "If a value is present, and the value matches the given predicate,
   return an Optional describing the value, otherwise return an
   empty Optional.

  predicate - a predicate to apply to the value, if present - `Optional.T>`

  returns: an Optional describing the value of this Optional
   if a value is present and the value matches the given predicate,
   otherwise an empty Optional - `java.util.Optional<Optional.T>`

  throws: java.lang.NullPointerException - if the predicate is null"
  ([^java.util.Optional this ^Optional.T> predicate]
    (-> this (.filter predicate))))

(defn if-present
  "If a value is present, invoke the specified consumer with the value,
   otherwise do nothing.

  consumer - block to be executed if a value is present - `Optional.T>`

  throws: java.lang.NullPointerException - if value is present and consumer is null"
  ([^java.util.Optional this ^Optional.T> consumer]
    (-> this (.ifPresent consumer))))

(defn hash-code
  "Returns the hash code value of the present value, if any, or 0 (zero) if
   no value is present.

  returns: hash code value of the present value or 0 if no value is present - `int`"
  ([^java.util.Optional this]
    (-> this (.hashCode))))

(defn or-else
  "Return the value if present, otherwise return other.

  other - the value to be returned if there is no value present, may be null - `Optional.T`

  returns: the value, if present, otherwise other - `Optional.T`"
  ([^java.util.Optional this ^Optional.T other]
    (-> this (.orElse other))))

(defn get
  "If a value is present in this Optional, returns the value,
   otherwise throws NoSuchElementException.

  returns: the non-null value held by this Optional - `Optional.T`

  throws: java.util.NoSuchElementException - if there is no value present"
  ([^java.util.Optional this]
    (-> this (.get))))

(defn equals
  "Indicates whether some other object is `equal to` this Optional. The
   other object is considered equal if:

   it is also an Optional and;
   both instances have no value present or;
   the present values are `equal to` each other via equals().

  obj - an object to be tested for equality - `java.lang.Object`

  returns: {code true} if the other object is `equal to` this object
   otherwise false - `boolean`"
  ([^java.util.Optional this ^java.lang.Object obj]
    (-> this (.equals obj))))

