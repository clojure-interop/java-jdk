(ns jdk.awt.event.ComponentListener
  "The listener interface for receiving component events.
  The class that is interested in processing a component event
  either implements this interface (and all the methods it
  contains) or extends the abstract ComponentAdapter class
  (overriding only the methods of interest).
  The listener object created from that class is then registered with a
  component using the component's addComponentListener
  method. When the component's size, location, or visibility
  changes, the relevant method in the listener object is invoked,
  and the ComponentEvent is passed to it.

  Component events are provided for notification purposes ONLY;
  The AWT will automatically handle component moves and resizes
  internally so that GUI layout works properly regardless of
  whether a program registers a ComponentListener or not."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ComponentListener]))

(defn component-resized
  "Invoked when the component's size changes.

  e - `java.awt.event.ComponentEvent`"
  ([^. this ^java.awt.event.ComponentEvent e]
    (-> this (.componentResized e))))

(defn component-moved
  "Invoked when the component's position changes.

  e - `java.awt.event.ComponentEvent`"
  ([^. this ^java.awt.event.ComponentEvent e]
    (-> this (.componentMoved e))))

(defn component-shown
  "Invoked when the component has been made visible.

  e - `java.awt.event.ComponentEvent`"
  ([^. this ^java.awt.event.ComponentEvent e]
    (-> this (.componentShown e))))

(defn component-hidden
  "Invoked when the component has been made invisible.

  e - `java.awt.event.ComponentEvent`"
  ([^. this ^java.awt.event.ComponentEvent e]
    (-> this (.componentHidden e))))

