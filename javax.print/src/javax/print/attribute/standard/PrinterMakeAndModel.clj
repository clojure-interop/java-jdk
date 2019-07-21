(ns javax.print.attribute.standard.PrinterMakeAndModel
  "Class PrinterMakeAndModel is a printing attribute class, a text attribute,
  that the make and model of the printer.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterMakeAndModel]))

(defn ->printer-make-and-model
  "Constructor.

  Constructs a new printer make and model attribute with the given make
   and model string and locale.

  make-and-model - Printer make and model string. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if makeAndModel is null."
  (^PrinterMakeAndModel [^java.lang.String make-and-model ^java.util.Locale locale]
    (new PrinterMakeAndModel make-and-model locale)))

(defn equals
  "Returns whether this printer make and model attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class PrinterMakeAndModel.

   This printer make and model attribute's underlying string and
   object's underlying string are equal.

   This printer make and model attribute's locale and
   object's locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            make and model attribute, false otherwise. - `boolean`"
  (^Boolean [^PrinterMakeAndModel this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class PrinterMakeAndModel, the
   category is class PrinterMakeAndModel itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterMakeAndModel this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterMakeAndModel, the
   category name is \"printer-make-and-model\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterMakeAndModel this]
    (-> this (.getName))))

