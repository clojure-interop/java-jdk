(ns javax.naming.directory.InvalidAttributeValueException
  "This class is thrown when an attempt is
  made to add to an attribute a value that conflicts with the attribute's
  schema definition.  This could happen, for example, if attempting
  to add an attribute with no value when the attribute is required
  to have at least one value, or if attempting to add more than
  one value to a single valued-attribute, or if attempting to
  add a value that conflicts with the syntax of the attribute.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InvalidAttributeValueException]))

(defn ->invalid-attribute-value-exception
  "Constructor.

  Constructs a new instance of InvalidAttributeValueException using
   an explanation. All other fields are set to null.

  explanation - Additional detail about this exception. Can be null. - `java.lang.String`"
  ([explanation]
    (new InvalidAttributeValueException explanation))
  ([]
    (new InvalidAttributeValueException )))

