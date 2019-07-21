(ns javax.swing.text.html.StyleSheet
  "Support for defining the visual characteristics of
  HTML views being rendered.  The StyleSheet is used to
  translate the HTML model into visual characteristics.
  This enables views to be customized by a look-and-feel,
  multiple views over the same model can be rendered
  differently, etc.  This can be thought of as a CSS
  rule repository.  The key for CSS attributes is an
  object of type CSS.Attribute.  The type of the value
  is up to the StyleSheet implementation, but the
  toString method is required
  to return a string representation of CSS value.

  The primary entry point for HTML View implementations
  to get their attributes is the
  getViewAttributes
  method.  This should be implemented to establish the
  desired policy used to associate attributes with the view.
  Each HTMLEditorKit (i.e. and therefore each associated
  JEditorPane) can have its own StyleSheet, but by default one
  sheet will be shared by all of the HTMLEditorKit instances.
  HTMLDocument instance can also have a StyleSheet, which
  holds the document-specific CSS specifications.

  In order for Views to store less state and therefore be
  more lightweight, the StyleSheet can act as a factory for
  painters that handle some of the rendering tasks.  This allows
  implementations to determine what they want to cache
  and have the sharing potentially at the level that a
  selector is common to multiple views.  Since the StyleSheet
  may be used by views over multiple documents and typically
  the HTML attributes don't effect the selector being used,
  the potential for sharing is significant.

  The rules are stored as named styles, and other information
  is stored to translate the context of an element to a
  rule quickly.  The following code fragment will display
  the named styles, and therefore the CSS rules contained.


    import java.util.*;
    import javax.swing.text.*;
    import javax.swing.text.html.*;

    public class ShowStyles {

        public static void main(String[] args) {
          HTMLEditorKit kit = new HTMLEditorKit();
          HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
          StyleSheet styles = doc.getStyleSheet();

          Enumeration rules = styles.getStyleNames();
          while (rules.hasMoreElements()) {
              String name = (String) rules.nextElement();
              Style rule = styles.getStyle(name);
              System.out.println(rule.toString());
          }
          System.exit(0);
        }
    }

  The semantics for when a CSS style should overide visual attributes
  defined by an element are not well defined. For example, the html
  <body bgcolor=red> makes the body have a red
  background. But if the html file also contains the CSS rule
  body { background: blue } it becomes less clear as to
  what color the background of the body should be. The current
  implementation gives visual attributes defined in the element the
  highest precedence, that is they are always checked before any styles.
  Therefore, in the previous example the background would have a
  red color as the body element defines the background color to be red.

  As already mentioned this supports CSS. We don't support the full CSS
  spec. Refer to the javadoc of the CSS class to see what properties
  we support. The two major CSS parsing related
  concepts we do not currently
  support are pseudo selectors, such as A:link { color: red },
  and the important modifier.

  Note: This implementation is currently
  incomplete.  It can be replaced with alternative implementations
  that are complete.  Future versions of this class will provide
  better CSS support."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html StyleSheet]))

(defn ->style-sheet
  "Constructor.

  Construct a StyleSheet"
  (^StyleSheet []
    (new StyleSheet )))

(defn *get-index-of-size
  "pt - `float`

  returns: `int`"
  (^Integer [^Float pt]
    (StyleSheet/getIndexOfSize pt)))

(defn remove-style-sheet
  "Removes the StyleSheet ss from those of the receiver.

  ss - `javax.swing.text.html.StyleSheet`"
  ([^StyleSheet this ^javax.swing.text.html.StyleSheet ss]
    (-> this (.removeStyleSheet ss))))

(defn get-rule
  "Fetches the style to use to render the given type
   of HTML tag.  The element given is representing
   the tag and can be used to determine the nesting
   for situations where the attributes will differ
   if nesting inside of elements.

  t - the type to translate to visual attributes - `javax.swing.text.html.HTML$Tag`
  e - the element representing the tag; the element can be used to determine the nesting for situations where the attributes will differ if nested inside of other elements - `javax.swing.text.Element`

  returns: the set of CSS attributes to use to render
    the tag - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^StyleSheet this ^javax.swing.text.html.HTML$Tag t ^javax.swing.text.Element e]
    (-> this (.getRule t e)))
  (^javax.swing.text.Style [^StyleSheet this ^java.lang.String selector]
    (-> this (.getRule selector))))

(defn add-rule
  "Adds a set of rules to the sheet.  The rules are expected to
   be in valid CSS format.  Typically this would be called as
   a result of parsing a <style> tag.

  rule - `java.lang.String`"
  ([^StyleSheet this ^java.lang.String rule]
    (-> this (.addRule rule))))

(defn set-base
  "Sets the base. All import statements that are relative, will be
   relative to base.

  base - `java.net.URL`"
  ([^StyleSheet this ^java.net.URL base]
    (-> this (.setBase base))))

(defn get-foreground
  "Takes a set of attributes and turn it into a foreground color
   specification.  This might be used to specify things
   like brighter, more hue, etc.

  a - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^StyleSheet this ^javax.swing.text.AttributeSet a]
    (-> this (.getForeground a))))

(defn get-style-sheets
  "Returns an array of the linked StyleSheets. Will return null
   if there are no linked StyleSheets.

  returns: `javax.swing.text.html.StyleSheet[]`"
  ([^StyleSheet this]
    (-> this (.getStyleSheets))))

(defn import-style-sheet
  "Imports a style sheet from url. The resulting rules
   are directly added to the receiver. If you do not want the rules
   to become part of the receiver, create a new StyleSheet and use
   addStyleSheet to link it in.

  url - `java.net.URL`"
  ([^StyleSheet this ^java.net.URL url]
    (-> this (.importStyleSheet url))))

(defn string-to-color
  "Converts a color string such as \"RED\" or \"#NNNNNN\" to a Color.
   Note: This will only convert the HTML3.2 color strings
         or a string of length 7;
         otherwise, it will return null.

  string - `java.lang.String`

  returns: `java.awt.Color`"
  (^java.awt.Color [^StyleSheet this ^java.lang.String string]
    (-> this (.stringToColor string))))

(defn add-css-attribute
  "Adds a CSS attribute to the given set.

  attr - `javax.swing.text.MutableAttributeSet`
  key - `javax.swing.text.html.CSS$Attribute`
  value - `java.lang.String`"
  ([^StyleSheet this ^javax.swing.text.MutableAttributeSet attr ^javax.swing.text.html.CSS$Attribute key ^java.lang.String value]
    (-> this (.addCSSAttribute attr key value))))

(defn add-css-attribute-from-html
  "Adds a CSS attribute to the given set.

  attr - `javax.swing.text.MutableAttributeSet`
  key - `javax.swing.text.html.CSS$Attribute`
  value - `java.lang.String`

  returns: `boolean`"
  (^Boolean [^StyleSheet this ^javax.swing.text.MutableAttributeSet attr ^javax.swing.text.html.CSS$Attribute key ^java.lang.String value]
    (-> this (.addCSSAttributeFromHTML attr key value))))

(defn get-view-attributes
  "Fetches a set of attributes to use in the view for
   displaying.  This is basically a set of attributes that
   can be used for View.getAttributes.

  v - `javax.swing.text.View`

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.View v]
    (-> this (.getViewAttributes v))))

(defn get-point-size
  "Returns the point size, given a size index.

  index - `int`

  returns: `float`"
  (^Float [^StyleSheet this ^Integer index]
    (-> this (.getPointSize index))))

(defn remove-attribute
  "Removes an attribute from the set.  If the attribute is a StyleConstants
   attribute, the request will be converted to a CSS attribute prior to
   forwarding to the superclass behavior.

  old - the old set of attributes - `javax.swing.text.AttributeSet`
  key - the non-null attribute name - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.AttributeSet old ^java.lang.Object key]
    (-> this (.removeAttribute old key))))

(defn add-style-sheet
  "Adds the rules from the StyleSheet ss to those of
   the receiver. ss's rules will override the rules of
   any previously added style sheets. An added StyleSheet will never
   override the rules of the receiving style sheet.

  ss - `javax.swing.text.html.StyleSheet`"
  ([^StyleSheet this ^javax.swing.text.html.StyleSheet ss]
    (-> this (.addStyleSheet ss))))

(defn add-attributes
  "Adds a set of attributes to the element.  If any of these attributes
   are StyleConstants attributes, they will be converted to CSS prior
   to forwarding to the superclass behavior.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  attr - the attributes to add - `javax.swing.text.AttributeSet`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.AttributeSet old ^javax.swing.text.AttributeSet attr]
    (-> this (.addAttributes old attr))))

(defn get-base
  "Returns the base.

  returns: `java.net.URL`"
  (^java.net.URL [^StyleSheet this]
    (-> this (.getBase))))

(defn remove-attributes
  "Removes a set of attributes for the element.  If any of the attributes
   is a StyleConstants attribute, the request will be converted to a CSS
   attribute prior to forwarding to the superclass behavior.

  old - the old attribute set - `javax.swing.text.AttributeSet`
  names - the attribute names - `java.util.Enumeration`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.AttributeSet old ^java.util.Enumeration names]
    (-> this (.removeAttributes old names))))

(defn get-font
  "Fetches the font to use for the given set of attributes.

  a - the attribute set - `javax.swing.text.AttributeSet`

  returns: the font - `java.awt.Font`"
  (^java.awt.Font [^StyleSheet this ^javax.swing.text.AttributeSet a]
    (-> this (.getFont a))))

(defn add-attribute
  "Adds an attribute to the given set, and returns
   the new representative set.  This is reimplemented to
   convert StyleConstant attributes to CSS prior to forwarding
   to the superclass behavior.  The StyleConstants attribute
   has no corresponding CSS entry, the StyleConstants attribute
   is stored (but will likely be unused).

  old - the old attribute set - `javax.swing.text.AttributeSet`
  key - the non-null attribute key - `java.lang.Object`
  value - the attribute value - `java.lang.Object`

  returns: the updated attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.AttributeSet old ^java.lang.Object key ^java.lang.Object value]
    (-> this (.addAttribute old key value))))

(defn translate-html-to-css
  "Converts a set of HTML attributes to an equivalent
   set of CSS attributes.

  html-attr-set - AttributeSet containing the HTML attributes. - `javax.swing.text.AttributeSet`

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^javax.swing.text.AttributeSet html-attr-set]
    (-> this (.translateHTMLToCSS html-attr-set))))

(defn get-background
  "Takes a set of attributes and turn it into a background color
   specification.  This might be used to specify things
   like brighter, more hue, etc.

  a - the set of attributes - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^StyleSheet this ^javax.swing.text.AttributeSet a]
    (-> this (.getBackground a))))

(defn set-base-font-size
  "Sets the base font size, with valid values between 1 and 7.

  sz - `int`"
  ([^StyleSheet this ^Integer sz]
    (-> this (.setBaseFontSize sz))))

(defn load-rules
  "Loads a set of rules that have been specified in terms of
   CSS1 grammar.  If there are collisions with existing rules,
   the newly specified rule will win.

  in - the stream to read the CSS grammar from - `java.io.Reader`
  ref - the reference URL. This value represents the location of the stream and may be null. All relative URLs specified in the stream will be based upon this parameter. - `java.net.URL`

  throws: java.io.IOException"
  ([^StyleSheet this ^java.io.Reader in ^java.net.URL ref]
    (-> this (.loadRules in ref))))

(defn get-declaration
  "Translates a CSS declaration to an AttributeSet that represents
   the CSS declaration.  Typically this would be called as a
   result of encountering an HTML style attribute.

  decl - `java.lang.String`

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^StyleSheet this ^java.lang.String decl]
    (-> this (.getDeclaration decl))))

(defn get-list-painter
  "Fetches the list formatter to use for the given set
   of CSS attributes.

  a - `javax.swing.text.AttributeSet`

  returns: `javax.swing.text.html.StyleSheet$ListPainter`"
  (^javax.swing.text.html.StyleSheet$ListPainter [^StyleSheet this ^javax.swing.text.AttributeSet a]
    (-> this (.getListPainter a))))

(defn remove-style
  "Removes a named style previously added to the document.

  nm - the name of the style to remove - `java.lang.String`"
  ([^StyleSheet this ^java.lang.String nm]
    (-> this (.removeStyle nm))))

(defn get-box-painter
  "Fetches the box formatter to use for the given set
   of CSS attributes.

  a - `javax.swing.text.AttributeSet`

  returns: `javax.swing.text.html.StyleSheet$BoxPainter`"
  (^javax.swing.text.html.StyleSheet$BoxPainter [^StyleSheet this ^javax.swing.text.AttributeSet a]
    (-> this (.getBoxPainter a))))

