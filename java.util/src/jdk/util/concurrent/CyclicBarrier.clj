(ns jdk.util.concurrent.CyclicBarrier
  "A synchronization aid that allows a set of threads to all wait for
  each other to reach a common barrier point.  CyclicBarriers are
  useful in programs involving a fixed sized party of threads that
  must occasionally wait for each other. The barrier is called
  cyclic because it can be re-used after the waiting threads
  are released.

  A CyclicBarrier supports an optional Runnable command
  that is run once per barrier point, after the last thread in the party
  arrives, but before any threads are released.
  This barrier action is useful
  for updating shared-state before any of the parties continue.

  Sample usage: Here is an example of using a barrier in a
  parallel decomposition design:



  class Solver {
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
      int myRow;
      Worker(int row) { myRow = row; }
      public void run() {
        while (!done()) {
          processRow(myRow);

          try {
            barrier.await();
          } catch (InterruptedException ex) {
            return;
          } catch (BrokenBarrierException ex) {
            return;
          }
        }
      }
    }

    public Solver(float[][] matrix) {
      data = matrix;
      N = matrix.length;
      Runnable barrierAction =
        new Runnable() { public void run() { mergeRows(...); }};
      barrier = new CyclicBarrier(N, barrierAction);

      List<Thread> threads = new ArrayList<Thread>(N);
      for (int i = 0; i < N; i++) {
        Thread thread = new Thread(new Worker(i));
        threads.add(thread);
        thread.start();
      }

      // wait until done
      for (Thread thread : threads)
        thread.join();
    }
  }

  Here, each worker thread processes a row of the matrix then waits at the
  barrier until all rows have been processed. When all rows are processed
  the supplied Runnable barrier action is executed and merges the
  rows. If the merger
  determines that a solution has been found then done() will return
  true and each worker will terminate.

  If the barrier action does not rely on the parties being suspended when
  it is executed, then any of the threads in the party could execute that
  action when it is released. To facilitate this, each invocation of
  await() returns the arrival index of that thread at the barrier.
  You can then choose which thread should execute the barrier action, for
  example:


  if (barrier.await() == 0) {
    // log the completion of this iteration
  }

  The CyclicBarrier uses an all-or-none breakage model
  for failed synchronization attempts: If a thread leaves a barrier
  point prematurely because of interruption, failure, or timeout, all
  other threads waiting at that barrier point will also leave
  abnormally via BrokenBarrierException (or
  InterruptedException if they too were interrupted at about
  the same time).

  Memory consistency effects: Actions in a thread prior to calling
  await()
  happen-before
  actions that are part of the barrier action, which in turn
  happen-before actions following a successful return from the
  corresponding await() in other threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CyclicBarrier]))

(defn ->cyclic-barrier
  "Constructor.

  Creates a new CyclicBarrier that will trip when the
   given number of parties (threads) are waiting upon it, and which
   will execute the given barrier action when the barrier is tripped,
   performed by the last thread entering the barrier.

  parties - the number of threads that must invoke await() before the barrier is tripped - `int`
  barrier-action - the command to execute when the barrier is tripped, or null if there is no action - `java.lang.Runnable`

  throws: java.lang.IllegalArgumentException - if parties is less than 1"
  ([^Integer parties ^java.lang.Runnable barrier-action]
    (new CyclicBarrier parties barrier-action))
  ([^Integer parties]
    (new CyclicBarrier parties)))

(defn get-parties
  "Returns the number of parties required to trip this barrier.

  returns: the number of parties required to trip this barrier - `int`"
  ([^java.util.concurrent.CyclicBarrier this]
    (-> this (.getParties))))

(defn await
  "Waits until all parties have invoked
   await on this barrier, or the specified waiting time elapses.

   If the current thread is not the last to arrive then it is
   disabled for thread scheduling purposes and lies dormant until
   one of the following things happens:

   The last thread arrives; or
   The specified timeout elapses; or
   Some other thread interrupts
   the current thread; or
   Some other thread interrupts
   one of the other waiting threads; or
   Some other thread times out while waiting for barrier; or
   Some other thread invokes reset() on this barrier.


   If the current thread:

   has its interrupted status set on entry to this method; or
   is interrupted while waiting

   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.

   If the specified waiting time elapses then TimeoutException
   is thrown. If the time is less than or equal to zero, the
   method will not wait at all.

   If the barrier is reset() while any thread is waiting,
   or if the barrier is broken when
   await is invoked, or while any thread is waiting, then
   BrokenBarrierException is thrown.

   If any thread is interrupted while
   waiting, then all other waiting threads will throw BrokenBarrierException and the barrier is placed in the broken
   state.

   If the current thread is the last thread to arrive, and a
   non-null barrier action was supplied in the constructor, then the
   current thread runs the action before allowing the other threads to
   continue.
   If an exception occurs during the barrier action then that exception
   will be propagated in the current thread and the barrier is placed in
   the broken state.

  timeout - the time to wait for the barrier - `long`
  unit - the time unit of the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the arrival index of the current thread, where index
           getParties() - 1 indicates the first
           to arrive and zero indicates the last to arrive - `int`

  throws: java.lang.InterruptedException - if the current thread was interrupted while waiting"
  ([^java.util.concurrent.CyclicBarrier this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.await timeout unit)))
  ([^java.util.concurrent.CyclicBarrier this]
    (-> this (.await))))

(defn broken?
  "Queries if this barrier is in a broken state.

  returns: true if one or more parties broke out of this
           barrier due to interruption or timeout since
           construction or the last reset, or a barrier action
           failed due to an exception; false otherwise. - `boolean`"
  ([^java.util.concurrent.CyclicBarrier this]
    (-> this (.isBroken))))

(defn reset
  "Resets the barrier to its initial state.  If any parties are
   currently waiting at the barrier, they will return with a
   BrokenBarrierException. Note that resets after
   a breakage has occurred for other reasons can be complicated to
   carry out; threads need to re-synchronize in some other way,
   and choose one to perform the reset.  It may be preferable to
   instead create a new barrier for subsequent use."
  ([^java.util.concurrent.CyclicBarrier this]
    (-> this (.reset))))

(defn get-number-waiting
  "Returns the number of parties currently waiting at the barrier.
   This method is primarily useful for debugging and assertions.

  returns: the number of parties currently blocked in await() - `int`"
  ([^java.util.concurrent.CyclicBarrier this]
    (-> this (.getNumberWaiting))))

