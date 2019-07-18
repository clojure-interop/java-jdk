(ns javax.security.sasl.SaslClient
  "Performs SASL authentication as a client.

  A protocol library such as one for LDAP gets an instance of this
  class in order to perform authentication defined by a specific SASL
  mechanism. Invoking methods on the SaslClient instance
  process challenges and create responses according to the SASL
  mechanism implemented by the SaslClient.
  As the authentication proceeds, the instance
  encapsulates the state of a SASL client's authentication exchange.

  Here's an example of how an LDAP library might use a SaslClient.
  It first gets an instance of a SaslClient:


  SaslClient sc = Sasl.createSaslClient(mechanisms,
      authorizationId, protocol, serverName, props, callbackHandler);
  It can then proceed to use the client for authentication.
  For example, an LDAP library might use the client as follows:


  // Get initial response and send to server
  byte[] response = (sc.hasInitialResponse() ? sc.evaluateChallenge(new byte[0]) :
      null);
  LdapResult res = ldap.sendBindRequest(dn, sc.getName(), response);
  while (!sc.isComplete() &&
      (res.status == SASL_BIND_IN_PROGRESS || res.status == SUCCESS)) {
      response = sc.evaluateChallenge(res.getBytes());
      if (res.status == SUCCESS) {
          // we're done; don't expect to send another BIND
          if (response != null) {
              throw new SaslException(
                  `Protocol error: attempting to send response after completion`);
          }
          break;
      }
      res = ldap.sendBindRequest(dn, sc.getName(), response);
  }
  if (sc.isComplete() && res.status == SUCCESS) {
     String qop = (String) sc.getNegotiatedProperty(Sasl.QOP);
     if (qop != null
         && (qop.equalsIgnoreCase(`auth-int`)
             || qop.equalsIgnoreCase(`auth-conf`))) {

       // Use SaslClient.wrap() and SaslClient.unwrap() for future
       // communication with server
       ldap.in = new SecureInputStream(sc, ldap.in);
       ldap.out = new SecureOutputStream(sc, ldap.out);
     }
  }

  If the mechanism has an initial response, the library invokes
  evaluateChallenge() with an empty
  challenge and to get initial response.
  Protocols such as IMAP4, which do not include an initial response with
  their first authentication command to the server, initiates the
  authentication without first calling hasInitialResponse()
  or evaluateChallenge().
  When the server responds to the command, it sends an initial challenge.
  For a SASL mechanism in which the client sends data first, the server should
  have issued a challenge with no data. This will then result in a call
  (on the client) to evaluateChallenge() with an empty challenge."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl SaslClient]))

(defn get-mechanism-name
  "Returns the IANA-registered mechanism name of this SASL client.
   (e.g. `CRAM-MD5`, `GSSAPI`).

  returns: A non-null string representing the IANA-registered mechanism name. - `java.lang.String`"
  (^java.lang.String [^SaslClient this]
    (-> this (.getMechanismName))))

(defn has-initial-response?
  "Determines whether this mechanism has an optional initial response.
   If true, caller should call evaluateChallenge() with an
   empty array to get the initial response.

  returns: true if this mechanism has an initial response. - `boolean`"
  (^Boolean [^SaslClient this]
    (-> this (.hasInitialResponse))))

(defn evaluate-challenge
  "Evaluates the challenge data and generates a response.
   If a challenge is received from the server during the authentication
   process, this method is called to prepare an appropriate next
   response to submit to the server.

  challenge - The non-null challenge sent from the server. The challenge array may have zero length. - `byte[]`

  returns: The possibly null response to send to the server.
   It is null if the challenge accompanied a `SUCCESS` status and the challenge
   only contains data for the client to update its state and no response
   needs to be sent to the server. The response is a zero-length byte
   array if the client is to send a response with no data. - `byte[]`

  throws: javax.security.sasl.SaslException - If an error occurred while processing the challenge or generating a response."
  ([^SaslClient this challenge]
    (-> this (.evaluateChallenge challenge))))

(defn complete?
  "Determines whether the authentication exchange has completed.
   This method may be called at any time, but typically, it
   will not be called until the caller has received indication
   from the server
   (in a protocol-specific manner) that the exchange has completed.

  returns: true if the authentication exchange has completed; false otherwise. - `boolean`"
  (^Boolean [^SaslClient this]
    (-> this (.isComplete))))

(defn unwrap
  "Unwraps a byte array received from the server.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true) and only if
   the authentication exchange has negotiated integrity and/or privacy
   as the quality of protection; otherwise, an
   IllegalStateException is thrown.

   incoming is the contents of the SASL buffer as defined in RFC 2222
   without the leading four octet field that represents the length.
   offset and len specify the portion of incoming
   to use.

  incoming - A non-null byte array containing the encoded bytes from the server. - `byte[]`
  offset - The starting position at incoming of the bytes to use. - `int`
  len - The number of bytes from incoming to use. - `int`

  returns: A non-null byte array containing the decoded bytes. - `byte[]`

  throws: javax.security.sasl.SaslException - if incoming cannot be successfully unwrapped."
  ([^SaslClient this incoming ^Integer offset ^Integer len]
    (-> this (.unwrap incoming offset len))))

(defn wrap
  "Wraps a byte array to be sent to the server.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true) and only if
   the authentication exchange has negotiated integrity and/or privacy
   as the quality of protection; otherwise, an
   IllegalStateException is thrown.

   The result of this method will make up the contents of the SASL buffer
   as defined in RFC 2222 without the leading four octet field that
   represents the length.
   offset and len specify the portion of outgoing
   to use.

  outgoing - A non-null byte array containing the bytes to encode. - `byte[]`
  offset - The starting position at outgoing of the bytes to use. - `int`
  len - The number of bytes from outgoing to use. - `int`

  returns: A non-null byte array containing the encoded bytes. - `byte[]`

  throws: javax.security.sasl.SaslException - if outgoing cannot be successfully wrapped."
  ([^SaslClient this outgoing ^Integer offset ^Integer len]
    (-> this (.wrap outgoing offset len))))

(defn get-negotiated-property
  "Retrieves the negotiated property.
   This method can be called only after the authentication exchange has
   completed (i.e., when isComplete() returns true); otherwise, an
   IllegalStateException is thrown.

  prop-name - The non-null property name. - `java.lang.String`

  returns: The value of the negotiated property. If null, the property was
   not negotiated or is not applicable to this mechanism. - `java.lang.Object`

  throws: java.lang.IllegalStateException - if this authentication exchange has not completed"
  (^java.lang.Object [^SaslClient this ^java.lang.String prop-name]
    (-> this (.getNegotiatedProperty prop-name))))

(defn dispose
  "Disposes of any system resources or security-sensitive information
   the SaslClient might be using. Invoking this method invalidates
   the SaslClient instance. This method is idempotent.

  throws: javax.security.sasl.SaslException - If a problem was encountered while disposing the resources."
  ([^SaslClient this]
    (-> this (.dispose))))

