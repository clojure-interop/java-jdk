(ns jdk.util.EventListenerProxy
  "An abstract wrapper class for an EventListener class
  which associates a set of additional parameters with the listener.
  Subclasses must provide the storage and accessor methods
  for the additional arguments or parameters.

  For example, a bean which supports named properties
  would have a two argument method signature for adding
  a PropertyChangeListener for a property:


  public void addPropertyChangeListener(String propertyName,
                                        PropertyChangeListener listener)
  If the bean also implemented the zero argument get listener method:


  public PropertyChangeListener[] getPropertyChangeListeners()
  then the array may contain inner PropertyChangeListeners
  which are also PropertyChangeListenerProxy objects.

  If the calling method is interested in retrieving the named property
  then it would have to test the element to see if it is a proxy class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util EventListenerProxy]))

(defn ->event-listener-proxy
  "Constructor.

  Creates a proxy for the specified listener.

  listener - the listener object - `EventListenerProxy.T`"
  ([listener]
    (new EventListenerProxy listener)))

(defn get-listener
  "Returns the listener associated with the proxy.

  returns: the listener associated with the proxy - `EventListenerProxy.T`"
  ([this]
    (-> this (.getListener))))

