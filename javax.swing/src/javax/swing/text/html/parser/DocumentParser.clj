(ns javax.swing.text.html.parser.DocumentParser
  "A Parser for HTML Documents (actually, you can specify a DTD, but
  you should really only use this class with the html dtd in swing).
  Reads an InputStream of HTML and
  invokes the appropriate methods in the ParserCallback class. This
  is the default parser used by HTMLEditorKit to parse HTML url's.
  This will message the callback for all valid tags, as well as
  tags that are implied but not explicitly specified. For example, the
  html string (<p>blah) only has a p tag defined. The callback
  will see the following methods:
  handleStartTag(html, ...)
      handleStartTag(head, ...)
      handleEndTag(head)
      handleStartTag(body, ...)
      handleStartTag(p, ...)
      handleText(...)
      handleEndTag(p)
      handleEndTag(body)
      handleEndTag(html)

  The items in italic are implied, that is, although they were not
  explicitly specified, to be correct html they should have been present
  (head isn't necessary, but it is still generated). For tags that
  are implied, the AttributeSet argument will have a value of
  Boolean.TRUE for the key
  HTMLEditorKit.ParserCallback.IMPLIED.
  HTML.Attributes defines a type safe enumeration of html attributes.
  If an attribute key of a tag is defined in HTML.Attribute, the
  HTML.Attribute will be used as the key, otherwise a String will be used.
  For example <p foo=bar class=neat> has two attributes. foo is
  not defined in HTML.Attribute, where as class is, therefore the
  AttributeSet will have two values in it, HTML.Attribute.CLASS with
  a String value of 'neat' and the String key 'foo' with a String value of
  'bar'.
  The position argument will indicate the start of the tag, comment
  or text. Similar to arrays, the first character in the stream has a
  position of 0. For tags that are
  implied the position will indicate
  the location of the next encountered tag. In the first example,
  the implied start body and html tags will have the same position as the
  p tag, and the implied end p, html and body tags will all have the same
  position.
  As html skips whitespace the position for text will be the position
  of the first valid character, eg in the string '\n\n\nblah'
  the text 'blah' will have a position of 3, the newlines are skipped.

  For attributes that do not have a value, eg in the html
  string <foo blah> the attribute blah
  does not have a value, there are two possible values that will be
  placed in the AttributeSet's value:

  If the DTD does not contain an definition for the element, or the
      definition does not have an explicit value then the value in the
      AttributeSet will be HTML.NULL_ATTRIBUTE_VALUE.
  If the DTD contains an explicit value, as in:
      <!ATTLIST OPTION selected (selected) #IMPLIED>
      this value from the dtd (in this case selected) will be used.


  Once the stream has been parsed, the callback is notified of the most
  likely end of line string. The end of line string will be one of
  \n, \r or \r\n, which ever is encountered the most in parsing the
  stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser DocumentParser]))

(defn ->document-parser
  "Constructor.

  dtd - `javax.swing.text.html.parser.DTD`"
  ([^javax.swing.text.html.parser.DTD dtd]
    (new DocumentParser dtd)))

(defn parse
  "in - `java.io.Reader`
  callback - `javax.swing.text.html.HTMLEditorKit.ParserCallback`
  ignore-char-set - `boolean`

  throws: java.io.IOException"
  ([^javax.swing.text.html.parser.DocumentParser this ^java.io.Reader in ^javax.swing.text.html.HTMLEditorKit.ParserCallback callback ^Boolean ignore-char-set]
    (-> this (.parse in callback ignore-char-set))))

