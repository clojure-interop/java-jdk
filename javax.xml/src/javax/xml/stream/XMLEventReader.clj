(ns javax.xml.stream.XMLEventReader
  "This is the top level interface for parsing XML Events.  It provides
  the ability to peek at the next event and returns configuration
  information through the property interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLEventReader]))

(defn next-event
  "Get the next XMLEvent

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException - if there is an error with the underlying XML."
  (^javax.xml.stream.events.XMLEvent [^XMLEventReader this]
    (-> this (.nextEvent))))

(defn has-next?
  "Check if there are more events.
   Returns true if there are more events and false otherwise.

  returns: true if the event reader has more events, false otherwise - `boolean`"
  (^Boolean [^XMLEventReader this]
    (-> this (.hasNext))))

(defn peek
  "Check the next XMLEvent without reading it from the stream.
   Returns null if the stream is at EOF or has no more XMLEvents.
   A call to peek() will be equal to the next return of next().

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException"
  (^javax.xml.stream.events.XMLEvent [^XMLEventReader this]
    (-> this (.peek))))

(defn get-element-text
  "Reads the content of a text-only element. Precondition:
   the current event is START_ELEMENT. Postcondition:
   The current event is the corresponding END_ELEMENT.

  returns: `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the current event is not a START_ELEMENT or if a non text element is encountered"
  (^java.lang.String [^XMLEventReader this]
    (-> this (.getElementText))))

(defn next-tag
  "Skips any insignificant space events until a START_ELEMENT or
   END_ELEMENT is reached. If anything other than space characters are
   encountered, an exception is thrown. This method should
   be used when processing element-only content because
   the parser is not able to recognize ignorable whitespace if
   the DTD is missing or not interpreted.

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException - if anything other than space characters are encountered"
  (^javax.xml.stream.events.XMLEvent [^XMLEventReader this]
    (-> this (.nextTag))))

(defn get-property
  "Get the value of a feature/property from the underlying implementation

  name - The name of the property - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  (^java.lang.Object [^XMLEventReader this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn close
  "Frees any resources associated with this Reader.  This method does not close the
   underlying input source.

  throws: javax.xml.stream.XMLStreamException - if there are errors freeing associated resources"
  ([^XMLEventReader this]
    (-> this (.close))))

