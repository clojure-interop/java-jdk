(ns javax.print.attribute.standard.PrinterInfo
  "Class PrinterInfo is a printing attribute class, a text attribute, that
  provides descriptive information about a printer. This could include things
  like: `This printer can be used for printing color transparencies for
  HR presentations`, or `Out of courtesy for others, please
  print only small (1-5 page) jobs at this printer`, or even \
  `This printer is going away on July 1, 1997, please find a new
  printer`.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterInfo]))

(defn ->printer-info
  "Constructor.

  Constructs a new printer info attribute with the given information
   string and locale.

  info - Printer information string. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if info is null."
  (^PrinterInfo [^java.lang.String info ^java.util.Locale locale]
    (new PrinterInfo info locale)))

(defn equals
  "Returns whether this printer info attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class PrinterInfo.

   This printer info attribute's underlying string and
   object's underlying string are equal.

   This printer info attribute's locale and object's
   locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            info attribute, false otherwise. - `boolean`"
  (^Boolean [^PrinterInfo this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterInfo, the category is class PrinterInfo itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterInfo this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterInfo, the category name is `printer-info`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterInfo this]
    (-> this (.getName))))

