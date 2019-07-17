(ns javax.swing.JProgressBar
  "A component that visually displays the progress of some task.  As the task
  progresses towards completion, the progress bar displays the
  task's percentage of completion.
  This percentage is typically represented visually by a rectangle which
  starts out empty and gradually becomes filled in as the task progresses.
  In addition, the progress bar can display a textual representation of this
  percentage.

  JProgressBar uses a BoundedRangeModel as its data model,
  with the value property representing the `current` state of the task,
  and the minimum and maximum properties representing the
  beginning and end points, respectively.

  To indicate that a task of unknown length is executing,
  you can put a progress bar into indeterminate mode.
  While the bar is in indeterminate mode,
  it animates constantly to show that work is occurring.
  As soon as you can determine the task's length and amount of progress,
  you should update the progress bar's value
  and switch it back to determinate mode.



  Here is an example of creating a progress bar,
  where task is an object (representing some piece of work)
  which returns information about the progress of the task:



 progressBar = new JProgressBar(0, task.getLengthOfTask());
 progressBar.setValue(0);
 progressBar.setStringPainted(true);

  Here is an example of querying the current state of the task, and using
  the returned value to update the progress bar:



 progressBar.setValue(task.getCurrent());

  Here is an example of putting a progress bar into
  indeterminate mode,
  and then switching back to determinate mode
  once the length of the task is known:



 progressBar = new JProgressBar();
 ...//when the task of (initially) unknown length begins:
 progressBar.setIndeterminate(true);
 ...//do some work; get length of task...
 progressBar.setMaximum(newLength);
 progressBar.setValue(newValue);
 progressBar.setIndeterminate(false);



  For complete examples and further documentation see
  How to Monitor Progress,
  a section in The Java Tutorial.


  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JProgressBar]))

(defn ->j-progress-bar
  "Constructor.

  Creates a progress bar using the specified orientation,
   minimum, and maximum.
   By default, a border is painted but a progress string is not.
   Sets the initial value of the progress bar to the specified minimum.

   The BoundedRangeModel that holds the progress bar's data
   handles any issues that may arise from improperly setting the
   minimum, initial, and maximum values on the progress bar.
   See the BoundedRangeModel documentation for details.

  orient - the desired orientation of the progress bar - `int`
  min - the minimum value of the progress bar - `int`
  max - the maximum value of the progress bar - `int`

  throws: java.lang.IllegalArgumentException - if orient is an illegal value"
  ([^Integer orient ^Integer min ^Integer max]
    (new JProgressBar orient min max))
  ([^Integer min ^Integer max]
    (new JProgressBar min max))
  ([^Integer orient]
    (new JProgressBar orient))
  ([]
    (new JProgressBar )))

(defn add-change-listener
  "Adds the specified ChangeListener to the progress bar.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^javax.swing.JProgressBar this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn set-string
  "Sets the value of the progress string. By default,
   this string is null, implying the built-in behavior of
   using a simple percent string.
   If you have provided a custom progress string and want to revert to
   the built-in behavior, set the string back to null.

   The progress string is painted only if
   the isStringPainted method returns true.

  s - the value of the progress string - `java.lang.String`"
  ([^javax.swing.JProgressBar this ^java.lang.String s]
    (-> this (.setString s))))

(defn get-orientation
  "Returns SwingConstants.VERTICAL or
   SwingConstants.HORIZONTAL, depending on the orientation
   of the progress bar. The default orientation is
   SwingConstants.HORIZONTAL.

  returns: HORIZONTAL or VERTICAL - `int`"
  (^Integer [^javax.swing.JProgressBar this]
    (-> this (.getOrientation))))

(defn get-percent-complete
  "Returns the percent complete for the progress bar.
   Note that this number is between 0.0 and 1.0.

  returns: the percent complete for this progress bar - `double`"
  (^Double [^javax.swing.JProgressBar this]
    (-> this (.getPercentComplete))))

(defn string-painted?
  "Returns the value of the stringPainted property.

  returns: the value of the stringPainted property - `boolean`"
  (^Boolean [^javax.swing.JProgressBar this]
    (-> this (.isStringPainted))))

(defn get-minimum
  "Returns the progress bar's minimum value
   from the BoundedRangeModel.

  returns: the progress bar's minimum value - `int`"
  (^Integer [^javax.swing.JProgressBar this]
    (-> this (.getMinimum))))

(defn get-string
  "Returns a String representation of the current progress.
   By default, this returns a simple percentage String based on
   the value returned from getPercentComplete.  An example
   would be the `42%`.  You can change this by calling setString.

  returns: the value of the progress string, or a simple percentage string
           if the progress string is null - `java.lang.String`"
  (^java.lang.String [^javax.swing.JProgressBar this]
    (-> this (.getString))))

(defn get-ui-class-id
  "Returns the name of the look-and-feel class that renders this component.

  returns: the string `ProgressBarUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JProgressBar this]
    (-> this (.getUIClassID))))

(defn get-value
  "Returns the progress bar's current value
   from the BoundedRangeModel.
   The value is always between the
   minimum and maximum values, inclusive.

  returns: the current value of the progress bar - `int`"
  (^Integer [^javax.swing.JProgressBar this]
    (-> this (.getValue))))

(defn set-border-painted
  "Sets the borderPainted property, which is
   true if the progress bar should paint its border.
   The default value for this property is true.
   Some look and feels might not implement painted borders;
   they will ignore this property.

  b - true if the progress bar should paint its border; otherwise, false - `boolean`"
  ([^javax.swing.JProgressBar this ^Boolean b]
    (-> this (.setBorderPainted b))))

(defn remove-change-listener
  "Removes a ChangeListener from the progress bar.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^javax.swing.JProgressBar this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this progress bar with addChangeListener.

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^javax.swing.JProgressBar this]
    (-> this (.getChangeListeners))))

(defn set-ui
  "Sets the look-and-feel object that renders this component.

  ui - a ProgressBarUI object - `javax.swing.plaf.ProgressBarUI`"
  ([^javax.swing.JProgressBar this ^javax.swing.plaf.ProgressBarUI ui]
    (-> this (.setUI ui))))

(defn indeterminate?
  "Returns the value of the indeterminate property.

  returns: the value of the indeterminate property - `boolean`"
  (^Boolean [^javax.swing.JProgressBar this]
    (-> this (.isIndeterminate))))

(defn set-maximum
  "Sets the progress bar's maximum value
   (stored in the progress bar's data model) to n.

   The underlying BoundedRangeModel handles any mathematical
   issues arising from assigning faulty values.
   See the BoundedRangeModel documentation for details.

   If the maximum value is different from the previous maximum,
   all change listeners are notified.

  n - the new maximum - `int`"
  ([^javax.swing.JProgressBar this ^Integer n]
    (-> this (.setMaximum n))))

(defn set-indeterminate
  "Sets the indeterminate property of the progress bar,
   which determines whether the progress bar is in determinate
   or indeterminate mode.
   An indeterminate progress bar continuously displays animation
   indicating that an operation of unknown length is occurring.
   By default, this property is false.
   Some look and feels might not support indeterminate progress bars;
   they will ignore this property.



   See
   How to Monitor Progress
   for examples of using indeterminate progress bars.

  new-value - true if the progress bar should change to indeterminate mode; false if it should revert to normal. - `boolean`"
  ([^javax.swing.JProgressBar this ^Boolean new-value]
    (-> this (.setIndeterminate new-value))))

(defn get-ui
  "Returns the look-and-feel object that renders this component.

  returns: the ProgressBarUI object that renders this component - `javax.swing.plaf.ProgressBarUI`"
  (^javax.swing.plaf.ProgressBarUI [^javax.swing.JProgressBar this]
    (-> this (.getUI))))

(defn set-string-painted
  "Sets the value of the stringPainted property,
   which determines whether the progress bar
   should render a progress string.
   The default is false, meaning
   no string is painted.
   Some look and feels might not support progress strings
   or might support them only when the progress bar is in determinate mode.

  b - true if the progress bar should render a string - `boolean`"
  ([^javax.swing.JProgressBar this ^Boolean b]
    (-> this (.setStringPainted b))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JProgressBar. For progress bars, the
   AccessibleContext takes the form of an
   AccessibleJProgressBar.
   A new AccessibleJProgressBar instance is created if necessary.

  returns: an AccessibleJProgressBar that serves as the
           AccessibleContext of this JProgressBar - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JProgressBar this]
    (-> this (.getAccessibleContext))))

(defn set-value
  "Sets the progress bar's current value to n.  This method
   forwards the new value to the model.

   The data model (an instance of BoundedRangeModel)
   handles any mathematical
   issues arising from assigning faulty values.  See the
   BoundedRangeModel documentation for details.

   If the new value is different from the previous value,
   all change listeners are notified.

  n - the new value - `int`"
  ([^javax.swing.JProgressBar this ^Integer n]
    (-> this (.setValue n))))

(defn set-orientation
  "Sets the progress bar's orientation to newOrientation,
   which must be SwingConstants.VERTICAL or
   SwingConstants.HORIZONTAL. The default orientation
   is SwingConstants.HORIZONTAL.

  new-orientation - HORIZONTAL or VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if newOrientation is an illegal value"
  ([^javax.swing.JProgressBar this ^Integer new-orientation]
    (-> this (.setOrientation new-orientation))))

(defn border-painted?
  "Returns the borderPainted property.

  returns: the value of the borderPainted property - `boolean`"
  (^Boolean [^javax.swing.JProgressBar this]
    (-> this (.isBorderPainted))))

(defn get-model
  "Returns the data model used by this progress bar.

  returns: the BoundedRangeModel currently in use - `javax.swing.BoundedRangeModel`"
  (^javax.swing.BoundedRangeModel [^javax.swing.JProgressBar this]
    (-> this (.getModel))))

(defn set-minimum
  "Sets the progress bar's minimum value
   (stored in the progress bar's data model) to n.

   The data model (a BoundedRangeModel instance)
   handles any mathematical
   issues arising from assigning faulty values.
   See the BoundedRangeModel documentation for details.

   If the minimum value is different from the previous minimum,
   all change listeners are notified.

  n - the new minimum - `int`"
  ([^javax.swing.JProgressBar this ^Integer n]
    (-> this (.setMinimum n))))

(defn get-maximum
  "Returns the progress bar's maximum value
   from the BoundedRangeModel.

  returns: the progress bar's maximum value - `int`"
  (^Integer [^javax.swing.JProgressBar this]
    (-> this (.getMaximum))))

(defn set-model
  "Sets the data model used by the JProgressBar.
   Note that the BoundedRangeModel's extent is not used,
   and is set to 0.

  new-model - the BoundedRangeModel to use - `javax.swing.BoundedRangeModel`"
  ([^javax.swing.JProgressBar this ^javax.swing.BoundedRangeModel new-model]
    (-> this (.setModel new-model))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JProgressBar this]
    (-> this (.updateUI))))

