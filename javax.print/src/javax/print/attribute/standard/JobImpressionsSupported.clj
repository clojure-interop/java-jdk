(ns javax.print.attribute.standard.JobImpressionsSupported
  "Class JobImpressionsSupported is a printing attribute class, a set of
  integers, that gives the supported values for a JobImpressions attribute. It is restricted to a single contiguous range of
  integers; multiple non-overlapping ranges are not allowed. This gives the
  lower and upper bounds of the total sizes of print jobs in number of
  impressions that the printer will accept.

  IPP Compatibility: The JobImpressionsSupported attribute's canonical
  array form gives the lower and upper bound for the range of values to be
  included in an IPP \"job-impressions-supported\" attribute. See class SetOfIntegerSyntax for an
  explanation of canonical array form. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobImpressionsSupported]))

(defn ->job-impressions-supported
  "Constructor.

  Construct a new job impressions supported attribute containing a single
   range of integers. That is, only those values of JobImpressions in the
   one range are supported.

  lower-bound - Lower bound of the range. - `int`
  upper-bound - Upper bound of the range. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if a null range is specified or if a non-null range is specified with lowerBound less than 0."
  (^JobImpressionsSupported [^Integer lower-bound ^Integer upper-bound]
    (new JobImpressionsSupported lower-bound upper-bound)))

(defn equals
  "Returns whether this job impressions supported attribute is equivalent
   to the passed in object. To be equivalent, all of the following
   conditions must be true:


   object is not null.

   object is an instance of class JobImpressionsSupported.

   This job impressions supported attribute's members and
   object's members are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            impressions supported attribute, false otherwise. - `boolean`"
  (^Boolean [^JobImpressionsSupported this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class JobImpressionsSupported, the category is class
   JobImpressionsSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^JobImpressionsSupported this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobImpressionsSupported, the category name is
   \"job-impressions-supported\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^JobImpressionsSupported this]
    (-> this (.getName))))

