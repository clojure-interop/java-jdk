(ns javax.swing.plaf.synth.SynthSliderUI
  "Provides the Synth L&F UI delegate for
  JSlider."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthSliderUI]))

(defn *create-ui
  "Creates a new UI object for the given component.

  c - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (SynthSliderUI/createUI c)))

(defn get-minimum-size
  "Returns the specified component's minimum size appropriate for
   the look and feel.  If null is returned, the minimum
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method invokes getPreferredSize and returns that value.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthSliderUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthSliderUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

(defn value-for-y-position
  "Returns the value at the y position. If yPos is beyond the
   track at the the bottom or the top, this method sets the value to either
   the minimum or maximum value of the slider, depending on if the slider
   is inverted or not.

  y-pos - `int`

  returns: `int`"
  (^Integer [^javax.swing.plaf.synth.SynthSliderUI this ^Integer y-pos]
    (-> this (.valueForYPosition y-pos))))

(defn value-for-x-position
  "Returns the value at the x position.  If xPos is beyond the
   track at the left or the right, this method sets the value to either the
   minimum or maximum value of the slider, depending on if the slider is
   inverted or not.

  x-pos - `int`

  returns: `int`"
  (^Integer [^javax.swing.plaf.synth.SynthSliderUI this ^Integer x-pos]
    (-> this (.valueForXPosition x-pos))))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the paint(SynthContext,Graphics) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSliderUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn set-thumb-location
  "x - `int`
  y - `int`"
  ([^javax.swing.plaf.synth.SynthSliderUI this ^Integer x ^Integer y]
    (-> this (.setThumbLocation x y))))

(defn property-change
  "This method gets called when a bound property is changed.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.synth.SynthSliderUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

(defn paint
  "Paints the specified component according to the Look and Feel.
   This method is not used by Synth Look and Feel.
   Painting is handled by the paint(SynthContext,Graphics) method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthSliderUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  (^javax.swing.plaf.synth.SynthContext [^javax.swing.plaf.synth.SynthSliderUI this ^javax.swing.JComponent c]
    (-> this (.getContext c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`"
  (^Integer [^javax.swing.plaf.synth.SynthSliderUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-preferred-size
  "Returns the specified component's preferred size appropriate for
   the look and feel.  If null is returned, the preferred
   size will be calculated by the component's layout manager instead
   (this is the preferred approach for any component with a specific
   layout manager installed).  The default implementation of this
   method returns null.

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthSliderUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

