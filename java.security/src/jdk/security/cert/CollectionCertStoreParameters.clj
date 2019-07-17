(ns jdk.security.cert.CollectionCertStoreParameters
  "Parameters used as input for the Collection CertStore
  algorithm.

  This class is used to provide necessary configuration parameters
  to implementations of the Collection CertStore
  algorithm. The only parameter included in this class is the
  Collection from which the CertStore will
  retrieve certificates and CRLs.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CollectionCertStoreParameters]))

(defn ->collection-cert-store-parameters
  "Constructor.

  Creates an instance of CollectionCertStoreParameters
   which will allow certificates and CRLs to be retrieved from the
   specified Collection. If the specified
   Collection contains an object that is not a
   Certificate or CRL, that object will be
   ignored by the Collection CertStore.

   The Collection is not copied. Instead, a
   reference is used. This allows the caller to subsequently add or
   remove Certificates or CRLs from the
   Collection, thus changing the set of
   Certificates or CRLs available to the
   Collection CertStore. The Collection CertStore
   will not modify the contents of the Collection.

   If the Collection will be modified by one thread while
   another thread is calling a method of a Collection CertStore
   that has been initialized with this Collection, the
   Collection must have fail-fast iterators.

  collection - a Collection of Certificates and CRLs - `java.util.Collection<?>`

  throws: java.lang.NullPointerException - if collection is null"
  ([^java.util.Collection collection]
    (new CollectionCertStoreParameters collection))
  ([]
    (new CollectionCertStoreParameters )))

(defn get-collection
  "Returns the Collection from which Certificates
   and CRLs are retrieved. This is not a copy of the
   Collection, it is a reference. This allows the caller to
   subsequently add or remove Certificates or
   CRLs from the Collection.

  returns: the Collection (never null) - `java.util.Collection<?>`"
  (^java.util.Collection [^java.security.cert.CollectionCertStoreParameters this]
    (-> this (.getCollection))))

(defn clone
  "Returns a copy of this object. Note that only a reference to the
   Collection is copied, and not the contents.

  returns: the copy - `java.lang.Object`"
  (^java.lang.Object [^java.security.cert.CollectionCertStoreParameters this]
    (-> this (.clone))))

(defn to-string
  "Returns a formatted string describing the parameters.

  returns: a formatted string describing the parameters - `java.lang.String`"
  (^java.lang.String [^java.security.cert.CollectionCertStoreParameters this]
    (-> this (.toString))))

