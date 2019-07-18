(ns javax.management.openmbean.OpenMBeanConstructorInfoSupport
  "Describes a constructor of an Open MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanConstructorInfoSupport]))

(defn ->open-m-bean-constructor-info-support
  "Constructor.

  Constructs an OpenMBeanConstructorInfoSupport
   instance, which describes the constructor of a class of open
   MBeans with the specified name, description,
   signature, and descriptor.

   The signature array parameter is internally copied,
   so that subsequent changes to the array referenced by signature have no effect on this instance.

  name - cannot be a null or empty string. - `java.lang.String`
  description - cannot be a null or empty string. - `java.lang.String`
  signature - can be null or empty if there are no parameters to describe. - `javax.management.openmbean.OpenMBeanParameterInfo[]`
  descriptor - The descriptor for the constructor. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`

  throws: java.lang.IllegalArgumentException - if name or description are null or empty string."
  (^OpenMBeanConstructorInfoSupport [^java.lang.String name ^java.lang.String description signature ^javax.management.Descriptor descriptor]
    (new OpenMBeanConstructorInfoSupport name description signature descriptor))
  (^OpenMBeanConstructorInfoSupport [^java.lang.String name ^java.lang.String description signature]
    (new OpenMBeanConstructorInfoSupport name description signature)))

(defn equals
  "Compares the specified obj parameter with this
   OpenMBeanConstructorInfoSupport instance for
   equality.

   Returns true if and only if all of the following
   statements are true:


   obj is non null,
   obj also implements the OpenMBeanConstructorInfo interface,
   their names are equal
   their signatures are equal.


   This ensures that this equals method works properly for
   obj parameters which are different implementations of
   the OpenMBeanConstructorInfo interface.

  obj - the object to be compared for equality with this OpenMBeanConstructorInfoSupport instance; - `java.lang.Object`

  returns: true if the specified object is equal to this
   OpenMBeanConstructorInfoSupport instance. - `boolean`"
  (^Boolean [^OpenMBeanConstructorInfoSupport this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanConstructorInfoSupport instance.

   The hash code of an OpenMBeanConstructorInfoSupport
   instance is the sum of the hash codes of all elements of
   information used in equals comparisons (ie: its name
   and signature, where the signature hashCode is calculated by a
   call to java.util.Arrays.asList(this.getSignature).hashCode()).

   This ensures that t1.equals(t2) implies that t1.hashCode()==t2.hashCode() for any two OpenMBeanConstructorInfoSupport instances t1 and
   t2, as required by the general contract of the method
   Object.hashCode().

   However, note that another instance of a class implementing
   the OpenMBeanConstructorInfo interface may be equal to
   this OpenMBeanConstructorInfoSupport instance as
   defined by equals(java.lang.Object), but may have a
   different hash code if it is calculated differently.

   As OpenMBeanConstructorInfoSupport instances are
   immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value
   is returned for subsequent calls.

  returns: the hash code value for this OpenMBeanConstructorInfoSupport instance - `int`"
  (^Integer [^OpenMBeanConstructorInfoSupport this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this OpenMBeanConstructorInfoSupport instance.

   The string representation consists of the name of this class
   (ie javax.management.openmbean.OpenMBeanConstructorInfoSupport),
   the name and signature of the described constructor and the
   string representation of its descriptor.

   As OpenMBeanConstructorInfoSupport instances are
   immutable, the string representation for this instance is
   calculated once, on the first call to toString, and
   then the same value is returned for subsequent calls.

  returns: a string representation of this OpenMBeanConstructorInfoSupport instance - `java.lang.String`"
  (^java.lang.String [^OpenMBeanConstructorInfoSupport this]
    (-> this (.toString))))

