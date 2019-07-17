(ns javax.print.event.PrintJobListener
  "Implementations of this listener interface should be attached to a
  DocPrintJob to monitor the status of
  the printer job.
  These callback methods may be invoked on the thread processing the
  print job, or a service created notification thread. In either case
  the client should not perform lengthy processing in these callbacks."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.event PrintJobListener]))

(defn print-data-transfer-completed
  "Called to notify the client that data has been successfully
   transferred to the print service, and the client may free
   local resources allocated for that data.  The client should
   not assume that the data has been completely printed after
   receiving this event.
   If this event is not received the client should wait for a terminal
   event (completed/canceled/failed) before freeing the resources.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printDataTransferCompleted pje))))

(defn print-job-completed
  "Called to notify the client that the job completed successfully.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printJobCompleted pje))))

(defn print-job-failed
  "Called to notify the client that the job failed to complete
   successfully and will have to be resubmitted.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printJobFailed pje))))

(defn print-job-canceled
  "Called to notify the client that the job was canceled
   by a user or a program.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printJobCanceled pje))))

(defn print-job-no-more-events
  "Called to notify the client that no more events will be delivered.
   One cause of this event being generated is if the job
   has successfully completed, but the printing system
   is limited in capability and cannot verify this.
   This event is required to be delivered if none of the other
   terminal events (completed/failed/canceled) are delivered.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printJobNoMoreEvents pje))))

(defn print-job-requires-attention
  "Called to notify the client that an error has occurred that the
   user might be able to fix.  One example of an error that can
   generate this event is when the printer runs out of paper.

  pje - the job generating this event - `javax.print.event.PrintJobEvent`"
  ([^javax.print.event.PrintJobListener this ^javax.print.event.PrintJobEvent pje]
    (-> this (.printJobRequiresAttention pje))))

