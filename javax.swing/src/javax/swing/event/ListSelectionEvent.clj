(ns javax.swing.event.ListSelectionEvent
  "An event that characterizes a change in selection. The change is limited to a
  a single inclusive interval. The selection of at least one index within the
  range will have changed. A decent ListSelectionModel implementation
  will keep the range as small as possible. ListSelectionListeners will
  generally query the source of the event for the new selected status of each
  potentially changed row.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ListSelectionEvent]))

(defn ->list-selection-event
  "Constructor.

  Represents a change in selection status between firstIndex and
   lastIndex, inclusive. firstIndex is less than or equal to
   lastIndex. The selection of at least one index within the range will
   have changed.

  source - `java.lang.Object`
  first-index - the first index in the range, <= lastIndex - `int`
  last-index - the last index in the range, >= firstIndex - `int`
  is-adjusting - whether or not this is one in a series of multiple events, where changes are still being made - `boolean`"
  ([source first-index last-index is-adjusting]
    (new ListSelectionEvent source first-index last-index is-adjusting)))

(defn get-first-index
  "Returns the index of the first row whose selection may have changed.
   getFirstIndex() <= getLastIndex()

  returns: the first row whose selection value may have changed,
           where zero is the first row - `int`"
  ([this]
    (-> this (.getFirstIndex))))

(defn get-last-index
  "Returns the index of the last row whose selection may have changed.
   getLastIndex() >= getFirstIndex()

  returns: the last row whose selection value may have changed,
           where zero is the first row - `int`"
  ([this]
    (-> this (.getLastIndex))))

(defn get-value-is-adjusting?
  "Returns whether or not this is one in a series of multiple events,
   where changes are still being made. See the documentation for
   ListSelectionModel.setValueIsAdjusting(boolean) for
   more details on how this is used.

  returns: true if this is one in a series of multiple events,
           where changes are still being made - `boolean`"
  ([this]
    (-> this (.getValueIsAdjusting))))

(defn to-string
  "Returns a String that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

