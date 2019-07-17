(ns javax.naming.ldap.InitialLdapContext
  "This class is the starting context for performing
  LDAPv3-style extended operations and controls.

  See javax.naming.InitialContext and
  javax.naming.InitialDirContext for details on synchronization,
  and the policy for how an initial context is created.

  Request Controls
  When you create an initial context (InitialLdapContext),
  you can specify a list of request controls.
  These controls will be used as the request controls for any
  implicit LDAP `bind` operation performed by the context or contexts
  derived from the context. These are called connection request controls.
  Use getConnectControls() to get a context's connection request
  controls.

  The request controls supplied to the initial context constructor
  are not used as the context request controls
  for subsequent context operations such as searches and lookups.
  Context request controls are set and updated by using
  setRequestControls().

  As shown, there can be two different sets of request controls
  associated with a context: connection request controls and context
  request controls.
  This is required for those applications needing to send critical
  controls that might not be applicable to both the context operation and
  any implicit LDAP `bind` operation.
  A typical user program would do the following:


  InitialLdapContext lctx = new InitialLdapContext(env, critConnCtls);
  lctx.setRequestControls(critModCtls);
  lctx.modifyAttributes(name, mods);
  Controls[] respCtls =  lctx.getResponseControls();
  It specifies first the critical controls for creating the initial context
  (critConnCtls), and then sets the context's request controls
  (critModCtls) for the context operation. If for some reason
  lctx needs to reconnect to the server, it will use
  critConnCtls. See the LdapContext interface for
  more discussion about request controls.

  Service provider implementors should read the `Service Provider` section
  in the LdapContext class description for implementation details."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap InitialLdapContext]))

(defn ->initial-ldap-context
  "Constructor.

  Constructs an initial context
   using environment properties and connection request controls.
   See javax.naming.InitialContext for a discussion of
   environment properties.

    This constructor will not modify its parameters or
   save references to them, but may save a clone or copy.
   Caller should not modify mutable keys and values in
   environment after it has been passed to the constructor.

    connCtls is used as the underlying context instance's
   connection request controls.  See the class description
   for details.

  environment - environment used to create the initial DirContext. Null indicates an empty environment. - `java.util.Hashtable<?,?>`
  conn-ctls - connection request controls for the initial context. If null, no connection request controls are used. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([environment conn-ctls]
    (new InitialLdapContext environment conn-ctls))
  ([]
    (new InitialLdapContext )))

(defn extended-operation
  "Description copied from interface: LdapContext

  request - The non-null request to be performed. - `javax.naming.ldap.ExtendedRequest`

  returns: The possibly null response of the operation. null means
   the operation did not generate any response. - `javax.naming.ldap.ExtendedResponse`

  throws: javax.naming.NamingException - If an error occurred while performing the extended operation."
  ([this request]
    (-> this (.extendedOperation request))))

(defn new-instance
  "Description copied from interface: LdapContext

  req-ctls - The possibly null request controls to use for the new context. If null, the context is initialized with no request controls. - `javax.naming.ldap.Control[]`

  returns: A non-null LdapContext instance. - `javax.naming.ldap.LdapContext`

  throws: javax.naming.NamingException - If an error occurred while creating the new instance."
  ([this req-ctls]
    (-> this (.newInstance req-ctls))))

(defn reconnect
  "Description copied from interface: LdapContext

  conn-ctls - The possibly null controls to use. If null, no controls are used. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while reconnecting."
  ([this conn-ctls]
    (-> this (.reconnect conn-ctls))))

(defn get-connect-controls
  "Description copied from interface: LdapContext

  returns: A possibly-null array of controls. null means no connect controls
   have been set for this context. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the request controls."
  ([this]
    (-> this (.getConnectControls))))

(defn set-request-controls
  "Description copied from interface: LdapContext

  request-controls - The possibly null controls to use. If null, no controls are used. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while setting the request controls."
  ([this request-controls]
    (-> this (.setRequestControls request-controls))))

(defn get-request-controls
  "Description copied from interface: LdapContext

  returns: A possibly-null array of controls. null means no request controls
   have been set for this context. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the request controls."
  ([this]
    (-> this (.getRequestControls))))

(defn get-response-controls
  "Description copied from interface: LdapContext

  returns: A possibly null array of controls. If null, the previous
   method invoked on this context did not produce any controls. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the response controls."
  ([this]
    (-> this (.getResponseControls))))

