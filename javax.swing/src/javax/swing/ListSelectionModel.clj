(ns javax.swing.ListSelectionModel
  "This interface represents the current state of the
  selection for any of the components that display a
  list of values with stable indices.  The selection is
  modeled as a set of intervals, each interval represents
  a contiguous range of selected list elements.
  The methods for modifying the set of selected intervals
  all take a pair of indices, index0 and index1, that represent
  a closed interval, i.e. the interval includes both index0 and
  index1."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ListSelectionModel]))

(defn insert-index-interval
  "Insert length indices beginning before/after index.  This is typically
   called to sync the selection model with a corresponding change
   in the data model.

  index - `int`
  length - `int`
  before - `boolean`"
  ([^. this ^Integer index ^Integer length ^Boolean before]
    (-> this (.insertIndexInterval index length before))))

(defn get-value-is-adjusting?
  "Returns true if the selection is undergoing a series of changes.

  returns: true if the selection is undergoing a series of changes - `boolean`"
  ([^. this]
    (-> this (.getValueIsAdjusting))))

(defn add-list-selection-listener
  "Add a listener to the list that's notified each time a change
   to the selection occurs.

  x - the ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  ([^. this ^javax.swing.event.ListSelectionListener x]
    (-> this (.addListSelectionListener x))))

(defn clear-selection
  "Change the selection to the empty set.  If this represents
   a change to the current selection then notify each ListSelectionListener."
  ([^. this]
    (-> this (.clearSelection))))

(defn get-lead-selection-index
  "Return the second index argument from the most recent call to
   setSelectionInterval(), addSelectionInterval() or removeSelectionInterval().

  returns: `int`"
  ([^. this]
    (-> this (.getLeadSelectionIndex))))

(defn get-anchor-selection-index
  "Return the first index argument from the most recent call to
   setSelectionInterval(), addSelectionInterval() or removeSelectionInterval().
   The most recent index0 is considered the `anchor` and the most recent
   index1 is considered the `lead`.  Some interfaces display these
   indices specially, e.g. Windows95 displays the lead index with a
   dotted yellow outline.

  returns: `int`"
  ([^. this]
    (-> this (.getAnchorSelectionIndex))))

(defn selected-index?
  "Returns true if the specified index is selected.

  index - `int`

  returns: `boolean`"
  ([^. this ^Integer index]
    (-> this (.isSelectedIndex index))))

(defn remove-index-interval
  "Remove the indices in the interval index0,index1 (inclusive) from
   the selection model.  This is typically called to sync the selection
   model width a corresponding change in the data model.

  index-0 - `int`
  index-1 - `int`"
  ([^. this ^Integer index-0 ^Integer index-1]
    (-> this (.removeIndexInterval index-0 index-1))))

(defn set-selection-interval
  "Changes the selection to be between index0 and index1
   inclusive. index0 doesn't have to be less than or equal to
   index1.

   In SINGLE_SELECTION selection mode, only the second index
   is used.

   If this represents a change to the current selection, then each
   ListSelectionListener is notified of the change.

  index-0 - one end of the interval. - `int`
  index-1 - other end of the interval - `int`"
  ([^. this ^Integer index-0 ^Integer index-1]
    (-> this (.setSelectionInterval index-0 index-1))))

(defn remove-selection-interval
  "Changes the selection to be the set difference of the current selection
   and the indices between index0 and index1 inclusive.
   index0 doesn't have to be less than or equal to index1.

   In SINGLE_INTERVAL_SELECTION selection mode, if the removal
   would produce two disjoint selections, the removal is extended through
   the greater end of the selection. For example, if the selection is
   0-10 and you supply indices 5,6 (in any order) the
   resulting selection is 0-4.

   If this represents a change to the current selection, then each
   ListSelectionListener is notified of the change.

  index-0 - one end of the interval. - `int`
  index-1 - other end of the interval - `int`"
  ([^. this ^Integer index-0 ^Integer index-1]
    (-> this (.removeSelectionInterval index-0 index-1))))

(defn add-selection-interval
  "Changes the selection to be the set union of the current selection
   and the indices between index0 and index1 inclusive.
   index0 doesn't have to be less than or equal to index1.

   In SINGLE_SELECTION selection mode, this is equivalent
   to calling setSelectionInterval, and only the second index
   is used. In SINGLE_INTERVAL_SELECTION selection mode, this
   method behaves like setSelectionInterval, unless the given
   interval is immediately adjacent to or overlaps the existing selection,
   and can therefore be used to grow the selection.

   If this represents a change to the current selection, then each
   ListSelectionListener is notified of the change.

  index-0 - one end of the interval. - `int`
  index-1 - other end of the interval - `int`"
  ([^. this ^Integer index-0 ^Integer index-1]
    (-> this (.addSelectionInterval index-0 index-1))))

(defn remove-list-selection-listener
  "Remove a listener from the list that's notified each time a
   change to the selection occurs.

  x - the ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  ([^. this ^javax.swing.event.ListSelectionListener x]
    (-> this (.removeListSelectionListener x))))

(defn get-max-selection-index
  "Returns the last selected index or -1 if the selection is empty.

  returns: `int`"
  ([^. this]
    (-> this (.getMaxSelectionIndex))))

(defn selection-empty?
  "Returns true if no indices are selected.

  returns: `boolean`"
  ([^. this]
    (-> this (.isSelectionEmpty))))

(defn get-min-selection-index
  "Returns the first selected index or -1 if the selection is empty.

  returns: `int`"
  ([^. this]
    (-> this (.getMinSelectionIndex))))

(defn set-value-is-adjusting
  "Sets the valueIsAdjusting property, which indicates whether
   or not upcoming selection changes should be considered part of a single
   change. The value of this property is used to initialize the
   valueIsAdjusting property of the ListSelectionEvents that
   are generated.

   For example, if the selection is being updated in response to a user
   drag, this property can be set to true when the drag is initiated
   and set to false when the drag is finished. During the drag,
   listeners receive events with a valueIsAdjusting property
   set to true. At the end of the drag, when the change is
   finalized, listeners receive an event with the value set to false.
   Listeners can use this pattern if they wish to update only when a change
   has been finalized.

   Setting this property to true begins a series of changes that
   is to be considered part of a single change. When the property is changed
   back to false, an event is sent out characterizing the entire
   selection change (if there was one), with the event's
   valueIsAdjusting property set to false.

  value-is-adjusting - the new value of the property - `boolean`"
  ([^. this ^Boolean value-is-adjusting]
    (-> this (.setValueIsAdjusting value-is-adjusting))))

(defn set-anchor-selection-index
  "Set the anchor selection index.

  index - `int`"
  ([^. this ^Integer index]
    (-> this (.setAnchorSelectionIndex index))))

(defn get-selection-mode
  "Returns the current selection mode.

  returns: the current selection mode - `int`"
  ([^. this]
    (-> this (.getSelectionMode))))

(defn set-lead-selection-index
  "Set the lead selection index.

  index - `int`"
  ([^. this ^Integer index]
    (-> this (.setLeadSelectionIndex index))))

(defn set-selection-mode
  "Sets the selection mode. The following list describes the accepted
   selection modes:

   ListSelectionModel.SINGLE_SELECTION -
     Only one list index can be selected at a time. In this mode,
     setSelectionInterval and addSelectionInterval are
     equivalent, both replacing the current selection with the index
     represented by the second argument (the `lead`).
   ListSelectionModel.SINGLE_INTERVAL_SELECTION -
     Only one contiguous interval can be selected at a time.
     In this mode, addSelectionInterval behaves like
     setSelectionInterval (replacing the current selection),
     unless the given interval is immediately adjacent to or overlaps
     the existing selection, and can therefore be used to grow it.
   ListSelectionModel.MULTIPLE_INTERVAL_SELECTION -
     In this mode, there's no restriction on what can be selected.

  selection-mode - `int`

  throws: java.lang.IllegalArgumentException - if the selection mode isn't one of those allowed"
  ([^. this ^Integer selection-mode]
    (-> this (.setSelectionMode selection-mode))))

