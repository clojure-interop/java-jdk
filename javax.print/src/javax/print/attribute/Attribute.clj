(ns javax.print.attribute.Attribute
  "Interface Attribute is the base interface implemented by any and every
  printing attribute class to indicate that the class represents a
  printing attribute. All printing attributes are serializable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute Attribute]))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value when it is added to an attribute set.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.Attribute this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   Note: This method is intended to provide a default, nonlocalized
   string for the attribute's category. If two attribute objects return the
   same category from the getCategory() method, they should
   return the same name from the getName() method.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.Attribute this]
    (-> this (.getName))))

