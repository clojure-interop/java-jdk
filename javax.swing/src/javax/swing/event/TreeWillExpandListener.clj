(ns javax.swing.event.TreeWillExpandListener
  "The listener that's notified when a tree expands or collapses
  a node.
  For further information and examples see
  How to Write a Tree-Will-Expand Listener,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeWillExpandListener]))

(defn tree-will-expand
  "Invoked whenever a node in the tree is about to be expanded.

  event - `javax.swing.event.TreeExpansionEvent`

  throws: javax.swing.tree.ExpandVetoException"
  ([^javax.swing.event.TreeWillExpandListener this ^javax.swing.event.TreeExpansionEvent event]
    (-> this (.treeWillExpand event))))

(defn tree-will-collapse
  "Invoked whenever a node in the tree is about to be collapsed.

  event - `javax.swing.event.TreeExpansionEvent`

  throws: javax.swing.tree.ExpandVetoException"
  ([^javax.swing.event.TreeWillExpandListener this ^javax.swing.event.TreeExpansionEvent event]
    (-> this (.treeWillCollapse event))))

