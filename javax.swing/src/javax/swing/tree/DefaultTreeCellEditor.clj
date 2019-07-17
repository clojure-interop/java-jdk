(ns javax.swing.tree.DefaultTreeCellEditor
  "A TreeCellEditor. You need to supply an
  instance of DefaultTreeCellRenderer
  so that the icons can be obtained. You can optionally supply
  a TreeCellEditor that will be layed out according
  to the icon in the DefaultTreeCellRenderer.
  If you do not supply a TreeCellEditor,
  a TextField will be used. Editing is started
  on a triple mouse click, or after a click, pause, click and
  a delay of 1200 milliseconds.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree DefaultTreeCellEditor]))

(defn ->default-tree-cell-editor
  "Constructor.

  Constructs a DefaultTreeCellEditor
   object for a JTree using the
   specified renderer and the specified editor. (Use this constructor
   for specialized editing.)

  tree - a JTree object - `javax.swing.JTree`
  renderer - a DefaultTreeCellRenderer object - `javax.swing.tree.DefaultTreeCellRenderer`
  editor - a TreeCellEditor object - `javax.swing.tree.TreeCellEditor`"
  ([^javax.swing.JTree tree ^javax.swing.tree.DefaultTreeCellRenderer renderer ^javax.swing.tree.TreeCellEditor editor]
    (new DefaultTreeCellEditor tree renderer editor))
  ([^javax.swing.JTree tree ^javax.swing.tree.DefaultTreeCellRenderer renderer]
    (new DefaultTreeCellEditor tree renderer)))

(defn cancel-cell-editing
  "Messages cancelCellEditing to the
   realEditor and removes it from this instance."
  ([^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.cancelCellEditing))))

(defn stop-cell-editing
  "If the realEditor will allow editing to stop,
   the realEditor is removed and true is returned,
   otherwise false is returned.

  returns: true if editing was stopped; false otherwise - `boolean`"
  (^Boolean [^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.stopCellEditing))))

(defn get-cell-editor-value
  "Returns the value currently being edited.

  returns: the value currently being edited - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.getCellEditorValue))))

(defn get-tree-cell-editor-component
  "Configures the editor.  Passed onto the realEditor.

  tree - the JTree that is asking the editor to edit; this parameter can be null - `javax.swing.JTree`
  value - the value of the cell to be edited - `java.lang.Object`
  is-selected - true if the cell is to be rendered with selection highlighting - `boolean`
  expanded - true if the node is expanded - `boolean`
  leaf - true if the node is a leaf node - `boolean`
  row - the row index of the node being edited - `int`

  returns: the component for editing - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.tree.DefaultTreeCellEditor this ^javax.swing.JTree tree ^java.lang.Object value ^Boolean is-selected ^Boolean expanded ^Boolean leaf ^Integer row]
    (-> this (.getTreeCellEditorComponent tree value is-selected expanded leaf row))))

(defn cell-editable?
  "If the realEditor returns true to this
   message, prepareForEditing
   is messaged and true is returned.

  event - the event the editor should use to consider whether to begin editing or not - `java.util.EventObject`

  returns: true if editing can be started - `boolean`"
  (^Boolean [^javax.swing.tree.DefaultTreeCellEditor this ^java.util.EventObject event]
    (-> this (.isCellEditable event))))

(defn should-select-cell?
  "Messages the realEditor for the return value.

  event - the event the editor should use to start editing - `java.util.EventObject`

  returns: true if the editor would like the editing cell to be selected;
      otherwise returns false - `boolean`"
  (^Boolean [^javax.swing.tree.DefaultTreeCellEditor this ^java.util.EventObject event]
    (-> this (.shouldSelectCell event))))

(defn set-border-selection-color
  "Sets the color to use for the border.

  new-color - the new border color - `java.awt.Color`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^java.awt.Color new-color]
    (-> this (.setBorderSelectionColor new-color))))

(defn value-changed
  "Resets lastPath.

  e - the event that characterizes the change. - `javax.swing.event.TreeSelectionEvent`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^javax.swing.event.TreeSelectionEvent e]
    (-> this (.valueChanged e))))

(defn set-font
  "Sets the font to edit with. null indicates
   the renderers font should be used. This will NOT
   override any font you have set in the editor
   the receiver was instantiated with. If null
   for an editor was passed in a default editor will be
   created that will pick up this font.

  font - the editing Font - `java.awt.Font`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^java.awt.Font font]
    (-> this (.setFont font))))

(defn action-performed
  "Messaged when the timer fires, this will start the editing
   session.

  e - `java.awt.event.ActionEvent`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

(defn add-cell-editor-listener
  "Adds the CellEditorListener.

  l - the listener to be added - `javax.swing.event.CellEditorListener`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^javax.swing.event.CellEditorListener l]
    (-> this (.addCellEditorListener l))))

(defn get-cell-editor-listeners
  "Returns an array of all the CellEditorListeners added
   to this DefaultTreeCellEditor with addCellEditorListener().

  returns: all of the CellEditorListeners added or an empty
           array if no listeners have been added - `javax.swing.event.CellEditorListener[]`"
  ([^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.getCellEditorListeners))))

(defn get-font
  "Gets the font used for editing.

  returns: the editing Font - `java.awt.Font`"
  (^java.awt.Font [^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.getFont))))

(defn remove-cell-editor-listener
  "Removes the previously added CellEditorListener.

  l - the listener to be removed - `javax.swing.event.CellEditorListener`"
  ([^javax.swing.tree.DefaultTreeCellEditor this ^javax.swing.event.CellEditorListener l]
    (-> this (.removeCellEditorListener l))))

(defn get-border-selection-color
  "Returns the color the border is drawn.

  returns: the border selection color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.tree.DefaultTreeCellEditor this]
    (-> this (.getBorderSelectionColor))))

