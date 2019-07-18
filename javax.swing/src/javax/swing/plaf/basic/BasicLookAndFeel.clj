(ns javax.swing.plaf.basic.BasicLookAndFeel
  "A base class to use in creating a look and feel for Swing.

  Each of the ComponentUIs provided by BasicLookAndFeel derives its behavior from the defaults
  table. Unless otherwise noted each of the ComponentUI
  implementations in this package document the set of defaults they
  use. Unless otherwise noted the defaults are installed at the time
  installUI is invoked, and follow the recommendations
  outlined in LookAndFeel for installing defaults.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicLookAndFeel]))

(defn ->basic-look-and-feel
  "Constructor."
  (^BasicLookAndFeel []
    (new BasicLookAndFeel )))

(defn get-defaults
  "Returns the look and feel defaults. The returned UIDefaults
   is populated by invoking, in order, initClassDefaults,
   initSystemColorDefaults and initComponentDefaults.

   While this method is public, it should only be invoked by the
   UIManager when the look and feel is set as the current
   look and feel and after initialize has been invoked.

  returns: the look and feel defaults - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^BasicLookAndFeel this]
    (-> this (.getDefaults))))

(defn initialize
  "Initializes the look and feel. While this method is public,
   it should only be invoked by the UIManager when a
   look and feel is installed as the current look and feel. This
   method is invoked before the UIManager invokes
   getDefaults. This method is intended to perform any
   initialization for the look and feel. Subclasses
   should do any one-time setup they need here, rather than
   in a static initializer, because look and feel class objects
   may be loaded just to discover that isSupportedLookAndFeel()
   returns false."
  ([^BasicLookAndFeel this]
    (-> this (.initialize))))

(defn uninitialize
  "Uninitializes the look and feel. While this method is public,
   it should only be invoked by the UIManager when
   the look and feel is uninstalled. For example,
   UIManager.setLookAndFeel invokes this when the look and
   feel is changed.

   Subclasses may choose to free up some resources here."
  ([^BasicLookAndFeel this]
    (-> this (.uninitialize))))

