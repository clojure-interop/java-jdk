(ns jdk.nio.charset.CoderResult
  "A description of the result state of a coder.

   A charset coder, that is, either a decoder or an encoder, consumes bytes
  (or characters) from an input buffer, translates them, and writes the
  resulting characters (or bytes) to an output buffer.  A coding process
  terminates for one of four categories of reasons, which are described by
  instances of this class:



     Underflow is reported when there is no more input to be
    processed, or there is insufficient input and additional input is
    required.  This condition is represented by the unique result object
    UNDERFLOW, whose isUnderflow method
    returns true.

     Overflow is reported when there is insufficient room
    remaining in the output buffer.  This condition is represented by the
    unique result object OVERFLOW, whose isOverflow method returns true.

     A malformed-input error is reported when a sequence of
    input units is not well-formed.  Such errors are described by instances of
    this class whose isMalformed method returns
    true and whose length method returns the length
    of the malformed sequence.  There is one unique instance of this class for
    all malformed-input errors of a given length.

     An unmappable-character error is reported when a sequence
    of input units denotes a character that cannot be represented in the
    output charset.  Such errors are described by instances of this class
    whose isUnmappable method returns true and
    whose length method returns the length of the input
    sequence denoting the unmappable character.  There is one unique instance
    of this class for all unmappable-character errors of a given length.




   For convenience, the isError method returns true
  for result objects that describe malformed-input and unmappable-character
  errors but false for those that describe underflow or overflow
  conditions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CoderResult]))

(def *-underflow
  "Static Constant.

  Result object indicating underflow, meaning that either the input buffer
   has been completely consumed or, if the input buffer is not yet empty,
   that additional input is required.

  type: java.nio.charset.CoderResult"
  CoderResult/UNDERFLOW)

(def *-overflow
  "Static Constant.

  Result object indicating overflow, meaning that there is insufficient
   room in the output buffer.

  type: java.nio.charset.CoderResult"
  CoderResult/OVERFLOW)

(defn *malformed-for-length
  "Static factory method that returns the unique object describing a
   malformed-input error of the given length.

  length - The given length - `int`

  returns: The requested coder-result object - `java.nio.charset.CoderResult`"
  ([length]
    (CoderResult/malformedForLength length)))

(defn *unmappable-for-length
  "Static factory method that returns the unique result object describing
   an unmappable-character error of the given length.

  length - The given length - `int`

  returns: The requested coder-result object - `java.nio.charset.CoderResult`"
  ([length]
    (CoderResult/unmappableForLength length)))

(defn to-string
  "Returns a string describing this coder result.

  returns: A descriptive string - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn underflow?
  "Tells whether or not this object describes an underflow condition.

  returns: true if, and only if, this object denotes underflow - `boolean`"
  ([this]
    (-> this (.isUnderflow))))

(defn overflow?
  "Tells whether or not this object describes an overflow condition.

  returns: true if, and only if, this object denotes overflow - `boolean`"
  ([this]
    (-> this (.isOverflow))))

(defn error?
  "Tells whether or not this object describes an error condition.

  returns: true if, and only if, this object denotes either a
            malformed-input error or an unmappable-character error - `boolean`"
  ([this]
    (-> this (.isError))))

(defn malformed?
  "Tells whether or not this object describes a malformed-input error.

  returns: true if, and only if, this object denotes a
            malformed-input error - `boolean`"
  ([this]
    (-> this (.isMalformed))))

(defn unmappable?
  "Tells whether or not this object describes an unmappable-character
   error.

  returns: true if, and only if, this object denotes an
            unmappable-character error - `boolean`"
  ([this]
    (-> this (.isUnmappable))))

(defn length
  "Returns the length of the erroneous input described by this
   object  (optional operation).

  returns: The length of the erroneous input, a positive integer - `int`

  throws: java.lang.UnsupportedOperationException - If this object does not describe an error condition, that is, if the isError does not return true"
  ([this]
    (-> this (.length))))

(defn throw-exception
  "Throws an exception appropriate to the result described by this object.

  throws: java.nio.BufferUnderflowException - If this object is UNDERFLOW"
  ([this]
    (-> this (.throwException))))

