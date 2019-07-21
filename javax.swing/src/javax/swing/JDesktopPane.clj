(ns javax.swing.JDesktopPane
  "A container used to create a multiple-document interface or a virtual desktop.
  You create JInternalFrame objects and add them to the
  JDesktopPane. JDesktopPane extends
  JLayeredPane to manage the potentially overlapping internal
  frames. It also maintains a reference to an instance of
  DesktopManager that is set by the UI
  class for the current look and feel (L&F).  Note that JDesktopPane
  does not support borders.

  This class is normally used as the parent of JInternalFrames
  to provide a pluggable DesktopManager object to the
  JInternalFrames. The installUI of the
  L&F specific implementation is responsible for setting the
  desktopManager variable appropriately.
  When the parent of a JInternalFrame is a JDesktopPane,
  it should delegate most of its behavior to the desktopManager
  (closing, resizing, etc).

  For further documentation and examples see
  How to Use Internal Frames,
  a section in The Java Tutorial.

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
  (:import [javax.swing JDesktopPane]))

(defn ->j-desktop-pane
  "Constructor.

  Creates a new JDesktopPane."
  (^JDesktopPane []
    (new JDesktopPane )))

(def *-live-drag-mode
  "Static Constant.

  Indicates that the entire contents of the item being dragged
   should appear inside the desktop pane.

  type: int"
  JDesktopPane/LIVE_DRAG_MODE)

(def *-outline-drag-mode
  "Static Constant.

  Indicates that an outline only of the item being dragged
   should appear inside the desktop pane.

  type: int"
  JDesktopPane/OUTLINE_DRAG_MODE)

(defn set-component-z-order
  "Moves the specified component to the specified z-order index in
   the container. The z-order determines the order that components
   are painted; the component with the highest z-order paints first
   and the component with the lowest z-order paints last.
   Where components overlap, the component with the lower
   z-order paints over the component with the higher z-order.

   If the component is a child of some other container, it is
   removed from that container before being added to this container.
   The important difference between this method and
   java.awt.Container.add(Component, int) is that this method
   doesn't call removeNotify on the component while
   removing it from its previous container unless necessary and when
   allowed by the underlying native windowing system. This way, if the
   component has the keyboard focus, it maintains the focus when
   moved to the new position.

   This property is guaranteed to apply only to lightweight
   non-Container components.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy.

   Note: Not all platforms support changing the z-order of
   heavyweight components from one container into another without
   the call to removeNotify. There is no way to detect
   whether a platform supports this, so developers shouldn't make
   any assumptions.

  comp - the component to be moved - `java.awt.Component`
  index - the position in the container's list to insert the component, where getComponentCount() appends to the end - `int`"
  ([^JDesktopPane this ^java.awt.Component comp ^Integer index]
    (-> this (.setComponentZOrder comp index))))

(defn get-drag-mode
  "Gets the current \"dragging style\" used by the desktop pane.

  returns: either Live_DRAG_MODE or
     OUTLINE_DRAG_MODE - `int`"
  (^Integer [^JDesktopPane this]
    (-> this (.getDragMode))))

(defn get-selected-frame
  "Returns the currently active JInternalFrame
   in this JDesktopPane, or null
   if no JInternalFrame is currently active.

  returns: the currently active JInternalFrame or
     null - `javax.swing.JInternalFrame`"
  (^javax.swing.JInternalFrame [^JDesktopPane this]
    (-> this (.getSelectedFrame))))

(defn get-all-frames-in-layer
  "Returns all JInternalFrames currently displayed in the
   specified layer of the desktop. Returns iconified frames as well
   expanded frames.

  layer - an int specifying the desktop layer - `int`

  returns: an array of JInternalFrame objects - `javax.swing.JInternalFrame[]`"
  ([^JDesktopPane this ^Integer layer]
    (-> this (.getAllFramesInLayer layer))))

(defn get-all-frames
  "Returns all JInternalFrames currently displayed in the
   desktop. Returns iconified frames as well as expanded frames.

  returns: an array of JInternalFrame objects - `javax.swing.JInternalFrame[]`"
  ([^JDesktopPane this]
    (-> this (.getAllFrames))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string \"DesktopPaneUI\" - `java.lang.String`"
  (^java.lang.String [^JDesktopPane this]
    (-> this (.getUIClassID))))

(defn select-frame
  "Selects the next JInternalFrame in this desktop pane.

  forward - a boolean indicating which direction to select in; true for forward, false for backward - `boolean`

  returns: the JInternalFrame that was selected or null
           if nothing was selected - `javax.swing.JInternalFrame`"
  (^javax.swing.JInternalFrame [^JDesktopPane this ^Boolean forward]
    (-> this (.selectFrame forward))))

(defn get-desktop-manager
  "Returns the DesktopManger that handles
   desktop-specific UI actions.

  returns: `javax.swing.DesktopManager`"
  (^javax.swing.DesktopManager [^JDesktopPane this]
    (-> this (.getDesktopManager))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the DesktopPaneUI L&F object - `javax.swing.plaf.DesktopPaneUI`"
  ([^JDesktopPane this ^javax.swing.plaf.DesktopPaneUI ui]
    (-> this (.setUI ui))))

(defn remove
  "Removes the specified component from this container.
   This method also notifies the layout manager to remove the
   component from this container's layout via the
   removeLayoutComponent method.

   This method changes layout-related information, and therefore,
   invalidates the component hierarchy. If the container has already been
   displayed, the hierarchy must be validated thereafter in order to
   reflect the changes.

  comp - the component to be removed - `java.awt.Component`"
  ([^JDesktopPane this ^java.awt.Component comp]
    (-> this (.remove comp))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the DesktopPaneUI object that
     renders this component - `javax.swing.plaf.DesktopPaneUI`"
  (^javax.swing.plaf.DesktopPaneUI [^JDesktopPane this]
    (-> this (.getUI))))

(defn set-desktop-manager
  "Sets the DesktopManger that will handle
   desktop-specific UI actions. This may be overridden by
   LookAndFeel.

  d - the DesktopManager to use - `javax.swing.DesktopManager`"
  ([^JDesktopPane this ^javax.swing.DesktopManager d]
    (-> this (.setDesktopManager d))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JDesktopPane. For desktop panes, the
   AccessibleContext takes the form of an
   AccessibleJDesktopPane.
   A new AccessibleJDesktopPane instance is created if necessary.

  returns: an AccessibleJDesktopPane that serves as the
           AccessibleContext of this JDesktopPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JDesktopPane this]
    (-> this (.getAccessibleContext))))

(defn set-selected-frame
  "Sets the currently active JInternalFrame
    in this JDesktopPane. This method is used to bridge
    the package gap between JDesktopPane and the platform implementation
    code and should not be called directly. To visually select the frame
    the client must call JInternalFrame.setSelected(true) to activate
    the frame.

  f - the internal frame that's currently selected - `javax.swing.JInternalFrame`"
  ([^JDesktopPane this ^javax.swing.JInternalFrame f]
    (-> this (.setSelectedFrame f))))

(defn remove-all
  "Removes all the components from this container."
  ([^JDesktopPane this]
    (-> this (.removeAll))))

(defn set-drag-mode
  "Sets the \"dragging style\" used by the desktop pane.
   You may want to change to one mode or another for
   performance or aesthetic reasons.

  drag-mode - the style of drag to use for items in the Desktop - `int`"
  ([^JDesktopPane this ^Integer drag-mode]
    (-> this (.setDragMode drag-mode))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^JDesktopPane this]
    (-> this (.updateUI))))

