(ns javax.script.ScriptException
  "The generic Exception class for the Scripting APIs.  Checked
  exception types thrown by underlying scripting implementations must be wrapped in instances of
  ScriptException.  The class has members to store line and column numbers and
  filenames if this information is available."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script ScriptException]))

(defn ->script-exception
  "Constructor.

  ScriptException constructor specifying message, filename, line number
   and column number.

  message - The message. - `java.lang.String`
  file-name - The filename - `java.lang.String`
  line-number - the line number. - `int`
  column-number - the column number. - `int`"
  ([message file-name line-number column-number]
    (new ScriptException message file-name line-number column-number))
  ([message file-name line-number]
    (new ScriptException message file-name line-number))
  ([s]
    (new ScriptException s)))

(defn get-message
  "Returns a message containing the String passed to a constructor as well as
   line and column numbers and filename if any of these are known.

  returns: The error message. - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

(defn get-line-number
  "Get the line number on which an error occurred.

  returns: The line number.  Returns -1 if a line number is unavailable. - `int`"
  ([this]
    (-> this (.getLineNumber))))

(defn get-column-number
  "Get the column number on which an error occurred.

  returns: The column number.  Returns -1 if a column number is unavailable. - `int`"
  ([this]
    (-> this (.getColumnNumber))))

(defn get-file-name
  "Get the source of the script causing the error.

  returns: The file name of the script or some other string describing the script
   source.  May return some implementation-defined string such as <unknown>
   if a description of the source is unavailable. - `java.lang.String`"
  ([this]
    (-> this (.getFileName))))

