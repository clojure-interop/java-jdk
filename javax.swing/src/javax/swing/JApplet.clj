(ns javax.swing.JApplet
  "An extended version of java.applet.Applet that adds support for
  the JFC/Swing component architecture.
  You can find task-oriented documentation about using JApplet
  in The Java Tutorial,
  in the section
  How to Make Applets.

  The JApplet class is slightly incompatible with
  java.applet.Applet.  JApplet contains a
  JRootPane as its only child.  The contentPane
  should be the parent of any children of the JApplet.
  As a convenience, the add, remove, and setLayout
  methods of this class are overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to an applet as follows:


        applet.add(child);

  And the child will be added to the contentPane.
  The contentPane will always be non-null.
  Attempting to set it to null will cause the
  JApplet to throw an exception. The default
  contentPane will have a BorderLayout
  manager set on it.
  Refer to RootPaneContainer
  for details on adding, removing and setting the LayoutManager
  of a JApplet.

  Please see the JRootPane documentation for a
  complete description of the contentPane, glassPane,
  and layeredPane properties.

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
  (:import [javax.swing JApplet]))

(defn ->j-applet
  "Constructor.

  Creates a swing applet instance.

   This constructor sets the component's locale property to the value
   returned by JComponent.getDefaultLocale.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([]
    (new JApplet )))

(defn set-layout
  "Sets the LayoutManager.
   Overridden to conditionally forward the call to the
   contentPane.
   Refer to RootPaneContainer for
   more information.

  manager - the LayoutManager - `java.awt.LayoutManager`"
  ([this manager]
    (-> this (.setLayout manager))))

(defn set-layered-pane
  "Sets the layeredPane property.  This method is called by the constructor.

  layered-pane - the layeredPane object for this applet - `javax.swing.JLayeredPane`"
  ([this layered-pane]
    (-> this (.setLayeredPane layered-pane))))

(defn get-content-pane
  "Returns the contentPane object for this applet.

  returns: the value of the contentPane property. - `java.awt.Container`"
  ([this]
    (-> this (.getContentPane))))

(defn get-graphics
  "Creates a graphics context for this component. This method will
   return null if this component is currently not
   displayable.

  returns: a graphics context for this component, or null
               if it has none - `java.awt.Graphics`"
  ([this]
    (-> this (.getGraphics))))

(defn update
  "Just calls paint(g).  This method was overridden to
   prevent an unnecessary call to clear the background.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([this g]
    (-> this (.update g))))

(defn get-j-menu-bar
  "Returns the menubar set on this applet.

  returns: `javax.swing.JMenuBar`"
  ([this]
    (-> this (.getJMenuBar))))

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

   Note: When used with JApplet, TransferHandler only
   provides data import capability, as the data export related methods
   are currently typed to JComponent.

   Please see

   How to Use Drag and Drop and Data Transfer, a section in
   The Java Tutorial, for more information.

  new-handler - the new TransferHandler - `javax.swing.TransferHandler`"
  ([this new-handler]
    (-> this (.setTransferHandler new-handler))))

(defn remove
  "Removes the specified component from the container. If
   comp is not the rootPane, this will forward
   the call to the contentPane. This will do nothing if
   comp is not a child of the JFrame or
   contentPane.

  comp - the component to be removed - `java.awt.Component`

  throws: java.lang.NullPointerException - if comp is null"
  ([this comp]
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
  ([this time x y width height]
    (-> this (.repaint time x y width height))))

(defn get-glass-pane
  "Returns the glassPane object for this applet.

  returns: the value of the glassPane property. - `java.awt.Component`"
  ([this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JApplet.
   For JApplets, the AccessibleContext takes the form of an
   AccessibleJApplet.
   A new AccessibleJApplet instance is created if necessary.

  returns: an AccessibleJApplet that serves as the
           AccessibleContext of this JApplet - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets the glassPane property.
   This method is called by the constructor.

  glass-pane - the glassPane object for this applet - `java.awt.Component`"
  ([this glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn set-j-menu-bar
  "Sets the menubar for this applet.

  menu-bar - the menubar being placed in the applet - `javax.swing.JMenuBar`"
  ([this menu-bar]
    (-> this (.setJMenuBar menu-bar))))

(defn get-transfer-handler
  "Gets the transferHandler property.

  returns: the value of the transferHandler property - `javax.swing.TransferHandler`"
  ([this]
    (-> this (.getTransferHandler))))

(defn get-root-pane
  "Returns the rootPane object for this applet.

  returns: this components single JRootPane child. - `javax.swing.JRootPane`"
  ([this]
    (-> this (.getRootPane))))

(defn set-content-pane
  "Sets the contentPane property.  This method is called by the constructor.

  content-pane - the contentPane object for this applet - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([this content-pane]
    (-> this (.setContentPane content-pane))))

(defn get-layered-pane
  "Returns the layeredPane object for this applet.

  returns: the value of the layeredPane property. - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([this]
    (-> this (.getLayeredPane))))

