(ns javax.swing.undo.StateEdit
  "StateEdit is a general edit for objects that change state.
  Objects being edited must conform to the StateEditable interface.

  This edit class works by asking an object to store it's state in
  Hashtables before and after editing occurs.  Upon undo or redo the
  object is told to restore it's state from these Hashtables.

  A state edit is used as follows:


       // Create the edit during the `before` state of the object
       StateEdit newEdit = new StateEdit(myObject);
       // Modify the object
       myObject.someStateModifyingMethod();
       // `end` the edit when you are done modifying the object
       newEdit.end();

  Note that when a StateEdit ends, it removes redundant state from
  the Hashtables - A state Hashtable is not guaranteed to contain all
  keys/values placed into it when the state is stored!"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo StateEdit]))

(defn ->state-edit
  "Constructor.

  Create and return a new StateEdit with a presentation name.

  an-object - The object to watch for changing state - `javax.swing.undo.StateEditable`
  name - The presentation name to be used for this edit - `java.lang.String`"
  ([^javax.swing.undo.StateEditable an-object ^java.lang.String name]
    (new StateEdit an-object name))
  ([^javax.swing.undo.StateEditable an-object]
    (new StateEdit an-object)))

(defn end
  "Gets the post-edit state of the StateEditable object and
   ends the edit."
  ([^javax.swing.undo.StateEdit this]
    (-> this (.end))))

(defn undo
  "Tells the edited object to apply the state prior to the edit"
  ([^javax.swing.undo.StateEdit this]
    (-> this (.undo))))

(defn redo
  "Tells the edited object to apply the state after the edit"
  ([^javax.swing.undo.StateEdit this]
    (-> this (.redo))))

(defn get-presentation-name
  "Gets the presentation name for this edit

  returns: the empty string `` - `java.lang.String`"
  (^java.lang.String [^javax.swing.undo.StateEdit this]
    (-> this (.getPresentationName))))

