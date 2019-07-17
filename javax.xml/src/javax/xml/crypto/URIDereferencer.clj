(ns javax.xml.crypto.URIDereferencer
  "A dereferencer of URIReferences.

  The result of dereferencing a URIReference is either an
  instance of OctetStreamData or NodeSetData. Unless the
  URIReference is a same-document reference as defined
  in section 4.2 of the W3C Recommendation for XML-Signature Syntax and
  Processing, the result of dereferencing the URIReference
  MUST be an OctetStreamData."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto URIDereferencer]))

(defn dereference
  "Dereferences the specified URIReference and returns the
   dereferenced data.

  uri-reference - the URIReference - `javax.xml.crypto.URIReference`
  context - an XMLCryptoContext that may contain additional useful information for dereferencing the URI. This implementation should dereference the specified URIReference against the context's baseURI parameter, if specified. - `javax.xml.crypto.XMLCryptoContext`

  returns: the dereferenced data - `javax.xml.crypto.Data`

  throws: java.lang.NullPointerException - if uriReference or context are null"
  ([^. this ^javax.xml.crypto.URIReference uri-reference ^javax.xml.crypto.XMLCryptoContext context]
    (-> this (.dereference uri-reference context))))

