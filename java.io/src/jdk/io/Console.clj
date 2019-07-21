(ns jdk.io.Console
  "Methods to access the character-based console device, if any, associated
  with the current Java virtual machine.

   Whether a virtual machine has a console is dependent upon the
  underlying platform and also upon the manner in which the virtual
  machine is invoked.  If the virtual machine is started from an
  interactive command line without redirecting the standard input and
  output streams then its console will exist and will typically be
  connected to the keyboard and display from which the virtual machine
  was launched.  If the virtual machine is started automatically, for
  example by a background job scheduler, then it will typically not
  have a console.

  If this virtual machine has a console then it is represented by a
  unique instance of this class which can be obtained by invoking the
  System.console() method.  If no console device is
  available then an invocation of that method will return null.

  Read and write operations are synchronized to guarantee the atomic
  completion of critical operations; therefore invoking methods
  readLine(), readPassword(), format(),
  printf() as well as the read, format and write operations
  on the objects returned by reader() and writer() may
  block in multithreaded scenarios.

  Invoking close() on the objects returned by the reader()
  and the writer() will not close the underlying stream of those
  objects.

  The console-read methods return null when the end of the
  console input stream is reached, for example by typing control-D on
  Unix or control-Z on Windows.  Subsequent read operations will succeed
  if additional characters are later entered on the console's input
  device.

  Unless otherwise specified, passing a null argument to any method
  in this class will cause a NullPointerException to be thrown.

  Security note:
  If an application needs to read a password or other secure data, it should
  use readPassword() or readPassword(String, Object...) and
  manually zero the returned character array after processing to minimize the
  lifetime of sensitive data in memory.



  Console cons;
  char[] passwd;
  if ((cons = System.console()) != null &&
      (passwd = cons.readPassword(\"[%s]\", \"Password:\")) != null) {
      ...
      java.util.Arrays.fill(passwd, ' ');
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io Console]))

(defn writer
  "Retrieves the unique PrintWriter object
   associated with this console.

  returns: The printwriter associated with this console - `java.io.PrintWriter`"
  (^java.io.PrintWriter [^Console this]
    (-> this (.writer))))

(defn reader
  "Retrieves the unique Reader object associated
   with this console.

   This method is intended to be used by sophisticated applications, for
   example, a Scanner object which utilizes the rich
   parsing/scanning functionality provided by the Scanner:


   Console con = System.console();
   if (con != null) {
       Scanner sc = new Scanner(con.reader());
       ...
   }

   For simple applications requiring only line-oriented reading, use
   readLine(java.lang.String, java.lang.Object...).

   The bulk read operations read(char[]) ,
   read(char[], int, int)  and
   read(java.nio.CharBuffer)
   on the returned object will not read in characters beyond the line
   bound for each invocation, even if the destination buffer has space for
   more characters. The Reader's read methods may block if a
   line bound has not been entered or reached on the console's input device.
   A line bound is considered to be any one of a line feed ('\\n'),
   a carriage return ('\\r'), a carriage return followed immediately
   by a linefeed, or an end of stream.

  returns: The reader associated with this console - `java.io.Reader`"
  (^java.io.Reader [^Console this]
    (-> this (.reader))))

(defn format
  "Writes a formatted string to this console's output stream using
   the specified format string and arguments.

  fmt - A format string as described in Format string syntax - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This console - `java.io.Console`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.Console [^Console this ^java.lang.String fmt ^java.lang.Object args]
    (-> this (.format fmt args))))

(defn printf
  "A convenience method to write a formatted string to this console's
   output stream using the specified format string and arguments.

    An invocation of this method of the form con.printf(format,
   args) behaves in exactly the same way as the invocation of


  con.format(format, args).

  format - A format string as described in Format string syntax. - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The number of arguments is variable and may be zero. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. The behaviour on a null argument depends on the conversion. - `java.lang.Object`

  returns: This console - `java.io.Console`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.io.Console [^Console this ^java.lang.String format ^java.lang.Object args]
    (-> this (.printf format args))))

(defn read-line
  "Provides a formatted prompt, then reads a single line of text from the
   console.

  fmt - A format string as described in Format string syntax. - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. - `java.lang.Object`

  returns: A string containing the line read from the console, not
            including any line-termination characters, or null
            if an end of stream has been reached. - `java.lang.String`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  (^java.lang.String [^Console this ^java.lang.String fmt ^java.lang.Object args]
    (-> this (.readLine fmt args)))
  (^java.lang.String [^Console this]
    (-> this (.readLine))))

(defn read-password
  "Provides a formatted prompt, then reads a password or passphrase from
   the console with echoing disabled.

  fmt - A format string as described in Format string syntax for the prompt text. - `java.lang.String`
  args - Arguments referenced by the format specifiers in the format string. If there are more arguments than format specifiers, the extra arguments are ignored. The maximum number of arguments is limited by the maximum dimension of a Java array as defined by The Java™ Virtual Machine Specification. - `java.lang.Object`

  returns: A character array containing the password or passphrase read
            from the console, not including any line-termination characters,
            or null if an end of stream has been reached. - `char[]`

  throws: java.util.IllegalFormatException - If a format string contains an illegal syntax, a format specifier that is incompatible with the given arguments, insufficient arguments given the format string, or other illegal conditions. For specification of all possible formatting errors, see the Details section of the formatter class specification."
  ([^Console this ^java.lang.String fmt ^java.lang.Object args]
    (-> this (.readPassword fmt args)))
  ([^Console this]
    (-> this (.readPassword))))

(defn flush
  "Flushes the console and forces any buffered output to be written
   immediately ."
  ([^Console this]
    (-> this (.flush))))

