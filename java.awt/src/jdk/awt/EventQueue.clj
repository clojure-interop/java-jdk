(ns jdk.awt.EventQueue
  "EventQueue is a platform-independent class
  that queues events, both from the underlying peer classes
  and from trusted application classes.

  It encapsulates asynchronous event dispatch machinery which
  extracts events from the queue and dispatches them by calling
  dispatchEvent(AWTEvent) method
  on this EventQueue with the event to be dispatched
  as an argument.  The particular behavior of this machinery is
  implementation-dependent.  The only requirements are that events
  which were actually enqueued to this queue (note that events
  being posted to the EventQueue can be coalesced)
  are dispatched:

     Sequentially.
     That is, it is not permitted that several events from
         this queue are dispatched simultaneously.
     In the same order as they are enqueued.
     That is, if AWTEvent A is enqueued
         to the EventQueue before
         AWTEvent B then event B will not be
         dispatched before event A.


  Some browsers partition applets in different code bases into
  separate contexts, and establish walls between these contexts.
  In such a scenario, there will be one EventQueue
  per context. Other browsers place all applets into the same
  context, implying that there will be only a single, global
  EventQueue for all applets. This behavior is
  implementation-dependent.  Consult your browser's documentation
  for more information.

  For information on the threading issues of the event dispatch
  machinery, see AWT Threading Issues."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt EventQueue]))

(defn ->event-queue
  "Constructor."
  ([]
    (new EventQueue )))

(defn *get-most-recent-event-time
  "Returns the timestamp of the most recent event that had a timestamp, and
   that was dispatched from the EventQueue associated with the
   calling thread. If an event with a timestamp is currently being
   dispatched, its timestamp will be returned. If no events have yet
   been dispatched, the EventQueue's initialization time will be
   returned instead.In the current version of
   the JDK, only InputEvents,
   ActionEvents, and InvocationEvents have
   timestamps; however, future versions of the JDK may add timestamps to
   additional event types. Note that this method should only be invoked
   from an application's event dispatching thread.
   If this method is
   invoked from another thread, the current system time (as reported by
   System.currentTimeMillis()) will be returned instead.

  returns: the timestamp of the last InputEvent,
           ActionEvent, or InvocationEvent to be
           dispatched, or System.currentTimeMillis() if this
           method is invoked on a thread other than an event dispatching
           thread - `long`"
  (^Long []
    (EventQueue/getMostRecentEventTime )))

(defn *get-current-event
  "Returns the the event currently being dispatched by the
   EventQueue associated with the calling thread. This is
   useful if a method needs access to the event, but was not designed to
   receive a reference to it as an argument. Note that this method should
   only be invoked from an application's event dispatching thread. If this
   method is invoked from another thread, null will be returned.

  returns: the event currently being dispatched, or null if this method is
           invoked on a thread other than an event dispatching thread - `java.awt.AWTEvent`"
  (^java.awt.AWTEvent []
    (EventQueue/getCurrentEvent )))

(defn *dispatch-thread?
  "Returns true if the calling thread is
   the current AWT EventQueue's
   dispatch thread. Use this method to ensure that a particular
   task is being executed (or not being) there.

   Note: use the invokeLater(java.lang.Runnable) or invokeAndWait(java.lang.Runnable)
   methods to execute a task in
   the current AWT EventQueue's
   dispatch thread.

  returns: true if running in
   the current AWT EventQueue's
   dispatch thread - `boolean`"
  (^Boolean []
    (EventQueue/isDispatchThread )))

(defn *invoke-later
  "Causes runnable to have its run
   method called in the dispatch thread of
   the system EventQueue.
   This will happen after all pending events are processed.

  runnable - the Runnable whose run method should be executed asynchronously in the event dispatch thread of the system EventQueue - `java.lang.Runnable`"
  ([^java.lang.Runnable runnable]
    (EventQueue/invokeLater runnable)))

(defn *invoke-and-wait
  "Causes runnable to have its run
   method called in the dispatch thread of
   the system EventQueue.
   This will happen after all pending events are processed.
   The call blocks until this has happened.  This method
   will throw an Error if called from the
   event dispatcher thread.

  runnable - the Runnable whose run method should be executed synchronously in the event dispatch thread of the system EventQueue - `java.lang.Runnable`

  throws: java.lang.InterruptedException - if any thread has interrupted this thread"
  ([^java.lang.Runnable runnable]
    (EventQueue/invokeAndWait runnable)))

(defn post-event
  "Posts a 1.1-style event to the EventQueue.
   If there is an existing event on the queue with the same ID
   and event source, the source Component's
   coalesceEvents method will be called.

  the-event - an instance of java.awt.AWTEvent, or a subclass of it - `java.awt.AWTEvent`

  throws: java.lang.NullPointerException - if theEvent is null"
  ([^java.awt.EventQueue this ^java.awt.AWTEvent the-event]
    (-> this (.postEvent the-event))))

(defn get-next-event
  "Removes an event from the EventQueue and
   returns it.  This method will block until an event has
   been posted by another thread.

  returns: the next AWTEvent - `java.awt.AWTEvent`

  throws: java.lang.InterruptedException - if any thread has interrupted this thread"
  (^java.awt.AWTEvent [^java.awt.EventQueue this]
    (-> this (.getNextEvent))))

(defn peek-event
  "Returns the first event with the specified id, if any.

  id - the id of the type of event desired - `int`

  returns: the first event of the specified id or null
      if there is no such event - `java.awt.AWTEvent`"
  (^java.awt.AWTEvent [^java.awt.EventQueue this ^Integer id]
    (-> this (.peekEvent id)))
  (^java.awt.AWTEvent [^java.awt.EventQueue this]
    (-> this (.peekEvent))))

(defn push
  "Replaces the existing EventQueue with the specified one.
   Any pending events are transferred to the new EventQueue
   for processing by it.

  new-event-queue - an EventQueue (or subclass thereof) instance to be use - `java.awt.EventQueue`

  throws: java.lang.NullPointerException - if newEventQueue is null"
  ([^java.awt.EventQueue this ^java.awt.EventQueue new-event-queue]
    (-> this (.push new-event-queue))))

(defn create-secondary-loop
  "Creates a new secondary loop associated with this
   event queue. Use the SecondaryLoop.enter() and
   SecondaryLoop.exit() methods to start and stop the
   event loop and dispatch the events from this queue.

  returns: secondaryLoop A new secondary loop object, which can
                         be used to launch a new nested event
                         loop and dispatch events from this queue - `java.awt.SecondaryLoop`"
  (^java.awt.SecondaryLoop [^java.awt.EventQueue this]
    (-> this (.createSecondaryLoop))))

