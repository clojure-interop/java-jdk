(ns javax.print.attribute.HashPrintRequestAttributeSet
  "Class HashPrintRequestAttributeSet inherits its implementation from
  class HashAttributeSet and enforces the
  semantic restrictions of interface
  PrintRequestAttributeSet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute HashPrintRequestAttributeSet]))

(defn ->hash-print-request-attribute-set
  "Constructor.

  Construct a new print request attribute set,
   initially populated with the given value.

  attribute - Attribute value to add to the set. - `javax.print.attribute.PrintRequestAttribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if attribute is null."
  ([attribute]
    (new HashPrintRequestAttributeSet attribute))
  ([]
    (new HashPrintRequestAttributeSet )))

