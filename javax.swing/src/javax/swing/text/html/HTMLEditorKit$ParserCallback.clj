(ns javax.swing.text.html.HTMLEditorKit$ParserCallback
  "The result of parsing drives these callback methods.
  The open and close actions should be balanced.  The
  flush method will be the last method
  called, to give the receiver a chance to flush any
  pending data into the document.
  Refer to DocumentParser, the default parser used, for further
  information on the contents of the AttributeSets, the positions, and
  other info."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit$ParserCallback]))

(defn ->parser-callback
  "Constructor."
  (^HTMLEditorKit$ParserCallback []
    (new HTMLEditorKit$ParserCallback )))

(def *-implied
  "Static Constant.

  This is passed as an attribute in the attributeset to indicate
   the element is implied eg, the string '<>foo<\\t>'
   contains an implied html element and an implied body element.

  type: java.lang.Object"
  HTMLEditorKit$ParserCallback/IMPLIED)

(defn flush
  "throws: javax.swing.text.BadLocationException"
  ([^HTMLEditorKit$ParserCallback this]
    (-> this (.flush))))

(defn handle-text
  "data - `char[]`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this data ^Integer pos]
    (-> this (.handleText data pos))))

(defn handle-comment
  "data - `char[]`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this data ^Integer pos]
    (-> this (.handleComment data pos))))

(defn handle-start-tag
  "t - `javax.swing.text.html.HTML$Tag`
  a - `javax.swing.text.MutableAttributeSet`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this ^javax.swing.text.html.HTML$Tag t ^javax.swing.text.MutableAttributeSet a ^Integer pos]
    (-> this (.handleStartTag t a pos))))

(defn handle-end-tag
  "t - `javax.swing.text.html.HTML$Tag`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this ^javax.swing.text.html.HTML$Tag t ^Integer pos]
    (-> this (.handleEndTag t pos))))

(defn handle-simple-tag
  "t - `javax.swing.text.html.HTML$Tag`
  a - `javax.swing.text.MutableAttributeSet`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this ^javax.swing.text.html.HTML$Tag t ^javax.swing.text.MutableAttributeSet a ^Integer pos]
    (-> this (.handleSimpleTag t a pos))))

(defn handle-error
  "error-msg - `java.lang.String`
  pos - `int`"
  ([^HTMLEditorKit$ParserCallback this ^java.lang.String error-msg ^Integer pos]
    (-> this (.handleError error-msg pos))))

(defn handle-end-of-line-string
  "This is invoked after the stream has been parsed, but before
   flush. eol will be one of \\n, \\r
   or \\r\\n, which ever is encountered the most in parsing the
   stream.

  eol - `java.lang.String`"
  ([^HTMLEditorKit$ParserCallback this ^java.lang.String eol]
    (-> this (.handleEndOfLineString eol))))

