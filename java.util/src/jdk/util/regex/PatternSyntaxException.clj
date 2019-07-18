(ns jdk.util.regex.PatternSyntaxException
  "Unchecked exception thrown to indicate a syntax error in a
  regular-expression pattern."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.regex PatternSyntaxException]))

(defn ->pattern-syntax-exception
  "Constructor.

  Constructs a new instance of this class.

  desc - A description of the error - `java.lang.String`
  regex - The erroneous pattern - `java.lang.String`
  index - The approximate index in the pattern of the error, or -1 if the index is not known - `int`"
  (^PatternSyntaxException [^java.lang.String desc ^java.lang.String regex ^Integer index]
    (new PatternSyntaxException desc regex index)))

(defn get-index
  "Retrieves the error index.

  returns: The approximate index in the pattern of the error,
           or -1 if the index is not known - `int`"
  (^Integer [^PatternSyntaxException this]
    (-> this (.getIndex))))

(defn get-description
  "Retrieves the description of the error.

  returns: The description of the error - `java.lang.String`"
  (^java.lang.String [^PatternSyntaxException this]
    (-> this (.getDescription))))

(defn get-pattern
  "Retrieves the erroneous regular-expression pattern.

  returns: The erroneous pattern - `java.lang.String`"
  (^java.lang.String [^PatternSyntaxException this]
    (-> this (.getPattern))))

(defn get-message
  "Returns a multi-line string containing the description of the syntax
   error and its index, the erroneous regular-expression pattern, and a
   visual indication of the error index within the pattern.

  returns: The full detail message - `java.lang.String`"
  (^java.lang.String [^PatternSyntaxException this]
    (-> this (.getMessage))))

