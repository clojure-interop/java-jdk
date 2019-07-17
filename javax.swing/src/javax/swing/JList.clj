(ns javax.swing.JList
  "A component that displays a list of objects and allows the user to select
  one or more items. A separate model, ListModel, maintains the
  contents of the list.

  It's easy to display an array or Vector of objects, using the JList
  constructor that automatically builds a read-only ListModel instance
  for you:


  // Create a JList that displays strings from an array

  String[] data = {`one`, `two`, `three`, `four`};
  JList<String> myList = new JList<String>(data);

  // Create a JList that displays the superclasses of JList.class, by
  // creating it with a Vector populated with this data

  Vector<Class<?>> superClasses = new Vector<Class<?>>();
  Class<JList> rootClass = javax.swing.JList.class;
  for(Class<?> cls = rootClass; cls != null; cls = cls.getSuperclass()) {
      superClasses.addElement(cls);
  }
  JList<Class<?>> myList = new JList<Class<?>>(superClasses);

  // The automatically created model is stored in JList's `model`
  // property, which you can retrieve

  ListModel<Class<?>> model = myList.getModel();
  for(int i = 0; i < model.getSize(); i++) {
      System.out.println(model.getElementAt(i));
  }

  A ListModel can be supplied directly to a JList by way of a
  constructor or the setModel method. The contents need not be static -
  the number of items, and the values of items can change over time. A correct
  ListModel implementation notifies the set of
  javax.swing.event.ListDataListeners that have been added to it, each
  time a change occurs. These changes are characterized by a
  javax.swing.event.ListDataEvent, which identifies the range of list
  indices that have been modified, added, or removed. JList's
  ListUI is responsible for keeping the visual representation up to
  date with changes, by listening to the model.

  Simple, dynamic-content, JList applications can use the
  DefaultListModel class to maintain list elements. This class
  implements the ListModel interface and also provides a
  java.util.Vector-like API. Applications that need a more
  custom ListModel implementation may instead wish to subclass
  AbstractListModel, which provides basic support for managing and
  notifying listeners. For example, a read-only implementation of
  AbstractListModel:


  // This list model has about 2^16 elements.  Enjoy scrolling.

  ListModel<String> bigData = new AbstractListModel<String>() {
      public int getSize() { return Short.MAX_VALUE; }
      public String getElementAt(int index) { return `Index `  index; }
  };

  The selection state of a JList is managed by another separate
  model, an instance of ListSelectionModel. JList is
  initialized with a selection model on construction, and also contains
  methods to query or set this selection model. Additionally, JList
  provides convenient methods for easily managing the selection. These methods,
  such as setSelectedIndex and getSelectedValue, are cover
  methods that take care of the details of interacting with the selection
  model. By default, JList's selection model is configured to allow any
  combination of items to be selected at a time; selection mode
  MULTIPLE_INTERVAL_SELECTION. The selection mode can be changed
  on the selection model directly, or via JList's cover method.
  Responsibility for updating the selection model in response to user gestures
  lies with the list's ListUI.

  A correct ListSelectionModel implementation notifies the set of
  javax.swing.event.ListSelectionListeners that have been added to it
  each time a change to the selection occurs. These changes are characterized
  by a javax.swing.event.ListSelectionEvent, which identifies the range
  of the selection change.

  The preferred way to listen for changes in list selection is to add
  ListSelectionListeners directly to the JList. JList
  then takes care of listening to the the selection model and notifying your
  listeners of change.

  Responsibility for listening to selection changes in order to keep the list's
  visual representation up to date lies with the list's ListUI.


  Painting of cells in a JList is handled by a delegate called a
  cell renderer, installed on the list as the cellRenderer property.
  The renderer provides a java.awt.Component that is used
  like a `rubber stamp` to paint the cells. Each time a cell needs to be
  painted, the list's ListUI asks the cell renderer for the component,
  moves it into place, and has it paint the contents of the cell by way of its
  paint method. A default cell renderer, which uses a JLabel
  component to render, is installed by the lists's ListUI. You can
  substitute your own renderer using code like this:


   // Display an icon and a string for each object in the list.

  class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
      final static ImageIcon longIcon = new ImageIcon(`long.gif`);
      final static ImageIcon shortIcon = new ImageIcon(`short.gif`);

      // This is the only method defined by ListCellRenderer.
      // We just reconfigure the JLabel each time we're called.

      public Component getListCellRendererComponent(
        JList<?> list,           // the list
        Object value,            // value to display
        int index,               // cell index
        boolean isSelected,      // is the cell selected
        boolean cellHasFocus)    // does the cell have focus
      {
          String s = value.toString();
          setText(s);
          setIcon((s.length() > 10) ? longIcon : shortIcon);
          if (isSelected) {
              setBackground(list.getSelectionBackground());
              setForeground(list.getSelectionForeground());
          } else {
              setBackground(list.getBackground());
              setForeground(list.getForeground());
          }
          setEnabled(list.isEnabled());
          setFont(list.getFont());
          setOpaque(true);
          return this;
      }
  }

  myList.setCellRenderer(new MyCellRenderer());

  Another job for the cell renderer is in helping to determine sizing
  information for the list. By default, the list's ListUI determines
  the size of cells by asking the cell renderer for its preferred
  size for each list item. This can be expensive for large lists of items.
  To avoid these calculations, you can set a fixedCellWidth and
  fixedCellHeight on the list, or have these values calculated
  automatically based on a single prototype value:



  JList<String> bigDataList = new JList<String>(bigData);

  // We don't want the JList implementation to compute the width
  // or height of all of the list cells, so we give it a string
  // that's as big as we'll need for any cell.  It uses this to
  // compute values for the fixedCellWidth and fixedCellHeight
  // properties.

  bigDataList.setPrototypeCellValue(`Index 1234567890`);

  JList doesn't implement scrolling directly. To create a list that
  scrolls, make it the viewport view of a JScrollPane. For example:


  JScrollPane scrollPane = new JScrollPane(myList);

  // Or in two steps:
  JScrollPane scrollPane = new JScrollPane();
  scrollPane.getViewport().setView(myList);

  JList doesn't provide any special handling of double or triple
  (or N) mouse clicks, but it's easy to add a MouseListener if you
  wish to take action on these events. Use the locationToIndex
  method to determine what cell was clicked. For example:


  MouseListener mouseListener = new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
          if (e.getClickCount() == 2) {
              int index = list.locationToIndex(e.getPoint());
              System.out.println(`Double clicked on Item `  index);
           }
      }
  };
  list.addMouseListener(mouseListener);

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
  Please see XMLEncoder.

  See How to Use Lists
  in The Java Tutorial
  for further documentation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JList]))

(defn ->j-list
  "Constructor.

  Constructs a JList that displays elements from the specified,
   non-null, model. All JList constructors delegate to
   this one.

   This constructor registers the list with the ToolTipManager,
   allowing for tooltips to be provided by the cell renderers.

  data-model - the model for the list - `javax.swing.ListModel<JList.E>`

  throws: java.lang.IllegalArgumentException - if the model is null"
  ([data-model]
    (new JList data-model))
  ([]
    (new JList )))

(def *-vertical
  "Static Constant.

  Indicates a vertical layout of cells, in a single column;
   the default layout.

  type: int"
  JList/VERTICAL)

(def *-vertical-wrap
  "Static Constant.

  Indicates a `newspaper style` layout with cells flowing vertically
   then horizontally.

  type: int"
  JList/VERTICAL_WRAP)

(def *-horizontal-wrap
  "Static Constant.

  Indicates a `newspaper style` layout with cells flowing horizontally
   then vertically.

  type: int"
  JList/HORIZONTAL_WRAP)

(defn get-selection-background
  "Returns the color used to draw the background of selected items.
   DefaultListCellRenderer uses this color to draw the background
   of items in the selected state, as do the renderers installed by most
   ListUI implementations.

  returns: the color to draw the background of selected items - `java.awt.Color`"
  ([this]
    (-> this (.getSelectionBackground))))

(defn set-layout-orientation
  "Defines the way list cells are layed out. Consider a JList
   with five cells. Cells can be layed out in one of the following ways:



   VERTICAL:          0
                      1
                      2
                      3
                      4

   HORIZONTAL_WRAP:   0  1  2
                      3  4

   VERTICAL_WRAP:     0  3
                      1  4
                      2

   A description of these layouts follows:


     ValueDescription
     VERTICAL
         Cells are layed out vertically in a single column.
     HORIZONTAL_WRAP
         Cells are layed out horizontally, wrapping to a new row as
             necessary. If the visibleRowCount property is less than
             or equal to zero, wrapping is determined by the width of the
             list; otherwise wrapping is done in such a way as to ensure
             visibleRowCount rows in the list.
     VERTICAL_WRAP
         Cells are layed out vertically, wrapping to a new column as
             necessary. If the visibleRowCount property is less than
             or equal to zero, wrapping is determined by the height of the
             list; otherwise wrapping is done at visibleRowCount rows.


   The default value of this property is VERTICAL.

  layout-orientation - the new layout orientation, one of: VERTICAL, HORIZONTAL_WRAP or VERTICAL_WRAP - `int`

  throws: java.lang.IllegalArgumentException - if layoutOrientation isn't one of the allowable values"
  ([this layout-orientation]
    (-> this (.setLayoutOrientation layout-orientation))))

(defn set-selection-background
  "Sets the color used to draw the background of selected items, which
   cell renderers can use fill selected cells.
   DefaultListCellRenderer uses this color to fill the background
   of items in the selected state, as do the renderers installed by most
   ListUI implementations.

   The default value of this property is defined by the look
   and feel implementation.

   This is a JavaBeans bound property.

  selection-background - the Color to use for the background of selected cells - `java.awt.Color`"
  ([this selection-background]
    (-> this (.setSelectionBackground selection-background))))

(defn get-fixed-cell-height
  "Returns the value of the fixedCellHeight property.

  returns: the fixed cell height - `int`"
  ([this]
    (-> this (.getFixedCellHeight))))

(defn get-value-is-adjusting?
  "Returns the value of the selection model's isAdjusting property.

   This is a cover method that delegates to the method of the same name on
   the list's selection model.

  returns: the value of the selection model's isAdjusting property. - `boolean`"
  ([this]
    (-> this (.getValueIsAdjusting))))

(defn add-list-selection-listener
  "Adds a listener to the list, to be notified each time a change to the
   selection occurs; the preferred way of listening for selection state
   changes. JList takes care of listening for selection state
   changes in the selection model, and notifies the given listener of
   each change. ListSelectionEvents sent to the listener have a
   source property set to this list.

  listener - the ListSelectionListener to add - `javax.swing.event.ListSelectionListener`"
  ([this listener]
    (-> this (.addListSelectionListener listener))))

(defn clear-selection
  "Clears the selection; after calling this method, isSelectionEmpty
   will return true. This is a cover method that delegates to the
   method of the same name on the list's selection model."
  ([this]
    (-> this (.clearSelection))))

(defn set-cell-renderer
  "Sets the delegate that is used to paint each cell in the list.
   The job of a cell renderer is discussed in detail in the
   class level documentation.

   If the prototypeCellValue property is non-null,
   setting the cell renderer also causes the fixedCellWidth and
   fixedCellHeight properties to be re-calculated. Only one
   PropertyChangeEvent is generated however -
   for the cellRenderer property.

   The default value of this property is provided by the ListUI
   delegate, i.e. by the look and feel implementation.

   This is a JavaBeans bound property.

  cell-renderer - the ListCellRenderer that paints list cells - `JList.E>`"
  ([this cell-renderer]
    (-> this (.setCellRenderer cell-renderer))))

(defn get-lead-selection-index
  "Returns the lead selection index. This is a cover method that
   delegates to the method of the same name on the list's selection model.

  returns: the lead selection index - `int`"
  ([this]
    (-> this (.getLeadSelectionIndex))))

(defn set-visible-row-count
  "Sets the visibleRowCount property, which has different meanings
   depending on the layout orientation: For a VERTICAL layout
   orientation, this sets the preferred number of rows to display without
   requiring scrolling; for other orientations, it affects the wrapping of
   cells.

   In VERTICAL orientation:
   Setting this property affects the return value of the
   getPreferredScrollableViewportSize() method, which is used to
   calculate the preferred size of an enclosing viewport. See that method's
   documentation for more details.

   In HORIZONTAL_WRAP and VERTICAL_WRAP orientations:
   This affects how cells are wrapped. See the documentation of
   setLayoutOrientation(int) for more details.

   The default value of this property is 8.

   Calling this method with a negative value results in the property
   being set to 0.

   This is a JavaBeans bound property.

  visible-row-count - an integer specifying the preferred number of rows to display without requiring scrolling - `int`"
  ([this visible-row-count]
    (-> this (.setVisibleRowCount visible-row-count))))

(defn set-selection-foreground
  "Sets the color used to draw the foreground of selected items, which
   cell renderers can use to render text and graphics.
   DefaultListCellRenderer uses this color to draw the foreground
   of items in the selected state, as do the renderers installed by most
   ListUI implementations.

   The default value of this property is defined by the look and feel
   implementation.

   This is a JavaBeans bound property.

  selection-foreground - the Color to use in the foreground for selected list items - `java.awt.Color`"
  ([this selection-foreground]
    (-> this (.setSelectionForeground selection-foreground))))

(defn ensure-index-is-visible
  "Scrolls the list within an enclosing viewport to make the specified
   cell completely visible. This calls scrollRectToVisible with
   the bounds of the specified cell. For this method to work, the
   JList must be within a JViewport.

   If the given index is outside the list's range of cells, this method
   results in nothing.

  index - the index of the cell to make visible - `int`"
  ([this index]
    (-> this (.ensureIndexIsVisible index))))

(defn get-anchor-selection-index
  "Returns the anchor selection index. This is a cover method that
   delegates to the method of the same name on the list's selection model.

  returns: the anchor selection index - `int`"
  ([this]
    (-> this (.getAnchorSelectionIndex))))

(defn get-drop-mode
  "Returns the drop mode for this component.

  returns: the drop mode for this component - `javax.swing.DropMode`"
  ([this]
    (-> this (.getDropMode))))

(defn get-scrollable-block-increment
  "Returns the distance to scroll to expose the next or previous block.

   For vertical scrolling, the following rules are used:

   if scrolling down, returns the distance to scroll so that the last
   visible element becomes the first completely visible element
   if scrolling up, returns the distance to scroll so that the first
   visible element becomes the last completely visible element
   returns visibleRect.height if the list is empty


   For horizontal scrolling, when the layout orientation is either
   VERTICAL_WRAP or HORIZONTAL_WRAP:

   if scrolling right, returns the distance to scroll so that the
   last visible element becomes
   the first completely visible element
   if scrolling left, returns the distance to scroll so that the first
   visible element becomes the last completely visible element
   returns visibleRect.width if the list is empty


   For horizontal scrolling and VERTICAL orientation,
   returns visibleRect.width.

   Note that the value of visibleRect must be the equal to
   this.getVisibleRect().

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - SwingConstants.HORIZONTAL or SwingConstants.VERTICAL - `int`
  direction - less or equal to zero to scroll up/back, greater than zero for down/forward - `int`

  returns: the `block` increment for scrolling in the specified direction;
           always positive - `int`

  throws: java.lang.IllegalArgumentException - if visibleRect is null, or orientation isn't one of SwingConstants.VERTICAL or SwingConstants.HORIZONTAL"
  ([this visible-rect orientation direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn set-drop-mode
  "Sets the drop mode for this component. For backward compatibility,
   the default for this property is DropMode.USE_SELECTION.
   Usage of one of the other modes is recommended, however, for an
   improved user experience. DropMode.ON, for instance,
   offers similar behavior of showing items as selected, but does so without
   affecting the actual selection in the list.

   JList supports the following drop modes:

      DropMode.USE_SELECTION
      DropMode.ON
      DropMode.INSERT
      DropMode.ON_OR_INSERT

   The drop mode is only meaningful if this component has a
   TransferHandler that accepts drops.

  drop-mode - the drop mode to use - `javax.swing.DropMode`

  throws: java.lang.IllegalArgumentException - if the drop mode is unsupported or null"
  ([this drop-mode]
    (-> this (.setDropMode drop-mode))))

(defn get-selection-foreground
  "Returns the color used to draw the foreground of selected items.
   DefaultListCellRenderer uses this color to draw the foreground
   of items in the selected state, as do the renderers installed by most
   ListUI implementations.

  returns: the color to draw the foreground of selected items - `java.awt.Color`"
  ([this]
    (-> this (.getSelectionForeground))))

(defn selected-index?
  "Returns true if the specified index is selected,
   else false. This is a cover method that delegates to the method
   of the same name on the list's selection model.

  index - index to be queried for selection state - `int`

  returns: true if the specified index is selected,
           else false - `boolean`"
  ([this index]
    (-> this (.isSelectedIndex index))))

(defn set-fixed-cell-height
  "Sets a fixed value to be used for the height of every cell in the list.
   If height is -1, cell heights are computed in the ListUI
   by applying getPreferredSize to the cell renderer component
   for each list element.

   The default value of this property is -1.

   This is a JavaBeans bound property.

  height - the height to be used for for all cells in the list - `int`"
  ([this height]
    (-> this (.setFixedCellHeight height))))

(defn get-ui-class-id
  "Returns `ListUI`, the UIDefaults key used to look
   up the name of the javax.swing.plaf.ListUI class that defines
   the look and feel for this component.

  returns: the string `ListUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn set-fixed-cell-width
  "Sets a fixed value to be used for the width of every cell in the list.
   If width is -1, cell widths are computed in the ListUI
   by applying getPreferredSize to the cell renderer component
   for each list element.

   The default value of this property is -1.

   This is a JavaBeans bound property.

  width - the width to be used for all cells in the list - `int`"
  ([this width]
    (-> this (.setFixedCellWidth width))))

(defn get-selected-index
  "Returns the smallest selected cell index; the selection when only
   a single item is selected in the list. When multiple items are selected,
   it is simply the smallest selected index. Returns -1 if there is
   no selection.

   This method is a cover that delegates to getMinSelectionIndex.

  returns: the smallest selected cell index - `int`"
  ([this]
    (-> this (.getSelectedIndex))))

(defn set-selection-model
  "Sets the selectionModel for the list to a
   non-null ListSelectionModel
   implementation. The selection model handles the task of making single
   selections, selections of contiguous ranges, and non-contiguous
   selections.

   This is a JavaBeans bound property.

  selection-model - the ListSelectionModel that implements the selections - `javax.swing.ListSelectionModel`

  throws: java.lang.IllegalArgumentException - if selectionModel is null"
  ([this selection-model]
    (-> this (.setSelectionModel selection-model))))

(defn location-to-index
  "Returns the cell index closest to the given location in the list's
   coordinate system. To determine if the cell actually contains the
   specified location, compare the point against the cell's bounds,
   as provided by getCellBounds. This method returns -1
   if the model is empty

   This is a cover method that delegates to the method of the same name
   in the list's ListUI. It returns -1 if the list has
   no ListUI.

  location - the coordinates of the point - `java.awt.Point`

  returns: the cell index closest to the given location, or -1 - `int`"
  ([this location]
    (-> this (.locationToIndex location))))

(defn set-selection-interval
  "Selects the specified interval. Both anchor and lead
   indices are included. anchor doesn't have to be less than or
   equal to lead. This is a cover method that delegates to the
   method of the same name on the list's selection model.

   Refer to the documentation of the selection model class being used
   for details on how values less than 0 are handled.

  anchor - the first index to select - `int`
  lead - the last index to select - `int`"
  ([this anchor lead]
    (-> this (.setSelectionInterval anchor lead))))

(defn get-scrollable-unit-increment
  "Returns the distance to scroll to expose the next or previous
   row (for vertical scrolling) or column (for horizontal scrolling).

   For horizontal scrolling, if the layout orientation is VERTICAL,
   then the list's font size is returned (or 1 if the font is
   null).

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - SwingConstants.HORIZONTAL or SwingConstants.VERTICAL - `int`
  direction - less or equal to zero to scroll up/back, greater than zero for down/forward - `int`

  returns: the `unit` increment for scrolling in the specified direction;
           always positive - `int`

  throws: java.lang.IllegalArgumentException - if visibleRect is null, or orientation isn't one of SwingConstants.VERTICAL or SwingConstants.HORIZONTAL"
  ([this visible-rect orientation direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn set-prototype-cell-value
  "Sets the prototypeCellValue property, and then (if the new value
   is non-null), computes the fixedCellWidth and
   fixedCellHeight properties by requesting the cell renderer
   component for the given value (and index 0) from the cell renderer, and
   using that component's preferred size.

   This method is useful when the list is too long to allow the
   ListUI to compute the width/height of each cell, and there is a
   single cell value that is known to occupy as much space as any of the
   others, a so-called prototype.

   While all three of the prototypeCellValue,
   fixedCellHeight, and fixedCellWidth properties may be
   modified by this method, PropertyChangeEvent notifications are
   only sent when the prototypeCellValue property changes.

   To see an example which sets this property, see the
   class description above.

   The default value of this property is null.

   This is a JavaBeans bound property.

  prototype-cell-value - the value on which to base fixedCellWidth and fixedCellHeight - `JList.E`"
  ([this prototype-cell-value]
    (-> this (.setPrototypeCellValue prototype-cell-value))))

(defn get-last-visible-index
  "Returns the largest list index that is currently visible.
   If nothing is visible or the list is empty, -1 is returned.
   Note that the returned cell may only be partially visible.

  returns: the index of the last visible cell - `int`"
  ([this]
    (-> this (.getLastVisibleIndex))))

(defn get-layout-orientation
  "Returns the layout orientation property for the list: VERTICAL
   if the layout is a single column of cells, VERTICAL_WRAP if the
   layout is `newspaper style` with the content flowing vertically then
   horizontally, or HORIZONTAL_WRAP if the layout is `newspaper
   style` with the content flowing horizontally then vertically.

  returns: the value of the layoutOrientation property - `int`"
  ([this]
    (-> this (.getLayoutOrientation))))

(defn get-selection-model
  "Returns the current selection model. The selection model maintains the
   selection state of the list. See the class level documentation for more
   details.

  returns: the ListSelectionModel that maintains the
           list's selections - `javax.swing.ListSelectionModel`"
  ([this]
    (-> this (.getSelectionModel))))

(defn get-drop-location
  "Returns the location that this component should visually indicate
   as the drop location during a DnD operation over the component,
   or null if no location is to currently be shown.

   This method is not meant for querying the drop location
   from a TransferHandler, as the drop location is only
   set after the TransferHandler's canImport
   has returned and has allowed for the location to be shown.

   When this property changes, a property change event with
   name `dropLocation` is fired by the component.

   By default, responsibility for listening for changes to this property
   and indicating the drop location visually lies with the list's
   ListUI, which may paint it directly and/or install a cell
   renderer to do so. Developers wishing to implement custom drop location
   painting and/or replace the default cell renderer, may need to honor
   this property.

  returns: the drop location - `javax.swing.JList.DropLocation`"
  ([this]
    (-> this (.getDropLocation))))

(defn remove-selection-interval
  "Sets the selection to be the set difference of the specified interval
   and the current selection. Both the index0 and index1
   indices are removed. index0 doesn't have to be less than or
   equal to index1. This is a cover method that delegates to the
   method of the same name on the list's selection model.

   Refer to the documentation of the selection model class being used
   for details on how values less than 0 are handled.

  index-0 - the first index to remove from the selection - `int`
  index-1 - the last index to remove from the selection - `int`"
  ([this index-0 index-1]
    (-> this (.removeSelectionInterval index-0 index-1))))

(defn get-preferred-scrollable-viewport-size
  "Computes the size of viewport needed to display visibleRowCount
   rows. The value returned by this method depends on the layout
   orientation:

   VERTICAL:

   This is trivial if both fixedCellWidth and fixedCellHeight
   have been set (either explicitly or by specifying a prototype cell value).
   The width is simply the fixedCellWidth plus the list's horizontal
   insets. The height is the fixedCellHeight multiplied by the
   visibleRowCount, plus the list's vertical insets.

   If either fixedCellWidth or fixedCellHeight haven't been
   specified, heuristics are used. If the model is empty, the width is
   the fixedCellWidth, if greater than 0, or a hard-coded
   value of 256. The height is the fixedCellHeight multiplied
   by visibleRowCount, if fixedCellHeight is greater than
   0, otherwise it is a hard-coded value of 16 multiplied by
   visibleRowCount.

   If the model isn't empty, the width is the preferred size's width,
   typically the width of the widest list element. The height is the
   fixedCellHeight multiplied by the visibleRowCount,
   plus the list's vertical insets.

   VERTICAL_WRAP or HORIZONTAL_WRAP:

   This method simply returns the value from getPreferredSize.
   The list's ListUI is expected to override getPreferredSize
   to return an appropriate value.

  returns: a dimension containing the size of the viewport needed
            to display visibleRowCount rows - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn get-cell-renderer
  "Returns the object responsible for painting list items.

  returns: the value of the cellRenderer property - `javax.swing.ListCellRenderer<? super JList.E>`"
  ([this]
    (-> this (.getCellRenderer))))

(defn add-selection-interval
  "Sets the selection to be the union of the specified interval with current
   selection. Both the anchor and lead indices are
   included. anchor doesn't have to be less than or
   equal to lead. This is a cover method that delegates to the
   method of the same name on the list's selection model.

   Refer to the documentation of the selection model class being used
   for details on how values less than 0 are handled.

  anchor - the first index to add to the selection - `int`
  lead - the last index to add to the selection - `int`"
  ([this anchor lead]
    (-> this (.addSelectionInterval anchor lead))))

(defn get-selected-values
  "Deprecated. As of JDK 1.7, replaced by getSelectedValuesList()

  returns: the selected values, or an empty array if nothing is selected - `java.lang.  java.lang.Object[]`"
  ([this]
    (-> this (.getSelectedValues))))

(defn set-ui
  "Sets the ListUI, the look and feel object that
   renders this component.

  ui - the ListUI object - `javax.swing.plaf.ListUI`"
  ([this ui]
    (-> this (.setUI ui))))

(defn remove-list-selection-listener
  "Removes a selection listener from the list.

  listener - the ListSelectionListener to remove - `javax.swing.event.ListSelectionListener`"
  ([this listener]
    (-> this (.removeListSelectionListener listener))))

(defn get-tool-tip-text
  "Returns the tooltip text to be used for the given event. This overrides
   JComponent's getToolTipText to first check the cell
   renderer component for the cell over which the event occurred, returning
   its tooltip text, if any. This implementation allows you to specify
   tooltip text on the cell level, by using setToolTipText on your
   cell renderer component.

   Note: For JList to properly display the
   tooltips of its renderers in this manner, JList must be a
   registered component with the ToolTipManager. This registration
   is done automatically in the constructor. However, if at a later point
   JList is unregistered, by way of a call to
   setToolTipText(null), tips from the renderers will no longer display.

  event - the MouseEvent to fetch the tooltip text for - `java.awt.event.MouseEvent`

  returns: `java.lang.String`"
  ([this event]
    (-> this (.getToolTipText event))))

(defn get-selected-indices
  "Returns an array of all of the selected indices, in increasing
   order.

  returns: all of the selected indices, in increasing order,
           or an empty array if nothing is selected - `int[]`"
  ([this]
    (-> this (.getSelectedIndices))))

(defn set-drag-enabled
  "Turns on or off automatic drag handling. In order to enable automatic
   drag handling, this property should be set to true, and the
   list's TransferHandler needs to be non-null.
   The default value of the dragEnabled property is false.

   The job of honoring this property, and recognizing a user drag gesture,
   lies with the look and feel implementation, and in particular, the list's
   ListUI. When automatic drag handling is enabled, most look and
   feels (including those that subclass BasicLookAndFeel) begin a
   drag and drop operation whenever the user presses the mouse button over
   an item and then moves the mouse a few pixels. Setting this property to
   true can therefore have a subtle effect on how selections behave.

   If a look and feel is used that ignores this property, you can still
   begin a drag and drop operation by calling exportAsDrag on the
   list's TransferHandler.

  b - whether or not to enable automatic drag handling - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([this b]
    (-> this (.setDragEnabled b))))

(defn get-max-selection-index
  "Returns the largest selected cell index, or -1 if the selection
   is empty. This is a cover method that delegates to the method of the same
   name on the list's selection model.

  returns: the largest selected cell index - `int`"
  ([this]
    (-> this (.getMaxSelectionIndex))))

(defn get-ui
  "Returns the ListUI, the look and feel object that
   renders this component.

  returns: the ListUI object that renders this component - `javax.swing.plaf.ListUI`"
  ([this]
    (-> this (.getUI))))

(defn selection-empty?
  "Returns true if nothing is selected, else false.
   This is a cover method that delegates to the method of the same
   name on the list's selection model.

  returns: true if nothing is selected, else false - `boolean`"
  ([this]
    (-> this (.isSelectionEmpty))))

(defn get-min-selection-index
  "Returns the smallest selected cell index, or -1 if the selection
   is empty. This is a cover method that delegates to the method of the same
   name on the list's selection model.

  returns: the smallest selected cell index, or -1 - `int`"
  ([this]
    (-> this (.getMinSelectionIndex))))

(defn set-value-is-adjusting
  "Sets the selection model's valueIsAdjusting property. When
   true, upcoming changes to selection should be considered part
   of a single change. This property is used internally and developers
   typically need not call this method. For example, when the model is being
   updated in response to a user drag, the value of the property is set
   to true when the drag is initiated and set to false
   when the drag is finished. This allows listeners to update only
   when a change has been finalized, rather than handling all of the
   intermediate values.

   You may want to use this directly if making a series of changes
   that should be considered part of a single change.

   This is a cover method that delegates to the method of the same name on
   the list's selection model. See the documentation for
   ListSelectionModel.setValueIsAdjusting(boolean) for
   more details.

  b - the new value for the property - `boolean`"
  ([this b]
    (-> this (.setValueIsAdjusting b))))

(defn get-scrollable-tracks-viewport-width?
  "Returns true if this JList is displayed in a
   JViewport and the viewport is wider than the list's
   preferred width, or if the layout orientation is HORIZONTAL_WRAP
   and visibleRowCount <= 0; otherwise returns false.

   If false, then don't track the viewport's width. This allows
   horizontal scrolling if the JViewport is itself embedded in a
   JScrollPane.

  returns: whether or not an enclosing viewport should force the list's
           width to match its own - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-visible-row-count
  "Returns the value of the visibleRowCount property. See the
   documentation for setVisibleRowCount(int) for details on how to
   interpret this value.

  returns: the value of the visibleRowCount property. - `int`"
  ([this]
    (-> this (.getVisibleRowCount))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JList.
   For JList, the AccessibleContext takes the form of an
   AccessibleJList.

   A new AccessibleJList instance is created if necessary.

  returns: an AccessibleJList that serves as the
           AccessibleContext of this JList - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn index-to-location
  "Returns the origin of the specified item in the list's coordinate
   system. This method returns null if the index isn't valid.

   This is a cover method that delegates to the method of the same name
   in the list's ListUI. It returns null if the list has
   no ListUI.

  index - the cell index - `int`

  returns: the origin of the cell, or null - `java.awt.Point`"
  ([this index]
    (-> this (.indexToLocation index))))

(defn get-list-selection-listeners
  "Returns an array of all the ListSelectionListeners added
   to this JList by way of addListSelectionListener.

  returns: all of the ListSelectionListeners on this list, or
           an empty array if no listeners have been added - `javax.swing.event.ListSelectionListener[]`"
  ([this]
    (-> this (.getListSelectionListeners))))

(defn set-selected-value
  "Selects the specified object from the list.

  an-object - the object to select - `java.lang.Object`
  should-scroll - true if the list should scroll to display the selected object, if one exists; otherwise false - `boolean`"
  ([this an-object should-scroll]
    (-> this (.setSelectedValue an-object should-scroll))))

(defn set-selected-indices
  "Changes the selection to be the set of indices specified by the given
   array. Indices greater than or equal to the model size are ignored.
   This is a convenience method that clears the selection and then uses
   addSelectionInterval on the selection model to add the indices.
   Refer to the documentation of the selection model class being used for
   details on how values less than 0 are handled.

  indices - an array of the indices of the cells to select, non-null - `int[]`

  throws: java.lang.NullPointerException - if the given array is null"
  ([this indices]
    (-> this (.setSelectedIndices indices))))

(defn get-first-visible-index
  "Returns the smallest list index that is currently visible.
   In a left-to-right componentOrientation, the first visible
   cell is found closest to the list's upper-left corner. In right-to-left
   orientation, it is found closest to the upper-right corner.
   If nothing is visible or the list is empty, -1 is returned.
   Note that the returned cell may only be partially visible.

  returns: the index of the first visible cell - `int`"
  ([this]
    (-> this (.getFirstVisibleIndex))))

(defn get-scrollable-tracks-viewport-height?
  "Returns true if this JList is displayed in a
   JViewport and the viewport is taller than the list's
   preferred height, or if the layout orientation is VERTICAL_WRAP
   and visibleRowCount <= 0; otherwise returns false.

   If false, then don't track the viewport's height. This allows
   vertical scrolling if the JViewport is itself embedded in a
   JScrollPane.

  returns: whether or not an enclosing viewport should force the list's
           height to match its own - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn get-selection-mode
  "Returns the current selection mode for the list. This is a cover
   method that delegates to the method of the same name on the
   list's selection model.

  returns: the current selection mode - `int`"
  ([this]
    (-> this (.getSelectionMode))))

(defn get-drag-enabled?
  "Returns whether or not automatic drag handling is enabled.

  returns: the value of the dragEnabled property - `boolean`"
  ([this]
    (-> this (.getDragEnabled))))

(defn set-selected-index
  "Selects a single cell. Does nothing if the given index is greater
   than or equal to the model size. This is a convenience method that uses
   setSelectionInterval on the selection model. Refer to the
   documentation for the selection model class being used for details on
   how values less than 0 are handled.

  index - the index of the cell to select - `int`"
  ([this index]
    (-> this (.setSelectedIndex index))))

(defn get-selected-values-list
  "Returns a list of all the selected items, in increasing order based
   on their indices in the list.

  returns: the selected items, or an empty list if nothing is selected - `java.util.List<JList.E>`"
  ([this]
    (-> this (.getSelectedValuesList))))

(defn set-list-data
  "Constructs a read-only ListModel from an array of items,
   and calls setModel with this model.

   Attempts to pass a null value to this method results in
   undefined behavior and, most likely, exceptions. The created model
   references the given array directly. Attempts to modify the array
   after invoking this method results in undefined behavior.

  list-data - an array of E containing the items to display in the list - `JList.E[]`"
  ([this list-data]
    (-> this (.setListData list-data))))

(defn get-cell-bounds
  "Returns the bounding rectangle, in the list's coordinate system,
   for the range of cells specified by the two indices.
   These indices can be supplied in any order.

   If the smaller index is outside the list's range of cells, this method
   returns null. If the smaller index is valid, but the larger
   index is outside the list's range, the bounds of just the first index
   is returned. Otherwise, the bounds of the valid range is returned.

   This is a cover method that delegates to the method of the same name
   in the list's ListUI. It returns null if the list has
   no ListUI.

  index-0 - the first index in the range - `int`
  index-1 - the second index in the range - `int`

  returns: the bounding rectangle for the range of cells, or null - `java.awt.Rectangle`"
  ([this index-0 index-1]
    (-> this (.getCellBounds index-0 index-1))))

(defn get-fixed-cell-width
  "Returns the value of the fixedCellWidth property.

  returns: the fixed cell width - `int`"
  ([this]
    (-> this (.getFixedCellWidth))))

(defn get-model
  "Returns the data model that holds the list of items displayed
   by the JList component.

  returns: the ListModel that provides the displayed
                            list of items - `javax.swing.ListModel<JList.E>`"
  ([this]
    (-> this (.getModel))))

(defn get-selected-value
  "Returns the value for the smallest selected cell index;
   the selected value when only a single item is selected in the
   list. When multiple items are selected, it is simply the value for the
   smallest selected index. Returns null if there is no selection.

   This is a convenience method that simply returns the model value for
   getMinSelectionIndex.

  returns: the first selected value - `JList.E`"
  ([this]
    (-> this (.getSelectedValue))))

(defn get-prototype-cell-value
  "Returns the `prototypical` cell value -- a value used to calculate a
   fixed width and height for cells. This can be null if there
   is no such value.

  returns: the value of the prototypeCellValue property - `JList.E`"
  ([this]
    (-> this (.getPrototypeCellValue))))

(defn set-model
  "Sets the model that represents the contents or `value` of the
   list, notifies property change listeners, and then clears the
   list's selection.

   This is a JavaBeans bound property.

  model - the ListModel that provides the list of items for display - `javax.swing.ListModel<JList.E>`

  throws: java.lang.IllegalArgumentException - if model is null"
  ([this model]
    (-> this (.setModel model))))

(defn update-ui
  "Resets the ListUI property by setting it to the value provided
   by the current look and feel. If the current cell renderer was installed
   by the developer (rather than the look and feel itself), this also causes
   the cell renderer and its children to be updated, by calling
   SwingUtilities.updateComponentTreeUI on it."
  ([this]
    (-> this (.updateUI))))

(defn set-selection-mode
  "Sets the selection mode for the list. This is a cover method that sets
   the selection mode directly on the selection model.

   The following list describes the accepted selection modes:

   ListSelectionModel.SINGLE_SELECTION -
     Only one list index can be selected at a time. In this mode,
     setSelectionInterval and addSelectionInterval are
     equivalent, both replacing the current selection with the index
     represented by the second argument (the `lead`).
   ListSelectionModel.SINGLE_INTERVAL_SELECTION -
     Only one contiguous interval can be selected at a time.
     In this mode, addSelectionInterval behaves like
     setSelectionInterval (replacing the current selection},
     unless the given interval is immediately adjacent to or overlaps
     the existing selection, and can be used to grow the selection.
   ListSelectionModel.MULTIPLE_INTERVAL_SELECTION -
     In this mode, there's no restriction on what can be selected.
     This mode is the default.

  selection-mode - the selection mode - `int`

  throws: java.lang.IllegalArgumentException - if the selection mode isn't one of those allowed"
  ([this selection-mode]
    (-> this (.setSelectionMode selection-mode))))

(defn get-next-match
  "Returns the next list element whose toString value
   starts with the given prefix.

  prefix - the string to test for a match - `java.lang.String`
  start-index - the index for starting the search - `int`
  bias - the search direction, either Position.Bias.Forward or Position.Bias.Backward. - `javax.swing.text.Position.Bias`

  returns: the index of the next list element that
   starts with the prefix; otherwise -1 - `int`

  throws: java.lang.IllegalArgumentException - if prefix is null or startIndex is out of bounds"
  ([this prefix start-index bias]
    (-> this (.getNextMatch prefix start-index bias))))

