(ns javax.swing.plaf.multi.MultiLookAndFeel
  "A multiplexing look and feel that allows more than one UI
  to be associated with a component at the same time.
  The primary look and feel is called
  the default look and feel,
  and the other look and feels are called auxiliary.


  For further information, see
  Using the
  Multiplexing Look and Feel.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.multi MultiLookAndFeel]))

(defn ->multi-look-and-feel
  "Constructor."
  (^MultiLookAndFeel []
    (new MultiLookAndFeel )))

(defn *create-u-is
  "Creates the ComponentUI objects
   required to present
   the target component,
   placing the objects in the uis vector and
   returning the
   ComponentUI object
   that best represents the component's UI.
   This method finds the ComponentUI objects
   by invoking
   getDefaults().getUI(target) on each
   default and auxiliary look and feel currently in use.
   The first UI object this method adds
   to the uis vector
   is for the default look and feel.

   This method is invoked by the createUI method
   of MultiXxxxUI classes.

  mui - the ComponentUI object that represents the complete UI for the target component; this should be an instance of one of the MultiXxxxUI classes - `javax.swing.plaf.ComponentUI`
  uis - a Vector; generally this is the uis field of the mui argument - `java.util.Vector`
  target - a component whose UI is represented by mui - `javax.swing.JComponent`

  returns: mui if the component has any auxiliary UI objects;
           otherwise, returns the UI object for the default look and feel
           or null if the default UI object couldn't be found - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.plaf.ComponentUI mui ^java.util.Vector uis ^javax.swing.JComponent target]
    (MultiLookAndFeel/createUIs mui uis target)))

(defn get-name
  "Returns a string, suitable for use in menus,
   that identifies this look and feel.

  returns: a string such as `Multiplexing Look and Feel` - `java.lang.String`"
  (^java.lang.String [^MultiLookAndFeel this]
    (-> this (.getName))))

(defn get-id
  "Returns a string, suitable for use by applications/services,
   that identifies this look and feel.

  returns: `Multiplex` - `java.lang.String`"
  (^java.lang.String [^MultiLookAndFeel this]
    (-> this (.getID))))

(defn get-description
  "Returns a one-line description of this look and feel.

  returns: a descriptive string such as `Allows multiple UI instances per component instance` - `java.lang.String`"
  (^java.lang.String [^MultiLookAndFeel this]
    (-> this (.getDescription))))

(defn native-look-and-feel?
  "Returns false;
   this look and feel is not native to any platform.

  returns: false - `boolean`"
  (^Boolean [^MultiLookAndFeel this]
    (-> this (.isNativeLookAndFeel))))

(defn supported-look-and-feel?
  "Returns true;
   every platform permits this look and feel.

  returns: true - `boolean`"
  (^Boolean [^MultiLookAndFeel this]
    (-> this (.isSupportedLookAndFeel))))

(defn get-defaults
  "Creates, initializes, and returns
   the look and feel specific defaults.
   For this look and feel,
   the defaults consist solely of
   mappings of UI class IDs
   (such as `ButtonUI`)
   to ComponentUI class names
   (such as `javax.swing.plaf.multi.MultiButtonUI`).

  returns: an initialized UIDefaults object - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^MultiLookAndFeel this]
    (-> this (.getDefaults))))

