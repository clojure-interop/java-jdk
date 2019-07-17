(ns javax.xml.crypto.dsig.XMLSignContext
  "Contains context information for generating XML Signatures. This interface
  is primarily intended for type-safety.

  Note that XMLSignContext instances can contain
  information and state specific to the XML signature structure it is
  used with. The results are unpredictable if an
  XMLSignContext is used with different signature structures
  (for example, you should not use the same XMLSignContext
  instance to sign two different XMLSignature objects).

  Supported Properties
  The following properties can be set using the
  setProperty method.

    javax.xml.crypto.dsig.cacheReference: value must be a
       Boolean. This property controls whether or not the digested
       Reference objects will cache the dereferenced content and
       pre-digested input for subsequent retrieval via the
       Reference.getDereferencedData and
       Reference.getDigestInputStream
       methods. The default value if not specified is
       Boolean.FALSE."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLSignContext]))

