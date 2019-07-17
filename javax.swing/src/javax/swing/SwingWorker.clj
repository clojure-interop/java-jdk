(ns javax.swing.SwingWorker
  "An abstract class to perform lengthy GUI-interaction tasks in a
  background thread. Several background threads can be used to execute such
  tasks. However, the exact strategy of choosing a thread for any particular
  SwingWorker is unspecified and should not be relied on.

  When writing a multi-threaded application using Swing, there are
  two constraints to keep in mind:
  (refer to

    Concurrency in Swing
   for more details):

     Time-consuming tasks should not be run on the Event
         Dispatch Thread. Otherwise the application becomes unresponsive.

     Swing components should be accessed  on the Event
         Dispatch Thread only.





  These constraints mean that a GUI application with time intensive
  computing needs at least two threads:  1) a thread to perform the lengthy
  task and 2) the Event Dispatch Thread (EDT) for all GUI-related
  activities.  This involves inter-thread communication which can be
  tricky to implement.


  SwingWorker is designed for situations where you need to have a long
  running task run in a background thread and provide updates to the UI
  either when done, or while processing.
  Subclasses of SwingWorker must implement
  the doInBackground() method to perform the background computation.



  Workflow

  There are three threads involved in the life cycle of a
  SwingWorker :



  Current thread: The execute() method is
  called on this thread. It schedules SwingWorker for the execution on a
  worker
  thread and returns immediately. One can wait for the SwingWorker to
  complete using the get methods.


  Worker thread: The doInBackground()
  method is called on this thread.
  This is where all background activities should happen. To notify
  PropertyChangeListeners about bound properties changes use the
  firePropertyChange and
  getPropertyChangeSupport() methods. By default there are two bound
  properties available: state and progress.


  Event Dispatch Thread:  All Swing related activities occur
  on this thread. SwingWorker invokes the
  process and done() methods and notifies
  any PropertyChangeListeners on this thread.



  Often, the Current thread is the Event Dispatch
  Thread.



  Before the doInBackground method is invoked on a worker thread,
  SwingWorker notifies any PropertyChangeListeners about the
  state property change to StateValue.STARTED.  After the
  doInBackground method is finished the done method is
  executed.  Then SwingWorker notifies any PropertyChangeListeners
  about the state property change to StateValue.DONE.


  SwingWorker is only designed to be executed once.  Executing a
  SwingWorker more than once will not result in invoking the
  doInBackground method twice.


  Sample Usage

  The following example illustrates the simplest use case.  Some
  processing is done in the background and when done you update a Swing
  component.


  Say we want to find the `Meaning of Life` and display the result in
  a JLabel.



    final JLabel label;
    class MeaningOfLifeFinder extends SwingWorker<String, Object> {
         @Override
        public String doInBackground() {
            return findTheMeaningOfLife();
        }

         @Override
        protected void done() {
            try {
                label.setText(get());
            } catch (Exception ignore) {
            }
        }
    }

    (new MeaningOfLifeFinder()).execute();


  The next example is useful in situations where you wish to process data
  as it is ready on the Event Dispatch Thread.


  Now we want to find the first N prime numbers and display the results in a
  JTextArea.  While this is computing, we want to update our
  progress in a JProgressBar.  Finally, we also want to print
  the prime numbers to System.out.


  class PrimeNumbersTask extends
          SwingWorker<List<Integer>, Integer> {
      PrimeNumbersTask(JTextArea textArea, int numbersToFind) {
          //initialize
      }

       @Override
      public List<Integer> doInBackground() {
          while (! enough && ! isCancelled()) {
                  number = nextPrimeNumber();
                  publish(number);
                  setProgress(100 * numbers.size() / numbersToFind);
              }
          }
          return numbers;
      }

       @Override
      protected void process(List<Integer> chunks) {
          for (int number : chunks) {
              textArea.append(number  `\n`);
          }
      }
  }

  JTextArea textArea = new JTextArea();
  final JProgressBar progressBar = new JProgressBar(0, 100);
  PrimeNumbersTask task = new PrimeNumbersTask(textArea, N);
  task.addPropertyChangeListener(
      new PropertyChangeListener() {
          public  void propertyChange(PropertyChangeEvent evt) {
              if (`progress`.equals(evt.getPropertyName())) {
                  progressBar.setValue((Integer)evt.getNewValue());
              }
          }
      });

  task.execute();
  System.out.println(task.get()); //prints all prime numbers we have got


  Because SwingWorker implements Runnable, a
  SwingWorker can be submitted to an
  Executor for execution."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SwingWorker]))

(defn ->swing-worker
  "Constructor.

  Constructs this SwingWorker."
  ([]
    (new SwingWorker )))

(defn cancel
  "Attempts to cancel execution of this task.  This attempt will
   fail if the task has already completed, has already been cancelled,
   or could not be cancelled for some other reason. If successful,
   and this task has not started when cancel is called,
   this task should never run.  If the task has already started,
   then the mayInterruptIfRunning parameter determines
   whether the thread executing this task should be interrupted in
   an attempt to stop the task.

   After this method returns, subsequent calls to Future.isDone() will
   always return true.  Subsequent calls to Future.isCancelled()
   will always return true if this method returned true.

  may-interrupt-if-running - true if the thread executing this task should be interrupted; otherwise, in-progress tasks are allowed to complete - `boolean`

  returns: false if the task could not be cancelled,
   typically because it has already completed normally;
   true otherwise - `boolean`"
  (^Boolean [^javax.swing.SwingWorker this ^Boolean may-interrupt-if-running]
    (-> this (.cancel may-interrupt-if-running))))

(defn fire-property-change
  "Reports a bound property update to any registered listeners. No event is
   fired if old and new are equal and non-null.


   This SwingWorker will be the source for
   any generated events.


   When called off the Event Dispatch Thread
   PropertyChangeListeners are notified asynchronously on
   the Event Dispatch Thread.

   Note: This is merely a convenience wrapper. All work is delegated to
   PropertyChangeSupport from getPropertyChangeSupport().

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property - `java.lang.Object`
  new-value - the new value of the property - `java.lang.Object`"
  ([^javax.swing.SwingWorker this ^java.lang.String property-name ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn cancelled?
  "Returns true if this task was cancelled before it completed
   normally.

  returns: true if this task was cancelled before it completed - `boolean`"
  (^Boolean [^javax.swing.SwingWorker this]
    (-> this (.isCancelled))))

(defn get-property-change-support
  "Returns the PropertyChangeSupport for this SwingWorker.
   This method is used when flexible access to bound properties support is
   needed.

   This SwingWorker will be the source for
   any generated events.


   Note: The returned PropertyChangeSupport notifies any
   PropertyChangeListeners asynchronously on the Event Dispatch
   Thread in the event that firePropertyChange or
   fireIndexedPropertyChange are called off the Event Dispatch
   Thread.

  returns: PropertyChangeSupport for this SwingWorker - `java.beans.PropertyChangeSupport`"
  (^java.beans.PropertyChangeSupport [^javax.swing.SwingWorker this]
    (-> this (.getPropertyChangeSupport))))

(defn run
  "Sets this Future to the result of computation unless
   it has been cancelled."
  ([^javax.swing.SwingWorker this]
    (-> this (.run))))

(defn get-progress
  "Returns the progress bound property.

  returns: the progress bound property. - `int`"
  (^Integer [^javax.swing.SwingWorker this]
    (-> this (.getProgress))))

(defn get-state
  "Returns the SwingWorker state bound property.

  returns: the current state - `javax.swing.SwingWorker.StateValue`"
  (^javax.swing.SwingWorker.StateValue [^javax.swing.SwingWorker this]
    (-> this (.getState))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list. This
   removes a PropertyChangeListener that was registered for all
   properties. If listener was added more than once to the same
   event source, it will be notified one less time after being removed. If
   listener is null, or was never added, no exception is
   thrown and no action is taken.


   Note: This is merely a convenience wrapper. All work is delegated to
   PropertyChangeSupport from getPropertyChangeSupport().

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^javax.swing.SwingWorker this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn execute
  "Schedules this SwingWorker for execution on a worker
   thread. There are a number of worker threads available. In the
   event all worker threads are busy handling other
   SwingWorkers this SwingWorker is placed in a waiting
   queue.


   Note:
   SwingWorker is only designed to be executed once.  Executing a
   SwingWorker more than once will not result in invoking the
   doInBackground method twice."
  ([^javax.swing.SwingWorker this]
    (-> this (.execute))))

(defn done?
  "Returns true if this task completed.

   Completion may be due to normal termination, an exception, or
   cancellation -- in all of these cases, this method will return
   true.

  returns: true if this task completed - `boolean`"
  (^Boolean [^javax.swing.SwingWorker this]
    (-> this (.isDone))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list. The listener
   is registered for all properties. The same listener object may be added
   more than once, and will be called as many times as it is added. If
   listener is null, no exception is thrown and no action is taken.


   Note: This is merely a convenience wrapper. All work is delegated to
   PropertyChangeSupport from getPropertyChangeSupport().

  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^javax.swing.SwingWorker this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn get
  "Waits if necessary for at most the given time for the computation
   to complete, and then retrieves its result, if available.

   Please refer to get() for more details.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the computed result - `SwingWorker.T`

  throws: java.lang.InterruptedException - if the current thread was interrupted while waiting"
  (^SwingWorker.T [^javax.swing.SwingWorker this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.get timeout unit)))
  (^SwingWorker.T [^javax.swing.SwingWorker this]
    (-> this (.get))))

