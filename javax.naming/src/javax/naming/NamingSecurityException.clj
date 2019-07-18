(ns javax.naming.NamingSecurityException
  "This is the superclass of security-related exceptions
  thrown by operations in the Context and DirContext interfaces.
  The nature of the failure is described by the name of the subclass.

  If the program wants to handle this exception in particular, it
  should catch NamingSecurityException explicitly before attempting to
  catch NamingException. A program might want to do this, for example,
  if it wants to treat security-related exceptions specially from
  other sorts of naming exception.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NamingSecurityException]))

(defn ->naming-security-exception
  "Constructor.

  Constructs a new instance of NamingSecurityException using the
   explanation supplied. All other fields default to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  (^NamingSecurityException [^java.lang.String explanation]
    (new NamingSecurityException explanation))
  (^NamingSecurityException []
    (new NamingSecurityException )))

