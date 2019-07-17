(ns javax.swing.text.html.parser.Parser
  "A simple DTD-driven HTML parser. The parser reads an
  HTML file from an InputStream and calls various methods
  (which should be overridden in a subclass) when tags and
  data are encountered.

  Unfortunately there are many badly implemented HTML parsers
  out there, and as a result there are many badly formatted
  HTML files. This parser attempts to parse most HTML files.
  This means that the implementation sometimes deviates from
  the SGML specification in favor of HTML.

  The parser treats \r and \r\n as \n. Newlines after starttags
  and before end tags are ignored just as specified in the SGML/HTML
  specification.

  The html spec does not specify how spaces are to be coalesced very well.
  Specifically, the following scenarios are not discussed (note that a
  space should be used here, but I am using &nbsp to force the space to
  be displayed):

  '<b>blah <i> <strike> foo' which can be treated as:
  '<b>blah <i><strike>foo'
  as well as:
  '<p><a href=`xx`> <em>Using</em></a></p>'
  which appears to be treated as:
  '<p><a href=`xx`><em>Using</em></a></p>'

  If strict is false, when a tag that breaks flow,
  (TagElement.breaksFlows) or trailing whitespace is
  encountered, all whitespace will be ignored until a non whitespace
  character is encountered. This appears to give behavior closer to
  the popular browsers."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html.parser Parser]))

(defn ->parser
  "Constructor.

  dtd - `javax.swing.text.html.parser.DTD`"
  ([dtd]
    (new Parser dtd)))

(defn parse-dtd-markup
  "Parses th Document Declaration Type markup declaration.
   Currently ignores it.

  returns: `java.lang.String`

  throws: java.io.IOException"
  ([this]
    (-> this (.parseDTDMarkup))))

(defn parse
  "Parse an HTML stream, given a DTD.

  in - `java.io.Reader`

  throws: java.io.IOException"
  ([this in]
    (-> this (.parse in))))

