(ns jdk.net.CookiePolicy
  "CookiePolicy implementations decide which cookies should be accepted
  and which should be rejected. Three pre-defined policy implementations
  are provided, namely ACCEPT_ALL, ACCEPT_NONE and ACCEPT_ORIGINAL_SERVER.

  See RFC 2965 sec. 3.3 and 7 for more detail."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CookiePolicy]))

(defn should-accept?
  "Will be called to see whether or not this cookie should be accepted.

  uri - the URI to consult accept policy with - `java.net.URI`
  cookie - the HttpCookie object in question - `java.net.HttpCookie`

  returns: true if this cookie should be accepted;
                    otherwise, false - `boolean`"
  ([this uri cookie]
    (-> this (.shouldAccept uri cookie))))

