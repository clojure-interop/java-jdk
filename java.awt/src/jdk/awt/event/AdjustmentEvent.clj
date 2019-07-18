(ns jdk.awt.event.AdjustmentEvent
  "The adjustment event emitted by Adjustable objects like
  Scrollbar and ScrollPane.
  When the user changes the value of the scrolling component,
  it receives an instance of AdjustmentEvent.

  An unspecified behavior will be caused if the id parameter
  of any particular AdjustmentEvent instance is not
  in the range from ADJUSTMENT_FIRST to ADJUSTMENT_LAST.

  The type of any AdjustmentEvent instance takes one of the following
  values:

                       UNIT_INCREMENT
                       UNIT_DECREMENT
                       BLOCK_INCREMENT
                       BLOCK_DECREMENT
                       TRACK

  Assigning the value different from listed above will cause an unspecified behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event AdjustmentEvent]))

(defn ->adjustment-event
  "Constructor.

  Constructs an AdjustmentEvent object with the
   specified Adjustable source, event type, adjustment type, and value.
    This method throws an
   IllegalArgumentException if source
   is null.

  source - The Adjustable object where the event originated - `java.awt.Adjustable`
  id - An integer indicating the type of event. For information on allowable values, see the class description for AdjustmentEvent - `int`
  type - An integer indicating the adjustment type. For information on allowable values, see the class description for AdjustmentEvent - `int`
  value - The current value of the adjustment - `int`
  is-adjusting - A boolean that equals true if the event is one of a series of multiple adjusting events, otherwise false - `boolean`

  throws: java.lang.IllegalArgumentException - if source is null"
  (^AdjustmentEvent [^java.awt.Adjustable source ^Integer id ^Integer type ^Integer value ^Boolean is-adjusting]
    (new AdjustmentEvent source id type value is-adjusting))
  (^AdjustmentEvent [^java.awt.Adjustable source ^Integer id ^Integer type ^Integer value]
    (new AdjustmentEvent source id type value)))

(def *-adjustment-first
  "Static Constant.

  Marks the first integer id for the range of adjustment event ids.

  type: int"
  AdjustmentEvent/ADJUSTMENT_FIRST)

(def *-adjustment-last
  "Static Constant.

  Marks the last integer id for the range of adjustment event ids.

  type: int"
  AdjustmentEvent/ADJUSTMENT_LAST)

(def *-adjustment-value-changed
  "Static Constant.

  The adjustment value changed event.

  type: int"
  AdjustmentEvent/ADJUSTMENT_VALUE_CHANGED)

(def *-unit-increment
  "Static Constant.

  The unit increment adjustment type.

  type: int"
  AdjustmentEvent/UNIT_INCREMENT)

(def *-unit-decrement
  "Static Constant.

  The unit decrement adjustment type.

  type: int"
  AdjustmentEvent/UNIT_DECREMENT)

(def *-block-decrement
  "Static Constant.

  The block decrement adjustment type.

  type: int"
  AdjustmentEvent/BLOCK_DECREMENT)

(def *-block-increment
  "Static Constant.

  The block increment adjustment type.

  type: int"
  AdjustmentEvent/BLOCK_INCREMENT)

(def *-track
  "Static Constant.

  The absolute tracking adjustment type.

  type: int"
  AdjustmentEvent/TRACK)

(defn get-adjustable
  "Returns the Adjustable object where this event originated.

  returns: the Adjustable object where this event originated - `java.awt.Adjustable`"
  (^java.awt.Adjustable [^AdjustmentEvent this]
    (-> this (.getAdjustable))))

(defn get-value
  "Returns the current value in the adjustment event.

  returns: the current value in the adjustment event - `int`"
  (^Integer [^AdjustmentEvent this]
    (-> this (.getValue))))

(defn get-adjustment-type
  "Returns the type of adjustment which caused the value changed
   event.  It will have one of the following values:

   UNIT_INCREMENT
   UNIT_DECREMENT
   BLOCK_INCREMENT
   BLOCK_DECREMENT
   TRACK

  returns: one of the adjustment values listed above - `int`"
  (^Integer [^AdjustmentEvent this]
    (-> this (.getAdjustmentType))))

(defn get-value-is-adjusting?
  "Returns true if this is one of multiple
   adjustment events.

  returns: true if this is one of multiple
           adjustment events, otherwise returns false - `boolean`"
  (^Boolean [^AdjustmentEvent this]
    (-> this (.getValueIsAdjusting))))

(defn param-string
  "Description copied from class: AWTEvent

  returns: a string representation of this event - `java.lang.String`"
  (^java.lang.String [^AdjustmentEvent this]
    (-> this (.paramString))))

