(ns javax.accessibility.AccessibleTextSequence
  "This class collects together key details of a span of text.  It
  is used by implementors of the class AccessibleExtendedText in
  order to return the requested triplet of a String, and the
  start and end indicies/offsets into a larger body of text that the
  String comes from."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleTextSequence]))

(defn ->accessible-text-sequence
  "Constructor.

  Constructs an AccessibleTextSequence with the given
   parameters.

  start - the beginning index of the span of text - `int`
  end - the ending index of the span of text - `int`
  txt - the String shared by this text span - `java.lang.String`"
  ([^Integer start ^Integer end ^java.lang.String txt]
    (new AccessibleTextSequence start end txt)))

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

(defn -text
  "Instance Field.

  The text

  type: java.lang.String"
  [this]
  (-> this .-text))

