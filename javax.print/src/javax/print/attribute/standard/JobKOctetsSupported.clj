(ns javax.print.attribute.standard.JobKOctetsSupported
  "Class JobKOctetsSupported is a printing attribute class, a set of integers,
  that gives the supported values for a JobKOctets
  attribute. It is restricted to a single contiguous range of integers;
  multiple non-overlapping ranges are not allowed. This gives the lower and
  upper bounds of the total sizes of print jobs in units of K octets (1024
  octets) that the printer will accept.

  IPP Compatibility: The JobKOctetsSupported attribute's canonical array
  form gives the lower and upper bound for the range of values to be included
  in an IPP `job-k-octets-supported` attribute. See class SetOfIntegerSyntax for an
  explanation of canonical array form. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobKOctetsSupported]))

(defn ->job-k-octets-supported
  "Constructor.

  Construct a new job K octets supported attribute containing a single
   range of integers. That is, only those values of JobKOctets in the one
   range are supported.

  lower-bound - Lower bound of the range. - `int`
  upper-bound - Upper bound of the range. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if a null range is specified or if a non-null range is specified with lowerBound less than 0."
  ([lower-bound upper-bound]
    (new JobKOctetsSupported lower-bound upper-bound)))

(defn equals
  "Returns whether this job K octets supported attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class JobKOctetsSupported.

   This job K octets supported attribute's members and
   object's members are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job K
            octets supported attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobKOctetsSupported, the category is class
   JobKOctetsSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobKOctetsSupported, the category name is
   `job-k-octets-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

