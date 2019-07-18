(ns javax.activation.MimeType
  "A Multipurpose Internet Mail Extension (MIME) type, as defined
  in RFC 2045 and 2046."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation MimeType]))

(defn ->mime-type
  "Constructor.

  Constructor that builds a MimeType with the given primary and sub type
   but has an empty parameter list.

  primary - the primary MIME type - `java.lang.String`
  sub - the MIME sub-type - `java.lang.String`

  throws: javax.activation.MimeTypeParseException - if the primary type or subtype is not a valid token"
  (^MimeType [^java.lang.String primary ^java.lang.String sub]
    (new MimeType primary sub))
  (^MimeType [^java.lang.String rawdata]
    (new MimeType rawdata))
  (^MimeType []
    (new MimeType )))

(defn set-sub-type
  "Set the subtype for this object to the given String.

  sub - the MIME subtype - `java.lang.String`

  throws: javax.activation.MimeTypeParseException - if the subtype is not a valid token"
  ([^MimeType this ^java.lang.String sub]
    (-> this (.setSubType sub))))

(defn get-sub-type
  "Retrieve the subtype of this object.

  returns: the MIME subtype - `java.lang.String`"
  (^java.lang.String [^MimeType this]
    (-> this (.getSubType))))

(defn remove-parameter
  "Remove any value associated with the given name.

  name - the parameter name - `java.lang.String`"
  ([^MimeType this ^java.lang.String name]
    (-> this (.removeParameter name))))

(defn to-string
  "Return the String representation of this object.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MimeType this]
    (-> this (.toString))))

(defn get-parameters
  "Retrieve this object's parameter list.

  returns: a MimeTypeParameterList object representing the parameters - `javax.activation.MimeTypeParameterList`"
  (^javax.activation.MimeTypeParameterList [^MimeType this]
    (-> this (.getParameters))))

(defn write-external
  "The object implements the writeExternal method to save its contents
   by calling the methods of DataOutput for its primitive values or
   calling the writeObject method of ObjectOutput for objects, strings
   and arrays.

  out - the ObjectOutput object to write to - `java.io.ObjectOutput`

  throws: java.io.IOException - Includes any I/O exceptions that may occur"
  ([^MimeType this ^java.io.ObjectOutput out]
    (-> this (.writeExternal out))))

(defn get-base-type
  "Return a String representation of this object
   without the parameter list.

  returns: the MIME type and sub-type - `java.lang.String`"
  (^java.lang.String [^MimeType this]
    (-> this (.getBaseType))))

(defn get-parameter
  "Retrieve the value associated with the given name, or null if there
   is no current association.

  name - the parameter name - `java.lang.String`

  returns: the paramter's value - `java.lang.String`"
  (^java.lang.String [^MimeType this ^java.lang.String name]
    (-> this (.getParameter name))))

(defn set-primary-type
  "Set the primary type for this object to the given String.

  primary - the primary MIME type - `java.lang.String`

  throws: javax.activation.MimeTypeParseException - if the primary type is not a valid token"
  ([^MimeType this ^java.lang.String primary]
    (-> this (.setPrimaryType primary))))

(defn get-primary-type
  "Retrieve the primary type of this object.

  returns: the primary MIME type - `java.lang.String`"
  (^java.lang.String [^MimeType this]
    (-> this (.getPrimaryType))))

(defn match
  "Determine if the primary and sub type of this object is
   the same as what is in the given type.

  type - the MimeType object to compare with - `javax.activation.MimeType`

  returns: true if they match - `boolean`"
  (^Boolean [^MimeType this ^javax.activation.MimeType type]
    (-> this (.match type))))

(defn set-parameter
  "Set the value to be associated with the given name, replacing
   any previous association.

  name - the parameter name - `java.lang.String`
  value - the paramter's value - `java.lang.String`"
  ([^MimeType this ^java.lang.String name ^java.lang.String value]
    (-> this (.setParameter name value))))

(defn read-external
  "The object implements the readExternal method to restore its
   contents by calling the methods of DataInput for primitive
   types and readObject for objects, strings and arrays.  The
   readExternal method must read the values in the same sequence
   and with the same types as were written by writeExternal.

  in - the ObjectInput object to read from - `java.io.ObjectInput`

  throws: java.lang.ClassNotFoundException - If the class for an object being restored cannot be found."
  ([^MimeType this ^java.io.ObjectInput in]
    (-> this (.readExternal in))))

