(ns jdk.util.prefs.NodeChangeListener
  "A listener for receiving preference node change events."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs NodeChangeListener]))

(defn child-added
  "This method gets called when a child node is added.

  evt - A node change event object describing the parent and child node. - `java.util.prefs.NodeChangeEvent`"
  ([^NodeChangeListener this ^java.util.prefs.NodeChangeEvent evt]
    (-> this (.childAdded evt))))

(defn child-removed
  "This method gets called when a child node is removed.

  evt - A node change event object describing the parent and child node. - `java.util.prefs.NodeChangeEvent`"
  ([^NodeChangeListener this ^java.util.prefs.NodeChangeEvent evt]
    (-> this (.childRemoved evt))))

