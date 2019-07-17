(ns javax.xml.crypto.dsig.XMLValidateContext
  "Contains context information for validating XML Signatures. This interface
  is primarily intended for type-safety.

  Note that XMLValidateContext instances can contain
  information and state specific to the XML signature structure it is
  used with. The results are unpredictable if an
  XMLValidateContext is used with different signature structures
  (for example, you should not use the same XMLValidateContext
  instance to validate two different XMLSignature objects).

  Supported Properties
  The following properties can be set by an application using the
  setProperty method.

    javax.xml.crypto.dsig.cacheReference: value must be a
       Boolean. This property controls whether or not the
       Reference.validate method will cache the
       dereferenced content and pre-digested input for subsequent retrieval via
       the Reference.getDereferencedData
       and Reference.getDigestInputStream methods. The default value if not
       specified is Boolean.FALSE."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLValidateContext]))

