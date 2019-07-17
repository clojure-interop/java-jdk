(ns jdk.io.StreamTokenizer
  "The StreamTokenizer class takes an input stream and
  parses it into `tokens`, allowing the tokens to be
  read one at a time. The parsing process is controlled by a table
  and a number of flags that can be set to various states. The
  stream tokenizer can recognize identifiers, numbers, quoted
  strings, and various comment styles.

  Each byte read from the input stream is regarded as a character
  in the range '\u0000' through '\u00FF'.
  The character value is used to look up five possible attributes of
  the character: white space, alphabetic,
  numeric, string quote, and comment character.
  Each character can have zero or more of these attributes.

  In addition, an instance has four flags. These flags indicate:

  Whether line terminators are to be returned as tokens or treated
      as white space that merely separates tokens.
  Whether C-style comments are to be recognized and skipped.
  Whether C++-style comments are to be recognized and skipped.
  Whether the characters of identifiers are converted to lowercase.


  A typical application first constructs an instance of this class,
  sets up the syntax tables, and then repeatedly loops calling the
  nextToken method in each iteration of the loop until
  it returns the value TT_EOF."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io StreamTokenizer]))

(defn ->stream-tokenizer
  "Constructor.

  Create a tokenizer that parses the given character stream.

  r - a Reader object providing the input stream. - `java.io.Reader`"
  ([r]
    (new StreamTokenizer r)))

(defn -ttype
  "Instance Field.

  After a call to the nextToken method, this field
   contains the type of the token just read. For a single character
   token, its value is the single character, converted to an integer.
   For a quoted string token, its value is the quote character.
   Otherwise, its value is one of the following:

   TT_WORD indicates that the token is a word.
   TT_NUMBER indicates that the token is a number.
   TT_EOL indicates that the end of line has been read.
       The field can only have this value if the
       eolIsSignificant method has been called with the
       argument true.
   TT_EOF indicates that the end of the input stream
       has been reached.


   The initial value of this field is -4.

  type: int"
  [this]
  (-> this .-ttype))

(def *-tt-eof
  "Static Constant.

  A constant indicating that the end of the stream has been read.

  type: int"
  StreamTokenizer/TT_EOF)

(def *-tt-eol
  "Static Constant.

  A constant indicating that the end of the line has been read.

  type: int"
  StreamTokenizer/TT_EOL)

(def *-tt-number
  "Static Constant.

  A constant indicating that a number token has been read.

  type: int"
  StreamTokenizer/TT_NUMBER)

(def *-tt-word
  "Static Constant.

  A constant indicating that a word token has been read.

  type: int"
  StreamTokenizer/TT_WORD)

(defn -sval
  "Instance Field.

  If the current token is a word token, this field contains a
   string giving the characters of the word token. When the current
   token is a quoted string token, this field contains the body of
   the string.

   The current token is a word when the value of the
   ttype field is TT_WORD. The current token is
   a quoted string token when the value of the ttype field is
   a quote character.

   The initial value of this field is null.

  type: java.lang.String"
  [this]
  (-> this .-sval))

(defn -nval
  "Instance Field.

  If the current token is a number, this field contains the value
   of that number. The current token is a number when the value of
   the ttype field is TT_NUMBER.

   The initial value of this field is 0.0.

  type: double"
  [this]
  (-> this .-nval))

(defn eol-is-significant
  "Determines whether or not ends of line are treated as tokens.
   If the flag argument is true, this tokenizer treats end of lines
   as tokens; the nextToken method returns
   TT_EOL and also sets the ttype field to
   this value when an end of line is read.

   A line is a sequence of characters ending with either a
   carriage-return character ('\r') or a newline
   character ('\n'). In addition, a carriage-return
   character followed immediately by a newline character is treated
   as a single end-of-line token.

   If the flag is false, end-of-line characters are
   treated as white space and serve only to separate tokens.

  flag - true indicates that end-of-line characters are separate tokens; false indicates that end-of-line characters are white space. - `boolean`"
  ([this flag]
    (-> this (.eolIsSignificant flag))))

(defn slash-slash-comments
  "Determines whether or not the tokenizer recognizes C++-style comments.
   If the flag argument is true, this stream tokenizer
   recognizes C++-style comments. Any occurrence of two consecutive
   slash characters ('/') is treated as the beginning of
   a comment that extends to the end of the line.

   If the flag argument is false, then C++-style
   comments are not treated specially.

  flag - true indicates to recognize and ignore C++-style comments. - `boolean`"
  ([this flag]
    (-> this (.slashSlashComments flag))))

(defn comment-char
  "Specified that the character argument starts a single-line
   comment. All characters from the comment character to the end of
   the line are ignored by this stream tokenizer.

   Any other attribute settings for the specified character are cleared.

  ch - the character. - `int`"
  ([this ch]
    (-> this (.commentChar ch))))

(defn slash-star-comments
  "Determines whether or not the tokenizer recognizes C-style comments.
   If the flag argument is true, this stream tokenizer
   recognizes C-style comments. All text between successive
   occurrences of /* and */ are discarded.

   If the flag argument is false, then C-style comments
   are not treated specially.

  flag - true indicates to recognize and ignore C-style comments. - `boolean`"
  ([this flag]
    (-> this (.slashStarComments flag))))

(defn quote-char
  "Specifies that matching pairs of this character delimit string
   constants in this tokenizer.

   When the nextToken method encounters a string
   constant, the ttype field is set to the string
   delimiter and the sval field is set to the body of
   the string.

   If a string quote character is encountered, then a string is
   recognized, consisting of all characters after (but not including)
   the string quote character, up to (but not including) the next
   occurrence of that same string quote character, or a line
   terminator, or end of file. The usual escape sequences such as
   `\n` and `\t` are recognized and
   converted to single characters as the string is parsed.

   Any other attribute settings for the specified character are cleared.

  ch - the character. - `int`"
  ([this ch]
    (-> this (.quoteChar ch))))

(defn lower-case-mode
  "Determines whether or not word token are automatically lowercased.
   If the flag argument is true, then the value in the
   sval field is lowercased whenever a word token is
   returned (the ttype field has the
   value TT_WORD by the nextToken method
   of this tokenizer.

   If the flag argument is false, then the
   sval field is not modified.

  fl - true indicates that all word tokens should be lowercased. - `boolean`"
  ([this fl]
    (-> this (.lowerCaseMode fl))))

(defn to-string
  "Returns the string representation of the current stream token and
   the line number it occurs on.

   The precise string returned is unspecified, although the following
   example can be considered typical:



  Token['a'], line 10

  returns: a string representation of the token - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn push-back
  "Causes the next call to the nextToken method of this
   tokenizer to return the current value in the ttype
   field, and not to modify the value in the nval or
   sval field."
  ([this]
    (-> this (.pushBack))))

(defn next-token
  "Parses the next token from the input stream of this tokenizer.
   The type of the next token is returned in the ttype
   field. Additional information about the token may be in the
   nval field or the sval field of this
   tokenizer.

   Typical clients of this
   class first set up the syntax tables and then sit in a loop
   calling nextToken to parse successive tokens until TT_EOF
   is returned.

  returns: the value of the ttype field. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.nextToken))))

(defn ordinary-char
  "Specifies that the character argument is `ordinary`
   in this tokenizer. It removes any special significance the
   character has as a comment character, word component, string
   delimiter, white space, or number character. When such a character
   is encountered by the parser, the parser treats it as a
   single-character token and sets ttype field to the
   character value.

   Making a line terminator character `ordinary` may interfere
   with the ability of a StreamTokenizer to count
   lines. The lineno method may no longer reflect
   the presence of such terminator characters in its line count.

  ch - the character. - `int`"
  ([this ch]
    (-> this (.ordinaryChar ch))))

(defn whitespace-chars
  "Specifies that all characters c in the range
   low <= c <= high
   are white space characters. White space characters serve only to
   separate tokens in the input stream.

   Any other attribute settings for the characters in the specified
   range are cleared.

  low - the low end of the range. - `int`
  hi - the high end of the range. - `int`"
  ([this low hi]
    (-> this (.whitespaceChars low hi))))

(defn parse-numbers
  "Specifies that numbers should be parsed by this tokenizer. The
   syntax table of this tokenizer is modified so that each of the twelve
   characters:


        0 1 2 3 4 5 6 7 8 9 . -

   has the `numeric` attribute.

   When the parser encounters a word token that has the format of a
   double precision floating-point number, it treats the token as a
   number rather than a word, by setting the ttype
   field to the value TT_NUMBER and putting the numeric
   value of the token into the nval field."
  ([this]
    (-> this (.parseNumbers))))

(defn ordinary-chars
  "Specifies that all characters c in the range
   low <= c <= high
   are `ordinary` in this tokenizer. See the
   ordinaryChar method for more information on a
   character being ordinary.

  low - the low end of the range. - `int`
  hi - the high end of the range. - `int`"
  ([this low hi]
    (-> this (.ordinaryChars low hi))))

(defn reset-syntax
  "Resets this tokenizer's syntax table so that all characters are
   `ordinary.` See the ordinaryChar method
   for more information on a character being ordinary."
  ([this]
    (-> this (.resetSyntax))))

(defn word-chars
  "Specifies that all characters c in the range
   low <= c <= high
   are word constituents. A word token consists of a word constituent
   followed by zero or more word constituents or number constituents.

  low - the low end of the range. - `int`
  hi - the high end of the range. - `int`"
  ([this low hi]
    (-> this (.wordChars low hi))))

(defn lineno
  "Return the current line number.

  returns: the current line number of this stream tokenizer. - `int`"
  ([this]
    (-> this (.lineno))))

