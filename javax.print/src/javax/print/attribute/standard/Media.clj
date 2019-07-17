(ns javax.print.attribute.standard.Media
  "Class Media is a printing attribute class that specifies the
  medium on which to print.

  Media may be specified in different ways.

   it may be specified by paper source - eg paper tray
   it may be specified by a standard size - eg `A4`
   it may be specified by a name - eg `letterhead`

  Each of these corresponds to the IPP `media` attribute.
  The current API does not support describing media by characteristics
  (eg colour, opacity).
  This may be supported in a later revision of the specification.

  A Media object is constructed with a value which represents
  one of the ways in which the Media attribute can be specified.

  IPP Compatibility:  The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Media]))

(defn equals
  "Returns whether this media attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is of the same subclass of Media as this object.

   The values are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this media
            attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.Media this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Media and any vendor-defined subclasses, the category is
   class Media itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.Media this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Media and any vendor-defined subclasses, the category name is
   `media`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.Media this]
    (-> this (.getName))))

