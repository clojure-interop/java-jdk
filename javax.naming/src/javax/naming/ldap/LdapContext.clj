(ns javax.naming.ldap.LdapContext
  "This interface represents a context in which you can perform
  operations with LDAPv3-style controls and perform LDAPv3-style
  extended operations.

  For applications that do not require such controls or extended
  operations, the more generic javax.naming.directory.DirContext
  should be used instead.

  Usage Details About Controls

  This interface provides support for LDAP v3 controls.
  At a high level, this support allows a user
  program to set request controls for LDAP operations that are executed
  in the course of the user program's invocation of
  Context/DirContext
  methods, and read response controls resulting from LDAP operations.
  At the implementation level, there are some details that developers of
  both the user program and service providers need to understand in order
  to correctly use request and response controls.

  Request Controls

  There are two types of request controls:

  Request controls that affect how a connection is created
  Request controls that affect context methods


  The former is used whenever a connection needs to be established or
  re-established with an LDAP server. The latter is used when all other
  LDAP operations are sent to the LDAP server.  The reason why a
  distinction between these two types of request controls is necessary
  is because JNDI is a high-level API that does not deal directly with
  connections.  It is the job of service providers to do any necessary
  connection management. Consequently, a single
  connection may be shared by multiple context instances, and a service provider
  is free to use its own algorithms to conserve connection and network
  usage. Thus, when a method is invoked on the context instance, the service
  provider might need to do some connection management in addition to
  performing the corresponding LDAP operations. For connection management,
  it uses the connection request controls, while for the normal
  LDAP operations, it uses the context request controls.
 Unless explicitly qualified, the term \"request controls\" refers to
  context request controls.

  Context Request Controls
  There are two ways in which a context instance gets its request controls:

  ldapContext.newInstance(reqCtls)
  ldapContext.setRequestControls(reqCtls)

  where ldapContext is an instance of LdapContext.
  Specifying null or an empty array for reqCtls
  means no request controls.
  newInstance() creates a new instance of a context using
  reqCtls, while setRequestControls()
  updates an existing context instance's request controls to reqCtls.

  Unlike environment properties, request controls of a context instance
  are not inherited by context instances that are derived from
  it.  Derived context instances have null as their context
  request controls.  You must set the request controls of a derived context
  instance explicitly using setRequestControls().

  A context instance's request controls are retrieved using
  the method getRequestControls().

  Connection Request Controls
  There are three ways in which connection request controls are set:


  new InitialLdapContext(env, connCtls)
  refException.getReferralContext(env, connCtls)
  ldapContext.reconnect(connCtls);

  where refException is an instance of
  LdapReferralException, and ldapContext is an
  instance of LdapContext.
  Specifying null or an empty array for connCtls
  means no connection request controls.

  Like environment properties, connection request controls of a context
  are inherited by contexts that are derived from it.
  Typically, you initialize the connection request controls using the
  InitialLdapContext constructor or
  LdapReferralContext.getReferralContext(). These connection
  request controls are inherited by contexts that share the same
  connection--that is, contexts derived from the initial or referral
  contexts.

  Use reconnect() to change the connection request controls of
  a context.
  Invoking ldapContext.reconnect() affects only the
  connection used by ldapContext and any new contexts instances that are
  derived form ldapContext. Contexts that previously shared the
  connection with ldapContext remain unchanged. That is, a context's
  connection request controls must be explicitly changed and is not
  affected by changes to another context's connection request
  controls.

  A context instance's connection request controls are retrieved using
  the method getConnectControls().

  Service Provider Requirements

  A service provider supports connection and context request controls
  in the following ways.  Context request controls must be associated on
  a per context instance basis while connection request controls must be
  associated on a per connection instance basis.  The service provider
  must look for the connection request controls in the environment
  property \"java.naming.ldap.control.connect\" and pass this environment
  property on to context instances that it creates.

  Response Controls

  The method LdapContext.getResponseControls() is used to
  retrieve the response controls generated by LDAP operations executed
  as the result of invoking a Context/DirContext
  operation. The result is all of the responses controls generated
  by the underlying LDAP operations, including any implicit reconnection.
  To get only the reconnection response controls,
  use reconnect() followed by getResponseControls().

  Parameters

  A Control[] array
  passed as a parameter to any method is owned by the caller.
  The service provider will not modify the array or keep a reference to it,
  although it may keep references to the individual Control objects
  in the array.
  A Control[] array returned by any method is immutable, and may
  not subsequently be modified by either the caller or the service provider."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap LdapContext]))

(defn extended-operation
  "Performs an extended operation.

   This method is used to support LDAPv3 extended operations.

  request - The non-null request to be performed. - `javax.naming.ldap.ExtendedRequest`

  returns: The possibly null response of the operation. null means
   the operation did not generate any response. - `javax.naming.ldap.ExtendedResponse`

  throws: javax.naming.NamingException - If an error occurred while performing the extended operation."
  (^javax.naming.ldap.ExtendedResponse [^LdapContext this ^javax.naming.ldap.ExtendedRequest request]
    (-> this (.extendedOperation request))))

(defn new-instance
  "Creates a new instance of this context initialized using request controls.

   This method is a convenience method for creating a new instance
   of this context for the purposes of multithreaded access.
   For example, if multiple threads want to use different context
   request controls,
   each thread may use this method to get its own copy of this context
   and set/get context request controls without having to synchronize with other
   threads.

   The new context has the same environment properties and connection
   request controls as this context. See the class description for details.
   Implementations might also allow this context and the new context
   to share the same network connection or other resources if doing
   so does not impede the independence of either context.

  request-controls - The possibly null request controls to use for the new context. If null, the context is initialized with no request controls. - `javax.naming.ldap.Control[]`

  returns: A non-null LdapContext instance. - `javax.naming.ldap.LdapContext`

  throws: javax.naming.NamingException - If an error occurred while creating the new instance."
  (^javax.naming.ldap.LdapContext [^LdapContext this request-controls]
    (-> this (.newInstance request-controls))))

(defn reconnect
  "Reconnects to the LDAP server using the supplied controls and
   this context's environment.

   This method is a way to explicitly initiate an LDAP \"bind\" operation.
   For example, you can use this method to set request controls for
   the LDAP \"bind\" operation, or to explicitly connect to the server
   to get response controls returned by the LDAP \"bind\" operation.

   This method sets this context's connCtls
   to be its new connection request controls. This context's
   context request controls are not affected.
   After this method has been invoked, any subsequent
   implicit reconnections will be done using connCtls.
   connCtls are also used as
   connection request controls for new context instances derived from this
   context.
   These connection request controls are not
   affected by setRequestControls().

   Service provider implementors should read the \"Service Provider\" section
   in the class description for implementation details.

  conn-ctls - The possibly null controls to use. If null, no controls are used. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while reconnecting."
  ([^LdapContext this conn-ctls]
    (-> this (.reconnect conn-ctls))))

(defn get-connect-controls
  "Retrieves the connection request controls in effect for this context.
   The controls are owned by the JNDI implementation and are
   immutable. Neither the array nor the controls may be modified by the
   caller.

  returns: A possibly-null array of controls. null means no connect controls
   have been set for this context. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the request controls."
  ([^LdapContext this]
    (-> this (.getConnectControls))))

(defn set-request-controls
  "Sets the request controls for methods subsequently
   invoked on this context.
   The request controls are owned by the JNDI implementation and are
   immutable. Neither the array nor the controls may be modified by the
   caller.

   This removes any previous request controls and adds
   requestControls
   for use by subsequent methods invoked on this context.
   This method does not affect this context's connection request controls.

   Note that requestControls will be in effect until the next
   invocation of setRequestControls(). You need to explicitly
   invoke setRequestControls() with null or an empty
   array to clear the controls if you don't want them to affect the
   context methods any more.
   To check what request controls are in effect for this context, use
   getRequestControls().

  request-controls - The possibly null controls to use. If null, no controls are used. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while setting the request controls."
  ([^LdapContext this request-controls]
    (-> this (.setRequestControls request-controls))))

(defn get-request-controls
  "Retrieves the request controls in effect for this context.
   The request controls are owned by the JNDI implementation and are
   immutable. Neither the array nor the controls may be modified by the
   caller.

  returns: A possibly-null array of controls. null means no request controls
   have been set for this context. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the request controls."
  ([^LdapContext this]
    (-> this (.getRequestControls))))

(defn get-response-controls
  "Retrieves the response controls produced as a result of the last
   method invoked on this context.
   The response controls are owned by the JNDI implementation and are
   immutable. Neither the array nor the controls may be modified by the
   caller.

   These response controls might have been generated by a successful or
   failed operation.

   When a context method that may return response controls is invoked,
   response controls from the previous method invocation are cleared.
   getResponseControls() returns all of the response controls
   generated by LDAP operations used by the context method in the order
   received from the LDAP server.
   Invoking getResponseControls() does not
   clear the response controls. You can call it many times (and get
   back the same controls) until the next context method that may return
   controls is invoked.

  returns: A possibly null array of controls. If null, the previous
   method invoked on this context did not produce any controls. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If an error occurred while getting the response controls."
  ([^LdapContext this]
    (-> this (.getResponseControls))))

