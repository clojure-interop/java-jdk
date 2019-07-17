(ns jdk.rmi.server.RemoteCall
  "Deprecated.
 no replacement."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RemoteCall]))

(defn get-output-stream
  "Deprecated. no replacement

  returns: output stream for arguments/results - `java.lang..io.ObjectOutput`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.getOutputStream))))

(defn release-output-stream
  "Deprecated. no replacement

  returns: `java.lang. void`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.releaseOutputStream))))

(defn get-input-stream
  "Deprecated. no replacement

  returns: input stream for reading arguments/results - `java.lang..io.ObjectInput`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.getInputStream))))

(defn release-input-stream
  "Deprecated. no replacement

  returns: `java.lang. void`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.releaseInputStream))))

(defn get-result-stream
  "Deprecated. no replacement

  success - If true, indicates normal return, else indicates exceptional return. - `boolean`

  returns: output stream for writing call result - `java.lang..io.ObjectOutput`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this ^Boolean success]
    (-> this (.getResultStream success))))

(defn execute-call
  "Deprecated. no replacement

  returns: `java.lang. void`

  throws: java.lang.Exception - if a general exception occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.executeCall))))

(defn done
  "Deprecated. no replacement

  returns: `java.lang. void`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.rmi.server.RemoteCall this]
    (-> this (.done))))

