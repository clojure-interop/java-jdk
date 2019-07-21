(ns javax.swing.ListCellRenderer
  "Identifies components that can be used as \"rubber stamps\" to paint
  the cells in a JList.  For example, to use a JLabel as a
  ListCellRenderer, you would write something like this:


  class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
      public MyCellRenderer() {
          setOpaque(true);
      }

      public Component getListCellRendererComponent(JList<?> list,
                                                    Object value,
                                                    int index,
                                                    boolean isSelected,
                                                    boolean cellHasFocus) {

          setText(value.toString());

          Color background;
          Color foreground;

          // check if this cell represents the current DnD drop location
          JList.DropLocation dropLocation = list.getDropLocation();
          if (dropLocation != null
                  && !dropLocation.isInsert()
                  && dropLocation.getIndex() == index) {

              background = Color.BLUE;
              foreground = Color.WHITE;

          // check if this cell is selected
          } else if (isSelected) {
              background = Color.RED;
              foreground = Color.WHITE;

          // unselected, and not the DnD drop location
          } else {
              background = Color.WHITE;
              foreground = Color.BLACK;
          };

          setBackground(background);
          setForeground(foreground);

          return this;
      }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ListCellRenderer]))

(defn get-list-cell-renderer-component
  "Return a component that has been configured to display the specified
   value. That component's paint method is then called to
   \"render\" the cell.  If it is necessary to compute the dimensions
   of a list because the list cells do not have a fixed size, this method
   is called to generate a component on which getPreferredSize
   can be invoked.

  list - The JList we're painting. - `javax.swing.JList`
  value - The value returned by list.getModel().getElementAt(index). - `E`
  index - The cells index. - `int`
  is-selected - True if the specified cell was selected. - `boolean`
  cell-has-focus - True if the specified cell has the focus. - `boolean`

  returns: A component whose paint() method will render the specified value. - `java.awt.Component`"
  (^java.awt.Component [^ListCellRenderer this ^javax.swing.JList list value ^Integer index ^Boolean is-selected ^Boolean cell-has-focus]
    (-> this (.getListCellRendererComponent list value index is-selected cell-has-focus))))

