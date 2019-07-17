(ns jdk.util.jar.JarOutputStream
  "The JarOutputStream class is used to write the contents
  of a JAR file to any output stream. It extends the class
  java.util.zip.ZipOutputStream with support
  for writing an optional Manifest entry. The
  Manifest can be used to specify meta-information about
  the JAR file and its entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar JarOutputStream]))

(defn ->jar-output-stream
  "Constructor.

  Creates a new JarOutputStream with the specified
   Manifest. The manifest is written as the first
   entry to the output stream.

  out - the actual output stream - `java.io.OutputStream`
  man - the optional Manifest - `java.util.jar.Manifest`

  throws: java.io.IOException - if an I/O error has occurred"
  ([out man]
    (new JarOutputStream out man))
  ([out]
    (new JarOutputStream out)))

(def *-locsig
  "Static Constant.

  type: long"
  JarOutputStream/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  JarOutputStream/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  JarOutputStream/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  JarOutputStream/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  JarOutputStream/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  JarOutputStream/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  JarOutputStream/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  JarOutputStream/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  JarOutputStream/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  JarOutputStream/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  JarOutputStream/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  JarOutputStream/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  JarOutputStream/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  JarOutputStream/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  JarOutputStream/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  JarOutputStream/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  JarOutputStream/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  JarOutputStream/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  JarOutputStream/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  JarOutputStream/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  JarOutputStream/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  JarOutputStream/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  JarOutputStream/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  JarOutputStream/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  JarOutputStream/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  JarOutputStream/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  JarOutputStream/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  JarOutputStream/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  JarOutputStream/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  JarOutputStream/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  JarOutputStream/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  JarOutputStream/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  JarOutputStream/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  JarOutputStream/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  JarOutputStream/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  JarOutputStream/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  JarOutputStream/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  JarOutputStream/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  JarOutputStream/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  JarOutputStream/ENDCOM)

(defn put-next-entry
  "Begins writing a new JAR file entry and positions the stream
   to the start of the entry data. This method will also close
   any previous entry. The default compression method will be
   used if no compression method was specified for the entry.
   The current time will be used if the entry has no set modification
   time.

  ze - the ZIP/JAR entry to be written - `java.util.zip.ZipEntry`

  throws: java.util.zip.ZipException - if a ZIP error has occurred"
  ([this ze]
    (-> this (.putNextEntry ze))))

