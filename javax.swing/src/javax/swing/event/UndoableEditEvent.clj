(ns javax.swing.event.UndoableEditEvent
  "An event indicating that an operation which can be undone has occurred.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event UndoableEditEvent]))

(defn ->undoable-edit-event
  "Constructor.

  Constructs an UndoableEditEvent object.

  source - the Object that originated the event (typically this) - `java.lang.Object`
  edit - an UndoableEdit object - `javax.swing.undo.UndoableEdit`"
  ([^java.lang.Object source ^javax.swing.undo.UndoableEdit edit]
    (new UndoableEditEvent source edit)))

(defn get-edit
  "Returns the edit value.

  returns: the UndoableEdit object encapsulating the edit - `javax.swing.undo.UndoableEdit`"
  ([^javax.swing.event.UndoableEditEvent this]
    (-> this (.getEdit))))

