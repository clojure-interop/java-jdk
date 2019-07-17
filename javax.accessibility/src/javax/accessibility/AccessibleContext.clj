(ns javax.accessibility.AccessibleContext
  "AccessibleContext represents the minimum information all accessible objects
  return.  This information includes the accessible name, description, role,
  and state of the object, as well as information about its parent and
  children.  AccessibleContext also contains methods for
  obtaining more specific accessibility information about a component.
  If the component supports them, these methods will return an object that
  implements one or more of the following interfaces:

  AccessibleAction - the object can perform one or more actions.
  This interface provides the standard mechanism for an assistive
  technology to determine what those actions are and tell the object
  to perform them.  Any object that can be manipulated should
  support this interface.
  AccessibleComponent - the object has a graphical representation.
  This interface provides the standard mechanism for an assistive
  technology to determine and set the graphical representation of the
  object.  Any object that is rendered on the screen should support
  this interface.
  AccessibleSelection - the object allows its children to be
  selected.  This interface provides the standard mechanism for an
  assistive technology to determine the currently selected children of the object
  as well as modify its selection set.  Any object that has children
  that can be selected should support this interface.
  AccessibleText - the object presents editable textual information
  on the display.  This interface provides the standard mechanism for
  an assistive technology to access that text via its content, attributes,
  and spatial location.  Any object that contains editable text should
  support this interface.
  AccessibleValue - the object supports a numerical value.  This
  interface provides the standard mechanism for an assistive technology
  to determine and set the current value of the object, as well as obtain its
  minimum and maximum values.  Any object that supports a numerical value
  should support this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleContext]))

(defn ->accessible-context
  "Constructor."
  ([]
    (new AccessibleContext )))

(def *-accessible-name-property
  "Static Constant.

  Constant used to determine when the accessibleName property has
   changed.  The old value in the PropertyChangeEvent will be the old
   accessibleName and the new value will be the new accessibleName.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_NAME_PROPERTY)

(def *-accessible-description-property
  "Static Constant.

  Constant used to determine when the accessibleDescription property has
   changed.  The old value in the PropertyChangeEvent will be the
   old accessibleDescription and the new value will be the new
   accessibleDescription.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_DESCRIPTION_PROPERTY)

(def *-accessible-state-property
  "Static Constant.

  Constant used to determine when the accessibleStateSet property has
   changed.  The old value will be the old AccessibleState and the new
   value will be the new AccessibleState in the accessibleStateSet.
   For example, if a component that supports the vertical and horizontal
   states changes its orientation from vertical to horizontal, the old
   value will be AccessibleState.VERTICAL and the new value will be
   AccessibleState.HORIZONTAL.  Please note that either value can also
   be null.  For example, when a component changes from being enabled
   to disabled, the old value will be AccessibleState.ENABLED
   and the new value will be null.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_STATE_PROPERTY)

(def *-accessible-value-property
  "Static Constant.

  Constant used to determine when the accessibleValue property has
   changed.  The old value in the PropertyChangeEvent will be a Number
   representing the old value and the new value will be a Number
   representing the new value

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_VALUE_PROPERTY)

(def *-accessible-selection-property
  "Static Constant.

  Constant used to determine when the accessibleSelection has changed.
   The old and new values in the PropertyChangeEvent are currently
   reserved for future use.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_SELECTION_PROPERTY)

(def *-accessible-caret-property
  "Static Constant.

  Constant used to determine when the accessibleText caret has changed.
   The old value in the PropertyChangeEvent will be an
   integer representing the old caret position, and the new value will
   be an integer representing the new/current caret position.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_CARET_PROPERTY)

(def *-accessible-visible-data-property
  "Static Constant.

  Constant used to determine when the visual appearance of the object
   has changed.  The old and new values in the PropertyChangeEvent are
   currently reserved for future use.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_VISIBLE_DATA_PROPERTY)

(def *-accessible-child-property
  "Static Constant.

  Constant used to determine when Accessible children are added/removed
   from the object.  If an Accessible child is being added, the old
   value will be null and the new value will be the Accessible child.  If an
   Accessible child is being removed, the old value will be the Accessible
   child, and the new value will be null.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_CHILD_PROPERTY)

(def *-accessible-active-descendant-property
  "Static Constant.

  Constant used to determine when the active descendant of a component
   has changed.  The active descendant is used for objects such as
   list, tree, and table, which may have transient children.  When the
   active descendant has changed, the old value of the property change
   event will be the Accessible representing the previous active child, and
   the new value will be the Accessible representing the current active
   child.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_ACTIVE_DESCENDANT_PROPERTY)

(def *-accessible-table-caption-changed
  "Static Constant.

  Constant used to indicate that the table caption has changed
   The old value in the PropertyChangeEvent will be an Accessible
   representing the previous table caption and the new value will
   be an Accessible representing the new table caption.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_CAPTION_CHANGED)

(def *-accessible-table-summary-changed
  "Static Constant.

  Constant used to indicate that the table summary has changed
   The old value in the PropertyChangeEvent will be an Accessible
   representing the previous table summary and the new value will
   be an Accessible representing the new table summary.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_SUMMARY_CHANGED)

(def *-accessible-table-model-changed
  "Static Constant.

  Constant used to indicate that table data has changed.
   The old value in the PropertyChangeEvent will be null and the
   new value will be an AccessibleTableModelChange representing
   the table change.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_MODEL_CHANGED)

(def *-accessible-table-row-header-changed
  "Static Constant.

  Constant used to indicate that the row header has changed
   The old value in the PropertyChangeEvent will be null and the
   new value will be an AccessibleTableModelChange representing
   the header change.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_ROW_HEADER_CHANGED)

(def *-accessible-table-row-description-changed
  "Static Constant.

  Constant used to indicate that the row description has changed
   The old value in the PropertyChangeEvent will be null and the
   new value will be an Integer representing the row index.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_ROW_DESCRIPTION_CHANGED)

(def *-accessible-table-column-header-changed
  "Static Constant.

  Constant used to indicate that the column header has changed
   The old value in the PropertyChangeEvent will be null and the
   new value will be an AccessibleTableModelChange representing
   the header change.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_COLUMN_HEADER_CHANGED)

(def *-accessible-table-column-description-changed
  "Static Constant.

  Constant used to indicate that the column description has changed
   The old value in the PropertyChangeEvent will be null and the
   new value will be an Integer representing the column index.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TABLE_COLUMN_DESCRIPTION_CHANGED)

(def *-accessible-action-property
  "Static Constant.

  Constant used to indicate that the supported set of actions
   has changed.  The old value in the PropertyChangeEvent will
   be an Integer representing the old number of actions supported
   and the new value will be an Integer representing the new
   number of actions supported.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_ACTION_PROPERTY)

(def *-accessible-hypertext-offset
  "Static Constant.

  Constant used to indicate that a hypertext element has received focus.
   The old value in the PropertyChangeEvent will be an Integer
   representing the start index in the document of the previous element
   that had focus and the new value will be an Integer representing
   the start index in the document of the current element that has
   focus.  A value of -1 indicates that an element does not or did
   not have focus.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_HYPERTEXT_OFFSET)

(def *-accessible-text-property
  "Static Constant.

  PropertyChangeEvent which indicates that text has changed.

   For text insertion, the oldValue is null and the newValue
   is an AccessibleTextSequence specifying the text that was
   inserted.

   For text deletion, the oldValue is an AccessibleTextSequence
   specifying the text that was deleted and the newValue is null.

   For text replacement, the oldValue is an AccessibleTextSequence
   specifying the old text and the newValue is an AccessibleTextSequence
   specifying the new text.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TEXT_PROPERTY)

(def *-accessible-invalidate-children
  "Static Constant.

  PropertyChangeEvent which indicates that a significant change
   has occurred to the children of a component like a tree or text.
   This change notifies the event listener that it needs to
   reacquire the state of the subcomponents. The oldValue is
   null and the newValue is the component whose children have
   become invalid.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_INVALIDATE_CHILDREN)

(def *-accessible-text-attributes-changed
  "Static Constant.

  PropertyChangeEvent which indicates that text attributes have changed.

   For attribute insertion, the oldValue is null and the newValue
   is an AccessibleAttributeSequence specifying the attributes that were
   inserted.

   For attribute deletion, the oldValue is an AccessibleAttributeSequence
   specifying the attributes that were deleted and the newValue is null.

   For attribute replacement, the oldValue is an AccessibleAttributeSequence
   specifying the old attributes and the newValue is an
   AccessibleAttributeSequence specifying the new attributes.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_TEXT_ATTRIBUTES_CHANGED)

(def *-accessible-component-bounds-changed
  "Static Constant.

  PropertyChangeEvent which indicates that a change has occurred
   in a component's bounds.
   The oldValue is the old component bounds and the newValue is
   the new component bounds.

  type: java.lang.String"
  AccessibleContext/ACCESSIBLE_COMPONENT_BOUNDS_CHANGED)

(defn set-accessible-parent
  "Sets the Accessible parent of this object.  This is meant to be used
   only in the situations where the actual component's parent should
   not be treated as the component's accessible parent and is a method
   that should only be called by the parent of the accessible child.

  a - - Accessible to be set as the parent - `javax.accessibility.Accessible`"
  ([^javax.accessibility.AccessibleContext this ^javax.accessibility.Accessible a]
    (-> this (.setAccessibleParent a))))

(defn get-accessible-table
  "Gets the AccessibleTable associated with an object

  returns: an AccessibleTable if supported by object;
   otherwise return null - `javax.accessibility.AccessibleTable`"
  (^javax.accessibility.AccessibleTable [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleTable))))

(defn get-accessible-child
  "Returns the specified Accessible child of the object.  The Accessible
   children of an Accessible object are zero-based, so the first child
   of an Accessible child is at index 0, the second child is at index 1,
   and so on.

  i - zero-based index of child - `int`

  returns: the Accessible child of the object - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^javax.accessibility.AccessibleContext this ^Integer i]
    (-> this (.getAccessibleChild i))))

(defn fire-property-change
  "Support for reporting bound property changes.  If oldValue and
   newValue are not equal and the PropertyChangeEvent listener list
   is not empty, then fire a PropertyChange event to each listener.
   In general, this is for use by the Accessible objects themselves
   and should not be called by an application program.

  property-name - The programmatic name of the property that was changed. - `java.lang.String`
  old-value - The old value of the property. - `java.lang.Object`
  new-value - The new value of the property. - `java.lang.Object`"
  ([^javax.accessibility.AccessibleContext this ^java.lang.String property-name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn get-accessible-value
  "Gets the AccessibleValue associated with this object that supports a
   Numerical value.

  returns: AccessibleValue if supported by object; else return null - `javax.accessibility.AccessibleValue`"
  (^javax.accessibility.AccessibleValue [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleValue))))

(defn get-accessible-state-set
  "Gets the state set of this object.  The AccessibleStateSet of an object
   is composed of a set of unique AccessibleStates.  A change in the
   AccessibleStateSet of an object will cause a PropertyChangeEvent to
   be fired for the ACCESSIBLE_STATE_PROPERTY property.

  returns: an instance of AccessibleStateSet containing the
   current state set of the object - `javax.accessibility.AccessibleStateSet`"
  (^javax.accessibility.AccessibleStateSet [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleStateSet))))

(defn get-accessible-role
  "Gets the role of this object.  The role of the object is the generic
   purpose or use of the class of this object.  For example, the role
   of a push button is AccessibleRole.PUSH_BUTTON.  The roles in
   AccessibleRole are provided so component developers can pick from
   a set of predefined roles.  This enables assistive technologies to
   provide a consistent interface to various tweaked subclasses of
   components (e.g., use AccessibleRole.PUSH_BUTTON for all components
   that act like a push button) as well as distinguish between subclasses
   that behave differently (e.g., AccessibleRole.CHECK_BOX for check boxes
   and AccessibleRole.RADIO_BUTTON for radio buttons).
   Note that the AccessibleRole class is also extensible, so
   custom component developers can define their own AccessibleRole's
   if the set of predefined roles is inadequate.

  returns: an instance of AccessibleRole describing the role of the object - `javax.accessibility.AccessibleRole`"
  (^javax.accessibility.AccessibleRole [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleRole))))

(defn get-accessible-relation-set
  "Gets the AccessibleRelationSet associated with an object

  returns: an AccessibleRelationSet if supported by object;
   otherwise return null - `javax.accessibility.AccessibleRelationSet`"
  (^javax.accessibility.AccessibleRelationSet [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleRelationSet))))

(defn get-locale
  "Gets the locale of the component. If the component does not have a
   locale, then the locale of its parent is returned.

  returns: this component's locale.  If this component does not have
   a locale, the locale of its parent is returned. - `java.util.Locale`

  throws: java.awt.IllegalComponentStateException - If the Component does not have its own locale and has not yet been added to a containment hierarchy such that the locale can be determined from the containing parent."
  (^java.util.Locale [^javax.accessibility.AccessibleContext this]
    (-> this (.getLocale))))

(defn get-accessible-name
  "Gets the accessibleName property of this object.  The accessibleName
   property of an object is a localized String that designates the purpose
   of the object.  For example, the accessibleName property of a label
   or button might be the text of the label or button itself.  In the
   case of an object that doesn't display its name, the accessibleName
   should still be set.  For example, in the case of a text field used
   to enter the name of a city, the accessibleName for the en_US locale
   could be 'city.'

  returns: the localized name of the object; null if this
   object does not have a name - `java.lang.String`"
  (^java.lang.String [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleName))))

(defn get-accessible-icon
  "Gets the AccessibleIcons associated with an object that has
   one or more associated icons

  returns: an array of AccessibleIcon if supported by object;
   otherwise return null - `javax.accessibility.AccessibleIcon[]`"
  ([^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleIcon))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - The PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^javax.accessibility.AccessibleContext this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-accessible-children-count
  "Returns the number of accessible children of the object.

  returns: the number of accessible children of the object. - `int`"
  (^Integer [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleChildrenCount))))

(defn get-accessible-parent
  "Gets the Accessible parent of this object.

  returns: the Accessible parent of this object; null if this
   object does not have an Accessible parent - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleParent))))

(defn get-accessible-selection
  "Gets the AccessibleSelection associated with this object which allows its
   Accessible children to be selected.

  returns: AccessibleSelection if supported by object; else return null - `javax.accessibility.AccessibleSelection`"
  (^javax.accessibility.AccessibleSelection [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleSelection))))

(defn get-accessible-component
  "Gets the AccessibleComponent associated with this object that has a
   graphical representation.

  returns: AccessibleComponent if supported by object; else return null - `javax.accessibility.AccessibleComponent`"
  (^javax.accessibility.AccessibleComponent [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleComponent))))

(defn get-accessible-editable-text
  "Gets the AccessibleEditableText associated with this object
   presenting editable text on the display.

  returns: AccessibleEditableText if supported by object; else return null - `javax.accessibility.AccessibleEditableText`"
  (^javax.accessibility.AccessibleEditableText [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleEditableText))))

(defn get-accessible-text
  "Gets the AccessibleText associated with this object presenting
   text on the display.

  returns: AccessibleText if supported by object; else return null - `javax.accessibility.AccessibleText`"
  (^javax.accessibility.AccessibleText [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleText))))

(defn get-accessible-action
  "Gets the AccessibleAction associated with this object that supports
   one or more actions.

  returns: AccessibleAction if supported by object; else return null - `javax.accessibility.AccessibleAction`"
  (^javax.accessibility.AccessibleAction [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleAction))))

(defn get-accessible-description
  "Gets the accessibleDescription property of this object.  The
   accessibleDescription property of this object is a short localized
   phrase describing the purpose of the object.  For example, in the
   case of a 'Cancel' button, the accessibleDescription could be
   'Ignore changes and close dialog box.'

  returns: the localized description of the object; null if
   this object does not have a description - `java.lang.String`"
  (^java.lang.String [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleDescription))))

(defn set-accessible-name
  "Sets the localized accessible name of this object.  Changing the
   name will cause a PropertyChangeEvent to be fired for the
   ACCESSIBLE_NAME_PROPERTY property.

  s - the new localized name of the object. - `java.lang.String`"
  ([^javax.accessibility.AccessibleContext this ^java.lang.String s]
    (-> this (.setAccessibleName s))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all Accessible properties and will
   be called when those properties change.

  listener - The PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^javax.accessibility.AccessibleContext this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn set-accessible-description
  "Sets the accessible description of this object.  Changing the
   name will cause a PropertyChangeEvent to be fired for the
   ACCESSIBLE_DESCRIPTION_PROPERTY property.

  s - the new localized description of the object - `java.lang.String`"
  ([^javax.accessibility.AccessibleContext this ^java.lang.String s]
    (-> this (.setAccessibleDescription s))))

(defn get-accessible-index-in-parent
  "Gets the 0-based index of this object in its accessible parent.

  returns: the 0-based index of this object in its parent; -1 if this
   object does not have an accessible parent. - `int`"
  (^Integer [^javax.accessibility.AccessibleContext this]
    (-> this (.getAccessibleIndexInParent))))

