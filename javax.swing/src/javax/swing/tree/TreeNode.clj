(ns javax.swing.tree.TreeNode
  "Defines the requirements for an object that can be used as a
  tree node in a JTree.

  Implementations of TreeNode that override equals
  will typically need to override hashCode as well.  Refer
  to TreeModel for more information.

  For further information and examples of using tree nodes,
  see How to Use Tree Nodes
  in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree TreeNode]))

(defn get-child-at
  "Returns the child TreeNode at index
   childIndex.

  child-index - `int`

  returns: `javax.swing.tree.TreeNode`"
  (^javax.swing.tree.TreeNode [^javax.swing.tree.TreeNode this ^Integer child-index]
    (-> this (.getChildAt child-index))))

(defn get-child-count
  "Returns the number of children TreeNodes the receiver
   contains.

  returns: `int`"
  (^Integer [^javax.swing.tree.TreeNode this]
    (-> this (.getChildCount))))

(defn get-parent
  "Returns the parent TreeNode of the receiver.

  returns: `javax.swing.tree.TreeNode`"
  (^javax.swing.tree.TreeNode [^javax.swing.tree.TreeNode this]
    (-> this (.getParent))))

(defn get-index
  "Returns the index of node in the receivers children.
   If the receiver does not contain node, -1 will be
   returned.

  node - `javax.swing.tree.TreeNode`

  returns: `int`"
  (^Integer [^javax.swing.tree.TreeNode this ^javax.swing.tree.TreeNode node]
    (-> this (.getIndex node))))

(defn get-allows-children?
  "Returns true if the receiver allows children.

  returns: `boolean`"
  (^Boolean [^javax.swing.tree.TreeNode this]
    (-> this (.getAllowsChildren))))

(defn leaf?
  "Returns true if the receiver is a leaf.

  returns: `boolean`"
  (^Boolean [^javax.swing.tree.TreeNode this]
    (-> this (.isLeaf))))

(defn children
  "Returns the children of the receiver as an Enumeration.

  returns: `java.util.Enumeration`"
  (^java.util.Enumeration [^javax.swing.tree.TreeNode this]
    (-> this (.children))))

