(ns javax.swing.JScrollPane
  "Provides a scrollable view of a lightweight component.
  A JScrollPane manages a viewport, optional
  vertical and horizontal scroll bars, and optional row and
  column heading viewports.
  You can find task-oriented documentation of JScrollPane in
   How to Use Scroll Panes,
  a section in The Java Tutorial.  Note that
  JScrollPane does not support heavyweight components.








  The JViewport provides a window,
  or `viewport` onto a data
  source -- for example, a text file. That data source is the
  `scrollable client` (aka data model) displayed by the
  JViewport view.
  A JScrollPane basically consists of JScrollBars,
  a JViewport, and the wiring between them,
  as shown in the diagram at right.

  In addition to the scroll bars and viewport,
  a JScrollPane can have a
  column header and a row header. Each of these is a
  JViewport object that
  you specify with setRowHeaderView,
  and setColumnHeaderView.
  The column header viewport automatically scrolls left and right, tracking
  the left-right scrolling of the main viewport.
  (It never scrolls vertically, however.)
  The row header acts in a similar fashion.

  Where two scroll bars meet, the row header meets the column header,
  or a scroll bar meets one of the headers, both components stop short
  of the corner, leaving a rectangular space which is, by default, empty.
  These spaces can potentially exist in any number of the four corners.
  In the previous diagram, the top right space is present and identified
  by the label `corner component`.

  Any number of these empty spaces can be replaced by using the
  setCorner method to add a component to a particular corner.
  (Note: The same component cannot be added to multiple corners.)
  This is useful if there's
  some extra decoration or function you'd like to add to the scroll pane.
  The size of each corner component is entirely determined by the size of the
  headers and/or scroll bars that surround it.

  A corner component will only be visible if there is an empty space in that
  corner for it to exist in. For example, consider a component set into the
  top right corner of a scroll pane with a column header. If the scroll pane's
  vertical scrollbar is not present, perhaps because the view component hasn't
  grown large enough to require it, then the corner component will not be
  shown (since there is no empty space in that corner created by the meeting
  of the header and vertical scroll bar). Forcing the scroll bar to always be
  shown, using
  setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS),
  will ensure that the space for the corner component always exists.

  To add a border around the main viewport,
  you can use setViewportBorder.
  (Of course, you can also add a border around the whole scroll pane using
  setBorder.)

  A common operation to want to do is to set the background color that will
  be used if the main viewport view is smaller than the viewport, or is
  not opaque. This can be accomplished by setting the background color
  of the viewport, via scrollPane.getViewport().setBackground().
  The reason for setting the color of the viewport and not the scrollpane
  is that by default JViewport is opaque
  which, among other things, means it will completely fill
  in its background using its background color.  Therefore when
  JScrollPane draws its background the viewport will
  usually draw over it.

  By default JScrollPane uses ScrollPaneLayout
  to handle the layout of its child Components. ScrollPaneLayout
  determines the size to make the viewport view in one of two ways:

    If the view implements Scrollable
        a combination of getPreferredScrollableViewportSize,
        getScrollableTracksViewportWidth and
        getScrollableTracksViewportHeightis used, otherwise
    getPreferredSize is used.


  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JScrollPane]))

(defn ->j-scroll-pane
  "Constructor.

  Creates a JScrollPane that displays the view
   component in a viewport
   whose view position can be controlled with a pair of scrollbars.
   The scrollbar policies specify when the scrollbars are displayed,
   For example, if vsbPolicy is
   VERTICAL_SCROLLBAR_AS_NEEDED
   then the vertical scrollbar only appears if the view doesn't fit
   vertically. The available policy settings are listed at
   setVerticalScrollBarPolicy(int) and
   setHorizontalScrollBarPolicy(int).

  view - the component to display in the scrollpanes viewport - `java.awt.Component`
  vsb-policy - an integer that specifies the vertical scrollbar policy - `int`
  hsb-policy - an integer that specifies the horizontal scrollbar policy - `int`"
  ([^java.awt.Component view ^Integer vsb-policy ^Integer hsb-policy]
    (new JScrollPane view vsb-policy hsb-policy))
  ([^Integer vsb-policy ^Integer hsb-policy]
    (new JScrollPane vsb-policy hsb-policy))
  ([^java.awt.Component view]
    (new JScrollPane view))
  ([]
    (new JScrollPane )))

(defn get-viewport-border-bounds
  "Returns the bounds of the viewport's border.

  returns: a Rectangle object specifying the viewport border - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^javax.swing.JScrollPane this]
    (-> this (.getViewportBorderBounds))))

(defn get-vertical-scroll-bar-policy
  "Returns the vertical scroll bar policy value.

  returns: the verticalScrollBarPolicy property - `int`"
  (^Integer [^javax.swing.JScrollPane this]
    (-> this (.getVerticalScrollBarPolicy))))

(defn set-layout
  "Sets the layout manager for this JScrollPane.
   This method overrides setLayout in
   java.awt.Container to ensure that only
   LayoutManagers which
   are subclasses of ScrollPaneLayout can be used in a
   JScrollPane. If layout is non-null, this
   will invoke syncWithScrollPane on it.

  layout - the specified layout manager - `java.awt.LayoutManager`

  throws: java.lang.ClassCastException - if layout is not a ScrollPaneLayout"
  ([^javax.swing.JScrollPane this ^java.awt.LayoutManager layout]
    (-> this (.setLayout layout))))

(defn set-viewport
  "Removes the old viewport (if there is one); forces the
   viewPosition of the new viewport to be in the x,+y quadrant;
   syncs up the row and column headers (if there are any) with the
   new viewport; and finally syncs the scrollbars and
   headers with the new viewport.

   Most applications will find it more convenient to use
   setViewportView
   to add a viewport and a view to the scrollpane.

  viewport - the new viewport to be used; if viewport is null, the old viewport is still removed and the new viewport is set to null - `javax.swing.JViewport`"
  ([^javax.swing.JScrollPane this ^javax.swing.JViewport viewport]
    (-> this (.setViewport viewport))))

(defn set-viewport-border
  "Adds a border around the viewport.  Note that the border isn't
   set on the viewport directly, JViewport doesn't support
   the JComponent border property.
   Similarly setting the JScrollPanes
   viewport doesn't affect the viewportBorder property.

   The default value of this property is computed by the look
   and feel implementation.

  viewport-border - the border to be added - `javax.swing.border.Border`"
  ([^javax.swing.JScrollPane this ^javax.swing.border.Border viewport-border]
    (-> this (.setViewportBorder viewport-border))))

(defn get-row-header
  "Returns the row header.

  returns: the rowHeader property - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^javax.swing.JScrollPane this]
    (-> this (.getRowHeader))))

(defn get-ui-class-id
  "Returns the suffix used to construct the name of the L&F class used to
   render this component.

  returns: the string `ScrollPaneUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JScrollPane this]
    (-> this (.getUIClassID))))

(defn validate-root?
  "Overridden to return true so that any calls to revalidate
   on any descendants of this JScrollPane will cause the
   entire tree beginning with this JScrollPane to be
   validated.

  returns: true - `boolean`"
  (^Boolean [^javax.swing.JScrollPane this]
    (-> this (.isValidateRoot))))

(defn set-vertical-scroll-bar
  "Adds the scrollbar that controls the viewports vertical view position
   to the scrollpane.  This is usually unnecessary,
   as JScrollPane creates vertical and
   horizontal scrollbars by default.

  vertical-scroll-bar - the new vertical scrollbar to be added - `javax.swing.JScrollBar`"
  ([^javax.swing.JScrollPane this ^javax.swing.JScrollBar vertical-scroll-bar]
    (-> this (.setVerticalScrollBar vertical-scroll-bar))))

(defn create-horizontal-scroll-bar
  "Returns a JScrollPane.ScrollBar by default.
   Subclasses may override this method to force ScrollPaneUI
   implementations to use a JScrollBar subclass.
   Used by ScrollPaneUI implementations to
   create the horizontal scrollbar.

  returns: a JScrollBar with a horizontal orientation - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^javax.swing.JScrollPane this]
    (-> this (.createHorizontalScrollBar))))

(defn set-row-header
  "Removes the old rowHeader, if it exists; if the new rowHeader
   isn't null, syncs the y coordinate of its
   viewPosition with
   the viewport (if there is one) and then adds it to the scroll pane.

   Most applications will find it more convenient to use
   setRowHeaderView
   to add a row header component and its viewport to the scroll pane.

  row-header - the new row header to be used; if null the old row header is still removed and the new rowHeader is set to null - `javax.swing.JViewport`"
  ([^javax.swing.JScrollPane this ^javax.swing.JViewport row-header]
    (-> this (.setRowHeader row-header))))

(defn create-vertical-scroll-bar
  "Returns a JScrollPane.ScrollBar by default.  Subclasses
   may override this method to force ScrollPaneUI
   implementations to use a JScrollBar subclass.
   Used by ScrollPaneUI implementations to create the
   vertical scrollbar.

  returns: a JScrollBar with a vertical orientation - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^javax.swing.JScrollPane this]
    (-> this (.createVerticalScrollBar))))

(defn set-ui
  "Sets the ScrollPaneUI object that provides the
   look and feel (L&F) for this component.

  ui - the ScrollPaneUI L&F object - `javax.swing.plaf.ScrollPaneUI`"
  ([^javax.swing.JScrollPane this ^javax.swing.plaf.ScrollPaneUI ui]
    (-> this (.setUI ui))))

(defn set-horizontal-scroll-bar-policy
  "Determines when the horizontal scrollbar appears in the scrollpane.
   The options are:
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS

  policy - one of the three values listed above - `int`

  throws: java.lang.IllegalArgumentException - if policy is not one of the legal values shown above"
  ([^javax.swing.JScrollPane this ^Integer policy]
    (-> this (.setHorizontalScrollBarPolicy policy))))

(defn get-ui
  "Returns the look and feel (L&F) object that renders this component.

  returns: the ScrollPaneUI object that renders this
                            component - `javax.swing.plaf.ScrollPaneUI`"
  (^javax.swing.plaf.ScrollPaneUI [^javax.swing.JScrollPane this]
    (-> this (.getUI))))

(defn set-vertical-scroll-bar-policy
  "Determines when the vertical scrollbar appears in the scrollpane.
   Legal values are:

   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
   ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER
   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS

  policy - one of the three values listed above - `int`

  throws: java.lang.IllegalArgumentException - if policy is not one of the legal values shown above"
  ([^javax.swing.JScrollPane this ^Integer policy]
    (-> this (.setVerticalScrollBarPolicy policy))))

(defn set-wheel-scrolling-enabled
  "Enables/disables scrolling in response to movement of the mouse wheel.
   Wheel scrolling is enabled by default.

  handle-wheel - true if scrolling should be done automatically for a MouseWheelEvent, false otherwise. - `boolean`"
  ([^javax.swing.JScrollPane this ^Boolean handle-wheel]
    (-> this (.setWheelScrollingEnabled handle-wheel))))

(defn set-row-header-view
  "Creates a row-header viewport if necessary, sets
   its view and then adds the row-header viewport
   to the scrollpane.  For example:


   JScrollPane scrollpane = new JScrollPane();
   scrollpane.setViewportView(myBigComponentToScroll);
   scrollpane.setRowHeaderView(myBigComponentsRowHeader);

  view - the component to display as the row header - `java.awt.Component`"
  ([^javax.swing.JScrollPane this ^java.awt.Component view]
    (-> this (.setRowHeaderView view))))

(defn set-corner
  "Adds a child that will appear in one of the scroll panes
   corners, if there's room.   For example with both scrollbars
   showing (on the right and bottom edges of the scrollpane)
   the lower left corner component will be shown in the space
   between ends of the two scrollbars. Legal values for
   the key are:

   ScrollPaneConstants.LOWER_LEFT_CORNER
   ScrollPaneConstants.LOWER_RIGHT_CORNER
   ScrollPaneConstants.UPPER_LEFT_CORNER
   ScrollPaneConstants.UPPER_RIGHT_CORNER
   ScrollPaneConstants.LOWER_LEADING_CORNER
   ScrollPaneConstants.LOWER_TRAILING_CORNER
   ScrollPaneConstants.UPPER_LEADING_CORNER
   ScrollPaneConstants.UPPER_TRAILING_CORNER


   Although `corner` doesn't match any beans property
   signature, PropertyChange events are generated with the
   property name set to the corner key.

  key - identifies which corner the component will appear in - `java.lang.String`
  corner - one of the following components: lowerLeft lowerRight upperLeft upperRight - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if corner key is invalid"
  ([^javax.swing.JScrollPane this ^java.lang.String key ^java.awt.Component corner]
    (-> this (.setCorner key corner))))

(defn set-viewport-view
  "Creates a viewport if necessary and then sets its view.  Applications
   that don't provide the view directly to the JScrollPane
   constructor
   should use this method to specify the scrollable child that's going
   to be displayed in the scrollpane. For example:


   JScrollPane scrollpane = new JScrollPane();
   scrollpane.setViewportView(myBigComponentToScroll);
   Applications should not add children directly to the scrollpane.

  view - the component to add to the viewport - `java.awt.Component`"
  ([^javax.swing.JScrollPane this ^java.awt.Component view]
    (-> this (.setViewportView view))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JScrollPane.
   For scroll panes, the AccessibleContext takes the form of an
   AccessibleJScrollPane.
   A new AccessibleJScrollPane instance is created if necessary.

  returns: an AccessibleJScrollPane that serves as the
           AccessibleContext of this JScrollPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JScrollPane this]
    (-> this (.getAccessibleContext))))

(defn get-viewport
  "Returns the current JViewport.

  returns: the viewport property - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^javax.swing.JScrollPane this]
    (-> this (.getViewport))))

(defn get-horizontal-scroll-bar-policy
  "Returns the horizontal scroll bar policy value.

  returns: the horizontalScrollBarPolicy property - `int`"
  (^Integer [^javax.swing.JScrollPane this]
    (-> this (.getHorizontalScrollBarPolicy))))

(defn get-column-header
  "Returns the column header.

  returns: the columnHeader property - `javax.swing.JViewport`"
  (^javax.swing.JViewport [^javax.swing.JScrollPane this]
    (-> this (.getColumnHeader))))

(defn set-column-header-view
  "Creates a column-header viewport if necessary, sets
   its view, and then adds the column-header viewport
   to the scrollpane.  For example:


   JScrollPane scrollpane = new JScrollPane();
   scrollpane.setViewportView(myBigComponentToScroll);
   scrollpane.setColumnHeaderView(myBigComponentsColumnHeader);

  view - the component to display as the column header - `java.awt.Component`"
  ([^javax.swing.JScrollPane this ^java.awt.Component view]
    (-> this (.setColumnHeaderView view))))

(defn set-component-orientation
  "Sets the orientation for the vertical and horizontal
   scrollbars as determined by the
   ComponentOrientation argument.

  co - one of the following values: java.awt.ComponentOrientation.LEFT_TO_RIGHT java.awt.ComponentOrientation.RIGHT_TO_LEFT java.awt.ComponentOrientation.UNKNOWN - `java.awt.ComponentOrientation`"
  ([^javax.swing.JScrollPane this ^java.awt.ComponentOrientation co]
    (-> this (.setComponentOrientation co))))

(defn get-vertical-scroll-bar
  "Returns the vertical scroll bar that controls the viewports
   vertical view position.

  returns: the verticalScrollBar property - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^javax.swing.JScrollPane this]
    (-> this (.getVerticalScrollBar))))

(defn wheel-scrolling-enabled?
  "Indicates whether or not scrolling will take place in response to the
   mouse wheel.  Wheel scrolling is enabled by default.

  returns: `boolean`"
  (^Boolean [^javax.swing.JScrollPane this]
    (-> this (.isWheelScrollingEnabled))))

(defn update-ui
  "Replaces the current ScrollPaneUI object with a version
   from the current default look and feel.
   To be called when the default look and feel changes."
  ([^javax.swing.JScrollPane this]
    (-> this (.updateUI))))

(defn get-viewport-border
  "Returns the Border object that surrounds the viewport.

  returns: the viewportBorder property - `javax.swing.border.Border`"
  (^javax.swing.border.Border [^javax.swing.JScrollPane this]
    (-> this (.getViewportBorder))))

(defn set-column-header
  "Removes the old columnHeader, if it exists; if the new columnHeader
   isn't null, syncs the x coordinate of its viewPosition
   with the viewport (if there is one) and then adds it to the scroll pane.

   Most applications will find it more convenient to use
   setColumnHeaderView
   to add a column header component and its viewport to the scroll pane.

  column-header - `javax.swing.JViewport`"
  ([^javax.swing.JScrollPane this ^javax.swing.JViewport column-header]
    (-> this (.setColumnHeader column-header))))

(defn set-horizontal-scroll-bar
  "Adds the scrollbar that controls the viewport's horizontal view
   position to the scrollpane.
   This is usually unnecessary, as JScrollPane creates
   horizontal and vertical scrollbars by default.

  horizontal-scroll-bar - the horizontal scrollbar to be added - `javax.swing.JScrollBar`"
  ([^javax.swing.JScrollPane this ^javax.swing.JScrollBar horizontal-scroll-bar]
    (-> this (.setHorizontalScrollBar horizontal-scroll-bar))))

(defn get-horizontal-scroll-bar
  "Returns the horizontal scroll bar that controls the viewport's
   horizontal view position.

  returns: the horizontalScrollBar property - `javax.swing.JScrollBar`"
  (^javax.swing.JScrollBar [^javax.swing.JScrollPane this]
    (-> this (.getHorizontalScrollBar))))

(defn get-corner
  "Returns the component at the specified corner. The
   key value specifying the corner is one of:

   ScrollPaneConstants.LOWER_LEFT_CORNER
   ScrollPaneConstants.LOWER_RIGHT_CORNER
   ScrollPaneConstants.UPPER_LEFT_CORNER
   ScrollPaneConstants.UPPER_RIGHT_CORNER
   ScrollPaneConstants.LOWER_LEADING_CORNER
   ScrollPaneConstants.LOWER_TRAILING_CORNER
   ScrollPaneConstants.UPPER_LEADING_CORNER
   ScrollPaneConstants.UPPER_TRAILING_CORNER

  key - one of the values as shown above - `java.lang.String`

  returns: the corner component (which may be null)
           identified by the given key, or null
           if the key is invalid - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JScrollPane this ^java.lang.String key]
    (-> this (.getCorner key))))

