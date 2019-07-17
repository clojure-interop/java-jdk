(ns jdk.util.jar.JarInputStream
  "The JarInputStream class is used to read the contents of
  a JAR file from any input stream. It extends the class
  java.util.zip.ZipInputStream with support for reading
  an optional Manifest entry. The Manifest
  can be used to store meta-information about the JAR file and its entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar JarInputStream]))

(defn ->jar-input-stream
  "Constructor.

  Creates a new JarInputStream and reads the optional
   manifest. If a manifest is present and verify is true, also attempts
   to verify the signatures if the JarInputStream is signed.

  in - the actual input stream - `java.io.InputStream`
  verify - whether or not to verify the JarInputStream if it is signed. - `boolean`

  throws: java.io.IOException - if an I/O error has occurred"
  ([in verify]
    (new JarInputStream in verify))
  ([in]
    (new JarInputStream in)))

(def *-locsig
  "Static Constant.

  type: long"
  JarInputStream/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  JarInputStream/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  JarInputStream/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  JarInputStream/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  JarInputStream/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  JarInputStream/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  JarInputStream/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  JarInputStream/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  JarInputStream/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  JarInputStream/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  JarInputStream/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  JarInputStream/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  JarInputStream/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  JarInputStream/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  JarInputStream/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  JarInputStream/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  JarInputStream/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  JarInputStream/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  JarInputStream/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  JarInputStream/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  JarInputStream/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  JarInputStream/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  JarInputStream/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  JarInputStream/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  JarInputStream/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  JarInputStream/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  JarInputStream/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  JarInputStream/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  JarInputStream/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  JarInputStream/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  JarInputStream/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  JarInputStream/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  JarInputStream/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  JarInputStream/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  JarInputStream/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  JarInputStream/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  JarInputStream/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  JarInputStream/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  JarInputStream/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  JarInputStream/ENDCOM)

(defn get-manifest
  "Returns the Manifest for this JAR file, or
   null if none.

  returns: the Manifest for this JAR file, or
           null if none. - `java.util.jar.Manifest`"
  ([this]
    (-> this (.getManifest))))

(defn get-next-entry
  "Reads the next ZIP file entry and positions the stream at the
   beginning of the entry data. If verification has been enabled,
   any invalid signature detected while positioning the stream for
   the next entry will result in an exception.

  returns: the next ZIP file entry, or null if there are no more entries - `java.util.zip.ZipEntry`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([this]
    (-> this (.getNextEntry))))

(defn get-next-jar-entry
  "Reads the next JAR file entry and positions the stream at the
   beginning of the entry data. If verification has been enabled,
   any invalid signature detected while positioning the stream for
   the next entry will result in an exception.

  returns: the next JAR file entry, or null if there are no more entries - `java.util.jar.JarEntry`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([this]
    (-> this (.getNextJarEntry))))

(defn read
  "Reads from the current JAR file entry into an array of bytes.
   If len is not zero, the method
   blocks until some input is available; otherwise, no
   bytes are read and 0 is returned.
   If verification has been enabled, any invalid signature
   on the current entry will be reported at some point before the
   end of the entry is reached.

  b - the buffer into which the data is read - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes to read - `int`

  returns: the actual number of bytes read, or -1 if the end of the
           entry is reached - `int`

  throws: java.lang.NullPointerException - If b is null."
  ([this b off len]
    (-> this (.read b off len))))

