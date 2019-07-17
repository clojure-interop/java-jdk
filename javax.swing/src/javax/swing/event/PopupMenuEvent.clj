(ns javax.swing.event.PopupMenuEvent
  "PopupMenuEvent only contains the source of the event which is the JPoupMenu
  sending the event

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event PopupMenuEvent]))

(defn ->popup-menu-event
  "Constructor.

  Constructs a PopupMenuEvent object.

  source - the Object that originated the event (typically this) - `java.lang.Object`"
  ([^java.lang.Object source]
    (new PopupMenuEvent source)))

