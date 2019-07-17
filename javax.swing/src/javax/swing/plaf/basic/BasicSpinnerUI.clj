(ns javax.swing.plaf.basic.BasicSpinnerUI
  "The default Spinner UI delegate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicSpinnerUI]))

(defn ->basic-spinner-ui
  "Constructor."
  ([]
    (new BasicSpinnerUI )))

(defn *create-ui
  "Returns a new instance of BasicSpinnerUI.  SpinnerListUI
   delegates are allocated one per JSpinner.

  c - the JSpinner (not used) - `javax.swing.JComponent`

  returns: a new BasicSpinnerUI object - `javax.swing.plaf.ComponentUI`"
  ([c]
    (BasicSpinnerUI/createUI c)))

(defn install-ui
  "Calls installDefaults, installListeners,
   and then adds the components returned by createNextButton,
   createPreviousButton, and createEditor.

  c - the JSpinner - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Calls uninstallDefaults, uninstallListeners,
   and then removes all of the spinners children.

  c - the JSpinner (not used) - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

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

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([this c]
    (-> this (.getBaselineResizeBehavior c))))

