(ns jdk.nio.charset.CharsetEncoder
  "An engine that can transform a sequence of sixteen-bit Unicode characters into a sequence of
  bytes in a specific charset.



   The input character sequence is provided in a character buffer or a series
  of such buffers.  The output byte sequence is written to a byte buffer
  or a series of such buffers.  An encoder should always be used by making
  the following sequence of method invocations, hereinafter referred to as an
  encoding operation:



     Reset the encoder via the reset method, unless it
    has not been used before;

     Invoke the encode method zero or more times, as
    long as additional input may be available, passing false for the
    endOfInput argument and filling the input buffer and flushing the
    output buffer between invocations;

     Invoke the encode method one final time, passing
    true for the endOfInput argument; and then

     Invoke the flush method so that the encoder can
    flush any internal state to the output buffer.



  Each invocation of the encode method will encode as many
  characters as possible from the input buffer, writing the resulting bytes
  to the output buffer.  The encode method returns when more
  input is required, when there is not enough room in the output buffer, or
  when an encoding error has occurred.  In each case a CoderResult
  object is returned to describe the reason for termination.  An invoker can
  examine this object and fill the input buffer, flush the output buffer, or
  attempt to recover from an encoding error, as appropriate, and try again.



   There are two general types of encoding errors.  If the input character
  sequence is not a legal sixteen-bit Unicode sequence then the input is considered malformed.  If
  the input character sequence is legal but cannot be mapped to a valid
  byte sequence in the given charset then an unmappable character has been encountered.



   How an encoding error is handled depends upon the action requested for
  that type of error, which is described by an instance of the CodingErrorAction class.  The possible error actions are to ignore the erroneous input, report the error to the invoker via
  the returned CoderResult object, or replace the erroneous input with the current value of the
  replacement byte array.  The replacement


  is initially set to the encoder's default replacement, which often
  (but not always) has the initial value { (byte)'?' };





  its value may be changed via the replaceWith method.

   The default action for malformed-input and unmappable-character errors
  is to report them.  The
  malformed-input error action may be changed via the onMalformedInput method; the
  unmappable-character action may be changed via the onUnmappableCharacter method.

   This class is designed to handle many of the details of the encoding
  process, including the implementation of error actions.  An encoder for a
  specific charset, which is a concrete subclass of this class, need only
  implement the abstract encodeLoop method, which
  encapsulates the basic encoding loop.  A subclass that maintains internal
  state should, additionally, override the implFlush and
  implReset methods.

   Instances of this class are not safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CharsetEncoder]))

(defn on-unmappable-character
  "Changes this encoder's action for unmappable-character errors.

    This method invokes the implOnUnmappableCharacter method, passing the new action.

  new-action - The new action; must not be null - `java.nio.charset.CodingErrorAction`

  returns: This encoder - `java.nio.charset.CharsetEncoder`

  throws: java.lang.IllegalArgumentException - If the precondition on the parameter does not hold"
  ([^java.nio.charset.CharsetEncoder this ^java.nio.charset.CodingErrorAction new-action]
    (-> this (.onUnmappableCharacter new-action))))

(defn legal-replacement?
  "Tells whether or not the given byte array is a legal replacement value
   for this encoder.

    A replacement is legal if, and only if, it is a legal sequence of
   bytes in this encoder's charset; that is, it must be possible to decode
   the replacement into one or more sixteen-bit Unicode characters.

    The default implementation of this method is not very efficient; it
   should generally be overridden to improve performance.

  repl - The byte array to be tested - `byte[]`

  returns: true if, and only if, the given byte array
            is a legal replacement value for this encoder - `boolean`"
  ([^java.nio.charset.CharsetEncoder this repl]
    (-> this (.isLegalReplacement repl))))

(defn unmappable-character-action
  "Returns this encoder's current action for unmappable-character errors.

  returns: The current unmappable-character action, which is never
           null - `java.nio.charset.CodingErrorAction`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.unmappableCharacterAction))))

(defn can-encode?
  "Tells whether or not this encoder can encode the given character.

    This method returns false if the given character is a
   surrogate character; such characters can be interpreted only when they
   are members of a pair consisting of a high surrogate followed by a low
   surrogate.  The canEncode(CharSequence) method may be used to test whether or not a
   character sequence can be encoded.

    This method may modify this encoder's state; it should therefore not
   be invoked if an encoding operation is already in
   progress.

    The default implementation of this method is not very efficient; it
   should generally be overridden to improve performance.

  c - The given character - `char`

  returns: true if, and only if, this encoder can encode
            the given character - `boolean`

  throws: java.lang.IllegalStateException - If an encoding operation is already in progress"
  ([^java.nio.charset.CharsetEncoder this ^Character c]
    (-> this (.canEncode c))))

(defn malformed-input-action
  "Returns this encoder's current action for malformed-input errors.

  returns: The current malformed-input action, which is never null - `java.nio.charset.CodingErrorAction`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.malformedInputAction))))

(defn average-bytes-per-char
  "Returns the average number of bytes that will be produced for each
   character of input.  This heuristic value may be used to estimate the size
   of the output buffer required for a given input sequence.

  returns: The average number of bytes produced
            per character of input - `float`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.averageBytesPerChar))))

(defn replacement
  "Returns this encoder's replacement value.

  returns: This encoder's current replacement,
            which is never null and is never empty - `byte[]`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.replacement))))

(defn replace-with
  "Changes this encoder's replacement value.

    This method invokes the implReplaceWith
   method, passing the new replacement, after checking that the new
   replacement is acceptable.

  new-replacement - The replacement value The new replacement; must not be null, must have non-zero length, must not be longer than the value returned by the maxBytesPerChar method, and must be legal - `byte[]`

  returns: This encoder - `java.nio.charset.CharsetEncoder`

  throws: java.lang.IllegalArgumentException - If the preconditions on the parameter do not hold"
  ([^java.nio.charset.CharsetEncoder this new-replacement]
    (-> this (.replaceWith new-replacement))))

(defn flush
  "Flushes this encoder.

    Some encoders maintain internal state and may need to write some
   final bytes to the output buffer once the overall input sequence has
   been read.

    Any additional output is written to the output buffer beginning at
   its current position.  At most out.remaining()
   bytes will be written.  The buffer's position will be advanced
   appropriately, but its mark and limit will not be modified.

    If this method completes successfully then it returns CoderResult.UNDERFLOW.  If there is insufficient room in the output
   buffer then it returns CoderResult.OVERFLOW.  If this happens
   then this method must be invoked again, with an output buffer that has
   more room, in order to complete the current encoding
   operation.

    If this encoder has already been flushed then invoking this method
   has no effect.

    This method invokes the implFlush method to
   perform the actual flushing operation.

  out - The output byte buffer - `java.nio.ByteBuffer`

  returns: A coder-result object, either CoderResult.UNDERFLOW or
            CoderResult.OVERFLOW - `java.nio.charset.CoderResult`

  throws: java.lang.IllegalStateException - If the previous step of the current encoding operation was an invocation neither of the flush method nor of the three-argument encode method with a value of true for the endOfInput parameter"
  ([^java.nio.charset.CharsetEncoder this ^java.nio.ByteBuffer out]
    (-> this (.flush out))))

(defn reset
  "Resets this encoder, clearing any internal state.

    This method resets charset-independent state and also invokes the
   implReset method in order to perform any
   charset-specific reset actions.

  returns: This encoder - `java.nio.charset.CharsetEncoder`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.reset))))

(defn on-malformed-input
  "Changes this encoder's action for malformed-input errors.

    This method invokes the implOnMalformedInput method, passing the new action.

  new-action - The new action; must not be null - `java.nio.charset.CodingErrorAction`

  returns: This encoder - `java.nio.charset.CharsetEncoder`

  throws: java.lang.IllegalArgumentException - If the precondition on the parameter does not hold"
  ([^java.nio.charset.CharsetEncoder this ^java.nio.charset.CodingErrorAction new-action]
    (-> this (.onMalformedInput new-action))))

(defn max-bytes-per-char
  "Returns the maximum number of bytes that will be produced for each
   character of input.  This value may be used to compute the worst-case size
   of the output buffer required for a given input sequence.

  returns: The maximum number of bytes that will be produced per
            character of input - `float`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.maxBytesPerChar))))

(defn encode
  "Encodes as many characters as possible from the given input buffer,
   writing the results to the given output buffer.

    The buffers are read from, and written to, starting at their current
   positions.  At most in.remaining() characters
   will be read and at most out.remaining()
   bytes will be written.  The buffers' positions will be advanced to
   reflect the characters read and the bytes written, but their marks and
   limits will not be modified.

    In addition to reading characters from the input buffer and writing
   bytes to the output buffer, this method returns a CoderResult
   object to describe its reason for termination:



      CoderResult.UNDERFLOW indicates that as much of the
     input buffer as possible has been encoded.  If there is no further
     input then the invoker can proceed to the next step of the
     encoding operation.  Otherwise this method
     should be invoked again with further input.

      CoderResult.OVERFLOW indicates that there is
     insufficient space in the output buffer to encode any more characters.
     This method should be invoked again with an output buffer that has
     more remaining bytes. This is
     typically done by draining any encoded bytes from the output
     buffer.

      A malformed-input result indicates that a malformed-input
     error has been detected.  The malformed characters begin at the input
     buffer's (possibly incremented) position; the number of malformed
     characters may be determined by invoking the result object's length method.  This case applies only if the
     malformed action of this encoder
     is CodingErrorAction.REPORT; otherwise the malformed input
     will be ignored or replaced, as requested.

      An unmappable-character result indicates that an
     unmappable-character error has been detected.  The characters that
     encode the unmappable character begin at the input buffer's (possibly
     incremented) position; the number of such characters may be determined
     by invoking the result object's length
     method.  This case applies only if the unmappable action of this encoder is CodingErrorAction.REPORT; otherwise the unmappable character will be
     ignored or replaced, as requested.



   In any case, if this method is to be reinvoked in the same encoding
   operation then care should be taken to preserve any characters remaining
   in the input buffer so that they are available to the next invocation.

    The endOfInput parameter advises this method as to whether
   the invoker can provide further input beyond that contained in the given
   input buffer.  If there is a possibility of providing additional input
   then the invoker should pass false for this parameter; if there
   is no possibility of providing further input then the invoker should
   pass true.  It is not erroneous, and in fact it is quite
   common, to pass false in one invocation and later discover that
   no further input was actually available.  It is critical, however, that
   the final invocation of this method in a sequence of invocations always
   pass true so that any remaining unencoded input will be treated
   as being malformed.

    This method works by invoking the encodeLoop
   method, interpreting its results, handling error conditions, and
   reinvoking it as necessary.

  in - The input character buffer - `java.nio.CharBuffer`
  out - The output byte buffer - `java.nio.ByteBuffer`
  end-of-input - true if, and only if, the invoker can provide no additional input characters beyond those in the given buffer - `boolean`

  returns: A coder-result object describing the reason for termination - `java.nio.charset.CoderResult`

  throws: java.lang.IllegalStateException - If an encoding operation is already in progress and the previous step was an invocation neither of the reset method, nor of this method with a value of false for the endOfInput parameter, nor of this method with a value of true for the endOfInput parameter but a return value indicating an incomplete encoding operation"
  ([^java.nio.charset.CharsetEncoder this ^java.nio.CharBuffer in ^java.nio.ByteBuffer out ^Boolean end-of-input]
    (-> this (.encode in out end-of-input)))
  ([^java.nio.charset.CharsetEncoder this ^java.nio.CharBuffer in]
    (-> this (.encode in))))

(defn charset
  "Returns the charset that created this encoder.

  returns: This encoder's charset - `java.nio..Charset`"
  ([^java.nio.charset.CharsetEncoder this]
    (-> this (.charset))))

