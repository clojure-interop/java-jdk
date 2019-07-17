(ns javax.swing.JFrame
  "An extended version of java.awt.Frame that adds support for
  the JFC/Swing component architecture.
  You can find task-oriented documentation about using JFrame
  in The Java Tutorial, in the section
  How to Make Frames.


  The JFrame class is slightly incompatible with Frame.
  Like all other JFC/Swing top-level containers,
  a JFrame contains a JRootPane as its only child.
  The content pane provided by the root pane should,
  as a rule, contain
  all the non-menu components displayed by the JFrame.
  This is different from the AWT Frame case.
  As a convenience, the add, remove, and setLayout
  methods of this class are overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to a frame as follows:


        frame.add(child);
  And the child will be added to the contentPane.
  The content pane will
  always be non-null. Attempting to set it to null will cause the JFrame
  to throw an exception. The default content pane will have a BorderLayout
  manager set on it.
  Refer to RootPaneContainer
  for details on adding, removing and setting the LayoutManager
  of a JFrame.

  Unlike a Frame, a JFrame has some notion of how to
  respond when the user attempts to close the window. The default behavior
  is to simply hide the JFrame when the user closes the window. To change the
  default behavior, you invoke the method
  setDefaultCloseOperation(int).
  To make the JFrame behave the same as a Frame
  instance, use
  setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE).

  For more information on content panes
  and other features that root panes provide,
  see Using Top-Level Containers in The Java Tutorial.

  In a multi-screen environment, you can create a JFrame
  on a different screen device.  See Frame for more
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
  (:import [javax.swing JFrame]))

(defn ->j-frame
  "Constructor.

  Creates a JFrame with the specified title and the
   specified GraphicsConfiguration of a screen device.

   This constructor sets the component's locale property to the value
   returned by JComponent.getDefaultLocale.

  title - the title to be displayed in the frame's border. A null value is treated as an empty string, ``. - `java.lang.String`
  gc - the GraphicsConfiguration that is used to construct the new JFrame with; if gc is null, the system default GraphicsConfiguration is assumed - `java.awt.GraphicsConfiguration`

  throws: java.lang.IllegalArgumentException - if gc is not from a screen device. This exception is always thrown when GraphicsEnvironment.isHeadless() returns true."
  ([^java.lang.String title ^java.awt.GraphicsConfiguration gc]
    (new JFrame title gc))
  ([^java.awt.GraphicsConfiguration gc]
    (new JFrame gc))
  ([]
    (new JFrame )))

(def *-exit-on-close
  "Static Constant.

  The exit application default window close operation. If a window
   has this set as the close operation and is closed in an applet,
   a SecurityException may be thrown.
   It is recommended you only use this in an application.

  type: int"
  JFrame/EXIT_ON_CLOSE)

(defn *set-default-look-and-feel-decorated
  "Provides a hint as to whether or not newly created JFrames
   should have their Window decorations (such as borders, widgets to
   close the window, title...) provided by the current look
   and feel. If defaultLookAndFeelDecorated is true,
   the current LookAndFeel supports providing window
   decorations, and the current window manager supports undecorated
   windows, then newly created JFrames will have their
   Window decorations provided by the current LookAndFeel.
   Otherwise, newly created JFrames will have their
   Window decorations provided by the current window manager.

   You can get the same effect on a single JFrame by doing the following:


      JFrame frame = new JFrame();
      frame.setUndecorated(true);
      frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

  default-look-and-feel-decorated - A hint as to whether or not current look and feel should provide window decorations - `boolean`"
  ([^Boolean default-look-and-feel-decorated]
    (JFrame/setDefaultLookAndFeelDecorated default-look-and-feel-decorated)))

(defn *default-look-and-feel-decorated?
  "Returns true if newly created JFrames should have their
   Window decorations provided by the current look and feel. This is only
   a hint, as certain look and feels may not support this feature.

  returns: true if look and feel should provide Window decorations. - `boolean`"
  (^Boolean []
    (JFrame/isDefaultLookAndFeelDecorated )))

(defn set-layout
  "Sets the LayoutManager.
   Overridden to conditionally forward the call to the
   contentPane.
   Refer to RootPaneContainer for
   more information.

  manager - the LayoutManager - `java.awt.LayoutManager`"
  ([^javax.swing.JFrame this ^java.awt.LayoutManager manager]
    (-> this (.setLayout manager))))

(defn set-layered-pane
  "Sets the layeredPane property.
   This method is called by the constructor.

  layered-pane - the layeredPane object for this frame - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([^javax.swing.JFrame this ^javax.swing.JLayeredPane layered-pane]
    (-> this (.setLayeredPane layered-pane))))

(defn set-default-close-operation
  "Sets the operation that will happen by default when
   the user initiates a `close` on this frame.
   You must specify one of the following choices:


   DO_NOTHING_ON_CLOSE
   (defined in WindowConstants):
   Don't do anything; require the
   program to handle the operation in the windowClosing
   method of a registered WindowListener object.

   HIDE_ON_CLOSE
   (defined in WindowConstants):
   Automatically hide the frame after
   invoking any registered WindowListener
   objects.

   DISPOSE_ON_CLOSE
   (defined in WindowConstants):
   Automatically hide and dispose the
   frame after invoking any registered WindowListener
   objects.

   EXIT_ON_CLOSE
   (defined in JFrame):
   Exit the application using the System
   exit method.  Use this only in applications.


   The value is set to HIDE_ON_CLOSE by default. Changes
   to the value of this property cause the firing of a property
   change event, with property name `defaultCloseOperation`.

   Note: When the last displayable window within the
   Java virtual machine (VM) is disposed of, the VM may
   terminate.  See
   AWT Threading Issues for more information.

  operation - the operation which should be performed when the user closes the frame - `int`

  throws: java.lang.IllegalArgumentException - if defaultCloseOperation value isn't one of the above valid values"
  ([^javax.swing.JFrame this ^Integer operation]
    (-> this (.setDefaultCloseOperation operation))))

(defn get-content-pane
  "Returns the contentPane object for this frame.

  returns: the contentPane property - `java.awt.Container`"
  (^java.awt.Container [^javax.swing.JFrame this]
    (-> this (.getContentPane))))

(defn get-graphics
  "Creates a graphics context for this component. This method will
   return null if this component is currently not
   displayable.

  returns: a graphics context for this component, or null
               if it has none - `java.awt.Graphics`"
  (^java.awt.Graphics [^javax.swing.JFrame this]
    (-> this (.getGraphics))))

(defn update
  "Just calls paint(g).  This method was overridden to
   prevent an unnecessary call to clear the background.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^javax.swing.JFrame this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn get-j-menu-bar
  "Returns the menubar set on this frame.

  returns: the menubar for this frame - `javax.swing.JMenuBar`"
  (^javax.swing.JMenuBar [^javax.swing.JFrame this]
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

   Note: When used with JFrame, TransferHandler only
   provides data import capability, as the data export related methods
   are currently typed to JComponent.

   Please see

   How to Use Drag and Drop and Data Transfer, a section in
   The Java Tutorial, for more information.

  new-handler - the new TransferHandler - `javax.swing.TransferHandler`"
  ([^javax.swing.JFrame this ^javax.swing.TransferHandler new-handler]
    (-> this (.setTransferHandler new-handler))))

(defn remove
  "Removes the specified component from the container. If
   comp is not the rootPane, this will forward
   the call to the contentPane. This will do nothing if
   comp is not a child of the JFrame or
   contentPane.

  comp - the component to be removed - `java.awt.Component`

  throws: java.lang.NullPointerException - if comp is null"
  ([^javax.swing.JFrame this ^java.awt.Component comp]
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
  ([^javax.swing.JFrame this ^Long time ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint time x y width height))))

(defn get-glass-pane
  "Returns the glassPane object for this frame.

  returns: the glassPane property - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JFrame this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JFrame.
   For JFrames, the AccessibleContext takes the form of an
   AccessibleJFrame.
   A new AccessibleJFrame instance is created if necessary.

  returns: an AccessibleJFrame that serves as the
           AccessibleContext of this JFrame - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JFrame this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets the glassPane property.
   This method is called by the constructor.

  glass-pane - the glassPane object for this frame - `java.awt.Component`"
  ([^javax.swing.JFrame this ^java.awt.Component glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn set-icon-image
  "Sets the image to be displayed as the icon for this window.

   This method can be used instead of setIconImages()
   to specify a single image as a window's icon.

   The following statement:


       setIconImage(image);
   is equivalent to:


       ArrayList<Image> imageList = new ArrayList<Image>();
       imageList.add(image);
       setIconImages(imageList);

   Note : Native windowing systems may use different images of differing
   dimensions to represent a window, depending on the context (e.g.
   window decoration, window list, taskbar, etc.). They could also use
   just a single image for all contexts or no image at all.

  image - the icon image to be displayed. - `java.awt.Image`"
  ([^javax.swing.JFrame this ^java.awt.Image image]
    (-> this (.setIconImage image))))

(defn set-j-menu-bar
  "Sets the menubar for this frame.

  menubar - the menubar being placed in the frame - `javax.swing.JMenuBar`"
  ([^javax.swing.JFrame this ^javax.swing.JMenuBar menubar]
    (-> this (.setJMenuBar menubar))))

(defn get-transfer-handler
  "Gets the transferHandler property.

  returns: the value of the transferHandler property - `javax.swing.TransferHandler`"
  (^javax.swing.TransferHandler [^javax.swing.JFrame this]
    (-> this (.getTransferHandler))))

(defn get-root-pane
  "Returns the rootPane object for this frame.

  returns: the rootPane property - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^javax.swing.JFrame this]
    (-> this (.getRootPane))))

(defn set-content-pane
  "Sets the contentPane property.
   This method is called by the constructor.

   Swing's painting architecture requires an opaque JComponent
   in the containment hierarchy. This is typically provided by the
   content pane. If you replace the content pane it is recommended you
   replace it with an opaque JComponent.

  content-pane - the contentPane object for this frame - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^javax.swing.JFrame this ^java.awt.Container content-pane]
    (-> this (.setContentPane content-pane))))

(defn get-layered-pane
  "Returns the layeredPane object for this frame.

  returns: the layeredPane property - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^javax.swing.JFrame this]
    (-> this (.getLayeredPane))))

(defn get-default-close-operation
  "Returns the operation that occurs when the user
   initiates a `close` on this frame.

  returns: an integer indicating the window-close operation - `int`"
  (^Integer [^javax.swing.JFrame this]
    (-> this (.getDefaultCloseOperation))))

