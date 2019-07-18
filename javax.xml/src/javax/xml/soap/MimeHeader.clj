(ns javax.xml.soap.MimeHeader
  "An object that stores a MIME header name and its value. One or more
  MimeHeader objects may be contained in a MimeHeaders
  object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap MimeHeader]))

(defn ->mime-header
  "Constructor.

  Constructs a MimeHeader object initialized with the given
   name and value.

  name - a String giving the name of the header - `java.lang.String`
  value - a String giving the value of the header - `java.lang.String`"
  (^MimeHeader [^java.lang.String name ^java.lang.String value]
    (new MimeHeader name value)))

(defn get-name
  "Returns the name of this MimeHeader object.

  returns: the name of the header as a String - `java.lang.String`"
  (^java.lang.String [^MimeHeader this]
    (-> this (.getName))))

(defn get-value
  "Returns the value of this MimeHeader object.

  returns: the value of the header as a String - `java.lang.String`"
  (^java.lang.String [^MimeHeader this]
    (-> this (.getValue))))

