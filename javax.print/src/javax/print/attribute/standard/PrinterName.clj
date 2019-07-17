(ns javax.print.attribute.standard.PrinterName
  "Class PrinterName is a printing attribute class, a text attribute, that
  specifies the name of a printer. It is a name that is more end-user friendly
  than a URI. An administrator determines a printer's name and sets this
  attribute to that name. This name may be the last part of the printer's URI
  or it may be unrelated. In non-US-English locales, a name may contain
  characters that are not allowed in a URI.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterName]))

(defn ->printer-name
  "Constructor.

  Constructs a new printer name attribute with the given name and locale.

  printer-name - Printer name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if printerName is null."
  ([^java.lang.String printer-name ^java.util.Locale locale]
    (new PrinterName printer-name locale)))

(defn equals
  "Returns whether this printer name attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class PrinterName.

   This printer name attribute's underlying string and
   object's underlying string are equal.

   This printer name attribute's locale and object's locale
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            name attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.PrinterName this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterName, the category is
   class PrinterName itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.PrinterName this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterName, the category
   name is `printer-name`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.PrinterName this]
    (-> this (.getName))))

