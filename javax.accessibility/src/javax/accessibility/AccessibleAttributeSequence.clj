(ns javax.accessibility.AccessibleAttributeSequence
  "This class collects together the span of text that share the same
  contiguous set of attributes, along with that set of attributes.  It
  is used by implementors of the class AccessibleContext in
  order to generate ACCESSIBLE_TEXT_ATTRIBUTES_CHANGED events."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleAttributeSequence]))

(defn ->accessible-attribute-sequence
  "Constructor.

  Constructs an AccessibleAttributeSequence with the given
   parameters.

  start - the beginning index of the span of text - `int`
  end - the ending index of the span of text - `int`
  attr - the AttributeSet shared by this text span - `javax.swing.text.AttributeSet`"
  ([start end attr]
    (new AccessibleAttributeSequence start end attr)))

(defn -start-index
  "Instance Field.

  The start index of the text sequence

  type: int"
  [this]
  (-> this .-startIndex))

(defn -end-index
  "Instance Field.

  The end index of the text sequence

  type: int"
  [this]
  (-> this .-endIndex))

(defn -attributes
  "Instance Field.

  The text attributes

  type: javax.swing.text.AttributeSet"
  [this]
  (-> this .-attributes))

