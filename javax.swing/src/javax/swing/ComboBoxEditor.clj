(ns javax.swing.ComboBoxEditor
  "The editor component used for JComboBox components."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ComboBoxEditor]))

(defn get-editor-component
  "Return the component that should be added to the tree hierarchy for
   this editor

  returns: `java.awt.Component`"
  ([this]
    (-> this (.getEditorComponent))))

(defn set-item
  "Set the item that should be edited. Cancel any editing if necessary

  an-object - `java.lang.Object`"
  ([this an-object]
    (-> this (.setItem an-object))))

(defn get-item
  "Return the edited item

  returns: `java.lang.Object`"
  ([this]
    (-> this (.getItem))))

(defn select-all
  "Ask the editor to start editing and to select everything"
  ([this]
    (-> this (.selectAll))))

(defn add-action-listener
  "Add an ActionListener. An action event is generated when the edited item changes

  l - `java.awt.event.ActionListener`"
  ([this l]
    (-> this (.addActionListener l))))

(defn remove-action-listener
  "Remove an ActionListener

  l - `java.awt.event.ActionListener`"
  ([this l]
    (-> this (.removeActionListener l))))

