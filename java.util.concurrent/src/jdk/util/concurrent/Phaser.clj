(ns jdk.util.concurrent.Phaser
  "A reusable synchronization barrier, similar in functionality to
  CyclicBarrier and
  CountDownLatch
  but supporting more flexible usage.

  Registration. Unlike the case for other barriers, the
  number of parties registered to synchronize on a phaser
  may vary over time.  Tasks may be registered at any time (using
  methods register(), bulkRegister(int), or forms of
  constructors establishing initial numbers of parties), and
  optionally deregistered upon any arrival (using arriveAndDeregister()).  As is the case with most basic
  synchronization constructs, registration and deregistration affect
  only internal counts; they do not establish any further internal
  bookkeeping, so tasks cannot query whether they are registered.
  (However, you can introduce such bookkeeping by subclassing this
  class.)

  Synchronization. Like a CyclicBarrier, a Phaser may be repeatedly awaited.  Method arriveAndAwaitAdvance() has effect analogous to CyclicBarrier.await. Each
  generation of a phaser has an associated phase number. The phase
  number starts at zero, and advances when all parties arrive at the
  phaser, wrapping around to zero after reaching Integer.MAX_VALUE. The use of phase numbers enables independent
  control of actions upon arrival at a phaser and upon awaiting
  others, via two kinds of methods that may be invoked by any
  registered party:



     Arrival. Methods arrive() and
        arriveAndDeregister() record arrival.  These methods
        do not block, but return an associated arrival phase
        number; that is, the phase number of the phaser to which
        the arrival applied. When the final party for a given phase
        arrives, an optional action is performed and the phase
        advances.  These actions are performed by the party
        triggering a phase advance, and are arranged by overriding
        method onAdvance(int, int), which also controls
        termination. Overriding this method is similar to, but more
        flexible than, providing a barrier action to a CyclicBarrier.

     Waiting. Method awaitAdvance(int) requires an
        argument indicating an arrival phase number, and returns when
        the phaser advances to (or is already at) a different phase.
        Unlike similar constructions using CyclicBarrier,
        method awaitAdvance continues to wait even if the
        waiting thread is interrupted. Interruptible and timeout
        versions are also available, but exceptions encountered while
        tasks wait interruptibly or with timeout do not change the
        state of the phaser. If necessary, you can perform any
        associated recovery within handlers of those exceptions,
        often after invoking forceTermination.  Phasers may
        also be used by tasks executing in a ForkJoinPool,
        which will ensure sufficient parallelism to execute tasks
        when others are blocked waiting for a phase to advance.



  Termination. A phaser may enter a termination
  state, that may be checked using method isTerminated(). Upon
  termination, all synchronization methods immediately return without
  waiting for advance, as indicated by a negative return value.
  Similarly, attempts to register upon termination have no effect.
  Termination is triggered when an invocation of onAdvance
  returns true. The default implementation returns true if a deregistration has caused the number of registered
  parties to become zero.  As illustrated below, when phasers control
  actions with a fixed number of iterations, it is often convenient
  to override this method to cause termination when the current phase
  number reaches a threshold. Method forceTermination() is
  also available to abruptly release waiting threads and allow them
  to terminate.

  Tiering. Phasers may be tiered (i.e.,
  constructed in tree structures) to reduce contention. Phasers with
  large numbers of parties that would otherwise experience heavy
  synchronization contention costs may instead be set up so that
  groups of sub-phasers share a common parent.  This may greatly
  increase throughput even though it incurs greater per-operation
  overhead.

  In a tree of tiered phasers, registration and deregistration of
  child phasers with their parent are managed automatically.
  Whenever the number of registered parties of a child phaser becomes
  non-zero (as established in the Phaser(Phaser,int)
  constructor, register(), or bulkRegister(int)), the
  child phaser is registered with its parent.  Whenever the number of
  registered parties becomes zero as the result of an invocation of
  arriveAndDeregister(), the child phaser is deregistered
  from its parent.

  Monitoring. While synchronization methods may be invoked
  only by registered parties, the current state of a phaser may be
  monitored by any caller.  At any given moment there are getRegisteredParties() parties in total, of which getArrivedParties() have arrived at the current phase (getPhase()).  When the remaining (getUnarrivedParties())
  parties arrive, the phase advances.  The values returned by these
  methods may reflect transient states and so are not in general
  useful for synchronization control.  Method toString()
  returns snapshots of these state queries in a form convenient for
  informal monitoring.

  Sample usages:

  A Phaser may be used instead of a CountDownLatch
  to control a one-shot action serving a variable number of parties.
  The typical idiom is for the method setting this up to first
  register, then start the actions, then deregister, as in:



  void runTasks(List<Runnable> tasks) {
    final Phaser phaser = new Phaser(1); // \"1\" to register self
    // create and start threads
    for (final Runnable task : tasks) {
      phaser.register();
      new Thread() {
        public void run() {
          phaser.arriveAndAwaitAdvance(); // await all creation
          task.run();
        }
      }.start();
    }

    // allow threads to start and deregister self
    phaser.arriveAndDeregister();
  }

  One way to cause a set of threads to repeatedly perform actions
  for a given number of iterations is to override onAdvance:



  void startTasks(List<Runnable> tasks, final int iterations) {
    final Phaser phaser = new Phaser() {
      protected boolean onAdvance(int phase, int registeredParties) {
        return phase >= iterations || registeredParties == 0;
      }
    };
    phaser.register();
    for (final Runnable task : tasks) {
      phaser.register();
      new Thread() {
        public void run() {
          do {
            task.run();
            phaser.arriveAndAwaitAdvance();
          } while (!phaser.isTerminated());
        }
      }.start();
    }
    phaser.arriveAndDeregister(); // deregister self, don't wait
  }

  If the main task must later await termination, it
  may re-register and then execute a similar loop:


    // ...
    phaser.register();
    while (!phaser.isTerminated())
      phaser.arriveAndAwaitAdvance();

  Related constructions may be used to await particular phase numbers
  in contexts where you are sure that the phase will never wrap around
  Integer.MAX_VALUE. For example:



  void awaitPhase(Phaser phaser, int phase) {
    int p = phaser.register(); // assumes caller not already registered
    while (p < phase) {
      if (phaser.isTerminated())
        // ... deal with unexpected termination
      else
        p = phaser.arriveAndAwaitAdvance();
    }
    phaser.arriveAndDeregister();
  }


  To create a set of n tasks using a tree of phasers, you
  could use code of the following form, assuming a Task class with a
  constructor accepting a Phaser that it registers with upon
  construction. After invocation of build(new Task[n], 0, n,
  new Phaser()), these tasks could then be started, for example by
  submitting to a pool:



  void build(Task[] tasks, int lo, int hi, Phaser ph) {
    if (hi - lo > TASKS_PER_PHASER) {
      for (int i = lo; i < hi; i = TASKS_PER_PHASER) {
        int j = Math.min(i  TASKS_PER_PHASER, hi);
        build(tasks, i, j, new Phaser(ph));
      }
    } else {
      for (int i = lo; i < hi; +i)
        tasks[i] = new Task(ph);
        // assumes new Task(ph) performs ph.register()
    }
  }

  The best value of TASKS_PER_PHASER depends mainly on
  expected synchronization rates. A value as low as four may
  be appropriate for extremely small per-phase task bodies (thus
  high rates), or up to hundreds for extremely large ones.

  Implementation notes: This implementation restricts the
  maximum number of parties to 65535. Attempts to register additional
  parties result in IllegalStateException. However, you can and
  should create tiered phasers to accommodate arbitrarily large sets
  of participants."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Phaser]))

(defn ->phaser
  "Constructor.

  Creates a new phaser with the given parent and number of
   registered unarrived parties.  When the given parent is non-null
   and the given number of parties is greater than zero, this
   child phaser is registered with its parent.

  parent - the parent phaser - `java.util.concurrent.Phaser`
  parties - the number of parties required to advance to the next phase - `int`

  throws: java.lang.IllegalArgumentException - if parties less than zero or greater than the maximum number of parties supported"
  (^Phaser [^java.util.concurrent.Phaser parent ^Integer parties]
    (new Phaser parent parties))
  (^Phaser [^Integer parties]
    (new Phaser parties))
  (^Phaser []
    (new Phaser )))

(defn get-unarrived-parties
  "Returns the number of registered parties that have not yet
   arrived at the current phase of this phaser. If this phaser has
   terminated, the returned value is meaningless and arbitrary.

  returns: the number of unarrived parties - `int`"
  (^Integer [^Phaser this]
    (-> this (.getUnarrivedParties))))

(defn get-arrived-parties
  "Returns the number of registered parties that have arrived at
   the current phase of this phaser. If this phaser has terminated,
   the returned value is meaningless and arbitrary.

  returns: the number of arrived parties - `int`"
  (^Integer [^Phaser this]
    (-> this (.getArrivedParties))))

(defn arrive-and-await-advance
  "Arrives at this phaser and awaits others. Equivalent in effect
   to awaitAdvance(arrive()).  If you need to await with
   interruption or timeout, you can arrange this with an analogous
   construction using one of the other forms of the awaitAdvance method.  If instead you need to deregister upon
   arrival, use awaitAdvance(arriveAndDeregister()).

   It is a usage error for an unregistered party to invoke this
   method.  However, this error may result in an IllegalStateException only upon some subsequent operation on
   this phaser, if ever.

  returns: the arrival phase number, or the (negative)
   current phase if terminated - `int`

  throws: java.lang.IllegalStateException - if not terminated and the number of unarrived parties would become negative"
  (^Integer [^Phaser this]
    (-> this (.arriveAndAwaitAdvance))))

(defn get-registered-parties
  "Returns the number of parties registered at this phaser.

  returns: the number of parties - `int`"
  (^Integer [^Phaser this]
    (-> this (.getRegisteredParties))))

(defn await-advance-interruptibly
  "Awaits the phase of this phaser to advance from the given phase
   value or the given timeout to elapse, throwing InterruptedException if interrupted while waiting, or
   returning immediately if the current phase is not equal to the
   given phase value or this phaser is terminated.

  phase - an arrival phase number, or negative value if terminated; this argument is normally the value returned by a previous call to arrive or arriveAndDeregister. - `int`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the next arrival phase number, or the argument if it is
   negative, or the (negative) current phase
   if terminated - `int`

  throws: java.lang.InterruptedException - if thread interrupted while waiting"
  (^Integer [^Phaser this ^Integer phase ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitAdvanceInterruptibly phase timeout unit)))
  (^Integer [^Phaser this ^Integer phase]
    (-> this (.awaitAdvanceInterruptibly phase))))

(defn to-string
  "Returns a string identifying this phaser, as well as its
   state.  The state, in brackets, includes the String \"phase = \" followed by the phase number, \"parties = \"
   followed by the number of registered parties, and \"arrived = \" followed by the number of arrived parties.

  returns: a string identifying this phaser, as well as its state - `java.lang.String`"
  (^java.lang.String [^Phaser this]
    (-> this (.toString))))

(defn get-phase
  "Returns the current phase number. The maximum phase number is
   Integer.MAX_VALUE, after which it restarts at
   zero. Upon termination, the phase number is negative,
   in which case the prevailing phase prior to termination
   may be obtained via getPhase()  Integer.MIN_VALUE.

  returns: the phase number, or a negative value if terminated - `int`"
  (^Integer [^Phaser this]
    (-> this (.getPhase))))

(defn bulk-register
  "Adds the given number of new unarrived parties to this phaser.
   If an ongoing invocation of onAdvance(int, int) is in progress,
   this method may await its completion before returning.  If this
   phaser has a parent, and the given number of parties is greater
   than zero, and this phaser previously had no registered
   parties, this child phaser is also registered with its parent.
   If this phaser is terminated, the attempt to register has no
   effect, and a negative value is returned.

  parties - the number of additional parties required to advance to the next phase - `int`

  returns: the arrival phase number to which this registration
   applied.  If this value is negative, then this phaser has
   terminated, in which case registration has no effect. - `int`

  throws: java.lang.IllegalStateException - if attempting to register more than the maximum supported number of parties"
  (^Integer [^Phaser this ^Integer parties]
    (-> this (.bulkRegister parties))))

(defn get-parent
  "Returns the parent of this phaser, or null if none.

  returns: the parent of this phaser, or null if none - `java.util.concurrent.Phaser`"
  (^java.util.concurrent.Phaser [^Phaser this]
    (-> this (.getParent))))

(defn get-root
  "Returns the root ancestor of this phaser, which is the same as
   this phaser if it has no parent.

  returns: the root ancestor of this phaser - `java.util.concurrent.Phaser`"
  (^java.util.concurrent.Phaser [^Phaser this]
    (-> this (.getRoot))))

(defn register
  "Adds a new unarrived party to this phaser.  If an ongoing
   invocation of onAdvance(int, int) is in progress, this method
   may await its completion before returning.  If this phaser has
   a parent, and this phaser previously had no registered parties,
   this child phaser is also registered with its parent. If
   this phaser is terminated, the attempt to register has
   no effect, and a negative value is returned.

  returns: the arrival phase number to which this registration
   applied.  If this value is negative, then this phaser has
   terminated, in which case registration has no effect. - `int`

  throws: java.lang.IllegalStateException - if attempting to register more than the maximum supported number of parties"
  (^Integer [^Phaser this]
    (-> this (.register))))

(defn force-termination
  "Forces this phaser to enter termination state.  Counts of
   registered parties are unaffected.  If this phaser is a member
   of a tiered set of phasers, then all of the phasers in the set
   are terminated.  If this phaser is already terminated, this
   method has no effect.  This method may be useful for
   coordinating recovery after one or more tasks encounter
   unexpected exceptions."
  ([^Phaser this]
    (-> this (.forceTermination))))

(defn arrive
  "Arrives at this phaser, without waiting for others to arrive.

   It is a usage error for an unregistered party to invoke this
   method.  However, this error may result in an IllegalStateException only upon some subsequent operation on
   this phaser, if ever.

  returns: the arrival phase number, or a negative value if terminated - `int`

  throws: java.lang.IllegalStateException - if not terminated and the number of unarrived parties would become negative"
  (^Integer [^Phaser this]
    (-> this (.arrive))))

(defn terminated?
  "Returns true if this phaser has been terminated.

  returns: true if this phaser has been terminated - `boolean`"
  (^Boolean [^Phaser this]
    (-> this (.isTerminated))))

(defn arrive-and-deregister
  "Arrives at this phaser and deregisters from it without waiting
   for others to arrive. Deregistration reduces the number of
   parties required to advance in future phases.  If this phaser
   has a parent, and deregistration causes this phaser to have
   zero parties, this phaser is also deregistered from its parent.

   It is a usage error for an unregistered party to invoke this
   method.  However, this error may result in an IllegalStateException only upon some subsequent operation on
   this phaser, if ever.

  returns: the arrival phase number, or a negative value if terminated - `int`

  throws: java.lang.IllegalStateException - if not terminated and the number of registered or unarrived parties would become negative"
  (^Integer [^Phaser this]
    (-> this (.arriveAndDeregister))))

(defn await-advance
  "Awaits the phase of this phaser to advance from the given phase
   value, returning immediately if the current phase is not equal
   to the given phase value or this phaser is terminated.

  phase - an arrival phase number, or negative value if terminated; this argument is normally the value returned by a previous call to arrive or arriveAndDeregister. - `int`

  returns: the next arrival phase number, or the argument if it is
   negative, or the (negative) current phase
   if terminated - `int`"
  (^Integer [^Phaser this ^Integer phase]
    (-> this (.awaitAdvance phase))))

