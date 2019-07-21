(ns javax.swing.text.html.parser.Element
  "An element as described in a DTD using the ELEMENT construct.
  This is essential the description of a tag. It describes the
  type, content model, attributes, attribute types etc. It is used
  to correctly parse a document by the Parser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser Element]))

(defn index
  "Instance Field.

  type: int"
  (^Integer [^Element this]
    (-> this .-index)))

(defn name
  "Instance Field.

  type: java.lang.String"
  (^java.lang.String [^Element this]
    (-> this .-name)))

(defn o-start
  "Instance Field.

  type: boolean"
  (^Boolean [^Element this]
    (-> this .-oStart)))

(defn o-end
  "Instance Field.

  type: boolean"
  (^Boolean [^Element this]
    (-> this .-oEnd)))

(defn inclusions
  "Instance Field.

  type: java.util.BitSet"
  (^java.util.BitSet [^Element this]
    (-> this .-inclusions)))

(defn exclusions
  "Instance Field.

  type: java.util.BitSet"
  (^java.util.BitSet [^Element this]
    (-> this .-exclusions)))

(defn type
  "Instance Field.

  type: int"
  (^Integer [^Element this]
    (-> this .-type)))

(defn content
  "Instance Field.

  type: javax.swing.text.html.parser.ContentModel"
  (^javax.swing.text.html.parser.ContentModel [^Element this]
    (-> this .-content)))

(defn atts
  "Instance Field.

  type: javax.swing.text.html.parser.AttributeList"
  (^javax.swing.text.html.parser.AttributeList [^Element this]
    (-> this .-atts)))

(defn data
  "Instance Field.

  A field to store user data. Mostly used to store
   style sheets.

  type: java.lang.Object"
  (^java.lang.Object [^Element this]
    (-> this .-data)))

(defn *name-2type
  "nm - `java.lang.String`

  returns: `int`"
  (^Integer [^java.lang.String nm]
    (Element/name2type nm)))

(defn get-type
  "Get type.

  returns: `int`"
  (^Integer [^Element this]
    (-> this (.getType))))

(defn get-index
  "Get index.

  returns: `int`"
  (^Integer [^Element this]
    (-> this (.getIndex))))

(defn omit-end
  "Return true if the end tag can be omitted.

  returns: `boolean`"
  (^Boolean [^Element this]
    (-> this (.omitEnd))))

(defn get-attribute-by-value
  "Get an attribute by value.

  name - `java.lang.String`

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^Element this ^java.lang.String name]
    (-> this (.getAttributeByValue name))))

(defn to-string
  "Convert to a string.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^Element this]
    (-> this (.toString))))

(defn get-attribute
  "Get an attribute by name.

  name - `java.lang.String`

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^Element this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-name
  "Get the name of the element.

  returns: `java.lang.String`"
  (^java.lang.String [^Element this]
    (-> this (.getName))))

(defn empty?
  "Check if empty

  returns: `boolean`"
  (^Boolean [^Element this]
    (-> this (.isEmpty))))

(defn omit-start
  "Return true if the start tag can be omitted.

  returns: `boolean`"
  (^Boolean [^Element this]
    (-> this (.omitStart))))

(defn get-attributes
  "Get the attributes.

  returns: `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^Element this]
    (-> this (.getAttributes))))

(defn get-content
  "Get content model

  returns: `javax.swing.text.html.parser.ContentModel`"
  (^javax.swing.text.html.parser.ContentModel [^Element this]
    (-> this (.getContent))))

