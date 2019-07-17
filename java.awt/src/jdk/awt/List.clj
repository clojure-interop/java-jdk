(ns jdk.awt.List
  "The List component presents the user with a
  scrolling list of text items. The list can be set up so that
  the user can choose either one item or multiple items.

  For example, the code . . .



  List lst = new List(4, false);
  lst.add(`Mercury`);
  lst.add(`Venus`);
  lst.add(`Earth`);
  lst.add(`JavaSoft`);
  lst.add(`Mars`);
  lst.add(`Jupiter`);
  lst.add(`Saturn`);
  lst.add(`Uranus`);
  lst.add(`Neptune`);
  lst.add(`Pluto`);
  cnt.add(lst);

  where cnt is a container, produces the following
  scrolling list:



  If the List allows multiple selections, then clicking on
  an item that is already selected deselects it. In the preceding
  example, only one item from the scrolling list can be selected
  at a time, since the second argument when creating the new scrolling
  list is false. If the List does not allow multiple
  selections, selecting an item causes any other selected item
  to be deselected.

  Note that the list in the example shown was created with four visible
  rows.  Once the list has been created, the number of visible rows
  cannot be changed.  A default List is created with
  four rows, so that lst = new List() is equivalent to
  list = new List(4, false).

  Beginning with Java 1.1, the Abstract Window Toolkit
  sends the List object all mouse, keyboard, and focus events
  that occur over it. (The old AWT event model is being maintained
  only for backwards compatibility, and its use is discouraged.)

  When an item is selected or deselected by the user, AWT sends an instance
  of ItemEvent to the list.
  When the user double-clicks on an item in a scrolling list,
  AWT sends an instance of ActionEvent to the
  list following the item event. AWT also generates an action event
  when the user presses the return key while an item in the
  list is selected.

  If an application wants to perform some action based on an item
  in this list being selected or activated by the user, it should implement
  ItemListener or ActionListener
  as appropriate and register the new listener to receive
  events from this list.

  For multiple-selection scrolling lists, it is considered a better
  user interface to use an external gesture (such as clicking on a
  button) to trigger the action."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt List]))

(defn ->list
  "Constructor.

  Creates a new scrolling list initialized to display the specified
   number of rows. Note that if zero rows are specified, then
   the list will be created with a default of four rows.
   Also note that the number of visible rows in the list cannot
   be changed after it has been created.
   If the value of multipleMode is
   true, then the user can select multiple items from
   the list. If it is false, only one item at a time
   can be selected.

  rows - the number of items to show. - `int`
  multiple-mode - if true, then multiple selections are allowed; otherwise, only one item can be selected at a time. - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^Integer rows ^Boolean multiple-mode]
    (new List rows multiple-mode))
  ([^Integer rows]
    (new List rows))
  ([]
    (new List )))

(defn add-item-listener
  "Adds the specified item listener to receive item events from
   this list.  Item events are sent in response to user input, but not
   in response to calls to select or deselect.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.List this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn get-minimum-size
  "Gets the minimum dimensions for a list with the specified
   number of rows.

  rows - number of rows in the list - `int`

  returns: the minimum dimensions for displaying this scrolling list
               given that the specified number of rows must be visible - `java.awt.Dimension`"
  ([^java.awt.List this ^Integer rows]
    (-> this (.getMinimumSize rows)))
  ([^java.awt.List this]
    (-> this (.getMinimumSize))))

(defn add-item
  "Deprecated. replaced by add(String).

  item - `java.lang.String`

  returns: `java.lang.  void`"
  ([^java.awt.List this ^java.lang.String item]
    (-> this (.addItem item)))
  ([^java.awt.List this ^java.lang.String item ^Integer index]
    (-> this (.addItem item index))))

(defn get-item
  "Gets the item associated with the specified index.

  index - the position of the item - `int`

  returns: an item that is associated with
                      the specified index - `java.lang.String`"
  ([^java.awt.List this ^Integer index]
    (-> this (.getItem index))))

(defn get-item-count
  "Gets the number of items in the list.

  returns: the number of items in the list - `int`"
  ([^java.awt.List this]
    (-> this (.getItemCount))))

(defn set-multiple-selections
  "Deprecated. As of JDK version 1.1,
   replaced by setMultipleMode(boolean).

  b - `boolean`

  returns: `java.lang.  void`"
  ([^java.awt.List this ^Boolean b]
    (-> this (.setMultipleSelections b))))

(defn del-item
  "Deprecated. replaced by remove(String)
                           and remove(int).

  position - `int`

  returns: `java.lang.  void`"
  ([^java.awt.List this ^Integer position]
    (-> this (.delItem position))))

(defn remove-item-listener
  "Removes the specified item listener so that it no longer
   receives item events from this list.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.List this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn add-action-listener
  "Adds the specified action listener to receive action events from
   this list. Action events occur when a user double-clicks
   on a list item or types Enter when the list has the keyboard
   focus.

   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the action listener - `java.awt.event.ActionListener`"
  ([^java.awt.List this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn get-selected-index
  "Gets the index of the selected item on the list,

  returns: the index of the selected item;
                  if no item is selected, or if multiple items are
                  selected, -1 is returned. - `int`"
  ([^java.awt.List this]
    (-> this (.getSelectedIndex))))

(defn del-items
  "Deprecated. As of JDK version 1.1,
   Not for public use in the future.
   This method is expected to be retained only as a package
   private method.

  start - `int`
  end - `int`

  returns: `java.lang.  void`"
  ([^java.awt.List this ^Integer start ^Integer end]
    (-> this (.delItems start end))))

(defn add-notify
  "Creates the peer for the list.  The peer allows us to modify the
   list's appearance without changing its functionality."
  ([^java.awt.List this]
    (-> this (.addNotify))))

(defn get-visible-index
  "Gets the index of the item that was last made visible by
   the method makeVisible.

  returns: the index of the item that was last made visible - `int`"
  ([^java.awt.List this]
    (-> this (.getVisibleIndex))))

(defn remove-notify
  "Removes the peer for this list.  The peer allows us to modify the
   list's appearance without changing its functionality."
  ([^java.awt.List this]
    (-> this (.removeNotify))))

(defn select
  "Selects the item at the specified index in the scrolling list.

   Note that passing out of range parameters is invalid,
   and will result in unspecified behavior.

   Note that this method should be primarily used to
   initially select an item in this component.
   Programmatically calling this method will not trigger
   an ItemEvent.  The only way to trigger an
   ItemEvent is by user interaction.

  index - the position of the item to select - `int`"
  ([^java.awt.List this ^Integer index]
    (-> this (.select index))))

(defn get-items
  "Gets the items in the list.

  returns: a string array containing items of the list - `java.lang.String[]`"
  ([^java.awt.List this]
    (-> this (.getItems))))

(defn remove
  "Removes the first occurrence of an item from the list.
   If the specified item is selected, and is the only selected
   item in the list, the list is set to have no selection.

  item - the item to remove from the list - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the item doesn't exist in the list"
  ([^java.awt.List this ^java.lang.String item]
    (-> this (.remove item))))

(defn index-selected?
  "Determines if the specified item in this scrolling list is
   selected.

  index - the item to be checked - `int`

  returns: true if the specified item has been
                         selected; false otherwise - `boolean`"
  ([^java.awt.List this ^Integer index]
    (-> this (.isIndexSelected index))))

(defn make-visible
  "Makes the item at the specified index visible.

  index - the position of the item - `int`"
  ([^java.awt.List this ^Integer index]
    (-> this (.makeVisible index))))

(defn set-multiple-mode
  "Sets the flag that determines whether this list
   allows multiple selections.
   When the selection mode is changed from multiple-selection to
   single-selection, the selected items change as follows:
   If a selected item has the location cursor, only that
   item will remain selected.  If no selected item has the
   location cursor, all items will be deselected.

  b - if true then multiple selections are allowed; otherwise, only one item from the list can be selected at once - `boolean`"
  ([^java.awt.List this ^Boolean b]
    (-> this (.setMultipleMode b))))

(defn allows-multiple-selections
  "Deprecated. As of JDK version 1.1,
   replaced by isMultipleMode().

  returns: `java.lang.  boolean`"
  ([^java.awt.List this]
    (-> this (.allowsMultipleSelections))))

(defn get-action-listeners
  "Returns an array of all the action listeners
   registered on this list.

  returns: all of this list's ActionListeners
           or an empty array if no action
           listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^java.awt.List this]
    (-> this (.getActionListeners))))

(defn preferred-size
  "Deprecated. As of JDK version 1.1,
   replaced by getPreferredSize(int).

  rows - `int`

  returns: `java.lang.  java.awt.Dimension`"
  ([^java.awt.List this ^Integer rows]
    (-> this (.preferredSize rows)))
  ([^java.awt.List this]
    (-> this (.preferredSize))))

(defn deselect
  "Deselects the item at the specified index.

   Note that passing out of range parameters is invalid,
   and will result in unspecified behavior.

   If the item at the specified index is not selected,
   then the operation is ignored.

  index - the position of the item to deselect - `int`"
  ([^java.awt.List this ^Integer index]
    (-> this (.deselect index))))

(defn get-rows
  "Gets the number of visible lines in this list.  Note that
   once the List has been created, this number
   will never change.

  returns: the number of visible lines in this scrolling list - `int`"
  ([^java.awt.List this]
    (-> this (.getRows))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   List. For lists, the AccessibleContext
   takes the form of an AccessibleAWTList.
   A new AccessibleAWTList instance is created, if necessary.

  returns: an AccessibleAWTList that serves as the
           AccessibleContext of this List - `javax.accessibility.AccessibleContext`"
  ([^java.awt.List this]
    (-> this (.getAccessibleContext))))

(defn multiple-mode?
  "Determines whether this list allows multiple selections.

  returns: true if this list allows multiple
                   selections; otherwise, false - `boolean`"
  ([^java.awt.List this]
    (-> this (.isMultipleMode))))

(defn get-selected-item
  "Gets the selected item on this scrolling list.

  returns: the selected item on the list;
                  if no item is selected, or if multiple items are
                  selected, null is returned. - `java.lang.String`"
  ([^java.awt.List this]
    (-> this (.getSelectedItem))))

(defn is-selected
  "Deprecated. As of JDK version 1.1,
   replaced by isIndexSelected(int).

  index - `int`

  returns: `java.lang.  boolean`"
  ([^java.awt.List this ^Integer index]
    (-> this (.isSelected index))))

(defn get-selected-objects
  "Gets the selected items on this scrolling list in an array of Objects.

  returns: an array of Objects representing the
                  selected items on this scrolling list;
                  if no item is selected, a zero-length array is returned. - `java.lang.Object[]`"
  ([^java.awt.List this]
    (-> this (.getSelectedObjects))))

(defn remove-action-listener
  "Removes the specified action listener so that it no longer
   receives action events from this list. Action events
   occur when a user double-clicks on a list item.
   If listener l is null,
   no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the action listener - `java.awt.event.ActionListener`"
  ([^java.awt.List this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn add
  "Adds the specified item to the the scrolling list
   at the position indicated by the index.  The index is
   zero-based.  If the value of the index is less than zero,
   or if the value of the index is greater than or equal to
   the number of items in the list, then the item is added
   to the end of the list.

  item - the item to be added; if this parameter is null then the item is treated as an empty string, `` - `java.lang.String`
  index - the position at which to add the item - `int`"
  ([^java.awt.List this ^java.lang.String item ^Integer index]
    (-> this (.add item index)))
  ([^java.awt.List this ^java.lang.String item]
    (-> this (.add item))))

(defn replace-item
  "Replaces the item at the specified index in the scrolling list
   with the new string.

  new-value - a new string to replace an existing item - `java.lang.String`
  index - the position of the item to replace - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if index is out of range"
  ([^java.awt.List this ^java.lang.String new-value ^Integer index]
    (-> this (.replaceItem new-value index))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this List.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   List l
   for its item listeners with the following code:



  ItemListener[] ils = (ItemListener[])(l.getListeners(ItemListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this list,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^java.awt.List this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn clear
  "Deprecated. As of JDK version 1.1,
   replaced by removeAll().

  returns: `java.lang.  void`"
  ([^java.awt.List this]
    (-> this (.clear))))

(defn get-selected-indexes
  "Gets the selected indexes on the list.

  returns: an array of the selected indexes on this scrolling list;
                  if no item is selected, a zero-length array is returned. - `int[]`"
  ([^java.awt.List this]
    (-> this (.getSelectedIndexes))))

(defn minimum-size
  "Deprecated. As of JDK version 1.1,
   replaced by getMinimumSize(int).

  rows - `int`

  returns: `java.lang.  java.awt.Dimension`"
  ([^java.awt.List this ^Integer rows]
    (-> this (.minimumSize rows)))
  ([^java.awt.List this]
    (-> this (.minimumSize))))

(defn remove-all
  "Removes all items from this list."
  ([^java.awt.List this]
    (-> this (.removeAll))))

(defn count-items
  "Deprecated. As of JDK version 1.1,
   replaced by getItemCount().

  returns: `java.lang.  int`"
  ([^java.awt.List this]
    (-> this (.countItems))))

(defn get-preferred-size
  "Gets the preferred dimensions for a list with the specified
   number of rows.

  rows - number of rows in the list - `int`

  returns: the preferred dimensions for displaying this scrolling list
               given that the specified number of rows must be visible - `java.awt.Dimension`"
  ([^java.awt.List this ^Integer rows]
    (-> this (.getPreferredSize rows)))
  ([^java.awt.List this]
    (-> this (.getPreferredSize))))

(defn get-selected-items
  "Gets the selected items on this scrolling list.

  returns: an array of the selected items on this scrolling list;
                  if no item is selected, a zero-length array is returned. - `java.lang.String[]`"
  ([^java.awt.List this]
    (-> this (.getSelectedItems))))

(defn get-item-listeners
  "Returns an array of all the item listeners
   registered on this list.

  returns: all of this list's ItemListeners
           or an empty array if no item
           listeners are currently registered - `java.awt.event.ItemListener[]`"
  ([^java.awt.List this]
    (-> this (.getItemListeners))))

