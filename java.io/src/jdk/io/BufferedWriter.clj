(ns jdk.io.BufferedWriter
  "Writes text to a character-output stream, buffering characters so as to
  provide for the efficient writing of single characters, arrays, and strings.

   The buffer size may be specified, or the default size may be accepted.
  The default is large enough for most purposes.

   A newLine() method is provided, which uses the platform's own notion of
  line separator as defined by the system property line.separator.
  Not all platforms use the newline character ('\n') to terminate lines.
  Calling this method to terminate each output line is therefore preferred to
  writing a newline character directly.

   In general, a Writer sends its output immediately to the underlying
  character or byte stream.  Unless prompt output is required, it is advisable
  to wrap a BufferedWriter around any Writer whose write() operations may be
  costly, such as FileWriters and OutputStreamWriters.  For example,



  PrintWriter out
    = new PrintWriter(new BufferedWriter(new FileWriter(`foo.out`)));

  will buffer the PrintWriter's output to the file.  Without buffering, each
  invocation of a print() method would cause characters to be converted into
  bytes that would then be written immediately to the file, which can be very
  inefficient."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io BufferedWriter]))

(defn ->buffered-writer
  "Constructor.

  Creates a new buffered character-output stream that uses an output
   buffer of the given size.

  out - A Writer - `java.io.Writer`
  sz - Output-buffer size, a positive integer - `int`

  throws: java.lang.IllegalArgumentException - If sz <= 0"
  ([^java.io.Writer out ^Integer sz]
    (new BufferedWriter out sz))
  ([^java.io.Writer out]
    (new BufferedWriter out)))

(defn write
  "Writes a portion of an array of characters.

    Ordinarily this method stores characters from the given array into
   this stream's buffer, flushing the buffer to the underlying stream as
   needed.  If the requested length is at least as large as the buffer,
   however, then this method will flush the buffer and write the characters
   directly to the underlying stream.  Thus redundant
   BufferedWriters will not copy data unnecessarily.

  cbuf - A character array - `char[]`
  off - Offset from which to start reading characters - `int`
  len - Number of characters to write - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.BufferedWriter this cbuf ^Integer off ^Integer len]
    (-> this (.write cbuf off len)))
  ([^java.io.BufferedWriter this ^Integer c]
    (-> this (.write c))))

(defn new-line
  "Writes a line separator.  The line separator string is defined by the
   system property line.separator, and is not necessarily a single
   newline ('\n') character.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.BufferedWriter this]
    (-> this (.newLine))))

(defn flush
  "Flushes the stream.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.BufferedWriter this]
    (-> this (.flush))))

(defn close
  "Description copied from class: Writer

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.BufferedWriter this]
    (-> this (.close))))

