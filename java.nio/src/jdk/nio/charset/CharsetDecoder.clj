(ns jdk.nio.charset.CharsetDecoder
  "An engine that can transform a sequence of bytes in a specific charset into a sequence of
  sixteen-bit Unicode characters.



   The input byte sequence is provided in a byte buffer or a series
  of such buffers.  The output character sequence is written to a character buffer
  or a series of such buffers.  A decoder should always be used by making
  the following sequence of method invocations, hereinafter referred to as a
  decoding operation:



     Reset the decoder via the reset method, unless it
    has not been used before;

     Invoke the decode method zero or more times, as
    long as additional input may be available, passing false for the
    endOfInput argument and filling the input buffer and flushing the
    output buffer between invocations;

     Invoke the decode method one final time, passing
    true for the endOfInput argument; and then

     Invoke the flush method so that the decoder can
    flush any internal state to the output buffer.



  Each invocation of the decode method will decode as many
  bytes as possible from the input buffer, writing the resulting characters
  to the output buffer.  The decode method returns when more
  input is required, when there is not enough room in the output buffer, or
  when a decoding error has occurred.  In each case a CoderResult
  object is returned to describe the reason for termination.  An invoker can
  examine this object and fill the input buffer, flush the output buffer, or
  attempt to recover from a decoding error, as appropriate, and try again.



   There are two general types of decoding errors.  If the input byte
  sequence is not legal for this charset then the input is considered malformed.  If
  the input byte sequence is legal but cannot be mapped to a valid
  Unicode character then an unmappable character has been encountered.



   How a decoding error is handled depends upon the action requested for
  that type of error, which is described by an instance of the CodingErrorAction class.  The possible error actions are to ignore the erroneous input, report the error to the invoker via
  the returned CoderResult object, or replace the erroneous input with the current value of the
  replacement string.  The replacement






  has the initial value `\uFFFD`;


  its value may be changed via the replaceWith method.

   The default action for malformed-input and unmappable-character errors
  is to report them.  The
  malformed-input error action may be changed via the onMalformedInput method; the
  unmappable-character action may be changed via the onUnmappableCharacter method.

   This class is designed to handle many of the details of the decoding
  process, including the implementation of error actions.  A decoder for a
  specific charset, which is a concrete subclass of this class, need only
  implement the abstract decodeLoop method, which
  encapsulates the basic decoding loop.  A subclass that maintains internal
  state should, additionally, override the implFlush and
  implReset methods.

   Instances of this class are not safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CharsetDecoder]))

(defn average-chars-per-byte
  "Returns the average number of characters that will be produced for each
   byte of input.  This heuristic value may be used to estimate the size
   of the output buffer required for a given input sequence.

  returns: The average number of characters produced
            per byte of input - `float`"
  ([this]
    (-> this (.averageCharsPerByte))))

(defn on-unmappable-character
  "Changes this decoder's action for unmappable-character errors.

    This method invokes the implOnUnmappableCharacter method, passing the new action.

  new-action - The new action; must not be null - `java.nio.charset.CodingErrorAction`

  returns: This decoder - `java.nio.charset.CharsetDecoder`

  throws: java.lang.IllegalArgumentException - If the precondition on the parameter does not hold"
  ([this new-action]
    (-> this (.onUnmappableCharacter new-action))))

(defn unmappable-character-action
  "Returns this decoder's current action for unmappable-character errors.

  returns: The current unmappable-character action, which is never
           null - `java.nio.charset.CodingErrorAction`"
  ([this]
    (-> this (.unmappableCharacterAction))))

(defn malformed-input-action
  "Returns this decoder's current action for malformed-input errors.

  returns: The current malformed-input action, which is never null - `java.nio.charset.CodingErrorAction`"
  ([this]
    (-> this (.malformedInputAction))))

(defn replacement
  "Returns this decoder's replacement value.

  returns: This decoder's current replacement,
            which is never null and is never empty - `java.lang.String`"
  ([this]
    (-> this (.replacement))))

(defn decode
  "Decodes as many bytes as possible from the given input buffer,
   writing the results to the given output buffer.

    The buffers are read from, and written to, starting at their current
   positions.  At most in.remaining() bytes
   will be read and at most out.remaining()
   characters will be written.  The buffers' positions will be advanced to
   reflect the bytes read and the characters written, but their marks and
   limits will not be modified.

    In addition to reading bytes from the input buffer and writing
   characters to the output buffer, this method returns a CoderResult
   object to describe its reason for termination:



      CoderResult.UNDERFLOW indicates that as much of the
     input buffer as possible has been decoded.  If there is no further
     input then the invoker can proceed to the next step of the
     decoding operation.  Otherwise this method
     should be invoked again with further input.

      CoderResult.OVERFLOW indicates that there is
     insufficient space in the output buffer to decode any more bytes.
     This method should be invoked again with an output buffer that has
     more remaining characters. This is
     typically done by draining any decoded characters from the output
     buffer.

      A malformed-input result indicates that a malformed-input
     error has been detected.  The malformed bytes begin at the input
     buffer's (possibly incremented) position; the number of malformed
     bytes may be determined by invoking the result object's length method.  This case applies only if the
     malformed action of this decoder
     is CodingErrorAction.REPORT; otherwise the malformed input
     will be ignored or replaced, as requested.

      An unmappable-character result indicates that an
     unmappable-character error has been detected.  The bytes that
     decode the unmappable character begin at the input buffer's (possibly
     incremented) position; the number of such bytes may be determined
     by invoking the result object's length
     method.  This case applies only if the unmappable action of this decoder is CodingErrorAction.REPORT; otherwise the unmappable character will be
     ignored or replaced, as requested.



   In any case, if this method is to be reinvoked in the same decoding
   operation then care should be taken to preserve any bytes remaining
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
   pass true so that any remaining undecoded input will be treated
   as being malformed.

    This method works by invoking the decodeLoop
   method, interpreting its results, handling error conditions, and
   reinvoking it as necessary.

  in - The input byte buffer - `java.nio.ByteBuffer`
  out - The output character buffer - `java.nio.CharBuffer`
  end-of-input - true if, and only if, the invoker can provide no additional input bytes beyond those in the given buffer - `boolean`

  returns: A coder-result object describing the reason for termination - `java.nio.charset.CoderResult`

  throws: java.lang.IllegalStateException - If a decoding operation is already in progress and the previous step was an invocation neither of the reset method, nor of this method with a value of false for the endOfInput parameter, nor of this method with a value of true for the endOfInput parameter but a return value indicating an incomplete decoding operation"
  ([this in out end-of-input]
    (-> this (.decode in out end-of-input)))
  ([this in]
    (-> this (.decode in))))

(defn replace-with
  "Changes this decoder's replacement value.

    This method invokes the implReplaceWith
   method, passing the new replacement, after checking that the new
   replacement is acceptable.

  new-replacement - The replacement value The new replacement; must not be null and must have non-zero length - `java.lang.String`

  returns: This decoder - `java.nio.charset.CharsetDecoder`

  throws: java.lang.IllegalArgumentException - If the preconditions on the parameter do not hold"
  ([this new-replacement]
    (-> this (.replaceWith new-replacement))))

(defn detected-charset
  "Retrieves the charset that was detected by this
   decoder  (optional operation).

    If this decoder implements an auto-detecting charset then this
   method returns the actual charset once it has been detected.  After that
   point, this method returns the same value for the duration of the
   current decoding operation.  If not enough input bytes have yet been
   read to determine the actual charset then this method throws an IllegalStateException.

    The default implementation of this method always throws an UnsupportedOperationException; it should be overridden by
   auto-detecting decoders to return the appropriate value.

  returns: The charset detected by this auto-detecting decoder,
            or null if the charset has not yet been determined - `java.nio.charset.Charset`

  throws: java.lang.IllegalStateException - If insufficient bytes have been read to determine a charset"
  ([this]
    (-> this (.detectedCharset))))

(defn flush
  "Flushes this decoder.

    Some decoders maintain internal state and may need to write some
   final characters to the output buffer once the overall input sequence has
   been read.

    Any additional output is written to the output buffer beginning at
   its current position.  At most out.remaining()
   characters will be written.  The buffer's position will be advanced
   appropriately, but its mark and limit will not be modified.

    If this method completes successfully then it returns CoderResult.UNDERFLOW.  If there is insufficient room in the output
   buffer then it returns CoderResult.OVERFLOW.  If this happens
   then this method must be invoked again, with an output buffer that has
   more room, in order to complete the current decoding
   operation.

    If this decoder has already been flushed then invoking this method
   has no effect.

    This method invokes the implFlush method to
   perform the actual flushing operation.

  out - The output character buffer - `java.nio.CharBuffer`

  returns: A coder-result object, either CoderResult.UNDERFLOW or
            CoderResult.OVERFLOW - `java.nio.charset.CoderResult`

  throws: java.lang.IllegalStateException - If the previous step of the current decoding operation was an invocation neither of the flush method nor of the three-argument decode method with a value of true for the endOfInput parameter"
  ([this out]
    (-> this (.flush out))))

(defn reset
  "Resets this decoder, clearing any internal state.

    This method resets charset-independent state and also invokes the
   implReset method in order to perform any
   charset-specific reset actions.

  returns: This decoder - `java.nio.charset.CharsetDecoder`"
  ([this]
    (-> this (.reset))))

(defn on-malformed-input
  "Changes this decoder's action for malformed-input errors.

    This method invokes the implOnMalformedInput method, passing the new action.

  new-action - The new action; must not be null - `java.nio.charset.CodingErrorAction`

  returns: This decoder - `java.nio.charset.CharsetDecoder`

  throws: java.lang.IllegalArgumentException - If the precondition on the parameter does not hold"
  ([this new-action]
    (-> this (.onMalformedInput new-action))))

(defn charset-detected?
  "Tells whether or not this decoder has yet detected a
   charset  (optional operation).

    If this decoder implements an auto-detecting charset then at a
   single point during a decoding operation this method may start returning
   true to indicate that a specific charset has been detected in
   the input byte sequence.  Once this occurs, the detectedCharset method may be invoked to retrieve the detected charset.

    That this method returns false does not imply that no bytes
   have yet been decoded.  Some auto-detecting decoders are capable of
   decoding some, or even all, of an input byte sequence without fixing on
   a particular charset.

    The default implementation of this method always throws an UnsupportedOperationException; it should be overridden by
   auto-detecting decoders to return true once the input charset
   has been determined.

  returns: true if, and only if, this decoder has detected a
            specific charset - `boolean`

  throws: java.lang.UnsupportedOperationException - If this decoder does not implement an auto-detecting charset"
  ([this]
    (-> this (.isCharsetDetected))))

(defn auto-detecting?
  "Tells whether or not this decoder implements an auto-detecting charset.

    The default implementation of this method always returns
   false; it should be overridden by auto-detecting decoders to
   return true.

  returns: true if, and only if, this decoder implements an
            auto-detecting charset - `boolean`"
  ([this]
    (-> this (.isAutoDetecting))))

(defn max-chars-per-byte
  "Returns the maximum number of characters that will be produced for each
   byte of input.  This value may be used to compute the worst-case size
   of the output buffer required for a given input sequence.

  returns: The maximum number of characters that will be produced per
            byte of input - `float`"
  ([this]
    (-> this (.maxCharsPerByte))))

(defn charset
  "Returns the charset that created this decoder.

  returns: This decoder's charset - `java.nio..Charset`"
  ([this]
    (-> this (.charset))))

