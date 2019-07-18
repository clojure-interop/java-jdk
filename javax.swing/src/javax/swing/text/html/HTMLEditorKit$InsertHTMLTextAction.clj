(ns javax.swing.text.html.HTMLEditorKit$InsertHTMLTextAction
  "InsertHTMLTextAction can be used to insert an arbitrary string of HTML
  into an existing HTML document. At least two HTML.Tags need to be
  supplied. The first Tag, parentTag, identifies the parent in
  the document to add the elements to. The second tag, addTag,
  identifies the first tag that should be added to the document as
  seen in the HTML string. One important thing to remember, is that
  the parser is going to generate all the appropriate tags, even if
  they aren't in the HTML string passed in.
  For example, lets say you wanted to create an action to insert
  a table into the body. The parentTag would be HTML.Tag.BODY,
  addTag would be HTML.Tag.TABLE, and the string could be something
  like <table><tr><td></td></tr></table>.
  There is also an option to supply an alternate parentTag and
  addTag. These will be checked for if there is no parentTag at
  offset."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit$InsertHTMLTextAction]))

(defn ->insert-html-text-action
  "Constructor.

  name - `java.lang.String`
  html - `java.lang.String`
  parent-tag - `javax.swing.text.html.HTML$Tag`
  add-tag - `javax.swing.text.html.HTML$Tag`
  alternate-parent-tag - `javax.swing.text.html.HTML$Tag`
  alternate-add-tag - `javax.swing.text.html.HTML$Tag`"
  (^HTMLEditorKit$InsertHTMLTextAction [^java.lang.String name ^java.lang.String html ^javax.swing.text.html.HTML$Tag parent-tag ^javax.swing.text.html.HTML$Tag add-tag ^javax.swing.text.html.HTML$Tag alternate-parent-tag ^javax.swing.text.html.HTML$Tag alternate-add-tag]
    (new HTMLEditorKit$InsertHTMLTextAction name html parent-tag add-tag alternate-parent-tag alternate-add-tag))
  (^HTMLEditorKit$InsertHTMLTextAction [^java.lang.String name ^java.lang.String html ^javax.swing.text.html.HTML$Tag parent-tag ^javax.swing.text.html.HTML$Tag add-tag]
    (new HTMLEditorKit$InsertHTMLTextAction name html parent-tag add-tag)))

(defn action-performed
  "Inserts the HTML into the document.

  ae - the event - `java.awt.event.ActionEvent`"
  ([^HTMLEditorKit$InsertHTMLTextAction this ^java.awt.event.ActionEvent ae]
    (-> this (.actionPerformed ae))))

