(ns javax.security.cert.CertificateEncodingException
  "Certificate Encoding Exception. This is thrown whenever an error
  occurs whilst attempting to encode a certificate.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert CertificateEncodingException]))

(defn ->certificate-encoding-exception
  "Constructor.

  Constructs a CertificateEncodingException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new CertificateEncodingException message))
  ([]
    (new CertificateEncodingException )))

