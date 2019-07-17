(ns javax.print.event.PrintServiceAttributeListener
  "Implementations of this listener interface are attached to a
  PrintService to monitor
  the status of the print service.

  To monitor a particular job see PrintJobListener and
  PrintJobAttributeListener."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintServiceAttributeListener]))

(defn attribute-update
  "Called to notify a listener of an event in the print service.
   The service will call this method on an event notification thread.
   The client should not perform lengthy processing in this callback
   or subsequent event notifications may be blocked.

  psae - the event being notified - `javax.print.event.PrintServiceAttributeEvent`"
  ([^javax.print.event.PrintServiceAttributeListener this ^javax.print.event.PrintServiceAttributeEvent psae]
    (-> this (.attributeUpdate psae))))

