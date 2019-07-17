(ns javax.net.ssl.SSLEngineResult
  "An encapsulation of the result state produced by
  SSLEngine I/O calls.

   A SSLEngine provides a means for establishing
  secure communication sessions between two peers.  SSLEngine
  operations typically consume bytes from an input buffer and produce
  bytes in an output buffer.  This class provides operational result
  values describing the state of the SSLEngine, including
  indications of what operations are needed to finish an
  ongoing handshake.  Lastly, it reports the number of bytes consumed
  and produced as a result of this operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLEngineResult]))

(defn ->ssl-engine-result
  "Constructor.

  Initializes a new instance of this class.

  status - the return value of the operation. - `javax.net.ssl.SSLEngineResult.Status`
  handshake-status - the current handshaking status. - `javax.net.ssl.SSLEngineResult.HandshakeStatus`
  bytes-consumed - the number of bytes consumed from the source ByteBuffer - `int`
  bytes-produced - the number of bytes placed into the destination ByteBuffer - `int`

  throws: java.lang.IllegalArgumentException - if the status or handshakeStatus arguments are null, or if bytesConsumed or bytesProduced is negative."
  ([^javax.net.ssl.SSLEngineResult.Status status ^javax.net.ssl.SSLEngineResult.HandshakeStatus handshake-status ^Integer bytes-consumed ^Integer bytes-produced]
    (new SSLEngineResult status handshake-status bytes-consumed bytes-produced)))

(defn get-status
  "Gets the return value of this SSLEngine operation.

  returns: the return value - `javax.net.ssl.SSLEngineResult.Status`"
  ([^javax.net.ssl.SSLEngineResult this]
    (-> this (.getStatus))))

(defn get-handshake-status
  "Gets the handshake status of this SSLEngine
   operation.

  returns: the handshake status - `javax.net.ssl.SSLEngineResult.HandshakeStatus`"
  ([^javax.net.ssl.SSLEngineResult this]
    (-> this (.getHandshakeStatus))))

(defn bytes-consumed
  "Returns the number of bytes consumed from the input buffer.

  returns: the number of bytes consumed. - `int`"
  ([^javax.net.ssl.SSLEngineResult this]
    (-> this (.bytesConsumed))))

(defn bytes-produced
  "Returns the number of bytes written to the output buffer.

  returns: the number of bytes produced - `int`"
  ([^javax.net.ssl.SSLEngineResult this]
    (-> this (.bytesProduced))))

(defn to-string
  "Returns a String representation of this object.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.net.ssl.SSLEngineResult this]
    (-> this (.toString))))

