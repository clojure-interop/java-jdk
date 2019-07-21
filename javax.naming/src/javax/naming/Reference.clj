(ns javax.naming.Reference
  "This class represents a reference to an object that is found outside of
  the naming/directory system.

  Reference provides a way of recording address information about
  objects which themselves are not directly bound to the naming/directory system.

  A Reference consists of an ordered list of addresses and class information
  about the object being referenced.
  Each address in the list identifies a communications endpoint
  for the same conceptual object.  The \"communications endpoint\"
  is information that indicates how to contact the object. It could
  be, for example, a network address, a location in memory on the
  local machine, another process on the same machine, etc.
  The order of the addresses in the list may be of significance
  to object factories that interpret the reference.

  Multiple addresses may arise for
  various reasons, such as replication or the object offering interfaces
  over more than one communication mechanism.  The addresses are indexed
  starting with zero.

  A Reference also contains information to assist in creating an instance
  of the object to which this Reference refers.  It contains the class name
  of that object, and the class name and location of the factory to be used
  to create the object.
  The class factory location is a space-separated list of URLs representing
  the class path used to load the factory.  When the factory class (or
  any class or resource upon which it depends) needs to be loaded,
  each URL is used (in order) to attempt to load the class.

  A Reference instance is not synchronized against concurrent access by multiple
  threads. Threads that need to access a single Reference concurrently should
  synchronize amongst themselves and provide the necessary locking."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming Reference]))

(defn ->reference
  "Constructor.

  Constructs a new reference for an object with class name 'className',
   the class name and location of the object's factory, and the address for
   the object.

  class-name - The non-null class name of the object to which this reference refers. - `java.lang.String`
  addr - The non-null address of the object. - `javax.naming.RefAddr`
  factory - The possibly null class name of the object's factory. - `java.lang.String`
  factory-location - The possibly null location from which to load the factory (e.g. URL) - `java.lang.String`"
  (^Reference [^java.lang.String class-name ^javax.naming.RefAddr addr ^java.lang.String factory ^java.lang.String factory-location]
    (new Reference class-name addr factory factory-location))
  (^Reference [^java.lang.String class-name ^java.lang.String factory ^java.lang.String factory-location]
    (new Reference class-name factory factory-location))
  (^Reference [^java.lang.String class-name ^javax.naming.RefAddr addr]
    (new Reference class-name addr))
  (^Reference [^java.lang.String class-name]
    (new Reference class-name)))

(defn get-class-name
  "Retrieves the class name of the object to which this reference refers.

  returns: The non-null fully-qualified class name of the object.
           (e.g. \"java.lang.String\") - `java.lang.String`"
  (^java.lang.String [^Reference this]
    (-> this (.getClassName))))

(defn get-all
  "Retrieves an enumeration of the addresses in this reference.
   When addresses are added, changed or removed from this reference,
   its effects on this enumeration are undefined.

  returns: An non-null enumeration of the addresses
           (RefAddr) in this reference.
           If this reference has zero addresses, an enumeration with
           zero elements is returned. - `java.util.Enumeration<javax.naming.RefAddr>`"
  (^java.util.Enumeration [^Reference this]
    (-> this (.getAll))))

(defn to-string
  "Generates the string representation of this reference.
   The string consists of the class name to which this reference refers,
   and the string representation of each of its addresses.
   This representation is intended for display only and not to be parsed.

  returns: The non-null string representation of this reference. - `java.lang.String`"
  (^java.lang.String [^Reference this]
    (-> this (.toString))))

(defn remove
  "Deletes the address at index posn from the list of addresses.
   All addresses at index greater than posn are shifted down
   the list by one (towards index 0).

  posn - The 0-based index of in address to delete. - `int`

  returns: The address removed. - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn not in the specified range."
  (^java.lang.Object [^Reference this ^Integer posn]
    (-> this (.remove posn))))

(defn clone
  "Makes a copy of this reference using its class name
   list of addresses, class factory name and class factory location.
   Changes to the newly created copy does not affect this Reference
   and vice versa.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^Reference this]
    (-> this (.clone))))

(defn get-factory-class-name
  "Retrieves the class name of the factory of the object
   to which this reference refers.

  returns: The possibly null fully-qualified class name of the factory.
           (e.g. \"java.lang.String\") - `java.lang.String`"
  (^java.lang.String [^Reference this]
    (-> this (.getFactoryClassName))))

(defn hash-code
  "Computes the hash code of this reference.
   The hash code is the sum of the hash code of its addresses.

  returns: A hash code of this reference as an int. - `int`"
  (^Integer [^Reference this]
    (-> this (.hashCode))))

(defn add
  "Adds an address to the list of addresses at index posn.
   All addresses at index posn or greater are shifted up
   the list by one (away from index 0).

  posn - The 0-based index of the list to insert addr. - `int`
  addr - The non-null address to add. - `javax.naming.RefAddr`

  throws: java.lang.ArrayIndexOutOfBoundsException - If posn not in the specified range."
  ([^Reference this ^Integer posn ^javax.naming.RefAddr addr]
    (-> this (.add posn addr)))
  ([^Reference this ^javax.naming.RefAddr addr]
    (-> this (.add addr))))

(defn get-factory-class-location
  "Retrieves the location of the factory of the object
   to which this reference refers.
   If it is a codebase, then it is an ordered list of URLs,
   separated by spaces, listing locations from where the factory
   class definition should be loaded.

  returns: The possibly null string containing the
                   location for loading in the factory's class. - `java.lang.String`"
  (^java.lang.String [^Reference this]
    (-> this (.getFactoryClassLocation))))

(defn size
  "Retrieves the number of addresses in this reference.

  returns: The nonnegative number of addresses in this reference. - `int`"
  (^Integer [^Reference this]
    (-> this (.size))))

(defn clear
  "Deletes all addresses from this reference."
  ([^Reference this]
    (-> this (.clear))))

(defn get
  "Retrieves the first address that has the address type 'addrType'.
   String.compareTo() is used to test the equality of the address types.

  addr-type - The non-null address type for which to find the address. - `java.lang.String`

  returns: The address in this reference with address type 'addrType;
           null if no such address exist. - `javax.naming.RefAddr`"
  (^javax.naming.RefAddr [^Reference this ^java.lang.String addr-type]
    (-> this (.get addr-type))))

(defn equals
  "Determines whether obj is a reference with the same addresses
   (in same order) as this reference.
   The addresses are checked using RefAddr.equals().
   In addition to having the same addresses, the Reference also needs to
   have the same class name as this reference.
   The class factory and class factory location are not checked.
   If obj is null or not an instance of Reference, null is returned.

  obj - The possibly null object to check. - `java.lang.Object`

  returns: true if obj is equal to this reference; false otherwise. - `boolean`"
  (^Boolean [^Reference this ^java.lang.Object obj]
    (-> this (.equals obj))))

