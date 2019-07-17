(ns javax.swing.tree.TreeCellEditor
  "Adds to CellEditor the extensions necessary to configure an editor
  in a tree."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree TreeCellEditor]))

(defn get-tree-cell-editor-component
  "Sets an initial value for the editor.  This will cause
   the editor to stopEditing and lose any partially edited value
   if the editor is editing when this method is called.

   Returns the component that should be added to the client's
   Component hierarchy.  Once installed in the client's hierarchy
   this component will then be able to draw and receive user input.

  tree - the JTree that is asking the editor to edit; this parameter can be null - `javax.swing.JTree`
  value - the value of the cell to be edited - `java.lang.Object`
  is-selected - true if the cell is to be rendered with selection highlighting - `boolean`
  expanded - true if the node is expanded - `boolean`
  leaf - true if the node is a leaf node - `boolean`
  row - the row index of the node being edited - `int`

  returns: the component for editing - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.tree.TreeCellEditor this ^javax.swing.JTree tree ^java.lang.Object value ^Boolean is-selected ^Boolean expanded ^Boolean leaf ^Integer row]
    (-> this (.getTreeCellEditorComponent tree value is-selected expanded leaf row))))

