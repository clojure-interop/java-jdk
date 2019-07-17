(ns javax.swing.tree.DefaultTreeSelectionModel
  "Default implementation of TreeSelectionModel.  Listeners are notified
  whenever
  the paths in the selection change, not the rows. In order
  to be able to track row changes you may wish to become a listener
  for expansion events on the tree and test for changes from there.
  resetRowSelection is called from any of the methods that update
  the selected paths. If you subclass any of these methods to
  filter what is allowed to be selected, be sure and message
  resetRowSelection if you do not message super.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree DefaultTreeSelectionModel]))

(defn ->default-tree-selection-model
  "Constructor.

  Creates a new instance of DefaultTreeSelectionModel that is
   empty, with a selection mode of DISCONTIGUOUS_TREE_SELECTION."
  ([]
    (new DefaultTreeSelectionModel )))

(def *-selection-mode-property
  "Static Constant.

  Property name for selectionMode.

  type: java.lang.String"
  DefaultTreeSelectionModel/SELECTION_MODE_PROPERTY)

(defn get-lead-selection-path
  "Returns the last path that was added. This may differ from the
   leadSelectionPath property maintained by the JTree.

  returns: `javax.swing.tree.TreePath`"
  ([this]
    (-> this (.getLeadSelectionPath))))

(defn get-max-selection-row
  "Returns the largest value obtained from the RowMapper for the
   current set of selected TreePaths. If nothing is selected,
   or there is no RowMapper, this will return -1.

  returns: `int`"
  ([this]
    (-> this (.getMaxSelectionRow))))

(defn get-selection-count
  "Returns the number of paths that are selected.

  returns: `int`"
  ([this]
    (-> this (.getSelectionCount))))

(defn row-selected?
  "Returns true if the row identified by row is selected.

  row - `int`

  returns: `boolean`"
  ([this row]
    (-> this (.isRowSelected row))))

(defn clear-selection
  "Empties the current selection.  If this represents a change in the
   current selection, the selection listeners are notified."
  ([this]
    (-> this (.clearSelection))))

(defn get-row-mapper
  "Returns the RowMapper instance that is able to map a TreePath to a
   row.

  returns: `javax.swing.tree.RowMapper`"
  ([this]
    (-> this (.getRowMapper))))

(defn add-tree-selection-listener
  "Adds x to the list of listeners that are notified each time the
   set of selected TreePaths changes.

  x - the new listener to be added - `javax.swing.event.TreeSelectionListener`"
  ([this x]
    (-> this (.addTreeSelectionListener x))))

(defn reset-row-selection
  "Updates this object's mapping from TreePath to rows. This should
   be invoked when the mapping from TreePaths to integers has changed
   (for example, a node has been expanded).
   You do not normally have to call this, JTree and its associated
   Listeners will invoke this for you. If you are implementing your own
   View class, then you will have to invoke this.
   This will invoke insureRowContinuity to make sure
   the currently selected TreePaths are still valid based on the
   selection mode."
  ([this]
    (-> this (.resetRowSelection))))

(defn set-selection-path
  "Sets the selection to path. If this represents a change, then
   the TreeSelectionListeners are notified. If path is
   null, this has the same effect as invoking clearSelection.

  path - new path to select - `javax.swing.tree.TreePath`"
  ([this path]
    (-> this (.setSelectionPath path))))

(defn remove-tree-selection-listener
  "Removes x from the list of listeners that are notified each time
   the set of selected TreePaths changes.

  x - the listener to remove - `javax.swing.event.TreeSelectionListener`"
  ([this x]
    (-> this (.removeTreeSelectionListener x))))

(defn get-selection-paths
  "Returns the selection.

  returns: the selection - `javax.swing.tree.TreePath[]`"
  ([this]
    (-> this (.getSelectionPaths))))

(defn get-lead-selection-row
  "Returns the lead selection index. That is the last index that was
   added.

  returns: `int`"
  ([this]
    (-> this (.getLeadSelectionRow))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-selection-path
  "Returns the first path in the selection. This is useful if there
   if only one item currently selected.

  returns: `javax.swing.tree.TreePath`"
  ([this]
    (-> this (.getSelectionPath))))

(defn get-tree-selection-listeners
  "Returns an array of all the tree selection listeners
   registered on this model.

  returns: all of this model's TreeSelectionListeners
           or an empty
           array if no tree selection listeners are currently registered - `javax.swing.event.TreeSelectionListener[]`"
  ([this]
    (-> this (.getTreeSelectionListeners))))

(defn add-selection-paths
  "Adds paths to the current selection. If any of the paths in
   paths are not currently in the selection the TreeSelectionListeners
   are notified. This has
   no effect if paths is null.
   The lead path is set to the last element in paths.
   If the selection mode is CONTIGUOUS_TREE_SELECTION,
   and adding the new paths would make the selection discontiguous.
   Then two things can result: if the TreePaths in paths
   are contiguous, then the selection becomes these TreePaths,
   otherwise the TreePaths aren't contiguous and the selection becomes
   the first TreePath in paths.

  paths - the new path to add to the current selection - `javax.swing.tree.TreePath[]`"
  ([this paths]
    (-> this (.addSelectionPaths paths))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   This removes a PropertyChangeListener that was registered
   for all properties.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-min-selection-row
  "Returns the smallest value obtained from the RowMapper for the
   current set of selected TreePaths. If nothing is selected,
   or there is no RowMapper, this will return -1.

  returns: `int`"
  ([this]
    (-> this (.getMinSelectionRow))))

(defn selection-empty?
  "Returns true if the selection is currently empty.

  returns: `boolean`"
  ([this]
    (-> this (.isSelectionEmpty))))

(defn get-selection-rows
  "Returns the selection in terms of rows. There is not
   necessarily a one-to-one mapping between the TreePaths
   returned from getSelectionPaths and this method. In
   particular, if a TreePath is not viewable (the RowMapper returns -1 for the row corresponding to the
   TreePath), then the corresponding row is not included
   in the returned array. For example, if the selection consists
   of two paths, A and B, with A at row
   10, and B not currently viewable, then this method
   returns an array with the single entry 10.

  returns: the selection in terms of rows - `int[]`"
  ([this]
    (-> this (.getSelectionRows))))

(defn path-selected?
  "Returns true if the path, path,
   is in the current selection.

  path - `javax.swing.tree.TreePath`

  returns: `boolean`"
  ([this path]
    (-> this (.isPathSelected path))))

(defn get-property-change-listeners
  "Returns an array of all the property change listeners
   registered on this DefaultTreeSelectionModel.

  returns: all of this model's PropertyChangeListeners
           or an empty
           array if no property change listeners are currently registered - `java.beans.PropertyChangeListener[]`"
  ([this]
    (-> this (.getPropertyChangeListeners))))

(defn add-selection-path
  "Adds path to the current selection. If path is not currently
   in the selection the TreeSelectionListeners are notified. This has
   no effect if path is null.

  path - the new path to add to the current selection - `javax.swing.tree.TreePath`"
  ([this path]
    (-> this (.addSelectionPath path))))

(defn clone
  "Returns a clone of this object with the same selection.
   This method does not duplicate
   selection listeners and property listeners.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - never thrown by instances of this class"
  ([this]
    (-> this (.clone))))

(defn get-selection-mode
  "Returns the selection mode, one of SINGLE_TREE_SELECTION,
   DISCONTIGUOUS_TREE_SELECTION or
   CONTIGUOUS_TREE_SELECTION.

  returns: `int`"
  ([this]
    (-> this (.getSelectionMode))))

(defn remove-selection-path
  "Removes path from the selection. If path is in the selection
   The TreeSelectionListeners are notified. This has no effect if
   path is null.

  path - the path to remove from the selection - `javax.swing.tree.TreePath`"
  ([this path]
    (-> this (.removeSelectionPath path))))

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
   DefaultTreeSelectionModel m
   for its tree selection listeners with the following code:



  TreeSelectionListener[] tsls = (TreeSelectionListener[])(m.getListeners(TreeSelectionListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([this listener-type]
    (-> this (.getListeners listener-type))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

   A PropertyChangeEvent will get fired when the selection mode
   changes.

  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-selection-paths
  "Removes paths from the selection.  If any of the paths in paths
   are in the selection the TreeSelectionListeners are notified.
   This has no effect if paths is null.

  paths - the paths to remove from the selection - `javax.swing.tree.TreePath[]`"
  ([this paths]
    (-> this (.removeSelectionPaths paths))))

(defn set-selection-mode
  "Sets the selection model, which must be one of SINGLE_TREE_SELECTION,
   CONTIGUOUS_TREE_SELECTION or DISCONTIGUOUS_TREE_SELECTION. If mode
   is not one of the defined value,
   DISCONTIGUOUS_TREE_SELECTION is assumed.
   This may change the selection if the current selection is not valid
   for the new mode. For example, if three TreePaths are
   selected when the mode is changed to SINGLE_TREE_SELECTION,
   only one TreePath will remain selected. It is up to the particular
   implementation to decide what TreePath remains selected.

   Setting the mode to something other than the defined types will
   result in the mode becoming DISCONTIGUOUS_TREE_SELECTION.

  mode - `int`"
  ([this mode]
    (-> this (.setSelectionMode mode))))

(defn set-row-mapper
  "Sets the RowMapper instance. This instance is used to determine
   the row for a particular TreePath.

  new-mapper - `javax.swing.tree.RowMapper`"
  ([this new-mapper]
    (-> this (.setRowMapper new-mapper))))

(defn set-selection-paths
  "Sets the selection. Whether the supplied paths are taken as the
   new selection depends upon the selection mode. If the supplied
   array is null, or empty, the selection is cleared. If
   the selection mode is SINGLE_TREE_SELECTION, only the
   first path in pPaths is used. If the selection
   mode is CONTIGUOUS_TREE_SELECTION and the supplied paths
   are not contiguous, then only the first path in pPaths is
   used. If the selection mode is
   DISCONTIGUOUS_TREE_SELECTION, then all paths are used.

   All null paths in pPaths are ignored.

   If this represents a change, all registered TreeSelectionListeners are notified.

   The lead path is set to the last unique path.

   The paths returned from getSelectionPaths are in the same
   order as those supplied to this method.

  p-paths - the new selection - `javax.swing.tree.TreePath[]`"
  ([this p-paths]
    (-> this (.setSelectionPaths p-paths))))

