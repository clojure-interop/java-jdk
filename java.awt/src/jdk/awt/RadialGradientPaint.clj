(ns jdk.awt.RadialGradientPaint
  "The RadialGradientPaint class provides a way to fill a shape with
  a circular radial color gradient pattern. The user may specify 2 or more
  gradient colors, and this paint will provide an interpolation between
  each color.

  The user must specify the circle controlling the gradient pattern,
  which is described by a center point and a radius.  The user can also
  specify a separate focus point within that circle, which controls the
  location of the first color of the gradient.  By default the focus is
  set to be the center of the circle.

  This paint will map the first color of the gradient to the focus point,
  and the last color to the perimeter of the circle, interpolating
  smoothly for any in-between colors specified by the user.  Any line drawn
  from the focus point to the circumference will thus span all the gradient
  colors.

  Specifying a focus point outside of the radius of the circle will cause
  the rings of the gradient pattern to be centered on the point just inside
  the edge of the circle in the direction of the focus point.
  The rendering will internally use this modified location as if it were
  the specified focus point.

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


  The user may also select what action the RadialGradientPaint object
  takes when it is filling the space outside the circle's radius by
  setting CycleMethod to either REFLECTION or REPEAT.
  The gradient color proportions are equal for any particular line drawn
  from the focus point. The following figure shows that the distance AB
  is equal to the distance BC, and the distance AD is equal to the distance DE.



  If the gradient and graphics rendering transforms are uniformly scaled and
  the user sets the focus so that it coincides with the center of the circle,
  the gradient color proportions are equal for any line drawn from the center.
  The following figure shows the distances AB, BC, AD, and DE. They are all equal.



  Note that some minor variations in distances may occur due to sampling at
  the granularity of a pixel.
  If no cycle method is specified, NO_CYCLE will be chosen by
  default, which means the the last keyframe color will be used to fill the
  remaining area.

  The colorSpace parameter allows the user to specify in which colorspace
  the interpolation should be performed, default sRGB or linearized RGB.


  The following code demonstrates typical usage of
  RadialGradientPaint, where the center and focus points are
  the same:


      Point2D center = new Point2D.Float(50, 50);
      float radius = 25;
      float[] dist = {0.0f, 0.2f, 1.0f};
      Color[] colors = {Color.RED, Color.WHITE, Color.BLUE};
      RadialGradientPaint p =
          new RadialGradientPaint(center, radius, dist, colors);


  This image demonstrates the example code above, with default
  (centered) focus for each of the three cycle methods:





  It is also possible to specify a non-centered focus point, as
  in the following code:


      Point2D center = new Point2D.Float(50, 50);
      float radius = 25;
      Point2D focus = new Point2D.Float(40, 40);
      float[] dist = {0.0f, 0.2f, 1.0f};
      Color[] colors = {Color.RED, Color.WHITE, Color.BLUE};
      RadialGradientPaint p =
          new RadialGradientPaint(center, radius, focus,
                                  dist, colors,
                                  CycleMethod.NO_CYCLE);


  This image demonstrates the previous example code, with non-centered
  focus for each of the three cycle methods:"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt RadialGradientPaint]))

(defn ->radial-gradient-paint
  "Constructor.

  Constructs a RadialGradientPaint with a default
   SRGB color space.

  cx - the X coordinate in user space of the center point of the circle defining the gradient. The last color of the gradient is mapped to the perimeter of this circle. - `float`
  cy - the Y coordinate in user space of the center point of the circle defining the gradient. The last color of the gradient is mapped to the perimeter of this circle. - `float`
  radius - the radius of the circle defining the extents of the color gradient - `float`
  fx - the X coordinate of the point in user space to which the first color is mapped - `float`
  fy - the Y coordinate of the point in user space to which the first color is mapped - `float`
  fractions - numbers ranging from 0.0 to 1.0 specifying the distribution of colors along the gradient - `float[]`
  colors - array of colors to use in the gradient. The first color is used at the focus point, the last color around the perimeter of the circle. - `java.awt.Color[]`
  cycle-method - either NO_CYCLE, REFLECT, or REPEAT - `java.awt.MultipleGradientPaint$CycleMethod`

  throws: java.lang.NullPointerException - if fractions array is null, or colors array is null, or cycleMethod is null"
  (^RadialGradientPaint [^Float cx ^Float cy ^Float radius ^Float fx ^Float fy fractions colors ^java.awt.MultipleGradientPaint$CycleMethod cycle-method]
    (new RadialGradientPaint cx cy radius fx fy fractions colors cycle-method))
  (^RadialGradientPaint [^Float cx ^Float cy ^Float radius fractions colors ^java.awt.MultipleGradientPaint$CycleMethod cycle-method]
    (new RadialGradientPaint cx cy radius fractions colors cycle-method))
  (^RadialGradientPaint [^Float cx ^Float cy ^Float radius fractions colors]
    (new RadialGradientPaint cx cy radius fractions colors))
  (^RadialGradientPaint [^java.awt.geom.Point2D center ^Float radius fractions colors]
    (new RadialGradientPaint center radius fractions colors)))

(defn create-context
  "Creates and returns a PaintContext used to
   generate a circular radial color gradient pattern.
   See the description of the createContext method
   for information on null parameter handling.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  device-bounds - the device space bounding box of the graphics primitive being rendered. - `java.awt.Rectangle`
  user-bounds - the user space bounding box of the graphics primitive being rendered. - `java.awt.geom.Rectangle2D`
  transform - the AffineTransform from user space into device space. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  (^java.awt.PaintContext [^RadialGradientPaint this ^java.awt.image.ColorModel cm ^java.awt.Rectangle device-bounds ^java.awt.geom.Rectangle2D user-bounds ^java.awt.geom.AffineTransform transform ^java.awt.RenderingHints hints]
    (-> this (.createContext cm device-bounds user-bounds transform hints))))

(defn get-center-point
  "Returns a copy of the center point of the radial gradient.

  returns: a Point2D object that is a copy of the center point - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^RadialGradientPaint this]
    (-> this (.getCenterPoint))))

(defn get-focus-point
  "Returns a copy of the focus point of the radial gradient.
   Note that if the focus point specified when the radial gradient
   was constructed lies outside of the radius of the circle, this
   method will still return the original focus point even though
   the rendering may center the rings of color on a different
   point that lies inside the radius.

  returns: a Point2D object that is a copy of the focus point - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^RadialGradientPaint this]
    (-> this (.getFocusPoint))))

(defn get-radius
  "Returns the radius of the circle defining the radial gradient.

  returns: the radius of the circle defining the radial gradient - `float`"
  (^Float [^RadialGradientPaint this]
    (-> this (.getRadius))))

