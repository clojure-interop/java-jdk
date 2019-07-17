(ns javax.swing.plaf.metal.MetalRootPaneUI
  "Provides the metal look and feel implementation of RootPaneUI.

  MetalRootPaneUI provides support for the
  windowDecorationStyle property of JRootPane.
  MetalRootPaneUI does this by way of installing a custom
  LayoutManager, a private Component to render
  the appropriate widgets, and a private Border. The
  LayoutManager is always installed, regardless of the value of
  the windowDecorationStyle property, but the
  Border and Component are only installed/added if
  the windowDecorationStyle is other than
  JRootPane.NONE.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalRootPaneUI]))

(defn ->metal-root-pane-ui
  "Constructor."
  ([]
    (new MetalRootPaneUI )))

(defn *create-ui
  "Creates a UI for a JRootPane.

  c - the JRootPane the RootPaneUI will be created for - `javax.swing.JComponent`

  returns: the RootPaneUI implementation for the passed in JRootPane - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (MetalRootPaneUI/createUI c)))

(defn install-ui
  "Invokes supers implementation of installUI to install
   the necessary state onto the passed in JRootPane
   to render the metal look and feel implementation of
   RootPaneUI. If
   the windowDecorationStyle property of the
   JRootPane is other than JRootPane.NONE,
   this will add a custom Component to render the widgets to
   JRootPane, as well as installing a custom
   Border and LayoutManager on the
   JRootPane.

  c - the JRootPane to install state onto - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalRootPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Invokes supers implementation to uninstall any of its state. This will
   also reset the LayoutManager of the JRootPane.
   If a Component has been added to the JRootPane
   to render the window decoration style, this method will remove it.
   Similarly, this will revert the Border and LayoutManager of the
   JRootPane to what it was before installUI
   was invoked.

  c - the JRootPane to uninstall state from - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalRootPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn property-change
  "Invoked when a property changes. MetalRootPaneUI is
   primarily interested in events originating from the
   JRootPane it has been installed on identifying the
   property windowDecorationStyle. If the
   windowDecorationStyle has changed to a value other
   than JRootPane.NONE, this will add a Component
   to the JRootPane to render the window decorations, as well
   as installing a Border on the JRootPane.
   On the other hand, if the windowDecorationStyle has
   changed to JRootPane.NONE, this will remove the
   Component that has been added to the JRootPane
   as well resetting the Border to what it was before
   installUI was invoked.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.metal.MetalRootPaneUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

