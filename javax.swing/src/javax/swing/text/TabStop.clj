(ns javax.swing.text.TabStop
  "This class encapsulates a single tab stop (basically as tab stops
  are thought of by RTF). A tab stop is at a specified distance from the
  left margin, aligns text in a specified way, and has a specified leader.
  TabStops are immutable, and usually contained in TabSets.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TabStop]))

(defn ->tab-stop
  "Constructor.

  Creates a tab with the specified position pos,
   alignment align and leader leader.

  pos - `float`
  align - `int`
  leader - `int`"
  ([pos align leader]
    (new TabStop pos align leader))
  ([pos]
    (new TabStop pos)))

(def *-align-left
  "Static Constant.

  Character following tab is positioned at location.

  type: int"
  TabStop/ALIGN_LEFT)

(def *-align-right
  "Static Constant.

  Characters following tab are positioned such that all following
   characters up to next tab/newline end at location.

  type: int"
  TabStop/ALIGN_RIGHT)

(def *-align-center
  "Static Constant.

  Characters following tab are positioned such that all following
   characters up to next tab/newline are centered around the tabs
   location.

  type: int"
  TabStop/ALIGN_CENTER)

(def *-align-decimal
  "Static Constant.

  Characters following tab are aligned such that next
   decimal/tab/newline is at the tab location, very similar to
   RIGHT_TAB, just includes decimal as additional character to look for.

  type: int"
  TabStop/ALIGN_DECIMAL)

(def *-align-bar
  "Static Constant.

  type: int"
  TabStop/ALIGN_BAR)

(def *-lead-none
  "Static Constant.

  type: int"
  TabStop/LEAD_NONE)

(def *-lead-dots
  "Static Constant.

  type: int"
  TabStop/LEAD_DOTS)

(def *-lead-hyphens
  "Static Constant.

  type: int"
  TabStop/LEAD_HYPHENS)

(def *-lead-underline
  "Static Constant.

  type: int"
  TabStop/LEAD_UNDERLINE)

(def *-lead-thickline
  "Static Constant.

  type: int"
  TabStop/LEAD_THICKLINE)

(def *-lead-equals
  "Static Constant.

  type: int"
  TabStop/LEAD_EQUALS)

(defn get-position
  "Returns the position, as a float, of the tab.

  returns: the position of the tab - `float`"
  ([this]
    (-> this (.getPosition))))

(defn get-alignment
  "Returns the alignment, as an integer, of the tab.

  returns: the alignment of the tab - `int`"
  ([this]
    (-> this (.getAlignment))))

(defn get-leader
  "Returns the leader of the tab.

  returns: the leader of the tab - `int`"
  ([this]
    (-> this (.getLeader))))

(defn equals
  "Returns true if the tabs are equal.

  other - the reference object with which to compare. - `java.lang.Object`

  returns: true if the tabs are equal, otherwise false - `boolean`"
  ([this other]
    (-> this (.equals other))))

(defn hash-code
  "Returns the hashCode for the object.  This must be defined
   here to ensure 100% pure.

  returns: the hashCode for the object - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

