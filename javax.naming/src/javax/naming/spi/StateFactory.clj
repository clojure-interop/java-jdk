(ns javax.naming.spi.StateFactory
  "This interface represents a factory for obtaining the state of an
  object for binding.

  The JNDI framework allows for object implementations to
  be loaded in dynamically via object factories.
  For example, when looking up a printer bound in the name space,
  if the print service binds printer names to References, the printer
  Reference could be used to create a printer object, so that
  the caller of lookup can directly operate on the printer object
  after the lookup.
  An ObjectFactory is responsible
  for creating objects of a specific type.  In the above example,
  you may have a PrinterObjectFactory for creating
  Printer objects.

  For the reverse process, when an object is bound into the namespace,
  JNDI provides state factories.
  Continuing with the printer example, suppose the printer object is
  updated and rebound:


  ctx.rebind(`inky`, printer);
  The service provider for ctx uses a state factory
  to obtain the state of printer for binding into its namespace.
  A state factory for the Printer type object might return
  a more compact object for storage in the naming system.

  A state factory must implement the StateFactory interface.
  In addition, the factory class must be public and must have a
  public constructor that accepts no parameters.

  The getStateToBind() method of a state factory may
  be invoked multiple times, possibly using different parameters.
  The implementation is thread-safe.

  StateFactory is intended for use with service providers
  that implement only the Context interface.
  DirStateFactory is intended for use with service providers
  that implement the DirContext interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi StateFactory]))

(defn get-state-to-bind
  "Retrieves the state of an object for binding.

   NamingManager.getStateToBind()
   successively loads in state factories and invokes this method
   on them until one produces a non-null answer.
   DirectoryManager.getStateToBind()
   successively loads in state factories.  If a factory implements
   DirStateFactory, then DirectoryManager
   invokes DirStateFactory.getStateToBind(); otherwise
   it invokes StateFactory.getStateToBind().
   When an exception
   is thrown by a factory, the exception is passed on to the caller
   of NamingManager.getStateToBind() and
   DirectoryManager.getStateToBind().
   The search for other factories
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

   The name and environment parameters
   are owned by the caller.
   The implementation will not modify these objects or keep references
   to them, although it may keep references to clones or copies.

  obj - A non-null object whose state is to be retrieved. - `java.lang.Object`
  name - The name of this object relative to nameCtx, or null if no name is specified. - `javax.naming.Name`
  name-ctx - The context relative to which the name parameter is specified, or null if name is relative to the default initial context. - `javax.naming.Context`
  environment - The possibly null environment to be used in the creation of the object's state. - `java.util.Hashtable<?,?>`

  returns: The object's state for binding;
                null if the factory is not returning any changes. - `java.lang.Object`

  throws: javax.naming.NamingException - if this factory encountered an exception while attempting to get the object's state, and no other factories are to be tried."
  (^java.lang.Object [^javax.naming.spi.StateFactory this ^java.lang.Object obj ^javax.naming.Name name ^javax.naming.Context name-ctx ^java.util.Hashtable environment]
    (-> this (.getStateToBind obj name name-ctx environment))))

