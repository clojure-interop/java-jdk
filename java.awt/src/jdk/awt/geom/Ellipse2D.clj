(ns jdk.awt.geom.Ellipse2D
  "The Ellipse2D class describes an ellipse that is defined
  by a framing rectangle.

  This class is only the abstract superclass for all objects which
  store a 2D ellipse.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Ellipse2D]))

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
  (^Boolean [^Ellipse2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  (^Boolean [^Ellipse2D this ^Double x ^Double y]
    (-> this (.contains x y))))

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
  (^Boolean [^Ellipse2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h))))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of this
   Ellipse2D.
   The iterator for this class is multi-threaded safe, which means
   that this Ellipse2D class guarantees that
   modifications to the geometry of this Ellipse2D
   object do not affect any iterations of that geometry that
   are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`

  returns: the PathIterator object that returns the
            geometry of the outline of this Ellipse2D,
            one segment at a time. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^Ellipse2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn hash-code
  "Returns the hashcode for this Ellipse2D.

  returns: the hashcode for this Ellipse2D. - `int`"
  (^Integer [^Ellipse2D this]
    (-> this (.hashCode))))

(defn equals
  "Determines whether or not the specified Object is
   equal to this Ellipse2D.  The specified
   Object is equal to this Ellipse2D
   if it is an instance of Ellipse2D and if its
   location and size are the same as this Ellipse2D.

  obj - an Object to be compared with this Ellipse2D. - `java.lang.Object`

  returns: true if obj is an instance
            of Ellipse2D and has the same values;
            false otherwise. - `boolean`"
  (^Boolean [^Ellipse2D this ^java.lang.Object obj]
    (-> this (.equals obj))))

