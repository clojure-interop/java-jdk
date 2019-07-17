(ns jdk.awt.ScrollPaneAdjustable
  "This class represents the state of a horizontal or vertical
  scrollbar of a ScrollPane.  Objects of this class are
  returned by ScrollPane methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt ScrollPaneAdjustable]))

(defn get-adjustment-listeners
  "Returns an array of all the adjustment listeners
   registered on this ScrollPaneAdjustable.

  returns: all of this ScrollPaneAdjustable's
           AdjustmentListeners
           or an empty array if no adjustment
           listeners are currently registered - `java.awt.event.AdjustmentListener[]`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getAdjustmentListeners))))

(defn get-visible-amount
  "Description copied from interface: Adjustable

  returns: the length of the proportional indicator - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getVisibleAmount))))

(defn set-block-increment
  "Description copied from interface: Adjustable

  b - the block increment - `int`"
  ([^java.awt.ScrollPaneAdjustable this ^Integer b]
    (-> this (.setBlockIncrement b))))

(defn get-value-is-adjusting?
  "Returns true if the value is in the process of changing as a
   result of actions being taken by the user.

  returns: the value of the valueIsAdjusting property - `boolean`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getValueIsAdjusting))))

(defn get-orientation
  "Returns the orientation of this scrollbar.

  returns: the orientation of this scrollbar, either
              Adjustable.HORIZONTAL or
              Adjustable.VERTICAL - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getOrientation))))

(defn get-minimum
  "Description copied from interface: Adjustable

  returns: the minimum value of the adjustable object - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getMinimum))))

(defn get-unit-increment
  "Description copied from interface: Adjustable

  returns: the unit value increment for the adjustable object - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getUnitIncrement))))

(defn get-block-increment
  "Description copied from interface: Adjustable

  returns: the block value increment for the adjustable object - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getBlockIncrement))))

(defn add-adjustment-listener
  "Adds the specified adjustment listener to receive adjustment
   events from this ScrollPaneAdjustable.
   If l is null, no exception is thrown
   and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the adjustment listener. - `java.awt.event.AdjustmentListener`"
  ([^java.awt.ScrollPaneAdjustable this ^java.awt.event.AdjustmentListener l]
    (-> this (.addAdjustmentListener l))))

(defn to-string
  "Returns a string representation of this scrollbar and its values.

  returns: a string representation of this scrollbar. - `java.lang.String`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.toString))))

(defn get-value
  "Description copied from interface: Adjustable

  returns: the current value of the adjustable object - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getValue))))

(defn remove-adjustment-listener
  "Removes the specified adjustment listener so that it no longer
   receives adjustment events from this ScrollPaneAdjustable.
   If l is null, no exception is thrown
   and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the adjustment listener. - `java.awt.event.AdjustmentListener`"
  ([^java.awt.ScrollPaneAdjustable this ^java.awt.event.AdjustmentListener l]
    (-> this (.removeAdjustmentListener l))))

(defn set-maximum
  "This method should NOT be called by user code.
   This method is public for this class to properly implement
   Adjustable interface.

  max - the maximum value - `int`

  throws: java.awt.AWTError - Always throws an error when called."
  ([^java.awt.ScrollPaneAdjustable this ^Integer max]
    (-> this (.setMaximum max))))

(defn set-value-is-adjusting
  "Sets the valueIsAdjusting property.

  b - new adjustment-in-progress status - `boolean`"
  ([^java.awt.ScrollPaneAdjustable this ^Boolean b]
    (-> this (.setValueIsAdjusting b))))

(defn param-string
  "Returns a string representing the state of this scrollbar.
   This method is intended to be used only for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.  The returned string may be empty but
   may not be null.

  returns: the parameter string of this scrollbar. - `java.lang.String`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.paramString))))

(defn set-unit-increment
  "Description copied from interface: Adjustable

  u - the unit increment - `int`"
  ([^java.awt.ScrollPaneAdjustable this ^Integer u]
    (-> this (.setUnitIncrement u))))

(defn set-value
  "Sets the value of this scrollbar to the specified value.

   If the value supplied is less than the current minimum or
   greater than the current maximum, then one of those values is
   substituted, as appropriate.

  v - the new value of the scrollbar - `int`"
  ([^java.awt.ScrollPaneAdjustable this ^Integer v]
    (-> this (.setValue v))))

(defn set-visible-amount
  "This method should NOT be called by user code.
   This method is public for this class to properly implement
   Adjustable interface.

  v - the length of the indicator - `int`

  throws: java.awt.AWTError - Always throws an error when called."
  ([^java.awt.ScrollPaneAdjustable this ^Integer v]
    (-> this (.setVisibleAmount v))))

(defn set-minimum
  "This method should NOT be called by user code.
   This method is public for this class to properly implement
   Adjustable interface.

  min - the minimum value - `int`

  throws: java.awt.AWTError - Always throws an error when called."
  ([^java.awt.ScrollPaneAdjustable this ^Integer min]
    (-> this (.setMinimum min))))

(defn get-maximum
  "Description copied from interface: Adjustable

  returns: the maximum value of the adjustable object - `int`"
  ([^java.awt.ScrollPaneAdjustable this]
    (-> this (.getMaximum))))

