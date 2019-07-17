(ns javax.swing.JComboBox$KeySelectionManager
  "The interface that defines a KeySelectionManager.
  To qualify as a KeySelectionManager,
  the class needs to implement the method
  that identifies the list index given a character and the
  combo box data model."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JComboBox$KeySelectionManager]))

(defn selection-for-key
  "Given aKey and the model, returns the row
    that should become selected. Return -1 if no match was
    found.

  a-key - a char value, usually indicating a keyboard key that was pressed - `char`
  a-model - a ComboBoxModel -- the component's data model, containing the list of selectable items - `javax.swing.ComboBoxModel`

  returns: an int equal to the selected row, where 0 is the
           first item and -1 is none. - `int`"
  ([^javax.swing.JComboBox$KeySelectionManager this ^Character a-key ^javax.swing.ComboBoxModel a-model]
    (-> this (.selectionForKey a-key a-model))))

