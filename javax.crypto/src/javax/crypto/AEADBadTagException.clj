(ns javax.crypto.AEADBadTagException
  "This exception is thrown when a Cipher operating in
  an AEAD mode (such as GCM/CCM) is unable to verify the supplied
  authentication tag."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto AEADBadTagException]))

(defn ->aead-bad-tag-exception
  "Constructor.

  Constructs a AEADBadTagException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new AEADBadTagException msg))
  ([]
    (new AEADBadTagException )))

