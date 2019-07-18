(ns javax.swing.text.html.ParagraphView
  "Displays the a paragraph, and uses css attributes for its
  configuration."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html ParagraphView]))

(defn ->paragraph-view
  "Constructor.

  Constructs a ParagraphView for the given element.

  elem - the element that this view is responsible for - `javax.swing.text.Element`"
  (^ParagraphView [^javax.swing.text.Element elem]
    (new ParagraphView elem)))

(defn set-parent
  "Establishes the parent view for this view.  This is
   guaranteed to be called before any other methods if the
   parent view is functioning properly.

   This is implemented
   to forward to the superclass as well as call the
   setPropertiesFromAttributes
   method to set the paragraph properties from the css
   attributes.  The call is made at this time to ensure
   the ability to resolve upward through the parents
   view attributes.

  parent - the new parent, or null if the view is being removed from a parent it was previously added to - `javax.swing.text.View`"
  ([^ParagraphView this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

(defn get-attributes
  "Fetches the attributes to use when rendering.  This is
   implemented to multiplex the attributes specified in the
   model with a StyleSheet.

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^ParagraphView this]
    (-> this (.getAttributes))))

(defn visible?
  "Indicates whether or not this view should be
   displayed.  If none of the children wish to be
   displayed and the only visible child is the
   break that ends the paragraph, the paragraph
   will not be considered visible.  Otherwise,
   it will be considered visible and return true.

  returns: true if the paragraph should be displayed - `boolean`"
  (^Boolean [^ParagraphView this]
    (-> this (.isVisible))))

(defn paint
  "Renders using the given rendering surface and area on that
   surface.  This is implemented to delegate to the superclass
   after stashing the base coordinate for tab calculations.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^ParagraphView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-preferred-span
  "Determines the preferred span for this view.  Returns
   0 if the view is not visible, otherwise it calls the
   superclass method to get the preferred span.
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into;
             typically the view is told to render into the span
             that is returned, although there is no guarantee;
             the parent may choose to resize or break the view - `float`"
  (^Float [^ParagraphView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.  Returns 0 if the view is not visible, otherwise
   it calls the superclass method to get the minimum span.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the minimum span the view can be rendered into - `float`"
  (^Float [^ParagraphView this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.  Returns 0 if the view is not visible, otherwise
   it calls the superclass method ot get the maximum span.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the maximum span the view can be rendered into - `float`"
  (^Float [^ParagraphView this ^Integer axis]
    (-> this (.getMaximumSpan axis))))

