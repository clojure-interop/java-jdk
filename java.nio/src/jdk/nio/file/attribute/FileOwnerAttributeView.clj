(ns jdk.nio.file.attribute.FileOwnerAttributeView
  "A file attribute view that supports reading or updating the owner of a file.
  This file attribute view is intended for file system implementations that
  support a file attribute that represents an identity that is the owner of
  the file. Often the owner of a file is the identity of the entity that
  created the file.

   The getOwner or setOwner methods may
  be used to read or update the owner of the file.

   The getAttribute and
  setAttribute methods may also be
  used to read or update the owner. In that case, the owner attribute is
  identified by the name `owner`, and the value of the attribute is
  a UserPrincipal."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute FileOwnerAttributeView]))

(defn name
  "Returns the name of the attribute view. Attribute views of this type
   have the name `owner`.

  returns: the name of the attribute view - `java.lang.String`"
  ([^java.nio.file.attribute.FileOwnerAttributeView this]
    (-> this (.name))))

(defn get-owner
  "Read the file owner.

    It it implementation specific if the file owner can be a group.

  returns: the file owner - `java.nio.file.attribute.UserPrincipal`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.nio.file.attribute.FileOwnerAttributeView this]
    (-> this (.getOwner))))

(defn set-owner
  "Updates the file owner.

    It it implementation specific if the file owner can be a group. To ensure consistent and correct behavior
   across platforms it is recommended that this method should only be used
   to set the file owner to a user principal that is not a group.

  owner - the new file owner - `java.nio.file.attribute.UserPrincipal`

  throws: java.io.IOException - if an I/O error occurs, or the owner parameter is a group and this implementation does not support setting the owner to a group"
  ([^java.nio.file.attribute.FileOwnerAttributeView this ^java.nio.file.attribute.UserPrincipal owner]
    (-> this (.setOwner owner))))

