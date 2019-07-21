(ns javax.print.attribute.standard.Copies
  "Class Copies is an integer valued printing attribute class that specifies the
  number of copies to be printed.

  On many devices the supported number of collated copies will be limited by
  the number of physical output bins on the device, and may be different from
  the number of uncollated copies which can be supported.

  The effect of a Copies attribute with a value of n on a multidoc print
  job (a job with multiple documents) depends on the (perhaps defaulted) value
  of the MultipleDocumentHandling attribute:


  SINGLE_DOCUMENT -- The result will be n copies of a single output
  document comprising all the input docs.


  SINGLE_DOCUMENT_NEW_SHEET -- The result will be n copies of a single
  output document comprising all the input docs, and the first impression of
  each input doc will always start on a new media sheet.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- The result will be n copies of
  the first input document, followed by n copies of the second input
  document, . . . followed by n copies of the last input document.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- The result will be the first input
  document, the second input document, . . . the last input document, the group
  of documents being repeated n times.


  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Copies]))

(defn ->copies
  "Constructor.

  Construct a new copies attribute with the given integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 1."
  (^Copies [^Integer value]
    (new Copies value)))

(defn equals
  "Returns whether this copies attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class Copies.

   This copies attribute's value and object's value are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this copies
            attribute, false otherwise. - `boolean`"
  (^Boolean [^Copies this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class Copies, the category is class Copies itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^Copies this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Copies, the category name is \"copies\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^Copies this]
    (-> this (.getName))))

