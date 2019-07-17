(ns jdk.lang.management.MemoryType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management MemoryType]))

(def HEAP
  "Enum Constant.

  Heap memory type.

   The Java virtual machine has a heap
   that is the runtime data area from which
   memory for all class instances and arrays are allocated.

  type: java.lang.management.MemoryType"
  MemoryType/HEAP)

(def NON_HEAP
  "Enum Constant.

  Non-heap memory type.

   The Java virtual machine manages memory other than the heap
   (referred as non-heap memory).  The non-heap memory includes
   the method area and memory required for the internal
   processing or optimization for the Java virtual machine.
   It stores per-class structures such as a runtime
   constant pool, field and method data, and the code for
   methods and constructors.

  type: java.lang.management.MemoryType"
  MemoryType/NON_HEAP)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (MemoryType c : MemoryType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.lang.management.MemoryType[]`"
  ([]
    (MemoryType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.lang.management.MemoryType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (MemoryType/valueOf name)))

(defn to-string
  "Returns the string representation of this MemoryType.

  returns: the string representation of this MemoryType. - `java.lang.String`"
  ([^java.lang.management.MemoryType this]
    (-> this (.toString))))

