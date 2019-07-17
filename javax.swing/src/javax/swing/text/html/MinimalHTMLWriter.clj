(ns javax.swing.text.html.MinimalHTMLWriter
  "MinimalHTMLWriter is a fallback writer used by the
  HTMLEditorKit to write out HTML for a document that
  is a not produced by the EditorKit.

  The format for the document is:


  <html>
    <head>
      <style>
         <!-- list of named styles
          p.normal {
             font-family: SansSerif;
             margin-height: 0;
             font-size: 14
          }
         -->
       </style>
    </head>
    <body>
     <p style=normal>
         Bold, italic, and underline attributes
         of the run are emitted as HTML tags.
         The remaining attributes are emitted as
         part of the style attribute of a <span> tag.
         The syntax is similar to inline styles.
     </p>
    </body>
  </html>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html MinimalHTMLWriter]))

(defn ->minimal-html-writer
  "Constructor.

  Creates a new MinimalHTMLWriter.

  w - Writer - `java.io.Writer`
  doc - StyledDocument - `javax.swing.text.StyledDocument`
  pos - The location in the document to fetch the content. - `int`
  len - The amount to write out. - `int`"
  ([w doc pos len]
    (new MinimalHTMLWriter w doc pos len))
  ([w doc]
    (new MinimalHTMLWriter w doc)))

(defn write
  "Generates HTML output
   from a StyledDocument.

  throws: java.io.IOException - on any I/O error"
  ([this]
    (-> this (.write))))

