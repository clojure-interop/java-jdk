(ns javax.print.DocFlavor$STRING
  "Class DocFlavor.STRING provides predefined static constant DocFlavor
  objects for example doc flavors using a string (java.lang.String) as the print data representation class.
  As such, the character set is Unicode."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocFlavor$STRING]))

(defn ->string
  "Constructor.

  Constructs a new doc flavor with the given MIME type and a print
   data representation class name of `java.lang.String`.

  mime-type - MIME media type string. If it is a text media type, it is assumed to contain a `charset=utf-16` parameter. - `java.lang.String`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if mimeType is null."
  ([mime-type]
    (new DocFlavor$STRING mime-type)))

(def *-text-plain
  "Static Constant.

  Doc flavor with MIME type = `text/plain;
   charset=utf-16`, print data representation class name =
   `java.lang.String`.

  type: javax.print.DocFlavor.STRING"
  DocFlavor$STRING/TEXT_PLAIN)

(def *-text-html
  "Static Constant.

  Doc flavor with MIME type = `text/html;
   charset=utf-16`, print data representation class name =
   `java.lang.String`.

  type: javax.print.DocFlavor.STRING"
  DocFlavor$STRING/TEXT_HTML)

