(ns javax.swing.text.html.parser.ContentModel
  "A representation of a content model. A content model is
  basically a restricted BNF expression. It is restricted in
  the sense that it must be deterministic. This means that you
  don't have to represent it as a finite state automaton.
  See Annex H on page 556 of the SGML handbook for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser ContentModel]))

(defn ->content-model
  "Constructor.

  Create a content model of a particular type.

  type - `int`
  content - `java.lang.Object`
  next - `javax.swing.text.html.parser.ContentModel`"
  ([^Integer type ^java.lang.Object content ^javax.swing.text.html.parser.ContentModel next]
    (new ContentModel type content next))
  ([^Integer type ^javax.swing.text.html.parser.ContentModel content]
    (new ContentModel type content))
  ([^javax.swing.text.html.parser.Element content]
    (new ContentModel content))
  ([]
    (new ContentModel )))

(defn -type
  "Instance Field.

  Type. Either '*', '?', '+', ',', '|', '&'.

  type: int"
  [this]
  (-> this .-type))

(defn -content
  "Instance Field.

  The content. Either an Element or a ContentModel.

  type: java.lang.Object"
  [this]
  (-> this .-content))

(defn -next
  "Instance Field.

  The next content model (in a ',', '|' or '&' expression).

  type: javax.swing.text.html.parser.ContentModel"
  [this]
  (-> this .-next))

(defn empty
  "Return true if the content model could
   match an empty input stream.

  returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.ContentModel this]
    (-> this (.empty))))

(defn get-elements
  "Update elemVec with the list of elements that are
   part of the this contentModel.

  elem-vec - `java.util.Vector<javax.swing.text.html.parser.Element>`"
  ([^javax.swing.text.html.parser.ContentModel this ^java.util.Vector elem-vec]
    (-> this (.getElements elem-vec))))

(defn first
  "Return true if the token could potentially be the
   first token in the input stream.

  token - `java.lang.Object`

  returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.ContentModel this ^java.lang.Object token]
    (-> this (.first token)))
  (^javax.swing.text.html.parser.Element [^javax.swing.text.html.parser.ContentModel this]
    (-> this (.first))))

(defn to-string
  "Convert to a string.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.parser.ContentModel this]
    (-> this (.toString))))

