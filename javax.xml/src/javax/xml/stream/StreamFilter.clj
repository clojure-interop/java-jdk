(ns javax.xml.stream.StreamFilter
  "This interface declares a simple filter interface that one can
  create to filter XMLStreamReaders"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream StreamFilter]))

(defn accept
  "Tests whether the current state is part of this stream.  This method
   will return true if this filter accepts this event and false otherwise.

   The method should not change the state of the reader when accepting
   a state.

  reader - the event to test - `javax.xml.stream.XMLStreamReader`

  returns: true if this filter accepts this event, false otherwise - `boolean`"
  ([this reader]
    (-> this (.accept reader))))

