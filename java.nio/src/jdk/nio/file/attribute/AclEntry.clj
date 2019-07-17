(ns jdk.nio.file.attribute.AclEntry
  "An entry in an access control list (ACL).

   The ACL entry represented by this class is based on the ACL model
  specified in RFC 3530:
  Network File System (NFS) version 4 Protocol. Each entry has four
  components as follows:


      The type component determines if the entry
     grants or denies access.

      The principal component, sometimes called the
     `who` component, is a UserPrincipal corresponding to the identity
     that the entry grants or denies access


      The permissions component is a set of
     permissions


      The flags component is a set of flags to indicate how entries are inherited and propagated


   ACL entries are created using an associated AclEntry.Builder object by
  invoking its build method.

   ACL entries are immutable and are safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AclEntry]))

(defn *new-builder
  "Constructs a new builder with the components of an existing ACL entry.

  entry - an ACL entry - `java.nio.file.attribute.AclEntry`

  returns: a new builder - `java.nio.file.attribute.AclEntry.Builder`"
  ([^java.nio.file.attribute.AclEntry entry]
    (AclEntry/newBuilder entry))
  ([]
    (AclEntry/newBuilder )))

(defn type
  "Returns the ACL entry type.

  returns: the ACL entry type - `java.nio.file.attribute.AclEntryType`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.type))))

(defn principal
  "Returns the principal component.

  returns: the principal component - `java.nio.file.attribute.UserPrincipal`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.principal))))

(defn permissions
  "Returns a copy of the permissions component.

    The returned set is a modifiable copy of the permissions.

  returns: the permissions component - `java.util.Set<java.nio.file.attribute.AclEntryPermission>`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.permissions))))

(defn flags
  "Returns a copy of the flags component.

    The returned set is a modifiable copy of the flags.

  returns: the flags component - `java.util.Set<java.nio.file.attribute.AclEntryFlag>`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.flags))))

(defn equals
  "Compares the specified object with this ACL entry for equality.

    If the given object is not an AclEntry then this method
   immediately returns false.

    For two ACL entries to be considered equals requires that they are
   both the same type, their who components are equal, their permissions
   components are equal, and their flags components are equal.

    This method satisfies the general contract of the Object.equals method.

  ob - the object to which this object is to be compared - `java.lang.Object`

  returns: true if, and only if, the given object is an AclEntry that
            is identical to this AclEntry - `boolean`"
  ([^java.nio.file.attribute.AclEntry this ^java.lang.Object ob]
    (-> this (.equals ob))))

(defn hash-code
  "Returns the hash-code value for this ACL entry.

    This method satisfies the general contract of the Object.hashCode() method.

  returns: a hash code value for this object. - `int`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the string representation of this ACL entry.

  returns: the string representation of this entry - `java.lang.String`"
  ([^java.nio.file.attribute.AclEntry this]
    (-> this (.toString))))

