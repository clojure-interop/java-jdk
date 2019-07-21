(ns jdk.text.AttributedCharacterIterator$Attribute
  "Defines attribute keys that are used to identify text attributes. These
  keys are used in AttributedCharacterIterator and AttributedString."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text AttributedCharacterIterator$Attribute]))

(def *-language
  "Static Constant.

  Attribute key for the language of some text.
    Values are instances of Locale.

  type: java.text.AttributedCharacterIterator$Attribute"
  AttributedCharacterIterator$Attribute/LANGUAGE)

(def *-reading
  "Static Constant.

  Attribute key for the reading of some text. In languages where the written form
   and the pronunciation of a word are only loosely related (such as Japanese),
   it is often necessary to store the reading (pronunciation) along with the
   written form.
   Values are instances of Annotation holding instances of String.

  type: java.text.AttributedCharacterIterator$Attribute"
  AttributedCharacterIterator$Attribute/READING)

(def *-input-method-segment
  "Static Constant.

  Attribute key for input method segments. Input methods often break
   up text into segments, which usually correspond to words.
   Values are instances of Annotation holding a null reference.

  type: java.text.AttributedCharacterIterator$Attribute"
  AttributedCharacterIterator$Attribute/INPUT_METHOD_SEGMENT)

(defn equals
  "Compares two objects for equality. This version only returns true
   for x.equals(y) if x and y refer
   to the same object, and guarantees this for all subclasses.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^AttributedCharacterIterator$Attribute this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for the object. This version is identical to
   the one in Object, but is also final.

  returns: a hash code value for this object. - `int`"
  (^Integer [^AttributedCharacterIterator$Attribute this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of the object. This version returns the
   concatenation of class name, \"(\", a name identifying the attribute
   and \")\".

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^AttributedCharacterIterator$Attribute this]
    (-> this (.toString))))

