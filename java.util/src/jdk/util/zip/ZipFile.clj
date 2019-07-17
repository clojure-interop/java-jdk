(ns jdk.util.zip.ZipFile
  "This class is used to read entries from a zip file.

   Unless otherwise noted, passing a null argument to a constructor
  or method in this class will cause a NullPointerException to be
  thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipFile]))

(defn ->zip-file
  "Constructor.

  Opens a new ZipFile to read from the specified
   File object in the specified mode.  The mode argument
   must be either OPEN_READ or OPEN_READ | OPEN_DELETE.

   First, if there is a security manager, its checkRead
   method is called with the name argument as its argument to
   ensure the read is allowed.

  file - the ZIP file to be opened for reading - `java.io.File`
  mode - the mode in which the file is to be opened - `int`
  charset - the java.nio.charset.charset to be used to decode the ZIP entry name and comment that are not encoded by using UTF-8 encoding (indicated by entry's general purpose flag). - `java.nio.charset.Charset`

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([^java.io.File file ^Integer mode ^java.nio.charset.Charset charset]
    (new ZipFile file mode charset))
  ([^java.io.File file ^Integer mode]
    (new ZipFile file mode))
  ([^java.lang.String name]
    (new ZipFile name)))

(def *-open-read
  "Static Constant.

  Mode flag to open a zip file for reading.

  type: int"
  ZipFile/OPEN_READ)

(def *-open-delete
  "Static Constant.

  Mode flag to open a zip file and mark it for deletion.  The file will be
   deleted some time between the moment that it is opened and the moment
   that it is closed, but its contents will remain accessible via the
   ZipFile object until either the close method is invoked or the
   virtual machine exits.

  type: int"
  ZipFile/OPEN_DELETE)

(def *-locsig
  "Static Constant.

  type: long"
  ZipFile/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  ZipFile/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  ZipFile/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  ZipFile/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  ZipFile/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  ZipFile/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  ZipFile/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  ZipFile/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  ZipFile/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  ZipFile/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  ZipFile/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  ZipFile/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  ZipFile/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  ZipFile/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  ZipFile/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  ZipFile/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  ZipFile/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  ZipFile/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  ZipFile/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  ZipFile/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  ZipFile/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  ZipFile/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  ZipFile/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  ZipFile/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  ZipFile/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  ZipFile/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  ZipFile/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  ZipFile/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  ZipFile/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  ZipFile/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  ZipFile/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  ZipFile/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  ZipFile/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  ZipFile/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  ZipFile/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  ZipFile/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  ZipFile/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  ZipFile/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  ZipFile/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  ZipFile/ENDCOM)

(defn get-comment
  "Returns the zip file comment, or null if none.

  returns: the comment string for the zip file, or null if none - `java.lang.String`

  throws: java.lang.IllegalStateException - if the zip file has been closed Since 1.7"
  ([^java.util.zip.ZipFile this]
    (-> this (.getComment))))

(defn get-entry
  "Returns the zip file entry for the specified name, or null
   if not found.

  name - the name of the entry - `java.lang.String`

  returns: the zip file entry, or null if not found - `java.util.zip.ZipEntry`

  throws: java.lang.IllegalStateException - if the zip file has been closed"
  ([^java.util.zip.ZipFile this ^java.lang.String name]
    (-> this (.getEntry name))))

(defn get-input-stream
  "Returns an input stream for reading the contents of the specified
   zip file entry.

    Closing this ZIP file will, in turn, close all input
   streams that have been returned by invocations of this method.

  entry - the zip file entry - `java.util.zip.ZipEntry`

  returns: the input stream for reading the contents of the specified
   zip file entry. - `java.io.InputStream`

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([^java.util.zip.ZipFile this ^java.util.zip.ZipEntry entry]
    (-> this (.getInputStream entry))))

(defn get-name
  "Returns the path name of the ZIP file.

  returns: the path name of the ZIP file - `java.lang.String`"
  ([^java.util.zip.ZipFile this]
    (-> this (.getName))))

(defn entries
  "Returns an enumeration of the ZIP file entries.

  returns: an enumeration of the ZIP file entries - `java.util.Enumeration<? extends java.util.zip.ZipEntry>`

  throws: java.lang.IllegalStateException - if the zip file has been closed"
  ([^java.util.zip.ZipFile this]
    (-> this (.entries))))

(defn stream
  "Return an ordered Stream over the ZIP file entries.
   Entries appear in the Stream in the order they appear in
   the central directory of the ZIP file.

  returns: an ordered Stream of entries in this ZIP file - `java.util..Stream<? extends java.util.zip.ZipEntry>`

  throws: java.lang.IllegalStateException - if the zip file has been closed"
  ([^java.util.zip.ZipFile this]
    (-> this (.stream))))

(defn size
  "Returns the number of entries in the ZIP file.

  returns: the number of entries in the ZIP file - `int`

  throws: java.lang.IllegalStateException - if the zip file has been closed"
  ([^java.util.zip.ZipFile this]
    (-> this (.size))))

(defn close
  "Closes the ZIP file.
    Closing this ZIP file will close all of the input streams
   previously returned by invocations of the getInputStream method.

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.zip.ZipFile this]
    (-> this (.close))))

