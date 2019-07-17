(ns javax.swing.table.DefaultTableCellRenderer$UIResource
  "A subclass of DefaultTableCellRenderer that
  implements UIResource.
  DefaultTableCellRenderer doesn't implement
  UIResource
  directly so that applications can safely override the
  cellRenderer property with
  DefaultTableCellRenderer subclasses.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table DefaultTableCellRenderer$UIResource]))

(defn ->ui-resource
  "Constructor."
  ([]
    (new DefaultTableCellRenderer$UIResource )))

