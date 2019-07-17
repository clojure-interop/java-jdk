(ns jdk.awt.event.KeyListener
  "The listener interface for receiving keyboard events (keystrokes).
  The class that is interested in processing a keyboard event
  either implements this interface (and all the methods it
  contains) or extends the abstract KeyAdapter class
  (overriding only the methods of interest).

  The listener object created from that class is then registered with a
  component using the component's addKeyListener
  method. A keyboard event is generated when a key is pressed, released,
  or typed. The relevant method in the listener
  object is then invoked, and the KeyEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event KeyListener]))

(defn key-typed
  "Invoked when a key has been typed.
   See the class description for KeyEvent for a definition of
   a key typed event.

  e - `java.awt.event.KeyEvent`"
  ([this e]
    (-> this (.keyTyped e))))

(defn key-pressed
  "Invoked when a key has been pressed.
   See the class description for KeyEvent for a definition of
   a key pressed event.

  e - `java.awt.event.KeyEvent`"
  ([this e]
    (-> this (.keyPressed e))))

(defn key-released
  "Invoked when a key has been released.
   See the class description for KeyEvent for a definition of
   a key released event.

  e - `java.awt.event.KeyEvent`"
  ([this e]
    (-> this (.keyReleased e))))

