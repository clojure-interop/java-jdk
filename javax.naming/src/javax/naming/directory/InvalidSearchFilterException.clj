(ns javax.naming.directory.InvalidSearchFilterException
  "This exception is thrown when the specification of
  a search filter is invalid.  The expression of the filter may
  be invalid, or there may be a problem with one of the parameters
  passed to the filter.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InvalidSearchFilterException]))

(defn ->invalid-search-filter-exception
  "Constructor.

  Constructs a new instance of InvalidSearchFilterException
   with an explanation. All other fields are set to null.

  msg - Detail about this exception. Can be null. - `java.lang.String`"
  ([^java.lang.String msg]
    (new InvalidSearchFilterException msg))
  ([]
    (new InvalidSearchFilterException )))

