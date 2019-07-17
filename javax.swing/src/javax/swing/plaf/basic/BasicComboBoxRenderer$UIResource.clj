(ns javax.swing.plaf.basic.BasicComboBoxRenderer$UIResource
  "A subclass of BasicComboBoxRenderer that implements UIResource.
  BasicComboBoxRenderer doesn't implement UIResource
  directly so that applications can safely override the
  cellRenderer property with BasicListCellRenderer subclasses.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicComboBoxRenderer$UIResource]))

(defn ->ui-resource
  "Constructor."
  ([]
    (new BasicComboBoxRenderer$UIResource )))

