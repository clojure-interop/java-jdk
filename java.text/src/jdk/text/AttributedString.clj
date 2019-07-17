(ns jdk.text.AttributedString
  "An AttributedString holds text and related attribute information. It
  may be used as the actual data storage in some cases where a text
  reader wants to access attributed text through the AttributedCharacterIterator
  interface.


  An attribute is a key/value pair, identified by the key.  No two
  attributes on a given character can have the same key.

  The values for an attribute are immutable, or must not be mutated
  by clients or storage.  They are always passed by reference, and not
  cloned."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text AttributedString]))

(defn ->attributed-string
  "Constructor.

  Constructs an AttributedString instance with the subrange of
   the given attributed text represented by
   AttributedCharacterIterator.  Only attributes that match the
   given attributes will be incorporated into the instance. If the
   given range produces an empty text, all attributes will be
   discarded. Note that any attributes wrapped by an Annotation
   object are discarded for a subrange of the original attribute
   range.

  text - The text for this attributed string. - `java.text.AttributedCharacterIterator`
  begin-index - Index of the first character of the range. - `int`
  end-index - Index of the character following the last character of the range. - `int`
  attributes - Specifies attributes to be extracted from the text. If null is specified, all available attributes will be used. - `java.text.AttributedCharacterIterator.Attribute[]`

  throws: java.lang.NullPointerException - if text is null."
  ([^java.text.AttributedCharacterIterator text ^Integer begin-index ^Integer end-index ^java.text.AttributedCharacterIterator.Attribute[] attributes]
    (new AttributedString text begin-index end-index attributes))
  ([^java.text.AttributedCharacterIterator text ^Integer begin-index ^Integer end-index]
    (new AttributedString text begin-index end-index))
  ([^java.lang.String text ^java.text.AttributedCharacterIterator.Attribute,?> attributes]
    (new AttributedString text attributes))
  ([^java.lang.String text]
    (new AttributedString text)))

(defn add-attribute
  "Adds an attribute to a subrange of the string.

  attribute - the attribute key - `java.text.AttributedCharacterIterator.Attribute`
  value - The value of the attribute. May be null. - `java.lang.Object`
  begin-index - Index of the first character of the range. - `int`
  end-index - Index of the character following the last character of the range. - `int`

  throws: java.lang.NullPointerException - if attribute is null."
  ([^java.text.AttributedString this ^java.text.AttributedCharacterIterator.Attribute attribute ^java.lang.Object value ^Integer begin-index ^Integer end-index]
    (-> this (.addAttribute attribute value begin-index end-index)))
  ([^java.text.AttributedString this ^java.text.AttributedCharacterIterator.Attribute attribute ^java.lang.Object value]
    (-> this (.addAttribute attribute value))))

(defn add-attributes
  "Adds a set of attributes to a subrange of the string.

  attributes - The attributes to be added to the string. - `java.text.AttributedCharacterIterator.Attribute,?>`
  begin-index - Index of the first character of the range. - `int`
  end-index - Index of the character following the last character of the range. - `int`

  throws: java.lang.NullPointerException - if attributes is null."
  ([^java.text.AttributedString this ^java.text.AttributedCharacterIterator.Attribute,?> attributes ^Integer begin-index ^Integer end-index]
    (-> this (.addAttributes attributes begin-index end-index))))

(defn get-iterator
  "Creates an AttributedCharacterIterator instance that provides access to
   selected contents of this string.
   Information about attributes not listed in attributes that the
   implementor may have need not be made accessible through the iterator.
   If the list is null, all available attribute information should be made
   accessible.

  attributes - a list of attributes that the client is interested in - `java.text.AttributedCharacterIterator.Attribute[]`
  begin-index - the index of the first character - `int`
  end-index - the index of the character following the last character - `int`

  returns: an iterator providing access to the text and its attributes - `java.text.AttributedCharacterIterator`

  throws: java.lang.IllegalArgumentException - if beginIndex is less then 0, endIndex is greater than the length of the string, or beginIndex is greater than endIndex."
  ([^java.text.AttributedString this ^java.text.AttributedCharacterIterator.Attribute[] attributes ^Integer begin-index ^Integer end-index]
    (-> this (.getIterator attributes begin-index end-index)))
  ([^java.text.AttributedString this ^java.text.AttributedCharacterIterator.Attribute[] attributes]
    (-> this (.getIterator attributes)))
  ([^java.text.AttributedString this]
    (-> this (.getIterator))))

