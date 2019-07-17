(ns javax.print.attribute.SetOfIntegerSyntax
  "Class SetOfIntegerSyntax is an abstract base class providing the common
  implementation of all attributes whose value is a set of nonnegative
  integers. This includes attributes whose value is a single range of integers
  and attributes whose value is a set of ranges of integers.

  You can construct an instance of SetOfIntegerSyntax by giving it in `string
  form.` The string consists of zero or more comma-separated integer groups.
  Each integer group consists of either one integer, two integers separated by
  a hyphen (-), or two integers separated by a colon
  (:). Each integer consists of one or more decimal digits
  (0 through 9). Whitespace characters cannot
  appear within an integer but are otherwise ignored. For example:
  ``, `1`, `5-10`, `1:2,
  4`.

  You can also construct an instance of SetOfIntegerSyntax by giving it in
  `array form.` Array form consists of an array of zero or more integer groups
  where each integer group is a length-1 or length-2 array of
  ints; for example, int[0][],
  int[][]{{1}}, int[][]{{5,10}},
  int[][]{{1,2},{4}}.

  In both string form and array form, each successive integer group gives a
  range of integers to be included in the set. The first integer in each group
  gives the lower bound of the range; the second integer in each group gives
  the upper bound of the range; if there is only one integer in the group, the
  upper bound is the same as the lower bound. If the upper bound is less than
  the lower bound, it denotes a null range (no values). If the upper bound is
  equal to the lower bound, it denotes a range consisting of a single value. If
  the upper bound is greater than the lower bound, it denotes a range
  consisting of more than one value. The ranges may appear in any order and are
  allowed to overlap. The union of all the ranges gives the set's contents.
  Once a SetOfIntegerSyntax instance is constructed, its value is immutable.

  The SetOfIntegerSyntax object's value is actually stored in `canonical
  array form.` This is the same as array form, except there are no null ranges;
  the members of the set are represented in as few ranges as possible (i.e.,
  overlapping ranges are coalesced); the ranges appear in ascending order; and
  each range is always represented as a length-two array of ints
  in the form {lower bound, upper bound}. An empty set is represented as a
  zero-length array.

  Class SetOfIntegerSyntax has operations to return the set's members in
  canonical array form, to test whether a given integer is a member of the
  set, and to iterate through the members of the set."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute SetOfIntegerSyntax]))

(defn get-members
  "Obtain this set-of-integer attribute's members in canonical array form.
   The returned array is `safe;` the client may alter it without affecting
   this set-of-integer attribute.

  returns: This set-of-integer attribute's members in canonical array form. - `int[][]`"
  ([^javax.print.attribute.SetOfIntegerSyntax this]
    (-> this (.getMembers))))

(defn contains
  "Determine if this set-of-integer attribute contains the given value.

  x - Integer value. - `int`

  returns: True if this set-of-integer attribute contains the value
            x, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.SetOfIntegerSyntax this ^Integer x]
    (-> this (.contains x))))

(defn next
  "Determine the smallest integer in this set-of-integer attribute that is
   greater than the given value. If there are no integers in this
   set-of-integer attribute greater than the given value, -1 is
   returned. (Since a set-of-integer attribute can only contain nonnegative
   values, -1 will never appear in the set.) You can use the
   next() method to iterate through the integer values in a
   set-of-integer attribute in ascending order, like this:


       SetOfIntegerSyntax attribute = . . .;
       int i = -1;
       while ((i = attribute.next (i)) != -1)
           {
           foo (i);
           }

  x - Integer value. - `int`

  returns: The smallest integer in this set-of-integer attribute that is
            greater than x, or -1 if no integer in
            this set-of-integer attribute is greater than x. - `int`"
  (^Integer [^javax.print.attribute.SetOfIntegerSyntax this ^Integer x]
    (-> this (.next x))))

(defn equals
  "Returns whether this set-of-integer attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class SetOfIntegerSyntax.

   This set-of-integer attribute's members and object's
   members are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this
            set-of-integer attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.SetOfIntegerSyntax this ^java.lang.Object object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this set-of-integer attribute. The hash
   code is the sum of the lower and upper bounds of the ranges in the
   canonical array form, or 0 for an empty set.

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.print.attribute.SetOfIntegerSyntax this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string value corresponding to this set-of-integer attribute.
   The string value is a zero-length string if this set is empty. Otherwise,
   the string value is a comma-separated list of the ranges in the canonical
   array form, where each range is represented as `i` if
   the lower bound equals the upper bound or
   `i-j` otherwise.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.SetOfIntegerSyntax this]
    (-> this (.toString))))

