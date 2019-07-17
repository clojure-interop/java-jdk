(ns javax.security.sasl.SaslServer
  "Performs SASL authentication as a server.

  A server such an LDAP server gets an instance of this
  class in order to perform authentication defined by a specific SASL
  mechanism. Invoking methods on the SaslServer instance
  generates challenges according to the SASL
  mechanism implemented by the SaslServer.
  As the authentication proceeds, the instance
  encapsulates the state of a SASL server's authentication exchange.

  Here's an example of how an LDAP server might use a SaslServer.
  It first gets an instance of a SaslServer for the SASL mechanism
  requested by the client:


  SaslServer ss = Sasl.createSaslServer(mechanism,
      `ldap`, myFQDN, props, callbackHandler);
  It can then proceed to use the server for authentication.
  For example, suppose the LDAP server received an LDAP BIND request
  containing the name of the SASL mechanism and an (optional) initial
  response. It then might use the server as follows:


  while (!ss.isComplete()) {
      try {
          byte[] challenge = ss.evaluateResponse(response);
          if (ss.isComplete()) {
              status = ldap.sendBindResponse(mechanism, challenge, SUCCESS);
          } else {
              status = ldap.sendBindResponse(mechanism, challenge,
                    SASL_BIND_IN_PROGRESS);
              response = ldap.readBindRequest();
          }
      } catch (SaslException e) {
           status = ldap.sendErrorResponse(e);
           break;
      }
  }
  if (ss.isComplete() && status == SUCCESS) {
     String qop = (String) sc.getNegotiatedProperty(Sasl.QOP);
     if (qop != null
         && (qop.equalsIgnoreCase(`auth-int`)
             || qop.equalsIgnoreCase(`auth-conf`))) {

       // Use SaslServer.wrap() and SaslServer.unwrap() for future
       // communication with client
       ldap.in = new SecureInputStream(ss, ldap.in);
       ldap.out = new SecureOutputStream(ss, ldap.out);
     }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl SaslServer]))

(defn get-mechanism-name
  "Returns the IANA-registered mechanism name of this SASL server.
   (e.g. `CRAM-MD5`, `GSSAPI`).

  returns: A non-null string representing the IANA-registered mechanism name. - `java.lang.String`"
  ([^javax.security.sasl.SaslServer this]
    (-> this (.getMechanismName))))

(defn evaluate-response
  "Evaluates the response data and generates a challenge.

   If a response is received from the client during the authentication
   process, this method is called to prepare an appropriate next
   challenge to submit to the client. The challenge is null if the
   authentication has succeeded and no more challenge data is to be sent
   to the client. It is non-null if the authentication must be continued
   by sending a challenge to the client, or if the authentication has
   succeeded but challenge data needs to be processed by the client.
   isComplete() should be called
   after each call to evaluateResponse(),to determine if any further
   response is needed from the client.

  response - The non-null (but possibly empty) response sent by the client. - `byte[]`

  returns: The possibly null challenge to send to the client.
   It is null if the authentication has succeeded and there is
   no more challenge data to be sent to the client. - `byte[]`

  throws: javax.security.sasl.SaslException - If an error occurred while processing the response or generating a challenge."
  ([^javax.security.sasl.SaslServer this response]
    (-> this (.evaluateResponse response))))

(defn complete?
  "Determines whether the authentication exchange has completed.
   This method is typically called after each invocation of
   evaluateResponse() to determine whether the
   authentication has completed successfully or should be continued.

  returns: true if the authentication exchange has completed; false otherwise. - `boolean`"
  ([^javax.security.sasl.SaslServer this]
    (-> this (.isComplete))))

(defn get-authorization-id
  "Reports the authorization ID in effect for the client of this
   session.
   This method can only be called if isComplete() returns true.

  returns: The authorization ID of the client. - `java.lang.String`

  throws: java.lang.IllegalStateException - if this authentication session has not completed"
  ([^javax.security.sasl.SaslServer this]
    (-> this (.getAuthorizationID))))

(defn unwrap
  "Unwraps a byte array received from the client.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true) and only if
   the authentication exchange has negotiated integrity and/or privacy
   as the quality of protection; otherwise,
   an IllegalStateException is thrown.

   incoming is the contents of the SASL buffer as defined in RFC 2222
   without the leading four octet field that represents the length.
   offset and len specify the portion of incoming
   to use.

  incoming - A non-null byte array containing the encoded bytes from the client. - `byte[]`
  offset - The starting position at incoming of the bytes to use. - `int`
  len - The number of bytes from incoming to use. - `int`

  returns: A non-null byte array containing the decoded bytes. - `byte[]`

  throws: javax.security.sasl.SaslException - if incoming cannot be successfully unwrapped."
  ([^javax.security.sasl.SaslServer this incoming ^Integer offset ^Integer len]
    (-> this (.unwrap incoming offset len))))

(defn wrap
  "Wraps a byte array to be sent to the client.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true) and only if
   the authentication exchange has negotiated integrity and/or privacy
   as the quality of protection; otherwise, a SaslException is thrown.

   The result of this method
   will make up the contents of the SASL buffer as defined in RFC 2222
   without the leading four octet field that represents the length.
   offset and len specify the portion of outgoing
   to use.

  outgoing - A non-null byte array containing the bytes to encode. - `byte[]`
  offset - The starting position at outgoing of the bytes to use. - `int`
  len - The number of bytes from outgoing to use. - `int`

  returns: A non-null byte array containing the encoded bytes. - `byte[]`

  throws: javax.security.sasl.SaslException - if outgoing cannot be successfully wrapped."
  ([^javax.security.sasl.SaslServer this outgoing ^Integer offset ^Integer len]
    (-> this (.wrap outgoing offset len))))

(defn get-negotiated-property
  "Retrieves the negotiated property.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true); otherwise, an
   IllegalStateException is thrown.

  prop-name - the property - `java.lang.String`

  returns: The value of the negotiated property. If null, the property was
   not negotiated or is not applicable to this mechanism. - `java.lang.Object`

  throws: java.lang.IllegalStateException - if this authentication exchange has not completed"
  ([^javax.security.sasl.SaslServer this ^java.lang.String prop-name]
    (-> this (.getNegotiatedProperty prop-name))))

(defn dispose
  "Disposes of any system resources or security-sensitive information
   the SaslServer might be using. Invoking this method invalidates
   the SaslServer instance. This method is idempotent.

  throws: javax.security.sasl.SaslException - If a problem was encountered while disposing the resources."
  ([^javax.security.sasl.SaslServer this]
    (-> this (.dispose))))

