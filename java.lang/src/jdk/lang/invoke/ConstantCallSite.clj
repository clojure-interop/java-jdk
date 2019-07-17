(ns jdk.lang.invoke.ConstantCallSite
  "A ConstantCallSite is a CallSite whose target is permanent, and can never be changed.
  An invokedynamic instruction linked to a ConstantCallSite is permanently
  bound to the call site's target."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke ConstantCallSite]))

(defn ->constant-call-site
  "Constructor.

  Creates a call site with a permanent target.

  target - the target to be permanently associated with this call site - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the proposed target is null"
  ([target]
    (new ConstantCallSite target)))

(defn get-target
  "Returns the target method of the call site, which behaves
   like a final field of the ConstantCallSite.
   That is, the target is always the original value passed
   to the constructor call which created this instance.

  returns: the immutable linkage state of this call site, a constant method handle - `java.lang.invoke.MethodHandle`

  throws: java.lang.IllegalStateException - if the ConstantCallSite constructor has not completed"
  ([this]
    (-> this (.getTarget))))

(defn set-target
  "Always throws an UnsupportedOperationException.
   This kind of call site cannot change its target.

  ignore - a new target proposed for the call site, which is ignored - `java.lang.invoke.MethodHandle`

  throws: java.lang.UnsupportedOperationException - because this kind of call site cannot change its target"
  ([this ignore]
    (-> this (.setTarget ignore))))

(defn dynamic-invoker
  "Returns this call site's permanent target.
   Since that target will never change, this is a correct implementation
   of CallSite.dynamicInvoker.

  returns: the immutable linkage state of this call site, a constant method handle - `java.lang.invoke.MethodHandle`

  throws: java.lang.IllegalStateException - if the ConstantCallSite constructor has not completed"
  ([this]
    (-> this (.dynamicInvoker))))

