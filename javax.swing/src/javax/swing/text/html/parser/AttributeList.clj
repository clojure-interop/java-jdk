(ns javax.swing.text.html.parser.AttributeList
  "This class defines the attributes of an SGML element
  as described in a DTD using the ATTLIST construct.
  An AttributeList can be obtained from the Element
  class using the getAttributes() method.

  It is actually an element in a linked list. Use the
  getNext() method repeatedly to enumerate all the attributes
  of an element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser AttributeList]))

(defn ->attribute-list
  "Constructor.

  Create an attribute list element.

  name - `java.lang.String`
  type - `int`
  modifier - `int`
  value - `java.lang.String`
  values - `java.util.Vector`
  next - `javax.swing.text.html.parser.AttributeList`"
  (^AttributeList [^java.lang.String name ^Integer type ^Integer modifier ^java.lang.String value ^java.util.Vector values ^javax.swing.text.html.parser.AttributeList next]
    (new AttributeList name type modifier value values next))
  (^AttributeList [^java.lang.String name]
    (new AttributeList name)))

(defn name
  "Instance Field.

  type: java.lang.String"
  (^java.lang.String [^AttributeList this]
    (-> this .-name)))

(defn type
  "Instance Field.

  type: int"
  (^Integer [^AttributeList this]
    (-> this .-type)))

(defn values
  "Instance Field.

  type: java.util.Vector<?>"
  (^java.util.Vector [^AttributeList this]
    (-> this .-values)))

(defn modifier
  "Instance Field.

  type: int"
  (^Integer [^AttributeList this]
    (-> this .-modifier)))

(defn value
  "Instance Field.

  type: java.lang.String"
  (^java.lang.String [^AttributeList this]
    (-> this .-value)))

(defn next
  "Instance Field.

  type: javax.swing.text.html.parser.AttributeList"
  (^javax.swing.text.html.parser.AttributeList [^AttributeList this]
    (-> this .-next)))

(defn *name-2type
  "nm - `java.lang.String`

  returns: `int`"
  (^Integer [^java.lang.String nm]
    (AttributeList/name2type nm)))

(defn *type-2name
  "tp - `int`

  returns: `java.lang.String`"
  (^java.lang.String [^Integer tp]
    (AttributeList/type2name tp)))

(defn get-name
  "returns: attribute name - `java.lang.String`"
  (^java.lang.String [^AttributeList this]
    (-> this (.getName))))

(defn get-type
  "returns: attribute type - `int`"
  (^Integer [^AttributeList this]
    (-> this (.getType))))

(defn get-modifier
  "returns: attribute modifier - `int`"
  (^Integer [^AttributeList this]
    (-> this (.getModifier))))

(defn get-values
  "returns: possible attribute values - `java.util.Enumeration<?>`"
  (^java.util.Enumeration [^AttributeList this]
    (-> this (.getValues))))

(defn get-value
  "returns: default attribute value - `java.lang.String`"
  (^java.lang.String [^AttributeList this]
    (-> this (.getValue))))

(defn get-next
  "returns: the next attribute in the list - `javax.swing.text.html.parser.AttributeList`"
  (^javax.swing.text.html.parser.AttributeList [^AttributeList this]
    (-> this (.getNext))))

(defn to-string
  "Description copied from class: Object

  returns: string representation - `java.lang.String`"
  (^java.lang.String [^AttributeList this]
    (-> this (.toString))))

