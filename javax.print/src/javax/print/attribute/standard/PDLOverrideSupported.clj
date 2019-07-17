(ns javax.print.attribute.standard.PDLOverrideSupported
  "Class PDLOverrideSupported is a printing attribute class, an enumeration,
  that expresses the printer's ability to attempt to override processing
  instructions embedded in documents' print data with processing instructions
  specified as attributes outside the print data.

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PDLOverrideSupported]))

(def *-not-attempted
  "Static Constant.

  The printer makes no attempt to make the external job attribute values
   take precedence over embedded instructions in the documents' print
   data.

  type: javax.print.attribute.standard.PDLOverrideSupported"
  PDLOverrideSupported/NOT_ATTEMPTED)

(def *-attempted
  "Static Constant.

  The printer attempts to make the external job attribute values take
   precedence over embedded instructions in the documents' print data,
   however there is no guarantee.

  type: javax.print.attribute.standard.PDLOverrideSupported"
  PDLOverrideSupported/ATTEMPTED)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PDLOverrideSupported and any vendor-defined subclasses, the
   category is class PDLOverrideSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PDLOverrideSupported and any vendor-defined subclasses, the
   category name is `pdl-override-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

