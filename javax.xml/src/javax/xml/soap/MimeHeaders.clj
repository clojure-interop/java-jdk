(ns javax.xml.soap.MimeHeaders
  "A container for MimeHeader objects, which represent
  the MIME headers present in a MIME part of a message.

  This class is used primarily when an application wants to
  retrieve specific attachments based on certain MIME headers and
  values. This class will most likely be used by implementations of
  AttachmentPart and other MIME dependent parts of the SAAJ
  API."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap MimeHeaders]))

(defn ->mime-headers
  "Constructor.

  Constructs a default MimeHeaders object initialized with
   an empty Vector object."
  ([]
    (new MimeHeaders )))

(defn get-header
  "Returns all of the values for the specified header as an array of
   String objects.

  name - the name of the header for which values will be returned - `java.lang.String`

  returns: a String array with all of the values for the
           specified header - `java.lang.String[]`"
  ([^javax.xml.soap.MimeHeaders this ^java.lang.String name]
    (-> this (.getHeader name))))

(defn set-header
  "Replaces the current value of the first header entry whose name matches
   the given name with the given value, adding a new header if no existing header
   name matches. This method also removes all matching headers after the first one.

   Note that RFC822 headers can contain only US-ASCII characters.

  name - a String with the name of the header for which to search - `java.lang.String`
  value - a String with the value that will replace the current value of the specified header - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem in the mime header name or the value being set"
  ([^javax.xml.soap.MimeHeaders this ^java.lang.String name ^java.lang.String value]
    (-> this (.setHeader name value))))

(defn add-header
  "Adds a MimeHeader object with the specified name and value
   to this MimeHeaders object's list of headers.

   Note that RFC822 headers can contain only US-ASCII characters.

  name - a String with the name of the header to be added - `java.lang.String`
  value - a String with the value of the header to be added - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem in the mime header name or value being added"
  ([^javax.xml.soap.MimeHeaders this ^java.lang.String name ^java.lang.String value]
    (-> this (.addHeader name value))))

(defn remove-header
  "Remove all MimeHeader objects whose name matches the
   given name.

  name - a String with the name of the header for which to search - `java.lang.String`"
  ([^javax.xml.soap.MimeHeaders this ^java.lang.String name]
    (-> this (.removeHeader name))))

(defn remove-all-headers
  "Removes all the header entries from this MimeHeaders object."
  ([^javax.xml.soap.MimeHeaders this]
    (-> this (.removeAllHeaders))))

(defn get-all-headers
  "Returns all the MimeHeaders in this MimeHeaders object.

  returns: an Iterator object over this MimeHeaders
            object's list of MimeHeader objects - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.soap.MimeHeaders this]
    (-> this (.getAllHeaders))))

(defn get-matching-headers
  "Returns all the MimeHeader objects whose name matches
   a name in the given array of names.

  names - an array of String objects with the names for which to search - `java.lang.String[]`

  returns: an Iterator object over the MimeHeader
            objects whose name matches one of the names in the given list - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.soap.MimeHeaders this names]
    (-> this (.getMatchingHeaders names))))

(defn get-non-matching-headers
  "Returns all of the MimeHeader objects whose name does not
   match a name in the given array of names.

  names - an array of String objects with the names for which to search - `java.lang.String[]`

  returns: an Iterator object over the MimeHeader
            objects whose name does not match one of the names in the given list - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.soap.MimeHeaders this names]
    (-> this (.getNonMatchingHeaders names))))

