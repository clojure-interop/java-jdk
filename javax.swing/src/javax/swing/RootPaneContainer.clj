(ns javax.swing.RootPaneContainer
  "This interface is implemented by components that have a single
  JRootPane child: JDialog, JFrame, JWindow, JApplet, JInternalFrame.
  The methods in  this interface are just covers for the JRootPane
  properties, e.g. getContentPane() is generally implemented
  like this:

      public Container getContentPane() {
          return getRootPane().getContentPane();
      }
  This interface serves as a marker for Swing GUI builders
  that need to treat components like JFrame, that contain a
  single JRootPane, specially.  For example in a GUI builder,
  dropping a component on a RootPaneContainer would be interpreted
  as frame.getContentPane().add(child).

  As a convenience, the standard classes that implement this interface
  (such as JFrame, JDialog, JWindow, JApplet,
  and JInternalFrame) have their add, remove,
  and setLayout methods overridden, so that they delegate calls
  to the corresponding methods of the ContentPane.
  For example, you can add a child component to a frame as follows:


        frame.add(child);
  instead of:


        frame.getContentPane().add(child);

  The behavior of the add and
  setLayout methods for
  JFrame, JDialog, JWindow,
  JApplet and JInternalFrame is controlled by
  the rootPaneCheckingEnabled property. If this property is
  true (the default), then calls to these methods are
  forwarded to the contentPane; if false, these
  methods operate directly on the RootPaneContainer. This
  property is only intended for subclasses, and is therefore protected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RootPaneContainer]))

(defn get-root-pane
  "Return this component's single JRootPane child.  A conventional
   implementation of this interface will have all of the other
   methods indirect through this one.  The rootPane has two
   children: the glassPane and the layeredPane.

  returns: this components single JRootPane child. - `javax.swing.JRootPane`"
  (^javax.swing.JRootPane [^RootPaneContainer this]
    (-> this (.getRootPane))))

(defn set-content-pane
  "The `contentPane` is the primary container for application
   specific components.  Applications should add children to
   the contentPane, set its layout manager, and so on.

   The contentPane may not be null.

   Generally implemented with
   getRootPane().setContentPane(contentPane);

  content-pane - the Container to use for the contents of this JRootPane - `java.awt.Container`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the content pane parameter is null"
  ([^RootPaneContainer this ^java.awt.Container content-pane]
    (-> this (.setContentPane content-pane))))

(defn get-content-pane
  "Returns the contentPane.

  returns: the value of the contentPane property. - `java.awt.Container`"
  (^java.awt.Container [^RootPaneContainer this]
    (-> this (.getContentPane))))

(defn set-layered-pane
  "A Container that manages the contentPane and in some cases a menu bar.
   The layeredPane can be used by descendants that want to add a child
   to the RootPaneContainer that isn't layout managed.  For example
   an internal dialog or a drag and drop effect component.

   The layeredPane may not be null.

   Generally implemented with

      getRootPane().setLayeredPane(layeredPane);

  layered-pane - `javax.swing.JLayeredPane`

  throws: java.awt.IllegalComponentStateException - (a runtime exception) if the layered pane parameter is null"
  ([^RootPaneContainer this ^javax.swing.JLayeredPane layered-pane]
    (-> this (.setLayeredPane layered-pane))))

(defn get-layered-pane
  "Returns the layeredPane.

  returns: the value of the layeredPane property. - `javax.swing.JLayeredPane`"
  (^javax.swing.JLayeredPane [^RootPaneContainer this]
    (-> this (.getLayeredPane))))

(defn set-glass-pane
  "The glassPane is always the first child of the rootPane
   and the rootPanes layout manager ensures that it's always
   as big as the rootPane.  By default it's transparent and
   not visible.  It can be used to temporarily grab all keyboard
   and mouse input by adding listeners and then making it visible.
   by default it's not visible.

   The glassPane may not be null.

   Generally implemented with
   getRootPane().setGlassPane(glassPane);

  glass-pane - `java.awt.Component`"
  ([^RootPaneContainer this ^java.awt.Component glass-pane]
    (-> this (.setGlassPane glass-pane))))

(defn get-glass-pane
  "Returns the glassPane.

  returns: the value of the glassPane property. - `java.awt.Component`"
  (^java.awt.Component [^RootPaneContainer this]
    (-> this (.getGlassPane))))

