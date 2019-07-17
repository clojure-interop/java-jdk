(ns javax.print.attribute.HashPrintJobAttributeSet
  "Class HashPrintJobAttributeSet provides an attribute set
  which inherits its implementation from class HashAttributeSet and enforces the semantic restrictions of interface
  PrintJobAttributeSet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute HashPrintJobAttributeSet]))

(defn ->hash-print-job-attribute-set
  "Constructor.

  Construct a new hash print job attribute set,
   initially populated with the given value.

  attribute - Attribute value to add to the set. - `javax.print.attribute.PrintJobAttribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if attribute is null."
  ([^javax.print.attribute.PrintJobAttribute attribute]
    (new HashPrintJobAttributeSet attribute))
  ([]
    (new HashPrintJobAttributeSet )))

