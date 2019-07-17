(ns javax.xml.stream.EventFilter
  "This interface declares a simple filter interface that one can
  create to filter XMLEventReaders"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream EventFilter]))

(defn accept
  "Tests whether this event is part of this stream.  This method
   will return true if this filter accepts this event and false
   otherwise.

  event - the event to test - `javax.xml.stream.events.XMLEvent`

  returns: true if this filter accepts this event, false otherwise - `boolean`"
  ([^. this ^javax.xml.stream.events.XMLEvent event]
    (-> this (.accept event))))

