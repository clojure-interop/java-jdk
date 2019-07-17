(ns jdk.beans.Visibility
  "Under some circumstances a bean may be run on servers where a GUI
  is not available.  This interface can be used to query a bean to
  determine whether it absolutely needs a gui, and to advise the
  bean whether a GUI is available.

  This interface is for expert developers, and is not needed
  for normal simple beans.  To avoid confusing end-users we
  avoid using getXXX setXXX design patterns for these methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Visibility]))

(defn needs-gui
  "Determines whether this bean needs a GUI.

  returns: True if the bean absolutely needs a GUI available in
            order to get its work done. - `boolean`"
  (^Boolean [^java.beans.Visibility this]
    (-> this (.needsGui))))

(defn dont-use-gui
  "This method instructs the bean that it should not use the Gui."
  ([^java.beans.Visibility this]
    (-> this (.dontUseGui))))

(defn ok-to-use-gui
  "This method instructs the bean that it is OK to use the Gui."
  ([^java.beans.Visibility this]
    (-> this (.okToUseGui))))

(defn avoiding-gui
  "Determines whether this bean is avoiding using a GUI.

  returns: true if the bean is currently avoiding use of the Gui.
     e.g. due to a call on dontUseGui(). - `boolean`"
  (^Boolean [^java.beans.Visibility this]
    (-> this (.avoidingGui))))

