(ns javax.swing.plaf.basic.BasicTableHeaderUI
  "BasicTableHeaderUI implementation"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTableHeaderUI]))

(defn ->basic-table-header-ui
  "Constructor."
  ([]
    (new BasicTableHeaderUI )))

(defn *create-ui
  "h - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent h]
    (BasicTableHeaderUI/createUI h)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTableHeaderUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-minimum-size
  "Return the minimum size of the header. The minimum width is the sum
   of the minimum widths of each column (plus inter-cell spacing).

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-preferred-size
  "Return the preferred size of the header. The preferred height is the
   maximum of the preferred heights of all of the components provided
   by the header renderers. The preferred width is the sum of the
   preferred widths of each column (plus inter-cell spacing).

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-maximum-size
  "Return the maximum size of the header. The maximum width is the sum
   of the maximum widths of each column (plus inter-cell spacing).

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTableHeaderUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

