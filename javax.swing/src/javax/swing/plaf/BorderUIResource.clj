(ns javax.swing.plaf.BorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource]))

(defn ->border-ui-resource
  "Constructor.

  Creates a UIResource border object which wraps
   an existing Border instance.

  delegate - the border being wrapped - `javax.swing.border.Border`"
  ([^javax.swing.border.Border delegate]
    (new BorderUIResource delegate)))

(defn *get-etched-border-ui-resource
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BorderUIResource/getEtchedBorderUIResource )))

(defn *get-lowered-bevel-border-ui-resource
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BorderUIResource/getLoweredBevelBorderUIResource )))

(defn *get-raised-bevel-border-ui-resource
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BorderUIResource/getRaisedBevelBorderUIResource )))

(defn *get-black-line-border-ui-resource
  "returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border []
    (BorderUIResource/getBlackLineBorderUIResource )))

(defn paint-border
  "Description copied from interface: Border

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.plaf.BorderUIResource this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Description copied from interface: Border

  c - the component for which this border insets value applies - `java.awt.Component`

  returns: `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.plaf.BorderUIResource this ^java.awt.Component c]
    (-> this (.getBorderInsets c))))

(defn border-opaque?
  "Description copied from interface: Border

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.BorderUIResource this]
    (-> this (.isBorderOpaque))))

