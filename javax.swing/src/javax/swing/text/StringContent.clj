(ns javax.swing.text.StringContent
  "An implementation of the AbstractDocument.Content interface that is
  a brute force implementation that is useful for relatively small
  documents and/or debugging.  It manages the character content
  as a simple character array.  It is also quite inefficient.

  It is generally recommended that the gap buffer or piece table
  implementations be used instead.  This buffer does not scale up
  to large sizes.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StringContent]))

(defn ->string-content
  "Constructor.

  Creates a new StringContent object, with the initial
   size specified.  If the length is < 1, a size of 1 is used.

  initial-length - the initial size - `int`"
  ([^Integer initial-length]
    (new StringContent initial-length))
  ([]
    (new StringContent )))

(defn length
  "Returns the length of the content.

  returns: the length >= 1 - `int`"
  (^Integer [^javax.swing.text.StringContent this]
    (-> this (.length))))

(defn insert-string
  "Inserts a string into the content.

  where - the starting position >= 0 && < length() - `int`
  str - the non-null string to insert - `java.lang.String`

  returns: an UndoableEdit object for undoing - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  (^javax.swing.undo.UndoableEdit [^javax.swing.text.StringContent this ^Integer where ^java.lang.String str]
    (-> this (.insertString where str))))

(defn remove
  "Removes part of the content.  where  nitems must be < length().

  where - the starting position >= 0 - `int`
  nitems - the number of characters to remove >= 0 - `int`

  returns: an UndoableEdit object for undoing - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  (^javax.swing.undo.UndoableEdit [^javax.swing.text.StringContent this ^Integer where ^Integer nitems]
    (-> this (.remove where nitems))))

(defn get-string
  "Retrieves a portion of the content.  where  len must be <= length().

  where - the starting position >= 0 - `int`
  len - the length to retrieve >= 0 - `int`

  returns: a string representing the content; may be empty - `java.lang.String`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  (^java.lang.String [^javax.swing.text.StringContent this ^Integer where ^Integer len]
    (-> this (.getString where len))))

(defn get-chars
  "Retrieves a portion of the content.  where  len must be <= length()

  where - the starting position >= 0 - `int`
  len - the number of characters to retrieve >= 0 - `int`
  chars - the Segment object to return the characters in - `javax.swing.text.Segment`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([^javax.swing.text.StringContent this ^Integer where ^Integer len ^javax.swing.text.Segment chars]
    (-> this (.getChars where len chars))))

(defn create-position
  "Creates a position within the content that will
   track change as the content is mutated.

  offset - the offset to create a position for >= 0 - `int`

  returns: the position - `javax.swing.text.Position`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  (^javax.swing.text.Position [^javax.swing.text.StringContent this ^Integer offset]
    (-> this (.createPosition offset))))

