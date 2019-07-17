(ns javax.swing.text.Position
  "Represents a location within a document.  It is intended to abstract away
  implementation details of the document and enable specification of
  positions within the document that are capable of tracking of change as
  the document is edited.

  A Position object points at a location between two characters.
  As the surrounding content is altered, the Position object
  adjusts its offset automatically to reflect the changes. If content is
  inserted or removed before the Position object's location, then the
  Position increments or decrements its offset, respectively,
  so as to point to the same location. If a portion of the document is removed
  that contains a Position's offset, then the Position's
  offset becomes that of the beginning of the removed region. For example, if
  a Position has an offset of 5 and the region 2-10 is removed, then
  the Position's offset becomes 2.

  Position with an offset of 0 is a special case. It never changes its
  offset while document content is altered."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Position]))

(defn get-offset
  "Fetches the current offset within the document.

  returns: the offset >= 0 - `int`"
  ([this]
    (-> this (.getOffset))))

