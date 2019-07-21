(ns javax.print.DocFlavor$BYTE_ARRAY
  "Class DocFlavor.BYTE_ARRAY provides predefined static constant
  DocFlavor objects for example doc flavors using a byte array
  (byte[]) as the print data representation class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocFlavor$BYTE_ARRAY]))

(defn ->byte-array
  "Constructor.

  Constructs a new doc flavor with the given MIME type and a print
   data representation class name of \"[B\" (byte array).

  mime-type - MIME media type string. - `java.lang.String`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if mimeType is null."
  (^DocFlavor$BYTE_ARRAY [^java.lang.String mime-type]
    (new DocFlavor$BYTE_ARRAY mime-type)))

(def *-text-plain-host
  "Static Constant.

  Doc flavor with MIME type = \"text/plain\",
   encoded in the host platform encoding.
   See hostEncoding
   Print data representation class name =
   \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_HOST)

(def *-text-plain-utf-8
  "Static Constant.

  Doc flavor with MIME type =
   \"text/plain; charset=utf-8\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_UTF_8)

(def *-text-plain-utf-16
  "Static Constant.

  Doc flavor with MIME type =
   \"text/plain; charset=utf-16\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_UTF_16)

(def *-text-plain-utf-16-be
  "Static Constant.

  Doc flavor with MIME type =
   \"text/plain; charset=utf-16be\"
   (big-endian byte ordering),
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_UTF_16BE)

(def *-text-plain-utf-16-le
  "Static Constant.

  Doc flavor with MIME type =
   \"text/plain; charset=utf-16le\"
   (little-endian byte ordering),
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_UTF_16LE)

(def *-text-plain-us-ascii
  "Static Constant.

  Doc flavor with MIME type =
   \"text/plain; charset=us-ascii\",
   print data representation class name =
   \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_PLAIN_US_ASCII)

(def *-text-html-host
  "Static Constant.

  Doc flavor with MIME type = \"text/html\",
   encoded in the host platform encoding.
   See hostEncoding
   Print data representation class name =
   \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_HOST)

(def *-text-html-utf-8
  "Static Constant.

  Doc flavor with MIME type =
   \"text/html; charset=utf-8\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_UTF_8)

(def *-text-html-utf-16
  "Static Constant.

  Doc flavor with MIME type =
   \"text/html; charset=utf-16\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_UTF_16)

(def *-text-html-utf-16-be
  "Static Constant.

  Doc flavor with MIME type =
   \"text/html; charset=utf-16be\"
   (big-endian byte ordering),
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_UTF_16BE)

(def *-text-html-utf-16-le
  "Static Constant.

  Doc flavor with MIME type =
   \"text/html; charset=utf-16le\"
   (little-endian byte ordering),
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_UTF_16LE)

(def *-text-html-us-ascii
  "Static Constant.

  Doc flavor with MIME type =
   \"text/html; charset=us-ascii\",
   print data representation class name =
   \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/TEXT_HTML_US_ASCII)

(def *-pdf
  "Static Constant.

  Doc flavor with MIME type = \"application/pdf\", print
   data representation class name = \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/PDF)

(def *-postscript
  "Static Constant.

  Doc flavor with MIME type = \"application/postscript\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/POSTSCRIPT)

(def *-pcl
  "Static Constant.

  Doc flavor with MIME type = \"application/vnd.hp-PCL\",
   print data representation class name = \"[B\" (byte
   array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/PCL)

(def *-gif
  "Static Constant.

  Doc flavor with MIME type = \"image/gif\", print data
   representation class name = \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/GIF)

(def *-jpeg
  "Static Constant.

  Doc flavor with MIME type = \"image/jpeg\", print data
   representation class name = \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/JPEG)

(def *-png
  "Static Constant.

  Doc flavor with MIME type = \"image/png\", print data
   representation class name = \"[B\" (byte array).

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/PNG)

(def *-autosense
  "Static Constant.

  Doc flavor with MIME type =
   \"application/octet-stream\",
   print data representation class name = \"[B\" (byte
   array). The client must determine that data described
   using this DocFlavor is valid for the printer.

  type: javax.print.DocFlavor$BYTE_ARRAY"
  DocFlavor$BYTE_ARRAY/AUTOSENSE)

