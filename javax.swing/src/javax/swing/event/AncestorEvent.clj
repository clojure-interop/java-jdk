(ns javax.swing.event.AncestorEvent
  "An event reported to a child component that originated from an
  ancestor in the component hierarchy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event AncestorEvent]))

(defn ->ancestor-event
  "Constructor.

  Constructs an AncestorEvent object to identify a change
   in an ancestor-component's display-status.

  source - the JComponent that originated the event (typically this) - `javax.swing.JComponent`
  id - an int specifying ANCESTOR_ADDED, ANCESTOR_REMOVED or ANCESTOR_MOVED - `int`
  ancestor - a Container object specifying the ancestor-component whose display-status changed - `java.awt.Container`
  ancestor-parent - a Container object specifying the ancestor's parent - `java.awt.Container`"
  ([^javax.swing.JComponent source ^Integer id ^java.awt.Container ancestor ^java.awt.Container ancestor-parent]
    (new AncestorEvent source id ancestor ancestor-parent)))

(def *-ancestor-added
  "Static Constant.

  An ancestor-component was added to the hierarchy of
   visible objects (made visible), and is currently being displayed.

  type: int"
  AncestorEvent/ANCESTOR_ADDED)

(def *-ancestor-removed
  "Static Constant.

  An ancestor-component was removed from the hierarchy
   of visible objects (hidden) and is no longer being displayed.

  type: int"
  AncestorEvent/ANCESTOR_REMOVED)

(def *-ancestor-moved
  "Static Constant.

  An ancestor-component changed its position on the screen.

  type: int"
  AncestorEvent/ANCESTOR_MOVED)

(defn get-ancestor
  "Returns the ancestor that the event actually occurred on.

  returns: `java.awt.Container`"
  (^java.awt.Container [^javax.swing.event.AncestorEvent this]
    (-> this (.getAncestor))))

(defn get-ancestor-parent
  "Returns the parent of the ancestor the event actually occurred on.
   This is most interesting in an ANCESTOR_REMOVED event, as
   the ancestor may no longer be in the component hierarchy.

  returns: `java.awt.Container`"
  (^java.awt.Container [^javax.swing.event.AncestorEvent this]
    (-> this (.getAncestorParent))))

(defn get-component
  "Returns the component that the listener was added to.

  returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.event.AncestorEvent this]
    (-> this (.getComponent))))

