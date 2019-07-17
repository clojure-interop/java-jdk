(ns javax.naming.directory.AttributeModificationException
  "This exception is thrown when an attempt is
  made to add, or remove, or modify an attribute, its identifier,
  or its values that conflicts with the attribute's (schema) definition
  or the attribute's state.
  It is thrown in response to DirContext.modifyAttributes().
  It contains a list of modifications that have not been performed, in the
  order that they were supplied to modifyAttributes().
  If the list is null, none of the modifications were performed successfully.

  An AttributeModificationException instance is not synchronized
  against concurrent multithreaded access. Multiple threads trying
  to access and modify a single AttributeModification instance
  should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory AttributeModificationException]))

(defn ->attribute-modification-exception
  "Constructor.

  Constructs a new instance of AttributeModificationException using
   an explanation. All other fields are set to null.

  explanation - Possibly null additional detail about this exception. If null, this exception has no detail message. - `java.lang.String`"
  ([explanation]
    (new AttributeModificationException explanation))
  ([]
    (new AttributeModificationException )))

(defn set-unexecuted-modifications
  "Sets the unexecuted modification list to be e.
   Items in the list must appear in the same order in which they were
   originally supplied in DirContext.modifyAttributes().
   The first item in the list is the first one that was not executed.
   If this list is null, none of the operations originally submitted
   to modifyAttributes() were executed.

  e - The possibly null list of unexecuted modifications. - `javax.naming.directory.ModificationItem[]`"
  ([this e]
    (-> this (.setUnexecutedModifications e))))

(defn get-unexecuted-modifications
  "Retrieves the unexecuted modification list.
   Items in the list appear in the same order in which they were
   originally supplied in DirContext.modifyAttributes().
   The first item in the list is the first one that was not executed.
   If this list is null, none of the operations originally submitted
   to modifyAttributes() were executed.

  returns: The possibly null unexecuted modification list. - `javax.naming.directory.ModificationItem[]`"
  ([this]
    (-> this (.getUnexecutedModifications))))

(defn to-string
  "The string representation of this exception consists of
   information about where the error occurred, and
   the first unexecuted modification.
   This string is meant for debugging and not mean to be interpreted
   programmatically.

  returns: The non-null string representation of this exception. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

