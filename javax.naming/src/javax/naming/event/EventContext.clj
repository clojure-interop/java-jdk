(ns javax.naming.event.EventContext
  "Contains methods for registering/deregistering listeners to be notified of
  events fired when objects named in a context changes.

 Target
  The name parameter in the addNamingListener() methods is referred
  to as the target. The target, along with the scope, identify
  the object(s) that the listener is interested in.
  It is possible to register interest in a target that does not exist, but
  there might be limitations in the extent to which this can be
  supported by the service provider and underlying protocol/service.

  If a service only supports registration for existing
  targets, an attempt to register for a nonexistent target
  results in a NameNotFoundException being thrown as early as possible,
  preferably at the time addNamingListener() is called, or if that is
  not possible, the listener will receive the exception through the
  NamingExceptionEvent.

  Also, for service providers that only support registration for existing
  targets, when the target that a listener has registered for is
  subsequently removed from the namespace, the listener is notified
  via a NamingExceptionEvent (containing a
 NameNotFoundException).

  An application can use the method targetMustExist() to check
  whether a EventContext supports registration
  of nonexistent targets.

 Event Source
  The EventContext instance on which you invoke the
  registration methods is the event source of the events that are
  (potentially) generated.
  The source is not necessarily the object named by the target.
  Only when the target is the empty name is the object named by the target
  the source.
  In other words, the target,
  along with the scope parameter, are used to identify
  the object(s) that the listener is interested in, but the event source
  is the EventContext instance with which the listener
  has registered.

  For example, suppose a listener makes the following registration:


       NamespaceChangeListener listener = ...;
       src.addNamingListener(`x`, SUBTREE_SCOPE, listener);
  When an object named `x/y` is subsequently deleted, the corresponding
  NamingEvent (evt)  must contain:


       evt.getEventContext() == src
       evt.getOldBinding().getName().equals(`x/y`)

  Furthermore, listener registration/deregistration is with
  the EventContext
  instance, and not with the corresponding object in the namespace.
  If the program intends at some point to remove a listener, then it needs to
  keep a reference to the EventContext instance on
  which it invoked addNamingListener() (just as
  it needs to keep a reference to the listener in order to remove it
  later). It cannot expect to do a lookup() and get another instance of
  a EventContext on which to perform the deregistration.
 Lifetime of Registration
  A registered listener becomes deregistered when:

 It is removed using removeNamingListener().
 An exception is thrown while collecting information about the events.
   That is, when the listener receives a NamingExceptionEvent.
 Context.close() is invoked on the EventContext
  instance with which it has registered.

  Until that point, a EventContext instance that has outstanding
  listeners will continue to exist and be maintained by the service provider.

 Listener Implementations
  The registration/deregistration methods accept an instance of
  NamingListener. There are subinterfaces of NamingListener
  for different of event types of NamingEvent.
  For example, the ObjectChangeListener
  interface is for the NamingEvent.OBJECT_CHANGED event type.
  To register interest in multiple event types, the listener implementation
  should implement multiple NamingListener subinterfaces and use a
  single invocation of addNamingListener().
  In addition to reducing the number of method calls and possibly the code size
  of the listeners, this allows some service providers to optimize the
  registration.

 Threading Issues

  Like Context instances in general, instances of
  EventContext are not guaranteed to be thread-safe.
  Care must be taken when multiple threads are accessing the same
  EventContext concurrently.
  See the
  package description
  for more information on threading issues."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event EventContext]))

(defn add-naming-listener
  "Adds a listener for receiving naming events fired
   when the object(s) identified by a target and scope changes.

   The event source of those events is this context. See the
   class description for a discussion on event source and target.
   See the descriptions of the constants OBJECT_SCOPE,
   ONELEVEL_SCOPE, and SUBTREE_SCOPE to see how
   scope affects the registration.

   target needs to name a context only when scope is
   ONELEVEL_SCOPE.
   target may name a non-context if scope is either
   OBJECT_SCOPE or SUBTREE_SCOPE.  Using
   SUBTREE_SCOPE for a non-context might be useful,
   for example, if the caller does not know in advance whether target
   is a context and just wants to register interest in the (possibly
   degenerate subtree) rooted at target.

   When the listener is notified of an event, the listener may
   in invoked in a thread other than the one in which
   addNamingListener() is executed.
   Care must be taken when multiple threads are accessing the same
   EventContext concurrently.
   See the
   package description
   for more information on threading issues.

  target - A nonnull name to be resolved relative to this context. - `javax.naming.Name`
  scope - One of OBJECT_SCOPE, ONELEVEL_SCOPE, or SUBTREE_SCOPE. - `int`
  l - The nonnull listener. - `javax.naming.event.NamingListener`

  throws: javax.naming.NamingException - If a problem was encountered while adding the listener."
  ([^javax.naming.event.EventContext this ^javax.naming.Name target ^Integer scope ^javax.naming.event.NamingListener l]
    (-> this (.addNamingListener target scope l))))

(defn remove-naming-listener
  "Removes a listener from receiving naming events fired
   by this EventContext.
   The listener may have registered more than once with this
   EventContext, perhaps with different target/scope arguments.
   After this method is invoked, the listener will no longer
   receive events with this EventContext instance
   as the event source (except for those events already in the process of
   being dispatched).
   If the listener was not, or is no longer, registered with
   this EventContext instance, this method does not do anything.

  l - The nonnull listener. - `javax.naming.event.NamingListener`

  throws: javax.naming.NamingException - If a problem was encountered while removing the listener."
  ([^javax.naming.event.EventContext this ^javax.naming.event.NamingListener l]
    (-> this (.removeNamingListener l))))

(defn target-must-exist
  "Determines whether a listener can register interest in a target
   that does not exist.

  returns: true if the target must exist; false if the target need not exist. - `boolean`

  throws: javax.naming.NamingException - If the context's behavior in this regard cannot be determined."
  (^Boolean [^javax.naming.event.EventContext this]
    (-> this (.targetMustExist))))

