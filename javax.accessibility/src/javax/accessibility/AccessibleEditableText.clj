(ns javax.accessibility.AccessibleEditableText
  "The AccessibleEditableText interface should be implemented by all
  classes that present editable textual information on the display.
  Along with the AccessibleText interface, this interface provides
  the standard mechanism for an assistive technology to access
  that text via its content, attributes, and spatial location.
  Applications can determine if an object supports the AccessibleEditableText
  interface by first obtaining its AccessibleContext (see Accessible)
  and then calling the AccessibleContext.getAccessibleEditableText()
  method of AccessibleContext.  If the return value is not null, the object
  supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleEditableText]))

(defn delete
  "Deletes the text between two indices

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`"
  ([this start-index end-index]
    (-> this (.delete start-index end-index))))

(defn paste
  "Pastes the text from the system clipboard into the text
   starting at the specified index.

  start-index - the starting index in the text - `int`"
  ([this start-index]
    (-> this (.paste start-index))))

(defn get-text-range
  "Returns the text string between two indices.

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`

  returns: the text string between the indices - `java.lang.String`"
  ([this start-index end-index]
    (-> this (.getTextRange start-index end-index))))

(defn select-text
  "Selects the text between two indices.

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`"
  ([this start-index end-index]
    (-> this (.selectText start-index end-index))))

(defn insert-text-at-index
  "Inserts the specified string at the given index/

  index - the index in the text where the string will be inserted - `int`
  s - the string to insert in the text - `java.lang.String`"
  ([this index s]
    (-> this (.insertTextAtIndex index s))))

(defn replace-text
  "Replaces the text between two indices with the specified
   string.

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`
  s - the string to replace the text between two indices - `java.lang.String`"
  ([this start-index end-index s]
    (-> this (.replaceText start-index end-index s))))

(defn set-attributes
  "Sets attributes for the text between two indices.

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`
  as - the attribute set - `javax.swing.text.AttributeSet`"
  ([this start-index end-index as]
    (-> this (.setAttributes start-index end-index as))))

(defn cut
  "Cuts the text between two indices into the system clipboard.

  start-index - the starting index in the text - `int`
  end-index - the ending index in the text - `int`"
  ([this start-index end-index]
    (-> this (.cut start-index end-index))))

(defn set-text-contents
  "Sets the text contents to the specified string.

  s - the string to set the text contents - `java.lang.String`"
  ([this s]
    (-> this (.setTextContents s))))

