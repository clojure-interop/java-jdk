(ns jdk.awt.Rectangle
  "A Rectangle specifies an area in a coordinate space that is
  enclosed by the Rectangle object's upper-left point
  (x,y)
  in the coordinate space, its width, and its height.

  A Rectangle object's width and
  height are public fields. The constructors
  that create a Rectangle, and the methods that can modify
  one, do not prevent setting a negative value for width or height.


  A Rectangle whose width or height is exactly zero has location
  along those axes with zero dimension, but is otherwise considered empty.
  The isEmpty() method will return true for such a Rectangle.
  Methods which test if an empty Rectangle contains or intersects
  a point or rectangle will always return false if either dimension is zero.
  Methods which combine such a Rectangle with a point or rectangle
  will include the location of the Rectangle on that axis in the
  result as if the add(Point) method were being called.



  A Rectangle whose width or height is negative has neither
  location nor dimension along those axes with negative dimensions.
  Such a Rectangle is treated as non-existant along those axes.
  Such a Rectangle is also empty with respect to containment
  calculations and methods which test if it contains or intersects a
  point or rectangle will always return false.
  Methods which combine such a Rectangle with a point or rectangle
  will ignore the Rectangle entirely in generating the result.
  If two Rectangle objects are combined and each has a negative
  dimension, the result will have at least one negative dimension.


  Methods which affect only the location of a Rectangle will
  operate on its location regardless of whether or not it has a negative
  or zero dimension along either axis.

  Note that a Rectangle constructed with the default no-argument
  constructor will have dimensions of 0x0 and therefore be empty.
  That Rectangle will still have a location of (0,0) and
  will contribute that location to the union and add operations.
  Code attempting to accumulate the bounds of a set of points should
  therefore initially construct the Rectangle with a specifically
  negative width and height or it should use the first point in the set
  to construct the Rectangle.
  For example:


      Rectangle bounds = new Rectangle(0, 0, -1, -1);
      for (int i = 0; i < points.length; i++) {
          bounds.add(points[i]);
      }
  or if we know that the points array contains at least one point:


      Rectangle bounds = new Rectangle(points[0]);
      for (int i = 1; i < points.length; i++) {
          bounds.add(points[i]);
      }

  This class uses 32-bit integers to store its location and dimensions.
  Frequently operations may produce a result that exceeds the range of
  a 32-bit integer.
  The methods will calculate their results in a way that avoids any
  32-bit overflow for intermediate results and then choose the best
  representation to store the final results back into the 32-bit fields
  which hold the location and dimensions.
  The location of the result will be stored into the x and
  y fields by clipping the true result to the nearest 32-bit value.
  The values stored into the width and height dimension
  fields will be chosen as the 32-bit values that encompass the largest
  part of the true result as possible.
  Generally this means that the dimension will be clipped independently
  to the range of 32-bit integers except that if the location had to be
  moved to store it into its pair of 32-bit fields then the dimensions
  will be adjusted relative to the `best representation` of the location.
  If the true result had a negative dimension and was therefore
  non-existant along one or both axes, the stored dimensions will be
  negative numbers in those axes.
  If the true result had a location that could be represented within
  the range of 32-bit integers, but zero dimension along one or both
  axes, then the stored dimensions will be zero in those axes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Rectangle]))

(defn ->rectangle
  "Constructor.

  Constructs a new Rectangle whose upper-left corner is
   specified as
   (x,y) and whose width and height
   are specified by the arguments of the same name.

  x - the specified X coordinate - `int`
  y - the specified Y coordinate - `int`
  width - the width of the Rectangle - `int`
  height - the height of the Rectangle - `int`"
  (^Rectangle [^Integer x ^Integer y ^Integer width ^Integer height]
    (new Rectangle x y width height))
  (^Rectangle [^Integer width ^Integer height]
    (new Rectangle width height))
  (^Rectangle [^java.awt.Rectangle r]
    (new Rectangle r))
  (^Rectangle []
    (new Rectangle )))

(defn -x
  "Instance Field.

  The X coordinate of the upper-left corner of the Rectangle.

  type: int"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of the upper-left corner of the Rectangle.

  type: int"
  [this]
  (-> this .-y))

(defn -width
  "Instance Field.

  The width of the Rectangle.

  type: int"
  [this]
  (-> this .-width))

(defn -height
  "Instance Field.

  The height of the Rectangle.

  type: int"
  [this]
  (-> this .-height))

(defn set-rect
  "Sets the bounds of this Rectangle to the integer bounds
   which encompass the specified x, y, width,
   and height.
   If the parameters specify a Rectangle that exceeds the
   maximum range of integers, the result will be the best
   representation of the specified Rectangle intersected
   with the maximum integer bounds.

  x - the X coordinate of the upper-left corner of the specified rectangle - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangle - `double`
  width - the width of the specified rectangle - `double`
  height - the new height of the specified rectangle - `double`"
  ([^Rectangle this ^Double x ^Double y ^Double width ^Double height]
    (-> this (.setRect x y width height))))

(defn get-location
  "Returns the location of this Rectangle.

   This method is included for completeness, to parallel the
   getLocation method of Component.

  returns: the Point that is the upper-left corner of
                    this Rectangle. - `java.awt.Point`"
  (^java.awt.Point [^Rectangle this]
    (-> this (.getLocation))))

(defn get-width
  "Returns the width of the bounding Rectangle in
   double precision.

  returns: the width of the bounding Rectangle. - `double`"
  (^Double [^Rectangle this]
    (-> this (.getWidth))))

(defn set-location
  "Moves this Rectangle to the specified location.

   This method is included for completeness, to parallel the
   setLocation method of Component.

  x - the X coordinate of the new location - `int`
  y - the Y coordinate of the new location - `int`"
  ([^Rectangle this ^Integer x ^Integer y]
    (-> this (.setLocation x y)))
  ([^Rectangle this ^java.awt.Point p]
    (-> this (.setLocation p))))

(defn translate
  "Translates this Rectangle the indicated distance,
   to the right along the X coordinate axis, and
   downward along the Y coordinate axis.

  dx - the distance to move this Rectangle along the X axis - `int`
  dy - the distance to move this Rectangle along the Y axis - `int`"
  ([^Rectangle this ^Integer dx ^Integer dy]
    (-> this (.translate dx dy))))

(defn contains
  "Checks whether this Rectangle entirely contains
   the Rectangle
   at the specified location (X,Y) with the
   specified dimensions (W,H).

  x - the specified X coordinate - `int`
  y - the specified Y coordinate - `int`
  w - the width of the Rectangle - `int`
  h - the height of the Rectangle - `int`

  returns: true if the Rectangle specified by
              (X, Y, W, H)
              is entirely enclosed inside this Rectangle;
              false otherwise. - `boolean`"
  (^Boolean [^Rectangle this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.contains x y w h)))
  (^Boolean [^Rectangle this ^Integer x ^Integer y]
    (-> this (.contains x y)))
  (^Boolean [^Rectangle this ^java.awt.Point p]
    (-> this (.contains p))))

(defn union
  "Computes the union of this Rectangle with the
   specified Rectangle. Returns a new
   Rectangle that
   represents the union of the two rectangles.

   If either Rectangle has any dimension less than zero
   the rules for non-existant rectangles
   apply.
   If only one has a dimension less than zero, then the result
   will be a copy of the other Rectangle.
   If both have dimension less than zero, then the result will
   have at least one dimension less than zero.

   If the resulting Rectangle would have a dimension
   too large to be expressed as an int, the result
   will have a dimension of Integer.MAX_VALUE along
   that dimension.

  r - the specified Rectangle - `java.awt.Rectangle`

  returns: the smallest Rectangle containing both
              the specified Rectangle and this
              Rectangle. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Rectangle this ^java.awt.Rectangle r]
    (-> this (.union r))))

(defn to-string
  "Returns a String representing this
   Rectangle and its values.

  returns: a String representing this
                 Rectangle object's coordinate and size values. - `java.lang.String`"
  (^java.lang.String [^Rectangle this]
    (-> this (.toString))))

(defn reshape
  "Deprecated. As of JDK version 1.1,
   replaced by setBounds(int, int, int, int).

  x - the new X coordinate for the upper-left corner of this Rectangle - `int`
  y - the new Y coordinate for the upper-left corner of this Rectangle - `int`
  width - the new width for this Rectangle - `int`
  height - the new height for this Rectangle - `int`"
  ([^Rectangle this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.reshape x y width height))))

(defn create-intersection
  "Returns a new Rectangle2D object representing the
   intersection of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be intersected with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the largest Rectangle2D contained in both
            the specified Rectangle2D and in this
            Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^Rectangle this ^java.awt.geom.Rectangle2D r]
    (-> this (.createIntersection r))))

(defn get-y
  "Returns the Y coordinate of the bounding Rectangle in
   double precision.

  returns: the Y coordinate of the bounding Rectangle. - `double`"
  (^Double [^Rectangle this]
    (-> this (.getY))))

(defn create-union
  "Returns a new Rectangle2D object representing the
   union of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be combined with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the smallest Rectangle2D containing both
   the specified Rectangle2D and this
   Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^Rectangle this ^java.awt.geom.Rectangle2D r]
    (-> this (.createUnion r))))

(defn get-x
  "Returns the X coordinate of the bounding Rectangle in
   double precision.

  returns: the X coordinate of the bounding Rectangle. - `double`"
  (^Double [^Rectangle this]
    (-> this (.getX))))

(defn intersection
  "Computes the intersection of this Rectangle with the
   specified Rectangle. Returns a new Rectangle
   that represents the intersection of the two rectangles.
   If the two rectangles do not intersect, the result will be
   an empty rectangle.

  r - the specified Rectangle - `java.awt.Rectangle`

  returns: the largest Rectangle contained in both the
              specified Rectangle and in
              this Rectangle; or if the rectangles
              do not intersect, an empty rectangle. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Rectangle this ^java.awt.Rectangle r]
    (-> this (.intersection r))))

(defn get-height
  "Returns the height of the bounding Rectangle in
   double precision.

  returns: the height of the bounding Rectangle. - `double`"
  (^Double [^Rectangle this]
    (-> this (.getHeight))))

(defn outcode
  "Determines where the specified coordinates lie with respect
   to this Rectangle2D.
   This method computes a binary OR of the appropriate mask values
   indicating, for each side of this Rectangle2D,
   whether or not the specified coordinates are on the same side
   of the edge as the rest of this Rectangle2D.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`

  returns: the logical OR of all appropriate out codes. - `int`"
  (^Integer [^Rectangle this ^Double x ^Double y]
    (-> this (.outcode x y))))

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
  (^java.awt.geom.Rectangle2D [^Rectangle this]
    (-> this (.getBounds2D))))

(defn move
  "Deprecated. As of JDK version 1.1,
   replaced by setLocation(int, int).

  x - the X coordinate of the new location - `int`
  y - the Y coordinate of the new location - `int`"
  ([^Rectangle this ^Integer x ^Integer y]
    (-> this (.move x y))))

(defn set-size
  "Sets the size of this Rectangle to the specified
   width and height.

   This method is included for completeness, to parallel the
   setSize method of Component.

  width - the new width for this Rectangle - `int`
  height - the new height for this Rectangle - `int`"
  ([^Rectangle this ^Integer width ^Integer height]
    (-> this (.setSize width height)))
  ([^Rectangle this ^java.awt.Dimension d]
    (-> this (.setSize d))))

(defn inside
  "Deprecated. As of JDK version 1.1,
   replaced by contains(int, int).

  x - the specified X coordinate - `int`
  y - the specified Y coordinate - `int`

  returns: true if the point
              (X,Y) is inside this
              Rectangle;
              false otherwise. - `boolean`"
  (^Boolean [^Rectangle this ^Integer x ^Integer y]
    (-> this (.inside x y))))

(defn get-bounds
  "Gets the bounding Rectangle of this Rectangle.

   This method is included for completeness, to parallel the
   getBounds method of
   Component.

  returns: a new Rectangle, equal to the
   bounding Rectangle for this Rectangle. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^Rectangle this]
    (-> this (.getBounds))))

(defn set-bounds
  "Sets the bounding Rectangle of this
   Rectangle to the specified
   x, y, width,
   and height.

   This method is included for completeness, to parallel the
   setBounds method of Component.

  x - the new X coordinate for the upper-left corner of this Rectangle - `int`
  y - the new Y coordinate for the upper-left corner of this Rectangle - `int`
  width - the new width for this Rectangle - `int`
  height - the new height for this Rectangle - `int`"
  ([^Rectangle this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.setBounds x y width height)))
  ([^Rectangle this ^java.awt.Rectangle r]
    (-> this (.setBounds r))))

(defn add
  "Adds a point, specified by the integer arguments newx,newy
   to the bounds of this Rectangle.

   If this Rectangle has any dimension less than zero,
   the rules for non-existant
   rectangles apply.
   In that case, the new bounds of this Rectangle will
   have a location equal to the specified coordinates and
   width and height equal to zero.

   After adding a point, a call to contains with the
   added point as an argument does not necessarily return
   true. The contains method does not
   return true for points on the right or bottom
   edges of a Rectangle. Therefore, if the added point
   falls on the right or bottom edge of the enlarged
   Rectangle, contains returns
   false for that point.
   If the specified point must be contained within the new
   Rectangle, a 1x1 rectangle should be added instead:


       r.add(newx, newy, 1, 1);

  newx - the X coordinate of the new point - `int`
  newy - the Y coordinate of the new point - `int`"
  ([^Rectangle this ^Integer newx ^Integer newy]
    (-> this (.add newx newy)))
  ([^Rectangle this ^java.awt.Point pt]
    (-> this (.add pt))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  (^Boolean [^Rectangle this]
    (-> this (.isEmpty))))

(defn resize
  "Deprecated. As of JDK version 1.1,
   replaced by setSize(int, int).

  width - the new width for this Rectangle - `int`
  height - the new height for this Rectangle - `int`"
  ([^Rectangle this ^Integer width ^Integer height]
    (-> this (.resize width height))))

(defn get-size
  "Gets the size of this Rectangle, represented by
   the returned Dimension.

   This method is included for completeness, to parallel the
   getSize method of Component.

  returns: a Dimension, representing the size of
              this Rectangle. - `java.awt.Dimension`"
  (^java.awt.Dimension [^Rectangle this]
    (-> this (.getSize))))

(defn equals
  "Checks whether two rectangles are equal.

   The result is true if and only if the argument is not
   null and is a Rectangle object that has the
   same upper-left corner, width, and height as
   this Rectangle.

  obj - the Object to compare with this Rectangle - `java.lang.Object`

  returns: true if the objects are equal;
              false otherwise. - `boolean`"
  (^Boolean [^Rectangle this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn intersects
  "Determines whether or not this Rectangle and the specified
   Rectangle intersect. Two rectangles intersect if
   their intersection is nonempty.

  r - the specified Rectangle - `java.awt.Rectangle`

  returns: true if the specified Rectangle
              and this Rectangle intersect;
              false otherwise. - `boolean`"
  (^Boolean [^Rectangle this ^java.awt.Rectangle r]
    (-> this (.intersects r))))

(defn grow
  "Resizes the Rectangle both horizontally and vertically.

   This method modifies the Rectangle so that it is
   h units larger on both the left and right side,
   and v units larger at both the top and bottom.

   The new Rectangle has (x - h, y - v)
   as its upper-left corner,
   width of (width  2h),
   and a height of (height  2v).

   If negative values are supplied for h and
   v, the size of the Rectangle
   decreases accordingly.
   The grow method will check for integer overflow
   and underflow, but does not check whether the resulting
   values of width and height grow
   from negative to non-negative or shrink from non-negative
   to negative.

  h - the horizontal expansion - `int`
  v - the vertical expansion - `int`"
  ([^Rectangle this ^Integer h ^Integer v]
    (-> this (.grow h v))))

