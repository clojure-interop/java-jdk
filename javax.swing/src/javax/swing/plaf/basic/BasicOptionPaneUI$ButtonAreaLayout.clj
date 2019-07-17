(ns javax.swing.plaf.basic.BasicOptionPaneUI$ButtonAreaLayout
  "ButtonAreaLayout behaves in a similar manner to
  FlowLayout. It lays out all components from left to
  right. If syncAllWidths is true, the widths of each
  component will be set to the largest preferred size width.

  This class should be treated as a `protected` inner class.
  Instantiate it only within subclasses of BasicOptionPaneUI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicOptionPaneUI$ButtonAreaLayout]))

(defn ->button-area-layout
  "Constructor.

  sync-all-widths - `boolean`
  padding - `int`"
  ([sync-all-widths padding]
    (new BasicOptionPaneUI$ButtonAreaLayout sync-all-widths padding)))

(defn set-sync-all-widths
  "new-value - `boolean`"
  ([this new-value]
    (-> this (.setSyncAllWidths new-value))))

(defn get-sync-all-widths?
  "returns: `boolean`"
  ([this]
    (-> this (.getSyncAllWidths))))

(defn preferred-layout-size
  "Description copied from interface: LayoutManager

  c - the container to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([this c]
    (-> this (.preferredLayoutSize c))))

(defn get-centers-children?
  "returns: `boolean`"
  ([this]
    (-> this (.getCentersChildren))))

(defn minimum-layout-size
  "Description copied from interface: LayoutManager

  c - the component to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([this c]
    (-> this (.minimumLayoutSize c))))

(defn set-padding
  "new-padding - `int`"
  ([this new-padding]
    (-> this (.setPadding new-padding))))

(defn get-padding
  "returns: `int`"
  ([this]
    (-> this (.getPadding))))

(defn set-centers-children
  "new-value - `boolean`"
  ([this new-value]
    (-> this (.setCentersChildren new-value))))

(defn add-layout-component
  "Description copied from interface: LayoutManager

  string - the string to be associated with the component - `java.lang.String`
  comp - the component to be added - `java.awt.Component`"
  ([this string comp]
    (-> this (.addLayoutComponent string comp))))

(defn remove-layout-component
  "Description copied from interface: LayoutManager

  c - the component to be removed - `java.awt.Component`"
  ([this c]
    (-> this (.removeLayoutComponent c))))

(defn layout-container
  "Description copied from interface: LayoutManager

  container - the container to be laid out - `java.awt.Container`"
  ([this container]
    (-> this (.layoutContainer container))))

