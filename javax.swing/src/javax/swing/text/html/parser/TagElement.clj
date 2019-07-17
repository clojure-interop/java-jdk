(ns javax.swing.text.html.parser.TagElement
  "A generic HTML TagElement class. The methods define how white
  space is interpreted around the tag."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser TagElement]))

(defn ->tag-element
  "Constructor.

  elem - `javax.swing.text.html.parser.Element`
  fictional - `boolean`"
  ([^javax.swing.text.html.parser.Element elem ^Boolean fictional]
    (new TagElement elem fictional))
  ([^javax.swing.text.html.parser.Element elem]
    (new TagElement elem)))

(defn breaks-flow
  "returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.TagElement this]
    (-> this (.breaksFlow))))

(defn preformatted?
  "returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.TagElement this]
    (-> this (.isPreformatted))))

(defn get-element
  "returns: `javax.swing.text.html.parser.Element`"
  (^javax.swing.text.html.parser.Element [^javax.swing.text.html.parser.TagElement this]
    (-> this (.getElement))))

(defn get-html-tag
  "returns: `javax.swing.text.html.HTML.Tag`"
  (^javax.swing.text.html.HTML.Tag [^javax.swing.text.html.parser.TagElement this]
    (-> this (.getHTMLTag))))

(defn fictional
  "returns: `boolean`"
  (^Boolean [^javax.swing.text.html.parser.TagElement this]
    (-> this (.fictional))))

