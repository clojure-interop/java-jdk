(ns javax.naming.directory.Attributes
  "This interface represents a collection of attributes.

  In a directory, named objects can have associated with them
  attributes.  The Attributes interface represents a collection of attributes.
  For example, you can request from the directory the attributes
  associated with an object.  Those attributes are returned in
  an object that implements the Attributes interface.

  Attributes in an object that implements the  Attributes interface are
  unordered. The object can have zero or more attributes.
  Attributes is either case-sensitive or case-insensitive (case-ignore).
  This property is determined at the time the Attributes object is
  created. (see BasicAttributes constructor for example).
  In a case-insensitive Attributes, the case of its attribute identifiers
  is ignored when searching for an attribute, or adding attributes.
  In a case-sensitive Attributes, the case is significant.

  Note that updates to Attributes (such as adding or removing an attribute)
  do not affect the corresponding representation in the directory.
  Updates to the directory can only be effected
  using operations in the DirContext interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory Attributes]))

(defn case-ignored?
  "Determines whether the attribute set ignores the case of
   attribute identifiers when retrieving or adding attributes.

  returns: true if case is ignored; false otherwise. - `boolean`"
  ([^javax.naming.directory.Attributes this]
    (-> this (.isCaseIgnored))))

(defn size
  "Retrieves the number of attributes in the attribute set.

  returns: The nonnegative number of attributes in this attribute set. - `int`"
  ([^javax.naming.directory.Attributes this]
    (-> this (.size))))

(defn get
  "Retrieves the attribute with the given attribute id from the
   attribute set.

  attr-id - The non-null id of the attribute to retrieve. If this attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`

  returns: The attribute identified by attrID; null if not found. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.Attributes this ^java.lang.String attr-id]
    (-> this (.get attr-id))))

(defn get-all
  "Retrieves an enumeration of the attributes in the attribute set.
   The effects of updates to this attribute set on this enumeration
   are undefined.

  returns: A non-null enumeration of the attributes in this attribute set.
           Each element of the enumeration is of class Attribute.
           If attribute set has zero attributes, an empty enumeration
           is returned. - `javax.naming.NamingEnumeration<? extends javax.naming.directory.Attribute>`"
  ([^javax.naming.directory.Attributes this]
    (-> this (.getAll))))

(defn get-i-ds
  "Retrieves an enumeration of the ids of the attributes in the
   attribute set.
   The effects of updates to this attribute set on this enumeration
   are undefined.

  returns: A non-null enumeration of the attributes' ids in
           this attribute set. Each element of the enumeration is
           of class String.
           If attribute set has zero attributes, an empty enumeration
           is returned. - `javax.naming.NamingEnumeration<java.lang.String>`"
  ([^javax.naming.directory.Attributes this]
    (-> this (.getIDs))))

(defn put
  "Adds a new attribute to the attribute set.

  attr-id - non-null The id of the attribute to add. If the attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`
  val - The possibly null value of the attribute to add. If null, the attribute does not have any values. - `java.lang.Object`

  returns: The Attribute with attrID that was previous in this attribute set;
           null if no such attribute existed. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.Attributes this ^java.lang.String attr-id ^java.lang.Object val]
    (-> this (.put attr-id val)))
  ([^javax.naming.directory.Attributes this ^javax.naming.directory.Attribute attr]
    (-> this (.put attr))))

(defn remove
  "Removes the attribute with the attribute id 'attrID' from
   the attribute set. If the attribute does not exist, ignore.

  attr-id - The non-null id of the attribute to remove. If the attribute set ignores the character case of its attribute ids, the case of attrID is ignored. - `java.lang.String`

  returns: The Attribute with the same ID as attrID that was previous
           in the attribute set;
           null if no such attribute existed. - `javax.naming.directory.Attribute`"
  ([^javax.naming.directory.Attributes this ^java.lang.String attr-id]
    (-> this (.remove attr-id))))

(defn clone
  "Makes a copy of the attribute set.
   The new set contains the same attributes as the original set:
   the attributes are not themselves cloned.
   Changes to the copy will not affect the original and vice versa.

  returns: A non-null copy of this attribute set. - `java.lang.Object`"
  ([^javax.naming.directory.Attributes this]
    (-> this (.clone))))

