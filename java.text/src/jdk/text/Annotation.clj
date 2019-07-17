(ns jdk.text.Annotation
  "An Annotation object is used as a wrapper for a text attribute value if
  the attribute has annotation characteristics. These characteristics are:

  The text range that the attribute is applied to is critical to the
  semantics of the range. That means, the attribute cannot be applied to subranges
  of the text range that it applies to, and, if two adjacent text ranges have
  the same value for this attribute, the attribute still cannot be applied to
  the combined range as a whole with this value.
  The attribute or its value usually do no longer apply if the underlying text is
  changed.


  An example is grammatical information attached to a sentence:
  For the previous sentence, you can say that `an example`
  is the subject, but you cannot say the same about `an`, `example`, or `exam`.
  When the text is changed, the grammatical information typically becomes invalid.
  Another example is Japanese reading information (yomi).


  Wrapping the attribute value into an Annotation object guarantees that
  adjacent text runs don't get merged even if the attribute values are equal,
  and indicates to text containers that the attribute should be discarded if
  the underlying text is modified."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text Annotation]))

(defn ->annotation
  "Constructor.

  Constructs an annotation record with the given value, which
   may be null.

  value - the value of the attribute - `java.lang.Object`"
  ([^java.lang.Object value]
    (new Annotation value)))

(defn get-value
  "Returns the value of the attribute, which may be null.

  returns: the value of the attribute - `java.lang.Object`"
  (^java.lang.Object [^java.text.Annotation this]
    (-> this (.getValue))))

(defn to-string
  "Returns the String representation of this Annotation.

  returns: the String representation of this Annotation - `java.lang.String`"
  (^java.lang.String [^java.text.Annotation this]
    (-> this (.toString))))

