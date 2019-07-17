(ns jdk.util.jar.JarFile
  "The JarFile class is used to read the contents of a jar file
  from any file that can be opened with java.io.RandomAccessFile.
  It extends the class java.util.zip.ZipFile with support
  for reading an optional Manifest entry. The
  Manifest can be used to specify meta-information about the
  jar file and its entries.

   Unless otherwise noted, passing a null argument to a constructor
  or method in this class will cause a NullPointerException to be
  thrown.

  If the verify flag is on when opening a signed jar file, the content of the
  file is verified against its signature embedded inside the file. Please note
  that the verification process does not include validating the signer's
  certificate. A caller should inspect the return value of
  JarEntry.getCodeSigners() to further determine if the signature
  can be trusted."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar JarFile]))

(defn ->jar-file
  "Constructor.

  Creates a new JarFile to read from the specified
   File object in the specified mode.  The mode argument
   must be either OPEN_READ or OPEN_READ | OPEN_DELETE.

  file - the jar file to be opened for reading - `java.io.File`
  verify - whether or not to verify the jar file if it is signed. - `boolean`
  mode - the mode in which the file is to be opened - `int`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.io.File file ^Boolean verify ^Integer mode]
    (new JarFile file verify mode))
  ([^java.lang.String name ^Boolean verify]
    (new JarFile name verify))
  ([^java.lang.String name]
    (new JarFile name)))

(def *-manifest-name
  "Static Constant.

  The JAR manifest file name.

  type: java.lang.String"
  JarFile/MANIFEST_NAME)

(def *-locsig
  "Static Constant.

  type: long"
  JarFile/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  JarFile/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  JarFile/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  JarFile/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  JarFile/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  JarFile/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  JarFile/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  JarFile/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  JarFile/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  JarFile/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  JarFile/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  JarFile/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  JarFile/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  JarFile/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  JarFile/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  JarFile/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  JarFile/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  JarFile/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  JarFile/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  JarFile/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  JarFile/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  JarFile/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  JarFile/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  JarFile/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  JarFile/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  JarFile/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  JarFile/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  JarFile/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  JarFile/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  JarFile/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  JarFile/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  JarFile/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  JarFile/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  JarFile/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  JarFile/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  JarFile/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  JarFile/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  JarFile/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  JarFile/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  JarFile/ENDCOM)

(defn get-manifest
  "Returns the jar file manifest, or null if none.

  returns: the jar file manifest, or null if none - `java.util.jar.Manifest`

  throws: java.lang.IllegalStateException - may be thrown if the jar file has been closed"
  ([^java.util.jar.JarFile this]
    (-> this (.getManifest))))

(defn get-jar-entry
  "Returns the JarEntry for the given entry name or
   null if not found.

  name - the jar file entry name - `java.lang.String`

  returns: the JarEntry for the given entry name or
           null if not found. - `java.util.jar.JarEntry`

  throws: java.lang.IllegalStateException - may be thrown if the jar file has been closed"
  ([^java.util.jar.JarFile this ^java.lang.String name]
    (-> this (.getJarEntry name))))

(defn get-entry
  "Returns the ZipEntry for the given entry name or
   null if not found.

  name - the jar file entry name - `java.lang.String`

  returns: the ZipEntry for the given entry name or
           null if not found - `java.util.zip.ZipEntry`

  throws: java.lang.IllegalStateException - may be thrown if the jar file has been closed"
  ([^java.util.jar.JarFile this ^java.lang.String name]
    (-> this (.getEntry name))))

(defn entries
  "Returns an enumeration of the zip file entries.

  returns: an enumeration of the ZIP file entries - `java.util.Enumeration<java.util.jar.JarEntry>`"
  ([^java.util.jar.JarFile this]
    (-> this (.entries))))

(defn stream
  "Description copied from class: ZipFile

  returns: an ordered Stream of entries in this ZIP file - `java.util..Stream<java.util.jar.JarEntry>`"
  ([^java.util.jar.JarFile this]
    (-> this (.stream))))

(defn get-input-stream
  "Returns an input stream for reading the contents of the specified
   zip file entry.

  ze - the zip file entry - `java.util.zip.ZipEntry`

  returns: an input stream for reading the contents of the specified
           zip file entry - `java.io.InputStream`

  throws: java.util.zip.ZipException - if a zip file format error has occurred"
  ([^java.util.jar.JarFile this ^java.util.zip.ZipEntry ze]
    (-> this (.getInputStream ze))))

