(ns javax.sql.rowset.spi.SyncFactory
  "The Service Provider Interface (SPI) mechanism that generates SyncProvider
  instances to be used by disconnected RowSet objects.
  The SyncProvider instances in turn provide the
  javax.sql.RowSetReader object the RowSet object
  needs to populate itself with data and the
  javax.sql.RowSetWriter object it needs to
  propagate changes to its
  data back to the underlying data source.

  Because the methods in the SyncFactory class are all static,
  there is only one SyncFactory object
  per Java VM at any one time. This ensures that there is a single source from which a
  RowSet implementation can obtain its SyncProvider
  implementation.

  1.0 Overview
  The SyncFactory class provides an internal registry of available
  synchronization provider implementations (SyncProvider objects).
  This registry may be queried to determine which
  synchronization providers are available.
  The following line of code gets an enumeration of the providers currently registered.


      java.util.Enumeration e = SyncFactory.getRegisteredProviders();
  All standard RowSet implementations must provide at least two providers:

   an optimistic provider for use with a CachedRowSet implementation
      or an implementation derived from it
   an XML provider, which is used for reading and writing XML, such as with
        WebRowSet objects

  Note that the JDBC RowSet Implementations include the SyncProvider
  implementations RIOptimisticProvider and RIXmlProvider,
  which satisfy this requirement.

  The SyncFactory class provides accessor methods to assist
  applications in determining which synchronization providers are currently
  registered with the SyncFactory.

  Other methods let RowSet persistence providers be
  registered or de-registered with the factory mechanism. This
  allows additional synchronization provider implementations to be made
  available to RowSet objects at run time.

  Applications can apply a degree of filtering to determine the level of
  synchronization that a SyncProvider implementation offers.
  The following criteria determine whether a provider is
  made available to a RowSet object:

  If a particular provider is specified by a RowSet object, and
  the SyncFactory does not contain a reference to this provider,
  a SyncFactoryException is thrown stating that the synchronization
  provider could not be found.

  If a RowSet implementation is instantiated with a specified
  provider and the specified provider has been properly registered, the
  requested provider is supplied. Otherwise a SyncFactoryException
  is thrown.

  If a RowSet object does not specify a
  SyncProvider implementation and no additional
  SyncProvider implementations are available, the reference
  implementation providers are supplied.

  2.0 Registering SyncProvider Implementations

  Both vendors and developers can register SyncProvider
  implementations using one of the following mechanisms.

  Using the command line
  The name of the provider is supplied on the command line, which will add
  the provider to the system properties.
  For example:


     -Drowset.provider.classname=com.fred.providers.HighAvailabilityProvider
  Using the Standard Properties File
  The reference implementation is targeted
  to ship with J2SE 1.5, which will include an additional resource file
  that may be edited by hand. Here is an example of the properties file
  included in the reference implementation:


    #Default JDBC RowSet sync providers listing
    #

    # Optimistic synchronization provider
    rowset.provider.classname.0=com.sun.rowset.providers.RIOptimisticProvider
    rowset.provider.vendor.0=Oracle Corporation
    rowset.provider.version.0=1.0

    # XML Provider using standard XML schema
    rowset.provider.classname.1=com.sun.rowset.providers.RIXMLProvider
    rowset.provider.vendor.1=Oracle Corporation
    rowset.provider.version.1=1.0
  The SyncFactory checks this file and registers the
  SyncProvider implementations that it contains. A
  developer or vendor can add other implementations to this file.
  For example, here is a possible addition:


      rowset.provider.classname.2=com.fred.providers.HighAvailabilityProvider
      rowset.provider.vendor.2=Fred, Inc.
      rowset.provider.version.2=1.0

  Using a JNDI Context
  Available providers can be registered on a JNDI
  context, and the SyncFactory will attempt to load
  SyncProvider implementations from that JNDI context.
  For example, the following code fragment registers a provider implementation
  on a JNDI context.  This is something a deployer would normally do. In this
  example, MyProvider is being registered on a CosNaming
  namespace, which is the namespace used by J2EE resources.


     import javax.naming.*;

     Hashtable svrEnv = new  Hashtable();
     srvEnv.put(Context.INITIAL_CONTEXT_FACTORY, `CosNaming`);

     Context ctx = new InitialContext(svrEnv);
     com.fred.providers.MyProvider = new MyProvider();
     ctx.rebind(`providers/MyProvider`, syncProvider);

  Next, an application will register the JNDI context with the
  SyncFactory instance.  This allows the SyncFactory
  to browse within the JNDI context looking for SyncProvider
  implementations.


     Hashtable appEnv = new Hashtable();
     appEnv.put(Context.INITIAL_CONTEXT_FACTORY, `CosNaming`);
     appEnv.put(Context.PROVIDER_URL, `iiop://hostname/providers`);
     Context ctx = new InitialContext(appEnv);

     SyncFactory.registerJNDIContext(ctx);
  If a RowSet object attempts to obtain a MyProvider
  object, the SyncFactory will try to locate it. First it searches
  for it in the system properties, then it looks in the resource files, and
  finally it checks the JNDI context that has been set. The SyncFactory
  instance verifies that the requested provider is a valid extension of the
  SyncProvider abstract class and then gives it to the
  RowSet object. In the following code fragment, a new
  CachedRowSet object is created and initialized with
  env, which contains the binding to MyProvider.


     Hashtable env = new Hashtable();
     env.put(SyncFactory.ROWSET_SYNC_PROVIDER, `com.fred.providers.MyProvider`);
     CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl(env);
  Further details on these mechanisms are available in the
  javax.sql.rowset.spi package specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi SyncFactory]))

(def *-rowset-sync-provider
  "Static Constant.

  The standard property-id for a synchronization provider implementation
   name.

  type: java.lang.String"
  SyncFactory/ROWSET_SYNC_PROVIDER)

(def *-rowset-sync-vendor
  "Static Constant.

  The standard property-id for a synchronization provider implementation
   vendor name.

  type: java.lang.String"
  SyncFactory/ROWSET_SYNC_VENDOR)

(def *-rowset-sync-provider-version
  "Static Constant.

  The standard property-id for a synchronization provider implementation
   version tag.

  type: java.lang.String"
  SyncFactory/ROWSET_SYNC_PROVIDER_VERSION)

(defn *register-provider
  "Adds the the given synchronization provider to the factory register. Guidelines
   are provided in the SyncProvider specification for the
   required naming conventions for SyncProvider
   implementations.

   Synchronization providers bound to a JNDI context can be
   registered by binding a SyncProvider instance to a JNDI namespace.



   SyncProvider p = new MySyncProvider();
   InitialContext ic = new InitialContext();
   ic.bind (`jdbc/rowset/MySyncProvider`, p);

   Furthermore, an initial JNDI context should be set with the
   SyncFactory using the setJNDIContext method.
   The SyncFactory leverages this context to search for
   available SyncProvider objects bound to the JNDI
   context and its child nodes.

  provider-id - A String object with the unique ID of the synchronization provider being registered - `java.lang.String`

  throws: javax.sql.rowset.spi.SyncFactoryException - if an attempt is made to supply an empty or null provider name"
  ([^java.lang.String provider-id]
    (SyncFactory/registerProvider provider-id)))

(defn *get-sync-factory
  "Returns the SyncFactory singleton.

  returns: the SyncFactory instance - `javax.sql.rowset.spi.SyncFactory`"
  ([]
    (SyncFactory/getSyncFactory )))

(defn *unregister-provider
  "Removes the designated currently registered synchronization provider from the
   Factory SPI register.

  provider-id - The unique-id of the synchronization provider - `java.lang.String`

  throws: javax.sql.rowset.spi.SyncFactoryException - If an attempt is made to unregister a SyncProvider implementation that was not registered."
  ([^java.lang.String provider-id]
    (SyncFactory/unregisterProvider provider-id)))

(defn *get-instance
  "Returns the SyncProvider instance identified by providerID.

  provider-id - the unique identifier of the provider - `java.lang.String`

  returns: a SyncProvider implementation - `javax.sql.rowset.spi.SyncProvider`

  throws: javax.sql.rowset.spi.SyncFactoryException - If the SyncProvider cannot be found, the providerID is null, or some error was encountered when trying to invoke this provider."
  ([^java.lang.String provider-id]
    (SyncFactory/getInstance provider-id)))

(defn *get-registered-providers
  "Returns an Enumeration of currently registered synchronization
   providers.  A RowSet implementation may use any provider in
   the enumeration as its SyncProvider object.

   At a minimum, the reference synchronization provider allowing
   RowSet content data to be stored using a JDBC driver should be
   possible.

  returns: Enumeration  A enumeration of available synchronization
   providers that are registered with this Factory - `java.util.Enumeration<javax.sql.rowset.spi.SyncProvider>`

  throws: javax.sql.rowset.spi.SyncFactoryException - If an error occurs obtaining the registered providers"
  ([]
    (SyncFactory/getRegisteredProviders )))

(defn *set-logger
  "Sets the logging object that is used by SyncProvider
   implementations provided by the SyncFactory SPI. All
   SyncProvider implementations can log their events
   to this object and the application can retrieve a handle to this
   object using the getLogger method.

   This method checks to see that there is an SQLPermission
   object  which grants the permission setSyncFactory
   before allowing the method to succeed.  If a
   SecurityManager exists and its
   checkPermission method denies calling setLogger,
   this method throws a
   java.lang.SecurityException.

  logger - a Logger object instance - `java.util.logging.Logger`
  level - a Level object instance indicating the degree of logging required - `java.util.logging.Level`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method denies calling setLogger"
  ([^java.util.logging.Logger logger ^java.util.logging.Level level]
    (SyncFactory/setLogger logger level))
  ([^java.util.logging.Logger logger]
    (SyncFactory/setLogger logger)))

(defn *get-logger
  "Returns the logging object for applications to retrieve
   synchronization events posted by SyncProvider implementations.

  returns: The Logger that has been specified for use by
   SyncProvider implementations - `java.util.logging.Logger`

  throws: javax.sql.rowset.spi.SyncFactoryException - if no logging object has been set."
  ([]
    (SyncFactory/getLogger )))

(defn *set-jndi-context
  "Sets the initial JNDI context from which SyncProvider implementations
   can be retrieved from a JNDI namespace

    This method checks to see that there is an SQLPermission
   object  which grants the permission setSyncFactory
   before allowing the method to succeed.  If a
   SecurityManager exists and its
   checkPermission method denies calling setJNDIContext,
   this method throws a
   java.lang.SecurityException.

  ctx - a valid JNDI context - `javax.naming.Context`

  throws: javax.sql.rowset.spi.SyncFactoryException - if the supplied JNDI context is null"
  ([^javax.naming.Context ctx]
    (SyncFactory/setJNDIContext ctx)))

