(ns javax.swing.InputMap
  "InputMap provides a binding between an input event
  (currently only KeyStrokes are used)
  and an Object. InputMaps
  are usually used with an ActionMap,
  to determine an Action to perform
  when a key is pressed.
  An InputMap can have a parent
  that is searched for bindings not defined in the InputMap.
  As with ActionMap if you create a cycle, eg:


    InputMap am = new InputMap();
    InputMap bm = new InputMap():
    am.setParent(bm);
    bm.setParent(am);
  some of the methods will cause a StackOverflowError to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing InputMap]))

(defn ->input-map
  "Constructor.

  Creates an InputMap with no parent and no mappings."
  ([]
    (new InputMap )))

(defn set-parent
  "Sets this InputMap's parent.

  map - the InputMap that is the parent of this one - `javax.swing.InputMap`"
  ([this map]
    (-> this (.setParent map))))

(defn keys
  "Returns the KeyStrokes that are bound in this InputMap.

  returns: `javax.swing.KeyStroke[]`"
  ([this]
    (-> this (.keys))))

(defn all-keys
  "Returns an array of the KeyStrokes defined in this
   InputMap and its parent. This differs from keys() in that
   this method includes the keys defined in the parent.

  returns: `javax.swing.KeyStroke[]`"
  ([this]
    (-> this (.allKeys))))

(defn put
  "Adds a binding for keyStroke to actionMapKey.
   If actionMapKey is null, this removes the current binding
   for keyStroke.

  key-stroke - `javax.swing.KeyStroke`
  action-map-key - `java.lang.Object`"
  ([this key-stroke action-map-key]
    (-> this (.put key-stroke action-map-key))))

(defn get-parent
  "Gets this InputMap's parent.

  returns: map  the InputMap that is the parent of this one,
                or null if this InputMap has no parent - `javax.swing.InputMap`"
  ([this]
    (-> this (.getParent))))

(defn remove
  "Removes the binding for key from this
   InputMap.

  key - `javax.swing.KeyStroke`"
  ([this key]
    (-> this (.remove key))))

(defn size
  "Returns the number of KeyStroke bindings.

  returns: `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all the mappings from this InputMap."
  ([this]
    (-> this (.clear))))

(defn get
  "Returns the binding for keyStroke, messaging the
   parent InputMap if the binding is not locally defined.

  key-stroke - `javax.swing.KeyStroke`

  returns: `java.lang.Object`"
  ([this key-stroke]
    (-> this (.get key-stroke))))

