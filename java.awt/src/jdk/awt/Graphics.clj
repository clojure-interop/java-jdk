(ns jdk.awt.Graphics
  "The Graphics class is the abstract base class for
  all graphics contexts that allow an application to draw onto
  components that are realized on various devices, as well as
  onto off-screen images.

  A Graphics object encapsulates state information needed
  for the basic rendering operations that Java supports.  This
  state information includes the following properties:


  The Component object on which to draw.
  A translation origin for rendering and clipping coordinates.
  The current clip.
  The current color.
  The current font.
  The current logical pixel operation function (XOR or Paint).
  The current XOR alternation color
      (see setXORMode(java.awt.Color)).


  Coordinates are infinitely thin and lie between the pixels of the
  output device.
  Operations that draw the outline of a figure operate by traversing
  an infinitely thin path between pixels with a pixel-sized pen that hangs
  down and to the right of the anchor point on the path.
  Operations that fill a figure operate by filling the interior
  of that infinitely thin path.
  Operations that render horizontal text render the ascending
  portion of character glyphs entirely above the baseline coordinate.

  The graphics pen hangs down and to the right from the path it traverses.
  This has the following implications:

  If you draw a figure that covers a given rectangle, that
  figure occupies one extra row of pixels on the right and bottom edges
  as compared to filling a figure that is bounded by that same rectangle.
  If you draw a horizontal line along the same y coordinate as
  the baseline of a line of text, that line is drawn entirely below
  the text, except for any descenders.

  All coordinates that appear as arguments to the methods of this
  Graphics object are considered relative to the
  translation origin of this Graphics object prior to
  the invocation of the method.

  All rendering operations modify only pixels which lie within the
  area bounded by the current clip, which is specified by a Shape
  in user space and is controlled by the program using the
  Graphics object.  This user clip
  is transformed into device space and combined with the
  device clip, which is defined by the visibility of windows and
  device extents.  The combination of the user clip and device clip
  defines the composite clip, which determines the final clipping
  region.  The user clip cannot be modified by the rendering
  system to reflect the resulting composite clip. The user clip can only
  be changed through the setClip or clipRect
  methods.
  All drawing or writing is done in the current color,
  using the current paint mode, and in the current font."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Graphics]))

(defn draw-image
  "Draws as much of the specified area of the specified image as is
   currently available, scaling it on the fly to fit inside the
   specified area of the destination drawable surface.

   Transparent pixels are drawn in the specified background color.
   This operation is equivalent to filling a rectangle of the
   width and height of the specified image with the given color and then
   drawing the image on top of it, but possibly more efficient.

   This method returns immediately in all cases, even if the
   image area to be drawn has not yet been scaled, dithered, and converted
   for the current output device.
   If the current output representation is not yet complete then
   drawImage returns false. As more of
   the image becomes available, the process that loads the image notifies
   the specified image observer.

   This method always uses the unscaled version of the image
   to render the scaled rectangle and performs the required
   scaling on the fly. It does not use a cached, scaled version
   of the image for this operation. Scaling of the image from source
   to destination is performed such that the first coordinate
   of the source rectangle is mapped to the first coordinate of
   the destination rectangle, and the second source coordinate is
   mapped to the second destination coordinate. The subimage is
   scaled and flipped as needed to preserve those mappings.

  img - the specified image to be drawn. This method does nothing if img is null. - `java.awt.Image`
  dx-1 - the x coordinate of the first corner of the destination rectangle. - `int`
  dy-1 - the y coordinate of the first corner of the destination rectangle. - `int`
  dx-2 - the x coordinate of the second corner of the destination rectangle. - `int`
  dy-2 - the y coordinate of the second corner of the destination rectangle. - `int`
  sx-1 - the x coordinate of the first corner of the source rectangle. - `int`
  sy-1 - the y coordinate of the first corner of the source rectangle. - `int`
  sx-2 - the x coordinate of the second corner of the source rectangle. - `int`
  sy-2 - the y coordinate of the second corner of the source rectangle. - `int`
  bgcolor - the background color to paint under the non-opaque portions of the image. - `java.awt.Color`
  observer - object to be notified as more of the image is scaled and converted. - `java.awt.image.ImageObserver`

  returns: false if the image pixels are still changing;
             true otherwise. - `boolean`"
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer dx-1 ^Integer dy-1 ^Integer dx-2 ^Integer dy-2 ^Integer sx-1 ^Integer sy-1 ^Integer sx-2 ^Integer sy-2 ^java.awt.Color bgcolor ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img dx-1 dy-1 dx-2 dy-2 sx-1 sy-1 sx-2 sy-2 bgcolor observer)))
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer dx-1 ^Integer dy-1 ^Integer dx-2 ^Integer dy-2 ^Integer sx-1 ^Integer sy-1 ^Integer sx-2 ^Integer sy-2 ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img dx-1 dy-1 dx-2 dy-2 sx-1 sy-1 sx-2 sy-2 observer)))
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer x ^Integer y ^Integer width ^Integer height ^java.awt.Color bgcolor ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img x y width height bgcolor observer)))
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer x ^Integer y ^Integer width ^Integer height ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img x y width height observer)))
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer x ^Integer y ^java.awt.Color bgcolor ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img x y bgcolor observer)))
  ([^java.awt.Graphics this ^java.awt.Image img ^Integer x ^Integer y ^java.awt.image.ImageObserver observer]
    (-> this (.drawImage img x y observer))))

(defn draw-arc
  "Draws the outline of a circular or elliptical arc
   covering the specified rectangle.

   The resulting arc begins at startAngle and extends
   for arcAngle degrees, using the current color.
   Angles are interpreted such that 0 degrees
   is at the 3 o'clock position.
   A positive value indicates a counter-clockwise rotation
   while a negative value indicates a clockwise rotation.

   The center of the arc is the center of the rectangle whose origin
   is (x, y) and whose size is specified by the
   width and height arguments.

   The resulting arc covers an area
   width  1 pixels wide
   by height  1 pixels tall.

   The angles are specified relative to the non-square extents of
   the bounding rectangle such that 45 degrees always falls on the
   line from the center of the ellipse to the upper right corner of
   the bounding rectangle. As a result, if the bounding rectangle is
   noticeably longer in one axis than the other, the angles to the
   start and end of the arc segment will be skewed farther along the
   longer axis of the bounds.

  x - the x coordinate of the upper-left corner of the arc to be drawn. - `int`
  y - the y coordinate of the upper-left corner of the arc to be drawn. - `int`
  width - the width of the arc to be drawn. - `int`
  height - the height of the arc to be drawn. - `int`
  start-angle - the beginning angle. - `int`
  arc-angle - the angular extent of the arc, relative to the start angle. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Integer start-angle ^Integer arc-angle]
    (-> this (.drawArc x y width height start-angle arc-angle))))

(defn copy-area
  "Copies an area of the component by a distance specified by
   dx and dy. From the point specified
   by x and y, this method
   copies downwards and to the right.  To copy an area of the
   component to the left or upwards, specify a negative value for
   dx or dy.
   If a portion of the source rectangle lies outside the bounds
   of the component, or is obscured by another window or component,
   copyArea will be unable to copy the associated
   pixels. The area that is omitted can be refreshed by calling
   the component's paint method.

  x - the x coordinate of the source rectangle. - `int`
  y - the y coordinate of the source rectangle. - `int`
  width - the width of the source rectangle. - `int`
  height - the height of the source rectangle. - `int`
  dx - the horizontal distance to copy the pixels. - `int`
  dy - the vertical distance to copy the pixels. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Integer dx ^Integer dy]
    (-> this (.copyArea x y width height dx dy))))

(defn draw-oval
  "Draws the outline of an oval.
   The result is a circle or ellipse that fits within the
   rectangle specified by the x, y,
   width, and height arguments.

   The oval covers an area that is
   width  1 pixels wide
   and height  1 pixels tall.

  x - the x coordinate of the upper left corner of the oval to be drawn. - `int`
  y - the y coordinate of the upper left corner of the oval to be drawn. - `int`
  width - the width of the oval to be drawn. - `int`
  height - the height of the oval to be drawn. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.drawOval x y width height))))

(defn get-clip
  "Gets the current clipping area.
   This method returns the user clip, which is independent of the
   clipping associated with device bounds and window visibility.
   If no clip has previously been set, or if the clip has been
   cleared using setClip(null), this method returns
   null.

  returns: a Shape object representing the
                current clipping area, or null if
                no clip is set. - `java.awt.Shape`"
  ([^java.awt.Graphics this]
    (-> this (.getClip))))

(defn translate
  "Translates the origin of the graphics context to the point
   (x, y) in the current coordinate system.
   Modifies this graphics context so that its new origin corresponds
   to the point (x, y) in this graphics context's
   original coordinate system.  All coordinates used in subsequent
   rendering operations on this graphics context will be relative
   to this new origin.

  x - the x coordinate. - `int`
  y - the y coordinate. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y]
    (-> this (.translate x y))))

(defn clip-rect
  "Intersects the current clip with the specified rectangle.
   The resulting clipping area is the intersection of the current
   clipping area and the specified rectangle.  If there is no
   current clipping area, either because the clip has never been
   set, or the clip has been cleared using setClip(null),
   the specified rectangle becomes the new clip.
   This method sets the user clip, which is independent of the
   clipping associated with device bounds and window visibility.
   This method can only be used to make the current clip smaller.
   To set the current clip larger, use any of the setClip methods.
   Rendering operations have no effect outside of the clipping area.

  x - the x coordinate of the rectangle to intersect the clip with - `int`
  y - the y coordinate of the rectangle to intersect the clip with - `int`
  width - the width of the rectangle to intersect the clip with - `int`
  height - the height of the rectangle to intersect the clip with - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.clipRect x y width height))))

(defn draw-polyline
  "Draws a sequence of connected lines defined by
   arrays of x and y coordinates.
   Each pair of (x, y) coordinates defines a point.
   The figure is not closed if the first point
   differs from the last point.

  x-points - an array of x points - `int[]`
  y-points - an array of y points - `int[]`
  n-points - the total number of points - `int`"
  ([^java.awt.Graphics this x-points y-points ^Integer n-points]
    (-> this (.drawPolyline x-points y-points n-points))))

(defn hit-clip
  "Returns true if the specified rectangular area might intersect
   the current clipping area.
   The coordinates of the specified rectangular area are in the
   user coordinate space and are relative to the coordinate
   system origin of this graphics context.
   This method may use an algorithm that calculates a result quickly
   but which sometimes might return true even if the specified
   rectangular area does not intersect the clipping area.
   The specific algorithm employed may thus trade off accuracy for
   speed, but it will never return false unless it can guarantee
   that the specified rectangular area does not intersect the
   current clipping area.
   The clipping area used by this method can represent the
   intersection of the user clip as specified through the clip
   methods of this graphics context as well as the clipping
   associated with the device or image bounds and window visibility.

  x - the x coordinate of the rectangle to test against the clip - `int`
  y - the y coordinate of the rectangle to test against the clip - `int`
  width - the width of the rectangle to test against the clip - `int`
  height - the height of the rectangle to test against the clip - `int`

  returns: true if the specified rectangle intersects
           the bounds of the current clip; false
           otherwise. - `boolean`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.hitClip x y width height))))

(defn dispose
  "Disposes of this graphics context and releases
   any system resources that it is using.
   A Graphics object cannot be used after
   disposehas been called.

   When a Java program runs, a large number of Graphics
   objects can be created within a short time frame.
   Although the finalization process of the garbage collector
   also disposes of the same system resources, it is preferable
   to manually free the associated resources by calling this
   method rather than to rely on a finalization process which
   may not run to completion for a long period of time.

   Graphics objects which are provided as arguments to the
   paint and update methods
   of components are automatically released by the system when
   those methods return. For efficiency, programmers should
   call dispose when finished using
   a Graphics object only if it was created
   directly from a component or another Graphics object."
  ([^java.awt.Graphics this]
    (-> this (.dispose))))

(defn fill-polygon
  "Fills a closed polygon defined by
   arrays of x and y coordinates.

   This method draws the polygon defined by nPoint line
   segments, where the first nPoint - 1
   line segments are line segments from
   (xPoints[i - 1], yPoints[i - 1])
   to (xPoints[i], yPoints[i]), for
   1 ≤ i ≤ nPoints.
   The figure is automatically closed by drawing a line connecting
   the final point to the first point, if those points are different.

   The area inside the polygon is defined using an
   even-odd fill rule, also known as the alternating rule.

  x-points - a an array of x coordinates. - `int[]`
  y-points - a an array of y coordinates. - `int[]`
  n-points - a the total number of points. - `int`"
  ([^java.awt.Graphics this x-points y-points ^Integer n-points]
    (-> this (.fillPolygon x-points y-points n-points)))
  ([^java.awt.Graphics this ^java.awt.Polygon p]
    (-> this (.fillPolygon p))))

(defn to-string
  "Returns a String object representing this
                          Graphics object's value.

  returns: a string representation of this graphics context. - `java.lang.String`"
  ([^java.awt.Graphics this]
    (-> this (.toString))))

(defn get-clip-bounds
  "Returns the bounding rectangle of the current clipping area.
   The coordinates in the rectangle are relative to the coordinate
   system origin of this graphics context.  This method differs
   from getClipBounds in that an existing
   rectangle is used instead of allocating a new one.
   This method refers to the user clip, which is independent of the
   clipping associated with device bounds and window visibility.
    If no clip has previously been set, or if the clip has been
   cleared using setClip(null), this method returns the
   specified Rectangle.

  r - the rectangle where the current clipping area is copied to. Any current values in this rectangle are overwritten. - `java.awt.Rectangle`

  returns: the bounding rectangle of the current clipping area. - `java.awt.Rectangle`"
  ([^java.awt.Graphics this ^java.awt.Rectangle r]
    (-> this (.getClipBounds r)))
  ([^java.awt.Graphics this]
    (-> this (.getClipBounds))))

(defn fill-3-d-rect
  "Paints a 3-D highlighted rectangle filled with the current color.
   The edges of the rectangle will be highlighted so that it appears
   as if the edges were beveled and lit from the upper left corner.
   The colors used for the highlighting effect will be determined from
   the current color.

  x - the x coordinate of the rectangle to be filled. - `int`
  y - the y coordinate of the rectangle to be filled. - `int`
  width - the width of the rectangle to be filled. - `int`
  height - the height of the rectangle to be filled. - `int`
  raised - a boolean value that determines whether the rectangle appears to be raised above the surface or etched into the surface. - `boolean`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Boolean raised]
    (-> this (.fill3DRect x y width height raised))))

(defn draw-line
  "Draws a line, using the current color, between the points
   (x1, y1) and (x2, y2)
   in this graphics context's coordinate system.

  x-1 - the first point's x coordinate. - `int`
  y-1 - the first point's y coordinate. - `int`
  x-2 - the second point's x coordinate. - `int`
  y-2 - the second point's y coordinate. - `int`"
  ([^java.awt.Graphics this ^Integer x-1 ^Integer y-1 ^Integer x-2 ^Integer y-2]
    (-> this (.drawLine x-1 y-1 x-2 y-2))))

(defn draw-bytes
  "Draws the text given by the specified byte array, using this
   graphics context's current font and color. The baseline of the
   first character is at position (x, y) in this
   graphics context's coordinate system.

   Use of this method is not recommended as each byte is interpreted
   as a Unicode code point in the range 0 to 255, and so can only be
   used to draw Latin characters in that range.

  data - the data to be drawn - `byte[]`
  offset - the start offset in the data - `int`
  length - the number of bytes that are drawn - `int`
  x - the x coordinate of the baseline of the text - `int`
  y - the y coordinate of the baseline of the text - `int`

  throws: java.lang.NullPointerException - if data is null."
  ([^java.awt.Graphics this data ^Integer offset ^Integer length ^Integer x ^Integer y]
    (-> this (.drawBytes data offset length x y))))

(defn draw-polygon
  "Draws a closed polygon defined by
   arrays of x and y coordinates.
   Each pair of (x, y) coordinates defines a point.

   This method draws the polygon defined by nPoint line
   segments, where the first nPoint - 1
   line segments are line segments from
   (xPoints[i - 1], yPoints[i - 1])
   to (xPoints[i], yPoints[i]), for
   1 ≤ i ≤ nPoints.
   The figure is automatically closed by drawing a line connecting
   the final point to the first point, if those points are different.

  x-points - a an array of x coordinates. - `int[]`
  y-points - a an array of y coordinates. - `int[]`
  n-points - a the total number of points. - `int`"
  ([^java.awt.Graphics this x-points y-points ^Integer n-points]
    (-> this (.drawPolygon x-points y-points n-points)))
  ([^java.awt.Graphics this ^java.awt.Polygon p]
    (-> this (.drawPolygon p))))

(defn get-font-metrics
  "Gets the font metrics for the specified font.

  f - the specified font - `java.awt.Font`

  returns: the font metrics for the specified font. - `java.awt.FontMetrics`"
  ([^java.awt.Graphics this ^java.awt.Font f]
    (-> this (.getFontMetrics f)))
  ([^java.awt.Graphics this]
    (-> this (.getFontMetrics))))

(defn draw-string
  "Draws the text given by the specified string, using this
   graphics context's current font and color. The baseline of the
   leftmost character is at position (x, y) in this
   graphics context's coordinate system.

  str - the string to be drawn. - `java.lang.String`
  x - the x coordinate. - `int`
  y - the y coordinate. - `int`

  throws: java.lang.NullPointerException - if str is null."
  ([^java.awt.Graphics this ^java.lang.String str ^Integer x ^Integer y]
    (-> this (.drawString str x y))))

(defn set-clip
  "Sets the current clip to the rectangle specified by the given
   coordinates.  This method sets the user clip, which is
   independent of the clipping associated with device bounds
   and window visibility.
   Rendering operations have no effect outside of the clipping area.

  x - the x coordinate of the new clip rectangle. - `int`
  y - the y coordinate of the new clip rectangle. - `int`
  width - the width of the new clip rectangle. - `int`
  height - the height of the new clip rectangle. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.setClip x y width height)))
  ([^java.awt.Graphics this ^java.awt.Shape clip]
    (-> this (.setClip clip))))

(defn fill-arc
  "Fills a circular or elliptical arc covering the specified rectangle.

   The resulting arc begins at startAngle and extends
   for arcAngle degrees.
   Angles are interpreted such that 0 degrees
   is at the 3 o'clock position.
   A positive value indicates a counter-clockwise rotation
   while a negative value indicates a clockwise rotation.

   The center of the arc is the center of the rectangle whose origin
   is (x, y) and whose size is specified by the
   width and height arguments.

   The resulting arc covers an area
   width  1 pixels wide
   by height  1 pixels tall.

   The angles are specified relative to the non-square extents of
   the bounding rectangle such that 45 degrees always falls on the
   line from the center of the ellipse to the upper right corner of
   the bounding rectangle. As a result, if the bounding rectangle is
   noticeably longer in one axis than the other, the angles to the
   start and end of the arc segment will be skewed farther along the
   longer axis of the bounds.

  x - the x coordinate of the upper-left corner of the arc to be filled. - `int`
  y - the y coordinate of the upper-left corner of the arc to be filled. - `int`
  width - the width of the arc to be filled. - `int`
  height - the height of the arc to be filled. - `int`
  start-angle - the beginning angle. - `int`
  arc-angle - the angular extent of the arc, relative to the start angle. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Integer start-angle ^Integer arc-angle]
    (-> this (.fillArc x y width height start-angle arc-angle))))

(defn set-xor-mode
  "Sets the paint mode of this graphics context to alternate between
   this graphics context's current color and the new specified color.
   This specifies that logical pixel operations are performed in the
   XOR mode, which alternates pixels between the current color and
   a specified XOR color.

   When drawing operations are performed, pixels which are the
   current color are changed to the specified color, and vice versa.

   Pixels that are of colors other than those two colors are changed
   in an unpredictable but reversible manner; if the same figure is
   drawn twice, then all pixels are restored to their original values.

  c-1 - the XOR alternation color - `java.awt.Color`"
  ([^java.awt.Graphics this ^java.awt.Color c-1]
    (-> this (.setXORMode c-1))))

(defn set-color
  "Sets this graphics context's current color to the specified
   color. All subsequent graphics operations using this graphics
   context use this specified color.

  c - the new rendering color. - `java.awt.Color`"
  ([^java.awt.Graphics this ^java.awt.Color c]
    (-> this (.setColor c))))

(defn draw-rect
  "Draws the outline of the specified rectangle.
   The left and right edges of the rectangle are at
   x and x  width.
   The top and bottom edges are at
   y and y  height.
   The rectangle is drawn using the graphics context's current color.

  x - the x coordinate of the rectangle to be drawn. - `int`
  y - the y coordinate of the rectangle to be drawn. - `int`
  width - the width of the rectangle to be drawn. - `int`
  height - the height of the rectangle to be drawn. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.drawRect x y width height))))

(defn fill-round-rect
  "Fills the specified rounded corner rectangle with the current color.
   The left and right edges of the rectangle
   are at x and x  width - 1,
   respectively. The top and bottom edges of the rectangle are at
   y and y  height - 1.

  x - the x coordinate of the rectangle to be filled. - `int`
  y - the y coordinate of the rectangle to be filled. - `int`
  width - the width of the rectangle to be filled. - `int`
  height - the height of the rectangle to be filled. - `int`
  arc-width - the horizontal diameter of the arc at the four corners. - `int`
  arc-height - the vertical diameter of the arc at the four corners. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Integer arc-width ^Integer arc-height]
    (-> this (.fillRoundRect x y width height arc-width arc-height))))

(defn set-font
  "Sets this graphics context's font to the specified font.
   All subsequent text operations using this graphics context
   use this font. A null argument is silently ignored.

  font - the font. - `java.awt.Font`"
  ([^java.awt.Graphics this ^java.awt.Font font]
    (-> this (.setFont font))))

(defn draw-3-d-rect
  "Draws a 3-D highlighted outline of the specified rectangle.
   The edges of the rectangle are highlighted so that they
   appear to be beveled and lit from the upper left corner.

   The colors used for the highlighting effect are determined
   based on the current color.
   The resulting rectangle covers an area that is
   width  1 pixels wide
   by height  1 pixels tall.

  x - the x coordinate of the rectangle to be drawn. - `int`
  y - the y coordinate of the rectangle to be drawn. - `int`
  width - the width of the rectangle to be drawn. - `int`
  height - the height of the rectangle to be drawn. - `int`
  raised - a boolean that determines whether the rectangle appears to be raised above the surface or sunk into the surface. - `boolean`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Boolean raised]
    (-> this (.draw3DRect x y width height raised))))

(defn create
  "Creates a new Graphics object based on this
   Graphics object, but with a new translation and clip area.
   The new Graphics object has its origin
   translated to the specified point (x, y).
   Its clip area is determined by the intersection of the original
   clip area with the specified rectangle.  The arguments are all
   interpreted in the coordinate system of the original
   Graphics object. The new graphics context is
   identical to the original, except in two respects:



   The new graphics context is translated by (x, y).
   That is to say, the point (0, 0) in the
   new graphics context is the same as (x, y) in
   the original graphics context.

   The new graphics context has an additional clipping rectangle, in
   addition to whatever (translated) clipping rectangle it inherited
   from the original graphics context. The origin of the new clipping
   rectangle is at (0, 0), and its size
   is specified by the width and height
   arguments.

  x - the x coordinate. - `int`
  y - the y coordinate. - `int`
  width - the width of the clipping rectangle. - `int`
  height - the height of the clipping rectangle. - `int`

  returns: a new graphics context. - `java.awt.Graphics`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.create x y width height)))
  ([^java.awt.Graphics this]
    (-> this (.create))))

(defn set-paint-mode
  "Sets the paint mode of this graphics context to overwrite the
   destination with this graphics context's current color.
   This sets the logical pixel operation function to the paint or
   overwrite mode.  All subsequent rendering operations will
   overwrite the destination with the current color."
  ([^java.awt.Graphics this]
    (-> this (.setPaintMode))))

(defn get-font
  "Gets the current font.

  returns: this graphics context's current font. - `java.awt.Font`"
  ([^java.awt.Graphics this]
    (-> this (.getFont))))

(defn draw-round-rect
  "Draws an outlined round-cornered rectangle using this graphics
   context's current color. The left and right edges of the rectangle
   are at x and x  width,
   respectively. The top and bottom edges of the rectangle are at
   y and y  height.

  x - the x coordinate of the rectangle to be drawn. - `int`
  y - the y coordinate of the rectangle to be drawn. - `int`
  width - the width of the rectangle to be drawn. - `int`
  height - the height of the rectangle to be drawn. - `int`
  arc-width - the horizontal diameter of the arc at the four corners. - `int`
  arc-height - the vertical diameter of the arc at the four corners. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height ^Integer arc-width ^Integer arc-height]
    (-> this (.drawRoundRect x y width height arc-width arc-height))))

(defn draw-chars
  "Draws the text given by the specified character array, using this
   graphics context's current font and color. The baseline of the
   first character is at position (x, y) in this
   graphics context's coordinate system.

  data - the array of characters to be drawn - `char[]`
  offset - the start offset in the data - `int`
  length - the number of characters to be drawn - `int`
  x - the x coordinate of the baseline of the text - `int`
  y - the y coordinate of the baseline of the text - `int`

  throws: java.lang.NullPointerException - if data is null."
  ([^java.awt.Graphics this data ^Integer offset ^Integer length ^Integer x ^Integer y]
    (-> this (.drawChars data offset length x y))))

(defn get-color
  "Gets this graphics context's current color.

  returns: this graphics context's current color. - `java.awt.Color`"
  ([^java.awt.Graphics this]
    (-> this (.getColor))))

(defn clear-rect
  "Clears the specified rectangle by filling it with the background
   color of the current drawing surface. This operation does not
   use the current paint mode.

   Beginning with Java 1.1, the background color
   of offscreen images may be system dependent. Applications should
   use setColor followed by fillRect to
   ensure that an offscreen image is cleared to a specific color.

  x - the x coordinate of the rectangle to clear. - `int`
  y - the y coordinate of the rectangle to clear. - `int`
  width - the width of the rectangle to clear. - `int`
  height - the height of the rectangle to clear. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.clearRect x y width height))))

(defn get-clip-rect
  "Deprecated. As of JDK version 1.1,
   replaced by getClipBounds().

  returns: the bounding rectangle of the current clipping area
                or null if no clip is set. - `java.lang.  java.awt.Rectangle`"
  ([^java.awt.Graphics this]
    (-> this (.getClipRect))))

(defn fill-rect
  "Fills the specified rectangle.
   The left and right edges of the rectangle are at
   x and x  width - 1.
   The top and bottom edges are at
   y and y  height - 1.
   The resulting rectangle covers an area
   width pixels wide by
   height pixels tall.
   The rectangle is filled using the graphics context's current color.

  x - the x coordinate of the rectangle to be filled. - `int`
  y - the y coordinate of the rectangle to be filled. - `int`
  width - the width of the rectangle to be filled. - `int`
  height - the height of the rectangle to be filled. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.fillRect x y width height))))

(defn fill-oval
  "Fills an oval bounded by the specified rectangle with the
   current color.

  x - the x coordinate of the upper left corner of the oval to be filled. - `int`
  y - the y coordinate of the upper left corner of the oval to be filled. - `int`
  width - the width of the oval to be filled. - `int`
  height - the height of the oval to be filled. - `int`"
  ([^java.awt.Graphics this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.fillOval x y width height))))

(defn finalize
  "Disposes of this graphics context once it is no longer referenced."
  ([^java.awt.Graphics this]
    (-> this (.finalize))))

