(ns javax.swing.text.GlyphView
  "A GlyphView is a styled chunk of text that represents a view
  mapped over an element in the text model. This view is generally
  responsible for displaying text glyphs using character level
  attributes in some way.
  An implementation of the GlyphPainter class is used to do the
  actual rendering and model/view translations.  This separates
  rendering from layout and management of the association with
  the model.

  The view supports breaking for the purpose of formatting.
  The fragments produced by breaking share the view that has
  primary responsibility for the element (i.e. they are nested
  classes and carry only a small amount of state of their own)
  so they can share its resources.

  Since this view
  represents text that may have tabs embedded in it, it implements the
  TabableView interface.  Tabs will only be
  expanded if this view is embedded in a container that does
  tab expansion.  ParagraphView is an example of a container
  that does tab expansion."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text GlyphView]))

(defn ->glyph-view
  "Constructor.

  Constructs a new view wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new GlyphView elem)))

(defn get-break-weight
  "Determines how attractive a break opportunity in
   this view is.  This can be used for determining which
   view is the most attractive to call breakView
   on in the process of formatting.  The
   higher the weight, the more attractive the break.  A
   value equal to or lower than View.BadBreakWeight
   should not be considered for a break.  A value greater
   than or equal to View.ForcedBreakWeight should
   be broken.

   This is implemented to forward to the superclass for
   the Y_AXIS.  Along the X_AXIS the following values
   may be returned.

   View.ExcellentBreakWeight
   if there is whitespace proceeding the desired break
     location.
   View.BadBreakWeight
   if the desired break location results in a break
     location of the starting offset.
   View.GoodBreakWeight
   if the other conditions don't occur.

   This will normally result in the behavior of breaking
   on a whitespace location if one can be found, otherwise
   breaking between characters.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  pos - the potential location of the start of the broken view >= 0. This may be useful for calculating tab positions. - `float`
  len - specifies the relative length from pos where a potential break is desired >= 0. - `float`

  returns: the weight, which should be a value between
     View.ForcedBreakWeight and View.BadBreakWeight. - `int`"
  ([^javax.swing.text.GlyphView this ^Integer axis ^Float pos ^Float len]
    (-> this (.getBreakWeight axis pos len))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.
   This is implemented to call preferenceChanged along both the
   horizontal and vertical axis.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.GlyphView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  ([^javax.swing.text.GlyphView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.
   This is implemented to call preferenceChanged along the
   axis the glyphs are rendered.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.GlyphView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate e a f))))

(defn strike-through?
  "Determine if the glyphs should have a strikethrough
   line.  If true, a line should be drawn through the center
   of the glyphs.

  returns: `boolean`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.isStrikeThrough))))

(defn get-foreground
  "Fetch the foreground color to use to render the
   glyphs.  If there is no foreground color, null should
   be returned.  This is implemented to call
   StyledDocument.getBackground if the associated
   document is a StyledDocument.  If the associated document
   is not a StyledDocument, the associated components foreground
   color is used.  If there is no associated component, null
   is returned.

  returns: `java.awt.Color`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getForeground))))

(defn create-fragment
  "Creates a view that represents a portion of the element.
   This is potentially useful during formatting operations
   for taking measurements of fragments of the view.  If
   the view doesn't support fragmenting (the default), it
   should return itself.

   This view does support fragmenting.  It is implemented
   to return a nested class that shares state in this view
   representing only a portion of the view.

  p-0 - the starting offset >= 0. This should be a value greater or equal to the element starting offset and less than the element ending offset. - `int`
  p-1 - the ending offset > p0. This should be a value less than or equal to the elements end offset and greater than the elements starting offset. - `int`

  returns: the view fragment, or itself if the view doesn't
     support breaking into fragments - `javax.swing.text.View`"
  ([^javax.swing.text.GlyphView this ^Integer p-0 ^Integer p-1]
    (-> this (.createFragment p-0 p-1))))

(defn get-end-offset
  "Fetches the portion of the model that this view is responsible for.

  returns: the ending offset into the model - `int`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getEndOffset))))

(defn get-text
  "Fetch a reference to the text that occupies
   the given range.  This is normally used by
   the GlyphPainter to determine what characters
   it should render glyphs for.

  p-0 - the starting document offset >= 0 - `int`
  p-1 - the ending document offset >= p0 - `int`

  returns: the Segment containing the text - `javax.swing.text.Segment`"
  ([^javax.swing.text.GlyphView this ^Integer p-0 ^Integer p-1]
    (-> this (.getText p-0 p-1))))

(defn subscript?
  "Determine if the glyphs should be rendered as superscript.

  returns: `boolean`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.isSubscript))))

(defn get-tabbed-span
  "Determines the desired span when using the given
   tab expansion implementation.

  x - the position the view would be located at for the purpose of tab expansion >= 0. - `float`
  e - how to expand the tabs when encountered. - `javax.swing.text.TabExpander`

  returns: the desired span >= 0 - `float`"
  ([^javax.swing.text.GlyphView this ^Float x ^javax.swing.text.TabExpander e]
    (-> this (.getTabbedSpan x e))))

(defn get-tab-expander
  "Fetch the TabExpander to use if tabs are present in this view.

  returns: `javax.swing.text.TabExpander`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getTabExpander))))

(defn superscript?
  "Determine if the glyphs should be rendered as subscript.

  returns: `boolean`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.isSuperscript))))

(defn get-minimum-span
  "Determines the minimum span for this view along an axis.

   This implementation returns the longest non-breakable area within
   the view as a minimum span for View.X_AXIS.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the minimum span the view can be rendered into - `float`

  throws: java.lang.IllegalArgumentException - if the axis parameter is invalid"
  ([^javax.swing.text.GlyphView this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn insert-update
  "Gives notification that something was inserted into
   the document in a location that this view is responsible for.
   This is implemented to call preferenceChanged along the
   axis the glyphs are rendered.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.GlyphView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate e a f))))

(defn paint
  "Renders a portion of a text style run.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.GlyphView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  For the label, the alignment is along the font
   baseline for the y axis, and the superclasses alignment
   along the x axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the desired alignment.  This should be a value
     between 0.0 and 1.0 inclusive, where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin.  An alignment of 0.5 would be the
     center of the view. - `float`"
  ([^javax.swing.text.GlyphView this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn get-start-offset
  "Fetches the portion of the model that this view is responsible for.

  returns: the starting offset into the model - `int`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getStartOffset))))

(defn get-partial-span
  "Determines the span along the same axis as tab
   expansion for a portion of the view.  This is
   intended for use by the TabExpander for cases
   where the tab expansion involves aligning the
   portion of text that doesn't have whitespace
   relative to the tab stop.  There is therefore
   an assumption that the range given does not
   contain tabs.

   This method can be called while servicing the
   getTabbedSpan or getPreferredSize.  It has to
   arrange for its own text buffer to make the
   measurements.

  p-0 - the starting document offset >= 0 - `int`
  p-1 - the ending document offset >= p0 - `int`

  returns: the span >= 0 - `float`"
  ([^javax.swing.text.GlyphView this ^Integer p-0 ^Integer p-1]
    (-> this (.getPartialSpan p-0 p-1))))

(defn set-glyph-painter
  "Sets the painter to use for rendering glyphs.

  p - `javax.swing.text.GlyphView.GlyphPainter`"
  ([^javax.swing.text.GlyphView this ^javax.swing.text.GlyphView.GlyphPainter p]
    (-> this (.setGlyphPainter p))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - the X coordinate >= 0 - `float`
  y - the Y coordinate >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias-return - either Position.Bias.Forward or Position.Bias.Backward is returned as the zero-th element of this array - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point of view >= 0 - `int`"
  ([^javax.swing.text.GlyphView this ^Float x ^Float y ^java.awt.Shape a ^javax.swing.text.Position.Bias[] bias-return]
    (-> this (.viewToModel x y a bias-return))))

(defn get-font
  "Fetch the font that the glyphs should be based
   upon.  This is implemented to call
   StyledDocument.getFont if the associated
   document is a StyledDocument.  If the associated document
   is not a StyledDocument, the associated components font
   is used.  If there is no associated component, null
   is returned.

  returns: `java.awt.Font`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getFont))))

(defn get-background
  "Fetch the background color to use to render the
   glyphs.  If there is no background color, null should
   be returned.  This is implemented to call
   StyledDocument.getBackground if the associated
   document is a styled document, otherwise it returns null.

  returns: `java.awt.Color`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getBackground))))

(defn underline?
  "Determine if the glyphs should be underlined.  If true,
   an underline should be drawn through the baseline.

  returns: `boolean`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.isUnderline))))

(defn break-view
  "Breaks this view on the given axis at the given length.
   This is implemented to attempt to break on a whitespace
   location, and returns a fragment with the whitespace at
   the end.  If a whitespace location can't be found, the
   nearest character is used.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  p-0 - the location in the model where the fragment should start it's representation >= 0. - `int`
  pos - the position along the axis that the broken view would occupy >= 0. This may be useful for things like tab calculations. - `float`
  len - specifies the distance along the axis where a potential break is desired >= 0. - `float`

  returns: the fragment of the view that represents the
    given span, if the view can be broken.  If the view
    doesn't support breaking behavior, the view itself is
    returned. - `javax.swing.text.View`"
  ([^javax.swing.text.GlyphView this ^Integer axis ^Integer p-0 ^Float pos ^Float len]
    (-> this (.breakView axis p-0 pos len))))

(defn get-glyph-painter
  "Fetch the currently installed glyph painter.
   If a painter has not yet been installed, and
   a default was not yet needed, null is returned.

  returns: `javax.swing.text.GlyphView.GlyphPainter`"
  ([^javax.swing.text.GlyphView this]
    (-> this (.getGlyphPainter))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([^javax.swing.text.GlyphView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be
   visible, they might not be in the same order found in the model, or
   they just might not allow access to some of the locations in the
   model.
   This method enables specifying a position to convert
   within the range of >=0.  If the value is -1, a position
   will be calculated automatically.  If the value < -1,
   the BadLocationException will be thrown.

  pos - the position to convert - `int`
  b - `javax.swing.text.Position.Bias`
  a - the allocated region to render into - `java.awt.Shape`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This may be SwingConstants.WEST, SwingConstants.EAST, SwingConstants.NORTH, or SwingConstants.SOUTH. - `int`
  bias-ret - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position. - `int`

  throws: javax.swing.text.BadLocationException - the given position is not a valid position within the document"
  ([^javax.swing.text.GlyphView this ^Integer pos ^javax.swing.text.Position.Bias b ^java.awt.Shape a ^Integer direction ^javax.swing.text.Position.Bias[] bias-ret]
    (-> this (.getNextVisualPositionFrom pos b a direction bias-ret))))

