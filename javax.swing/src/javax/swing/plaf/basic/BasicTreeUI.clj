(ns javax.swing.plaf.basic.BasicTreeUI
  "The basic L&F for a hierarchical data structure."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTreeUI]))

(defn ->basic-tree-ui
  "Constructor."
  ([]
    (new BasicTreeUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (BasicTreeUI/createUI x)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Returns the minimum size for this component.  Which will be
   the min preferred size or 0, 0.

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-right-child-indent
  "returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicTreeUI this]
    (-> this (.getRightChildIndent))))

(defn get-row-for-path
  "Returns the row that the last item identified in path is visible
   at.  Will return -1 if any of the elements in path are not
   currently visible.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree ^javax.swing.tree.TreePath path]
    (-> this (.getRowForPath tree path))))

(defn get-maximum-size
  "Returns the maximum size for this component, which will be the
   preferred size if the instance is currently in a JTree, or 0, 0.

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn set-right-child-indent
  "new-amount - `int`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^Integer new-amount]
    (-> this (.setRightChildIndent new-amount))))

(defn get-path-bounds
  "Returns the Rectangle enclosing the label portion that the
   last item in path will be drawn into.  Will return null if
   any component in path is currently valid.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`

  returns: `java.awt.Rectangle`"
  (^java.awt.Rectangle [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree ^javax.swing.tree.TreePath path]
    (-> this (.getPathBounds tree path))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-row-count
  "Returns the number of rows that are being displayed.

  tree - `javax.swing.JTree`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree]
    (-> this (.getRowCount tree))))

(defn get-expanded-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.plaf.basic.BasicTreeUI this]
    (-> this (.getExpandedIcon))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component.BaselineResizeBehavior [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

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
  (^javax.swing.tree.TreePath [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree ^Integer x ^Integer y]
    (-> this (.getClosestPathForLocation tree x y))))

(defn set-collapsed-icon
  "new-g - `javax.swing.Icon`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.Icon new-g]
    (-> this (.setCollapsedIcon new-g))))

(defn get-preferred-min-size
  "Returns the minimum preferred size.

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTreeUI this]
    (-> this (.getPreferredMinSize))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn set-left-child-indent
  "new-amount - `int`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^Integer new-amount]
    (-> this (.setLeftChildIndent new-amount))))

(defn set-expanded-icon
  "new-g - `javax.swing.Icon`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.Icon new-g]
    (-> this (.setExpandedIcon new-g))))

(defn get-path-for-row
  "Returns the path for passed in row.  If row is not visible
   null is returned.

  tree - `javax.swing.JTree`
  row - `int`

  returns: `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree ^Integer row]
    (-> this (.getPathForRow tree row))))

(defn get-editing-path
  "Returns the path to the element that is being edited.

  tree - `javax.swing.JTree`

  returns: `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree]
    (-> this (.getEditingPath tree))))

(defn get-left-child-indent
  "returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicTreeUI this]
    (-> this (.getLeftChildIndent))))

(defn editing?
  "Returns true if the tree is being edited.  The item that is being
   edited can be returned by getEditingPath().

  tree - `javax.swing.JTree`

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree]
    (-> this (.isEditing tree))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn start-editing-at-path
  "Selects the last item in path and tries to edit it.  Editing will
   fail if the CellEditor won't allow it for the selected item.

  tree - `javax.swing.JTree`
  path - `javax.swing.tree.TreePath`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree ^javax.swing.tree.TreePath path]
    (-> this (.startEditingAtPath tree path))))

(defn get-collapsed-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.plaf.basic.BasicTreeUI this]
    (-> this (.getCollapsedIcon))))

(defn get-preferred-size
  "Returns the preferred size to represent the tree in
   c.  If checkConsistency is true
   checkConsistency is messaged first.

  c - `javax.swing.JComponent`
  check-consistency - `boolean`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c ^Boolean check-consistency]
    (-> this (.getPreferredSize c check-consistency)))
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn cancel-editing
  "Cancels the current editing session.

  tree - `javax.swing.JTree`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree]
    (-> this (.cancelEditing tree))))

(defn set-preferred-min-size
  "Sets the preferred minimum size.

  new-size - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTreeUI this ^java.awt.Dimension new-size]
    (-> this (.setPreferredMinSize new-size))))

(defn stop-editing
  "Stops the current editing session.  This has no effect if the
   tree isn't being edited.  Returns true if the editor allows the
   editing session to stop.

  tree - `javax.swing.JTree`

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicTreeUI this ^javax.swing.JTree tree]
    (-> this (.stopEditing tree))))

