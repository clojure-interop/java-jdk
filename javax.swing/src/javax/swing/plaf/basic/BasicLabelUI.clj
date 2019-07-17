(ns javax.swing.plaf.basic.BasicLabelUI
  "A Windows L&F implementation of LabelUI.  This implementation
  is completely static, i.e. there's only one UIView implementation
  that's shared by all JLabel objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicLabelUI]))

(defn ->basic-label-ui
  "Constructor."
  ([]
    (new BasicLabelUI )))

(defn *create-ui
  "Returns an instance of BasicLabelUI.

  c - a component - `javax.swing.JComponent`

  returns: an instance of BasicLabelUI - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicLabelUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: getPreferredSize(c) - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: getPreferredSize(c) - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component.BaselineResizeBehavior [^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn property-change
  "Description copied from interface: PropertyChangeListener

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.basic.BasicLabelUI this ^java.beans.PropertyChangeEvent e]
    (-> this (.propertyChange e))))

(defn paint
  "Paints the label text with the foreground color, if the label is opaque
   then paints the entire background with the background color. The Label
   text is drawn by paintEnabledText(javax.swing.JLabel, java.awt.Graphics, java.lang.String, int, int) or paintDisabledText(javax.swing.JLabel, java.awt.Graphics, java.lang.String, int, int).
   The locations of the label parts are computed by layoutCL(javax.swing.JLabel, java.awt.FontMetrics, java.lang.String, javax.swing.Icon, java.awt.Rectangle, java.awt.Rectangle, java.awt.Rectangle).

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicLabelUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicLabelUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

