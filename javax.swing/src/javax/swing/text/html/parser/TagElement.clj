(ns javax.swing.text.html.parser.TagElement
  "A generic HTML TagElement class. The methods define how white
  space is interpreted around the tag."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser TagElement]))

(defn ->tag-element
  "Constructor.

  elem - `javax.swing.text.html.parser.Element`
  fictional - `boolean`"
  ([elem fictional]
    (new TagElement elem fictional))
  ([elem]
    (new TagElement elem)))

(defn breaks-flow
  "returns: `boolean`"
  ([this]
    (-> this (.breaksFlow))))

(defn preformatted?
  "returns: `boolean`"
  ([this]
    (-> this (.isPreformatted))))

(defn get-element
  "returns: `javax.swing.text.html.parser.Element`"
  ([this]
    (-> this (.getElement))))

(defn get-html-tag
  "returns: `javax.swing.text.html.HTML.Tag`"
  ([this]
    (-> this (.getHTMLTag))))

(defn fictional
  "returns: `boolean`"
  ([this]
    (-> this (.fictional))))

