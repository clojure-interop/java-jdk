(ns javax.swing.AbstractAction
  "This class provides default implementations for the JFC Action
  interface. Standard behaviors like the get and set methods for
  Action object properties (icon, text, and enabled) are defined
  here. The developer need only subclass this abstract class and
  define the actionPerformed method.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing AbstractAction]))

(defn ->abstract-action
  "Constructor.

  Creates an Action with the specified name and small icon.

  name - the name (Action.NAME) for the action; a value of null is ignored - `java.lang.String`
  icon - the small icon (Action.SMALL_ICON) for the action; a value of null is ignored - `javax.swing.Icon`"
  ([name icon]
    (new AbstractAction name icon))
  ([name]
    (new AbstractAction name))
  ([]
    (new AbstractAction )))

(defn get-value
  "Gets the Object associated with the specified key.

  key - a string containing the specified key - `java.lang.String`

  returns: the binding Object stored with this key; if there
            are no keys, it will return null - `java.lang.Object`"
  ([this key]
    (-> this (.getValue key))))

(defn put-value
  "Sets the Value associated with the specified key.

  key - the String that identifies the stored object - `java.lang.String`
  new-value - the Object to store using this key - `java.lang.Object`"
  ([this key new-value]
    (-> this (.putValue key new-value))))

(defn enabled?
  "Returns true if the action is enabled.

  returns: true if the action is enabled, false otherwise - `boolean`"
  ([this]
    (-> this (.isEnabled))))

(defn set-enabled
  "Sets whether the Action is enabled. The default is true.

  new-value - true to enable the action, false to disable it - `boolean`"
  ([this new-value]
    (-> this (.setEnabled new-value))))

(defn get-keys
  "Returns an array of Objects which are keys for
   which values have been set for this AbstractAction,
   or null if no keys have values set.

  returns: an array of key objects, or null if no
                    keys have values set - `java.lang.Object[]`"
  ([this]
    (-> this (.getKeys))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

   A PropertyChangeEvent will get fired in response to setting
   a bound property, e.g. setFont, setBackground,
   or setForeground.
   Note that if the current component is inheriting its foreground,
   background, or font from its container, then no event will be
   fired in response to a change in the inherited property.

  listener - The PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-property-change-listeners
  "Returns an array of all the PropertyChangeListeners added
   to this AbstractAction with addPropertyChangeListener().

  returns: all of the PropertyChangeListeners added or an empty
           array if no listeners have been added - `java.beans.PropertyChangeListener[]`"
  ([this]
    (-> this (.getPropertyChangeListeners))))

