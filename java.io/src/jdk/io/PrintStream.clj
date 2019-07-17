(ns jdk.io.PrintStream
  "A PrintStream adds functionality to another output stream,
  namely the ability to print representations of various data values
  conveniently.  Two other features are provided as well.  Unlike other output
  streams, a PrintStream never throws an
  IOException; instead, exceptional situations merely set an
  internal flag that can be tested via the checkError method.
  Optionally, a PrintStream can be created so as to flush
  automatically; this means that the flush method is
  automatically invoked after a byte array is written, one of the
  println methods is invoked, or a newline character or byte
  ('\n') is written.

   All characters printed by a PrintStream are converted into
  bytes using the platform's default character encoding.  The PrintWriter class should be used in situations that require writing
  characters rather than bytes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PrintStream]))

(defn ->print-stream
  "Constructor.

  Creates a new print stream.

  out - The output stream to which values and objects will be printed - `java.io.OutputStream`
  auto-flush - A boolean; if true, the output buffer will be flushed whenever a byte array is written, one of the println methods is invoked, or a newline character or byte ('\n') is written - `boolean`
  encoding - The name of a supported character encoding - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named encoding is not supported"
  ([^java.io.OutputStream out ^Boolean auto-flush ^java.lang.String encoding]
    (new PrintStream out auto-flush encoding))
  ([^java.io.OutputStream out ^Boolean auto-flush]
    (new PrintStream out auto-flush))
  ([^java.io.OutputStream out]
    (new PrintStream out)))

(defn printf
  "A convenience method to write a formatted string to this output stream
   using the specified format string and arguments.

    An invocation of this method of the form out.printf(l, format,
   args) behaves in exactly the same way as the invocation



       out.format(l, format, args)

  l - The java.util.locale to apply during formatting. If l is null then no localization is applied. - `java.util.Locale`
  format - A format string as described in Format string syntax - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This output stream - `java.io.PrintStream`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.PrintStream [^java.io.PrintStream this ^java.util.Locale l ^java.lang.String format ^java.lang.Object args]
    (-> this (.printf l format args)))
  (^java.io.PrintStream [^java.io.PrintStream this ^java.lang.String format ^java.lang.Object args]
    (-> this (.printf format args))))

(defn flush
  "Flushes the stream.  This is done by writing any buffered output bytes to
   the underlying output stream and then flushing that stream."
  ([^java.io.PrintStream this]
    (-> this (.flush))))

(defn println
  "Prints a boolean and then terminate the line.  This method behaves as
   though it invokes print(boolean) and then
   println().

  x - The boolean to be printed - `boolean`"
  ([^java.io.PrintStream this ^Boolean x]
    (-> this (.println x)))
  ([^java.io.PrintStream this]
    (-> this (.println))))

(defn close
  "Closes the stream.  This is done by flushing the stream and then closing
   the underlying output stream."
  ([^java.io.PrintStream this]
    (-> this (.close))))

(defn append
  "Appends a subsequence of the specified character sequence to this output
   stream.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null, behaves in
   exactly the same way as the invocation



       out.print(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters `null`. - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This output stream - `java.io.PrintStream`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.io.PrintStream [^java.io.PrintStream this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.io.PrintStream [^java.io.PrintStream this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn print
  "Prints a boolean value.  The string produced by String.valueOf(boolean) is translated into bytes
   according to the platform's default character encoding, and these bytes
   are written in exactly the manner of the
   write(int) method.

  b - The boolean to be printed - `boolean`"
  ([^java.io.PrintStream this ^Boolean b]
    (-> this (.print b))))

(defn write
  "Writes len bytes from the specified byte array starting at
   offset off to this stream.  If automatic flushing is
   enabled then the flush method will be invoked.

    Note that the bytes will be written as given; to write characters
   that will be translated according to the platform's default character
   encoding, use the print(char) or println(char)
   methods.

  buf - A byte array - `byte[]`
  off - Offset from which to start taking bytes - `int`
  len - Number of bytes to write - `int`"
  ([^java.io.PrintStream this buf ^Integer off ^Integer len]
    (-> this (.write buf off len)))
  ([^java.io.PrintStream this ^Integer b]
    (-> this (.write b))))

(defn check-error
  "Flushes the stream and checks its error state. The internal error state
   is set to true when the underlying output stream throws an
   IOException other than InterruptedIOException,
   and when the setError method is invoked.  If an operation
   on the underlying output stream throws an
   InterruptedIOException, then the PrintStream
   converts the exception back into an interrupt by doing:


       Thread.currentThread().interrupt();
   or the equivalent.

  returns: true if and only if this stream has encountered an
           IOException other than
           InterruptedIOException, or the
           setError method has been invoked - `boolean`"
  (^Boolean [^java.io.PrintStream this]
    (-> this (.checkError))))

(defn format
  "Writes a formatted string to this output stream using the specified
   format string and arguments.

  l - The java.util.locale to apply during formatting. If l is null then no localization is applied. - `java.util.Locale`
  format - A format string as described in Format string syntax - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This output stream - `java.io.PrintStream`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.PrintStream [^java.io.PrintStream this ^java.util.Locale l ^java.lang.String format ^java.lang.Object args]
    (-> this (.format l format args)))
  (^java.io.PrintStream [^java.io.PrintStream this ^java.lang.String format ^java.lang.Object args]
    (-> this (.format format args))))

