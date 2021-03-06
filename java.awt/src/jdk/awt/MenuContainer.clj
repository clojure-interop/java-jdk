(ns jdk.awt.MenuContainer
  "The super class of all menu related containers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuContainer]))

(defn get-font
  "returns: `java.awt.Font`"
  (^java.awt.Font [^MenuContainer this]
    (-> this (.getFont))))

(defn remove
  "comp - `java.awt.MenuComponent`"
  ([^MenuContainer this ^java.awt.MenuComponent comp]
    (-> this (.remove comp))))

(defn post-event
  "Deprecated. As of JDK version 1.1
   replaced by dispatchEvent(AWTEvent).

  evt - `java.awt.Event`

  returns: `boolean`"
  (^Boolean [^MenuContainer this ^java.awt.Event evt]
    (-> this (.postEvent evt))))

