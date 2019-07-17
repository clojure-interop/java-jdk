(ns javax.naming.InvalidNameException
  "This exception indicates that the name being specified does
  not conform to the naming syntax of a naming system.
  This exception is thrown by any of the methods that does name
  parsing (such as those in Context, DirContext, CompositeName and CompoundName).

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming InvalidNameException]))

(defn ->invalid-name-exception
  "Constructor.

  Constructs an instance of InvalidNameException using an
   explanation of the problem.
   All other fields are initialized to null.

  explanation - A possibly null message explaining the problem. - `java.lang.String`"
  ([explanation]
    (new InvalidNameException explanation))
  ([]
    (new InvalidNameException )))

