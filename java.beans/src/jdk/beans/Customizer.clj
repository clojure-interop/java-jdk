(ns jdk.beans.Customizer
  "A customizer class provides a complete custom GUI for customizing
  a target Java Bean.

  Each customizer should inherit from the java.awt.Component class so
  it can be instantiated inside an AWT dialog or panel.

  Each customizer should have a null constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Customizer]))

(defn set-object
  "Set the object to be customized.  This method should be called only
   once, before the Customizer has been added to any parent AWT container.

  bean - The object to be customized. - `java.lang.Object`"
  ([^. this ^java.lang.Object bean]
    (-> this (.setObject bean))))

(defn add-property-change-listener
  "Register a listener for the PropertyChange event.  The customizer
   should fire a PropertyChange event whenever it changes the target
   bean in a way that might require the displayed properties to be
   refreshed.

  listener - An object to be invoked when a PropertyChange event is fired. - `java.beans.PropertyChangeListener`"
  ([^. this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-property-change-listener
  "Remove a listener for the PropertyChange event.

  listener - The PropertyChange listener to be removed. - `java.beans.PropertyChangeListener`"
  ([^. this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

