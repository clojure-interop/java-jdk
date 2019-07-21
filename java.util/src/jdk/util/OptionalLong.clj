(ns jdk.util.OptionalLong
  "A container object which may or may not contain a long value.
  If a value is present, isPresent() will return true and
  getAsLong() will return the value.

  Additional methods that depend on the presence or absence of a contained
  value are provided, such as orElse()
  (return a default value if value not present) and
  ifPresent() (execute a block
  of code if the value is present).

  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  OptionalLong may have unpredictable results and should be avoided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util OptionalLong]))

(defn *empty
  "Returns an empty OptionalLong instance.  No value is present for this
   OptionalLong.

  returns: an empty OptionalLong. - `java.util.OptionalLong`"
  (^java.util.OptionalLong []
    (OptionalLong/empty )))

(defn *of
  "Return an OptionalLong with the specified value present.

  value - the value to be present - `long`

  returns: an OptionalLong with the value present - `java.util.OptionalLong`"
  (^java.util.OptionalLong [^Long value]
    (OptionalLong/of value)))

(defn or-else-throw
  "Return the contained value, if present, otherwise throw an exception
   to be created by the provided supplier.

  exception-supplier - The supplier which will return the exception to be thrown - `java.util.function.Supplier`

  returns: the present value - `<X extends java.lang.Throwable> long`

  throws: X - if there is no value present"
  ([^OptionalLong this ^java.util.function.Supplier exception-supplier]
    (-> this (.orElseThrow exception-supplier))))

(defn present?
  "Return true if there is a value present, otherwise false.

  returns: true if there is a value present, otherwise false - `boolean`"
  (^Boolean [^OptionalLong this]
    (-> this (.isPresent))))

(defn to-string
  "Returns a string representation of the object. In general, the
   toString method returns a string that
   \"textually represents\" this object. The result should
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
  (^java.lang.String [^OptionalLong this]
    (-> this (.toString))))

(defn or-else-get
  "Return the value if present, otherwise invoke other and return
   the result of that invocation.

  other - a LongSupplier whose result is returned if no value is present - `java.util.function.LongSupplier`

  returns: the value if present otherwise the result of other.getAsLong() - `long`

  throws: java.lang.NullPointerException - if value is not present and other is null"
  (^Long [^OptionalLong this ^java.util.function.LongSupplier other]
    (-> this (.orElseGet other))))

(defn get-as-long
  "If a value is present in this OptionalLong, returns the value,
   otherwise throws NoSuchElementException.

  returns: the value held by this OptionalLong - `long`

  throws: java.util.NoSuchElementException - if there is no value present"
  (^Long [^OptionalLong this]
    (-> this (.getAsLong))))

(defn if-present
  "Have the specified consumer accept the value if a value is present,
   otherwise do nothing.

  consumer - block to be executed if a value is present - `java.util.function.LongConsumer`

  throws: java.lang.NullPointerException - if value is present and consumer is null"
  ([^OptionalLong this ^java.util.function.LongConsumer consumer]
    (-> this (.ifPresent consumer))))

(defn hash-code
  "Returns the hash code value of the present value, if any, or 0 (zero) if
   no value is present.

  returns: hash code value of the present value or 0 if no value is present - `int`"
  (^Integer [^OptionalLong this]
    (-> this (.hashCode))))

(defn or-else
  "Return the value if present, otherwise return other.

  other - the value to be returned if there is no value present - `long`

  returns: the value, if present, otherwise other - `long`"
  (^Long [^OptionalLong this ^Long other]
    (-> this (.orElse other))))

(defn equals
  "Indicates whether some other object is \"equal to\" this OptionalLong. The
   other object is considered equal if:

   it is also an OptionalLong and;
   both instances have no value present or;
   the present values are \"equal to\" each other via ==.

  obj - an object to be tested for equality - `java.lang.Object`

  returns: {code true} if the other object is \"equal to\" this object
   otherwise false - `boolean`"
  (^Boolean [^OptionalLong this ^java.lang.Object obj]
    (-> this (.equals obj))))

