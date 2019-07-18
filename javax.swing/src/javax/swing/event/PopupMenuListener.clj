(ns javax.swing.event.PopupMenuListener
  "A popup menu listener"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event PopupMenuListener]))

(defn popup-menu-will-become-visible
  "This method is called before the popup menu becomes visible

  e - `javax.swing.event.PopupMenuEvent`"
  ([^PopupMenuListener this ^javax.swing.event.PopupMenuEvent e]
    (-> this (.popupMenuWillBecomeVisible e))))

(defn popup-menu-will-become-invisible
  "This method is called before the popup menu becomes invisible
   Note that a JPopupMenu can become invisible any time

  e - `javax.swing.event.PopupMenuEvent`"
  ([^PopupMenuListener this ^javax.swing.event.PopupMenuEvent e]
    (-> this (.popupMenuWillBecomeInvisible e))))

(defn popup-menu-canceled
  "This method is called when the popup menu is canceled

  e - `javax.swing.event.PopupMenuEvent`"
  ([^PopupMenuListener this ^javax.swing.event.PopupMenuEvent e]
    (-> this (.popupMenuCanceled e))))

