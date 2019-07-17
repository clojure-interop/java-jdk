(ns javax.swing.text.StyledDocument
  "Interface for a generic styled document."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledDocument]))

(defn get-foreground
  "Takes a set of attributes and turn it into a foreground color
   specification.  This might be used to specify things
   like brighter, more hue, etc.

  attr - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.StyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getForeground attr))))

(defn set-paragraph-attributes
  "Sets paragraph attributes.

  offset - the start of the change >= 0 - `int`
  length - the length of the change >= 0 - `int`
  s - the non-null attributes to change to. Any attributes defined will be applied to the text for the given range. - `javax.swing.text.AttributeSet`
  replace - indicates whether or not the previous attributes should be cleared before the new attributes are set. If true, the operation will replace the previous attributes entirely. If false, the new attributes will be merged with the previous attributes. - `boolean`"
  ([^javax.swing.text.StyledDocument this ^Integer offset ^Integer length ^javax.swing.text.AttributeSet s ^Boolean replace]
    (-> this (.setParagraphAttributes offset length s replace))))

(defn get-logical-style
  "Gets a logical style for a given position in a paragraph.

  p - the position >= 0 - `int`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.StyledDocument this ^Integer p]
    (-> this (.getLogicalStyle p))))

(defn set-character-attributes
  "Changes the content element attributes used for the given range of
   existing content in the document.  All of the attributes
   defined in the given Attributes argument are applied to the
   given range.  This method can be used to completely remove
   all content level attributes for the given range by
   giving an Attributes argument that has no attributes defined
   and setting replace to true.

  offset - the start of the change >= 0 - `int`
  length - the length of the change >= 0 - `int`
  s - the non-null attributes to change to. Any attributes defined will be applied to the text for the given range. - `javax.swing.text.AttributeSet`
  replace - indicates whether or not the previous attributes should be cleared before the new attributes as set. If true, the operation will replace the previous attributes entirely. If false, the new attributes will be merged with the previous attributes. - `boolean`"
  ([^javax.swing.text.StyledDocument this ^Integer offset ^Integer length ^javax.swing.text.AttributeSet s ^Boolean replace]
    (-> this (.setCharacterAttributes offset length s replace))))

(defn set-logical-style
  "Sets the logical style to use for the paragraph at the
   given position.  If attributes aren't explicitly set
   for character and paragraph attributes they will resolve
   through the logical style assigned to the paragraph, which
   in turn may resolve through some hierarchy completely
   independent of the element hierarchy in the document.

  pos - the starting position >= 0 - `int`
  s - the style to set - `javax.swing.text.Style`"
  ([^javax.swing.text.StyledDocument this ^Integer pos ^javax.swing.text.Style s]
    (-> this (.setLogicalStyle pos s))))

(defn add-style
  "Adds a new style into the logical style hierarchy.  Style attributes
   resolve from bottom up so an attribute specified in a child
   will override an attribute specified in the parent.

  nm - the name of the style (must be unique within the collection of named styles). The name may be null if the style is unnamed, but the caller is responsible for managing the reference returned as an unnamed style can't be fetched by name. An unnamed style may be useful for things like character attribute overrides such as found in a style run. - `java.lang.String`
  parent - the parent style. This may be null if unspecified attributes need not be resolved in some other style. - `javax.swing.text.Style`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.StyledDocument this ^java.lang.String nm ^javax.swing.text.Style parent]
    (-> this (.addStyle nm parent))))

(defn get-character-element
  "Gets the element that represents the character that
   is at the given offset within the document.

  pos - the offset >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.StyledDocument this ^Integer pos]
    (-> this (.getCharacterElement pos))))

(defn get-font
  "Takes a set of attributes and turn it into a font
   specification.  This can be used to turn things like
   family, style, size, etc into a font that is available
   on the system the document is currently being used on.

  attr - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the font - `java.awt.Font`"
  (^java.awt.Font [^javax.swing.text.StyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getFont attr))))

(defn get-background
  "Takes a set of attributes and turn it into a background color
   specification.  This might be used to specify things
   like brighter, more hue, etc.

  attr - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.StyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getBackground attr))))

(defn remove-style
  "Removes a named style previously added to the document.

  nm - the name of the style to remove - `java.lang.String`"
  ([^javax.swing.text.StyledDocument this ^java.lang.String nm]
    (-> this (.removeStyle nm))))

(defn get-paragraph-element
  "Gets the element that represents the paragraph that
   encloses the given offset within the document.

  pos - the offset >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.StyledDocument this ^Integer pos]
    (-> this (.getParagraphElement pos))))

(defn get-style
  "Fetches a named style previously added.

  nm - the name of the style - `java.lang.String`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.StyledDocument this ^java.lang.String nm]
    (-> this (.getStyle nm))))

