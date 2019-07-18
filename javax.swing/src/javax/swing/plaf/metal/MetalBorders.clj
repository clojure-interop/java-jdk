(ns javax.swing.plaf.metal.MetalBorders
  "Factory object that can vend Borders appropriate for the metal L & F."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalBorders]))

(defn ->metal-borders
  "Constructor."
  (^MetalBorders []
    (new MetalBorders )))

(defn *get-button-border
  "Returns a border instance for a JButton

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (MetalBorders/getButtonBorder )))

(defn *get-text-border
  "Returns a border instance for a text component

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (MetalBorders/getTextBorder )))

(defn *get-text-field-border
  "Returns a border instance for a JTextField

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (MetalBorders/getTextFieldBorder )))

(defn *get-toggle-button-border
  "Returns a border instance for a JToggleButton

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (MetalBorders/getToggleButtonBorder )))

(defn *get-desktop-icon-border
  "Returns a border instance for a Desktop Icon

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (MetalBorders/getDesktopIconBorder )))

