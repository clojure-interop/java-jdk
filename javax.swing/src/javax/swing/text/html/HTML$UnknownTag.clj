(ns javax.swing.text.html.HTML$UnknownTag
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTML$UnknownTag]))

(defn ->unknown-tag
  "Constructor.

  Creates a new UnknownTag with the specified
   id.

  id - the id of the new tag - `java.lang.String`"
  (^HTML$UnknownTag [^java.lang.String id]
    (new HTML$UnknownTag id)))

(defn hash-code
  "Returns the hash code which corresponds to the string
   for this tag.

  returns: a hash code value for this object. - `int`"
  (^Integer [^HTML$UnknownTag this]
    (-> this (.hashCode))))

(defn equals
  "Compares this object to the specified object.
   The result is true if and only if the argument is not
   null and is an UnknownTag object
   with the same name.

  obj - the object to compare this tag with - `java.lang.Object`

  returns: true if the objects are equal;
              false otherwise - `boolean`"
  (^Boolean [^HTML$UnknownTag this ^java.lang.Object obj]
    (-> this (.equals obj))))

