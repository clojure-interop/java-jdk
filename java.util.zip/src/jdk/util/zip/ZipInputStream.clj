(ns jdk.util.zip.ZipInputStream
  "This class implements an input stream filter for reading files in the
  ZIP file format. Includes support for both compressed and uncompressed
  entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipInputStream]))

(defn ->zip-input-stream
  "Constructor.

  Creates a new ZIP input stream.

  in - the actual input stream - `java.io.InputStream`
  charset - The java.nio.charset.charset to be used to decode the ZIP entry name (ignored if the language encoding bit of the ZIP entry's general purpose bit flag is set). - `java.nio.charset.Charset`"
  ([^java.io.InputStream in ^java.nio.charset.Charset charset]
    (new ZipInputStream in charset))
  ([^java.io.InputStream in]
    (new ZipInputStream in)))

(def *-locsig
  "Static Constant.

  type: long"
  ZipInputStream/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  ZipInputStream/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  ZipInputStream/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  ZipInputStream/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  ZipInputStream/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  ZipInputStream/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  ZipInputStream/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  ZipInputStream/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  ZipInputStream/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  ZipInputStream/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  ZipInputStream/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  ZipInputStream/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  ZipInputStream/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  ZipInputStream/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  ZipInputStream/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  ZipInputStream/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  ZipInputStream/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  ZipInputStream/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  ZipInputStream/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  ZipInputStream/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  ZipInputStream/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  ZipInputStream/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  ZipInputStream/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  ZipInputStream/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  ZipInputStream/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  ZipInputStream/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  ZipInputStream/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  ZipInputStream/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  ZipInputStream/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  ZipInputStream/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  ZipInputStream/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  ZipInputStream/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  ZipInputStream/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  ZipInputStream/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  ZipInputStream/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  ZipInputStream/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  ZipInputStream/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  ZipInputStream/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  ZipInputStream/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  ZipInputStream/ENDCOM)

(defn get-next-entry
  "Reads the next ZIP file entry and positions the stream at the
   beginning of the entry data.

  returns: the next ZIP file entry, or null if there are no more entries - `java.util.zip.ZipEntry`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  (^java.util.zip.ZipEntry [^java.util.zip.ZipInputStream this]
    (-> this (.getNextEntry))))

(defn close-entry
  "Closes the current ZIP entry and positions the stream for reading the
   next entry.

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([^java.util.zip.ZipInputStream this]
    (-> this (.closeEntry))))

(defn available
  "Returns 0 after EOF has reached for the current entry data,
   otherwise always return 1.

   Programs should not count on this method to return the actual number
   of bytes that could be read without blocking.

  returns: 1 before EOF and 0 after EOF has reached for current entry. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^java.util.zip.ZipInputStream this]
    (-> this (.available))))

(defn read
  "Reads from the current ZIP entry into an array of bytes.
   If len is not zero, the method
   blocks until some input is available; otherwise, no
   bytes are read and 0 is returned.

  b - the buffer into which the data is read - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, or -1 if the end of the
           entry is reached - `int`

  throws: java.lang.NullPointerException - if b is null."
  (^Integer [^java.util.zip.ZipInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len))))

(defn skip
  "Skips specified number of bytes in the current ZIP entry.

  n - the number of bytes to skip - `long`

  returns: the actual number of bytes skipped - `long`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  (^Long [^java.util.zip.ZipInputStream this ^Long n]
    (-> this (.skip n))))

(defn close
  "Closes this input stream and releases any system resources associated
   with the stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.zip.ZipInputStream this]
    (-> this (.close))))

