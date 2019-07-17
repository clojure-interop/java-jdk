(ns javax.management.ObjectName
  "Represents the object name of an MBean, or a pattern that can
  match the names of several MBeans.  Instances of this class are
  immutable.

  An instance of this class can be used to represent:

  An object name
  An object name pattern, within the context of a query


  An object name consists of two parts, the domain and the key
  properties.

  The domain is a string of characters not including
  the character colon (:).  It is recommended that the domain
  should not contain the string `//`, which is reserved for future use.

  If the domain includes at least one occurrence of the wildcard
  characters asterisk (*) or question mark
  (?), then the object name is a pattern.  The asterisk
  matches any sequence of zero or more characters, while the question
  mark matches any single character.

  If the domain is empty, it will be replaced in certain contexts
  by the default domain of the MBean server in which the
  ObjectName is used.

  The key properties are an unordered set of keys and
  associated values.

  Each key is a nonempty string of characters which may
  not contain any of the characters comma (,), equals
  (=), colon, asterisk, or question mark.  The same key
  may not occur twice in a given ObjectName.

  Each value associated with a key is a string of
  characters that is either unquoted or quoted.

  An unquoted value is a possibly empty string of
  characters which may not contain any of the characters comma,
  equals, colon, or quote.

  If the unquoted value contains at least one occurrence
  of the wildcard characters asterisk or question mark, then the object
  name is a property value pattern. The asterisk matches any
  sequence of zero or more characters, while the question mark matches
  any single character.

  A quoted value consists of a quote (`),
  followed by a possibly empty string of characters, followed by
  another quote.  Within the string of characters, the backslash
  (\) has a special meaning.  It must be followed by
  one of the following characters:


  Another backslash.  The second backslash has no special
  meaning and the two characters represent a single backslash.

  The character 'n'.  The two characters represent a newline
  ('\n' in Java).

  A quote.  The two characters represent a quote, and that quote
  is not considered to terminate the quoted value. An ending closing
  quote must be present for the quoted value to be valid.

  A question mark (?) or asterisk (*).  The two characters represent
  a question mark or asterisk respectively.


  A quote may not appear inside a quoted value except immediately
  after an odd number of consecutive backslashes.

  The quotes surrounding a quoted value, and any backslashes
  within that value, are considered to be part of the value.

  If the quoted value contains at least one occurrence of
  the characters asterisk or question mark and they are not preceded
  by a backslash, then they are considered as wildcard characters and
  the object name is a property value pattern. The asterisk
  matches any sequence of zero or more characters, while the question
  mark matches any single character.

  An ObjectName may be a property list pattern. In this
  case it may have zero or more keys and associated values. It matches
  a nonpattern ObjectName whose domain matches and that contains the
  same keys and associated values, as well as possibly other keys and
  values.

  An ObjectName is a property value pattern when at least
  one of its quoted or unquoted key property values
  contains the wildcard characters asterisk or question mark as described
  above. In this case it has one or more keys and associated values, with
  at least one of the values containing wildcard characters. It matches a
  nonpattern ObjectName whose domain matches and that contains the same
  keys whose values match; if the property value pattern is also a
  property list pattern then the nonpattern ObjectName can contain
  other keys and values.

  An ObjectName is a property pattern if it is either a
  property list pattern or a property value pattern
  or both.

  An ObjectName is a pattern if its domain contains a wildcard or
  if the ObjectName is a property pattern.

  If an ObjectName is not a pattern, it must contain at least one
  key with its associated value.

  Examples of ObjectName patterns are:


  *:type=Foo,name=Bar to match names in any domain whose
      exact set of keys is type=Foo,name=Bar.
  d:type=Foo,name=Bar,* to match names in the domain
      d that have the keys type=Foo,name=Bar plus
      zero or more other keys.
  *:type=Foo,name=Bar,* to match names in any domain
      that has the keys type=Foo,name=Bar plus zero or
      more other keys.
  d:type=F?o,name=Bar will match e.g.
      d:type=Foo,name=Bar and d:type=Fro,name=Bar.
  d:type=F*o,name=Bar will match e.g.
      d:type=Fo,name=Bar and d:type=Frodo,name=Bar.
  d:type=Foo,name=`B*` will match e.g.
      d:type=Foo,name=`Bling`. Wildcards are recognized even
      inside quotes, and like other special characters can be escaped
      with \.


  An ObjectName can be written as a String with the following
  elements in order:


  The domain.
  A colon (:).
  A key property list as defined below.


  A key property list written as a String is a comma-separated
  list of elements.  Each element is either an asterisk or a key
  property.  A key property consists of a key, an equals
  (=), and the associated value.

  At most one element of a key property list may be an asterisk.
  If the key property list contains an asterisk element, the
  ObjectName is a property list pattern.

  Spaces have no special significance in a String representing an
  ObjectName.  For example, the String:


  domain: key1 = value1 , key2 = value2
  represents an ObjectName with two keys.  The name of each key
  contains six characters, of which the first and last are spaces.
  The value associated with the key ` key1 `
  also begins and ends with a space.

  In addition to the restrictions on characters spelt out above,
  no part of an ObjectName may contain a newline character
  ('\n'), whether the domain, a key, or a value, whether
  quoted or unquoted.  The newline character can be represented in a
  quoted value with the sequence \n.

  The rules on special characters and quoting apply regardless of
  which constructor is used to make an ObjectName.

  To avoid collisions between MBeans supplied by different
  vendors, a useful convention is to begin the domain name with the
  reverse DNS name of the organization that specifies the MBeans,
  followed by a period and a string whose interpretation is
  determined by that organization.  For example, MBeans specified by
  example.com  would have
  domains such as com.example.MyDomain.  This is essentially
  the same convention as for Java-language package names.

  The serialVersionUID of this class is 1081892073854801359L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ObjectName]))

(defn ->object-name
  "Constructor.

  Construct an object name with exactly one key property.

  domain - The domain part of the object name. - `java.lang.String`
  key - The attribute in the key property of the object name. - `java.lang.String`
  value - The value in the key property of the object name. - `java.lang.String`

  throws: javax.management.MalformedObjectNameException - The domain, key, or value contains an illegal character, or value does not follow the rules for quoting."
  ([domain key value]
    (new ObjectName domain key value))
  ([domain table]
    (new ObjectName domain table))
  ([name]
    (new ObjectName name)))

(def *-wildcard
  "Static Constant.

  Defines the wildcard `*:*` ObjectName.

  type: javax.management.ObjectName"
  ObjectName/WILDCARD)

(defn *get-instance
  "Return an instance of ObjectName that can be used anywhere
   an object obtained with new ObjectName(domain, key, value) can be used.  The
   returned object may be of a subclass of ObjectName.  Calling
   this method twice with the same parameters may return the same
   object or two equal but not identical objects.

  domain - The domain part of the object name. - `java.lang.String`
  key - The attribute in the key property of the object name. - `java.lang.String`
  value - The value in the key property of the object name. - `java.lang.String`

  returns: an ObjectName corresponding to the given domain,
   key, and value. - `javax.management.ObjectName`

  throws: javax.management.MalformedObjectNameException - The domain, key, or value contains an illegal character, or value does not follow the rules for quoting."
  ([domain key value]
    (ObjectName/getInstance domain key value))
  ([domain table]
    (ObjectName/getInstance domain table))
  ([name]
    (ObjectName/getInstance name)))

(defn *quote
  "Returns a quoted form of the given String, suitable for
   inclusion in an ObjectName.  The returned value can be used as
   the value associated with a key in an ObjectName.  The String
   s may contain any character.  Appropriate quoting
   ensures that the returned value is legal in an ObjectName.

   The returned value consists of a quote ('`'), a sequence of
   characters corresponding to the characters of s,
   and another quote.  Characters in s appear
   unchanged within the returned value except:


   A quote ('`') is replaced by a backslash (\) followed by a quote.
   An asterisk ('*') is replaced by a backslash (\) followed by an
   asterisk.
   A question mark ('?') is replaced by a backslash (\) followed by
   a question mark.
   A backslash ('\') is replaced by two backslashes.
   A newline character (the character '\n' in Java) is replaced
   by a backslash followed by the character '\n'.

  s - the String to be quoted. - `java.lang.String`

  returns: the quoted String. - `java.lang.String`

  throws: java.lang.NullPointerException - if s is null."
  ([s]
    (ObjectName/quote s)))

(defn *unquote
  "Returns an unquoted form of the given String.  If
   q is a String returned by quote(s),
   then unquote(q).equals(s).  If there is no String
   s for which quote(s).equals(q), then
   unquote(q) throws an IllegalArgumentException.

   These rules imply that there is a one-to-one mapping between
   quoted and unquoted forms.

  q - the String to be unquoted. - `java.lang.String`

  returns: the unquoted String. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if q could not have been returned by the quote(java.lang.String) method, for instance if it does not begin and end with a quote (`)."
  ([q]
    (ObjectName/unquote q)))

(defn domain-pattern?
  "Checks whether the object name is a pattern on the domain part.

  returns: True if the name is a domain pattern, otherwise false. - `boolean`"
  ([this]
    (-> this (.isDomainPattern))))

(defn pattern?
  "Checks whether the object name is a pattern.

   An object name is a pattern if its domain contains a
   wildcard or if the object name is a property pattern.

  returns: True if the name is a pattern, otherwise false. - `boolean`"
  ([this]
    (-> this (.isPattern))))

(defn set-m-bean-server
  "Description copied from interface: QueryExp

  mbs - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`"
  ([this mbs]
    (-> this (.setMBeanServer mbs))))

(defn get-canonical-name
  "Returns the canonical form of the name; that is, a string
   representation where the properties are sorted in lexical
   order.

   More precisely, the canonical form of the name is a String
   consisting of the domain part, a colon
   (:), the canonical key property list, and
   a pattern indication.

   The canonical key property list is the same string
   as described for getCanonicalKeyPropertyListString().

   The pattern indication is:

   empty for an ObjectName
   that is not a property list pattern;
   an asterisk for an ObjectName
   that is a property list pattern with no keys; or
   a comma and an
   asterisk (,*) for an ObjectName that is a property
   list pattern with at least one key.

  returns: The canonical form of the name. - `java.lang.String`"
  ([this]
    (-> this (.getCanonicalName))))

(defn to-string
  "Returns a string representation of the object name.  The
   format of this string is not specified, but users can expect
   that two ObjectNames return the same string if and only if they
   are equal.

  returns: a string representation of this object name. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn apply
  "Test whether this ObjectName, which may be a pattern,
   matches another ObjectName.  If name is a pattern,
   the result is false.  If this ObjectName is a pattern, the
   result is true if and only if name matches the
   pattern.  If neither this ObjectName nor name is
   a pattern, the result is true if and only if the two
   ObjectNames are equal as described for the equals(Object) method.

  name - The name of the MBean to compare to. - `javax.management.ObjectName`

  returns: True if name matches this ObjectName. - `boolean`

  throws: java.lang.NullPointerException - if name is null."
  ([this name]
    (-> this (.apply name))))

(defn property-value-pattern?
  "Checks whether the value associated with a key in a key
   property is a pattern.

  property - The property whose value is to be checked. - `java.lang.String`

  returns: True if the value associated with the given key property
   is a pattern, otherwise false. - `boolean`

  throws: java.lang.NullPointerException - If property is null."
  ([this property]
    (-> this (.isPropertyValuePattern property)))
  ([this]
    (-> this (.isPropertyValuePattern))))

(defn property-pattern?
  "Checks whether the object name is a pattern on the key properties.

   An object name is a pattern on the key properties if it is a
   pattern on the key property list (e.g. `d:k=v,*`) or on the
   property values (e.g. `d:k=*`) or on both (e.g. `d:k=*,*`).

  returns: True if the name is a property pattern, otherwise false. - `boolean`"
  ([this]
    (-> this (.isPropertyPattern))))

(defn get-key-property-list
  "Returns the key properties as a Hashtable.  The returned
   value is a Hashtable in which each key is a key in the
   ObjectName's key property list and each value is the associated
   value.

   The returned value may be unmodifiable.  If it is
   modifiable, changing it has no effect on this ObjectName.

  returns: The table of key properties. - `java.util.Hashtable<java.lang.String,java.lang.String>`"
  ([this]
    (-> this (.getKeyPropertyList))))

(defn get-key-property-list-string
  "Returns a string representation of the list of key
   properties specified at creation time.  If this ObjectName was
   constructed with the constructor ObjectName(String),
   the key properties in the returned String will be in the same
   order as in the argument to the constructor.

  returns: The key property list string.  This string is
   independent of whether the ObjectName is a pattern. - `java.lang.String`"
  ([this]
    (-> this (.getKeyPropertyListString))))

(defn get-domain
  "Returns the domain part.

  returns: The domain. - `java.lang.String`"
  ([this]
    (-> this (.getDomain))))

(defn get-canonical-key-property-list-string
  "Returns a string representation of the list of key properties,
   in which the key properties are sorted in lexical order. This
   is used in lexicographic comparisons performed in order to
   select MBeans based on their key property list.  Lexical order
   is the order implied by String.compareTo(String).

  returns: The canonical key property list string.  This string is
   independent of whether the ObjectName is a pattern. - `java.lang.String`"
  ([this]
    (-> this (.getCanonicalKeyPropertyListString))))

(defn hash-code
  "Returns a hash code for this object name.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn property-list-pattern?
  "Checks whether the object name is a pattern on the key property list.

   For example, `d:k=v,*` and `d:k=*,*` are key property list patterns
   whereas `d:k=*` is not.

  returns: True if the name is a property list pattern, otherwise false. - `boolean`"
  ([this]
    (-> this (.isPropertyListPattern))))

(defn compare-to
  "Compares two ObjectName instances. The ordering relation between
   ObjectNames is not completely specified but is intended to be such
   that a sorted list of ObjectNames will appear in an order that is
   convenient for a person to read.

   In particular, if the two ObjectName instances have different
   domains then their order is the lexicographical order of the domains.
   The ordering of the key property list remains unspecified.

   For example, the ObjectName instances below:

   Shapes:type=Square,name=3
   Colors:type=Red,name=2
   Shapes:type=Triangle,side=isosceles,name=2
   Colors:type=Red,name=1
   Shapes:type=Square,name=1
   Colors:type=Blue,name=1
   Shapes:type=Square,name=2
   JMImplementation:type=MBeanServerDelegate
   Shapes:type=Triangle,side=scalene,name=1

   could be ordered as follows:

   Colors:type=Blue,name=1
   Colors:type=Red,name=1
   Colors:type=Red,name=2
   JMImplementation:type=MBeanServerDelegate
   Shapes:type=Square,name=1
   Shapes:type=Square,name=2
   Shapes:type=Square,name=3
   Shapes:type=Triangle,side=scalene,name=1
   Shapes:type=Triangle,side=isosceles,name=2

  name - the ObjectName to be compared. - `javax.management.ObjectName`

  returns: a negative integer, zero, or a positive integer as this
           ObjectName is less than, equal to, or greater than the
           specified ObjectName. - `int`"
  ([this name]
    (-> this (.compareTo name))))

(defn get-key-property
  "Obtains the value associated with a key in a key property.

  property - The property whose value is to be obtained. - `java.lang.String`

  returns: The value of the property, or null if there is no such
   property in this ObjectName. - `java.lang.String`

  throws: java.lang.NullPointerException - If property is null."
  ([this property]
    (-> this (.getKeyProperty property))))

(defn equals
  "Compares the current object name with another object name.  Two
   ObjectName instances are equal if and only if their canonical
   forms are equal.  The canonical form is the string described
   for getCanonicalName().

  object - The object name that the current object name is to be compared with. - `java.lang.Object`

  returns: True if object is an ObjectName whose
   canonical form is equal to that of this ObjectName. - `boolean`"
  ([this object]
    (-> this (.equals object))))

