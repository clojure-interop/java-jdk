(ns javax.swing.tree.FixedHeightLayoutCache
  "NOTE: This will become more open in a future release.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree FixedHeightLayoutCache]))

(defn ->fixed-height-layout-cache
  "Constructor."
  (^FixedHeightLayoutCache []
    (new FixedHeightLayoutCache )))

(defn get-row-for-path
  "Returns the row that the last item identified in path is visible
   at.  Will return -1 if any of the elements in path are not
   currently visible.

  path - the TreePath being queried - `javax.swing.tree.TreePath`

  returns: the row where the last item in path is visible or -1
           if any elements in path aren't currently visible - `int`"
  (^Integer [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getRowForPath path))))

(defn tree-nodes-inserted
  "Invoked after nodes have been inserted into the tree.

   e.path() returns the parent of the new nodes
   e.childIndices() returns the indices of the new nodes in
   ascending order.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^FixedHeightLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesInserted e))))

(defn tree-nodes-removed
  "Invoked after nodes have been removed from the tree.  Note that
   if a subtree is removed from the tree, this method may only be
   invoked once for the root of the removed subtree, not once for
   each individual set of siblings removed.

   e.path() returns the former parent of the deleted nodes.

   e.childIndices() returns the indices the nodes had before they were deleted in ascending order.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^FixedHeightLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesRemoved e))))

(defn expanded?
  "Returns true if the value identified by row is currently expanded.

  path - `javax.swing.tree.TreePath`

  returns: `boolean`"
  (^Boolean [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.isExpanded path))))

(defn get-row-count
  "Returns the number of visible rows.

  returns: the number of rows being displayed - `int`"
  (^Integer [^FixedHeightLayoutCache this]
    (-> this (.getRowCount))))

(defn set-root-visible
  "Determines whether or not the root node from
   the TreeModel is visible.

  root-visible - true if the root node of the tree is to be displayed - `boolean`"
  ([^FixedHeightLayoutCache this ^Boolean root-visible]
    (-> this (.setRootVisible root-visible))))

(defn get-visible-child-count
  "Returns the number of visible children for row.

  path - the path being queried - `javax.swing.tree.TreePath`

  returns: the number of visible children for the specified path - `int`"
  (^Integer [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getVisibleChildCount path))))

(defn tree-nodes-changed
  "Invoked after a node (or a set of siblings) has changed in some
   way. The node(s) have not changed locations in the tree or
   altered their children arrays, but other attributes have
   changed and may affect presentation. Example: the name of a
   file has changed, but it is in the same location in the file
   system.

   e.path() returns the path the parent of the changed node(s).

   e.childIndices() returns the index(es) of the changed node(s).

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^FixedHeightLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesChanged e))))

(defn invalidate-path-bounds
  "Does nothing, FixedHeightLayoutCache doesn't cache width, and that
   is all that could change.

  path - the path being updated - `javax.swing.tree.TreePath`"
  ([^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.invalidatePathBounds path))))

(defn get-visible-paths-from
  "Returns an Enumerator that increments over the visible paths
   starting at the passed in location. The ordering of the enumeration
   is based on how the paths are displayed.

  path - the starting location for the enumeration - `javax.swing.tree.TreePath`

  returns: the Enumerator starting at the desired location - `java.util.Enumeration<javax.swing.tree.TreePath>`"
  (^java.util.Enumeration [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getVisiblePathsFrom path))))

(defn tree-structure-changed
  "Invoked after the tree has drastically changed structure from a
   given node down.  If the path returned by e.getPath() is of length
   one and the first element does not identify the current root node
   the first element should become the new root of the tree.

   e.path() holds the path to the node.
   e.childIndices() returns null.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^FixedHeightLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeStructureChanged e))))

(defn get-expanded-state?
  "Returns true if the path is expanded, and visible.

  path - the path being queried - `javax.swing.tree.TreePath`

  returns: true if the path is expanded and visible, false otherwise - `boolean`"
  (^Boolean [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getExpandedState path))))

(defn set-row-height
  "Sets the height of each cell. If rowHeight is less than or equal to
   0 this will throw an IllegalArgumentException.

  row-height - the height of each cell, in pixels - `int`"
  ([^FixedHeightLayoutCache this ^Integer row-height]
    (-> this (.setRowHeight row-height))))

(defn get-path-for-row
  "Returns the path for passed in row.  If row is not visible
   null is returned.

  row - the row being queried - `int`

  returns: the TreePath for the given row - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^FixedHeightLayoutCache this ^Integer row]
    (-> this (.getPathForRow row))))

(defn get-bounds
  "Returns a rectangle giving the bounds needed to draw path.

  path - a TreePath specifying a node - `javax.swing.tree.TreePath`
  place-in - a Rectangle object giving the available space - `java.awt.Rectangle`

  returns: a Rectangle object specifying the space to be used - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path ^java.awt.Rectangle place-in]
    (-> this (.getBounds path place-in))))

(defn set-expanded-state
  "Marks the path path expanded state to
   isExpanded.

  path - the path being expanded or collapsed - `javax.swing.tree.TreePath`
  is-expanded - true if the path should be expanded, false otherwise - `boolean`"
  ([^FixedHeightLayoutCache this ^javax.swing.tree.TreePath path ^Boolean is-expanded]
    (-> this (.setExpandedState path is-expanded))))

(defn set-model
  "Sets the TreeModel that will provide the data.

  new-model - the TreeModel that is to provide the data - `javax.swing.tree.TreeModel`"
  ([^FixedHeightLayoutCache this ^javax.swing.tree.TreeModel new-model]
    (-> this (.setModel new-model))))

(defn invalidate-sizes
  "Informs the TreeState that it needs to recalculate all the sizes
   it is referencing."
  ([^FixedHeightLayoutCache this]
    (-> this (.invalidateSizes))))

(defn get-path-closest-to
  "Returns the path to the node that is closest to x,y.  If
   there is nothing currently visible this will return null, otherwise
   it'll always return a valid path.  If you need to test if the
   returned object is exactly at x, y you should get the bounds for
   the returned path and test x, y against that.

  x - the horizontal component of the desired location - `int`
  y - the vertical component of the desired location - `int`

  returns: the TreePath closest to the specified point - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^FixedHeightLayoutCache this ^Integer x ^Integer y]
    (-> this (.getPathClosestTo x y))))

