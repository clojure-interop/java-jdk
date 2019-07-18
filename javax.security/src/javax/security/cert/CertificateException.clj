(ns javax.security.cert.CertificateException
  "This exception indicates one of a variety of certificate problems.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert CertificateException]))

(defn ->certificate-exception
  "Constructor.

  Constructs a certificate exception with the given detail
   message. A detail message is a String that describes this
   particular exception.

  msg - the detail message. - `java.lang.String`"
  (^CertificateException [^java.lang.String msg]
    (new CertificateException msg))
  (^CertificateException []
    (new CertificateException )))

