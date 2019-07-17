(ns jdk.awt.geom.Arc2D
  "Arc2D is the abstract superclass for all objects that
  store a 2D arc defined by a framing rectangle,
  start angle, angular extent (length of the arc), and a closure type
  (OPEN, CHORD, or PIE).


  The arc is a partial section of a full ellipse which
  inscribes the framing rectangle of its parent RectangularShape.


  The angles are specified relative to the non-square
  framing rectangle such that 45 degrees always falls on the line from
  the center of the ellipse to the upper right corner of the framing
  rectangle.
  As a result, if the framing rectangle is noticeably longer along one
  axis than the other, the angles to the start and end of the arc segment
  will be skewed farther along the longer axis of the frame.


  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Arc2D]))

(def *-open
  "Static Constant.

  The closure type for an open arc with no path segments
   connecting the two ends of the arc segment.

  type: int"
  Arc2D/OPEN)

(def *-chord
  "Static Constant.

  The closure type for an arc closed by drawing a straight
   line segment from the start of the arc segment to the end of the
   arc segment.

  type: int"
  Arc2D/CHORD)

(def *-pie
  "Static Constant.

  The closure type for an arc closed by drawing straight line
   segments from the start of the arc segment to the center
   of the full ellipse and from that point to the end of the arc segment.

  type: int"
  Arc2D/PIE)

(defn get-angle-start
  "Returns the starting angle of the arc.

  returns: A double value that represents the starting angle
   of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getAngleStart))))

(defn set-arc
  "Sets the location, size, angular extents, and closure type of
   this arc to the specified double values.

  x - The X coordinate of the upper-left corner of the arc. - `double`
  y - The Y coordinate of the upper-left corner of the arc. - `double`
  w - The overall width of the full ellipse of which this arc is a partial section. - `double`
  h - The overall height of the full ellipse of which this arc is a partial section. - `double`
  ang-st - The starting angle of the arc in degrees. - `double`
  ang-ext - The angular extent of the arc in degrees. - `double`
  closure - The closure type for the arc: OPEN, CHORD, or PIE. - `int`"
  ([^java.awt.geom.Arc2D this ^Double x ^Double y ^Double w ^Double h ^Double ang-st ^Double ang-ext ^Integer closure]
    (-> this (.setArc x y w h ang-st ang-ext closure)))
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Point2D loc ^java.awt.geom.Dimension2D size ^Double ang-st ^Double ang-ext ^Integer closure]
    (-> this (.setArc loc size ang-st ang-ext closure)))
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Rectangle2D rect ^Double ang-st ^Double ang-ext ^Integer closure]
    (-> this (.setArc rect ang-st ang-ext closure)))
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Arc2D a]
    (-> this (.setArc a))))

(defn set-angle-extent
  "Sets the angular extent of this arc to the specified double
   value.

  ang-ext - The angular extent of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D this ^Double ang-ext]
    (-> this (.setAngleExtent ang-ext))))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of the
   arc.
   This iterator is multithread safe.
   Arc2D guarantees that
   modifications to the geometry of the arc
   do not affect any iterations of that geometry that
   are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if the untransformed coordinates are desired. - `java.awt.geom.AffineTransform`

  returns: A PathIterator that defines the arc's boundary. - `java.awt.geom.PathIterator`"
  ([^java.awt.geom.Arc2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn get-start-point
  "Returns the starting point of the arc.  This point is the
   intersection of the ray from the center defined by the
   starting angle and the elliptical boundary of the arc.

  returns: A Point2D object representing the
   x,y coordinates of the starting point of the arc. - `java.awt.geom.Point2D`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getStartPoint))))

(defn contains-angle
  "Determines whether or not the specified angle is within the
   angular extents of the arc.

  angle - The angle to test. - `double`

  returns: true if the arc contains the angle,
   false if the arc doesn't contain the angle. - `boolean`"
  ([^java.awt.geom.Arc2D this ^Double angle]
    (-> this (.containsAngle angle))))

(defn set-arc-type
  "Sets the closure type of this arc to the specified value:
   OPEN, CHORD, or PIE.

  type - The integer constant that represents the closure type of this arc: OPEN, CHORD, or PIE. - `int`

  throws: java.lang.IllegalArgumentException - if type is not 0, 1, or 2.+"
  ([^java.awt.geom.Arc2D this ^Integer type]
    (-> this (.setArcType type))))

(defn get-arc-type
  "Returns the arc closure type of the arc: OPEN,
   CHORD, or PIE.

  returns: One of the integer constant closure types defined
   in this class. - `int`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getArcType))))

(defn contains
  "Determines whether or not the interior of the arc entirely contains
   the specified rectangle.

  x - The X coordinate of the rectangle's upper-left corner. - `double`
  y - The Y coordinate of the rectangle's upper-left corner. - `double`
  w - The width of the rectangle. - `double`
  h - The height of the rectangle. - `double`

  returns: true if the arc contains the rectangle,
   false if the arc doesn't contain the rectangle. - `boolean`"
  ([^java.awt.geom.Arc2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.geom.Arc2D this ^Double x ^Double y]
    (-> this (.contains x y)))
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.contains r))))

(defn set-angle-start
  "Sets the starting angle of this arc to the specified double
   value.

  ang-st - The starting angle of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D this ^Double ang-st]
    (-> this (.setAngleStart ang-st))))

(defn set-arc-by-center
  "Sets the position, bounds, angular extents, and closure type of
   this arc to the specified values. The arc is defined by a center
   point and a radius rather than a framing rectangle for the full ellipse.

  x - The X coordinate of the center of the arc. - `double`
  y - The Y coordinate of the center of the arc. - `double`
  radius - The radius of the arc. - `double`
  ang-st - The starting angle of the arc in degrees. - `double`
  ang-ext - The angular extent of the arc in degrees. - `double`
  closure - The closure type for the arc: OPEN, CHORD, or PIE. - `int`"
  ([^java.awt.geom.Arc2D this ^Double x ^Double y ^Double radius ^Double ang-st ^Double ang-ext ^Integer closure]
    (-> this (.setArcByCenter x y radius ang-st ang-ext closure))))

(defn get-bounds-2-d
  "Returns the high-precision framing rectangle of the arc.  The framing
   rectangle contains only the part of this Arc2D that is
   in between the starting and ending angles and contains the pie
   wedge, if this Arc2D has a PIE closure type.

   This method differs from the
   getBounds in that the
   getBounds method only returns the bounds of the
   enclosing ellipse of this Arc2D without considering
   the starting and ending angles of this Arc2D.

  returns: the Rectangle2D that represents the arc's
   framing rectangle. - `java.awt.geom.Rectangle2D`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getBounds2D))))

(defn hash-code
  "Returns the hashcode for this Arc2D.

  returns: the hashcode for this Arc2D. - `int`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.hashCode))))

(defn set-angles
  "Sets the starting angle and angular extent of this arc using two
   sets of coordinates. The first set of coordinates is used to
   determine the angle of the starting point relative to the arc's
   center. The second set of coordinates is used to determine the
   angle of the end point relative to the arc's center.
   The arc will always be non-empty and extend counterclockwise
   from the first point around to the second point.

  x-1 - The X coordinate of the arc's starting point. - `double`
  y-1 - The Y coordinate of the arc's starting point. - `double`
  x-2 - The X coordinate of the arc's ending point. - `double`
  y-2 - The Y coordinate of the arc's ending point. - `double`"
  ([^java.awt.geom.Arc2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.setAngles x-1 y-1 x-2 y-2)))
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D p-2]
    (-> this (.setAngles p-1 p-2))))

(defn set-arc-by-tangent
  "Sets the position, bounds, and angular extents of this arc to the
   specified value. The starting angle of the arc is tangent to the
   line specified by points (p1, p2), the ending angle is tangent to
   the line specified by points (p2, p3), and the arc has the
   specified radius.

  p-1 - The first point that defines the arc. The starting angle of the arc is tangent to the line specified by points (p1, p2). - `java.awt.geom.Point2D`
  p-2 - The second point that defines the arc. The starting angle of the arc is tangent to the line specified by points (p1, p2). The ending angle of the arc is tangent to the line specified by points (p2, p3). - `java.awt.geom.Point2D`
  p-3 - The third point that defines the arc. The ending angle of the arc is tangent to the line specified by points (p2, p3). - `java.awt.geom.Point2D`
  radius - The radius of the arc. - `double`"
  ([^java.awt.geom.Arc2D this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D p-2 ^java.awt.geom.Point2D p-3 ^Double radius]
    (-> this (.setArcByTangent p-1 p-2 p-3 radius))))

(defn set-frame
  "Sets the location and size of the framing rectangle of this
   Shape to the specified rectangular values.
   Note that the arc
   partially inscribes
   the framing rectangle of this RectangularShape.

  x - the X coordinate of the upper-left corner of the specified rectangular shape - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular shape - `double`
  w - the width of the specified rectangular shape - `double`
  h - the height of the specified rectangular shape - `double`"
  ([^java.awt.geom.Arc2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setFrame x y w h))))

(defn equals
  "Determines whether or not the specified Object is
   equal to this Arc2D.  The specified
   Object is equal to this Arc2D
   if it is an instance of Arc2D and if its
   location, size, arc extents and type are the same as this
   Arc2D.

  obj - an Object to be compared with this Arc2D. - `java.lang.Object`

  returns: true if obj is an instance
            of Arc2D and has the same values;
            false otherwise. - `boolean`"
  ([^java.awt.geom.Arc2D this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn intersects
  "Determines whether or not the interior of the arc intersects
   the interior of the specified rectangle.

  x - The X coordinate of the rectangle's upper-left corner. - `double`
  y - The Y coordinate of the rectangle's upper-left corner. - `double`
  w - The width of the rectangle. - `double`
  h - The height of the rectangle. - `double`

  returns: true if the arc intersects the rectangle,
   false if the arc doesn't intersect the rectangle. - `boolean`"
  ([^java.awt.geom.Arc2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h))))

(defn get-angle-extent
  "Returns the angular extent of the arc.

  returns: A double value that represents the angular extent
   of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getAngleExtent))))

(defn get-end-point
  "Returns the ending point of the arc.  This point is the
   intersection of the ray from the center defined by the
   starting angle plus the angular extent of the arc and the
   elliptical boundary of the arc.

  returns: A Point2D object representing the
   x,y coordinates  of the ending point of the arc. - `java.awt.geom.Point2D`"
  ([^java.awt.geom.Arc2D this]
    (-> this (.getEndPoint))))

