(ns javax.swing.event.CaretEvent
  "CaretEvent is used to notify interested parties that
  the text caret has changed in the event source.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event CaretEvent]))

(defn ->caret-event
  "Constructor.

  Creates a new CaretEvent object.

  source - the object responsible for the event - `java.lang.Object`"
  ([source]
    (new CaretEvent source)))

(defn get-dot
  "Fetches the location of the caret.

  returns: the dot >= 0 - `int`"
  ([this]
    (-> this (.getDot))))

(defn get-mark
  "Fetches the location of other end of a logical
   selection.  If there is no selection, this
   will be the same as dot.

  returns: the mark >= 0 - `int`"
  ([this]
    (-> this (.getMark))))

