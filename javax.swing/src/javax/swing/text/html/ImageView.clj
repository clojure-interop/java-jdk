(ns javax.swing.text.html.ImageView
  "View of an Image, intended to support the HTML <IMG> tag.
  Supports scaling via the HEIGHT and WIDTH attributes of the tag.
  If the image is unable to be loaded any text specified via the
  ALT attribute will be rendered.

  While this class has been part of swing for a while now, it is public
  as of 1.4."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html ImageView]))

(defn ->image-view
  "Constructor.

  Creates a new view that represents an IMG element.

  elem - the element to create a view for - `javax.swing.text.Element`"
  (^ImageView [^javax.swing.text.Element elem]
    (new ImageView elem)))

(defn get-image
  "Returns the image to render.

  returns: `java.awt.Image`"
  (^java.awt.Image [^ImageView this]
    (-> this (.getImage))))

(defn changed-update
  "Invoked when the Elements attributes have changed. Recreates the image.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^ImageView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

(defn set-parent
  "Establishes the parent view for this view.
   Seize this moment to cache the AWT Container I'm in.

  parent - the new parent, or null if the view is being removed from a parent - `javax.swing.text.View`"
  ([^ImageView this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either X_AXIS or Y_AXIS - `int`

  returns: the span the view would like to be rendered into;
             typically the view is told to render into the span
             that is returned, although there is no guarantee;
             the parent may choose to resize or break the view - `float`"
  (^Float [^ImageView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-loading-image-icon
  "Returns the icon to use while in the process of loading the image.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^ImageView this]
    (-> this (.getLoadingImageIcon))))

(defn get-tool-tip-text
  "For images the tooltip text comes from text specified with the
   ALT attribute. This is overriden to return
   getAltText.

  x - `float`
  y - `float`
  allocation - `java.awt.Shape`

  returns: `java.lang.String`"
  (^java.lang.String [^ImageView this ^Float x ^Float y ^java.awt.Shape allocation]
    (-> this (.getToolTipText x y allocation))))

(defn get-no-image-icon
  "Returns the icon to use if the image couldn't be found.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^ImageView this]
    (-> this (.getNoImageIcon))))

(defn paint
  "Paints the View.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^ImageView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  This is implemented to give the alignment to the
   bottom of the icon along the y axis, and the default
   along the x axis.

  axis - may be either X_AXIS or Y_AXIS - `int`

  returns: the desired alignment; this should be a value
     between 0.0 and 1.0 where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin; an alignment of 0.5 would be the
     center of the view - `float`"
  (^Float [^ImageView this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn set-loads-synchronously
  "Sets how the image is loaded. If newValue is true,
   the image we be loaded when first asked for, otherwise it will
   be loaded asynchronously. The default is to not load synchronously,
   that is to load the image asynchronously.

  new-value - `boolean`"
  ([^ImageView this ^Boolean new-value]
    (-> this (.setLoadsSynchronously new-value))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view if it has any layout duties.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([^ImageView this ^Float width ^Float height]
    (-> this (.setSize width height))))

(defn get-image-url
  "Return a URL for the image source,
   or null if it could not be determined.

  returns: `java.net.URL`"
  (^java.net.URL [^ImageView this]
    (-> this (.getImageURL))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - the X coordinate - `float`
  y - the Y coordinate - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - `javax.swing.text.Position$Bias[]`

  returns: the location within the model that best represents the
    given point of view - `int`"
  (^Integer [^ImageView this ^Float x ^Float y ^java.awt.Shape a bias]
    (-> this (.viewToModel x y a bias))))

(defn get-loads-synchronously?
  "Returns true if the image should be loaded when first asked for.

  returns: `boolean`"
  (^Boolean [^ImageView this]
    (-> this (.getLoadsSynchronously))))

(defn get-attributes
  "Fetches the attributes to use when rendering.  This is
   implemented to multiplex the attributes specified in the
   model with a StyleSheet.

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^ImageView this]
    (-> this (.getAttributes))))

(defn get-alt-text
  "Returns the text to display if the image can't be loaded. This is
   obtained from the Elements attribute set with the attribute name
   HTML.Attribute.ALT.

  returns: `java.lang.String`"
  (^java.lang.String [^ImageView this]
    (-> this (.getAltText))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position$Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^ImageView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position$Bias b]
    (-> this (.modelToView pos a b))))

