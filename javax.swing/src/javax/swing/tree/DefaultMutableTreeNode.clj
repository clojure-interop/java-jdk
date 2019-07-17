(ns javax.swing.tree.DefaultMutableTreeNode
  "A DefaultMutableTreeNode is a general-purpose node in a tree data
  structure.
  For examples of using default mutable tree nodes, see
  How to Use Trees
  in The Java Tutorial.



  A tree node may have at most one parent and 0 or more children.
  DefaultMutableTreeNode provides operations for examining and modifying a
  node's parent and children and also operations for examining the tree that
  the node is a part of.  A node's tree is the set of all nodes that can be
  reached by starting at the node and following all the possible links to
  parents and children.  A node with no parent is the root of its tree; a
  node with no children is a leaf.  A tree may consist of many subtrees,
  each node acting as the root for its own subtree.

  This class provides enumerations for efficiently traversing a tree or
  subtree in various orders or for following the path between two nodes.
  A DefaultMutableTreeNode may also hold a reference to a user object, the
  use of which is left to the user.  Asking a DefaultMutableTreeNode for its
  string representation with toString() returns the string
  representation of its user object.

  This is not a thread safe class.If you intend to use
  a DefaultMutableTreeNode (or a tree of TreeNodes) in more than one thread, you
  need to do your own synchronizing. A good convention to adopt is
  synchronizing on the root node of a tree.

  While DefaultMutableTreeNode implements the MutableTreeNode interface and
  will allow you to add in any implementation of MutableTreeNode not all
  of the methods in DefaultMutableTreeNode will be applicable to all
  MutableTreeNodes implementations. Especially with some of the enumerations
  that are provided, using some of these methods assumes the
  DefaultMutableTreeNode contains only DefaultMutableNode instances. All
  of the TreeNode/MutableTreeNode methods will behave as defined no
  matter what implementations are added.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree DefaultMutableTreeNode]))

(defn ->default-mutable-tree-node
  "Constructor.

  Creates a tree node with no parent, no children, initialized with
   the specified user object, and that allows children only if
   specified.

  user-object - an Object provided by the user that constitutes the node's data - `java.lang.Object`
  allows-children - if true, the node is allowed to have child nodes -- otherwise, it is always a leaf node - `boolean`"
  ([user-object allows-children]
    (new DefaultMutableTreeNode user-object allows-children))
  ([user-object]
    (new DefaultMutableTreeNode user-object))
  ([]
    (new DefaultMutableTreeNode )))

(def *-empty-enumeration
  "Static Constant.

  An enumeration that is always empty. This is used when an enumeration
   of a leaf node's children is requested.

  type: java.util.Enumeration<javax.swing.tree.TreeNode>"
  DefaultMutableTreeNode/EMPTY_ENUMERATION)

(defn get-allows-children?
  "Returns true if this node is allowed to have children.

  returns: true if this node allows children, else false - `boolean`"
  ([this]
    (-> this (.getAllowsChildren))))

(defn get-user-object-path
  "Returns the user object path, from the root, to get to this node.
   If some of the TreeNodes in the path have null user objects, the
   returned path will contain nulls.

  returns: `java.lang.Object[]`"
  ([this]
    (-> this (.getUserObjectPath))))

(defn set-user-object
  "Sets the user object for this node to userObject.

  user-object - the Object that constitutes this node's user-specified data - `java.lang.Object`"
  ([this user-object]
    (-> this (.setUserObject user-object))))

(defn depth-first-enumeration
  "Creates and returns an enumeration that traverses the subtree rooted at
   this node in depth-first order.  The first node returned by the
   enumeration's nextElement() method is the leftmost leaf.
   This is the same as a postorder traversal.

   Modifying the tree by inserting, removing, or moving a node invalidates
   any enumerations created before the modification.

  returns: an enumeration for traversing the tree in depth-first order - `java.util.Enumeration`"
  ([this]
    (-> this (.depthFirstEnumeration))))

(defn set-parent
  "Sets this node's parent to newParent but does not
   change the parent's child array.  This method is called from
   insert() and remove() to
   reassign a child's parent, it should not be messaged from anywhere
   else.

  new-parent - this node's new parent - `javax.swing.tree.MutableTreeNode`"
  ([this new-parent]
    (-> this (.setParent new-parent))))

(defn get-child-count
  "Returns the number of children of this node.

  returns: an int giving the number of children of this node - `int`"
  ([this]
    (-> this (.getChildCount))))

(defn node-ancestor?
  "Returns true if anotherNode is an ancestor of this node
   -- if it is this node, this node's parent, or an ancestor of this
   node's parent.  (Note that a node is considered an ancestor of itself.)
   If anotherNode is null, this method returns false.  This
   operation is at worst O(h) where h is the distance from the root to
   this node.

  another-node - node to test as an ancestor of this node - `javax.swing.tree.TreeNode`

  returns: true if this node is a descendant of anotherNode - `boolean`"
  ([this another-node]
    (-> this (.isNodeAncestor another-node))))

(defn get-previous-node
  "Returns the node that precedes this node in a preorder traversal of
   this node's tree.  Returns null if this node is the
   first node of the traversal -- the root of the tree.
   This is an inefficient way to
   traverse the entire tree; use an enumeration, instead.

  returns: the node that precedes this node in a preorder traversal, or
            null if this node is the first - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getPreviousNode))))

(defn get-last-leaf
  "Finds and returns the last leaf that is a descendant of this node --
   either this node or its last child's last leaf.
   Returns this node if it is a leaf.

  returns: the last leaf in the subtree rooted at this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getLastLeaf))))

(defn get-index
  "Returns the index of the specified child in this node's child array.
   If the specified node is not a child of this node, returns
   -1.  This method performs a linear search and is O(n)
   where n is the number of children.

  a-child - the TreeNode to search for among this node's children - `javax.swing.tree.TreeNode`

  returns: an int giving the index of the node in this node's child
            array, or -1 if the specified node is a not
            a child of this node - `int`

  throws: java.lang.IllegalArgumentException - if aChild is null"
  ([this a-child]
    (-> this (.getIndex a-child))))

(defn get-next-node
  "Returns the node that follows this node in a preorder traversal of this
   node's tree.  Returns null if this node is the last node of the
   traversal.  This is an inefficient way to traverse the entire tree; use
   an enumeration, instead.

  returns: the node that follows this node in a preorder traversal, or
            null if this node is last - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getNextNode))))

(defn remove-all-children
  "Removes all of this node's children, setting their parents to null.
   If this node has no children, this method does nothing."
  ([this]
    (-> this (.removeAllChildren))))

(defn children
  "Creates and returns a forward-order enumeration of this node's
   children.  Modifying this node's child array invalidates any child
   enumerations created before the modification.

  returns: an Enumeration of this node's children - `java.util.Enumeration`"
  ([this]
    (-> this (.children))))

(defn postorder-enumeration
  "Creates and returns an enumeration that traverses the subtree rooted at
   this node in postorder.  The first node returned by the enumeration's
   nextElement() method is the leftmost leaf.  This is the
   same as a depth-first traversal.

   Modifying the tree by inserting, removing, or moving a node invalidates
   any enumerations created before the modification.

  returns: an enumeration for traversing the tree in postorder - `java.util.Enumeration`"
  ([this]
    (-> this (.postorderEnumeration))))

(defn get-next-sibling
  "Returns the next sibling of this node in the parent's children array.
   Returns null if this node has no parent or is the parent's last child.
   This method performs a linear search that is O(n) where n is the number
   of children; to traverse the entire array, use the parent's child
   enumeration instead.

  returns: the sibling of this node that immediately follows this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getNextSibling))))

(defn get-leaf-count
  "Returns the total number of leaves that are descendants of this node.
   If this node is a leaf, returns 1.  This method is O(n)
   where n is the number of descendants of this node.

  returns: the number of leaves beneath this node - `int`"
  ([this]
    (-> this (.getLeafCount))))

(defn to-string
  "Returns the result of sending toString() to this node's
   user object, or the empty string if the node has no user object.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-first-leaf
  "Finds and returns the first leaf that is a descendant of this node --
   either this node or its first child's first leaf.
   Returns this node if it is a leaf.

  returns: the first leaf in the subtree rooted at this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getFirstLeaf))))

(defn node-descendant?
  "Returns true if anotherNode is a descendant of this node
   -- if it is this node, one of this node's children, or a descendant of
   one of this node's children.  Note that a node is considered a
   descendant of itself.  If anotherNode is null, returns
   false.  This operation is at worst O(h) where h is the distance from the
   root to anotherNode.

  another-node - node to test as descendant of this node - `javax.swing.tree.DefaultMutableTreeNode`

  returns: true if this node is an ancestor of anotherNode - `boolean`"
  ([this another-node]
    (-> this (.isNodeDescendant another-node))))

(defn get-child-after
  "Returns the child in this node's child array that immediately
   follows aChild, which must be a child of this node.  If
   aChild is the last child, returns null.  This method
   performs a linear search of this node's children for
   aChild and is O(n) where n is the number of children; to
   traverse the entire array of children, use an enumeration instead.

  a-child - `javax.swing.tree.TreeNode`

  returns: the child of this node that immediately follows
            aChild - `javax.swing.tree.TreeNode`

  throws: java.lang.IllegalArgumentException - if aChild is null or is not a child of this node"
  ([this a-child]
    (-> this (.getChildAfter a-child))))

(defn get-path
  "Returns the path from the root, to get to this node.  The last
   element in the path is this node.

  returns: an array of TreeNode objects giving the path, where the
           first element in the path is the root and the last
           element is this node. - `javax.swing.tree.TreeNode[]`"
  ([this]
    (-> this (.getPath))))

(defn get-last-child
  "Returns this node's last child.  If this node has no children,
   throws NoSuchElementException.

  returns: the last child of this node - `javax.swing.tree.TreeNode`

  throws: java.util.NoSuchElementException - if this node has no children"
  ([this]
    (-> this (.getLastChild))))

(defn node-child?
  "Returns true if aNode is a child of this node.  If
   aNode is null, this method returns false.

  a-node - `javax.swing.tree.TreeNode`

  returns: true if aNode is a child of this node; false if
                    aNode is null - `boolean`"
  ([this a-node]
    (-> this (.isNodeChild a-node))))

(defn preorder-enumeration
  "Creates and returns an enumeration that traverses the subtree rooted at
   this node in preorder.  The first node returned by the enumeration's
   nextElement() method is this node.

   Modifying the tree by inserting, removing, or moving a node invalidates
   any enumerations created before the modification.

  returns: an enumeration for traversing the tree in preorder - `java.util.Enumeration`"
  ([this]
    (-> this (.preorderEnumeration))))

(defn leaf?
  "Returns true if this node has no children.  To distinguish between
   nodes that have no children and nodes that cannot have
   children (e.g. to distinguish files from empty directories), use this
   method in conjunction with getAllowsChildren

  returns: true if this node has no children - `boolean`"
  ([this]
    (-> this (.isLeaf))))

(defn get-next-leaf
  "Returns the leaf after this node or null if this node is the
   last leaf in the tree.

   In this implementation of the MutableNode interface,
   this operation is very inefficient. In order to determine the
   next node, this method first performs a linear search in the
   parent's child-list in order to find the current node.

   That implementation makes the operation suitable for short
   traversals from a known position. But to traverse all of the
   leaves in the tree, you should use depthFirstEnumeration
   to enumerate the nodes in the tree and use isLeaf
   on each node to determine which are leaves.

  returns: returns the next leaf past this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getNextLeaf))))

(defn breadth-first-enumeration
  "Creates and returns an enumeration that traverses the subtree rooted at
   this node in breadth-first order.  The first node returned by the
   enumeration's nextElement() method is this node.

   Modifying the tree by inserting, removing, or moving a node invalidates
   any enumerations created before the modification.

  returns: an enumeration for traversing the tree in breadth-first order - `java.util.Enumeration`"
  ([this]
    (-> this (.breadthFirstEnumeration))))

(defn get-previous-leaf
  "Returns the leaf before this node or null if this node is the
   first leaf in the tree.

   In this implementation of the MutableNode interface,
   this operation is very inefficient. In order to determine the
   previous node, this method first performs a linear search in the
   parent's child-list in order to find the current node.

   That implementation makes the operation suitable for short
   traversals from a known position. But to traverse all of the
   leaves in the tree, you should use depthFirstEnumeration
   to enumerate the nodes in the tree and use isLeaf
   on each node to determine which are leaves.

  returns: returns the leaf before this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getPreviousLeaf))))

(defn get-child-before
  "Returns the child in this node's child array that immediately
   precedes aChild, which must be a child of this node.  If
   aChild is the first child, returns null.  This method
   performs a linear search of this node's children for aChild
   and is O(n) where n is the number of children.

  a-child - `javax.swing.tree.TreeNode`

  returns: the child of this node that immediately precedes
            aChild - `javax.swing.tree.TreeNode`

  throws: java.lang.IllegalArgumentException - if aChild is null or is not a child of this node"
  ([this a-child]
    (-> this (.getChildBefore a-child))))

(defn set-allows-children
  "Determines whether or not this node is allowed to have children.
   If allows is false, all of this node's children are
   removed.

   Note: By default, a node allows children.

  allows - true if this node is allowed to have children - `boolean`"
  ([this allows]
    (-> this (.setAllowsChildren allows))))

(defn get-parent
  "Returns this node's parent or null if this node has no parent.

  returns: this node's parent TreeNode, or null if this node has no parent - `javax.swing.tree.TreeNode`"
  ([this]
    (-> this (.getParent))))

(defn remove
  "Removes the child at the specified index from this node's children
   and sets that node's parent to null. The child node to remove
   must be a MutableTreeNode.

  child-index - the index in this node's child array of the child to remove - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if childIndex is out of bounds"
  ([this child-index]
    (-> this (.remove child-index))))

(defn get-root
  "Returns the root of the tree that contains this node.  The root is
   the ancestor with a null parent.

  returns: the root of the tree that contains this node - `javax.swing.tree.TreeNode`"
  ([this]
    (-> this (.getRoot))))

(defn get-level
  "Returns the number of levels above this node -- the distance from
   the root to this node.  If this node is the root, returns 0.

  returns: the number of levels above this node - `int`"
  ([this]
    (-> this (.getLevel))))

(defn get-child-at
  "Returns the child at the specified index in this node's child array.

  index - an index into this node's child array - `int`

  returns: the TreeNode in this node's child array at  the specified index - `javax.swing.tree.TreeNode`

  throws: java.lang.ArrayIndexOutOfBoundsException - if index is out of bounds"
  ([this index]
    (-> this (.getChildAt index))))

(defn get-previous-sibling
  "Returns the previous sibling of this node in the parent's children
   array.  Returns null if this node has no parent or is the parent's
   first child.  This method performs a linear search that is O(n) where n
   is the number of children.

  returns: the sibling of this node that immediately precedes this node - `javax.swing.tree.DefaultMutableTreeNode`"
  ([this]
    (-> this (.getPreviousSibling))))

(defn insert
  "Removes newChild from its present parent (if it has a
   parent), sets the child's parent to this node, and then adds the child
   to this node's child array at index childIndex.
   newChild must not be null and must not be an ancestor of
   this node.

  new-child - the MutableTreeNode to insert under this node - `javax.swing.tree.MutableTreeNode`
  child-index - the index in this node's child array where this node is to be inserted - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if childIndex is out of bounds"
  ([this new-child child-index]
    (-> this (.insert new-child child-index))))

(defn clone
  "Overridden to make clone public.  Returns a shallow copy of this node;
   the new node has no parent or children and has a reference to the same
   user object, if any.

  returns: a copy of this node - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn get-sibling-count
  "Returns the number of siblings of this node.  A node is its own sibling
   (if it has no parent or no siblings, this method returns
   1).

  returns: the number of siblings of this node - `int`"
  ([this]
    (-> this (.getSiblingCount))))

(defn add
  "Removes newChild from its parent and makes it a child of
   this node by adding it to the end of this node's child array.

  new-child - node to add as a child of this node - `javax.swing.tree.MutableTreeNode`

  throws: java.lang.IllegalArgumentException - if newChild is null"
  ([this new-child]
    (-> this (.add new-child))))

(defn path-from-ancestor-enumeration
  "Creates and returns an enumeration that follows the path from
   ancestor to this node.  The enumeration's
   nextElement() method first returns ancestor,
   then the child of ancestor that is an ancestor of this
   node, and so on, and finally returns this node.  Creation of the
   enumeration is O(m) where m is the number of nodes between this node
   and ancestor, inclusive.  Each nextElement()
   message is O(1).

   Modifying the tree by inserting, removing, or moving a node invalidates
   any enumerations created before the modification.

  ancestor - `javax.swing.tree.TreeNode`

  returns: an enumeration for following the path from an ancestor of
            this node to this one - `java.util.Enumeration`

  throws: java.lang.IllegalArgumentException - if ancestor is not an ancestor of this node"
  ([this ancestor]
    (-> this (.pathFromAncestorEnumeration ancestor))))

(defn node-sibling?
  "Returns true if anotherNode is a sibling of (has the
   same parent as) this node.  A node is its own sibling.  If
   anotherNode is null, returns false.

  another-node - node to test as sibling of this node - `javax.swing.tree.TreeNode`

  returns: true if anotherNode is a sibling of this node - `boolean`"
  ([this another-node]
    (-> this (.isNodeSibling another-node))))

(defn get-shared-ancestor
  "Returns the nearest common ancestor to this node and aNode.
   Returns null, if no such ancestor exists -- if this node and
   aNode are in different trees or if aNode is
   null.  A node is considered an ancestor of itself.

  a-node - node to find common ancestor with - `javax.swing.tree.DefaultMutableTreeNode`

  returns: nearest ancestor common to this node and aNode,
            or null if none - `javax.swing.tree.TreeNode`"
  ([this a-node]
    (-> this (.getSharedAncestor a-node))))

(defn get-first-child
  "Returns this node's first child.  If this node has no children,
   throws NoSuchElementException.

  returns: the first child of this node - `javax.swing.tree.TreeNode`

  throws: java.util.NoSuchElementException - if this node has no children"
  ([this]
    (-> this (.getFirstChild))))

(defn node-related?
  "Returns true if and only if aNode is in the same tree
   as this node.  Returns false if aNode is null.

  a-node - `javax.swing.tree.DefaultMutableTreeNode`

  returns: true if aNode is in the same tree as this node;
            false if aNode is null - `boolean`"
  ([this a-node]
    (-> this (.isNodeRelated a-node))))

(defn root?
  "Returns true if this node is the root of the tree.  The root is
   the only node in the tree with a null parent; every tree has exactly
   one root.

  returns: true if this node is the root of its tree - `boolean`"
  ([this]
    (-> this (.isRoot))))

(defn get-depth
  "Returns the depth of the tree rooted at this node -- the longest
   distance from this node to a leaf.  If this node has no children,
   returns 0.  This operation is much more expensive than
   getLevel() because it must effectively traverse the entire
   tree rooted at this node.

  returns: the depth of the tree whose root is this node - `int`"
  ([this]
    (-> this (.getDepth))))

(defn get-user-object
  "Returns this node's user object.

  returns: the Object stored at this node by the user - `java.lang.Object`"
  ([this]
    (-> this (.getUserObject))))

(defn remove-from-parent
  "Removes the subtree rooted at this node from the tree, giving this
   node a null parent.  Does nothing if this node is the root of its
   tree."
  ([this]
    (-> this (.removeFromParent))))

