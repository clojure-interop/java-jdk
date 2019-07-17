(ns javax.swing.text.html.HTMLEditorKit$HTMLTextAction
  "An abstract Action providing some convenience methods that may
  be useful in inserting HTML into an existing document.
  NOTE: None of the convenience methods obtain a lock on the
  document. If you have another thread modifying the text these
  methods may have inconsistent behavior, or return the wrong thing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit$HTMLTextAction]))

(defn ->html-text-action
  "Constructor.

  name - `java.lang.String`"
  ([^java.lang.String name]
    (new HTMLEditorKit$HTMLTextAction name)))

