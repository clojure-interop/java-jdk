(ns jdk.awt.event.AWTEventListenerProxy
  "A class which extends the EventListenerProxy
  specifically for adding an AWTEventListener
  for a specific event mask.
  Instances of this class can be added as AWTEventListeners
  to a Toolkit object.

  The getAWTEventListeners method of Toolkit
  can return a mixture of AWTEventListener
  and AWTEventListenerProxy objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event AWTEventListenerProxy]))

(defn ->awt-event-listener-proxy
  "Constructor.

  Constructor which binds the AWTEventListener
   to a specific event mask.

  event-mask - the bitmap of event types to receive - `long`
  listener - the listener object - `java.awt.event.AWTEventListener`"
  (^AWTEventListenerProxy [^Long event-mask ^java.awt.event.AWTEventListener listener]
    (new AWTEventListenerProxy event-mask listener)))

(defn event-dispatched
  "Forwards the AWT event to the listener delegate.

  event - the AWT event - `java.awt.AWTEvent`"
  ([^AWTEventListenerProxy this ^java.awt.AWTEvent event]
    (-> this (.eventDispatched event))))

(defn get-event-mask
  "Returns the event mask associated with the listener.

  returns: the event mask associated with the listener - `long`"
  (^Long [^AWTEventListenerProxy this]
    (-> this (.getEventMask))))

