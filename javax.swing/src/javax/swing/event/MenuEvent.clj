(ns javax.swing.event.MenuEvent
  "MenuEvent is used to notify interested parties that
  the menu which is the event source has been posted,
  selected, or canceled.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuEvent]))

(defn ->menu-event
  "Constructor.

  Constructs a MenuEvent object.

  source - the Object that originated the event (typically this) - `java.lang.Object`"
  ([source]
    (new MenuEvent source)))

