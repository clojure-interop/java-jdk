(ns javax.naming.CompoundName
  "This class represents a compound name -- a name from
  a hierarchical name space.
  Each component in a compound name is an atomic name.

  The components of a compound name are numbered.  The indexes of a
  compound name with N components range from 0 up to, but not including, N.
  This range may be written as [0,N).
  The most significant component is at index 0.
  An empty compound name has no components.

  Compound Name Syntax
  The syntax of a compound name is specified using a set of properties:

   jndi.syntax.direction
   Direction for parsing (\"right_to_left\", \"left_to_right\", \"flat\").
       If unspecified, defaults to \"flat\", which means the namespace is flat
       with no hierarchical structure.

   jndi.syntax.separator
   Separator between atomic name components.
       Required unless direction is \"flat\".

   jndi.syntax.ignorecase
   If present, \"true\" means ignore the case when comparing name
       components. If its value is not \"true\", or if the property is not
       present, case is considered when comparing name components.

   jndi.syntax.escape
   If present, specifies the escape string for overriding separator,
       escapes and quotes.

   jndi.syntax.beginquote
   If present, specifies the string delimiting start of a quoted string.

   jndi.syntax.endquote
   String delimiting end of quoted string.
       If present, specifies the string delimiting the end of a quoted string.
       If not present, use syntax.beginquote as end quote.
   jndi.syntax.beginquote2
   Alternative set of begin/end quotes.

   jndi.syntax.endquote2
   Alternative set of begin/end quotes.

   jndi.syntax.trimblanks
   If present, \"true\" means trim any leading and trailing whitespaces
       in a name component for comparison purposes. If its value is not
       \"true\", or if the property is not present, blanks are significant.
   jndi.syntax.separator.ava
   If present, specifies the string that separates
       attribute-value-assertions when specifying multiple attribute/value
       pairs. (e.g. \",\"  in age=65,gender=male).
   jndi.syntax.separator.typeval
   If present, specifies the string that separators attribute
               from value (e.g. \"=\" in \"age=65\")

  These properties are interpreted according to the following rules:


  In a string without quotes or escapes, any instance of the
  separator delimits two atomic names. Each atomic name is referred
  to as a component.

  A separator, quote or escape is escaped if preceded immediately
  (on the left) by the escape.

  If there are two sets of quotes, a specific begin-quote must be matched
  by its corresponding end-quote.

  A non-escaped begin-quote which precedes a component must be
  matched by a non-escaped end-quote at the end of the component.
  A component thus quoted is referred to as a
  quoted component. It is parsed by
  removing the being- and end- quotes, and by treating the intervening
  characters as ordinary characters unless one of the rules involving
  quoted components listed below applies.

  Quotes embedded in non-quoted components are treated as ordinary strings
  and need not be matched.

  A separator that is escaped or appears between non-escaped
  quotes is treated as an ordinary string and not a separator.

  An escape string within a quoted component acts as an escape only when
  followed by the corresponding end-quote string.
  This can be used to embed an escaped quote within a quoted component.

  An escaped escape string is not treated as an escape string.

  An escape string that does not precede a meta string (quotes or separator)
  and is not at the end of a component is treated as an ordinary string.

  A leading separator (the compound name string begins with
  a separator) denotes a leading empty atomic component (consisting
  of an empty string).
  A trailing separator (the compound name string ends with
  a separator) denotes a trailing empty atomic component.
  Adjacent separators denote an empty atomic component.


  The string form of the compound name follows the syntax described above.
  When the components of the compound name are turned into their
  string representation, the reserved syntax rules described above are
  applied (e.g. embedded separators are escaped or quoted)
  so that when the same string is parsed, it will yield the same components
  of the original compound name.

 Multithreaded Access
  A CompoundName instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify a
  CompoundName should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming CompoundName]))

(defn ->compound-name
  "Constructor.

  Constructs a new compound name instance by parsing the string n
   using the syntax specified by the syntax properties supplied.

  n - The non-null string to parse. - `java.lang.String`
  syntax - A non-null list of properties that specify the syntax of this compound name. See class description for contents of properties. - `java.util.Properties`

  throws: javax.naming.InvalidNameException - If 'n' violates the syntax specified by syntax."
  (^CompoundName [^java.lang.String n ^java.util.Properties syntax]
    (new CompoundName n syntax)))

(defn add-all
  "Adds the components of a compound name -- in order -- at a specified
   position within this compound name.
   Components of this compound name at or after the index of the first
   new component are shifted up (away from index 0)
   to accommodate the new components.

   Implementation note: Currently the syntax properties of suffix
    is not used or checked. They might be in the future.

  posn - The index in this name at which to add the new components. Must be in the range [0,size()]. - `int`
  n - The non-null components to add. - `javax.naming.Name`

  returns: The updated CompoundName, not a new one. Cannot be null. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^CompoundName this ^Integer posn ^javax.naming.Name n]
    (-> this (.addAll posn n)))
  (^javax.naming.Name [^CompoundName this ^javax.naming.Name suffix]
    (-> this (.addAll suffix))))

(defn ends-with
  "Determines whether a compound name is a suffix of this compound name.
   A compound name 'n' is a suffix if it it is equal to
   getSuffix(size()-n.size())--in other words, this
   compound name ends with 'n'.
   If n is null or not a compound name, false is returned.

   Implementation note: Currently the syntax properties of n
    are not used when doing the comparison. They might be in the future.

  n - The possibly null compound name to check. - `javax.naming.Name`

  returns: true if n is a CompoundName and
           is a suffix of this compound name, false otherwise. - `boolean`"
  (^Boolean [^CompoundName this ^javax.naming.Name n]
    (-> this (.endsWith n))))

(defn get-suffix
  "Creates a compound name whose components consist of a suffix of the
   components in this compound name.
   The result and this compound name share the same syntax.
   Subsequent changes to
   this compound name does not affect the name that is returned.

  posn - The 0-based index of the component at which to start. Must be in the range [0,size()]. - `int`

  returns: A compound name consisting of the components at indexes in
           the range [posn,size()).  If posn is equal to
           size(), an empty compound name is returned. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^CompoundName this ^Integer posn]
    (-> this (.getSuffix posn))))

(defn get-all
  "Retrieves the components of this compound name as an enumeration
   of strings.
   The effects of updates to this compound name on this enumeration
   is undefined.

  returns: A non-null enumeration of the components of this
   compound name. Each element of the enumeration is of class String. - `java.util.Enumeration<java.lang.String>`"
  (^java.util.Enumeration [^CompoundName this]
    (-> this (.getAll))))

(defn to-string
  "Generates the string representation of this compound name, using
   the syntax rules of the compound name. The syntax rules
   are described in the class description.
   An empty component is represented by an empty string.

   The string representation thus generated can be passed to
   the CompoundName constructor with the same syntax properties
   to create a new equivalent compound name.

  returns: A non-null string representation of this compound name. - `java.lang.String`"
  (^java.lang.String [^CompoundName this]
    (-> this (.toString))))

(defn remove
  "Deletes a component from this compound name.
   The component of this compound name at position 'posn' is removed,
   and components at indices greater than 'posn'
   are shifted down (towards index 0) by one.

  posn - The index of the component to delete. Must be in the range [0,size()). - `int`

  returns: The component removed (a String). - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range (includes case where compound name is empty)."
  (^java.lang.Object [^CompoundName this ^Integer posn]
    (-> this (.remove posn))))

(defn starts-with
  "Determines whether a compound name is a prefix of this compound name.
   A compound name 'n' is a prefix if it is equal to
   getPrefix(n.size())--in other words, this compound name
   starts with 'n'.
   If n is null or not a compound name, false is returned.

   Implementation note: Currently the syntax properties of n
    are not used when doing the comparison. They might be in the future.

  n - The possibly null compound name to check. - `javax.naming.Name`

  returns: true if n is a CompoundName and
                   is a prefix of this compound name, false otherwise. - `boolean`"
  (^Boolean [^CompoundName this ^javax.naming.Name n]
    (-> this (.startsWith n))))

(defn clone
  "Creates a copy of this compound name.
   Changes to the components of this compound name won't
   affect the new copy and vice versa.
   The clone and this compound name share the same syntax.

  returns: A non-null copy of this compound name. - `java.lang.Object`"
  (^java.lang.Object [^CompoundName this]
    (-> this (.clone))))

(defn hash-code
  "Computes the hash code of this compound name.
   The hash code is the sum of the hash codes of the \"canonicalized\"
   forms of individual components of this compound name.
   Each component is \"canonicalized\" according to the
   compound name's syntax before its hash code is computed.
   For a case-insensitive name, for example, the uppercased form of
   a name has the same hash code as its lowercased equivalent.

  returns: An int representing the hash code of this name. - `int`"
  (^Integer [^CompoundName this]
    (-> this (.hashCode))))

(defn add
  "Adds a single component at a specified position within this
   compound name.
   Components of this compound name at or after the index of the new
   component are shifted up by one (away from index 0)
   to accommodate the new component.

  posn - The index at which to add the new component. Must be in the range [0,size()]. - `int`
  comp - The non-null component to add. - `java.lang.String`

  returns: The updated CompoundName, not a new one. Cannot be null. - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^CompoundName this ^Integer posn ^java.lang.String comp]
    (-> this (.add posn comp)))
  (^javax.naming.Name [^CompoundName this ^java.lang.String comp]
    (-> this (.add comp))))

(defn empty?
  "Determines whether this compound name is empty.
   A compound name is empty if it has zero components.

  returns: true if this compound name is empty, false otherwise. - `boolean`"
  (^Boolean [^CompoundName this]
    (-> this (.isEmpty))))

(defn size
  "Retrieves the number of components in this compound name.

  returns: The nonnegative number of components in this compound name. - `int`"
  (^Integer [^CompoundName this]
    (-> this (.size))))

(defn compare-to
  "Compares this CompoundName with the specified Object for order.
   Returns a
   negative integer, zero, or a positive integer as this Name is less
   than, equal to, or greater than the given Object.

   If obj is null or not an instance of CompoundName, ClassCastException
   is thrown.

   See equals() for what it means for two compound names to be equal.
   If two compound names are equal, 0 is returned.

   Ordering of compound names depend on the syntax of the compound name.
   By default, they follow lexicographical rules for string comparison
   with the extension that this applies to all the components in the
   compound name and that comparison of individual components is
   affected by the jndi.syntax.ignorecase and jndi.syntax.trimblanks
   properties, identical to how they affect equals().
   If this compound name is \"lexicographically\" lesser than obj,
   a negative number is returned.
   If this compound name is \"lexicographically\" greater than obj,
   a positive number is returned.

   Implementation note: Currently the syntax properties of the two compound
   names are not compared when checking order. They might be in the future.

  obj - The non-null object to compare against. - `java.lang.Object`

  returns: a negative integer, zero, or a positive integer as this Name
            is less than, equal to, or greater than the given Object. - `int`

  throws: java.lang.ClassCastException - if obj is not a CompoundName."
  (^Integer [^CompoundName this ^java.lang.Object obj]
    (-> this (.compareTo obj))))

(defn get-prefix
  "Creates a compound name whose components consist of a prefix of the
   components in this compound name.
   The result and this compound name share the same syntax.
   Subsequent changes to
   this compound name does not affect the name that is returned and
   vice versa.

  posn - The 0-based index of the component at which to stop. Must be in the range [0,size()]. - `int`

  returns: A compound name consisting of the components at indexes in
           the range [0,posn). - `javax.naming.Name`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn is outside the specified range."
  (^javax.naming.Name [^CompoundName this ^Integer posn]
    (-> this (.getPrefix posn))))

(defn get
  "Retrieves a component of this compound name.

  posn - The 0-based index of the component to retrieve. Must be in the range [0,size()). - `int`

  returns: The component at index posn. - `java.lang.String`

  throws: java.lang.ArrayIndexOutOfBoundsException - if posn is outside the specified range."
  (^java.lang.String [^CompoundName this ^Integer posn]
    (-> this (.get posn))))

(defn equals
  "Determines whether obj is syntactically equal to this compound name.
   If obj is null or not a CompoundName, false is returned.
   Two compound names are equal if each component in one is \"equal\"
   to the corresponding component in the other.

   Equality is also defined in terms of the syntax of this compound name.
   The default implementation of CompoundName uses the syntax properties
   jndi.syntax.ignorecase and jndi.syntax.trimblanks when comparing
   two components for equality.  If case is ignored, two strings
   with the same sequence of characters but with different cases
   are considered equal. If blanks are being trimmed, leading and trailing
   blanks are ignored for the purpose of the comparison.

   Both compound names must have the same number of components.

   Implementation note: Currently the syntax properties of the two compound
   names are not compared for equality. They might be in the future.

  obj - The possibly null object to compare against. - `java.lang.Object`

  returns: true if obj is equal to this compound name, false otherwise. - `boolean`"
  (^Boolean [^CompoundName this ^java.lang.Object obj]
    (-> this (.equals obj))))

