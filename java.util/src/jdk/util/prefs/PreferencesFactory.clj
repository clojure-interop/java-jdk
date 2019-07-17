(ns jdk.util.prefs.PreferencesFactory
  "A factory object that generates Preferences objects.  Providers of
  new Preferences implementations should provide corresponding
  PreferencesFactory implementations so that the new
  Preferences implementation can be installed in place of the
  platform-specific default implementation.

  This class is for Preferences implementers only.
  Normal users of the Preferences facility should have no need to
  consult this documentation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs PreferencesFactory]))

(defn system-root
  "Returns the system root preference node.  (Multiple calls on this
   method will return the same object reference.)

  returns: the system root preference node - `java.util.prefs.Preferences`"
  ([this]
    (-> this (.systemRoot))))

(defn user-root
  "Returns the user root preference node corresponding to the calling
   user.  In a server, the returned value will typically depend on
   some implicit client-context.

  returns: the user root preference node corresponding to the calling
   user - `java.util.prefs.Preferences`"
  ([this]
    (-> this (.userRoot))))

