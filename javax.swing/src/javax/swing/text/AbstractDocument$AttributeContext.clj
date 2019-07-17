(ns javax.swing.text.AbstractDocument$AttributeContext
  "An interface that can be used to allow MutableAttributeSet
  implementations to use pluggable attribute compression
  techniques.  Each mutation of the attribute set can be
  used to exchange a previous AttributeSet instance with
  another, preserving the possibility of the AttributeSet
  remaining immutable.  An implementation is provided by
  the StyleContext class.

  The Element implementations provided by this class use
  this interface to provide their MutableAttributeSet
  implementations, so that different AttributeSet compression
  techniques can be employed.  The method
  getAttributeContext should be implemented to
  return the object responsible for implementing the desired
  compression technique."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AbstractDocument$AttributeContext]))

(defn add-attribute
  "Adds an attribute to the given set, and returns
   the new representative set.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  name - the non-null attribute name - `java.lang.Object`
  value - the attribute value - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this ^javax.swing.text.AttributeSet old ^java.lang.Object name ^java.lang.Object value]
    (-> this (.addAttribute old name value))))

(defn add-attributes
  "Adds a set of attributes to the element.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  attr - the attributes to add - `javax.swing.text.AttributeSet`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this ^javax.swing.text.AttributeSet old ^javax.swing.text.AttributeSet attr]
    (-> this (.addAttributes old attr))))

(defn remove-attribute
  "Removes an attribute from the set.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  name - the non-null attribute name - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this ^javax.swing.text.AttributeSet old ^java.lang.Object name]
    (-> this (.removeAttribute old name))))

(defn remove-attributes
  "Removes a set of attributes for the element.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  names - the attribute names - `java.util.Enumeration<?>`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this ^javax.swing.text.AttributeSet old ^java.util.Enumeration names]
    (-> this (.removeAttributes old names))))

(defn get-empty-set
  "Fetches an empty AttributeSet.

  returns: the attribute set - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this]
    (-> this (.getEmptySet))))

(defn reclaim
  "Reclaims an attribute set.
   This is a way for a MutableAttributeSet to mark that it no
   longer need a particular immutable set.  This is only necessary
   in 1.1 where there are no weak references.  A 1.1 implementation
   would call this in its finalize method.

  a - the attribute set to reclaim - `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.AbstractDocument$AttributeContext this ^javax.swing.text.AttributeSet a]
    (-> this (.reclaim a))))

