(ns javax.swing.tree.TreeSelectionModel
  "This interface represents the current state of the selection for
  the tree component.
  For information and examples of using tree selection models,
  see How to Use Trees
  in The Java Tutorial.


  The state of the tree selection is characterized by
  a set of TreePaths, and optionally a set of integers. The mapping
  from TreePath to integer is done by way of an instance of RowMapper.
  It is not necessary for a TreeSelectionModel to have a RowMapper to
  correctly operate, but without a RowMapper getSelectionRows
  will return null.



  A TreeSelectionModel can be configured to allow only one
  path (SINGLE_TREE_SELECTION) a number of
  contiguous paths (CONTIGUOUS_TREE_SELECTION) or a number of
  discontiguous paths (DISCONTIGUOUS_TREE_SELECTION).
  A RowMapper is used to determine if TreePaths are
  contiguous.
  In the absence of a RowMapper CONTIGUOUS_TREE_SELECTION and
  DISCONTIGUOUS_TREE_SELECTION behave the same, that is they
  allow any number of paths to be contained in the TreeSelectionModel.



  For a selection model of CONTIGUOUS_TREE_SELECTION any
  time the paths are changed (setSelectionPath,
  addSelectionPath ...) the TreePaths are again checked to
  make they are contiguous. A check of the TreePaths can also be forced
  by invoking resetRowSelection. How a set of discontiguous
  TreePaths is mapped to a contiguous set is left to implementors of
  this interface to enforce a particular policy.



  Implementations should combine duplicate TreePaths that are
  added to the selection. For example, the following code


    TreePath[] paths = new TreePath[] { treePath, treePath };
    treeSelectionModel.setSelectionPaths(paths);
  should result in only one path being selected:
  treePath, and
  not two copies of treePath.



  The lead TreePath is the last path that was added (or set). The lead
  row is then the row that corresponds to the TreePath as determined
  from the RowMapper."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree TreeSelectionModel]))

(defn get-lead-selection-path
  "Returns the last path that was added. This may differ from the
   leadSelectionPath property maintained by the JTree.

  returns: `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^TreeSelectionModel this]
    (-> this (.getLeadSelectionPath))))

(defn get-max-selection-row
  "Returns the largest value obtained from the RowMapper for the
   current set of selected TreePaths. If nothing is selected,
   or there is no RowMapper, this will return -1.

  returns: `int`"
  (^Integer [^TreeSelectionModel this]
    (-> this (.getMaxSelectionRow))))

(defn get-selection-count
  "Returns the number of paths that are selected.

  returns: `int`"
  (^Integer [^TreeSelectionModel this]
    (-> this (.getSelectionCount))))

(defn row-selected?
  "Returns true if the row identified by row is selected.

  row - `int`

  returns: `boolean`"
  (^Boolean [^TreeSelectionModel this ^Integer row]
    (-> this (.isRowSelected row))))

(defn clear-selection
  "Empties the current selection.  If this represents a change in the
   current selection, the selection listeners are notified."
  ([^TreeSelectionModel this]
    (-> this (.clearSelection))))

(defn get-row-mapper
  "Returns the RowMapper instance that is able to map a TreePath to a
   row.

  returns: `javax.swing.tree.RowMapper`"
  (^javax.swing.tree.RowMapper [^TreeSelectionModel this]
    (-> this (.getRowMapper))))

(defn add-tree-selection-listener
  "Adds x to the list of listeners that are notified each time the
   set of selected TreePaths changes.

  x - the new listener to be added - `javax.swing.event.TreeSelectionListener`"
  ([^TreeSelectionModel this ^javax.swing.event.TreeSelectionListener x]
    (-> this (.addTreeSelectionListener x))))

(defn reset-row-selection
  "Updates this object's mapping from TreePaths to rows. This should
   be invoked when the mapping from TreePaths to integers has changed
   (for example, a node has been expanded).

   You do not normally have to call this; JTree and its associated
   listeners will invoke this for you. If you are implementing your own
   view class, then you will have to invoke this."
  ([^TreeSelectionModel this]
    (-> this (.resetRowSelection))))

(defn set-selection-path
  "Sets the selection to path. If this represents a change, then
   the TreeSelectionListeners are notified. If path is
   null, this has the same effect as invoking clearSelection.

  path - new path to select - `javax.swing.tree.TreePath`"
  ([^TreeSelectionModel this ^javax.swing.tree.TreePath path]
    (-> this (.setSelectionPath path))))

(defn remove-tree-selection-listener
  "Removes x from the list of listeners that are notified each time
   the set of selected TreePaths changes.

  x - the listener to remove - `javax.swing.event.TreeSelectionListener`"
  ([^TreeSelectionModel this ^javax.swing.event.TreeSelectionListener x]
    (-> this (.removeTreeSelectionListener x))))

(defn get-selection-paths
  "Returns the paths in the selection. This will return null (or an
   empty array) if nothing is currently selected.

  returns: `javax.swing.tree.TreePath[]`"
  ([^TreeSelectionModel this]
    (-> this (.getSelectionPaths))))

(defn get-lead-selection-row
  "Returns the lead selection index. That is the last index that was
   added.

  returns: `int`"
  (^Integer [^TreeSelectionModel this]
    (-> this (.getLeadSelectionRow))))

(defn get-selection-path
  "Returns the first path in the selection. How first is defined is
   up to implementors, and may not necessarily be the TreePath with
   the smallest integer value as determined from the
   RowMapper.

  returns: `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^TreeSelectionModel this]
    (-> this (.getSelectionPath))))

(defn add-selection-paths
  "Adds paths to the current selection.  If any of the paths in
   paths are not currently in the selection the TreeSelectionListeners
   are notified. This has
   no effect if paths is null.

  paths - the new paths to add to the current selection - `javax.swing.tree.TreePath[]`"
  ([^TreeSelectionModel this paths]
    (-> this (.addSelectionPaths paths))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^TreeSelectionModel this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-min-selection-row
  "Returns the smallest value obtained from the RowMapper for the
   current set of selected TreePaths. If nothing is selected,
   or there is no RowMapper, this will return -1.

  returns: `int`"
  (^Integer [^TreeSelectionModel this]
    (-> this (.getMinSelectionRow))))

(defn selection-empty?
  "Returns true if the selection is currently empty.

  returns: `boolean`"
  (^Boolean [^TreeSelectionModel this]
    (-> this (.isSelectionEmpty))))

(defn get-selection-rows
  "Returns all of the currently selected rows. This will return
   null (or an empty array) if there are no selected TreePaths or
   a RowMapper has not been set.

  returns: `int[]`"
  ([^TreeSelectionModel this]
    (-> this (.getSelectionRows))))

(defn path-selected?
  "Returns true if the path, path, is in the current
   selection.

  path - `javax.swing.tree.TreePath`

  returns: `boolean`"
  (^Boolean [^TreeSelectionModel this ^javax.swing.tree.TreePath path]
    (-> this (.isPathSelected path))))

(defn add-selection-path
  "Adds path to the current selection. If path is not currently
   in the selection the TreeSelectionListeners are notified. This has
   no effect if path is null.

  path - the new path to add to the current selection - `javax.swing.tree.TreePath`"
  ([^TreeSelectionModel this ^javax.swing.tree.TreePath path]
    (-> this (.addSelectionPath path))))

(defn get-selection-mode
  "Returns the current selection mode, one of
   SINGLE_TREE_SELECTION,
   CONTIGUOUS_TREE_SELECTION or
   DISCONTIGUOUS_TREE_SELECTION.

  returns: `int`"
  (^Integer [^TreeSelectionModel this]
    (-> this (.getSelectionMode))))

(defn remove-selection-path
  "Removes path from the selection. If path is in the selection
   The TreeSelectionListeners are notified. This has no effect if
   path is null.

  path - the path to remove from the selection - `javax.swing.tree.TreePath`"
  ([^TreeSelectionModel this ^javax.swing.tree.TreePath path]
    (-> this (.removeSelectionPath path))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

   A PropertyChangeEvent will get fired when the selection mode
   changes.

  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^TreeSelectionModel this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-selection-paths
  "Removes paths from the selection.  If any of the paths in
   paths
   are in the selection, the TreeSelectionListeners are notified.
   This method has no effect if paths is null.

  paths - the path to remove from the selection - `javax.swing.tree.TreePath[]`"
  ([^TreeSelectionModel this paths]
    (-> this (.removeSelectionPaths paths))))

(defn set-selection-mode
  "Sets the selection model, which must be one of SINGLE_TREE_SELECTION,
   CONTIGUOUS_TREE_SELECTION or DISCONTIGUOUS_TREE_SELECTION.

   This may change the selection if the current selection is not valid
   for the new mode. For example, if three TreePaths are
   selected when the mode is changed to SINGLE_TREE_SELECTION,
   only one TreePath will remain selected. It is up to the particular
   implementation to decide what TreePath remains selected.

  mode - `int`"
  ([^TreeSelectionModel this ^Integer mode]
    (-> this (.setSelectionMode mode))))

(defn set-row-mapper
  "Sets the RowMapper instance. This instance is used to determine
   the row for a particular TreePath.

  new-mapper - `javax.swing.tree.RowMapper`"
  ([^TreeSelectionModel this ^javax.swing.tree.RowMapper new-mapper]
    (-> this (.setRowMapper new-mapper))))

(defn set-selection-paths
  "Sets the selection to path. If this represents a change, then
   the TreeSelectionListeners are notified. If paths is
   null, this has the same effect as invoking clearSelection.

  paths - new selection - `javax.swing.tree.TreePath[]`"
  ([^TreeSelectionModel this paths]
    (-> this (.setSelectionPaths paths))))

