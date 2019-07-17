(ns jdk.awt.Shape
  "The Shape interface provides definitions for objects
  that represent some form of geometric shape.  The Shape
  is described by a PathIterator object, which can express the
  outline of the Shape as well as a rule for determining
  how the outline divides the 2D plane into interior and exterior
  points.  Each Shape object provides callbacks to get the
  bounding box of the geometry, determine whether points or
  rectangles lie partly or entirely within the interior
  of the Shape, and retrieve a PathIterator
  object that describes the trajectory path of the Shape
  outline.

  Definition of insideness:
  A point is considered to lie inside a
  Shape if and only if:

   it lies completely
  inside theShape boundary or

  it lies exactly on the Shape boundary and the
  space immediately adjacent to the
  point in the increasing X direction is
  entirely inside the boundary or

  it lies exactly on a horizontal boundary segment and the
  space immediately adjacent to the point in the
  increasing Y direction is inside the boundary.

  The contains and intersects methods
  consider the interior of a Shape to be the area it
  encloses as if it were filled.  This means that these methods
  consider
  unclosed shapes to be implicitly closed for the purpose of
  determining if a shape contains or intersects a rectangle or if a
  shape contains a point."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Shape]))

(defn get-bounds
  "Returns an integer Rectangle that completely encloses the
   Shape.  Note that there is no guarantee that the
   returned Rectangle is the smallest bounding box that
   encloses the Shape, only that the Shape
   lies entirely within the indicated  Rectangle.  The
   returned Rectangle might also fail to completely
   enclose the Shape if the Shape overflows
   the limited range of the integer data type.  The
   getBounds2D method generally returns a
   tighter bounding box due to its greater flexibility in
   representation.


   Note that the
   definition of insideness can lead to situations where points
   on the defining outline of the shape may not be considered
   contained in the returned bounds object, but only in cases
   where those points are also not considered contained in the original
   shape.


   If a point is inside the shape according to the
   contains(point) method, then
   it must be inside the returned Rectangle bounds object
   according to the contains(point)
   method of the bounds. Specifically:


    shape.contains(x,y) requires bounds.contains(x,y)


   If a point is not inside the shape, then it might
   still be contained in the bounds object:


    bounds.contains(x,y) does not imply shape.contains(x,y)

  returns: an integer Rectangle that completely encloses
                   the Shape. - `java.awt.Rectangle`"
  ([^java.awt.Shape this]
    (-> this (.getBounds))))

(defn get-bounds-2-d
  "Returns a high precision and more accurate bounding box of
   the Shape than the getBounds method.
   Note that there is no guarantee that the returned
   Rectangle2D is the smallest bounding box that encloses
   the Shape, only that the Shape lies
   entirely within the indicated Rectangle2D.  The
   bounding box returned by this method is usually tighter than that
   returned by the getBounds method and never fails due
   to overflow problems since the return value can be an instance of
   the Rectangle2D that uses double precision values to
   store the dimensions.


   Note that the
   definition of insideness can lead to situations where points
   on the defining outline of the shape may not be considered
   contained in the returned bounds object, but only in cases
   where those points are also not considered contained in the original
   shape.


   If a point is inside the shape according to the
   contains(point) method, then it must
   be inside the returned Rectangle2D bounds object according
   to the contains(point) method of the
   bounds. Specifically:


    shape.contains(p) requires bounds.contains(p)


   If a point is not inside the shape, then it might
   still be contained in the bounds object:


    bounds.contains(p) does not imply shape.contains(p)

  returns: an instance of Rectangle2D that is a
                   high-precision bounding box of the Shape. - `java.awt.geom.Rectangle2D`"
  ([^java.awt.Shape this]
    (-> this (.getBounds2D))))

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
  ([^java.awt.Shape this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.Shape this ^Double x ^Double y]
    (-> this (.contains x y)))
  ([^java.awt.Shape this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

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
  ([^java.awt.Shape this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  ([^java.awt.Shape this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn get-path-iterator
  "Returns an iterator object that iterates along the Shape
   boundary and provides access to a flattened view of the
   Shape outline geometry.

   Only SEG_MOVETO, SEG_LINETO, and SEG_CLOSE point types are
   returned by the iterator.

   If an optional AffineTransform is specified,
   the coordinates returned in the iteration are transformed
   accordingly.

   The amount of subdivision of the curved segments is controlled
   by the flatness parameter, which specifies the
   maximum distance that any point on the unflattened transformed
   curve can deviate from the returned flattened path segments.
   Note that a limit on the accuracy of the flattened path might be
   silently imposed, causing very small flattening parameters to be
   treated as larger values.  This limit, if there is one, is
   defined by the particular implementation that is used.

   Each call to this method returns a fresh PathIterator
   object that traverses the Shape object geometry
   independently from any other PathIterator objects in use at
   the same time.

   It is recommended, but not guaranteed, that objects
   implementing the Shape interface isolate iterations
   that are in process from any changes that might occur to the original
   object's geometry during such iterations.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum distance that the line segments used to approximate the curved segments are allowed to deviate from any point on the original curve - `double`

  returns: a new PathIterator that independently traverses
           a flattened view of the geometry of the  Shape. - `java.awt.geom.PathIterator`"
  ([^java.awt.Shape this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  ([^java.awt.Shape this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

