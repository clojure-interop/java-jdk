(ns javax.swing.UIDefaults
  "A table of defaults for Swing components.  Applications can set/get
  default values via the UIManager.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIDefaults]))

(defn ->ui-defaults
  "Constructor.

  Creates an empty defaults table with the specified initial capacity and
   load factor.

  initial-capacity - the initial capacity of the defaults table - `int`
  load-factor - the load factor of the defaults table - `float`"
  ([initial-capacity load-factor]
    (new UIDefaults initial-capacity load-factor))
  ([key-value-list]
    (new UIDefaults key-value-list))
  ([]
    (new UIDefaults )))

(defn set-default-locale
  "Sets the default locale.  The default locale is used in retrieving
   localized values via get methods that do not take a
   locale argument.  As of release 1.4, Swing UI objects should retrieve
   localized values using the locale of their component rather than the
   default locale.  The default locale exists to provide compatibility with
   pre 1.4 behaviour.

  l - the new default locale - `java.util.Locale`"
  ([this l]
    (-> this (.setDefaultLocale l))))

(defn get-insets
  "If the value of key for the given Locale
   is an Insets return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is an Insets,
            return the Insets object; otherwise return
            null - `java.awt.Insets`"
  ([this key l]
    (-> this (.getInsets key l)))
  ([this key]
    (-> this (.getInsets key))))

(defn put
  "Sets the value of key to value for all locales.
   If key is a string and the new value isn't
   equal to the old one, fire a PropertyChangeEvent.
   If value is null, the key is removed from the table.

  key - the unique Object who's value will be used to retrieve the data value associated with it - `java.lang.Object`
  value - the new Object to store as data under that key - `java.lang.Object`

  returns: the previous Object value, or null - `java.lang.Object`"
  ([this key value]
    (-> this (.put key value))))

(defn get-default-locale
  "Returns the default locale.  The default locale is used in retrieving
   localized values via get methods that do not take a
   locale argument.  As of release 1.4, Swing UI objects should retrieve
   localized values using the locale of their component rather than the
   default locale.  The default locale exists to provide compatibility with
   pre 1.4 behaviour.

  returns: the default locale - `java.util.Locale`"
  ([this]
    (-> this (.getDefaultLocale))))

(defn get-string
  "If the value of key for the given Locale
   is a String return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired Locale - `java.util.Locale`

  returns: if the value for key for the given
            Locale is a String,
            return the String object; otherwise return
            null - `java.lang.String`"
  ([this key l]
    (-> this (.getString key l)))
  ([this key]
    (-> this (.getString key))))

(defn get-border
  "If the value of key for the given Locale
   is a Border return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is a Border,
            return the Border object; otherwise return
            null - `javax.swing.border.Border`"
  ([this key l]
    (-> this (.getBorder key l)))
  ([this key]
    (-> this (.getBorder key))))

(defn get-icon
  "If the value of key for the given Locale
   is an Icon return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is an Icon,
            return the Icon object; otherwise return
            null - `javax.swing.Icon`"
  ([this key l]
    (-> this (.getIcon key l)))
  ([this key]
    (-> this (.getIcon key))))

(defn put-defaults
  "Puts all of the key/value pairs in the database and
   unconditionally generates one PropertyChangeEvent.
   The events oldValue and newValue will be null and its
   propertyName will be `UIDefaults`.  The key/value pairs are
   added for all locales.

  key-value-list - an array of key/value pairs - `java.lang.Object[]`"
  ([this key-value-list]
    (-> this (.putDefaults key-value-list))))

(defn get-dimension
  "If the value of key for the given Locale
   is a Dimension return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is a Dimension,
            return the Dimension object; otherwise return
            null - `java.awt.Dimension`"
  ([this key l]
    (-> this (.getDimension key l)))
  ([this key]
    (-> this (.getDimension key))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-int
  "If the value of key for the given Locale
   is an Integer return its integer value, otherwise return 0.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is an Integer,
            return its value, otherwise return 0 - `int`"
  ([this key l]
    (-> this (.getInt key l)))
  ([this key]
    (-> this (.getInt key))))

(defn get-ui
  "Creates an ComponentUI implementation for the
   specified component.  In other words create the look
   and feel specific delegate object for target.
   This is done in two steps:

    Look up the name of the ComponentUI implementation
   class under the value returned by target.getUIClassID().
    Use the implementation classes static createUI()
   method to construct a look and feel delegate.

  target - the JComponent which needs a UI - `javax.swing.JComponent`

  returns: the ComponentUI object - `javax.swing.plaf.ComponentUI`"
  ([this target]
    (-> this (.getUI target))))

(defn get-property-change-listeners
  "Returns an array of all the PropertyChangeListeners added
   to this UIDefaults with addPropertyChangeListener().

  returns: all of the PropertyChangeListeners added or an empty
           array if no listeners have been added - `java.beans.PropertyChangeListener[]`"
  ([this]
    (-> this (.getPropertyChangeListeners))))

(defn get-font
  "If the value of key for the given Locale
   is a Font return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is a Font,
            return the Font object; otherwise return
            null - `java.awt.Font`"
  ([this key l]
    (-> this (.getFont key l)))
  ([this key]
    (-> this (.getFont key))))

(defn get-boolean?
  "If the value of key for the given Locale
   is boolean, return the boolean value, otherwise return false.

  key - an Object specifying the key for the desired boolean value - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
           is boolean, return the
           boolean value, otherwise return false. - `boolean`"
  ([this key l]
    (-> this (.getBoolean key l)))
  ([this key]
    (-> this (.getBoolean key))))

(defn get-ui-class
  "The value of get(uidClassID) must be the
   String name of a
   class that implements the corresponding ComponentUI
   class.  If the class hasn't been loaded before, this method looks
   up the class with uiClassLoader.loadClass() if a non
   null
   class loader is provided, classForName() otherwise.

   If a mapping for uiClassID exists or if the specified
   class can't be found, return null.

   This method is used by getUI, it's usually
   not necessary to call it directly.

  ui-class-id - a string containing the class ID - `java.lang.String`
  ui-class-loader - the object which will load the class - `java.lang.ClassLoader`

  returns: the value of Class.forName(get(uidClassID)) - `java.lang.Class<? extends javax.swing.plaf.ComponentUI>`"
  ([this ui-class-id ui-class-loader]
    (-> this (.getUIClass ui-class-id ui-class-loader)))
  ([this ui-class-id]
    (-> this (.getUIClass ui-class-id))))

(defn get-color
  "If the value of key for the given Locale
   is a Color return it, otherwise return null.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: if the value for key and Locale
            is a Color,
            return the Color object; otherwise return
            null - `java.awt.Color`"
  ([this key l]
    (-> this (.getColor key l)))
  ([this key]
    (-> this (.getColor key))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

   A PropertyChangeEvent will get fired whenever a default
   is changed.

  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn add-resource-bundle
  "Adds a resource bundle to the list of resource bundles that are
   searched for localized values.  Resource bundles are searched in the
   reverse order they were added.  In other words, the most recently added
   bundle is searched first.

  bundle-name - the base name of the resource bundle to be added - `java.lang.String`"
  ([this bundle-name]
    (-> this (.addResourceBundle bundle-name))))

(defn remove-resource-bundle
  "Removes a resource bundle from the list of resource bundles that are
   searched for localized defaults.

  bundle-name - the base name of the resource bundle to be removed - `java.lang.String`"
  ([this bundle-name]
    (-> this (.removeResourceBundle bundle-name))))

(defn get
  "Returns the value for key associated with the given locale.
   If the value is a UIDefaults.LazyValue then the real
   value is computed with LazyValue.createValue(),
   the table entry is replaced, and the real value is returned.
   If the value is an UIDefaults.ActiveValue
   the table entry is not replaced - the value is computed
   with ActiveValue.createValue() for each
   get() call.

   If the key is not found in the table then it is searched for in the list
   of resource bundles maintained by this object.  The resource bundles are
   searched most recently added first using the given locale.
   LazyValues and ActiveValues are not supported
   in the resource bundles.

  key - the desired key - `java.lang.Object`
  l - the desired locale - `java.util.Locale`

  returns: the value for key - `java.lang.Object`"
  ([this key l]
    (-> this (.get key l)))
  ([this key]
    (-> this (.get key))))

