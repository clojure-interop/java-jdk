(ns javax.naming.spi.ObjectFactoryBuilder
  "This interface represents a builder that creates object factories.

  The JNDI framework allows for object implementations to
  be loaded in dynamically via object factories.
  For example, when looking up a printer bound in the name space,
  if the print service binds printer names to References, the printer
  Reference could be used to create a printer object, so that
  the caller of lookup can directly operate on the printer object
  after the lookup.  An ObjectFactory is responsible for creating
  objects of a specific type.  JNDI uses a default policy for using
  and loading object factories.  You can override this default policy
  by calling NamingManager.setObjectFactoryBuilder() with an ObjectFactoryBuilder,
  which contains the program-defined way of creating/loading
  object factories.
  Any ObjectFactoryBuilder implementation must implement this
  interface that for creating object factories."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi ObjectFactoryBuilder]))

(defn create-object-factory
  "Creates a new object factory using the environment supplied.

   The environment parameter is owned by the caller.
   The implementation will not modify the object or keep a reference
   to it, although it may keep a reference to a clone or copy.

  obj - The possibly null object for which to create a factory. - `java.lang.Object`
  environment - Environment to use when creating the factory. Can be null. - `java.util.Hashtable<?,?>`

  returns: A non-null new instance of an ObjectFactory. - `javax.naming.spi.ObjectFactory`

  throws: javax.naming.NamingException - If an object factory cannot be created."
  (^javax.naming.spi.ObjectFactory [^javax.naming.spi.ObjectFactoryBuilder this ^java.lang.Object obj ^java.util.Hashtable environment]
    (-> this (.createObjectFactory obj environment))))

