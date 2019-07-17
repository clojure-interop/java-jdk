(ns javax.swing.text.html.parser.Element
  "An element as described in a DTD using the ELEMENT construct.
  This is essential the description of a tag. It describes the
  type, content model, attributes, attribute types etc. It is used
  to correctly parse a document by the Parser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser Element]))

(defn -index
  "Instance Field.

  type: int"
  [this]
  (-> this .-index))

(defn -name
  "Instance Field.

  type: java.lang.String"
  [this]
  (-> this .-name))

(defn -o-start
  "Instance Field.

  type: boolean"
  [this]
  (-> this .-oStart))

(defn -o-end
  "Instance Field.

  type: boolean"
  [this]
  (-> this .-oEnd))

(defn -inclusions
  "Instance Field.

  type: java.util.BitSet"
  [this]
  (-> this .-inclusions))

(defn -exclusions
  "Instance Field.

  type: java.util.BitSet"
  [this]
  (-> this .-exclusions))

(defn -type
  "Instance Field.

  type: int"
  [this]
  (-> this .-type))

(defn -content
  "Instance Field.

  type: javax.swing.text.html.parser.ContentModel"
  [this]
  (-> this .-content))

(defn -atts
  "Instance Field.

  type: javax.swing.text.html.parser.AttributeList"
  [this]
  (-> this .-atts))

(defn -data
  "Instance Field.

  A field to store user data. Mostly used to store
   style sheets.

  type: java.lang.Object"
  [this]
  (-> this .-data))

(defn *name-2type
  "nm - `java.lang.String`

  returns: `int`"
  (^Integer [^java.lang.String nm]
    (Element/name2type nm)))

(defn get-type
  "Get type.

  returns: `int`"
  (^Integer [^javax.swing.text.html.parser.Element this]
    (-> this (.getType))))

(defn get-index
  "Get index.

  returns: `int`"
  (^Integer [^javax.swing.text.html.parser.Element this]
    (-> this (.getIndex))))

(defn omit-end
  "Return true if the end tag can be omitted.

  returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.Element this]
    (-> this (.omitEnd))))

(defn get-attribute-by-value
  "Get an attribute by value.

  name - `java.lang.String`

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^javax.swing.text.html.parser.Element this ^java.lang.String name]
    (-> this (.getAttributeByValue name))))

(defn to-string
  "Convert to a string.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.parser.Element this]
    (-> this (.toString))))

(defn get-attribute
  "Get an attribute by name.

  name - `java.lang.String`

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^javax.swing.text.html.parser.Element this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-name
  "Get the name of the element.

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.parser.Element this]
    (-> this (.getName))))

(defn empty?
  "Check if empty

  returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.Element this]
    (-> this (.isEmpty))))

(defn omit-start
  "Return true if the start tag can be omitted.

  returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.Element this]
    (-> this (.omitStart))))

(defn get-attributes
  "Get the attributes.

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^javax.swing.text.html.parser.Element this]
    (-> this (.getAttributes))))

(defn get-content
  "Get content model

  returns: `javax.swing.text.html.parser.ContentModel`"
  (^javax.swing.text.html.parser.ContentModel [^javax.swing.text.html.parser.Element this]
    (-> this (.getContent))))

