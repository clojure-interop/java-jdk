(ns javax.swing.text.AttributeSet
  "A collection of unique attributes.  This is a read-only,
  immutable interface.  An attribute is basically a key and
  a value assigned to the key.  The collection may represent
  something like a style run, a logical style, etc.  These
  are generally used to describe features that will contribute
  to some graphical representation such as a font.  The
  set of possible keys is unbounded and can be anything.
  Typically View implementations will respond to attribute
  definitions and render something to represent the attributes.

  Attributes can potentially resolve in a hierarchy.  If a
  key doesn't resolve locally, and a resolving parent
  exists, the key will be resolved through the parent."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AttributeSet]))

(defn equal?
  "Determines if the two attribute sets are equivalent.

  attr - an attribute set - `javax.swing.text.AttributeSet`

  returns: true if the sets are equivalent - `boolean`"
  (^Boolean [^AttributeSet this ^javax.swing.text.AttributeSet attr]
    (-> this (.isEqual attr))))

(defn get-attribute-count
  "Returns the number of attributes that are defined locally in this set.
   Attributes that are defined in the parent set are not included.

  returns: the number of attributes >= 0 - `int`"
  (^Integer [^AttributeSet this]
    (-> this (.getAttributeCount))))

(defn get-resolve-parent
  "Gets the resolving parent.

  returns: the parent - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^AttributeSet this]
    (-> this (.getResolveParent))))

(defn get-attribute
  "Fetches the value of the given attribute. If the value is not found
   locally, the search is continued upward through the resolving
   parent (if one exists) until the value is either
   found or there are no more parents.  If the value is not found,
   null is returned.

  key - the non-null key of the attribute binding - `java.lang.Object`

  returns: the value of the attribute, or null if not found - `java.lang.Object`"
  (^java.lang.Object [^AttributeSet this ^java.lang.Object key]
    (-> this (.getAttribute key))))

(defn copy-attributes
  "Returns an attribute set that is guaranteed not
   to change over time.

  returns: a copy of the attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^AttributeSet this]
    (-> this (.copyAttributes))))

(defn defined?
  "Checks whether the named attribute has a value specified in
   the set without resolving through another attribute
   set.

  attr-name - the attribute name - `java.lang.Object`

  returns: true if the attribute has a value specified - `boolean`"
  (^Boolean [^AttributeSet this ^java.lang.Object attr-name]
    (-> this (.isDefined attr-name))))

(defn contains-attributes
  "Returns true if this set defines all the attributes from the
   given set with equal values. If an attribute is not found locally,
   it is searched through in the resolving parent hierarchy.

  attributes - the set of attributes to check against - `javax.swing.text.AttributeSet`

  returns: true if this set defines all the attributes with equal
                values, either locally or through its resolving parent - `boolean`

  throws: java.lang.NullPointerException - if attributes is null"
  (^Boolean [^AttributeSet this ^javax.swing.text.AttributeSet attributes]
    (-> this (.containsAttributes attributes))))

(defn contains-attribute
  "Returns true if this set defines an attribute with the same
   name and an equal value. If such an attribute is not found locally,
   it is searched through in the resolving parent hierarchy.

  name - the non-null attribute name - `java.lang.Object`
  value - the value - `java.lang.Object`

  returns: true if the set defines the attribute with an
       equal value, either locally or through its resolving parent - `boolean`

  throws: java.lang.NullPointerException - if either name or value is null"
  (^Boolean [^AttributeSet this ^java.lang.Object name ^java.lang.Object value]
    (-> this (.containsAttribute name value))))

(defn get-attribute-names
  "Returns an enumeration over the names of the attributes that are
   defined locally in the set. Names of attributes defined in the
   resolving parent, if any, are not included. The values of the
   Enumeration may be anything and are not constrained to
   a particular Object type.

   This method never returns null. For a set with no attributes, it
   returns an empty Enumeration.

  returns: the names - `java.util.Enumeration<?>`"
  (^java.util.Enumeration [^AttributeSet this]
    (-> this (.getAttributeNames))))

