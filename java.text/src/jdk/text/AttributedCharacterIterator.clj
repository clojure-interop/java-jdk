(ns jdk.text.AttributedCharacterIterator
  "An AttributedCharacterIterator allows iteration through both text and
  related attribute information.


  An attribute is a key/value pair, identified by the key.  No two
  attributes on a given character can have the same key.

  The values for an attribute are immutable, or must not be mutated
  by clients or storage.  They are always passed by reference, and not
  cloned.

  A run with respect to an attribute is a maximum text range for
  which:

  the attribute is undefined or null for the entire range, or
  the attribute value is defined and has the same non-null value for the
      entire range.


  A run with respect to a set of attributes is a maximum text range for
  which this condition is met for each member attribute.

  When getting a run with no explicit attributes specified (i.e.,
  calling getRunStart() and getRunLimit()), any
  contiguous text segments having the same attributes (the same set
  of attribute/value pairs) are treated as separate runs if the
  attributes have been given to those text segments separately.

  The returned indexes are limited to the range of the iterator.

  The returned attribute information is limited to runs that contain
  the current character.


  Attribute keys are instances of AttributedCharacterIterator.Attribute and its
  subclasses, such as TextAttribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text AttributedCharacterIterator]))

(defn get-run-start
  "Returns the index of the first character of the run
   with respect to the given attribute containing the current character.

  attribute - the desired attribute. - `java.text.AttributedCharacterIterator.Attribute`

  returns: the index of the first character of the run - `int`"
  (^Integer [^java.text.AttributedCharacterIterator this ^java.text.AttributedCharacterIterator.Attribute attribute]
    (-> this (.getRunStart attribute)))
  (^Integer [^java.text.AttributedCharacterIterator this]
    (-> this (.getRunStart))))

(defn get-run-limit
  "Returns the index of the first character following the run
   with respect to the given attribute containing the current character.

  attribute - the desired attribute - `java.text.AttributedCharacterIterator.Attribute`

  returns: the index of the first character following the run - `int`"
  (^Integer [^java.text.AttributedCharacterIterator this ^java.text.AttributedCharacterIterator.Attribute attribute]
    (-> this (.getRunLimit attribute)))
  (^Integer [^java.text.AttributedCharacterIterator this]
    (-> this (.getRunLimit))))

(defn get-attributes
  "Returns a map with the attributes defined on the current
   character.

  returns: a map with the attributes defined on the current character - `java.util.Map<java.text.AttributedCharacterIterator.Attribute,java.lang.Object>`"
  (^java.util.Map [^java.text.AttributedCharacterIterator this]
    (-> this (.getAttributes))))

(defn get-attribute
  "Returns the value of the named attribute for the current character.
   Returns null if the attribute is not defined.

  attribute - the desired attribute - `java.text.AttributedCharacterIterator.Attribute`

  returns: the value of the named attribute or null - `java.lang.Object`"
  (^java.lang.Object [^java.text.AttributedCharacterIterator this ^java.text.AttributedCharacterIterator.Attribute attribute]
    (-> this (.getAttribute attribute))))

(defn get-all-attribute-keys
  "Returns the keys of all attributes defined on the
   iterator's text range. The set is empty if no
   attributes are defined.

  returns: the keys of all attributes - `java.util.Set<java.text.AttributedCharacterIterator.Attribute>`"
  (^java.util.Set [^java.text.AttributedCharacterIterator this]
    (-> this (.getAllAttributeKeys))))

