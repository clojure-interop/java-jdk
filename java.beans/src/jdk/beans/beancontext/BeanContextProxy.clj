(ns jdk.beans.beancontext.BeanContextProxy
  " This interface is implemented by a JavaBean that does
  not directly have a BeanContext(Child) associated with
  it (via implementing that interface or a subinterface thereof),
  but has a public BeanContext(Child) delegated from it.
  For example, a subclass of java.awt.Container may have a BeanContext
  associated with it that all Component children of that Container shall
  be contained within.


  An Object may not implement this interface and the
  BeanContextChild interface
  (or any subinterfaces thereof) they are mutually exclusive.


  Callers of this interface shall examine the return type in order to
  obtain a particular subinterface of BeanContextChild as follows:

  BeanContextChild bcc = o.getBeanContextProxy();

  if (bcc instanceof BeanContext) {
       // ...
  }

  or

  BeanContextChild bcc = o.getBeanContextProxy();
  BeanContext      bc  = null;

  try {
      bc = (BeanContext)bcc;
  } catch (ClassCastException cce) {
      // cast failed, bcc is not an instanceof BeanContext
  }



  The return value is a constant for the lifetime of the implementing
  instance"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextProxy]))

(defn get-bean-context-proxy
  "Gets the BeanContextChild (or subinterface)
   associated with this object.

  returns: the BeanContextChild (or subinterface)
   associated with this object - `java.beans.beancontext.BeanContextChild`"
  ([^. this]
    (-> this (.getBeanContextProxy))))

