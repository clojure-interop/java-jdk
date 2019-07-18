(ns jdk.io.PrintWriter
  "Prints formatted representations of objects to a text-output stream.  This
  class implements all of the print methods found in PrintStream.  It does not contain methods for writing raw bytes, for which
  a program should use unencoded byte streams.

   Unlike the PrintStream class, if automatic flushing is enabled
  it will be done only when one of the println, printf, or
  format methods is invoked, rather than whenever a newline character
  happens to be output.  These methods use the platform's own notion of line
  separator rather than the newline character.

   Methods in this class never throw I/O exceptions, although some of its
  constructors may.  The client may inquire as to whether any errors have
  occurred by invoking checkError()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PrintWriter]))

(defn ->print-writer
  "Constructor.

  Creates a new PrintWriter.

  out - A character-output stream - `java.io.Writer`
  auto-flush - A boolean; if true, the println, printf, or format methods will flush the output buffer - `boolean`"
  (^PrintWriter [^java.io.Writer out ^Boolean auto-flush]
    (new PrintWriter out auto-flush))
  (^PrintWriter [^java.io.Writer out]
    (new PrintWriter out)))

(defn printf
  "A convenience method to write a formatted string to this writer using
   the specified format string and arguments.  If automatic flushing is
   enabled, calls to this method will flush the output buffer.

    An invocation of this method of the form out.printf(l, format,
   args) behaves in exactly the same way as the invocation



       out.format(l, format, args)

  l - The java.util.locale to apply during formatting. If l is null then no localization is applied. - `java.util.Locale`
  format - A format string as described in Format string syntax. - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This writer - `java.io.PrintWriter`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.PrintWriter [^PrintWriter this ^java.util.Locale l ^java.lang.String format ^java.lang.Object args]
    (-> this (.printf l format args)))
  (^java.io.PrintWriter [^PrintWriter this ^java.lang.String format ^java.lang.Object args]
    (-> this (.printf format args))))

(defn flush
  "Flushes the stream."
  ([^PrintWriter this]
    (-> this (.flush))))

(defn println
  "Prints a boolean value and then terminates the line.  This method behaves
   as though it invokes print(boolean) and then
   println().

  x - the boolean value to be printed - `boolean`"
  ([^PrintWriter this ^Boolean x]
    (-> this (.println x)))
  ([^PrintWriter this]
    (-> this (.println))))

(defn close
  "Closes the stream and releases any system resources associated
   with it. Closing a previously closed stream has no effect."
  ([^PrintWriter this]
    (-> this (.close))))

(defn append
  "Appends a subsequence of the specified character sequence to this writer.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null, behaves in
   exactly the same way as the invocation



       out.write(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters `null`. - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This writer - `java.io.PrintWriter`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.io.PrintWriter [^PrintWriter this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.io.PrintWriter [^PrintWriter this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn print
  "Prints a boolean value.  The string produced by String.valueOf(boolean) is translated into bytes
   according to the platform's default character encoding, and these bytes
   are written in exactly the manner of the write(int) method.

  b - The boolean to be printed - `boolean`"
  ([^PrintWriter this ^Boolean b]
    (-> this (.print b))))

(defn write
  "Writes A Portion of an array of characters.

  buf - Array of characters - `char[]`
  off - Offset from which to start writing characters - `int`
  len - Number of characters to write - `int`"
  ([^PrintWriter this buf ^Integer off ^Integer len]
    (-> this (.write buf off len)))
  ([^PrintWriter this ^Integer c]
    (-> this (.write c))))

(defn check-error
  "Flushes the stream if it's not closed and checks its error state.

  returns: true if the print stream has encountered an error,
            either on the underlying output stream or during a format
            conversion. - `boolean`"
  (^Boolean [^PrintWriter this]
    (-> this (.checkError))))

(defn format
  "Writes a formatted string to this writer using the specified format
   string and arguments.  If automatic flushing is enabled, calls to this
   method will flush the output buffer.

  l - The java.util.locale to apply during formatting. If l is null then no localization is applied. - `java.util.Locale`
  format - A format string as described in Format string syntax. - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This writer - `java.io.PrintWriter`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.PrintWriter [^PrintWriter this ^java.util.Locale l ^java.lang.String format ^java.lang.Object args]
    (-> this (.format l format args)))
  (^java.io.PrintWriter [^PrintWriter this ^java.lang.String format ^java.lang.Object args]
    (-> this (.format format args))))

