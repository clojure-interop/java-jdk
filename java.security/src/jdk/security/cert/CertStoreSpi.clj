(ns jdk.security.cert.CertStoreSpi
  "The Service Provider Interface (SPI)
  for the CertStore class. All CertStore
  implementations must include a class (the SPI class) that extends
  this class (CertStoreSpi), provides a constructor with
  a single argument of type CertStoreParameters, and implements
  all of its methods. In general, instances of this class should only be
  accessed through the CertStore class.
  For details, see the Java Cryptography Architecture.

  Concurrent Access

  The public methods of all CertStoreSpi objects must be
  thread-safe. That is, multiple threads may concurrently invoke these
  methods on a single CertStoreSpi object (or more than one)
  with no ill effects. This allows a CertPathBuilder to search
  for a CRL while simultaneously searching for further certificates, for
  instance.

  Simple CertStoreSpi implementations will probably ensure
  thread safety by adding a synchronized keyword to their
  engineGetCertificates and engineGetCRLs methods.
  More sophisticated ones may allow truly concurrent access."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertStoreSpi]))

(defn ->cert-store-spi
  "Constructor.

  The sole constructor.

  params - the initialization parameters (may be null) - `java.security.cert.CertStoreParameters`

  throws: java.security.InvalidAlgorithmParameterException - if the initialization parameters are inappropriate for this CertStoreSpi"
  ([params]
    (new CertStoreSpi params)))

(defn engine-get-certificates
  "Returns a Collection of Certificates that
   match the specified selector. If no Certificates
   match the selector, an empty Collection will be returned.

   For some CertStore types, the resulting
   Collection may not contain all of the
   Certificates that match the selector. For instance,
   an LDAP CertStore may not search all entries in the
   directory. Instead, it may just search entries that are likely to
   contain the Certificates it is looking for.

   Some CertStore implementations (especially LDAP
   CertStores) may throw a CertStoreException
   unless a non-null CertSelector is provided that includes
   specific criteria that can be used to find the certificates. Issuer
   and/or subject names are especially useful criteria.

  selector - A CertSelector used to select which Certificates should be returned. Specify null to return all Certificates (if supported). - `java.security.cert.CertSelector`

  returns: A Collection of Certificates that
           match the specified selector (never null) - `java.util.Collection<? extends java.security.cert.Certificate>`

  throws: java.security.cert.CertStoreException - if an exception occurs"
  ([this selector]
    (-> this (.engineGetCertificates selector))))

(defn engine-get-cr-ls
  "Returns a Collection of CRLs that
   match the specified selector. If no CRLs
   match the selector, an empty Collection will be returned.

   For some CertStore types, the resulting
   Collection may not contain all of the
   CRLs that match the selector. For instance,
   an LDAP CertStore may not search all entries in the
   directory. Instead, it may just search entries that are likely to
   contain the CRLs it is looking for.

   Some CertStore implementations (especially LDAP
   CertStores) may throw a CertStoreException
   unless a non-null CRLSelector is provided that includes
   specific criteria that can be used to find the CRLs. Issuer names
   and/or the certificate to be checked are especially useful.

  selector - A CRLSelector used to select which CRLs should be returned. Specify null to return all CRLs (if supported). - `java.security.cert.CRLSelector`

  returns: A Collection of CRLs that
           match the specified selector (never null) - `java.util.Collection<? extends java.security.cert.CRL>`

  throws: java.security.cert.CertStoreException - if an exception occurs"
  ([this selector]
    (-> this (.engineGetCRLs selector))))

