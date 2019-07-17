(ns javax.swing.text.html.parser.Entity
  "An entity is described in a DTD using the ENTITY construct.
  It defines the type and value of the the entity."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser Entity]))

(defn ->entity
  "Constructor.

  Creates an entity.

  name - the name of the entity - `java.lang.String`
  type - the type of the entity - `int`
  data - the char array of data - `char[]`"
  ([^java.lang.String name ^Integer type data]
    (new Entity name type data)))

(defn -name
  "Instance Field.

  type: java.lang.String"
  [this]
  (-> this .-name))

(defn -type
  "Instance Field.

  type: int"
  [this]
  (-> this .-type))

(defn -data
  "Instance Field.

  type: char[]"
  [this]
  (-> this .-data))

(defn *name-2type
  "Converts nm string to the corresponding
   entity type.  If the string does not have a corresponding
   entity type, returns the type corresponding to `CDATA`.
   Valid entity types are: `PUBLIC`, `CDATA`, `SDATA`, `PI`,
   `STARTTAG`, `ENDTAG`, `MS`, `MD`, `SYSTEM`.

  nm - the string to be converted - `java.lang.String`

  returns: the corresponding entity type, or the type corresponding
     to `CDATA`, if none exists - `int`"
  (^Integer [^java.lang.String nm]
    (Entity/name2type nm)))

(defn get-name
  "Gets the name of the entity.

  returns: the name of the entity, as a String - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.parser.Entity this]
    (-> this (.getName))))

(defn get-type
  "Gets the type of the entity.

  returns: the type of the entity - `int`"
  (^Integer [^javax.swing.text.html.parser.Entity this]
    (-> this (.getType))))

(defn parameter?
  "Returns true if it is a parameter entity.

  returns: true if it is a parameter entity - `boolean`"
  (^Boolean [^javax.swing.text.html.parser.Entity this]
    (-> this (.isParameter))))

(defn general?
  "Returns true if it is a general entity.

  returns: true if it is a general entity - `boolean`"
  (^Boolean [^javax.swing.text.html.parser.Entity this]
    (-> this (.isGeneral))))

(defn get-data
  "Returns the data.

  returns: the data - `char[]`"
  ([^javax.swing.text.html.parser.Entity this]
    (-> this (.getData))))

(defn get-string
  "Returns the data as a String.

  returns: the data as a String - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.parser.Entity this]
    (-> this (.getString))))

