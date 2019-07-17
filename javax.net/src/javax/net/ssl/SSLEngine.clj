(ns javax.net.ssl.SSLEngine
  "A class which enables secure communications using protocols such as
  the Secure Sockets Layer (SSL) or
   IETF RFC 2246 `Transport
  Layer Security` (TLS)  protocols, but is transport independent.

  The secure communications modes include:

        Integrity Protection.  SSL/TLS protects against
       modification of messages by an active wiretapper.

        Authentication.  In most modes, SSL/TLS provides
       peer authentication.  Servers are usually authenticated, and
       clients may be authenticated as requested by servers.

        Confidentiality (Privacy Protection).  In most
       modes, SSL/TLS encrypts data being sent between client and
       server.  This protects the confidentiality of data, so that
       passive wiretappers won't see sensitive data such as financial
       information or personal information of many kinds.



  These kinds of protection are specified by a `cipher suite`, which
  is a combination of cryptographic algorithms used by a given SSL
  connection.  During the negotiation process, the two endpoints must
  agree on a cipher suite that is available in both environments.  If
  there is no such suite in common, no SSL connection can be
  established, and no data can be exchanged.

  The cipher suite used is established by a negotiation process called
  `handshaking`.  The goal of this process is to create or rejoin a
  `session`, which may protect many connections over time.  After
  handshaking has completed, you can access session attributes by
  using the getSession() method.

  The SSLSocket class provides much of the same security
  functionality, but all of the inbound and outbound data is
  automatically transported using the underlying Socket, which by design uses a blocking model.
  While this is appropriate for many applications, this model does not
  provide the scalability required by large servers.

  The primary distinction of an SSLEngine is that it
  operates on inbound and outbound byte streams, independent of the
  transport mechanism.  It is the responsibility of the
  SSLEngine user to arrange for reliable I/O transport to
  the peer.  By separating the SSL/TLS abstraction from the I/O
  transport mechanism, the SSLEngine can be used for a
  wide variety of I/O types, such as non-blocking I/O (polling), selectable non-blocking I/O, Socket and the
  traditional Input/OutputStreams, local ByteBuffers or byte arrays,  future asynchronous
  I/O models , and so on.

  At a high level, the SSLEngine appears thus:



                    app data

                 |           ^
                 |     |     |
                 v     |     |
            ----+-----|-----+----+
            |          |          |
            |       SSL|Engine    |
    wrap()  |          |          |  unwrap()
            | OUTBOUND | INBOUND  |
            |          |          |
            ----+-----|-----+----+
                 |     |     ^
                 |     |     |
                 v           |

                    net data
  Application data (also known as plaintext or cleartext) is data which
  is produced or consumed by an application.  Its counterpart is
  network data, which consists of either handshaking and/or ciphertext
  (encrypted) data, and destined to be transported via an I/O
  mechanism.  Inbound data is data which has been received from the
  peer, and outbound data is destined for the peer.

  (In the context of an SSLEngine, the term `handshake
  data` is taken to mean any data exchanged to establish and control a
  secure connection.  Handshake data includes the SSL/TLS messages
  `alert`, `change_cipher_spec,` and `handshake.`)

  There are five distinct phases to an SSLEngine.


       Creation - The SSLEngine has been created and
      initialized, but has not yet been used.  During this phase, an
      application may set any SSLEngine-specific settings
      (enabled cipher suites, whether the SSLEngine should
      handshake in client or server mode, and so on).  Once
      handshaking has begun, though, any new settings (except
      client/server mode, see below) will be used for
      the next handshake.

       Initial Handshake - The initial handshake is a procedure by
      which the two peers exchange communication parameters until an
      SSLSession is established.  Application data can not be sent during
      this phase.

       Application Data - Once the communication parameters have
      been established and the handshake is complete, application data
      may flow through the SSLEngine.  Outbound
      application messages are encrypted and integrity protected,
      and inbound messages reverse the process.

        Rehandshaking - Either side may request a renegotiation of
      the session at any time during the Application Data phase.  New
      handshaking data can be intermixed among the application data.
      Before starting the rehandshake phase, the application may
      reset the SSL/TLS communication parameters such as the list of
      enabled ciphersuites and whether to use client authentication,
      but can not change between client/server modes.  As before, once
      handshaking has begun, any new SSLEngine
      configuration settings will not be used until the next
      handshake.

        Closure - When the connection is no longer needed, the
      application should close the SSLEngine and should
      send/receive any remaining messages to the peer before
      closing the underlying transport mechanism.  Once an engine is
      closed, it is not reusable:  a new SSLEngine must
      be created.

  An SSLEngine is created by calling SSLContext.createSSLEngine() from an initialized
  SSLContext.  Any configuration
  parameters should be set before making the first call to
  wrap(), unwrap(), or
  beginHandshake().  These methods all trigger the
  initial handshake.

  Data moves through the engine by calling wrap() or unwrap() on outbound or inbound data, respectively.  Depending on
  the state of the SSLEngine, a wrap() call
  may consume application data from the source buffer and may produce
  network data in the destination buffer.  The outbound data
  may contain application and/or handshake data.  A call to
  unwrap() will examine the source buffer and may
  advance the handshake if the data is handshaking information, or
  may place application data in the destination buffer if the data
  is application.  The state of the underlying SSL/TLS algorithm
  will determine when data is consumed and produced.

  Calls to wrap() and unwrap() return an
  SSLEngineResult which indicates the status of the
  operation, and (optionally) how to interact with the engine to make
  progress.

  The SSLEngine produces/consumes complete SSL/TLS
  packets only, and does not store application data internally between
  calls to wrap()/unwrap().  Thus input and output
  ByteBuffers must be sized appropriately to hold the
  maximum record that can be produced.  Calls to SSLSession.getPacketBufferSize() and SSLSession.getApplicationBufferSize() should be used to determine
  the appropriate buffer sizes.  The size of the outbound application
  data buffer generally does not matter.  If buffer conditions do not
  allow for the proper consumption/production of data, the application
  must determine (via SSLEngineResult) and correct the
  problem, and then try the call again.

  For example, unwrap() will return a SSLEngineResult.Status.BUFFER_OVERFLOW result if the engine
  determines that there is not enough destination buffer space available.
  Applications should call SSLSession.getApplicationBufferSize()
  and compare that value with the space available in the destination buffer,
  enlarging the buffer if necessary.  Similarly, if unwrap()
  were to return a SSLEngineResult.Status.BUFFER_UNDERFLOW, the
  application should call SSLSession.getPacketBufferSize() to ensure
  that the source buffer has enough room to hold a record (enlarging if
  necessary), and then obtain more inbound data.



    SSLEngineResult r = engine.unwrap(src, dst);
    switch (r.getStatus()) {
    BUFFER_OVERFLOW:
        // Could attempt to drain the dst buffer of any already obtained
        // data, but we'll just increase it to the size needed.
        int appSize = engine.getSession().getApplicationBufferSize();
        ByteBuffer b = ByteBuffer.allocate(appSize  dst.position());
        dst.flip();
        b.put(dst);
        dst = b;
        // retry the operation.
        break;
    BUFFER_UNDERFLOW:
        int netSize = engine.getSession().getPacketBufferSize();
        // Resize buffer if needed.
        if (netSize > dst.capacity()) {
            ByteBuffer b = ByteBuffer.allocate(netSize);
            src.flip();
            b.put(src);
            src = b;
        }
        // Obtain more inbound network data for src,
        // then retry the operation.
        break;
    // other cases: CLOSED, OK.
    }


  Unlike SSLSocket, all methods of SSLEngine are
  non-blocking.  SSLEngine implementations may
  require the results of tasks that may take an extended period of
  time to complete, or may even block.  For example, a TrustManager
  may need to connect to a remote certificate validation service,
  or a KeyManager might need to prompt a user to determine which
  certificate to use as part of client authentication.  Additionally,
  creating cryptographic signatures and verifying them can be slow,
  seemingly blocking.

  For any operation which may potentially block, the
  SSLEngine will create a Runnable
  delegated task.  When SSLEngineResult indicates that a
  delegated task result is needed, the application must call getDelegatedTask() to obtain an outstanding delegated task and
  call its run() method (possibly using
  a different thread depending on the compute strategy).  The
  application should continue obtaining delegated tasks until no more
  exist, and try the original operation again.

  At the end of a communication session, applications should properly
  close the SSL/TLS link.  The SSL/TLS protocols have closure handshake
  messages, and these messages should be communicated to the peer
  before releasing the SSLEngine and closing the
  underlying transport mechanism.  A close can be initiated by one of:
  an SSLException, an inbound closure handshake message, or one of the
  close methods.  In all cases, closure handshake messages are
  generated by the engine, and wrap() should be repeatedly
  called until the resulting SSLEngineResult's status
  returns `CLOSED`, or isOutboundDone() returns true.  All
  data obtained from the wrap() method should be sent to the
  peer.

  closeOutbound() is used to signal the engine that the
  application will not be sending any more data.

  A peer will signal its intent to close by sending its own closure
  handshake message.  After this message has been received and
  processed by the local SSLEngine's unwrap()
  call, the application can detect the close by calling
  unwrap() and looking for a SSLEngineResult
  with status `CLOSED`, or if isInboundDone() returns true.
  If for some reason the peer closes the communication link without
  sending the proper SSL/TLS closure message, the application can
  detect the end-of-stream and can signal the engine via closeInbound() that there will no more inbound messages to
  process.  Some applications might choose to require orderly shutdown
  messages from a peer, in which case they can check that the closure
  was generated by a handshake message and not by an end-of-stream
  condition.

  There are two groups of cipher suites which you will need to know
  about when managing cipher suites:


        Supported cipher suites:  all the suites which are
       supported by the SSL implementation.  This list is reported
       using getSupportedCipherSuites().

        Enabled cipher suites, which may be fewer than
       the full set of supported suites.  This group is set using the
       setEnabledCipherSuites(String []) method, and
       queried using the getEnabledCipherSuites() method.
       Initially, a default set of cipher suites will be enabled on a
       new engine that represents the minimum suggested
       configuration.


  Implementation defaults require that only cipher suites which
  authenticate servers and provide confidentiality be enabled by
  default.  Only if both sides explicitly agree to unauthenticated
  and/or non-private (unencrypted) communications will such a
  cipher suite be selected.

  Each SSL/TLS connection must have one client and one server, thus
  each endpoint must decide which role to assume.  This choice determines
  who begins the handshaking process as well as which type of messages
  should be sent by each party.  The method setUseClientMode(boolean) configures the mode.  Once the initial
  handshaking has started, an SSLEngine can not switch
  between client and server modes, even when performing renegotiations.

  Applications might choose to process delegated tasks in different
  threads.  When an SSLEngine
  is created, the current AccessControlContext
  is saved.  All future delegated tasks will be processed using this
  context:  that is, all access control decisions will be made using the
  context captured at engine creation.



  Concurrency Notes:
  There are two concurrency issues to be aware of:


       The wrap() and unwrap() methods
       may execute concurrently of each other.

        The SSL/TLS protocols employ ordered packets.
       Applications must take care to ensure that generated packets
       are delivered in sequence.  If packets arrive
       out-of-order, unexpected or fatal results may occur.

       For example:



               synchronized (outboundLock) {
                   sslEngine.wrap(src, dst);
                   outboundQueue.put(dst);
               }

       As a corollary, two threads must not attempt to call the same method
       (either wrap() or unwrap()) concurrently,
       because there is no way to guarantee the eventual packet ordering."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLEngine]))

(defn get-need-client-auth?
  "Returns true if the engine will require client authentication.
   This option is only useful to engines in the server mode.

  returns: true if client authentication is required,
            or false if no client authentication is desired. - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getNeedClientAuth))))

(defn get-supported-protocols
  "Returns the names of the protocols which could be enabled for use
   with this SSLEngine.

  returns: an array of protocols supported - `java.lang.String[]`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getSupportedProtocols))))

(defn inbound-done?
  "Returns whether unwrap(ByteBuffer, ByteBuffer) will
   accept any more inbound data messages.

  returns: true if the SSLEngine will not
            consume anymore network data (and by implication,
            will not produce any more application data.) - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.isInboundDone))))

(defn get-handshake-status
  "Returns the current handshake status for this SSLEngine.

  returns: the current SSLEngineResult.HandshakeStatus. - `javax.net.ssl.SSLEngineResult.HandshakeStatus`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getHandshakeStatus))))

(defn get-handshake-session
  "Returns the SSLSession being constructed during a SSL/TLS
   handshake.

   TLS protocols may negotiate parameters that are needed when using
   an instance of this class, but before the SSLSession has
   been completely initialized and made available via getSession.
   For example, the list of valid signature algorithms may restrict
   the type of certificates that can used during TrustManager
   decisions, or the maximum TLS fragment packet sizes can be
   resized to better support the network environment.

   This method provides early access to the SSLSession being
   constructed.  Depending on how far the handshake has progressed,
   some data may not yet be available for use.  For example, if a
   remote server will be sending a Certificate chain, but that chain
   has yet not been processed, the getPeerCertificates
   method of SSLSession will throw a
   SSLPeerUnverifiedException.  Once that chain has been processed,
   getPeerCertificates will return the proper value.

  returns: null if this instance is not currently handshaking, or
           if the current handshake has not progressed far enough to
           create a basic SSLSession.  Otherwise, this method returns the
           SSLSession currently being negotiated. - `javax.net.ssl.SSLSession`

  throws: java.lang.UnsupportedOperationException - if the underlying provider does not implement the operation."
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getHandshakeSession))))

(defn close-inbound
  "Signals that no more inbound network data will be sent
   to this SSLEngine.

   If the application initiated the closing process by calling
   closeOutbound(), under some circumstances it is not
   required that the initiator wait for the peer's corresponding
   close message.  (See section 7.2.1 of the TLS specification (RFC 2246) for more
   information on waiting for closure alerts.)  In such cases, this
   method need not be called.

   But if the application did not initiate the closure process, or
   if the circumstances above do not apply, this method should be
   called whenever the end of the SSL/TLS data stream is reached.
   This ensures closure of the inbound side, and checks that the
   peer followed the SSL/TLS close procedure properly, thus
   detecting possible truncation attacks.

   This method is idempotent:  if the inbound side has already
   been closed, this method does not do anything.

   wrap() should be
   called to flush any remaining handshake data.

  throws: javax.net.ssl.SSLException - if this engine has not received the proper SSL/TLS close notification message from the peer."
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.closeInbound))))

(defn set-use-client-mode
  "Configures the engine to use client (or server) mode when
   handshaking.

   This method must be called before any handshaking occurs.
   Once handshaking has begun, the mode can not be reset for the
   life of this engine.

   Servers normally authenticate themselves, and clients
   are not required to do so.

  mode - true if the engine should start its handshaking in `client` mode - `boolean`

  throws: java.lang.IllegalArgumentException - if a mode change is attempted after the initial handshake has begun."
  ([^javax.net.ssl.SSLEngine this ^Boolean mode]
    (-> this (.setUseClientMode mode))))

(defn get-use-client-mode?
  "Returns true if the engine is set to use client mode when
   handshaking.

  returns: true if the engine should do handshaking
            in `client` mode - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getUseClientMode))))

(defn set-want-client-auth
  "Configures the engine to request client authentication.
   This option is only useful for engines in the server mode.

   An engine's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setNeedClientAuth(boolean), if this option is set and
   the client chooses not to provide authentication information
   about itself, the negotiations will continue.

   Calling this method overrides any previous setting made by
   this method or setNeedClientAuth(boolean).

  want - set to true if client authentication is requested, or false if no client authentication is desired. - `boolean`"
  ([^javax.net.ssl.SSLEngine this ^Boolean want]
    (-> this (.setWantClientAuth want))))

(defn get-ssl-parameters
  "Returns the SSLParameters in effect for this SSLEngine.
   The ciphersuites and protocols of the returned SSLParameters
   are always non-null.

  returns: the SSLParameters in effect for this SSLEngine. - `javax.net.ssl.SSLParameters`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getSSLParameters))))

(defn get-session
  "Returns the SSLSession in use in this
   SSLEngine.

   These can be long lived, and frequently correspond to an entire
   login session for some user.  The session specifies a particular
   cipher suite which is being actively used by all connections in
   that session, as well as the identities of the session's client
   and server.

   Unlike SSLSocket.getSession()
   this method does not block until handshaking is complete.

   Until the initial handshake has completed, this method returns
   a session object which reports an invalid cipher suite of
   `SSL_NULL_WITH_NULL_NULL`.

  returns: the SSLSession for this SSLEngine - `javax.net.ssl.SSLSession`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getSession))))

(defn unwrap
  "Attempts to decode SSL/TLS network data into a subsequence of
   plaintext application data buffers.  This `scattering`
   operation decodes, in a single invocation, a sequence of bytes
   into one or more of a given sequence of buffers.  Scattering
   unwraps are often useful when implementing network protocols or
   file formats that, for example, group data into segments
   consisting of one or more fixed-length headers followed by a
   variable-length body.  See
   ScatteringByteChannel for more
   information on scattering, and ScatteringByteChannel.read(ByteBuffer[],
   int, int) for more information on the subsequence
   behavior.

   Depending on the state of the SSLEngine, this method may consume
   network data without producing any application data (for example,
   it may consume handshake data.)

   The application is responsible for reliably obtaining the network
   data from the peer, and for invoking unwrap() on the data in the
   order it was received.  The application must properly synchronize
   multiple calls to this method.

   If this SSLEngine has not yet started its initial
   handshake, this method will automatically start the handshake.

   This method will attempt to consume one complete SSL/TLS network
   packet, but will never consume more than the sum of the bytes
   remaining in the buffers.  Each ByteBuffer's
   position is updated to reflect the amount of data consumed or
   produced.  The limits remain the same.

   The underlying memory used by the src and
   dsts ByteBuffers must not be the same.

   The inbound network buffer may be modified as a result of this
   call:  therefore if the network data packet is required for some
   secondary purpose, the data should be duplicated before calling this
   method.  Note:  the network data will not be useful to a second
   SSLEngine, as each SSLEngine contains unique random state which
   influences the SSL/TLS messages.

   See the class description for more information on engine closure.

  src - a ByteBuffer containing inbound network data. - `java.nio.ByteBuffer`
  dsts - an array of ByteBuffers to hold inbound application data. - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be transferred; it must be non-negative and no larger than dsts.length. - `int`
  length - The maximum number of buffers to be accessed; it must be non-negative and no larger than dsts.length - offset. - `int`

  returns: an SSLEngineResult describing the result
            of this operation. - `javax.net.ssl.SSLEngineResult`

  throws: javax.net.ssl.SSLException - A problem was encountered while processing the data that caused the SSLEngine to abort. See the class description for more information on engine closure."
  ([^javax.net.ssl.SSLEngine this ^java.nio.ByteBuffer src ^java.nio.ByteBuffer[] dsts ^Integer offset ^Integer length]
    (-> this (.unwrap src dsts offset length)))
  ([^javax.net.ssl.SSLEngine this ^java.nio.ByteBuffer src ^java.nio.ByteBuffer dst]
    (-> this (.unwrap src dst))))

(defn wrap
  "Attempts to encode plaintext bytes from a subsequence of data
   buffers into SSL/TLS network data.  This `gathering`
   operation encodes, in a single invocation, a sequence of bytes
   from one or more of a given sequence of buffers.  Gathering
   wraps are often useful when implementing network protocols or
   file formats that, for example, group data into segments
   consisting of one or more fixed-length headers followed by a
   variable-length body.  See
   GatheringByteChannel for more
   information on gathering, and GatheringByteChannel.write(ByteBuffer[],
   int, int) for more information on the subsequence
   behavior.

   Depending on the state of the SSLEngine, this method may produce
   network data without consuming any application data (for example,
   it may generate handshake data.)

   The application is responsible for reliably transporting the
   network data to the peer, and for ensuring that data created by
   multiple calls to wrap() is transported in the same order in which
   it was generated.  The application must properly synchronize
   multiple calls to this method.

   If this SSLEngine has not yet started its initial
   handshake, this method will automatically start the handshake.

   This method will attempt to produce SSL/TLS records, and will
   consume as much source data as possible, but will never consume
   more than the sum of the bytes remaining in each buffer.  Each
   ByteBuffer's position is updated to reflect the
   amount of data consumed or produced.  The limits remain the
   same.

   The underlying memory used by the srcs and
   dst ByteBuffers must not be the same.

   See the class description for more information on engine closure.

  srcs - an array of ByteBuffers containing the outbound application data - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be retrieved; it must be non-negative and no larger than srcs.length - `int`
  length - The maximum number of buffers to be accessed; it must be non-negative and no larger than srcs.length - offset - `int`
  dst - a ByteBuffer to hold outbound network data - `java.nio.ByteBuffer`

  returns: an SSLEngineResult describing the result
            of this operation. - `javax.net.ssl.SSLEngineResult`

  throws: javax.net.ssl.SSLException - A problem was encountered while processing the data that caused the SSLEngine to abort. See the class description for more information on engine closure."
  ([^javax.net.ssl.SSLEngine this ^java.nio.ByteBuffer[] srcs ^Integer offset ^Integer length ^java.nio.ByteBuffer dst]
    (-> this (.wrap srcs offset length dst)))
  ([^javax.net.ssl.SSLEngine this ^java.nio.ByteBuffer src ^java.nio.ByteBuffer dst]
    (-> this (.wrap src dst))))

(defn get-enabled-cipher-suites
  "Returns the names of the SSL cipher suites which are currently
   enabled for use on this engine.  When an SSLEngine is first
   created, all enabled cipher suites support a minimum quality of
   service.  Thus, in some environments this value might be empty.

   Even if a suite has been enabled, it might never be used.  (For
   example, the peer does not support it, the requisite
   certificates/private keys for the suite are not available, or an
   anonymous suite is enabled but authentication is required.)

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getEnabledCipherSuites))))

(defn get-supported-cipher-suites
  "Returns the names of the cipher suites which could be enabled for use
   on this engine.  Normally, only a subset of these will actually
   be enabled by default, since this list may include cipher suites which
   do not meet quality of service requirements for those defaults.  Such
   cipher suites might be useful in specialized applications.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getSupportedCipherSuites))))

(defn begin-handshake
  "Initiates handshaking (initial or renegotiation) on this SSLEngine.

   This method is not needed for the initial handshake, as the
   wrap() and unwrap() methods will
   implicitly call this method if handshaking has not already begun.

   Note that the peer may also request a session renegotiation with
   this SSLEngine by sending the appropriate
   session renegotiate handshake message.

   Unlike the SSLSocket#startHandshake() method, this method does not block
   until handshaking is completed.

   To force a complete SSL/TLS session renegotiation, the current
   session should be invalidated prior to calling this method.

   Some protocols may not support multiple handshakes on an existing
   engine and may throw an SSLException.

  throws: javax.net.ssl.SSLException - if a problem was encountered while signaling the SSLEngine to begin a new handshake. See the class description for more information on engine closure."
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.beginHandshake))))

(defn get-peer-host
  "Returns the host name of the peer.

   Note that the value is not authenticated, and should not be
   relied upon.

  returns: the host name of the peer, or null if nothing is
            available. - `java.lang.String`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getPeerHost))))

(defn set-ssl-parameters
  "Applies SSLParameters to this engine.

   This means:

   If params.getCipherSuites() is non-null,
     setEnabledCipherSuites() is called with that value.
   If params.getProtocols() is non-null,
     setEnabledProtocols() is called with that value.
   If params.getNeedClientAuth() or
     params.getWantClientAuth() return true,
     setNeedClientAuth(true) and
     setWantClientAuth(true) are called, respectively;
     otherwise setWantClientAuth(false) is called.
   If params.getServerNames() is non-null, the engine will
     configure its server names with that value.
   If params.getSNIMatchers() is non-null, the engine will
     configure its SNI matchers with that value.

  params - the parameters - `javax.net.ssl.SSLParameters`

  throws: java.lang.IllegalArgumentException - if the setEnabledCipherSuites() or the setEnabledProtocols() call fails"
  ([^javax.net.ssl.SSLEngine this ^javax.net.ssl.SSLParameters params]
    (-> this (.setSSLParameters params))))

(defn close-outbound
  "Signals that no more outbound application data will be sent
   on this SSLEngine.

   This method is idempotent:  if the outbound side has already
   been closed, this method does not do anything.

   wrap(ByteBuffer, ByteBuffer) should be
   called to flush any remaining handshake data."
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.closeOutbound))))

(defn set-enabled-cipher-suites
  "Sets the cipher suites enabled for use on this engine.

   Each cipher suite in the suites parameter must have
   been listed by getSupportedCipherSuites(), or the method will
   fail.  Following a successful call to this method, only suites
   listed in the suites parameter are enabled for use.

   See getEnabledCipherSuites() for more information
   on why a specific cipher suite may never be used on a engine.

  suites - Names of all the cipher suites to enable - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of the ciphers named by the parameter is not supported, or when the parameter is null."
  ([^javax.net.ssl.SSLEngine this ^java.lang.String[] suites]
    (-> this (.setEnabledCipherSuites suites))))

(defn get-enable-session-creation?
  "Returns true if new SSL sessions may be established by this engine.

  returns: true indicates that sessions may be created; this
            is the default.  false indicates that an existing session
            must be resumed - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getEnableSessionCreation))))

(defn get-delegated-task
  "Returns a delegated Runnable task for
   this SSLEngine.

   SSLEngine operations may require the results of
   operations that block, or may take an extended period of time to
   complete.  This method is used to obtain an outstanding Runnable operation (task).  Each task must be assigned
   a thread (possibly the current) to perform the run operation.  Once the
   run method returns, the Runnable object
   is no longer needed and may be discarded.

   Delegated tasks run in the AccessControlContext
   in place when this object was created.

   A call to this method will return each outstanding task
   exactly once.

   Multiple delegated tasks can be run in parallel.

  returns: a delegated Runnable task, or null
            if none are available. - `java.lang.Runnable`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getDelegatedTask))))

(defn set-enable-session-creation
  "Controls whether new SSL sessions may be established by this engine.
   If session creations are not allowed, and there are no
   existing sessions to resume, there will be no successful
   handshaking.

  flag - true indicates that sessions may be created; this is the default. false indicates that an existing session must be resumed - `boolean`"
  ([^javax.net.ssl.SSLEngine this ^Boolean flag]
    (-> this (.setEnableSessionCreation flag))))

(defn get-peer-port
  "Returns the port number of the peer.

   Note that the value is not authenticated, and should not be
   relied upon.

  returns: the port number of the peer, or -1 if nothing is
            available. - `int`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getPeerPort))))

(defn set-enabled-protocols
  "Set the protocol versions enabled for use on this engine.

   The protocols must have been listed by getSupportedProtocols()
   as being supported.  Following a successful call to this method,
   only protocols listed in the protocols parameter
   are enabled for use.

  protocols - Names of all the protocols to enable. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of the protocols named by the parameter is not supported or when the protocols parameter is null."
  ([^javax.net.ssl.SSLEngine this ^java.lang.String[] protocols]
    (-> this (.setEnabledProtocols protocols))))

(defn set-need-client-auth
  "Configures the engine to require client authentication.  This
   option is only useful for engines in the server mode.

   An engine's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setWantClientAuth(boolean), if this option is set and
   the client chooses not to provide authentication information
   about itself, the negotiations will stop and the engine will
   begin its closure procedure.

   Calling this method overrides any previous setting made by
   this method or setWantClientAuth(boolean).

  need - set to true if client authentication is required, or false if no client authentication is desired. - `boolean`"
  ([^javax.net.ssl.SSLEngine this ^Boolean need]
    (-> this (.setNeedClientAuth need))))

(defn get-enabled-protocols
  "Returns the names of the protocol versions which are currently
   enabled for use with this SSLEngine.

  returns: an array of protocols - `java.lang.String[]`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getEnabledProtocols))))

(defn outbound-done?
  "Returns whether wrap(ByteBuffer, ByteBuffer) will
   produce any more outbound data messages.

   Note that during the closure phase, a SSLEngine may
   generate handshake closure data that must be sent to the peer.
   wrap() must be called to generate this data.  When
   this method returns true, no more outbound data will be created.

  returns: true if the SSLEngine will not produce
            any more network data - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.isOutboundDone))))

(defn get-want-client-auth?
  "Returns true if the engine will request client authentication.
   This option is only useful for engines in the server mode.

  returns: true if client authentication is requested,
            or false if no client authentication is desired. - `boolean`"
  ([^javax.net.ssl.SSLEngine this]
    (-> this (.getWantClientAuth))))

