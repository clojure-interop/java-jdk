(ns javax.xml.stream.util.XMLEventAllocator
  "This interface defines a class that allows a user to register
  a way to allocate events given an XMLStreamReader.  An implementation
  is not required to use the XMLEventFactory implementation but this
  is recommended.  The XMLEventAllocator can be set on an XMLInputFactory
  using the property \"javax.xml.stream.allocator\""
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.util XMLEventAllocator]))

(defn new-instance
  "This method creates an instance of the XMLEventAllocator. This
   allows the XMLInputFactory to allocate a new instance per reader.

  returns: `javax.xml.stream.util.XMLEventAllocator`"
  (^javax.xml.stream.util.XMLEventAllocator [^XMLEventAllocator this]
    (-> this (.newInstance))))

(defn allocate
  "This method allocates an event or set of events
   given the current
   state of the XMLStreamReader and adds the event
   or set of events to the
   consumer that was passed in.  This method can be used
   to expand or contract reader states into event states.
   This method may modify the state of the XMLStreamReader.

  reader - The XMLStreamReader to allocate from - `javax.xml.stream.XMLStreamReader`
  consumer - The XMLEventConsumer to add to. - `javax.xml.stream.util.XMLEventConsumer`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLEventAllocator this ^javax.xml.stream.XMLStreamReader reader ^javax.xml.stream.util.XMLEventConsumer consumer]
    (-> this (.allocate reader consumer)))
  (^javax.xml.stream.events.XMLEvent [^XMLEventAllocator this ^javax.xml.stream.XMLStreamReader reader]
    (-> this (.allocate reader))))

