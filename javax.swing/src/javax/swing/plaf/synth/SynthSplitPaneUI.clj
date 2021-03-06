(ns javax.swing.plaf.synth.SynthSplitPaneUI
  "Provides the Synth L&F UI delegate for
  JSplitPane."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthSplitPaneUI]))

(defn ->synth-split-pane-ui
  "Constructor."
  (^SynthSplitPaneUI []
    (new SynthSplitPaneUI )))

(defn *create-ui
  "Creates a new SynthSplitPaneUI instance

  x - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (SynthSplitPaneUI/createUI x)))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  (^javax.swing.plaf.synth.SynthContext [^SynthSplitPaneUI this ^javax.swing.JComponent c]
    (-> this (.getContext c))))

(defn property-change
  "This method gets called when a bound property is changed.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^SynthSplitPaneUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

(defn create-default-divider
  "Creates the default divider.

  returns: `javax.swing.plaf.basic.BasicSplitPaneDivider`"
  (^javax.swing.plaf.basic.BasicSplitPaneDivider [^SynthSplitPaneUI this]
    (-> this (.createDefaultDivider))))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the paint(SynthContext,Graphics) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^SynthSplitPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn paint
  "Paints the specified component according to the Look and Feel.
   This method is not used by Synth Look and Feel.
   Painting is handled by the paint(SynthContext,Graphics) method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^SynthSplitPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^SynthSplitPaneUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

(defn finished-painting-children
  "Called when the specified split pane has finished painting
   its children.

  jc - `javax.swing.JSplitPane`
  g - `java.awt.Graphics`"
  ([^SynthSplitPaneUI this ^javax.swing.JSplitPane jc ^java.awt.Graphics g]
    (-> this (.finishedPaintingChildren jc g))))

