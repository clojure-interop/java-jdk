(ns javax.swing.JSeparator
  "JSeparator provides a general purpose component for
  implementing divider lines - most commonly used as a divider
  between menu items that breaks them up into logical groupings.
  Instead of using JSeparator directly,
  you can use the JMenu or JPopupMenu
  addSeparator method to create and add a separator.
  JSeparators may also be used elsewhere in a GUI
  wherever a visual divider is useful.



  For more information and examples see
  How to Use Menus,
  a section in The Java Tutorial.

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
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSeparator]))

(defn ->j-separator
  "Constructor.

  Creates a new separator with the specified horizontal or
   vertical orientation.

  orientation - an integer specifying SwingConstants.HORIZONTAL or SwingConstants.VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if orientation is neither SwingConstants.HORIZONTAL nor SwingConstants.VERTICAL"
  ([orientation]
    (new JSeparator orientation))
  ([]
    (new JSeparator )))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the SeparatorUI object that renders this component - `javax.swing.plaf.SeparatorUI`"
  ([this]
    (-> this (.getUI))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the SeparatorUI L&F object - `javax.swing.plaf.SeparatorUI`"
  ([this ui]
    (-> this (.setUI ui))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([this]
    (-> this (.updateUI))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `SeparatorUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-orientation
  "Returns the orientation of this separator.

  returns: The value of the orientation property, one of the
             following constants defined in SwingConstants:
             VERTICAL, or
             HORIZONTAL. - `int`"
  ([this]
    (-> this (.getOrientation))))

(defn set-orientation
  "Sets the orientation of the separator.
   The default value of this property is HORIZONTAL.

  orientation - either SwingConstants.HORIZONTAL or SwingConstants.VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if orientation is neither SwingConstants.HORIZONTAL nor SwingConstants.VERTICAL"
  ([this orientation]
    (-> this (.setOrientation orientation))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JSeparator.
   For separators, the AccessibleContext takes the form of an
   AccessibleJSeparator.
   A new AccessibleJSeparator instance is created if necessary.

  returns: an AccessibleJSeparator that serves as the
           AccessibleContext of this JSeparator - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

