(ns javax.swing.plaf.basic.BasicBorders
  "Factory object that can vend Borders appropriate for the basic L & F."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicBorders]))

(defn ->basic-borders
  "Constructor."
  (^BasicBorders []
    (new BasicBorders )))

(defn *get-text-field-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getTextFieldBorder )))

(defn *get-progress-bar-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getProgressBarBorder )))

(defn *get-menu-bar-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getMenuBarBorder )))

(defn *get-internal-frame-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getInternalFrameBorder )))

(defn *get-button-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getButtonBorder )))

(defn *get-split-pane-divider-border
  "Returns a border instance for a JSplitPane divider

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getSplitPaneDividerBorder )))

(defn *get-split-pane-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getSplitPaneBorder )))

(defn *get-radio-button-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getRadioButtonBorder )))

(defn *get-toggle-button-border
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BasicBorders/getToggleButtonBorder )))

