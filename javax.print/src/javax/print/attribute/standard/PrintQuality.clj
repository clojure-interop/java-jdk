(ns javax.print.attribute.standard.PrintQuality
  "Class PrintQuality is a printing attribute class, an enumeration,
  that specifies the print quality that the printer uses for the job.

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrintQuality]))

(def *-draft
  "Static Constant.

  Lowest quality available on the printer.

  type: javax.print.attribute.standard.PrintQuality"
  PrintQuality/DRAFT)

(def *-normal
  "Static Constant.

  Normal or intermediate quality on the printer.

  type: javax.print.attribute.standard.PrintQuality"
  PrintQuality/NORMAL)

(def *-high
  "Static Constant.

  Highest quality available on the printer.

  type: javax.print.attribute.standard.PrintQuality"
  PrintQuality/HIGH)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrintQuality and any vendor-defined subclasses, the category is
   class PrintQuality itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.PrintQuality this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrintQuality and any vendor-defined subclasses, the category
   name is `print-quality`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.PrintQuality this]
    (-> this (.getName))))

