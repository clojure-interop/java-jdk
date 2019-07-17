(ns javax.swing.BoundedRangeModel
  "Defines the data model used by components like Sliders
  and ProgressBars.
  Defines four interrelated integer properties: minimum, maximum, extent
  and value.  These four integers define two nested ranges like this:


  minimum <= value <= value+extent <= maximum
  The outer range is minimum,maximum and the inner
  range is value,value+extent.  The inner range
  must lie within the outer one, i.e. value must be
  less than or equal to maximum and value+extent
  must greater than or equal to minimum, and maximum
  must be greater than or equal to minimum.
  There are a few features of this model that one might find a little
  surprising.  These quirks exist for the convenience of the
  Swing BoundedRangeModel clients, such as Slider and
  ScrollBar.


    The minimum and maximum set methods `correct` the other
    three properties to accommodate their new value argument.  For
    example setting the model's minimum may change its maximum, value,
    and extent properties (in that order), to maintain the constraints
    specified above.


    The value and extent set methods `correct` their argument to
    fit within the limits defined by the other three properties.
    For example if value == maximum, setExtent(10)
    would change the extent (back) to zero.


    The four BoundedRangeModel values are defined as Java Beans properties
    however Swing ChangeEvents are used to notify clients of changes rather
    than PropertyChangeEvents. This was done to keep the overhead of monitoring
    a BoundedRangeModel low. Changes are often reported at MouseDragged rates.




  For an example of specifying custom bounded range models used by sliders,
  see Separable model architecture
  in A Swing Architecture Overview."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing BoundedRangeModel]))

(defn add-change-listener
  "Adds a ChangeListener to the model's listener list.

  x - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener x]
    (-> this (.addChangeListener x))))

(defn get-value-is-adjusting?
  "Returns true if the current changes to the value property are part
   of a series of changes.

  returns: the valueIsAdjustingProperty. - `boolean`"
  ([^. this]
    (-> this (.getValueIsAdjusting))))

(defn get-minimum
  "Returns the minimum acceptable value.

  returns: the value of the minimum property - `int`"
  ([^. this]
    (-> this (.getMinimum))))

(defn get-extent
  "Returns the model's extent, the length of the inner range that
   begins at the model's value.

  returns: the value of the model's extent property - `int`"
  ([^. this]
    (-> this (.getExtent))))

(defn set-extent
  "Sets the model's extent.  The newExtent is forced to
   be greater than or equal to zero and less than or equal to
   maximum - value.

   When a BoundedRange model is used with a scrollbar the extent
   defines the length of the scrollbar knob (aka the `thumb` or
   `elevator`).  The extent usually represents how much of the
   object being scrolled is visible. When used with a slider,
   the extent determines how much the value can `jump`, for
   example when the user presses PgUp or PgDn.

   Notifies any listeners if the model changes.

  new-extent - the model's new extent - `int`"
  ([^. this ^Integer new-extent]
    (-> this (.setExtent new-extent))))

(defn get-value
  "Returns the model's current value.  Note that the upper
   limit on the model's value is maximum - extent
   and the lower limit is minimum.

  returns: the model's value - `int`"
  ([^. this]
    (-> this (.getValue))))

(defn remove-change-listener
  "Removes a ChangeListener from the model's listener list.

  x - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener x]
    (-> this (.removeChangeListener x))))

(defn set-maximum
  "Sets the model's maximum to newMaximum. The other
   three properties may be changed as well, to ensure that


   minimum <= value <= value+extent <= maximum

   Notifies any listeners if the model changes.

  new-maximum - the model's new maximum - `int`"
  ([^. this ^Integer new-maximum]
    (-> this (.setMaximum new-maximum))))

(defn set-range-properties
  "This method sets all of the model's data with a single method call.
   The method results in a single change event being generated. This is
   convenient when you need to adjust all the model data simultaneously and
   do not want individual change events to occur.

  value - an int giving the current value - `int`
  extent - an int giving the amount by which the value can `jump` - `int`
  min - an int giving the minimum value - `int`
  max - an int giving the maximum value - `int`
  adjusting - a boolean, true if a series of changes are in progress - `boolean`"
  ([^. this ^Integer value ^Integer extent ^Integer min ^Integer max ^Boolean adjusting]
    (-> this (.setRangeProperties value extent min max adjusting))))

(defn set-value-is-adjusting
  "This attribute indicates that any upcoming changes to the value
   of the model should be considered a single event. This attribute
   will be set to true at the start of a series of changes to the value,
   and will be set to false when the value has finished changing.  Normally
   this allows a listener to only take action when the final value change in
   committed, instead of having to do updates for all intermediate values.

   Sliders and scrollbars use this property when a drag is underway.

  b - true if the upcoming changes to the value property are part of a series - `boolean`"
  ([^. this ^Boolean b]
    (-> this (.setValueIsAdjusting b))))

(defn set-value
  "Sets the model's current value to newValue if newValue
   satisfies the model's constraints. Those constraints are:


   minimum <= value <= value+extent <= maximum
   Otherwise, if newValue is less than minimum
   it's set to minimum, if its greater than
   maximum then it's set to maximum, and
   if it's greater than value+extent then it's set to
   value+extent.

   When a BoundedRange model is used with a scrollbar the value
   specifies the origin of the scrollbar knob (aka the `thumb` or
   `elevator`).  The value usually represents the origin of the
   visible part of the object being scrolled.

   Notifies any listeners if the model changes.

  new-value - the model's new value - `int`"
  ([^. this ^Integer new-value]
    (-> this (.setValue new-value))))

(defn set-minimum
  "Sets the model's minimum to newMinimum.   The
   other three properties may be changed as well, to ensure
   that:


   minimum <= value <= value+extent <= maximum

   Notifies any listeners if the model changes.

  new-minimum - the model's new minimum - `int`"
  ([^. this ^Integer new-minimum]
    (-> this (.setMinimum new-minimum))))

(defn get-maximum
  "Returns the model's maximum.  Note that the upper
   limit on the model's value is (maximum - extent).

  returns: the value of the maximum property. - `int`"
  ([^. this]
    (-> this (.getMaximum))))

