(ns javax.swing.plaf.metal.MetalComboBoxUI
  "Metal UI for JComboBox

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalComboBoxUI]))

(defn ->metal-combo-box-ui
  "Constructor."
  ([]
    (new MetalComboBoxUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalComboBoxUI/createUI c)))

(defn get-minimum-size
  "Description copied from class: BasicComboBoxUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMinimumSize c))))

(defn paint-current-value
  "If necessary paints the currently selected item.

  g - Graphics to paint to - `java.awt.Graphics`
  bounds - Region to paint current value to - `java.awt.Rectangle`
  has-focus - whether or not the JComboBox has focus - `boolean`

  throws: java.lang.NullPointerException - if any of the arguments are null."
  ([this g bounds has-focus]
    (-> this (.paintCurrentValue g bounds has-focus))))

(defn create-property-change-listener
  "Description copied from class: BasicComboBoxUI

  returns: an instance of a PropertyChangeListener or null - `java.beans.PropertyChangeListener`"
  ([this]
    (-> this (.createPropertyChangeListener))))

(defn configure-editor
  "Description copied from class: BasicComboBoxUI"
  ([this]
    (-> this (.configureEditor))))

(defn layout-combo-box
  "parent - `java.awt.Container`
  manager - `javax.swing.plaf.metal.MetalComboBoxUI.MetalComboBoxLayoutManager`"
  ([this parent manager]
    (-> this (.layoutComboBox parent manager))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this g c]
    (-> this (.paint g c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  ([this c width height]
    (-> this (.getBaseline c width height))))

(defn paint-current-value-background
  "If necessary paints the background of the currently selected item.

  g - Graphics to paint to - `java.awt.Graphics`
  bounds - Region to paint background to - `java.awt.Rectangle`
  has-focus - whether or not the JComboBox has focus - `boolean`

  throws: java.lang.NullPointerException - if any of the arguments are null."
  ([this g bounds has-focus]
    (-> this (.paintCurrentValueBackground g bounds has-focus))))

(defn unconfigure-editor
  "Description copied from class: BasicComboBoxUI"
  ([this]
    (-> this (.unconfigureEditor))))

