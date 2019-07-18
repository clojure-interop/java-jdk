(ns javax.print.attribute.standard.PrinterMoreInfoManufacturer
  "Class PrinterMoreInfoManufacturer is a printing attribute class, a URI,
  that is used to obtain more information about this type of device.
  The information obtained from this URI is intended for end user
  consumption. Features outside the scope of the Print Service API
  can be accessed from this URI (e.g.,
  latest firmware, upgrades, service proxies, optional features available,
  details on color support). The information is intended to be germane to
  this kind of printer without regard to site specific modifications or
  services.

  In contrast, the PrinterMoreInfo attribute is used
  to find out more information about this specific printer rather than this
  general kind of printer.


  IPP Compatibility: The string form returned by
  toString() gives the IPP uri value.
  The category name returned by getName()
  gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterMoreInfoManufacturer]))

(defn ->printer-more-info-manufacturer
  "Constructor.

  Constructs a new printer more info manufacturer attribute with the
   specified URI.

  uri - URI. - `java.net.URI`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if uri is null."
  (^PrinterMoreInfoManufacturer [^java.net.URI uri]
    (new PrinterMoreInfoManufacturer uri)))

(defn equals
  "Returns whether this printer more info manufacturer attribute is
   equivalent to the passed in object. To be equivalent, all of the
   following conditions must be true:


   object is not null.

   object is an instance of class
   PrinterMoreInfoManufacturer.

   This printer more info manufacturer attribute's URI and
   object's URI are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            more info manufacturer attribute, false otherwise. - `boolean`"
  (^Boolean [^PrinterMoreInfoManufacturer this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterMoreInfoManufacturer, the category is
   class PrinterMoreInfoManufacturer itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterMoreInfoManufacturer this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterMoreInfoManufacturer, the category name is
   `printer-more-info-manufacturer`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterMoreInfoManufacturer this]
    (-> this (.getName))))

