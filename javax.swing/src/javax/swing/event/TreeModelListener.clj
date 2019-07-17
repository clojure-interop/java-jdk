(ns javax.swing.event.TreeModelListener
  "Defines the interface for an object that listens
  to changes in a TreeModel.
  For further information and examples see
  How to Write a Tree Model Listener,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeModelListener]))

(defn tree-nodes-changed
  "Invoked after a node (or a set of siblings) has changed in some
   way. The node(s) have not changed locations in the tree or
   altered their children arrays, but other attributes have
   changed and may affect presentation. Example: the name of a
   file has changed, but it is in the same location in the file
   system.
   To indicate the root has changed, childIndices and children
   will be null.

   Use e.getPath()
   to get the parent of the changed node(s).
   e.getChildIndices()
   returns the index(es) of the changed node(s).

  e - `javax.swing.event.TreeModelEvent`"
  ([^. this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesChanged e))))

(defn tree-nodes-inserted
  "Invoked after nodes have been inserted into the tree.

   Use e.getPath()
   to get the parent of the new node(s).
   e.getChildIndices()
   returns the index(es) of the new node(s)
   in ascending order.

  e - `javax.swing.event.TreeModelEvent`"
  ([^. this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesInserted e))))

(defn tree-nodes-removed
  "Invoked after nodes have been removed from the tree.  Note that
   if a subtree is removed from the tree, this method may only be
   invoked once for the root of the removed subtree, not once for
   each individual set of siblings removed.

   Use e.getPath()
   to get the former parent of the deleted node(s).
   e.getChildIndices()
   returns, in ascending order, the index(es)
   the node(s) had before being deleted.

  e - `javax.swing.event.TreeModelEvent`"
  ([^. this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesRemoved e))))

(defn tree-structure-changed
  "Invoked after the tree has drastically changed structure from a
   given node down.  If the path returned by e.getPath() is of length
   one and the first element does not identify the current root node
   the first element should become the new root of the tree.

   Use e.getPath()
   to get the path to the node.
   e.getChildIndices()
   returns null.

  e - `javax.swing.event.TreeModelEvent`"
  ([^. this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeStructureChanged e))))

