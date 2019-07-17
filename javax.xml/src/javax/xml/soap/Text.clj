(ns javax.xml.soap.Text
  "A representation of a node whose value is text.  A Text object
  may represent text that is content or text that is a comment."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap Text]))

(defn comment?
  "Retrieves whether this Text object represents a comment.

  returns: true if this Text object is a
           comment; false otherwise - `boolean`"
  ([this]
    (-> this (.isComment))))

