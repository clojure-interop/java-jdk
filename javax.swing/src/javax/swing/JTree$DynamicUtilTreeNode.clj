(ns javax.swing.JTree$DynamicUtilTreeNode
  "DynamicUtilTreeNode can wrap
  vectors/hashtables/arrays/strings and
  create the appropriate children tree nodes as necessary. It is
  dynamic in that it will only create the children as necessary.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTree$DynamicUtilTreeNode]))

(defn ->dynamic-util-tree-node
  "Constructor.

  Creates a node with the specified object as its value and
   with the specified children. For the node to allow children,
   the children-object must be an array of objects, a
   Vector, or a Hashtable -- even
   if empty. Otherwise, the node is not
   allowed to have children.

  value - the Object that is the value for the new node - `java.lang.Object`
  children - an array of Objects, a Vector, or a Hashtable used to create the child nodes; if any other object is specified, or if the value is null, then the node is not allowed to have children - `java.lang.Object`"
  ([^java.lang.Object value ^java.lang.Object children]
    (new JTree$DynamicUtilTreeNode value children)))

(defn *create-children
  "Adds to parent all the children in children.
   If children is an array or vector all of its
   elements are added is children, otherwise if children
   is a hashtable all the key/value pairs are added in the order
   Enumeration returns them.

  parent - `javax.swing.tree.DefaultMutableTreeNode`
  children - `java.lang.Object`"
  ([^javax.swing.tree.DefaultMutableTreeNode parent ^java.lang.Object children]
    (JTree$DynamicUtilTreeNode/createChildren parent children)))

(defn leaf?
  "Returns true if this node allows children. Whether the node
   allows children depends on how it was created.

  returns: true if this node allows children, false otherwise - `boolean`"
  (^Boolean [^javax.swing.JTree$DynamicUtilTreeNode this]
    (-> this (.isLeaf))))

(defn get-child-count
  "Returns the number of child nodes.

  returns: the number of child nodes - `int`"
  (^Integer [^javax.swing.JTree$DynamicUtilTreeNode this]
    (-> this (.getChildCount))))

(defn get-child-at
  "Subclassed to load the children, if necessary.

  index - an index into this node's child array - `int`

  returns: the TreeNode in this node's child array at  the specified index - `javax.swing.tree.TreeNode`"
  (^javax.swing.tree.TreeNode [^javax.swing.JTree$DynamicUtilTreeNode this ^Integer index]
    (-> this (.getChildAt index))))

(defn children
  "Subclassed to load the children, if necessary.

  returns: an Enumeration of this node's children - `java.util.Enumeration`"
  (^java.util.Enumeration [^javax.swing.JTree$DynamicUtilTreeNode this]
    (-> this (.children))))

