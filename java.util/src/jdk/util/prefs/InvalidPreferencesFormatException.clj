(ns jdk.util.prefs.InvalidPreferencesFormatException
  "Thrown to indicate that an operation could not complete because
  the input did not conform to the appropriate XML document type
  for a collection of preferences, as per the Preferences
  specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs InvalidPreferencesFormatException]))

(defn ->invalid-preferences-format-exception
  "Constructor.

  Constructs an InvalidPreferencesFormatException with the specified
   detail message and cause.

  message - the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method. - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). - `java.lang.Throwable`"
  ([message cause]
    (new InvalidPreferencesFormatException message cause))
  ([cause]
    (new InvalidPreferencesFormatException cause)))

