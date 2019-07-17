(ns javax.imageio.spi.ServiceRegistry
  "A registry for service provider instances.

   A service is a well-known set of interfaces and (usually
  abstract) classes.  A service provider is a specific
  implementation of a service.  The classes in a provider typically
  implement the interface or subclass the class defined by the
  service itself.

   Service providers are stored in one or more categories,
  each of which is defined by a class of interface (described by a
  Class object) that all of its members must implement.
  The set of categories may be changed dynamically.

   Only a single instance of a given leaf class (that is, the
  actual class returned by getClass(), as opposed to any
  inherited classes or interfaces) may be registered.  That is,
  suppose that the
  com.mycompany.mypkg.GreenServiceProvider class
  implements the com.mycompany.mypkg.MyService
  interface.  If a GreenServiceProvider instance is
  registered, it will be stored in the category defined by the
  MyService class.  If a new instance of
  GreenServiceProvider is registered, it will replace
  the previous instance.  In practice, service provider objects are
  usually singletons so this behavior is appropriate.

   To declare a service provider, a services
  subdirectory is placed within the META-INF directory
  that is present in every JAR file.  This directory contains a file
  for each service provider interface that has one or more
  implementation classes present in the JAR file.  For example, if
  the JAR file contained a class named
  com.mycompany.mypkg.MyServiceImpl which implements the
  javax.someapi.SomeService interface, the JAR file
  would contain a file named:

  META-INF/services/javax.someapi.SomeService

  containing the line:



  com.mycompany.mypkg.MyService

   The service provider classes should be to be lightweight and
  quick to load.  Implementations of these interfaces should avoid
  complex dependencies on other classes and on native code. The usual
  pattern for more complex services is to register a lightweight
  proxy for the heavyweight service.

   An application may customize the contents of a registry as it
  sees fit, so long as it has the appropriate runtime permission.

   For more details on declaring service providers, and the JAR
  format in general, see the
  JAR File Specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ServiceRegistry]))

(defn ->service-registry
  "Constructor.

  Constructs a ServiceRegistry instance with a
   set of categories taken from the categories
   argument.

  categories - an Iterator containing Class objects to be used to define categories. - `java.util.Iterator<java.lang.Class<?>>`

  throws: java.lang.IllegalArgumentException - if categories is null."
  ([^java.util.Iterator> categories]
    (new ServiceRegistry categories)))

(defn *lookup-providers
  "Searches for implementations of a particular service class
   using the given class loader.

    This method transforms the name of the given service class
   into a provider-configuration filename as described in the
   class comment and then uses the getResources
   method of the given class loader to find all available files
   with that name.  These files are then read and parsed to
   produce a list of provider-class names.  The iterator that is
   returned uses the given class loader to look up and then
   instantiate each element of the list.

    Because it is possible for extensions to be installed into
   a running Java virtual machine, this method may return
   different results each time it is invoked.

  provider-class - a Classobject indicating the class or interface of the service providers being detected. - `java.lang.Class<T>`
  loader - the class loader to be used to load provider-configuration files and instantiate provider classes, or null if the system class loader (or, failing that the bootstrap class loader) is to be used. - `java.lang.ClassLoader`

  returns: An Iterator that yields provider objects
   for the given service, in some arbitrary order.  The iterator
   will throw an Error if a provider-configuration
   file violates the specified format or if a provider class
   cannot be found and instantiated. - `<T> java.util.Iterator<T>`

  throws: java.lang.IllegalArgumentException - if providerClass is null."
  ([^java.lang.Class provider-class ^java.lang.ClassLoader loader]
    (ServiceRegistry/lookupProviders provider-class loader))
  ([^java.lang.Class provider-class]
    (ServiceRegistry/lookupProviders provider-class)))

(defn register-service-providers
  "Adds a set of service provider objects, taken from an
   Iterator to the registry.  Each provider is
   associated within each category present in the registry whose
   Class it implements.

    For each entry of providers that implements
   the RegisterableService interface, its
   onRegistration method will be called once for each
   category it is registered under.  Its
   onDeregistration method will be called each time
   it is deregistered from a category or when the registry is
   finalized.

  providers - an Iterator containing service provider objects to be registered. - `java.util.Iterator<?>`

  throws: java.lang.IllegalArgumentException - if providers is null or contains a null entry."
  ([^javax.imageio.spi.ServiceRegistry this ^java.util.Iterator providers]
    (-> this (.registerServiceProviders providers))))

(defn contains
  "Returns true if provider is currently
   registered.

  provider - the service provider object to be queried. - `java.lang.Object`

  returns: true if the given provider has been
   registered. - `boolean`

  throws: java.lang.IllegalArgumentException - if provider is null."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Object provider]
    (-> this (.contains provider))))

(defn deregister-all
  "Deregisters all service provider object currently registered
   under the given category.

  category - the category to be emptied. - `java.lang.Class<?>`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class category]
    (-> this (.deregisterAll category)))
  ([^javax.imageio.spi.ServiceRegistry this]
    (-> this (.deregisterAll))))

(defn get-service-providers
  "Returns an Iterator containing service provider
   objects within a given category that satisfy a criterion
   imposed by the supplied ServiceRegistry.Filter
   object's filter method.

    The useOrdering argument controls the
   ordering of the results using the same rules as
   getServiceProviders(Class, boolean).

  category - the category to be retrieved from. - `java.lang.Class<T>`
  filter - an instance of ServiceRegistry.Filter whose filter method will be invoked. - `javax.imageio.spi.ServiceRegistry.Filter`
  use-ordering - true if pairwise orderings should be taken account in ordering the returned objects. - `boolean`

  returns: an Iterator containing service provider
   objects from the given category, possibly in order. - `<T> java.util.Iterator<T>`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class category ^javax.imageio.spi.ServiceRegistry.Filter filter ^Boolean use-ordering]
    (-> this (.getServiceProviders category filter use-ordering)))
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class category ^Boolean use-ordering]
    (-> this (.getServiceProviders category use-ordering))))

(defn deregister-service-provider
  "Removes a service provider object from the given category.  If
   the provider was not previously registered, nothing happens and
   false is returned.  Otherwise, true
   is returned.  If an object of the same class as
   provider but not equal (using ==) to
   provider is registered, it will not be
   deregistered.

    If provider implements the
   RegisterableService interface, its
   onDeregistration method will be called.

  provider - the service provider object to be deregistered. - `T`
  category - the category from which to deregister the provider. - `java.lang.Class<T>`

  returns: true if the provider was previously
   registered in the same category category,
   false otherwise. - `<T> boolean`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this provider ^java.lang.Class category]
    (-> this (.deregisterServiceProvider provider category)))
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Object provider]
    (-> this (.deregisterServiceProvider provider))))

(defn get-service-provider-by-class
  "Returns the currently registered service provider object that
   is of the given class type.  At most one object of a given
   class is allowed to be registered at any given time.  If no
   registered object has the desired class type, null
   is returned.

  provider-class - the Class of the desired service provider object. - `java.lang.Class<T>`

  returns: a currently registered service provider object with the
   desired Classtype, or null is none is
   present. - `<T> T`

  throws: java.lang.IllegalArgumentException - if providerClass is null."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class provider-class]
    (-> this (.getServiceProviderByClass provider-class))))

(defn set-ordering
  "Sets a pairwise ordering between two service provider objects
   within a given category.  If one or both objects are not
   currently registered within the given category, or if the
   desired ordering is already set, nothing happens and
   false is returned.  If the providers previously
   were ordered in the reverse direction, that ordering is
   removed.

    The ordering will be used by the
   getServiceProviders methods when their
   useOrdering argument is true.

  category - a Class object indicating the category under which the preference is to be established. - `java.lang.Class<T>`
  first-provider - the preferred provider. - `T`
  second-provider - the provider to which firstProvider is preferred. - `T`

  returns: true if a previously unset ordering
   was established. - `<T> boolean`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class category first-provider second-provider]
    (-> this (.setOrdering category first-provider second-provider))))

(defn get-categories
  "Returns an Iterator of Class objects
   indicating the current set of categories.  The iterator will be
   empty if no categories exist.

  returns: an Iterator containing
   Classobjects. - `java.util.Iterator<java.lang.Class<?>>`"
  ([^javax.imageio.spi.ServiceRegistry this]
    (-> this (.getCategories))))

(defn register-service-provider
  "Adds a service provider object to the registry.  The provider
   is associated with the given category.

    If provider implements the
   RegisterableService interface, its
   onRegistration method will be called.  Its
   onDeregistration method will be called each time
   it is deregistered from a category, for example if a
   category is removed or the registry is garbage collected.

  provider - the service provide object to be registered. - `T`
  category - the category under which to register the provider. - `java.lang.Class<T>`

  returns: true if no provider of the same class was previously
   registered in the same category category. - `<T> boolean`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this provider ^java.lang.Class category]
    (-> this (.registerServiceProvider provider category)))
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Object provider]
    (-> this (.registerServiceProvider provider))))

(defn unset-ordering
  "Sets a pairwise ordering between two service provider objects
   within a given category.  If one or both objects are not
   currently registered within the given category, or if no
   ordering is currently set between them, nothing happens
   and false is returned.

    The ordering will be used by the
   getServiceProviders methods when their
   useOrdering argument is true.

  category - a Class object indicating the category under which the preference is to be disestablished. - `java.lang.Class<T>`
  first-provider - the formerly preferred provider. - `T`
  second-provider - the provider to which firstProvider was formerly preferred. - `T`

  returns: true if a previously set ordering was
   disestablished. - `<T> boolean`

  throws: java.lang.IllegalArgumentException - if there is no category corresponding to category."
  ([^javax.imageio.spi.ServiceRegistry this ^java.lang.Class category first-provider second-provider]
    (-> this (.unsetOrdering category first-provider second-provider))))

(defn finalize
  "Finalizes this object prior to garbage collection.  The
   deregisterAll method is called to deregister all
   currently registered service providers.  This method should not
   be called from application code.

  throws: java.lang.Throwable - if an error occurs during superclass finalization."
  ([^javax.imageio.spi.ServiceRegistry this]
    (-> this (.finalize))))

