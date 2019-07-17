(ns javax.net.ssl.SSLEngineResult$Status
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLEngineResult$Status]))

(def BUFFER_UNDERFLOW
  "Enum Constant.

  The SSLEngine was not able to unwrap the
   incoming data because there were not enough source bytes
   available to make a complete packet.


   Repeat the call once more bytes are available.

  type: javax.net.ssl.SSLEngineResult.Status"
  SSLEngineResult$Status/BUFFER_UNDERFLOW)

(def BUFFER_OVERFLOW
  "Enum Constant.

  The SSLEngine was not able to process the
   operation because there are not enough bytes available in the
   destination buffer to hold the result.

   Repeat the call once more bytes are available.

  type: javax.net.ssl.SSLEngineResult.Status"
  SSLEngineResult$Status/BUFFER_OVERFLOW)

(def OK
  "Enum Constant.

  The SSLEngine completed the operation, and
   is available to process similar calls.

  type: javax.net.ssl.SSLEngineResult.Status"
  SSLEngineResult$Status/OK)

(def CLOSED
  "Enum Constant.

  The operation just closed this side of the
   SSLEngine, or the operation
   could not be completed because it was already closed.

  type: javax.net.ssl.SSLEngineResult.Status"
  SSLEngineResult$Status/CLOSED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SSLEngineResult.Status c : SSLEngineResult.Status.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.net.ssl.SSLEngineResult.Status[]`"
  ([]
    (SSLEngineResult$Status/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.net.ssl.SSLEngineResult.Status`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.net.ssl.SSLEngineResult.Status [^java.lang.String name]
    (SSLEngineResult$Status/valueOf name)))

