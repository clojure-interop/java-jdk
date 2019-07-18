(ns javax.accessibility.AccessibleSelection
  "This AccessibleSelection interface
  provides the standard mechanism for an assistive technology to determine
  what the current selected children are, as well as modify the selection set.
  Any object that has children that can be selected should support
  the AccessibleSelection interface.  Applications can determine if an object supports the
  AccessibleSelection interface by first obtaining its AccessibleContext (see
  Accessible) and then calling the
  AccessibleContext.getAccessibleSelection() method.
  If the return value is not null, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleSelection]))

(defn get-accessible-selection-count
  "Returns the number of Accessible children currently selected.
   If no children are selected, the return value will be 0.

  returns: the number of items currently selected. - `int`"
  (^Integer [^AccessibleSelection this]
    (-> this (.getAccessibleSelectionCount))))

(defn get-accessible-selection
  "Returns an Accessible representing the specified selected child
   of the object.  If there isn't a selection, or there are
   fewer children selected than the integer passed in, the return
   value will be null.
   Note that the index represents the i-th selected child, which
   is different from the i-th child.

  i - the zero-based index of selected children - `int`

  returns: the i-th selected child - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleSelection this ^Integer i]
    (-> this (.getAccessibleSelection i))))

(defn accessible-child-selected?
  "Determines if the current child of this object is selected.

  i - the zero-based index of the child in this Accessible object. - `int`

  returns: true if the current child of this object is selected; else false. - `boolean`"
  (^Boolean [^AccessibleSelection this ^Integer i]
    (-> this (.isAccessibleChildSelected i))))

(defn add-accessible-selection
  "Adds the specified Accessible child of the object to the object's
   selection.  If the object supports multiple selections,
   the specified child is added to any existing selection, otherwise
   it replaces any existing selection in the object.  If the
   specified child is already selected, this method has no effect.

  i - the zero-based index of the child - `int`"
  ([^AccessibleSelection this ^Integer i]
    (-> this (.addAccessibleSelection i))))

(defn remove-accessible-selection
  "Removes the specified child of the object from the object's
   selection.  If the specified item isn't currently selected, this
   method has no effect.

  i - the zero-based index of the child - `int`"
  ([^AccessibleSelection this ^Integer i]
    (-> this (.removeAccessibleSelection i))))

(defn clear-accessible-selection
  "Clears the selection in the object, so that no children in the
   object are selected."
  ([^AccessibleSelection this]
    (-> this (.clearAccessibleSelection))))

(defn select-all-accessible-selection
  "Causes every child of the object to be selected
   if the object supports multiple selections."
  ([^AccessibleSelection this]
    (-> this (.selectAllAccessibleSelection))))

