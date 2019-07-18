(ns jdk.io.OutputStreamWriter
  "An OutputStreamWriter is a bridge from character streams to byte streams:
  Characters written to it are encoded into bytes using a specified charset.  The charset that it uses
  may be specified by name or may be given explicitly, or the platform's
  default charset may be accepted.

   Each invocation of a write() method causes the encoding converter to be
  invoked on the given character(s).  The resulting bytes are accumulated in a
  buffer before being written to the underlying output stream.  The size of
  this buffer may be specified, but by default it is large enough for most
  purposes.  Note that the characters passed to the write() methods are not
  buffered.

   For top efficiency, consider wrapping an OutputStreamWriter within a
  BufferedWriter so as to avoid frequent converter invocations.  For example:



  Writer out
    = new BufferedWriter(new OutputStreamWriter(System.out));

   A surrogate pair is a character represented by a sequence of two
  char values: A high surrogate in the range '\uD800' to
  '\uDBFF' followed by a low surrogate in the range '\uDC00' to
  '\uDFFF'.

   A malformed surrogate element is a high surrogate that is not
  followed by a low surrogate or a low surrogate that is not preceded by a
  high surrogate.

   This class always replaces malformed surrogate elements and unmappable
  character sequences with the charset's default substitution sequence.
  The java.nio.charset.CharsetEncoder class should be used when more
  control over the encoding process is required."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io OutputStreamWriter]))

(defn ->output-stream-writer
  "Constructor.

  Creates an OutputStreamWriter that uses the named charset.

  out - An OutputStream - `java.io.OutputStream`
  charset-name - The name of a supported charset - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named encoding is not supported"
  (^OutputStreamWriter [^java.io.OutputStream out ^java.lang.String charset-name]
    (new OutputStreamWriter out charset-name))
  (^OutputStreamWriter [^java.io.OutputStream out]
    (new OutputStreamWriter out)))

(defn get-encoding
  "Returns the name of the character encoding being used by this stream.

    If the encoding has an historical name then that name is returned;
   otherwise the encoding's canonical name is returned.

    If this instance was created with the OutputStreamWriter(OutputStream, String) constructor then the returned
   name, being unique for the encoding, may differ from the name passed to
   the constructor.  This method may return null if the stream has
   been closed.

  returns: The historical name of this encoding, or possibly
           null if the stream has been closed - `java.lang.String`"
  (^java.lang.String [^OutputStreamWriter this]
    (-> this (.getEncoding))))

(defn write
  "Writes a portion of an array of characters.

  cbuf - Buffer of characters - `char[]`
  off - Offset from which to start writing characters - `int`
  len - Number of characters to write - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^OutputStreamWriter this cbuf ^Integer off ^Integer len]
    (-> this (.write cbuf off len)))
  ([^OutputStreamWriter this ^Integer c]
    (-> this (.write c))))

(defn flush
  "Flushes the stream.

  throws: java.io.IOException - If an I/O error occurs"
  ([^OutputStreamWriter this]
    (-> this (.flush))))

(defn close
  "Description copied from class: Writer

  throws: java.io.IOException - If an I/O error occurs"
  ([^OutputStreamWriter this]
    (-> this (.close))))

