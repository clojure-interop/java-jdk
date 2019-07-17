(ns jdk.awt.Dimension
  "The Dimension class encapsulates the width and
  height of a component (in integer precision) in a single object.
  The class is
  associated with certain properties of components. Several methods
  defined by the Component class and the
  LayoutManager interface return a
  Dimension object.

  Normally the values of width
  and height are non-negative integers.
  The constructors that allow you to create a dimension do
  not prevent you from setting a negative value for these properties.
  If the value of width or height is
  negative, the behavior of some methods defined by other objects is
  undefined."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Dimension]))

(defn ->dimension
  "Constructor.

  Constructs a Dimension and initializes
   it to the specified width and specified height.

  width - the specified width - `int`
  height - the specified height - `int`"
  ([^Integer width ^Integer height]
    (new Dimension width height))
  ([^java.awt.Dimension d]
    (new Dimension d))
  ([]
    (new Dimension )))

(defn -width
  "Instance Field.

  The width dimension; negative values can be used.

  type: int"
  [this]
  (-> this .-width))

(defn -height
  "Instance Field.

  The height dimension; negative values can be used.

  type: int"
  [this]
  (-> this .-height))

(defn get-width
  "Returns the width of this Dimension in double
   precision.

  returns: the width of this Dimension. - `double`"
  ([^java.awt.Dimension this]
    (-> this (.getWidth))))

(defn get-height
  "Returns the height of this Dimension in double
   precision.

  returns: the height of this Dimension. - `double`"
  ([^java.awt.Dimension this]
    (-> this (.getHeight))))

(defn set-size
  "Sets the size of this Dimension object to
   the specified width and height in double precision.
   Note that if width or height
   are larger than Integer.MAX_VALUE, they will
   be reset to Integer.MAX_VALUE.

  width - the new width for the Dimension object - `double`
  height - the new height for the Dimension object - `double`"
  ([^java.awt.Dimension this ^Double width ^Double height]
    (-> this (.setSize width height)))
  ([^java.awt.Dimension this ^java.awt.Dimension d]
    (-> this (.setSize d))))

(defn get-size
  "Gets the size of this Dimension object.
   This method is included for completeness, to parallel the
   getSize method defined by Component.

  returns: the size of this dimension, a new instance of
             Dimension with the same width and height - `java.awt.Dimension`"
  ([^java.awt.Dimension this]
    (-> this (.getSize))))

(defn equals
  "Checks whether two dimension objects have equal values.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.awt.Dimension this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code for this Dimension.

  returns: a hash code for this Dimension - `int`"
  ([^java.awt.Dimension this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of the values of this
   Dimension object's height and
   width fields. This method is intended to be used only
   for debugging purposes, and the content and format of the returned
   string may vary between implementations. The returned string may be
   empty but may not be null.

  returns: a string representation of this Dimension
            object - `java.lang.String`"
  ([^java.awt.Dimension this]
    (-> this (.toString))))

