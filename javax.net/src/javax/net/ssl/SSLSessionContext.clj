(ns javax.net.ssl.SSLSessionContext
  "A SSLSessionContext represents a set of
  SSLSessions associated with a single entity. For example,
  it could be associated with a server or client who participates in many
  sessions concurrently.

  Not all environments will contain session contexts.

  There are SSLSessionContext parameters that affect how
  sessions are stored:

       Sessions can be set to expire after a specified
       time limit.
       The number of sessions that can be stored in context
       can be limited.

  A session can be retrieved based on its session id, and all session id's
  in a SSLSessionContext can be listed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSessionContext]))

(defn get-session
  "Returns the SSLSession bound to the specified session id.

  session-id - the Session identifier - `byte[]`

  returns: the SSLSession or null if
   the specified session id does not refer to a valid SSLSession. - `javax.net.ssl.SSLSession`

  throws: java.lang.NullPointerException - if sessionId is null."
  (^javax.net.ssl.SSLSession [^SSLSessionContext this session-id]
    (-> this (.getSession session-id))))

(defn get-ids
  "Returns an Enumeration of all session id's grouped under this
   SSLSessionContext.

  returns: an enumeration of all the Session id's - `java.util.Enumeration<byte[]>`"
  ([^SSLSessionContext this]
    (-> this (.getIds))))

(defn set-session-timeout
  "Sets the timeout limit for SSLSession objects grouped
   under this SSLSessionContext.

   If the timeout limit is set to 't' seconds, a session exceeds the
   timeout limit 't' seconds after its creation time.
   When the timeout limit is exceeded for a session, the
   SSLSession object is invalidated and future connections
   cannot resume or rejoin the session.
   A check for sessions exceeding the timeout is made immediately whenever
   the timeout limit is changed for this SSLSessionContext.

  seconds - the new session timeout limit in seconds; zero means there is no limit. - `int`

  throws: java.lang.IllegalArgumentException - if the timeout specified is < 0."
  ([^SSLSessionContext this ^Integer seconds]
    (-> this (.setSessionTimeout seconds))))

(defn get-session-timeout
  "Returns the timeout limit of SSLSession objects grouped
   under this SSLSessionContext.

   If the timeout limit is set to 't' seconds, a session exceeds the
   timeout limit 't' seconds after its creation time.
   When the timeout limit is exceeded for a session, the
   SSLSession object is invalidated and future connections
   cannot resume or rejoin the session.
   A check for sessions exceeding the timeout limit is made immediately
   whenever the timeout limit is changed for this
   SSLSessionContext.

  returns: the session timeout limit in seconds; zero means there is no
   limit. - `int`"
  (^Integer [^SSLSessionContext this]
    (-> this (.getSessionTimeout))))

(defn set-session-cache-size
  "Sets the size of the cache used for storing
   SSLSession objects grouped under this
   SSLSessionContext.

  size - the new session cache size limit; zero means there is no limit. - `int`

  throws: java.lang.IllegalArgumentException - if the specified size is < 0."
  ([^SSLSessionContext this ^Integer size]
    (-> this (.setSessionCacheSize size))))

(defn get-session-cache-size
  "Returns the size of the cache used for storing
   SSLSession objects grouped under this
   SSLSessionContext.

  returns: size of the session cache; zero means there is no size limit. - `int`"
  (^Integer [^SSLSessionContext this]
    (-> this (.getSessionCacheSize))))

