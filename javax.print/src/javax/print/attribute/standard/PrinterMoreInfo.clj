(ns javax.print.attribute.standard.PrinterMoreInfo
  "Class PrinterMoreInfo is a printing attribute class, a URI, that is used to
  obtain more information about this specific printer. For example, this
  could be an HTTP type URI referencing an HTML page accessible to a web
  browser. The information obtained from this URI is intended for end user
  consumption. Features outside the scope of the Print Service API can be
  accessed from this URI.
  The information is intended to be specific to this printer instance and
  site specific services (e.g. job pricing, services offered, end user
  assistance).

  In contrast, the PrinterMoreInfoManufacturer attribute is used to find out more information
  about this general kind of printer rather than this specific printer.

  IPP Compatibility: The string form returned by
  toString()  gives the IPP uri value.
  The category name returned by getName()
  gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterMoreInfo]))

(defn ->printer-more-info
  "Constructor.

  Constructs a new printer more info attribute with the specified URI.

  uri - URI. - `java.net.URI`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if uri is null."
  ([^java.net.URI uri]
    (new PrinterMoreInfo uri)))

(defn equals
  "Returns whether this printer more info attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class PrinterMoreInfo.

   This printer more info attribute's URI and object's URI
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            more info attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.PrinterMoreInfo this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterMoreInfo, the category is class PrinterMoreInfo itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.PrinterMoreInfo this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterMoreInfo, the
   category name is `printer-more-info`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.PrinterMoreInfo this]
    (-> this (.getName))))

