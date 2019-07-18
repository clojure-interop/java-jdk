(ns javax.swing.UnsupportedLookAndFeelException
  "An exception that indicates the requested look & feel
  management classes are not present on the user's system.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UnsupportedLookAndFeelException]))

(defn ->unsupported-look-and-feel-exception
  "Constructor.

  Constructs an UnsupportedLookAndFeelException object.

  s - a message String - `java.lang.String`"
  (^UnsupportedLookAndFeelException [^java.lang.String s]
    (new UnsupportedLookAndFeelException s)))

