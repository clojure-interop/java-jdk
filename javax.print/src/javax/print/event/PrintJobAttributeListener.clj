(ns javax.print.event.PrintJobAttributeListener
  "Implementations of this interface are attached to a
  DocPrintJob to monitor
  the status of attribute changes associated with the print job."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintJobAttributeListener]))

(defn attribute-update
  "Notifies the listener of a change in some print job attributes.
   One example of an occurrence triggering this event is if the
   JobState
   attribute changed from
   PROCESSING to PROCESSING_STOPPED.

  pjae - the event. - `javax.print.event.PrintJobAttributeEvent`"
  ([this pjae]
    (-> this (.attributeUpdate pjae))))

