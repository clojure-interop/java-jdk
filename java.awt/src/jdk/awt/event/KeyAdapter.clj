(ns jdk.awt.event.KeyAdapter
  "An abstract adapter class for receiving keyboard events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Extend this class to create a KeyEvent listener
  and override the methods for the events of interest. (If you implement the
  KeyListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a component using the component's addKeyListener
  method. When a key is pressed, released, or typed,
  the relevant method in the listener object is invoked,
  and the KeyEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event KeyAdapter]))

(defn ->key-adapter
  "Constructor."
  ([]
    (new KeyAdapter )))

(defn key-typed
  "Invoked when a key has been typed.
   This event occurs when a key press is followed by a key release.

  e - `java.awt.event.KeyEvent`"
  ([^java.awt.event.KeyAdapter this ^java.awt.event.KeyEvent e]
    (-> this (.keyTyped e))))

(defn key-pressed
  "Invoked when a key has been pressed.

  e - `java.awt.event.KeyEvent`"
  ([^java.awt.event.KeyAdapter this ^java.awt.event.KeyEvent e]
    (-> this (.keyPressed e))))

(defn key-released
  "Invoked when a key has been released.

  e - `java.awt.event.KeyEvent`"
  ([^java.awt.event.KeyAdapter this ^java.awt.event.KeyEvent e]
    (-> this (.keyReleased e))))

