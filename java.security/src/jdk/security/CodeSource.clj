(ns jdk.security.CodeSource
  "This class extends the concept of a codebase to
  encapsulate not only the location (URL) but also the certificate chains
  that were used to verify signed code originating from that location."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security CodeSource]))

(defn ->code-source
  "Constructor.

  Constructs a CodeSource and associates it with the specified
   location and set of certificates.

  url - the location (URL). - `java.net.URL`
  certs - the certificate(s). It may be null. The contents of the array are copied to protect against subsequent modification. - `java.security.cert.Certificate[]`"
  (^CodeSource [^java.net.URL url certs]
    (new CodeSource url certs)))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^CodeSource this]
    (-> this (.hashCode))))

(defn equals
  "Tests for equality between the specified object and this
   object. Two CodeSource objects are considered equal if their
   locations are of identical value and if their signer certificate
   chains are of identical value. It is not required that
   the certificate chains be in the same order.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if the objects are considered equal, false otherwise. - `boolean`"
  (^Boolean [^CodeSource this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-location
  "Returns the location associated with this CodeSource.

  returns: the location (URL). - `java.net.URL`"
  (^java.net.URL [^CodeSource this]
    (-> this (.getLocation))))

(defn get-certificates
  "Returns the certificates associated with this CodeSource.

   If this CodeSource object was created using the
   CodeSource(URL url, CodeSigner[] signers)
   constructor then its certificate chains are extracted and used to
   create an array of Certificate objects. Each signer certificate is
   followed by its supporting certificate chain (which may be empty).
   Each signer certificate and its supporting certificate chain is ordered
   bottom-to-top (i.e., with the signer certificate first and the (root)
   certificate authority last).

  returns: A copy of the certificates array, or null if there is none. - `java.security.cert.Certificate[]`"
  ([^CodeSource this]
    (-> this (.getCertificates))))

(defn get-code-signers
  "Returns the code signers associated with this CodeSource.

   If this CodeSource object was created using the
   CodeSource(URL url, java.security.cert.Certificate[] certs)
   constructor then its certificate chains are extracted and used to
   create an array of CodeSigner objects. Note that only X.509 certificates
   are examined - all other certificate types are ignored.

  returns: A copy of the code signer array, or null if there is none. - `java.security.CodeSigner[]`"
  ([^CodeSource this]
    (-> this (.getCodeSigners))))

(defn implies
  "Returns true if this CodeSource object `implies` the specified CodeSource.

   More specifically, this method makes the following checks.
   If any fail, it returns false. If they all succeed, it returns true.

    codesource must not be null.
    If this object's certificates are not null, then all
   of this object's certificates must be present in codesource's
   certificates.
    If this object's location (getLocation()) is not null, then the
   following checks are made against this object's location and
   codesource's:

         codesource's location must not be null.

         If this object's location
             equals codesource's location, then return true.

         This object's protocol (getLocation().getProtocol()) must be
             equal to codesource's protocol, ignoring case.

         If this object's host (getLocation().getHost()) is not null,
             then the SocketPermission
             constructed with this object's host must imply the
             SocketPermission constructed with codesource's host.

         If this object's port (getLocation().getPort()) is not
             equal to -1 (that is, if a port is specified), it must equal
             codesource's port or default port
             (codesource.getLocation().getDefaultPort()).

         If this object's file (getLocation().getFile()) doesn't equal
             codesource's file, then the following checks are made:
             If this object's file ends with `/-`,
             then codesource's file must start with this object's
             file (exclusive the trailing `-`).
             If this object's file ends with a `/*`,
             then codesource's file must start with this object's
             file and must not have any further `/` separators.
             If this object's file doesn't end with a `/`,
             then codesource's file must match this object's
             file with a '/' appended.

         If this object's reference (getLocation().getRef()) is
             not null, it must equal codesource's reference.




   For example, the codesource objects with the following locations
   and null certificates all imply
   the codesource with the location `http://java.sun.com/classes/foo.jar`
   and null certificates:


       http:
       http://*.sun.com/classes/*
       http://java.sun.com/classes/-
       http://java.sun.com/classes/foo.jar

   Note that if this CodeSource has a null location and a null
   certificate chain, then it implies every other CodeSource.

  codesource - CodeSource to compare against. - `java.security.CodeSource`

  returns: true if the specified codesource is implied by this codesource,
   false if not. - `boolean`"
  (^Boolean [^CodeSource this ^java.security.CodeSource codesource]
    (-> this (.implies codesource))))

(defn to-string
  "Returns a string describing this CodeSource, telling its
   URL and certificates.

  returns: information about this CodeSource. - `java.lang.String`"
  (^java.lang.String [^CodeSource this]
    (-> this (.toString))))

