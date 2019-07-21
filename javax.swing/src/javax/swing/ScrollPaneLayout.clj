(ns javax.swing.ScrollPaneLayout
  "The layout manager used by JScrollPane.
  JScrollPaneLayout is
  responsible for nine components: a viewport, two scrollbars,
  a row header, a column header, and four \"corner\" components.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ScrollPaneLayout]))

(defn ->scroll-pane-layout
  "Constructor."
  (^ScrollPaneLayout []
    (new ScrollPaneLayout )))

(defn get-viewport-border-bounds
  "Deprecated. As of JDK version Swing1.1
      replaced by JScrollPane.getViewportBorderBounds().

  scrollpane - `javax.swing.JScrollPane`

  returns: the size and position of the viewport border - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^ScrollPaneLayout this ^javax.swing.JScrollPane scrollpane]
    (-> this (.getViewportBorderBounds scrollpane))))

(defn get-vertical-scroll-bar-policy
  "Returns the vertical scrollbar-display policy.

  returns: an integer giving the display policy - `int`"
  (^Integer [^ScrollPaneLayout this]
    (-> this (.getVerticalScrollBarPolicy))))

(defn preferred-layout-size
  "The preferred size of a ScrollPane is the size of the insets,
   plus the preferred size of the viewport, plus the preferred size of
   the visible headers, plus the preferred size of the scrollbars
   that will appear given the current view and the current
   scrollbar displayPolicies.
   Note that the rowHeader is calculated as part of the preferred width
   and the colHeader is calculated as part of the preferred size.

  parent - the Container that will be laid out - `java.awt.Container`

  returns: a Dimension object specifying the preferred size of the
           viewport and any scrollbars - `java.awt.Dimension`"
  (^java.awt.Dimension [^ScrollPaneLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn get-row-header
  "Returns the JViewport object that is the row header.

  returns: the JViewport object that is the row header - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^ScrollPaneLayout this]
    (-> this (.getRowHeader))))

(defn sync-with-scroll-pane
  "This method is invoked after the ScrollPaneLayout is set as the
   LayoutManager of a JScrollPane.
   It initializes all of the internal fields that
   are ordinarily set by addLayoutComponent.  For example:


   ScrollPaneLayout mySPLayout = new ScrollPanelLayout() {
       public void layoutContainer(Container p) {
           super.layoutContainer(p);
           // do some extra work here ...
       }
   };
   scrollpane.setLayout(mySPLayout):

  sp - `javax.swing.JScrollPane`"
  ([^ScrollPaneLayout this ^javax.swing.JScrollPane sp]
    (-> this (.syncWithScrollPane sp))))

(defn set-horizontal-scroll-bar-policy
  "Sets the horizontal scrollbar-display policy.
   The options are:
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS

   Note: Applications should use the JScrollPane version
   of this method.  It only exists for backwards compatibility
   with the Swing 1.0.2 (and earlier) versions of this class.

  x - an int giving the display policy - `int`

  throws: java.lang.IllegalArgumentException - if x is not a valid horizontal scrollbar policy, as listed above"
  ([^ScrollPaneLayout this ^Integer x]
    (-> this (.setHorizontalScrollBarPolicy x))))

(defn set-vertical-scroll-bar-policy
  "Sets the vertical scrollbar-display policy. The options
   are:

   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
   ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER
   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS

   Note: Applications should use the JScrollPane version
   of this method.  It only exists for backwards compatibility
   with the Swing 1.0.2 (and earlier) versions of this class.

  x - an integer giving the display policy - `int`

  throws: java.lang.IllegalArgumentException - if x is an invalid vertical scroll bar policy, as listed above"
  ([^ScrollPaneLayout this ^Integer x]
    (-> this (.setVerticalScrollBarPolicy x))))

(defn minimum-layout-size
  "The minimum size of a ScrollPane is the size of the insets
   plus minimum size of the viewport, plus the scrollpane's
   viewportBorder insets, plus the minimum size
   of the visible headers, plus the minimum size of the
   scrollbars whose displayPolicy isn't NEVER.

  parent - the Container that will be laid out - `java.awt.Container`

  returns: a Dimension object specifying the minimum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^ScrollPaneLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn get-viewport
  "Returns the JViewport object that displays the
   scrollable contents.

  returns: the JViewport object that displays the scrollable contents - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^ScrollPaneLayout this]
    (-> this (.getViewport))))

(defn get-horizontal-scroll-bar-policy
  "Returns the horizontal scrollbar-display policy.

  returns: an integer giving the display policy - `int`"
  (^Integer [^ScrollPaneLayout this]
    (-> this (.getHorizontalScrollBarPolicy))))

(defn get-column-header
  "Returns the JViewport object that is the column header.

  returns: the JViewport object that is the column header - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^ScrollPaneLayout this]
    (-> this (.getColumnHeader))))

(defn add-layout-component
  "Adds the specified component to the layout. The layout is
   identified using one of:

   ScrollPaneConstants.VIEWPORT
   ScrollPaneConstants.VERTICAL_SCROLLBAR
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR
   ScrollPaneConstants.ROW_HEADER
   ScrollPaneConstants.COLUMN_HEADER
   ScrollPaneConstants.LOWER_LEFT_CORNER
   ScrollPaneConstants.LOWER_RIGHT_CORNER
   ScrollPaneConstants.UPPER_LEFT_CORNER
   ScrollPaneConstants.UPPER_RIGHT_CORNER

  s - the component identifier - `java.lang.String`
  c - the the component to be added - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if s is an invalid key"
  ([^ScrollPaneLayout this ^java.lang.String s ^java.awt.Component c]
    (-> this (.addLayoutComponent s c))))

(defn remove-layout-component
  "Removes the specified component from the layout.

  c - the component to remove - `java.awt.Component`"
  ([^ScrollPaneLayout this ^java.awt.Component c]
    (-> this (.removeLayoutComponent c))))

(defn get-vertical-scroll-bar
  "Returns the JScrollBar object that handles vertical scrolling.

  returns: the JScrollBar object that handles vertical scrolling - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^ScrollPaneLayout this]
    (-> this (.getVerticalScrollBar))))

(defn layout-container
  "Lays out the scrollpane. The positioning of components depends on
   the following constraints:

    The row header, if present and visible, gets its preferred
   width and the viewport's height.

    The column header, if present and visible, gets its preferred
   height and the viewport's width.

    If a vertical scrollbar is needed, i.e. if the viewport's extent
   height is smaller than its view height or if the displayPolicy
   is ALWAYS, it's treated like the row header with respect to its
   dimensions and is made visible.

    If a horizontal scrollbar is needed, it is treated like the
   column header (see the paragraph above regarding the vertical scrollbar).

    If the scrollpane has a non-null
   viewportBorder, then space is allocated for that.

    The viewport gets the space available after accounting for
   the previous constraints.

    The corner components, if provided, are aligned with the
   ends of the scrollbars and headers. If there is a vertical
   scrollbar, the right corners appear; if there is a horizontal
   scrollbar, the lower corners appear; a row header gets left
   corners, and a column header gets upper corners.

  parent - the Container to lay out - `java.awt.Container`"
  ([^ScrollPaneLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

(defn get-horizontal-scroll-bar
  "Returns the JScrollBar object that handles horizontal scrolling.

  returns: the JScrollBar object that handles horizontal scrolling - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^ScrollPaneLayout this]
    (-> this (.getHorizontalScrollBar))))

(defn get-corner
  "Returns the Component at the specified corner.

  key - the String specifying the corner - `java.lang.String`

  returns: the Component at the specified corner, as defined in
           ScrollPaneConstants; if key is not one of the
            four corners, null is returned - `java.awt.Component`"
  (^java.awt.Component [^ScrollPaneLayout this ^java.lang.String key]
    (-> this (.getCorner key))))

