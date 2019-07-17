(ns javax.print.attribute.standard.CopiesSupported
  "Class CopiesSupported is a printing attribute class, a set of integers, that
  gives the supported values for a Copies attribute. It is
  restricted to a single contiguous range of integers; multiple non-overlapping
  ranges are not allowed.

  IPP Compatibility: The CopiesSupported attribute's canonical array
  form gives the lower and upper bound for the range of copies to be included
  in an IPP `copies-supported` attribute. See class SetOfIntegerSyntax for an
  explanation of canonical array form. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard CopiesSupported]))

(defn ->copies-supported
  "Constructor.

  Construct a new copies supported attribute containing a single range of
   integers. That is, only those values of Copies in the one range are
   supported.

  lower-bound - Lower bound of the range. - `int`
  upper-bound - Upper bound of the range. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if a null range is specified or if a non-null range is specified with lowerBound less than 1."
  ([^Integer lower-bound ^Integer upper-bound]
    (new CopiesSupported lower-bound upper-bound))
  ([^Integer member]
    (new CopiesSupported member)))

(defn equals
  "Returns whether this copies supported attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions must
   be true:


   object is not null.

   object is an instance of class CopiesSupported.

   This copies supported attribute's members and object's
   members are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this copies
            supported attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.CopiesSupported this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class CopiesSupported, the category
   is class CopiesSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.CopiesSupported this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class CopiesSupported, the category
   name is `copies-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.CopiesSupported this]
    (-> this (.getName))))

