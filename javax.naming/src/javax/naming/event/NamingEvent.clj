(ns javax.naming.event.NamingEvent
  "This class represents an event fired by a naming/directory service.

  The NamingEvent's state consists of

  The event source: the EventContext which fired this event.
  The event type.
  The new binding: information about the object after the change.
  The old binding: information about the object before the change.
  Change information: information about the change
  that triggered this event; usually service provider-specific or server-specific
  information.


  Note that the event source is always the same EventContext
  instance  that the listener has registered with.
  Furthermore, the names of the bindings in
  the NamingEvent are always relative to that instance.
  For example, suppose a listener makes the following registration:


      NamespaceChangeListener listener = ...;
      src.addNamingListener(`x`, SUBTREE_SCOPE, listener);
  When an object named `x/y` is subsequently deleted, the corresponding
  NamingEvent (evt) must contain:


      evt.getEventContext() == src
      evt.getOldBinding().getName().equals(`x/y`)

  Care must be taken when multiple threads are accessing the same
  EventContext concurrently.
  See the
  package description
  for more information on threading issues."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event NamingEvent]))

(defn ->naming-event
  "Constructor.

  Constructs an instance of NamingEvent.

   The names in newBd and oldBd are to be resolved relative
   to the event source source.

   For an OBJECT_ADDED event type, newBd must not be null.
   For an OBJECT_REMOVED event type, oldBd must not be null.
   For an OBJECT_CHANGED event type,  newBd and
   oldBd must not be null. For  an OBJECT_RENAMED event type,
   one of newBd or oldBd may be null if the new or old
   binding is outside of the scope for which the listener has registered.

  source - The non-null context that fired this event. - `javax.naming.event.EventContext`
  type - The type of the event. - `int`
  new-bd - A possibly null binding before the change. See method description. - `javax.naming.Binding`
  old-bd - A possibly null binding after the change. See method description. - `javax.naming.Binding`
  change-info - A possibly null object containing information about the change. - `java.lang.Object`"
  ([^javax.naming.event.EventContext source ^Integer type ^javax.naming.Binding new-bd ^javax.naming.Binding old-bd ^java.lang.Object change-info]
    (new NamingEvent source type new-bd old-bd change-info)))

(def *-object-added
  "Static Constant.

  Naming event type for indicating that a new object has been added.
   The value of this constant is 0.

  type: int"
  NamingEvent/OBJECT_ADDED)

(def *-object-removed
  "Static Constant.

  Naming event type for indicating that an object has been removed.
   The value of this constant is 1.

  type: int"
  NamingEvent/OBJECT_REMOVED)

(def *-object-renamed
  "Static Constant.

  Naming event type for indicating that an object has been renamed.
   Note that some services might fire multiple events for a single
   logical rename operation. For example, the rename operation might
   be implemented by adding a binding with the new name and removing
   the old binding.

   The old/new binding in NamingEvent may be null if the old
   name or new name is outside of the scope for which the listener
   has registered.

   When an interior node in the namespace tree has been renamed, the
   topmost node which is part of the listener's scope should used to generate
   a rename event. The extent to which this can be supported is
   provider-specific. For example, a service might generate rename
   notifications for all descendants of the changed interior node and the
   corresponding provider might not be able to prevent those
   notifications from being propagated to the listeners.

   The value of this constant is 2.

  type: int"
  NamingEvent/OBJECT_RENAMED)

(def *-object-changed
  "Static Constant.

  Naming event type for indicating that an object has been changed.
   The changes might include the object's attributes, or the object itself.
   Note that some services might fire multiple events for a single
   modification. For example, the modification might
   be implemented by first removing the old binding and adding
   a new binding containing the same name but a different object.

   The value of this constant is 3.

  type: int"
  NamingEvent/OBJECT_CHANGED)

(defn get-type
  "Returns the type of this event.

  returns: The type of this event. - `int`"
  (^Integer [^javax.naming.event.NamingEvent this]
    (-> this (.getType))))

(defn get-event-context
  "Retrieves the event source that fired this event.
   This returns the same object as EventObject.getSource().

   If the result of this method is used to access the
   event source, for example, to look up the object or get its attributes,
   then it needs to be locked  because implementations of Context
   are not guaranteed to be thread-safe
   (and EventContext is a subinterface of Context).
   See the
   package description
   for more information on threading issues.

  returns: The non-null context that fired this event. - `javax.naming.event.EventContext`"
  (^javax.naming.event.EventContext [^javax.naming.event.NamingEvent this]
    (-> this (.getEventContext))))

(defn get-old-binding
  "Retrieves the binding of the object before the change.

   The binding must be nonnull if the object existed before the change
   relative to the source context (getEventContext()).
   That is, it must be nonnull for OBJECT_REMOVED and
   OBJECT_CHANGED.
   For OBJECT_RENAMED, it is null if the object before the rename
   is outside of the scope for which the listener has registered interest;
   it is nonnull if the object is inside the scope before the rename.

   The name in the binding is to be resolved relative
   to the event source getEventContext().
   The object returned by Binding.getObject() may be null if
   such information is unavailable.

  returns: The possibly null binding of the object before the change. - `javax.naming.Binding`"
  (^javax.naming.Binding [^javax.naming.event.NamingEvent this]
    (-> this (.getOldBinding))))

(defn get-new-binding
  "Retrieves the binding of the object after the change.

   The binding must be nonnull if the object existed after the change
   relative to the source context (getEventContext()).
   That is, it must be nonnull for OBJECT_ADDED and
   OBJECT_CHANGED. For OBJECT_RENAMED,
   it is null if the object after the rename is outside the scope for
   which the listener registered interest; it is nonnull if the object
   is inside the scope after the rename.

   The name in the binding is to be resolved relative
   to the event source getEventContext().
   The object returned by Binding.getObject() may be null if
   such information is unavailable.

  returns: The possibly null binding of the object after the change. - `javax.naming.Binding`"
  (^javax.naming.Binding [^javax.naming.event.NamingEvent this]
    (-> this (.getNewBinding))))

(defn get-change-info
  "Retrieves the change information for this event.
   The value of the change information is service-specific. For example,
   it could be an ID that identifies the change in a change log on the server.

  returns: The possibly null change information of this event. - `java.lang.Object`"
  (^java.lang.Object [^javax.naming.event.NamingEvent this]
    (-> this (.getChangeInfo))))

(defn dispatch
  "Invokes the appropriate listener method on this event.
   The default implementation of
   this method handles the following event types:
   OBJECT_ADDED, OBJECT_REMOVED,
   OBJECT_RENAMED, OBJECT_CHANGED.

   The listener method is executed in the same thread
   as this method.  See the
   package description
   for more information on threading issues.

  listener - The nonnull listener. - `javax.naming.event.NamingListener`"
  ([^javax.naming.event.NamingEvent this ^javax.naming.event.NamingListener listener]
    (-> this (.dispatch listener))))

