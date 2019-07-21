(ns javax.sound.sampled.Line
  "The Line interface represents a mono or multi-channel
  audio feed. A line is an element of the digital audio
  \"pipeline,\" such as a mixer, an input or output port,
  or a data path into or out of a mixer.

  A line can have controls, such as gain, pan, and reverb.
  The controls themselves are instances of classes that extend the
  base Control class.
  The Line interface provides two accessor methods for
  obtaining the line's controls: getControls returns the
  entire set, and getControl returns a single control of
  specified type.

  Lines exist in various states at different times.  When a line opens, it reserves system
  resources for itself, and when it closes, these resources are freed for
  other objects or applications. The isOpen() method lets
  you discover whether a line is open or closed.
  An open line need not be processing data, however.  Such processing is
  typically initiated by subinterface methods such as
  SourceDataLine.write and
  TargetDataLine.read.

  You can register an object to receive notifications whenever the line's
  state changes.  The object must implement the LineListener
  interface, which consists of the single method
  update.
  This method will be invoked when a line opens and closes (and, if it's a
  DataLine, when it starts and stops).

  An object can be registered to listen to multiple lines.  The event it
  receives in its update method will specify which line created
  the event, what type of event it was
  (OPEN, CLOSE, START, or STOP),
  and how many sample frames the line had processed at the time the event occurred.

  Certain line operations, such as open and close, can generate security
  exceptions if invoked by unprivileged code when the line is a shared audio
  resource."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Line]))

(defn add-line-listener
  "Adds a listener to this line.  Whenever the line's status changes, the
   listener's update() method is called with a LineEvent object
   that describes the change.

  listener - the object to add as a listener to this line - `javax.sound.sampled.LineListener`"
  ([^Line this ^javax.sound.sampled.LineListener listener]
    (-> this (.addLineListener listener))))

(defn get-controls
  "Obtains the set of controls associated with this line.
   Some controls may only be available when the line is open.
   If there are no controls, this method returns an array of length 0.

  returns: the array of controls - `javax.sound.sampled.Control[]`"
  ([^Line this]
    (-> this (.getControls))))

(defn get-control
  "Obtains a control of the specified type,
   if there is any.
   Some controls may only be available when the line is open.

  control - the type of the requested control - `javax.sound.sampled.Control$Type`

  returns: a control of the specified type - `javax.sound.sampled.Control`

  throws: java.lang.IllegalArgumentException - if a control of the specified type is not supported"
  (^javax.sound.sampled.Control [^Line this ^javax.sound.sampled.Control$Type control]
    (-> this (.getControl control))))

(defn control-supported?
  "Indicates whether the line supports a control of the specified type.
   Some controls may only be available when the line is open.

  control - the type of the control for which support is queried - `javax.sound.sampled.Control$Type`

  returns: true if at least one control of the specified type is
   supported, otherwise false. - `boolean`"
  (^Boolean [^Line this ^javax.sound.sampled.Control$Type control]
    (-> this (.isControlSupported control))))

(defn close
  "Closes the line, indicating that any system resources
   in use by the line can be released.  If this operation
   succeeds, the line is marked closed and a CLOSE event is dispatched
   to the line's listeners.

  throws: java.lang.SecurityException - if the line cannot be closed due to security restrictions."
  ([^Line this]
    (-> this (.close))))

(defn remove-line-listener
  "Removes the specified listener from this line's list of listeners.

  listener - listener to remove - `javax.sound.sampled.LineListener`"
  ([^Line this ^javax.sound.sampled.LineListener listener]
    (-> this (.removeLineListener listener))))

(defn open?
  "Indicates whether the line is open, meaning that it has reserved
   system resources and is operational, although it might not currently be
   playing or capturing sound.

  returns: true if the line is open, otherwise false - `boolean`"
  (^Boolean [^Line this]
    (-> this (.isOpen))))

(defn open
  "Opens the line, indicating that it should acquire any required
   system resources and become operational.
   If this operation
   succeeds, the line is marked as open, and an OPEN event is dispatched
   to the line's listeners.

   Note that some lines, once closed, cannot be reopened.  Attempts
   to reopen such a line will always result in an LineUnavailableException.

   Some types of lines have configurable properties that may affect
   resource allocation.   For example, a DataLine must
   be opened with a particular format and buffer size.  Such lines
   should provide a mechanism for configuring these properties, such
   as an additional open method or methods which allow
   an application to specify the desired settings.

   This method takes no arguments, and opens the line with the current
   settings.  For SourceDataLine and
   TargetDataLine objects, this means that the line is
   opened with default settings.  For a Clip, however,
   the buffer size is determined when data is loaded.  Since this method does not
   allow the application to specify any data to load, an IllegalArgumentException
   is thrown. Therefore, you should instead use one of the open methods
   provided in the Clip interface to load data into the Clip.

   For DataLine's, if the DataLine.Info
   object which was used to retrieve the line, specifies at least
   one fully qualified audio format, the last one will be used
   as the default format.

  throws: java.lang.IllegalArgumentException - if this method is called on a Clip instance."
  ([^Line this]
    (-> this (.open))))

(defn get-line-info
  "Obtains the Line.Info object describing this
   line.

  returns: description of the line - `javax.sound.sampled.Line$Info`"
  (^javax.sound.sampled.Line$Info [^Line this]
    (-> this (.getLineInfo))))

