(ns jdk.beans.VetoableChangeListenerProxy
  "A class which extends the EventListenerProxy
  specifically for adding a VetoableChangeListener
  with a `constrained` property.
  Instances of this class can be added
  as VetoableChangeListeners to a bean
  which supports firing vetoable change events.

  If the object has a getVetoableChangeListeners method
  then the array returned could be a mixture of VetoableChangeListener
  and VetoableChangeListenerProxy objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans VetoableChangeListenerProxy]))

(defn ->vetoable-change-listener-proxy
  "Constructor.

  Constructor which binds the VetoableChangeListener
   to a specific property.

  property-name - the name of the property to listen on - `java.lang.String`
  listener - the listener object - `java.beans.VetoableChangeListener`"
  (^VetoableChangeListenerProxy [^java.lang.String property-name ^java.beans.VetoableChangeListener listener]
    (new VetoableChangeListenerProxy property-name listener)))

(defn vetoable-change
  "Forwards the property change event to the listener delegate.

  event - the property change event - `java.beans.PropertyChangeEvent`

  throws: java.beans.PropertyVetoException - if the recipient wishes the property change to be rolled back"
  ([^VetoableChangeListenerProxy this ^java.beans.PropertyChangeEvent event]
    (-> this (.vetoableChange event))))

(defn get-property-name
  "Returns the name of the named property associated with the listener.

  returns: the name of the named property associated with the listener - `java.lang.String`"
  (^java.lang.String [^VetoableChangeListenerProxy this]
    (-> this (.getPropertyName))))

