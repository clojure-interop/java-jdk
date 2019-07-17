(ns javax.xml.crypto.OctetStreamData
  "A representation of a Data type containing an octet stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto OctetStreamData]))

(defn ->octet-stream-data
  "Constructor.

  Creates a new OctetStreamData.

  octet-stream - the input stream containing the octets - `java.io.InputStream`
  uri - the URI String identifying the data object (may be null) - `java.lang.String`
  mime-type - the MIME type associated with the data object (may be null) - `java.lang.String`

  throws: java.lang.NullPointerException - if octetStream is null"
  ([octet-stream uri mime-type]
    (new OctetStreamData octet-stream uri mime-type))
  ([octet-stream]
    (new OctetStreamData octet-stream)))

(defn get-octet-stream
  "Returns the input stream of this OctetStreamData.

  returns: the input stream of this OctetStreamData. - `java.io.InputStream`"
  ([this]
    (-> this (.getOctetStream))))

(defn get-uri
  "Returns the URI String identifying the data object represented by this
   OctetStreamData.

  returns: the URI String or null if not applicable - `java.lang.String`"
  ([this]
    (-> this (.getURI))))

(defn get-mime-type
  "Returns the MIME type associated with the data object represented by this
   OctetStreamData.

  returns: the MIME type or null if not applicable - `java.lang.String`"
  ([this]
    (-> this (.getMimeType))))

