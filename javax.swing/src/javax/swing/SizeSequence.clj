(ns javax.swing.SizeSequence
  "A SizeSequence object
  efficiently maintains an ordered list
  of sizes and corresponding positions.
  One situation for which SizeSequence
  might be appropriate is in a component
  that displays multiple rows of unequal size.
  In this case, a single SizeSequence
  object could be used to track the heights
  and Y positions of all rows.

  Another example would be a multi-column component,
  such as a JTable,
  in which the column sizes are not all equal.
  The JTable might use a single
  SizeSequence object
  to store the widths and X positions of all the columns.
  The JTable could then use the
  SizeSequence object
  to find the column corresponding to a certain position.
  The JTable could update the
  SizeSequence object
  whenever one or more column sizes changed.


  The following figure shows the relationship between size and position data
  for a multi-column component.





  In the figure, the first index (0) corresponds to the first column,
  the second index (1) to the second column, and so on.
  The first column's position starts at 0,
  and the column occupies size0 pixels,
  where size0 is the value returned by
  getSize(0).
  Thus, the first column ends at size0 - 1.
  The second column then begins at
  the position size0
  and occupies size1 (getSize(1)) pixels.

  Note that a SizeSequence object simply represents intervals
  along an axis.
  In our examples, the intervals represent height or width in pixels.
  However, any other unit of measure (for example, time in days)
  could be just as valid.


  Implementation Notes

  Normally when storing the size and position of entries,
  one would choose between
  storing the sizes or storing their positions
  instead. The two common operations that are needed during
  rendering are: getIndex(position)
  and setSize(index, size).
  Whichever choice of internal format is made one of these
  operations is costly when the number of entries becomes large.
  If sizes are stored, finding the index of the entry
  that encloses a particular position is linear in the
  number of entries. If positions are stored instead, setting
  the size of an entry at a particular index requires updating
  the positions of the affected entries, which is also a linear
  calculation.

  Like the above techniques this class holds an array of N integers
  internally but uses a hybrid encoding, which is halfway
  between the size-based and positional-based approaches.
  The result is a data structure that takes the same space to store
  the information but can perform most operations in Log(N) time
  instead of O(N), where N is the number of entries in the list.

  Two operations that remain O(N) in the number of entries are
  the insertEntries
  and removeEntries methods, both
  of which are implemented by converting the internal array to
  a set of integer sizes, copying it into the new array, and then
  reforming the hybrid representation in place."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SizeSequence]))

(defn ->size-sequence
  "Constructor.

  Creates a new SizeSequence object
   that contains the specified number of entries,
   all initialized to have size value.

  num-entries - the number of sizes to track - `int`
  value - the initial value of each size - `int`"
  (^SizeSequence [^Integer num-entries ^Integer value]
    (new SizeSequence num-entries value))
  (^SizeSequence [^Integer num-entries]
    (new SizeSequence num-entries))
  (^SizeSequence []
    (new SizeSequence )))

(defn set-sizes
  "Resets this SizeSequence object,
   using the data in the sizes argument.
   This method reinitializes this object so that it
   contains as many entries as the sizes array.
   Each entry's size is initialized to the value of the
   corresponding item in sizes.

  sizes - the array of sizes to be contained in this SizeSequence - `int[]`"
  ([^SizeSequence this sizes]
    (-> this (.setSizes sizes))))

(defn get-sizes
  "Returns the size of all entries.

  returns: a new array containing the sizes in this object - `int[]`"
  ([^SizeSequence this]
    (-> this (.getSizes))))

(defn get-position
  "Returns the start position for the specified entry.
   For example, getPosition(0) returns 0,
   getPosition(1) is equal to
     getSize(0),
   getPosition(2) is equal to
     getSize(0)  getSize(1),
   and so on.
   Note that if index is greater than
   length the value returned may
   be meaningless.

  index - the index of the entry whose position is desired - `int`

  returns: the starting position of the specified entry - `int`"
  (^Integer [^SizeSequence this ^Integer index]
    (-> this (.getPosition index))))

(defn get-index
  "Returns the index of the entry
   that corresponds to the specified position.
   For example, getIndex(0) is 0,
   since the first entry always starts at position 0.

  position - the position of the entry - `int`

  returns: the index of the entry that occupies the specified position - `int`"
  (^Integer [^SizeSequence this ^Integer position]
    (-> this (.getIndex position))))

(defn get-size
  "Returns the size of the specified entry.
   If index is out of the range
   (0 <= index < getSizes().length)
   the behavior is unspecified.

  index - the index corresponding to the entry - `int`

  returns: the size of the entry - `int`"
  (^Integer [^SizeSequence this ^Integer index]
    (-> this (.getSize index))))

(defn set-size
  "Sets the size of the specified entry.
   Note that if the value of index
   does not fall in the range:
   (0 <= index < getSizes().length)
   the behavior is unspecified.

  index - the index corresponding to the entry - `int`
  size - the size of the entry - `int`"
  ([^SizeSequence this ^Integer index ^Integer size]
    (-> this (.setSize index size))))

(defn insert-entries
  "Adds a contiguous group of entries to this SizeSequence.
   Note that the values of start and
   length must satisfy the following
   conditions:  (0 <= start < getSizes().length)
   AND (length >= 0).  If these conditions are
   not met, the behavior is unspecified and an exception
   may be thrown.

  start - the index to be assigned to the first entry in the group - `int`
  length - the number of entries in the group - `int`
  value - the size to be assigned to each new entry - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the parameters are outside of the range: (0 <= start < (getSizes().length)) AND (length >= 0)"
  ([^SizeSequence this ^Integer start ^Integer length ^Integer value]
    (-> this (.insertEntries start length value))))

(defn remove-entries
  "Removes a contiguous group of entries
   from this SizeSequence.
   Note that the values of start and
   length must satisfy the following
   conditions:  (0 <= start < getSizes().length)
   AND (length >= 0).  If these conditions are
   not met, the behavior is unspecified and an exception
   may be thrown.

  start - the index of the first entry to be removed - `int`
  length - the number of entries to be removed - `int`"
  ([^SizeSequence this ^Integer start ^Integer length]
    (-> this (.removeEntries start length))))

