(ns javax.print.attribute.HashPrintServiceAttributeSet
  "Class HashPrintServiceAttributeSet provides an attribute set
  which inherits its implementation from class HashAttributeSet and enforces the semantic restrictions of interface
  PrintServiceAttributeSet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute HashPrintServiceAttributeSet]))

(defn ->hash-print-service-attribute-set
  "Constructor.

  Construct a new hash print service attribute set,
    initially populated with the given value.

  attribute - Attribute value to add to the set. - `javax.print.attribute.PrintServiceAttribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if attribute is null."
  (^HashPrintServiceAttributeSet [^javax.print.attribute.PrintServiceAttribute attribute]
    (new HashPrintServiceAttributeSet attribute))
  (^HashPrintServiceAttributeSet []
    (new HashPrintServiceAttributeSet )))

