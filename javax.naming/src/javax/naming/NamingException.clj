(ns javax.naming.NamingException
  "This is the superclass of all exceptions thrown by
  operations in the Context and DirContext interfaces.
  The nature of the failure is described by the name of the subclass.
  This exception captures the information pinpointing where the operation
  failed, such as where resolution last proceeded to.

   Resolved Name. Portion of name that has been resolved.
   Resolved Object. Object to which resolution of name proceeded.
   Remaining Name. Portion of name that has not been resolved.
   Explanation. Detail explaining why name resolution failed.
   Root Exception. The exception that caused this naming exception
                      to be thrown.

  null is an acceptable value for any of these fields. When null,
  it means that no such information has been recorded for that field.

  A NamingException instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single NamingException instance should lock the object.

  This exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The
  root exception (or root cause) is the same object as the
  cause returned by the Throwable.getCause() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NamingException]))

(defn ->naming-exception
  "Constructor.

  Constructs a new NamingException with an explanation.
   All unspecified fields are set to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^NamingException [^java.lang.String explanation]
    (new NamingException explanation))
  (^NamingException []
    (new NamingException )))

(defn append-remaining-component
  "Add name as the last component in remaining name.

  name - The component to add. If name is null, this method does not do anything. - `java.lang.String`"
  ([^NamingException this ^java.lang.String name]
    (-> this (.appendRemainingComponent name))))

(defn get-explanation
  "Retrieves the explanation associated with this exception.

  returns: The possibly null detail string explaining more
           about this exception. If null, it means there is no
           detail message for this exception. - `java.lang.String`"
  (^java.lang.String [^NamingException this]
    (-> this (.getExplanation))))

(defn init-cause
  "Initializes the cause of this exception to the specified value.
   The cause is the throwable that caused this naming exception to be
   thrown.

   This method may be called at most once.

  cause - the cause, which is saved for later retrieval by the getCause() method. A null value indicates that the cause is nonexistent or unknown. - `java.lang.Throwable`

  returns: a reference to this NamingException instance. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if cause is this exception. (A throwable cannot be its own cause.)"
  (^java.lang.Throwable [^NamingException this ^java.lang.Throwable cause]
    (-> this (.initCause cause))))

(defn set-resolved-name
  "Sets the resolved name field of this exception.

   name is a composite name. If the intent is to set
   this field using a compound name or string, you must
   `stringify` the compound name, and create a composite
   name with a single component using the string. You can then
   invoke this method using the resulting composite name.

   A copy of name is made and stored.
   Subsequent changes to name does not
   affect the copy in this NamingException and vice versa.

  name - The possibly null name to set resolved name to. If null, it sets the resolved name field to null. - `javax.naming.Name`"
  ([^NamingException this ^javax.naming.Name name]
    (-> this (.setResolvedName name))))

(defn get-resolved-obj
  "Retrieves the object to which resolution was successful.
   This is the object to which the resolved name is bound.

  returns: The possibly null object that was resolved so far.
    null means that the resolved object field has not been set. - `java.lang.Object`"
  (^java.lang.Object [^NamingException this]
    (-> this (.getResolvedObj))))

(defn set-resolved-obj
  "Sets the resolved object field of this exception.

  obj - The possibly null object to set resolved object to. If null, the resolved object field is set to null. - `java.lang.Object`"
  ([^NamingException this ^java.lang.Object obj]
    (-> this (.setResolvedObj obj))))

(defn to-string
  "Generates the string representation in more detail.
   This string representation consists of the information returned
   by the toString() that takes no parameters, plus the string
   representation of the resolved object (if it is not null).
   This string is used for debugging and not meant to be interpreted
   programmatically.

  detail - If true, include details about the resolved object in addition to the other information. - `boolean`

  returns: The non-null string containing the string representation. - `java.lang.String`"
  (^java.lang.String [^NamingException this ^Boolean detail]
    (-> this (.toString detail)))
  (^java.lang.String [^NamingException this]
    (-> this (.toString))))

(defn append-remaining-name
  "Add components from 'name' as the last components in
   remaining name.

   name is a composite name. If the intent is to append
   a compound name, you should `stringify` the compound name
   then invoke the overloaded form that accepts a String parameter.

   Subsequent changes to name does not
   affect the remaining name field in this NamingException and vice versa.

  name - The possibly null name containing ordered components to add. If name is null, this method does not do anything. - `javax.naming.Name`"
  ([^NamingException this ^javax.naming.Name name]
    (-> this (.appendRemainingName name))))

(defn set-remaining-name
  "Sets the remaining name field of this exception.

   name is a composite name. If the intent is to set
   this field using a compound name or string, you must
   `stringify` the compound name, and create a composite
   name with a single component using the string. You can then
   invoke this method using the resulting composite name.

   A copy of name is made and stored.
   Subsequent changes to name does not
   affect the copy in this NamingException and vice versa.

  name - The possibly null name to set remaining name to. If null, it sets the remaining name field to null. - `javax.naming.Name`"
  ([^NamingException this ^javax.naming.Name name]
    (-> this (.setRemainingName name))))

(defn get-resolved-name
  "Retrieves the leading portion of the name that was resolved
   successfully.

  returns: The part of the name that was resolved successfully.
            It is a composite name. It can be null, which means
            the resolved name field has not been set. - `javax.naming.Name`"
  (^javax.naming.Name [^NamingException this]
    (-> this (.getResolvedName))))

(defn get-remaining-name
  "Retrieves the remaining unresolved portion of the name.

  returns: The part of the name that has not been resolved.
            It is a composite name. It can be null, which means
            the remaining name field has not been set. - `javax.naming.Name`"
  (^javax.naming.Name [^NamingException this]
    (-> this (.getRemainingName))))

(defn get-root-cause
  "Retrieves the root cause of this NamingException, if any.
   The root cause of a naming exception is used when the service provider
   wants to indicate to the caller a non-naming related exception
   but at the same time wants to use the NamingException structure
   to indicate how far the naming operation proceeded.

   This method predates the general-purpose exception chaining facility.
   The getCause() method is now the preferred means of obtaining
   this information.

  returns: The possibly null exception that caused this naming
      exception. If null, it means no root cause has been
      set for this naming exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^NamingException this]
    (-> this (.getRootCause))))

(defn get-cause
  "Returns the cause of this exception.  The cause is the
   throwable that caused this naming exception to be thrown.
   Returns null if the cause is nonexistent or
   unknown.

  returns: the cause of this exception, or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^NamingException this]
    (-> this (.getCause))))

(defn set-root-cause
  "Records the root cause of this NamingException.
   If e is this, this method does not do anything.

   This method predates the general-purpose exception chaining facility.
   The initCause(Throwable) method is now the preferred means
   of recording this information.

  e - The possibly null exception that caused the naming operation to fail. If null, it means this naming exception has no root cause. - `java.lang.Throwable`"
  ([^NamingException this ^java.lang.Throwable e]
    (-> this (.setRootCause e))))

