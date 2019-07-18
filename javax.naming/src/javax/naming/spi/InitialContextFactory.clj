(ns javax.naming.spi.InitialContextFactory
  "This interface represents a factory that creates an initial context.

  The JNDI framework allows for different initial context implementations
  to be specified at runtime.  The initial context is created using
  an initial context factory.
  An initial context factory must implement the InitialContextFactory
  interface, which provides a method for creating instances of initial
  context that implement the Context interface.
  In addition, the factory class must be public and must have a public
  constructor that accepts no arguments."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi InitialContextFactory]))

(defn get-initial-context
  "Creates an Initial Context for beginning name resolution.
   Special requirements of this context are supplied
   using environment.

   The environment parameter is owned by the caller.
   The implementation will not modify the object or keep a reference
   to it, although it may keep a reference to a clone or copy.

  environment - The possibly null environment specifying information to be used in the creation of the initial context. - `java.util.Hashtable`

  returns: A non-null initial context object that implements the Context
               interface. - `javax.naming.Context`

  throws: javax.naming.NamingException - If cannot create an initial context."
  (^javax.naming.Context [^InitialContextFactory this ^java.util.Hashtable environment]
    (-> this (.getInitialContext environment))))

