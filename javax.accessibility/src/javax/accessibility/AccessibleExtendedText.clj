(ns javax.accessibility.AccessibleExtendedText
  "The AccessibleExtendedText interface contains additional methods
  not provided by the AccessibleText interface

  Applications can determine if an object supports the AccessibleExtendedText
  interface by first obtaining its AccessibleContext (see Accessible)
  and then calling the AccessibleContext.getAccessibleText() method of
  AccessibleContext.  If the return value is an instance of
  AccessibleExtendedText, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleExtendedText]))

(defn get-text-range
  "Returns the text between two indices

  start-index - the start index in the text - `int`
  end-index - the end index in the text - `int`

  returns: the text string if the indices are valid.
   Otherwise, null is returned. - `java.lang.String`"
  ([^javax.accessibility.AccessibleExtendedText this ^Integer start-index ^Integer end-index]
    (-> this (.getTextRange start-index end-index))))

(defn get-text-sequence-at
  "Returns the AccessibleTextSequence at a given index.

  part - the CHARACTER, WORD, SENTENCE, LINE or ATTRIBUTE_RUN to retrieve - `int`
  index - an index within the text - `int`

  returns: an AccessibleTextSequence specifying the text
   if part and index are valid.  Otherwise, null is returned. - `javax.accessibility.AccessibleTextSequence`"
  ([^javax.accessibility.AccessibleExtendedText this ^Integer part ^Integer index]
    (-> this (.getTextSequenceAt part index))))

(defn get-text-sequence-after
  "Returns the AccessibleTextSequence after a given index.

  part - the CHARACTER, WORD, SENTENCE, LINE or ATTRIBUTE_RUN to retrieve - `int`
  index - an index within the text - `int`

  returns: an AccessibleTextSequence specifying the text
   if part and index are valid.  Otherwise, null is returned. - `javax.accessibility.AccessibleTextSequence`"
  ([^javax.accessibility.AccessibleExtendedText this ^Integer part ^Integer index]
    (-> this (.getTextSequenceAfter part index))))

(defn get-text-sequence-before
  "Returns the AccessibleTextSequence before a given index.

  part - the CHARACTER, WORD, SENTENCE, LINE or ATTRIBUTE_RUN to retrieve - `int`
  index - an index within the text - `int`

  returns: an AccessibleTextSequence specifying the text
   if part and index are valid.  Otherwise, null is returned. - `javax.accessibility.AccessibleTextSequence`"
  ([^javax.accessibility.AccessibleExtendedText this ^Integer part ^Integer index]
    (-> this (.getTextSequenceBefore part index))))

(defn get-text-bounds
  "Returns the bounding rectangle of the text between two indices.

  start-index - the start index in the text - `int`
  end-index - the end index in the text - `int`

  returns: the bounding rectangle of the text if the indices are valid.
   Otherwise, null is returned. - `java.awt.Rectangle`"
  ([^javax.accessibility.AccessibleExtendedText this ^Integer start-index ^Integer end-index]
    (-> this (.getTextBounds start-index end-index))))

