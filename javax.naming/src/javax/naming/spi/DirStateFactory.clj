(ns javax.naming.spi.DirStateFactory
  "This interface represents a factory for obtaining the state of an
  object and corresponding attributes for binding.

  The JNDI framework allows for object implementations to
  be loaded in dynamically via object factories.

  A DirStateFactory extends StateFactory
  by allowing an Attributes instance
  to be supplied to and be returned by the getStateToBind() method.
  DirStateFactory implementations are intended to be used by
  DirContext service providers.
  When a caller binds an object using DirContext.bind(),
  he might also specify a set of attributes to be bound with the object.
  The object and attributes to be bound are passed to
  the getStateToBind() method of a factory.
  If the factory processes the object and attributes, it returns
  a corresponding pair of object and attributes to be bound.
  If the factory does not process the object, it must return null.

  For example, a caller might bind a printer object with some printer-related
  attributes.


  ctx.rebind(`inky`, printer, printerAttrs);
  An LDAP service provider for ctx uses a DirStateFactory
  (indirectly via DirectoryManager.getStateToBind())
  and gives it printer and printerAttrs. A factory for
  an LDAP directory might turn printer into a set of attributes
  and merge that with printerAttrs. The service provider then
  uses the resulting attributes to create an LDAP entry and updates
  the directory.

   Since DirStateFactory extends StateFactory, it
  has two getStateToBind() methods, where one
  differs from the other by the attributes
  argument. DirectoryManager.getStateToBind() will only use
  the form that accepts the attributes argument, while
  NamingManager.getStateToBind() will only use the form that
  does not accept the attributes argument.

   Either form of the getStateToBind() method of a
  DirStateFactory may be invoked multiple times, possibly using different
  parameters.  The implementation is thread-safe."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi DirStateFactory]))

(defn get-state-to-bind
  "Retrieves the state of an object for binding given the object and attributes
   to be transformed.

   DirectoryManager.getStateToBind()
   successively loads in state factories. If a factory implements
   DirStateFactory, DirectoryManager invokes this method;
   otherwise, it invokes StateFactory.getStateToBind().
   It does this until a factory produces a non-null answer.

   When an exception is thrown by a factory,
   the exception is passed on to the caller
   of DirectoryManager.getStateToBind(). The search for other factories
   that may produce a non-null answer is halted.
   A factory should only throw an exception if it is sure that
   it is the only intended factory and that no other factories
   should be tried.
   If this factory cannot create an object using the arguments supplied,
   it should return null.

   The name and nameCtx parameters may
   optionally be used to specify the name of the object being created.
   See the description of `Name and Context Parameters` in
   ObjectFactory.getObjectInstance()
   for details.
   If a factory uses nameCtx it should synchronize its use
   against concurrent access, since context implementations are not
   guaranteed to be thread-safe.

   The name, inAttrs, and environment parameters
   are owned by the caller.
   The implementation will not modify these objects or keep references
   to them, although it may keep references to clones or copies.
   The object returned by this method is owned by the caller.
   The implementation will not subsequently modify it.
   It will contain either a new Attributes object that is
   likewise owned by the caller, or a reference to the original
   inAttrs parameter.

  obj - A possibly null object whose state is to be retrieved. - `java.lang.Object`
  name - The name of this object relative to nameCtx, or null if no name is specified. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified, or null if name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the object's state. - `java.util.Hashtable`
  in-attrs - The possibly null attributes to be bound with the object. The factory must not modify inAttrs. - `javax.naming.directory.Attributes`

  returns: A Result containing the object's state for binding
   and the corresponding
   attributes to be bound; null if the object don't use this factory. - `javax.naming.spi.DirStateFactory$Result`

  throws: javax.naming.NamingException - If this factory encountered an exception while attempting to get the object's state, and no other factories are to be tried."
  (^javax.naming.spi.DirStateFactory$Result [^DirStateFactory this ^java.lang.Object obj ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment ^javax.naming.directory.Attributes in-attrs]
    (-> this (.getStateToBind obj name name-ctx environment in-attrs))))

