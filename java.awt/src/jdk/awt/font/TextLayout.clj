(ns jdk.awt.font.TextLayout
  "TextLayout is an immutable graphical representation of styled
  character data.

  It provides the following capabilities:

  implicit bidirectional analysis and reordering,
  cursor positioning and movement, including split cursors for
  mixed directional text,
  highlighting, including both logical and visual highlighting
  for mixed directional text,
  multiple baselines (roman, hanging, and centered),
  hit testing,
  justification,
  default font substitution,
  metric information such as ascent, descent, and advance, and
  rendering


  A TextLayout object can be rendered using
  its draw method.

  TextLayout can be constructed either directly or through
  the use of a LineBreakMeasurer.  When constructed directly, the
  source text represents a single paragraph.  LineBreakMeasurer
  allows styled text to be broken into lines that fit within a particular
  width.  See the LineBreakMeasurer documentation for more
  information.

  TextLayout construction logically proceeds as follows:

  paragraph attributes are extracted and examined,
  text is analyzed for bidirectional reordering, and reordering
  information is computed if needed,
  text is segmented into style runs
  fonts are chosen for style runs, first by using a font if the
  attribute TextAttribute.FONT is present, otherwise by computing
  a default font using the attributes that have been defined
  if text is on multiple baselines, the runs or subruns are further
  broken into subruns sharing a common baseline,
  glyphvectors are generated for each run using the chosen font,
  final bidirectional reordering is performed on the glyphvectors


  All graphical information returned from a TextLayout
  object's methods is relative to the origin of the
  TextLayout, which is the intersection of the
  TextLayout object's baseline with its left edge.  Also,
  coordinates passed into a TextLayout object's methods
  are assumed to be relative to the TextLayout object's
  origin.  Clients usually need to translate between a
  TextLayout object's coordinate system and the coordinate
  system in another object (such as a
  Graphics object).

  TextLayout objects are constructed from styled text,
  but they do not retain a reference to their source text.  Thus,
  changes in the text previously used to generate a TextLayout
  do not affect the TextLayout.

  Three methods on a TextLayout object
  (getNextRightHit, getNextLeftHit, and
  hitTestChar) return instances of TextHitInfo.
  The offsets contained in these TextHitInfo objects
  are relative to the start of the TextLayout, not
  to the text used to create the TextLayout.  Similarly,
  TextLayout methods that accept TextHitInfo
  instances as parameters expect the TextHitInfo object's
  offsets to be relative to the TextLayout, not to any
  underlying text storage model.

  Examples:
  Constructing and drawing a TextLayout and its bounding
  rectangle:


    Graphics2D g = ...;
    Point2D loc = ...;
    Font font = Font.getFont(`Helvetica-bold-italic`);
    FontRenderContext frc = g.getFontRenderContext();
    TextLayout layout = new TextLayout(`This is a string`, font, frc);
    layout.draw(g, (float)loc.getX(), (float)loc.getY());

    Rectangle2D bounds = layout.getBounds();
    bounds.setRect(bounds.getX()+loc.getX(),
                   bounds.getY()+loc.getY(),
                   bounds.getWidth(),
                   bounds.getHeight());
    g.draw(bounds);


  Hit-testing a TextLayout (determining which character is at
  a particular graphical location):


    Point2D click = ...;
    TextHitInfo hit = layout.hitTestChar(
                          (float) (click.getX() - loc.getX()),
                          (float) (click.getY() - loc.getY()));


  Responding to a right-arrow key press:


    int insertionIndex = ...;
    TextHitInfo next = layout.getNextRightHit(insertionIndex);
    if (next != null) {
        // translate graphics to origin of layout on screen
        g.translate(loc.getX(), loc.getY());
        Shape[] carets = layout.getCaretShapes(next.getInsertionIndex());
        g.draw(carets[0]);
        if (carets[1] != null) {
            g.draw(carets[1]);
        }
    }

  Drawing a selection range corresponding to a substring in the source text.
  The selected area may not be visually contiguous:


    // selStart, selLimit should be relative to the layout,
    // not to the source text

    int selStart = ..., selLimit = ...;
    Color selectionColor = ...;
    Shape selection = layout.getLogicalHighlightShape(selStart, selLimit);
    // selection may consist of disjoint areas
    // graphics is assumed to be tranlated to origin of layout
    g.setColor(selectionColor);
    g.fill(selection);

  Drawing a visually contiguous selection range.  The selection range may
  correspond to more than one substring in the source text.  The ranges of
  the corresponding source text substrings can be obtained with
  getLogicalRangesForVisualSelection():


    TextHitInfo selStart = ..., selLimit = ...;
    Shape selection = layout.getVisualHighlightShape(selStart, selLimit);
    g.setColor(selectionColor);
    g.fill(selection);
    int[] ranges = getLogicalRangesForVisualSelection(selStart, selLimit);
    // ranges[0], ranges[1] is the first selection range,
    // ranges[2], ranges[3] is the second selection range, etc.

  Note: Font rotations can cause text baselines to be rotated, and
  multiple runs with different rotations can cause the baseline to
  bend or zig-zag.  In order to account for this (rare) possibility,
  some APIs are specified to return metrics and take parameters 'in
  baseline-relative coordinates' (e.g. ascent, advance), and others
  are in 'in standard coordinates' (e.g. getBounds).  Values in
  baseline-relative coordinates map the 'x' coordinate to the
  distance along the baseline, (positive x is forward along the
  baseline), and the 'y' coordinate to a distance along the
  perpendicular to the baseline at 'x' (positive y is 90 degrees
  clockwise from the baseline vector).  Values in standard
  coordinates are measured along the x and y axes, with 0,0 at the
  origin of the TextLayout.  Documentation for each relevant API
  indicates what values are in what coordinate system.  In general,
  measurement-related APIs are in baseline-relative coordinates,
  while display-related APIs are in standard coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TextLayout]))

(defn ->text-layout
  "Constructor.

  Constructs a TextLayout from a String
   and a Font.  All the text is styled using the specified
   Font.

   The String must specify a single paragraph of text,
   because an entire paragraph is required for the bidirectional
   algorithm.

  string - the text to display - `java.lang.String`
  font - a Font used to style the text - `java.awt.Font`
  frc - contains information about a graphics device which is needed to measure the text correctly. Text measurements can vary slightly depending on the device resolution, and attributes such as antialiasing. This parameter does not specify a translation between the TextLayout and user space. - `java.awt.font.FontRenderContext`"
  (^TextLayout [^java.lang.String string ^java.awt.Font font ^java.awt.font.FontRenderContext frc]
    (new TextLayout string font frc))
  (^TextLayout [^java.text.AttributedCharacterIterator text ^java.awt.font.FontRenderContext frc]
    (new TextLayout text frc)))

(def *-default-caret-policy
  "Static Constant.

  This CaretPolicy is used when a policy is not specified
   by the client.  With this policy, a hit on a character whose direction
   is the same as the line direction is stronger than a hit on a
   counterdirectional character.  If the characters' directions are
   the same, a hit on the leading edge of a character is stronger
   than a hit on the trailing edge of a character.

  type: java.awt.font.TextLayout$CaretPolicy"
  TextLayout/DEFAULT_CARET_POLICY)

(defn get-caret-shapes
  "Returns two paths corresponding to the strong and weak caret.

  offset - an offset in this TextLayout - `int`
  bounds - the bounds to which to extend the carets. The bounds is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`
  policy - the specified CaretPolicy - `java.awt.font.TextLayout$CaretPolicy`

  returns: an array of two paths.  Element zero is the strong
   caret.  If there are two carets, element one is the weak caret,
   otherwise it is null. The returned shapes
   are in standard coordinates. - `java.awt.Shape[]`"
  ([^TextLayout this ^Integer offset ^java.awt.geom.Rectangle2D bounds ^java.awt.font.TextLayout$CaretPolicy policy]
    (-> this (.getCaretShapes offset bounds policy)))
  ([^TextLayout this ^Integer offset ^java.awt.geom.Rectangle2D bounds]
    (-> this (.getCaretShapes offset bounds)))
  ([^TextLayout this ^Integer offset]
    (-> this (.getCaretShapes offset))))

(defn get-visual-highlight-shape
  "Returns a path enclosing the visual selection in the specified range,
   extended to bounds.

   If the selection includes the leftmost (topmost) position, the selection
   is extended to the left (top) of bounds.  If the
   selection includes the rightmost (bottommost) position, the selection
   is extended to the right (bottom) of the bounds.  The height
   (width on vertical lines) of the selection is always extended to
   bounds.

   Although the selection is always contiguous, the logically selected
   text can be discontiguous on lines with mixed-direction text.  The
   logical ranges of text selected can be retrieved using
   getLogicalRangesForVisualSelection.  For example,
   consider the text 'ABCdef' where capital letters indicate
   right-to-left text, rendered on a right-to-left line, with a visual
   selection from 0L (the leading edge of 'A') to 3T (the trailing edge
   of 'd').  The text appears as follows, with bold underlined areas
   representing the selection:


      defCBA
   The logical selection ranges are 0-3, 4-6 (ABC, ef) because the
   visually contiguous text is logically discontiguous.  Also note that
   since the rightmost position on the layout (to the right of 'A') is
   selected, the selection is extended to the right of the bounds.

  first-endpoint - one end of the visual selection - `java.awt.font.TextHitInfo`
  second-endpoint - the other end of the visual selection - `java.awt.font.TextHitInfo`
  bounds - the bounding rectangle to which to extend the selection. This is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`

  returns: a Shape enclosing the selection.  This is in
       standard coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^TextLayout this ^java.awt.font.TextHitInfo first-endpoint ^java.awt.font.TextHitInfo second-endpoint ^java.awt.geom.Rectangle2D bounds]
    (-> this (.getVisualHighlightShape first-endpoint second-endpoint bounds)))
  (^java.awt.Shape [^TextLayout this ^java.awt.font.TextHitInfo first-endpoint ^java.awt.font.TextHitInfo second-endpoint]
    (-> this (.getVisualHighlightShape first-endpoint second-endpoint))))

(defn get-advance
  "Returns the advance of this TextLayout.
   The advance is the distance from the origin to the advance of the
   rightmost (bottommost) character.  This is in baseline-relative
   coordinates.

  returns: the advance of this TextLayout. - `float`"
  (^Float [^TextLayout this]
    (-> this (.getAdvance))))

(defn get-caret-info
  "Returns information about the caret corresponding to hit.
   The first element of the array is the intersection of the caret with
   the baseline, as a distance along the baseline. The second element
   of the array is the inverse slope (run/rise) of the caret, measured
   with respect to the baseline at that point.

   This method is meant for informational use.  To display carets, it
   is better to use getCaretShapes.

  hit - a hit on a character in this TextLayout - `java.awt.font.TextHitInfo`
  bounds - the bounds to which the caret info is constructed. The bounds is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`

  returns: a two-element array containing the position and slope of
   the caret.  The returned caret info is in baseline-relative coordinates. - `float[]`"
  ([^TextLayout this ^java.awt.font.TextHitInfo hit ^java.awt.geom.Rectangle2D bounds]
    (-> this (.getCaretInfo hit bounds)))
  ([^TextLayout this ^java.awt.font.TextHitInfo hit]
    (-> this (.getCaretInfo hit))))

(defn hit-test-char
  "Returns a TextHitInfo corresponding to the
   specified point.
   Coordinates outside the bounds of the TextLayout
   map to hits on the leading edge of the first logical character,
   or the trailing edge of the last logical character, as appropriate,
   regardless of the position of that character in the line.  Only the
   direction along the baseline is used to make this evaluation.

  x - the x offset from the origin of this TextLayout. This is in standard coordinates. - `float`
  y - the y offset from the origin of this TextLayout. This is in standard coordinates. - `float`
  bounds - the bounds of the TextLayout. This is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`

  returns: a hit describing the character and edge (leading or trailing)
       under the specified point. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^TextLayout this ^Float x ^Float y ^java.awt.geom.Rectangle2D bounds]
    (-> this (.hitTestChar x y bounds)))
  (^java.awt.font.TextHitInfo [^TextLayout this ^Float x ^Float y]
    (-> this (.hitTestChar x y))))

(defn left-to-right?
  "Returns true if this TextLayout has
   a left-to-right base direction or false if it has
   a right-to-left base direction.  The TextLayout
   has a base direction of either left-to-right (LTR) or
   right-to-left (RTL).  The base direction is independent of the
   actual direction of text on the line, which may be either LTR,
   RTL, or mixed. Left-to-right layouts by default should position
   flush left.  If the layout is on a tabbed line, the
   tabs run left to right, so that logically successive layouts position
   left to right.  The opposite is true for RTL layouts. By default they
   should position flush left, and tabs run right-to-left.

  returns: true if the base direction of this
           TextLayout is left-to-right; false
           otherwise. - `boolean`"
  (^Boolean [^TextLayout this]
    (-> this (.isLeftToRight))))

(defn get-ascent
  "Returns the ascent of this TextLayout.
   The ascent is the distance from the top (right) of the
   TextLayout to the baseline.  It is always either
   positive or zero.  The ascent is sufficient to
   accommodate superscripted text and is the maximum of the sum of the
   ascent, offset, and baseline of each glyph.  The ascent is
   the maximum ascent from the baseline of all the text in the
   TextLayout.  It is in baseline-relative coordinates.

  returns: the ascent of this TextLayout. - `float`"
  (^Float [^TextLayout this]
    (-> this (.getAscent))))

(defn to-string
  "Returns debugging information for this TextLayout.

  returns: the textLine of this TextLayout
          as a String. - `java.lang.String`"
  (^java.lang.String [^TextLayout this]
    (-> this (.toString))))

(defn get-layout-path
  "Return the LayoutPath, or null if the layout path is the
   default path (x maps to advance, y maps to offset).

  returns: the layout path - `java.awt.font.LayoutPath`"
  (^java.awt.font.LayoutPath [^TextLayout this]
    (-> this (.getLayoutPath))))

(defn get-next-right-hit
  "Returns the hit for the next caret to the right (bottom); if no
   such hit, returns null.  The hit is to the right of
   the strong caret at the specified offset, as determined by the
   specified policy.
   The returned hit is the stronger of the two possible
   hits, as determined by the specified policy.

  offset - an insertion offset in this TextLayout. Cannot be less than 0 or greater than this TextLayout object's character count. - `int`
  policy - the policy used to select the strong caret - `java.awt.font.TextLayout$CaretPolicy`

  returns: a hit whose caret appears at the next position to the
   right (bottom) of the caret of the provided hit, or null. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^TextLayout this ^Integer offset ^java.awt.font.TextLayout$CaretPolicy policy]
    (-> this (.getNextRightHit offset policy)))
  (^java.awt.font.TextHitInfo [^TextLayout this ^java.awt.font.TextHitInfo hit]
    (-> this (.getNextRightHit hit))))

(defn get-descent
  "Returns the descent of this TextLayout.
   The descent is the distance from the baseline to the bottom (left) of
   the TextLayout.  It is always either positive or zero.
   The descent is sufficient to accommodate subscripted text and is the
   maximum of the sum of the descent, offset, and baseline of each glyph.
   This is the maximum descent from the baseline of all the text in
   the TextLayout.  It is in baseline-relative coordinates.

  returns: the descent of this TextLayout. - `float`"
  (^Float [^TextLayout this]
    (-> this (.getDescent))))

(defn get-logical-highlight-shape
  "Returns a Shape enclosing the logical selection in the
   specified range, extended to the specified bounds.

   If the selection range includes the first logical character, the
   selection is extended to the portion of bounds before
   the start of this TextLayout.  If the range includes
   the last logical character, the selection is extended to the portion
   of bounds after the end of this TextLayout.
   The height (width on vertical lines) of the selection is always
   extended to bounds.

   The selection can be discontiguous on lines with mixed-direction text.
   Only those characters in the logical range between start and limit
   appear selected.  For example, consider the text 'ABCdef' where capital
   letters indicate right-to-left text, rendered on a right-to-left line,
   with a logical selection from 0 to 4 ('ABCd').  The text appears as
   follows, with bold standing in for the selection, and underlining for
   the extension:


      defCBA
   The selection is discontiguous because the selected characters are
   visually discontiguous. Also note that since the range includes the
   first logical character (A), the selection is extended to the portion
   of the bounds before the start of the layout, which in
   this case (a right-to-left line) is the right portion of the
   bounds.

  first-endpoint - an endpoint in the range of characters to select - `int`
  second-endpoint - the other endpoint of the range of characters to select. Can be less than firstEndpoint. The range includes the character at min(firstEndpoint, secondEndpoint), but excludes max(firstEndpoint, secondEndpoint). - `int`
  bounds - the bounding rectangle to which to extend the selection. This is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`

  returns: an area enclosing the selection.  This is in standard
       coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^TextLayout this ^Integer first-endpoint ^Integer second-endpoint ^java.awt.geom.Rectangle2D bounds]
    (-> this (.getLogicalHighlightShape first-endpoint second-endpoint bounds)))
  (^java.awt.Shape [^TextLayout this ^Integer first-endpoint ^Integer second-endpoint]
    (-> this (.getLogicalHighlightShape first-endpoint second-endpoint))))

(defn get-baseline-offsets
  "Returns the offsets array for the baselines used for this
   TextLayout.

   The array is indexed by one of the values defined in
   Font, which are roman, centered and hanging.  The
   values are relative to this TextLayout object's
   baseline, so that getBaselineOffsets[getBaseline()] == 0.
   Offsets are added to the position of the TextLayout
   object's baseline to get the position for the new baseline.

  returns: the offsets array containing the baselines used for this
      TextLayout. - `float[]`"
  ([^TextLayout this]
    (-> this (.getBaselineOffsets))))

(defn get-character-level
  "Returns the level of the character at index.
   Indices -1 and characterCount are assigned the base
   level of this TextLayout.

  index - the index of the character from which to get the level - `int`

  returns: the level of the character at the specified index. - `byte`"
  (^Byte [^TextLayout this ^Integer index]
    (-> this (.getCharacterLevel index))))

(defn get-caret-shape
  "Returns a Shape representing the caret at the specified
   hit inside the specified bounds.

  hit - the hit at which to generate the caret - `java.awt.font.TextHitInfo`
  bounds - the bounds of the TextLayout to use in generating the caret. The bounds is in baseline-relative coordinates. - `java.awt.geom.Rectangle2D`

  returns: a Shape representing the caret.  The returned
      shape is in standard coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^TextLayout this ^java.awt.font.TextHitInfo hit ^java.awt.geom.Rectangle2D bounds]
    (-> this (.getCaretShape hit bounds)))
  (^java.awt.Shape [^TextLayout this ^java.awt.font.TextHitInfo hit]
    (-> this (.getCaretShape hit))))

(defn get-outline
  "Returns a Shape representing the outline of this
   TextLayout.

  tx - an optional AffineTransform to apply to the outline of this TextLayout. - `java.awt.geom.AffineTransform`

  returns: a Shape that is the outline of this
       TextLayout.  This is in standard coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^TextLayout this ^java.awt.geom.AffineTransform tx]
    (-> this (.getOutline tx))))

(defn get-logical-ranges-for-visual-selection
  "Returns the logical ranges of text corresponding to a visual selection.

  first-endpoint - an endpoint of the visual range - `java.awt.font.TextHitInfo`
  second-endpoint - the other endpoint of the visual range. This endpoint can be less than firstEndpoint. - `java.awt.font.TextHitInfo`

  returns: an array of integers representing start/limit pairs for the
   selected ranges. - `int[]`"
  ([^TextLayout this ^java.awt.font.TextHitInfo first-endpoint ^java.awt.font.TextHitInfo second-endpoint]
    (-> this (.getLogicalRangesForVisualSelection first-endpoint second-endpoint))))

(defn get-next-left-hit
  "Returns the hit for the next caret to the left (top); if no
   such hit, returns null.  The hit is to the left of
   the strong caret at the specified offset, as determined by the
   specified policy.
   The returned hit is the stronger of the two possible
   hits, as determined by the specified policy.

  offset - an insertion offset in this TextLayout. Cannot be less than 0 or greater than this TextLayout object's character count. - `int`
  policy - the policy used to select the strong caret - `java.awt.font.TextLayout$CaretPolicy`

  returns: a hit whose caret appears at the next position to the
   left (top) of the caret of the provided hit, or null. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^TextLayout this ^Integer offset ^java.awt.font.TextLayout$CaretPolicy policy]
    (-> this (.getNextLeftHit offset policy)))
  (^java.awt.font.TextHitInfo [^TextLayout this ^java.awt.font.TextHitInfo hit]
    (-> this (.getNextLeftHit hit))))

(defn get-leading
  "Returns the leading of the TextLayout.
   The leading is the suggested interline spacing for this
   TextLayout.  This is in baseline-relative
   coordinates.

   The leading is computed from the leading, descent, and baseline
   of all glyphvectors in the TextLayout.  The algorithm
   is roughly as follows:


   maxD = 0;
   maxDL = 0;
   for (GlyphVector g in all glyphvectors) {
      maxD = max(maxD, g.getDescent()  offsets[g.getBaseline()]);
      maxDL = max(maxDL, g.getDescent()  g.getLeading()
                         offsets[g.getBaseline()]);
   }
   return maxDL - maxD;

  returns: the leading of this TextLayout. - `float`"
  (^Float [^TextLayout this]
    (-> this (.getLeading))))

(defn draw
  "Renders this TextLayout at the specified location in
   the specified Graphics2D context.
   The origin of the layout is placed at x, y.  Rendering may touch
   any point within getBounds() of this position.  This
   leaves the g2 unchanged.  Text is rendered along the
   baseline path.

  g-2 - the Graphics2D context into which to render the layout - `java.awt.Graphics2D`
  x - the X coordinate of the origin of this TextLayout - `float`
  y - the Y coordinate of the origin of this TextLayout - `float`"
  ([^TextLayout this ^java.awt.Graphics2D g-2 ^Float x ^Float y]
    (-> this (.draw g-2 x y))))

(defn vertical?
  "Returns true if this TextLayout is vertical.

  returns: true if this TextLayout is vertical;
        false otherwise. - `boolean`"
  (^Boolean [^TextLayout this]
    (-> this (.isVertical))))

(defn hash-code
  "Returns the hash code of this TextLayout.

  returns: the hash code of this TextLayout. - `int`"
  (^Integer [^TextLayout this]
    (-> this (.hashCode))))

(defn get-bounds
  "Returns the bounds of this TextLayout.
   The bounds are in standard coordinates.
   Due to rasterization effects, this bounds might not enclose all of the
   pixels rendered by the TextLayout.
   It might not coincide exactly with the ascent, descent,
   origin or advance of the TextLayout.

  returns: a Rectangle2D that is the bounds of this
          TextLayout. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^TextLayout this]
    (-> this (.getBounds))))

(defn get-pixel-bounds
  "Returns the pixel bounds of this TextLayout when
   rendered in a graphics with the given
   FontRenderContext at the given location.  The
   graphics render context need not be the same as the
   FontRenderContext used to create this
   TextLayout, and can be null.  If it is null, the
   FontRenderContext of this TextLayout
   is used.

  frc - the FontRenderContext of the Graphics. - `java.awt.font.FontRenderContext`
  x - the x-coordinate at which to render this TextLayout. - `float`
  y - the y-coordinate at which to render this TextLayout. - `float`

  returns: a Rectangle bounding the pixels that would be affected. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^TextLayout this ^java.awt.font.FontRenderContext frc ^Float x ^Float y]
    (-> this (.getPixelBounds frc x y))))

(defn get-justified-layout
  "Creates a copy of this TextLayout justified to the
   specified width.

   If this TextLayout has already been justified, an
   exception is thrown.  If this TextLayout object's
   justification ratio is zero, a TextLayout identical
   to this TextLayout is returned.

  justification-width - the width to use when justifying the line. For best results, it should not be too different from the current advance of the line. - `float`

  returns: a TextLayout justified to the specified width. - `java.awt.font.TextLayout`

  throws: java.lang.Error - if this layout has already been justified, an Error is thrown."
  (^java.awt.font.TextLayout [^TextLayout this ^Float justification-width]
    (-> this (.getJustifiedLayout justification-width))))

(defn get-character-count
  "Returns the number of characters represented by this
   TextLayout.

  returns: the number of characters in this TextLayout. - `int`"
  (^Integer [^TextLayout this]
    (-> this (.getCharacterCount))))

(defn get-baseline
  "Returns the baseline for this TextLayout.
   The baseline is one of the values defined in Font,
   which are roman, centered and hanging.  Ascent and descent are
   relative to this baseline.  The baselineOffsets
   are also relative to this baseline.

  returns: the baseline of this TextLayout. - `byte`"
  (^Byte [^TextLayout this]
    (-> this (.getBaseline))))

(defn get-black-box-bounds
  "Returns the black box bounds of the characters in the specified range.
   The black box bounds is an area consisting of the union of the bounding
   boxes of all the glyphs corresponding to the characters between start
   and limit.  This area can be disjoint.

  first-endpoint - one end of the character range - `int`
  second-endpoint - the other end of the character range. Can be less than firstEndpoint. - `int`

  returns: a Shape enclosing the black box bounds.  This is
       in standard coordinates. - `java.awt.Shape`"
  (^java.awt.Shape [^TextLayout this ^Integer first-endpoint ^Integer second-endpoint]
    (-> this (.getBlackBoxBounds first-endpoint second-endpoint))))

(defn equals
  "Returns true if the specified Object is a
   TextLayout object and if the specified Object
   equals this TextLayout.

  obj - an Object to test for equality - `java.lang.Object`

  returns: true if the specified Object
        equals this TextLayout; false
        otherwise. - `boolean`"
  (^Boolean [^TextLayout this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-visible-advance
  "Returns the advance of this TextLayout, minus trailing
   whitespace.  This is in baseline-relative coordinates.

  returns: the advance of this TextLayout without the
        trailing whitespace. - `float`"
  (^Float [^TextLayout this]
    (-> this (.getVisibleAdvance))))

(defn hit-to-point
  "Convert a hit to a point in standard coordinates.  The point is
   on the baseline of the character at the leading or trailing
   edge of the character, as appropriate.  If the path is
   broken at the side of the character represented by the hit, the
   point will be adjacent to the character.

  hit - the hit to check. This must be a valid hit on the TextLayout. - `java.awt.font.TextHitInfo`
  point - the returned point. The point is in standard coordinates. - `java.awt.geom.Point2D`

  throws: java.lang.IllegalArgumentException - if the hit is not valid for the TextLayout."
  ([^TextLayout this ^java.awt.font.TextHitInfo hit ^java.awt.geom.Point2D point]
    (-> this (.hitToPoint hit point))))

(defn get-visual-other-hit
  "Returns the hit on the opposite side of the specified hit's caret.

  hit - the specified hit - `java.awt.font.TextHitInfo`

  returns: a hit that is on the opposite side of the specified hit's
      caret. - `java.awt.font.TextHitInfo`"
  (^java.awt.font.TextHitInfo [^TextLayout this ^java.awt.font.TextHitInfo hit]
    (-> this (.getVisualOtherHit hit))))

