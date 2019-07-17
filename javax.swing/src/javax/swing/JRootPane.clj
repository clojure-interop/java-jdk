(ns javax.swing.JRootPane
  "A lightweight container used behind the scenes by
  JFrame, JDialog, JWindow,
  JApplet, and JInternalFrame.
  For task-oriented information on functionality provided by root panes
  see How to Use Root Panes,
  a section in The Java Tutorial.


  The following image shows the relationships between
  the classes that use root panes.

  The `heavyweight` components (those that delegate to a peer, or native
  component on the host system) are shown with a darker, heavier box. The four
  heavyweight JFC/Swing containers (JFrame, JDialog,
  JWindow, and JApplet) are
  shown in relation to the AWT classes they extend.
  These four components are the
  only heavyweight containers in the Swing library. The lightweight container
  JInternalFrame is also shown.
  All five of these JFC/Swing containers implement the
  RootPaneContainer interface,
  and they all delegate their operations to a
  JRootPane (shown with a little `handle` on top).

  Note: The JComponent method getRootPane
  can be used to obtain the JRootPane that contains
  a given component.








  The diagram at right shows the structure of a JRootPane.
  A JRootpane is made up of a glassPane,
  an optional menuBar, and a contentPane.
  (The JLayeredPane manages the menuBar
  and the contentPane.)
  The glassPane sits over the top of everything,
  where it is in a position to intercept mouse movements.
  Since the glassPane (like the contentPane)
  can be an arbitrary component, it is also possible to set up the
  glassPane for drawing. Lines and images on the
  glassPane can then range
  over the frames underneath without being limited by their boundaries.

  Although the menuBar component is optional,
  the layeredPane, contentPane,
  and glassPane always exist.
  Attempting to set them to null generates an exception.

  To add components to the JRootPane (other than the
  optional menu bar), you add the object to the contentPane
  of the JRootPane, like this:


        rootPane.getContentPane().add(child);
  The same principle holds true for setting layout managers, removing
  components, listing children, etc. All these methods are invoked on
  the contentPane instead of on the JRootPane.

  Note: The default layout manager for the contentPane is
   a BorderLayout manager. However, the JRootPane
   uses a custom LayoutManager.
   So, when you want to change the layout manager for the components you added
   to a JRootPane, be sure to use code like this:


     rootPane.getContentPane().setLayout(new BoxLayout());
  If a JMenuBar component is set on the JRootPane,
  it is positioned along the upper edge of the frame.
  The contentPane is adjusted in location and size to
  fill the remaining area.
  (The JMenuBar and the contentPane are added to the
  layeredPane component at the
  JLayeredPane.FRAME_CONTENT_LAYER layer.)

  The layeredPane is the parent of all children in the
  JRootPane -- both as the direct parent of the menu and
  the grandparent of all components added to the contentPane.
  It is an instance of JLayeredPane,
  which provides the ability to add components at several layers.
  This capability is very useful when working with menu popups,
  dialog boxes, and dragging -- situations in which you need to place
  a component on top of all other components in the pane.

  The glassPane sits on top of all other components in the
  JRootPane.
  That provides a convenient place to draw above all other components,
  and makes it possible to intercept mouse events,
  which is useful both for dragging and for drawing.
  Developers can use setVisible on the glassPane
  to control when the glassPane displays over the other children.
  By default the glassPane is not visible.

  The custom LayoutManager used by JRootPane
  ensures that:

  The glassPane fills the entire viewable
      area of the JRootPane (bounds - insets).
  The layeredPane fills the entire viewable area of the
      JRootPane. (bounds - insets)
  The menuBar is positioned at the upper edge of the
      layeredPane.
  The contentPane fills the entire viewable area,
      minus the menuBar, if present.

  Any other views in the JRootPane view hierarchy are ignored.

  If you replace the LayoutManager of the JRootPane,
  you are responsible for managing all of these views.
  So ordinarily you will want to be sure that you
  change the layout manager for the contentPane rather than
  for the JRootPane itself!

  The painting architecture of Swing requires an opaque
  JComponent
  to exist in the containment hierarchy above all other components. This is
  typically provided by way of the content pane. If you replace the content
  pane, it is recommended that you make the content pane opaque
  by way of setOpaque(true). Additionally, if the content pane
  overrides paintComponent, it
  will need to completely fill in the background in an opaque color in
  paintComponent.

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
  (:import [javax.swing JRootPane]))

(defn ->j-root-pane
  "Constructor.

  Creates a JRootPane, setting up its
   glassPane, layeredPane,
   and contentPane."
  ([]
    (new JRootPane )))

(def *-none
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should not provide any sort of
   Window decorations.

  type: int"
  JRootPane/NONE)

(def *-frame
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Frame.

  type: int"
  JRootPane/FRAME)

(def *-plain-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog.

  type: int"
  JRootPane/PLAIN_DIALOG)

(def *-information-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to display an informational message.

  type: int"
  JRootPane/INFORMATION_DIALOG)

(def *-error-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to display an error message.

  type: int"
  JRootPane/ERROR_DIALOG)

(def *-color-chooser-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to display a JColorChooser.

  type: int"
  JRootPane/COLOR_CHOOSER_DIALOG)

(def *-file-chooser-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to display a JFileChooser.

  type: int"
  JRootPane/FILE_CHOOSER_DIALOG)

(def *-question-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to present a question to the user.

  type: int"
  JRootPane/QUESTION_DIALOG)

(def *-warning-dialog
  "Static Constant.

  Constant used for the windowDecorationStyle property. Indicates that
   the JRootPane should provide decorations appropriate for
   a Dialog used to display a warning message.

  type: int"
  JRootPane/WARNING_DIALOG)

(defn set-window-decoration-style
  "Sets the type of Window decorations (such as borders, widgets for
   closing a Window, title ...) the JRootPane should
   provide. The default is to provide no Window decorations
   (NONE).

   This is only a hint, and some look and feels may not support
   this.
   This is a bound property.

  window-decoration-style - Constant identifying Window decorations to provide. - `int`

  throws: java.lang.IllegalArgumentException - if style is not one of: NONE, FRAME, PLAIN_DIALOG, INFORMATION_DIALOG, ERROR_DIALOG, COLOR_CHOOSER_DIALOG, FILE_CHOOSER_DIALOG, QUESTION_DIALOG, or WARNING_DIALOG."
  ([^javax.swing.JRootPane this ^Integer window-decoration-style]
    (-> this (.setWindowDecorationStyle window-decoration-style))))

(defn set-layered-pane
  "Sets the layered pane for the root pane. The layered pane
   typically holds a content pane and an optional JMenuBar.

  layered - the JLayeredPane to use - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([^javax.swing.JRootPane this ^javax.swing.JLayeredPane layered]
    (-> this (.setLayeredPane layered))))

(defn get-window-decoration-style
  "Returns a constant identifying the type of Window decorations the
   JRootPane is providing.

  returns: One of NONE, FRAME,
          PLAIN_DIALOG, INFORMATION_DIALOG,
          ERROR_DIALOG, COLOR_CHOOSER_DIALOG,
          FILE_CHOOSER_DIALOG, QUESTION_DIALOG or
          WARNING_DIALOG. - `int`"
  (^Integer [^javax.swing.JRootPane this]
    (-> this (.getWindowDecorationStyle))))

(defn get-content-pane
  "Returns the content pane -- the container that holds the components
   parented by the root pane.

  returns: the Container that holds the component-contents - `java.awt.Container`"
  (^java.awt.Container [^javax.swing.JRootPane this]
    (-> this (.getContentPane))))

(defn set-double-buffered
  "Sets whether this component should use a buffer to paint.
    If set to true, all the drawing from this component will be done
    in an offscreen painting buffer. The offscreen painting buffer will
    the be copied onto the screen.
    If a Component is buffered and one of its ancestor
    is also buffered, the ancestor buffer will be used.

  a-flag - if true, set this component to be double buffered - `boolean`"
  ([^javax.swing.JRootPane this ^Boolean a-flag]
    (-> this (.setDoubleBuffered a-flag))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the L&F class
   that renders this component.

  returns: the string `RootPaneUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JRootPane this]
    (-> this (.getUIClassID))))

(defn get-j-menu-bar
  "Returns the menu bar from the layered pane.

  returns: the JMenuBar used in the pane - `javax.swing.JMenuBar`"
  (^javax.swing.JMenuBar [^javax.swing.JRootPane this]
    (-> this (.getJMenuBar))))

(defn validate-root?
  "If a descendant of this JRootPane calls
   revalidate, validate from here on down.

   Deferred requests to layout a component and its descendents again.
   For example, calls to revalidate, are pushed upwards to
   either a JRootPane or a JScrollPane
   because both classes override isValidateRoot to return true.

  returns: true - `boolean`"
  (^Boolean [^javax.swing.JRootPane this]
    (-> this (.isValidateRoot))))

(defn add-notify
  "Notifies this component that it now has a parent component.
   When this method is invoked, the chain of parent components is
   set up with KeyboardAction event listeners.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^javax.swing.JRootPane this]
    (-> this (.addNotify))))

(defn set-menu-bar
  "Deprecated. As of Swing version 1.0.3
    replaced by setJMenuBar(JMenuBar menu).

  menu - the JMenuBar to add. - `javax.swing.JMenuBar`

  returns: `java.lang.  void`"
  ([^javax.swing.JRootPane this ^javax.swing.JMenuBar menu]
    (-> this (.setMenuBar menu))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the LabelUI L&F object - `javax.swing.plaf.RootPaneUI`"
  ([^javax.swing.JRootPane this ^javax.swing.plaf.RootPaneUI ui]
    (-> this (.setUI ui))))

(defn remove-notify
  "Notifies this component that it no longer has a parent component.
   When this method is invoked, any KeyboardActions
   set up in the the chain of parent components are removed.
   This method is called by the toolkit internally and should
   not be called directly by programs."
  ([^javax.swing.JRootPane this]
    (-> this (.removeNotify))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: LabelUI object - `javax.swing.plaf.RootPaneUI`"
  (^javax.swing.plaf.RootPaneUI [^javax.swing.JRootPane this]
    (-> this (.getUI))))

(defn get-glass-pane
  "Returns the current glass pane for this JRootPane.

  returns: the current glass pane - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JRootPane this]
    (-> this (.getGlassPane))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JRootPane. For root panes, the
   AccessibleContext takes the form of an
   AccessibleJRootPane.
   A new AccessibleJRootPane instance is created if necessary.

  returns: an AccessibleJRootPane that serves as the
           AccessibleContext of this JRootPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JRootPane this]
    (-> this (.getAccessibleContext))))

(defn set-glass-pane
  "Sets a specified Component to be the glass pane for this
   root pane.  The glass pane should normally be a lightweight,
   transparent component, because it will be made visible when
   ever the root pane needs to grab input events.

   The new glass pane's visibility is changed to match that of
   the current glass pane.  An implication of this is that care
   must be taken when you want to replace the glass pane and
   make it visible.  Either of the following will work:


     root.setGlassPane(newGlassPane);
     newGlassPane.setVisible(true);
   or:


     root.getGlassPane().setVisible(true);
     root.setGlassPane(newGlassPane);

  glass - the Component to use as the glass pane for this JRootPane - `java.awt.Component`

  throws: java.lang.NullPointerException - if the glass parameter is null"
  ([^javax.swing.JRootPane this ^java.awt.Component glass]
    (-> this (.setGlassPane glass))))

(defn get-default-button
  "Returns the value of the defaultButton property.

  returns: the JButton which is currently the default button - `javax.swing.JButton`"
  (^javax.swing.JButton [^javax.swing.JRootPane this]
    (-> this (.getDefaultButton))))

(defn set-j-menu-bar
  "Adds or changes the menu bar used in the layered pane.

  menu - the JMenuBar to add - `javax.swing.JMenuBar`"
  ([^javax.swing.JRootPane this ^javax.swing.JMenuBar menu]
    (-> this (.setJMenuBar menu))))

(defn get-menu-bar
  "Deprecated. As of Swing version 1.0.3
    replaced by getJMenuBar().

  returns: the JMenuBar used in the pane - `java.lang.  javax.swing.JMenuBar`"
  ([^javax.swing.JRootPane this]
    (-> this (.getMenuBar))))

(defn set-content-pane
  "Sets the content pane -- the container that holds the components
   parented by the root pane.

   Swing's painting architecture requires an opaque JComponent
   in the containment hierarchy. This is typically provided by the
   content pane. If you replace the content pane it is recommended you
   replace it with an opaque JComponent.

  content - the Container to use for component-contents - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^javax.swing.JRootPane this ^java.awt.Container content]
    (-> this (.setContentPane content))))

(defn get-layered-pane
  "Gets the layered pane used by the root pane. The layered pane
   typically holds a content pane and an optional JMenuBar.

  returns: the JLayeredPane currently in use - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^javax.swing.JRootPane this]
    (-> this (.getLayeredPane))))

(defn set-default-button
  "Sets the defaultButton property,
   which determines the current default button for this JRootPane.
   The default button is the button which will be activated
   when a UI-defined activation event (typically the Enter key)
   occurs in the root pane regardless of whether or not the button
   has keyboard focus (unless there is another component within
   the root pane which consumes the activation event,
   such as a JTextPane).
   For default activation to work, the button must be an enabled
   descendent of the root pane when activation occurs.
   To remove a default button from this root pane, set this
   property to null.

  default-button - the JButton which is to be the default button - `javax.swing.JButton`"
  ([^javax.swing.JRootPane this ^javax.swing.JButton default-button]
    (-> this (.setDefaultButton default-button))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JRootPane this]
    (-> this (.updateUI))))

(defn optimized-drawing-enabled?
  "The glassPane and contentPane
   have the same bounds, which means JRootPane
   does not tiles its children and this should return false.
   On the other hand, the glassPane
   is normally not visible, and so this can return true if the
   glassPane isn't visible. Therefore, the
   return value here depends upon the visibility of the
   glassPane.

  returns: true if this component's children don't overlap - `boolean`"
  (^Boolean [^javax.swing.JRootPane this]
    (-> this (.isOptimizedDrawingEnabled))))

