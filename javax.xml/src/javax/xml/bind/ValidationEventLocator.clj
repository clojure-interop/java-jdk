(ns javax.xml.bind.ValidationEventLocator
  "Encapsulate the location of a ValidationEvent.


  The ValidationEventLocator indicates where the ValidationEvent
   occurred.  Different fields will be set depending on the type of
  validation that was being performed when the error or warning was detected.
  For example, on-demand validation would produce locators that contained
  references to objects in the Java content tree while unmarshal-time
  validation would produce locators containing information appropriate to the
  source of the XML data (file, url, Node, etc)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind ValidationEventLocator]))

(defn get-url
  "Return the name of the XML source as a URL if available

  returns: the name of the XML source as a URL or null if unavailable - `java.net.URL`"
  ([this]
    (-> this (.getURL))))

(defn get-offset
  "Return the byte offset if available

  returns: the byte offset into the input source or -1 if unavailable - `int`"
  ([this]
    (-> this (.getOffset))))

(defn get-line-number
  "Return the line number if available

  returns: the line number or -1 if unavailable - `int`"
  ([this]
    (-> this (.getLineNumber))))

(defn get-column-number
  "Return the column number if available

  returns: the column number or -1 if unavailable - `int`"
  ([this]
    (-> this (.getColumnNumber))))

(defn get-object
  "Return a reference to the object in the Java content tree if available

  returns: a reference to the object in the Java content tree or null if
           unavailable - `java.lang.Object`"
  ([this]
    (-> this (.getObject))))

(defn get-node
  "Return a reference to the DOM Node if available

  returns: a reference to the DOM Node or null if unavailable - `org.w3c.dom.Node`"
  ([this]
    (-> this (.getNode))))

