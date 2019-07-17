(ns javax.swing.text.html.parser.DTD
  "The representation of an SGML DTD.  DTD describes a document
  syntax and is used in parsing of HTML documents.  It contains
  a list of elements and their attributes as well as a list of
  entities defined in the DTD."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser DTD]))

(defn -name
  "Instance Field.

  type: java.lang.String"
  [this]
  (-> this .-name))

(defn -elements
  "Instance Field.

  type: java.util.Vector<javax.swing.text.html.parser.Element>"
  [this]
  (-> this .-elements))

(defn -element-hash
  "Instance Field.

  type: java.util.Hashtable<java.lang.String,javax.swing.text.html.parser.Element>"
  [this]
  (-> this .-elementHash))

(defn -entity-hash
  "Instance Field.

  type: java.util.Hashtable<java.lang.Object,javax.swing.text.html.parser.Entity>"
  [this]
  (-> this .-entityHash))

(def -pcdata
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-pcdata))

(def -html
  "Instance Constant.

  type: javax.swing.text..parser.Element"
  (-> this .-html))

(def -meta
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-meta))

(def -base
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-base))

(def -isindex
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-isindex))

(def -head
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-head))

(def -body
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-body))

(def -applet
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-applet))

(def -param
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-param))

(def -p
  "Instance Constant.

  type: javax.swing.text.html.arser.Element"
  (-> this .-p))

(def -title
  "Instance Constant.

  type: javax.swing.text.html.parser.Element"
  (-> this .-title))

(def *-file-version
  "Static Constant.

  type: int"
  DTD/FILE_VERSION)

(defn *put-dtd-hash
  "name - `java.lang.String`
  dtd - `javax.swing.text.html.parser.DTD`"
  ([^java.lang.String name ^javax.swing.text.html.parser.DTD dtd]
    (DTD/putDTDHash name dtd)))

(defn *get-dtd
  "Returns a DTD with the specified name.  If
   a DTD with that name doesn't exist, one is created
   and returned.  Any uppercase characters in the name
   are converted to lowercase.

  name - the name of the DTD - `java.lang.String`

  returns: the DTD which corresponds to name - `javax.swing.text.html.parser.DTD`

  throws: java.io.IOException"
  ([^java.lang.String name]
    (DTD/getDTD name)))

(defn define-attributes
  "Defines attributes for an Element.

  name - the name of the Element - `java.lang.String`
  atts - the AttributeList specifying the Element - `javax.swing.text.html.parser.AttributeList`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name ^javax.swing.text.html.parser.AttributeList atts]
    (-> this (.defineAttributes name atts))))

(defn get-entity
  "Gets an entity by name.

  name - `java.lang.String`

  returns: the Entity corresponding to the
     name String - `javax.swing.text.html.parser.Entity`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name]
    (-> this (.getEntity name))))

(defn define-entity
  "Defines an entity.  If the Entity specified
   by name, type, and data
   exists, it is returned; otherwise a new Entity
   is created and is returned.

  name - the name of the Entity as a String - `java.lang.String`
  type - the type of the Entity - `int`
  data - the Entity's data - `char[]`

  returns: the Entity requested or a new Entity
     if not found - `javax.swing.text.html.parser.Entity`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name ^Integer type data]
    (-> this (.defineEntity name type data))))

(defn get-element
  "Gets an element by name. A new element is
   created if the element doesn't exist.

  name - the requested String - `java.lang.String`

  returns: the Element corresponding to
     name, which may be newly created - `javax.swing.text.html.parser.Element`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name]
    (-> this (.getElement name))))

(defn def-entity
  "Creates and returns a character Entity.

  name - the entity's name - `java.lang.String`
  type - `int`
  ch - `int`

  returns: the new character Entity - `javax.swing.text.html.parser.Entity`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name ^Integer type ^Integer ch]
    (-> this (.defEntity name type ch))))

(defn to-string
  "Returns a string representation of this DTD.

  returns: the string representation of this DTD - `java.lang.String`"
  ([^javax.swing.text.html.parser.DTD this]
    (-> this (.toString))))

(defn read
  "Recreates a DTD from an archived format.

  in - the DataInputStream to read from - `java.io.DataInputStream`

  throws: java.io.IOException"
  ([^javax.swing.text.html.parser.DTD this ^java.io.DataInputStream in]
    (-> this (.read in))))

(defn get-name
  "Gets the name of the DTD.

  returns: the name of the DTD - `java.lang.String`"
  ([^javax.swing.text.html.parser.DTD this]
    (-> this (.getName))))

(defn define-element
  "Returns the Element which matches the
   specified parameters.  If one doesn't exist, a new
   one is created and returned.

  name - the name of the Element - `java.lang.String`
  type - the type of the Element - `int`
  omit-start - true if start should be omitted - `boolean`
  omit-end - true if end should be omitted - `boolean`
  content - the ContentModel - `javax.swing.text.html.parser.ContentModel`
  exclusions - `java.util.BitSet`
  inclusions - `java.util.BitSet`
  atts - the AttributeList specifying the Element - `javax.swing.text.html.parser.AttributeList`

  returns: the Element specified - `javax.swing.text.html.parser.Element`"
  ([^javax.swing.text.html.parser.DTD this ^java.lang.String name ^Integer type ^Boolean omit-start ^Boolean omit-end ^javax.swing.text.html.parser.ContentModel content ^java.util.BitSet exclusions ^java.util.BitSet inclusions ^javax.swing.text.html.parser.AttributeList atts]
    (-> this (.defineElement name type omit-start omit-end content exclusions inclusions atts))))

