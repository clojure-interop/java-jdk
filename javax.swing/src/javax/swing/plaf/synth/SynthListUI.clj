(ns javax.swing.plaf.synth.SynthListUI
  "Provides the Synth L&F UI delegate for
  JList."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthListUI]))

(defn ->synth-list-ui
  "Constructor."
  ([]
    (new SynthListUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  list - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  ([list]
    (SynthListUI/createUI list)))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the BasicListUI.paint(java.awt.Graphics, javax.swing.JComponent) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([this g c]
    (-> this (.update g c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([this context g x y w h]
    (-> this (.paintBorder context g x y w h))))

(defn property-change
  "This method gets called when a bound property is changed.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([this e]
    (-> this (.propertyChange e))))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  ([this c]
    (-> this (.getContext c))))

