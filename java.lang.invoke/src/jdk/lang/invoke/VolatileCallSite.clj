(ns jdk.lang.invoke.VolatileCallSite
  "A VolatileCallSite is a CallSite whose target acts like a volatile variable.
  An invokedynamic instruction linked to a VolatileCallSite sees updates
  to its call site target immediately, even if the update occurs in another thread.
  There may be a performance penalty for such tight coupling between threads.

  Unlike MutableCallSite, there is no
  syncAll operation on volatile
  call sites, since every write to a volatile variable is implicitly
  synchronized with reader threads.

  In other respects, a VolatileCallSite is interchangeable
  with MutableCallSite."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke VolatileCallSite]))

(defn ->volatile-call-site
  "Constructor.

  Creates a call site with a volatile binding to its target.
   The initial target is set to a method handle
   of the given type which will throw an IllegalStateException if called.

  type - the method type that this call site will have - `java.lang.invoke.MethodType`

  throws: java.lang.NullPointerException - if the proposed type is null"
  ([^java.lang.invoke.MethodType type]
    (new VolatileCallSite type)))

(defn get-target
  "Returns the target method of the call site, which behaves
   like a volatile field of the VolatileCallSite.

   The interactions of getTarget with memory are the same
   as of a read from a volatile field.

   In particular, the current thread is required to issue a fresh
   read of the target from memory, and must not fail to see
   a recent update to the target by another thread.

  returns: the linkage state of this call site, a method handle which can change over time - `java.lang.invoke.MethodHandle`"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.VolatileCallSite this]
    (-> this (.getTarget))))

(defn set-target
  "Updates the target method of this call site, as a volatile variable.
   The type of the new target must agree with the type of the old target.

   The interactions with memory are the same as of a write to a volatile field.
   In particular, any threads is guaranteed to see the updated target
   the next time it calls getTarget.

  new-target - the new target - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the proposed new target is null"
  ([^java.lang.invoke.VolatileCallSite this ^java.lang.invoke.MethodHandle new-target]
    (-> this (.setTarget new-target))))

(defn dynamic-invoker
  "Produces a method handle equivalent to an invokedynamic instruction
   which has been linked to this call site.

   This method is equivalent to the following code:


   MethodHandle getTarget, invoker, result;
   getTarget = MethodHandles.publicLookup().bind(this, `getTarget`, MethodType.methodType(MethodHandle.class));
   invoker = MethodHandles.exactInvoker(this.type());
   result = MethodHandles.foldArguments(invoker, getTarget)

  returns: a method handle which always invokes this call site's current target - `java.lang.invoke.MethodHandle`"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.VolatileCallSite this]
    (-> this (.dynamicInvoker))))

