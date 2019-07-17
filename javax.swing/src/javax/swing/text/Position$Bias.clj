(ns javax.swing.text.Position$Bias
  "A typesafe enumeration to indicate bias to a position
  in the model.  A position indicates a location between
  two characters.  The bias can be used to indicate an
  interest toward one of the two sides of the position
  in boundary conditions where a simple offset is
  ambiguous."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Position$Bias]))

(def *-forward
  "Static Constant.

  Indicates to bias toward the next character
   in the model.

  type: javax.swing.text.Position.Bias"
  Position$Bias/Forward)

(def *-backward
  "Static Constant.

  Indicates a bias toward the previous character
   in the model.

  type: javax.swing.text.Position.Bias"
  Position$Bias/Backward)

(defn to-string
  "string representation

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.swing.text.Position$Bias this]
    (-> this (.toString))))

