(ns jdk.util.Scanner
  "A simple text scanner which can parse primitive types and strings using
  regular expressions.

  A Scanner breaks its input into tokens using a
  delimiter pattern, which by default matches whitespace. The resulting
  tokens may then be converted into values of different types using the
  various next methods.

  For example, this code allows a user to read a number from
  System.in:


      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();

  As another example, this code allows long types to be
  assigned from entries in a file myNumbers:


       Scanner sc = new Scanner(new File(`myNumbers`));
       while (sc.hasNextLong()) {
           long aLong = sc.nextLong();
       }

  The scanner can also use delimiters other than whitespace. This
  example reads several items in from a string:


      String input = `1 fish 2 fish red fish blue fish`;
      Scanner s = new Scanner(input).useDelimiter(`\\s*fish\\s*`);
      System.out.println(s.nextInt());
      System.out.println(s.nextInt());
      System.out.println(s.next());
      System.out.println(s.next());
      s.close();

  prints the following output:


      1
      2
      red
      blue

  The same output can be generated with this code, which uses a regular
  expression to parse all four tokens at once:


      String input = `1 fish 2 fish red fish blue fish`;
      Scanner s = new Scanner(input);
      s.findInLine(`(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)`);
      MatchResult result = s.match();
      for (int i=1; i<=result.groupCount(); i++)
          System.out.println(result.group(i));
      s.close();

  The default whitespace delimiter used
  by a scanner is as recognized by Character.isWhitespace. The reset()
  method will reset the value of the scanner's delimiter to the default
  whitespace delimiter regardless of whether it was previously changed.

  A scanning operation may block waiting for input.

  The next() and hasNext() methods and their
  primitive-type companion methods (such as nextInt() and
  hasNextInt()) first skip any input that matches the delimiter
  pattern, and then attempt to return the next token. Both hasNext
  and next methods may block waiting for further input.  Whether a
  hasNext method blocks has no connection to whether or not its
  associated next method will block.

   The findInLine(java.lang.String), findWithinHorizon(java.lang.String, int), and skip(java.util.regex.Pattern)
  methods operate independently of the delimiter pattern. These methods will
  attempt to match the specified pattern with no regard to delimiters in the
  input and thus can be used in special circumstances where delimiters are
  not relevant. These methods may block waiting for more input.

  When a scanner throws an InputMismatchException, the scanner
  will not pass the token that caused the exception, so that it may be
  retrieved or skipped via some other method.

  Depending upon the type of delimiting pattern, empty tokens may be
  returned. For example, the pattern `\\s+` will return no empty
  tokens since it matches multiple instances of the delimiter. The delimiting
  pattern `\\s` could return empty tokens since it only passes one
  space at a time.

   A scanner can read text from any object which implements the Readable interface.  If an invocation of the underlying
  readable's Readable.read(java.nio.CharBuffer) method throws an IOException then the scanner assumes that the end of the input
  has been reached.  The most recent IOException thrown by the
  underlying readable can be retrieved via the ioException() method.

  When a Scanner is closed, it will close its input source
  if the source implements the Closeable interface.

  A Scanner is not safe for multithreaded use without
  external synchronization.

  Unless otherwise mentioned, passing a null parameter into
  any method of a Scanner will cause a
  NullPointerException to be thrown.

  A scanner will default to interpreting numbers as decimal unless a
  different radix has been set by using the useRadix(int) method. The
  reset() method will reset the value of the scanner's radix to
  10 regardless of whether it was previously changed.

   Localized numbers

   An instance of this class is capable of scanning numbers in the standard
  formats as well as in the formats of the scanner's locale. A scanner's
  initial locale is the value returned by the Locale.getDefault(Locale.Category.FORMAT) method; it may be changed via the useLocale(java.util.Locale) method. The reset() method will reset the value of the
  scanner's locale to the initial locale regardless of whether it was
  previously changed.

  The localized formats are defined in terms of the following parameters,
  which for a particular locale are taken from that locale's DecimalFormat object, df, and its and
  DecimalFormatSymbols object,
  dfs.


      LocalGroupSeparator
          The character used to separate thousands groups,
          i.e., dfs.getGroupingSeparator()
      LocalDecimalSeparator
          The character used for the decimal point,
      i.e., dfs.getDecimalSeparator()
      LocalPositivePrefix
          The string that appears before a positive number (may
          be empty), i.e., df.getPositivePrefix()
      LocalPositiveSuffix
          The string that appears after a positive number (may be
          empty), i.e., df.getPositiveSuffix()
      LocalNegativePrefix
          The string that appears before a negative number (may
          be empty), i.e., df.getNegativePrefix()
      LocalNegativeSuffix
          The string that appears after a negative number (may be
          empty), i.e., df.getNegativeSuffix()
      LocalNaN
          The string that represents not-a-number for
          floating-point values,
          i.e., dfs.getNaN()
      LocalInfinity
          The string that represents infinity for floating-point
          values, i.e., dfs.getInfinity()


   Number syntax

   The strings that can be parsed as numbers by an instance of this class
  are specified in terms of the following regular-expression grammar, where
  Rmax is the highest digit in the radix being used (for example, Rmax is 9 in base 10).


    NonAsciiDigit:
        A non-ASCII character c for which
             Character.isDigit(c)
                         returns true

    Non0Digit:
        [1-Rmax] | NonASCIIDigit

    Digit:
        [0-Rmax] | NonASCIIDigit

    GroupedNumeral:
        ( Non0Digit
                    Digit?
                    Digit?
            ( LocalGroupSeparator
                          Digit
                          Digit
                          Digit )+ )

    Numeral:
        ( ( Digit+ )
                | GroupedNumeral )

    Integer:
        ( [-+]? ( Numeral
                                ) )
        | LocalPositivePrefix Numeral
                       LocalPositiveSuffix
        | LocalNegativePrefix Numeral
                  LocalNegativeSuffix

    DecimalNumeral:
        Numeral
        | Numeral
                  LocalDecimalSeparator
                  Digit*
        | LocalDecimalSeparator
                  Digit+

    Exponent:
        ( [eE] [+-]? Digit+ )

    Decimal:
        ( [-+]? DecimalNumeral
                          Exponent? )
        | LocalPositivePrefix
                  DecimalNumeral
                  LocalPositiveSuffix
                  Exponent?
        | LocalNegativePrefix
                  DecimalNumeral
                  LocalNegativeSuffix
                  Exponent?

    HexFloat:
        [-+]? 0[xX][0-9a-fA-F]*\.[0-9a-fA-F]+
                  ([pP][-+]?[0-9]+)?

    NonNumber:
        NaN
                           | LocalNan
                           | Infinity
                           | LocalInfinity

    SignedNonNumber:
        ( [-+]? NonNumber )
        | LocalPositivePrefix
                  NonNumber
                  LocalPositiveSuffix
        | LocalNegativePrefix
                  NonNumber
                  LocalNegativeSuffix

    Float:
        Decimal
            | HexFloat
            | SignedNonNumber


  Whitespace is not significant in the above regular expressions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Scanner]))

(defn ->scanner
  "Constructor.

  Constructs a new Scanner that produces values scanned
   from the specified input stream. Bytes from the stream are converted
   into characters using the specified charset.

  source - An input stream to be scanned - `java.io.InputStream`
  charset-name - The encoding type used to convert bytes from the stream into characters to be scanned - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the specified character set does not exist"
  ([^java.io.InputStream source ^java.lang.String charset-name]
    (new Scanner source charset-name))
  ([^java.lang.Readable source]
    (new Scanner source)))

(defn skip
  "Skips input that matches the specified pattern, ignoring delimiters.
   This method will skip input if an anchored match of the specified
   pattern succeeds.

   If a match to the specified pattern is not found at the
   current position, then no input is skipped and a
   NoSuchElementException is thrown.

   Since this method seeks to match the specified pattern starting at
   the scanner's current position, patterns that can match a lot of
   input (`.*`, for example) may cause the scanner to buffer a large
   amount of input.

   Note that it is possible to skip something without risking a
   NoSuchElementException by using a pattern that can
   match nothing, e.g., sc.skip(`[ \t]*`).

  pattern - a string specifying the pattern to skip over - `java.util.regex.Pattern`

  returns: this scanner - `java.util.Scanner`

  throws: java.util.NoSuchElementException - if the specified pattern is not found"
  (^java.util.Scanner [^java.util.Scanner this ^java.util.regex.Pattern pattern]
    (-> this (.skip pattern))))

(defn has-next-boolean?
  "Returns true if the next token in this scanner's input can be
   interpreted as a boolean value using a case insensitive pattern
   created from the string `true|false`.  The scanner does not
   advance past the input that matched.

  returns: true if and only if this scanner's next token is a valid
           boolean value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextBoolean))))

(defn next-big-integer
  "Scans the next token of the input as a BigInteger.

    If the next token matches the Integer regular expression defined
   above then the token is converted into a BigInteger value as if
   by removing all group separators, mapping non-ASCII digits into ASCII
   digits via the Character.digit, and passing the
   resulting string to the BigInteger(String, int) constructor with the specified radix.

  radix - the radix used to interpret the token - `int`

  returns: the BigInteger scanned from the input - `java.math.BigInteger`

  throws: java.util.InputMismatchException - if the next token does not match the Integer regular expression, or is out of range"
  (^java.math.BigInteger [^java.util.Scanner this ^Integer radix]
    (-> this (.nextBigInteger radix)))
  (^java.math.BigInteger [^java.util.Scanner this]
    (-> this (.nextBigInteger))))

(defn next
  "Returns the next token if it matches the pattern constructed from the
   specified string.  If the match is successful, the scanner advances
   past the input that matched the pattern.

    An invocation of this method of the form next(pattern)
   behaves in exactly the same way as the invocation
   next(Pattern.compile(pattern)).

  pattern - a string specifying the pattern to scan - `java.lang.String`

  returns: the next token - `java.lang.String`

  throws: java.util.NoSuchElementException - if no such tokens are available"
  (^java.lang.String [^java.util.Scanner this ^java.lang.String pattern]
    (-> this (.next pattern)))
  (^java.lang.String [^java.util.Scanner this]
    (-> this (.next))))

(defn has-next-float?
  "Returns true if the next token in this scanner's input can be
   interpreted as a float value using the nextFloat()
   method. The scanner does not advance past any input.

  returns: true if and only if this scanner's next token is a valid
           float value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextFloat))))

(defn use-delimiter
  "Sets this scanner's delimiting pattern to the specified pattern.

  pattern - A delimiting pattern - `java.util.regex.Pattern`

  returns: this scanner - `java.util.Scanner`"
  (^java.util.Scanner [^java.util.Scanner this ^java.util.regex.Pattern pattern]
    (-> this (.useDelimiter pattern))))

(defn find-within-horizon
  "Attempts to find the next occurrence of a pattern constructed from the
   specified string, ignoring delimiters.

   An invocation of this method of the form
   findWithinHorizon(pattern) behaves in exactly the same way as
   the invocation
   findWithinHorizon(Pattern.compile(pattern, horizon)).

  pattern - a string specifying the pattern to search for - `java.lang.String`
  horizon - the search horizon - `int`

  returns: the text that matched the specified pattern - `java.lang.String`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^java.lang.String [^java.util.Scanner this ^java.lang.String pattern ^Integer horizon]
    (-> this (.findWithinHorizon pattern horizon))))

(defn find-in-line
  "Attempts to find the next occurrence of a pattern constructed from the
   specified string, ignoring delimiters.

   An invocation of this method of the form findInLine(pattern)
   behaves in exactly the same way as the invocation
   findInLine(Pattern.compile(pattern)).

  pattern - a string specifying the pattern to search for - `java.lang.String`

  returns: the text that matched the specified pattern - `java.lang.String`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^java.lang.String [^java.util.Scanner this ^java.lang.String pattern]
    (-> this (.findInLine pattern))))

(defn next-float
  "Scans the next token of the input as a float.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid float value as
   described below. If the translation is successful, the scanner advances
   past the input that matched.

    If the next token matches the Float regular expression defined above
   then the token is converted into a float value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Float.parseFloat. If the token matches
   the localized NaN or infinity strings, then either `Nan` or `Infinity`
   is passed to Float.parseFloat as
   appropriate.

  returns: the float scanned from the input - `float`

  throws: java.util.InputMismatchException - if the next token does not match the Float regular expression, or is out of range"
  (^Float [^java.util.Scanner this]
    (-> this (.nextFloat))))

(defn next-int
  "Scans the next token of the input as an int.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid int value as
   described below. If the translation is successful, the scanner advances
   past the input that matched.

    If the next token matches the Integer regular expression defined
   above then the token is converted into an int value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Integer.parseInt with the
   specified radix.

  radix - the radix used to interpret the token as an int value - `int`

  returns: the int scanned from the input - `int`

  throws: java.util.InputMismatchException - if the next token does not match the Integer regular expression, or is out of range"
  (^Integer [^java.util.Scanner this ^Integer radix]
    (-> this (.nextInt radix)))
  (^Integer [^java.util.Scanner this]
    (-> this (.nextInt))))

(defn to-string
  "Returns the string representation of this Scanner. The
   string representation of a Scanner contains information
   that may be useful for debugging. The exact format is unspecified.

  returns: The string representation of this scanner - `java.lang.String`"
  (^java.lang.String [^java.util.Scanner this]
    (-> this (.toString))))

(defn has-next-short?
  "Returns true if the next token in this scanner's input can be
   interpreted as a short value in the specified radix using the
   nextShort() method. The scanner does not advance past any input.

  radix - the radix used to interpret the token as a short value - `int`

  returns: true if and only if this scanner's next token is a valid
           short value in the specified radix - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^Integer radix]
    (-> this (.hasNextShort radix)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextShort))))

(defn reset
  "Resets this scanner.

    Resetting a scanner discards all of its explicit state
   information which may have been changed by invocations of useDelimiter(java.util.regex.Pattern), useLocale(java.util.Locale), or useRadix(int).

    An invocation of this method of the form
   scanner.reset() behaves in exactly the same way as the
   invocation



     scanner.useDelimiter(`\\p{javaWhitespace}+`)
            .useLocale(Locale.getDefault(Locale.Category.FORMAT))
            .useRadix(10);

  returns: this scanner - `java.util.Scanner`"
  (^java.util.Scanner [^java.util.Scanner this]
    (-> this (.reset))))

(defn has-next-big-integer?
  "Returns true if the next token in this scanner's input can be
   interpreted as a BigInteger in the specified radix using
   the nextBigInteger() method. The scanner does not advance past
   any input.

  radix - the radix used to interpret the token as an integer - `int`

  returns: true if and only if this scanner's next token is a valid
           BigInteger - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^Integer radix]
    (-> this (.hasNextBigInteger radix)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextBigInteger))))

(defn has-next-byte?
  "Returns true if the next token in this scanner's input can be
   interpreted as a byte value in the specified radix using the
   nextByte() method. The scanner does not advance past any input.

  radix - the radix used to interpret the token as a byte value - `int`

  returns: true if and only if this scanner's next token is a valid
           byte value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^Integer radix]
    (-> this (.hasNextByte radix)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextByte))))

(defn next-short
  "Scans the next token of the input as a short.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid short value as
   described below. If the translation is successful, the scanner advances
   past the input that matched.

    If the next token matches the Integer regular expression defined
   above then the token is converted into a short value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Short.parseShort with the
   specified radix.

  radix - the radix used to interpret the token as a short value - `int`

  returns: the short scanned from the input - `short`

  throws: java.util.InputMismatchException - if the next token does not match the Integer regular expression, or is out of range"
  (^Short [^java.util.Scanner this ^Integer radix]
    (-> this (.nextShort radix)))
  (^Short [^java.util.Scanner this]
    (-> this (.nextShort))))

(defn next-long
  "Scans the next token of the input as a long.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid long value as
   described below. If the translation is successful, the scanner advances
   past the input that matched.

    If the next token matches the Integer regular expression defined
   above then the token is converted into a long value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Long.parseLong with the
   specified radix.

  radix - the radix used to interpret the token as an int value - `int`

  returns: the long scanned from the input - `long`

  throws: java.util.InputMismatchException - if the next token does not match the Integer regular expression, or is out of range"
  (^Long [^java.util.Scanner this ^Integer radix]
    (-> this (.nextLong radix)))
  (^Long [^java.util.Scanner this]
    (-> this (.nextLong))))

(defn locale
  "Returns this scanner's locale.

   A scanner's locale affects many elements of its default
   primitive matching regular expressions; see
   localized numbers above.

  returns: this scanner's locale - `java.util.Locale`"
  (^java.util.Locale [^java.util.Scanner this]
    (-> this (.locale))))

(defn has-next-int?
  "Returns true if the next token in this scanner's input can be
   interpreted as an int value in the specified radix using the
   nextInt() method. The scanner does not advance past any input.

  radix - the radix used to interpret the token as an int value - `int`

  returns: true if and only if this scanner's next token is a valid
           int value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^Integer radix]
    (-> this (.hasNextInt radix)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextInt))))

(defn io-exception
  "Returns the IOException last thrown by this
   Scanner's underlying Readable. This method
   returns null if no such exception exists.

  returns: the last exception thrown by this scanner's readable - `java.io.IOException`"
  (^java.io.IOException [^java.util.Scanner this]
    (-> this (.ioException))))

(defn delimiter
  "Returns the Pattern this Scanner is currently
   using to match delimiters.

  returns: this scanner's delimiting pattern. - `java.util.regex.Pattern`"
  (^java.util.regex.Pattern [^java.util.Scanner this]
    (-> this (.delimiter))))

(defn remove
  "The remove operation is not supported by this implementation of
   Iterator.

  throws: java.lang.UnsupportedOperationException - if this method is invoked."
  ([^java.util.Scanner this]
    (-> this (.remove))))

(defn has-next?
  "Returns true if the next token matches the pattern constructed from the
   specified string. The scanner does not advance past any input.

    An invocation of this method of the form hasNext(pattern)
   behaves in exactly the same way as the invocation
   hasNext(Pattern.compile(pattern)).

  pattern - a string specifying the pattern to scan - `java.lang.String`

  returns: true if and only if this scanner has another token matching
           the specified pattern - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^java.lang.String pattern]
    (-> this (.hasNext pattern)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNext))))

(defn next-byte
  "Scans the next token of the input as a byte.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid byte value as
   described below. If the translation is successful, the scanner advances
   past the input that matched.

    If the next token matches the Integer regular expression defined
   above then the token is converted into a byte value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Byte.parseByte with the
   specified radix.

  radix - the radix used to interpret the token as a byte value - `int`

  returns: the byte scanned from the input - `byte`

  throws: java.util.InputMismatchException - if the next token does not match the Integer regular expression, or is out of range"
  (^Byte [^java.util.Scanner this ^Integer radix]
    (-> this (.nextByte radix)))
  (^Byte [^java.util.Scanner this]
    (-> this (.nextByte))))

(defn has-next-double?
  "Returns true if the next token in this scanner's input can be
   interpreted as a double value using the nextDouble()
   method. The scanner does not advance past any input.

  returns: true if and only if this scanner's next token is a valid
           double value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextDouble))))

(defn next-line
  "Advances this scanner past the current line and returns the input
   that was skipped.

   This method returns the rest of the current line, excluding any line
   separator at the end. The position is set to the beginning of the next
   line.

   Since this method continues to search through the input looking
   for a line separator, it may buffer all of the input searching for
   the line to skip if no line separators are present.

  returns: the line that was skipped - `java.lang.String`

  throws: java.util.NoSuchElementException - if no line was found"
  (^java.lang.String [^java.util.Scanner this]
    (-> this (.nextLine))))

(defn close
  "Closes this scanner.

    If this scanner has not yet been closed then if its underlying
   java.lang.readable also implements the Closeable interface then the readable's close method
   will be invoked.  If this scanner is already closed then invoking this
   method will have no effect.

   Attempting to perform search operations after a scanner has
   been closed will result in an IllegalStateException."
  ([^java.util.Scanner this]
    (-> this (.close))))

(defn next-big-decimal
  "Scans the next token of the input as a BigDecimal.

    If the next token matches the Decimal regular expression defined
   above then the token is converted into a BigDecimal value as if
   by removing all group separators, mapping non-ASCII digits into ASCII
   digits via the Character.digit, and passing the
   resulting string to the BigDecimal(String)
   constructor.

  returns: the BigDecimal scanned from the input - `java.math.BigDecimal`

  throws: java.util.InputMismatchException - if the next token does not match the Decimal regular expression, or is out of range"
  (^java.math.BigDecimal [^java.util.Scanner this]
    (-> this (.nextBigDecimal))))

(defn use-locale
  "Sets this scanner's locale to the specified locale.

   A scanner's locale affects many elements of its default
   primitive matching regular expressions; see
   localized numbers above.

   Invoking the reset() method will set the scanner's locale to
   the initial locale.

  locale - A string specifying the locale to use - `java.util.Locale`

  returns: this scanner - `java.util.Scanner`"
  (^java.util.Scanner [^java.util.Scanner this ^java.util.Locale locale]
    (-> this (.useLocale locale))))

(defn match
  "Returns the match result of the last scanning operation performed
   by this scanner. This method throws IllegalStateException
   if no match has been performed, or if the last match was
   not successful.

   The various nextmethods of Scanner
   make a match result available if they complete without throwing an
   exception. For instance, after an invocation of the nextInt()
   method that returned an int, this method returns a
   MatchResult for the search of the
   Integer regular expression
   defined above. Similarly the findInLine(java.lang.String),
   findWithinHorizon(java.lang.String, int), and skip(java.util.regex.Pattern) methods will make a
   match available if they succeed.

  returns: a match result for the last match operation - `java.util.regex.MatchResult`

  throws: java.lang.IllegalStateException - If no match result is available"
  (^java.util.regex.MatchResult [^java.util.Scanner this]
    (-> this (.match))))

(defn has-next-big-decimal?
  "Returns true if the next token in this scanner's input can be
   interpreted as a BigDecimal using the
   nextBigDecimal() method. The scanner does not advance past any
   input.

  returns: true if and only if this scanner's next token is a valid
           BigDecimal - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextBigDecimal))))

(defn has-next-line?
  "Returns true if there is another line in the input of this scanner.
   This method may block while waiting for input. The scanner does not
   advance past any input.

  returns: true if and only if this scanner has another line of input - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextLine))))

(defn use-radix
  "Sets this scanner's default radix to the specified radix.

   A scanner's radix affects elements of its default
   number matching regular expressions; see
   localized numbers above.

   If the radix is less than Character.MIN_RADIX
   or greater than Character.MAX_RADIX, then an
   IllegalArgumentException is thrown.

   Invoking the reset() method will set the scanner's radix to
   10.

  radix - The radix to use when scanning numbers - `int`

  returns: this scanner - `java.util.Scanner`

  throws: java.lang.IllegalArgumentException - if radix is out of range"
  (^java.util.Scanner [^java.util.Scanner this ^Integer radix]
    (-> this (.useRadix radix))))

(defn next-double
  "Scans the next token of the input as a double.
   This method will throw InputMismatchException
   if the next token cannot be translated into a valid double value.
   If the translation is successful, the scanner advances past the input
   that matched.

    If the next token matches the Float regular expression defined above
   then the token is converted into a double value as if by
   removing all locale specific prefixes, group separators, and locale
   specific suffixes, then mapping non-ASCII digits into ASCII
   digits via Character.digit, prepending a
   negative sign (-) if the locale specific negative prefixes and suffixes
   were present, and passing the resulting string to
   Double.parseDouble. If the token matches
   the localized NaN or infinity strings, then either `Nan` or `Infinity`
   is passed to Double.parseDouble as
   appropriate.

  returns: the double scanned from the input - `double`

  throws: java.util.InputMismatchException - if the next token does not match the Float regular expression, or is out of range"
  (^Double [^java.util.Scanner this]
    (-> this (.nextDouble))))

(defn next-boolean
  "Scans the next token of the input into a boolean value and returns
   that value. This method will throw InputMismatchException
   if the next token cannot be translated into a valid boolean value.
   If the match is successful, the scanner advances past the input that
   matched.

  returns: the boolean scanned from the input - `boolean`

  throws: java.util.InputMismatchException - if the next token is not a valid boolean"
  (^Boolean [^java.util.Scanner this]
    (-> this (.nextBoolean))))

(defn has-next-long?
  "Returns true if the next token in this scanner's input can be
   interpreted as a long value in the specified radix using the
   nextLong() method. The scanner does not advance past any input.

  radix - the radix used to interpret the token as a long value - `int`

  returns: true if and only if this scanner's next token is a valid
           long value - `boolean`

  throws: java.lang.IllegalStateException - if this scanner is closed"
  (^Boolean [^java.util.Scanner this ^Integer radix]
    (-> this (.hasNextLong radix)))
  (^Boolean [^java.util.Scanner this]
    (-> this (.hasNextLong))))

(defn radix
  "Returns this scanner's default radix.

   A scanner's radix affects elements of its default
   number matching regular expressions; see
   localized numbers above.

  returns: the default radix of this scanner - `int`"
  (^Integer [^java.util.Scanner this]
    (-> this (.radix))))

