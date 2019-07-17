(ns javax.swing.plaf.metal.MetalScrollButton
  "JButton object for Metal scrollbar arrows.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalScrollButton]))

(defn ->metal-scroll-button
  "Constructor.

  direction - `int`
  width - `int`
  free-standing - `boolean`"
  ([^Integer direction ^Integer width ^Boolean free-standing]
    (new MetalScrollButton direction width free-standing)))

(defn set-free-standing
  "free-standing - `boolean`"
  ([^javax.swing.plaf.metal.MetalScrollButton this ^Boolean free-standing]
    (-> this (.setFreeStanding free-standing))))

(defn paint
  "Description copied from class: JComponent

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([^javax.swing.plaf.metal.MetalScrollButton this ^java.awt.Graphics g]
    (-> this (.paint g))))

(defn get-preferred-size
  "Description copied from class: BasicArrowButton

  returns: the preferred size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalScrollButton this]
    (-> this (.getPreferredSize))))

(defn get-minimum-size
  "Description copied from class: BasicArrowButton

  returns: the minimum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalScrollButton this]
    (-> this (.getMinimumSize))))

(defn get-maximum-size
  "Description copied from class: BasicArrowButton

  returns: the maximum size - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalScrollButton this]
    (-> this (.getMaximumSize))))

(defn get-button-width
  "returns: `int`"
  (^Integer [^javax.swing.plaf.metal.MetalScrollButton this]
    (-> this (.getButtonWidth))))

