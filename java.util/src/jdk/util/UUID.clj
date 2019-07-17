(ns jdk.util.UUID
  "A class that represents an immutable universally unique identifier (UUID).
  A UUID represents a 128-bit value.

   There exist different variants of these global identifiers.  The methods
  of this class are for manipulating the Leach-Salz variant, although the
  constructors allow the creation of any variant of UUID (described below).

   The layout of a variant 2 (Leach-Salz) UUID is as follows:

  The most significant long consists of the following unsigned fields:


  0xFFFFFFFF00000000 time_low
  0x00000000FFFF0000 time_mid
  0x000000000000F000 version
  0x0000000000000FFF time_hi
  The least significant long consists of the following unsigned fields:


  0xC000000000000000 variant
  0x3FFF000000000000 clock_seq
  0x0000FFFFFFFFFFFF node

   The variant field contains a value which identifies the layout of the
  UUID.  The bit layout described above is valid only for a UUID with a variant value of 2, which indicates the Leach-Salz variant.

   The version field holds a value that describes the type of this UUID.  There are four different basic types of UUIDs: time-based, DCE
  security, name-based, and randomly generated UUIDs.  These types have a
  version value of 1, 2, 3 and 4, respectively.

   For more information including algorithms used to create UUIDs,
  see  RFC 4122: A
  Universally Unique IDentifier (UUID) URN Namespace, section 4.2
  `Algorithms for Creating a Time-Based UUID`."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util UUID]))

(defn ->uuid
  "Constructor.

  Constructs a new UUID using the specified data.  mostSigBits is used for the most significant 64 bits of the UUID and leastSigBits becomes the least significant 64 bits of
   the UUID.

  most-sig-bits - The most significant bits of the UUID - `long`
  least-sig-bits - The least significant bits of the UUID - `long`"
  ([^Long most-sig-bits ^Long least-sig-bits]
    (new UUID most-sig-bits least-sig-bits)))

(defn *random-uuid
  "Static factory to retrieve a type 4 (pseudo randomly generated) UUID.

   The UUID is generated using a cryptographically strong pseudo
   random number generator.

  returns: A randomly generated UUID - `java.util.UUID`"
  ([]
    (UUID/randomUUID )))

(defn *name-uuid-from-bytes
  "Static factory to retrieve a type 3 (name based) UUID based on
   the specified byte array.

  name - A byte array to be used to construct a UUID - `byte[]`

  returns: A UUID generated from the specified array - `java.util.UUID`"
  ([name]
    (UUID/nameUUIDFromBytes name)))

(defn *from-string
  "Creates a UUID from the string standard representation as
   described in the toString() method.

  name - A string that specifies a UUID - `java.lang.String`

  returns: A UUID with the specified value - `java.util.UUID`

  throws: java.lang.IllegalArgumentException - If name does not conform to the string representation as described in toString()"
  ([^java.lang.String name]
    (UUID/fromString name)))

(defn get-least-significant-bits
  "Returns the least significant 64 bits of this UUID's 128 bit value.

  returns: The least significant 64 bits of this UUID's 128 bit value - `long`"
  ([^java.util.UUID this]
    (-> this (.getLeastSignificantBits))))

(defn clock-sequence
  "The clock sequence value associated with this UUID.

    The 14 bit clock sequence value is constructed from the clock
   sequence field of this UUID.  The clock sequence field is used to
   guarantee temporal uniqueness in a time-based UUID.

    The clockSequence value is only meaningful in a time-based
   UUID, which has version type 1.  If this UUID is not a time-based UUID
   then this method throws UnsupportedOperationException.

  returns: The clock sequence of this UUID - `int`

  throws: java.lang.UnsupportedOperationException - If this UUID is not a version 1 UUID"
  ([^java.util.UUID this]
    (-> this (.clockSequence))))

(defn timestamp
  "The timestamp value associated with this UUID.

    The 60 bit timestamp value is constructed from the time_low,
   time_mid, and time_hi fields of this UUID.  The resulting
   timestamp is measured in 100-nanosecond units since midnight,
   October 15, 1582 UTC.

    The timestamp value is only meaningful in a time-based UUID, which
   has version type 1.  If this UUID is not a time-based UUID then
   this method throws UnsupportedOperationException.

  returns: The timestamp of this UUID. - `long`

  throws: java.lang.UnsupportedOperationException - If this UUID is not a version 1 UUID"
  ([^java.util.UUID this]
    (-> this (.timestamp))))

(defn to-string
  "Returns a String object representing this UUID.

    The UUID string representation is as described by this BNF:


   UUID                   = <time_low> `-` <time_mid> `-`
                            <time_high_and_version> `-`
                            <variant_and_sequence> `-`
                            <node>
   time_low               = 4*<hexOctet>
   time_mid               = 2*<hexOctet>
   time_high_and_version  = 2*<hexOctet>
   variant_and_sequence   = 2*<hexOctet>
   node                   = 6*<hexOctet>
   hexOctet               = <hexDigit><hexDigit>
   hexDigit               =
         `0` | `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9`
         | `a` | `b` | `c` | `d` | `e` | `f`
         | `A` | `B` | `C` | `D` | `E` | `F`

  returns: A string representation of this UUID - `java.lang.String`"
  ([^java.util.UUID this]
    (-> this (.toString))))

(defn get-most-significant-bits
  "Returns the most significant 64 bits of this UUID's 128 bit value.

  returns: The most significant 64 bits of this UUID's 128 bit value - `long`"
  ([^java.util.UUID this]
    (-> this (.getMostSignificantBits))))

(defn version
  "The version number associated with this UUID.  The version
   number describes how this UUID was generated.

   The version number has the following meaning:

   1    Time-based UUID
   2    DCE security UUID
   3    Name-based UUID
   4    Randomly generated UUID

  returns: The version number of this UUID - `int`"
  ([^java.util.UUID this]
    (-> this (.version))))

(defn hash-code
  "Returns a hash code for this UUID.

  returns: A hash code value for this UUID - `int`"
  ([^java.util.UUID this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this UUID with the specified UUID.

    The first of two UUIDs is greater than the second if the most
   significant field in which the UUIDs differ is greater for the first
   UUID.

  val - UUID to which this UUID is to be compared - `java.util.UUID`

  returns: -1, 0 or 1 as this UUID is less than, equal to, or
            greater than val - `int`"
  ([^java.util.UUID this ^java.util.UUID val]
    (-> this (.compareTo val))))

(defn equals
  "Compares this object to the specified object.  The result is true if and only if the argument is not null, is a UUID
   object, has the same variant, and contains the same value, bit for bit,
   as this UUID.

  obj - The object to be compared - `java.lang.Object`

  returns: true if the objects are the same; false
            otherwise - `boolean`"
  ([^java.util.UUID this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn variant
  "The variant number associated with this UUID.  The variant
   number describes the layout of the UUID.

   The variant number has the following meaning:

   0    Reserved for NCS backward compatibility
   2    IETF RFC 4122
   (Leach-Salz), used by this class
   6    Reserved, Microsoft Corporation backward compatibility
   7    Reserved for future definition

  returns: The variant number of this UUID - `int`"
  ([^java.util.UUID this]
    (-> this (.variant))))

(defn node
  "The node value associated with this UUID.

    The 48 bit node value is constructed from the node field of this
   UUID.  This field is intended to hold the IEEE 802 address of the machine
   that generated this UUID to guarantee spatial uniqueness.

    The node value is only meaningful in a time-based UUID, which has
   version type 1.  If this UUID is not a time-based UUID then this method
   throws UnsupportedOperationException.

  returns: The node value of this UUID - `long`

  throws: java.lang.UnsupportedOperationException - If this UUID is not a version 1 UUID"
  ([^java.util.UUID this]
    (-> this (.node))))

