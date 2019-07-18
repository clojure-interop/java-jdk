(ns jdk.beans.beancontext.BeanContextEvent
  " BeanContextEvent is the abstract root event class
  for all events emitted
  from, and pertaining to the semantics of, a BeanContext.
  This class introduces a mechanism to allow the propagation of
  BeanContextEvent subclasses through a hierarchy of
  BeanContexts. The setPropagatedFrom()
  and getPropagatedFrom() methods allow a
  BeanContext to identify itself as the source
  of a propagated event."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextEvent]))

(defn get-bean-context
  "Gets the BeanContext associated with this event.

  returns: the BeanContext associated with this event. - `java.beans.beancontext.BeanContext`"
  (^java.beans.beancontext.BeanContext [^BeanContextEvent this]
    (-> this (.getBeanContext))))

(defn set-propagated-from
  "Sets the BeanContext from which this event was propagated.

  bc - the BeanContext from which this event was propagated - `java.beans.beancontext.BeanContext`"
  ([^BeanContextEvent this ^java.beans.beancontext.BeanContext bc]
    (-> this (.setPropagatedFrom bc))))

(defn get-propagated-from
  "Gets the BeanContext from which this event was propagated.

  returns: the BeanContext from which this
   event was propagated - `java.beans.beancontext.BeanContext`"
  (^java.beans.beancontext.BeanContext [^BeanContextEvent this]
    (-> this (.getPropagatedFrom))))

(defn propagated?
  "Reports whether or not this event is
   propagated from some other BeanContext.

  returns: true if propagated, false
   if not - `boolean`"
  (^Boolean [^BeanContextEvent this]
    (-> this (.isPropagated))))

