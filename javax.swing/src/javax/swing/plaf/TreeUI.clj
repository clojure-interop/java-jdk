(ns javax.swing.plaf.TreeUI
  "Pluggable look and feel interface for JTree."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf TreeUI]))

(defn ->tree-ui
  "Constructor."
  ([]
    (new TreeUI )))

(defn get-row-for-path
  "Returns the row that the last item identified in path is visible
   at.  Will return -1 if any of the elements in path are not
   currently visible.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`

  returns: `int`"
  ([this tree path]
    (-> this (.getRowForPath tree path))))

(defn get-path-bounds
  "Returns the Rectangle enclosing the label portion that the
   last item in path will be drawn into.  Will return null if
   any component in path is currently valid.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`

  returns: `java.awt.Rectangle`"
  ([this tree path]
    (-> this (.getPathBounds tree path))))

(defn get-row-count
  "Returns the number of rows that are being displayed.

  tree - `javax.swing.JTree`

  returns: `int`"
  ([this tree]
    (-> this (.getRowCount tree))))

(defn get-closest-path-for-location
  "Returns the path to the node that is closest to x,y.  If
   there is nothing currently visible this will return null, otherwise
   it'll always return a valid path.  If you need to test if the
   returned object is exactly at x, y you should get the bounds for
   the returned path and test x, y against that.

  tree - `javax.swing.JTree`
  x - `int`
  y - `int`

  returns: `javax.swing.tree.TreePath`"
  ([this tree x y]
    (-> this (.getClosestPathForLocation tree x y))))

(defn get-path-for-row
  "Returns the path for passed in row.  If row is not visible
   null is returned.

  tree - `javax.swing.JTree`
  row - `int`

  returns: `javax.swing.tree.TreePath`"
  ([this tree row]
    (-> this (.getPathForRow tree row))))

(defn get-editing-path
  "Returns the path to the element that is being edited.

  tree - `javax.swing.JTree`

  returns: `javax.swing.tree.TreePath`"
  ([this tree]
    (-> this (.getEditingPath tree))))

(defn editing?
  "Returns true if the tree is being edited.  The item that is being
   edited can be returned by getEditingPath().

  tree - `javax.swing.JTree`

  returns: `boolean`"
  ([this tree]
    (-> this (.isEditing tree))))

(defn start-editing-at-path
  "Selects the last item in path and tries to edit it.  Editing will
   fail if the CellEditor won't allow it for the selected item.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`"
  ([this tree path]
    (-> this (.startEditingAtPath tree path))))

(defn cancel-editing
  "Cancels the current editing session. This has no effect if the
   tree isn't being edited.  Returns true if the editor allows the
   editing session to stop.

  tree - `javax.swing.JTree`"
  ([this tree]
    (-> this (.cancelEditing tree))))

(defn stop-editing
  "Stops the current editing session.  This has no effect if the
   tree isn't being edited.  Returns true if the editor allows the
   editing session to stop.

  tree - `javax.swing.JTree`

  returns: `boolean`"
  ([this tree]
    (-> this (.stopEditing tree))))

