(ns javax.naming.directory.InvalidAttributesException
  "This exception is thrown when an attempt is
  made to add or modify an attribute set that has been specified
  incompletely or incorrectly. This could happen, for example,
  when attempting to add or modify a binding, or to create a new
  subcontext without specifying all the mandatory attributes
  required for creation of the object.  Another situation in
  which this exception is thrown is by specification of incompatible
  attributes within the same attribute set, or attributes in conflict
  with that specified by the object's schema.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InvalidAttributesException]))

(defn ->invalid-attributes-exception
  "Constructor.

  Constructs a new instance of InvalidAttributesException using an
   explanation. All other fields are set to null.

  explanation - Additional detail about this exception. Can be null. - `java.lang.String`"
  (^InvalidAttributesException [^java.lang.String explanation]
    (new InvalidAttributesException explanation))
  (^InvalidAttributesException []
    (new InvalidAttributesException )))

