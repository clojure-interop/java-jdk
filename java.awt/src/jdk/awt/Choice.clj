(ns jdk.awt.Choice
  "The Choice class presents a pop-up menu of choices.
  The current choice is displayed as the title of the menu.

  The following code example produces a pop-up menu:



  Choice ColorChooser = new Choice();
  ColorChooser.add(`Green`);
  ColorChooser.add(`Red`);
  ColorChooser.add(`Blue`);

  After this choice menu has been added to a panel,
  it appears as follows in its normal state:



  In the picture, `Green` is the current choice.
  Pushing the mouse button down on the object causes a menu to
  appear with the current choice highlighted.

  Some native platforms do not support arbitrary resizing of
  Choice components and the behavior of
  setSize()/getSize() is bound by
  such limitations.
  Native GUI Choice components' size are often bound by such
  attributes as font size and length of items contained within
  the Choice."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Choice]))

(defn ->choice
  "Constructor.

  Creates a new choice menu. The menu initially has no items in it.

   By default, the first item added to the choice menu becomes the
   selected item, until a different selection is made by the user
   by calling one of the select methods.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([]
    (new Choice )))

(defn add-item-listener
  "Adds the specified item listener to receive item events from
   this Choice menu.  Item events are sent in response
   to user input, but not in response to calls to select.
   If l is null, no exception is thrown and no action
   is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.Choice this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn add-item
  "Obsolete as of Java 2 platform v1.1.  Please use the
   add method instead.

   Adds an item to this Choice menu.

  item - the item to be added - `java.lang.String`

  throws: java.lang.NullPointerException - if the item's value is equal to null"
  ([^java.awt.Choice this ^java.lang.String item]
    (-> this (.addItem item))))

(defn get-item
  "Gets the string at the specified index in this
   Choice menu.

  index - the index at which to begin - `int`

  returns: `java.lang.String`"
  (^java.lang.String [^java.awt.Choice this ^Integer index]
    (-> this (.getItem index))))

(defn get-item-count
  "Returns the number of items in this Choice menu.

  returns: the number of items in this Choice menu - `int`"
  (^Integer [^java.awt.Choice this]
    (-> this (.getItemCount))))

(defn remove-item-listener
  "Removes the specified item listener so that it no longer receives
   item events from this Choice menu.
   If l is null, no exception is thrown and no
   action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.Choice this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn get-selected-index
  "Returns the index of the currently selected item.
   If nothing is selected, returns -1.

  returns: the index of the currently selected item, or -1 if nothing
    is currently selected - `int`"
  (^Integer [^java.awt.Choice this]
    (-> this (.getSelectedIndex))))

(defn add-notify
  "Creates the Choice's peer.  This peer allows us
   to change the look
   of the Choice without changing its functionality."
  ([^java.awt.Choice this]
    (-> this (.addNotify))))

(defn select
  "Sets the selected item in this Choice menu to be the
   item at the specified position.

   Note that this method should be primarily used to
   initially select an item in this component.
   Programmatically calling this method will not trigger
   an ItemEvent.  The only way to trigger an
   ItemEvent is by user interaction.

  pos - the position of the selected item - `int`

  throws: java.lang.IllegalArgumentException - if the specified position is greater than the number of items or less than zero"
  ([^java.awt.Choice this ^Integer pos]
    (-> this (.select pos))))

(defn remove
  "Removes the first occurrence of item
   from the Choice menu.  If the item
   being removed is the currently selected item,
   then the first item in the choice becomes the
   selected item.  Otherwise, the currently selected
   item remains selected (and the selected index is
   updated accordingly).

  item - the item to remove from this Choice menu - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the item doesn't exist in the choice menu"
  ([^java.awt.Choice this ^java.lang.String item]
    (-> this (.remove item))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   Choice. For Choice components,
   the AccessibleContext takes the form of an
   AccessibleAWTChoice. A new AccessibleAWTChoice
   instance is created if necessary.

  returns: an AccessibleAWTChoice that serves as the
           AccessibleContext of this Choice - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^java.awt.Choice this]
    (-> this (.getAccessibleContext))))

(defn get-selected-item
  "Gets a representation of the current choice as a string.

  returns: a string representation of the currently
                       selected item in this choice menu - `java.lang.String`"
  (^java.lang.String [^java.awt.Choice this]
    (-> this (.getSelectedItem))))

(defn insert
  "Inserts the item into this choice at the specified position.
   Existing items at an index greater than or equal to
   index are shifted up by one to accommodate
   the new item.  If index is greater than or
   equal to the number of items in this choice,
   item is added to the end of this choice.

   If the item is the first one being added to the choice,
   then the item becomes selected.  Otherwise, if the
   selected item was one of the items shifted, the first
   item in the choice becomes the selected item.  If the
   selected item was no among those shifted, it remains
   the selected item.

  item - the non-null item to be inserted - `java.lang.String`
  index - the position at which the item should be inserted - `int`

  throws: java.lang.IllegalArgumentException - if index is less than 0"
  ([^java.awt.Choice this ^java.lang.String item ^Integer index]
    (-> this (.insert item index))))

(defn get-selected-objects
  "Returns an array (length 1) containing the currently selected
   item.  If this choice has no items, returns null.

  returns: `java.lang.Object[]`"
  ([^java.awt.Choice this]
    (-> this (.getSelectedObjects))))

(defn add
  "Adds an item to this Choice menu.

  item - the item to be added - `java.lang.String`

  throws: java.lang.NullPointerException - if the item's value is null"
  ([^java.awt.Choice this ^java.lang.String item]
    (-> this (.add item))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Choice.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   Choice c
   for its item listeners with the following code:



  ItemListener[] ils = (ItemListener[])(c.getListeners(ItemListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this choice,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^java.awt.Choice this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn remove-all
  "Removes all items from the choice menu."
  ([^java.awt.Choice this]
    (-> this (.removeAll))))

(defn count-items
  "Deprecated. As of JDK version 1.1,
   replaced by getItemCount().

  returns: `java.lang.  int`"
  ([^java.awt.Choice this]
    (-> this (.countItems))))

(defn get-item-listeners
  "Returns an array of all the item listeners
   registered on this choice.

  returns: all of this choice's ItemListeners
           or an empty array if no item
           listeners are currently registered - `java.awt.event.ItemListener[]`"
  ([^java.awt.Choice this]
    (-> this (.getItemListeners))))

