(ns jdk.beans.beancontext.BeanContextContainerProxy
  " This interface is implemented by BeanContexts' that have an AWT Container
  associated with them."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextContainerProxy]))

(defn get-container
  "Gets the java.awt.Container associated
   with this BeanContext.

  returns: the java.awt.Container associated
   with this BeanContext. - `java.awt.Container`"
  (^java.awt.Container [^BeanContextContainerProxy this]
    (-> this (.getContainer))))

