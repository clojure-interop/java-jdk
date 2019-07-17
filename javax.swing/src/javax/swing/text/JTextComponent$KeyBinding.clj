(ns javax.swing.text.JTextComponent$KeyBinding
  "Binding record for creating key bindings.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text JTextComponent$KeyBinding]))

(defn ->key-binding
  "Constructor.

  Creates a new key binding.

  key - the key - `javax.swing.KeyStroke`
  action-name - the name of the action for the key - `java.lang.String`"
  ([key action-name]
    (new JTextComponent$KeyBinding key action-name)))

(defn -key
  "Instance Field.

  The key.

  type: javax.swing.KeyStroke"
  [this]
  (-> this .-key))

(defn -action-name
  "Instance Field.

  The name of the action for the key.

  type: java.lang.String"
  [this]
  (-> this .-actionName))

