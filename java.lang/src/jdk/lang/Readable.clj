(ns jdk.lang.Readable
  "A Readable is a source of characters. Characters from
  a Readable are made available to callers of the read
  method via a CharBuffer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Readable]))

(defn read
  "Attempts to read characters into the specified character buffer.
   The buffer is used as a repository of characters as-is: the only
   changes made are the results of a put operation. No flipping or
   rewinding of the buffer is performed.

  cb - the buffer to read characters into - `java.nio.CharBuffer`

  returns: The number of char values added to the buffer,
                   or -1 if this source of characters is at its end - `int`

  throws: java.io.IOException - if an I/O error occurs"
  (^Integer [^java.lang.Readable this ^java.nio.CharBuffer cb]
    (-> this (.read cb))))

