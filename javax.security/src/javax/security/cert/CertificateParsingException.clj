(ns javax.security.cert.CertificateParsingException
  "Certificate Parsing Exception. This is thrown whenever
  invalid DER encoded certificate is parsed or unsupported DER features
  are found in the Certificate.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert CertificateParsingException]))

(defn ->certificate-parsing-exception
  "Constructor.

  Constructs a CertificateParsingException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new CertificateParsingException message))
  ([]
    (new CertificateParsingException )))

