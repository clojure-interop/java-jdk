(ns javax.print.event.PrintJobAdapter
  "An abstract adapter class for receiving print job events.
  The methods in this class are empty.
  This class exists as a convenience for creating listener objects.
  Extend this class to create a PrintJobEvent listener and override
  the methods for the events of interest.  Unlike the
  ComponentListener
  interface, this abstract interface provides null methods so that you
  only need to define the methods you need, rather than all of the methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintJobAdapter]))

(defn ->print-job-adapter
  "Constructor."
  ([]
    (new PrintJobAdapter )))

(defn print-data-transfer-completed
  "Called to notify the client that data has been successfully
   transferred to the print service, and the client may free
   local resources allocated for that data.  The client should
   not assume that the data has been completely printed after
   receiving this event.

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printDataTransferCompleted pje))))

(defn print-job-completed
  "Called to notify the client that the job completed successfully.

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printJobCompleted pje))))

(defn print-job-failed
  "Called to notify the client that the job failed to complete
   successfully and will have to be resubmitted.

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printJobFailed pje))))

(defn print-job-canceled
  "Called to notify the client that the job was canceled
   by user or program.

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printJobCanceled pje))))

(defn print-job-no-more-events
  "Called to notify the client that no more events will be delivered.
   One cause of this event being generated is if the job
   has successfully completed, but the printing system
   is limited in capability and cannot verify this.
   This event is required to be delivered if none of the other
   terminal events (completed/failed/canceled) are delivered.

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printJobNoMoreEvents pje))))

(defn print-job-requires-attention
  "Called to notify the client that some possibly user rectifiable
   problem occurs (eg printer out of paper).

  pje - the event being notified - `javax.print.event.PrintJobEvent`"
  ([this pje]
    (-> this (.printJobRequiresAttention pje))))

