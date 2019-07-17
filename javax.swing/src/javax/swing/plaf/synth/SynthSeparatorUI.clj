(ns javax.swing.plaf.synth.SynthSeparatorUI
  "Provides the Synth L&F UI delegate for
  JSeparator."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthSeparatorUI]))

(defn ->synth-separator-ui
  "Constructor."
  ([]
    (new SynthSeparatorUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  c - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (SynthSeparatorUI/createUI c)))

(defn install-ui
  "Configures the specified component appropriately for the look and feel.
   This method is invoked when the ComponentUI instance is being installed
   as the UI delegate on the specified component.  This method should
   completely configure the component for the look and feel,
   including the following:

   Install default property values for color, fonts, borders,
       icons, opacity, etc. on the component.  Whenever possible,
       property values initialized by the client program should not
       be overridden.
   Install a LayoutManager on the component if necessary.
   Create/add any required sub-components to the component.
   Create/install event listeners on the component.
   Create/install a PropertyChangeListener on the component in order
       to detect and respond to component property changes appropriately.
   Install keyboard UI (mnemonics, traversal, etc.) on the component.
   Initialize any appropriate instance data.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Returns the specified component's minimum size appropriate for
   the look and feel.  If null is returned, the minimum
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method invokes getPreferredSize and returns that value.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Returns the specified component's maximum size appropriate for
   the look and feel.  If null is returned, the maximum
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method invokes getPreferredSize and returns that value.

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn uninstall-listeners
  "Uninstalls listeners. This method is called when a
   LookAndFeel is uninstalled.

  c - `javax.swing.JSeparator`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JSeparator c]
    (-> this (.uninstallListeners c))))

(defn uninstall-ui
  "Reverses configuration which was done on the specified component during
   installUI.  This method is invoked when this
   UIComponent instance is being removed as the UI delegate
   for the specified component.  This method should undo the
   configuration performed in installUI, being careful to
   leave the JComponent instance in a clean state (no
   extraneous listeners, look-and-feel-specific property objects, etc.).
   This should include the following:

   Remove any UI-set borders from the component.
   Remove any UI-set layout managers on the component.
   Remove any UI-added sub-components from the component.
   Remove any UI-added event/property listeners from the component.
   Remove any UI-installed keyboard UI from the component.
   Nullify any allocated instance data objects to allow for GC.

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the paint(SynthContext,Graphics) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn property-change
  "Description copied from interface: PropertyChangeListener

  evt - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^java.beans.PropertyChangeEvent evt]
    (-> this (.propertyChange evt))))

(defn install-listeners
  "Installs listeners. This method is called when a
   LookAndFeel is installed.

  c - `javax.swing.JSeparator`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JSeparator c]
    (-> this (.installListeners c))))

(defn uninstall-defaults
  "Uninstalls default setting. This method is called when a
   LookAndFeel is uninstalled.

  c - `javax.swing.JSeparator`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JSeparator c]
    (-> this (.uninstallDefaults c))))

(defn paint
  "Paints the specified component according to the Look and Feel.
   This method is not used by Synth Look and Feel.
   Painting is handled by the paint(SynthContext,Graphics) method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  (^javax.swing.plaf.synth.SynthContext [^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getContext c))))

(defn install-defaults
  "Installs default setting. This method is called when a
   LookAndFeel is installed.

  c - `javax.swing.JSeparator`"
  ([^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JSeparator c]
    (-> this (.installDefaults c))))

(defn get-preferred-size
  "Returns the specified component's preferred size appropriate for
   the look and feel.  If null is returned, the preferred
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method returns null.

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

