(ns javax.naming.ldap.ExtendedResponse
  "This interface represents an LDAP extended operation response as defined in
  RFC 2251.


      ExtendedResponse ::= [APPLICATION 24] SEQUENCE {
           COMPONENTS OF LDAPResult,
           responseName     [10] LDAPOID OPTIONAL,
           response         [11] OCTET STRING OPTIONAL }
  It comprises an optional object identifier and an optional ASN.1 BER
  encoded value.


  The methods in this class can be used by the application to get low
  level information about the extended operation response. However, typically,
  the application will be using methods specific to the class that
  implements this interface. Such a class should have decoded the BER buffer
  in the response and should provide methods that allow the user to
  access that data in the response in a type-safe and friendly manner.

  For example, suppose the LDAP server supported a 'get time' extended operation.
  It would supply GetTimeRequest and GetTimeResponse classes.
  The GetTimeResponse class might look like:


  public class GetTimeResponse implements ExtendedResponse {
      public java.util.Date getDate() {...};
      public long getTime() {...};
      ....
  }
  A program would use then these classes as follows:


  GetTimeResponse resp =
      (GetTimeResponse) ectx.extendedOperation(new GetTimeRequest());
  java.util.Date now = resp.getDate();"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap ExtendedResponse]))

(defn get-id
  "Retrieves the object identifier of the response.
   The LDAP protocol specifies that the response object identifier is optional.
   If the server does not send it, the response will contain no ID (i.e. null).

  returns: A possibly null object identifier string representing the LDAP
           ExtendedResponse.responseName component. - `java.lang.String`"
  (^java.lang.String [^javax.naming.ldap.ExtendedResponse this]
    (-> this (.getID))))

(defn get-encoded-value
  "Retrieves the ASN.1 BER encoded value of the LDAP extended operation
   response. Null is returned if the value is absent from the response
   sent by the LDAP server.
   The result is the raw BER bytes including the tag and length of
   the response value. It does not include the response OID.

  returns: A possibly null byte array representing the ASN.1 BER encoded
           contents of the LDAP ExtendedResponse.response
           component. - `byte[]`"
  ([^javax.naming.ldap.ExtendedResponse this]
    (-> this (.getEncodedValue))))

