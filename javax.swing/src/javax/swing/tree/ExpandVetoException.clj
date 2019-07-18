(ns javax.swing.tree.ExpandVetoException
  "Exception used to stop and expand/collapse from happening.
  See How to Write a Tree-Will-Expand Listener
  in The Java Tutorial
  for further information and examples."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree ExpandVetoException]))

(defn ->expand-veto-exception
  "Constructor.

  Constructs an ExpandVetoException object with the specified message.

  event - a TreeExpansionEvent object - `javax.swing.event.TreeExpansionEvent`
  message - a String containing the message - `java.lang.String`"
  (^ExpandVetoException [^javax.swing.event.TreeExpansionEvent event ^java.lang.String message]
    (new ExpandVetoException event message))
  (^ExpandVetoException [^javax.swing.event.TreeExpansionEvent event]
    (new ExpandVetoException event)))

