(ns javax.crypto.interfaces.PBEKey
  "The interface to a PBE key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.interfaces PBEKey]))

(defn get-password
  "Returns the password.

    Note: this method should return a copy of the password. It is
   the caller's responsibility to zero out the password information after
   it is no longer needed.

  returns: the password. - `char[]`"
  ([^. this]
    (-> this (.getPassword))))

(defn get-salt
  "Returns the salt or null if not specified.

    Note: this method should return a copy of the salt. It is
   the caller's responsibility to zero out the salt information after
   it is no longer needed.

  returns: the salt. - `byte[]`"
  ([^. this]
    (-> this (.getSalt))))

(defn get-iteration-count
  "Returns the iteration count or 0 if not specified.

  returns: the iteration count. - `int`"
  ([^. this]
    (-> this (.getIterationCount))))

