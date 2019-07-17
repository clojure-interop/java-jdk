(ns jdk.net.FileNameMap
  "A simple interface which provides a mechanism to map
  between a file name and a MIME type string."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net FileNameMap]))

(defn get-content-type-for
  "Gets the MIME type for the specified file name.

  file-name - the specified file name - `java.lang.String`

  returns: a String indicating the MIME
   type for the specified file name. - `java.lang.String`"
  ([this file-name]
    (-> this (.getContentTypeFor file-name))))

