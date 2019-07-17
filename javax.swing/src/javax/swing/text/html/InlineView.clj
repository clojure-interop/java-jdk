(ns javax.swing.text.html.InlineView
  "Displays the inline element styles
  based upon css attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html InlineView]))

(defn ->inline-view
  "Constructor.

  Constructs a new view wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new InlineView elem)))

(defn insert-update
  "Gives notification that something was inserted into
   the document in a location that this view is responsible for.
   If either parameter is null, behavior of this method is
   implementation dependent.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.html.InlineView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate e a f))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.
   If either parameter is null, behavior of this method is
   implementation dependent.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.html.InlineView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate e a f))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.html.InlineView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

(defn get-attributes
  "Fetches the attributes to use when rendering.  This is
   implemented to multiplex the attributes specified in the
   model with a StyleSheet.

  returns: `javax.swing.text.AttributeSet`"
  ([^javax.swing.text.html.InlineView this]
    (-> this (.getAttributes))))

(defn get-break-weight
  "Determines how attractive a break opportunity in
   this view is.  This can be used for determining which
   view is the most attractive to call breakView
   on in the process of formatting.  A view that represents
   text that has whitespace in it might be more attractive
   than a view that has no whitespace, for example.  The
   higher the weight, the more attractive the break.  A
   value equal to or lower than BadBreakWeight
   should not be considered for a break.  A value greater
   than or equal to ForcedBreakWeight should
   be broken.

   This is implemented to provide the default behavior
   of returning BadBreakWeight unless the length
   is greater than the length of the view in which case the
   entire view represents the fragment.  Unless a view has
   been written to support breaking behavior, it is not
   attractive to try and break the view.  An example of
   a view that does support breaking is LabelView.
   An example of a view that uses break weight is
   ParagraphView.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  pos - the potential location of the start of the broken view >= 0. This may be useful for calculating tab positions. - `float`
  len - specifies the relative length from pos where a potential break is desired >= 0. - `float`

  returns: the weight, which should be a value between
     ForcedBreakWeight and BadBreakWeight. - `int`"
  ([^javax.swing.text.html.InlineView this ^Integer axis ^Float pos ^Float len]
    (-> this (.getBreakWeight axis pos len))))

(defn break-view
  "Tries to break this view on the given axis. Refer to
   View.breakView(int, int, float, float) for a complete
   description of this method.
   Behavior of this method is unspecified in case axis
   is neither View.X_AXIS nor View.Y_AXIS, and
   in case offset, pos, or len
   is null.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  offset - the location in the document model that a broken fragment would occupy >= 0. This would be the starting offset of the fragment returned - `int`
  pos - the position along the axis that the broken view would occupy >= 0. This may be useful for things like tab calculations - `float`
  len - specifies the distance along the axis where a potential break is desired >= 0 - `float`

  returns: the fragment of the view that represents the
    given span. - `javax.swing.text.View`"
  ([^javax.swing.text.html.InlineView this ^Integer axis ^Integer offset ^Float pos ^Float len]
    (-> this (.breakView axis offset pos len))))

