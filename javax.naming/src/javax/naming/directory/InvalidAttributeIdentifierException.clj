(ns javax.naming.directory.InvalidAttributeIdentifierException
  "This exception is thrown when an attempt is
  made to add to create an attribute with an invalid attribute identifier.
  The validity of an attribute identifier is directory-specific.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InvalidAttributeIdentifierException]))

(defn ->invalid-attribute-identifier-exception
  "Constructor.

  Constructs a new instance of InvalidAttributeIdentifierException using the
   explanation supplied. All other fields set to null.

  explanation - Possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^InvalidAttributeIdentifierException [^java.lang.String explanation]
    (new InvalidAttributeIdentifierException explanation))
  (^InvalidAttributeIdentifierException []
    (new InvalidAttributeIdentifierException )))

