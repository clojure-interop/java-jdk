(ns javax.swing.event.ListDataEvent
  "Defines an event that encapsulates changes to a list.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ListDataEvent]))

(defn ->list-data-event
  "Constructor.

  Constructs a ListDataEvent object. If index0 is >
   index1, index0 and index1 will be swapped such that
   index0 will always be <= index1.

  source - the source Object (typically this) - `java.lang.Object`
  type - an int specifying CONTENTS_CHANGED, INTERVAL_ADDED, or INTERVAL_REMOVED - `int`
  index-0 - one end of the new interval - `int`
  index-1 - the other end of the new interval - `int`"
  (^ListDataEvent [^java.lang.Object source ^Integer type ^Integer index-0 ^Integer index-1]
    (new ListDataEvent source type index-0 index-1)))

(def *-contents-changed
  "Static Constant.

  Identifies one or more changes in the lists contents.

  type: int"
  ListDataEvent/CONTENTS_CHANGED)

(def *-interval-added
  "Static Constant.

  Identifies the addition of one or more contiguous items to the list

  type: int"
  ListDataEvent/INTERVAL_ADDED)

(def *-interval-removed
  "Static Constant.

  Identifies the removal of one or more contiguous items from the list

  type: int"
  ListDataEvent/INTERVAL_REMOVED)

(defn get-type
  "Returns the event type. The possible values are:

    CONTENTS_CHANGED
    INTERVAL_ADDED
    INTERVAL_REMOVED

  returns: an int representing the type value - `int`"
  (^Integer [^ListDataEvent this]
    (-> this (.getType))))

(defn get-index-0
  "Returns the lower index of the range. For a single
   element, this value is the same as that returned by getIndex1().

  returns: an int representing the lower index value - `int`"
  (^Integer [^ListDataEvent this]
    (-> this (.getIndex0))))

(defn get-index-1
  "Returns the upper index of the range. For a single
   element, this value is the same as that returned by getIndex0().

  returns: an int representing the upper index value - `int`"
  (^Integer [^ListDataEvent this]
    (-> this (.getIndex1))))

(defn to-string
  "Returns a string representation of this ListDataEvent. This method
   is intended to be used only for debugging purposes, and the
   content and format of the returned string may vary between
   implementations. The returned string may be empty but may not
   be null.

  returns: a string representation of this ListDataEvent. - `java.lang.String`"
  (^java.lang.String [^ListDataEvent this]
    (-> this (.toString))))

