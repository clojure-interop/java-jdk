(ns javax.swing.JFormattedTextField$AbstractFormatterFactory
  "Instances of AbstractFormatterFactory are used by
  JFormattedTextField to obtain instances of
  AbstractFormatter which in turn are used to format values.
  AbstractFormatterFactory can return different
  AbstractFormatters based on the state of the
  JFormattedTextField, perhaps returning different
  AbstractFormatters when the
  JFormattedTextField has focus vs when it
  doesn't have focus."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JFormattedTextField$AbstractFormatterFactory]))

(defn ->abstract-formatter-factory
  "Constructor."
  ([]
    (new JFormattedTextField$AbstractFormatterFactory )))

(defn get-formatter
  "Returns an AbstractFormatter that can handle formatting
   of the passed in JFormattedTextField.

  tf - JFormattedTextField requesting AbstractFormatter - `javax.swing.JFormattedTextField`

  returns: AbstractFormatter to handle formatting duties, a null
           return value implies the JFormattedTextField should behave
           like a normal JTextField - `javax.swing.JFormattedTextField.AbstractFormatter`"
  (^javax.swing.JFormattedTextField.AbstractFormatter [^javax.swing.JFormattedTextField$AbstractFormatterFactory this ^javax.swing.JFormattedTextField tf]
    (-> this (.getFormatter tf))))

