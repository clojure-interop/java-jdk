(ns javax.print.attribute.HashDocAttributeSet
  "Class HashDocAttributeSet provides an attribute set which
  inherits its implementation from class HashAttributeSet and enforces the semantic restrictions of interface DocAttributeSet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute HashDocAttributeSet]))

(defn ->hash-doc-attribute-set
  "Constructor.

  Construct a new hash doc attribute set,
   initially populated with the given value.

  attribute - Attribute value to add to the set. - `javax.print.attribute.DocAttribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if attribute is null."
  (^HashDocAttributeSet [^javax.print.attribute.DocAttribute attribute]
    (new HashDocAttributeSet attribute))
  (^HashDocAttributeSet []
    (new HashDocAttributeSet )))

