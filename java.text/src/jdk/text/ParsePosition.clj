(ns jdk.text.ParsePosition
  "ParsePosition is a simple class used by Format
  and its subclasses to keep track of the current position during parsing.
  The parseObject method in the various Format
  classes requires a ParsePosition object as an argument.


  By design, as you parse through a string with different formats,
  you can use the same ParsePosition, since the index parameter
  records the current position."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text ParsePosition]))

(defn ->parse-position
  "Constructor.

  Create a new ParsePosition with the given initial index.

  index - initial index - `int`"
  ([^Integer index]
    (new ParsePosition index)))

(defn get-index
  "Retrieve the current parse position.  On input to a parse method, this
   is the index of the character at which parsing will begin; on output, it
   is the index of the character following the last character parsed.

  returns: the current parse position - `int`"
  (^Integer [^java.text.ParsePosition this]
    (-> this (.getIndex))))

(defn set-index
  "Set the current parse position.

  index - the current parse position - `int`"
  ([^java.text.ParsePosition this ^Integer index]
    (-> this (.setIndex index))))

(defn set-error-index
  "Set the index at which a parse error occurred.  Formatters
   should set this before returning an error code from their
   parseObject method.  The default value is -1 if this is not set.

  ei - the index at which an error occurred - `int`"
  ([^java.text.ParsePosition this ^Integer ei]
    (-> this (.setErrorIndex ei))))

(defn get-error-index
  "Retrieve the index at which an error occurred, or -1 if the
   error index has not been set.

  returns: the index at which an error occurred - `int`"
  (^Integer [^java.text.ParsePosition this]
    (-> this (.getErrorIndex))))

(defn equals
  "Overrides equals

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.text.ParsePosition this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code for this ParsePosition.

  returns: a hash code value for this object - `int`"
  (^Integer [^java.text.ParsePosition this]
    (-> this (.hashCode))))

(defn to-string
  "Return a string representation of this ParsePosition.

  returns: a string representation of this object - `java.lang.String`"
  (^java.lang.String [^java.text.ParsePosition this]
    (-> this (.toString))))

