(ns javax.swing.text.SimpleAttributeSet
  "A straightforward implementation of MutableAttributeSet using a
  hash table.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text SimpleAttributeSet]))

(defn ->simple-attribute-set
  "Constructor.

  Creates a new attribute set based on a supplied set of attributes.

  source - the set of attributes - `javax.swing.text.AttributeSet`"
  ([source]
    (new SimpleAttributeSet source))
  ([]
    (new SimpleAttributeSet )))

(def *-empty
  "Static Constant.

  An empty attribute set.

  type: javax.swing.text.AttributeSet"
  SimpleAttributeSet/EMPTY)

(defn equal?
  "Compares two attribute sets.

  attr - the second attribute set - `javax.swing.text.AttributeSet`

  returns: true if the sets are equal, false otherwise - `boolean`"
  ([this attr]
    (-> this (.isEqual attr))))

(defn set-resolve-parent
  "Sets the resolving parent.

  parent - the parent - `javax.swing.text.AttributeSet`"
  ([this parent]
    (-> this (.setResolveParent parent))))

(defn to-string
  "Converts the attribute set to a String.

  returns: the string - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-attribute-count
  "Gets a count of the number of attributes.

  returns: the count - `int`"
  ([this]
    (-> this (.getAttributeCount))))

(defn get-resolve-parent
  "Gets the resolving parent.  This is the set
   of attributes to resolve through if an attribute
   isn't defined locally.  This is null if there
   are no other sets of attributes to resolve
   through.

  returns: the parent - `javax.swing.text.AttributeSet`"
  ([this]
    (-> this (.getResolveParent))))

(defn get-attribute
  "Gets the value of an attribute.

  name - the attribute name - `java.lang.Object`

  returns: the value - `java.lang.Object`"
  ([this name]
    (-> this (.getAttribute name))))

(defn remove-attribute
  "Removes an attribute from the list.

  name - the attribute name - `java.lang.Object`"
  ([this name]
    (-> this (.removeAttribute name))))

(defn add-attributes
  "Adds a set of attributes to the list.

  attributes - the set of attributes to add - `javax.swing.text.AttributeSet`"
  ([this attributes]
    (-> this (.addAttributes attributes))))

(defn copy-attributes
  "Makes a copy of the attributes.

  returns: the copy - `javax.swing.text.AttributeSet`"
  ([this]
    (-> this (.copyAttributes))))

(defn remove-attributes
  "Removes a set of attributes from the list.

  names - the set of names to remove - `java.util.Enumeration<?>`"
  ([this names]
    (-> this (.removeAttributes names))))

(defn clone
  "Clones a set of attributes.

  returns: the new set of attributes - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hashcode for this set of attributes.

  returns: a hashcode value for this set of attributes. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn defined?
  "Tells whether a given attribute is defined.

  attr-name - the attribute name - `java.lang.Object`

  returns: true if the attribute is defined - `boolean`"
  ([this attr-name]
    (-> this (.isDefined attr-name))))

(defn add-attribute
  "Adds an attribute to the list.

  name - the attribute name - `java.lang.Object`
  value - the attribute value - `java.lang.Object`"
  ([this name value]
    (-> this (.addAttribute name value))))

(defn empty?
  "Checks whether the set of attributes is empty.

  returns: true if the set is empty else false - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn contains-attributes
  "Checks whether the attribute list contains all the
   specified name/value pairs.

  attributes - the attribute list - `javax.swing.text.AttributeSet`

  returns: true if the list contains all the name/value pairs - `boolean`"
  ([this attributes]
    (-> this (.containsAttributes attributes))))

(defn contains-attribute
  "Checks whether the attribute list contains a
   specified attribute name/value pair.

  name - the name - `java.lang.Object`
  value - the value - `java.lang.Object`

  returns: true if the name/value pair is in the list - `boolean`"
  ([this name value]
    (-> this (.containsAttribute name value))))

(defn get-attribute-names
  "Gets the names of the attributes in the set.

  returns: the names as an Enumeration - `java.util.Enumeration<?>`"
  ([this]
    (-> this (.getAttributeNames))))

(defn equals
  "Compares this object to the specified object.
   The result is true if the object is an equivalent
   set of attributes.

  obj - the object to compare this attribute set with - `java.lang.Object`

  returns: true if the objects are equal;
              false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

