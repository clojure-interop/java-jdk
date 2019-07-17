(ns javax.swing.undo.CannotRedoException
  "Thrown when an UndoableEdit is told to redo() and can't.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo CannotRedoException]))

(defn ->cannot-redo-exception
  "Constructor."
  ([]
    (new CannotRedoException )))

