(ns jdk.awt.event.AWTEventListener
  "The listener interface for receiving notification of events
  dispatched to objects that are instances of Component or
  MenuComponent or their subclasses.  Unlike the other EventListeners
  in this package, AWTEventListeners passively observe events
  being dispatched in the AWT, system-wide.  Most applications
  should never use this class; applications which might use
  AWTEventListeners include event recorders for automated testing,
  and facilities such as the Java Accessibility package.

  The class that is interested in monitoring AWT events
  implements this interface, and the object created with that
  class is registered with the Toolkit, using the Toolkit's
  addAWTEventListener method.  When an event is
  dispatched anywhere in the AWT, that object's
  eventDispatched method is invoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event AWTEventListener]))

(defn event-dispatched
  "Invoked when an event is dispatched in the AWT.

  event - `java.awt.AWTEvent`"
  ([this event]
    (-> this (.eventDispatched event))))

