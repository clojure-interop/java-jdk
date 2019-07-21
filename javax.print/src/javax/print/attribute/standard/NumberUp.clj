(ns javax.print.attribute.standard.NumberUp
  "Class NumberUp is an integer valued printing attribute class that specifies
  the number of print-stream pages to impose upon a single side of an
  instance of a selected medium. That is, if the NumberUp value is n,
  the printer must place n print-stream pages on a single side of
  an instance of the
  selected medium. To accomplish this, the printer may add some sort of
  translation, scaling, or rotation. This attribute primarily controls the
  translation, scaling and rotation of print-stream pages.

  The effect of a NumberUp attribute on a multidoc print job (a job with
  multiple documents) depends on whether all the docs have the same number up
  values specified or whether different docs have different number up values
  specified, and on the (perhaps defaulted) value of the MultipleDocumentHandling attribute.


  If all the docs have the same number up value n specified, then any
  value of MultipleDocumentHandling makes
  sense, and the printer's processing depends on the MultipleDocumentHandling value:


  SINGLE_DOCUMENT -- All the input docs will be combined together into one
  output document. Each media impression will consist of nm
   print-stream pages from the output document.


  SINGLE_DOCUMENT_NEW_SHEET -- All the input docs will be combined together
  into one output document. Each media impression will consist of n
  print-stream pages from the output document. However, the first impression of
  each input doc will always start on a new media sheet; this means the last
  impression of an input doc may have fewer than n print-stream pages
   on it.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- The input docs will remain separate.
  Each media impression will consist of n print-stream pages from the
  input doc. Since the input docs are separate, the first impression of each
  input doc will always start on a new media sheet; this means the last
  impression of an input doc may have fewer than n print-stream pages on
  it.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- The input docs will remain separate.
  Each media impression will consist of n print-stream pages from the
  input doc. Since the input docs are separate, the first impression of each
  input doc will always start on a new media sheet; this means the last
  impression of an input doc may have fewer than n print-stream pages
  on it.



  SINGLE_DOCUMENT -- All the input docs will be combined together into one
  output document. Each media impression will consist of ni
  print-stream pages from the output document, where i is the number of
  the input doc corresponding to that point in the output document. When the
  next input doc has a different number up value from the previous input doc,
  the first print-stream page of the next input doc goes at the start of the
  next media impression, possibly leaving fewer than the full number of
  print-stream pages on the previous media impression.


  SINGLE_DOCUMENT_NEW_SHEET -- All the input docs will be combined together
  into one output document. Each media impression will consist of n
  print-stream pages from the output document. However, the first impression of
  each input doc will always start on a new media sheet; this means the last
  impression of an input doc may have fewer than n print-stream pages
  on it.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- The input docs will remain separate.
  For input doc i, each media impression will consist of
  ni print-stream pages from the input doc. Since the input
  docs are separate, the first impression of each input doc will always start
  on a new media sheet; this means the last impression of an input doc may have
  fewer than ni print-stream pages on it.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- The input docs will remain separate.
  For input doc i, each media impression will consist of
  ni print-stream pages from the input doc. Since the input
  docs are separate, the first impression of each input doc will always start
  on a new media sheet; this means the last impression of an input doc may
  have fewer than ni print-stream pages on it.


  IPP Compatibility: The integer value gives the IPP integer value.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard NumberUp]))

(defn ->number-up
  "Constructor.

  Construct a new number up attribute with the given integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 1."
  (^NumberUp [^Integer value]
    (new NumberUp value)))

(defn equals
  "Returns whether this number up attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class NumberUp.

   This number up attribute's value and object's value are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this number up
            attribute, false otherwise. - `boolean`"
  (^Boolean [^NumberUp this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class NumberUp, the category is class NumberUp itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^NumberUp this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class NumberUp, the category name is \"number-up\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^NumberUp this]
    (-> this (.getName))))

