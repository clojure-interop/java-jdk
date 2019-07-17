(ns javax.swing.plaf.synth.SynthScrollBarUI
  "Provides the Synth L&F UI delegate for
  JScrollBar."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthScrollBarUI]))

(defn ->synth-scroll-bar-ui
  "Constructor."
  ([]
    (new SynthScrollBarUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (SynthScrollBarUI/createUI c)))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  (^javax.swing.plaf.synth.SynthContext [^javax.swing.plaf.synth.SynthScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.getContext c))))

(defn get-supports-absolute-positioning?
  "Indicates whether the user can absolutely position the thumb with
   a mouse gesture (usually the middle mouse button).

  returns: true if a mouse gesture can absolutely position the thumb - `boolean`"
  (^Boolean [^javax.swing.plaf.synth.SynthScrollBarUI this]
    (-> this (.getSupportsAbsolutePositioning))))

(defn update
  "Notifies this UI delegate to repaint the specified component.
   This method paints the component background, then calls
   the paint(SynthContext,Graphics) method.

   In general, this method does not need to be overridden by subclasses.
   All Look and Feel rendering code should reside in the paint method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthScrollBarUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn paint
  "Paints the specified component according to the Look and Feel.
   This method is not used by Synth Look and Feel.
   Painting is handled by the paint(SynthContext,Graphics) method.

  g - the Graphics object used for painting - `java.awt.Graphics`
  c - the component being painted - `javax.swing.JComponent`"
  ([^javax.swing.plaf.synth.SynthScrollBarUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthScrollBarUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

(defn get-preferred-size
  "A vertical scrollbar's preferred width is the maximum of
   preferred widths of the (non null)
   increment/decrement buttons,
   and the minimum width of the thumb. The preferred height is the
   sum of the preferred heights of the same parts.  The basis for
   the preferred size of a horizontal scrollbar is similar.

   The preferredSize is only computed once, subsequent
   calls to this method just return a cached size.

  c - the JScrollBar that's delegating this method to us - `javax.swing.JComponent`

  returns: the preferred size of a Basic JScrollBar - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.synth.SynthScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn property-change
  "Description copied from interface: PropertyChangeListener

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.synth.SynthScrollBarUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

