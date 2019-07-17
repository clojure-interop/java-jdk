(ns javax.swing.text.ParagraphView
  "View of a simple line-wrapping paragraph that supports
  multiple fonts, colors, components, icons, etc.  It is
  basically a vertical box with a margin around it.  The
  contents of the box are a bunch of rows which are special
  horizontal boxes.  This view creates a collection of
  views that represent the child elements of the paragraph
  element.  Each of these views are placed into a row
  directly if they will fit, otherwise the breakView
  method is called to try and carve the view into pieces
  that fit."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ParagraphView]))

(defn ->paragraph-view
  "Constructor.

  Constructs a ParagraphView for the given element.

  elem - the element that this view is responsible for - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new ParagraphView elem)))

(defn get-flow-span
  "Fetches the constraining span to flow against for
   the given child index.

  index - the index of the view being queried - `int`

  returns: the constraining span for the given view at
    index - `int`"
  ([^javax.swing.text.ParagraphView this ^Integer index]
    (-> this (.getFlowSpan index))))

(defn get-flow-start
  "Fetches the location along the flow axis that the
   flow span will start at.

  index - the index of the view being queried - `int`

  returns: the location for the given view at
    index - `int`"
  ([^javax.swing.text.ParagraphView this ^Integer index]
    (-> this (.getFlowStart index))))

(defn next-tab-stop
  "Returns the next tab stop position given a reference position.
   This view implements the tab coordinate system, and calls
   getTabbedSpan on the logical children in the process
   of layout to determine the desired span of the children.  The
   logical children can delegate their tab expansion upward to
   the paragraph which knows how to expand tabs.
   LabelView is an example of a view that delegates
   its tab expansion needs upward to the paragraph.

   This is implemented to try and locate a TabSet
   in the paragraph element's attribute set.  If one can be
   found, its settings will be used, otherwise a default expansion
   will be provided.  The base location for for tab expansion
   is the left inset from the paragraphs most recent allocation
   (which is what the layout of the children is based upon).

  x - the X reference position - `float`
  tab-offset - the position within the text stream that the tab occurred at >= 0 - `int`

  returns: the trailing end of the tab expansion >= 0 - `float`"
  ([^javax.swing.text.ParagraphView this ^Float x ^Integer tab-offset]
    (-> this (.nextTabStop x tab-offset))))

(defn paint
  "Renders using the given rendering surface and area on that
   surface.  This is implemented to delegate to the superclass
   after stashing the base coordinate for tab calculations.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.ParagraphView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  This is implemented to give the alignment to the
   center of the first row along the y axis, and the default
   along the x axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the desired alignment.  This should be a value
     between 0.0 and 1.0 inclusive, where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin.  An alignment of 0.5 would be the
     center of the view. - `float`"
  ([^javax.swing.text.ParagraphView this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn break-view
  "Breaks this view on the given axis at the given length.

   ParagraphView instances are breakable
   along the Y_AXIS only, and only if
   len is after the first line.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  len - specifies where a potential break is desired along the given axis >= 0 - `float`
  a - the current allocation of the view - `java.awt.Shape`

  returns: the fragment of the view that represents the
    given span, if the view can be broken; if the view
    doesn't support breaking behavior, the view itself is
    returned - `javax.swing.text.View`"
  ([^javax.swing.text.ParagraphView this ^Integer axis ^Float len ^java.awt.Shape a]
    (-> this (.breakView axis len a))))

(defn get-break-weight
  "Gets the break weight for a given location.

   ParagraphView instances are breakable
   along the Y_AXIS only, and only if
   len is after the first row.  If the length
   is less than one row, a value of BadBreakWeight
   is returned.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  len - specifies where a potential break is desired >= 0 - `float`

  returns: a value indicating the attractiveness of breaking here;
    either GoodBreakWeight or BadBreakWeight - `int`"
  ([^javax.swing.text.ParagraphView this ^Integer axis ^Float len]
    (-> this (.getBreakWeight axis len))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.ParagraphView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate changes a f))))

