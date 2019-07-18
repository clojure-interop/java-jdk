(ns javax.management.remote.JMXPrincipal
  "The identity of a remote client of the JMX Remote API.

  Principals such as this JMXPrincipal
  may be associated with a particular Subject
  to augment that Subject with an additional
  identity.  Refer to the Subject
  class for more information on how to achieve this.
  Authorization decisions can then be based upon
  the Principals associated with a Subject."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXPrincipal]))

(defn ->jmx-principal
  "Constructor.

  Creates a JMXPrincipal for a given identity.

  name - the JMX Remote API name for this identity. - `java.lang.String`

  throws: java.lang.NullPointerException - if the name is null."
  (^JMXPrincipal [^java.lang.String name]
    (new JMXPrincipal name)))

(defn get-name
  "Returns the name of this principal.

  returns: the name of this JMXPrincipal. - `java.lang.String`"
  (^java.lang.String [^JMXPrincipal this]
    (-> this (.getName))))

(defn to-string
  "Returns a string representation of this JMXPrincipal.

  returns: a string representation of this JMXPrincipal. - `java.lang.String`"
  (^java.lang.String [^JMXPrincipal this]
    (-> this (.toString))))

(defn equals
  "Compares the specified Object with this JMXPrincipal
   for equality.  Returns true if the given object is also a
   JMXPrincipal and the two JMXPrincipals
   have the same name.

  o - Object to be compared for equality with this JMXPrincipal. - `java.lang.Object`

  returns: true if the specified Object is equal to this
   JMXPrincipal. - `boolean`"
  (^Boolean [^JMXPrincipal this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Returns a hash code for this JMXPrincipal.

  returns: a hash code for this JMXPrincipal. - `int`"
  (^Integer [^JMXPrincipal this]
    (-> this (.hashCode))))

