(ns jdk.beans.beancontext.BeanContextMembershipListener
  " Compliant BeanContexts fire events on this interface when the state of
  the membership of the BeanContext changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextMembershipListener]))

(defn children-added
  "Called when a child or list of children is added to a
   BeanContext that this listener is registered with.

  bcme - The BeanContextMembershipEvent describing the change that occurred. - `java.beans.beancontext.BeanContextMembershipEvent`"
  ([this bcme]
    (-> this (.childrenAdded bcme))))

(defn children-removed
  "Called when a child or list of children is removed
   from a BeanContext that this listener
   is registered with.

  bcme - The BeanContextMembershipEvent describing the change that occurred. - `java.beans.beancontext.BeanContextMembershipEvent`"
  ([this bcme]
    (-> this (.childrenRemoved bcme))))

