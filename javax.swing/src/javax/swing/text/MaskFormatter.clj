(ns javax.swing.text.MaskFormatter
  "MaskFormatter is used to format and edit strings. The behavior
  of a MaskFormatter is controlled by way of a String mask
  that specifies the valid characters that can be contained at a particular
  location in the Document model. The following characters can
  be specified:



     Character
     Description


     #
     Any valid number, uses Character.isDigit.


     '
     Escape character, used to escape any of the
        special formatting characters.


     UAny character (Character.isLetter). All
         lowercase letters are mapped to upper case.

  LAny character (Character.isLetter). All
         upper case letters are mapped to lower case.

  AAny character or number (Character.isLetter
        or Character.isDigit)

  ?Any character
         (Character.isLetter).

  *Anything.
  HAny hex character (0-9, a-f or A-F).



  Typically characters correspond to one char, but in certain languages this
  is not the case. The mask is on a per character basis, and will thus
  adjust to fit as many chars as are needed.

  You can further restrict the characters that can be input by the
  setInvalidCharacters and setValidCharacters
  methods. setInvalidCharacters allows you to specify
  which characters are not legal. setValidCharacters allows
  you to specify which characters are valid. For example, the following
  code block is equivalent to a mask of '0xHHH' with no invalid/valid
  characters:


  MaskFormatter formatter = new MaskFormatter(`0x***`);
  formatter.setValidCharacters(`0123456789abcdefABCDEF`);

  When initially formatting a value if the length of the string is
  less than the length of the mask, two things can happen. Either
  the placeholder string will be used, or the placeholder character will
  be used. Precedence is given to the placeholder string. For example:


    MaskFormatter formatter = new MaskFormatter(`###-####`);
    formatter.setPlaceholderCharacter('_');
    formatter.getDisplayValue(tf, `123`);

  Would result in the string '123-____'. If
  setPlaceholder(`555-1212`) was invoked '123-1212' would
  result. The placeholder String is only used on the initial format,
  on subsequent formats only the placeholder character will be used.

  If a MaskFormatter is configured to only allow valid characters
  (setAllowsInvalid(false)) literal characters will be skipped as
  necessary when editing. Consider a MaskFormatter with
  the mask `###-####` and current value `555-1212`. Using the right
  arrow key to navigate through the field will result in (| indicates the
  position of the caret):


    |555-1212
    5|55-1212
    55|5-1212
    555-|1212
    555-1|212
  The '-' is a literal (non-editable) character, and is skipped.

  Similar behavior will result when editing. Consider inserting the string
  '123-45' and '12345' into the MaskFormatter in the
  previous example. Both inserts will result in the same String,
  '123-45__'. When MaskFormatter
  is processing the insert at character position 3 (the '-'), two things can
  happen:

    If the inserted character is '-', it is accepted.
    If the inserted character matches the mask for the next non-literal
        character, it is accepted at the new location.
    Anything else results in an invalid edit


  By default MaskFormatter will not allow invalid edits, you can
  change this with the setAllowsInvalid method, and will
  commit edits on valid edits (use the setCommitsOnValidEdit to
  change this).

  By default, MaskFormatter is in overwrite mode. That is as
  characters are typed a new character is not inserted, rather the character
  at the current location is replaced with the newly typed character. You
  can change this behavior by way of the method setOverwriteMode.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text MaskFormatter]))

(defn ->mask-formatter
  "Constructor.

  Creates a MaskFormatter with the specified mask.
   A ParseException
   will be thrown if mask is an invalid mask.

  mask - `java.lang.String`

  throws: java.text.ParseException - if mask does not contain valid mask characters"
  ([mask]
    (new MaskFormatter mask))
  ([]
    (new MaskFormatter )))

(defn get-value-contains-literal-characters?
  "Returns true if stringToValue should return literal
   characters in the mask.

  returns: True if literal characters in mask should be returned in
           stringToValue - `boolean`"
  ([this]
    (-> this (.getValueContainsLiteralCharacters))))

(defn string-to-value
  "Parses the text, returning the appropriate Object representation of
   the String value. This strips the literal characters as
   necessary and invokes supers stringToValue, so that if
   you have specified a value class (setValueClass) an
   instance of it will be created. This will throw a
   ParseException if the value does not match the current
   mask.  Refer to setValueContainsLiteralCharacters(boolean) for details
   on how literals are treated.

  value - String to convert - `java.lang.String`

  returns: Object representation of text - `java.lang.Object`

  throws: java.text.ParseException - if there is an error in the conversion"
  ([this value]
    (-> this (.stringToValue value))))

(defn set-placeholder
  "Sets the string to use if the value does not completely fill in
   the mask. A null value implies the placeholder char should be used.

  placeholder - String used when formatting if the value does not completely fill the mask - `java.lang.String`"
  ([this placeholder]
    (-> this (.setPlaceholder placeholder))))

(defn set-value-contains-literal-characters
  "If true, the returned value and set value will also contain the literal
   characters in mask.

   For example, if the mask is '(###) ###-####', the
   current value is '(415) 555-1212', and
   valueContainsLiteralCharacters is
   true stringToValue will return
   '(415) 555-1212'. On the other hand, if
   valueContainsLiteralCharacters is false,
   stringToValue will return '4155551212'.

  contains-literal-chars - Used to indicate if literal characters in mask should be returned in stringToValue - `boolean`"
  ([this contains-literal-chars]
    (-> this (.setValueContainsLiteralCharacters contains-literal-chars))))

(defn get-invalid-characters
  "Returns the characters that are not valid for input.

  returns: illegal characters. - `java.lang.String`"
  ([this]
    (-> this (.getInvalidCharacters))))

(defn get-mask
  "Returns the formatting mask.

  returns: Mask dictating legal character values. - `java.lang.String`"
  ([this]
    (-> this (.getMask))))

(defn set-mask
  "Sets the mask dictating the legal characters.
   This will throw a ParseException if mask is
   not valid.

  mask - `java.lang.String`

  throws: java.text.ParseException - if mask does not contain valid mask characters"
  ([this mask]
    (-> this (.setMask mask))))

(defn install
  "Installs the DefaultFormatter onto a particular
   JFormattedTextField.
   This will invoke valueToString to convert the
   current value from the JFormattedTextField to
   a String. This will then install the Actions from
   getActions, the DocumentFilter
   returned from getDocumentFilter and the
   NavigationFilter returned from
   getNavigationFilter onto the
   JFormattedTextField.

   Subclasses will typically only need to override this if they
   wish to install additional listeners on the
   JFormattedTextField.

   If there is a ParseException in converting the
   current value to a String, this will set the text to an empty
   String, and mark the JFormattedTextField as being
   in an invalid state.

   While this is a public method, this is typically only useful
   for subclassers of JFormattedTextField.
   JFormattedTextField will invoke this method at
   the appropriate times when the value changes, or its internal
   state changes.

  ftf - JFormattedTextField to format for, may be null indicating uninstall from current JFormattedTextField. - `javax.swing.JFormattedTextField`"
  ([this ftf]
    (-> this (.install ftf))))

(defn set-placeholder-character
  "Sets the character to use in place of characters that are not present
   in the value, ie the user must fill them in. The default value is
   a space.

   This is only applicable if the placeholder string has not been
   specified, or does not completely fill in the mask.

  placeholder - Character used when formatting if the value does not completely fill the mask - `char`"
  ([this placeholder]
    (-> this (.setPlaceholderCharacter placeholder))))

(defn set-valid-characters
  "Allows for further restricting of the characters that can be input.
   Only characters specified in the mask, not in the
   invalidCharacters, and in
   validCharacters will be allowed to be input. Passing
   in null (the default) implies the valid characters are only bound
   by the mask and the invalid characters.

  valid-characters - If non-null, specifies legal characters. - `java.lang.String`"
  ([this valid-characters]
    (-> this (.setValidCharacters valid-characters))))

(defn get-placeholder-character
  "Returns the character to use in place of characters that are not present
   in the value, ie the user must fill them in.

  returns: Character used when formatting if the value does not
          completely fill the mask - `char`"
  ([this]
    (-> this (.getPlaceholderCharacter))))

(defn get-placeholder
  "Returns the String to use if the value does not completely fill
   in the mask.

  returns: String used when formatting if the value does not
          completely fill the mask - `java.lang.String`"
  ([this]
    (-> this (.getPlaceholder))))

(defn get-valid-characters
  "Returns the valid characters that can be input.

  returns: Legal characters - `java.lang.String`"
  ([this]
    (-> this (.getValidCharacters))))

(defn value-to-string
  "Returns a String representation of the Object value
   based on the mask.  Refer to
   setValueContainsLiteralCharacters(boolean) for details
   on how literals are treated.

  value - Value to convert - `java.lang.Object`

  returns: String representation of value - `java.lang.String`

  throws: java.text.ParseException - if there is an error in the conversion"
  ([this value]
    (-> this (.valueToString value))))

(defn set-invalid-characters
  "Allows for further restricting of the characters that can be input.
   Only characters specified in the mask, not in the
   invalidCharacters, and in
   validCharacters will be allowed to be input. Passing
   in null (the default) implies the valid characters are only bound
   by the mask and the valid characters.

  invalid-characters - If non-null, specifies illegal characters. - `java.lang.String`"
  ([this invalid-characters]
    (-> this (.setInvalidCharacters invalid-characters))))

