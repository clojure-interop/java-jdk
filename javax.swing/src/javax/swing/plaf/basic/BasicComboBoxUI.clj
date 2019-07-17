(ns javax.swing.plaf.basic.BasicComboBoxUI
  "Basic UI implementation for JComboBox.

  The combo box is a compound component which means that it is an aggregate of
  many simpler components. This class creates and manages the listeners
  on the combo box and the combo box model. These listeners update the user
  interface in response to changes in the properties and state of the combo box.

  All event handling is handled by listener classes created with the
  createxxxListener() methods and internal classes.
  You can change the behavior of this class by overriding the
  createxxxListener() methods and supplying your own
  event listeners or subclassing from the ones supplied in this class.

  For adding specific actions,
  overide installKeyboardActions to add actions in response to
  KeyStroke bindings. See the article How to Use Key Bindings"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicComboBoxUI]))

(defn ->basic-combo-box-ui
  "Constructor."
  ([]
    (new BasicComboBoxUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (BasicComboBoxUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "The minimum size is the size of the display area plus insets plus the button.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMinimumSize c))))

(defn unconfigure-arrow-button
  "This public method is implementation specific and should be private. Do
   not call or override."
  ([this]
    (-> this (.unconfigureArrowButton))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMaximumSize c))))

(defn get-accessible-child
  "Description copied from class: ComponentUI

  c - `javax.swing.JComponent`
  i - `int`

  returns: the ith Accessible child of the object - `javax.accessibility.Accessible`"
  ([this c i]
    (-> this (.getAccessibleChild c i))))

(defn paint-current-value
  "Paints the currently selected item.

  g - `java.awt.Graphics`
  bounds - `java.awt.Rectangle`
  has-focus - `boolean`"
  ([this g bounds has-focus]
    (-> this (.paintCurrentValue g bounds has-focus))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

(defn add-editor
  "This public method is implementation specific and should be private.
   do not call or override. To implement a specific editor create a
   custom ComboBoxEditor"
  ([this]
    (-> this (.addEditor))))

(defn configure-arrow-button
  "This public method is implementation specific and should be private. Do
   not call or override."
  ([this]
    (-> this (.configureArrowButton))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([this c]
    (-> this (.getBaselineResizeBehavior c))))

(defn remove-editor
  "This public method is implementation specific and should be private.
   do not call or override."
  ([this]
    (-> this (.removeEditor))))

(defn focus-traversable?
  "Determines if the JComboBox is focus traversable.  If the JComboBox is editable
   this returns false, otherwise it returns true.

  c - `javax.swing.JComboBox`

  returns: `boolean`"
  ([this c]
    (-> this (.isFocusTraversable c))))

(defn get-accessible-children-count
  "Description copied from class: ComponentUI

  c - `javax.swing.JComponent`

  returns: the number of accessible children in the object - `int`"
  ([this c]
    (-> this (.getAccessibleChildrenCount c))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this g c]
    (-> this (.paint g c))))

(defn set-popup-visible
  "Hides the popup.

  c - `javax.swing.JComboBox`
  v - `boolean`"
  ([this c v]
    (-> this (.setPopupVisible c v))))

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
  "Paints the background of the currently selected item.

  g - `java.awt.Graphics`
  bounds - `java.awt.Rectangle`
  has-focus - `boolean`"
  ([this g bounds has-focus]
    (-> this (.paintCurrentValueBackground g bounds has-focus))))

(defn popup-visible?
  "Tells if the popup is visible or not.

  c - `javax.swing.JComboBox`

  returns: `boolean`"
  ([this c]
    (-> this (.isPopupVisible c))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([this c]
    (-> this (.getPreferredSize c))))

