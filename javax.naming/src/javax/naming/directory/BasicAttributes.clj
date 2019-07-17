(ns javax.naming.directory.BasicAttributes
  "This class provides a basic implementation
  of the Attributes interface.

  BasicAttributes is either case-sensitive or case-insensitive (case-ignore).
  This property is determined at the time the BasicAttributes constructor
  is called.
  In a case-insensitive BasicAttributes, the case of its attribute identifiers
  is ignored when searching for an attribute, or adding attributes.
  In a case-sensitive BasicAttributes, the case is significant.

  When the BasicAttributes class needs to create an Attribute, it
  uses BasicAttribute. There is no other dependency on BasicAttribute.

  Note that updates to BasicAttributes (such as adding or removing an attribute)
  does not affect the corresponding representation in the directory.
  Updates to the directory can only be effected
  using operations in the DirContext interface.

  A BasicAttributes instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single BasicAttributes instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory BasicAttributes]))

(defn ->basic-attributes
  "Constructor.

  Constructs a new instance of Attributes with one attribute.
   The attribute specified by attrID and val are added to the newly
   created attribute.
   If ignoreCase is true, the character case of attribute
   identifiers is ignored; otherwise the case is significant.

  attr-id - non-null The id of the attribute to add. If this attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`
  val - The value of the attribute to add. If null, a null value is added to the attribute. - `java.lang.Object`
  ignore-case - true means this attribute set will ignore the case of its attribute identifiers when retrieving or adding attributes; false means case is respected. - `boolean`"
  ([^java.lang.String attr-id ^java.lang.Object val ^Boolean ignore-case]
    (new BasicAttributes attr-id val ignore-case))
  ([^java.lang.String attr-id ^java.lang.Object val]
    (new BasicAttributes attr-id val))
  ([^Boolean ignore-case]
    (new BasicAttributes ignore-case))
  ([]
    (new BasicAttributes )))

(defn case-ignored?
  "Description copied from interface: Attributes

  returns: true if case is ignored; false otherwise. - `boolean`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.isCaseIgnored))))

(defn get-i-ds
  "Description copied from interface: Attributes

  returns: A non-null enumeration of the attributes' ids in
           this attribute set. Each element of the enumeration is
           of class String.
           If attribute set has zero attributes, an empty enumeration
           is returned. - `javax.naming.NamingEnumeration<java.lang.String>`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.getIDs))))

(defn put
  "Description copied from interface: Attributes

  attr-id - non-null The id of the attribute to add. If the attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`
  val - The possibly null value of the attribute to add. If null, the attribute does not have any values. - `java.lang.Object`

  returns: The Attribute with attrID that was previous in this attribute set;
           null if no such attribute existed. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.BasicAttributes this ^java.lang.String attr-id ^java.lang.Object val]
    (-> this (.put attr-id val)))
  ([^javax.naming.directory.BasicAttributes this ^javax.naming.directory.Attribute attr]
    (-> this (.put attr))))

(defn get-all
  "Description copied from interface: Attributes

  returns: A non-null enumeration of the attributes in this attribute set.
           Each element of the enumeration is of class Attribute.
           If attribute set has zero attributes, an empty enumeration
           is returned. - `javax.naming.NamingEnumeration<javax.naming.directory.Attribute>`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.getAll))))

(defn to-string
  "Generates the string representation of this attribute set.
   The string consists of each attribute identifier and the contents
   of each attribute. The contents of this string is useful
   for debugging and is not meant to be interpreted programmatically.

  returns: A non-null string listing the contents of this attribute set. - `java.lang.String`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.toString))))

(defn remove
  "Description copied from interface: Attributes

  attr-id - The non-null id of the attribute to remove. If the attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`

  returns: The Attribute with the same ID as attrID that was previous
           in the attribute set;
           null if no such attribute existed. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.BasicAttributes this ^java.lang.String attr-id]
    (-> this (.remove attr-id))))

(defn clone
  "Description copied from class: Object

  returns: a clone of this instance. - `java.lang.Object`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.clone))))

(defn hash-code
  "Calculates the hash code of this BasicAttributes.

   The hash code is computed by adding the hash code of
   the attributes of this object. If this BasicAttributes
   ignores case of its attribute IDs, one is added to the hash code.
   If a subclass overrides hashCode(),
   it should override equals()
   as well so that two Attributes instances that are equal
   have the same hash code.

  returns: an int representing the hash code of this BasicAttributes instance. - `int`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.hashCode))))

(defn size
  "Description copied from interface: Attributes

  returns: The nonnegative number of attributes in this attribute set. - `int`"
  ([^javax.naming.directory.BasicAttributes this]
    (-> this (.size))))

(defn get
  "Description copied from interface: Attributes

  attr-id - The non-null id of the attribute to retrieve. If this attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`

  returns: The attribute identified by attrID; null if not found. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.BasicAttributes this ^java.lang.String attr-id]
    (-> this (.get attr-id))))

(defn equals
  "Determines whether this BasicAttributes is equal to another
   Attributes
   Two Attributes are equal if they are both instances of
   Attributes,
   treat the case of attribute IDs the same way, and contain the
   same attributes. Each Attribute in this BasicAttributes
   is checked for equality using Object.equals(), which may have
   be overridden by implementations of Attribute).
   If a subclass overrides equals(),
   it should override hashCode()
   as well so that two Attributes instances that are equal
   have the same hash code.

  obj - the possibly null object to compare against. - `java.lang.Object`

  returns: true If obj is equal to this BasicAttributes. - `boolean`"
  ([^javax.naming.directory.BasicAttributes this ^java.lang.Object obj]
    (-> this (.equals obj))))

