(ns jdk.awt.MenuContainer
  "The super class of all menu related containers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuContainer]))

(defn get-font
  "returns: `java.awt.Font`"
  ([this]
    (-> this (.getFont))))

(defn remove
  "comp - `java.awt.MenuComponent`"
  ([this comp]
    (-> this (.remove comp))))

(defn post-event
  "Deprecated. As of JDK version 1.1
   replaced by dispatchEvent(AWTEvent).

  evt - `java.awt.Event`

  returns: `java.lang. boolean`"
  ([this evt]
    (-> this (.postEvent evt))))

