(ns javax.swing.text.TextAction
  "An Action implementation useful for key bindings that are
  shared across a number of different text components.  Because
  the action is shared, it must have a way of getting it's
  target to act upon.  This class provides support to try and
  find a text component to operate on.  The preferred way of
  getting the component to act upon is through the ActionEvent
  that is received.  If the Object returned by getSource can
  be narrowed to a text component, it will be used.  If the
  action event is null or can't be narrowed, the last focused
  text component is tried.  This is determined by being
  used in conjunction with a JTextController which
  arranges to share that information with a TextAction.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TextAction]))

(defn ->text-action
  "Constructor.

  Creates a new JTextAction object.

  name - the name of the action - `java.lang.String`"
  (^TextAction [^java.lang.String name]
    (new TextAction name)))

(defn *augment-list
  "Takes one list of
   commands and augments it with another list
   of commands.  The second list takes precedence
   over the first list; that is, when both lists
   contain a command with the same name, the command
   from the second list is used.

  list-1 - the first list, may be empty but not null - `javax.swing.Action[]`
  list-2 - the second list, may be empty but not null - `javax.swing.Action[]`

  returns: the augmented list - `javax.swing.Action[]`"
  ([list-1 list-2]
    (TextAction/augmentList list-1 list-2)))

