(ns javax.naming.CannotProceedException
  "This exception is thrown to indicate that the operation reached
  a point in the name where the operation cannot proceed any further.
  When performing an operation on a composite name, a naming service
  provider may reach a part of the name that does not belong to its
  namespace.  At that point, it can construct a
  CannotProceedException and then invoke methods provided by
  javax.naming.spi.NamingManager (such as getContinuationContext())
  to locate another provider to continue the operation.  If this is
  not possible, this exception is raised to the caller of the
  context operation.

  If the program wants to handle this exception in particular, it
  should catch CannotProceedException explicitly before attempting to
  catch NamingException.

  A CannotProceedException instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  CannotProceedException should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming CannotProceedException]))

(defn ->cannot-proceed-exception
  "Constructor.

  Constructs a new instance of CannotProceedException using an
   explanation. All unspecified fields default to null.

  explanation - A possibly null string containing additional detail about this exception. If null, this exception has no detail message. - `java.lang.String`"
  (^CannotProceedException [^java.lang.String explanation]
    (new CannotProceedException explanation))
  (^CannotProceedException []
    (new CannotProceedException )))

(defn get-environment
  "Retrieves the environment that was in effect when this exception
   was created.

  returns: Possibly null environment property set.
            null means no environment was recorded for this exception. - `java.util.Hashtable<?,?>`"
  (^java.util.Hashtable [^CannotProceedException this]
    (-> this (.getEnvironment))))

(defn set-environment
  "Sets the environment that will be returned when getEnvironment()
   is called.

  environment - A possibly null environment property set. null means no environment is being recorded for this exception. - `java.util.Hashtable`"
  ([^CannotProceedException this ^java.util.Hashtable environment]
    (-> this (.setEnvironment environment))))

(defn get-remaining-new-name
  "Retrieves the `remaining new name` field of this exception, which is
   used when this exception is thrown during a rename() operation.

  returns: The possibly null part of the new name that has not been resolved.
            It is a composite name. It can be null, which means
            the remaining new name field has not been set. - `javax.naming.Name`"
  (^javax.naming.Name [^CannotProceedException this]
    (-> this (.getRemainingNewName))))

(defn set-remaining-new-name
  "Sets the `remaining new name` field of this exception.
   This is the value returned by getRemainingNewName().

   newName is a composite name. If the intent is to set
   this field using a compound name or string, you must
   `stringify` the compound name, and create a composite
   name with a single component using the string. You can then
   invoke this method using the resulting composite name.

   A copy of newName is made and stored.
   Subsequent changes to name does not
   affect the copy in this NamingException and vice versa.

  new-name - The possibly null name to set the `remaining new name` to. If null, it sets the remaining name field to null. - `javax.naming.Name`"
  ([^CannotProceedException this ^javax.naming.Name new-name]
    (-> this (.setRemainingNewName new-name))))

(defn get-alt-name
  "Retrieves the altName field of this exception.
   This is the name of the resolved object, relative to the context
   altNameCtx. It will be used during a subsequent call to the
   javax.naming.spi.ObjectFactory.getObjectInstance method.

  returns: The name of the resolved object, relative to
            altNameCtx.
            It is a composite name.  If null, then no name is specified. - `javax.naming.Name`"
  (^javax.naming.Name [^CannotProceedException this]
    (-> this (.getAltName))))

(defn set-alt-name
  "Sets the altName field of this exception.

  alt-name - The name of the resolved object, relative to altNameCtx. It is a composite name. If null, then no name is specified. - `javax.naming.Name`"
  ([^CannotProceedException this ^javax.naming.Name alt-name]
    (-> this (.setAltName alt-name))))

(defn get-alt-name-ctx
  "Retrieves the altNameCtx field of this exception.
   This is the context relative to which altName is named.
   It will be used during a subsequent call to the
   javax.naming.spi.ObjectFactory.getObjectInstance method.

  returns: The context relative to which altName is named.
            If null, then the default initial context is implied. - `javax.naming.Context`"
  (^javax.naming.Context [^CannotProceedException this]
    (-> this (.getAltNameCtx))))

(defn set-alt-name-ctx
  "Sets the altNameCtx field of this exception.

  alt-name-ctx - The context relative to which altName is named. If null, then the default initial context is implied. - `javax.naming.Context`"
  ([^CannotProceedException this ^javax.naming.Context alt-name-ctx]
    (-> this (.setAltNameCtx alt-name-ctx))))

