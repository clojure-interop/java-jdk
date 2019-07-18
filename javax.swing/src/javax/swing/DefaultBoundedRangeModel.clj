(ns javax.swing.DefaultBoundedRangeModel
  "A generic implementation of BoundedRangeModel.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultBoundedRangeModel]))

(defn ->default-bounded-range-model
  "Constructor.

  Initializes value, extent, minimum and maximum. Adjusting is false.
   Throws an IllegalArgumentException if the following
   constraints aren't satisfied:


   min <= value <= value+extent <= max

  value - `int`
  extent - `int`
  min - `int`
  max - `int`"
  (^DefaultBoundedRangeModel [^Integer value ^Integer extent ^Integer min ^Integer max]
    (new DefaultBoundedRangeModel value extent min max))
  (^DefaultBoundedRangeModel []
    (new DefaultBoundedRangeModel )))

(defn add-change-listener
  "Adds a ChangeListener.  The change listeners are run each
   time any one of the Bounded Range model properties changes.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^DefaultBoundedRangeModel this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn get-value-is-adjusting?
  "Returns true if the value is in the process of changing
   as a result of actions being taken by the user.

  returns: the value of the valueIsAdjusting property - `boolean`"
  (^Boolean [^DefaultBoundedRangeModel this]
    (-> this (.getValueIsAdjusting))))

(defn get-minimum
  "Returns the model's minimum.

  returns: the model's minimum - `int`"
  (^Integer [^DefaultBoundedRangeModel this]
    (-> this (.getMinimum))))

(defn get-extent
  "Returns the model's extent.

  returns: the model's extent - `int`"
  (^Integer [^DefaultBoundedRangeModel this]
    (-> this (.getExtent))))

(defn set-extent
  "Sets the extent to n after ensuring that n
   is greater than or equal to zero and falls within the model's
   constraints:


       minimum <= value <= value+extent <= maximum

  n - the model's new extent - `int`"
  ([^DefaultBoundedRangeModel this ^Integer n]
    (-> this (.setExtent n))))

(defn to-string
  "Returns a string that displays all of the
   BoundedRangeModel properties.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^DefaultBoundedRangeModel this]
    (-> this (.toString))))

(defn get-value
  "Returns the model's current value.

  returns: the model's current value - `int`"
  (^Integer [^DefaultBoundedRangeModel this]
    (-> this (.getValue))))

(defn remove-change-listener
  "Removes a ChangeListener.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^DefaultBoundedRangeModel this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the change listeners
   registered on this DefaultBoundedRangeModel.

  returns: all of this model's ChangeListeners
           or an empty
           array if no change listeners are currently registered - `javax.swing.event.ChangeListener[]`"
  ([^DefaultBoundedRangeModel this]
    (-> this (.getChangeListeners))))

(defn set-maximum
  "Sets the maximum to n after ensuring that n
   that the other three properties obey the model's constraints:


       minimum <= value <= value+extent <= maximum

  n - the model's new maximum - `int`"
  ([^DefaultBoundedRangeModel this ^Integer n]
    (-> this (.setMaximum n))))

(defn set-range-properties
  "Sets all of the BoundedRangeModel properties after forcing
   the arguments to obey the usual constraints:


       minimum <= value <= value+extent <= maximum

   At most, one ChangeEvent is generated.

  new-value - an int giving the current value - `int`
  new-extent - an int giving the amount by which the value can `jump` - `int`
  new-min - an int giving the minimum value - `int`
  new-max - an int giving the maximum value - `int`
  adjusting - a boolean, true if a series of changes are in progress - `boolean`"
  ([^DefaultBoundedRangeModel this ^Integer new-value ^Integer new-extent ^Integer new-min ^Integer new-max ^Boolean adjusting]
    (-> this (.setRangeProperties new-value new-extent new-min new-max adjusting))))

(defn set-value-is-adjusting
  "Sets the valueIsAdjusting property.

  b - true if the upcoming changes to the value property are part of a series - `boolean`"
  ([^DefaultBoundedRangeModel this ^Boolean b]
    (-> this (.setValueIsAdjusting b))))

(defn set-value
  "Sets the current value of the model. For a slider, that
   determines where the knob appears. Ensures that the new
   value, n falls within the model's constraints:


       minimum <= value <= value+extent <= maximum

  n - the model's new value - `int`"
  ([^DefaultBoundedRangeModel this ^Integer n]
    (-> this (.setValue n))))

(defn get-listeners
  "Returns an array of all the objects currently registered as
   FooListeners
   upon this model.
   FooListeners
   are registered using the addFooListener method.

   You can specify the listenerType argument
   with a class literal, such as FooListener.class.
   For example, you can query a DefaultBoundedRangeModel
   instance m
   for its change listeners
   with the following code:



  ChangeListener[] cls = (ChangeListener[])(m.getListeners(ChangeListener.class));

   If no such listeners exist,
   this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners
            on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^DefaultBoundedRangeModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn set-minimum
  "Sets the minimum to n after ensuring that n
   that the other three properties obey the model's constraints:


       minimum <= value <= value+extent <= maximum

  n - the model's new minimum - `int`"
  ([^DefaultBoundedRangeModel this ^Integer n]
    (-> this (.setMinimum n))))

(defn get-maximum
  "Returns the model's maximum.

  returns: the model's maximum - `int`"
  (^Integer [^DefaultBoundedRangeModel this]
    (-> this (.getMaximum))))

