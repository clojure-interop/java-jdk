(ns jdk.util.OptionalInt
  "A container object which may or may not contain a int value.
  If a value is present, isPresent() will return true and
  getAsInt() will return the value.

  Additional methods that depend on the presence or absence of a contained
  value are provided, such as orElse()
  (return a default value if value not present) and
  ifPresent() (execute a block
  of code if the value is present).

  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  OptionalInt may have unpredictable results and should be avoided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util OptionalInt]))

(defn *empty
  "Returns an empty OptionalInt instance.  No value is present for this
   OptionalInt.

  returns: an empty OptionalInt - `java.util.OptionalInt`"
  (^java.util.OptionalInt []
    (OptionalInt/empty )))

(defn *of
  "Return an OptionalInt with the specified value present.

  value - the value to be present - `int`

  returns: an OptionalInt with the value present - `java.util.OptionalInt`"
  (^java.util.OptionalInt [^Integer value]
    (OptionalInt/of value)))

(defn or-else-throw
  "Return the contained value, if present, otherwise throw an exception
   to be created by the provided supplier.

  exception-supplier - The supplier which will return the exception to be thrown - `java.util.function.Supplier`

  returns: the present value - `<X extends java.lang.Throwable> int`

  throws: X - if there is no value present"
  ([^OptionalInt this ^java.util.function.Supplier exception-supplier]
    (-> this (.orElseThrow exception-supplier))))

(defn present?
  "Return true if there is a value present, otherwise false.

  returns: true if there is a value present, otherwise false - `boolean`"
  (^Boolean [^OptionalInt this]
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
  (^java.lang.String [^OptionalInt this]
    (-> this (.toString))))

(defn or-else-get
  "Return the value if present, otherwise invoke other and return
   the result of that invocation.

  other - a IntSupplier whose result is returned if no value is present - `java.util.function.IntSupplier`

  returns: the value if present otherwise the result of other.getAsInt() - `int`

  throws: java.lang.NullPointerException - if value is not present and other is null"
  (^Integer [^OptionalInt this ^java.util.function.IntSupplier other]
    (-> this (.orElseGet other))))

(defn if-present
  "Have the specified consumer accept the value if a value is present,
   otherwise do nothing.

  consumer - block to be executed if a value is present - `java.util.function.IntConsumer`

  throws: java.lang.NullPointerException - if value is present and consumer is null"
  ([^OptionalInt this ^java.util.function.IntConsumer consumer]
    (-> this (.ifPresent consumer))))

(defn hash-code
  "Returns the hash code value of the present value, if any, or 0 (zero) if
   no value is present.

  returns: hash code value of the present value or 0 if no value is present - `int`"
  (^Integer [^OptionalInt this]
    (-> this (.hashCode))))

(defn or-else
  "Return the value if present, otherwise return other.

  other - the value to be returned if there is no value present - `int`

  returns: the value, if present, otherwise other - `int`"
  (^Integer [^OptionalInt this ^Integer other]
    (-> this (.orElse other))))

(defn get-as-int
  "If a value is present in this OptionalInt, returns the value,
   otherwise throws NoSuchElementException.

  returns: the value held by this OptionalInt - `int`

  throws: java.util.NoSuchElementException - if there is no value present"
  (^Integer [^OptionalInt this]
    (-> this (.getAsInt))))

(defn equals
  "Indicates whether some other object is `equal to` this OptionalInt. The
   other object is considered equal if:

   it is also an OptionalInt and;
   both instances have no value present or;
   the present values are `equal to` each other via ==.

  obj - an object to be tested for equality - `java.lang.Object`

  returns: {code true} if the other object is `equal to` this object
   otherwise false - `boolean`"
  (^Boolean [^OptionalInt this ^java.lang.Object obj]
    (-> this (.equals obj))))

