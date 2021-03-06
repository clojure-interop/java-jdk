(ns javax.xml.bind.helpers.ValidationEventLocatorImpl
  "Default implementation of the ValidationEventLocator interface.


  JAXB providers are allowed to use whatever class that implements
  the ValidationEventLocator interface. This class is just provided for a
  convenience."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers ValidationEventLocatorImpl]))

(defn ->validation-event-locator-impl
  "Constructor.

  Constructs an object from an org.xml.sax.Locator.

   The object's ColumnNumber, LineNumber, and URL become available from the
   values returned by the locator's getColumnNumber(), getLineNumber(), and
   getSystemId() methods respectively. Node, Object, and Offset are not
   available.

  loc - the SAX Locator object that will be used to populate this event locator. - `org.xml.sax.Locator`

  throws: java.lang.IllegalArgumentException - if the Locator is null"
  (^ValidationEventLocatorImpl [^org.xml.sax.Locator loc]
    (new ValidationEventLocatorImpl loc))
  (^ValidationEventLocatorImpl []
    (new ValidationEventLocatorImpl )))

(defn set-line-number
  "Set the lineNumber field on this event locator.

  line-number - the line number - `int`"
  ([^ValidationEventLocatorImpl this ^Integer line-number]
    (-> this (.setLineNumber line-number))))

(defn set-column-number
  "Set the columnNumber field on this event locator.

  column-number - the column number - `int`"
  ([^ValidationEventLocatorImpl this ^Integer column-number]
    (-> this (.setColumnNumber column-number))))

(defn set-object
  "Set the Object field on this event locator.  Null values are allowed.

  object - the java content object - `java.lang.Object`"
  ([^ValidationEventLocatorImpl this ^java.lang.Object object]
    (-> this (.setObject object))))

(defn to-string
  "Returns a string representation of this object in a format
   helpful to debugging.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^ValidationEventLocatorImpl this]
    (-> this (.toString))))

(defn set-node
  "Set the Node field on this event locator.  Null values are allowed.

  node - the Node - `org.w3c.dom.Node`"
  ([^ValidationEventLocatorImpl this ^org.w3c.dom.Node node]
    (-> this (.setNode node))))

(defn get-object
  "Description copied from interface: ValidationEventLocator

  returns: a reference to the object in the Java content tree or null if
           unavailable - `java.lang.Object`"
  (^java.lang.Object [^ValidationEventLocatorImpl this]
    (-> this (.getObject))))

(defn get-node
  "Description copied from interface: ValidationEventLocator

  returns: a reference to the DOM Node or null if unavailable - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^ValidationEventLocatorImpl this]
    (-> this (.getNode))))

(defn get-column-number
  "Description copied from interface: ValidationEventLocator

  returns: the column number or -1 if unavailable - `int`"
  (^Integer [^ValidationEventLocatorImpl this]
    (-> this (.getColumnNumber))))

(defn get-offset
  "Description copied from interface: ValidationEventLocator

  returns: the byte offset into the input source or -1 if unavailable - `int`"
  (^Integer [^ValidationEventLocatorImpl this]
    (-> this (.getOffset))))

(defn get-url
  "Description copied from interface: ValidationEventLocator

  returns: the name of the XML source as a URL or null if unavailable - `java.net.URL`"
  (^java.net.URL [^ValidationEventLocatorImpl this]
    (-> this (.getURL))))

(defn set-url
  "Set the URL field on this event locator.  Null values are allowed.

  url - the url - `java.net.URL`"
  ([^ValidationEventLocatorImpl this ^java.net.URL url]
    (-> this (.setURL url))))

(defn set-offset
  "Set the offset field on this event locator.

  offset - the offset - `int`"
  ([^ValidationEventLocatorImpl this ^Integer offset]
    (-> this (.setOffset offset))))

(defn get-line-number
  "Description copied from interface: ValidationEventLocator

  returns: the line number or -1 if unavailable - `int`"
  (^Integer [^ValidationEventLocatorImpl this]
    (-> this (.getLineNumber))))

