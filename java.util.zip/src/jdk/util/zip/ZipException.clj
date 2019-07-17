(ns jdk.util.zip.ZipException
  "Signals that a Zip exception of some sort has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipException]))

(defn ->zip-exception
  "Constructor.

  Constructs a ZipException with the specified detail
   message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new ZipException s))
  ([]
    (new ZipException )))

