(ns javax.swing.plaf.basic.BasicComboBoxEditor
  "The default editor for editable combo boxes. The editor is implemented as a JTextField."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicComboBoxEditor]))

(defn ->basic-combo-box-editor
  "Constructor."
  ([]
    (new BasicComboBoxEditor )))

(defn get-editor-component
  "Description copied from interface: ComboBoxEditor

  returns: `java.awt.Component`"
  (^java.awt.Component [^javax.swing.plaf.basic.BasicComboBoxEditor this]
    (-> this (.getEditorComponent))))

(defn set-item
  "Sets the item that should be edited.

  an-object - the displayed value of the editor - `java.lang.Object`"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this ^java.lang.Object an-object]
    (-> this (.setItem an-object))))

(defn get-item
  "Description copied from interface: ComboBoxEditor

  returns: `java.lang.Object`"
  (^java.lang.Object [^javax.swing.plaf.basic.BasicComboBoxEditor this]
    (-> this (.getItem))))

(defn select-all
  "Description copied from interface: ComboBoxEditor"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this]
    (-> this (.selectAll))))

(defn focus-gained
  "Description copied from interface: FocusListener

  e - `java.awt.event.FocusEvent`"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this ^java.awt.event.FocusEvent e]
    (-> this (.focusGained e))))

(defn focus-lost
  "Description copied from interface: FocusListener

  e - `java.awt.event.FocusEvent`"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this ^java.awt.event.FocusEvent e]
    (-> this (.focusLost e))))

(defn add-action-listener
  "Description copied from interface: ComboBoxEditor

  l - `java.awt.event.ActionListener`"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn remove-action-listener
  "Description copied from interface: ComboBoxEditor

  l - `java.awt.event.ActionListener`"
  ([^javax.swing.plaf.basic.BasicComboBoxEditor this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

