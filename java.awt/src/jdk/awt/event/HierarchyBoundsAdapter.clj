(ns jdk.awt.event.HierarchyBoundsAdapter
  "An abstract adapter class for receiving ancestor moved and resized events.
  The methods in this class are empty. This class exists as a
  convenience for creating listener objects.

  Extend this class and override the method for the event of interest. (If
  you implement the HierarchyBoundsListener interface, you have
  to define both methods in it. This abstract class defines null methods for
  them both, so you only have to define the method for the event you care
  about.)

  Create a listener object using your class and then register it with a
  Component using the Component's addHierarchyBoundsListener
  method. When the hierarchy to which the Component belongs changes by
  resize or movement of an ancestor, the relevant method in the listener
  object is invoked, and the HierarchyEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event HierarchyBoundsAdapter]))

(defn ->hierarchy-bounds-adapter
  "Constructor."
  ([]
    (new HierarchyBoundsAdapter )))

(defn ancestor-moved
  "Called when an ancestor of the source is moved.

  e - `java.awt.event.HierarchyEvent`"
  ([this e]
    (-> this (.ancestorMoved e))))

(defn ancestor-resized
  "Called when an ancestor of the source is resized.

  e - `java.awt.event.HierarchyEvent`"
  ([this e]
    (-> this (.ancestorResized e))))

