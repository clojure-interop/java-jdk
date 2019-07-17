(ns javax.lang.model.type.NoType
  "A pseudo-type used where no actual type is appropriate.
  The kinds of NoType are:

  VOID - corresponds to the keyword void.
  PACKAGE - the pseudo-type of a package element.
  NONE - used in other cases
    where no actual type is appropriate; for example, the superclass
    of java.lang.Object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type NoType]))

