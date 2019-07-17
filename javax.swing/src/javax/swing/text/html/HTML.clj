(ns javax.swing.text.html.HTML
  "Constants used in the HTMLDocument.  These
  are basically tag and attribute definitions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTML]))

(defn ->html
  "Constructor."
  ([]
    (new HTML )))

(def *-null-attribute-value
  "Static Constant.

  type: java.lang.String"
  HTML/NULL_ATTRIBUTE_VALUE)

(defn *get-all-tags
  "Returns the set of actual HTML tags that
   are recognized by the default HTML reader.
   This set does not include tags that are
   manufactured by the reader.

  returns: `javax.swing.text.html.HTML.Tag[]`"
  ([]
    (HTML/getAllTags )))

(defn *get-tag
  "Fetches a tag constant for a well-known tag name (i.e. one of
   the tags in the set {A, ADDRESS, APPLET, AREA, B,
   BASE, BASEFONT, BIG,
   BLOCKQUOTE, BODY, BR, CAPTION, CENTER, CITE, CODE,
   DD, DFN, DIR, DIV, DL, DT, EM, FONT, FORM, FRAME,
   FRAMESET, H1, H2, H3, H4, H5, H6, HEAD, HR, HTML,
   I, IMG, INPUT, ISINDEX, KBD, LI, LINK, MAP, MENU,
   META, NOBR, NOFRAMES, OBJECT, OL, OPTION, P, PARAM,
   PRE, SAMP, SCRIPT, SELECT, SMALL, SPAN, STRIKE, S,
   STRONG, STYLE, SUB, SUP, TABLE, TD, TEXTAREA,
   TH, TITLE, TR, TT, U, UL, VAR}.  If the given
   name does not represent one of the well-known tags, then
   null will be returned.

  tag-name - the String name requested - `java.lang.String`

  returns: a tag constant corresponding to the tagName,
      or null if not found - `javax.swing.text.html.HTML.Tag`"
  ([tag-name]
    (HTML/getTag tag-name)))

(defn *get-integer-attribute-value
  "Fetches an integer attribute value.  Attribute values
   are stored as a string, and this is a convenience method
   to convert to an actual integer.

  attr - the set of attributes to use to try to fetch a value - `javax.swing.text.AttributeSet`
  key - the key to use to fetch the value - `javax.swing.text.html.HTML.Attribute`
  def - the default value to use if the attribute isn't defined or there is an error converting to an integer - `int`

  returns: `int`"
  ([attr key def]
    (HTML/getIntegerAttributeValue attr key def)))

(defn *get-all-attribute-keys
  "Returns the set of HTML attributes recognized.

  returns: the set of HTML attributes recognized - `javax.swing.text.html.HTML.Attribute[]`"
  ([]
    (HTML/getAllAttributeKeys )))

(defn *get-attribute-key
  "Fetches an attribute constant for a well-known attribute name
   (i.e. one of the attributes in the set {FACE, COMMENT, SIZE,
   COLOR, CLEAR, BACKGROUND, BGCOLOR, TEXT, LINK, VLINK, ALINK,
   WIDTH, HEIGHT, ALIGN, NAME, HREF, REL, REV, TITLE, TARGET,
   SHAPE, COORDS, ISMAP, NOHREF, ALT, ID, SRC, HSPACE, VSPACE,
   USEMAP, LOWSRC, CODEBASE, CODE, ARCHIVE, VALUE, VALUETYPE,
   TYPE, CLASS, STYLE, LANG, DIR, DECLARE, CLASSID, DATA, CODETYPE,
   STANDBY, BORDER, SHAPES, NOSHADE, COMPACT, START, ACTION, METHOD,
   ENCTYPE, CHECKED, MAXLENGTH, MULTIPLE, SELECTED, ROWS, COLS,
   DUMMY, CELLSPACING, CELLPADDING, VALIGN, HALIGN, NOWRAP, ROWSPAN,
   COLSPAN, PROMPT, HTTPEQUIV, CONTENT, LANGUAGE, VERSION, N,
   FRAMEBORDER, MARGINWIDTH, MARGINHEIGHT, SCROLLING, NORESIZE,
   MEDIA, ENDTAG}).
   If the given name does not represent one of the well-known attributes,
   then null will be returned.

  att-name - the String requested - `java.lang.String`

  returns: the Attribute corresponding to attName - `javax.swing.text.html.HTML.Attribute`"
  ([att-name]
    (HTML/getAttributeKey att-name)))

