(ns javax.swing.DefaultListModel
  "This class loosely implements the java.util.Vector
  API, in that it implements the 1.1.x version of
  java.util.Vector, has no collection class support,
  and notifies the ListDataListeners when changes occur.
  Presently it delegates to a Vector,
  in a future release it will be a real Collection implementation.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultListModel]))

(defn ->default-list-model
  "Constructor."
  (^DefaultListModel []
    (new DefaultListModel )))

(defn first-element
  "Returns the first component of this list.
   Throws a NoSuchElementException if this
   vector has no components.

  returns: the first component of this list - `E`"
  ([^DefaultListModel this]
    (-> this (.firstElement))))

(defn add-element
  "Adds the specified component to the end of this list.

  element - the component to be added - `E`"
  ([^DefaultListModel this element]
    (-> this (.addElement element))))

(defn contains
  "Tests whether the specified object is a component in this list.

  elem - an object - `java.lang.Object`

  returns: true if the specified object
            is the same as a component in this list - `boolean`"
  (^Boolean [^DefaultListModel this ^java.lang.Object elem]
    (-> this (.contains elem))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^DefaultListModel this]
    (-> this (.toString))))

(defn insert-element-at
  "Inserts the specified element as a component in this list at the
   specified index.

   Throws an ArrayIndexOutOfBoundsException if the index
   is invalid.

   Note: Although this method is not deprecated, the preferred
      method to use is add(int,Object), which implements the
      List interface defined in the 1.2 Collections framework.

  element - the component to insert - `E`
  index - where to insert the new component - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index was invalid"
  ([^DefaultListModel this element ^Integer index]
    (-> this (.insertElementAt element index))))

(defn remove-all-elements
  "Removes all components from this list and sets its size to zero.

   Note: Although this method is not deprecated, the preferred
      method to use is clear, which implements the
      List interface defined in the 1.2 Collections framework."
  ([^DefaultListModel this]
    (-> this (.removeAllElements))))

(defn get-element-at
  "Returns the component at the specified index.

   Note: Although this method is not deprecated, the preferred
      method to use is get(int), which implements the
      List interface defined in the 1.2 Collections framework.

  index - an index into this list - `int`

  returns: the component at the specified index - `E`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is negative or greater than the current size of this list"
  ([^DefaultListModel this ^Integer index]
    (-> this (.getElementAt index))))

(defn last-index-of
  "Searches backwards for elem, starting from the
   specified index, and returns an index to it.

  elem - the desired component - `java.lang.Object`
  index - the index to start searching from - `int`

  returns: the index of the last occurrence of the elem
            in this list at position less than index;
            returns -1 if the object is not found - `int`"
  (^Integer [^DefaultListModel this ^java.lang.Object elem ^Integer index]
    (-> this (.lastIndexOf elem index)))
  (^Integer [^DefaultListModel this ^java.lang.Object elem]
    (-> this (.lastIndexOf elem))))

(defn remove-element
  "Removes the first (lowest-indexed) occurrence of the argument
   from this list.

  obj - the component to be removed - `java.lang.Object`

  returns: true if the argument was a component of this
            list; false otherwise - `boolean`"
  (^Boolean [^DefaultListModel this ^java.lang.Object obj]
    (-> this (.removeElement obj))))

(defn set-element-at
  "Sets the component at the specified index of this
   list to be the specified element. The previous component at that
   position is discarded.

   Throws an ArrayIndexOutOfBoundsException if the index
   is invalid.

   Note: Although this method is not deprecated, the preferred
      method to use is set(int,Object), which implements the
      List interface defined in the 1.2 Collections framework.

  element - what the component is to be set to - `E`
  index - the specified index - `int`"
  ([^DefaultListModel this element ^Integer index]
    (-> this (.setElementAt element index))))

(defn remove
  "Removes the element at the specified position in this list.
   Returns the element that was removed from the list.

   Throws an ArrayIndexOutOfBoundsException
   if the index is out of range
   (index < 0 || index >= size()).

  index - the index of the element to removed - `int`

  returns: the element previously at the specified position - `E`"
  ([^DefaultListModel this ^Integer index]
    (-> this (.remove index))))

(defn copy-into
  "Copies the components of this list into the specified array.
   The array must be big enough to hold all the objects in this list,
   else an IndexOutOfBoundsException is thrown.

  an-array - the array into which the components get copied - `java.lang.Object[]`"
  ([^DefaultListModel this an-array]
    (-> this (.copyInto an-array))))

(defn ensure-capacity
  "Increases the capacity of this list, if necessary, to ensure
   that it can hold at least the number of components specified by
   the minimum capacity argument.

  min-capacity - the desired minimum capacity - `int`"
  ([^DefaultListModel this ^Integer min-capacity]
    (-> this (.ensureCapacity min-capacity))))

(defn element-at
  "Returns the component at the specified index.
   Throws an ArrayIndexOutOfBoundsException if the index
   is negative or not less than the size of the list.

   Note: Although this method is not deprecated, the preferred
      method to use is get(int), which implements the
      List interface defined in the 1.2 Collections framework.

  index - an index into this list - `int`

  returns: the component at the specified index - `E`"
  ([^DefaultListModel this ^Integer index]
    (-> this (.elementAt index))))

(defn set-size
  "Sets the size of this list.

  new-size - the new size of this list - `int`"
  ([^DefaultListModel this ^Integer new-size]
    (-> this (.setSize new-size))))

(defn add
  "Inserts the specified element at the specified position in this list.

   Throws an ArrayIndexOutOfBoundsException if the
   index is out of range
   (index < 0 || index > size()).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `E`"
  ([^DefaultListModel this ^Integer index element]
    (-> this (.add index element))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element.

   Throws an ArrayIndexOutOfBoundsException
   if the index is out of range
   (index < 0 || index >= size()).

  index - index of element to replace - `int`
  element - element to be stored at the specified position - `E`

  returns: the element previously at the specified position - `E`"
  ([^DefaultListModel this ^Integer index element]
    (-> this (.set index element))))

(defn empty?
  "Tests whether this list has any components.

  returns: true if and only if this list has
            no components, that is, its size is zero;
            false otherwise - `boolean`"
  (^Boolean [^DefaultListModel this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of components in this list.

  returns: the number of components in this list - `int`"
  (^Integer [^DefaultListModel this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this list.  The list will
   be empty after this call returns (unless it throws an exception)."
  ([^DefaultListModel this]
    (-> this (.clear))))

(defn index-of
  "Searches for the first occurrence of elem, beginning
   the search at index.

  elem - an desired component - `java.lang.Object`
  index - the index from which to begin searching - `int`

  returns: the index where the first occurrence of elem
            is found after index; returns -1
            if the elem is not found in the list - `int`"
  (^Integer [^DefaultListModel this ^java.lang.Object elem ^Integer index]
    (-> this (.indexOf elem index)))
  (^Integer [^DefaultListModel this ^java.lang.Object elem]
    (-> this (.indexOf elem))))

(defn to-array
  "Returns an array containing all of the elements in this list in the
   correct order.

  returns: an array containing the elements of the list - `java.lang.Object[]`"
  ([^DefaultListModel this]
    (-> this (.toArray))))

(defn last-element
  "Returns the last component of the list.
   Throws a NoSuchElementException if this vector
   has no components.

  returns: the last component of the list - `E`"
  ([^DefaultListModel this]
    (-> this (.lastElement))))

(defn get-size
  "Returns the number of components in this list.

   This method is identical to size, which implements the
   List interface defined in the 1.2 Collections framework.
   This method exists in conjunction with setSize so that
   size is identifiable as a JavaBean property.

  returns: the number of components in this list - `int`"
  (^Integer [^DefaultListModel this]
    (-> this (.getSize))))

(defn get
  "Returns the element at the specified position in this list.

   Throws an ArrayIndexOutOfBoundsException
   if the index is out of range
   (index < 0 || index >= size()).

  index - index of element to return - `int`

  returns: `E`"
  ([^DefaultListModel this ^Integer index]
    (-> this (.get index))))

(defn capacity
  "Returns the current capacity of this list.

  returns: the current capacity - `int`"
  (^Integer [^DefaultListModel this]
    (-> this (.capacity))))

(defn remove-element-at
  "Deletes the component at the specified index.

   Throws an ArrayIndexOutOfBoundsException if the index
   is invalid.

   Note: Although this method is not deprecated, the preferred
      method to use is remove(int), which implements the
      List interface defined in the 1.2 Collections framework.

  index - the index of the object to remove - `int`"
  ([^DefaultListModel this ^Integer index]
    (-> this (.removeElementAt index))))

(defn elements
  "Returns an enumeration of the components of this list.

  returns: an enumeration of the components of this list - `java.util.Enumeration<E>`"
  (^java.util.Enumeration [^DefaultListModel this]
    (-> this (.elements))))

(defn trim-to-size
  "Trims the capacity of this list to be the list's current size."
  ([^DefaultListModel this]
    (-> this (.trimToSize))))

(defn remove-range
  "Deletes the components at the specified range of indexes.
   The removal is inclusive, so specifying a range of (1,5)
   removes the component at index 1 and the component at index 5,
   as well as all components in between.

   Throws an ArrayIndexOutOfBoundsException
   if the index was invalid.
   Throws an IllegalArgumentException if
   fromIndex > toIndex.

  from-index - the index of the lower end of the range - `int`
  to-index - the index of the upper end of the range - `int`"
  ([^DefaultListModel this ^Integer from-index ^Integer to-index]
    (-> this (.removeRange from-index to-index))))

