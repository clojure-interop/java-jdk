(ns jdk.util.jar.JarEntry
  "This class is used to represent a JAR file entry."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar JarEntry]))

(defn ->jar-entry
  "Constructor.

  Creates a new JarEntry for the specified JAR file
   entry name.

  name - the JAR file entry name - `java.lang.String`

  throws: java.lang.NullPointerException - if the entry name is null"
  (^JarEntry [^java.lang.String name]
    (new JarEntry name)))

(def *-locsig
  "Static Constant.

  type: long"
  JarEntry/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  JarEntry/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  JarEntry/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  JarEntry/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  JarEntry/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  JarEntry/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  JarEntry/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  JarEntry/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  JarEntry/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  JarEntry/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  JarEntry/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  JarEntry/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  JarEntry/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  JarEntry/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  JarEntry/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  JarEntry/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  JarEntry/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  JarEntry/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  JarEntry/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  JarEntry/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  JarEntry/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  JarEntry/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  JarEntry/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  JarEntry/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  JarEntry/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  JarEntry/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  JarEntry/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  JarEntry/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  JarEntry/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  JarEntry/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  JarEntry/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  JarEntry/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  JarEntry/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  JarEntry/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  JarEntry/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  JarEntry/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  JarEntry/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  JarEntry/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  JarEntry/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  JarEntry/ENDCOM)

(defn get-attributes
  "Returns the Manifest Attributes for this
   entry, or null if none.

  returns: the Manifest Attributes for this
   entry, or null if none - `java.util.jar.Attributes`

  throws: java.io.IOException - if an I/O error has occurred"
  (^java.util.jar.Attributes [^JarEntry this]
    (-> this (.getAttributes))))

(defn get-certificates
  "Returns the Certificate objects for this entry, or
   null if none. This method can only be called once
   the JarEntry has been completely verified by reading
   from the entry input stream until the end of the stream has been
   reached. Otherwise, this method will return null.

   The returned certificate array comprises all the signer certificates
   that were used to verify this entry. Each signer certificate is
   followed by its supporting certificate chain (which may be empty).
   Each signer certificate and its supporting certificate chain are ordered
   bottom-to-top (i.e., with the signer certificate first and the (root)
   certificate authority last).

  returns: the Certificate objects for this entry, or
   null if none. - `java.security.cert.Certificate[]`"
  ([^JarEntry this]
    (-> this (.getCertificates))))

(defn get-code-signers
  "Returns the CodeSigner objects for this entry, or
   null if none. This method can only be called once
   the JarEntry has been completely verified by reading
   from the entry input stream until the end of the stream has been
   reached. Otherwise, this method will return null.

   The returned array comprises all the code signers that have signed
   this entry.

  returns: the CodeSigner objects for this entry, or
   null if none. - `java.security.CodeSigner[]`"
  ([^JarEntry this]
    (-> this (.getCodeSigners))))

