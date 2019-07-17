(ns javax.swing.JWindow
  "A JWindow is a container that can be displayed anywhere on the
  user's desktop. It does not have the title bar, window-management buttons,
  or other trimmings associated with a JFrame, but it is still a
  `first-class citizen` of the user's desktop, and can exist anywhere
  on it.

  The JWindow component contains a JRootPane
  as its only child.  The contentPane should be the parent
  of any children of the JWindow.
  As a convenience, the add, remove, and setLayout
  methods of this class are overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to a window as follows:


        window.add(child);
  And the child will be added to the contentPane.
  The contentPane will always be non-null.
  Attempting to set it to null will cause the JWindow
  to throw an exception. The default contentPane will have a
  BorderLayout manager set on it.
  Refer to RootPaneContainer
  for details on adding, removing and setting the LayoutManager
  of a JWindow.

  Please see the JRootPane documentation for a complete description of
  the contentPane, glassPane, and
  layeredPane components.

  In a multi-screen environment, you can create a JWindow
  on a different screen device.  See Window for more
  information.

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
  (:import [javax.swing JWindow]))

(defn ->j-window
  "Constructor.

  Creates a window with the specified owner window and
   GraphicsConfiguration of a screen device. If
   owner is null, the shared owner will be used
   and this window will not be focusable.

   This constructor sets the component's locale property to the value
   returned by JComponent.getDefaultLocale.

  owner - the window from which the window is displayed - `java.awt.Window`
  gc - the GraphicsConfiguration that is used to construct the new window with; if gc is null, the system default GraphicsConfiguration is assumed, unless owner is also null, in which case the GraphicsConfiguration from the shared owner frame will be used. - `java.awt.GraphicsConfiguration`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.awt.Window owner ^java.awt.GraphicsConfiguration gc]
    (new JWindow owner gc))
  ([^java.awt.GraphicsConfiguration gc]
    (new JWindow gc))
  ([]
    (new JWindow )))

(defn set-layout
  "Sets the LayoutManager.
   Overridden to conditionally forward the call to the
   contentPane.
   Refer to RootPaneContainer for
   more information.

  manager - the LayoutManager - `java.awt.LayoutManager`"
  ([^javax.swing.JWindow this ^java.awt.LayoutManager manager]
    (-> this (.setLayout manager))))

(defn set-layered-pane
  "Sets the layeredPane property.
   This method is called by the constructor.

  layered-pane - the new layeredPane object - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^javax.swing.JWindow this ^javax.swing.JLayeredPane layered-pane]
    (-> this (.setLayeredPane layered-pane))))

(defn get-content-pane
  "Returns the Container which is the contentPane
   for this window.

  returns: the contentPane property - `java.awt.Container`"
  (^java.awt.Container [^javax.swing.JWindow this]
    (-> this (.getContentPane))))

(defn get-graphics
  "Creates a graphics context for this component. This method will
   return null if this component is currently not
   displayable.

  returns: a graphics context for this component, or null
               if it has none - `java.awt.Graphics`"
  (^java.awt.Graphics [^javax.swing.JWindow this]
    (-> this (.getGraphics))))

(defn update
  "Calls paint(g).  This method was overridden to
   prevent an unnecessary call to clear the background.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^javax.swing.JWindow this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn set-transfer-handler
  "Sets the transferHandler property, which is a mechanism to
   support transfer of data into this component. Use null
   if the component does not support data transfer operations.

   If the system property suppressSwingDropSupport is false
   (the default) and the current drop target on this component is either
   null or not a user-set drop target, this method will change the
   drop target as follows: If newHandler is null it will
   clear the drop target. If not null it will install a new
   DropTarget.

   Note: When used with JWindow, TransferHandler only
   provides data import capability, as the data export related methods
   are currently typed to JComponent.

   Please see

   How to Use Drag and Drop and Data Transfer, a section in
   The Java Tutorial, for more information.

  new-handler - the new TransferHandler - `javax.swing.TransferHandler`"
  ([^javax.swing.JWindow this ^javax.swing.TransferHandler new-handler]
    (-> this (.setTransferHandler new-handler))))

(defn remove
  "Removes the specified component from the container. If
   comp is not the rootPane, this will forward
   the call to the contentPane. This will do nothing if
   comp is not a child of the JWindow or
   contentPane.

  comp - the component to be removed - `java.awt.Component`

  throws: java.lang.NullPointerException - if comp is null"
  ([^javax.swing.JWindow this ^java.awt.Component comp]
    (-> this (.remove comp))))

(defn repaint
  "Repaints the specified rectangle of this component within
   time milliseconds.  Refer to RepaintManager
   for details on how the repaint is handled.

  time - maximum time in milliseconds before update - `long`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  width - the width - `int`
  height - the height - `int`"
  ([^javax.swing.JWindow this ^Long time ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint time x y width height))))

(defn get-glass-pane
  "Returns the glassPane Component for this window.

  returns: the glassPane property - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JWindow this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JWindow.
   For JWindows, the AccessibleContext takes the form of an
   AccessibleJWindow.
   A new AccessibleJWindow instance is created if necessary.

  returns: an AccessibleJWindow that serves as the
           AccessibleContext of this JWindow - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JWindow this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets the glassPane property.
   This method is called by the constructor.

  glass-pane - the glassPane object for this window - `java.awt.Component`"
  ([^javax.swing.JWindow this ^java.awt.Component glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn get-transfer-handler
  "Gets the transferHandler property.

  returns: the value of the transferHandler property - `javax.swing.TransferHandler`"
  (^javax.swing.TransferHandler [^javax.swing.JWindow this]
    (-> this (.getTransferHandler))))

(defn get-root-pane
  "Returns the rootPane object for this window.

  returns: the rootPane property for this window - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^javax.swing.JWindow this]
    (-> this (.getRootPane))))

(defn set-content-pane
  "Sets the contentPane property for this window.
   This method is called by the constructor.

  content-pane - the new contentPane - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^javax.swing.JWindow this ^java.awt.Container content-pane]
    (-> this (.setContentPane content-pane))))

(defn get-layered-pane
  "Returns the layeredPane object for this window.

  returns: the layeredPane property - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^javax.swing.JWindow this]
    (-> this (.getLayeredPane))))

