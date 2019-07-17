(ns javax.xml.stream.util.XMLEventConsumer
  "This interface defines an event consumer interface.  The contract of the
  of a consumer is to accept the event.  This interface can be used to
  mark an object as able to receive events.  Add may be called several
  times in immediate succession so a consumer must be able to cache
  events it hasn't processed yet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.util XMLEventConsumer]))

(defn add
  "This method adds an event to the consumer. Calling this method
   invalidates the event parameter. The client application should
   discard all references to this event upon calling add.
   The behavior of an application that continues to use such references
   is undefined.

  event - the event to add, may not be null - `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException"
  ([this event]
    (-> this (.add event))))

