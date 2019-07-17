(ns jdk.io.LineNumberReader
  "A buffered character-input stream that keeps track of line numbers.  This
  class defines methods setLineNumber(int) and getLineNumber() for setting and getting the current line number
  respectively.

   By default, line numbering begins at 0. This number increments at every
  line terminator as the data is read, and can be changed
  with a call to setLineNumber(int).  Note however, that
  setLineNumber(int) does not actually change the current position in
  the stream; it only changes the value that will be returned by
  getLineNumber().

   A line is considered to be terminated by any one of a
  line feed ('\n'), a carriage return ('\r'), or a carriage return followed
  immediately by a linefeed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io LineNumberReader]))

(defn ->line-number-reader
  "Constructor.

  Create a new line-numbering reader, reading characters into a buffer of
   the given size.

  in - A Reader object to provide the underlying stream - `java.io.Reader`
  sz - An int specifying the size of the buffer - `int`"
  ([^java.io.Reader in ^Integer sz]
    (new LineNumberReader in sz))
  ([^java.io.Reader in]
    (new LineNumberReader in)))

(defn set-line-number
  "Set the current line number.

  line-number - An int specifying the line number - `int`"
  ([^java.io.LineNumberReader this ^Integer line-number]
    (-> this (.setLineNumber line-number))))

(defn get-line-number
  "Get the current line number.

  returns: The current line number - `int`"
  ([^java.io.LineNumberReader this]
    (-> this (.getLineNumber))))

(defn read
  "Read characters into a portion of an array.  Whenever a line terminator is read the current line number is
   incremented.

  cbuf - Destination buffer - `char[]`
  off - Offset at which to start storing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The number of bytes read, or -1 if the end of the stream has
            already been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.LineNumberReader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  ([^java.io.LineNumberReader this]
    (-> this (.read))))

(defn read-line
  "Read a line of text.  Whenever a line terminator is
   read the current line number is incremented.

  returns: A String containing the contents of the line, not including
            any line termination characters, or
            null if the end of the stream has been reached - `java.lang.String`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.LineNumberReader this]
    (-> this (.readLine))))

(defn skip
  "Skip characters.

  n - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.LineNumberReader this ^Long n]
    (-> this (.skip n))))

(defn mark
  "Mark the present position in the stream.  Subsequent calls to reset()
   will attempt to reposition the stream to this point, and will also reset
   the line number appropriately.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. After reading this many characters, attempting to reset the stream may fail. - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.LineNumberReader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Reset the stream to the most recent mark.

  throws: java.io.IOException - If the stream has not been marked, or if the mark has been invalidated"
  ([^java.io.LineNumberReader this]
    (-> this (.reset))))

