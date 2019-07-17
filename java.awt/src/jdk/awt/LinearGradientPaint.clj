(ns jdk.awt.LinearGradientPaint
  "The LinearGradientPaint class provides a way to fill
  a Shape with a linear color gradient pattern.  The user
  may specify two or more gradient colors, and this paint will provide an
  interpolation between each color.  The user also specifies start and end
  points which define where in user space the color gradient should begin
  and end.

  The user must provide an array of floats specifying how to distribute the
  colors along the gradient.  These values should range from 0.0 to 1.0 and
  act like keyframes along the gradient (they mark where the gradient should
  be exactly a particular color).

  In the event that the user does not set the first keyframe value equal
  to 0 and/or the last keyframe value equal to 1, keyframes will be created
  at these positions and the first and last colors will be replicated there.
  So, if a user specifies the following arrays to construct a gradient:


      {Color.BLUE, Color.RED}, {.3f, .7f}
  this will be converted to a gradient with the following keyframes:


      {Color.BLUE, Color.BLUE, Color.RED, Color.RED}, {0f, .3f, .7f, 1f}


  The user may also select what action the LinearGradientPaint object
  takes when it is filling the space outside the start and end points by
  setting CycleMethod to either REFLECTION or REPEAT.
  The distances between any two colors in any of the reflected or repeated
  copies of the gradient are the same as the distance between those same two
  colors between the start and end points.
  Note that some minor variations in distances may occur due to sampling at
  the granularity of a pixel.
  If no cycle method is specified, NO_CYCLE will be chosen by
  default, which means the endpoint colors will be used to fill the
  remaining area.

  The colorSpace parameter allows the user to specify in which colorspace
  the interpolation should be performed, default sRGB or linearized RGB.


  The following code demonstrates typical usage of
  LinearGradientPaint:


      Point2D start = new Point2D.Float(0, 0);
      Point2D end = new Point2D.Float(50, 50);
      float[] dist = {0.0f, 0.2f, 1.0f};
      Color[] colors = {Color.RED, Color.WHITE, Color.BLUE};
      LinearGradientPaint p =
          new LinearGradientPaint(start, end, dist, colors);

  This code will create a LinearGradientPaint which interpolates
  between red and white for the first 20% of the gradient and between white
  and blue for the remaining 80%.


  This image demonstrates the example code above for each
  of the three cycle methods:"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt LinearGradientPaint]))

(defn ->linear-gradient-paint
  "Constructor.

  Constructs a LinearGradientPaint with a default SRGB
   color space.

  start-x - the X coordinate of the gradient axis start point in user space - `float`
  start-y - the Y coordinate of the gradient axis start point in user space - `float`
  end-x - the X coordinate of the gradient axis end point in user space - `float`
  end-y - the Y coordinate of the gradient axis end point in user space - `float`
  fractions - numbers ranging from 0.0 to 1.0 specifying the distribution of colors along the gradient - `float[]`
  colors - array of colors corresponding to each fractional value - `java.awt.Color[]`
  cycle-method - either NO_CYCLE, REFLECT, or REPEAT - `java.awt.MultipleGradientPaint.CycleMethod`

  throws: java.lang.NullPointerException - if fractions array is null, or colors array is null, or cycleMethod is null"
  ([^Float start-x ^Float start-y ^Float end-x ^Float end-y fractions colors ^java.awt.MultipleGradientPaint.CycleMethod cycle-method]
    (new LinearGradientPaint start-x start-y end-x end-y fractions colors cycle-method))
  ([^Float start-x ^Float start-y ^Float end-x ^Float end-y fractions colors]
    (new LinearGradientPaint start-x start-y end-x end-y fractions colors))
  ([^java.awt.geom.Point2D start ^java.awt.geom.Point2D end fractions colors ^java.awt.MultipleGradientPaint.CycleMethod cycle-method]
    (new LinearGradientPaint start end fractions colors cycle-method))
  ([^java.awt.geom.Point2D start ^java.awt.geom.Point2D end fractions colors]
    (new LinearGradientPaint start end fractions colors)))

(defn create-context
  "Creates and returns a PaintContext used to
   generate a linear color gradient pattern.
   See the specification of the
   method in the Paint interface for information
   on null parameter handling.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  device-bounds - the device space bounding box of the graphics primitive being rendered. - `java.awt.Rectangle`
  user-bounds - the user space bounding box of the graphics primitive being rendered. - `java.awt.geom.Rectangle2D`
  transform - the AffineTransform from user space into device space. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  (^java.awt.PaintContext [^java.awt.LinearGradientPaint this ^java.awt.image.ColorModel cm ^java.awt.Rectangle device-bounds ^java.awt.geom.Rectangle2D user-bounds ^java.awt.geom.AffineTransform transform ^java.awt.RenderingHints hints]
    (-> this (.createContext cm device-bounds user-bounds transform hints))))

(defn get-start-point
  "Returns a copy of the start point of the gradient axis.

  returns: a Point2D object that is a copy of the point
   that anchors the first color of this LinearGradientPaint - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.LinearGradientPaint this]
    (-> this (.getStartPoint))))

(defn get-end-point
  "Returns a copy of the end point of the gradient axis.

  returns: a Point2D object that is a copy of the point
   that anchors the last color of this LinearGradientPaint - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.LinearGradientPaint this]
    (-> this (.getEndPoint))))

