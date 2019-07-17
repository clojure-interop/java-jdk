(ns javax.swing.plaf.basic.BasicSliderUI
  "A Basic L&F implementation of SliderUI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicSliderUI]))

(defn ->basic-slider-ui
  "Constructor.

  b - `javax.swing.JSlider`"
  ([^javax.swing.JSlider b]
    (new BasicSliderUI b)))

(def *-positive-scroll
  "Static Constant.

  type: int"
  BasicSliderUI/POSITIVE_SCROLL)

(def *-negative-scroll
  "Static Constant.

  type: int"
  BasicSliderUI/NEGATIVE_SCROLL)

(def *-min-scroll
  "Static Constant.

  type: int"
  BasicSliderUI/MIN_SCROLL)

(def *-max-scroll
  "Static Constant.

  type: int"
  BasicSliderUI/MAX_SCROLL)

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent b]
    (BasicSliderUI/createUI b)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn paint-track
  "g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g]
    (-> this (.paintTrack g))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn paint-focus
  "g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g]
    (-> this (.paintFocus g))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-preferred-horizontal-size
  "returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this]
    (-> this (.getPreferredHorizontalSize))))

(defn value-for-y-position
  "Returns the value at the y position. If yPos is beyond the
   track at the the bottom or the top, this method sets the value to either
   the minimum or maximum value of the slider, depending on if the slider
   is inverted or not.

  y-pos - `int`

  returns: `int`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^Integer y-pos]
    (-> this (.valueForYPosition y-pos))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn value-for-x-position
  "Returns the value at the x position.  If xPos is beyond the
   track at the left or the right, this method sets the value to either the
   minimum or maximum value of the slider, depending on if the slider is
   inverted or not.

  x-pos - `int`

  returns: `int`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^Integer x-pos]
    (-> this (.valueForXPosition x-pos))))

(defn set-thumb-location
  "x - `int`
  y - `int`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^Integer x ^Integer y]
    (-> this (.setThumbLocation x y))))

(defn get-minimum-horizontal-size
  "returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this]
    (-> this (.getMinimumHorizontalSize))))

(defn scroll-by-block
  "direction - `int`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^Integer direction]
    (-> this (.scrollByBlock direction))))

(defn scroll-by-unit
  "direction - `int`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^Integer direction]
    (-> this (.scrollByUnit direction))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn paint-ticks
  "g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g]
    (-> this (.paintTicks g))))

(defn get-preferred-vertical-size
  "returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this]
    (-> this (.getPreferredVerticalSize))))

(defn paint-labels
  "g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g]
    (-> this (.paintLabels g))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn paint-thumb
  "g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^java.awt.Graphics g]
    (-> this (.paintThumb g))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-minimum-vertical-size
  "returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicSliderUI this]
    (-> this (.getMinimumVerticalSize))))

