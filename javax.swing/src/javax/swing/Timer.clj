(ns javax.swing.Timer
  "Fires one or more ActionEvents at specified
  intervals. An example use is an animation object that uses a
  Timer as the trigger for drawing its frames.

  Setting up a timer
  involves creating a Timer object,
  registering one or more action listeners on it,
  and starting the timer using
  the start method.
  For example,
  the following code creates and starts a timer
  that fires an action event once per second
  (as specified by the first argument to the Timer constructor).
  The second argument to the Timer constructor
  specifies a listener to receive the timer's action events.



   int delay = 1000; //milliseconds
   ActionListener taskPerformer = new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
           //...Perform a task...
       }
   };
   new Timer(delay, taskPerformer).start();


  Timers are constructed by specifying both a delay parameter
  and an ActionListener. The delay parameter is used
  to set both the initial delay and the delay between event
  firing, in milliseconds. Once the timer has been started,
  it waits for the initial delay before firing its
  first ActionEvent to registered listeners.
  After this first event, it continues to fire events
  every time the between-event delay has elapsed, until it
  is stopped.

  After construction, the initial delay and the between-event
  delay can be changed independently, and additional
  ActionListeners may be added.

  If you want the timer to fire only the first time and then stop,
  invoke setRepeats(false) on the timer.

  Although all Timers perform their waiting
  using a single, shared thread
  (created by the first Timer object that executes),
  the action event handlers for Timers
  execute on another thread -- the event-dispatching thread.
  This means that the action handlers for Timers
  can safely perform operations on Swing components.
  However, it also means that the handlers must execute quickly
  to keep the GUI responsive.


  In v 1.3, another Timer class was added
  to the Java platform: java.util.Timer.
  Both it and javax.swing.Timer
  provide the same basic functionality,
  but java.util.Timer
  is more general and has more features.
  The javax.swing.Timer has two features
  that can make it a little easier to use with GUIs.
  First, its event handling metaphor is familiar to GUI programmers
  and can make dealing with the event-dispatching thread
  a bit simpler.
  Second, its
  automatic thread sharing means that you don't have to
  take special steps to avoid spawning
  too many threads.
  Instead, your timer uses the same thread
  used to make cursors blink,
  tool tips appear,
  and so on.


  You can find further documentation
  and several examples of using timers by visiting
  How to Use Timers,
  a section in The Java Tutorial.
  For more examples and help in choosing between
  this Timer class and
  java.util.Timer,
  see
  Using Timers in Swing Applications,
  an article in The Swing Connection.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Timer]))

(defn ->timer
  "Constructor.

  Creates a Timer and initializes both the initial delay and
   between-event delay to delay milliseconds. If delay
   is less than or equal to zero, the timer fires as soon as it
   is started. If listener is not null,
   it's registered as an action listener on the timer.

  delay - milliseconds for the initial and between-event delay - `int`
  listener - an initial listener; can be null - `java.awt.event.ActionListener`"
  (^Timer [^Integer delay ^java.awt.event.ActionListener listener]
    (new Timer delay listener)))

(defn *set-log-timers
  "Enables or disables the timer log. When enabled, a message
   is posted to System.out whenever the timer goes off.

  flag - true to enable logging - `boolean`"
  ([^Boolean flag]
    (Timer/setLogTimers flag)))

(defn *get-log-timers?
  "Returns true if logging is enabled.

  returns: true if logging is enabled; otherwise, false - `boolean`"
  (^Boolean []
    (Timer/getLogTimers )))

(defn stop
  "Stops the Timer,
   causing it to stop sending action events
   to its listeners."
  ([^Timer this]
    (-> this (.stop))))

(defn set-delay
  "Sets the Timer's between-event delay, the number of milliseconds
   between successive action events. This does not affect the initial delay
   property, which can be set by the setInitialDelay method.

  delay - the delay in milliseconds - `int`"
  ([^Timer this ^Integer delay]
    (-> this (.setDelay delay))))

(defn set-initial-delay
  "Sets the Timer's initial delay, the time
   in milliseconds to wait after the timer is started
   before firing the first event. Upon construction, this
   is set to be the same as the between-event delay,
   but then its value is independent and remains unaffected
   by changes to the between-event delay.

  initial-delay - the initial delay, in milliseconds - `int`"
  ([^Timer this ^Integer initial-delay]
    (-> this (.setInitialDelay initial-delay))))

(defn coalesce?
  "Returns true if the Timer coalesces
   multiple pending action events.

  returns: `boolean`"
  (^Boolean [^Timer this]
    (-> this (.isCoalesce))))

(defn get-delay
  "Returns the delay, in milliseconds,
   between firings of action events.

  returns: `int`"
  (^Integer [^Timer this]
    (-> this (.getDelay))))

(defn set-repeats
  "If flag is false,
   instructs the Timer to send only one
   action event to its listeners.

  flag - specify false to make the timer stop after sending its first action event - `boolean`"
  ([^Timer this ^Boolean flag]
    (-> this (.setRepeats flag))))

(defn add-action-listener
  "Adds an action listener to the Timer.

  listener - the listener to add - `java.awt.event.ActionListener`"
  ([^Timer this ^java.awt.event.ActionListener listener]
    (-> this (.addActionListener listener))))

(defn repeats?
  "Returns true (the default)
   if the Timer will send
   an action event
   to its listeners multiple times.

  returns: `boolean`"
  (^Boolean [^Timer this]
    (-> this (.isRepeats))))

(defn get-initial-delay
  "Returns the Timer's initial delay.

  returns: `int`"
  (^Integer [^Timer this]
    (-> this (.getInitialDelay))))

(defn start
  "Starts the Timer,
   causing it to start sending action events
   to its listeners."
  ([^Timer this]
    (-> this (.start))))

(defn get-action-listeners
  "Returns an array of all the action listeners registered
   on this timer.

  returns: all of the timer's ActionListeners or an empty
           array if no action listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^Timer this]
    (-> this (.getActionListeners))))

(defn restart
  "Restarts the Timer,
   canceling any pending firings and causing
   it to fire with its initial delay."
  ([^Timer this]
    (-> this (.restart))))

(defn running?
  "Returns true if the Timer is running.

  returns: `boolean`"
  (^Boolean [^Timer this]
    (-> this (.isRunning))))

(defn remove-action-listener
  "Removes the specified action listener from the Timer.

  listener - the listener to remove - `java.awt.event.ActionListener`"
  ([^Timer this ^java.awt.event.ActionListener listener]
    (-> this (.removeActionListener listener))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this Timer.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a Timer
   instance t
   for its action listeners
   with the following code:



  ActionListener[] als = (ActionListener[])(t.getListeners(ActionListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners
            on this timer,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^Timer this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-action-command
  "Returns the string that will be delivered as the action command
   in ActionEvents fired by this timer. May be
   null, which is also the default.

  returns: the action command used in firing events - `java.lang.String`"
  (^java.lang.String [^Timer this]
    (-> this (.getActionCommand))))

(defn set-coalesce
  "Sets whether the Timer coalesces multiple pending
   ActionEvent firings.
   A busy application may not be able
   to keep up with a Timer's event generation,
   causing multiple
   action events to be queued.  When processed,
   the application sends these events one after the other, causing the
   Timer's listeners to receive a sequence of
   events with no delay between them. Coalescing avoids this situation
   by reducing multiple pending events to a single event.
   Timers
   coalesce events by default.

  flag - specify false to turn off coalescing - `boolean`"
  ([^Timer this ^Boolean flag]
    (-> this (.setCoalesce flag))))

(defn set-action-command
  "Sets the string that will be delivered as the action command
   in ActionEvents fired by this timer.
   null is an acceptable value.

  command - the action command - `java.lang.String`"
  ([^Timer this ^java.lang.String command]
    (-> this (.setActionCommand command))))

