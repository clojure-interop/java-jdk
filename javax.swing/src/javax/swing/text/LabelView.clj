(ns javax.swing.text.LabelView
  "A LabelView is a styled chunk of text
  that represents a view mapped over an element in the
  text model.  It caches the character level attributes
  used for rendering."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text LabelView]))

(defn ->label-view
  "Constructor.

  Constructs a new view wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  (^LabelView [^javax.swing.text.Element elem]
    (new LabelView elem)))

(defn get-background
  "Fetches the background color to use to render the glyphs.
   This is implemented to return a cached background color,
   which defaults to null.

  returns: the cached background color - `java.awt.Color`"
  (^java.awt.Color [^LabelView this]
    (-> this (.getBackground))))

(defn get-foreground
  "Fetches the foreground color to use to render the glyphs.
   This is implemented to return a cached foreground color,
   which defaults to null.

  returns: the cached foreground color - `java.awt.Color`"
  (^java.awt.Color [^LabelView this]
    (-> this (.getForeground))))

(defn get-font
  "Fetches the font that the glyphs should be based upon.
   This is implemented to return a cached font.

  returns: the cached font - `java.awt.Font`"
  (^java.awt.Font [^LabelView this]
    (-> this (.getFont))))

(defn underline?
  "Determines if the glyphs should be underlined.  If true,
   an underline should be drawn through the baseline.  This
   is implemented to return the cached underline property.

   When you request this property, LabelView
   re-syncs its state with the properties of the
   Element's AttributeSet.
   If Element's AttributeSet
   does not have this property set, it will revert to false.

  returns: the value of the cached
       underline property - `boolean`"
  (^Boolean [^LabelView this]
    (-> this (.isUnderline))))

(defn strike-through?
  "Determines if the glyphs should have a strikethrough
   line.  If true, a line should be drawn through the center
   of the glyphs.  This is implemented to return the
   cached strikeThrough property.

   When you request this property, LabelView
   re-syncs its state with the properties of the
   Element's AttributeSet.
   If Element's AttributeSet
   does not have this property set, it will revert to false.

  returns: the value of the cached
       strikeThrough property - `boolean`"
  (^Boolean [^LabelView this]
    (-> this (.isStrikeThrough))))

(defn subscript?
  "Determines if the glyphs should be rendered as superscript.

  returns: the value of the cached subscript property

   When you request this property, LabelView
   re-syncs its state with the properties of the
   Element's AttributeSet.
   If Element's AttributeSet
   does not have this property set, it will revert to false. - `boolean`"
  (^Boolean [^LabelView this]
    (-> this (.isSubscript))))

(defn superscript?
  "Determines if the glyphs should be rendered as subscript.

   When you request this property, LabelView
   re-syncs its state with the properties of the
   Element's AttributeSet.
   If Element's AttributeSet
   does not have this property set, it will revert to false.

  returns: the value of the cached
       superscript property - `boolean`"
  (^Boolean [^LabelView this]
    (-> this (.isSuperscript))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^LabelView this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

