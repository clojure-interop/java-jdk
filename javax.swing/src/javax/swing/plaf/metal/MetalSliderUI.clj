(ns javax.swing.plaf.metal.MetalSliderUI
  "A Java L&F implementation of SliderUI.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalSliderUI]))

(defn ->metal-slider-ui
  "Constructor."
  (^MetalSliderUI []
    (new MetalSliderUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalSliderUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^MetalSliderUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn paint-thumb
  "g - `java.awt.Graphics`"
  ([^MetalSliderUI this ^java.awt.Graphics g]
    (-> this (.paintThumb g))))

(defn paint-track
  "g - `java.awt.Graphics`"
  ([^MetalSliderUI this ^java.awt.Graphics g]
    (-> this (.paintTrack g))))

(defn paint-focus
  "g - `java.awt.Graphics`"
  ([^MetalSliderUI this ^java.awt.Graphics g]
    (-> this (.paintFocus g))))

(defn get-tick-length
  "Gets the height of the tick area for horizontal sliders and the width of the
   tick area for vertical sliders.  BasicSliderUI uses the returned value to
   determine the tick area rectangle.

  returns: `int`"
  (^Integer [^MetalSliderUI this]
    (-> this (.getTickLength))))

