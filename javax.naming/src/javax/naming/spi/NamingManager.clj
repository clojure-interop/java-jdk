(ns javax.naming.spi.NamingManager
  "This class contains methods for creating context objects
  and objects referred to by location information in the naming
  or directory service.

  This class cannot be instantiated.  It has only static methods.

  The mention of URL in the documentation for this class refers to
  a URL string as defined by RFC 1738 and its related RFCs. It is
  any string that conforms to the syntax described therein, and
  may not always have corresponding support in the java.net.URL
  class or Web browsers.

  NamingManager is safe for concurrent access by multiple threads.

  Except as otherwise noted,
  a Name or environment parameter
  passed to any method is owned by the caller.
  The implementation will not modify the object or keep a reference
  to it, although it may keep a reference to a clone or copy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi NamingManager]))

(def *-cpe
  "Static Constant.

  Constant that holds the name of the environment property into
   which getContinuationContext() stores the value of its
   CannotProceedException parameter.
   This property is inherited by the continuation context, and may
   be used by that context's service provider to inspect the
   fields of the exception.

   The value of this constant is `java.naming.spi.CannotProceedException`.

  type: java.lang.String"
  NamingManager/CPE)

(defn *set-object-factory-builder
  "The ObjectFactoryBuilder determines the policy used when
   trying to load object factories.
   See getObjectInstance() and class ObjectFactory for a description
   of the default policy.
   setObjectFactoryBuilder() overrides this default policy by installing
   an ObjectFactoryBuilder. Subsequent object factories will
   be loaded and created using the installed builder.

   The builder can only be installed if the executing thread is allowed
   (by the security manager's checkSetFactory() method) to do so.
   Once installed, the builder cannot be replaced.

  builder - The factory builder to install. If null, no builder is installed. - `javax.naming.spi.ObjectFactoryBuilder`

  throws: java.lang.SecurityException - builder cannot be installed for security reasons."
  ([^javax.naming.spi.ObjectFactoryBuilder builder]
    (NamingManager/setObjectFactoryBuilder builder)))

(defn *get-object-instance
  "Creates an instance of an object for the specified object
   and environment.

   If an object factory builder has been installed, it is used to
   create a factory for creating the object.
   Otherwise, the following rules are used to create the object:

   If refInfo is a Reference
      or Referenceable containing a factory class name,
      use the named factory to create the object.
      Return refInfo if the factory cannot be created.
      Under JDK 1.1, if the factory class must be loaded from a location
      specified in the reference, a SecurityManager must have
      been installed or the factory creation will fail.
      If an exception is encountered while creating the factory,
      it is passed up to the caller.
   If refInfo is a Reference or
      Referenceable with no factory class name,
      and the address or addresses are StringRefAddrs with
      address type `URL`,
      try the URL context factory corresponding to each URL's scheme id
      to create the object (see getURLContext()).
      If that fails, continue to the next step.
    Use the object factories specified in
      the Context.OBJECT_FACTORIES property of the environment,
      and of the provider resource file associated with
      nameCtx, in that order.
      The value of this property is a colon-separated list of factory
      class names that are tried in order, and the first one that succeeds
      in creating an object is the one used.
      If none of the factories can be loaded,
      return refInfo.
      If an exception is encountered while creating the object, the
      exception is passed up to the caller.


   Service providers that implement the DirContext
   interface should use
   DirectoryManager.getObjectInstance(), not this method.
   Service providers that implement only the Context
   interface should use this method.

   Note that an object factory (an object that implements the ObjectFactory
   interface) must be public and must have a public constructor that
   accepts no arguments.

   The name and nameCtx parameters may
   optionally be used to specify the name of the object being created.
   name is the name of the object, relative to context
   nameCtx.  This information could be useful to the object
   factory or to the object implementation.
    If there are several possible contexts from which the object
    could be named -- as will often be the case -- it is up to
    the caller to select one.  A good rule of thumb is to select the
   `deepest` context available.
   If nameCtx is null, name is relative
   to the default initial context.  If no name is being specified, the
   name parameter should be null.

  ref-info - The possibly null object for which to create an object. - `java.lang.Object`
  name - The name of this object relative to nameCtx. Specifying a name is optional; if it is omitted, name should be null. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified. If null, name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the object factory and the object. - `java.util.Hashtable<?,?>`

  returns: An object created using refInfo; or
            refInfo if an object cannot be created using
            the algorithm described above. - `java.lang.Object`

  throws: javax.naming.NamingException - if a naming exception was encountered while attempting to get a URL context, or if one of the factories accessed throws a NamingException."
  (^java.lang.Object [^java.lang.Object ref-info ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment]
    (NamingManager/getObjectInstance ref-info name name-ctx environment)))

(defn *get-url-context
  "Creates a context for the given URL scheme id.

   The resulting context is for resolving URLs of the
   scheme scheme. The resulting context is not tied
   to a specific URL. It is able to handle arbitrary URLs with
   the specified scheme.

   The class name of the factory that creates the resulting context
   has the naming convention scheme-idURLContextFactory
   (e.g. `ftpURLContextFactory` for the `ftp` scheme-id),
   in the package specified as follows.
   The Context.URL_PKG_PREFIXES environment property (which
   may contain values taken from applet parameters, system properties,
   or application resource files)
   contains a colon-separated list of package prefixes.
   Each package prefix in
   the property is tried in the order specified to load the factory class.
   The default package prefix is `com.sun.jndi.url` (if none of the
   specified packages work, this default is tried).
   The complete package name is constructed using the package prefix,
   concatenated with the scheme id.

   For example, if the scheme id is `ldap`, and the
   Context.URL_PKG_PREFIXES property
   contains `com.widget:com.wiz.jndi`,
   the naming manager would attempt to load the following classes
   until one is successfully instantiated:

   com.widget.ldap.ldapURLContextFactory
    com.wiz.jndi.ldap.ldapURLContextFactory
    com.sun.jndi.url.ldap.ldapURLContextFactory

   If none of the package prefixes work, null is returned.

   If a factory is instantiated, it is invoked with the following
   parameters to produce the resulting context.

   factory.getObjectInstance(null, environment);

   For example, invoking getObjectInstance() as shown above
   on a LDAP URL context factory would return a
   context that can resolve LDAP urls
   (e.g. `ldap://ldap.wiz.com/o=wiz,c=us`,
   `ldap://ldap.umich.edu/o=umich,c=us`, ...).

   Note that an object factory (an object that implements the ObjectFactory
   interface) must be public and must have a public constructor that
   accepts no arguments.

  scheme - The non-null scheme-id of the URLs supported by the context. - `java.lang.String`
  environment - The possibly null environment properties to be used in the creation of the object factory and the context. - `java.util.Hashtable<?,?>`

  returns: A context for resolving URLs with the
           scheme id scheme;
    null if the factory for creating the
           context is not found. - `javax.naming.Context`

  throws: javax.naming.NamingException - If a naming exception occurs while creating the context."
  (^javax.naming.Context [^java.lang.String scheme ^java.util.Hashtable environment]
    (NamingManager/getURLContext scheme environment)))

(defn *get-initial-context
  "Creates an initial context using the specified environment
   properties.

   If an InitialContextFactoryBuilder has been installed,
   it is used to create the factory for creating the initial context.
   Otherwise, the class specified in the
   Context.INITIAL_CONTEXT_FACTORY environment property is used.
   Note that an initial context factory (an object that implements the
   InitialContextFactory interface) must be public and must have a
   public constructor that accepts no arguments.

  env - The possibly null environment properties used when creating the context. - `java.util.Hashtable<?,?>`

  returns: A non-null initial context. - `javax.naming.Context`

  throws: javax.naming.NoInitialContextException - If the Context.INITIAL_CONTEXT_FACTORY property is not found or names a nonexistent class or a class that cannot be instantiated, or if the initial context could not be created for some other reason."
  (^javax.naming.Context [^java.util.Hashtable env]
    (NamingManager/getInitialContext env)))

(defn *set-initial-context-factory-builder
  "Sets the InitialContextFactory builder to be builder.


   The builder can only be installed if the executing thread is allowed by
   the security manager to do so. Once installed, the builder cannot
   be replaced.

  builder - The initial context factory builder to install. If null, no builder is set. - `javax.naming.spi.InitialContextFactoryBuilder`

  throws: java.lang.SecurityException - builder cannot be installed for security reasons."
  ([^javax.naming.spi.InitialContextFactoryBuilder builder]
    (NamingManager/setInitialContextFactoryBuilder builder)))

(defn *has-initial-context-factory-builder?
  "Determines whether an initial context factory builder has
   been set.

  returns: true if an initial context factory builder has
             been set; false otherwise. - `boolean`"
  (^Boolean []
    (NamingManager/hasInitialContextFactoryBuilder )))

(defn *get-continuation-context
  "Creates a context in which to continue a context operation.

   In performing an operation on a name that spans multiple
   namespaces, a context from one naming system may need to pass
   the operation on to the next naming system.  The context
   implementation does this by first constructing a
   CannotProceedException containing information
   pinpointing how far it has proceeded.  It then obtains a
   continuation context from JNDI by calling
   getContinuationContext.  The context
   implementation should then resume the context operation by
   invoking the same operation on the continuation context, using
   the remainder of the name that has not yet been resolved.

   Before making use of the cpe parameter, this method
   updates the environment associated with that object by setting
   the value of the property CPE
   to cpe.  This property will be inherited by the
   continuation context, and may be used by that context's
   service provider to inspect the fields of this exception.

  cpe - The non-null exception that triggered this continuation. - `javax.naming.CannotProceedException`

  returns: A non-null Context object for continuing the operation. - `javax.naming.Context`

  throws: javax.naming.NamingException - If a naming exception occurred."
  (^javax.naming.Context [^javax.naming.CannotProceedException cpe]
    (NamingManager/getContinuationContext cpe)))

(defn *get-state-to-bind
  "Retrieves the state of an object for binding.

   Service providers that implement the DirContext interface
   should use DirectoryManager.getStateToBind(), not this method.
   Service providers that implement only the Context interface
   should use this method.

   This method uses the specified state factories in
   the Context.STATE_FACTORIES property from the environment
   properties, and from the provider resource file associated with
   nameCtx, in that order.
      The value of this property is a colon-separated list of factory
      class names that are tried in order, and the first one that succeeds
      in returning the object's state is the one used.
   If no object's state can be retrieved in this way, return the
   object itself.
      If an exception is encountered while retrieving the state, the
      exception is passed up to the caller.

   Note that a state factory
   (an object that implements the StateFactory
   interface) must be public and must have a public constructor that
   accepts no arguments.

   The name and nameCtx parameters may
   optionally be used to specify the name of the object being created.
   See the description of `Name and Context Parameters` in
   ObjectFactory.getObjectInstance()
   for details.

   This method may return a Referenceable object.  The
   service provider obtaining this object may choose to store it
   directly, or to extract its reference (using
   Referenceable.getReference()) and store that instead.

  obj - The non-null object for which to get state to bind. - `java.lang.Object`
  name - The name of this object relative to nameCtx, or null if no name is specified. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified, or null if name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the state factory and the object's state. - `java.util.Hashtable<?,?>`

  returns: The non-null object representing obj's state for
    binding.  It could be the object (obj) itself. - `java.lang.Object`

  throws: javax.naming.NamingException - If one of the factories accessed throws an exception, or if an error was encountered while loading and instantiating the factory and object classes. A factory should only throw an exception if it does not want other factories to be used in an attempt to create an object. See StateFactory.getStateToBind()."
  (^java.lang.Object [^java.lang.Object obj ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment]
    (NamingManager/getStateToBind obj name name-ctx environment)))

