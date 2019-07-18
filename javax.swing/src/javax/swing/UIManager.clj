(ns javax.swing.UIManager
  "UIManager manages the current look and feel, the set of
  available look and feels, PropertyChangeListeners that
  are notified when the look and feel changes, look and feel defaults, and
  convenience methods for obtaining various default values.

  Specifying the look and feel

  The look and feel can be specified in two distinct ways: by
  specifying the fully qualified name of the class for the look and
  feel, or by creating an instance of LookAndFeel and passing
  it to setLookAndFeel. The following example illustrates
  setting the look and feel to the system look and feel:


    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  The following example illustrates setting the look and feel based on
  class name:


    UIManager.setLookAndFeel(`javax.swing.plaf.metal.MetalLookAndFeel`);
  Once the look and feel has been changed it is imperative to invoke
  updateUI on all JComponents. The method SwingUtilities.updateComponentTreeUI(java.awt.Component) makes it easy to apply updateUI to a containment hierarchy. Refer to it for
  details. The exact behavior of not invoking updateUI after changing the look and feel is
  unspecified. It is very possible to receive unexpected exceptions,
  painting problems, or worse.

  Default look and feel

  The class used for the default look and feel is chosen in the following
  manner:

    If the system property swing.defaultlaf is
        non-null, use its value as the default look and feel class
        name.
    If the Properties file swing.properties
        exists and contains the key swing.defaultlaf,
        use its value as the default look and feel class name. The location
        that is checked for swing.properties may vary depending
        upon the implementation of the Java platform. Typically the
        swing.properties file is located in the lib
        subdirectory of the Java installation directory.
        Refer to the release notes of the implementation being used for
        further details.
    Otherwise use the cross platform look and feel.


  Defaults

  UIManager manages three sets of UIDefaults. In order, they
  are:

    Developer defaults. With few exceptions Swing does not
        alter the developer defaults; these are intended to be modified
        and used by the developer.
    Look and feel defaults. The look and feel defaults are
        supplied by the look and feel at the time it is installed as the
        current look and feel (setLookAndFeel() is invoked). The
        look and feel defaults can be obtained using the getLookAndFeelDefaults() method.
    System defaults. The system defaults are provided by Swing.

  Invoking any of the various get methods
  results in checking each of the defaults, in order, returning
  the first non-null value. For example, invoking
  UIManager.getString(`Table.foreground`) results in first
  checking developer defaults. If the developer defaults contain
  a value for `Table.foreground` it is returned, otherwise
  the look and feel defaults are checked, followed by the system defaults.

  It's important to note that getDefaults returns a custom
  instance of UIDefaults with this resolution logic built into it.
  For example, UIManager.getDefaults().getString(`Table.foreground`)
  is equivalent to UIManager.getString(`Table.foreground`). Both
  resolve using the algorithm just described. In many places the
  documentation uses the word defaults to refer to the custom instance
  of UIDefaults with the resolution logic as previously described.

  When the look and feel is changed, UIManager alters only the
  look and feel defaults; the developer and system defaults are not
  altered by the UIManager in any way.

  The set of defaults a particular look and feel supports is defined
  and documented by that look and feel. In addition, each look and
  feel, or ComponentUI provided by a look and feel, may
  access the defaults at different times in their life cycle. Some
  look and feels may aggressively look up defaults, so that changing a
  default may not have an effect after installing the look and feel.
  Other look and feels may lazily access defaults so that a change to
  the defaults may effect an existing look and feel. Finally, other look
  and feels might not configure themselves from the defaults table in
  any way. None-the-less it is usually the case that a look and feel
  expects certain defaults, so that in general
  a ComponentUI provided by one look and feel will not
  work with another look and feel.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIManager]))

(defn ->ui-manager
  "Constructor."
  (^UIManager []
    (new UIManager )))

(defn *get-insets
  "Returns an Insets object from the defaults that is
   appropriate for the given locale. If the value
   for key is not an Insets, null is returned.

  key - an Object specifying the Insets object - `java.lang.Object`
  l - the Locale for which the object is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Insets object - `java.awt.Insets`

  throws: java.lang.NullPointerException - if key is null"
  (^java.awt.Insets [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getInsets key l))
  (^java.awt.Insets [^java.lang.Object key]
    (UIManager/getInsets key)))

(defn *install-look-and-feel
  "Adds the specified look and feel to the set of available look
   and feels. While this method does not check the
   arguments in any way, it is strongly recommended that non-null values be supplied.

  name - descriptive name of the look and feel - `java.lang.String`
  class-name - name of the class that implements the look and feel - `java.lang.String`"
  ([^java.lang.String name ^java.lang.String class-name]
    (UIManager/installLookAndFeel name class-name))
  ([^javax.swing.UIManager$LookAndFeelInfo info]
    (UIManager/installLookAndFeel info)))

(defn *put
  "Stores an object in the developer defaults. This is a cover method
   for getDefaults().put(key, value). This only effects the
   developer defaults, not the system or look and feel defaults.

  key - an Object specifying the retrieval key - `java.lang.Object`
  value - the Object to store; refer to UIDefaults for details on how null is handled - `java.lang.Object`

  returns: the Object returned by UIDefaults.put(java.lang.Object, java.lang.Object) - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null"
  (^java.lang.Object [^java.lang.Object key ^java.lang.Object value]
    (UIManager/put key value)))

(defn *get-string
  "Returns a string from the defaults that is appropriate for the
   given locale.  If the value for
   key is not a String, null is returned.

  key - an Object specifying the string - `java.lang.Object`
  l - the Locale for which the string is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the String - `java.lang.String`

  throws: java.lang.NullPointerException - if key is null"
  (^java.lang.String [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getString key l))
  (^java.lang.String [^java.lang.Object key]
    (UIManager/getString key)))

(defn *get-defaults
  "Returns the defaults. The returned defaults resolve using the
   logic specified in the class documentation.

  returns: a UIDefaults object containing the default values - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults []
    (UIManager/getDefaults )))

(defn *get-border
  "Returns a border from the defaults that is appropriate
   for the given locale.  If the value for
   key is not a Border, null is returned.

  key - an Object specifying the border - `java.lang.Object`
  l - the Locale for which the border is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Border object - `javax.swing.border.Border`

  throws: java.lang.NullPointerException - if key is null"
  (^javax.swing.border.Border [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getBorder key l))
  (^javax.swing.border.Border [^java.lang.Object key]
    (UIManager/getBorder key)))

(defn *remove-auxiliary-look-and-feel
  "Removes a LookAndFeel from the list of auxiliary look and feels.
   The auxiliary look and feels tell the multiplexing look and feel what
   other LookAndFeel classes for a component instance are to be used
   in addition to the default LookAndFeel class when creating a
   multiplexing UI.  The change will only take effect when a new
   UI class is created or when the default look and feel is changed
   on a component instance.
   Note these are not the same as the installed look and feels.

  laf - `javax.swing.LookAndFeel`

  returns: true if the LookAndFeel was removed from the list - `boolean`"
  (^Boolean [^javax.swing.LookAndFeel laf]
    (UIManager/removeAuxiliaryLookAndFeel laf)))

(defn *get-icon
  "Returns an Icon from the defaults that is appropriate
   for the given locale. If the value for
   key is not an Icon, null is returned.

  key - an Object specifying the icon - `java.lang.Object`
  l - the Locale for which the icon is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Icon object - `javax.swing.Icon`

  throws: java.lang.NullPointerException - if key is null"
  (^javax.swing.Icon [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getIcon key l))
  (^javax.swing.Icon [^java.lang.Object key]
    (UIManager/getIcon key)))

(defn *get-auxiliary-look-and-feels
  "Returns the list of auxiliary look and feels (can be null).
   The auxiliary look and feels tell the multiplexing look and feel what
   other LookAndFeel classes for a component instance are
   to be used in addition to the default LookAndFeel class when creating a
   multiplexing UI.
   Note these are not the same as the installed look and feels.

  returns: list of auxiliary LookAndFeels or null - `javax.swing.LookAndFeel[]`"
  ([]
    (UIManager/getAuxiliaryLookAndFeels )))

(defn *get-dimension
  "Returns a dimension from the defaults that is appropriate
   for the given locale. If the value
   for key is not a Dimension, null is returned.

  key - an Object specifying the dimension object - `java.lang.Object`
  l - the Locale for which the object is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Dimension object - `java.awt.Dimension`

  throws: java.lang.NullPointerException - if key is null"
  (^java.awt.Dimension [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getDimension key l))
  (^java.awt.Dimension [^java.lang.Object key]
    (UIManager/getDimension key)))

(defn *get-installed-look-and-feels
  "Returns an array of LookAndFeelInfos representing the
   LookAndFeel implementations currently available. The
   LookAndFeelInfo objects can be used by an
   application to construct a menu of look and feel options for
   the user, or to determine which look and feel to set at startup
   time. To avoid the penalty of creating numerous LookAndFeel objects, LookAndFeelInfo maintains the
   class name of the LookAndFeel class, not the actual
   LookAndFeel instance.

   The following example illustrates setting the current look and feel
   from an instance of LookAndFeelInfo:


     UIManager.setLookAndFeel(info.getClassName());

  returns: an array of LookAndFeelInfo objects - `javax.swing.UIManager$LookAndFeelInfo[]`"
  ([]
    (UIManager/getInstalledLookAndFeels )))

(defn *get-look-and-feel-defaults
  "Returns the UIDefaults from the current look and feel,
   that were obtained at the time the look and feel was installed.

   In general, developers should use the UIDefaults returned from
   getDefaults(). As the current look and feel may expect
   certain values to exist, altering the UIDefaults returned
   from this method could have unexpected results.

  returns: UIDefaults from the current look and feel - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults []
    (UIManager/getLookAndFeelDefaults )))

(defn *remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyChangeListener listener]
    (UIManager/removePropertyChangeListener listener)))

(defn *get-cross-platform-look-and-feel-class-name
  "Returns the name of the LookAndFeel class that implements
   the default cross platform look and feel -- the Java
   Look and Feel (JLF).  This value can be overriden by setting the
   swing.crossplatformlaf system property.

  returns: a string with the JLF implementation-class - `java.lang.String`"
  (^java.lang.String []
    (UIManager/getCrossPlatformLookAndFeelClassName )))

(defn *set-look-and-feel
  "Sets the current look and feel to newLookAndFeel.
   If the current look and feel is non-null uninitialize is invoked on it. If newLookAndFeel is
   non-null, initialize is invoked on it followed
   by getDefaults. The defaults returned from newLookAndFeel.getDefaults() replace those of the defaults
   from the previous look and feel. If the newLookAndFeel is
   null, the look and feel defaults are set to null.

   A value of null can be used to set the look and feel
   to null. As the LookAndFeel is required for
   most of Swing to function, setting the LookAndFeel to
   null is strongly discouraged.

   This is a JavaBeans bound property.

  new-look-and-feel - LookAndFeel to install - `javax.swing.LookAndFeel`

  throws: javax.swing.UnsupportedLookAndFeelException - if newLookAndFeel is non-null and newLookAndFeel.isSupportedLookAndFeel() returns false"
  ([^javax.swing.LookAndFeel new-look-and-feel]
    (UIManager/setLookAndFeel new-look-and-feel)))

(defn *get-int
  "Returns an integer from the defaults that is appropriate
   for the given locale. If the value for
   key is not an Integer, or does not exist,
   0 is returned.

  key - an Object specifying the int - `java.lang.Object`
  l - the Locale for which the int is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the int - `int`

  throws: java.lang.NullPointerException - if key is null"
  (^Integer [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getInt key l))
  (^Integer [^java.lang.Object key]
    (UIManager/getInt key)))

(defn *get-system-look-and-feel-class-name
  "Returns the name of the LookAndFeel class that implements
   the native system look and feel if there is one, otherwise
   the name of the default cross platform LookAndFeel
   class. This value can be overriden by setting the
   swing.systemlaf system property.

  returns: the String of the LookAndFeel
            class - `java.lang.String`"
  (^java.lang.String []
    (UIManager/getSystemLookAndFeelClassName )))

(defn *get-ui
  "Returns the appropriate ComponentUI implementation for
   target. Typically, this is a cover for
   getDefaults().getUI(target). However, if an auxiliary
   look and feel has been installed, this first invokes
   getUI(target) on the multiplexing look and feel's
   defaults, and returns that value if it is non-null.

  target - the JComponent to return the ComponentUI for - `javax.swing.JComponent`

  returns: the ComponentUI object for target - `javax.swing.plaf.ComponentUI`

  throws: java.lang.NullPointerException - if target is null"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent target]
    (UIManager/getUI target)))

(defn *get-property-change-listeners
  "Returns an array of all the PropertyChangeListeners added
   to this UIManager with addPropertyChangeListener().

  returns: all of the PropertyChangeListeners added or an empty
           array if no listeners have been added - `java.beans.PropertyChangeListener[]`"
  ([]
    (UIManager/getPropertyChangeListeners )))

(defn *add-auxiliary-look-and-feel
  "Adds a LookAndFeel to the list of auxiliary look and feels.
   The auxiliary look and feels tell the multiplexing look and feel what
   other LookAndFeel classes for a component instance are to be used
   in addition to the default LookAndFeel class when creating a
   multiplexing UI.  The change will only take effect when a new
   UI class is created or when the default look and feel is changed
   on a component instance.
   Note these are not the same as the installed look and feels.

  laf - the LookAndFeel object - `javax.swing.LookAndFeel`"
  ([^javax.swing.LookAndFeel laf]
    (UIManager/addAuxiliaryLookAndFeel laf)))

(defn *get-font
  "Returns a font from the defaults that is appropriate
   for the given locale. If the value for key is
   not a Font, null is returned.

  key - an Object specifying the font - `java.lang.Object`
  l - the Locale for which the font is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Font object - `java.awt.Font`

  throws: java.lang.NullPointerException - if key is null"
  (^java.awt.Font [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getFont key l))
  (^java.awt.Font [^java.lang.Object key]
    (UIManager/getFont key)))

(defn *get-look-and-feel
  "Returns the current look and feel or null.

  returns: current look and feel, or null - `javax.swing.LookAndFeel`"
  (^javax.swing.LookAndFeel []
    (UIManager/getLookAndFeel )))

(defn *get-boolean?
  "Returns a boolean from the defaults which is associated with
   the key value and the given Locale. If the key is not
   found or the key doesn't represent
   a boolean value then false will be returned.

  key - an Object specifying the key for the desired boolean value - `java.lang.Object`
  l - the Locale for which the boolean is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the boolean value corresponding to the key - `boolean`

  throws: java.lang.NullPointerException - if key is null"
  (^Boolean [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getBoolean key l))
  (^Boolean [^java.lang.Object key]
    (UIManager/getBoolean key)))

(defn *get-color
  "Returns a color from the defaults that is appropriate
   for the given locale. If the value for key is
   not a Color, null is returned.

  key - an Object specifying the color - `java.lang.Object`
  l - the Locale for which the color is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Color object - `java.awt.Color`

  throws: java.lang.NullPointerException - if key is null"
  (^java.awt.Color [^java.lang.Object key ^java.util.Locale l]
    (UIManager/getColor key l))
  (^java.awt.Color [^java.lang.Object key]
    (UIManager/getColor key)))

(defn *add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^java.beans.PropertyChangeListener listener]
    (UIManager/addPropertyChangeListener listener)))

(defn *get
  "Returns an object from the defaults that is appropriate for
   the given locale.

  key - an Object specifying the desired object - `java.lang.Object`
  l - the Locale for which the object is desired; refer to UIDefaults for details on how a null Locale is handled - `java.util.Locale`

  returns: the Object - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null"
  (^java.lang.Object [^java.lang.Object key ^java.util.Locale l]
    (UIManager/get key l))
  (^java.lang.Object [^java.lang.Object key]
    (UIManager/get key)))

(defn *set-installed-look-and-feels
  "Sets the set of available look and feels. While this method does
   not check to ensure all of the LookAndFeelInfos are
   non-null, it is strongly recommended that only non-null
   values are supplied in the infos array.

  infos - set of LookAndFeelInfo objects specifying the available look and feels - `javax.swing.UIManager$LookAndFeelInfo[]`

  throws: java.lang.NullPointerException - if infos is null"
  ([infos]
    (UIManager/setInstalledLookAndFeels infos)))

