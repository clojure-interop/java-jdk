(ns jdk.awt.geom.RoundRectangle2D
  "The RoundRectangle2D class defines a rectangle with
  rounded corners defined by a location (x,y), a
  dimension (w x h), and the width and height of an arc
  with which to round the corners.

  This class is the abstract superclass for all objects that
  store a 2D rounded rectangle.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom RoundRectangle2D]))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of this
   RoundRectangle2D.
   The iterator for this class is multi-threaded safe, which means
   that this RoundRectangle2D class guarantees that
   modifications to the geometry of this RoundRectangle2D
   object do not affect any iterations of that geometry that
   are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`

  returns: the PathIterator object that returns the
            geometry of the outline of this
            RoundRectangle2D, one segment at a time. - `java.awt.geom.PathIterator`"
  ([^java.awt.geom.RoundRectangle2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn contains
  "Tests if the interior of the Shape entirely contains
   the specified rectangular area.  All coordinates that lie inside
   the rectangular area must lie within the Shape for the
   entire rectangular area to be considered contained within the
   Shape.

   The Shape.contains() method allows a Shape
   implementation to conservatively return false when:


   the intersect method returns true and

   the calculations to determine whether or not the
   Shape entirely contains the rectangular area are
   prohibitively expensive.

   This means that for some Shapes this method might
   return false even though the Shape contains
   the rectangular area.
   The Area class performs
   more accurate geometric computations than most
   Shape objects and therefore can be used if a more precise
   answer is required.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the interior of the Shape
            entirely contains the specified rectangular area;
            false otherwise or, if the Shape
            contains the rectangular area and the
            intersects method returns true
            and the containment calculations would be too expensive to
            perform. - `boolean`"
  ([^java.awt.geom.RoundRectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.geom.RoundRectangle2D this ^Double x ^Double y]
    (-> this (.contains x y))))

(defn set-round-rect
  "Sets the location, size, and corner radii of this
   RoundRectangle2D to the specified
   double values.

  x - the X coordinate to which to set the location of this RoundRectangle2D - `double`
  y - the Y coordinate to which to set the location of this RoundRectangle2D - `double`
  w - the width to which to set this RoundRectangle2D - `double`
  h - the height to which to set this RoundRectangle2D - `double`
  arc-width - the width to which to set the arc of this RoundRectangle2D - `double`
  arc-height - the height to which to set the arc of this RoundRectangle2D - `double`"
  ([^java.awt.geom.RoundRectangle2D this ^Double x ^Double y ^Double w ^Double h ^Double arc-width ^Double arc-height]
    (-> this (.setRoundRect x y w h arc-width arc-height)))
  ([^java.awt.geom.RoundRectangle2D this ^java.awt.geom.RoundRectangle2D rr]
    (-> this (.setRoundRect rr))))

(defn get-arc-width
  "Gets the width of the arc that rounds off the corners.

  returns: the width of the arc that rounds off the corners
   of this RoundRectangle2D. - `double`"
  ([^java.awt.geom.RoundRectangle2D this]
    (-> this (.getArcWidth))))

(defn get-arc-height
  "Gets the height of the arc that rounds off the corners.

  returns: the height of the arc that rounds off the corners
   of this RoundRectangle2D. - `double`"
  ([^java.awt.geom.RoundRectangle2D this]
    (-> this (.getArcHeight))))

(defn hash-code
  "Returns the hashcode for this RoundRectangle2D.

  returns: the hashcode for this RoundRectangle2D. - `int`"
  ([^java.awt.geom.RoundRectangle2D this]
    (-> this (.hashCode))))

(defn set-frame
  "Sets the location and size of the framing rectangle of this
   Shape to the specified rectangular values.

  x - the X coordinate of the upper-left corner of the specified rectangular shape - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular shape - `double`
  w - the width of the specified rectangular shape - `double`
  h - the height of the specified rectangular shape - `double`"
  ([^java.awt.geom.RoundRectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setFrame x y w h))))

(defn equals
  "Determines whether or not the specified Object is
   equal to this RoundRectangle2D.  The specified
   Object is equal to this RoundRectangle2D
   if it is an instance of RoundRectangle2D and if its
   location, size, and corner arc dimensions are the same as this
   RoundRectangle2D.

  obj - an Object to be compared with this RoundRectangle2D. - `java.lang.Object`

  returns: true if obj is an instance
            of RoundRectangle2D and has the same values;
            false otherwise. - `boolean`"
  ([^java.awt.geom.RoundRectangle2D this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn intersects
  "Tests if the interior of the Shape intersects the
   interior of a specified rectangular area.
   The rectangular area is considered to intersect the Shape
   if any point is contained in both the interior of the
   Shape and the specified rectangular area.

   The Shape.intersects() method allows a Shape
   implementation to conservatively return true when:


   there is a high probability that the rectangular area and the
   Shape intersect, but

   the calculations to accurately determine this intersection
   are prohibitively expensive.

   This means that for some Shapes this method might
   return true even though the rectangular area does not
   intersect the Shape.
   The Area class performs
   more accurate computations of geometric intersection than most
   Shape objects and therefore can be used if a more precise
   answer is required.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the interior of the Shape and
            the interior of the rectangular area intersect, or are
            both highly likely to intersect and intersection calculations
            would be too expensive to perform; false otherwise. - `boolean`"
  ([^java.awt.geom.RoundRectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h))))

