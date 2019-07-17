(ns javax.swing.JSpinner$ListEditor
  "An editor for a JSpinner whose model is a
  SpinnerListModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSpinner$ListEditor]))

(defn ->list-editor
  "Constructor.

  Construct a JSpinner editor that supports displaying
   and editing the value of a SpinnerListModel
   with a JFormattedTextField.  This
   ListEditor becomes both a ChangeListener
   on the spinner and a PropertyChangeListener
   on the new JFormattedTextField.

  spinner - the spinner whose model this editor will monitor - `javax.swing.JSpinner`

  throws: java.lang.IllegalArgumentException - if the spinners model is not an instance of SpinnerListModel"
  ([^javax.swing.JSpinner spinner]
    (new JSpinner$ListEditor spinner)))

(defn get-model
  "Return our spinner ancestor's SpinnerNumberModel.

  returns: getSpinner().getModel() - `javax.swing.SpinnerListModel`"
  ([^javax.swing.JSpinner$ListEditor this]
    (-> this (.getModel))))

