(ns jdk.util.EventObject
  " The root class from which all event state objects shall be derived.

  All Events are constructed with a reference to the object, the `source`,
  that is logically deemed to be the object upon which the Event in question
  initially occurred upon."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util EventObject]))

(defn ->event-object
  "Constructor.

  Constructs a prototypical Event.

  source - The object on which the Event initially occurred. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if source is null."
  ([^java.lang.Object source]
    (new EventObject source)))

(defn get-source
  "The object on which the Event initially occurred.

  returns: The object on which the Event initially occurred. - `java.lang.Object`"
  ([^java.util.EventObject this]
    (-> this (.getSource))))

(defn to-string
  "Returns a String representation of this EventObject.

  returns: A a String representation of this EventObject. - `java.lang.String`"
  ([^java.util.EventObject this]
    (-> this (.toString))))

