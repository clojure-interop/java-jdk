(ns javax.swing.tree.TreePath
  "TreePath represents an array of objects that uniquely
  identify the path to a node in a tree. The elements of the array
  are ordered with the root as the first element of the array. For
  example, a file on the file system is uniquely identified based on
  the array of parent directories and the name of the file. The path
  /tmp/foo/bar could be represented by a TreePath as
  new TreePath(new Object[] {`tmp`, `foo`, `bar`}).

  TreePath is used extensively by JTree and related classes.
  For example, JTree represents the selection as an array of
  TreePaths. When used with JTree, the elements of the
  path are the objects returned from the TreeModel. When JTree
  is paired with DefaultTreeModel, the elements of the
  path are TreeNodes. The following example illustrates extracting
  the user object from the selection of a JTree:


    DefaultMutableTreeNode root = ...;
    DefaultTreeModel model = new DefaultTreeModel(root);
    JTree tree = new JTree(model);
    ...
    TreePath selectedPath = tree.getSelectionPath();
    DefaultMutableTreeNode selectedNode =
        ((DefaultMutableTreeNode)selectedPath.getLastPathComponent()).
        getUserObject();
  Subclasses typically need override only getLastPathComponent, and getParentPath. As JTree
  internally creates TreePaths at various points, it's
  generally not useful to subclass TreePath and use with
  JTree.

  While TreePath is serializable, a NotSerializableException is thrown if any elements of the path are
  not serializable.

  For further information and examples of using tree paths,
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
  (:import [javax.swing.tree TreePath]))

(defn ->tree-path
  "Constructor.

  Creates a TreePath from an array. The array uniquely
   identifies the path to a node.

  path - an array of objects representing the path to a node - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - if path is null, empty, or contains a null value"
  ([^java.lang.Object[] path]
    (new TreePath path)))

(defn get-path-count
  "Returns the number of elements in the path.

  returns: the number of elements in the path - `int`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.getPathCount))))

(defn get-parent-path
  "Returns the TreePath of the parent. A return value of
   null indicates this is the root node.

  returns: the parent path - `javax.swing.tree.TreePath`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.getParentPath))))

(defn path-by-adding-child
  "Returns a new path containing all the elements of this path
   plus child. child is the last element
   of the newly created TreePath.

  child - the path element to add - `java.lang.Object`

  returns: `javax.swing.tree.TreePath`

  throws: java.lang.NullPointerException - if child is null"
  ([^javax.swing.tree.TreePath this ^java.lang.Object child]
    (-> this (.pathByAddingChild child))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.toString))))

(defn get-path
  "Returns an ordered array of the elements of this TreePath.
   The first element is the root.

  returns: an array of the elements in this TreePath - `java.lang.Object[]`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.getPath))))

(defn get-path-component
  "Returns the path element at the specified index.

  index - the index of the element requested - `int`

  returns: the element at the specified index - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the index is outside the range of this path"
  ([^javax.swing.tree.TreePath this ^Integer index]
    (-> this (.getPathComponent index))))

(defn hash-code
  "Returns the hash code of this TreePath. The hash code of a
   TreePath is the hash code of the last element in the path.

  returns: the hashCode for the object - `int`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.hashCode))))

(defn descendant?
  "Returns true if aTreePath is a
   descendant of this
   TreePath. A TreePath P1 is a descendant of a
   TreePath P2
   if P1 contains all of the elements that make up
   P2's path.
   For example, if this object has the path [a, b],
   and aTreePath has the path [a, b, c],
   then aTreePath is a descendant of this object.
   However, if aTreePath has the path [a],
   then it is not a descendant of this object.  By this definition
   a TreePath is always considered a descendant of itself.
   That is, aTreePath.isDescendant(aTreePath) returns
   true.

  a-tree-path - the TreePath to check - `javax.swing.tree.TreePath`

  returns: true if aTreePath is a descendant of this path - `boolean`"
  ([^javax.swing.tree.TreePath this ^javax.swing.tree.TreePath a-tree-path]
    (-> this (.isDescendant a-tree-path))))

(defn get-last-path-component
  "Returns the last element of this path.

  returns: the last element in the path - `java.lang.Object`"
  ([^javax.swing.tree.TreePath this]
    (-> this (.getLastPathComponent))))

(defn equals
  "Compares this TreePath to the specified object. This returns
   true if o is a TreePath with the exact
   same elements (as determined by using equals on each
   element of the path).

  o - the object to compare - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^javax.swing.tree.TreePath this ^java.lang.Object o]
    (-> this (.equals o))))

