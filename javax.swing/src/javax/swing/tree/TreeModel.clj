(ns javax.swing.tree.TreeModel
  "The model used by JTree.

  JTree and its related classes make extensive use of
  TreePaths for identifying nodes in the TreeModel.
  If a TreeModel returns the same object, as compared by
  equals, at two different indices under the same parent
  than the resulting TreePath objects will be considered equal
  as well. Some implementations may assume that if two
  TreePaths are equal, they identify the same node. If this
  condition is not met, painting problems and other oddities may result.
  In other words, if getChild for a given parent returns
  the same Object (as determined by equals) problems may
  result, and it is recommended you avoid doing this.

  Similarly JTree and its related classes place
  TreePaths in Maps.  As such if
  a node is requested twice, the return values must be equal
  (using the equals method) and have the same
  hashCode.

  For further information on tree models,
  including an example of a custom implementation,
  see How to Use Trees
  in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree TreeModel]))

(defn get-root
  "Returns the root of the tree.  Returns null
   only if the tree has no nodes.

  returns: the root of the tree - `java.lang.Object`"
  ([^. this]
    (-> this (.getRoot))))

(defn get-child
  "Returns the child of parent at index index
   in the parent's
   child array.  parent must be a node previously obtained
   from this data source. This should not return null
   if index
   is a valid index for parent (that is index >= 0 &&
   index < getChildCount(parent)).

  parent - a node in the tree, obtained from this data source - `java.lang.Object`
  index - `int`

  returns: the child of parent at index index - `java.lang.Object`"
  ([^. this ^java.lang.Object parent ^Integer index]
    (-> this (.getChild parent index))))

(defn get-child-count
  "Returns the number of children of parent.
   Returns 0 if the node
   is a leaf or if it has no children.  parent must be a node
   previously obtained from this data source.

  parent - a node in the tree, obtained from this data source - `java.lang.Object`

  returns: the number of children of the node parent - `int`"
  ([^. this ^java.lang.Object parent]
    (-> this (.getChildCount parent))))

(defn leaf?
  "Returns true if node is a leaf.
   It is possible for this method to return false
   even if node has no children.
   A directory in a filesystem, for example,
   may contain no files; the node representing
   the directory is not a leaf, but it also has no children.

  node - a node in the tree, obtained from this data source - `java.lang.Object`

  returns: true if node is a leaf - `boolean`"
  ([^. this ^java.lang.Object node]
    (-> this (.isLeaf node))))

(defn value-for-path-changed
  "Messaged when the user has altered the value for the item identified
   by path to newValue.
   If newValue signifies a truly new value
   the model should post a treeNodesChanged event.

  path - path to the node that the user has altered - `javax.swing.tree.TreePath`
  new-value - the new value from the TreeCellEditor - `java.lang.Object`"
  ([^. this ^javax.swing.tree.TreePath path ^java.lang.Object new-value]
    (-> this (.valueForPathChanged path new-value))))

(defn get-index-of-child
  "Returns the index of child in parent.  If either parent
   or child is null, returns -1.
   If either parent or child don't
   belong to this tree model, returns -1.

  parent - a node in the tree, obtained from this data source - `java.lang.Object`
  child - the node we are interested in - `java.lang.Object`

  returns: the index of the child in the parent, or -1 if either
      child or parent are null
      or don't belong to this tree model - `int`"
  ([^. this ^java.lang.Object parent ^java.lang.Object child]
    (-> this (.getIndexOfChild parent child))))

(defn add-tree-model-listener
  "Adds a listener for the TreeModelEvent
   posted after the tree changes.

  l - the listener to add - `javax.swing.event.TreeModelListener`"
  ([^. this ^javax.swing.event.TreeModelListener l]
    (-> this (.addTreeModelListener l))))

(defn remove-tree-model-listener
  "Removes a listener previously added with
   addTreeModelListener.

  l - the listener to remove - `javax.swing.event.TreeModelListener`"
  ([^. this ^javax.swing.event.TreeModelListener l]
    (-> this (.removeTreeModelListener l))))

