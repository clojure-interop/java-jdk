(ns javax.swing.text.DocumentFilter
  "DocumentFilter, as the name implies, is a filter for the
  Document mutation methods. When a Document
  containing a DocumentFilter is modified (either through
  insert or remove), it forwards the appropriate
  method invocation to the DocumentFilter. The
  default implementation allows the modification to
  occur. Subclasses can filter the modifications by conditionally invoking
  methods on the superclass, or invoking the necessary methods on
  the passed in FilterBypass. Subclasses should NOT call back
  into the Document for the modification
  instead call into the superclass or the FilterBypass.

  When remove or insertString is invoked
  on the DocumentFilter, the DocumentFilter
  may callback into the
  FilterBypass multiple times, or for different regions, but
  it should not callback into the FilterBypass after returning
  from the remove or insertString method.

  By default, text related document mutation methods such as
  insertString, replace and remove
  in AbstractDocument use DocumentFilter when
  available, and Element related mutation methods such as
  create, insert and removeElement in
  DefaultStyledDocument do not use DocumentFilter.
  If a method doesn't follow these defaults, this must be explicitly stated
  in the method documentation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DocumentFilter]))

(defn ->document-filter
  "Constructor."
  ([]
    (new DocumentFilter )))

(defn remove
  "Invoked prior to removal of the specified region in the
   specified Document. Subclasses that want to conditionally allow
   removal should override this and only call supers implementation as
   necessary, or call directly into the FilterBypass as
   necessary.

  fb - FilterBypass that can be used to mutate Document - `javax.swing.text.DocumentFilter.FilterBypass`
  offset - the offset from the beginning >= 0 - `int`
  length - the number of characters to remove >= 0 - `int`

  throws: javax.swing.text.BadLocationException - some portion of the removal range was not a valid part of the document. The location in the exception is the first bad position encountered."
  ([this fb offset length]
    (-> this (.remove fb offset length))))

(defn insert-string
  "Invoked prior to insertion of text into the
   specified Document. Subclasses that want to conditionally allow
   insertion should override this and only call supers implementation as
   necessary, or call directly into the FilterBypass.

  fb - FilterBypass that can be used to mutate Document - `javax.swing.text.DocumentFilter.FilterBypass`
  offset - the offset into the document to insert the content >= 0. All positions that track change at or after the given location will move. - `int`
  string - the string to insert - `java.lang.String`
  attr - the attributes to associate with the inserted content. This may be null if there are no attributes. - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert position is not a valid position within the document"
  ([this fb offset string attr]
    (-> this (.insertString fb offset string attr))))

(defn replace
  "Invoked prior to replacing a region of text in the
   specified Document. Subclasses that want to conditionally allow
   replace should override this and only call supers implementation as
   necessary, or call directly into the FilterBypass.

  fb - FilterBypass that can be used to mutate Document - `javax.swing.text.DocumentFilter.FilterBypass`
  offset - Location in Document - `int`
  length - Length of text to delete - `int`
  text - Text to insert, null indicates no text to insert - `java.lang.String`
  attrs - AttributeSet indicating attributes of inserted text, null is legal. - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert position is not a valid position within the document"
  ([this fb offset length text attrs]
    (-> this (.replace fb offset length text attrs))))

