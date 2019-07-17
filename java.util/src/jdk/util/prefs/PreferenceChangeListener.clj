(ns jdk.util.prefs.PreferenceChangeListener
  "A listener for receiving preference change events."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs PreferenceChangeListener]))

(defn preference-change
  "This method gets called when a preference is added, removed or when
   its value is changed.

  evt - A PreferenceChangeEvent object describing the event source and the preference that has changed. - `java.util.prefs.PreferenceChangeEvent`"
  ([^java.util.prefs.PreferenceChangeListener this ^java.util.prefs.PreferenceChangeEvent evt]
    (-> this (.preferenceChange evt))))

