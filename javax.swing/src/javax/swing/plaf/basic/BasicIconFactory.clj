(ns javax.swing.plaf.basic.BasicIconFactory
  "Factory object that can vend Icons appropriate for the basic L & F.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicIconFactory]))

(defn ->basic-icon-factory
  "Constructor."
  ([]
    (new BasicIconFactory )))

(defn *get-menu-item-check-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getMenuItemCheckIcon )))

(defn *get-menu-item-arrow-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getMenuItemArrowIcon )))

(defn *get-menu-arrow-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getMenuArrowIcon )))

(defn *get-check-box-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getCheckBoxIcon )))

(defn *get-radio-button-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getRadioButtonIcon )))

(defn *get-check-box-menu-item-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getCheckBoxMenuItemIcon )))

(defn *get-radio-button-menu-item-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/getRadioButtonMenuItemIcon )))

(defn *create-empty-frame-icon
  "returns: `javax.swing.Icon`"
  ([]
    (BasicIconFactory/createEmptyFrameIcon )))

