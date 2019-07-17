(ns javax.print.URIException
  "Interface URIException is a mixin interface which a subclass of PrintException can implement to report an error condition
  involving a URI address. The Print Service API does not define any print
  exception classes that implement interface URIException, that being left to
  the Print Service implementor's discretion."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print URIException]))

(defn get-unsupported-uri
  "Return the URI.

  returns: the URI that is the cause of this exception. - `java.net.URI`"
  ([^. this]
    (-> this (.getUnsupportedURI))))

(defn get-reason
  "Return the reason for the event.

  returns: one of the predefined reasons enumerated in this interface. - `int`"
  ([^. this]
    (-> this (.getReason))))

