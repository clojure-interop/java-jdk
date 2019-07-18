(ns javax.swing.JDialog
  "The main class for creating a dialog window. You can use this class
  to create a custom dialog, or invoke the many class methods
  in JOptionPane to create a variety of standard dialogs.
  For information about creating dialogs, see
  The Java Tutorial section
  How
  to Make Dialogs.



  The JDialog component contains a JRootPane
  as its only child.
  The contentPane should be the parent of any children of the
  JDialog.
  As a convenience, the add, remove, and setLayout
  methods of this class are overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to a dialog as follows:


        dialog.add(child);
  And the child will be added to the contentPane.
  The contentPane is always non-null.
  Attempting to set it to null generates an exception.
  The default contentPane has a BorderLayout
  manager set on it.
  Refer to RootPaneContainer
  for details on adding, removing and setting the LayoutManager
  of a JDialog.

  Please see the JRootPane documentation for a complete
  description of the contentPane, glassPane,
  and layeredPane components.

  In a multi-screen environment, you can create a JDialog
  on a different screen device than its owner.  See Frame for
  more information.

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
  (:import [javax.swing JDialog]))

(defn ->j-dialog
  "Constructor.

  Creates a dialog with the specified title,
   owner Frame, modality and GraphicsConfiguration.
   If owner is null,
   a shared, hidden frame will be set as the owner of this dialog.

   This constructor sets the component's locale property to the value
   returned by JComponent.getDefaultLocale.

   NOTE: Any popup components (JComboBox,
   JPopupMenu, JMenuBar)
   created within a modal dialog will be forced to be lightweight.

   NOTE: This constructor does not allow you to create an unowned
   JDialog. To create an unowned JDialog
   you must use either the JDialog(Window) or
   JDialog(Dialog) constructor with an argument of
   null.

  owner - the Frame from which the dialog is displayed - `java.awt.Frame`
  title - the String to display in the dialog's title bar - `java.lang.String`
  modal - specifies whether dialog blocks user input to other top-level windows when shown. If true, the modality type property is set to DEFAULT_MODALITY_TYPE, otherwise the dialog is modeless. - `boolean`
  gc - the GraphicsConfiguration of the target screen device; if null, the default system GraphicsConfiguration is assumed - `java.awt.GraphicsConfiguration`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  (^JDialog [^java.awt.Frame owner ^java.lang.String title ^Boolean modal ^java.awt.GraphicsConfiguration gc]
    (new JDialog owner title modal gc))
  (^JDialog [^java.awt.Frame owner ^java.lang.String title ^Boolean modal]
    (new JDialog owner title modal))
  (^JDialog [^java.awt.Frame owner ^Boolean modal]
    (new JDialog owner modal))
  (^JDialog [^java.awt.Frame owner]
    (new JDialog owner))
  (^JDialog []
    (new JDialog )))

(defn *set-default-look-and-feel-decorated
  "Provides a hint as to whether or not newly created JDialogs
   should have their Window decorations (such as borders, widgets to
   close the window, title...) provided by the current look
   and feel. If defaultLookAndFeelDecorated is true,
   the current LookAndFeel supports providing window
   decorations, and the current window manager supports undecorated
   windows, then newly created JDialogs will have their
   Window decorations provided by the current LookAndFeel.
   Otherwise, newly created JDialogs will have their
   Window decorations provided by the current window manager.

   You can get the same effect on a single JDialog by doing the following:


      JDialog dialog = new JDialog();
      dialog.setUndecorated(true);
      dialog.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

  default-look-and-feel-decorated - A hint as to whether or not current look and feel should provide window decorations - `boolean`"
  ([^Boolean default-look-and-feel-decorated]
    (JDialog/setDefaultLookAndFeelDecorated default-look-and-feel-decorated)))

(defn *default-look-and-feel-decorated?
  "Returns true if newly created JDialogs should have their
   Window decorations provided by the current look and feel. This is only
   a hint, as certain look and feels may not support this feature.

  returns: true if look and feel should provide Window decorations. - `boolean`"
  (^Boolean []
    (JDialog/isDefaultLookAndFeelDecorated )))

(defn set-layout
  "Sets the LayoutManager.
   Overridden to conditionally forward the call to the
   contentPane.
   Refer to RootPaneContainer for
   more information.

  manager - the LayoutManager - `java.awt.LayoutManager`"
  ([^JDialog this ^java.awt.LayoutManager manager]
    (-> this (.setLayout manager))))

(defn set-layered-pane
  "Sets the layeredPane property.
   This method is called by the constructor.

  layered-pane - the new layeredPane property - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([^JDialog this ^javax.swing.JLayeredPane layered-pane]
    (-> this (.setLayeredPane layered-pane))))

(defn set-default-close-operation
  "Sets the operation that will happen by default when
   the user initiates a `close` on this dialog.
   You must specify one of the following choices:


   DO_NOTHING_ON_CLOSE
   (defined in WindowConstants):
   Don't do anything; require the
   program to handle the operation in the windowClosing
   method of a registered WindowListener object.

   HIDE_ON_CLOSE
   (defined in WindowConstants):
   Automatically hide the dialog after
   invoking any registered WindowListener
   objects.

   DISPOSE_ON_CLOSE
   (defined in WindowConstants):
   Automatically hide and dispose the
   dialog after invoking any registered WindowListener
   objects.


   The value is set to HIDE_ON_CLOSE by default. Changes
   to the value of this property cause the firing of a property
   change event, with property name `defaultCloseOperation`.

   Note: When the last displayable window within the
   Java virtual machine (VM) is disposed of, the VM may
   terminate.  See
   AWT Threading Issues for more information.

  operation - the operation which should be performed when the user closes the dialog - `int`

  throws: java.lang.IllegalArgumentException - if defaultCloseOperation value isn't one of the above valid values"
  ([^JDialog this ^Integer operation]
    (-> this (.setDefaultCloseOperation operation))))

(defn get-content-pane
  "Returns the contentPane object for this dialog.

  returns: the contentPane property - `java.awt.Container`"
  (^java.awt.Container [^JDialog this]
    (-> this (.getContentPane))))

(defn get-graphics
  "Creates a graphics context for this component. This method will
   return null if this component is currently not
   displayable.

  returns: a graphics context for this component, or null
               if it has none - `java.awt.Graphics`"
  (^java.awt.Graphics [^JDialog this]
    (-> this (.getGraphics))))

(defn update
  "Calls paint(g).  This method was overridden to
   prevent an unnecessary call to clear the background.

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^JDialog this ^java.awt.Graphics g]
    (-> this (.update g))))

(defn get-j-menu-bar
  "Returns the menubar set on this dialog.

  returns: `javax.swing.JMenuBar`"
  (^javax.swing.JMenuBar [^JDialog this]
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

   Note: When used with JDialog, TransferHandler only
   provides data import capability, as the data export related methods
   are currently typed to JComponent.

   Please see

   How to Use Drag and Drop and Data Transfer, a section in
   The Java Tutorial, for more information.

  new-handler - the new TransferHandler - `javax.swing.TransferHandler`"
  ([^JDialog this ^javax.swing.TransferHandler new-handler]
    (-> this (.setTransferHandler new-handler))))

(defn remove
  "Removes the specified component from the container. If
   comp is not the rootPane, this will forward
   the call to the contentPane. This will do nothing if
   comp is not a child of the JDialog or
   contentPane.

  comp - the component to be removed - `java.awt.Component`

  throws: java.lang.NullPointerException - if comp is null"
  ([^JDialog this ^java.awt.Component comp]
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
  ([^JDialog this ^Long time ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint time x y width height))))

(defn get-glass-pane
  "Returns the glassPane object for this dialog.

  returns: the glassPane property - `java.awt.Component`"
  (^java.awt.Component [^JDialog this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JDialog.
   For JDialogs, the AccessibleContext takes the form of an
   AccessibleJDialog.
   A new AccessibleJDialog instance is created if necessary.

  returns: an AccessibleJDialog that serves as the
           AccessibleContext of this JDialog - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JDialog this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets the glassPane property.
   This method is called by the constructor.

  glass-pane - the glassPane object for this dialog - `java.awt.Component`"
  ([^JDialog this ^java.awt.Component glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn set-j-menu-bar
  "Sets the menubar for this dialog.

  menu - the menubar being placed in the dialog - `javax.swing.JMenuBar`"
  ([^JDialog this ^javax.swing.JMenuBar menu]
    (-> this (.setJMenuBar menu))))

(defn get-transfer-handler
  "Gets the transferHandler property.

  returns: the value of the transferHandler property - `javax.swing.TransferHandler`"
  (^javax.swing.TransferHandler [^JDialog this]
    (-> this (.getTransferHandler))))

(defn get-root-pane
  "Returns the rootPane object for this dialog.

  returns: this components single JRootPane child. - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^JDialog this]
    (-> this (.getRootPane))))

(defn set-content-pane
  "Sets the contentPane property.
   This method is called by the constructor.

   Swing's painting architecture requires an opaque JComponent
   in the containment hierarchy. This is typically provided by the
   content pane. If you replace the content pane it is recommended you
   replace it with an opaque JComponent.

  content-pane - the contentPane object for this dialog - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^JDialog this ^java.awt.Container content-pane]
    (-> this (.setContentPane content-pane))))

(defn get-layered-pane
  "Returns the layeredPane object for this dialog.

  returns: the layeredPane property - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^JDialog this]
    (-> this (.getLayeredPane))))

(defn get-default-close-operation
  "Returns the operation which occurs when the user
   initiates a `close` on this dialog.

  returns: an integer indicating the window-close operation - `int`"
  (^Integer [^JDialog this]
    (-> this (.getDefaultCloseOperation))))

