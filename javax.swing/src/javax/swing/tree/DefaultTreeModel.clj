(ns javax.swing.tree.DefaultTreeModel
  "A simple tree data model that uses TreeNodes.
  For further information and examples that use DefaultTreeModel,
  see How to Use Trees
  in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree DefaultTreeModel]))

(defn ->default-tree-model
  "Constructor.

  Creates a tree specifying whether any node can have children,
   or whether only certain nodes can have children.

  root - a TreeNode object that is the root of the tree - `javax.swing.tree.TreeNode`
  asks-allows-children - a boolean, false if any node can have children, true if each node is asked to see if it can have children - `boolean`"
  ([^javax.swing.tree.TreeNode root ^Boolean asks-allows-children]
    (new DefaultTreeModel root asks-allows-children))
  ([^javax.swing.tree.TreeNode root]
    (new DefaultTreeModel root)))

(defn set-asks-allows-children
  "Sets whether or not to test leafness by asking getAllowsChildren()
   or isLeaf() to the TreeNodes.  If newvalue is true, getAllowsChildren()
   is messaged, otherwise isLeaf() is messaged.

  new-value - `boolean`"
  ([^javax.swing.tree.DefaultTreeModel this ^Boolean new-value]
    (-> this (.setAsksAllowsChildren new-value))))

(defn nodes-were-removed
  "Invoke this method after you've removed some TreeNodes from
   node.  childIndices should be the index of the removed elements and
   must be sorted in ascending order. And removedChildren should be
   the array of the children objects that were removed.

  node - `javax.swing.tree.TreeNode`
  child-indices - `int[]`
  removed-children - `java.lang.Object[]`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node child-indices removed-children]
    (-> this (.nodesWereRemoved node child-indices removed-children))))

(defn get-child-count
  "Returns the number of children of parent.  Returns 0 if the node
   is a leaf or if it has no children.  parent must be a node
   previously obtained from this data source.

  parent - a node in the tree, obtained from this data source - `java.lang.Object`

  returns: the number of children of the node parent - `int`"
  (^Integer [^javax.swing.tree.DefaultTreeModel this ^java.lang.Object parent]
    (-> this (.getChildCount parent))))

(defn remove-tree-model-listener
  "Removes a listener previously added with addTreeModelListener().

  l - the listener to remove - `javax.swing.event.TreeModelListener`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.event.TreeModelListener l]
    (-> this (.removeTreeModelListener l))))

(defn remove-node-from-parent
  "Message this to remove node from its parent. This will message
   nodesWereRemoved to create the appropriate event. This is the
   preferred way to remove a node as it handles the event creation
   for you.

  node - `javax.swing.tree.MutableTreeNode`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.MutableTreeNode node]
    (-> this (.removeNodeFromParent node))))

(defn get-tree-model-listeners
  "Returns an array of all the tree model listeners
   registered on this model.

  returns: all of this model's TreeModelListeners
           or an empty
           array if no tree model listeners are currently registered - `javax.swing.event.TreeModelListener[]`"
  ([^javax.swing.tree.DefaultTreeModel this]
    (-> this (.getTreeModelListeners))))

(defn leaf?
  "Returns whether the specified node is a leaf node.
   The way the test is performed depends on the
   askAllowsChildren setting.

  node - the node to check - `java.lang.Object`

  returns: true if the node is a leaf node - `boolean`"
  (^Boolean [^javax.swing.tree.DefaultTreeModel this ^java.lang.Object node]
    (-> this (.isLeaf node))))

(defn get-index-of-child
  "Returns the index of child in parent.
   If either the parent or child is null, returns -1.

  parent - a note in the tree, obtained from this data source - `java.lang.Object`
  child - the node we are interested in - `java.lang.Object`

  returns: the index of the child in the parent, or -1
      if either the parent or the child is null - `int`"
  (^Integer [^javax.swing.tree.DefaultTreeModel this ^java.lang.Object parent ^java.lang.Object child]
    (-> this (.getIndexOfChild parent child))))

(defn node-structure-changed
  "Invoke this method if you've totally changed the children of
   node and its children's children...  This will post a
   treeStructureChanged event.

  node - `javax.swing.tree.TreeNode`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node]
    (-> this (.nodeStructureChanged node))))

(defn get-root
  "Returns the root of the tree.  Returns null only if the tree has
   no nodes.

  returns: the root of the tree - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.tree.DefaultTreeModel this]
    (-> this (.getRoot))))

(defn get-path-to-root
  "Builds the parents of node up to and including the root node,
   where the original node is the last element in the returned array.
   The length of the returned array gives the node's depth in the
   tree.

  a-node - the TreeNode to get the path for - `javax.swing.tree.TreeNode`

  returns: `javax.swing.tree.TreeNode[]`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode a-node]
    (-> this (.getPathToRoot a-node))))

(defn get-child
  "Returns the child of parent at index index in the parent's
   child array.  parent must be a node previously obtained from
   this data source. This should not return null if index
   is a valid index for parent (that is index >= 0 &&
   index < getChildCount(parent)).

  parent - a node in the tree, obtained from this data source - `java.lang.Object`
  index - `int`

  returns: the child of parent at index index - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.tree.DefaultTreeModel this ^java.lang.Object parent ^Integer index]
    (-> this (.getChild parent index))))

(defn reload
  "Invoke this method if you've modified the TreeNodes upon which
   this model depends. The model will notify all of its listeners that the
   model has changed below the given node.

  node - the node below which the model has changed - `javax.swing.tree.TreeNode`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node]
    (-> this (.reload node)))
  ([^javax.swing.tree.DefaultTreeModel this]
    (-> this (.reload))))

(defn node-changed
  "Invoke this method after you've changed how node is to be
   represented in the tree.

  node - `javax.swing.tree.TreeNode`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node]
    (-> this (.nodeChanged node))))

(defn nodes-changed
  "Invoke this method after you've changed how the children identified by
   childIndicies are to be represented in the tree.

  node - `javax.swing.tree.TreeNode`
  child-indices - `int[]`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node child-indices]
    (-> this (.nodesChanged node child-indices))))

(defn add-tree-model-listener
  "Adds a listener for the TreeModelEvent posted after the tree changes.

  l - the listener to add - `javax.swing.event.TreeModelListener`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.event.TreeModelListener l]
    (-> this (.addTreeModelListener l))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this model.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal,
   such as
   FooListener.class.
   For example, you can query a
   DefaultTreeModel m
   for its tree model listeners with the following code:



  TreeModelListener[] tmls = (TreeModelListener[])(m.getListeners(TreeModelListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^javax.swing.tree.DefaultTreeModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn nodes-were-inserted
  "Invoke this method after you've inserted some TreeNodes into
   node.  childIndices should be the index of the new elements and
   must be sorted in ascending order.

  node - `javax.swing.tree.TreeNode`
  child-indices - `int[]`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode node child-indices]
    (-> this (.nodesWereInserted node child-indices))))

(defn asks-allows-children
  "Tells how leaf nodes are determined.

  returns: true if only nodes which do not allow children are
           leaf nodes, false if nodes which have no children
           (even if allowed) are leaf nodes - `boolean`"
  (^Boolean [^javax.swing.tree.DefaultTreeModel this]
    (-> this (.asksAllowsChildren))))

(defn set-root
  "Sets the root to root. A null root implies
   the tree is to display nothing, and is legal.

  root - `javax.swing.tree.TreeNode`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreeNode root]
    (-> this (.setRoot root))))

(defn value-for-path-changed
  "This sets the user object of the TreeNode identified by path
   and posts a node changed.  If you use custom user objects in
   the TreeModel you're going to need to subclass this and
   set the user object of the changed node to something meaningful.

  path - path to the node that the user has altered - `javax.swing.tree.TreePath`
  new-value - the new value from the TreeCellEditor - `java.lang.Object`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.TreePath path ^java.lang.Object new-value]
    (-> this (.valueForPathChanged path new-value))))

(defn insert-node-into
  "Invoked this to insert newChild at location index in parents children.
   This will then message nodesWereInserted to create the appropriate
   event. This is the preferred way to add children as it will create
   the appropriate event.

  new-child - `javax.swing.tree.MutableTreeNode`
  parent - `javax.swing.tree.MutableTreeNode`
  index - `int`"
  ([^javax.swing.tree.DefaultTreeModel this ^javax.swing.tree.MutableTreeNode new-child ^javax.swing.tree.MutableTreeNode parent ^Integer index]
    (-> this (.insertNodeInto new-child parent index))))

