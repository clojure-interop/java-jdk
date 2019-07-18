(ns jdk.awt.event.HierarchyBoundsListener
  "The listener interface for receiving ancestor moved and resized events.
  The class that is interested in processing these events either implements
  this interface (and all the methods it contains) or extends the abstract
  HierarchyBoundsAdapter class (overriding only the method of
  interest).
  The listener object created from that class is then registered with a
  Component using the Component's addHierarchyBoundsListener
  method. When the hierarchy to which the Component belongs changes by
  the resizing or movement of an ancestor, the relevant method in the listener
  object is invoked, and the HierarchyEvent is passed to it.

  Hierarchy events are provided for notification purposes ONLY;
  The AWT will automatically handle changes to the hierarchy internally so
  that GUI layout works properly regardless of whether a
  program registers an HierarchyBoundsListener or not."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event HierarchyBoundsListener]))

(defn ancestor-moved
  "Called when an ancestor of the source is moved.

  e - `java.awt.event.HierarchyEvent`"
  ([^HierarchyBoundsListener this ^java.awt.event.HierarchyEvent e]
    (-> this (.ancestorMoved e))))

(defn ancestor-resized
  "Called when an ancestor of the source is resized.

  e - `java.awt.event.HierarchyEvent`"
  ([^HierarchyBoundsListener this ^java.awt.event.HierarchyEvent e]
    (-> this (.ancestorResized e))))

