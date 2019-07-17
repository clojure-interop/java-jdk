(ns javax.xml.transform.TransformerException
  "This class specifies an exceptional condition that occurred
  during the transformation process."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform TransformerException]))

(defn ->transformer-exception
  "Constructor.

  Wrap an existing exception in a TransformerException.

  message - The error or warning message, or null to use the message from the embedded exception. - `java.lang.String`
  locator - The locator object for the error or warning. - `javax.xml.transform.SourceLocator`
  e - Any exception - `java.lang.Throwable`"
  ([message locator e]
    (new TransformerException message locator e))
  ([message e]
    (new TransformerException message e))
  ([message]
    (new TransformerException message)))

(defn get-locator
  "Method getLocator retrieves an instance of a SourceLocator
   object that specifies where an error occurred.

  returns: A SourceLocator object, or null if none was specified. - `javax.xml.transform.SourceLocator`"
  ([this]
    (-> this (.getLocator))))

(defn set-locator
  "Method setLocator sets an instance of a SourceLocator
   object that specifies where an error occurred.

  location - A SourceLocator object, or null to clear the location. - `javax.xml.transform.SourceLocator`"
  ([this location]
    (-> this (.setLocator location))))

(defn get-exception
  "This method retrieves an exception that this exception wraps.

  returns: An Throwable object, or null. - `java.lang.Throwable`"
  ([this]
    (-> this (.getException))))

(defn get-cause
  "Returns the cause of this throwable or null if the
   cause is nonexistent or unknown.  (The cause is the throwable that
   caused this throwable to get thrown.)

  returns: the cause, or null if unknown - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

(defn init-cause
  "Initializes the cause of this throwable to the specified value.
   (The cause is the throwable that caused this throwable to get thrown.)

   This method can be called at most once.  It is generally called from
   within the constructor, or immediately after creating the
   throwable.  If this throwable was created
   with TransformerException(Throwable) or
   TransformerException(String,Throwable), this method cannot be called
   even once.

  cause - the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`

  returns: a reference to this Throwable instance. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if cause is this throwable. (A throwable cannot be its own cause.)"
  ([this cause]
    (-> this (.initCause cause))))

(defn get-message-and-location
  "Get the error message with location information
   appended.

  returns: A String representing the error message with
           location information appended. - `java.lang.String`"
  ([this]
    (-> this (.getMessageAndLocation))))

(defn get-location-as-string
  "Get the location information as a string.

  returns: A string with location info, or null
   if there is no location information. - `java.lang.String`"
  ([this]
    (-> this (.getLocationAsString))))

(defn print-stack-trace
  "Print the the trace of methods from where the error
   originated.  This will trace all nested exception
   objects, as well as this object.

  s - The stream where the dump will be sent to. - `java.io.PrintStream`"
  ([this s]
    (-> this (.printStackTrace s)))
  ([this]
    (-> this (.printStackTrace))))

