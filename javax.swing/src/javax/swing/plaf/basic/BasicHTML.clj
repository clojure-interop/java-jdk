(ns javax.swing.plaf.basic.BasicHTML
  "Support for providing html views for the swing components.
  This translates a simple html string to a javax.swing.text.View
  implementation that can render the html and provide the necessary
  layout semantics."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicHTML]))

(defn ->basic-html
  "Constructor."
  ([]
    (new BasicHTML )))

(def *-property-key
  "Static Constant.

  Key to use for the html renderer when stored as a
   client property of a JComponent.

  type: java.lang.String"
  BasicHTML/propertyKey)

(def *-document-base-key
  "Static Constant.

  Key stored as a client property to indicate the base that relative
   references are resolved against. For example, lets say you keep
   your images in the directory resources relative to the code path,
   you would use the following the set the base:


     jComponent.putClientProperty(documentBaseKey,
                                  xxx.class.getResource(`resources/`));

  type: java.lang.String"
  BasicHTML/documentBaseKey)

(defn *create-html-view
  "Create an html renderer for the given component and
   string of html.

  c - `javax.swing.JComponent`
  html - `java.lang.String`

  returns: `javax.swing.text.View`"
  ([^javax.swing.JComponent c ^java.lang.String html]
    (BasicHTML/createHTMLView c html)))

(defn *get-html-baseline
  "Returns the baseline for the html renderer.

  view - the View to get the baseline for - `javax.swing.text.View`
  w - the width to get the baseline for - `int`
  h - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.IllegalArgumentException - if width or height is < 0"
  ([^javax.swing.text.View view ^Integer w ^Integer h]
    (BasicHTML/getHTMLBaseline view w h)))

(defn *html-string?
  "Check the given string to see if it should trigger the
   html rendering logic in a non-text component that supports
   html rendering.

  s - `java.lang.String`

  returns: `boolean`"
  ([^java.lang.String s]
    (BasicHTML/isHTMLString s)))

(defn *update-renderer
  "Stash the HTML render for the given text into the client
   properties of the given JComponent. If the given text is
   NOT HTML the property will be cleared of any
   renderer.

   This method is useful for ComponentUI implementations
   that are static (i.e. shared) and get their state
   entirely from the JComponent.

  c - `javax.swing.JComponent`
  text - `java.lang.String`"
  ([^javax.swing.JComponent c ^java.lang.String text]
    (BasicHTML/updateRenderer c text)))

