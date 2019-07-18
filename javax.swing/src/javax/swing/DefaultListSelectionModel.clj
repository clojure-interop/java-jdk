(ns javax.swing.DefaultListSelectionModel
  "Default data model for list selections.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultListSelectionModel]))

(defn ->default-list-selection-model
  "Constructor."
  (^DefaultListSelectionModel []
    (new DefaultListSelectionModel )))

(defn insert-index-interval
  "Insert length indices beginning before/after index. If the value
   at index is itself selected and the selection mode is not
   SINGLE_SELECTION, set all of the newly inserted items as selected.
   Otherwise leave them unselected. This method is typically
   called to sync the selection model with a corresponding change
   in the data model.

  index - `int`
  length - `int`
  before - `boolean`"
  ([^DefaultListSelectionModel this ^Integer index ^Integer length ^Boolean before]
    (-> this (.insertIndexInterval index length before))))

(defn get-value-is-adjusting?
  "Returns true if the selection is undergoing a series of changes.

  returns: true if the selection is undergoing a series of changes - `boolean`"
  (^Boolean [^DefaultListSelectionModel this]
    (-> this (.getValueIsAdjusting))))

(defn add-list-selection-listener
  "Add a listener to the list that's notified each time a change
   to the selection occurs.

  l - the ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  ([^DefaultListSelectionModel this ^javax.swing.event.ListSelectionListener l]
    (-> this (.addListSelectionListener l))))

(defn clear-selection
  "Change the selection to the empty set.  If this represents
   a change to the current selection then notify each ListSelectionListener."
  ([^DefaultListSelectionModel this]
    (-> this (.clearSelection))))

(defn get-lead-selection-index
  "Return the second index argument from the most recent call to
   setSelectionInterval(), addSelectionInterval() or removeSelectionInterval().

  returns: `int`"
  (^Integer [^DefaultListSelectionModel this]
    (-> this (.getLeadSelectionIndex))))

(defn get-anchor-selection-index
  "Return the first index argument from the most recent call to
   setSelectionInterval(), addSelectionInterval() or removeSelectionInterval().
   The most recent index0 is considered the `anchor` and the most recent
   index1 is considered the `lead`.  Some interfaces display these
   indices specially, e.g. Windows95 displays the lead index with a
   dotted yellow outline.

  returns: `int`"
  (^Integer [^DefaultListSelectionModel this]
    (-> this (.getAnchorSelectionIndex))))

(defn selected-index?
  "Returns true if the specified index is selected.

  index - `int`

  returns: `boolean`"
  (^Boolean [^DefaultListSelectionModel this ^Integer index]
    (-> this (.isSelectedIndex index))))

(defn remove-index-interval
  "Remove the indices in the interval index0,index1 (inclusive) from
   the selection model.  This is typically called to sync the selection
   model width a corresponding change in the data model.  Note
   that (as always) index0 need not be <= index1.

  index-0 - `int`
  index-1 - `int`"
  ([^DefaultListSelectionModel this ^Integer index-0 ^Integer index-1]
    (-> this (.removeIndexInterval index-0 index-1))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^DefaultListSelectionModel this]
    (-> this (.toString))))

(defn set-selection-interval
  "Changes the selection to be between index0 and index1
   inclusive. index0 doesn't have to be less than or equal to
   index1.

   In SINGLE_SELECTION selection mode, only the second index
   is used.

   If this represents a change to the current selection, then each
   ListSelectionListener is notified of the change.

   If either index is -1, this method does nothing and returns
   without exception. Otherwise, if either index is less than -1,
   an IndexOutOfBoundsException is thrown.

  index-0 - one end of the interval. - `int`
  index-1 - other end of the interval - `int`

  throws: java.lang.IndexOutOfBoundsException - if either index is less than -1 (and neither index is -1)"
  ([^DefaultListSelectionModel this ^Integer index-0 ^Integer index-1]
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

   If either index is -1, this method does nothing and returns
   without exception. Otherwise, if either index is less than -1,
   an IndexOutOfBoundsException is thrown.

  index-0 - one end of the interval - `int`
  index-1 - other end of the interval - `int`

  throws: java.lang.IndexOutOfBoundsException - if either index is less than -1 (and neither index is -1)"
  ([^DefaultListSelectionModel this ^Integer index-0 ^Integer index-1]
    (-> this (.removeSelectionInterval index-0 index-1))))

(defn add-selection-interval
  "Changes the selection to be the set union of the current selection
   and the indices between index0 and index1 inclusive.

   In SINGLE_SELECTION selection mode, this is equivalent
   to calling setSelectionInterval, and only the second index
   is used. In SINGLE_INTERVAL_SELECTION selection mode, this
   method behaves like setSelectionInterval, unless the given
   interval is immediately adjacent to or overlaps the existing selection,
   and can therefore be used to grow it.

   If this represents a change to the current selection, then each
   ListSelectionListener is notified of the change. Note that
   index0 doesn't have to be less than or equal to index1.

   If either index is -1, this method does nothing and returns
   without exception. Otherwise, if either index is less than -1,
   an IndexOutOfBoundsException is thrown.

  index-0 - one end of the interval. - `int`
  index-1 - other end of the interval - `int`

  throws: java.lang.IndexOutOfBoundsException - if either index is less than -1 (and neither index is -1)"
  ([^DefaultListSelectionModel this ^Integer index-0 ^Integer index-1]
    (-> this (.addSelectionInterval index-0 index-1))))

(defn remove-list-selection-listener
  "Remove a listener from the list that's notified each time a
   change to the selection occurs.

  l - the ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  ([^DefaultListSelectionModel this ^javax.swing.event.ListSelectionListener l]
    (-> this (.removeListSelectionListener l))))

(defn set-lead-anchor-notification-enabled
  "Sets the value of the leadAnchorNotificationEnabled flag.

  flag - `boolean`"
  ([^DefaultListSelectionModel this ^Boolean flag]
    (-> this (.setLeadAnchorNotificationEnabled flag))))

(defn get-max-selection-index
  "Returns the last selected index or -1 if the selection is empty.

  returns: `int`"
  (^Integer [^DefaultListSelectionModel this]
    (-> this (.getMaxSelectionIndex))))

(defn lead-anchor-notification-enabled?
  "Returns the value of the leadAnchorNotificationEnabled flag.
   When leadAnchorNotificationEnabled is true the model
   generates notification events with bounds that cover all the changes to
   the selection plus the changes to the lead and anchor indices.
   Setting the flag to false causes a narrowing of the event's bounds to
   include only the elements that have been selected or deselected since
   the last change. Either way, the model continues to maintain the lead
   and anchor variables internally. The default is true.

   Note: It is possible for the lead or anchor to be changed without a
   change to the selection. Notification of these changes is often
   important, such as when the new lead or anchor needs to be updated in
   the view. Therefore, caution is urged when changing the default value.

  returns: the value of the leadAnchorNotificationEnabled flag - `boolean`"
  (^Boolean [^DefaultListSelectionModel this]
    (-> this (.isLeadAnchorNotificationEnabled))))

(defn selection-empty?
  "Returns true if no indices are selected.

  returns: `boolean`"
  (^Boolean [^DefaultListSelectionModel this]
    (-> this (.isSelectionEmpty))))

(defn get-min-selection-index
  "Returns the first selected index or -1 if the selection is empty.

  returns: `int`"
  (^Integer [^DefaultListSelectionModel this]
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

  is-adjusting - the new value of the property - `boolean`"
  ([^DefaultListSelectionModel this ^Boolean is-adjusting]
    (-> this (.setValueIsAdjusting is-adjusting))))

(defn get-list-selection-listeners
  "Returns an array of all the list selection listeners
   registered on this DefaultListSelectionModel.

  returns: all of this model's ListSelectionListeners
           or an empty
           array if no list selection listeners are currently registered - `javax.swing.event.ListSelectionListener[]`"
  ([^DefaultListSelectionModel this]
    (-> this (.getListSelectionListeners))))

(defn move-lead-selection-index
  "Set the lead selection index, leaving all selection values unchanged.
   If leadAnchorNotificationEnabled is true, send a notification covering
   the old and new lead cells.

  lead-index - the new lead selection index - `int`"
  ([^DefaultListSelectionModel this ^Integer lead-index]
    (-> this (.moveLeadSelectionIndex lead-index))))

(defn set-anchor-selection-index
  "Set the anchor selection index, leaving all selection values unchanged.
   If leadAnchorNotificationEnabled is true, send a notification covering
   the old and new anchor cells.

  anchor-index - `int`"
  ([^DefaultListSelectionModel this ^Integer anchor-index]
    (-> this (.setAnchorSelectionIndex anchor-index))))

(defn clone
  "Returns a clone of this selection model with the same selection.
   listenerLists are not duplicated.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if the selection model does not both (a) implement the Cloneable interface and (b) define a clone method."
  (^java.lang.Object [^DefaultListSelectionModel this]
    (-> this (.clone))))

(defn get-selection-mode
  "Returns the current selection mode.

  returns: the current selection mode - `int`"
  (^Integer [^DefaultListSelectionModel this]
    (-> this (.getSelectionMode))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this model.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a DefaultListSelectionModel
   instance m
   for its list selection listeners
   with the following code:



  ListSelectionListener[] lsls = (ListSelectionListener[])(m.getListeners(ListSelectionListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners
            on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^DefaultListSelectionModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn set-lead-selection-index
  "Sets the lead selection index, ensuring that values between the
   anchor and the new lead are either all selected or all deselected.
   If the value at the anchor index is selected, first clear all the
   values in the range [anchor, oldLeadIndex], then select all the values
   values in the range [anchor, newLeadIndex], where oldLeadIndex is the old
   leadIndex and newLeadIndex is the new one.

   If the value at the anchor index is not selected, do the same thing in
   reverse selecting values in the old range and deselecting values in the
   new one.

   Generate a single event for this change and notify all listeners.
   For the purposes of generating minimal bounds in this event, do the
   operation in a single pass; that way the first and last index inside the
   ListSelectionEvent that is broadcast will refer to cells that actually
   changed value because of this method. If, instead, this operation were
   done in two steps the effect on the selection state would be the same
   but two events would be generated and the bounds around the changed
   values would be wider, including cells that had been first cleared only
   to later be set.

   This method can be used in the mouseDragged method
   of a UI class to extend a selection.

  lead-index - `int`"
  ([^DefaultListSelectionModel this ^Integer lead-index]
    (-> this (.setLeadSelectionIndex lead-index))))

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
  ([^DefaultListSelectionModel this ^Integer selection-mode]
    (-> this (.setSelectionMode selection-mode))))

