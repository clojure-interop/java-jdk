(ns jdk.awt.font.TransformAttribute
  "The TransformAttribute class provides an immutable
  wrapper for a transform so that it is safe to use as an attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TransformAttribute]))

(defn ->transform-attribute
  "Constructor.

  Wraps the specified transform.  The transform is cloned and a
   reference to the clone is kept.  The original transform is unchanged.
   If null is passed as the argument, this constructor behaves as though
   it were the identity transform.  (Note that it is preferable to use
   IDENTITY in this case.)

  transform - the specified AffineTransform to be wrapped, or null. - `java.awt.geom.AffineTransform`"
  (^TransformAttribute [^java.awt.geom.AffineTransform transform]
    (new TransformAttribute transform)))

(def *-identity
  "Static Constant.

  A TransformAttribute representing the identity transform.

  type: java.awt.font.TransformAttribute"
  TransformAttribute/IDENTITY)

(defn get-transform
  "Returns a copy of the wrapped transform.

  returns: a AffineTransform that is a copy of the wrapped
   transform of this TransformAttribute. - `java.awt.geom.AffineTransform`"
  (^java.awt.geom.AffineTransform [^TransformAttribute this]
    (-> this (.getTransform))))

(defn identity?
  "Returns true if the wrapped transform is
   an identity transform.

  returns: true if the wrapped transform is
   an identity transform; false otherwise. - `boolean`"
  (^Boolean [^TransformAttribute this]
    (-> this (.isIdentity))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^TransformAttribute this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if rhs is a TransformAttribute
   whose transform is equal to this TransformAttribute's
   transform.

  rhs - the object to compare to - `java.lang.Object`

  returns: true if the argument is a TransformAttribute
   whose transform is equal to this TransformAttribute's
   transform. - `boolean`"
  (^Boolean [^TransformAttribute this ^java.lang.Object rhs]
    (-> this (.equals rhs))))

