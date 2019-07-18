(ns javax.swing.text.MutableAttributeSet
  "A generic interface for a mutable collection of unique attributes.

  Implementations will probably want to provide a constructor of the
  form:
  public XXXAttributeSet(ConstAttributeSet source);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text MutableAttributeSet]))

(defn add-attribute
  "Creates a new attribute set similar to this one except that it contains
   an attribute with the given name and value.  The object must be
   immutable, or not mutated by any client.

  name - the name - `java.lang.Object`
  value - the value - `java.lang.Object`"
  ([^MutableAttributeSet this ^java.lang.Object name ^java.lang.Object value]
    (-> this (.addAttribute name value))))

(defn add-attributes
  "Creates a new attribute set similar to this one except that it contains
   the given attributes and values.

  attributes - the set of attributes - `javax.swing.text.AttributeSet`"
  ([^MutableAttributeSet this ^javax.swing.text.AttributeSet attributes]
    (-> this (.addAttributes attributes))))

(defn remove-attribute
  "Removes an attribute with the given name.

  name - the attribute name - `java.lang.Object`"
  ([^MutableAttributeSet this ^java.lang.Object name]
    (-> this (.removeAttribute name))))

(defn remove-attributes
  "Removes an attribute set with the given names.

  names - the set of names - `java.util.Enumeration`"
  ([^MutableAttributeSet this ^java.util.Enumeration names]
    (-> this (.removeAttributes names))))

(defn set-resolve-parent
  "Sets the resolving parent.  This is the set
   of attributes to resolve through if an attribute
   isn't defined locally.

  parent - the parent - `javax.swing.text.AttributeSet`"
  ([^MutableAttributeSet this ^javax.swing.text.AttributeSet parent]
    (-> this (.setResolveParent parent))))

