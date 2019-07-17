(ns jdk.awt.font.GlyphVector
  "A GlyphVector object is a collection of glyphs
  containing geometric information for the placement of each glyph
  in a transformed coordinate space which corresponds to the
  device on which the GlyphVector is ultimately
  displayed.

  The GlyphVector does not attempt any interpretation of
  the sequence of glyphs it contains.  Relationships between adjacent
  glyphs in sequence are solely used to determine the placement of
  the glyphs in the visual coordinate space.

  Instances of GlyphVector are created by a Font.

  In a text processing application that can cache intermediate
  representations of text, creation and subsequent caching of a
  GlyphVector for use during rendering is the fastest
  method to present the visual representation of characters to a user.

  A GlyphVector is associated with exactly one
  Font, and can provide data useful only in relation to
  this Font.  In addition, metrics obtained from a
  GlyphVector are not generally geometrically scaleable
  since the pixelization and spacing are dependent on grid-fitting
  algorithms within a Font.  To facilitate accurate
  measurement of a GlyphVector and its component
  glyphs, you must specify a scaling transform, anti-alias mode, and
  fractional metrics mode when creating the GlyphVector.
  These characteristics can be derived from the destination device.

  For each glyph in the GlyphVector, you can obtain:

  the position of the glyph
  the transform associated with the glyph
  the metrics of the glyph in the context of the
    GlyphVector.  The metrics of the glyph may be
    different under different transforms, application specified
    rendering hints, and the specific instance of the glyph within
    the GlyphVector.


  Altering the data used to create the GlyphVector does not
  alter the state of the GlyphVector.

  Methods are provided to adjust the positions of the glyphs
  within the GlyphVector.  These methods are most
  appropriate for applications that are performing justification
  operations for the presentation of the glyphs.

  Methods are provided to transform individual glyphs within the
  GlyphVector.  These methods are primarily useful for
  special effects.

  Methods are provided to return both the visual, logical, and pixel bounds
  of the entire GlyphVector or of individual glyphs within
  the GlyphVector.

  Methods are provided to return a Shape for the
  GlyphVector, and for individual glyphs within the
  GlyphVector."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font GlyphVector]))

(defn ->glyph-vector
  "Constructor."
  ([]
    (new GlyphVector )))

(def *-flag-has-transforms
  "Static Constant.

  A flag used with getLayoutFlags that indicates that this GlyphVector has
   per-glyph transforms.

  type: int"
  GlyphVector/FLAG_HAS_TRANSFORMS)

(def *-flag-has-position-adjustments
  "Static Constant.

  A flag used with getLayoutFlags that indicates that this GlyphVector has
   position adjustments.  When this is true, the glyph positions don't match the
   accumulated default advances of the glyphs (for example, if kerning has been done).

  type: int"
  GlyphVector/FLAG_HAS_POSITION_ADJUSTMENTS)

(def *-flag-run-rtl
  "Static Constant.

  A flag used with getLayoutFlags that indicates that this GlyphVector has
   a right-to-left run direction.  This refers to the glyph-to-char mapping and does
   not imply that the visual locations of the glyphs are necessarily in this order,
   although generally they will be.

  type: int"
  GlyphVector/FLAG_RUN_RTL)

(def *-flag-complex-glyphs
  "Static Constant.

  A flag used with getLayoutFlags that indicates that this GlyphVector has
   a complex glyph-to-char mapping (one that does not map glyphs to chars one-to-one in
   strictly ascending or descending order matching the run direction).

  type: int"
  GlyphVector/FLAG_COMPLEX_GLYPHS)

(def *-flag-mask
  "Static Constant.

  A mask for supported flags from getLayoutFlags.  Only bits covered by the mask
   should be tested.

  type: int"
  GlyphVector/FLAG_MASK)

(defn get-glyph-outline
  "Returns a Shape whose interior corresponds to the
   visual representation of the specified glyph
   within this GlyphVector, offset to x, y.
   The outline returned by this method is positioned around the
   origin of each individual glyph.

  glyph-index - the index into this GlyphVector - `int`
  x - the X coordinate of the location of this GlyphVector - `float`
  y - the Y coordinate of the location of this GlyphVector - `float`

  returns: a Shape that is the outline of the glyph
     at the specified glyphIndex of this
     GlyphVector when rendered at the specified
     coordinates. - `java.awt.Shape`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.Shape [^java.awt.font.GlyphVector this ^Integer glyph-index ^Float x ^Float y]
    (-> this (.getGlyphOutline glyph-index x y)))
  (^java.awt.Shape [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphOutline glyph-index))))

(defn get-glyph-char-indices
  "Returns the character indices of the specified glyphs.
   The character index is the index of the first logical
   character represented by the glyph.  Indices are returned
   in glyph order.  The default implementation invokes
   getGlyphCharIndex for each glyph, and subclassers will probably
   want to override this implementation for performance reasons.
   Use this method for convenience and performance
   in processing of glyphcodes. If no array is passed in,
   a new array is created.

  begin-glyph-index - the index of the first glyph - `int`
  num-entries - the number of glyph indices - `int`
  code-return - the array into which to return the character indices - `int[]`

  returns: an array of character indices, one per glyph. - `int[]`"
  ([^java.awt.font.GlyphVector this ^Integer begin-glyph-index ^Integer num-entries code-return]
    (-> this (.getGlyphCharIndices begin-glyph-index num-entries code-return))))

(defn get-glyph-positions
  "Returns an array of glyph positions for the specified glyphs.
   This method is used for convenience and performance when
   processing glyph positions.
   If no array is passed in, a new array is created.
   Even numbered array entries beginning with position zero are the X
   coordinates of the glyph numbered beginGlyphIndex  position/2.
   Odd numbered array entries beginning with position one are the Y
   coordinates of the glyph numbered beginGlyphIndex  (position-1)/2.
   If beginGlyphIndex equals the number of of glyphs in
   this GlyphVector, this method gets the position after
   the last glyph and this position is used to define the advance of
   the entire GlyphVector.

  begin-glyph-index - the index at which to begin retrieving glyph positions - `int`
  num-entries - the number of glyphs to retrieve - `int`
  position-return - the array that receives the glyph positions and is then returned. - `float[]`

  returns: an array of glyph positions specified by
    beginGlyphIndex and numEntries. - `float[]`

  throws: java.lang.IllegalArgumentException - if numEntries is less than 0"
  ([^java.awt.font.GlyphVector this ^Integer begin-glyph-index ^Integer num-entries position-return]
    (-> this (.getGlyphPositions begin-glyph-index num-entries position-return))))

(defn perform-default-layout
  "Assigns default positions to each glyph in this
   GlyphVector. This can destroy information
   generated during initial layout of this GlyphVector."
  ([^java.awt.font.GlyphVector this]
    (-> this (.performDefaultLayout))))

(defn get-glyph-justification-info
  "Returns the justification information for the glyph at
   the specified index into this GlyphVector.

  glyph-index - the index into this GlyphVector that corresponds to the glyph from which to retrieve its justification properties - `int`

  returns: a GlyphJustificationInfo object that
     represents the justification properties of the glyph at the
     specified glyphIndex into this
     GlyphVector. - `java.awt.font.GlyphJustificationInfo`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.font.GlyphJustificationInfo [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphJustificationInfo glyph-index))))

(defn get-glyph-visual-bounds
  "Returns the visual bounds of the specified glyph within the
   GlyphVector.
   The bounds returned by this method is positioned around the
   origin of each individual glyph.

  glyph-index - the index into this GlyphVector that corresponds to the glyph from which to retrieve its visual bounds - `int`

  returns: a Shape that is the visual bounds of the
     glyph at the specified glyphIndex. - `java.awt.Shape`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.Shape [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphVisualBounds glyph-index))))

(defn get-num-glyphs
  "Returns the number of glyphs in this GlyphVector.

  returns: number of glyphs in this GlyphVector. - `int`"
  (^Integer [^java.awt.font.GlyphVector this]
    (-> this (.getNumGlyphs))))

(defn get-visual-bounds
  "Returns the visual bounds of this GlyphVector
   The visual bounds is the bounding box of the outline of this
   GlyphVector.  Because of rasterization and
   alignment of pixels, it is possible that this box does not
   enclose all pixels affected by rendering this GlyphVector.

  returns: a Rectangle2D that is the bounding box
   of this GlyphVector. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.font.GlyphVector this]
    (-> this (.getVisualBounds))))

(defn get-glyph-codes
  "Returns an array of glyphcodes for the specified glyphs.
   The contents of this return value are meaningless to anything other
   than the Font used to create this
   GlyphVector.  This method is used
   for convenience and performance when processing glyphcodes.
   If no array is passed in, a new array is created.

  begin-glyph-index - the index into this GlyphVector at which to start retrieving glyphcodes - `int`
  num-entries - the number of glyphcodes to retrieve - `int`
  code-return - the array that receives the glyphcodes and is then returned - `int[]`

  returns: an array of glyphcodes for the specified glyphs. - `int[]`

  throws: java.lang.IllegalArgumentException - if numEntries is less than 0"
  ([^java.awt.font.GlyphVector this ^Integer begin-glyph-index ^Integer num-entries code-return]
    (-> this (.getGlyphCodes begin-glyph-index num-entries code-return))))

(defn get-glyph-position
  "Returns the position of the specified glyph relative to the
   origin of this GlyphVector.
   If glyphIndex equals the number of of glyphs in
   this GlyphVector, this method returns the position after
   the last glyph. This position is used to define the advance of
   the entire GlyphVector.

  glyph-index - the index into this GlyphVector - `int`

  returns: a Point2D object that is the position of the glyph
     at the specified glyphIndex. - `java.awt.geom.Point2D`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than the number of glyphs in this GlyphVector"
  (^java.awt.geom.Point2D [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphPosition glyph-index))))

(defn get-layout-flags
  "Returns flags describing the global state of the GlyphVector.
   Flags not described below are reserved.  The default
   implementation returns 0 (meaning false) for the position adjustments,
   transforms, rtl, and complex flags.
   Subclassers should override this method, and make sure
   it correctly describes the GlyphVector and corresponds
   to the results of related calls.

  returns: an int containing the flags describing the state - `int`"
  (^Integer [^java.awt.font.GlyphVector this]
    (-> this (.getLayoutFlags))))

(defn get-logical-bounds
  "Returns the logical bounds of this GlyphVector.
   This method is used when positioning this GlyphVector
   in relation to visually adjacent GlyphVector objects.

  returns: a Rectangle2D that is the logical bounds of this
   GlyphVector. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.font.GlyphVector this]
    (-> this (.getLogicalBounds))))

(defn get-glyph-pixel-bounds
  "Returns the pixel bounds of the glyph at index when this
   GlyphVector is rendered in a Graphics with the
   given FontRenderContext at the given location. The
   renderFRC need not be the same as the
   FontRenderContext of this
   GlyphVector, and can be null.  If it is null, the
   FontRenderContext of this GlyphVector
   is used.  The default implementation returns the visual bounds of the glyph,
   offset to x, y and rounded out to the next integer value, and
   ignores the FRC.  Subclassers should override this method.

  index - the index of the glyph. - `int`
  render-frc - the FontRenderContext of the Graphics. - `java.awt.font.FontRenderContext`
  x - the X position at which to render this GlyphVector. - `float`
  y - the Y position at which to render this GlyphVector. - `float`

  returns: a Rectangle bounding the pixels that would be affected. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^java.awt.font.GlyphVector this ^Integer index ^java.awt.font.FontRenderContext render-frc ^Float x ^Float y]
    (-> this (.getGlyphPixelBounds index render-frc x y))))

(defn set-glyph-position
  "Sets the position of the specified glyph within this
   GlyphVector.
   If glyphIndex equals the number of of glyphs in
   this GlyphVector, this method sets the position after
   the last glyph. This position is used to define the advance of
   the entire GlyphVector.

  glyph-index - the index into this GlyphVector - `int`
  new-pos - the Point2D at which to position the glyph at the specified glyphIndex - `java.awt.geom.Point2D`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than the number of glyphs in this GlyphVector"
  ([^java.awt.font.GlyphVector this ^Integer glyph-index ^java.awt.geom.Point2D new-pos]
    (-> this (.setGlyphPosition glyph-index new-pos))))

(defn set-glyph-transform
  "Sets the transform of the specified glyph within this
   GlyphVector.  The transform is relative to the glyph
   position.  A null argument for newTX
   indicates that no special transform is applied for the specified
   glyph.
   This method can be used to rotate, mirror, translate and scale the
   glyph.  Adding a transform can result in significant performance changes.

  glyph-index - the index into this GlyphVector - `int`
  new-tx - the new transform of the glyph at glyphIndex - `java.awt.geom.AffineTransform`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  ([^java.awt.font.GlyphVector this ^Integer glyph-index ^java.awt.geom.AffineTransform new-tx]
    (-> this (.setGlyphTransform glyph-index new-tx))))

(defn get-outline
  "Returns a Shape whose interior corresponds to the
   visual representation of this GlyphVector when
   rendered at x, y.

  x - the X coordinate of this GlyphVector. - `float`
  y - the Y coordinate of this GlyphVector. - `float`

  returns: a Shape that is the outline of this
     GlyphVector when rendered at the specified
     coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^java.awt.font.GlyphVector this ^Float x ^Float y]
    (-> this (.getOutline x y)))
  (^java.awt.Shape [^java.awt.font.GlyphVector this]
    (-> this (.getOutline))))

(defn get-glyph-logical-bounds
  "Returns the logical bounds of the specified glyph within this
   GlyphVector.
   These logical bounds have a total of four edges, with two edges
   parallel to the baseline under the glyph's transform and the other two
   edges are shared with adjacent glyphs if they are present.  This
   method is useful for hit-testing of the specified glyph,
   positioning of a caret at the leading or trailing edge of a glyph,
   and for drawing a highlight region around the specified glyph.

  glyph-index - the index into this GlyphVector that corresponds to the glyph from which to retrieve its logical bounds - `int`

  returns: a Shape that is the logical bounds of the
     glyph at the specified glyphIndex. - `java.awt.Shape`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.Shape [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphLogicalBounds glyph-index))))

(defn get-font-render-context
  "Returns the FontRenderContext associated with this
   GlyphVector.

  returns: FontRenderContext used to create this
   GlyphVector. - `java.awt.font.FontRenderContext`"
  (^java.awt.font.FontRenderContext [^java.awt.font.GlyphVector this]
    (-> this (.getFontRenderContext))))

(defn get-font
  "Returns the Font associated with this
   GlyphVector.

  returns: Font used to create this
   GlyphVector. - `java.awt.Font`"
  (^java.awt.Font [^java.awt.font.GlyphVector this]
    (-> this (.getFont))))

(defn get-pixel-bounds
  "Returns the pixel bounds of this GlyphVector when
   rendered in a graphics with the given
   FontRenderContext at the given location.  The
   renderFRC need not be the same as the
   FontRenderContext of this
   GlyphVector, and can be null.  If it is null, the
   FontRenderContext of this GlyphVector
   is used.  The default implementation returns the visual bounds,
   offset to x, y and rounded out to the next integer value (i.e. returns an
   integer rectangle which encloses the visual bounds) and
   ignores the FRC.  Subclassers should override this method.

  render-frc - the FontRenderContext of the Graphics. - `java.awt.font.FontRenderContext`
  x - the x-coordinate at which to render this GlyphVector. - `float`
  y - the y-coordinate at which to render this GlyphVector. - `float`

  returns: a Rectangle bounding the pixels that would be affected. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^java.awt.font.GlyphVector this ^java.awt.font.FontRenderContext render-frc ^Float x ^Float y]
    (-> this (.getPixelBounds render-frc x y))))

(defn get-glyph-metrics
  "Returns the metrics of the glyph at the specified index into
   this GlyphVector.

  glyph-index - the index into this GlyphVector that corresponds to the glyph from which to retrieve its metrics - `int`

  returns: a GlyphMetrics object that represents the
     metrics of the glyph at the specified glyphIndex
     into this GlyphVector. - `java.awt.font.GlyphMetrics`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.font.GlyphMetrics [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphMetrics glyph-index))))

(defn get-glyph-code
  "Returns the glyphcode of the specified glyph.
   This return value is meaningless to anything other
   than the Font object that created this
   GlyphVector.

  glyph-index - the index into this GlyphVector that corresponds to the glyph from which to retrieve the glyphcode. - `int`

  returns: the glyphcode of the glyph at the specified
   glyphIndex. - `int`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^Integer [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphCode glyph-index))))

(defn equals
  "Tests if the specified GlyphVector exactly
   equals this GlyphVector.

  set - the specified GlyphVector to test - `java.awt.font.GlyphVector`

  returns: true if the specified
     GlyphVector equals this GlyphVector;
     false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.GlyphVector this ^java.awt.font.GlyphVector set]
    (-> this (.equals set))))

(defn get-glyph-transform
  "Returns the transform of the specified glyph within this
   GlyphVector.  The transform is relative to the
   glyph position.  If no special transform has been applied,
   null can be returned.  A null return indicates
   an identity transform.

  glyph-index - the index into this GlyphVector - `int`

  returns: an AffineTransform that is the transform of
     the glyph at the specified glyphIndex. - `java.awt.geom.AffineTransform`

  throws: java.lang.IndexOutOfBoundsException - if glyphIndex is less than 0 or greater than or equal to the number of glyphs in this GlyphVector"
  (^java.awt.geom.AffineTransform [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphTransform glyph-index))))

(defn get-glyph-char-index
  "Returns the character index of the specified glyph.
   The character index is the index of the first logical
   character represented by the glyph.  The default
   implementation assumes a one-to-one, left-to-right mapping
   of glyphs to characters.

  glyph-index - the index of the glyph - `int`

  returns: the index of the first character represented by the glyph - `int`"
  (^Integer [^java.awt.font.GlyphVector this ^Integer glyph-index]
    (-> this (.getGlyphCharIndex glyph-index))))

