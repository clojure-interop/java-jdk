(ns javax.swing.tree.TreeCellRenderer
  "Defines the requirements for an object that displays a tree node.
  See How to Use Trees
  in The Java Tutorial
  for an example of implementing a tree cell renderer
  that displays custom icons."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree TreeCellRenderer]))

(defn get-tree-cell-renderer-component
  "Sets the value of the current tree cell to value.
   If selected is true, the cell will be drawn as if
   selected. If expanded is true the node is currently
   expanded and if leaf is true the node represents a
   leaf and if hasFocus is true the node currently has
   focus. tree is the JTree the receiver is being
   configured for.  Returns the Component that the renderer
   uses to draw the value.

   The TreeCellRenderer is also responsible for rendering the
   the cell representing the tree's current DnD drop location if
   it has one. If this renderer cares about rendering
   the DnD drop location, it should query the tree directly to
   see if the given row represents the drop location:


       JTree.DropLocation dropLocation = tree.getDropLocation();
       if (dropLocation != null
               && dropLocation.getChildIndex() == -1
               && tree.getRowForPath(dropLocation.getPath()) == row) {

           // this row represents the current drop location
           // so render it specially, perhaps with a different color
       }

  tree - `javax.swing.JTree`
  value - `java.lang.Object`
  selected - `boolean`
  expanded - `boolean`
  leaf - `boolean`
  row - `int`
  has-focus - `boolean`

  returns: the Component that the renderer uses to draw the value - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.tree.TreeCellRenderer this ^javax.swing.JTree tree ^java.lang.Object value ^Boolean selected ^Boolean expanded ^Boolean leaf ^Integer row ^Boolean has-focus]
    (-> this (.getTreeCellRendererComponent tree value selected expanded leaf row has-focus))))

