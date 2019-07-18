(ns javax.print.DocFlavor$CHAR_ARRAY
  "Class DocFlavor.CHAR_ARRAY provides predefined static constant
  DocFlavor objects for example doc flavors using a character array
  (char[]) as the print data representation class. As such,
  the character set is Unicode."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocFlavor$CHAR_ARRAY]))

(defn ->char-array
  "Constructor.

  Constructs a new doc flavor with the given MIME type and a print
   data representation class name of
   `[C` (character array).

  mime-type - MIME media type string. If it is a text media type, it is assumed to contain a `charset=utf-16` parameter. - `java.lang.String`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if mimeType is null."
  (^DocFlavor$CHAR_ARRAY [^java.lang.String mime-type]
    (new DocFlavor$CHAR_ARRAY mime-type)))

(def *-text-plain
  "Static Constant.

  Doc flavor with MIME type = `text/plain;
   charset=utf-16`, print data representation class name =
   `[C` (character array).

  type: javax.print.DocFlavor$CHAR_ARRAY"
  DocFlavor$CHAR_ARRAY/TEXT_PLAIN)

(def *-text-html
  "Static Constant.

  Doc flavor with MIME type = `text/html;
   charset=utf-16`, print data representation class name =
   `[C` (character array).

  type: javax.print.DocFlavor$CHAR_ARRAY"
  DocFlavor$CHAR_ARRAY/TEXT_HTML)

