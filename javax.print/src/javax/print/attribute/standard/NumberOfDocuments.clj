(ns javax.print.attribute.standard.NumberOfDocuments
  "Class NumberOfDocuments is an integer valued printing attribute that
  indicates the number of individual docs the printer has accepted for this
  job, regardless of whether the docs' print data has reached the printer or
  not.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard NumberOfDocuments]))

(defn ->number-of-documents
  "Constructor.

  Construct a new number of documents attribute with the given integer
   value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  (^NumberOfDocuments [^Integer value]
    (new NumberOfDocuments value)))

(defn equals
  "Returns whether this number of documents attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class NumberOfDocuments.

   This number of documents attribute's value and object's
   value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this number of
            documents attribute, false otherwise. - `boolean`"
  (^Boolean [^NumberOfDocuments this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class NumberOfDocuments, the
   category is class NumberOfDocuments itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^NumberOfDocuments this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class NumberOfDocuments, the
   category name is `number-of-documents`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^NumberOfDocuments this]
    (-> this (.getName))))

