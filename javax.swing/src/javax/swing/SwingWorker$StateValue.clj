(ns javax.swing.SwingWorker$StateValue
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SwingWorker$StateValue]))

(def PENDING
  "Enum Constant.

  Initial SwingWorker state.

  type: javax.swing.SwingWorker.StateValue"
  SwingWorker$StateValue/PENDING)

(def STARTED
  "Enum Constant.

  SwingWorker is STARTED
   before invoking doInBackground.

  type: javax.swing.SwingWorker.StateValue"
  SwingWorker$StateValue/STARTED)

(def DONE
  "Enum Constant.

  SwingWorker is DONE
   after doInBackground method
   is finished.

  type: javax.swing.SwingWorker.StateValue"
  SwingWorker$StateValue/DONE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SwingWorker.StateValue c : SwingWorker.StateValue.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.SwingWorker.StateValue[]`"
  ([]
    (SwingWorker$StateValue/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.SwingWorker.StateValue`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (SwingWorker$StateValue/valueOf name)))

