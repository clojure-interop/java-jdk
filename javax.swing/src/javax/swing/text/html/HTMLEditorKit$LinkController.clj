(ns javax.swing.text.html.HTMLEditorKit$LinkController
  "Class to watch the associated component and fire
  hyperlink events on it when appropriate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit$LinkController]))

(defn ->link-controller
  "Constructor."
  (^HTMLEditorKit$LinkController []
    (new HTMLEditorKit$LinkController )))

(defn mouse-clicked
  "Called for a mouse click event.
   If the component is read-only (ie a browser) then
   the clicked event is used to drive an attempt to
   follow the reference specified by a link.

  e - the mouse event - `java.awt.event.MouseEvent`"
  ([^HTMLEditorKit$LinkController this e]
    (-> this (.mouseClicked e))))

(defn mouse-dragged
  "Description copied from class: MouseAdapter

  e - `java.awt.event.MouseEvent`"
  ([^HTMLEditorKit$LinkController this e]
    (-> this (.mouseDragged e))))

(defn mouse-moved
  "Description copied from class: MouseAdapter

  e - `java.awt.event.MouseEvent`"
  ([^HTMLEditorKit$LinkController this e]
    (-> this (.mouseMoved e))))

