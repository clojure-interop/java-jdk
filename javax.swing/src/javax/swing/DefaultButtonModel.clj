(ns javax.swing.DefaultButtonModel
  "The default implementation of a Button component's data model.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing. As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultButtonModel]))

(defn ->default-button-model
  "Constructor.

  Constructs a DefaultButtonModel."
  (^DefaultButtonModel []
    (new DefaultButtonModel )))

(def *-armed
  "Static Constant.

  Identifies the \"armed\" bit in the bitmask, which
   indicates partial commitment towards choosing/triggering
   the button.

  type: int"
  DefaultButtonModel/ARMED)

(def *-selected
  "Static Constant.

  Identifies the \"selected\" bit in the bitmask, which
   indicates that the button has been selected. Only needed for
   certain types of buttons - such as radio button or check box.

  type: int"
  DefaultButtonModel/SELECTED)

(def *-pressed
  "Static Constant.

  Identifies the \"pressed\" bit in the bitmask, which
   indicates that the button is pressed.

  type: int"
  DefaultButtonModel/PRESSED)

(def *-enabled
  "Static Constant.

  Identifies the \"enabled\" bit in the bitmask, which
   indicates that the button can be selected by
   an input device (such as a mouse pointer).

  type: int"
  DefaultButtonModel/ENABLED)

(def *-rollover
  "Static Constant.

  Identifies the \"rollover\" bit in the bitmask, which
   indicates that the mouse is over the button.

  type: int"
  DefaultButtonModel/ROLLOVER)

(defn add-item-listener
  "Adds an ItemListener to the model.

  l - the listener to add - `java.awt.event.ItemListener`"
  ([^DefaultButtonModel this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn get-mnemonic
  "Gets the keyboard mnemonic for the button.

  returns: an int specifying the accelerator key - `int`"
  (^Integer [^DefaultButtonModel this]
    (-> this (.getMnemonic))))

(defn add-change-listener
  "Adds a ChangeListener to the model.

  l - the listener to add - `javax.swing.event.ChangeListener`"
  ([^DefaultButtonModel this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-item-listener
  "Removes an ItemListener from the model.

  l - the listener to remove - `java.awt.event.ItemListener`"
  ([^DefaultButtonModel this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn set-group
  "Identifies the group the button belongs to --
   needed for radio buttons, which are mutually
   exclusive within their group.

  group - the ButtonGroup the button belongs to - `javax.swing.ButtonGroup`"
  ([^DefaultButtonModel this ^javax.swing.ButtonGroup group]
    (-> this (.setGroup group))))

(defn set-selected
  "Selects or deselects the button.

  b - true selects the button, false deselects the button - `boolean`"
  ([^DefaultButtonModel this ^Boolean b]
    (-> this (.setSelected b))))

(defn armed?
  "Indicates partial commitment towards triggering the
   button.

  returns: true if the button is armed,
           and ready to be triggered - `boolean`"
  (^Boolean [^DefaultButtonModel this]
    (-> this (.isArmed))))

(defn add-action-listener
  "Adds an ActionListener to the model.

  l - the listener to add - `java.awt.event.ActionListener`"
  ([^DefaultButtonModel this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn set-armed
  "Marks the button as armed or unarmed.

  b - whether or not the button should be armed - `boolean`"
  ([^DefaultButtonModel this ^Boolean b]
    (-> this (.setArmed b))))

(defn remove-change-listener
  "Removes a ChangeListener from the model.

  l - the listener to remove - `javax.swing.event.ChangeListener`"
  ([^DefaultButtonModel this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the change listeners
   registered on this DefaultButtonModel.

  returns: all of this model's ChangeListeners
           or an empty
           array if no change listeners are currently registered - `javax.swing.event.ChangeListener[]`"
  ([^DefaultButtonModel this]
    (-> this (.getChangeListeners))))

(defn set-pressed
  "Sets the button to pressed or unpressed.

  b - whether or not the button should be pressed - `boolean`"
  ([^DefaultButtonModel this ^Boolean b]
    (-> this (.setPressed b))))

(defn get-action-listeners
  "Returns an array of all the action listeners
   registered on this DefaultButtonModel.

  returns: all of this model's ActionListeners
           or an empty
           array if no action listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^DefaultButtonModel this]
    (-> this (.getActionListeners))))

(defn rollover?
  "Indicates that the mouse is over the button.

  returns: true if the mouse is over the button - `boolean`"
  (^Boolean [^DefaultButtonModel this]
    (-> this (.isRollover))))

(defn set-enabled
  "Enables or disables the button.

  b - whether or not the button should be enabled - `boolean`"
  ([^DefaultButtonModel this ^Boolean b]
    (-> this (.setEnabled b))))

(defn pressed?
  "Indicates if the button is pressed.

  returns: true if the button is pressed - `boolean`"
  (^Boolean [^DefaultButtonModel this]
    (-> this (.isPressed))))

(defn selected?
  "Indicates if the button has been selected. Only needed for
   certain types of buttons - such as radio buttons and check boxes.

  returns: true if the button is selected - `boolean`"
  (^Boolean [^DefaultButtonModel this]
    (-> this (.isSelected))))

(defn get-selected-objects
  "Overridden to return null.

  returns: `java.lang.Object[]`"
  ([^DefaultButtonModel this]
    (-> this (.getSelectedObjects))))

(defn remove-action-listener
  "Removes an ActionListener from the model.

  l - the listener to remove - `java.awt.event.ActionListener`"
  ([^DefaultButtonModel this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this model.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a DefaultButtonModel
   instance m
   for its action listeners
   with the following code:



  ActionListener[] als = (ActionListener[])(m.getListeners(ActionListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners
            on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^DefaultButtonModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-action-command
  "Returns the action command string for the button.

  returns: the String that identifies the generated event - `java.lang.String`"
  (^java.lang.String [^DefaultButtonModel this]
    (-> this (.getActionCommand))))

(defn set-rollover
  "Sets or clears the button's rollover state

  b - whether or not the button is in the rollover state - `boolean`"
  ([^DefaultButtonModel this ^Boolean b]
    (-> this (.setRollover b))))

(defn set-action-command
  "Sets the action command string that gets sent as part of the
   ActionEvent when the button is triggered.

  action-command - the String that identifies the generated event - `java.lang.String`"
  ([^DefaultButtonModel this ^java.lang.String action-command]
    (-> this (.setActionCommand action-command))))

(defn enabled?
  "Indicates if the button can be selected or triggered by
   an input device, such as a mouse pointer.

  returns: true if the button is enabled - `boolean`"
  (^Boolean [^DefaultButtonModel this]
    (-> this (.isEnabled))))

(defn set-mnemonic
  "Sets the keyboard mnemonic (shortcut key or
   accelerator key) for the button.

  key - an int specifying the accelerator key - `int`"
  ([^DefaultButtonModel this ^Integer key]
    (-> this (.setMnemonic key))))

(defn get-item-listeners
  "Returns an array of all the item listeners
   registered on this DefaultButtonModel.

  returns: all of this model's ItemListeners
           or an empty
           array if no item listeners are currently registered - `java.awt.event.ItemListener[]`"
  ([^DefaultButtonModel this]
    (-> this (.getItemListeners))))

(defn get-group
  "Returns the group that the button belongs to.
   Normally used with radio buttons, which are mutually
   exclusive within their group.

  returns: the ButtonGroup that the button belongs to - `javax.swing.ButtonGroup`"
  (^javax.swing.ButtonGroup [^DefaultButtonModel this]
    (-> this (.getGroup))))

