(ns javax.swing.JTree$EmptySelectionModel
  "EmptySelectionModel is a TreeSelectionModel
  that does not allow anything to be selected.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTree$EmptySelectionModel]))

(defn *shared-instance
  "Returns the single instance of EmptySelectionModel.

  returns: single instance of EmptySelectionModel - `javax.swing.JTree.EmptySelectionModel`"
  ([]
    (JTree$EmptySelectionModel/sharedInstance )))

(defn add-tree-selection-listener
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  listener - the listener to add; this is ignored - `javax.swing.event.TreeSelectionListener`"
  ([this listener]
    (-> this (.addTreeSelectionListener listener))))

(defn remove-tree-selection-listener
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  listener - the listener to remove; this is ignored - `javax.swing.event.TreeSelectionListener`"
  ([this listener]
    (-> this (.removeTreeSelectionListener listener))))

(defn add-selection-paths
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  paths - the paths to add to the selection; this is ignored - `javax.swing.tree.TreePath[]`"
  ([this paths]
    (-> this (.addSelectionPaths paths))))

(defn remove-property-change-listener
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  listener - the listener to remove; this is ignored - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn add-property-change-listener
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  listener - the listener to add; this is ignored - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn remove-selection-paths
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  paths - the paths to remove; this is ignored - `javax.swing.tree.TreePath[]`"
  ([this paths]
    (-> this (.removeSelectionPaths paths))))

(defn set-selection-mode
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  mode - the selection mode; this is ignored - `int`"
  ([this mode]
    (-> this (.setSelectionMode mode))))

(defn set-row-mapper
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  mapper - the RowMapper instance; this is ignored - `javax.swing.tree.RowMapper`"
  ([this mapper]
    (-> this (.setRowMapper mapper))))

(defn set-selection-paths
  "This is overriden to do nothing; EmptySelectionModel
   does not allow a selection.

  paths - the paths to select; this is ignored - `javax.swing.tree.TreePath[]`"
  ([this paths]
    (-> this (.setSelectionPaths paths))))

