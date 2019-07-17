(ns jdk.net.MalformedURLException
  "Thrown to indicate that a malformed URL has occurred. Either no
  legal protocol could be found in a specification string or the
  string could not be parsed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net MalformedURLException]))

(defn ->malformed-url-exception
  "Constructor.

  Constructs a MalformedURLException with the
   specified detail message.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new MalformedURLException msg))
  ([]
    (new MalformedURLException )))

