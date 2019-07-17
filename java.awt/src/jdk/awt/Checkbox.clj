(ns jdk.awt.Checkbox
  "A check box is a graphical component that can be in either an
  `on` (true) or `off` (false) state.
  Clicking on a check box changes its state from
  `on` to `off,` or from `off` to `on.`

  The following code example creates a set of check boxes in
  a grid layout:



  setLayout(new GridLayout(3, 1));
  add(new Checkbox(`one`, null, true));
  add(new Checkbox(`two`));
  add(new Checkbox(`three`));

  This image depicts the check boxes and grid layout
  created by this code example:



  The button labeled one is in the `on` state, and the
  other two are in the `off` state. In this example, which uses the
  GridLayout class, the states of the three check
  boxes are set independently.

  Alternatively, several check boxes can be grouped together under
  the control of a single object, using the
  CheckboxGroup class.
  In a check box group, at most one button can be in the `on`
  state at any given time. Clicking on a check box to turn it on
  forces any other check box in the same group that is on
  into the `off` state."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Checkbox]))

(defn ->checkbox
  "Constructor.

  Constructs a Checkbox with the specified label, set to the
   specified state, and in the specified check box group.

  label - a string label for this check box, or null for no label. - `java.lang.String`
  state - the initial state of this check box. - `boolean`
  group - a check box group for this check box, or null for no group. - `java.awt.CheckboxGroup`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([^java.lang.String label ^Boolean state ^java.awt.CheckboxGroup group]
    (new Checkbox label state group))
  ([^java.lang.String label ^Boolean state]
    (new Checkbox label state))
  ([^java.lang.String label]
    (new Checkbox label))
  ([]
    (new Checkbox )))

(defn add-item-listener
  "Adds the specified item listener to receive item events from
   this check box.  Item events are sent to listeners in response
   to user input, but not in response to calls to setState().
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.Checkbox this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn remove-item-listener
  "Removes the specified item listener so that the item listener
   no longer receives item events from this check box.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the item listener - `java.awt.event.ItemListener`"
  ([^java.awt.Checkbox this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn set-state
  "Sets the state of this check box to the specified state.
   The boolean value true indicates the `on` state,
   and false indicates the `off` state.

   Note that this method should be primarily used to
   initialize the state of the checkbox.  Programmatically
   setting the state of the checkbox will not trigger
   an ItemEvent.  The only way to trigger an
   ItemEvent is by user interaction.

  state - the boolean state of the check box - `boolean`"
  ([^java.awt.Checkbox this ^Boolean state]
    (-> this (.setState state))))

(defn get-checkbox-group
  "Determines this check box's group.

  returns: this check box's group, or null
                 if the check box is not part of a check box group. - `java.awt.CheckboxGroup`"
  (^java.awt.CheckboxGroup [^java.awt.Checkbox this]
    (-> this (.getCheckboxGroup))))

(defn get-state?
  "Determines whether this check box is in the `on` or `off` state.
   The boolean value true indicates the `on` state,
   and false indicates the `off` state.

  returns: the state of this check box, as a boolean value - `boolean`"
  (^Boolean [^java.awt.Checkbox this]
    (-> this (.getState))))

(defn add-notify
  "Creates the peer of the Checkbox. The peer allows you to change the
   look of the Checkbox without changing its functionality."
  ([^java.awt.Checkbox this]
    (-> this (.addNotify))))

(defn get-label
  "Gets the label of this check box.

  returns: the label of this check box, or null
                    if this check box has no label. - `java.lang.String`"
  (^java.lang.String [^java.awt.Checkbox this]
    (-> this (.getLabel))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Checkbox.
   For checkboxes, the AccessibleContext takes the form of an
   AccessibleAWTCheckbox.
   A new AccessibleAWTCheckbox is created if necessary.

  returns: an AccessibleAWTCheckbox that serves as the
           AccessibleContext of this Checkbox - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^java.awt.Checkbox this]
    (-> this (.getAccessibleContext))))

(defn set-checkbox-group
  "Sets this check box's group to the specified check box group.
   If this check box is already in a different check box group,
   it is first taken out of that group.

   If the state of this check box is true and the new
   group already has a check box selected, this check box's state
   is changed to false.  If the state of this check
   box is true and the new group has no check box
   selected, this check box becomes the selected checkbox for
   the new group and its state is true.

  g - the new check box group, or null to remove this check box from any check box group - `java.awt.CheckboxGroup`"
  ([^java.awt.Checkbox this ^java.awt.CheckboxGroup g]
    (-> this (.setCheckboxGroup g))))

(defn get-selected-objects
  "Returns an array (length 1) containing the checkbox
   label or null if the checkbox is not selected.

  returns: `java.lang.Object[]`"
  ([^java.awt.Checkbox this]
    (-> this (.getSelectedObjects))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Checkbox.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   Checkbox c
   for its item listeners with the following code:



  ItemListener[] ils = (ItemListener[])(c.getListeners(ItemListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this checkbox,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^java.awt.Checkbox this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn set-label
  "Sets this check box's label to be the string argument.

  label - a string to set as the new label, or null for no label. - `java.lang.String`"
  ([^java.awt.Checkbox this ^java.lang.String label]
    (-> this (.setLabel label))))

(defn get-item-listeners
  "Returns an array of all the item listeners
   registered on this checkbox.

  returns: all of this checkbox's ItemListeners
           or an empty array if no item
           listeners are currently registered - `java.awt.event.ItemListener[]`"
  ([^java.awt.Checkbox this]
    (-> this (.getItemListeners))))

