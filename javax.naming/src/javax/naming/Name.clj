(ns javax.naming.Name
  "The Name interface represents a generic name -- an ordered
  sequence of components.  It can be a composite name (names that
  span multiple namespaces), or a compound name (names that are
  used within individual hierarchical naming systems).

   There can be different implementations of Name; for example,
  composite names, URLs, or namespace-specific compound names.

   The components of a name are numbered.  The indexes of a name
  with N components range from 0 up to, but not including, N.  This
  range may be written as [0,N).
  The most significant component is at index 0.
  An empty name has no components.

   None of the methods in this interface accept null as a valid
  value for a parameter that is a name or a name component.
  Likewise, methods that return a name or name component never return null.

   An instance of a Name may not be synchronized against
  concurrent multithreaded access if that access is not read-only."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming Name]))

(defn add-all
  "Adds the components of a name -- in order -- at a specified position
   within this name.
   Components of this name at or after the index of the first new
   component are shifted up (away from 0) to accommodate the new
   components.

  posn - the index in this name at which to add the new components. Must be in the range [0,size()]. - `int`
  n - the components to add - `javax.naming.Name`

  returns: the updated name (not a new one) - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn n]
    (-> this (.addAll posn n)))
  ([this suffix]
    (-> this (.addAll suffix))))

(defn ends-with
  "Determines whether this name ends with a specified suffix.
   A name n is a suffix if it is equal to
   getSuffix(size()-n.size()).

  n - the name to check - `javax.naming.Name`

  returns: true if n is a suffix of this name, false otherwise - `boolean`"
  ([this n]
    (-> this (.endsWith n))))

(defn get-suffix
  "Creates a name whose components consist of a suffix of the
   components in this name.  Subsequent changes to
   this name do not affect the name that is returned and vice versa.

  posn - the 0-based index of the component at which to start. Must be in the range [0,size()]. - `int`

  returns: a name consisting of the components at indexes in
            the range [posn,size()).  If posn is equal to
            size(), an empty name is returned. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn]
    (-> this (.getSuffix posn))))

(defn get-all
  "Retrieves the components of this name as an enumeration
   of strings.  The effect on the enumeration of updates to
   this name is undefined.  If the name has zero components,
   an empty (non-null) enumeration is returned.

  returns: an enumeration of the components of this name, each a string - `java.util.Enumeration<java.lang.String>`"
  ([this]
    (-> this (.getAll))))

(defn remove
  "Removes a component from this name.
   The component of this name at the specified position is removed.
   Components with indexes greater than this position
   are shifted down (toward index 0) by one.

  posn - the index of the component to remove. Must be in the range [0,size()). - `int`

  returns: the component removed (a String) - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn]
    (-> this (.remove posn))))

(defn starts-with
  "Determines whether this name starts with a specified prefix.
   A name n is a prefix if it is equal to
   getPrefix(n.size()).

  n - the name to check - `javax.naming.Name`

  returns: true if n is a prefix of this name, false otherwise - `boolean`"
  ([this n]
    (-> this (.startsWith n))))

(defn clone
  "Generates a new copy of this name.
   Subsequent changes to the components of this name will not
   affect the new copy, and vice versa.

  returns: a copy of this name - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn add
  "Adds a single component at a specified position within this name.
   Components of this name at or after the index of the new component
   are shifted up by one (away from index 0) to accommodate the new
   component.

  posn - the index at which to add the new component. Must be in the range [0,size()]. - `int`
  comp - the component to add - `java.lang.String`

  returns: the updated name (not a new one) - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn comp]
    (-> this (.add posn comp)))
  ([this comp]
    (-> this (.add comp))))

(defn empty?
  "Determines whether this name is empty.
   An empty name is one with zero components.

  returns: true if this name is empty, false otherwise - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of components in this name.

  returns: the number of components in this name - `int`"
  ([this]
    (-> this (.size))))

(defn compare-to
  "Compares this name with another name for order.
   Returns a negative integer, zero, or a positive integer as this
   name is less than, equal to, or greater than the given name.

    As with Object.equals(), the notion of ordering for names
   depends on the class that implements this interface.
   For example, the ordering may be
   based on lexicographical ordering of the name components.
   Specific attributes of the name, such as how it treats case,
   may affect the ordering.  In general, two names of different
   classes may not be compared.

  obj - the non-null object to compare against. - `java.lang.Object`

  returns: a negative integer, zero, or a positive integer as this name
            is less than, equal to, or greater than the given name - `int`

  throws: java.lang.ClassCastException - if obj is not a Name of a type that may be compared with this name"
  ([this obj]
    (-> this (.compareTo obj))))

(defn get-prefix
  "Creates a name whose components consist of a prefix of the
   components of this name.  Subsequent changes to
   this name will not affect the name that is returned and vice versa.

  posn - the 0-based index of the component at which to stop. Must be in the range [0,size()]. - `int`

  returns: a name consisting of the components at indexes in
            the range [0,posn). - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn]
    (-> this (.getPrefix posn))))

(defn get
  "Retrieves a component of this name.

  posn - the 0-based index of the component to retrieve. Must be in the range [0,size()). - `int`

  returns: the component at index posn - `java.lang.String`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range"
  ([this posn]
    (-> this (.get posn))))

