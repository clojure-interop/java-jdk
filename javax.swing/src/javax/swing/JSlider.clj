(ns javax.swing.JSlider
  "A component that lets the user graphically select a value by sliding
  a knob within a bounded interval. The knob is always positioned
  at the points that match integer values within the specified interval.

  The slider can show both
  major tick marks, and minor tick marks between the major ones.  The number of
  values between the tick marks is controlled with
  setMajorTickSpacing and setMinorTickSpacing.
  Painting of tick marks is controlled by setPaintTicks.

  Sliders can also print text labels at regular intervals (or at
  arbitrary locations) along the slider track.  Painting of labels is
  controlled by setLabelTable and setPaintLabels.

  For further information and examples see
  How to Use Sliders,
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
  (:import [javax.swing JSlider]))

(defn ->j-slider
  "Constructor.

  Creates a slider with the specified orientation and the
   specified minimum, maximum, and initial values.
   The orientation can be
   either SwingConstants.VERTICAL or
   SwingConstants.HORIZONTAL.

   The BoundedRangeModel that holds the slider's data
   handles any issues that may arise from improperly setting the
   minimum, initial, and maximum values on the slider.  See the
   BoundedRangeModel documentation for details.

  orientation - the orientation of the slider - `int`
  min - the minimum value of the slider - `int`
  max - the maximum value of the slider - `int`
  value - the initial value of the slider - `int`

  throws: java.lang.IllegalArgumentException - if orientation is not one of VERTICAL, HORIZONTAL"
  (^JSlider [^Integer orientation ^Integer min ^Integer max ^Integer value]
    (new JSlider orientation min max value))
  (^JSlider [^Integer min ^Integer max ^Integer value]
    (new JSlider min max value))
  (^JSlider [^Integer min ^Integer max]
    (new JSlider min max))
  (^JSlider [^Integer orientation]
    (new JSlider orientation))
  (^JSlider []
    (new JSlider )))

(defn set-minor-tick-spacing
  "This method sets the minor tick spacing.  The number that is passed in
   represents the distance, measured in values, between each minor tick mark.
   If you have a slider with a range from 0 to 50 and the minor tick spacing
   is set to 10, you will get minor ticks next to the following values:
   0, 10, 20, 30, 40, 50.

   In order for minor ticks to be painted, setPaintTicks must be
   set to true.

  n - new value for the minorTickSpacing property - `int`"
  ([^JSlider this ^Integer n]
    (-> this (.setMinorTickSpacing n))))

(defn add-change-listener
  "Adds a ChangeListener to the slider.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^JSlider this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn get-value-is-adjusting?
  "Returns the valueIsAdjusting property from the model.  For
   details on how this is used, see the setValueIsAdjusting
   documentation.

  returns: the value of the model's valueIsAdjusting property - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getValueIsAdjusting))))

(defn get-orientation
  "Return this slider's vertical or horizontal orientation.

  returns: SwingConstants.VERTICAL or
    SwingConstants.HORIZONTAL - `int`"
  (^Integer [^JSlider this]
    (-> this (.getOrientation))))

(defn get-snap-to-ticks?
  "Returns true if the knob (and the data value it represents)
   resolve to the closest tick mark next to where the user
   positioned the knob.

  returns: true if the value snaps to the nearest tick mark, else false - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getSnapToTicks))))

(defn get-minimum
  "Returns the minimum value supported by the slider
   from the BoundedRangeModel.

  returns: the value of the model's minimum property - `int`"
  (^Integer [^JSlider this]
    (-> this (.getMinimum))))

(defn set-inverted
  "Specify true to reverse the value-range shown for the slider and false to
   put the value range in the normal order.  The order depends on the
   slider's ComponentOrientation property.  Normal (non-inverted)
   horizontal sliders with a ComponentOrientation value of
   LEFT_TO_RIGHT have their maximum on the right.
   Normal horizontal sliders with a ComponentOrientation value of
   RIGHT_TO_LEFT have their maximum on the left.  Normal vertical
   sliders have their maximum on the top.  These labels are reversed when the
   slider is inverted.

   By default, the value of this property is false.

  b - true to reverse the slider values from their normal order - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setInverted b))))

(defn get-minor-tick-spacing
  "This method returns the minor tick spacing.  The number that is returned
   represents the distance, measured in values, between each minor tick mark.
   If you have a slider with a range from 0 to 50 and the minor tick spacing
   is set to 10, you will get minor ticks next to the following values:
   0, 10, 20, 30, 40, 50.

  returns: the number of values between minor ticks - `int`"
  (^Integer [^JSlider this]
    (-> this (.getMinorTickSpacing))))

(defn create-standard-labels
  "Creates a Hashtable of numerical text labels, starting at the
   starting point specified, and using the increment specified.
   For example, if you call
   createStandardLabels( 10, 2 ),
   then labels will be created for the values 2, 12, 22, 32, and so on.

   For the labels to be drawn on the slider, the returned Hashtable
   must be passed into setLabelTable, and setPaintLabels
   must be set to true.

   For further details on the makeup of the returned Hashtable, see
   the setLabelTable documentation.

  increment - distance between labels in the generated hashtable - `int`
  start - value at which the labels will begin - `int`

  returns: a new Hashtable of labels - `java.util.Hashtable`

  throws: java.lang.IllegalArgumentException - if start is out of range, or if increment is less than or equal to zero"
  (^java.util.Hashtable [^JSlider this ^Integer increment ^Integer start]
    (-> this (.createStandardLabels increment start)))
  (^java.util.Hashtable [^JSlider this ^Integer increment]
    (-> this (.createStandardLabels increment))))

(defn get-extent
  "Returns the \"extent\" from the BoundedRangeModel.
   This represents the range of values \"covered\" by the knob.

  returns: an int representing the extent - `int`"
  (^Integer [^JSlider this]
    (-> this (.getExtent))))

(defn set-extent
  "Sets the size of the range \"covered\" by the knob.  Most look
   and feel implementations will change the value by this amount
   if the user clicks on either side of the knob.  This method just
   forwards the new extent value to the model.

   The data model (an instance of BoundedRangeModel)
   handles any mathematical
   issues arising from assigning faulty values.  See the
   BoundedRangeModel documentation for details.

   If the new extent value is different from the previous extent value,
   all change listeners are notified.

  extent - the new extent - `int`"
  ([^JSlider this ^Integer extent]
    (-> this (.setExtent extent))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: \"SliderUI\" - `java.lang.String`"
  (^java.lang.String [^JSlider this]
    (-> this (.getUIClassID))))

(defn get-value
  "Returns the slider's current value
   from the BoundedRangeModel.

  returns: the current value of the slider - `int`"
  (^Integer [^JSlider this]
    (-> this (.getValue))))

(defn remove-change-listener
  "Removes a ChangeListener from the slider.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^JSlider this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this JSlider with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^JSlider this]
    (-> this (.getChangeListeners))))

(defn get-label-table
  "Returns the dictionary of what labels to draw at which values.

  returns: the Dictionary containing labels and
      where to draw them - `java.util.Dictionary`"
  (^java.util.Dictionary [^JSlider this]
    (-> this (.getLabelTable))))

(defn set-paint-labels
  "Determines whether labels are painted on the slider.

   This method will also set up a label table for you.
   If there is not already a label table, and the major tick spacing is
   > 0,
   a standard label table will be generated (by calling
   createStandardLabels) with labels at the major tick marks.
   The label table is then set on the slider by calling
   setLabelTable.

   By default, this property is false.

  b - whether or not to paint labels - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setPaintLabels b))))

(defn set-ui
  "Sets the UI object which implements the L&F for this component.

  ui - the SliderUI L&F object - `javax.swing.plaf.SliderUI`"
  ([^JSlider this ^javax.swing.plaf.SliderUI ui]
    (-> this (.setUI ui))))

(defn get-paint-ticks?
  "Tells if tick marks are to be painted.

  returns: true if tick marks are painted, else false - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getPaintTicks))))

(defn set-maximum
  "Sets the slider's maximum value to maximum.  This method
   forwards the new maximum value to the model.

   The data model (an instance of BoundedRangeModel)
   handles any mathematical
   issues arising from assigning faulty values.  See the
   BoundedRangeModel documentation for details.

   If the new maximum value is different from the previous maximum value,
   all change listeners are notified.

  maximum - the new maximum - `int`"
  ([^JSlider this ^Integer maximum]
    (-> this (.setMaximum maximum))))

(defn set-paint-ticks
  "Determines whether tick marks are painted on the slider.
   By default, this property is false.

  b - whether or not tick marks should be painted - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setPaintTicks b))))

(defn get-ui
  "Gets the UI object which implements the L&F for this component.

  returns: the SliderUI object that implements the Slider L&F - `javax.swing.plaf.SliderUI`"
  (^javax.swing.plaf.SliderUI [^JSlider this]
    (-> this (.getUI))))

(defn set-value-is-adjusting
  "Sets the model's valueIsAdjusting property.  Slider look and
   feel implementations should set this property to true when
   a knob drag begins, and to false when the drag ends.

  b - the new value for the valueIsAdjusting property - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setValueIsAdjusting b))))

(defn set-font
  "Sets the font for this component.

  font - the desired Font for this component - `java.awt.Font`"
  ([^JSlider this ^java.awt.Font font]
    (-> this (.setFont font))))

(defn get-paint-track?
  "Tells if the track (area the slider slides in) is to be painted.

  returns: true if track is painted, else false - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getPaintTrack))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JSlider.
   For sliders, the AccessibleContext takes the form of an
   AccessibleJSlider.
   A new AccessibleJSlider instance is created if necessary.

  returns: an AccessibleJSlider that serves as the
           AccessibleContext of this JSlider - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JSlider this]
    (-> this (.getAccessibleContext))))

(defn set-value
  "Sets the slider's current value to n.  This method
   forwards the new value to the model.

   The data model (an instance of BoundedRangeModel)
   handles any mathematical
   issues arising from assigning faulty values.  See the
   BoundedRangeModel documentation for details.

   If the new value is different from the previous value,
   all change listeners are notified.

  n - the new value - `int`"
  ([^JSlider this ^Integer n]
    (-> this (.setValue n))))

(defn image-update
  "Repaints the component when the image has changed.
   This imageUpdate method of an ImageObserver
   is called when more information about an
   image which had been previously requested using an asynchronous
   routine such as the drawImage method of
   Graphics becomes available.
   See the definition of imageUpdate for
   more information on this method and its arguments.

   The imageUpdate method of Component
   incrementally draws an image on the component as more of the bits
   of the image are available.

   If the system property awt.image.incrementaldraw
   is missing or has the value true, the image is
   incrementally drawn. If the system property has any other value,
   then the image is not drawn until it has been completely loaded.

   Also, if incremental drawing is in effect, the value of the
   system property awt.image.redrawrate is interpreted
   as an integer to give the maximum redraw rate, in milliseconds. If
   the system property is missing or cannot be interpreted as an
   integer, the redraw rate is once every 100ms.

   The interpretation of the x, y,
   width, and height arguments depends on
   the value of the infoflags argument.

  img - the image being observed - `java.awt.Image`
  infoflags - see imageUpdate for more information - `int`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  w - the width - `int`
  h - the height - `int`

  returns: false if the infoflags indicate that the
              image is completely loaded; true otherwise. - `boolean`"
  (^Boolean [^JSlider this ^java.awt.Image img ^Integer infoflags ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.imageUpdate img infoflags x y w h))))

(defn set-orientation
  "Set the slider's orientation to either SwingConstants.VERTICAL or
   SwingConstants.HORIZONTAL.

  orientation - HORIZONTAL or VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if orientation is not one of VERTICAL, HORIZONTAL"
  ([^JSlider this ^Integer orientation]
    (-> this (.setOrientation orientation))))

(defn get-major-tick-spacing
  "This method returns the major tick spacing.  The number that is returned
   represents the distance, measured in values, between each major tick mark.
   If you have a slider with a range from 0 to 50 and the major tick spacing
   is set to 10, you will get major ticks next to the following values:
   0, 10, 20, 30, 40, 50.

  returns: the number of values between major ticks - `int`"
  (^Integer [^JSlider this]
    (-> this (.getMajorTickSpacing))))

(defn set-label-table
  "Used to specify what label will be drawn at any given value.
   The key-value pairs are of this format:
   { Integer value, java.swing.JComponent label }.

   An easy way to generate a standard table of value labels is by using the
   createStandardLabels method.

   Once the labels have been set, this method calls updateLabelUIs().
   Note that the labels are only painted if the paintLabels
   property is true.

  labels - new Dictionary of labels, or null to remove all labels - `java.util.Dictionary`"
  ([^JSlider this ^java.util.Dictionary labels]
    (-> this (.setLabelTable labels))))

(defn set-paint-track
  "Determines whether the track is painted on the slider.
   By default, this property is true.

  b - whether or not to paint the slider track - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setPaintTrack b))))

(defn get-paint-labels?
  "Tells if labels are to be painted.

  returns: true if labels are painted, else false - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getPaintLabels))))

(defn get-model
  "Returns the BoundedRangeModel that handles the slider's three
   fundamental properties: minimum, maximum, value.

  returns: the data model for this component - `javax.swing.BoundedRangeModel`"
  (^javax.swing.BoundedRangeModel [^JSlider this]
    (-> this (.getModel))))

(defn set-minimum
  "Sets the slider's minimum value to minimum.  This method
   forwards the new minimum value to the model.

   The data model (an instance of BoundedRangeModel)
   handles any mathematical
   issues arising from assigning faulty values.  See the
   BoundedRangeModel documentation for details.

   If the new minimum value is different from the previous minimum value,
   all change listeners are notified.

  minimum - the new minimum - `int`"
  ([^JSlider this ^Integer minimum]
    (-> this (.setMinimum minimum))))

(defn set-snap-to-ticks
  "Specifying true makes the knob (and the data value it represents)
   resolve to the closest tick mark next to where the user
   positioned the knob.
   By default, this property is false.

  b - true to snap the knob to the nearest tick mark - `boolean`"
  ([^JSlider this ^Boolean b]
    (-> this (.setSnapToTicks b))))

(defn get-maximum
  "Returns the maximum value supported by the slider
   from the BoundedRangeModel.

  returns: the value of the model's maximum property - `int`"
  (^Integer [^JSlider this]
    (-> this (.getMaximum))))

(defn set-major-tick-spacing
  "This method sets the major tick spacing.  The number that is passed in
   represents the distance, measured in values, between each major tick mark.
   If you have a slider with a range from 0 to 50 and the major tick spacing
   is set to 10, you will get major ticks next to the following values:
   0, 10, 20, 30, 40, 50.

   In order for major ticks to be painted, setPaintTicks must be
   set to true.

   This method will also set up a label table for you.
   If there is not already a label table, and the major tick spacing is
   > 0, and getPaintLabels returns
   true, a standard label table will be generated (by calling
   createStandardLabels) with labels at the major tick marks.
   For the example above, you would get text labels: \"0\",
   \"10\", \"20\", \"30\", \"40\", \"50\".
   The label table is then set on the slider by calling
   setLabelTable.

  n - new value for the majorTickSpacing property - `int`"
  ([^JSlider this ^Integer n]
    (-> this (.setMajorTickSpacing n))))

(defn set-model
  "Sets the BoundedRangeModel that handles the slider's three
   fundamental properties: minimum, maximum, value.

   Attempts to pass a null model to this method result in
   undefined behavior, and, most likely, exceptions.

  new-model - the new, non-null BoundedRangeModel to use - `javax.swing.BoundedRangeModel`"
  ([^JSlider this ^javax.swing.BoundedRangeModel new-model]
    (-> this (.setModel new-model))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^JSlider this]
    (-> this (.updateUI))))

(defn get-inverted?
  "Returns true if the value-range shown for the slider is reversed,

  returns: true if the slider values are reversed from their normal order - `boolean`"
  (^Boolean [^JSlider this]
    (-> this (.getInverted))))

