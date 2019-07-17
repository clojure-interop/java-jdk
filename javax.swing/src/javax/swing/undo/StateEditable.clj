(ns javax.swing.undo.StateEditable
  "StateEditable defines the interface for objects that can have
  their state undone/redone by a StateEdit."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo StateEditable]))

(defn store-state
  "Upon receiving this message the receiver should place any relevant
   state into state.

  state - `java.util.Hashtable<java.lang.Object,java.lang.Object>`"
  ([this state]
    (-> this (.storeState state))))

(defn restore-state
  "Upon receiving this message the receiver should extract any relevant
   state out of state.

  state - `java.util.Hashtable<?,?>`"
  ([this state]
    (-> this (.restoreState state))))

