(ns javax.swing.ComponentInputMap
  "A ComponentInputMap is an InputMap
  associated with a particular JComponent.
  The component is automatically notified whenever
  the ComponentInputMap changes.
  ComponentInputMaps are used for
  WHEN_IN_FOCUSED_WINDOW bindings."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ComponentInputMap]))

(defn ->component-input-map
  "Constructor.

  Creates a ComponentInputMap associated with the
   specified component.

  component - a non-null JComponent - `javax.swing.JComponent`

  throws: java.lang.IllegalArgumentException - if component is null"
  ([^javax.swing.JComponent component]
    (new ComponentInputMap component)))

(defn set-parent
  "Sets the parent, which must be a ComponentInputMap
   associated with the same component as this
   ComponentInputMap.

  map - a ComponentInputMap - `javax.swing.InputMap`

  throws: java.lang.IllegalArgumentException - if map is not a ComponentInputMap or is not associated with the same component"
  ([^javax.swing.ComponentInputMap this ^javax.swing.InputMap map]
    (-> this (.setParent map))))

(defn get-component
  "Returns the component the InputMap was created for.

  returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.ComponentInputMap this]
    (-> this (.getComponent))))

(defn put
  "Adds a binding for keyStroke to actionMapKey.
   If actionMapKey is null, this removes the current binding
   for keyStroke.

  key-stroke - `javax.swing.KeyStroke`
  action-map-key - `java.lang.Object`"
  ([^javax.swing.ComponentInputMap this ^javax.swing.KeyStroke key-stroke ^java.lang.Object action-map-key]
    (-> this (.put key-stroke action-map-key))))

(defn remove
  "Removes the binding for key from this object.

  key - `javax.swing.KeyStroke`"
  ([^javax.swing.ComponentInputMap this ^javax.swing.KeyStroke key]
    (-> this (.remove key))))

(defn clear
  "Removes all the mappings from this object."
  ([^javax.swing.ComponentInputMap this]
    (-> this (.clear))))

