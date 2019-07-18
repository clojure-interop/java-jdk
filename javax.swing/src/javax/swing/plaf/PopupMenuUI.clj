(ns javax.swing.plaf.PopupMenuUI
  "Pluggable look and feel interface for JPopupMenu."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf PopupMenuUI]))

(defn ->popup-menu-ui
  "Constructor."
  (^PopupMenuUI []
    (new PopupMenuUI )))

(defn popup-trigger?
  "e - `java.awt.event.MouseEvent`

  returns: `boolean`"
  (^Boolean [^PopupMenuUI this e]
    (-> this (.isPopupTrigger e))))

(defn get-popup
  "Returns the Popup that will be responsible for
   displaying the JPopupMenu.

  popup - JPopupMenu requesting Popup - `javax.swing.JPopupMenu`
  x - Screen x location Popup is to be shown at - `int`
  y - Screen y location Popup is to be shown at. - `int`

  returns: Popup that will show the JPopupMenu - `javax.swing.Popup`"
  (^javax.swing.Popup [^PopupMenuUI this ^javax.swing.JPopupMenu popup ^Integer x ^Integer y]
    (-> this (.getPopup popup x y))))

