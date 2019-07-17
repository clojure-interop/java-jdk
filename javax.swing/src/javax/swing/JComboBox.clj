(ns javax.swing.JComboBox
  "A component that combines a button or editable field and a drop-down list.
  The user can select a value from the drop-down list, which appears at the
  user's request. If you make the combo box editable, then the combo box
  includes an editable field into which the user can type a value.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder.


  See How to Use Combo Boxes
  in The Java Tutorial
  for further information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JComboBox]))

(defn ->j-combo-box
  "Constructor.

  Creates a JComboBox that takes its items from an
   existing ComboBoxModel.  Since the
   ComboBoxModel is provided, a combo box created using
   this constructor does not create a default combo box model and
   may impact how the insert, remove and add methods behave.

  a-model - the ComboBoxModel that provides the displayed list of items - `javax.swing.ComboBoxModel<JComboBox.E>`"
  ([^javax.swing.ComboBoxModel a-model]
    (new JComboBox a-model))
  ([]
    (new JComboBox )))

(defn add-item-listener
  "Adds an ItemListener.

   aListener will receive one or two ItemEvents when
   the selected item changes.

  a-listener - the ItemListener that is to be notified - `java.awt.event.ItemListener`"
  ([^javax.swing.JComboBox this ^java.awt.event.ItemListener a-listener]
    (-> this (.addItemListener a-listener))))

(defn set-selected-item
  "Sets the selected item in the combo box display area to the object in
   the argument.
   If anObject is in the list, the display area shows
   anObject selected.

   If anObject is not in the list and the combo box is
   uneditable, it will not change the current selection. For editable
   combo boxes, the selection will change to anObject.

   If this constitutes a change in the selected item,
   ItemListeners added to the combo box will be notified with
   one or two ItemEvents.
   If there is a current selected item, an ItemEvent will be
   fired and the state change will be ItemEvent.DESELECTED.
   If anObject is in the list and is not currently selected
   then an ItemEvent will be fired and the state change will
   be ItemEvent.SELECTED.

   ActionListeners added to the combo box will be notified
   with an ActionEvent when this method is called.

  an-object - the list object to select; use null to clear the selection - `java.lang.Object`"
  ([^javax.swing.JComboBox this ^java.lang.Object an-object]
    (-> this (.setSelectedItem an-object))))

(defn light-weight-popup-enabled?
  "Gets the value of the lightWeightPopupEnabled
   property.

  returns: the value of the lightWeightPopupEnabled
      property - `boolean`"
  ([^javax.swing.JComboBox this]
    (-> this (.isLightWeightPopupEnabled))))

(defn show-popup
  "Causes the combo box to display its popup window."
  ([^javax.swing.JComboBox this]
    (-> this (.showPopup))))

(defn add-item
  "Adds an item to the item list.
   This method works only if the JComboBox uses a
   mutable data model.

   Warning:
   Focus and keyboard navigation problems may arise if you add duplicate
   String objects. A workaround is to add new objects instead of String
   objects and make sure that the toString() method is defined.
   For example:


     comboBox.addItem(makeObj(`Item 1`));
     comboBox.addItem(makeObj(`Item 1`));
     ...
     private Object makeObj(final String item)  {
       return new Object() { public String toString() { return item; } };
     }

  item - the item to add to the list - `JComboBox.E`"
  ([^javax.swing.JComboBox this ^JComboBox.E item]
    (-> this (.addItem item))))

(defn get-editor
  "Returns the editor used to paint and edit the selected item in the
   JComboBox field.

  returns: the ComboBoxEditor that displays the selected item - `javax.swing.ComboBoxEditor`"
  ([^javax.swing.JComboBox this]
    (-> this (.getEditor))))

(defn remove-item
  "Removes an item from the item list.
   This method works only if the JComboBox uses a
   mutable data model.

  an-object - the object to remove from the item list - `java.lang.Object`"
  ([^javax.swing.JComboBox this ^java.lang.Object an-object]
    (-> this (.removeItem an-object))))

(defn configure-editor
  "Initializes the editor with the specified item.

  an-editor - the ComboBoxEditor that displays the list item in the combo box field and allows it to be edited - `javax.swing.ComboBoxEditor`
  an-item - the object to display and edit in the field - `java.lang.Object`"
  ([^javax.swing.JComboBox this ^javax.swing.ComboBoxEditor an-editor ^java.lang.Object an-item]
    (-> this (.configureEditor an-editor an-item))))

(defn get-item-count
  "Returns the number of items in the list.

  returns: an integer equal to the number of items in the list - `int`"
  ([^javax.swing.JComboBox this]
    (-> this (.getItemCount))))

(defn fire-popup-menu-will-become-invisible
  "Notifies PopupMenuListeners that the popup portion of the
   combo box has become invisible.

   This method is public but should not be called by anything other than
   the UI delegate."
  ([^javax.swing.JComboBox this]
    (-> this (.firePopupMenuWillBecomeInvisible))))

(defn remove-item-listener
  "Removes an ItemListener.

  a-listener - the ItemListener to remove - `java.awt.event.ItemListener`"
  ([^javax.swing.JComboBox this ^java.awt.event.ItemListener a-listener]
    (-> this (.removeItemListener a-listener))))

(defn get-item-at
  "Returns the list item at the specified index.  If index
   is out of range (less than zero or greater than or equal to size)
   it will return null.

  index - an integer indicating the list position, where the first item starts at zero - `int`

  returns: the item at that list position; or
                    null if out of range - `JComboBox.E`"
  ([^javax.swing.JComboBox this ^Integer index]
    (-> this (.getItemAt index))))

(defn remove-item-at
  "Removes the item at anIndex
   This method works only if the JComboBox uses a
   mutable data model.

  an-index - an int specifying the index of the item to remove, where 0 indicates the first item in the list - `int`"
  ([^javax.swing.JComboBox this ^Integer an-index]
    (-> this (.removeItemAt an-index))))

(defn add-popup-menu-listener
  "Adds a PopupMenu listener which will listen to notification
   messages from the popup portion of the combo box.

   For all standard look and feels shipped with Java, the popup list
   portion of combo box is implemented as a JPopupMenu.
   A custom look and feel may not implement it this way and will
   therefore not receive the notification.

  l - the PopupMenuListener to add - `javax.swing.event.PopupMenuListener`"
  ([^javax.swing.JComboBox this ^javax.swing.event.PopupMenuListener l]
    (-> this (.addPopupMenuListener l))))

(defn get-action
  "Returns the currently set Action for this
   ActionEvent source, or null if no
   Action is set.

  returns: the Action for this ActionEvent
            source; or null - `javax.swing.Action`"
  ([^javax.swing.JComboBox this]
    (-> this (.getAction))))

(defn add-action-listener
  "Adds an ActionListener.

   The ActionListener will receive an ActionEvent
   when a selection has been made. If the combo box is editable, then
   an ActionEvent will be fired when editing has stopped.

  l - the ActionListener that is to be notified - `java.awt.event.ActionListener`"
  ([^javax.swing.JComboBox this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn get-maximum-row-count
  "Returns the maximum number of items the combo box can display
   without a scrollbar

  returns: an integer specifying the maximum number of items that are
           displayed in the list before using a scrollbar - `int`"
  ([^javax.swing.JComboBox this]
    (-> this (.getMaximumRowCount))))

(defn remove-popup-menu-listener
  "Removes a PopupMenuListener.

  l - the PopupMenuListener to remove - `javax.swing.event.PopupMenuListener`"
  ([^javax.swing.JComboBox this ^javax.swing.event.PopupMenuListener l]
    (-> this (.removePopupMenuListener l))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `ComboBoxUI` - `java.lang.String`"
  ([^javax.swing.JComboBox this]
    (-> this (.getUIClassID))))

(defn hide-popup
  "Causes the combo box to close its popup window."
  ([^javax.swing.JComboBox this]
    (-> this (.hidePopup))))

(defn get-selected-index
  "Returns the first item in the list that matches the given item.
   The result is not always defined if the JComboBox
   allows selected items that are not in the list.
   Returns -1 if there is no selected item or if the user specified
   an item which is not in the list.

  returns: an integer specifying the currently selected list item,
                    where 0 specifies
                    the first item in the list;
                    or -1 if no item is selected or if
                    the currently selected item is not in the list - `int`"
  ([^javax.swing.JComboBox this]
    (-> this (.getSelectedIndex))))

(defn select-with-key-char
  "Selects the list item that corresponds to the specified keyboard
   character and returns true, if there is an item corresponding
   to that character.  Otherwise, returns false.

  key-char - a char, typically this is a keyboard key typed by the user - `char`

  returns: `boolean`"
  ([^javax.swing.JComboBox this ^Character key-char]
    (-> this (.selectWithKeyChar key-char))))

(defn set-maximum-row-count
  "Sets the maximum number of rows the JComboBox displays.
   If the number of objects in the model is greater than count,
   the combo box uses a scrollbar.

  count - an integer specifying the maximum number of items to display in the list before using a scrollbar - `int`"
  ([^javax.swing.JComboBox this ^Integer count]
    (-> this (.setMaximumRowCount count))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the ComboBoxUI L&F object - `javax.swing.plaf.ComboBoxUI`"
  ([^javax.swing.JComboBox this ^javax.swing.plaf.ComboBoxUI ui]
    (-> this (.setUI ui))))

(defn editable?
  "Returns true if the JComboBox is editable.
   By default, a combo box is not editable.

  returns: true if the JComboBox is editable, else false - `boolean`"
  ([^javax.swing.JComboBox this]
    (-> this (.isEditable))))

(defn set-prototype-display-value
  "Sets the prototype display value used to calculate the size of the display
   for the UI portion.

   If a prototype display value is specified, the preferred size of
   the combo box is calculated by configuring the renderer with the
   prototype display value and obtaining its preferred size. Specifying
   the preferred display value is often useful when the combo box will be
   displaying large amounts of data. If no prototype display value has
   been specified, the renderer must be configured for each value from
   the model and its preferred size obtained, which can be
   relatively expensive.

  prototype-display-value - `JComboBox.E`"
  ([^javax.swing.JComboBox this ^JComboBox.E prototype-display-value]
    (-> this (.setPrototypeDisplayValue prototype-display-value))))

(defn remove-all-items
  "Removes all items from the item list."
  ([^javax.swing.JComboBox this]
    (-> this (.removeAllItems))))

(defn set-renderer
  "Sets the renderer that paints the list items and the item selected from the list in
   the JComboBox field. The renderer is used if the JComboBox is not
   editable. If it is editable, the editor is used to render and edit
   the selected item.

   The default renderer displays a string or an icon.
   Other renderers can handle graphic images and composite items.

   To display the selected item,
   aRenderer.getListCellRendererComponent
   is called, passing the list object and an index of -1.

  a-renderer - the ListCellRenderer that displays the selected item - `JComboBox.E>`"
  ([^javax.swing.JComboBox this ^JComboBox.E> a-renderer]
    (-> this (.setRenderer a-renderer))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the ComboBoxUI object that renders this component - `javax.swing.plaf.ComboBoxUI`"
  ([^javax.swing.JComboBox this]
    (-> this (.getUI))))

(defn get-action-listeners
  "Returns an array of all the ActionListeners added
   to this JComboBox with addActionListener().

  returns: all of the ActionListeners added or an empty
           array if no listeners have been added - `java.awt.event.ActionListener[]`"
  ([^javax.swing.JComboBox this]
    (-> this (.getActionListeners))))

(defn get-renderer
  "Returns the renderer used to display the selected item in the
   JComboBox field.

  returns: the ListCellRenderer that displays
                    the selected item. - `javax.swing.ListCellRenderer<? super JComboBox.E>`"
  ([^javax.swing.JComboBox this]
    (-> this (.getRenderer))))

(defn fire-popup-menu-canceled
  "Notifies PopupMenuListeners that the popup portion of the
   combo box has been canceled.

   This method is public but should not be called by anything other than
   the UI delegate."
  ([^javax.swing.JComboBox this]
    (-> this (.firePopupMenuCanceled))))

(defn contents-changed
  "This method is public as an implementation side effect.
   do not call or override.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.JComboBox this ^javax.swing.event.ListDataEvent e]
    (-> this (.contentsChanged e))))

(defn action-performed
  "This method is public as an implementation side effect.
   do not call or override.

  e - `java.awt.event.ActionEvent`"
  ([^javax.swing.JComboBox this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JComboBox.
   For combo boxes, the AccessibleContext takes the form of an
   AccessibleJComboBox.
   A new AccessibleJComboBox instance is created if necessary.

  returns: an AccessibleJComboBox that serves as the
           AccessibleContext of this JComboBox - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JComboBox this]
    (-> this (.getAccessibleContext))))

(defn get-key-selection-manager
  "Returns the list's key-selection manager.

  returns: the KeySelectionManager currently in use - `javax.swing.JComboBox.KeySelectionManager`"
  ([^javax.swing.JComboBox this]
    (-> this (.getKeySelectionManager))))

(defn get-selected-item
  "Returns the current selected item.

   If the combo box is editable, then this value may not have been added
   to the combo box with addItem, insertItemAt
   or the data constructors.

  returns: the current selected Object - `java.lang.Object`"
  ([^javax.swing.JComboBox this]
    (-> this (.getSelectedItem))))

(defn set-enabled
  "Enables the combo box so that items can be selected. When the
   combo box is disabled, items cannot be selected and values
   cannot be typed into its field (if it is editable).

  b - a boolean value, where true enables the component and false disables it - `boolean`"
  ([^javax.swing.JComboBox this ^Boolean b]
    (-> this (.setEnabled b))))

(defn interval-added
  "This method is public as an implementation side effect.
   do not call or override.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.JComboBox this ^javax.swing.event.ListDataEvent e]
    (-> this (.intervalAdded e))))

(defn set-popup-visible
  "Sets the visibility of the popup.

  v - `boolean`"
  ([^javax.swing.JComboBox this ^Boolean v]
    (-> this (.setPopupVisible v))))

(defn process-key-event
  "Handles KeyEvents, looking for the Tab key.
   If the Tab key is found, the popup window is closed.

  e - the KeyEvent containing the keyboard key that was pressed - `java.awt.event.KeyEvent`"
  ([^javax.swing.JComboBox this ^java.awt.event.KeyEvent e]
    (-> this (.processKeyEvent e))))

(defn set-editable
  "Determines whether the JComboBox field is editable.
   An editable JComboBox allows the user to type into the
   field or selected an item from the list to initialize the field,
   after which it can be edited. (The editing affects only the field,
   the list item remains intact.) A non editable JComboBox
   displays the selected item in the field,
   but the selection cannot be modified.

  a-flag - a boolean value, where true indicates that the field is editable - `boolean`"
  ([^javax.swing.JComboBox this ^Boolean a-flag]
    (-> this (.setEditable a-flag))))

(defn get-prototype-display-value
  "Returns the `prototypical display` value - an Object used
   for the calculation of the display height and width.

  returns: the value of the prototypeDisplayValue property - `JComboBox.E`"
  ([^javax.swing.JComboBox this]
    (-> this (.getPrototypeDisplayValue))))

(defn get-selected-objects
  "Returns an array containing the selected item.
   This method is implemented for compatibility with
   ItemSelectable.

  returns: an array of Objects containing one
            element -- the selected item - `java.lang.Object[]`"
  ([^javax.swing.JComboBox this]
    (-> this (.getSelectedObjects))))

(defn set-key-selection-manager
  "Sets the object that translates a keyboard character into a list
   selection. Typically, the first selection with a matching first
   character becomes the selected item.

  a-manager - `javax.swing.JComboBox.KeySelectionManager`"
  ([^javax.swing.JComboBox this ^javax.swing.JComboBox.KeySelectionManager a-manager]
    (-> this (.setKeySelectionManager a-manager))))

(defn set-selected-index
  "Selects the item at index anIndex.

  an-index - an integer specifying the list item to select, where 0 specifies the first item in the list and -1 indicates no selection - `int`

  throws: java.lang.IllegalArgumentException - if anIndex < -1 or anIndex is greater than or equal to size"
  ([^javax.swing.JComboBox this ^Integer an-index]
    (-> this (.setSelectedIndex an-index))))

(defn remove-action-listener
  "Removes an ActionListener.

  l - the ActionListener to remove - `java.awt.event.ActionListener`"
  ([^javax.swing.JComboBox this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn set-light-weight-popup-enabled
  "Sets the lightWeightPopupEnabled property, which
   provides a hint as to whether or not a lightweight
   Component should be used to contain the
   JComboBox, versus a heavyweight
   Component such as a Panel
   or a Window.  The decision of lightweight
   versus heavyweight is ultimately up to the
   JComboBox.  Lightweight windows are more
   efficient than heavyweight windows, but lightweight
   and heavyweight components do not mix well in a GUI.
   If your application mixes lightweight and heavyweight
   components, you should disable lightweight popups.
   The default value for the lightWeightPopupEnabled
   property is true, unless otherwise specified
   by the look and feel.  Some look and feels always use
   heavyweight popups, no matter what the value of this property.

   See the article Mixing Heavy and Light Components
   This method fires a property changed event.

  a-flag - if true, lightweight popups are desired - `boolean`"
  ([^javax.swing.JComboBox this ^Boolean a-flag]
    (-> this (.setLightWeightPopupEnabled a-flag))))

(defn interval-removed
  "This method is public as an implementation side effect.
   do not call or override.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.JComboBox this ^javax.swing.event.ListDataEvent e]
    (-> this (.intervalRemoved e))))

(defn get-action-command
  "Returns the action command that is included in the event sent to
   action listeners.

  returns: the string containing the `command` that is sent
            to action listeners. - `java.lang.String`"
  ([^javax.swing.JComboBox this]
    (-> this (.getActionCommand))))

(defn set-action
  "Sets the Action for the ActionEvent source.
   The new Action replaces any previously set
   Action but does not affect ActionListeners
   independently added with addActionListener.
   If the Action is already a registered
   ActionListener for the ActionEvent source,
   it is not re-registered.

   Setting the Action results in immediately changing
   all the properties described in
   Swing Components Supporting Action.
   Subsequently, the combobox's properties are automatically updated
   as the Action's properties change.

   This method uses three other methods to set
   and help track the Action's property values.
   It uses the configurePropertiesFromAction method
   to immediately change the combobox's properties.
   To track changes in the Action's property values,
   this method registers the PropertyChangeListener
   returned by createActionPropertyChangeListener. The
   default PropertyChangeListener invokes the
   actionPropertyChanged method when a property in the
   Action changes.

  a - the Action for the JComboBox, or null. - `javax.swing.Action`"
  ([^javax.swing.JComboBox this ^javax.swing.Action a]
    (-> this (.setAction a))))

(defn get-model
  "Returns the data model currently used by the JComboBox.

  returns: the ComboBoxModel that provides the displayed
                    list of items - `javax.swing.ComboBoxModel<JComboBox.E>`"
  ([^javax.swing.JComboBox this]
    (-> this (.getModel))))

(defn popup-visible?
  "Determines the visibility of the popup.

  returns: true if the popup is visible, otherwise returns false - `boolean`"
  ([^javax.swing.JComboBox this]
    (-> this (.isPopupVisible))))

(defn set-model
  "Sets the data model that the JComboBox uses to obtain
   the list of items.

  a-model - the ComboBoxModel that provides the displayed list of items - `javax.swing.ComboBoxModel<JComboBox.E>`"
  ([^javax.swing.JComboBox this ^javax.swing.ComboBoxModel a-model]
    (-> this (.setModel a-model))))

(defn insert-item-at
  "Inserts an item into the item list at a given index.
   This method works only if the JComboBox uses a
   mutable data model.

  item - the item to add to the list - `JComboBox.E`
  index - an integer specifying the position at which to add the item - `int`"
  ([^javax.swing.JComboBox this ^JComboBox.E item ^Integer index]
    (-> this (.insertItemAt item index))))

(defn set-action-command
  "Sets the action command that should be included in the event
   sent to action listeners.

  a-command - a string containing the `command` that is sent to action listeners; the same listener can then do different things depending on the command it receives - `java.lang.String`"
  ([^javax.swing.JComboBox this ^java.lang.String a-command]
    (-> this (.setActionCommand a-command))))

(defn fire-popup-menu-will-become-visible
  "Notifies PopupMenuListeners that the popup portion of the
   combo box will become visible.

   This method is public but should not be called by anything other than
   the UI delegate."
  ([^javax.swing.JComboBox this]
    (-> this (.firePopupMenuWillBecomeVisible))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JComboBox this]
    (-> this (.updateUI))))

(defn get-popup-menu-listeners
  "Returns an array of all the PopupMenuListeners added
   to this JComboBox with addPopupMenuListener().

  returns: all of the PopupMenuListeners added or an empty
           array if no listeners have been added - `javax.swing.event.PopupMenuListener[]`"
  ([^javax.swing.JComboBox this]
    (-> this (.getPopupMenuListeners))))

(defn set-editor
  "Sets the editor used to paint and edit the selected item in the
   JComboBox field.  The editor is used only if the
   receiving JComboBox is editable. If not editable,
   the combo box uses the renderer to paint the selected item.

  an-editor - the ComboBoxEditor that displays the selected item - `javax.swing.ComboBoxEditor`"
  ([^javax.swing.JComboBox this ^javax.swing.ComboBoxEditor an-editor]
    (-> this (.setEditor an-editor))))

(defn get-item-listeners
  "Returns an array of all the ItemListeners added
   to this JComboBox with addItemListener().

  returns: all of the ItemListeners added or an empty
           array if no listeners have been added - `java.awt.event.ItemListener[]`"
  ([^javax.swing.JComboBox this]
    (-> this (.getItemListeners))))

