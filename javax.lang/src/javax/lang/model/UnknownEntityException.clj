(ns javax.lang.model.UnknownEntityException
  "Superclass of exceptions which indicate that an unknown kind of
  entity was encountered.  This situation can occur if the language
  evolves and new kinds of constructs are introduced.  Subclasses of
  this exception may be thrown by visitors to indicate that the
  visitor was created for a prior version of the language.

  A common superclass for those exceptions allows a single catch
  block to have code handling them uniformly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model UnknownEntityException]))

