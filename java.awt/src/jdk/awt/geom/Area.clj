(ns jdk.awt.geom.Area
  "An Area object stores and manipulates a
  resolution-independent description of an enclosed area of
  2-dimensional space.
  Area objects can be transformed and can perform
  various Constructive Area Geometry (CAG) operations when combined
  with other Area objects.
  The CAG operations include area
  addition, subtraction,
  intersection, and exclusive or.
  See the linked method documentation for examples of the various
  operations.

  The Area class implements the Shape
  interface and provides full support for all of its hit-testing
  and path iteration facilities, but an Area is more
  specific than a generalized path in a number of ways:

  Only closed paths and sub-paths are stored.
      Area objects constructed from unclosed paths
      are implicitly closed during construction as if those paths
      had been filled by the Graphics2D.fill method.
  The interiors of the individual stored sub-paths are all
      non-empty and non-overlapping.  Paths are decomposed during
      construction into separate component non-overlapping parts,
      empty pieces of the path are discarded, and then these
      non-empty and non-overlapping properties are maintained
      through all subsequent CAG operations.  Outlines of different
      component sub-paths may touch each other, as long as they
      do not cross so that their enclosed areas overlap.
  The geometry of the path describing the outline of the
      Area resembles the path from which it was
      constructed only in that it describes the same enclosed
      2-dimensional area, but may use entirely different types
      and ordering of the path segments to do so.

  Interesting issues which are not always obvious when using
  the Area include:

  Creating an Area from an unclosed (open)
      Shape results in a closed outline in the
      Area object.
  Creating an Area from a Shape
      which encloses no area (even when `closed`) produces an
      empty Area.  A common example of this issue
      is that producing an Area from a line will
      be empty since the line encloses no area.  An empty
      Area will iterate no geometry in its
      PathIterator objects.
  A self-intersecting Shape may be split into
      two (or more) sub-paths each enclosing one of the
      non-intersecting portions of the original path.
  An Area may take more path segments to
      describe the same geometry even when the original
      outline is simple and obvious.  The analysis that the
      Area class must perform on the path may
      not reflect the same concepts of `simple and obvious`
      as a human being perceives."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Area]))

(defn ->area
  "Constructor.

  The Area class creates an area geometry from the
   specified Shape object.  The geometry is explicitly
   closed, if the Shape is not already closed.  The
   fill rule (even-odd or winding) specified by the geometry of the
   Shape is used to determine the resulting enclosed area.

  s - the Shape from which the area is constructed - `java.awt.Shape`

  throws: java.lang.NullPointerException - if s is null"
  ([^java.awt.Shape s]
    (new Area s))
  ([]
    (new Area )))

(defn get-path-iterator
  "Creates a PathIterator for the flattened outline of
   this Area object.  Only uncurved path segments
   represented by the SEG_MOVETO, SEG_LINETO, and SEG_CLOSE point
   types are returned by the iterator.  This Area
   object is unchanged.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum amount that the control points for a given curve can vary from colinear before a subdivided curve is replaced by a straight line connecting the end points - `double`

  returns: the PathIterator object that returns the
   geometry of the outline of this Area, one segment
   at a time. - `java.awt.geom.PathIterator`"
  ([^java.awt.geom.Area this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  ([^java.awt.geom.Area this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn singular?
  "Tests whether this Area is comprised of a single
   closed subpath.  This method returns true if the
   path contains 0 or 1 subpaths, or false if the path
   contains more than 1 subpath.  The subpaths are counted by the
   number of SEG_MOVETO  segments
   that appear in the path.

  returns: true if the Area is comprised
   of a single basic geometry; false otherwise. - `boolean`"
  ([^java.awt.geom.Area this]
    (-> this (.isSingular))))

(defn intersect
  "Sets the shape of this Area to the intersection of
   its current shape and the shape of the specified Area.
   The resulting shape of this Area will include
   only areas that were contained in both this Area
   and also in the specified Area.


       // Example:
       Area a1 = new Area([triangle 0,0 => 8,0 => 0,8]);
       Area a2 = new Area([triangle 0,0 => 8,0 => 8,8]);
       a1.intersect(a2);

        a1(before)   intersect     a2         =     a1(after)

       ################     ################     ################
       ##############         ##############       ############
       ############             ############         ########
       ##########                 ##########           ####
       ########                     ########
       ######                         ######
       ####                             ####
       ##                                 ##

  rhs - the Area to be intersected with this Area - `java.awt.geom.Area`

  throws: java.lang.NullPointerException - if rhs is null"
  ([^java.awt.geom.Area this ^java.awt.geom.Area rhs]
    (-> this (.intersect rhs))))

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
  ([^java.awt.geom.Area this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.geom.Area this ^Double x ^Double y]
    (-> this (.contains x y)))
  ([^java.awt.geom.Area this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn polygonal?
  "Tests whether this Area consists entirely of
   straight edged polygonal geometry.

  returns: true if the geometry of this
   Area consists entirely of line segments;
   false otherwise. - `boolean`"
  ([^java.awt.geom.Area this]
    (-> this (.isPolygonal))))

(defn transform
  "Transforms the geometry of this Area using the specified
   AffineTransform.  The geometry is transformed in place, which
   permanently changes the enclosed area defined by this object.

  t - the transformation used to transform the area - `java.awt.geom.AffineTransform`

  throws: java.lang.NullPointerException - if t is null"
  ([^java.awt.geom.Area this ^java.awt.geom.AffineTransform t]
    (-> this (.transform t))))

(defn reset
  "Removes all of the geometry from this Area and
   restores it to an empty area."
  ([^java.awt.geom.Area this]
    (-> this (.reset))))

(defn subtract
  "Subtracts the shape of the specified Area from the
   shape of this Area.
   The resulting shape of this Area will include
   areas that were contained only in this Area
   and not in the specified Area.


       // Example:
       Area a1 = new Area([triangle 0,0 => 8,0 => 0,8]);
       Area a2 = new Area([triangle 0,0 => 8,0 => 8,8]);
       a1.subtract(a2);

          a1(before)     -         a2         =     a1(after)

       ################     ################
       ##############         ##############     ##
       ############             ############     ####
       ##########                 ##########     ######
       ########                     ########     ########
       ######                         ######     ######
       ####                             ####     ####
       ##                                 ##     ##

  rhs - the Area to be subtracted from the current shape - `java.awt.geom.Area`

  throws: java.lang.NullPointerException - if rhs is null"
  ([^java.awt.geom.Area this ^java.awt.geom.Area rhs]
    (-> this (.subtract rhs))))

(defn get-bounds-2-d
  "Returns a high precision bounding Rectangle2D that
   completely encloses this Area.

   The Area class will attempt to return the tightest bounding
   box possible for the Shape.  The bounding box will not be
   padded to include the control points of curves in the outline
   of the Shape, but should tightly fit the actual geometry of
   the outline itself.

  returns: the bounding Rectangle2D for the
   Area. - `java.awt.geom.Rectangle2D`"
  ([^java.awt.geom.Area this]
    (-> this (.getBounds2D))))

(defn exclusive-or
  "Sets the shape of this Area to be the combined area
   of its current shape and the shape of the specified Area,
   minus their intersection.
   The resulting shape of this Area will include
   only areas that were contained in either this Area
   or in the specified Area, but not in both.


       // Example:
       Area a1 = new Area([triangle 0,0 => 8,0 => 0,8]);
       Area a2 = new Area([triangle 0,0 => 8,0 => 8,8]);
       a1.exclusiveOr(a2);

          a1(before)    xor        a2         =     a1(after)

       ################     ################
       ##############         ##############     ##            ##
       ############             ############     ####        ####
       ##########                 ##########     ######    ######
       ########                     ########     ################
       ######                         ######     ######    ######
       ####                             ####     ####        ####
       ##                                 ##     ##            ##

  rhs - the Area to be exclusive ORed with this Area. - `java.awt.geom.Area`

  throws: java.lang.NullPointerException - if rhs is null"
  ([^java.awt.geom.Area this ^java.awt.geom.Area rhs]
    (-> this (.exclusiveOr rhs))))

(defn clone
  "Returns an exact copy of this Area object.

  returns: Created clone object - `java.lang.Object`"
  ([^java.awt.geom.Area this]
    (-> this (.clone))))

(defn get-bounds
  "Returns a bounding Rectangle that completely encloses
   this Area.

   The Area class will attempt to return the tightest bounding
   box possible for the Shape.  The bounding box will not be
   padded to include the control points of curves in the outline
   of the Shape, but should tightly fit the actual geometry of
   the outline itself.  Since the returned object represents
   the bounding box with integers, the bounding box can only be
   as tight as the nearest integer coordinates that encompass
   the geometry of the Shape.

  returns: the bounding Rectangle for the
   Area. - `java.awt.Rectangle`"
  ([^java.awt.geom.Area this]
    (-> this (.getBounds))))

(defn create-transformed-area
  "Creates a new Area object that contains the same
   geometry as this Area transformed by the specified
   AffineTransform.  This Area object
   is unchanged.

  t - the specified AffineTransform used to transform the new Area - `java.awt.geom.AffineTransform`

  returns: a new Area object representing the transformed
             geometry. - `java.awt.geom.Area`

  throws: java.lang.NullPointerException - if t is null"
  ([^java.awt.geom.Area this ^java.awt.geom.AffineTransform t]
    (-> this (.createTransformedArea t))))

(defn add
  "Adds the shape of the specified Area to the
   shape of this Area.
   The resulting shape of this Area will include
   the union of both shapes, or all areas that were contained
   in either this or the specified Area.


       // Example:
       Area a1 = new Area([triangle 0,0 => 8,0 => 0,8]);
       Area a2 = new Area([triangle 0,0 => 8,0 => 8,8]);
       a1.add(a2);

          a1(before)              a2         =     a1(after)

       ################     ################     ################
       ##############         ##############     ################
       ############             ############     ################
       ##########                 ##########     ################
       ########                     ########     ################
       ######                         ######     ######    ######
       ####                             ####     ####        ####
       ##                                 ##     ##            ##

  rhs - the Area to be added to the current shape - `java.awt.geom.Area`

  throws: java.lang.NullPointerException - if rhs is null"
  ([^java.awt.geom.Area this ^java.awt.geom.Area rhs]
    (-> this (.add rhs))))

(defn empty?
  "Tests whether this Area object encloses any area.

  returns: true if this Area object
   represents an empty area; false otherwise. - `boolean`"
  ([^java.awt.geom.Area this]
    (-> this (.isEmpty))))

(defn equals
  "Tests whether the geometries of the two Area objects
   are equal.
   This method will return false if the argument is null.

  other - the Area to be compared to this Area - `java.awt.geom.Area`

  returns: true if the two geometries are equal;
            false otherwise. - `boolean`"
  ([^java.awt.geom.Area this ^java.awt.geom.Area other]
    (-> this (.equals other))))

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
  ([^java.awt.geom.Area this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  ([^java.awt.geom.Area this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn rectangular?
  "Tests whether this Area is rectangular in shape.

  returns: true if the geometry of this
   Area is rectangular in shape; false
   otherwise. - `boolean`"
  ([^java.awt.geom.Area this]
    (-> this (.isRectangular))))

