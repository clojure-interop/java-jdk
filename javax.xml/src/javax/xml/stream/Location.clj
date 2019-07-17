(ns javax.xml.stream.Location
  "Provides information on the location of an event.

  All the information provided by a Location is optional.  For example
  an application may only report line numbers."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream Location]))

(defn get-line-number
  "Return the line number where the current event ends,
   returns -1 if none is available.

  returns: the current line number - `int`"
  (^Integer [^javax.xml.stream.Location this]
    (-> this (.getLineNumber))))

(defn get-column-number
  "Return the column number where the current event ends,
   returns -1 if none is available.

  returns: the current column number - `int`"
  (^Integer [^javax.xml.stream.Location this]
    (-> this (.getColumnNumber))))

(defn get-character-offset
  "Return the byte or character offset into the input source this location
   is pointing to. If the input source is a file or a byte stream then
   this is the byte offset into that stream, but if the input source is
   a character media then the offset is the character offset.
   Returns -1 if there is no offset available.

  returns: the current offset - `int`"
  (^Integer [^javax.xml.stream.Location this]
    (-> this (.getCharacterOffset))))

(defn get-public-id
  "Returns the public ID of the XML

  returns: the public ID, or null if not available - `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.Location this]
    (-> this (.getPublicId))))

(defn get-system-id
  "Returns the system ID of the XML

  returns: the system ID, or null if not available - `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.Location this]
    (-> this (.getSystemId))))

