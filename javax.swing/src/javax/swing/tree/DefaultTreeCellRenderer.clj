(ns javax.swing.tree.DefaultTreeCellRenderer
  "Displays an entry in a tree.
  DefaultTreeCellRenderer is not opaque and
  unless you subclass paint you should not change this.
  See How to Use Trees
  in The Java Tutorial
  for examples of customizing node display using this class.

  The set of icons and colors used by DefaultTreeCellRenderer
  can be configured using the various setter methods. The value for
  each property is initialized from the defaults table. When the
  look and feel changes (updateUI is invoked), any properties
  that have a value of type UIResource are refreshed from the
  defaults table. The following table lists the mapping between
  DefaultTreeCellRenderer property and defaults table key:


      Property:
      Key:
    `leafIcon``Tree.leafIcon`
    `closedIcon``Tree.closedIcon`
    `openIcon``Tree.openIcon`
    `textSelectionColor``Tree.selectionForeground`
    `textNonSelectionColor``Tree.textForeground`
    `backgroundSelectionColor``Tree.selectionBackground`
    `backgroundNonSelectionColor``Tree.textBackground`
    `borderSelectionColor``Tree.selectionBorderColor`


  Implementation Note:
  This class overrides
  invalidate,
  validate,
  revalidate,
  repaint,
  and
  firePropertyChange
  solely to improve performance.
  If not overridden, these frequently called methods would execute code paths
  that are unnecessary for the default tree cell renderer.
  If you write your own renderer,
  take care to weigh the benefits and
  drawbacks of overriding these methods.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree DefaultTreeCellRenderer]))

(defn ->default-tree-cell-renderer
  "Constructor.

  Creates a DefaultTreeCellRenderer. Icons and text color are
   determined from the UIManager."
  (^DefaultTreeCellRenderer []
    (new DefaultTreeCellRenderer )))

(defn get-text-selection-color
  "Returns the color the text is drawn with when the node is selected.

  returns: `java.awt.Color`"
  (^java.awt.Color [^DefaultTreeCellRenderer this]
    (-> this (.getTextSelectionColor))))

(defn fire-property-change
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property (as a byte) - `byte`
  new-value - the new value of the property (as a byte) - `byte`"
  ([^DefaultTreeCellRenderer this ^java.lang.String property-name ^Byte old-value ^Byte new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn set-text-selection-color
  "Sets the color the text is drawn with when the node is selected.

  new-color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color new-color]
    (-> this (.setTextSelectionColor new-color))))

(defn validate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^DefaultTreeCellRenderer this]
    (-> this (.validate))))

(defn set-text-non-selection-color
  "Sets the color the text is drawn with when the node isn't selected.

  new-color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color new-color]
    (-> this (.setTextNonSelectionColor new-color))))

(defn get-default-open-icon
  "Returns the default icon, for the current laf, that is used to
   represent non-leaf nodes that are expanded.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getDefaultOpenIcon))))

(defn set-leaf-icon
  "Sets the icon used to represent leaf nodes.

  new-icon - `javax.swing.Icon`"
  ([^DefaultTreeCellRenderer this ^javax.swing.Icon new-icon]
    (-> this (.setLeafIcon new-icon))))

(defn set-open-icon
  "Sets the icon used to represent non-leaf nodes that are expanded.

  new-icon - `javax.swing.Icon`"
  ([^DefaultTreeCellRenderer this ^javax.swing.Icon new-icon]
    (-> this (.setOpenIcon new-icon))))

(defn get-closed-icon
  "Returns the icon used to represent non-leaf nodes that are not
   expanded.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getClosedIcon))))

(defn get-default-closed-icon
  "Returns the default icon, for the current laf, that is used to
   represent non-leaf nodes that are not expanded.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getDefaultClosedIcon))))

(defn set-background
  "Subclassed to map ColorUIResources to null. If
   color is null, or a ColorUIResource, this
   has the effect of letting the background color of the JTree show
   through. On the other hand, if color is non-null, and not
   a ColorUIResource, the background becomes
   color.

  color - the desired background Color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color color]
    (-> this (.setBackground color))))

(defn set-border-selection-color
  "Sets the color to use for the border.

  new-color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color new-color]
    (-> this (.setBorderSelectionColor new-color))))

(defn get-background-selection-color
  "Returns the color to use for the background if node is selected.

  returns: `java.awt.Color`"
  (^java.awt.Color [^DefaultTreeCellRenderer this]
    (-> this (.getBackgroundSelectionColor))))

(defn repaint
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  tm - this parameter is not used - `long`
  x - the x value of the dirty region - `int`
  y - the y value of the dirty region - `int`
  width - the width of the dirty region - `int`
  height - the height of the dirty region - `int`"
  ([^DefaultTreeCellRenderer this ^Long tm ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint tm x y width height)))
  ([^DefaultTreeCellRenderer this ^java.awt.Rectangle r]
    (-> this (.repaint r)))
  ([^DefaultTreeCellRenderer this]
    (-> this (.repaint))))

(defn set-font
  "Subclassed to map FontUIResources to null. If
   font is null, or a FontUIResource, this
   has the effect of letting the font of the JTree show
   through. On the other hand, if font is non-null, and not
   a FontUIResource, the font becomes font.

  font - the desired Font for this component - `java.awt.Font`"
  ([^DefaultTreeCellRenderer this ^java.awt.Font font]
    (-> this (.setFont font))))

(defn invalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^DefaultTreeCellRenderer this]
    (-> this (.invalidate))))

(defn get-tree-cell-renderer-component
  "Configures the renderer based on the passed in components.
   The value is set from messaging the tree with
   convertValueToText, which ultimately invokes
   toString on value.
   The foreground color is set based on the selection and the icon
   is set based on the leaf and expanded
   parameters.

  tree - `javax.swing.JTree`
  value - `java.lang.Object`
  sel - `boolean`
  expanded - `boolean`
  leaf - `boolean`
  row - `int`
  has-focus - `boolean`

  returns: the Component that the renderer uses to draw the value - `java.awt.Component`"
  (^java.awt.Component [^DefaultTreeCellRenderer this ^javax.swing.JTree tree ^java.lang.Object value ^Boolean sel ^Boolean expanded ^Boolean leaf ^Integer row ^Boolean has-focus]
    (-> this (.getTreeCellRendererComponent tree value sel expanded leaf row has-focus))))

(defn paint
  "Paints the value.  The background is filled based on selected.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^DefaultTreeCellRenderer this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn set-background-selection-color
  "Sets the color to use for the background if node is selected.

  new-color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color new-color]
    (-> this (.setBackgroundSelectionColor new-color))))

(defn get-default-leaf-icon
  "Returns the default icon, for the current laf, that is used to
   represent leaf nodes.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getDefaultLeafIcon))))

(defn get-open-icon
  "Returns the icon used to represent non-leaf nodes that are expanded.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getOpenIcon))))

(defn get-font
  "Gets the font of this component.

  returns: this component's font; if a font has not been set
   for this component, the font of its parent is returned - `java.awt.Font`"
  (^java.awt.Font [^DefaultTreeCellRenderer this]
    (-> this (.getFont))))

(defn get-background-non-selection-color
  "Returns the background color to be used for non selected nodes.

  returns: `java.awt.Color`"
  (^java.awt.Color [^DefaultTreeCellRenderer this]
    (-> this (.getBackgroundNonSelectionColor))))

(defn set-closed-icon
  "Sets the icon used to represent non-leaf nodes that are not expanded.

  new-icon - `javax.swing.Icon`"
  ([^DefaultTreeCellRenderer this ^javax.swing.Icon new-icon]
    (-> this (.setClosedIcon new-icon))))

(defn get-border-selection-color
  "Returns the color the border is drawn.

  returns: `java.awt.Color`"
  (^java.awt.Color [^DefaultTreeCellRenderer this]
    (-> this (.getBorderSelectionColor))))

(defn revalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^DefaultTreeCellRenderer this]
    (-> this (.revalidate))))

(defn set-background-non-selection-color
  "Sets the background color to be used for non selected nodes.

  new-color - `java.awt.Color`"
  ([^DefaultTreeCellRenderer this ^java.awt.Color new-color]
    (-> this (.setBackgroundNonSelectionColor new-color))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^DefaultTreeCellRenderer this]
    (-> this (.updateUI))))

(defn get-preferred-size
  "Overrides JComponent.getPreferredSize to
   return slightly wider preferred size value.

  returns: the value of the preferredSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^DefaultTreeCellRenderer this]
    (-> this (.getPreferredSize))))

(defn get-text-non-selection-color
  "Returns the color the text is drawn with when the node isn't selected.

  returns: `java.awt.Color`"
  (^java.awt.Color [^DefaultTreeCellRenderer this]
    (-> this (.getTextNonSelectionColor))))

(defn get-leaf-icon
  "Returns the icon used to represent leaf nodes.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^DefaultTreeCellRenderer this]
    (-> this (.getLeafIcon))))

