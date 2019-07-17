(ns javax.xml.ws.soap.AddressingFeature$Responses
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.soap AddressingFeature$Responses]))

(def ANONYMOUS
  "Enum Constant.

  Specifies the use of only anonymous
   responses. It will result into wsam:AnonymousResponses nested assertion
   as specified in

   3.1.2 AnonymousResponses Assertion in the generated WSDL.

  type: javax.xml.ws.soap.AddressingFeature.Responses"
  AddressingFeature$Responses/ANONYMOUS)

(def NON_ANONYMOUS
  "Enum Constant.

  Specifies the use of only non-anonymous
   responses. It will result into
   wsam:NonAnonymousResponses nested assertion as specified in

   3.1.3 NonAnonymousResponses Assertion in the generated WSDL.

  type: javax.xml.ws.soap.AddressingFeature.Responses"
  AddressingFeature$Responses/NON_ANONYMOUS)

(def ALL
  "Enum Constant.

  Supports all response types and this is the default

  type: javax.xml.ws.soap.AddressingFeature.Responses"
  AddressingFeature$Responses/ALL)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AddressingFeature.Responses c : AddressingFeature.Responses.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.ws.soap.AddressingFeature.Responses[]`"
  ([]
    (AddressingFeature$Responses/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.ws.soap.AddressingFeature.Responses`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (AddressingFeature$Responses/valueOf name)))

