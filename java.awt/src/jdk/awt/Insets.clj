(ns jdk.awt.Insets
  "An Insets object is a representation of the borders
  of a container. It specifies the space that a container must leave
  at each of its edges. The space can be a border, a blank space, or
  a title."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Insets]))

(defn ->insets
  "Constructor.

  Creates and initializes a new Insets object with the
   specified top, left, bottom, and right insets.

  top - the inset from the top. - `int`
  left - the inset from the left. - `int`
  bottom - the inset from the bottom. - `int`
  right - the inset from the right. - `int`"
  (^Insets [^Integer top ^Integer left ^Integer bottom ^Integer right]
    (new Insets top left bottom right)))

(defn top
  "Instance Field.

  The inset from the top.
   This value is added to the Top of the rectangle
   to yield a new location for the Top.

  type: int"
  (^Integer [^Insets this]
    (-> this .-top)))

(defn left
  "Instance Field.

  The inset from the left.
   This value is added to the Left of the rectangle
   to yield a new location for the Left edge.

  type: int"
  (^Integer [^Insets this]
    (-> this .-left)))

(defn bottom
  "Instance Field.

  The inset from the bottom.
   This value is subtracted from the Bottom of the rectangle
   to yield a new location for the Bottom.

  type: int"
  (^Integer [^Insets this]
    (-> this .-bottom)))

(defn right
  "Instance Field.

  The inset from the right.
   This value is subtracted from the Right of the rectangle
   to yield a new location for the Right edge.

  type: int"
  (^Integer [^Insets this]
    (-> this .-right)))

(defn set
  "Set top, left, bottom, and right to the specified values

  top - the inset from the top. - `int`
  left - the inset from the left. - `int`
  bottom - the inset from the bottom. - `int`
  right - the inset from the right. - `int`"
  ([^Insets this ^Integer top ^Integer left ^Integer bottom ^Integer right]
    (-> this (.set top left bottom right))))

(defn equals
  "Checks whether two insets objects are equal. Two instances
   of Insets are equal if the four integer values
   of the fields top, left,
   bottom, and right are all equal.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if the two insets are equal;
                            otherwise false. - `boolean`"
  (^Boolean [^Insets this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code for this Insets.

  returns: a hash code for this Insets. - `int`"
  (^Integer [^Insets this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this Insets object.
   This method is intended to be used only for debugging purposes, and
   the content and format of the returned string may vary between
   implementations. The returned string may be empty but may not be
   null.

  returns: a string representation of this Insets object. - `java.lang.String`"
  (^java.lang.String [^Insets this]
    (-> this (.toString))))

(defn clone
  "Create a copy of this object.

  returns: a copy of this Insets object. - `java.lang.Object`"
  (^java.lang.Object [^Insets this]
    (-> this (.clone))))

