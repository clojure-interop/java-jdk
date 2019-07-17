(ns javax.swing.event.ChangeEvent
  "ChangeEvent is used to notify interested parties that
  state has changed in the event source.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ChangeEvent]))

(defn ->change-event
  "Constructor.

  Constructs a ChangeEvent object.

  source - the Object that is the source of the event (typically this) - `java.lang.Object`"
  ([^java.lang.Object source]
    (new ChangeEvent source)))

