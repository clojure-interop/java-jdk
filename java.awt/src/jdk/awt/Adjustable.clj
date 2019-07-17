(ns jdk.awt.Adjustable
  "The interface for objects which have an adjustable numeric value
  contained within a bounded range of values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Adjustable]))

(defn get-visible-amount
  "Gets the length of the proportional indicator.

  returns: the length of the proportional indicator - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getVisibleAmount))))

(defn set-block-increment
  "Sets the block value increment for the adjustable object.

  b - the block increment - `int`"
  ([^java.awt.Adjustable this ^Integer b]
    (-> this (.setBlockIncrement b))))

(defn get-orientation
  "Gets the orientation of the adjustable object.

  returns: the orientation of the adjustable object;
     either HORIZONTAL, VERTICAL,
     or NO_ORIENTATION - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getOrientation))))

(defn get-minimum
  "Gets the minimum value of the adjustable object.

  returns: the minimum value of the adjustable object - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getMinimum))))

(defn get-unit-increment
  "Gets the unit value increment for the adjustable object.

  returns: the unit value increment for the adjustable object - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getUnitIncrement))))

(defn get-block-increment
  "Gets the block value increment for the adjustable object.

  returns: the block value increment for the adjustable object - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getBlockIncrement))))

(defn add-adjustment-listener
  "Adds a listener to receive adjustment events when the value of
   the adjustable object changes.

  l - the listener to receive events - `java.awt.event.AdjustmentListener`"
  ([^java.awt.Adjustable this ^java.awt.event.AdjustmentListener l]
    (-> this (.addAdjustmentListener l))))

(defn get-value
  "Gets the current value of the adjustable object.

  returns: the current value of the adjustable object - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getValue))))

(defn remove-adjustment-listener
  "Removes an adjustment listener.

  l - the listener being removed - `java.awt.event.AdjustmentListener`"
  ([^java.awt.Adjustable this ^java.awt.event.AdjustmentListener l]
    (-> this (.removeAdjustmentListener l))))

(defn set-maximum
  "Sets the maximum value of the adjustable object.

  max - the maximum value - `int`"
  ([^java.awt.Adjustable this ^Integer max]
    (-> this (.setMaximum max))))

(defn set-unit-increment
  "Sets the unit value increment for the adjustable object.

  u - the unit increment - `int`"
  ([^java.awt.Adjustable this ^Integer u]
    (-> this (.setUnitIncrement u))))

(defn set-value
  "Sets the current value of the adjustable object. If
   the value supplied is less than minimum
   or greater than maximum - visibleAmount,
   then one of those values is substituted, as appropriate.

   Calling this method does not fire an
   AdjustmentEvent.

  v - the current value, between minimum and maximum - visibleAmount - `int`"
  ([^java.awt.Adjustable this ^Integer v]
    (-> this (.setValue v))))

(defn set-visible-amount
  "Sets the length of the proportional indicator of the
   adjustable object.

  v - the length of the indicator - `int`"
  ([^java.awt.Adjustable this ^Integer v]
    (-> this (.setVisibleAmount v))))

(defn set-minimum
  "Sets the minimum value of the adjustable object.

  min - the minimum value - `int`"
  ([^java.awt.Adjustable this ^Integer min]
    (-> this (.setMinimum min))))

(defn get-maximum
  "Gets the maximum value of the adjustable object.

  returns: the maximum value of the adjustable object - `int`"
  ([^java.awt.Adjustable this]
    (-> this (.getMaximum))))

