(ns javax.print.attribute.standard.PrinterLocation
  "Class PrinterLocation is a printing attribute class, a text attribute, that
  identifies the location of the device. This could include things like:
  `in Room 123A, second floor of building XYZ`.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterLocation]))

(defn ->printer-location
  "Constructor.

  Constructs a new printer location attribute with the given location and
   locale.

  location - Printer location. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if location is null."
  ([location locale]
    (new PrinterLocation location locale)))

(defn equals
  "Returns whether this printer location attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class PrinterLocation.

   This printer location attribute's underlying string and
   object's underlying string are equal.

   This printer location attribute's locale and object's
   locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            location attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterLocation, the
   category is class PrinterLocation itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterLocation, the
   category name is `printer-location`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

