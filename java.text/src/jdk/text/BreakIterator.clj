(ns jdk.text.BreakIterator
  "The BreakIterator class implements methods for finding
  the location of boundaries in text. Instances of BreakIterator
  maintain a current position and scan over text
  returning the index of characters where boundaries occur.
  Internally, BreakIterator scans text using a
  CharacterIterator, and is thus able to scan text held
  by any object implementing that protocol. A StringCharacterIterator
  is used to scan String objects passed to setText.


  You use the factory methods provided by this class to create
  instances of various types of break iterators. In particular,
  use getWordInstance, getLineInstance,
  getSentenceInstance, and getCharacterInstance
  to create BreakIterators that perform
  word, line, sentence, and character boundary analysis respectively.
  A single BreakIterator can work only on one unit
  (word, line, sentence, and so on). You must use a different iterator
  for each unit boundary analysis you wish to perform.


  Line boundary analysis determines where a text string can be
  broken when line-wrapping. The mechanism correctly handles
  punctuation and hyphenated words. Actual line breaking needs
  to also consider the available line width and is handled by
  higher-level software.


  Sentence boundary analysis allows selection with correct interpretation
  of periods within numbers and abbreviations, and trailing punctuation
  marks such as quotation marks and parentheses.


  Word boundary analysis is used by search and replace functions, as
  well as within text editing applications that allow the user to
  select words with a double click. Word selection provides correct
  interpretation of punctuation marks within and following
  words. Characters that are not part of a word, such as symbols
  or punctuation marks, have word-breaks on both sides.


  Character boundary analysis allows users to interact with characters
  as they expect to, for example, when moving the cursor through a text
  string. Character boundary analysis provides correct navigation
  through character strings, regardless of how the character is stored.
  The boundaries returned may be those of supplementary characters,
  combining character sequences, or ligature clusters.
  For example, an accented character might be stored as a base character
  and a diacritical mark. What users consider to be a character can
  differ between languages.


  The BreakIterator instances returned by the factory methods
  of this class are intended for use with natural languages only, not for
  programming language text. It is however possible to define subclasses
  that tokenize a programming language.


  Examples:
  Creating and using text boundaries:



  public static void main(String args[]) {
       if (args.length == 1) {
           String stringToExamine = args[0];
           //print each word in order
           BreakIterator boundary = BreakIterator.getWordInstance();
           boundary.setText(stringToExamine);
           printEachForward(boundary, stringToExamine);
           //print each sentence in reverse order
           boundary = BreakIterator.getSentenceInstance(Locale.US);
           boundary.setText(stringToExamine);
           printEachBackward(boundary, stringToExamine);
           printFirst(boundary, stringToExamine);
           printLast(boundary, stringToExamine);
       }
  }


  Print each element in order:



  public static void printEachForward(BreakIterator boundary, String source) {
      int start = boundary.first();
      for (int end = boundary.next();
           end != BreakIterator.DONE;
           start = end, end = boundary.next()) {
           System.out.println(source.substring(start,end));
      }
  }


  Print each element in reverse order:



  public static void printEachBackward(BreakIterator boundary, String source) {
      int end = boundary.last();
      for (int start = boundary.previous();
           start != BreakIterator.DONE;
           end = start, start = boundary.previous()) {
          System.out.println(source.substring(start,end));
      }
  }


  Print first element:



  public static void printFirst(BreakIterator boundary, String source) {
      int start = boundary.first();
      int end = boundary.next();
      System.out.println(source.substring(start,end));
  }


  Print last element:



  public static void printLast(BreakIterator boundary, String source) {
      int end = boundary.last();
      int start = boundary.previous();
      System.out.println(source.substring(start,end));
  }


  Print the element at a specified position:



  public static void printAt(BreakIterator boundary, int pos, String source) {
      int end = boundary.following(pos);
      int start = boundary.previous();
      System.out.println(source.substring(start,end));
  }


  Find the next word:



  public static int nextWordStartAfter(int pos, String text) {
      BreakIterator wb = BreakIterator.getWordInstance();
      wb.setText(text);
      int last = wb.following(pos);
      int current = wb.next();
      while (current != BreakIterator.DONE) {
          for (int p = last; p < current; p++) {
              if (Character.isLetter(text.codePointAt(p)))
                  return last;
          }
          last = current;
          current = wb.next();
      }
      return BreakIterator.DONE;
  }
  (The iterator returned by BreakIterator.getWordInstance() is unique in that
  the break positions it returns don't represent both the start and end of the
  thing being iterated over.  That is, a sentence-break iterator returns breaks
  that each represent the end of one sentence and the beginning of the next.
  With the word-break iterator, the characters between two boundaries might be a
  word, or they might be the punctuation or whitespace between two words.  The
  above code uses a simple heuristic to determine which boundary is the beginning
  of a word: If the characters between this boundary and the next boundary
  include at least one letter (this can be an alphabetical letter, a CJK ideograph,
  a Hangul syllable, a Kana character, etc.), then the text between this boundary
  and the next is a word; otherwise, it's the material between words.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text BreakIterator]))

(def *-done
  "Static Constant.

  DONE is returned by previous(), next(), next(int), preceding(int)
   and following(int) when either the first or last text boundary has been
   reached.

  type: int"
  BreakIterator/DONE)

(defn *get-word-instance
  "Returns a new BreakIterator instance
   for word breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for word breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^java.util.Locale locale]
    (BreakIterator/getWordInstance locale))
  (^java.text.BreakIterator []
    (BreakIterator/getWordInstance )))

(defn *get-line-instance
  "Returns a new BreakIterator instance
   for line breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for line breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^java.util.Locale locale]
    (BreakIterator/getLineInstance locale))
  (^java.text.BreakIterator []
    (BreakIterator/getLineInstance )))

(defn *get-character-instance
  "Returns a new BreakIterator instance
   for character breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for character breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^java.util.Locale locale]
    (BreakIterator/getCharacterInstance locale))
  (^java.text.BreakIterator []
    (BreakIterator/getCharacterInstance )))

(defn *get-sentence-instance
  "Returns a new BreakIterator instance
   for sentence breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for sentence breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^java.util.Locale locale]
    (BreakIterator/getSentenceInstance locale))
  (^java.text.BreakIterator []
    (BreakIterator/getSentenceInstance )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   get*Instance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported by the Java
   runtime and by installed
   BreakIteratorProvider implementations.
   It must contain at least a Locale
   instance equal to Locale.US.

  returns: An array of locales for which localized
           BreakIterator instances are available. - `java.util.Locale[]`"
  ([]
    (BreakIterator/getAvailableLocales )))

(defn next
  "Returns the nth boundary from the current boundary. If either
   the first or last text boundary has been reached, it returns
   BreakIterator.DONE and the current position is set to either
   the first or last text boundary depending on which one is reached. Otherwise,
   the iterator's current position is set to the new boundary.
   For example, if the iterator's current position is the mth text boundary
   and three more boundaries exist from the current boundary to the last text
   boundary, the next(2) call will return m  2. The new text position is set
   to the (m  2)th text boundary. A next(4) call would return
   BreakIterator.DONE and the last text boundary would become the
   new text position.

  n - which boundary to return. A value of 0 does nothing. Negative values move to previous boundaries and positive values move to later boundaries. - `int`

  returns: The character index of the nth boundary from the current position
   or BreakIterator.DONE if either first or last text boundary
   has been reached. - `int`"
  (^Integer [^BreakIterator this ^Integer n]
    (-> this (.next n)))
  (^Integer [^BreakIterator this]
    (-> this (.next))))

(defn preceding
  "Returns the last boundary preceding the specified character offset. If the
   specified offset equals to the first text boundary, it returns
   BreakIterator.DONE and the iterator's current position is unchanged.
   Otherwise, the iterator's current position is set to the returned boundary.
   The value returned is always less than the offset or the value
   BreakIterator.DONE.

  offset - the character offset to begin scanning. - `int`

  returns: The last boundary before the specified offset or
   BreakIterator.DONE if the first text boundary is passed in
   as the offset. - `int`

  throws: java.lang.IllegalArgumentException - if the specified offset is less than the first text boundary or greater than the last text boundary."
  (^Integer [^BreakIterator this ^Integer offset]
    (-> this (.preceding offset))))

(defn set-text
  "Set a new text string to be scanned.  The current scan
   position is reset to first().

  new-text - new text to scan. - `java.lang.String`"
  ([^BreakIterator this ^java.lang.String new-text]
    (-> this (.setText new-text))))

(defn get-text
  "Get the text being scanned

  returns: the text being scanned - `java.text.CharacterIterator`"
  (^java.text.CharacterIterator [^BreakIterator this]
    (-> this (.getText))))

(defn previous
  "Returns the boundary preceding the current boundary. If the current boundary
   is the first text boundary, it returns BreakIterator.DONE and
   the iterator's current position is unchanged. Otherwise, the iterator's
   current position is set to the boundary preceding the current boundary.

  returns: The character index of the previous text boundary or
   BreakIterator.DONE if the current boundary is the first text
   boundary. - `int`"
  (^Integer [^BreakIterator this]
    (-> this (.previous))))

(defn current
  "Returns character index of the text boundary that was most
   recently returned by next(), next(int), previous(), first(), last(),
   following(int) or preceding(int). If any of these methods returns
   BreakIterator.DONE because either first or last text boundary
   has been reached, it returns the first or last text boundary depending on
   which one is reached.

  returns: The text boundary returned from the above methods, first or last
   text boundary. - `int`"
  (^Integer [^BreakIterator this]
    (-> this (.current))))

(defn boundary?
  "Returns true if the specified character offset is a text boundary.

  offset - the character offset to check. - `int`

  returns: true if `offset` is a boundary position,
   false otherwise. - `boolean`

  throws: java.lang.IllegalArgumentException - if the specified offset is less than the first text boundary or greater than the last text boundary."
  (^Boolean [^BreakIterator this ^Integer offset]
    (-> this (.isBoundary offset))))

(defn last
  "Returns the last boundary. The iterator's current position is set
   to the last text boundary.

  returns: The character index of the last text boundary. - `int`"
  (^Integer [^BreakIterator this]
    (-> this (.last))))

(defn clone
  "Create a copy of this iterator

  returns: A copy of this - `java.lang.Object`"
  (^java.lang.Object [^BreakIterator this]
    (-> this (.clone))))

(defn following
  "Returns the first boundary following the specified character offset. If the
   specified offset equals to the last text boundary, it returns
   BreakIterator.DONE and the iterator's current position is unchanged.
   Otherwise, the iterator's current position is set to the returned boundary.
   The value returned is always greater than the offset or the value
   BreakIterator.DONE.

  offset - the character offset to begin scanning. - `int`

  returns: The first boundary after the specified offset or
   BreakIterator.DONE if the last text boundary is passed in
   as the offset. - `int`

  throws: java.lang.IllegalArgumentException - if the specified offset is less than the first text boundary or greater than the last text boundary."
  (^Integer [^BreakIterator this ^Integer offset]
    (-> this (.following offset))))

(defn first
  "Returns the first boundary. The iterator's current position is set
   to the first text boundary.

  returns: The character index of the first text boundary. - `int`"
  (^Integer [^BreakIterator this]
    (-> this (.first))))

