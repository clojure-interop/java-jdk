(ns javax.swing.JToolBar$Separator
  "A toolbar-specific separator. An object with dimension but
  no contents used to divide buttons on a tool bar into groups."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JToolBar$Separator]))

(defn ->separator
  "Constructor.

  Creates a new toolbar separator with the specified size.

  size - the Dimension of the separator - `java.awt.Dimension`"
  ([^java.awt.Dimension size]
    (new JToolBar$Separator size))
  ([]
    (new JToolBar$Separator )))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `ToolBarSeparatorUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JToolBar$Separator this]
    (-> this (.getUIClassID))))

(defn set-separator-size
  "Sets the size of the separator.

  size - the new Dimension of the separator - `java.awt.Dimension`"
  ([^javax.swing.JToolBar$Separator this ^java.awt.Dimension size]
    (-> this (.setSeparatorSize size))))

(defn get-separator-size
  "Returns the size of the separator

  returns: the Dimension object containing the separator's
           size (This is a reference, NOT a copy!) - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.JToolBar$Separator this]
    (-> this (.getSeparatorSize))))

(defn get-minimum-size
  "Returns the minimum size for the separator.

  returns: the Dimension object containing the separator's
           minimum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.JToolBar$Separator this]
    (-> this (.getMinimumSize))))

(defn get-maximum-size
  "Returns the maximum size for the separator.

  returns: the Dimension object containing the separator's
           maximum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.JToolBar$Separator this]
    (-> this (.getMaximumSize))))

(defn get-preferred-size
  "Returns the preferred size for the separator.

  returns: the Dimension object containing the separator's
           preferred size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.JToolBar$Separator this]
    (-> this (.getPreferredSize))))

