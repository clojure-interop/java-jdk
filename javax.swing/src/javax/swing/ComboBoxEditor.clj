(ns javax.swing.ComboBoxEditor
  "The editor component used for JComboBox components."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ComboBoxEditor]))

(defn get-editor-component
  "Return the component that should be added to the tree hierarchy for
   this editor

  returns: `java.awt.Component`"
  (^java.awt.Component [^javax.swing.ComboBoxEditor this]
    (-> this (.getEditorComponent))))

(defn set-item
  "Set the item that should be edited. Cancel any editing if necessary

  an-object - `java.lang.Object`"
  ([^javax.swing.ComboBoxEditor this ^java.lang.Object an-object]
    (-> this (.setItem an-object))))

(defn get-item
  "Return the edited item

  returns: `java.lang.Object`"
  (^java.lang.Object [^javax.swing.ComboBoxEditor this]
    (-> this (.getItem))))

(defn select-all
  "Ask the editor to start editing and to select everything"
  ([^javax.swing.ComboBoxEditor this]
    (-> this (.selectAll))))

(defn add-action-listener
  "Add an ActionListener. An action event is generated when the edited item changes

  l - `java.awt.event.ActionListener`"
  ([^javax.swing.ComboBoxEditor this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn remove-action-listener
  "Remove an ActionListener

  l - `java.awt.event.ActionListener`"
  ([^javax.swing.ComboBoxEditor this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

