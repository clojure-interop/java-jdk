(ns jdk.awt.BasicStroke
  "The BasicStroke class defines a basic set of rendering
  attributes for the outlines of graphics primitives, which are rendered
  with a Graphics2D object that has its Stroke attribute set to
  this BasicStroke.
  The rendering attributes defined by BasicStroke describe
  the shape of the mark made by a pen drawn along the outline of a
  Shape and the decorations applied at the ends and joins of
  path segments of the Shape.
  These rendering attributes include:

  width
  The pen width, measured perpendicularly to the pen trajectory.
  end caps
  The decoration applied to the ends of unclosed subpaths and
  dash segments.  Subpaths that start and end on the same point are
  still considered unclosed if they do not have a CLOSE segment.
  See SEG_CLOSE
  for more information on the CLOSE segment.
  The three different decorations are: CAP_BUTT,
  CAP_ROUND, and CAP_SQUARE.
  line joins
  The decoration applied at the intersection of two path segments
  and at the intersection of the endpoints of a subpath that is closed
  using SEG_CLOSE.
  The three different decorations are: JOIN_BEVEL,
  JOIN_MITER, and JOIN_ROUND.
  miter limit
  The limit to trim a line join that has a JOIN_MITER decoration.
  A line join is trimmed when the ratio of miter length to stroke
  width is greater than the miterlimit value.  The miter length is
  the diagonal length of the miter, which is the distance between
  the inside corner and the outside corner of the intersection.
  The smaller the angle formed by two line segments, the longer
  the miter length and the sharper the angle of intersection.  The
  default miterlimit value of 10.0f causes all angles less than
  11 degrees to be trimmed.  Trimming miters converts
  the decoration of the line join to bevel.
  dash attributes
  The definition of how to make a dash pattern by alternating
  between opaque and transparent sections.

  All attributes that specify measurements and distances controlling
  the shape of the returned outline are measured in the same
  coordinate system as the original unstroked Shape
  argument.  When a Graphics2D object uses a
  Stroke object to redefine a path during the execution
  of one of its draw methods, the geometry is supplied
  in its original form before the Graphics2D transform
  attribute is applied.  Therefore, attributes such as the pen width
  are interpreted in the user space coordinate system of the
  Graphics2D object and are subject to the scaling and
  shearing effects of the user-space-to-device-space transform in that
  particular Graphics2D.
  For example, the width of a rendered shape's outline is determined
  not only by the width attribute of this BasicStroke,
  but also by the transform attribute of the
  Graphics2D object.  Consider this code:

       // sets the Graphics2D object's Transform attribute
       g2d.scale(10, 10);
       // sets the Graphics2D object's Stroke attribute
       g2d.setStroke(new BasicStroke(1.5f));

  Assuming there are no other scaling transforms added to the
  Graphics2D object, the resulting line
  will be approximately 15 pixels wide.
  As the example code demonstrates, a floating-point line
  offers better precision, especially when large transforms are
  used with a Graphics2D object.
  When a line is diagonal, the exact width depends on how the
  rendering pipeline chooses which pixels to fill as it traces the
  theoretical widened outline.  The choice of which pixels to turn
  on is affected by the antialiasing attribute because the
  antialiasing rendering pipeline can choose to color
  partially-covered pixels.

  For more information on the user space coordinate system and the
  rendering process, see the Graphics2D class comments."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt BasicStroke]))

(defn ->basic-stroke
  "Constructor.

  Constructs a new BasicStroke with the specified
   attributes.

  width - the width of this BasicStroke. The width must be greater than or equal to 0.0f. If width is set to 0.0f, the stroke is rendered as the thinnest possible line for the target device and the antialias hint setting. - `float`
  cap - the decoration of the ends of a BasicStroke - `int`
  join - the decoration applied where path segments meet - `int`
  miterlimit - the limit to trim the miter join. The miterlimit must be greater than or equal to 1.0f. - `float`
  dash - the array representing the dashing pattern - `float[]`
  dash-phase - the offset to start the dashing pattern - `float`

  throws: java.lang.IllegalArgumentException - if dash lengths are all zero."
  ([width cap join miterlimit dash dash-phase]
    (new BasicStroke width cap join miterlimit dash dash-phase))
  ([width cap join miterlimit]
    (new BasicStroke width cap join miterlimit))
  ([width cap join]
    (new BasicStroke width cap join))
  ([width]
    (new BasicStroke width))
  ([]
    (new BasicStroke )))

(def *-join-miter
  "Static Constant.

  Joins path segments by extending their outside edges until
   they meet.

  type: java.lang.annotation.    int"
  BasicStroke/JOIN_MITER)

(def *-join-round
  "Static Constant.

  Joins path segments by rounding off the corner at a radius
   of half the line width.

  type: java.lang.annotation.    int"
  BasicStroke/JOIN_ROUND)

(def *-join-bevel
  "Static Constant.

  Joins path segments by connecting the outer corners of their
   wide outlines with a straight segment.

  type: java.lang.annotation.    int"
  BasicStroke/JOIN_BEVEL)

(def *-cap-butt
  "Static Constant.

  Ends unclosed subpaths and dash segments with no added
   decoration.

  type: java.lang.annotation.    int"
  BasicStroke/CAP_BUTT)

(def *-cap-round
  "Static Constant.

  Ends unclosed subpaths and dash segments with a round
   decoration that has a radius equal to half of the width
   of the pen.

  type: java.lang.annotation.    int"
  BasicStroke/CAP_ROUND)

(def *-cap-square
  "Static Constant.

  Ends unclosed subpaths and dash segments with a square
   projection that extends beyond the end of the segment
   to a distance equal to half of the line width.

  type: java.lang.annotation.    int"
  BasicStroke/CAP_SQUARE)

(defn get-dash-array
  "Returns the array representing the lengths of the dash segments.
   Alternate entries in the array represent the user space lengths
   of the opaque and transparent segments of the dashes.
   As the pen moves along the outline of the Shape
   to be stroked, the user space
   distance that the pen travels is accumulated.  The distance
   value is used to index into the dash array.
   The pen is opaque when its current cumulative distance maps
   to an even element of the dash array and transparent otherwise.

  returns: the dash array. - `float[]`"
  ([this]
    (-> this (.getDashArray))))

(defn get-end-cap
  "Returns the end cap style.

  returns: the end cap style of this BasicStroke as one
   of the static int values that define possible end cap
   styles. - `int`"
  ([this]
    (-> this (.getEndCap))))

(defn get-dash-phase
  "Returns the current dash phase.
   The dash phase is a distance specified in user coordinates that
   represents an offset into the dashing pattern. In other words, the dash
   phase defines the point in the dashing pattern that will correspond to
   the beginning of the stroke.

  returns: the dash phase as a float value. - `float`"
  ([this]
    (-> this (.getDashPhase))))

(defn get-line-join
  "Returns the line join style.

  returns: the line join style of the BasicStroke as one
   of the static int values that define possible line
   join styles. - `int`"
  ([this]
    (-> this (.getLineJoin))))

(defn create-stroked-shape
  "Returns a Shape whose interior defines the
   stroked outline of a specified Shape.

  s - the Shape boundary be stroked - `java.awt.Shape`

  returns: the Shape of the stroked outline. - `java.awt.Shape`"
  ([this s]
    (-> this (.createStrokedShape s))))

(defn get-line-width
  "Returns the line width.  Line width is represented in user space,
   which is the default-coordinate space used by Java 2D.  See the
   Graphics2D class comments for more information on
   the user space coordinate system.

  returns: the line width of this BasicStroke. - `float`"
  ([this]
    (-> this (.getLineWidth))))

(defn hash-code
  "Returns the hashcode for this stroke.

  returns: a hash code for this stroke. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Tests if a specified object is equal to this BasicStroke
   by first testing if it is a BasicStroke and then comparing
   its width, join, cap, miter limit, dash, and dash phase attributes with
   those of this BasicStroke.

  obj - the specified object to compare to this BasicStroke - `java.lang.Object`

  returns: true if the width, join, cap, miter limit, dash, and
              dash phase are the same for both objects;
              false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn get-miter-limit
  "Returns the limit of miter joins.

  returns: the limit of miter joins of the BasicStroke. - `float`"
  ([this]
    (-> this (.getMiterLimit))))

