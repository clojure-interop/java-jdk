(ns javax.print.attribute.standard.NumberUpSupported
  "Class NumberUpSupported is a printing attribute class, a set of integers,
  that gives the supported values for a NumberUp attribute.

  IPP Compatibility: The NumberUpSupported attribute's canonical array
  form gives the lower and upper bound for each range of number-up to be
  included in an IPP `number-up-supported` attribute. See class SetOfIntegerSyntax for an
  explanation of canonical array form. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard NumberUpSupported]))

(defn ->number-up-supported
  "Constructor.

  Construct a new number up supported attribute containing a single range
   of integers. That is, only those values of NumberUp in the one range are
   supported.

  lower-bound - Lower bound of the range. - `int`
  upper-bound - Upper bound of the range. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if a null range is specified or if a non-null range is specified with lowerBound less than 1."
  ([lower-bound upper-bound]
    (new NumberUpSupported lower-bound upper-bound))
  ([members]
    (new NumberUpSupported members)))

(defn equals
  "Returns whether this number up supported attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class NumberUpSupported.

   This number up supported attribute's members and object's
   members are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this number up
            supported attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class NumberUpSupported, the
   category is class NumberUpSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class NumberUpSupported, the
   category name is `number-up-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

