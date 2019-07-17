(ns javax.print.attribute.standard.Compression
  "Class Compression is a printing attribute class, an enumeration, that
  specifies how print data is compressed. Compression is an attribute of the
  print data (the doc), not of the Print Job. If a Compression attribute is not
  specified for a doc, the printer assumes the doc's print data is uncompressed
  (i.e., the default Compression value is always NONE).

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Compression]))

(def *-none
  "Static Constant.

  No compression is used.

  type: javax.print.attribute.standard.Compression"
  Compression/NONE)

(def *-deflate
  "Static Constant.

  ZIP public domain inflate/deflate compression technology.

  type: javax.print.attribute.standard.Compression"
  Compression/DEFLATE)

(def *-gzip
  "Static Constant.

  GNU zip compression technology described in
   RFC 1952.

  type: javax.print.attribute.standard.Compression"
  Compression/GZIP)

(def *-compress
  "Static Constant.

  UNIX compression technology.

  type: javax.print.attribute.standard.Compression"
  Compression/COMPRESS)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Compression and any vendor-defined subclasses, the category is
   class Compression itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.Compression this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Compression and any vendor-defined subclasses, the category
   name is `compression`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.Compression this]
    (-> this (.getName))))

