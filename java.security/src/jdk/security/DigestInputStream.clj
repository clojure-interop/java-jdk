(ns jdk.security.DigestInputStream
  "A transparent stream that updates the associated message digest using
  the bits going through the stream.

  To complete the message digest computation, call one of the
  digest methods on the associated message
  digest after your calls to one of this digest input stream's
  read methods.

  It is possible to turn this stream on or off (see
  on). When it is on, a call to one of the
  read methods
  results in an update on the message digest.  But when it is off,
  the message digest is not updated. The default is for the stream
  to be on.

  Note that digest objects can compute only one digest (see
  MessageDigest),
  so that in order to compute intermediate digests, a caller should
  retain a handle onto the digest object, and clone it for each
  digest to be computed, leaving the orginal digest untouched."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security DigestInputStream]))

(defn ->digest-input-stream
  "Constructor.

  Creates a digest input stream, using the specified input stream
   and message digest.

  stream - the input stream. - `java.io.InputStream`
  digest - the message digest to associate with this stream. - `java.security.MessageDigest`"
  (^DigestInputStream [^java.io.InputStream stream ^java.security.MessageDigest digest]
    (new DigestInputStream stream digest)))

(defn get-message-digest
  "Returns the message digest associated with this stream.

  returns: the message digest associated with this stream. - `java.security.MessageDigest`"
  (^java.security.MessageDigest [^DigestInputStream this]
    (-> this (.getMessageDigest))))

(defn set-message-digest
  "Associates the specified message digest with this stream.

  digest - the message digest to be associated with this stream. - `java.security.MessageDigest`"
  ([^DigestInputStream this ^java.security.MessageDigest digest]
    (-> this (.setMessageDigest digest))))

(defn read
  "Reads into a byte array, and updates the message digest (if the
   digest function is on).  That is, this method reads up to
   len bytes from the input stream into the array
   b, starting at offset off. This method
   blocks until the data is actually
   read. If the digest function is on (see
   on), this method will then call update
   on the message digest associated with this stream, passing it
   the data.

  b - the array into which the data is read. - `byte[]`
  off - the starting offset into b of where the data should be placed. - `int`
  len - the maximum number of bytes to be read from the input stream into b, starting at offset off. - `int`

  returns: the actual number of bytes read. This is less than
   len if the end of the stream is reached prior to
   reading len bytes. -1 is returned if no bytes were
   read because the end of the stream had already been reached when
   the call was made. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^DigestInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^DigestInputStream this]
    (-> this (.read))))

(defn on
  "Turns the digest function on or off. The default is on.  When
   it is on, a call to one of the read methods results in an
   update on the message digest.  But when it is off, the message
   digest is not updated.

  on - true to turn the digest function on, false to turn it off. - `boolean`"
  ([^DigestInputStream this ^Boolean on]
    (-> this (.on on))))

(defn to-string
  "Prints a string representation of this digest input stream and
   its associated message digest object.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^DigestInputStream this]
    (-> this (.toString))))

