(ns javax.swing.event.TreeExpansionEvent
  "An event used to identify a single path in a tree.  The source
  returned by getSource will be an instance of JTree.

  For further documentation and examples see
  the following sections in The Java Tutorial:
  How to Write a Tree Expansion Listener and
  How to Write a Tree-Will-Expand Listener.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeExpansionEvent]))

(defn ->tree-expansion-event
  "Constructor.

  Constructs a TreeExpansionEvent object.

  source - the Object that originated the event (typically this) - `java.lang.Object`
  path - a TreePath object identifying the newly expanded node - `javax.swing.tree.TreePath`"
  ([^java.lang.Object source ^javax.swing.tree.TreePath path]
    (new TreeExpansionEvent source path)))

(defn get-path
  "Returns the path to the value that has been expanded/collapsed.

  returns: `javax.swing.tree.TreePath`"
  ([^javax.swing.event.TreeExpansionEvent this]
    (-> this (.getPath))))

