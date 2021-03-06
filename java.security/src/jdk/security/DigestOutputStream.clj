(ns jdk.security.DigestOutputStream
  "A transparent stream that updates the associated message digest using
  the bits going through the stream.

  To complete the message digest computation, call one of the
  digest methods on the associated message
  digest after your calls to one of this digest output stream's
  write methods.

  It is possible to turn this stream on or off (see
  on). When it is on, a call to one of the
  write methods results in
  an update on the message digest.  But when it is off, the message
  digest is not updated. The default is for the stream to be on."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security DigestOutputStream]))

(defn ->digest-output-stream
  "Constructor.

  Creates a digest output stream, using the specified output stream
   and message digest.

  stream - the output stream. - `java.io.OutputStream`
  digest - the message digest to associate with this stream. - `java.security.MessageDigest`"
  (^DigestOutputStream [^java.io.OutputStream stream ^java.security.MessageDigest digest]
    (new DigestOutputStream stream digest)))

(defn get-message-digest
  "Returns the message digest associated with this stream.

  returns: the message digest associated with this stream. - `java.security.MessageDigest`"
  (^java.security.MessageDigest [^DigestOutputStream this]
    (-> this (.getMessageDigest))))

(defn set-message-digest
  "Associates the specified message digest with this stream.

  digest - the message digest to be associated with this stream. - `java.security.MessageDigest`"
  ([^DigestOutputStream this ^java.security.MessageDigest digest]
    (-> this (.setMessageDigest digest))))

(defn write
  "Updates the message digest (if the digest function is on) using
   the specified subarray, and in any case writes the subarray to
   the output stream. That is, if the digest function is on (see
   on), this method calls update
   on the message digest associated with this stream, passing it
   the subarray specifications. This method then writes the subarray
   bytes to the output stream, blocking until the bytes are actually
   written.

  b - the array containing the subarray to be used for updating and writing to the output stream. - `byte[]`
  off - the offset into b of the first byte to be updated and written. - `int`
  len - the number of bytes of data to be updated and written from b, starting at offset off. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^DigestOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^DigestOutputStream this ^Integer b]
    (-> this (.write b))))

(defn on
  "Turns the digest function on or off. The default is on.  When
   it is on, a call to one of the write methods results in an
   update on the message digest.  But when it is off, the message
   digest is not updated.

  on - true to turn the digest function on, false to turn it off. - `boolean`"
  ([^DigestOutputStream this ^Boolean on]
    (-> this (.on on))))

(defn to-string
  "Prints a string representation of this digest output stream and
   its associated message digest object.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^DigestOutputStream this]
    (-> this (.toString))))

