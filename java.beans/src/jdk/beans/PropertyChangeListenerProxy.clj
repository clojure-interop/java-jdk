(ns jdk.beans.PropertyChangeListenerProxy
  "A class which extends the EventListenerProxy
  specifically for adding a PropertyChangeListener
  with a `bound` property.
  Instances of this class can be added
  as PropertyChangeListeners to a bean
  which supports firing property change events.

  If the object has a getPropertyChangeListeners method
  then the array returned could be a mixture of PropertyChangeListener
  and PropertyChangeListenerProxy objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyChangeListenerProxy]))

(defn ->property-change-listener-proxy
  "Constructor.

  Constructor which binds the PropertyChangeListener
   to a specific property.

  property-name - the name of the property to listen on - `java.lang.String`
  listener - the listener object - `java.beans.PropertyChangeListener`"
  ([^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (new PropertyChangeListenerProxy property-name listener)))

(defn property-change
  "Forwards the property change event to the listener delegate.

  event - the property change event - `java.beans.PropertyChangeEvent`"
  ([^java.beans.PropertyChangeListenerProxy this ^java.beans.PropertyChangeEvent event]
    (-> this (.propertyChange event))))

(defn get-property-name
  "Returns the name of the named property associated with the listener.

  returns: the name of the named property associated with the listener - `java.lang.String`"
  (^java.lang.String [^java.beans.PropertyChangeListenerProxy this]
    (-> this (.getPropertyName))))

