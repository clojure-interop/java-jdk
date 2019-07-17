(ns jdk.util.prefs.NodeChangeEvent
  "An event emitted by a Preferences node to indicate that
  a child of that node has been added or removed.

  Note, that although NodeChangeEvent inherits Serializable interface from
  java.util.EventObject, it is not intended to be Serializable. Appropriate
  serialization methods are implemented to throw NotSerializableException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs NodeChangeEvent]))

(defn ->node-change-event
  "Constructor.

  Constructs a new NodeChangeEvent instance.

  parent - The parent of the node that was added or removed. - `java.util.prefs.Preferences`
  child - The node that was added or removed. - `java.util.prefs.Preferences`"
  ([^java.util.prefs.Preferences parent ^java.util.prefs.Preferences child]
    (new NodeChangeEvent parent child)))

(defn get-parent
  "Returns the parent of the node that was added or removed.

  returns: The parent Preferences node whose child was added or removed - `java.util.prefs.Preferences`"
  (^java.util.prefs.Preferences [^java.util.prefs.NodeChangeEvent this]
    (-> this (.getParent))))

(defn get-child
  "Returns the node that was added or removed.

  returns: The node that was added or removed. - `java.util.prefs.Preferences`"
  (^java.util.prefs.Preferences [^java.util.prefs.NodeChangeEvent this]
    (-> this (.getChild))))

