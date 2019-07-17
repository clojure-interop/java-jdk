(ns javax.swing.plaf.FontUIResource
  "A subclass of java.awt.Font that implements UIResource.
  UI classes which set default font properties should use
  this class.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf FontUIResource]))

(defn ->font-ui-resource
  "Constructor.

  name - `java.lang.String`
  style - `int`
  size - `int`"
  ([^java.lang.String name ^Integer style ^Integer size]
    (new FontUIResource name style size))
  ([^java.awt.Font font]
    (new FontUIResource font)))

