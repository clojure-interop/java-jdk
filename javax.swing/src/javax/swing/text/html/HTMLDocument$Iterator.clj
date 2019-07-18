(ns javax.swing.text.html.HTMLDocument$Iterator
  "An iterator to iterate over a particular type of
  tag.  The iterator is not thread safe.  If reliable
  access to the document is not already ensured by
  the context under which the iterator is being used,
  its use should be performed under the protection of
  Document.render."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLDocument$Iterator]))

(defn ->iterator
  "Constructor."
  (^HTMLDocument$Iterator []
    (new HTMLDocument$Iterator )))

(defn get-attributes
  "Return the attributes for this tag.

  returns: the AttributeSet for this tag, or
        null if none can be found - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^HTMLDocument$Iterator this]
    (-> this (.getAttributes))))

(defn get-start-offset
  "Returns the start of the range for which the current occurrence of
   the tag is defined and has the same attributes.

  returns: the start of the range, or -1 if it can't be found - `int`"
  (^Integer [^HTMLDocument$Iterator this]
    (-> this (.getStartOffset))))

(defn get-end-offset
  "Returns the end of the range for which the current occurrence of
   the tag is defined and has the same attributes.

  returns: the end of the range - `int`"
  (^Integer [^HTMLDocument$Iterator this]
    (-> this (.getEndOffset))))

(defn next
  "Move the iterator forward to the next occurrence
   of the tag it represents."
  ([^HTMLDocument$Iterator this]
    (-> this (.next))))

(defn valid?
  "Indicates if the iterator is currently
   representing an occurrence of a tag.  If
   false there are no more tags for this iterator.

  returns: true if the iterator is currently representing an
                occurrence of a tag, otherwise returns false - `boolean`"
  (^Boolean [^HTMLDocument$Iterator this]
    (-> this (.isValid))))

(defn get-tag
  "Type of tag this iterator represents.

  returns: `javax.swing.text.html.HTML$Tag`"
  (^javax.swing.text.html.HTML$Tag [^HTMLDocument$Iterator this]
    (-> this (.getTag))))

