(ns jdk.io.StringWriter
  "A character stream that collects its output in a string buffer, which can
  then be used to construct a string.

  Closing a StringWriter has no effect. The methods in this class
  can be called after the stream has been closed without generating an
  IOException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io StringWriter]))

(defn ->string-writer
  "Constructor.

  Create a new string writer using the specified initial string-buffer
   size.

  initial-size - The number of char values that will fit into this buffer before it is automatically expanded - `int`

  throws: java.lang.IllegalArgumentException - If initialSize is negative"
  (^StringWriter [^Integer initial-size]
    (new StringWriter initial-size))
  (^StringWriter []
    (new StringWriter )))

(defn write
  "Write a portion of an array of characters.

  cbuf - Array of characters - `char[]`
  off - Offset from which to start writing characters - `int`
  len - Number of characters to write - `int`"
  ([^StringWriter this cbuf ^Integer off ^Integer len]
    (-> this (.write cbuf off len)))
  ([^StringWriter this ^Integer c]
    (-> this (.write c))))

(defn append
  "Appends a subsequence of the specified character sequence to this writer.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null, behaves in
   exactly the same way as the invocation



       out.write(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters `null`. - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This writer - `java.io.StringWriter`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.io.StringWriter [^StringWriter this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.io.StringWriter [^StringWriter this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn to-string
  "Return the buffer's current value as a string.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^StringWriter this]
    (-> this (.toString))))

(defn get-buffer
  "Return the string buffer itself.

  returns: StringBuffer holding the current buffer value. - `java.lang.StringBuffer`"
  (^java.lang.StringBuffer [^StringWriter this]
    (-> this (.getBuffer))))

(defn flush
  "Flush the stream."
  ([^StringWriter this]
    (-> this (.flush))))

(defn close
  "Closing a StringWriter has no effect. The methods in this
   class can be called after the stream has been closed without generating
   an IOException.

  throws: java.io.IOException - If an I/O error occurs"
  ([^StringWriter this]
    (-> this (.close))))

