(ns javax.swing.JSpinner$NumberEditor
  "An editor for a JSpinner whose model is a
  SpinnerNumberModel.  The value of the editor is
  displayed with a JFormattedTextField whose format
  is defined by a NumberFormatter instance whose
  minimum and maximum properties
  are mapped to the SpinnerNumberModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSpinner$NumberEditor]))

(defn ->number-editor
  "Constructor.

  Construct a JSpinner editor that supports displaying
   and editing the value of a SpinnerNumberModel
   with a JFormattedTextField.  This
   NumberEditor becomes both a ChangeListener
   on the spinner and a PropertyChangeListener
   on the new JFormattedTextField.

  spinner - the spinner whose model this editor will monitor - `javax.swing.JSpinner`
  decimal-format-pattern - the initial pattern for the DecimalFormat object that's used to display and parse the value of the text field. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the spinners model is not an instance of SpinnerNumberModel or if decimalFormatPattern is not a legal argument to DecimalFormat"
  (^JSpinner$NumberEditor [^javax.swing.JSpinner spinner ^java.lang.String decimal-format-pattern]
    (new JSpinner$NumberEditor spinner decimal-format-pattern))
  (^JSpinner$NumberEditor [^javax.swing.JSpinner spinner]
    (new JSpinner$NumberEditor spinner)))

(defn get-format
  "Returns the java.text.DecimalFormat object the
   JFormattedTextField uses to parse and format
   numbers.

  returns: the value of getTextField().getFormatter().getFormat(). - `java.text.DecimalFormat`"
  (^java.text.DecimalFormat [^JSpinner$NumberEditor this]
    (-> this (.getFormat))))

(defn get-model
  "Return our spinner ancestor's SpinnerNumberModel.

  returns: getSpinner().getModel() - `javax.swing.SpinnerNumberModel`"
  (^javax.swing.SpinnerNumberModel [^JSpinner$NumberEditor this]
    (-> this (.getModel))))

