(ns javax.swing.text.Keymap
  "A collection of bindings of KeyStrokes to actions.  The
  bindings are basically name-value pairs that potentially
  resolve in a hierarchy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Keymap]))

(defn get-default-action
  "Fetches the default action to fire if a
   key is typed (i.e. a KEY_TYPED KeyEvent is received)
   and there is no binding for it.  Typically this
   would be some action that inserts text so that
   the keymap doesn't require an action for each
   possible key.

  returns: the default action - `javax.swing.Action`"
  (^javax.swing.Action [^Keymap this]
    (-> this (.getDefaultAction))))

(defn remove-key-stroke-binding
  "Removes a binding from the keymap.

  keys - the key sequence - `javax.swing.KeyStroke`"
  ([^Keymap this ^javax.swing.KeyStroke keys]
    (-> this (.removeKeyStrokeBinding keys))))

(defn get-bound-actions
  "Fetches all of the actions defined in this keymap.

  returns: the list of actions - `javax.swing.Action[]`"
  ([^Keymap this]
    (-> this (.getBoundActions))))

(defn remove-bindings
  "Removes all bindings from the keymap."
  ([^Keymap this]
    (-> this (.removeBindings))))

(defn set-resolve-parent
  "Sets the parent keymap, which will be used to
   resolve key-bindings.
   The behavior is unspecified if a Keymap has itself
   as one of its resolve parents.

  parent - the parent keymap - `javax.swing.text.Keymap`"
  ([^Keymap this ^javax.swing.text.Keymap parent]
    (-> this (.setResolveParent parent))))

(defn get-action
  "Fetches the action appropriate for the given symbolic
   event sequence.  This is used by JTextController to
   determine how to interpret key sequences.  If the
   binding is not resolved locally, an attempt is made
   to resolve through the parent keymap, if one is set.

  key - the key sequence - `javax.swing.KeyStroke`

  returns: the action associated with the key
    sequence if one is defined, otherwise null - `javax.swing.Action`"
  (^javax.swing.Action [^Keymap this ^javax.swing.KeyStroke key]
    (-> this (.getAction key))))

(defn get-resolve-parent
  "Fetches the parent keymap used to resolve key-bindings.

  returns: the keymap - `javax.swing.text.Keymap`"
  (^javax.swing.text.Keymap [^Keymap this]
    (-> this (.getResolveParent))))

(defn get-name
  "Fetches the name of the set of key-bindings.

  returns: the name - `java.lang.String`"
  (^java.lang.String [^Keymap this]
    (-> this (.getName))))

(defn add-action-for-key-stroke
  "Adds a binding to the keymap.

  key - the key sequence - `javax.swing.KeyStroke`
  a - the action - `javax.swing.Action`"
  ([^Keymap this ^javax.swing.KeyStroke key ^javax.swing.Action a]
    (-> this (.addActionForKeyStroke key a))))

(defn get-key-strokes-for-action
  "Fetches the keystrokes that will result in
   the given action.

  a - the action - `javax.swing.Action`

  returns: the list of keystrokes - `javax.swing.KeyStroke[]`"
  ([^Keymap this ^javax.swing.Action a]
    (-> this (.getKeyStrokesForAction a))))

(defn locally-defined?
  "Determines if the given key sequence is locally defined.

  key - the key sequence - `javax.swing.KeyStroke`

  returns: true if the key sequence is locally defined else false - `boolean`"
  (^Boolean [^Keymap this ^javax.swing.KeyStroke key]
    (-> this (.isLocallyDefined key))))

(defn set-default-action
  "Set the default action to fire if a key is typed.

  a - the action - `javax.swing.Action`"
  ([^Keymap this ^javax.swing.Action a]
    (-> this (.setDefaultAction a))))

(defn get-bound-key-strokes
  "Fetches all of the keystrokes in this map that
   are bound to some action.

  returns: the list of keystrokes - `javax.swing.KeyStroke[]`"
  ([^Keymap this]
    (-> this (.getBoundKeyStrokes))))

