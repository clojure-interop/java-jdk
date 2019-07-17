(ns javax.swing.plaf.basic.DefaultMenuLayout
  "The default layout manager for Popup menus and menubars.  This
  class is an extension of BoxLayout which adds the UIResource tag
  so that pluggable L&Fs can distinguish it from user-installed
  layout managers on menus."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic DefaultMenuLayout]))

(defn ->default-menu-layout
  "Constructor.

  target - `java.awt.Container`
  axis - `int`"
  ([target axis]
    (new DefaultMenuLayout target axis)))

(defn preferred-layout-size
  "Description copied from class: BoxLayout

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the dimensions >= 0 && <= Integer.MAX_VALUE - `java.awt.Dimension`"
  ([this target]
    (-> this (.preferredLayoutSize target))))

