(ns javax.swing.JTree
  " A control that displays a set of hierarchical data as an outline.
  You can find task-oriented documentation and examples of using trees in
  How to Use Trees,
  a section in The Java Tutorial.

  A specific node in a tree can be identified either by a
  TreePath (an object
  that encapsulates a node and all of its ancestors), or by its
  display row, where each row in the display area displays one node.
  An expanded node is a non-leaf node (as identified by
  TreeModel.isLeaf(node) returning false) that will displays
  its children when all its ancestors are expanded.
  A collapsed
  node is one which hides them. A hidden node is one which is
  under a collapsed ancestor. All of a viewable nodes parents
  are expanded, but may or may not be displayed. A displayed node
  is both viewable and in the display area, where it can be seen.

  The following JTree methods use \"visible\" to mean \"displayed\":

  isRootVisible()
  setRootVisible()
  scrollPathToVisible()
  scrollRowToVisible()
  getVisibleRowCount()
  setVisibleRowCount()

  The next group of JTree methods use \"visible\" to mean
  \"viewable\" (under an expanded parent):

  isVisible()
  makeVisible()

  If you are interested in knowing when the selection changes implement
  the TreeSelectionListener interface and add the instance
  using the method addTreeSelectionListener.
  valueChanged will be invoked when the
  selection changes, that is if the user clicks twice on the same
  node valueChanged will only be invoked once.

  If you are interested in detecting either double-click events or when
  a user clicks on a node, regardless of whether or not it was selected,
  we recommend you do the following:



  final JTree tree = ...;

  MouseListener ml = new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
          int selRow = tree.getRowForLocation(e.getX(), e.getY());
          TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
          if(selRow != -1) {
              if(e.getClickCount() == 1) {
                  mySingleClick(selRow, selPath);
              }
              else if(e.getClickCount() == 2) {
                  myDoubleClick(selRow, selPath);
              }
          }
      }
  };
  tree.addMouseListener(ml);
  NOTE: This example obtains both the path and row, but you only need to
  get the one you're interested in.

  To use JTree to display compound nodes
  (for example, nodes containing both
  a graphic icon and text), subclass TreeCellRenderer and use
  setCellRenderer(javax.swing.tree.TreeCellRenderer) to tell the tree to use it. To edit such nodes,
  subclass TreeCellEditor and use setCellEditor(javax.swing.tree.TreeCellEditor).


  Like all JComponent classes, you can use InputMap and
  ActionMap
  to associate an Action object with a KeyStroke
  and execute the action under specified conditions.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTree]))

(defn ->j-tree
  "Constructor.

  Returns a JTree with the specified TreeNode
   as its root, which
   displays the root node and which decides whether a node is a
   leaf node in the specified manner.

  root - a TreeNode object - `javax.swing.tree.TreeNode`
  asks-allows-children - if false, any node without children is a leaf node; if true, only nodes that do not allow children are leaf nodes - `boolean`"
  (^JTree [^javax.swing.tree.TreeNode root ^Boolean asks-allows-children]
    (new JTree root asks-allows-children))
  (^JTree [value]
    (new JTree value))
  (^JTree []
    (new JTree )))

(def *-cell-renderer-property
  "Static Constant.

  Bound property name for cellRenderer.

  type: java.lang.String"
  JTree/CELL_RENDERER_PROPERTY)

(def *-tree-model-property
  "Static Constant.

  Bound property name for treeModel.

  type: java.lang.String"
  JTree/TREE_MODEL_PROPERTY)

(def *-root-visible-property
  "Static Constant.

  Bound property name for rootVisible.

  type: java.lang.String"
  JTree/ROOT_VISIBLE_PROPERTY)

(def *-shows-root-handles-property
  "Static Constant.

  Bound property name for showsRootHandles.

  type: java.lang.String"
  JTree/SHOWS_ROOT_HANDLES_PROPERTY)

(def *-row-height-property
  "Static Constant.

  Bound property name for rowHeight.

  type: java.lang.String"
  JTree/ROW_HEIGHT_PROPERTY)

(def *-cell-editor-property
  "Static Constant.

  Bound property name for cellEditor.

  type: java.lang.String"
  JTree/CELL_EDITOR_PROPERTY)

(def *-editable-property
  "Static Constant.

  Bound property name for editable.

  type: java.lang.String"
  JTree/EDITABLE_PROPERTY)

(def *-large-model-property
  "Static Constant.

  Bound property name for largeModel.

  type: java.lang.String"
  JTree/LARGE_MODEL_PROPERTY)

(def *-selection-model-property
  "Static Constant.

  Bound property name for selectionModel.

  type: java.lang.String"
  JTree/SELECTION_MODEL_PROPERTY)

(def *-visible-row-count-property
  "Static Constant.

  Bound property name for visibleRowCount.

  type: java.lang.String"
  JTree/VISIBLE_ROW_COUNT_PROPERTY)

(def *-invokes-stop-cell-editing-property
  "Static Constant.

  Bound property name for messagesStopCellEditing.

  type: java.lang.String"
  JTree/INVOKES_STOP_CELL_EDITING_PROPERTY)

(def *-scrolls-on-expand-property
  "Static Constant.

  Bound property name for scrollsOnExpand.

  type: java.lang.String"
  JTree/SCROLLS_ON_EXPAND_PROPERTY)

(def *-toggle-click-count-property
  "Static Constant.

  Bound property name for toggleClickCount.

  type: java.lang.String"
  JTree/TOGGLE_CLICK_COUNT_PROPERTY)

(def *-lead-selection-path-property
  "Static Constant.

  Bound property name for leadSelectionPath.

  type: java.lang.String"
  JTree/LEAD_SELECTION_PATH_PROPERTY)

(def *-anchor-selection-path-property
  "Static Constant.

  Bound property name for anchor selection path.

  type: java.lang.String"
  JTree/ANCHOR_SELECTION_PATH_PROPERTY)

(def *-expands-selected-paths-property
  "Static Constant.

  Bound property name for expands selected paths property

  type: java.lang.String"
  JTree/EXPANDS_SELECTED_PATHS_PROPERTY)

(defn expand-row
  "Ensures that the node in the specified row is expanded and
   viewable.

   If row is < 0 or >= getRowCount this
   will have no effect.

  row - an integer specifying a display row, where 0 is the first row in the display - `int`"
  ([^JTree this ^Integer row]
    (-> this (.expandRow row))))

(defn collapsed?
  "Returns true if the value identified by path is currently collapsed,
   this will return false if any of the values in path are currently
   not being displayed.

  path - the TreePath to check - `javax.swing.tree.TreePath`

  returns: true if any of the nodes in the node's path are collapsed,
                 false if all nodes in the path are expanded - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.isCollapsed path))))

(defn set-shows-root-handles
  "Sets the value of the showsRootHandles property,
   which specifies whether the node handles should be displayed.
   The default value of this property depends on the constructor
   used to create the JTree.
   Some look and feels might not support handles;
   they will ignore this property.

   This is a bound property.

  new-value - true if root handles should be displayed; otherwise, false - `boolean`"
  ([^JTree this ^Boolean new-value]
    (-> this (.setShowsRootHandles new-value))))

(defn get-lead-selection-path
  "Returns the path identified as the lead.

  returns: path identified as the lead - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this]
    (-> this (.getLeadSelectionPath))))

(defn get-max-selection-row
  "Returns the largest selected row. If the selection is empty, or
   none of the selected paths are viewable, -1 is returned.

  returns: the largest selected row - `int`"
  (^Integer [^JTree this]
    (-> this (.getMaxSelectionRow))))

(defn path-editable?
  "Returns isEditable. This is invoked from the UI before
   editing begins to insure that the given path can be edited. This
   is provided as an entry point for subclassers to add filtered
   editing without having to resort to creating a new editor.

  path - `javax.swing.tree.TreePath`

  returns: true if every parent node and the node itself is editable - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.isPathEditable path))))

(defn fixed-row-height?
  "Returns true if the height of each display row is a fixed size.

  returns: true if the height of each row is a fixed size - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isFixedRowHeight))))

(defn get-selection-count
  "Returns the number of nodes selected.

  returns: the number of nodes selected - `int`"
  (^Integer [^JTree this]
    (-> this (.getSelectionCount))))

(defn get-row-for-path
  "Returns the row that displays the node identified by the specified
   path.

  path - the TreePath identifying a node - `javax.swing.tree.TreePath`

  returns: an integer specifying the display row, where 0 is the first
           row in the display, or -1 if any of the elements in path
           are hidden under a collapsed parent. - `int`"
  (^Integer [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.getRowForPath path))))

(defn row-selected?
  "Returns true if the node identified by row is selected.

  row - an integer specifying a display row, where 0 is the first row in the display - `int`

  returns: true if the node is selected - `boolean`"
  (^Boolean [^JTree this ^Integer row]
    (-> this (.isRowSelected row))))

(defn clear-selection
  "Clears the selection."
  ([^JTree this]
    (-> this (.clearSelection))))

(defn add-tree-selection-listener
  "Adds a listener for TreeSelection events.

  tsl - the TreeSelectionListener that will be notified when a node is selected or deselected (a \"negative selection\") - `javax.swing.event.TreeSelectionListener`"
  ([^JTree this ^javax.swing.event.TreeSelectionListener tsl]
    (-> this (.addTreeSelectionListener tsl))))

(defn set-cell-renderer
  "Sets the TreeCellRenderer that will be used to
   draw each cell.

   This is a bound property.

  x - the TreeCellRenderer that is to render each cell - `javax.swing.tree.TreeCellRenderer`"
  ([^JTree this ^javax.swing.tree.TreeCellRenderer x]
    (-> this (.setCellRenderer x))))

(defn fire-tree-collapsed
  "Notifies all listeners that have registered interest for
   notification on this event type.  The event instance
   is lazily created using the path parameter.

  path - the TreePath indicating the node that was collapsed - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.fireTreeCollapsed path))))

(defn set-visible-row-count
  "Sets the number of rows that are to be displayed.
   This will only work if the tree is contained in a
   JScrollPane,
   and will adjust the preferred size and size of that scrollpane.

   This is a bound property.

  new-count - the number of rows to display - `int`"
  ([^JTree this ^Integer new-count]
    (-> this (.setVisibleRowCount new-count))))

(defn get-shows-root-handles?
  "Returns the value of the showsRootHandles property.

  returns: the value of the showsRootHandles property - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getShowsRootHandles))))

(defn get-path-bounds
  "Returns the Rectangle that the specified node will be drawn
   into. Returns null if any component in the path is hidden
   (under a collapsed parent).

   Note:
   This method returns a valid rectangle, even if the specified
   node is not currently displayed.

  path - the TreePath identifying the node - `javax.swing.tree.TreePath`

  returns: the Rectangle the node is drawn in,
            or null - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.getPathBounds path))))

(defn set-selection-path
  "Selects the node identified by the specified path. If any
   component of the path is hidden (under a collapsed node), and
   getExpandsSelectedPaths is true it is
   exposed (made viewable).

  path - the TreePath specifying the node to select - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.setSelectionPath path))))

(defn remove-tree-selection-listener
  "Removes a TreeSelection listener.

  tsl - the TreeSelectionListener to remove - `javax.swing.event.TreeSelectionListener`"
  ([^JTree this ^javax.swing.event.TreeSelectionListener tsl]
    (-> this (.removeTreeSelectionListener tsl))))

(defn add-tree-expansion-listener
  "Adds a listener for TreeExpansion events.

  tel - a TreeExpansionListener that will be notified when a tree node is expanded or collapsed (a \"negative expansion\") - `javax.swing.event.TreeExpansionListener`"
  ([^JTree this ^javax.swing.event.TreeExpansionListener tel]
    (-> this (.addTreeExpansionListener tel))))

(defn set-selection-rows
  "Selects the nodes corresponding to each of the specified rows
   in the display. If a particular element of rows is
   < 0 or >= getRowCount, it will be ignored.
   If none of the elements
   in rows are valid rows, the selection will
   be cleared. That is it will be as if clearSelection
   was invoked.

  rows - an array of ints specifying the rows to select, where 0 indicates the first row in the display - `int[]`"
  ([^JTree this rows]
    (-> this (.setSelectionRows rows))))

(defn get-row-bounds
  "Returns the Rectangle that the node at the specified row is
   drawn in.

  row - the row to be drawn, where 0 is the first row in the display - `int`

  returns: the Rectangle the node is drawn in - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JTree this ^Integer row]
    (-> this (.getRowBounds row))))

(defn get-expands-selected-paths?
  "Returns the expandsSelectedPaths property.

  returns: true if selection changes result in the parent path being
           expanded - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getExpandsSelectedPaths))))

(defn collapse-row
  "Ensures that the node in the specified row is collapsed.

   If row is < 0 or >= getRowCount this
   will have no effect.

  row - an integer specifying a display row, where 0 is the first row in the display - `int`"
  ([^JTree this ^Integer row]
    (-> this (.collapseRow row))))

(defn get-drop-mode
  "Returns the drop mode for this component.

  returns: the drop mode for this component - `javax.swing.DropMode`"
  (^javax.swing.DropMode [^JTree this]
    (-> this (.getDropMode))))

(defn get-scrollable-block-increment
  "Returns the amount for a block increment, which is the height or
   width of visibleRect, based on orientation.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL - `int`
  direction - less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: the \"block\" increment for scrolling in the specified direction - `int`"
  (^Integer [^JTree this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn set-drop-mode
  "Sets the drop mode for this component. For backward compatibility,
   the default for this property is DropMode.USE_SELECTION.
   Usage of one of the other modes is recommended, however, for an
   improved user experience. DropMode.ON, for instance,
   offers similar behavior of showing items as selected, but does so without
   affecting the actual selection in the tree.

   JTree supports the following drop modes:

      DropMode.USE_SELECTION
      DropMode.ON
      DropMode.INSERT
      DropMode.ON_OR_INSERT


   The drop mode is only meaningful if this component has a
   TransferHandler that accepts drops.

  drop-mode - the drop mode to use - `javax.swing.DropMode`

  throws: java.lang.IllegalArgumentException - if the drop mode is unsupported or null"
  ([^JTree this ^javax.swing.DropMode drop-mode]
    (-> this (.setDropMode drop-mode))))

(defn set-large-model
  "Specifies whether the UI should use a large model.
   (Not all UIs will implement this.) Fires a property change
   for the LARGE_MODEL_PROPERTY.

   This is a bound property.

  new-value - true to suggest a large model to the UI - `boolean`"
  ([^JTree this ^Boolean new-value]
    (-> this (.setLargeModel new-value))))

(defn set-expands-selected-paths
  "Configures the expandsSelectedPaths property. If
   true, any time the selection is changed, either via the
   TreeSelectionModel, or the cover methods provided by
   JTree, the TreePaths parents will be
   expanded to make them visible (visible meaning the parent path is
   expanded, not necessarily in the visible rectangle of the
   JTree). If false, when the selection
   changes the nodes parent is not made visible (all its parents expanded).
   This is useful if you wish to have your selection model maintain paths
   that are not always visible (all parents expanded).

   This is a bound property.

  new-value - the new value for expandsSelectedPaths - `boolean`"
  ([^JTree this ^Boolean new-value]
    (-> this (.setExpandsSelectedPaths new-value))))

(defn remove-tree-expansion-listener
  "Removes a listener for TreeExpansion events.

  tel - the TreeExpansionListener to remove - `javax.swing.event.TreeExpansionListener`"
  ([^JTree this ^javax.swing.event.TreeExpansionListener tel]
    (-> this (.removeTreeExpansionListener tel))))

(defn get-selection-paths
  "Returns the paths of all selected values.

  returns: an array of TreePath objects indicating the selected
           nodes, or null if nothing is currently selected - `javax.swing.tree.TreePath[]`"
  ([^JTree this]
    (-> this (.getSelectionPaths))))

(defn fire-tree-will-collapse
  "Notifies all listeners that have registered interest for
   notification on this event type.  The event instance
   is lazily created using the path parameter.

  path - the TreePath indicating the node that was expanded - `javax.swing.tree.TreePath`

  throws: javax.swing.tree.ExpandVetoException"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.fireTreeWillCollapse path))))

(defn expanded?
  "Returns true if the node identified by the path is currently expanded,

  path - the TreePath specifying the node to check - `javax.swing.tree.TreePath`

  returns: false if any of the nodes in the node's path are collapsed,
                 true if all nodes in the path are expanded - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.isExpanded path))))

(defn get-row-count
  "Returns the number of viewable nodes. A node is viewable if all of its
   parents are expanded. The root is only included in this count if
   isRootVisible() is true. This returns 0 if
   the UI has not been set.

  returns: the number of viewable nodes - `int`"
  (^Integer [^JTree this]
    (-> this (.getRowCount))))

(defn get-lead-selection-row
  "Returns the row index corresponding to the lead path.

  returns: an integer giving the row index of the lead path,
            where 0 is the first row in the display; or -1
            if leadPath is null - `int`"
  (^Integer [^JTree this]
    (-> this (.getLeadSelectionRow))))

(defn get-closest-row-for-location
  "Returns the row to the node that is closest to x,y.  If no nodes
   are viewable or there is no model, returns -1. Otherwise,
   it always returns a valid row.  To test if the returned object is
   exactly at x, y, get the bounds for the node at the returned
   row and test x, y against that.

  x - an integer giving the number of pixels horizontally from the left edge of the display area, minus any left margin - `int`
  y - an integer giving the number of pixels vertically from the top of the display area, minus any top margin - `int`

  returns: the row closest to the location, -1 if nothing is
           viewable or there is no model - `int`"
  (^Integer [^JTree this ^Integer x ^Integer y]
    (-> this (.getClosestRowForLocation x y))))

(defn root-visible?
  "Returns true if the root node of the tree is displayed.

  returns: true if the root node of the tree is displayed - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isRootVisible))))

(defn set-scrolls-on-expand
  "Sets the scrollsOnExpand property,
   which determines whether the
   tree might scroll to show previously hidden children.
   If this property is true (the default),
   when a node expands
   the tree can use scrolling to make
   the maximum possible number of the node's descendants visible.
   In some look and feels, trees might not need to scroll when expanded;
   those look and feels will ignore this property.

   This is a bound property.

  new-value - false to disable scrolling on expansion; true to enable it - `boolean`"
  ([^JTree this ^Boolean new-value]
    (-> this (.setScrollsOnExpand new-value))))

(defn get-row-for-location
  "Returns the row for the specified location.

  x - an integer giving the number of pixels horizontally from the left edge of the display area, minus any left margin - `int`
  y - an integer giving the number of pixels vertically from the top of the display area, minus any top margin - `int`

  returns: the row corresponding to the location, or -1 if the
           location is not within the bounds of a displayed cell - `int`"
  (^Integer [^JTree this ^Integer x ^Integer y]
    (-> this (.getRowForLocation x y))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string \"TreeUI\" - `java.lang.String`"
  (^java.lang.String [^JTree this]
    (-> this (.getUIClassID))))

(defn tree-did-change
  "Sent when the tree has changed enough that we need to resize
   the bounds, but not enough that we need to remove the
   expanded node set (e.g nodes were expanded or collapsed, or
   nodes were inserted into the tree). You should never have to
   invoke this, the UI will invoke this as it needs to."
  ([^JTree this]
    (-> this (.treeDidChange))))

(defn remove-tree-will-expand-listener
  "Removes a listener for TreeWillExpand events.

  tel - the TreeWillExpandListener to remove - `javax.swing.event.TreeWillExpandListener`"
  ([^JTree this ^javax.swing.event.TreeWillExpandListener tel]
    (-> this (.removeTreeWillExpandListener tel))))

(defn set-selection-model
  "Sets the tree's selection model. When a null value is
   specified an empty
   selectionModel is used, which does not allow selections.

   This is a bound property.

  selection-model - the TreeSelectionModel to use, or null to disable selections - `javax.swing.tree.TreeSelectionModel`"
  ([^JTree this ^javax.swing.tree.TreeSelectionModel selection-model]
    (-> this (.setSelectionModel selection-model))))

(defn get-expanded-descendants
  "Returns an Enumeration of the descendants of the
   path parent that
   are currently expanded. If parent is not currently
   expanded, this will return null.
   If you expand/collapse nodes while
   iterating over the returned Enumeration
   this may not return all
   the expanded paths, or may return paths that are no longer expanded.

  parent - the path which is to be examined - `javax.swing.tree.TreePath`

  returns: an Enumeration of the descendents of
            parent, or null if
            parent is not currently expanded - `java.util.Enumeration<javax.swing.tree.TreePath>`"
  (^java.util.Enumeration [^JTree this ^javax.swing.tree.TreePath parent]
    (-> this (.getExpandedDescendants parent))))

(defn get-selection-path
  "Returns the path to the first selected node.

  returns: the TreePath for the first selected node,
            or null if nothing is currently selected - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this]
    (-> this (.getSelectionPath))))

(defn set-selection-interval
  "Selects the rows in the specified interval (inclusive). If
   the specified indices are within the viewable set of rows, or bound
   the viewable set of rows, then the specified rows are constrained by
   the viewable set of rows. If the specified indices are not within the
   viewable set of rows, or do not bound the viewable set of rows, then
   the selection is cleared. For example, if the row count is 10, and this method is invoked with -1, 20, then the
   specified indices bounds the viewable range, and this is treated as
   if invoked with 0, 9. On the other hand, if this were
   invoked with -10, -1, then the specified indices do not
   bound the viewable set of rows, and the selection is cleared.

   The parameters are not order dependent. That is, setSelectionInterval(x, y) is equivalent to
   setSelectionInterval(y, x).

  index-0 - the first index in the range to select - `int`
  index-1 - the last index in the range to select - `int`"
  ([^JTree this ^Integer index-0 ^Integer index-1]
    (-> this (.setSelectionInterval index-0 index-1))))

(defn get-scrollable-unit-increment
  "Returns the amount to increment when scrolling. The amount is
   the height of the first displayed row that isn't completely in view
   or, if it is totally displayed, the height of the next row in the
   scrolling direction.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL - `int`
  direction - less than zero to scroll up/left, greater than zero for down/right - `int`

  returns: the \"unit\" increment for scrolling in the specified direction - `int`"
  (^Integer [^JTree this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn get-cell-editor
  "Returns the editor used to edit entries in the tree.

  returns: the TreeCellEditor in use,
            or null if the tree cannot be edited - `javax.swing.tree.TreeCellEditor`"
  (^javax.swing.tree.TreeCellEditor [^JTree this]
    (-> this (.getCellEditor))))

(defn get-tree-selection-listeners
  "Returns an array of all the TreeSelectionListeners added
   to this JTree with addTreeSelectionListener().

  returns: all of the TreeSelectionListeners added or an empty
           array if no listeners have been added - `javax.swing.event.TreeSelectionListener[]`"
  ([^JTree this]
    (-> this (.getTreeSelectionListeners))))

(defn get-anchor-selection-path
  "Returns the path identified as the anchor.

  returns: path identified as the anchor - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this]
    (-> this (.getAnchorSelectionPath))))

(defn get-tree-will-expand-listeners
  "Returns an array of all the TreeWillExpandListeners added
   to this JTree with addTreeWillExpandListener().

  returns: all of the TreeWillExpandListeners added or an empty
           array if no listeners have been added - `javax.swing.event.TreeWillExpandListener[]`"
  ([^JTree this]
    (-> this (.getTreeWillExpandListeners))))

(defn set-selection-row
  "Selects the node at the specified row in the display.

  row - the row to select, where 0 is the first row in the display - `int`"
  ([^JTree this ^Integer row]
    (-> this (.setSelectionRow row))))

(defn set-root-visible
  "Determines whether or not the root node from
   the TreeModel is visible.

   This is a bound property.

  root-visible - true if the root node of the tree is to be displayed - `boolean`"
  ([^JTree this ^Boolean root-visible]
    (-> this (.setRootVisible root-visible))))

(defn remove-selection-row
  "Removes the row at the index row from the current
   selection.

  row - the row to remove - `int`"
  ([^JTree this ^Integer row]
    (-> this (.removeSelectionRow row))))

(defn add-selection-row
  "Adds the path at the specified row to the current selection.

  row - an integer specifying the row of the node to add, where 0 is the first row in the display - `int`"
  ([^JTree this ^Integer row]
    (-> this (.addSelectionRow row))))

(defn add-selection-paths
  "Adds each path in the array of paths to the current selection. If
   any component of any of the paths isn't viewable and
   getExpandsSelectedPaths is true, it is
   made viewable.

   Note that JTree does not allow duplicate nodes to
   exist as children under the same parent -- each sibling must be
   a unique object.

  paths - an array of TreePath objects that specifies the nodes to add - `javax.swing.tree.TreePath[]`"
  ([^JTree this paths]
    (-> this (.addSelectionPaths paths))))

(defn fire-tree-will-expand
  "Notifies all listeners that have registered interest for
   notification on this event type.  The event instance
   is lazily created using the path parameter.

  path - the TreePath indicating the node that was expanded - `javax.swing.tree.TreePath`

  throws: javax.swing.tree.ExpandVetoException"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.fireTreeWillExpand path))))

(defn get-selection-model
  "Returns the model for selections. This should always return a
   non-null value. If you don't want to allow anything
   to be selected
   set the selection model to null, which forces an empty
   selection model to be used.

  returns: `javax.swing.tree.TreeSelectionModel`"
  (^javax.swing.tree.TreeSelectionModel [^JTree this]
    (-> this (.getSelectionModel))))

(defn convert-value-to-text
  "Called by the renderers to convert the specified value to
   text. This implementation returns value.toString, ignoring
   all other arguments. To control the conversion, subclass this
   method and use any of the arguments you need.

  value - the Object to convert to text - `java.lang.Object`
  selected - true if the node is selected - `boolean`
  expanded - true if the node is expanded - `boolean`
  leaf - true if the node is a leaf node - `boolean`
  row - an integer specifying the node's display row, where 0 is the first row in the display - `int`
  has-focus - true if the node has the focus - `boolean`

  returns: the String representation of the node's value - `java.lang.String`"
  (^java.lang.String [^JTree this ^java.lang.Object value ^Boolean selected ^Boolean expanded ^Boolean leaf ^Integer row ^Boolean has-focus]
    (-> this (.convertValueToText value selected expanded leaf row has-focus))))

(defn get-last-selected-path-component
  "Returns the last path component of the selected path. This is
   a convenience method for
   getSelectionModel().getSelectionPath().getLastPathComponent().
   This is typically only useful if the selection has one path.

  returns: the last path component of the selected path, or
           null if nothing is selected - `java.lang.Object`"
  (^java.lang.Object [^JTree this]
    (-> this (.getLastSelectedPathComponent))))

(defn get-drop-location
  "Returns the location that this component should visually indicate
   as the drop location during a DnD operation over the component,
   or null if no location is to currently be shown.

   This method is not meant for querying the drop location
   from a TransferHandler, as the drop location is only
   set after the TransferHandler's canImport
   has returned and has allowed for the location to be shown.

   When this property changes, a property change event with
   name \"dropLocation\" is fired by the component.

  returns: the drop location - `javax.swing.JTree$DropLocation`"
  (^javax.swing.JTree$DropLocation [^JTree this]
    (-> this (.getDropLocation))))

(defn remove-selection-interval
  "Removes the specified rows (inclusive) from the selection. If
   the specified indices are within the viewable set of rows, or bound
   the viewable set of rows, then the specified indices are constrained by
   the viewable set of rows. If the specified indices are not within the
   viewable set of rows, or do not bound the viewable set of rows, then
   the selection is unchanged. For example, if the row count is 10, and this method is invoked with -1, 20, then the
   specified range bounds the viewable range, and this is treated as
   if invoked with 0, 9. On the other hand, if this were
   invoked with -10, -1, then the specified range does not
   bound the viewable set of rows, and the selection is unchanged.

   The parameters are not order dependent. That is, removeSelectionInterval(x, y) is equivalent to
   removeSelectionInterval(y, x).

  index-0 - the first row to remove from the selection - `int`
  index-1 - the last row to remove from the selection - `int`"
  ([^JTree this ^Integer index-0 ^Integer index-1]
    (-> this (.removeSelectionInterval index-0 index-1))))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred display size of a JTree. The height is
   determined from getVisibleRowCount and the width
   is the current preferred width.

  returns: a Dimension object containing the preferred size - `java.awt.Dimension`"
  (^java.awt.Dimension [^JTree this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn set-toggle-click-count
  "Sets the number of mouse clicks before a node will expand or close.
   The default is two.

   This is a bound property.

  click-count - `int`"
  ([^JTree this ^Integer click-count]
    (-> this (.setToggleClickCount click-count))))

(defn get-cell-renderer
  "Returns the current TreeCellRenderer
    that is rendering each cell.

  returns: the TreeCellRenderer that is rendering each cell - `javax.swing.tree.TreeCellRenderer`"
  (^javax.swing.tree.TreeCellRenderer [^JTree this]
    (-> this (.getCellRenderer))))

(defn add-selection-interval
  "Adds the specified rows (inclusive) to the selection. If the
   specified indices are within the viewable set of rows, or bound
   the viewable set of rows, then the specified indices are
   constrained by the viewable set of rows. If the indices are not
   within the viewable set of rows, or do not bound the viewable
   set of rows, then the selection is unchanged. For example, if
   the row count is 10, and this method is invoked with
   -1, 20, then the specified indices bounds the viewable
   range, and this is treated as if invoked with 0, 9. On
   the other hand, if this were invoked with -10, -1, then
   the specified indices do not bound the viewable set of rows,
   and the selection is unchanged.

   The parameters are not order dependent. That is, addSelectionInterval(x, y) is equivalent to
   addSelectionInterval(y, x).

  index-0 - the first index in the range to add to the selection - `int`
  index-1 - the last index in the range to add to the selection - `int`"
  ([^JTree this ^Integer index-0 ^Integer index-1]
    (-> this (.addSelectionInterval index-0 index-1))))

(defn set-ui
  "Sets the L&F object that renders this component.

   This is a bound property.

  ui - the TreeUI L&F object - `javax.swing.plaf.TreeUI`"
  ([^JTree this ^javax.swing.plaf.TreeUI ui]
    (-> this (.setUI ui))))

(defn editable?
  "Returns true if the tree is editable.

  returns: true if the tree is editable - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isEditable))))

(defn collapse-path
  "Ensures that the node identified by the specified path is
   collapsed and viewable.

  path - the TreePath identifying a node - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.collapsePath path))))

(defn get-tool-tip-text
  "Overrides JComponent's getToolTipText
   method in order to allow
   renderer's tips to be used if it has text set.

   NOTE: For JTree to properly display tooltips of its
   renderers, JTree must be a registered component with the
   ToolTipManager.  This can be done by invoking
   ToolTipManager.sharedInstance().registerComponent(tree).
   This is not done automatically!

  event - the MouseEvent that initiated the ToolTip display - `java.awt.event.MouseEvent`

  returns: a string containing the  tooltip or null
            if event is null - `java.lang.String`"
  (^java.lang.String [^JTree this event]
    (-> this (.getToolTipText event))))

(defn scroll-path-to-visible
  "Makes sure all the path components in path are expanded (except
   for the last path component) and scrolls so that the
   node identified by the path is displayed. Only works when this
   JTree is contained in a JScrollPane.

  path - the TreePath identifying the node to bring into view - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.scrollPathToVisible path))))

(defn set-invokes-stop-cell-editing
  "Determines what happens when editing is interrupted by selecting
   another node in the tree, a change in the tree's data, or by some
   other means. Setting this property to true causes the
   changes to be automatically saved when editing is interrupted.

   Fires a property change for the INVOKES_STOP_CELL_EDITING_PROPERTY.

  new-value - true means that stopCellEditing is invoked when editing is interrupted, and data is saved; false means that cancelCellEditing is invoked, and changes are lost - `boolean`"
  ([^JTree this ^Boolean new-value]
    (-> this (.setInvokesStopCellEditing new-value))))

(defn add-tree-will-expand-listener
  "Adds a listener for TreeWillExpand events.

  tel - a TreeWillExpandListener that will be notified when a tree node will be expanded or collapsed (a \"negative expansion\") - `javax.swing.event.TreeWillExpandListener`"
  ([^JTree this ^javax.swing.event.TreeWillExpandListener tel]
    (-> this (.addTreeWillExpandListener tel))))

(defn remove-selection-rows
  "Removes the rows that are selected at each of the specified
   rows.

  rows - an array of ints specifying display rows, where 0 is the first row in the display - `int[]`"
  ([^JTree this rows]
    (-> this (.removeSelectionRows rows))))

(defn set-drag-enabled
  "Turns on or off automatic drag handling. In order to enable automatic
   drag handling, this property should be set to true, and the
   tree's TransferHandler needs to be non-null.
   The default value of the dragEnabled property is false.

   The job of honoring this property, and recognizing a user drag gesture,
   lies with the look and feel implementation, and in particular, the tree's
   TreeUI. When automatic drag handling is enabled, most look and
   feels (including those that subclass BasicLookAndFeel) begin a
   drag and drop operation whenever the user presses the mouse button over
   an item and then moves the mouse a few pixels. Setting this property to
   true can therefore have a subtle effect on how selections behave.

   If a look and feel is used that ignores this property, you can still
   begin a drag and drop operation by calling exportAsDrag on the
   tree's TransferHandler.

  b - whether or not to enable automatic drag handling - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([^JTree this ^Boolean b]
    (-> this (.setDragEnabled b))))

(defn make-visible
  "Ensures that the node identified by path is currently viewable.

  path - the TreePath to make visible - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.makeVisible path))))

(defn get-closest-path-for-location
  "Returns the path to the node that is closest to x,y.  If
   no nodes are currently viewable, or there is no model, returns
   null, otherwise it always returns a valid path.  To test if
   the node is exactly at x, y, get the node's bounds and
   test x, y against that.

  x - an integer giving the number of pixels horizontally from the left edge of the display area, minus any left margin - `int`
  y - an integer giving the number of pixels vertically from the top of the display area, minus any top margin - `int`

  returns: the TreePath for the node closest to that location,
            null if nothing is viewable or there is no model - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this ^Integer x ^Integer y]
    (-> this (.getClosestPathForLocation x y))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the TreeUI object that renders this component - `javax.swing.plaf.TreeUI`"
  (^javax.swing.plaf.TreeUI [^JTree this]
    (-> this (.getUI))))

(defn get-min-selection-row
  "Returns the smallest selected row. If the selection is empty, or
   none of the selected paths are viewable, -1 is returned.

  returns: the smallest selected row - `int`"
  (^Integer [^JTree this]
    (-> this (.getMinSelectionRow))))

(defn get-path-for-location
  "Returns the path for the node at the specified location.

  x - an integer giving the number of pixels horizontally from the left edge of the display area, minus any left margin - `int`
  y - an integer giving the number of pixels vertically from the top of the display area, minus any top margin - `int`

  returns: the TreePath for the node at that location - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this ^Integer x ^Integer y]
    (-> this (.getPathForLocation x y))))

(defn selection-empty?
  "Returns true if the selection is currently empty.

  returns: true if the selection is currently empty - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isSelectionEmpty))))

(defn add-selection-rows
  "Adds the paths at each of the specified rows to the current selection.

  rows - an array of ints specifying the rows to add, where 0 indicates the first row in the display - `int[]`"
  ([^JTree this rows]
    (-> this (.addSelectionRows rows))))

(defn get-invokes-stop-cell-editing?
  "Returns the indicator that tells what happens when editing is
   interrupted.

  returns: the indicator that tells what happens when editing is
           interrupted - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getInvokesStopCellEditing))))

(defn get-scrollable-tracks-viewport-width?
  "Returns false to indicate that the width of the viewport does not
   determine the width of the table, unless the preferred width of
   the tree is smaller than the viewports width.  In other words:
   ensure that the tree is never smaller than its viewport.

  returns: whether the tree should track the width of the viewport - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-selection-rows
  "Returns all of the currently selected rows. This method is simply
   forwarded to the TreeSelectionModel.
   If nothing is selected null or an empty array will
   be returned, based on the TreeSelectionModel
   implementation.

  returns: an array of integers that identifies all currently selected rows
           where 0 is the first row in the display - `int[]`"
  ([^JTree this]
    (-> this (.getSelectionRows))))

(defn path-selected?
  "Returns true if the item identified by the path is currently selected.

  path - a TreePath identifying a node - `javax.swing.tree.TreePath`

  returns: true if the node is selected - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.isPathSelected path))))

(defn get-visible-row-count
  "Returns the number of rows that are displayed in the display area.

  returns: the number of rows displayed - `int`"
  (^Integer [^JTree this]
    (-> this (.getVisibleRowCount))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JTree.
   For JTrees, the AccessibleContext takes the form of an
   AccessibleJTree.
   A new AccessibleJTree instance is created if necessary.

  returns: an AccessibleJTree that serves as the
           AccessibleContext of this JTree - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JTree this]
    (-> this (.getAccessibleContext))))

(defn fire-tree-expanded
  "Notifies all listeners that have registered interest for
   notification on this event type.  The event instance
   is lazily created using the path parameter.

  path - the TreePath indicating the node that was expanded - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.fireTreeExpanded path))))

(defn visible?
  "Returns true if the value identified by path is currently viewable,
   which means it is either the root or all of its parents are expanded.
   Otherwise, this method returns false.

  path - `javax.swing.tree.TreePath`

  returns: true if the node is viewable, otherwise false - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.isVisible path))))

(defn set-editable
  "Determines whether the tree is editable. Fires a property
   change event if the new setting is different from the existing
   setting.

   This is a bound property.

  flag - a boolean value, true if the tree is editable - `boolean`"
  ([^JTree this ^Boolean flag]
    (-> this (.setEditable flag))))

(defn set-row-height
  "Sets the height of each cell, in pixels.  If the specified value
   is less than or equal to zero the current cell renderer is
   queried for each row's height.

   This is a bound property.

  row-height - the height of each cell, in pixels - `int`"
  ([^JTree this ^Integer row-height]
    (-> this (.setRowHeight row-height))))

(defn add-selection-path
  "Adds the node identified by the specified TreePath
   to the current selection. If any component of the path isn't
   viewable, and getExpandsSelectedPaths is true it is
   made viewable.

   Note that JTree does not allow duplicate nodes to
   exist as children under the same parent -- each sibling must be
   a unique object.

  path - the TreePath to add - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.addSelectionPath path))))

(defn get-scrollable-tracks-viewport-height?
  "Returns false to indicate that the height of the viewport does not
   determine the height of the table, unless the preferred height
   of the tree is smaller than the viewports height.  In other words:
   ensure that the tree is never smaller than its viewport.

  returns: whether the tree should track the height of the viewport - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn large-model?
  "Returns true if the tree is configured for a large model.

  returns: true if a large model is suggested - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isLargeModel))))

(defn get-drag-enabled?
  "Returns whether or not automatic drag handling is enabled.

  returns: the value of the dragEnabled property - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getDragEnabled))))

(defn get-path-for-row
  "Returns the path for the specified row.  If row is
   not visible, or a TreeUI has not been set, null
   is returned.

  row - an integer specifying a row - `int`

  returns: the TreePath to the specified node,
            null if row < 0
            or row >= getRowCount() - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this ^Integer row]
    (-> this (.getPathForRow row))))

(defn set-lead-selection-path
  "Sets the path identifies as the lead. The lead may not be selected.
   The lead is not maintained by JTree,
   rather the UI will update it.

   This is a bound property.

  new-path - the new lead path - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath new-path]
    (-> this (.setLeadSelectionPath new-path))))

(defn get-editing-path
  "Returns the path to the element that is currently being edited.

  returns: the TreePath for the node being edited - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^JTree this]
    (-> this (.getEditingPath))))

(defn remove-selection-path
  "Removes the node identified by the specified path from the current
   selection.

  path - the TreePath identifying a node - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.removeSelectionPath path))))

(defn set-anchor-selection-path
  "Sets the path identified as the anchor.
   The anchor is not maintained by JTree, rather the UI will
   update it.

   This is a bound property.

  new-path - the new anchor path - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath new-path]
    (-> this (.setAnchorSelectionPath new-path))))

(defn get-model
  "Returns the TreeModel that is providing the data.

  returns: the TreeModel that is providing the data - `javax.swing.tree.TreeModel`"
  (^javax.swing.tree.TreeModel [^JTree this]
    (-> this (.getModel))))

(defn editing?
  "Returns true if the tree is being edited. The item that is being
   edited can be obtained using getSelectionPath.

  returns: true if the user is currently editing a node - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.isEditing))))

(defn start-editing-at-path
  "Selects the node identified by the specified path and initiates
   editing.  The edit-attempt fails if the CellEditor
   does not allow
   editing for the specified item.

  path - the TreePath identifying a node - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.startEditingAtPath path))))

(defn get-toggle-click-count
  "Returns the number of mouse clicks needed to expand or close a node.

  returns: number of mouse clicks before node is expanded - `int`"
  (^Integer [^JTree this]
    (-> this (.getToggleClickCount))))

(defn has-been-expanded?
  "Returns true if the node identified by the path has ever been
   expanded.

  path - `javax.swing.tree.TreePath`

  returns: true if the path has ever been expanded - `boolean`"
  (^Boolean [^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.hasBeenExpanded path))))

(defn expand-path
  "Ensures that the node identified by the specified path is
   expanded and viewable. If the last item in the path is a
   leaf, this will have no effect.

  path - the TreePath identifying a node - `javax.swing.tree.TreePath`"
  ([^JTree this ^javax.swing.tree.TreePath path]
    (-> this (.expandPath path))))

(defn set-cell-editor
  "Sets the cell editor.  A null value implies that the
   tree cannot be edited.  If this represents a change in the
   cellEditor, the propertyChange
   method is invoked on all listeners.

   This is a bound property.

  cell-editor - the TreeCellEditor to use - `javax.swing.tree.TreeCellEditor`"
  ([^JTree this ^javax.swing.tree.TreeCellEditor cell-editor]
    (-> this (.setCellEditor cell-editor))))

(defn set-model
  "Sets the TreeModel that will provide the data.

   This is a bound property.

  new-model - the TreeModel that is to provide the data - `javax.swing.tree.TreeModel`"
  ([^JTree this ^javax.swing.tree.TreeModel new-model]
    (-> this (.setModel new-model))))

(defn remove-selection-paths
  "Removes the nodes identified by the specified paths from the
   current selection.

  paths - an array of TreePath objects that specifies the nodes to remove - `javax.swing.tree.TreePath[]`"
  ([^JTree this paths]
    (-> this (.removeSelectionPaths paths))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^JTree this]
    (-> this (.updateUI))))

(defn get-row-height
  "Returns the height of each row.  If the returned value is less than
   or equal to 0 the height for each row is determined by the
   renderer.

  returns: `int`"
  (^Integer [^JTree this]
    (-> this (.getRowHeight))))

(defn get-scrolls-on-expand?
  "Returns the value of the scrollsOnExpand property.

  returns: the value of the scrollsOnExpand property - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.getScrollsOnExpand))))

(defn set-selection-paths
  "Selects the nodes identified by the specified array of paths.
   If any component in any of the paths is hidden (under a collapsed
   node), and getExpandsSelectedPaths is true
   it is exposed (made viewable).

  paths - an array of TreePath objects that specifies the nodes to select - `javax.swing.tree.TreePath[]`"
  ([^JTree this paths]
    (-> this (.setSelectionPaths paths))))

(defn scroll-row-to-visible
  "Scrolls the item identified by row until it is displayed. The minimum
   of amount of scrolling necessary to bring the row into view
   is performed. Only works when this JTree is contained in a
   JScrollPane.

  row - an integer specifying the row to scroll, where 0 is the first row in the display - `int`"
  ([^JTree this ^Integer row]
    (-> this (.scrollRowToVisible row))))

(defn get-tree-expansion-listeners
  "Returns an array of all the TreeExpansionListeners added
   to this JTree with addTreeExpansionListener().

  returns: all of the TreeExpansionListeners added or an empty
           array if no listeners have been added - `javax.swing.event.TreeExpansionListener[]`"
  ([^JTree this]
    (-> this (.getTreeExpansionListeners))))

(defn get-next-match
  "Returns the TreePath to the next tree element that
   begins with a prefix. To handle the conversion of a
   TreePath into a String, convertValueToText
   is used.

  prefix - the string to test for a match - `java.lang.String`
  starting-row - the row for starting the search - `int`
  bias - the search direction, either Position.Bias.Forward or Position.Bias.Backward. - `javax.swing.text.Position$Bias`

  returns: the TreePath of the next tree element that
   starts with the prefix; otherwise null - `javax.swing.tree.TreePath`

  throws: java.lang.IllegalArgumentException - if prefix is null or startingRow is out of bounds"
  (^javax.swing.tree.TreePath [^JTree this ^java.lang.String prefix ^Integer starting-row ^javax.swing.text.Position$Bias bias]
    (-> this (.getNextMatch prefix starting-row bias))))

(defn cancel-editing
  "Cancels the current editing session. Has no effect if the
   tree isn't being edited."
  ([^JTree this]
    (-> this (.cancelEditing))))

(defn stop-editing
  "Ends the current editing session.
   (The DefaultTreeCellEditor
   object saves any edits that are currently in progress on a cell.
   Other implementations may operate differently.)
   Has no effect if the tree isn't being edited.

   Note:
   To make edit-saves automatic whenever the user changes
   their position in the tree, use setInvokesStopCellEditing(boolean).

  returns: true if editing was in progress and is now stopped,
                false if editing was not in progress - `boolean`"
  (^Boolean [^JTree this]
    (-> this (.stopEditing))))

