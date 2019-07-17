(ns javax.management.openmbean.OpenMBeanOperationInfoSupport
  "Describes an operation of an Open MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanOperationInfoSupport]))

(defn ->open-m-bean-operation-info-support
  "Constructor.

  Constructs an OpenMBeanOperationInfoSupport
   instance, which describes the operation of a class of open
   MBeans, with the specified name, description,
   signature, returnOpenType, impact, and descriptor.

   The signature array parameter is internally copied,
   so that subsequent changes to the array referenced by signature have no effect on this instance.

  name - cannot be a null or empty string. - `java.lang.String`
  description - cannot be a null or empty string. - `java.lang.String`
  signature - can be null or empty if there are no parameters to describe. - `javax.management.openmbean.OpenMBeanParameterInfo[]`
  return-open-type - cannot be null: use SimpleType.VOID for operations that return nothing. - `javax.management.openmbean.OpenType<?>`
  impact - must be one of ACTION, ACTION_INFO, INFO, or UNKNOWN. - `int`
  descriptor - The descriptor for the operation. This may be null, which is equivalent to an empty descriptor. - `javax.management.Descriptor`

  throws: java.lang.IllegalArgumentException - if name or description are null or empty string, or returnOpenType is null, or impact is not one of ACTION, ACTION_INFO, INFO, or UNKNOWN."
  ([^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenMBeanParameterInfo[] signature ^javax.management.openmbean.OpenType return-open-type ^Integer impact ^javax.management.Descriptor descriptor]
    (new OpenMBeanOperationInfoSupport name description signature return-open-type impact descriptor))
  ([^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenMBeanParameterInfo[] signature ^javax.management.openmbean.OpenType return-open-type ^Integer impact]
    (new OpenMBeanOperationInfoSupport name description signature return-open-type impact)))

(defn get-return-open-type
  "Returns the open type of the values returned by the
   operation described by this OpenMBeanOperationInfo
   instance.

  returns: the return type. - `javax.management.openmbean.OpenType<?>`"
  ([^javax.management.openmbean.OpenMBeanOperationInfoSupport this]
    (-> this (.getReturnOpenType))))

(defn equals
  "Compares the specified obj parameter with this
   OpenMBeanOperationInfoSupport instance for
   equality.

   Returns true if and only if all of the following
   statements are true:


   obj is non null,
   obj also implements the OpenMBeanOperationInfo interface,
   their names are equal
   their signatures are equal
   their return open types are equal
   their impacts are equal


   This ensures that this equals method works properly for
   obj parameters which are different implementations of
   the OpenMBeanOperationInfo interface.

  obj - the object to be compared for equality with this OpenMBeanOperationInfoSupport instance; - `java.lang.Object`

  returns: true if the specified object is equal to this
   OpenMBeanOperationInfoSupport instance. - `boolean`"
  ([^javax.management.openmbean.OpenMBeanOperationInfoSupport this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanOperationInfoSupport instance.

   The hash code of an OpenMBeanOperationInfoSupport
   instance is the sum of the hash codes of all elements of
   information used in equals comparisons (ie: its name,
   return open type, impact and signature, where the signature
   hashCode is calculated by a call to java.util.Arrays.asList(this.getSignature).hashCode()).

   This ensures that t1.equals(t2)  implies that t1.hashCode()==t2.hashCode()  for any two OpenMBeanOperationInfoSupport instances t1 and t2, as required by the general contract of the method Object.hashCode().

   However, note that another instance of a class implementing
   the OpenMBeanOperationInfo interface may be equal to
   this OpenMBeanOperationInfoSupport instance as defined
   by equals(java.lang.Object), but may have a different
   hash code if it is calculated differently.

   As OpenMBeanOperationInfoSupport instances are
   immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value
   is returned for subsequent calls.

  returns: the hash code value for this OpenMBeanOperationInfoSupport instance - `int`"
  ([^javax.management.openmbean.OpenMBeanOperationInfoSupport this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this OpenMBeanOperationInfoSupport instance.

   The string representation consists of the name of this class
   (ie javax.management.openmbean.OpenMBeanOperationInfoSupport), and
   the name, signature, return open type and impact of the
   described operation and the string representation of its descriptor.

   As OpenMBeanOperationInfoSupport instances are
   immutable, the string representation for this instance is
   calculated once, on the first call to toString, and
   then the same value is returned for subsequent calls.

  returns: a string representation of this OpenMBeanOperationInfoSupport instance - `java.lang.String`"
  ([^javax.management.openmbean.OpenMBeanOperationInfoSupport this]
    (-> this (.toString))))

