(ns javax.swing.JSpinner$DateEditor
  "An editor for a JSpinner whose model is a
  SpinnerDateModel.  The value of the editor is
  displayed with a JFormattedTextField whose format
  is defined by a DateFormatter instance whose
  minimum and maximum properties
  are mapped to the SpinnerDateModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSpinner$DateEditor]))

(defn ->date-editor
  "Constructor.

  Construct a JSpinner editor that supports displaying
   and editing the value of a SpinnerDateModel
   with a JFormattedTextField.  This
   DateEditor becomes both a ChangeListener
   on the spinner and a PropertyChangeListener
   on the new JFormattedTextField.

  spinner - the spinner whose model this editor will monitor - `javax.swing.JSpinner`
  date-format-pattern - the initial pattern for the SimpleDateFormat object that's used to display and parse the value of the text field. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the spinners model is not an instance of SpinnerDateModel"
  ([^javax.swing.JSpinner spinner ^java.lang.String date-format-pattern]
    (new JSpinner$DateEditor spinner date-format-pattern))
  ([^javax.swing.JSpinner spinner]
    (new JSpinner$DateEditor spinner)))

(defn get-format
  "Returns the java.text.SimpleDateFormat object the
   JFormattedTextField uses to parse and format
   numbers.

  returns: the value of getTextField().getFormatter().getFormat(). - `java.text.SimpleDateFormat`"
  (^java.text.SimpleDateFormat [^javax.swing.JSpinner$DateEditor this]
    (-> this (.getFormat))))

(defn get-model
  "Return our spinner ancestor's SpinnerDateModel.

  returns: getSpinner().getModel() - `javax.swing.SpinnerDateModel`"
  (^javax.swing.SpinnerDateModel [^javax.swing.JSpinner$DateEditor this]
    (-> this (.getModel))))

