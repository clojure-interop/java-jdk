(ns javax.swing.plaf.synth.SynthMenuItemUI
  "Provides the Synth L&F UI delegate for
  JMenuItem."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthMenuItemUI]))

(defn ->synth-menu-item-ui
  "Constructor."
  ([]
    (new SynthMenuItemUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  c - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (SynthMenuItemUI/createUI c)))

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
  ([^javax.swing.plaf.synth.SynthMenuItemUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  (^javax.swing.plaf.synth.SynthContext [^javax.swing.plaf.synth.SynthMenuItemUI this ^javax.swing.JComponent c]
    (-> this (.getContext c))))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the paint(SynthContext,Graphics) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthMenuItemUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn paint
  "Paints the specified component according to the Look and Feel.
   This method is not used by Synth Look and Feel.
   Painting is handled by the paint(SynthContext,Graphics) method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthMenuItemUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthMenuItemUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

(defn property-change
  "This method gets called when a bound property is changed.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.synth.SynthMenuItemUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

