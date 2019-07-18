(ns javax.print.attribute.standard.Chromaticity
  "Class Chromaticity is a printing attribute class, an enumeration, that
  specifies monochrome or color printing. This is used by a print client
  to specify how the print data should be generated or processed. It is not
  descriptive of the color capabilities of the device. Query the service's
  ColorSupported attribute to determine if the device
  can be verified to support color printing.

  The table below shows the effects of specifying a Chromaticity attribute of
  MONOCHROME or COLOR
  for a monochrome or color document.




  ChromaticityAttribute


  Effect onMonochrome Document


  Effect onColor Document




  MONOCHROME


  Printed as is, in monochrome


  Printed in monochrome, with colors converted to shades of gray




  COLOR


  Printed as is, in monochrome


  Printed as is, in color





  IPP Compatibility: Chromaticity is not an IPP attribute at present."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Chromaticity]))

(def *-monochrome
  "Static Constant.

  Monochrome printing.

  type: javax.print.attribute.standard.Chromaticity"
  Chromaticity/MONOCHROME)

(def *-color
  "Static Constant.

  Color printing.

  type: javax.print.attribute.standard.Chromaticity"
  Chromaticity/COLOR)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Chromaticity, the category is the class Chromaticity itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^Chromaticity this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Chromaticity, the category name is `chromaticity`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^Chromaticity this]
    (-> this (.getName))))

