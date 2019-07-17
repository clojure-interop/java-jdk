(ns javax.swing.ProgressMonitor
  "A class to monitor the progress of some operation. If it looks
  like the operation will take a while, a progress dialog will be popped up.
  When the ProgressMonitor is created it is given a numeric range and a
  descriptive string. As the operation progresses, call the setProgress method
  to indicate how far along the [min,max] range the operation is.
  Initially, there is no ProgressDialog. After the first millisToDecideToPopup
  milliseconds (default 500) the progress monitor will predict how long
  the operation will take.  If it is longer than millisToPopup (default 2000,
  2 seconds) a ProgressDialog will be popped up.

  From time to time, when the Dialog box is visible, the progress bar will
  be updated when setProgress is called.  setProgress won't always update
  the progress bar, it will only be done if the amount of progress is
  visibly significant.



  For further documentation and examples see
  How to Monitor Progress,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ProgressMonitor]))

(defn ->progress-monitor
  "Constructor.

  Constructs a graphic object that shows progress, typically by filling
   in a rectangular bar as the process nears completion.

  parent-component - the parent component for the dialog box - `java.awt.Component`
  message - a descriptive message that will be shown to the user to indicate what operation is being monitored. This does not change as the operation progresses. See the message parameters to methods in JOptionPane.message for the range of values. - `java.lang.Object`
  note - a short note describing the state of the operation. As the operation progresses, you can call setNote to change the note displayed. This is used, for example, in operations that iterate through a list of files to show the name of the file being processes. If note is initially null, there will be no note line in the dialog box and setNote will be ineffective - `java.lang.String`
  min - the lower bound of the range - `int`
  max - the upper bound of the range - `int`"
  ([^java.awt.Component parent-component ^java.lang.Object message ^java.lang.String note ^Integer min ^Integer max]
    (new ProgressMonitor parent-component message note min max)))

(defn set-progress
  "Indicate the progress of the operation being monitored.
   If the specified value is >= the maximum, the progress
   monitor is closed.

  nv - an int specifying the current value, between the maximum and minimum specified for this component - `int`"
  ([^javax.swing.ProgressMonitor this ^Integer nv]
    (-> this (.setProgress nv))))

(defn canceled?
  "Returns true if the user hits the Cancel button in the progress dialog.

  returns: `boolean`"
  (^Boolean [^javax.swing.ProgressMonitor this]
    (-> this (.isCanceled))))

(defn get-minimum
  "Returns the minimum value -- the lower end of the progress value.

  returns: an int representing the minimum value - `int`"
  (^Integer [^javax.swing.ProgressMonitor this]
    (-> this (.getMinimum))))

(defn get-note
  "Specifies the additional note that is displayed along with the
   progress message.

  returns: a String specifying the note to display - `java.lang.String`"
  (^java.lang.String [^javax.swing.ProgressMonitor this]
    (-> this (.getNote))))

(defn get-millis-to-popup
  "Returns the amount of time it will take for the popup to appear.

  returns: `int`"
  (^Integer [^javax.swing.ProgressMonitor this]
    (-> this (.getMillisToPopup))))

(defn get-millis-to-decide-to-popup
  "Returns the amount of time this object waits before deciding whether
   or not to popup a progress monitor.

  returns: `int`"
  (^Integer [^javax.swing.ProgressMonitor this]
    (-> this (.getMillisToDecideToPopup))))

(defn set-maximum
  "Specifies the maximum value.

  m - an int specifying the maximum value - `int`"
  ([^javax.swing.ProgressMonitor this ^Integer m]
    (-> this (.setMaximum m))))

(defn set-millis-to-popup
  "Specifies the amount of time it will take for the popup to appear.
   (If the predicted time remaining is less than this time, the popup
   won't be displayed.)

  millis-to-popup - an int specifying the time in milliseconds - `int`"
  ([^javax.swing.ProgressMonitor this ^Integer millis-to-popup]
    (-> this (.setMillisToPopup millis-to-popup))))

(defn get-accessible-context
  "Gets the AccessibleContext for the
   ProgressMonitor

  returns: the AccessibleContext for the
   ProgressMonitor - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.ProgressMonitor this]
    (-> this (.getAccessibleContext))))

(defn close
  "Indicate that the operation is complete.  This happens automatically
   when the value set by setProgress is >= max, but it may be called
   earlier if the operation ends early."
  ([^javax.swing.ProgressMonitor this]
    (-> this (.close))))

(defn set-note
  "Specifies the additional note that is displayed along with the
   progress message. Used, for example, to show which file the
   is currently being copied during a multiple-file copy.

  note - a String specifying the note to display - `java.lang.String`"
  ([^javax.swing.ProgressMonitor this ^java.lang.String note]
    (-> this (.setNote note))))

(defn set-minimum
  "Specifies the minimum value.

  m - an int specifying the minimum value - `int`"
  ([^javax.swing.ProgressMonitor this ^Integer m]
    (-> this (.setMinimum m))))

(defn get-maximum
  "Returns the maximum value -- the higher end of the progress value.

  returns: an int representing the maximum value - `int`"
  (^Integer [^javax.swing.ProgressMonitor this]
    (-> this (.getMaximum))))

(defn set-millis-to-decide-to-popup
  "Specifies the amount of time to wait before deciding whether or
   not to popup a progress monitor.

  millis-to-decide-to-popup - an int specifying the time to wait, in milliseconds - `int`"
  ([^javax.swing.ProgressMonitor this ^Integer millis-to-decide-to-popup]
    (-> this (.setMillisToDecideToPopup millis-to-decide-to-popup))))

