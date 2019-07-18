(ns javax.swing.plaf.basic.BasicTableUI
  "BasicTableUI implementation"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTableUI]))

(defn ->basic-table-ui
  "Constructor."
  (^BasicTableUI []
    (new BasicTableUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicTableUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^BasicTableUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component$BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component$BaselineResizeBehavior [^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn get-minimum-size
  "Return the minimum size of the table. The minimum height is the
   row height times the number of rows.
   The minimum width is the sum of the minimum widths of each column.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-preferred-size
  "Return the preferred size of the table. The preferred height is the
   row height times the number of rows.
   The preferred width is the sum of the preferred widths of each column.

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-maximum-size
  "Return the maximum size of the table. The maximum height is the
   row heighttimes the number of rows.
   The maximum width is the sum of the maximum widths of each column.

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicTableUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn paint
  "Paint a representation of the table instance
   that was set in installUI().

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicTableUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

