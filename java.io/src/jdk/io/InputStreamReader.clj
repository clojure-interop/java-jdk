(ns jdk.io.InputStreamReader
  "An InputStreamReader is a bridge from byte streams to character streams: It
  reads bytes and decodes them into characters using a specified charset.  The charset that it uses
  may be specified by name or may be given explicitly, or the platform's
  default charset may be accepted.

   Each invocation of one of an InputStreamReader's read() methods may
  cause one or more bytes to be read from the underlying byte-input stream.
  To enable the efficient conversion of bytes to characters, more bytes may
  be read ahead from the underlying stream than are necessary to satisfy the
  current read operation.

   For top efficiency, consider wrapping an InputStreamReader within a
  BufferedReader.  For example:



  BufferedReader in
    = new BufferedReader(new InputStreamReader(System.in));"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io InputStreamReader]))

(defn ->input-stream-reader
  "Constructor.

  Creates an InputStreamReader that uses the named charset.

  in - An InputStream - `java.io.InputStream`
  charset-name - The name of a supported charset - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named charset is not supported"
  ([^java.io.InputStream in ^java.lang.String charset-name]
    (new InputStreamReader in charset-name))
  ([^java.io.InputStream in]
    (new InputStreamReader in)))

(defn get-encoding
  "Returns the name of the character encoding being used by this stream.

    If the encoding has an historical name then that name is returned;
   otherwise the encoding's canonical name is returned.

    If this instance was created with the InputStreamReader(InputStream, String) constructor then the returned
   name, being unique for the encoding, may differ from the name passed to
   the constructor. This method will return null if the
   stream has been closed.

  returns: The historical name of this encoding, or
           null if the stream has been closed - `java.lang.String`"
  ([^java.io.InputStreamReader this]
    (-> this (.getEncoding))))

(defn read
  "Reads characters into a portion of an array.

  cbuf - Destination buffer - `char[]`
  offset - Offset at which to start storing characters - `int`
  length - Maximum number of characters to read - `int`

  returns: The number of characters read, or -1 if the end of the
               stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.InputStreamReader this cbuf ^Integer offset ^Integer length]
    (-> this (.read cbuf offset length)))
  ([^java.io.InputStreamReader this]
    (-> this (.read))))

(defn ready
  "Tells whether this stream is ready to be read.  An InputStreamReader is
   ready if its input buffer is not empty, or if bytes are available to be
   read from the underlying byte stream.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.InputStreamReader this]
    (-> this (.ready))))

(defn close
  "Description copied from class: Reader

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.InputStreamReader this]
    (-> this (.close))))

