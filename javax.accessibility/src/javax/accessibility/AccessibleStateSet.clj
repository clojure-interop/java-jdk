(ns javax.accessibility.AccessibleStateSet
  "Class AccessibleStateSet determines a component's state set.  The state set
  of a component is a set of AccessibleState objects and descriptions. E.G., The
  current overall state of the object, such as whether it is enabled,
  has focus, etc."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleStateSet]))

(defn ->accessible-state-set
  "Constructor.

  Creates a new state with the initial set of states contained in
   the array of states passed in.  Duplicate entries are ignored.

  states - an array of AccessibleState describing the state set. - `javax.accessibility.AccessibleState[]`"
  (^AccessibleStateSet [states]
    (new AccessibleStateSet states))
  (^AccessibleStateSet []
    (new AccessibleStateSet )))

(defn add
  "Adds a new state to the current state set if it is not already
   present.  If the state is already in the state set, the state
   set is unchanged and the return value is false.  Otherwise,
   the state is added to the state set and the return value is
   true.

  state - the state to add to the state set - `javax.accessibility.AccessibleState`

  returns: true if state is added to the state set; false if the state set
   is unchanged - `boolean`"
  (^Boolean [^AccessibleStateSet this ^javax.accessibility.AccessibleState state]
    (-> this (.add state))))

(defn add-all
  "Adds all of the states to the existing state set.  Duplicate entries
   are ignored.

  states - AccessibleState array describing the state set. - `javax.accessibility.AccessibleState[]`"
  ([^AccessibleStateSet this states]
    (-> this (.addAll states))))

(defn remove
  "Removes a state from the current state set.  If the state is not
   in the set, the state set will be unchanged and the return value
   will be false.  If the state is in the state set, it will be removed
   from the set and the return value will be true.

  state - the state to remove from the state set - `javax.accessibility.AccessibleState`

  returns: true if the state is in the state set; false if the state set
   will be unchanged - `boolean`"
  (^Boolean [^AccessibleStateSet this ^javax.accessibility.AccessibleState state]
    (-> this (.remove state))))

(defn clear
  "Removes all the states from the current state set."
  ([^AccessibleStateSet this]
    (-> this (.clear))))

(defn contains
  "Checks if the current state is in the state set.

  state - the state - `javax.accessibility.AccessibleState`

  returns: true if the state is in the state set; otherwise false - `boolean`"
  (^Boolean [^AccessibleStateSet this ^javax.accessibility.AccessibleState state]
    (-> this (.contains state))))

(defn to-array
  "Returns the current state set as an array of AccessibleState

  returns: AccessibleState array containing the current state. - `javax.accessibility.AccessibleState[]`"
  ([^AccessibleStateSet this]
    (-> this (.toArray))))

(defn to-string
  "Creates a localized String representing all the states in the set
   using the default locale.

  returns: comma separated localized String - `java.lang.String`"
  (^java.lang.String [^AccessibleStateSet this]
    (-> this (.toString))))

