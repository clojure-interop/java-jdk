(ns javax.swing.event.TreeSelectionEvent
  "An event that characterizes a change in the current
  selection.  The change is based on any number of paths.
  TreeSelectionListeners will generally query the source of
  the event for the new selected status of each potentially
  changed row.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeSelectionEvent]))

(defn ->tree-selection-event
  "Constructor.

  Represents a change in the selection of a TreeSelectionModel.
   paths identifies the paths that have been either added or
   removed from the selection.

  source - source of event - `java.lang.Object`
  paths - the paths that have changed in the selection - `javax.swing.tree.TreePath[]`
  are-new - `boolean[]`
  old-lead-selection-path - `javax.swing.tree.TreePath`
  new-lead-selection-path - `javax.swing.tree.TreePath`"
  ([^java.lang.Object source ^javax.swing.tree.TreePath[] paths are-new ^javax.swing.tree.TreePath old-lead-selection-path ^javax.swing.tree.TreePath new-lead-selection-path]
    (new TreeSelectionEvent source paths are-new old-lead-selection-path new-lead-selection-path)))

(defn get-paths
  "Returns the paths that have been added or removed from the
   selection.

  returns: `javax.swing.tree.TreePath[]`"
  ([^javax.swing.event.TreeSelectionEvent this]
    (-> this (.getPaths))))

(defn get-path
  "Returns the first path element.

  returns: `javax.swing.tree.TreePath`"
  ([^javax.swing.event.TreeSelectionEvent this]
    (-> this (.getPath))))

(defn added-path?
  "Returns whether the specified path was added to the selection.
   A return value of true indicates the path identified by
   path was added to the selection. A return value of
   false indicates path is no longer selected. This method
   is only valid for the paths returned from getPaths(); invoking
   with a path not included in getPaths() throws an
   IllegalArgumentException.

  path - the path to test - `javax.swing.tree.TreePath`

  returns: true if path was added to the selection,
           false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - if path is not contained in getPaths"
  ([^javax.swing.event.TreeSelectionEvent this ^javax.swing.tree.TreePath path]
    (-> this (.isAddedPath path)))
  ([^javax.swing.event.TreeSelectionEvent this]
    (-> this (.isAddedPath))))

(defn get-old-lead-selection-path
  "Returns the path that was previously the lead path.

  returns: `javax.swing.tree.TreePath`"
  ([^javax.swing.event.TreeSelectionEvent this]
    (-> this (.getOldLeadSelectionPath))))

(defn get-new-lead-selection-path
  "Returns the current lead path.

  returns: `javax.swing.tree.TreePath`"
  ([^javax.swing.event.TreeSelectionEvent this]
    (-> this (.getNewLeadSelectionPath))))

(defn clone-with-source
  "Returns a copy of the receiver, but with the source being newSource.

  new-source - `java.lang.Object`

  returns: `java.lang.Object`"
  ([^javax.swing.event.TreeSelectionEvent this ^java.lang.Object new-source]
    (-> this (.cloneWithSource new-source))))

