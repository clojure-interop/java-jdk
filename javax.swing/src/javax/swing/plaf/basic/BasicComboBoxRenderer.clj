(ns javax.swing.plaf.basic.BasicComboBoxRenderer
  "ComboBox renderer

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicComboBoxRenderer]))

(defn ->basic-combo-box-renderer
  "Constructor."
  (^BasicComboBoxRenderer []
    (new BasicComboBoxRenderer )))

(defn get-preferred-size
  "Description copied from class: JComponent

  returns: the value of the preferredSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicComboBoxRenderer this]
    (-> this (.getPreferredSize))))

(defn get-list-cell-renderer-component
  "Description copied from interface: ListCellRenderer

  list - The JList we're painting. - `javax.swing.JList`
  value - The value returned by list.getModel().getElementAt(index). - `java.lang.Object`
  index - The cells index. - `int`
  is-selected - True if the specified cell was selected. - `boolean`
  cell-has-focus - True if the specified cell has the focus. - `boolean`

  returns: A component whose paint() method will render the specified value. - `java.awt.Component`"
  (^java.awt.Component [^BasicComboBoxRenderer this ^javax.swing.JList list ^java.lang.Object value ^Integer index ^Boolean is-selected ^Boolean cell-has-focus]
    (-> this (.getListCellRendererComponent list value index is-selected cell-has-focus))))

