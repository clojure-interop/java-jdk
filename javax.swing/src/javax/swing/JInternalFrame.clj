(ns javax.swing.JInternalFrame
  "A lightweight object that provides many of the features of
  a native frame, including dragging, closing, becoming an icon,
  resizing, title display, and support for a menu bar.
  For task-oriented documentation and examples of using internal frames,
  see How to Use Internal Frames,
  a section in The Java Tutorial.



  Generally,
  you add JInternalFrames to a JDesktopPane. The UI
  delegates the look-and-feel-specific actions to the
  DesktopManager
  object maintained by the JDesktopPane.

  The JInternalFrame content pane
  is where you add child components.
  As a convenience, the add, remove, and setLayout
  methods of this class are overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to an internal frame as follows:


        internalFrame.add(child);
  And the child will be added to the contentPane.
  The content pane is actually managed by an instance of
  JRootPane,
  which also manages a layout pane, glass pane, and
  optional menu bar for the internal frame. Please see the
  JRootPane
  documentation for a complete description of these components.
  Refer to RootPaneContainer
  for details on adding, removing and setting the LayoutManager
  of a JInternalFrame.

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
  (:import [javax.swing JInternalFrame]))

(defn ->j-internal-frame
  "Constructor.

  Creates a JInternalFrame with the specified title,
   resizability, closability, maximizability, and iconifiability.
   All JInternalFrame constructors use this one.

  title - the String to display in the title bar - `java.lang.String`
  resizable - if true, the internal frame can be resized - `boolean`
  closable - if true, the internal frame can be closed - `boolean`
  maximizable - if true, the internal frame can be maximized - `boolean`
  iconifiable - if true, the internal frame can be iconified - `boolean`"
  (^JInternalFrame [^java.lang.String title ^Boolean resizable ^Boolean closable ^Boolean maximizable ^Boolean iconifiable]
    (new JInternalFrame title resizable closable maximizable iconifiable))
  (^JInternalFrame [^java.lang.String title ^Boolean resizable ^Boolean closable ^Boolean maximizable]
    (new JInternalFrame title resizable closable maximizable))
  (^JInternalFrame [^java.lang.String title ^Boolean resizable ^Boolean closable]
    (new JInternalFrame title resizable closable))
  (^JInternalFrame [^java.lang.String title ^Boolean resizable]
    (new JInternalFrame title resizable))
  (^JInternalFrame [^java.lang.String title]
    (new JInternalFrame title))
  (^JInternalFrame []
    (new JInternalFrame )))

(def *-content-pane-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/CONTENT_PANE_PROPERTY)

(def *-menu-bar-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/MENU_BAR_PROPERTY)

(def *-title-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/TITLE_PROPERTY)

(def *-layered-pane-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/LAYERED_PANE_PROPERTY)

(def *-root-pane-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/ROOT_PANE_PROPERTY)

(def *-glass-pane-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/GLASS_PANE_PROPERTY)

(def *-frame-icon-property
  "Static Constant.

  Bound property name.

  type: java.lang.String"
  JInternalFrame/FRAME_ICON_PROPERTY)

(def *-is-selected-property
  "Static Constant.

  Constrained property name indicated that this frame has
   selected status.

  type: java.lang.String"
  JInternalFrame/IS_SELECTED_PROPERTY)

(def *-is-closed-property
  "Static Constant.

  Constrained property name indicating that the internal frame is closed.

  type: java.lang.String"
  JInternalFrame/IS_CLOSED_PROPERTY)

(def *-is-maximum-property
  "Static Constant.

  Constrained property name indicating that the internal frame is maximized.

  type: java.lang.String"
  JInternalFrame/IS_MAXIMUM_PROPERTY)

(def *-is-icon-property
  "Static Constant.

  Constrained property name indicating that the internal frame is iconified.

  type: java.lang.String"
  JInternalFrame/IS_ICON_PROPERTY)

(defn get-frame-icon
  "Returns the image displayed in the title bar of this internal frame (usually
   in the top-left corner).

  returns: the Icon displayed in the title bar - `javax.swing.Icon`"
  (^javax.swing.Icon [^JInternalFrame this]
    (-> this (.getFrameIcon))))

(defn set-layout
  "Ensures that, by default, the layout of this component cannot be set.
   Overridden to conditionally forward the call to the
   contentPane.
   Refer to RootPaneContainer for
   more information.

  manager - the LayoutManager - `java.awt.LayoutManager`"
  ([^JInternalFrame this ^java.awt.LayoutManager manager]
    (-> this (.setLayout manager))))

(defn set-normal-bounds
  "Sets the normal bounds for this internal frame, the bounds that
   this internal frame would be restored to from its maximized state.
   This method is intended for use only by desktop managers.

  r - the bounds that this internal frame should be restored to - `java.awt.Rectangle`"
  ([^JInternalFrame this ^java.awt.Rectangle r]
    (-> this (.setNormalBounds r))))

(defn set-layered-pane
  "Sets this JInternalFrame's
   layeredPane property.

  layered - the JLayeredPane for this internal frame - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([^JInternalFrame this ^javax.swing.JLayeredPane layered]
    (-> this (.setLayeredPane layered))))

(defn hide
  "Description copied from class: JComponent"
  ([^JInternalFrame this]
    (-> this (.hide))))

(defn set-desktop-icon
  "Sets the JDesktopIcon associated with this
   JInternalFrame.

  d - the JDesktopIcon to display on the desktop - `javax.swing.JInternalFrame$JDesktopIcon`"
  ([^JInternalFrame this ^javax.swing.JInternalFrame$JDesktopIcon d]
    (-> this (.setDesktopIcon d))))

(defn get-desktop-icon
  "Returns the JDesktopIcon used when this
   JInternalFrame is iconified.

  returns: the JDesktopIcon displayed on the desktop - `javax.swing.JInternalFrame$JDesktopIcon`"
  (^javax.swing.JInternalFrame$JDesktopIcon [^JInternalFrame this]
    (-> this (.getDesktopIcon))))

(defn maximizable?
  "Gets the value of the maximizable property.

  returns: the value of the maximizable property - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isMaximizable))))

(defn icon?
  "Returns whether the JInternalFrame is currently iconified.

  returns: true if this internal frame is iconified - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isIcon))))

(defn pack
  "Causes subcomponents of this JInternalFrame
   to be laid out at their preferred size.  Internal frames that are
   iconized or maximized are first restored and then packed.  If the
   internal frame is unable to be restored its state is not changed
   and will not be packed."
  ([^JInternalFrame this]
    (-> this (.pack))))

(defn set-icon
  "Iconifies or de-iconifies this internal frame,
   if the look and feel supports iconification.
   If the internal frame's state changes to iconified,
   this method fires an INTERNAL_FRAME_ICONIFIED event.
   If the state changes to de-iconified,
   an INTERNAL_FRAME_DEICONIFIED event is fired.

  b - a boolean, where true means to iconify this internal frame and false means to de-iconify it - `boolean`

  throws: java.beans.PropertyVetoException - when the attempt to set the property is vetoed by the JInternalFrame"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setIcon b))))

(defn iconifiable?
  "Gets the iconable property,
   which by default is false.

  returns: the value of the iconable property. - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isIconifiable))))

(defn get-most-recent-focus-owner
  "Returns the child component of this JInternalFrame
   that will receive the
   focus when this JInternalFrame is selected.
   If this JInternalFrame is
   currently selected, this method returns the same component as
   the getFocusOwner method.
   If this JInternalFrame is not selected,
   then the child component that most recently requested focus will be
   returned. If no child component has ever requested focus, then this
   JInternalFrame's initial focusable component is returned.
   If no such
   child exists, then this JInternalFrame's default component
   to focus is returned.

  returns: the child component that will receive focus when this
           JInternalFrame is selected - `java.awt.Component`"
  (^java.awt.Component [^JInternalFrame this]
    (-> this (.getMostRecentFocusOwner))))

(defn set-layer
  "Convenience method for setting the layer attribute of this component.

  layer - an Integer object specifying this frame's desktop layer - `java.lang.Integer`"
  ([^JInternalFrame this ^java.lang.Integer layer]
    (-> this (.setLayer layer))))

(defn closable?
  "Returns whether this JInternalFrame can be closed by
   some user action.

  returns: true if this internal frame can be closed - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isClosable))))

(defn do-default-close-action
  "Fires an
   INTERNAL_FRAME_CLOSING event
   and then performs the action specified by
   the internal frame's default close operation.
   This method is typically invoked by the
   look-and-feel-implemented action handler
   for the internal frame's close button."
  ([^JInternalFrame this]
    (-> this (.doDefaultCloseAction))))

(defn set-focus-cycle-root
  "Does nothing because JInternalFrames must always be roots of a focus
   traversal cycle.

  focus-cycle-root - this value is ignored - `boolean`"
  ([^JInternalFrame this ^Boolean focus-cycle-root]
    (-> this (.setFocusCycleRoot focus-cycle-root))))

(defn remove-internal-frame-listener
  "Removes the specified internal frame listener so that it no longer
   receives internal frame events from this internal frame.

  l - the internal frame listener - `javax.swing.event.InternalFrameListener`"
  ([^JInternalFrame this ^javax.swing.event.InternalFrameListener l]
    (-> this (.removeInternalFrameListener l))))

(defn set-default-close-operation
  "Sets the operation that will happen by default when
   the user initiates a `close` on this internal frame.
   The possible choices are:


   DO_NOTHING_ON_CLOSE
    Do nothing.
        This requires the program to handle the operation
        in the internalFrameClosing method
        of a registered InternalFrameListener object.
   HIDE_ON_CLOSE
    Automatically make the internal frame invisible.
   DISPOSE_ON_CLOSE
    Automatically dispose of the internal frame.


   The default value is DISPOSE_ON_CLOSE.
   Before performing the specified close operation,
   the internal frame fires
   an INTERNAL_FRAME_CLOSING event.

  operation - one of the following constants defined in javax.swing.WindowConstants (an interface implemented by JInternalFrame): DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE - `int`"
  ([^JInternalFrame this ^Integer operation]
    (-> this (.setDefaultCloseOperation operation))))

(defn set-closed
  "Closes this internal frame if the argument is true.
   Do not invoke this method with a false argument;
   the result of invoking setClosed(false)
   is unspecified.



   If the internal frame is already closed,
   this method does nothing and returns immediately.
   Otherwise,
   this method begins by firing
   an INTERNAL_FRAME_CLOSING event.
   Then this method sets the closed property to true
   unless a listener vetoes the property change.
   This method finishes by making the internal frame
   invisible and unselected,
   and then firing an INTERNAL_FRAME_CLOSED event.



   Note:
   To reuse an internal frame that has been closed,
   you must add it to a container
   (even if you never removed it from its previous container).
   Typically, this container will be the JDesktopPane
   that previously contained the internal frame.

  b - must be true - `boolean`

  throws: java.beans.PropertyVetoException - when the attempt to set the property is vetoed by the JInternalFrame"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setClosed b))))

(defn get-content-pane
  "Returns the content pane for this internal frame.

  returns: the content pane - `java.awt.Container`"
  (^java.awt.Container [^JInternalFrame this]
    (-> this (.getContentPane))))

(defn set-selected
  "Selects or deselects the internal frame
   if it's showing.
   A JInternalFrame normally draws its title bar
   differently if it is
   the selected frame, which indicates to the user that this
   internal frame has the focus.
   When this method changes the state of the internal frame
   from deselected to selected, it fires an
   InternalFrameEvent.INTERNAL_FRAME_ACTIVATED event.
   If the change is from selected to deselected,
   an InternalFrameEvent.INTERNAL_FRAME_DEACTIVATED event
   is fired.

  selected - a boolean, where true means this internal frame should become selected (currently active) and false means it should become deselected - `boolean`

  throws: java.beans.PropertyVetoException - when the attempt to set the property is vetoed by the JInternalFrame"
  ([^JInternalFrame this ^Boolean selected]
    (-> this (.setSelected selected))))

(defn dispose
  "Makes this internal frame
   invisible, unselected, and closed.
   If the frame is not already closed,
   this method fires an
   INTERNAL_FRAME_CLOSED event.
   The results of invoking this method are similar to
   setClosed(true),
   but dispose always succeeds in closing
   the internal frame and does not fire
   an INTERNAL_FRAME_CLOSING event."
  ([^JInternalFrame this]
    (-> this (.dispose))))

(defn move-to-front
  "Convenience method that moves this component to position 0 if its
   parent is a JLayeredPane."
  ([^JInternalFrame this]
    (-> this (.moveToFront))))

(defn get-focus-owner
  "If this JInternalFrame is active,
   returns the child that has focus.
   Otherwise, returns null.

  returns: the component with focus, or null if no children have focus - `java.awt.Component`"
  (^java.awt.Component [^JInternalFrame this]
    (-> this (.getFocusOwner))))

(defn set-frame-icon
  "Sets an image to be displayed in the titlebar of this internal frame (usually
   in the top-left corner).
   This image is not the desktopIcon object, which
   is the image displayed in the JDesktop when
   this internal frame is iconified.

   Passing null to this function is valid,
   but the look and feel
   can choose the
   appropriate behavior for that situation, such as displaying no icon
   or a default icon for the look and feel.

  icon - the Icon to display in the title bar - `javax.swing.Icon`"
  ([^JInternalFrame this ^javax.swing.Icon icon]
    (-> this (.setFrameIcon icon))))

(defn get-ui-class-id
  "Returns the name of the look-and-feel
   class that renders this component.

  returns: the string `InternalFrameUI` - `java.lang.String`"
  (^java.lang.String [^JInternalFrame this]
    (-> this (.getUIClassID))))

(defn get-j-menu-bar
  "Returns the current JMenuBar for this
   JInternalFrame, or null
   if no menu bar has been set.

  returns: the JMenuBar used by this internal frame - `javax.swing.JMenuBar`"
  (^javax.swing.JMenuBar [^JInternalFrame this]
    (-> this (.getJMenuBar))))

(defn get-layer
  "Convenience method for getting the layer attribute of this component.

  returns: an Integer object specifying this
            frame's desktop layer - `int`"
  (^Integer [^JInternalFrame this]
    (-> this (.getLayer))))

(defn get-internal-frame-listeners
  "Returns an array of all the InternalFrameListeners added
   to this JInternalFrame with
   addInternalFrameListener.

  returns: all of the InternalFrameListeners added or an empty
           array if no listeners have been added - `javax.swing.event.InternalFrameListener[]`"
  ([^JInternalFrame this]
    (-> this (.getInternalFrameListeners))))

(defn reshape
  "Moves and resizes this component.  Unlike other components,
   this implementation also forces re-layout, so that frame
   decorations such as the title bar are always redisplayed.

  x - an integer giving the component's new horizontal position measured in pixels from the left of its container - `int`
  y - an integer giving the component's new vertical position, measured in pixels from the bottom of its container - `int`
  width - an integer giving the component's new width in pixels - `int`
  height - an integer giving the component's new height in pixels - `int`"
  ([^JInternalFrame this ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.reshape x y width height))))

(defn set-menu-bar
  "Deprecated. As of Swing version 1.0.3
    replaced by setJMenuBar(JMenuBar m).

  m - the JMenuBar to use in this internal frame - `javax.swing.JMenuBar`"
  ([^JInternalFrame this ^javax.swing.JMenuBar m]
    (-> this (.setMenuBar m))))

(defn show
  "If the internal frame is not visible,
   brings the internal frame to the front,
   makes it visible,
   and attempts to select it.
   The first time the internal frame is made visible,
   this method also fires an INTERNAL_FRAME_OPENED event.
   This method does nothing if the internal frame is already visible.
   Invoking this method
   has the same result as invoking
   setVisible(true)."
  ([^JInternalFrame this]
    (-> this (.show))))

(defn closed?
  "Returns whether this JInternalFrame is currently closed.

  returns: true if this internal frame is closed, false otherwise - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isClosed))))

(defn set-ui
  "Sets the UI delegate for this JInternalFrame.

  ui - the UI delegate - `javax.swing.plaf.InternalFrameUI`"
  ([^JInternalFrame this ^javax.swing.plaf.InternalFrameUI ui]
    (-> this (.setUI ui))))

(defn set-maximum
  "Maximizes and restores this internal frame.  A maximized frame is resized to
   fully fit the JDesktopPane area associated with the
   JInternalFrame.
   A restored frame's size is set to the JInternalFrame's
   actual size.

  b - a boolean, where true maximizes this internal frame and false restores it - `boolean`

  throws: java.beans.PropertyVetoException - when the attempt to set the property is vetoed by the JInternalFrame"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setMaximum b))))

(defn resizable?
  "Returns whether the JInternalFrame can be resized
   by some user action.

  returns: true if this internal frame can be resized, false otherwise - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isResizable))))

(defn add-internal-frame-listener
  "Adds the specified listener to receive internal
   frame events from this internal frame.

  l - the internal frame listener - `javax.swing.event.InternalFrameListener`"
  ([^JInternalFrame this ^javax.swing.event.InternalFrameListener l]
    (-> this (.addInternalFrameListener l))))

(defn remove
  "Removes the specified component from the container. If
   comp is not a child of the JInternalFrame
   this will forward the call to the contentPane.

  comp - the component to be removed - `java.awt.Component`

  throws: java.lang.NullPointerException - if comp is null"
  ([^JInternalFrame this ^java.awt.Component comp]
    (-> this (.remove comp))))

(defn set-maximizable
  "Sets the maximizable property,
   which determines whether the JInternalFrame
   can be maximized by
   some user action.
   Some look and feels might not support maximizing internal frames;
   they will ignore this property.

  b - true to specify that this internal frame should be maximizable; false to specify that it should not be - `boolean`"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setMaximizable b))))

(defn get-ui
  "Returns the look-and-feel object that renders this component.

  returns: the InternalFrameUI object that renders
            this component - `javax.swing.plaf.InternalFrameUI`"
  (^javax.swing.plaf.InternalFrameUI [^JInternalFrame this]
    (-> this (.getUI))))

(defn to-back
  "Sends this internal frame to the back.
   Places this internal frame at the bottom of the stacking order
   and makes the corresponding adjustment to other visible
   internal frames."
  ([^JInternalFrame this]
    (-> this (.toBack))))

(defn get-glass-pane
  "Returns the glass pane for this internal frame.

  returns: the glass pane - `java.awt.Component`"
  (^java.awt.Component [^JInternalFrame this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JInternalFrame.
   For internal frames, the AccessibleContext
   takes the form of an
   AccessibleJInternalFrame object.
   A new AccessibleJInternalFrame instance is created if necessary.

  returns: an AccessibleJInternalFrame that serves as the
           AccessibleContext of this
           JInternalFrame - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JInternalFrame this]
    (-> this (.getAccessibleContext))))

(defn get-last-cursor
  "Returns the last Cursor that was set by the
   setCursor method that is not a resizable
   Cursor.

  returns: the last non-resizable Cursor - `java.awt.Cursor`"
  (^java.awt.Cursor [^JInternalFrame this]
    (-> this (.getLastCursor))))

(defn set-glass-pane
  "Sets this JInternalFrame's
   glassPane property.

  glass - the glass pane for this internal frame - `java.awt.Component`"
  ([^JInternalFrame this ^java.awt.Component glass]
    (-> this (.setGlassPane glass))))

(defn get-normal-bounds
  "If the JInternalFrame is not in maximized state, returns
   getBounds(); otherwise, returns the bounds that the
   JInternalFrame would be restored to.

  returns: a Rectangle containing the bounds of this
            frame when in the normal state - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JInternalFrame this]
    (-> this (.getNormalBounds))))

(defn set-closable
  "Sets whether this JInternalFrame can be closed by
   some user action.

  b - a boolean value, where true means this internal frame can be closed - `boolean`"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setClosable b))))

(defn get-focus-cycle-root-ancestor
  "Always returns null because JInternalFrames
   must always be roots of a focus
   traversal cycle.

  returns: null - `java.awt.Container`"
  (^java.awt.Container [^JInternalFrame this]
    (-> this (.getFocusCycleRootAncestor))))

(defn selected?
  "Returns whether the JInternalFrame is the
   currently `selected` or active frame.

  returns: true if this internal frame is currently selected (active) - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isSelected))))

(defn set-j-menu-bar
  "Sets the menuBar property for this JInternalFrame.

  m - the JMenuBar to use in this internal frame - `javax.swing.JMenuBar`"
  ([^JInternalFrame this ^javax.swing.JMenuBar m]
    (-> this (.setJMenuBar m))))

(defn get-menu-bar
  "Deprecated. As of Swing version 1.0.3,
   replaced by getJMenuBar().

  returns: the current menu bar, or null if none has been set - `javax.swing.JMenuBar`"
  (^javax.swing.JMenuBar [^JInternalFrame this]
    (-> this (.getMenuBar))))

(defn maximum?
  "Returns whether the JInternalFrame is currently maximized.

  returns: true if this internal frame is maximized, false otherwise - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isMaximum))))

(defn set-cursor
  "Sets the cursor image to the specified cursor.  This cursor
   image is displayed when the contains method for
   this component returns true for the current cursor location, and
   this Component is visible, displayable, and enabled. Setting the
   cursor of a Container causes that cursor to be displayed
   within all of the container's subcomponents, except for those
   that have a non-null cursor.

   The method may have no visual effect if the Java platform
   implementation and/or the native system do not support
   changing the mouse cursor shape.

  cursor - One of the constants defined by the Cursor class; if this parameter is null then this component will inherit the cursor of its parent - `java.awt.Cursor`"
  ([^JInternalFrame this ^java.awt.Cursor cursor]
    (-> this (.setCursor cursor))))

(defn move-to-back
  "Convenience method that moves this component to position -1 if its
   parent is a JLayeredPane."
  ([^JInternalFrame this]
    (-> this (.moveToBack))))

(defn to-front
  "Brings this internal frame to the front.
   Places this internal frame  at the top of the stacking order
   and makes the corresponding adjustment to other visible internal
   frames."
  ([^JInternalFrame this]
    (-> this (.toFront))))

(defn get-root-pane
  "Returns the rootPane object for this internal frame.

  returns: the rootPane property - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^JInternalFrame this]
    (-> this (.getRootPane))))

(defn set-iconifiable
  "Sets the iconable property,
   which must be true
   for the user to be able to
   make the JInternalFrame an icon.
   Some look and feels might not implement iconification;
   they will ignore this property.

  b - a boolean, where true means this internal frame can be iconified - `boolean`"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setIconifiable b))))

(defn set-content-pane
  "Sets this JInternalFrame's contentPane
   property.

  c - the content pane for this internal frame - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^JInternalFrame this ^java.awt.Container c]
    (-> this (.setContentPane c))))

(defn get-layered-pane
  "Returns the layered pane for this internal frame.

  returns: a JLayeredPane object - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^JInternalFrame this]
    (-> this (.getLayeredPane))))

(defn set-resizable
  "Sets whether the JInternalFrame can be resized by some
   user action.

  b - a boolean, where true means this internal frame can be resized - `boolean`"
  ([^JInternalFrame this ^Boolean b]
    (-> this (.setResizable b))))

(defn get-warning-string
  "Gets the warning string that is displayed with this internal frame.
   Since an internal frame is always secure (since it's fully
   contained within a window that might need a warning string)
   this method always returns null.

  returns: null - `java.lang.String`"
  (^java.lang.String [^JInternalFrame this]
    (-> this (.getWarningString))))

(defn focus-cycle-root?
  "Always returns true because all JInternalFrames must be
   roots of a focus traversal cycle.

  returns: true - `boolean`"
  (^Boolean [^JInternalFrame this]
    (-> this (.isFocusCycleRoot))))

(defn update-ui
  "Notification from the UIManager that the look and feel
   has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^JInternalFrame this]
    (-> this (.updateUI))))

(defn restore-subcomponent-focus
  "Requests the internal frame to restore focus to the
   last subcomponent that had focus. This is used by the UI when
   the user selected this internal frame --
   for example, by clicking on the title bar."
  ([^JInternalFrame this]
    (-> this (.restoreSubcomponentFocus))))

(defn get-desktop-pane
  "Convenience method that searches the ancestor hierarchy for a
   JDesktop instance. If JInternalFrame
   finds none, the desktopIcon tree is searched.

  returns: the JDesktopPane this internal frame belongs to,
           or null if none is found - `javax.swing.JDesktopPane`"
  (^javax.swing.JDesktopPane [^JInternalFrame this]
    (-> this (.getDesktopPane))))

(defn get-title
  "Returns the title of the JInternalFrame.

  returns: a String containing this internal frame's title - `java.lang.String`"
  (^java.lang.String [^JInternalFrame this]
    (-> this (.getTitle))))

(defn set-title
  "Sets the JInternalFrame title. title
   may have a null value.

  title - the String to display in the title bar - `java.lang.String`"
  ([^JInternalFrame this ^java.lang.String title]
    (-> this (.setTitle title))))

(defn get-default-close-operation
  "Returns the default operation that occurs when the user
   initiates a `close` on this internal frame.

  returns: the operation that will occur when the user closes the internal
           frame - `int`"
  (^Integer [^JInternalFrame this]
    (-> this (.getDefaultCloseOperation))))

