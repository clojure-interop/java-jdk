(ns javax.naming.CompositeName
  "This class represents a composite name -- a sequence of
  component names spanning multiple namespaces.
  Each component is a string name from the namespace of a
  naming system. If the component comes from a hierarchical
  namespace, that component can be further parsed into
  its atomic parts by using the CompoundName class.

  The components of a composite name are numbered.  The indexes of a
  composite name with N components range from 0 up to, but not including, N.
  This range may be written as [0,N).
  The most significant component is at index 0.
  An empty composite name has no components.

  JNDI Composite Name Syntax
  JNDI defines a standard string representation for composite names. This
  representation is the concatenation of the components of a composite name
  from left to right using the component separator (a forward
  slash character (/)) to separate each component.
  The JNDI syntax defines the following meta characters:

  escape (backward slash \),
  quote characters  (single (') and double quotes (`)), and
  component separator (forward slash character (/)).

  Any occurrence of a leading quote, an escape preceding any meta character,
  an escape at the end of a component, or a component separator character
  in an unquoted component must be preceded by an escape character when
  that component is being composed into a composite name string.
  Alternatively, to avoid adding escape characters as described,
  the entire component can be quoted using matching single quotes
  or matching double quotes. A single quote occurring within a double-quoted
  component is not considered a meta character (and need not be escaped),
  and vice versa.

  When two composite names are compared, the case of the characters
  is significant.

  A leading component separator (the composite name string begins with
  a separator) denotes a leading empty component (a component consisting
  of an empty string).
  A trailing component separator (the composite name string ends with
  a separator) denotes a trailing empty component.
  Adjacent component separators denote an empty component.

 Composite Name Examples
 This table shows examples of some composite names. Each row shows
 the string form of a composite name and its corresponding structural form
 (CompositeName).




 String Name
 CompositeName




 ``

 {} (the empty name == new CompositeName(``) == new CompositeName())





 `x`

 {`x`}





 `x/y`

 {`x`, `y`}



 `x/`
 {`x`, ``}



 `/x`
 {``, `x`}



 `/`
 {``}



 `//`
 {``, ``}


 `/x/`
 {``, `x`, ``}


 `x//y`
 {`x`, ``, `y`}



 Composition Examples
  Here are some composition examples.  The right column shows composing
  string composite names while the left column shows composing the
  corresponding CompositeNames.  Notice that composing the
  string forms of two composite names simply involves concatenating
  their string forms together.




 String Names
 CompositeNames




 `x/y`            `/`   = x/y/


 {`x`, `y`}       {``}  = {`x`, `y`, ``}





 ``               `x`   = `x`


 {}               {`x`} = {`x`}





 `/`              `x`   = `/x`


 {``}             {`x`} = {``, `x`}





 `x`    ``       ``    = `x`


 {`x`}  {}       {}    = {`x`}





 Multithreaded Access
  A CompositeName instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify a
  CompositeName should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming CompositeName]))

(defn ->composite-name
  "Constructor.

  Constructs a new composite name instance by parsing the string n
   using the composite name syntax (left-to-right, slash separated).
   The composite name syntax is described in detail in the class
   description.

  n - The non-null string to parse. - `java.lang.String`

  throws: javax.naming.InvalidNameException - If n has invalid composite name syntax."
  ([^java.lang.String n]
    (new CompositeName n))
  ([]
    (new CompositeName )))

(defn add-all
  "Adds the components of a composite name -- in order -- at a specified
   position within this composite name.
   Components of this composite name at or after the index of the first
   new component are shifted up (away from index 0)
   to accommodate the new components.

  posn - The index in this name at which to add the new components. Must be in the range [0,size()]. - `int`
  n - The non-null components to add. - `javax.naming.Name`

  returns: The updated CompositeName, not a new one. Cannot be null. - `javax.naming.Name`

  throws: javax.naming.InvalidNameException - If n is not a composite name."
  (^javax.naming.Name [^javax.naming.CompositeName this ^Integer posn ^javax.naming.Name n]
    (-> this (.addAll posn n)))
  (^javax.naming.Name [^javax.naming.CompositeName this ^javax.naming.Name suffix]
    (-> this (.addAll suffix))))

(defn ends-with
  "Determines whether a composite name is a suffix of this composite name.
   A composite name 'n' is a suffix if it it is equal to
   getSuffix(size()-n.size())--in other words, this
   composite name ends with 'n'.
   If n is null or not a composite name, false is returned.

  n - The possibly null name to check. - `javax.naming.Name`

  returns: true if n is a CompositeName and
           is a suffix of this composite name, false otherwise. - `boolean`"
  (^Boolean [^javax.naming.CompositeName this ^javax.naming.Name n]
    (-> this (.endsWith n))))

(defn get-suffix
  "Creates a composite name whose components consist of a suffix of the
   components in this composite name. Subsequent changes to
   this composite name does not affect the name that is returned.

  posn - The 0-based index of the component at which to start. Must be in the range [0,size()]. - `int`

  returns: A composite name consisting of the components at indexes in
           the range [posn,size()).  If posn is equal to
           size(), an empty composite name is returned. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^javax.naming.CompositeName this ^Integer posn]
    (-> this (.getSuffix posn))))

(defn get-all
  "Retrieves the components of this composite name as an enumeration
   of strings.
   The effects of updates to this composite name on this enumeration
   is undefined.

  returns: A non-null enumeration of the components of
           this composite name. Each element of the enumeration is of
           class String. - `java.util.Enumeration<java.lang.String>`"
  (^java.util.Enumeration [^javax.naming.CompositeName this]
    (-> this (.getAll))))

(defn to-string
  "Generates the string representation of this composite name.
   The string representation consists of enumerating in order
   each component of the composite name and separating
   each component by a forward slash character. Quoting and
   escape characters are applied where necessary according to
   the JNDI syntax, which is described in the class description.
   An empty component is represented by an empty string.

   The string representation thus generated can be passed to
   the CompositeName constructor to create a new equivalent
   composite name.

  returns: A non-null string representation of this composite name. - `java.lang.String`"
  (^java.lang.String [^javax.naming.CompositeName this]
    (-> this (.toString))))

(defn remove
  "Deletes a component from this composite name.
   The component of this composite name at position 'posn' is removed,
   and components at indices greater than 'posn'
   are shifted down (towards index 0) by one.

  posn - The index of the component to delete. Must be in the range [0,size()). - `int`

  returns: The component removed (a String). - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range (includes case where composite name is empty)."
  (^java.lang.Object [^javax.naming.CompositeName this ^Integer posn]
    (-> this (.remove posn))))

(defn starts-with
  "Determines whether a composite name is a prefix of this composite name.
   A composite name 'n' is a prefix if it is equal to
   getPrefix(n.size())--in other words, this composite name
   starts with 'n'. If 'n' is null or not a composite name, false is returned.

  n - The possibly null name to check. - `javax.naming.Name`

  returns: true if n is a CompositeName and
           is a prefix of this composite name, false otherwise. - `boolean`"
  (^Boolean [^javax.naming.CompositeName this ^javax.naming.Name n]
    (-> this (.startsWith n))))

(defn clone
  "Generates a copy of this composite name.
   Changes to the components of this composite name won't
   affect the new copy and vice versa.

  returns: A non-null copy of this composite name. - `java.lang.Object`"
  (^java.lang.Object [^javax.naming.CompositeName this]
    (-> this (.clone))))

(defn hash-code
  "Computes the hash code of this composite name.
   The hash code is the sum of the hash codes of individual components
   of this composite name.

  returns: An int representing the hash code of this name. - `int`"
  (^Integer [^javax.naming.CompositeName this]
    (-> this (.hashCode))))

(defn add
  "Adds a single component at a specified position within this
   composite name.
   Components of this composite name at or after the index of the new
   component are shifted up by one (away from index 0) to accommodate
   the new component.

  posn - The index at which to add the new component. Must be in the range [0,size()]. - `int`
  comp - The non-null component to add. - `java.lang.String`

  returns: The updated CompositeName, not a new one. Cannot be null. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^javax.naming.CompositeName this ^Integer posn ^java.lang.String comp]
    (-> this (.add posn comp)))
  (^javax.naming.Name [^javax.naming.CompositeName this ^java.lang.String comp]
    (-> this (.add comp))))

(defn empty?
  "Determines whether this composite name is empty. A composite name
   is empty if it has zero components.

  returns: true if this composite name is empty, false otherwise. - `boolean`"
  (^Boolean [^javax.naming.CompositeName this]
    (-> this (.isEmpty))))

(defn size
  "Retrieves the number of components in this composite name.

  returns: The nonnegative number of components in this composite name. - `int`"
  (^Integer [^javax.naming.CompositeName this]
    (-> this (.size))))

(defn compare-to
  "Compares this CompositeName with the specified Object for order.
   Returns a
   negative integer, zero, or a positive integer as this Name is less
   than, equal to, or greater than the given Object.

   If obj is null or not an instance of CompositeName, ClassCastException
   is thrown.

   See equals() for what it means for two composite names to be equal.
   If two composite names are equal, 0 is returned.

   Ordering of composite names follows the lexicographical rules for
   string comparison, with the extension that this applies to all
   the components in the composite name. The effect is as if all the
   components were lined up in their specified ordered and the
   lexicographical rules applied over the two line-ups.
   If this composite name is `lexicographically` lesser than obj,
   a negative number is returned.
   If this composite name is `lexicographically` greater than obj,
   a positive number is returned.

  obj - The non-null object to compare against. - `java.lang.Object`

  returns: a negative integer, zero, or a positive integer as this Name
            is less than, equal to, or greater than the given Object. - `int`

  throws: java.lang.ClassCastException - if obj is not a CompositeName."
  (^Integer [^javax.naming.CompositeName this ^java.lang.Object obj]
    (-> this (.compareTo obj))))

(defn get-prefix
  "Creates a composite name whose components consist of a prefix of the
   components in this composite name. Subsequent changes to
   this composite name does not affect the name that is returned.

  posn - The 0-based index of the component at which to stop. Must be in the range [0,size()]. - `int`

  returns: A composite name consisting of the components at indexes in
           the range [0,posn). - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^javax.naming.CompositeName this ^Integer posn]
    (-> this (.getPrefix posn))))

(defn get
  "Retrieves a component of this composite name.

  posn - The 0-based index of the component to retrieve. Must be in the range [0,size()). - `int`

  returns: The non-null component at index posn. - `java.lang.String`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range."
  (^java.lang.String [^javax.naming.CompositeName this ^Integer posn]
    (-> this (.get posn))))

(defn equals
  "Determines whether two composite names are equal.
   If obj is null or not a composite name, false is returned.
   Two composite names are equal if each component in one is equal
   to the corresponding component in the other. This implies
   both have the same number of components, and each component's
   equals() test against the corresponding component in the other name
   returns true.

  obj - The possibly null object to compare against. - `java.lang.Object`

  returns: true if obj is equal to this composite name, false otherwise. - `boolean`"
  (^Boolean [^javax.naming.CompositeName this ^java.lang.Object obj]
    (-> this (.equals obj))))

