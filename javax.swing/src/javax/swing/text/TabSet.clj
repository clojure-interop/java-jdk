(ns javax.swing.text.TabSet
  "A TabSet is comprised of many TabStops. It offers methods for locating the
  closest TabStop to a given position and finding all the potential TabStops.
  It is also immutable.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TabSet]))

(defn ->tab-set
  "Constructor.

  Creates and returns an instance of TabSet. The array of Tabs
   passed in must be sorted in ascending order.

  tabs - `javax.swing.text.TabStop[]`"
  ([tabs]
    (new TabSet tabs)))

(defn get-tab-count
  "Returns the number of Tab instances the receiver contains.

  returns: `int`"
  ([this]
    (-> this (.getTabCount))))

(defn get-tab
  "Returns the TabStop at index index. This will throw an
   IllegalArgumentException if index is outside the range
   of tabs.

  index - `int`

  returns: `javax.swing.text.TabStop`"
  ([this index]
    (-> this (.getTab index))))

(defn get-tab-after
  "Returns the Tab instance after location. This will
   return null if there are no tabs after location.

  location - `float`

  returns: `javax.swing.text.TabStop`"
  ([this location]
    (-> this (.getTabAfter location))))

(defn get-tab-index
  "tab - `javax.swing.text.TabStop`

  returns: the index of the TabStop tab, or -1 if
   tab is not contained in the receiver. - `int`"
  ([this tab]
    (-> this (.getTabIndex tab))))

(defn get-tab-index-after
  "Returns the index of the Tab to be used after location.
   This will return -1 if there are no tabs after location.

  location - `float`

  returns: `int`"
  ([this location]
    (-> this (.getTabIndexAfter location))))

(defn equals
  "Indicates whether this TabSet is equal to another one.

  o - the TabSet instance which this instance should be compared to. - `java.lang.Object`

  returns: true if o is the instance of
   TabSet, has the same number of TabStops
   and they are all equal, false otherwise. - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn hash-code
  "Returns a hashcode for this set of TabStops.

  returns: a hashcode value for this set of TabStops. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the string representation of the set of tabs.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

