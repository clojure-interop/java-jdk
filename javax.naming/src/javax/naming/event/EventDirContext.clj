(ns javax.naming.event.EventDirContext
  "Contains methods for registering listeners to be notified
  of events fired when objects named in a directory context changes.

  The methods in this interface support identification of objects by
  RFC 2254
  search filters.

 Using the search filter, it is possible to register interest in objects
  that do not exist at the time of registration but later come into existence and
  satisfy the filter.  However, there might be limitations in the extent
  to which this can be supported by the service provider and underlying
  protocol/service.  If the caller submits a filter that cannot be
  supported in this way, addNamingListener() throws an
  InvalidSearchFilterException.

  See EventContext for a description of event source
  and target, and information about listener registration/deregistration
  that are also applicable to methods in this interface.
  See the
  package description
  for information on threading issues.

  A SearchControls or array object
  passed as a parameter to any method is owned by the caller.
  The service provider will not modify the object or keep a reference to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event EventDirContext]))

(defn add-naming-listener
  "Adds a listener for receiving naming events fired
   when objects identified by the search filter filter and
   filter arguments at the object named by the target are modified.
   The scope, returningObj flag, and returningAttributes flag from
   the search controls ctls are used to control the selection
   of objects that the listener is interested in,
   and determines what information is returned in the eventual
   NamingEvent object.  Note that the requested
   information to be returned might not be present in the NamingEvent
   object if they are unavailable or could not be obtained by the
   service provider or service.

  target - The nonnull name of the object resolved relative to this context. - `javax.naming.Name`
  filter - The nonnull string filter (see RFC2254). - `java.lang.String`
  filter-args - The possibly null array of arguments for the filter. - `java.lang.Object[]`
  ctls - The possibly null search controls. If null, the default search controls are used. - `javax.naming.directory.SearchControls`
  l - The nonnull listener. - `javax.naming.event.NamingListener`

  throws: javax.naming.NamingException - If a problem was encountered while adding the listener."
  ([^. this ^javax.naming.Name target ^java.lang.String filter ^java.lang.Object[] filter-args ^javax.naming.directory.SearchControls ctls ^javax.naming.event.NamingListener l]
    (-> this (.addNamingListener target filter filter-args ctls l)))
  ([^. this ^javax.naming.Name target ^java.lang.String filter ^javax.naming.directory.SearchControls ctls ^javax.naming.event.NamingListener l]
    (-> this (.addNamingListener target filter ctls l))))

