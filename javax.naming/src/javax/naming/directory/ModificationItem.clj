(ns javax.naming.directory.ModificationItem
  "This class represents a modification item.
  It consists of a modification code and an attribute on which to operate.

  A ModificationItem instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single ModificationItem instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory ModificationItem]))

(defn ->modification-item
  "Constructor.

  Creates a new instance of ModificationItem.

  mod-op - Modification to apply. It must be one of: DirContext.ADD_ATTRIBUTE DirContext.REPLACE_ATTRIBUTE DirContext.REMOVE_ATTRIBUTE - `int`
  attr - The non-null attribute to use for modification. - `javax.naming.directory.Attribute`

  throws: java.lang.IllegalArgumentException - If attr is null, or if mod_op is not one of the ones specified above."
  ([^Integer mod-op ^javax.naming.directory.Attribute attr]
    (new ModificationItem mod-op attr)))

(defn get-modification-op
  "Retrieves the modification code of this modification item.

  returns: The modification code.  It is one of:
           DirContext.ADD_ATTRIBUTE
           DirContext.REPLACE_ATTRIBUTE
           DirContext.REMOVE_ATTRIBUTE - `int`"
  (^Integer [^javax.naming.directory.ModificationItem this]
    (-> this (.getModificationOp))))

(defn get-attribute
  "Retrieves the attribute associated with this modification item.

  returns: The non-null attribute to use for the modification. - `javax.naming.directory.Attribute`"
  (^javax.naming.directory.Attribute [^javax.naming.directory.ModificationItem this]
    (-> this (.getAttribute))))

(defn to-string
  "Generates the string representation of this modification item,
   which consists of the modification operation and its related attribute.
   The string representation is meant for debugging and not to be
   interpreted programmatically.

  returns: The non-null string representation of this modification item. - `java.lang.String`"
  (^java.lang.String [^javax.naming.directory.ModificationItem this]
    (-> this (.toString))))

