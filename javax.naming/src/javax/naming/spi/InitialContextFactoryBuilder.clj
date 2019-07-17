(ns javax.naming.spi.InitialContextFactoryBuilder
  "This interface represents a builder that creates initial context factories.

  The JNDI framework allows for different initial context implementations
  to be specified at runtime.  An initial context is created using
  an initial context factory. A program can install its own builder
  that creates initial context factories, thereby overriding the
  default policies used by the framework, by calling
  NamingManager.setInitialContextFactoryBuilder().
  The InitialContextFactoryBuilder interface must be implemented by
  such a builder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi InitialContextFactoryBuilder]))

(defn create-initial-context-factory
  "Creates an initial context factory using the specified
   environment.

   The environment parameter is owned by the caller.
   The implementation will not modify the object or keep a reference
   to it, although it may keep a reference to a clone or copy.

  environment - Environment used in creating an initial context implementation. Can be null. - `java.util.Hashtable<?,?>`

  returns: A non-null initial context factory. - `javax.naming.spi.InitialContextFactory`

  throws: javax.naming.NamingException - If an initial context factory could not be created."
  ([^javax.naming.spi.InitialContextFactoryBuilder this ^java.util.Hashtable environment]
    (-> this (.createInitialContextFactory environment))))

