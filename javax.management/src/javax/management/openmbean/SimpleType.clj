(ns javax.management.openmbean.SimpleType
  "The SimpleType class is the open type class whose instances describe
  all open data values which are neither arrays,
  nor CompositeData values,
  nor TabularData values.
  It predefines all its possible instances as static fields, and has no public constructor.

  Given a SimpleType instance describing values whose Java class name is className,
  the internal fields corresponding to the name and description of this SimpleType instance
  are also set to className.
  In other words, its methods getClassName, getTypeName and getDescription
  all return the same string value className."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean SimpleType]))

(def *-void
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Void.

  type: javax.management.openmbean.SimpleType<java.lang.Void>"
  SimpleType/VOID)

(def *-boolean
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Boolean.

  type: javax.management.openmbean.SimpleType<java.lang.Boolean>"
  SimpleType/BOOLEAN)

(def *-character
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Character.

  type: javax.management.openmbean.SimpleType<java.lang.Character>"
  SimpleType/CHARACTER)

(def *-byte
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Byte.

  type: javax.management.openmbean.SimpleType<java.lang.Byte>"
  SimpleType/BYTE)

(def *-short
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Short.

  type: javax.management.openmbean.SimpleType<java.lang.Short>"
  SimpleType/SHORT)

(def *-integer
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Integer.

  type: javax.management.openmbean.SimpleType<java.lang.Integer>"
  SimpleType/INTEGER)

(def *-long
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Long.

  type: javax.management.openmbean.SimpleType<java.lang.Long>"
  SimpleType/LONG)

(def *-float
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Float.

  type: javax.management.openmbean.SimpleType<java.lang.Float>"
  SimpleType/FLOAT)

(def *-double
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.Double.

  type: javax.management.openmbean.SimpleType<java.lang.Double>"
  SimpleType/DOUBLE)

(def *-string
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.lang.String.

  type: javax.management.openmbean.SimpleType<java.lang.String>"
  SimpleType/STRING)

(def *-bigdecimal
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.math.BigDecimal.

  type: javax.management.openmbean.SimpleType<java.math.BigDecimal>"
  SimpleType/BIGDECIMAL)

(def *-biginteger
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.math.BigInteger.

  type: javax.management.openmbean.SimpleType<java.math.BigInteger>"
  SimpleType/BIGINTEGER)

(def *-date
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is java.util.Date.

  type: javax.management.openmbean.SimpleType<java.util.Date>"
  SimpleType/DATE)

(def *-objectname
  "Static Constant.

  The SimpleType instance describing values whose
   Java class name is javax.management.ObjectName.

  type: javax.management.openmbean.SimpleType<javax.management.ObjectName>"
  SimpleType/OBJECTNAME)

(defn value?
  "Tests whether obj is a value for this
   SimpleType instance.   This method returns
   true if and only if obj is not null and
   obj's class name is the same as the className field
   defined for this SimpleType instance (ie the class
   name returned by the getClassName method).

  obj - the object to be tested. - `java.lang.Object`

  returns: true if obj is a value for this
   SimpleType instance. - `boolean`"
  (^Boolean [^javax.management.openmbean.SimpleType this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn equals
  "Compares the specified obj parameter with this SimpleType instance for equality.

   Two SimpleType instances are equal if and only if their
   getClassName methods return the same value.

  obj - the object to be compared for equality with this SimpleType instance; if obj is null or is not an instance of the class SimpleType, equals returns false. - `java.lang.Object`

  returns: true if the specified object is equal to this SimpleType instance. - `boolean`"
  (^Boolean [^javax.management.openmbean.SimpleType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this SimpleType instance.
   The hash code of a SimpleType instance is the the hash code of
   the string value returned by the getClassName method.

   As SimpleType instances are immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value is returned for subsequent calls.

  returns: the hash code value for this SimpleType instance - `int`"
  (^Integer [^javax.management.openmbean.SimpleType this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this SimpleType instance.

   The string representation consists of
   the name of this class (ie javax.management.openmbean.SimpleType) and the type name
   for this instance (which is the java class name of the values this SimpleType instance represents).

   As SimpleType instances are immutable, the string representation for this instance is calculated once,
   on the first call to toString, and then the same value is returned for subsequent calls.

  returns: a string representation of this SimpleType instance - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.SimpleType this]
    (-> this (.toString))))

(defn read-resolve
  "Replace an object read from an ObjectInputStream with the unique instance for that
   value.

  returns: the replacement object. - `java.lang.Object`

  throws: java.io.ObjectStreamException - if the read object cannot be resolved."
  (^java.lang.Object [^javax.management.openmbean.SimpleType this]
    (-> this (.readResolve))))

