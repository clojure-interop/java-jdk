(ns javax.naming.MalformedLinkException
  "This exception is thrown when a malformed link was encountered while
  resolving or constructing a link.

  Synchronization and serialization issues that apply to LinkException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming MalformedLinkException]))

(defn ->malformed-link-exception
  "Constructor.

  Constructs a new instance of MalformedLinkException with an explanation
   All the other fields are initialized to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^MalformedLinkException [^java.lang.String explanation]
    (new MalformedLinkException explanation))
  (^MalformedLinkException []
    (new MalformedLinkException )))

