(ns javax.print.attribute.standard.PrinterURI
  "Class PrinterURI is a printing attribute class, a URI, that specifies the
  globally unique name of a printer.  If it has such a name, an administrator
  determines a printer's URI and sets this attribute to that name.

  IPP Compatibility:  This implements the
  IPP printer-uri attribute. The string form returned by
  toString()  gives the IPP printer-uri value.
  The category name returned by getName()
  gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterURI]))

(defn ->printer-uri
  "Constructor.

  Constructs a new PrinterURI attribute with the specified URI.

  uri - URI of the printer - `java.net.URI`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if uri is null."
  ([^java.net.URI uri]
    (new PrinterURI uri)))

(defn equals
  "Returns whether this printer name attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class PrinterURI.

   This PrinterURI attribute's underlying URI and
   object's underlying URI are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this PrinterURI
            attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.PrinterURI this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterURI and any vendor-defined subclasses, the category is
   class PrinterURI itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.PrinterURI this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterURI and any vendor-defined subclasses, the category
   name is `printer-uri`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.PrinterURI this]
    (-> this (.getName))))

