(ns javax.security.auth.Destroyable
  "Objects such as credentials may optionally implement this interface
  to provide the capability to destroy its contents."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth Destroyable]))

(defn destroy
  "Destroy this Object.

    Sensitive information associated with this Object
   is destroyed or cleared.  Subsequent calls to certain methods
   on this Object will result in an
   IllegalStateException being thrown.


   The default implementation throws DestroyFailedException.

  returns: `default void`

  throws: javax.security.auth.DestroyFailedException - if the destroy operation fails."
  ([^. this]
    (-> this (.destroy))))

(defn is-destroyed
  "Determine if this Object has been destroyed.


   The default implementation returns false.

  returns: true if this Object has been destroyed,
            false otherwise. - `default boolean`"
  ([^. this]
    (-> this (.isDestroyed))))

