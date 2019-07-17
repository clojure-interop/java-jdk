(ns jdk.awt.event.ComponentAdapter
  "An abstract adapter class for receiving component events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Extend this class to create a ComponentEvent listener
  and override the methods for the events of interest. (If you implement the
  ComponentListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using your class and then register it with a
  component using the component's addComponentListener
  method. When the component's size, location, or visibility
  changes, the relevant method in the listener object is invoked,
  and the ComponentEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ComponentAdapter]))

(defn ->component-adapter
  "Constructor."
  ([]
    (new ComponentAdapter )))

(defn component-resized
  "Invoked when the component's size changes.

  e - `java.awt.event.ComponentEvent`"
  ([^java.awt.event.ComponentAdapter this ^java.awt.event.ComponentEvent e]
    (-> this (.componentResized e))))

(defn component-moved
  "Invoked when the component's position changes.

  e - `java.awt.event.ComponentEvent`"
  ([^java.awt.event.ComponentAdapter this ^java.awt.event.ComponentEvent e]
    (-> this (.componentMoved e))))

(defn component-shown
  "Invoked when the component has been made visible.

  e - `java.awt.event.ComponentEvent`"
  ([^java.awt.event.ComponentAdapter this ^java.awt.event.ComponentEvent e]
    (-> this (.componentShown e))))

(defn component-hidden
  "Invoked when the component has been made invisible.

  e - `java.awt.event.ComponentEvent`"
  ([^java.awt.event.ComponentAdapter this ^java.awt.event.ComponentEvent e]
    (-> this (.componentHidden e))))

