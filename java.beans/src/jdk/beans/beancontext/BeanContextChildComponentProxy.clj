(ns jdk.beans.beancontext.BeanContextChildComponentProxy
  " This interface is implemented by
  BeanContextChildren that have an AWT Component
  associated with them."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextChildComponentProxy]))

(defn get-component
  "Gets the java.awt.Component associated with
   this BeanContextChild.

  returns: the AWT Component associated with
   this BeanContextChild - `java.awt.Component`"
  (^java.awt.Component [^java.beans.beancontext.BeanContextChildComponentProxy this]
    (-> this (.getComponent))))

