(ns javax.swing.plaf.synth.SynthPainter
  "SynthPainter is used for painting portions of
  JComponents. At a minimum each JComponent
  has two paint methods: one for the border and one for the background. Some
  JComponents have more than one Region, and as
  a consequence more paint methods.

  Instances of SynthPainter are obtained from the
  SynthStyle.getPainter(javax.swing.plaf.synth.SynthContext) method.

  You typically supply a SynthPainter by way of Synth's
  file format. The following
  example registers a painter for all JButtons that will
  render the image myImage.png:


   <style id=\"buttonStyle\">
     <imagePainter path=\"myImage.png\" sourceInsets=\"2 2 2 2\"
                   paintCenter=\"true\" stretch=\"true\"/>
     <insets top=\"2\" bottom=\"2\" left=\"2\" right=\"2\"/>
   </style>
   <bind style=\"buttonStyle\" type=\"REGION\" key=\"button\"/>

  SynthPainter is abstract in so far as it does no painting,
  all the methods
  are empty. While none of these methods are typed to throw an exception,
  subclasses can assume that valid arguments are passed in, and if not
  they can throw a NullPointerException or
  IllegalArgumentException in response to invalid arguments."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthPainter]))

(defn ->synth-painter
  "Constructor."
  (^SynthPainter []
    (new SynthPainter )))

(defn paint-file-chooser-border
  "Paints the border of a file chooser.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintFileChooserBorder context g x y w h))))

(defn paint-root-pane-background
  "Paints the background of a root pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRootPaneBackground context g x y w h))))

(defn paint-tool-tip-border
  "Paints the border of a tool tip.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolTipBorder context g x y w h))))

(defn paint-popup-menu-background
  "Paints the background of a popup menu.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPopupMenuBackground context g x y w h))))

(defn paint-tree-cell-focus
  "Paints the focus indicator for a cell in a tree when it has focus.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTreeCellFocus context g x y w h))))

(defn paint-tool-bar-content-border
  "Paints the border of the content area of a tool bar. This implementation
   invokes the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarContentBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarContentBorder context g x y w h))))

(defn paint-slider-background
  "Paints the background of a slider. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSliderBackground context g x y w h))))

(defn paint-desktop-pane-border
  "Paints the background of a desktop pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintDesktopPaneBorder context g x y w h))))

(defn paint-tabbed-pane-content-background
  "Paints the background of the area that contains the content of the
   selected tab of a tabbed pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneContentBackground context g x y w h))))

(defn paint-scroll-bar-track-background
  "Paints the background of the track of a scrollbar. The track contains
   the thumb. This implementation invokes the method of the same name without
   the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarTrackBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollBarTrackBackground context g x y w h))))

(defn paint-scroll-bar-border
  "Paints the border of a scrollbar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollBarBorder context g x y w h))))

(defn paint-toggle-button-border
  "Paints the border of a toggle button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToggleButtonBorder context g x y w h))))

(defn paint-tool-bar-background
  "Paints the background of a tool bar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarBackground context g x y w h))))

(defn paint-internal-frame-border
  "Paints the border of an internal frame.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintInternalFrameBorder context g x y w h))))

(defn paint-arrow-button-foreground
  "Paints the foreground of an arrow button. This method is responsible
   for drawing a graphical representation of a direction, typically
   an arrow. Arrow buttons are created by
   some components, such as JScrollBar

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  direction - One of SwingConstants.NORTH, SwingConstants.SOUTH SwingConstants.EAST or SwingConstants.WEST - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer direction]
    (-> this (.paintArrowButtonForeground context g x y w h direction))))

(defn paint-internal-frame-title-pane-background
  "Paints the background of an internal frame title pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintInternalFrameTitlePaneBackground context g x y w h))))

(defn paint-check-box-menu-item-background
  "Paints the background of a check box menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintCheckBoxMenuItemBackground context g x y w h))))

(defn paint-split-pane-divider-background
  "Paints the background of the divider of a split pane. This implementation
   invokes the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSplitPane.HORIZONTAL_SPLIT or JSplitPane.VERTICAL_SPLIT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSplitPaneDividerBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSplitPaneDividerBackground context g x y w h))))

(defn paint-separator-foreground
  "Paints the foreground of a separator.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSeparator.HORIZONTAL or JSeparator.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSeparatorForeground context g x y w h orientation))))

(defn paint-file-chooser-background
  "Paints the background of a file chooser.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintFileChooserBackground context g x y w h))))

(defn paint-spinner-border
  "Paints the border of a spinner.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSpinnerBorder context g x y w h))))

(defn paint-table-background
  "Paints the background of a table.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTableBackground context g x y w h))))

(defn paint-split-pane-divider-foreground
  "Paints the foreground of the divider of a split pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSplitPane.HORIZONTAL_SPLIT or JSplitPane.VERTICAL_SPLIT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSplitPaneDividerForeground context g x y w h orientation))))

(defn paint-tool-tip-background
  "Paints the background of a tool tip.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolTipBackground context g x y w h))))

(defn paint-spinner-background
  "Paints the background of a spinner.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSpinnerBackground context g x y w h))))

(defn paint-split-pane-drag-divider
  "Paints the divider, when the user is dragging the divider, of a
   split pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSplitPane.HORIZONTAL_SPLIT or JSplitPane.VERTICAL_SPLIT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSplitPaneDragDivider context g x y w h orientation))))

(defn paint-editor-pane-border
  "Paints the border of an editor pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintEditorPaneBorder context g x y w h))))

(defn paint-tree-cell-border
  "Paints the border of the row containing a cell in a tree.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTreeCellBorder context g x y w h))))

(defn paint-menu-bar-border
  "Paints the border of a menu bar.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuBarBorder context g x y w h))))

(defn paint-label-border
  "Paints the border of a label.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintLabelBorder context g x y w h))))

(defn paint-panel-background
  "Paints the background of a panel.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPanelBackground context g x y w h))))

(defn paint-desktop-icon-border
  "Paints the border of a desktop icon.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintDesktopIconBorder context g x y w h))))

(defn paint-combo-box-background
  "Paints the background of a combo box.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintComboBoxBackground context g x y w h))))

(defn paint-tabbed-pane-tab-area-border
  "Paints the border of the area behind the tabs of a tabbed pane. This
   implementation invokes the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JTabbedPane.TOP, JTabbedPane.LEFT, JTabbedPane.BOTTOM, or JTabbedPane.RIGHT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintTabbedPaneTabAreaBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneTabAreaBorder context g x y w h))))

(defn paint-scroll-bar-thumb-background
  "Paints the background of the thumb of a scrollbar. The thumb provides
   a graphical indication as to how much of the Component is visible in a
   JScrollPane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarThumbBackground context g x y w h orientation))))

(defn paint-internal-frame-background
  "Paints the background of an internal frame.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintInternalFrameBackground context g x y w h))))

(defn paint-label-background
  "Paints the background of a label.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintLabelBackground context g x y w h))))

(defn paint-slider-thumb-background
  "Paints the background of the thumb of a slider.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderThumbBackground context g x y w h orientation))))

(defn paint-editor-pane-background
  "Paints the background of an editor pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintEditorPaneBackground context g x y w h))))

(defn paint-scroll-bar-background
  "Paints the background of a scrollbar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollBarBackground context g x y w h))))

(defn paint-split-pane-border
  "Paints the border of a split pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSplitPaneBorder context g x y w h))))

(defn paint-popup-menu-border
  "Paints the border of a popup menu.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPopupMenuBorder context g x y w h))))

(defn paint-progress-bar-border
  "Paints the border of a progress bar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - one of JProgressBar.HORIZONTAL or JProgressBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintProgressBarBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintProgressBarBorder context g x y w h))))

(defn paint-slider-track-border
  "Paints the border of the track of a slider. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderTrackBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSliderTrackBorder context g x y w h))))

(defn paint-split-pane-background
  "Paints the background of a split pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSplitPaneBackground context g x y w h))))

(defn paint-internal-frame-title-pane-border
  "Paints the border of an internal frame title pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintInternalFrameTitlePaneBorder context g x y w h))))

(defn paint-button-background
  "Paints the background of a button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintButtonBackground context g x y w h))))

(defn paint-formatted-text-field-border
  "Paints the border of a formatted text field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintFormattedTextFieldBorder context g x y w h))))

(defn paint-slider-border
  "Paints the border of a slider. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSliderBorder context g x y w h))))

(defn paint-tabbed-pane-tab-background
  "Paints the background of a tab of a tabbed pane. This implementation
   invokes the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  tab-index - Index of tab being painted. - `int`
  orientation - One of JTabbedPane.TOP, JTabbedPane.LEFT, JTabbedPane.BOTTOM, or JTabbedPane.RIGHT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer tab-index ^Integer orientation]
    (-> this (.paintTabbedPaneTabBackground context g x y w h tab-index orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer tab-index]
    (-> this (.paintTabbedPaneTabBackground context g x y w h tab-index))))

(defn paint-scroll-pane-background
  "Paints the background of a scroll pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollPaneBackground context g x y w h))))

(defn paint-table-header-background
  "Paints the background of the header of a table.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTableHeaderBackground context g x y w h))))

(defn paint-tree-background
  "Paints the background of a tree.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTreeBackground context g x y w h))))

(defn paint-color-chooser-background
  "Paints the background of a color chooser.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintColorChooserBackground context g x y w h))))

(defn paint-radio-button-background
  "Paints the background of a radio button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRadioButtonBackground context g x y w h))))

(defn paint-menu-background
  "Paints the background of a menu.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuBackground context g x y w h))))

(defn paint-panel-border
  "Paints the border of a panel.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPanelBorder context g x y w h))))

(defn paint-scroll-bar-thumb-border
  "Paints the border of the thumb of a scrollbar. The thumb provides
   a graphical indication as to how much of the Component is visible in a
   JScrollPane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarThumbBorder context g x y w h orientation))))

(defn paint-menu-bar-background
  "Paints the background of a menu bar.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuBarBackground context g x y w h))))

(defn paint-desktop-icon-background
  "Paints the background of a desktop icon.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintDesktopIconBackground context g x y w h))))

(defn paint-radio-button-menu-item-border
  "Paints the border of a radio button menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRadioButtonMenuItemBorder context g x y w h))))

(defn paint-option-pane-background
  "Paints the background of an option pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintOptionPaneBackground context g x y w h))))

(defn paint-tabbed-pane-tab-border
  "Paints the border of a tab of a tabbed pane. This implementation invokes
   the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  tab-index - Index of tab being painted. - `int`
  orientation - One of JTabbedPane.TOP, JTabbedPane.LEFT, JTabbedPane.BOTTOM, or JTabbedPane.RIGHT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer tab-index ^Integer orientation]
    (-> this (.paintTabbedPaneTabBorder context g x y w h tab-index orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer tab-index]
    (-> this (.paintTabbedPaneTabBorder context g x y w h tab-index))))

(defn paint-slider-thumb-border
  "Paints the border of the thumb of a slider.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderThumbBorder context g x y w h orientation))))

(defn paint-arrow-button-background
  "Paints the background of an arrow button. Arrow buttons are created by
   some components, such as JScrollBar.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintArrowButtonBackground context g x y w h))))

(defn paint-text-field-border
  "Paints the border of a text field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextFieldBorder context g x y w h))))

(defn paint-tabbed-pane-border
  "Paints the border of a tabbed pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneBorder context g x y w h))))

(defn paint-table-border
  "Paints the border of a table.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTableBorder context g x y w h))))

(defn paint-option-pane-border
  "Paints the border of an option pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintOptionPaneBorder context g x y w h))))

(defn paint-tool-bar-drag-window-background
  "Paints the background of the window containing the tool bar when it
   has been detached from its primary frame. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarDragWindowBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarDragWindowBackground context g x y w h))))

(defn paint-password-field-border
  "Paints the border of a password field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPasswordFieldBorder context g x y w h))))

(defn paint-text-area-background
  "Paints the background of a text area.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextAreaBackground context g x y w h))))

(defn paint-check-box-menu-item-border
  "Paints the border of a check box menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintCheckBoxMenuItemBorder context g x y w h))))

(defn paint-desktop-pane-background
  "Paints the background of a desktop pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintDesktopPaneBackground context g x y w h))))

(defn paint-tabbed-pane-content-border
  "Paints the border of the area that contains the content of the
   selected tab of a tabbed pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneContentBorder context g x y w h))))

(defn paint-separator-background
  "Paints the background of a separator. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSeparator.HORIZONTAL or JSeparator.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSeparatorBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSeparatorBackground context g x y w h))))

(defn paint-text-pane-background
  "Paints the background of a text pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextPaneBackground context g x y w h))))

(defn paint-slider-track-background
  "Paints the background of the track of a slider. This implementation invokes
   the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSlider.HORIZONTAL or JSlider.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSliderTrackBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSliderTrackBackground context g x y w h))))

(defn paint-formatted-text-field-background
  "Paints the background of a formatted text field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintFormattedTextFieldBackground context g x y w h))))

(defn paint-text-pane-border
  "Paints the border of a text pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextPaneBorder context g x y w h))))

(defn paint-separator-border
  "Paints the border of a separator. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JSeparator.HORIZONTAL or JSeparator.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintSeparatorBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintSeparatorBorder context g x y w h))))

(defn paint-arrow-button-border
  "Paints the border of an arrow button. Arrow buttons are created by
   some components, such as JScrollBar.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintArrowButtonBorder context g x y w h))))

(defn paint-menu-border
  "Paints the border of a menu.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuBorder context g x y w h))))

(defn paint-root-pane-border
  "Paints the border of a root pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRootPaneBorder context g x y w h))))

(defn paint-viewport-border
  "Paints the border of a viewport.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintViewportBorder context g x y w h))))

(defn paint-text-field-background
  "Paints the background of a text field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextFieldBackground context g x y w h))))

(defn paint-list-background
  "Paints the background of a list.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintListBackground context g x y w h))))

(defn paint-menu-item-background
  "Paints the background of a menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuItemBackground context g x y w h))))

(defn paint-combo-box-border
  "Paints the border of a combo box.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintComboBoxBorder context g x y w h))))

(defn paint-menu-item-border
  "Paints the border of a menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintMenuItemBorder context g x y w h))))

(defn paint-toggle-button-background
  "Paints the background of a toggle button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToggleButtonBackground context g x y w h))))

(defn paint-radio-button-border
  "Paints the border of a radio button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRadioButtonBorder context g x y w h))))

(defn paint-tree-border
  "Paints the border of a tree.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTreeBorder context g x y w h))))

(defn paint-text-area-border
  "Paints the border of a text area.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTextAreaBorder context g x y w h))))

(defn paint-progress-bar-foreground
  "Paints the foreground of a progress bar. is responsible for
   providing an indication of the progress of the progress bar.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - one of JProgressBar.HORIZONTAL or JProgressBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintProgressBarForeground context g x y w h orientation))))

(defn paint-tool-bar-drag-window-border
  "Paints the border of the window containing the tool bar when it
   has been detached from it's primary frame. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarDragWindowBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarDragWindowBorder context g x y w h))))

(defn paint-color-chooser-border
  "Paints the border of a color chooser.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintColorChooserBorder context g x y w h))))

(defn paint-viewport-background
  "Paints the background of the viewport.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintViewportBackground context g x y w h))))

(defn paint-scroll-bar-track-border
  "Paints the border of the track of a scrollbar. The track contains
   the thumb. This implementation invokes the method of the same name without
   the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - Orientation of the JScrollBar, one of JScrollBar.HORIZONTAL or JScrollBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintScrollBarTrackBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollBarTrackBorder context g x y w h))))

(defn paint-table-header-border
  "Paints the border of the header of a table.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTableHeaderBorder context g x y w h))))

(defn paint-password-field-background
  "Paints the background of a password field.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintPasswordFieldBackground context g x y w h))))

(defn paint-check-box-border
  "Paints the border of a check box.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintCheckBoxBorder context g x y w h))))

(defn paint-tool-bar-border
  "Paints the border of a tool bar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarBorder context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarBorder context g x y w h))))

(defn paint-tool-bar-content-background
  "Paints the background of the tool bar's content area. This implementation
   invokes the method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JToolBar.HORIZONTAL or JToolBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintToolBarContentBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintToolBarContentBackground context g x y w h))))

(defn paint-check-box-background
  "Paints the background of a check box.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintCheckBoxBackground context g x y w h))))

(defn paint-tree-cell-background
  "Paints the background of the row containing a cell in a tree.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTreeCellBackground context g x y w h))))

(defn paint-list-border
  "Paints the border of a list.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintListBorder context g x y w h))))

(defn paint-tabbed-pane-background
  "Paints the background of a tabbed pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneBackground context g x y w h))))

(defn paint-progress-bar-background
  "Paints the background of a progress bar. This implementation invokes the
   method of the same name without the orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - one of JProgressBar.HORIZONTAL or JProgressBar.VERTICAL - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintProgressBarBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintProgressBarBackground context g x y w h))))

(defn paint-tabbed-pane-tab-area-background
  "Paints the background of the area behind the tabs of a tabbed pane.
   This implementation invokes the method of the same name without the
   orientation.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`
  orientation - One of JTabbedPane.TOP, JTabbedPane.LEFT, JTabbedPane.BOTTOM, or JTabbedPane.RIGHT - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h ^Integer orientation]
    (-> this (.paintTabbedPaneTabAreaBackground context g x y w h orientation)))
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintTabbedPaneTabAreaBackground context g x y w h))))

(defn paint-button-border
  "Paints the border of a button.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintButtonBorder context g x y w h))))

(defn paint-scroll-pane-border
  "Paints the border of a scroll pane.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintScrollPaneBorder context g x y w h))))

(defn paint-radio-button-menu-item-background
  "Paints the background of a radio button menu item.

  context - SynthContext identifying the JComponent and Region to paint to - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint to - `java.awt.Graphics`
  x - X coordinate of the area to paint to - `int`
  y - Y coordinate of the area to paint to - `int`
  w - Width of the area to paint to - `int`
  h - Height of the area to paint to - `int`"
  ([^SynthPainter this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintRadioButtonMenuItemBackground context g x y w h))))

