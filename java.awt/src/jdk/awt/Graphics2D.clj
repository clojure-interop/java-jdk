(ns jdk.awt.Graphics2D
  "This Graphics2D class extends the
  Graphics class to provide more sophisticated
  control over geometry, coordinate transformations, color management,
  and text layout.  This is the fundamental class for rendering
  2-dimensional shapes, text and images on the  Java(tm) platform.

  Coordinate Spaces
  All coordinates passed to a Graphics2D object are specified
  in a device-independent coordinate system called User Space, which is
  used by applications.  The Graphics2D object contains
  an AffineTransform object as part of its rendering state
  that defines how to convert coordinates from user space to
  device-dependent coordinates in Device Space.

  Coordinates in device space usually refer to individual device pixels
  and are aligned on the infinitely thin gaps between these pixels.
  Some Graphics2D objects can be used to capture rendering
  operations for storage into a graphics metafile for playback on a
  concrete device of unknown physical resolution at a later time.  Since
  the resolution might not be known when the rendering operations are
  captured, the Graphics2D Transform is set up
  to transform user coordinates to a virtual device space that
  approximates the expected resolution of the target device. Further
  transformations might need to be applied at playback time if the
  estimate is incorrect.

  Some of the operations performed by the rendering attribute objects
  occur in the device space, but all Graphics2D methods take
  user space coordinates.

  Every Graphics2D object is associated with a target that
  defines where rendering takes place. A
  GraphicsConfiguration object defines the characteristics
  of the rendering target, such as pixel format and resolution.
  The same rendering target is used throughout the life of a
  Graphics2D object.

  When creating a Graphics2D object,  the
  GraphicsConfiguration
  specifies the default transform for
  the target of the Graphics2D (a
  Component or Image).  This default transform maps the
  user space coordinate system to screen and printer device coordinates
  such that the origin maps to the upper left hand corner of the
  target region of the device with increasing X coordinates extending
  to the right and increasing Y coordinates extending downward.
  The scaling of the default transform is set to identity for those devices
  that are close to 72 dpi, such as screen devices.
  The scaling of the default transform is set to approximately 72 user
  space coordinates per square inch for high resolution devices, such as
  printers.  For image buffers, the default transform is the
  Identity transform.

  Rendering Process
  The Rendering Process can be broken down into four phases that are
  controlled by the Graphics2D rendering attributes.
  The renderer can optimize many of these steps, either by caching the
  results for future calls, by collapsing multiple virtual steps into
  a single operation, or by recognizing various attributes as common
  simple cases that can be eliminated by modifying other parts of the
  operation.

  The steps in the rendering process are:


  Determine what to render.

  Constrain the rendering operation to the current Clip.
  The Clip is specified by a Shape in user
  space and is controlled by the program using the various clip
  manipulation methods of Graphics and
  Graphics2D.  This user clip
  is transformed into device space by the current
  Transform and combined with the
  device clip, which is defined by the visibility of windows and
  device extents.  The combination of the user clip and device clip
  defines the composite clip, which determines the final clipping
  region.  The user clip is not modified by the rendering
  system to reflect the resulting composite clip.

  Determine what colors to render.

  Apply the colors to the destination drawing surface using the current
  Composite attribute in the Graphics2D context.


  The three types of rendering operations, along with details of each
  of their particular rendering processes are:


  Shape operations


  If the operation is a draw(Shape) operation, then
  the  createStrokedShape
  method on the current Stroke attribute in the
  Graphics2D context is used to construct a new
  Shape object that contains the outline of the specified
  Shape.

  The Shape is transformed from user space to device space
  using the current Transform
  in the Graphics2D context.

  The outline of the Shape is extracted using the
  getPathIterator method of
  Shape, which returns a
  PathIterator
  object that iterates along the boundary of the Shape.

  If the Graphics2D object cannot handle the curved segments
  that the PathIterator object returns then it can call the
  alternate
  getPathIterator
  method of Shape, which flattens the Shape.

  The current Paint in the Graphics2D context
  is queried for a PaintContext, which specifies the
  colors to render in device space.


  Text operations


  The following steps are used to determine the set of glyphs required
  to render the indicated String:


  If the argument is a String, then the current
  Font in the Graphics2D context is asked to
  convert the Unicode characters in the String into a set of
  glyphs for presentation with whatever basic layout and shaping
  algorithms the font implements.

  If the argument is an
  AttributedCharacterIterator,
  the iterator is asked to convert itself to a
  TextLayout
  using its embedded font attributes. The TextLayout
  implements more sophisticated glyph layout algorithms that
  perform Unicode bi-directional layout adjustments automatically
  for multiple fonts of differing writing directions.

  If the argument is a
  GlyphVector, then the
  GlyphVector object already contains the appropriate
  font-specific glyph codes with explicit coordinates for the position of
  each glyph.


  The current Font is queried to obtain outlines for the
  indicated glyphs.  These outlines are treated as shapes in user space
  relative to the position of each glyph that was determined in step 1.

  The character outlines are filled as indicated above
  under Shape operations.

  The current Paint is queried for a
  PaintContext, which specifies
  the colors to render in device space.


  Image Operations


  The region of interest is defined by the bounding box of the source
  Image.
  This bounding box is specified in Image Space, which is the
  Image object's local coordinate system.

  If an AffineTransform is passed to
  drawImage(Image, AffineTransform, ImageObserver),
  the AffineTransform is used to transform the bounding
  box from image space to user space. If no AffineTransform
  is supplied, the bounding box is treated as if it is already in user space.

  The bounding box of the source Image is transformed from user
  space into device space using the current Transform.
  Note that the result of transforming the bounding box does not
  necessarily result in a rectangular region in device space.

  The Image object determines what colors to render,
  sampled according to the source to destination
  coordinate mapping specified by the current Transform and the
  optional image transform.



  Default Rendering Attributes
  The default values for the Graphics2D rendering attributes are:

  Paint
  The color of the Component.
  Font
  The Font of the Component.
  Stroke
  A square pen with a linewidth of 1, no dashing, miter segment joins
  and square end caps.
  Transform
  The
  getDefaultTransform
  for the GraphicsConfiguration of the Component.
  Composite
  The AlphaComposite.SRC_OVER rule.
  Clip
  No rendering Clip, the output is clipped to the
  Component.


  Rendering Compatibility Issues
  The JDK(tm) 1.1 rendering model is based on a pixelization model
  that specifies that coordinates
  are infinitely thin, lying between the pixels.  Drawing operations are
  performed using a one-pixel wide pen that fills the
  pixel below and to the right of the anchor point on the path.
  The JDK 1.1 rendering model is consistent with the
  capabilities of most of the existing class of platform
  renderers that need  to resolve integer coordinates to a
  discrete pen that must fall completely on a specified number of pixels.

  The Java 2D(tm) (Java(tm) 2 platform) API supports antialiasing renderers.
  A pen with a width of one pixel does not need to fall
  completely on pixel N as opposed to pixel N+1.  The pen can fall
  partially on both pixels. It is not necessary to choose a bias
  direction for a wide pen since the blending that occurs along the
  pen traversal edges makes the sub-pixel position of the pen
  visible to the user.  On the other hand, when antialiasing is
  turned off by setting the
  KEY_ANTIALIASING hint key
  to the
  VALUE_ANTIALIAS_OFF
  hint value, the renderer might need
  to apply a bias to determine which pixel to modify when the pen
  is straddling a pixel boundary, such as when it is drawn
  along an integer coordinate in device space.  While the capabilities
  of an antialiasing renderer make it no longer necessary for the
  rendering model to specify a bias for the pen, it is desirable for the
  antialiasing and non-antialiasing renderers to perform similarly for
  the common cases of drawing one-pixel wide horizontal and vertical
  lines on the screen.  To ensure that turning on antialiasing by
  setting the
  KEY_ANTIALIASING hint
  key to
  VALUE_ANTIALIAS_ON
  does not cause such lines to suddenly become twice as wide and half
  as opaque, it is desirable to have the model specify a path for such
  lines so that they completely cover a particular set of pixels to help
  increase their crispness.

  Java 2D API maintains compatibility with JDK 1.1 rendering
  behavior, such that legacy operations and existing renderer
  behavior is unchanged under Java 2D API.  Legacy
  methods that map onto general draw and
  fill methods are defined, which clearly indicates
  how Graphics2D extends Graphics based
  on settings of Stroke and Transform
  attributes and rendering hints.  The definition
  performs identically under default attribute settings.
  For example, the default Stroke is a
  BasicStroke with a width of 1 and no dashing and the
  default Transform for screen drawing is an Identity transform.

  The following two rules provide predictable rendering behavior whether
  aliasing or antialiasing is being used.

   Device coordinates are defined to be between device pixels which
  avoids any inconsistent results between aliased and antialiased
  rendering.  If coordinates were defined to be at a pixel's center, some
  of the pixels covered by a shape, such as a rectangle, would only be
  half covered.
  With aliased rendering, the half covered pixels would either be
  rendered inside the shape or outside the shape.  With anti-aliased
  rendering, the pixels on the entire edge of the shape would be half
  covered.  On the other hand, since coordinates are defined to be
  between pixels, a shape like a rectangle would have no half covered
  pixels, whether or not it is rendered using antialiasing.
   Lines and paths stroked using the BasicStroke
  object may be `normalized` to provide consistent rendering of the
  outlines when positioned at various points on the drawable and
  whether drawn with aliased or antialiased rendering.  This
  normalization process is controlled by the
  KEY_STROKE_CONTROL hint.
  The exact normalization algorithm is not specified, but the goals
  of this normalization are to ensure that lines are rendered with
  consistent visual appearance regardless of how they fall on the
  pixel grid and to promote more solid horizontal and vertical
  lines in antialiased mode so that they resemble their non-antialiased
  counterparts more closely.  A typical normalization step might
  promote antialiased line endpoints to pixel centers to reduce the
  amount of blending or adjust the subpixel positioning of
  non-antialiased lines so that the floating point line widths
  round to even or odd pixel counts with equal likelihood.  This
  process can move endpoints by up to half a pixel (usually towards
  positive infinity along both axes) to promote these consistent
  results.


  The following definitions of general legacy methods
  perform identically to previously specified behavior under default
  attribute settings:


  For fill operations, including fillRect,
  fillRoundRect, fillOval,
  fillArc, fillPolygon, and
  clearRect, fill can now be called
  with the desired Shape.  For example, when filling a
  rectangle:


  fill(new Rectangle(x, y, w, h));
  is called.


  Similarly, for draw operations, including drawLine,
  drawRect, drawRoundRect,
  drawOval, drawArc, drawPolyline,
  and drawPolygon, draw can now be
  called with the desired Shape.  For example, when drawing a
  rectangle:


  draw(new Rectangle(x, y, w, h));
  is called.


  The draw3DRect and fill3DRect methods were
  implemented in terms of the drawLine and
  fillRect methods in the Graphics class which
  would predicate their behavior upon the current Stroke
  and Paint objects in a Graphics2D context.
  This class overrides those implementations with versions that use
  the current Color exclusively, overriding the current
  Paint and which uses fillRect to describe
  the exact same behavior as the preexisting methods regardless of the
  setting of the current Stroke.

  The Graphics class defines only the setColor
  method to control the color to be painted.  Since the Java 2D API extends
  the Color object to implement the new Paint
  interface, the existing
  setColor method is now a convenience method for setting the
  current Paint attribute to a Color object.
  setColor(c) is equivalent to setPaint(c).

  The Graphics class defines two methods for controlling
  how colors are applied to the destination.


  The setPaintMode method is implemented as a convenience
  method to set the default Composite, equivalent to
  setComposite(new AlphaComposite.SrcOver).

  The setXORMode(Color xorcolor) method is implemented
  as a convenience method to set a special Composite object that
  ignores the Alpha components of source colors and sets the
  destination color to the value:


  dstpixel = (PixelOf(srccolor) ^ PixelOf(xorcolor) ^ dstpixel);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Graphics2D]))

(defn draw-glyph-vector
  "Renders the text of the specified
   GlyphVector using
   the Graphics2D context's rendering attributes.
   The rendering attributes applied include the Clip,
   Transform, Paint, and
   Composite attributes.  The GlyphVector
   specifies individual glyphs from a Font.
   The GlyphVector can also contain the glyph positions.
   This is the fastest way to render a set of characters to the
   screen.

  g - the GlyphVector to be rendered - `java.awt.font.GlyphVector`
  x - the x position in User Space where the glyphs should be rendered - `float`
  y - the y position in User Space where the glyphs should be rendered - `float`

  throws: java.lang.NullPointerException - if g is null."
  ([this g x y]
    (-> this (.drawGlyphVector g x y))))

(defn add-rendering-hints
  "Sets the values of an arbitrary number of preferences for the
   rendering algorithms.
   Only values for the rendering hints that are present in the
   specified Map object are modified.
   All other preferences not present in the specified
   object are left unmodified.
   Hint categories include controls for rendering quality and
   overall time/quality trade-off in the rendering process.
   Refer to the RenderingHints class for definitions of
   some common keys and values.

  hints - the rendering hints to be set - `java.util.Map<?,?>`"
  ([this hints]
    (-> this (.addRenderingHints hints))))

(defn draw-image
  "Renders a BufferedImage that is
   filtered with a
   BufferedImageOp.
   The rendering attributes applied include the Clip,
   Transform
   and Composite attributes.  This is equivalent to:


   img1 = op.filter(img, null);
   drawImage(img1, new AffineTransform(1f,0f,0f,1f,x,y), null);

  img - the specified BufferedImage to be rendered. This method does nothing if img is null. - `java.awt.image.BufferedImage`
  op - the filter to be applied to the image before rendering - `java.awt.image.BufferedImageOp`
  x - the x coordinate of the location in user space where the upper left corner of the image is rendered - `int`
  y - the y coordinate of the location in user space where the upper left corner of the image is rendered - `int`"
  ([this img op x y]
    (-> this (.drawImage img op x y)))
  ([this img xform obs]
    (-> this (.drawImage img xform obs))))

(defn get-rendering-hints
  "Gets the preferences for the rendering algorithms.  Hint categories
   include controls for rendering quality and overall time/quality
   trade-off in the rendering process.
   Returns all of the hint key/value pairs that were ever specified in
   one operation.  Refer to the
   RenderingHints class for definitions of some common
   keys and values.

  returns: a reference to an instance of RenderingHints
   that contains the current preferences. - `java.awt.RenderingHints`"
  ([this]
    (-> this (.getRenderingHints))))

(defn get-composite
  "Returns the current Composite in the
   Graphics2D context.

  returns: the current Graphics2D Composite,
                which defines a compositing style. - `java.awt.Composite`"
  ([this]
    (-> this (.getComposite))))

(defn translate
  "Translates the origin of the Graphics2D context to the
   point (x, y) in the current coordinate system.
   Modifies the Graphics2D context so that its new origin
   corresponds to the point (x, y) in the
   Graphics2D context's former coordinate system.  All
   coordinates used in subsequent rendering operations on this graphics
   context are relative to this new origin.

  x - the specified x coordinate - `int`
  y - the specified y coordinate - `int`"
  ([this x y]
    (-> this (.translate x y))))

(defn scale
  "Concatenates the current Graphics2D
   Transform with a scaling transformation
   Subsequent rendering is resized according to the specified scaling
   factors relative to the previous scaling.
   This is equivalent to calling transform(S), where S is an
   AffineTransform represented by the following matrix:


            [   sx   0    0   ]
            [   0    sy   0   ]
            [   0    0    1   ]

  sx - the amount by which X coordinates in subsequent rendering operations are multiplied relative to previous rendering operations. - `double`
  sy - the amount by which Y coordinates in subsequent rendering operations are multiplied relative to previous rendering operations. - `double`"
  ([this sx sy]
    (-> this (.scale sx sy))))

(defn clip
  "Intersects the current Clip with the interior of the
   specified Shape and sets the Clip to the
   resulting intersection.  The specified Shape is
   transformed with the current Graphics2D
   Transform before being intersected with the current
   Clip.  This method is used to make the current
   Clip smaller.
   To make the Clip larger, use setClip.
   The user clip modified by this method is independent of the
   clipping associated with device bounds and visibility.  If no clip has
   previously been set, or if the clip has been cleared using
   setClip with a null
   argument, the specified Shape becomes the new
   user clip.

  s - the Shape to be intersected with the current Clip. If s is null, this method clears the current Clip. - `java.awt.Shape`"
  ([this s]
    (-> this (.clip s))))

(defn set-paint
  "Sets the Paint attribute for the
   Graphics2D context.  Calling this method
   with a null Paint object does
   not have any effect on the current Paint attribute
   of this Graphics2D.

  paint - the Paint object to be used to generate color during the rendering process, or null - `java.awt.Paint`"
  ([this paint]
    (-> this (.setPaint paint))))

(defn get-paint
  "Returns the current Paint of the
   Graphics2D context.

  returns: the current Graphics2D Paint,
   which defines a color or pattern. - `java.awt.Paint`"
  ([this]
    (-> this (.getPaint))))

(defn transform
  "Composes an AffineTransform object with the
   Transform in this Graphics2D according
   to the rule last-specified-first-applied.  If the current
   Transform is Cx, the result of composition
   with Tx is a new Transform Cx'.  Cx' becomes the
   current Transform for this Graphics2D.
   Transforming a point p by the updated Transform Cx' is
   equivalent to first transforming p by Tx and then transforming
   the result by the original Transform Cx.  In other
   words, Cx'(p) = Cx(Tx(p)).  A copy of the Tx is made, if necessary,
   so further modifications to Tx do not affect rendering.

  tx - the AffineTransform object to be composed with the current Transform - `java.awt.geom.AffineTransform`"
  ([this tx]
    (-> this (.transform tx))))

(defn fill-3-d-rect
  "Paints a 3-D highlighted rectangle filled with the current color.
   The edges of the rectangle are highlighted so that it appears
   as if the edges were beveled and lit from the upper left corner.
   The colors used for the highlighting effect and for filling are
   determined from the current Color.  This method uses
   the current Color exclusively and ignores the current
   Paint.

  x - the x coordinate of the rectangle to be filled. - `int`
  y - the y coordinate of the rectangle to be filled. - `int`
  width - the width of the rectangle to be filled. - `int`
  height - the height of the rectangle to be filled. - `int`
  raised - a boolean value that determines whether the rectangle appears to be raised above the surface or etched into the surface. - `boolean`"
  ([this x y width height raised]
    (-> this (.fill3DRect x y width height raised))))

(defn get-rendering-hint
  "Returns the value of a single preference for the rendering algorithms.
   Hint categories include controls for rendering quality and overall
   time/quality trade-off in the rendering process.  Refer to the
   RenderingHints class for definitions of some common
   keys and values.

  hint-key - the key corresponding to the hint to get. - `java.awt.RenderingHints.Key`

  returns: an object representing the value for the specified hint key.
   Some of the keys and their associated values are defined in the
   RenderingHints class. - `java.lang.Object`"
  ([this hint-key]
    (-> this (.getRenderingHint hint-key))))

(defn get-stroke
  "Returns the current Stroke in the
   Graphics2D context.

  returns: the current Graphics2D Stroke,
                   which defines the line style. - `java.awt.Stroke`"
  ([this]
    (-> this (.getStroke))))

(defn set-rendering-hint
  "Sets the value of a single preference for the rendering algorithms.
   Hint categories include controls for rendering quality and overall
   time/quality trade-off in the rendering process.  Refer to the
   RenderingHints class for definitions of some common
   keys and values.

  hint-key - the key of the hint to be set. - `java.awt.RenderingHints.Key`
  hint-value - the value indicating preferences for the specified hint category. - `java.lang.Object`"
  ([this hint-key hint-value]
    (-> this (.setRenderingHint hint-key hint-value))))

(defn set-background
  "Sets the background color for the Graphics2D context.
   The background color is used for clearing a region.
   When a Graphics2D is constructed for a
   Component, the background color is
   inherited from the Component. Setting the background color
   in the Graphics2D context only affects the subsequent
   clearRect calls and not the background color of the
   Component.  To change the background
   of the Component, use appropriate methods of
   the Component.

  color - the background color that is used in subsequent calls to clearRect - `java.awt.Color`"
  ([this color]
    (-> this (.setBackground color))))

(defn draw-rendered-image
  "Renders a RenderedImage,
   applying a transform from image
   space into user space before drawing.
   The transformation from user space into device space is done with
   the current Transform in the Graphics2D.
   The specified transformation is applied to the image before the
   transform attribute in the Graphics2D context is applied.
   The rendering attributes applied include the Clip,
   Transform, and Composite attributes. Note
   that no rendering is done if the specified transform is
   noninvertible.

  img - the image to be rendered. This method does nothing if img is null. - `java.awt.image.RenderedImage`
  xform - the transformation from image space into user space - `java.awt.geom.AffineTransform`"
  ([this img xform]
    (-> this (.drawRenderedImage img xform))))

(defn set-stroke
  "Sets the Stroke for the Graphics2D context.

  s - the Stroke object to be used to stroke a Shape during the rendering process - `java.awt.Stroke`"
  ([this s]
    (-> this (.setStroke s))))

(defn set-composite
  "Sets the Composite for the Graphics2D context.
   The Composite is used in all drawing methods such as
   drawImage, drawString, draw,
   and fill.  It specifies how new pixels are to be combined
   with the existing pixels on the graphics device during the rendering
   process.
   If this Graphics2D context is drawing to a
   Component on the display screen and the
   Composite is a custom object rather than an
   instance of the AlphaComposite class, and if
   there is a security manager, its checkPermission
   method is called with an AWTPermission(`readDisplayPixels`)
   permission.

  comp - the Composite object to be used for rendering - `java.awt.Composite`

  throws: java.lang.SecurityException - if a custom Composite object is being used to render to the screen and a security manager is set and its checkPermission method does not allow the operation."
  ([this comp]
    (-> this (.setComposite comp))))

(defn draw-string
  "Renders the text of the specified String, using the
   current text attribute state in the Graphics2D context.
   The baseline of the
   first character is at position (x, y) in
   the User Space.
   The rendering attributes applied include the Clip,
   Transform, Paint, Font and
   Composite attributes.  For characters in script
   systems such as Hebrew and Arabic, the glyphs can be rendered from
   right to left, in which case the coordinate supplied is the
   location of the leftmost character on the baseline.

  str - the string to be rendered - `java.lang.String`
  x - the x coordinate of the location where the String should be rendered - `int`
  y - the y coordinate of the location where the String should be rendered - `int`

  throws: java.lang.NullPointerException - if str is null"
  ([this str x y]
    (-> this (.drawString str x y))))

(defn fill
  "Fills the interior of a Shape using the settings of the
   Graphics2D context. The rendering attributes applied
   include the Clip, Transform,
   Paint, and Composite.

  s - the Shape to be filled - `java.awt.Shape`"
  ([this s]
    (-> this (.fill s))))

(defn get-device-configuration
  "Returns the device configuration associated with this
   Graphics2D.

  returns: the device configuration of this Graphics2D. - `java.awt.GraphicsConfiguration`"
  ([this]
    (-> this (.getDeviceConfiguration))))

(defn draw-3-d-rect
  "Draws a 3-D highlighted outline of the specified rectangle.
   The edges of the rectangle are highlighted so that they
   appear to be beveled and lit from the upper left corner.

   The colors used for the highlighting effect are determined
   based on the current color.
   The resulting rectangle covers an area that is
   width  1 pixels wide
   by height  1 pixels tall.  This method
   uses the current Color exclusively and ignores
   the current Paint.

  x - the x coordinate of the rectangle to be drawn. - `int`
  y - the y coordinate of the rectangle to be drawn. - `int`
  width - the width of the rectangle to be drawn. - `int`
  height - the height of the rectangle to be drawn. - `int`
  raised - a boolean that determines whether the rectangle appears to be raised above the surface or sunk into the surface. - `boolean`"
  ([this x y width height raised]
    (-> this (.draw3DRect x y width height raised))))

(defn draw
  "Strokes the outline of a Shape using the settings of the
   current Graphics2D context.  The rendering attributes
   applied include the Clip, Transform,
   Paint, Composite and
   Stroke attributes.

  s - the Shape to be rendered - `java.awt.Shape`"
  ([this s]
    (-> this (.draw s))))

(defn get-font-render-context
  "Get the rendering context of the Font within this
   Graphics2D context.
   The FontRenderContext
   encapsulates application hints such as anti-aliasing and
   fractional metrics, as well as target device specific information
   such as dots-per-inch.  This information should be provided by the
   application when using objects that perform typographical
   formatting, such as Font and
   TextLayout.  This information should also be provided
   by applications that perform their own layout and need accurate
   measurements of various characteristics of glyphs such as advance
   and line height when various rendering hints have been applied to
   the text rendering.

  returns: a reference to an instance of FontRenderContext. - `java.awt.font.FontRenderContext`"
  ([this]
    (-> this (.getFontRenderContext))))

(defn hit
  "Checks whether or not the specified Shape intersects
   the specified Rectangle, which is in device
   space. If onStroke is false, this method checks
   whether or not the interior of the specified Shape
   intersects the specified Rectangle.  If
   onStroke is true, this method checks
   whether or not the Stroke of the specified
   Shape outline intersects the specified
   Rectangle.
   The rendering attributes taken into account include the
   Clip, Transform, and Stroke
   attributes.

  rect - the area in device space to check for a hit - `java.awt.Rectangle`
  s - the Shape to check for a hit - `java.awt.Shape`
  on-stroke - flag used to choose between testing the stroked or the filled shape. If the flag is true, the Stroke outline is tested. If the flag is false, the filled Shape is tested. - `boolean`

  returns: true if there is a hit; false
   otherwise. - `boolean`"
  ([this rect s on-stroke]
    (-> this (.hit rect s on-stroke))))

(defn shear
  "Concatenates the current Graphics2D
   Transform with a shearing transform.
   Subsequent renderings are sheared by the specified
   multiplier relative to the previous position.
   This is equivalent to calling transform(SH), where SH
   is an AffineTransform represented by the following
   matrix:


            [   1   shx   0   ]
            [  shy   1    0   ]
            [   0    0    1   ]

  shx - the multiplier by which coordinates are shifted in the positive X axis direction as a function of their Y coordinate - `double`
  shy - the multiplier by which coordinates are shifted in the positive Y axis direction as a function of their X coordinate - `double`"
  ([this shx shy]
    (-> this (.shear shx shy))))

(defn get-background
  "Returns the background color used for clearing a region.

  returns: the current Graphics2D Color,
   which defines the background color. - `java.awt.Color`"
  ([this]
    (-> this (.getBackground))))

(defn draw-renderable-image
  "Renders a
   RenderableImage,
   applying a transform from image space into user space before drawing.
   The transformation from user space into device space is done with
   the current Transform in the Graphics2D.
   The specified transformation is applied to the image before the
   transform attribute in the Graphics2D context is applied.
   The rendering attributes applied include the Clip,
   Transform, and Composite attributes. Note
   that no rendering is done if the specified transform is
   noninvertible.

   Rendering hints set on the Graphics2D object might
   be used in rendering the RenderableImage.
   If explicit control is required over specific hints recognized by a
   specific RenderableImage, or if knowledge of which hints
   are used is required, then a RenderedImage should be
   obtained directly from the RenderableImage
   and rendered using
  drawRenderedImage.

  img - the image to be rendered. This method does nothing if img is null. - `java.awt.image.renderable.RenderableImage`
  xform - the transformation from image space into user space - `java.awt.geom.AffineTransform`"
  ([this img xform]
    (-> this (.drawRenderableImage img xform))))

(defn set-transform
  "Overwrites the Transform in the Graphics2D context.
   WARNING: This method should never be used to apply a new
   coordinate transform on top of an existing transform because the
   Graphics2D might already have a transform that is
   needed for other purposes, such as rendering Swing
   components or applying a scaling transformation to adjust for the
   resolution of a printer.
   To add a coordinate transform, use the
   transform, rotate, scale,
   or shear methods.  The setTransform
   method is intended only for restoring the original
   Graphics2D transform after rendering, as shown in this
   example:


   // Get the current transform
   AffineTransform saveAT = g2.getTransform();
   // Perform transformation
   g2d.transform(...);
   // Render
   g2d.draw(...);
   // Restore original transform
   g2d.setTransform(saveAT);

  tx - the AffineTransform that was retrieved from the getTransform method - `java.awt.geom.AffineTransform`"
  ([this tx]
    (-> this (.setTransform tx))))

(defn get-transform
  "Returns a copy of the current Transform in the
   Graphics2D context.

  returns: the current AffineTransform in the
               Graphics2D context. - `java.awt.geom.AffineTransform`"
  ([this]
    (-> this (.getTransform))))

(defn rotate
  "Concatenates the current Graphics2D
   Transform with a translated rotation
   transform.  Subsequent rendering is transformed by a transform
   which is constructed by translating to the specified location,
   rotating by the specified radians, and translating back by the same
   amount as the original translation.  This is equivalent to the
   following sequence of calls:


            translate(x, y);
            rotate(theta);
            translate(-x, -y);
   Rotating with a positive angle theta rotates points on the positive
   x axis toward the positive y axis.

  theta - the angle of rotation in radians - `double`
  x - the x coordinate of the origin of the rotation - `double`
  y - the y coordinate of the origin of the rotation - `double`"
  ([this theta x y]
    (-> this (.rotate theta x y)))
  ([this theta]
    (-> this (.rotate theta))))

(defn set-rendering-hints
  "Replaces the values of all preferences for the rendering
   algorithms with the specified hints.
   The existing values for all rendering hints are discarded and
   the new set of known hints and values are initialized from the
   specified Map object.
   Hint categories include controls for rendering quality and
   overall time/quality trade-off in the rendering process.
   Refer to the RenderingHints class for definitions of
   some common keys and values.

  hints - the rendering hints to be set - `java.util.Map<?,?>`"
  ([this hints]
    (-> this (.setRenderingHints hints))))

