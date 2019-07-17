(ns jdk.util.OptionalDouble
  "A container object which may or may not contain a double value.
  If a value is present, isPresent() will return true and
  getAsDouble() will return the value.

  Additional methods that depend on the presence or absence of a contained
  value are provided, such as orElse()
  (return a default value if value not present) and
  ifPresent() (execute a block
  of code if the value is present).

  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  OptionalDouble may have unpredictable results and should be avoided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util OptionalDouble]))

(defn *empty
  "Returns an empty OptionalDouble instance.  No value is present for this
   OptionalDouble.

  returns: an empty OptionalDouble. - `java.util.OptionalDouble`"
  ([]
    (OptionalDouble/empty )))

(defn *of
  "Return an OptionalDouble with the specified value present.

  value - the value to be present - `double`

  returns: an OptionalDouble with the value present - `java.util.OptionalDouble`"
  ([value]
    (OptionalDouble/of value)))

(defn get-as-double
  "If a value is present in this OptionalDouble, returns the value,
   otherwise throws NoSuchElementException.

  returns: the value held by this OptionalDouble - `double`

  throws: java.util.NoSuchElementException - if there is no value present"
  ([this]
    (-> this (.getAsDouble))))

(defn or-else-throw
  "Return the contained value, if present, otherwise throw an exception
   to be created by the provided supplier.

  exception-supplier - The supplier which will return the exception to be thrown - `java.util.function.Supplier<X>`

  returns: the present value - `<X extends java.lang.Throwable> double`

  throws: X - if there is no value present"
  ([this exception-supplier]
    (-> this (.orElseThrow exception-supplier))))

(defn present?
  "Return true if there is a value present, otherwise false.

  returns: true if there is a value present, otherwise false - `boolean`"
  ([this]
    (-> this (.isPresent))))

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

  returns: the string representation of this instance - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn or-else-get
  "Return the value if present, otherwise invoke other and return
   the result of that invocation.

  other - a DoubleSupplier whose result is returned if no value is present - `java.util.function.DoubleSupplier`

  returns: the value if present otherwise the result of other.getAsDouble() - `double`

  throws: java.lang.NullPointerException - if value is not present and other is null"
  ([this other]
    (-> this (.orElseGet other))))

(defn if-present
  "Have the specified consumer accept the value if a value is present,
   otherwise do nothing.

  consumer - block to be executed if a value is present - `java.util.function.DoubleConsumer`

  throws: java.lang.NullPointerException - if value is present and consumer is null"
  ([this consumer]
    (-> this (.ifPresent consumer))))

(defn hash-code
  "Returns the hash code value of the present value, if any, or 0 (zero) if
   no value is present.

  returns: hash code value of the present value or 0 if no value is present - `int`"
  ([this]
    (-> this (.hashCode))))

(defn or-else
  "Return the value if present, otherwise return other.

  other - the value to be returned if there is no value present - `double`

  returns: the value, if present, otherwise other - `double`"
  ([this other]
    (-> this (.orElse other))))

(defn equals
  "Indicates whether some other object is `equal to` this OptionalDouble. The
   other object is considered equal if:

   it is also an OptionalDouble and;
   both instances have no value present or;
   the present values are `equal to` each other via Double.compare() == 0.

  obj - an object to be tested for equality - `java.lang.Object`

  returns: {code true} if the other object is `equal to` this object
   otherwise false - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

