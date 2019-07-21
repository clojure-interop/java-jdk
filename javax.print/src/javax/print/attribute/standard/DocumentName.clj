(ns javax.print.attribute.standard.DocumentName
  "Class DocumentName is a printing attribute class, a text attribute, that
  specifies the name of a document. DocumentName is an attribute of the print
  data (the doc), not of the Print Job. A document's name is an arbitrary
  string defined by the client.
  However if a JobName is not specified, the DocumentName should be used
  instead, which implies that supporting specification of DocumentName
  requires reporting of JobName and vice versa.
  See JobName for more information.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard DocumentName]))

(defn ->document-name
  "Constructor.

  Constructs a new document name attribute with the given document name
   and locale.

  document-name - Document name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if documentName is null."
  (^DocumentName [^java.lang.String document-name ^java.util.Locale locale]
    (new DocumentName document-name locale)))

(defn equals
  "Returns whether this document name attribute is equivalent to the
   passed in object.
   To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class DocumentName.

   This document name attribute's underlying string and
   object's underlying string are equal.

   This document name attribute's locale and object's locale
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this document
            name attribute, false otherwise. - `boolean`"
  (^Boolean [^DocumentName this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class DocumentName, the category is class DocumentName itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^DocumentName this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class DocumentName, the category name is \"document-name\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^DocumentName this]
    (-> this (.getName))))

