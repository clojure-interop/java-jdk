(ns javax.swing.text.WrappedPlainView
  "View of plain text (text with only one font and color)
  that does line-wrapping.  This view expects that its
  associated element has child elements that represent
  the lines it should be wrapping.  It is implemented
  as a vertical box that contains logical line views.
  The logical line views are nested classes that render
  the logical line as multiple physical line if the logical
  line is too wide to fit within the allocation.  The
  line views draw upon the outer class for its state
  to reduce their memory requirements.

  The line views do all of their rendering through the
  drawLine method which in turn does all of
  its rendering through the drawSelectedText
  and drawUnselectedText methods.  This
  enables subclasses to easily specialize the rendering
  without concern for the layout aspects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text WrappedPlainView]))

(defn ->wrapped-plain-view
  "Constructor.

  Creates a new WrappedPlainView.  Lines can be wrapped on
   either character or word boundaries depending upon the
   setting of the wordWrap parameter.

  elem - the element underlying the view - `javax.swing.text.Element`
  word-wrap - should lines be wrapped on word boundaries? - `boolean`"
  ([^javax.swing.text.Element elem ^Boolean word-wrap]
    (new WrappedPlainView elem word-wrap))
  ([^javax.swing.text.Element elem]
    (new WrappedPlainView elem)))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.WrappedPlainView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.  This is implemented to provide the superclass
   behavior after first making sure that the current font
   metrics are cached (for the nested lines which use
   the metrics to determine the height of the potentially
   wrapped lines).

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  (^Float [^javax.swing.text.WrappedPlainView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn remove-update
  "Gives notification that something was removed from the
   document in a location that this view is responsible for.
   This is implemented to simply update the children.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.WrappedPlainView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate e a f))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.  This is implemented to provide the superclass
   behavior after first making sure that the current font
   metrics are cached (for the nested lines which use
   the metrics to determine the height of the potentially
   wrapped lines).

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  (^Float [^javax.swing.text.WrappedPlainView this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.  This is implemented to provide the superclass
   behavior after first making sure that the current font
   metrics are cached (for the nested lines which use
   the metrics to determine the height of the potentially
   wrapped lines).

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  (^Float [^javax.swing.text.WrappedPlainView this ^Integer axis]
    (-> this (.getMaximumSpan axis))))

(defn insert-update
  "Gives notification that something was inserted into the
   document in a location that this view is responsible for.
   This is implemented to simply update the children.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.WrappedPlainView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate e a f))))

(defn paint
  "Renders using the given rendering surface and area
   on that surface.  This is implemented to stash the
   selection positions, selection colors, and font
   metrics for the nested lines to use.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.WrappedPlainView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn next-tab-stop
  "Returns the next tab stop position after a given reference position.
   This implementation does not support things like centering so it
   ignores the tabOffset argument.

  x - the current position >= 0 - `float`
  tab-offset - the position within the text stream that the tab occurred at >= 0. - `int`

  returns: the tab stop, measured in points >= 0 - `float`"
  (^Float [^javax.swing.text.WrappedPlainView this ^Float x ^Integer tab-offset]
    (-> this (.nextTabStop x tab-offset))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view along the given axis, if it
   has any layout duties.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([^javax.swing.text.WrappedPlainView this ^Float width ^Float height]
    (-> this (.setSize width height))))

