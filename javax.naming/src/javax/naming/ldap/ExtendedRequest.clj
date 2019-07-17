(ns javax.naming.ldap.ExtendedRequest
  "This interface represents an LDAPv3 extended operation request as defined in
  RFC 2251.


      ExtendedRequest ::= [APPLICATION 23] SEQUENCE {
               requestName      [0] LDAPOID,
               requestValue     [1] OCTET STRING OPTIONAL }
  It comprises an object identifier string and an optional ASN.1 BER
  encoded value.

  The methods in this class are used by the service provider to construct
  the bits to send to the LDAP server. Applications typically only deal with
  the classes that implement this interface, supplying them with
  any information required for a particular extended operation request.
  It would then pass such a class as an argument to the
  LdapContext.extendedOperation() method for performing the
  LDAPv3 extended operation.

  For example, suppose the LDAP server supported a 'get time' extended operation.
  It would supply GetTimeRequest and GetTimeResponse classes:


  public class GetTimeRequest implements ExtendedRequest {
      public GetTimeRequest() {... };
      public ExtendedResponse createExtendedResponse(String id,
          byte[] berValue, int offset, int length)
          throws NamingException {
          return new GetTimeResponse(id, berValue, offset, length);
      }
      ...
  }
  public class GetTimeResponse implements ExtendedResponse {
      long time;
      public GetTimeResponse(String id, byte[] berValue, int offset,
          int length) throws NamingException {
          time =      ... // decode berValue to get time
      }
      public java.util.Date getDate() { return new java.util.Date(time) };
      public long getTime() { return time };
      ...
  }
  A program would use then these classes as follows:


  GetTimeResponse resp =
      (GetTimeResponse) ectx.extendedOperation(new GetTimeRequest());
  long time = resp.getTime();"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap ExtendedRequest]))

(defn get-id
  "Retrieves the object identifier of the request.

  returns: The non-null object identifier string representing the LDAP
           ExtendedRequest.requestName component. - `java.lang.String`"
  ([^javax.naming.ldap.ExtendedRequest this]
    (-> this (.getID))))

(defn get-encoded-value
  "Retrieves the ASN.1 BER encoded value of the LDAP extended operation
   request. Null is returned if the value is absent.

   The result is the raw BER bytes including the tag and length of
   the request value. It does not include the request OID.
   This method is called by the service provider to get the bits to
   put into the extended operation to be sent to the LDAP server.

  returns: A possibly null byte array representing the ASN.1 BER encoded
           contents of the LDAP ExtendedRequest.requestValue
           component. - `byte[]`

  throws: java.lang.IllegalStateException - If the encoded value cannot be retrieved because the request contains insufficient or invalid data/state."
  ([^javax.naming.ldap.ExtendedRequest this]
    (-> this (.getEncodedValue))))

(defn create-extended-response
  "Creates the response object that corresponds to this request.

   After the service provider has sent the extended operation request
   to the LDAP server, it will receive a response from the server.
   If the operation failed, the provider will throw a NamingException.
   If the operation succeeded, the provider will invoke this method
   using the data that it got back in the response.
   It is the job of this method to return a class that implements
   the ExtendedResponse interface that is appropriate for the
   extended operation request.

   For example, a Start TLS extended request class would need to know
   how to process a Start TLS extended response. It does this by creating
   a class that implements ExtendedResponse.

  id - The possibly null object identifier of the response control. - `java.lang.String`
  ber-value - The possibly null ASN.1 BER encoded value of the response control. This is the raw BER bytes including the tag and length of the response value. It does not include the response OID. - `byte[]`
  offset - The starting position in berValue of the bytes to use. - `int`
  length - The number of bytes in berValue to use. - `int`

  returns: A non-null object. - `javax.naming.ldap.ExtendedResponse`

  throws: javax.naming.NamingException - if cannot create extended response due to an error."
  ([^javax.naming.ldap.ExtendedRequest this ^java.lang.String id ber-value ^Integer offset ^Integer length]
    (-> this (.createExtendedResponse id ber-value offset length))))

