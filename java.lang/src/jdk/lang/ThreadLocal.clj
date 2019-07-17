(ns jdk.lang.ThreadLocal
  "This class provides thread-local variables.  These variables differ from
  their normal counterparts in that each thread that accesses one (via its
  get or set method) has its own, independently initialized
  copy of the variable.  ThreadLocal instances are typically private
  static fields in classes that wish to associate state with a thread (e.g.,
  a user ID or Transaction ID).

  For example, the class below generates unique identifiers local to each
  thread.
  A thread's id is assigned the first time it invokes ThreadId.get()
  and remains unchanged on subsequent calls.


  import java.util.concurrent.atomic.AtomicInteger;

  public class ThreadId {
      // Atomic integer containing the next thread ID to be assigned
      private static final AtomicInteger nextId = new AtomicInteger(0);

      // Thread local variable containing each thread's ID
      private static final ThreadLocal<Integer> threadId =
          new ThreadLocal<Integer>() {
              @Override protected Integer initialValue() {
                  return nextId.getAndIncrement();
          }
      };

      // Returns the current thread's unique ID, assigning it if necessary
      public static int get() {
          return threadId.get();
      }
  }
  Each thread holds an implicit reference to its copy of a thread-local
  variable as long as the thread is alive and the ThreadLocal
  instance is accessible; after a thread goes away, all of its copies of
  thread-local instances are subject to garbage collection (unless other
  references to these copies exist)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ThreadLocal]))

(defn ->thread-local
  "Constructor.

  Creates a thread local variable."
  ([]
    (new ThreadLocal )))

(defn *with-initial
  "Creates a thread local variable. The initial value of the variable is
   determined by invoking the get method on the Supplier.

  supplier - the supplier to be used to determine the initial value - `S>`

  returns: a new thread local variable - `<S> java.lang.ThreadLocal<S>`

  throws: java.lang.NullPointerException - if the specified supplier is null"
  ([supplier]
    (ThreadLocal/withInitial supplier)))

(defn get
  "Returns the value in the current thread's copy of this
   thread-local variable.  If the variable has no value for the
   current thread, it is first initialized to the value returned
   by an invocation of the initialValue() method.

  returns: the current thread's value of this thread-local - `ThreadLocal.T`"
  ([^java.lang.ThreadLocal this]
    (-> this (.get))))

(defn set
  "Sets the current thread's copy of this thread-local variable
   to the specified value.  Most subclasses will have no need to
   override this method, relying solely on the initialValue()
   method to set the values of thread-locals.

  value - the value to be stored in the current thread's copy of this thread-local. - `ThreadLocal.T`"
  ([^java.lang.ThreadLocal this ^ThreadLocal.T value]
    (-> this (.set value))))

(defn remove
  "Removes the current thread's value for this thread-local
   variable.  If this thread-local variable is subsequently
   read by the current thread, its value will be
   reinitialized by invoking its initialValue() method,
   unless its value is set by the current thread
   in the interim.  This may result in multiple invocations of the
   initialValue method in the current thread."
  ([^java.lang.ThreadLocal this]
    (-> this (.remove))))

