(ns jdk.text.FieldPosition
  "FieldPosition is a simple class used by Format
  and its subclasses to identify fields in formatted output. Fields can
  be identified in two ways:

   By an integer constant, whose names typically end with
       _FIELD. The constants are defined in the various
       subclasses of Format.
   By a Format.Field constant, see ERA_FIELD
       and its friends in DateFormat for an example.


  FieldPosition keeps track of the position of the
  field within the formatted output with two indices: the index
  of the first character of the field and the index of the last
  character of the field.


  One version of the format method in the various
  Format classes requires a FieldPosition
  object as an argument. You use this format method
  to perform partial formatting or to get information about the
  formatted output (such as the position of a field).


  If you are interested in the positions of all attributes in the
  formatted string use the Format method
  formatToCharacterIterator."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text FieldPosition]))

(defn ->field-position
  "Constructor.

  Creates a FieldPosition object for the given field.
   The field is identified by an attribute constant from one of the
   Field subclasses as well as an integer field ID
   defined by the Format subclasses. Format
   subclasses that are aware of Field should give precedence
   to attribute and ignore fieldID if
   attribute is not null. However, older Format
   subclasses may not be aware of Field and rely on
   fieldID. If the field has no corresponding integer
   constant, fieldID should be -1.

  attribute - Format.Field constant identifying a field - `java.text.Format$Field`
  field-id - integer constant identifying a field - `int`"
  (^FieldPosition [^java.text.Format$Field attribute ^Integer field-id]
    (new FieldPosition attribute field-id))
  (^FieldPosition [^Integer field]
    (new FieldPosition field)))

(defn set-end-index
  "Sets the end index.  For use by subclasses of Format.

  ei - the end index - `int`"
  ([^FieldPosition this ^Integer ei]
    (-> this (.setEndIndex ei))))

(defn get-end-index
  "Retrieves the index of the character following the last character in the
   requested field.

  returns: the end index - `int`"
  (^Integer [^FieldPosition this]
    (-> this (.getEndIndex))))

(defn to-string
  "Return a string representation of this FieldPosition.

  returns: a string representation of this object - `java.lang.String`"
  (^java.lang.String [^FieldPosition this]
    (-> this (.toString))))

(defn set-begin-index
  "Sets the begin index.  For use by subclasses of Format.

  bi - the begin index - `int`"
  ([^FieldPosition this ^Integer bi]
    (-> this (.setBeginIndex bi))))

(defn get-begin-index
  "Retrieves the index of the first character in the requested field.

  returns: the begin index - `int`"
  (^Integer [^FieldPosition this]
    (-> this (.getBeginIndex))))

(defn get-field
  "Retrieves the field identifier.

  returns: the field identifier - `int`"
  (^Integer [^FieldPosition this]
    (-> this (.getField))))

(defn get-field-attribute
  "Returns the field identifier as an attribute constant
   from one of the Field subclasses. May return null if
   the field is specified only by an integer field ID.

  returns: Identifier for the field - `java.text.Format$Field`"
  (^java.text.Format$Field [^FieldPosition this]
    (-> this (.getFieldAttribute))))

(defn hash-code
  "Returns a hash code for this FieldPosition.

  returns: a hash code value for this object - `int`"
  (^Integer [^FieldPosition this]
    (-> this (.hashCode))))

(defn equals
  "Overrides equals

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^FieldPosition this ^java.lang.Object obj]
    (-> this (.equals obj))))

