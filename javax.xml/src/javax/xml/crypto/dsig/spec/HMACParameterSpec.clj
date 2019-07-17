(ns javax.xml.crypto.dsig.spec.HMACParameterSpec
  "Parameters for the
  XML Signature HMAC Algorithm. The parameters include an optional output
  length which specifies the MAC truncation length in bits. The resulting
  HMAC will be truncated to the specified number of bits. If the parameter is
  not specified, then this implies that all the bits of the hash are to be
  output. The XML Schema Definition of the HMACOutputLength
  element is defined as:


  <element name=`HMACOutputLength` minOccurs=`0` type=`ds:HMACOutputLengthType`/>
  <simpleType name=`HMACOutputLengthType`>
    <restriction base=`integer`/>
  </simpleType>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec HMACParameterSpec]))

(defn ->hmac-parameter-spec
  "Constructor.

  Creates an HMACParameterSpec with the specified truncation
   length.

  output-length - the truncation length in number of bits - `int`"
  ([^Integer output-length]
    (new HMACParameterSpec output-length)))

(defn get-output-length
  "Returns the truncation length.

  returns: the truncation length in number of bits - `int`"
  ([^javax.xml.crypto.dsig.spec.HMACParameterSpec this]
    (-> this (.getOutputLength))))

