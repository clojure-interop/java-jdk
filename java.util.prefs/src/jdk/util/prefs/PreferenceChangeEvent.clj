(ns jdk.util.prefs.PreferenceChangeEvent
  "An event emitted by a Preferences node to indicate that
  a preference has been added, removed or has had its value changed.

  Note, that although PreferenceChangeEvent inherits Serializable interface
  from EventObject, it is not intended to be Serializable. Appropriate
  serialization methods are implemented to throw NotSerializableException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs PreferenceChangeEvent]))

(defn ->preference-change-event
  "Constructor.

  Constructs a new PreferenceChangeEvent instance.

  node - The Preferences node that emitted the event. - `java.util.prefs.Preferences`
  key - The key of the preference that was changed. - `java.lang.String`
  new-value - The new value of the preference, or null if the preference is being removed. - `java.lang.String`"
  (^PreferenceChangeEvent [^java.util.prefs.Preferences node ^java.lang.String key ^java.lang.String new-value]
    (new PreferenceChangeEvent node key new-value)))

(defn get-node
  "Returns the preference node that emitted the event.

  returns: The preference node that emitted the event. - `java.util.prefs.Preferences`"
  (^java.util.prefs.Preferences [^PreferenceChangeEvent this]
    (-> this (.getNode))))

(defn get-key
  "Returns the key of the preference that was changed.

  returns: The key of the preference that was changed. - `java.lang.String`"
  (^java.lang.String [^PreferenceChangeEvent this]
    (-> this (.getKey))))

(defn get-new-value
  "Returns the new value for the preference.

  returns: The new value for the preference, or null if the
            preference was removed. - `java.lang.String`"
  (^java.lang.String [^PreferenceChangeEvent this]
    (-> this (.getNewValue))))

