(ns javax.swing.plaf.IconUIResource
  "An Icon wrapper class which implements UIResource.  UI
  classes which set icon properties should use this class
  to wrap any icons specified as defaults.

  This class delegates all method invocations to the
  Icon `delegate` object specified at construction.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf IconUIResource]))

(defn ->icon-ui-resource
  "Constructor.

  Creates a UIResource icon object which wraps
   an existing Icon instance.

  delegate - the icon being wrapped - `javax.swing.Icon`"
  ([^javax.swing.Icon delegate]
    (new IconUIResource delegate)))

(defn paint-icon
  "Description copied from interface: Icon

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([^javax.swing.plaf.IconUIResource this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y]
    (-> this (.paintIcon c g x y))))

(defn get-icon-width
  "Description copied from interface: Icon

  returns: an int specifying the fixed width of the icon. - `int`"
  ([^javax.swing.plaf.IconUIResource this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Description copied from interface: Icon

  returns: an int specifying the fixed height of the icon. - `int`"
  ([^javax.swing.plaf.IconUIResource this]
    (-> this (.getIconHeight))))

