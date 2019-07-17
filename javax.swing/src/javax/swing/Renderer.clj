(ns javax.swing.Renderer
  "Defines the requirements for an object responsible for
  `rendering` (displaying) a value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Renderer]))

(defn set-value
  "Specifies the value to display and whether or not the
   value should be portrayed as `currently selected`.

  a-value - an Object object - `java.lang.Object`
  is-selected - a boolean - `boolean`"
  ([^javax.swing.Renderer this ^java.lang.Object a-value ^Boolean is-selected]
    (-> this (.setValue a-value is-selected))))

(defn get-component
  "Returns the component used to render the value.

  returns: the Component responsible for displaying the value - `java.awt.Component`"
  ([^javax.swing.Renderer this]
    (-> this (.getComponent))))

