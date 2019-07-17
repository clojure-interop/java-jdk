(ns javax.xml.crypto.dsig.spec.XPathType$Filter
  "Represents the filter set operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec XPathType$Filter]))

(def *-intersect
  "Static Constant.

  The intersect filter operation.

  type: javax.xml.crypto.dsig.spec.XPathType.Filter"
  XPathType$Filter/INTERSECT)

(def *-subtract
  "Static Constant.

  The subtract filter operation.

  type: javax.xml.crypto.dsig.spec.XPathType.Filter"
  XPathType$Filter/SUBTRACT)

(def *-union
  "Static Constant.

  The union filter operation.

  type: javax.xml.crypto.dsig.spec.XPathType.Filter"
  XPathType$Filter/UNION)

(defn to-string
  "Returns the string form of the operation.

  returns: the string form of the operation - `java.lang.String`"
  ([^javax.xml.crypto.dsig.spec.XPathType$Filter this]
    (-> this (.toString))))

