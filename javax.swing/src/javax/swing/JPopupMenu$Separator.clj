(ns javax.swing.JPopupMenu$Separator
  "A popup menu-specific separator."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JPopupMenu$Separator]))

(defn ->separator
  "Constructor."
  (^JPopupMenu$Separator []
    (new JPopupMenu$Separator )))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `PopupMenuSeparatorUI` - `java.lang.String`"
  (^java.lang.String [^JPopupMenu$Separator this]
    (-> this (.getUIClassID))))

