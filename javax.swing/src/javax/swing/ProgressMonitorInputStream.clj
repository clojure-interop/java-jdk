(ns javax.swing.ProgressMonitorInputStream
  "Monitors the progress of reading from some InputStream. This ProgressMonitor
  is normally invoked in roughly this form:


  InputStream in = new BufferedInputStream(
                           new ProgressMonitorInputStream(
                                   parentComponent,
                                   `Reading `  fileName,
                                   new FileInputStream(fileName)));
  This creates a progress monitor to monitor the progress of reading
  the input stream.  If it's taking a while, a ProgressDialog will
  be popped up to inform the user.  If the user hits the Cancel button
  an InterruptedIOException will be thrown on the next read.
  All the right cleanup is done when the stream is closed.




  For further documentation and examples see
  How to Monitor Progress,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ProgressMonitorInputStream]))

(defn ->progress-monitor-input-stream
  "Constructor.

  Constructs an object to monitor the progress of an input stream.

  parent-component - The component triggering the operation being monitored. - `java.awt.Component`
  message - Descriptive text to be placed in the dialog box if one is popped up. - `java.lang.Object`
  in - The input stream to be monitored. - `java.io.InputStream`"
  ([^java.awt.Component parent-component ^java.lang.Object message ^java.io.InputStream in]
    (new ProgressMonitorInputStream parent-component message in)))

(defn get-progress-monitor
  "Get the ProgressMonitor object being used by this stream. Normally
   this isn't needed unless you want to do something like change the
   descriptive text partway through reading the file.

  returns: the ProgressMonitor object used by this object - `javax.swing.ProgressMonitor`"
  ([^javax.swing.ProgressMonitorInputStream this]
    (-> this (.getProgressMonitor))))

(defn read
  "Overrides FilterInputStream.read
   to update the progress monitor after the read.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.swing.ProgressMonitorInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^javax.swing.ProgressMonitorInputStream this b]
    (-> this (.read b)))
  ([^javax.swing.ProgressMonitorInputStream this]
    (-> this (.read))))

(defn skip
  "Overrides FilterInputStream.skip
   to update the progress monitor after the skip.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if the stream does not support seek, or if some other I/O error occurs."
  ([^javax.swing.ProgressMonitorInputStream this ^Long n]
    (-> this (.skip n))))

(defn close
  "Overrides FilterInputStream.close
   to close the progress monitor as well as the stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.swing.ProgressMonitorInputStream this]
    (-> this (.close))))

(defn reset
  "Overrides FilterInputStream.reset
   to reset the progress monitor as well as the stream.

  throws: java.io.IOException - if the stream has not been marked or if the mark has been invalidated."
  ([^javax.swing.ProgressMonitorInputStream this]
    (-> this (.reset))))

