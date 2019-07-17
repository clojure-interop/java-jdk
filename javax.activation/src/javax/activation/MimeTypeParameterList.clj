(ns javax.activation.MimeTypeParameterList
  "A parameter list of a MimeType
  as defined in RFC 2045 and 2046. The Primary type of the
  object must already be stripped off."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation MimeTypeParameterList]))

(defn ->mime-type-parameter-list
  "Constructor.

  Constructs a new MimeTypeParameterList with the passed in data.

  parameter-list - an RFC 2045, 2046 compliant parameter list. - `java.lang.String`

  throws: javax.activation.MimeTypeParseException"
  ([parameter-list]
    (new MimeTypeParameterList parameter-list))
  ([]
    (new MimeTypeParameterList )))

(defn size
  "Return the number of name-value pairs in this list.

  returns: the number of parameters - `int`"
  ([this]
    (-> this (.size))))

(defn empty?
  "Determine whether or not this list is empty.

  returns: true if there are no parameters - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn get
  "Retrieve the value associated with the given name, or null if there
   is no current association.

  name - the parameter name - `java.lang.String`

  returns: the parameter's value - `java.lang.String`"
  ([this name]
    (-> this (.get name))))

(defn set
  "Set the value to be associated with the given name, replacing
   any previous association.

  name - the parameter name - `java.lang.String`
  value - the parameter's value - `java.lang.String`"
  ([this name value]
    (-> this (.set name value))))

(defn remove
  "Remove any value associated with the given name.

  name - the parameter name - `java.lang.String`"
  ([this name]
    (-> this (.remove name))))

(defn get-names
  "Retrieve an enumeration of all the names in this list.

  returns: an enumeration of all parameter names - `java.util.Enumeration`"
  ([this]
    (-> this (.getNames))))

(defn to-string
  "Return a string representation of this object.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

