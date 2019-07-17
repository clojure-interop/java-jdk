(ns javax.swing.text.html.HTMLEditorKit$Parser
  "Interface to be supported by the parser.  This enables
  providing a different parser while reusing some of the
  implementation provided by this editor kit."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit$Parser]))

(defn ->parser
  "Constructor."
  ([]
    (new HTMLEditorKit$Parser )))

(defn parse
  "Parse the given stream and drive the given callback
   with the results of the parse.  This method should
   be implemented to be thread-safe.

  r - `java.io.Reader`
  cb - `javax.swing.text.html.HTMLEditorKit.ParserCallback`
  ignore-char-set - `boolean`

  throws: java.io.IOException"
  ([^javax.swing.text.html.HTMLEditorKit$Parser this ^java.io.Reader r ^javax.swing.text.html.HTMLEditorKit.ParserCallback cb ^Boolean ignore-char-set]
    (-> this (.parse r cb ignore-char-set))))

