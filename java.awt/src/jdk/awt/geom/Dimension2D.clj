(ns jdk.awt.geom.Dimension2D
  "The Dimension2D class is to encapsulate a width
  and a height dimension.

  This class is only the abstract superclass for all objects that
  store a 2D dimension.
  The actual storage representation of the sizes is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Dimension2D]))

(defn get-width
  "Returns the width of this Dimension in double
   precision.

  returns: the width of this Dimension. - `double`"
  (^Double [^java.awt.geom.Dimension2D this]
    (-> this (.getWidth))))

(defn get-height
  "Returns the height of this Dimension in double
   precision.

  returns: the height of this Dimension. - `double`"
  (^Double [^java.awt.geom.Dimension2D this]
    (-> this (.getHeight))))

(defn set-size
  "Sets the size of this Dimension object to the
   specified width and height.
   This method is included for completeness, to parallel the
   getSize method of
   Component.

  width - the new width for the Dimension object - `double`
  height - the new height for the Dimension object - `double`"
  ([^java.awt.geom.Dimension2D this ^Double width ^Double height]
    (-> this (.setSize width height)))
  ([^java.awt.geom.Dimension2D this ^java.awt.geom.Dimension2D d]
    (-> this (.setSize d))))

(defn clone
  "Creates a new object of the same class as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^java.awt.geom.Dimension2D this]
    (-> this (.clone))))

