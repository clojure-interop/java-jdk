(ns jdk.util.zip.ZipOutputStream
  "This class implements an output stream filter for writing files in the
  ZIP file format. Includes support for both compressed and uncompressed
  entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipOutputStream]))

(defn ->zip-output-stream
  "Constructor.

  Creates a new ZIP output stream.

  out - the actual output stream - `java.io.OutputStream`
  charset - the java.nio.charset.charset to be used to encode the entry names and comments - `java.nio.charset.Charset`"
  ([out charset]
    (new ZipOutputStream out charset))
  ([out]
    (new ZipOutputStream out)))

(def *-stored
  "Static Constant.

  Compression method for uncompressed (STORED) entries.

  type: int"
  ZipOutputStream/STORED)

(def *-deflated
  "Static Constant.

  Compression method for compressed (DEFLATED) entries.

  type: int"
  ZipOutputStream/DEFLATED)

(def *-locsig
  "Static Constant.

  type: long"
  ZipOutputStream/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  ZipOutputStream/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  ZipOutputStream/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  ZipOutputStream/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  ZipOutputStream/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  ZipOutputStream/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  ZipOutputStream/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  ZipOutputStream/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  ZipOutputStream/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  ZipOutputStream/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  ZipOutputStream/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  ZipOutputStream/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  ZipOutputStream/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  ZipOutputStream/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  ZipOutputStream/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  ZipOutputStream/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  ZipOutputStream/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  ZipOutputStream/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  ZipOutputStream/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  ZipOutputStream/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  ZipOutputStream/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  ZipOutputStream/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  ZipOutputStream/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  ZipOutputStream/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  ZipOutputStream/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  ZipOutputStream/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  ZipOutputStream/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  ZipOutputStream/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  ZipOutputStream/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  ZipOutputStream/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  ZipOutputStream/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  ZipOutputStream/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  ZipOutputStream/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  ZipOutputStream/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  ZipOutputStream/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  ZipOutputStream/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  ZipOutputStream/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  ZipOutputStream/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  ZipOutputStream/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  ZipOutputStream/ENDCOM)

(defn set-comment
  "Sets the ZIP file comment.

  comment - the comment string - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the length of the specified ZIP file comment is greater than 0xFFFF bytes"
  ([this comment]
    (-> this (.setComment comment))))

(defn set-method
  "Sets the default compression method for subsequent entries. This
   default will be used whenever the compression method is not specified
   for an individual ZIP file entry, and is initially set to DEFLATED.

  method - the default compression method - `int`

  throws: java.lang.IllegalArgumentException - if the specified compression method is invalid"
  ([this method]
    (-> this (.setMethod method))))

(defn set-level
  "Sets the compression level for subsequent entries which are DEFLATED.
   The default setting is DEFAULT_COMPRESSION.

  level - the compression level (0-9) - `int`

  throws: java.lang.IllegalArgumentException - if the compression level is invalid"
  ([this level]
    (-> this (.setLevel level))))

(defn put-next-entry
  "Begins writing a new ZIP file entry and positions the stream to the
   start of the entry data. Closes the current entry if still active.
   The default compression method will be used if no compression method
   was specified for the entry, and the current time will be used if
   the entry has no set modification time.

  e - the ZIP entry to be written - `java.util.zip.ZipEntry`

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([this e]
    (-> this (.putNextEntry e))))

(defn close-entry
  "Closes the current ZIP entry and positions the stream for writing
   the next entry.

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([this]
    (-> this (.closeEntry))))

(defn write
  "Writes an array of bytes to the current ZIP entry data. This method
   will block until all the bytes are written.

  b - the data to be written - `byte[]`
  off - the start offset in the data - `int`
  len - the number of bytes that are written - `int`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([this b off len]
    (-> this (.write b off len))))

(defn finish
  "Finishes writing the contents of the ZIP output stream without closing
   the underlying stream. Use this method when applying multiple filters
   in succession to the same output stream.

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([this]
    (-> this (.finish))))

(defn close
  "Closes the ZIP output stream as well as the stream being filtered.

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([this]
    (-> this (.close))))

