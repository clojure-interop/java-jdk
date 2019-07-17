(ns javax.swing.tree.AbstractLayoutCache
  "Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree AbstractLayoutCache]))

(defn ->abstract-layout-cache
  "Constructor."
  ([]
    (new AbstractLayoutCache )))

(defn get-row-for-path
  "Returns the row that the last item identified in path is visible
   at.  Will return -1 if any of the elements in path are not
   currently visible.

  path - the TreePath being queried - `javax.swing.tree.TreePath`

  returns: the row where the last item in path is visible or -1
           if any elements in path aren't currently visible - `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getRowForPath path))))

(defn tree-nodes-inserted
  "Invoked after nodes have been inserted into the tree.

   e.path() returns the parent of the new nodes
   e.childIndices() returns the indices of the new nodes in
   ascending order.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesInserted e))))

(defn get-node-dimensions
  "Returns the object that renders nodes in the tree, and which is
   responsible for calculating the dimensions of individual nodes.

  returns: the NodeDimensions object - `javax.swing.tree.AbstractLayoutCache.NodeDimensions`"
  (^javax.swing.tree.AbstractLayoutCache.NodeDimensions [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getNodeDimensions))))

(defn tree-nodes-removed
  "Invoked after nodes have been removed from the tree.  Note that
   if a subtree is removed from the tree, this method may only be
   invoked once for the root of the removed subtree, not once for
   each individual set of siblings removed.

   e.path() returns the former parent of the deleted nodes.

   e.childIndices() returns the indices the nodes had before they were deleted in ascending order.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesRemoved e))))

(defn expanded?
  "Returns true if the value identified by row is currently expanded.

  path - `javax.swing.tree.TreePath`

  returns: `boolean`"
  (^Boolean [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.isExpanded path))))

(defn get-row-count
  "Number of rows being displayed.

  returns: the number of rows being displayed - `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getRowCount))))

(defn root-visible?
  "Returns true if the root node of the tree is displayed.

  returns: true if the root node of the tree is displayed - `boolean`"
  (^Boolean [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.isRootVisible))))

(defn set-selection-model
  "Sets the TreeSelectionModel used to manage the
   selection to new LSM.

  new-lsm - the new TreeSelectionModel - `javax.swing.tree.TreeSelectionModel`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreeSelectionModel new-lsm]
    (-> this (.setSelectionModel new-lsm))))

(defn set-root-visible
  "Determines whether or not the root node from
   the TreeModel is visible.

  root-visible - true if the root node of the tree is to be displayed - `boolean`"
  ([^javax.swing.tree.AbstractLayoutCache this ^Boolean root-visible]
    (-> this (.setRootVisible root-visible))))

(defn set-node-dimensions
  "Sets the renderer that is responsible for drawing nodes in the tree
   and which is therefore responsible for calculating the dimensions of
   individual nodes.

  nd - a NodeDimensions object - `javax.swing.tree.AbstractLayoutCache.NodeDimensions`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.AbstractLayoutCache.NodeDimensions nd]
    (-> this (.setNodeDimensions nd))))

(defn get-selection-model
  "Returns the model used to maintain the selection.

  returns: the treeSelectionModel - `javax.swing.tree.TreeSelectionModel`"
  (^javax.swing.tree.TreeSelectionModel [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getSelectionModel))))

(defn get-visible-child-count
  "Returns the number of visible children for row.

  path - the path being queried - `javax.swing.tree.TreePath`

  returns: the number of visible children for the specified path - `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
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
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeNodesChanged e))))

(defn invalidate-path-bounds
  "Instructs the LayoutCache that the bounds for
   path are invalid, and need to be updated.

  path - the path being updated - `javax.swing.tree.TreePath`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.invalidatePathBounds path))))

(defn get-visible-paths-from
  "Returns an Enumerator that increments over the visible
   paths starting at the passed in location. The ordering of the
   enumeration is based on how the paths are displayed.
   The first element of the returned enumeration will be path,
   unless it isn't visible,
   in which case null will be returned.

  path - the starting location for the enumeration - `javax.swing.tree.TreePath`

  returns: the Enumerator starting at the desired location - `java.util.Enumeration<javax.swing.tree.TreePath>`"
  (^java.util.Enumeration [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getVisiblePathsFrom path))))

(defn get-rows-for-paths
  "Returns the rows that the TreePath instances in
   path are being displayed at.
   This method should return an array of the same length as that passed
   in, and if one of the TreePaths
   in path is not valid its entry in the array should
   be set to -1.

  paths - the array of TreePaths being queried - `javax.swing.tree.TreePath[]`

  returns: an array of the same length that is passed in containing
            the rows that each corresponding where each
            TreePath is displayed; if paths
            is null, null is returned - `int[]`"
  ([^javax.swing.tree.AbstractLayoutCache this paths]
    (-> this (.getRowsForPaths paths))))

(defn tree-structure-changed
  "Invoked after the tree has drastically changed structure from a
   given node down.  If the path returned by e.getPath()
   is of length one and the first element does not identify the
   current root node the first element should become the new root
   of the tree.

   e.path() holds the path to the node.
   e.childIndices() returns null.

  e - the TreeModelEvent - `javax.swing.event.TreeModelEvent`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.event.TreeModelEvent e]
    (-> this (.treeStructureChanged e))))

(defn get-expanded-state?
  "Returns true if the path is expanded, and visible.

  path - the path being queried - `javax.swing.tree.TreePath`

  returns: true if the path is expanded and visible, false otherwise - `boolean`"
  (^Boolean [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path]
    (-> this (.getExpandedState path))))

(defn set-row-height
  "Sets the height of each cell.  If the specified value
   is less than or equal to zero the current cell renderer is
   queried for each row's height.

  row-height - the height of each cell, in pixels - `int`"
  ([^javax.swing.tree.AbstractLayoutCache this ^Integer row-height]
    (-> this (.setRowHeight row-height))))

(defn get-path-for-row
  "Returns the path for passed in row.  If row is not visible
   null is returned.

  row - the row being queried - `int`

  returns: the TreePath for the given row - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^javax.swing.tree.AbstractLayoutCache this ^Integer row]
    (-> this (.getPathForRow row))))

(defn get-bounds
  "Returns a rectangle giving the bounds needed to draw path.

  path - a TreePath specifying a node - `javax.swing.tree.TreePath`
  place-in - a Rectangle object giving the available space - `java.awt.Rectangle`

  returns: a Rectangle object specifying the space to be used - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path ^java.awt.Rectangle place-in]
    (-> this (.getBounds path place-in))))

(defn set-expanded-state
  "Marks the path path expanded state to
   isExpanded.

  path - the path being expanded or collapsed - `javax.swing.tree.TreePath`
  is-expanded - true if the path should be expanded, false otherwise - `boolean`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreePath path ^Boolean is-expanded]
    (-> this (.setExpandedState path is-expanded))))

(defn get-model
  "Returns the TreeModel that is providing the data.

  returns: the TreeModel that is providing the data - `javax.swing.tree.TreeModel`"
  (^javax.swing.tree.TreeModel [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getModel))))

(defn get-preferred-height
  "Returns the preferred height.

  returns: the preferred height - `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getPreferredHeight))))

(defn set-model
  "Sets the TreeModel that will provide the data.

  new-model - the TreeModel that is to provide the data - `javax.swing.tree.TreeModel`"
  ([^javax.swing.tree.AbstractLayoutCache this ^javax.swing.tree.TreeModel new-model]
    (-> this (.setModel new-model))))

(defn invalidate-sizes
  "Informs the TreeState that it needs to recalculate
   all the sizes it is referencing."
  ([^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.invalidateSizes))))

(defn get-path-closest-to
  "Returns the path to the node that is closest to x,y.  If
   there is nothing currently visible this will return null,
   otherwise it'll always return a valid path.
   If you need to test if the
   returned object is exactly at x, y you should get the bounds for
   the returned path and test x, y against that.

  x - the horizontal component of the desired location - `int`
  y - the vertical component of the desired location - `int`

  returns: the TreePath closest to the specified point - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^javax.swing.tree.AbstractLayoutCache this ^Integer x ^Integer y]
    (-> this (.getPathClosestTo x y))))

(defn get-row-height
  "Returns the height of each row.  If the returned value is less than
   or equal to 0 the height for each row is determined by the
   renderer.

  returns: `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this]
    (-> this (.getRowHeight))))

(defn get-preferred-width
  "Returns the preferred width for the passed in region.
   The region is defined by the path closest to
   (bounds.x, bounds.y) and
   ends at bounds.height  bounds.y.
   If bounds is null,
   the preferred width for all the nodes
   will be returned (and this may be a VERY expensive
   computation).

  bounds - the region being queried - `java.awt.Rectangle`

  returns: the preferred width for the passed in region - `int`"
  (^Integer [^javax.swing.tree.AbstractLayoutCache this ^java.awt.Rectangle bounds]
    (-> this (.getPreferredWidth bounds))))

