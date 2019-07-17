(ns javax.swing.text.DocumentFilter$FilterBypass
  "Used as a way to circumvent calling back into the Document to
  change it. Document implementations that wish to support
  a DocumentFilter must provide an implementation that will
  not callback into the DocumentFilter when the following methods
  are invoked from the DocumentFilter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DocumentFilter$FilterBypass]))

(defn ->filter-bypass
  "Constructor."
  ([]
    (new DocumentFilter$FilterBypass )))

(defn get-document
  "Returns the Document the mutation is occurring on.

  returns: Document that remove/insertString will operate on - `javax.swing.text.Document`"
  ([^javax.swing.text.DocumentFilter$FilterBypass this]
    (-> this (.getDocument))))

(defn remove
  "Removes the specified region of text, bypassing the
   DocumentFilter.

  offset - the offset from the beginning >= 0 - `int`
  length - the number of characters to remove >= 0 - `int`

  throws: javax.swing.text.BadLocationException - some portion of the removal range was not a valid part of the document. The location in the exception is the first bad position encountered."
  ([^javax.swing.text.DocumentFilter$FilterBypass this ^Integer offset ^Integer length]
    (-> this (.remove offset length))))

(defn insert-string
  "Inserts the specified text, bypassing the
   DocumentFilter.

  offset - the offset into the document to insert the content >= 0. All positions that track change at or after the given location will move. - `int`
  string - the string to insert - `java.lang.String`
  attr - the attributes to associate with the inserted content. This may be null if there are no attributes. - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert position is not a valid position within the document"
  ([^javax.swing.text.DocumentFilter$FilterBypass this ^Integer offset ^java.lang.String string ^javax.swing.text.AttributeSet attr]
    (-> this (.insertString offset string attr))))

(defn replace
  "Deletes the region of text from offset to
   offset  length, and replaces it with
    text.

  offset - Location in Document - `int`
  length - Length of text to delete - `int`
  string - Text to insert, null indicates no text to insert - `java.lang.String`
  attrs - AttributeSet indicating attributes of inserted text, null is legal. - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert is not a valid position within the document"
  ([^javax.swing.text.DocumentFilter$FilterBypass this ^Integer offset ^Integer length ^java.lang.String string ^javax.swing.text.AttributeSet attrs]
    (-> this (.replace offset length string attrs))))

