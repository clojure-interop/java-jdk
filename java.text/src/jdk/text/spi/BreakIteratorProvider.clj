(ns jdk.text.spi.BreakIteratorProvider
  "An abstract class for service providers that
  provide concrete implementations of the
  BreakIterator class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi BreakIteratorProvider]))

(defn get-word-instance
  "Returns a new BreakIterator instance
   for word breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for word breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^BreakIteratorProvider this ^java.util.Locale locale]
    (-> this (.getWordInstance locale))))

(defn get-line-instance
  "Returns a new BreakIterator instance
   for line breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for line breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^BreakIteratorProvider this ^java.util.Locale locale]
    (-> this (.getLineInstance locale))))

(defn get-character-instance
  "Returns a new BreakIterator instance
   for character breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for character breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^BreakIteratorProvider this ^java.util.Locale locale]
    (-> this (.getCharacterInstance locale))))

(defn get-sentence-instance
  "Returns a new BreakIterator instance
   for sentence breaks
   for the given locale.

  locale - the desired locale - `java.util.Locale`

  returns: A break iterator for sentence breaks - `java.text.BreakIterator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.BreakIterator [^BreakIteratorProvider this ^java.util.Locale locale]
    (-> this (.getSentenceInstance locale))))

