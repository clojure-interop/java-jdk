(ns jdk.beans.DesignMode
  " This interface is intended to be implemented by, or delegated from, instances
  of java.beans.beancontext.BeanContext, in order to propagate to its nested hierarchy
  of java.beans.beancontext.BeanContextChild instances, the current \"designTime\" property.

  The JavaBeans™ specification defines the notion of design time as is a
  mode in which JavaBeans instances should function during their composition
  and customization in a interactive design, composition or construction tool,
  as opposed to runtime when the JavaBean is part of an applet, application,
  or other live Java executable abstraction."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans DesignMode]))

(defn set-design-time
  "Sets the \"value\" of the \"designTime\" property.

   If the implementing object is an instance of java.beans.beancontext.BeanContext,
   or a subinterface thereof, then that BeanContext should fire a
   PropertyChangeEvent, to its registered BeanContextMembershipListeners, with
   parameters:

      propertyName - java.beans.DesignMode.PROPERTYNAME
      oldValue - previous value of \"designTime\"
      newValue - current value of \"designTime\"

   Note it is illegal for a BeanContextChild to invoke this method
   associated with a BeanContext that it is nested within.

  design-time - the current \"value\" of the \"designTime\" property - `boolean`"
  ([^DesignMode this ^Boolean design-time]
    (-> this (.setDesignTime design-time))))

(defn design-time?
  "A value of true denotes that JavaBeans should behave in design time
   mode, a value of false denotes runtime behavior.

  returns: the current \"value\" of the \"designTime\" property. - `boolean`"
  (^Boolean [^DesignMode this]
    (-> this (.isDesignTime))))

