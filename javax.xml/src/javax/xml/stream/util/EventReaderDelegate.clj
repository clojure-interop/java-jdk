(ns javax.xml.stream.util.EventReaderDelegate
  "This is the base class for deriving an XMLEventReader
  filter.

  This class is designed to sit between an XMLEventReader and an
  application's XMLEventReader.  By default each method
  does nothing but call the corresponding method on the
  parent interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.util EventReaderDelegate]))

(defn ->event-reader-delegate
  "Constructor.

  Construct an filter with the specified parent.

  reader - the parent - `javax.xml.stream.XMLEventReader`"
  ([^javax.xml.stream.XMLEventReader reader]
    (new EventReaderDelegate reader))
  ([]
    (new EventReaderDelegate )))

(defn peek
  "Description copied from interface: XMLEventReader

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException"
  (^javax.xml.stream.events.XMLEvent [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.peek))))

(defn set-parent
  "Set the parent of this instance.

  reader - the new parent - `javax.xml.stream.XMLEventReader`"
  ([^javax.xml.stream.util.EventReaderDelegate this ^javax.xml.stream.XMLEventReader reader]
    (-> this (.setParent reader))))

(defn next
  "Description copied from interface: Iterator

  returns: the next element in the iteration - `java.lang.Object`"
  (^java.lang.Object [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.next))))

(defn next-event
  "Description copied from interface: XMLEventReader

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException - if there is an error with the underlying XML."
  (^javax.xml.stream.events.XMLEvent [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.nextEvent))))

(defn get-element-text
  "Description copied from interface: XMLEventReader

  returns: `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the current event is not a START_ELEMENT or if a non text element is encountered"
  (^java.lang.String [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.getElementText))))

(defn get-parent
  "Get the parent of this instance.

  returns: the parent or null if none is set - `javax.xml.stream.XMLEventReader`"
  (^javax.xml.stream.XMLEventReader [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.getParent))))

(defn remove
  "Description copied from interface: Iterator"
  ([^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.remove))))

(defn has-next?
  "Description copied from interface: XMLEventReader

  returns: true if the event reader has more events, false otherwise - `boolean`"
  (^Boolean [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.hasNext))))

(defn close
  "Description copied from interface: XMLEventReader

  throws: javax.xml.stream.XMLStreamException - if there are errors freeing associated resources"
  ([^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.close))))

(defn get-property
  "Description copied from interface: XMLEventReader

  name - The name of the property - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  (^java.lang.Object [^javax.xml.stream.util.EventReaderDelegate this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn next-tag
  "Description copied from interface: XMLEventReader

  returns: `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException - if anything other than space characters are encountered"
  (^javax.xml.stream.events.XMLEvent [^javax.xml.stream.util.EventReaderDelegate this]
    (-> this (.nextTag))))

