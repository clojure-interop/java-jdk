(ns jdk.awt.GradientPaint
  "The GradientPaint class provides a way to fill
  a Shape with a linear color gradient pattern.
  If Point P1 with Color C1 and Point P2 with
  Color C2 are specified in user space, the
  Color on the P1, P2 connecting line is proportionally
  changed from C1 to C2.  Any point P not on the extended P1, P2
  connecting line has the color of the point P' that is the perpendicular
  projection of P on the extended P1, P2 connecting line.
  Points on the extended line outside of the P1, P2 segment can be colored
  in one of two ways.


  If the gradient is cyclic then the points on the extended P1, P2
  connecting line cycle back and forth between the colors C1 and C2.

  If the gradient is acyclic then points on the P1 side of the segment
  have the constant Color C1 while points on the P2 side
  have the constant Color C2."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GradientPaint]))

(defn ->gradient-paint
  "Constructor.

  Constructs either a cyclic or acyclic GradientPaint
   object depending on the boolean parameter.

  x-1 - x coordinate of the first specified Point in user space - `float`
  y-1 - y coordinate of the first specified Point in user space - `float`
  color-1 - Color at the first specified Point - `java.awt.Color`
  x-2 - x coordinate of the second specified Point in user space - `float`
  y-2 - y coordinate of the second specified Point in user space - `float`
  color-2 - Color at the second specified Point - `java.awt.Color`
  cyclic - true if the gradient pattern should cycle repeatedly between the two colors; false otherwise - `boolean`"
  (^GradientPaint [^Float x-1 ^Float y-1 ^java.awt.Color color-1 ^Float x-2 ^Float y-2 ^java.awt.Color color-2 ^Boolean cyclic]
    (new GradientPaint x-1 y-1 color-1 x-2 y-2 color-2 cyclic))
  (^GradientPaint [^Float x-1 ^Float y-1 ^java.awt.Color color-1 ^Float x-2 ^Float y-2 ^java.awt.Color color-2]
    (new GradientPaint x-1 y-1 color-1 x-2 y-2 color-2))
  (^GradientPaint [^java.awt.geom.Point2D pt-1 ^java.awt.Color color-1 ^java.awt.geom.Point2D pt-2 ^java.awt.Color color-2 ^Boolean cyclic]
    (new GradientPaint pt-1 color-1 pt-2 color-2 cyclic))
  (^GradientPaint [^java.awt.geom.Point2D pt-1 ^java.awt.Color color-1 ^java.awt.geom.Point2D pt-2 ^java.awt.Color color-2]
    (new GradientPaint pt-1 color-1 pt-2 color-2)))

(defn get-point-1
  "Returns a copy of the point P1 that anchors the first color.

  returns: a Point2D object that is a copy of the point
   that anchors the first color of this
   GradientPaint. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^GradientPaint this]
    (-> this (.getPoint1))))

(defn get-color-1
  "Returns the color C1 anchored by the point P1.

  returns: a Color object that is the color
   anchored by P1. - `java.awt.Color`"
  (^java.awt.Color [^GradientPaint this]
    (-> this (.getColor1))))

(defn get-point-2
  "Returns a copy of the point P2 which anchors the second color.

  returns: a Point2D object that is a copy of the point
   that anchors the second color of this
   GradientPaint. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^GradientPaint this]
    (-> this (.getPoint2))))

(defn get-color-2
  "Returns the color C2 anchored by the point P2.

  returns: a Color object that is the color
   anchored by P2. - `java.awt.Color`"
  (^java.awt.Color [^GradientPaint this]
    (-> this (.getColor2))))

(defn cyclic?
  "Returns true if the gradient cycles repeatedly
   between the two colors C1 and C2.

  returns: true if the gradient cycles repeatedly
   between the two colors; false otherwise. - `boolean`"
  (^Boolean [^GradientPaint this]
    (-> this (.isCyclic))))

(defn create-context
  "Creates and returns a PaintContext used to
   generate a linear color gradient pattern.
   See the specification of the
   method in the Paint interface for information
   on null parameter handling.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  device-bounds - the device space bounding box of the graphics primitive being rendered. - `java.awt.Rectangle`
  user-bounds - the user space bounding box of the graphics primitive being rendered. - `java.awt.geom.Rectangle2D`
  xform - the AffineTransform from user space into device space. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  (^java.awt.PaintContext [^GradientPaint this ^java.awt.image.ColorModel cm ^java.awt.Rectangle device-bounds ^java.awt.geom.Rectangle2D user-bounds ^java.awt.geom.AffineTransform xform ^java.awt.RenderingHints hints]
    (-> this (.createContext cm device-bounds user-bounds xform hints))))

(defn get-transparency
  "Returns the transparency mode for this GradientPaint.

  returns: an integer value representing this GradientPaint
   object's transparency mode. - `int`"
  (^Integer [^GradientPaint this]
    (-> this (.getTransparency))))

