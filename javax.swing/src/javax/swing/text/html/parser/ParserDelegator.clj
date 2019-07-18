(ns javax.swing.text.html.parser.ParserDelegator
  "Responsible for starting up a new DocumentParser
  each time its parse method is invoked. Stores a
  reference to the dtd."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser ParserDelegator]))

(defn ->parser-delegator
  "Constructor."
  (^ParserDelegator []
    (new ParserDelegator )))

(defn parse
  "Description copied from class: HTMLEditorKit.Parser

  r - `java.io.Reader`
  cb - `javax.swing.text.html.HTMLEditorKit$ParserCallback`
  ignore-char-set - `boolean`

  throws: java.io.IOException"
  ([^ParserDelegator this ^java.io.Reader r ^javax.swing.text.html.HTMLEditorKit$ParserCallback cb ^Boolean ignore-char-set]
    (-> this (.parse r cb ignore-char-set))))

