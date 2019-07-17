(ns javax.swing.plaf.basic.BasicTextFieldUI
  "Basis of a look and feel for a JTextField.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTextFieldUI]))

(defn ->basic-text-field-ui
  "Constructor.

  Creates a new BasicTextFieldUI."
  ([]
    (new BasicTextFieldUI )))

(defn *create-ui
  "Creates a UI for a JTextField.

  c - the text field - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicTextFieldUI/createUI c)))

(defn create
  "Creates a view (FieldView) based on an element.

  elem - the element - `javax.swing.text.Element`

  returns: the view - `javax.swing.text.View`"
  (^javax.swing.text.View [^javax.swing.plaf.basic.BasicTextFieldUI this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.basic.BasicTextFieldUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component.BaselineResizeBehavior [^javax.swing.plaf.basic.BasicTextFieldUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

