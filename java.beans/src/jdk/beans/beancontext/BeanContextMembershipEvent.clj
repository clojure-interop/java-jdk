(ns jdk.beans.beancontext.BeanContextMembershipEvent
  "A BeanContextMembershipEvent encapsulates
  the list of children added to, or removed from,
  the membership of a particular BeanContext.
  An instance of this event is fired whenever a successful
  add(), remove(), retainAll(), removeAll(), or clear() is
  invoked on a given BeanContext instance.
  Objects interested in receiving events of this type must
  implement the BeanContextMembershipListener
  interface, and must register their intent via the
  BeanContext's
  addBeanContextMembershipListener(BeanContextMembershipListener bcml)
   method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextMembershipEvent]))

(defn ->bean-context-membership-event
  "Constructor.

  Contruct a BeanContextMembershipEvent

  bc - The BeanContext source - `java.beans.beancontext.BeanContext`
  changes - The Children affected - `java.util.Collection`

  throws: java.lang.NullPointerException - if changes is null"
  ([^java.beans.beancontext.BeanContext bc ^java.util.Collection changes]
    (new BeanContextMembershipEvent bc changes)))

(defn size
  "Gets the number of children affected by the notification.

  returns: the number of children affected by the notification - `int`"
  ([^java.beans.beancontext.BeanContextMembershipEvent this]
    (-> this (.size))))

(defn contains
  "Is the child specified affected by the event?

  child - the object to check for being affected - `java.lang.Object`

  returns: true if affected, false
   if not - `boolean`"
  ([^java.beans.beancontext.BeanContextMembershipEvent this ^java.lang.Object child]
    (-> this (.contains child))))

(defn to-array
  "Gets the array of children affected by this event.

  returns: the array of children affected - `java.lang.Object[]`"
  ([^java.beans.beancontext.BeanContextMembershipEvent this]
    (-> this (.toArray))))

(defn iterator
  "Gets the array of children affected by this event.

  returns: the array of children effected - `java.util.Iterator`"
  ([^java.beans.beancontext.BeanContextMembershipEvent this]
    (-> this (.iterator))))

