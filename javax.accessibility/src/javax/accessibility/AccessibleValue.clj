(ns javax.accessibility.AccessibleValue
  "The AccessibleValue interface should be supported by any object
  that supports a numerical value (e.g., a scroll bar).  This interface
  provides the standard mechanism for an assistive technology to determine
  and set the numerical value as well as get the minimum and maximum values.
  Applications can determine
  if an object supports the AccessibleValue interface by first
  obtaining its AccessibleContext (see
  Accessible) and then calling the
  AccessibleContext.getAccessibleValue() method.
  If the return value is not null, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleValue]))

(defn get-current-accessible-value
  "Get the value of this object as a Number.  If the value has not been
   set, the return value will be null.

  returns: value of the object - `java.lang.Number`"
  ([^. this]
    (-> this (.getCurrentAccessibleValue))))

(defn set-current-accessible-value
  "Set the value of this object as a Number.

  n - the number to use for the value - `java.lang.Number`

  returns: True if the value was set; else False - `boolean`"
  ([^. this ^java.lang.Number n]
    (-> this (.setCurrentAccessibleValue n))))

(defn get-minimum-accessible-value
  "Get the minimum value of this object as a Number.

  returns: Minimum value of the object; null if this object does not
   have a minimum value - `java.lang.Number`"
  ([^. this]
    (-> this (.getMinimumAccessibleValue))))

(defn get-maximum-accessible-value
  "Get the maximum value of this object as a Number.

  returns: Maximum value of the object; null if this object does not
   have a maximum value - `java.lang.Number`"
  ([^. this]
    (-> this (.getMaximumAccessibleValue))))

