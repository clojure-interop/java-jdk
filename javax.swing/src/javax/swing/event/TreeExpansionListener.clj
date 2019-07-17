(ns javax.swing.event.TreeExpansionListener
  "The listener that's notified when a tree expands or collapses
  a node.
  For further documentation and examples see
  How to Write a Tree Expansion Listener,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeExpansionListener]))

(defn tree-expanded
  "Called whenever an item in the tree has been expanded.

  event - `javax.swing.event.TreeExpansionEvent`"
  ([^. this ^javax.swing.event.TreeExpansionEvent event]
    (-> this (.treeExpanded event))))

(defn tree-collapsed
  "Called whenever an item in the tree has been collapsed.

  event - `javax.swing.event.TreeExpansionEvent`"
  ([^. this ^javax.swing.event.TreeExpansionEvent event]
    (-> this (.treeCollapsed event))))

