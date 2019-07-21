(ns jdk.lang.Appendable
  "An object to which char sequences and values can be appended.  The
  Appendable interface must be implemented by any class whose
  instances are intended to receive formatted output from a Formatter.

   The characters to be appended should be valid Unicode characters as
  described in Unicode Character
  Representation.  Note that supplementary characters may be composed of
  multiple 16-bit char values.

   Appendables are not necessarily safe for multithreaded access.  Thread
  safety is the responsibility of classes that extend and implement this
  interface.

   Since this interface may be implemented by existing classes
  with different styles of error handling there is no guarantee that
  errors will be propagated to the invoker."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Appendable]))

(defn append
  "Appends a subsequence of the specified character sequence to this
   Appendable.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null, behaves in
   exactly the same way as the invocation



       out.append(csq.subSequence(start, end))

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters \"null\". - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: A reference to this Appendable - `java.lang.Appendable`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.lang.Appendable [^Appendable this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.lang.Appendable [^Appendable this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

