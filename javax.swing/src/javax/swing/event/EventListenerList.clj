(ns javax.swing.event.EventListenerList
  "A class that holds a list of EventListeners.  A single instance
  can be used to hold all listeners (of all types) for the instance
  using the list.  It is the responsiblity of the class using the
  EventListenerList to provide type-safe API (preferably conforming
  to the JavaBeans spec) and methods which dispatch event notification
  methods to appropriate Event Listeners on the list.

  The main benefits that this class provides are that it is relatively
  cheap in the case of no listeners, and it provides serialization for
  event-listener lists in a single place, as well as a degree of MT safety
  (when used correctly).

  Usage example:
     Say one is defining a class that sends out FooEvents, and one wants
  to allow users of the class to register FooListeners and receive
  notification when FooEvents occur.  The following should be added
  to the class definition:


  EventListenerList listenerList = new EventListenerList();
  FooEvent fooEvent = null;

  public void addFooListener(FooListener l) {
      listenerList.add(FooListener.class, l);
  }

  public void removeFooListener(FooListener l) {
      listenerList.remove(FooListener.class, l);
  }


  // Notify all listeners that have registered interest for
  // notification on this event type.  The event instance
  // is lazily created using the parameters passed into
  // the fire method.

  protected void fireFooXXX() {
      // Guaranteed to return a non-null array
      Object[] listeners = listenerList.getListenerList();
      // Process the listeners last to first, notifying
      // those that are interested in this event
      for (int i = listeners.length-2; i>=0; i-=2) {
          if (listeners[i]==FooListener.class) {
              // Lazily create the event:
              if (fooEvent == null)
                  fooEvent = new FooEvent(this);
              ((FooListener)listeners[i+1]).fooXXX(fooEvent);
          }
      }
  }
  foo should be changed to the appropriate name, and fireFooXxx to the
  appropriate method name.  One fire method should exist for each
  notification method in the FooListener interface.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event EventListenerList]))

(defn ->event-listener-list
  "Constructor."
  (^EventListenerList []
    (new EventListenerList )))

(defn get-listener-list
  "Passes back the event listener list as an array
   of ListenerType-listener pairs.  Note that for
   performance reasons, this implementation passes back
   the actual data structure in which the listener data
   is stored internally!
   This method is guaranteed to pass back a non-null
   array, so that no null-checking is required in
   fire methods.  A zero-length array of Object should
   be returned if there are currently no listeners.

   WARNING!!! Absolutely NO modification of
   the data contained in this array should be made -- if
   any such manipulation is necessary, it should be done
   on a copy of the array returned rather than the array
   itself.

  returns: `java.lang.Object[]`"
  ([^EventListenerList this]
    (-> this (.getListenerList))))

(defn get-listeners
  "Return an array of all the listeners of the given type.

  t - `java.lang.Class`

  returns: all of the listeners of the specified type. - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if the supplied class is not assignable to EventListener"
  ([^EventListenerList this ^java.lang.Class t]
    (-> this (.getListeners t))))

(defn get-listener-count
  "Returns the total number of listeners of the supplied type
   for this listener list.

  t - `java.lang.Class`

  returns: `int`"
  (^Integer [^EventListenerList this ^java.lang.Class t]
    (-> this (.getListenerCount t)))
  (^Integer [^EventListenerList this]
    (-> this (.getListenerCount))))

(defn add
  "Adds the listener as a listener of the specified type.

  t - the type of the listener to be added - `java.lang.Class`
  l - the listener to be added - `T`

  returns: `<T extends java.util.EventListener> void`"
  ([^EventListenerList this ^java.lang.Class t l]
    (-> this (.add t l))))

(defn remove
  "Removes the listener as a listener of the specified type.

  t - the type of the listener to be removed - `java.lang.Class`
  l - the listener to be removed - `T`

  returns: `<T extends java.util.EventListener> void`"
  ([^EventListenerList this ^java.lang.Class t l]
    (-> this (.remove t l))))

(defn to-string
  "Returns a string representation of the EventListenerList.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^EventListenerList this]
    (-> this (.toString))))

