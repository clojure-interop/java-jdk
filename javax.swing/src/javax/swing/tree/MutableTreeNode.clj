(ns javax.swing.tree.MutableTreeNode
  "Defines the requirements for a tree node object that can change --
  by adding or removing child nodes, or by changing the contents
  of a user object stored in the node."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree MutableTreeNode]))

(defn insert
  "Adds child to the receiver at index.
   child will be messaged with setParent.

  child - `javax.swing.tree.MutableTreeNode`
  index - `int`"
  ([^javax.swing.tree.MutableTreeNode this ^javax.swing.tree.MutableTreeNode child ^Integer index]
    (-> this (.insert child index))))

(defn remove
  "Removes the child at index from the receiver.

  index - `int`"
  ([^javax.swing.tree.MutableTreeNode this ^Integer index]
    (-> this (.remove index))))

(defn set-user-object
  "Resets the user object of the receiver to object.

  object - `java.lang.Object`"
  ([^javax.swing.tree.MutableTreeNode this ^java.lang.Object object]
    (-> this (.setUserObject object))))

(defn remove-from-parent
  "Removes the receiver from its parent."
  ([^javax.swing.tree.MutableTreeNode this]
    (-> this (.removeFromParent))))

(defn set-parent
  "Sets the parent of the receiver to newParent.

  new-parent - `javax.swing.tree.MutableTreeNode`"
  ([^javax.swing.tree.MutableTreeNode this ^javax.swing.tree.MutableTreeNode new-parent]
    (-> this (.setParent new-parent))))

