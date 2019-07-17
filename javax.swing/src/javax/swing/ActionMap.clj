(ns javax.swing.ActionMap
  "ActionMap provides mappings from
  Objects
  (called keys or Action names)
  to Actions.
  An ActionMap is usually used with an InputMap
  to locate a particular action
  when a key is pressed. As with InputMap,
  an ActionMap can have a parent
  that is searched for keys not defined in the ActionMap.
  As with InputMap if you create a cycle, eg:


    ActionMap am = new ActionMap();
    ActionMap bm = new ActionMap():
    am.setParent(bm);
    bm.setParent(am);
  some of the methods will cause a StackOverflowError to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ActionMap]))

(defn ->action-map
  "Constructor.

  Creates an ActionMap with no parent and no mappings."
  ([]
    (new ActionMap )))

(defn set-parent
  "Sets this ActionMap's parent.

  map - the ActionMap that is the parent of this one - `javax.swing.ActionMap`"
  ([this map]
    (-> this (.setParent map))))

(defn keys
  "Returns the Action names that are bound in this ActionMap.

  returns: `java.lang.Object[]`"
  ([this]
    (-> this (.keys))))

(defn all-keys
  "Returns an array of the keys defined in this ActionMap and
   its parent. This method differs from keys() in that
   this method includes the keys defined in the parent.

  returns: `java.lang.Object[]`"
  ([this]
    (-> this (.allKeys))))

(defn put
  "Adds a binding for key to action.
   If action is null, this removes the current binding
   for key.
   In most instances, key will be
   action.getValue(NAME).

  key - `java.lang.Object`
  action - `javax.swing.Action`"
  ([this key action]
    (-> this (.put key action))))

(defn get-parent
  "Returns this ActionMap's parent.

  returns: the ActionMap that is the parent of this one,
           or null if this ActionMap has no parent - `javax.swing.ActionMap`"
  ([this]
    (-> this (.getParent))))

(defn remove
  "Removes the binding for key from this ActionMap.

  key - `java.lang.Object`"
  ([this key]
    (-> this (.remove key))))

(defn size
  "Returns the number of bindings in this ActionMap.

  returns: the number of bindings in this ActionMap - `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all the mappings from this ActionMap."
  ([this]
    (-> this (.clear))))

(defn get
  "Returns the binding for key, messaging the
   parent ActionMap if the binding is not locally defined.

  key - `java.lang.Object`

  returns: `javax.swing.Action`"
  ([this key]
    (-> this (.get key))))

