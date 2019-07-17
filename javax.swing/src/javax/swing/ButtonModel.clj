(ns javax.swing.ButtonModel
  "State model for buttons.

  This model is used for regular buttons, as well as check boxes
  and radio buttons, which are special kinds of buttons. In practice,
  a button's UI takes the responsibility of calling methods on its
  model to manage the state, as detailed below:

  In simple terms, pressing and releasing the mouse over a regular
  button triggers the button and causes and ActionEvent
  to be fired. The same behavior can be produced via a keyboard key
  defined by the look and feel of the button (typically the SPACE BAR).
  Pressing and releasing this key while the button has
  focus will give the same results. For check boxes and radio buttons, the
  mouse or keyboard equivalent sequence just described causes the button
  to become selected.

  In details, the state model for buttons works as follows
  when used with the mouse:

  Pressing the mouse on top of a button makes the model both
  armed and pressed. As long as the mouse remains down,
  the model remains pressed, even if the mouse moves
  outside the button. On the contrary, the model is only
  armed while the mouse remains pressed within the bounds of
  the button (it can move in or out of the button, but the model
  is only armed during the portion of time spent within the button).
  A button is triggered, and an ActionEvent is fired,
  when the mouse is released while the model is armed
  - meaning when it is released over top of the button after the mouse
  has previously been pressed on that button (and not already released).
  Upon mouse release, the model becomes unarmed and unpressed.

  In details, the state model for buttons works as follows
  when used with the keyboard:

  Pressing the look and feel defined keyboard key while the button
  has focus makes the model both armed and pressed. As long as this key
  remains down, the model remains in this state. Releasing the key sets
  the model to unarmed and unpressed, triggers the button, and causes an
  ActionEvent to be fired."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ButtonModel]))

(defn add-item-listener
  "Adds an ItemListener to the model.

  l - the listener to add - `java.awt.event.ItemListener`"
  ([^. this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn get-mnemonic
  "Gets the keyboard mnemonic for the button.

  returns: an int specifying the accelerator key - `int`"
  ([^. this]
    (-> this (.getMnemonic))))

(defn add-change-listener
  "Adds a ChangeListener to the model.

  l - the listener to add - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-item-listener
  "Removes an ItemListener from the model.

  l - the listener to remove - `java.awt.event.ItemListener`"
  ([^. this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

(defn set-group
  "Identifies the group the button belongs to --
   needed for radio buttons, which are mutually
   exclusive within their group.

  group - the ButtonGroup the button belongs to - `javax.swing.ButtonGroup`"
  ([^. this ^javax.swing.ButtonGroup group]
    (-> this (.setGroup group))))

(defn set-selected
  "Selects or deselects the button.

  b - true selects the button, false deselects the button - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setSelected b))))

(defn armed?
  "Indicates partial commitment towards triggering the
   button.

  returns: true if the button is armed,
           and ready to be triggered - `boolean`"
  ([^. this]
    (-> this (.isArmed))))

(defn add-action-listener
  "Adds an ActionListener to the model.

  l - the listener to add - `java.awt.event.ActionListener`"
  ([^. this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn set-armed
  "Marks the button as armed or unarmed.

  b - whether or not the button should be armed - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setArmed b))))

(defn remove-change-listener
  "Removes a ChangeListener from the model.

  l - the listener to remove - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn set-pressed
  "Sets the button to pressed or unpressed.

  b - whether or not the button should be pressed - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setPressed b))))

(defn rollover?
  "Indicates that the mouse is over the button.

  returns: true if the mouse is over the button - `boolean`"
  ([^. this]
    (-> this (.isRollover))))

(defn set-enabled
  "Enables or disables the button.

  b - whether or not the button should be enabled - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setEnabled b))))

(defn pressed?
  "Indicates if the button is pressed.

  returns: true if the button is pressed - `boolean`"
  ([^. this]
    (-> this (.isPressed))))

(defn selected?
  "Indicates if the button has been selected. Only needed for
   certain types of buttons - such as radio buttons and check boxes.

  returns: true if the button is selected - `boolean`"
  ([^. this]
    (-> this (.isSelected))))

(defn remove-action-listener
  "Removes an ActionListener from the model.

  l - the listener to remove - `java.awt.event.ActionListener`"
  ([^. this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn get-action-command
  "Returns the action command string for the button.

  returns: the String that identifies the generated event - `java.lang.String`"
  ([^. this]
    (-> this (.getActionCommand))))

(defn set-rollover
  "Sets or clears the button's rollover state

  b - whether or not the button is in the rollover state - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setRollover b))))

(defn set-action-command
  "Sets the action command string that gets sent as part of the
   ActionEvent when the button is triggered.

  s - the String that identifies the generated event - `java.lang.String`"
  ([^. this ^java.lang.String s]
    (-> this (.setActionCommand s))))

(defn enabled?
  "Indicates if the button can be selected or triggered by
   an input device, such as a mouse pointer.

  returns: true if the button is enabled - `boolean`"
  ([^. this]
    (-> this (.isEnabled))))

(defn set-mnemonic
  "Sets the keyboard mnemonic (shortcut key or
   accelerator key) for the button.

  key - an int specifying the accelerator key - `int`"
  ([^. this ^Integer key]
    (-> this (.setMnemonic key))))

