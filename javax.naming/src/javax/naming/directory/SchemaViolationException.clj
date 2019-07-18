(ns javax.naming.directory.SchemaViolationException
  "This exception is thrown when a method
  in some ways violates the schema. An example of schema violation
  is modifying attributes of an object that violates the object's
  schema definition. Another example is renaming or moving an object
  to a part of the namespace that violates the namespace's
  schema definition.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory SchemaViolationException]))

(defn ->schema-violation-exception
  "Constructor.

  Constructs a new instance of SchemaViolationException
   using the explanation supplied. All other fields are set to null.

  explanation - Detail about this exception. Can be null. - `java.lang.String`"
  (^SchemaViolationException [^java.lang.String explanation]
    (new SchemaViolationException explanation))
  (^SchemaViolationException []
    (new SchemaViolationException )))

