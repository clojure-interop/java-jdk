(ns javax.swing.Action
  "The Action interface provides a useful extension to the
  ActionListener
  interface in cases where the same functionality may be accessed by
  several controls.

  In addition to the actionPerformed method defined by the
  ActionListener interface, this interface allows the
  application to define, in a single place:

  One or more text strings that describe the function. These strings
      can be used, for example, to display the flyover text for a button
      or to set the text in a menu item.
  One or more icons that depict the function. These icons can be used
      for the images in a menu control, or for composite entries in a more
      sophisticated user interface.
  The enabled/disabled state of the functionality. Instead of having
      to separately disable the menu item and the toolbar button, the
      application can disable the function that implements this interface.
      All components which are registered as listeners for the state change
      then know to disable event generation for that item and to modify the
      display accordingly.


  This interface can be added to an existing class or used to create an
  adapter (typically, by subclassing AbstractAction).
  The Action object
  can then be added to multiple Action-aware containers
  and connected to Action-capable
  components. The GUI controls can then be activated or
  deactivated all at once by invoking the Action object's
  setEnabled method.

  Note that Action implementations tend to be more expensive
  in terms of storage than a typical ActionListener,
  which does not offer the benefits of centralized control of
  functionality and broadcast of property changes.  For this reason,
  you should take care to only use Actions where their benefits
  are desired, and use simple ActionListeners elsewhere.


  Swing Components Supporting Action

  Many of Swing's components have an Action property.  When
  an Action is set on a component, the following things
  happen:

  The Action is added as an ActionListener to
      the component.
  The component configures some of its properties to match the
       Action.
  The component installs a PropertyChangeListener on the
      Action so that the component can change its properties
      to reflect changes in the Action's properties.


  The following table describes the properties used by
  Swing components that support Actions.
  In the table, button refers to any
  AbstractButton subclass, which includes not only
  JButton but also classes such as
  JMenuItem. Unless otherwise stated, a
  null property value in an Action (or a
  Action that is null) results in the
  button's corresponding property being set to null.



     Component Property
     Components
     Action Key
     Notes

       enabled
       All
       The isEnabled method


       toolTipText
       All
       SHORT_DESCRIPTION


       actionCommand
       All
       ACTION_COMMAND_KEY


       mnemonic
       All buttons
       MNEMONIC_KEY
       A null value or Action results in the
           button's mnemonic property being set to
           '\0'.

       text
       All buttons
       NAME
       If you do not want the text of the button to mirror that
           of the Action, set the property
           hideActionText to true.  If
           hideActionText is true, setting the
           Action changes the text of the button to
           null and any changes to NAME
           are ignored.  hideActionText is useful for
           tool bar buttons that typically only show an Icon.
           JToolBar.add(Action) sets the property to
           true if the Action has a
           non-null value for LARGE_ICON_KEY or
           SMALL_ICON.

       displayedMnemonicIndex
       All buttons
       DISPLAYED_MNEMONIC_INDEX_KEY
       If the value of DISPLAYED_MNEMONIC_INDEX_KEY is
           beyond the bounds of the text, it is ignored.  When
           setAction is called, if the value from the
           Action is null, the displayed
           mnemonic index is not updated.  In any subsequent changes to
           DISPLAYED_MNEMONIC_INDEX_KEY, null
           is treated as -1.

       icon
       All buttons except of JCheckBox,
       JToggleButton and JRadioButton.
       either LARGE_ICON_KEY or
           SMALL_ICON
      The JMenuItem subclasses only use
          SMALL_ICON.  All other buttons will use
          LARGE_ICON_KEY; if the value is null they
          use SMALL_ICON.

       accelerator
       All JMenuItem subclasses, with the exception of
           JMenu.
       ACCELERATOR_KEY


       selected
       JToggleButton, JCheckBox,
           JRadioButton, JCheckBoxMenuItem and
           JRadioButtonMenuItem
       SELECTED_KEY
       Components that honor this property only use
           the value if it is non-null. For example, if
           you set an Action that has a null
           value for SELECTED_KEY on a JToggleButton, the
           JToggleButton will not update it's selected state in
           any way. Similarly, any time the JToggleButton's
           selected state changes it will only set the value back on
           the Action if the Action has a non-null
           value for SELECTED_KEY.

           Components that honor this property keep their selected state
           in sync with this property. When the same Action is used
           with multiple components, all the components keep their selected
           state in sync with this property. Mutually exclusive
           buttons, such as JToggleButtons in a ButtonGroup,
           force only one of the buttons to be selected. As such, do not
           use the same Action that defines a value for the
           SELECTED_KEY property with multiple mutually
           exclusive buttons.


  JPopupMenu, JToolBar and JMenu
  all provide convenience methods for creating a component and setting the
  Action on the corresponding component.  Refer to each of
  these classes for more information.

  Action uses PropertyChangeListener to
  inform listeners the Action has changed.  The beans
  specification indicates that a null property name can
  be used to indicate multiple values have changed.  By default Swing
  components that take an Action do not handle such a
  change.  To indicate that Swing should treat null
  according to the beans specification set the system property
  swing.actions.reconfigureOnNull to the String
  value true."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Action]))

(defn get-value
  "Gets one of this object's properties
   using the associated key.

  key - `java.lang.String`

  returns: `java.lang.Object`"
  ([^. this ^java.lang.String key]
    (-> this (.getValue key))))

(defn put-value
  "Sets one of this object's properties
   using the associated key. If the value has
   changed, a PropertyChangeEvent is sent
   to listeners.

  key - a String containing the key - `java.lang.String`
  value - an Object value - `java.lang.Object`"
  ([^. this ^java.lang.String key ^java.lang.Object value]
    (-> this (.putValue key value))))

(defn set-enabled
  "Sets the enabled state of the Action.  When enabled,
   any component associated with this object is active and
   able to fire this object's actionPerformed method.
   If the value has changed, a PropertyChangeEvent is sent
   to listeners.

  b - true to enable this Action, false to disable it - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setEnabled b))))

(defn enabled?
  "Returns the enabled state of the Action. When enabled,
   any component associated with this object is active and
   able to fire this object's actionPerformed method.

  returns: true if this Action is enabled - `boolean`"
  ([^. this]
    (-> this (.isEnabled))))

(defn add-property-change-listener
  "Adds a PropertyChange listener. Containers and attached
   components use these methods to register interest in this
   Action object. When its enabled state or other property
   changes, the registered listeners are informed of the change.

  listener - a PropertyChangeListener object - `java.beans.PropertyChangeListener`"
  ([^. this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-property-change-listener
  "Removes a PropertyChange listener.

  listener - a PropertyChangeListener object - `java.beans.PropertyChangeListener`"
  ([^. this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

