(ns jdk.nio.file.LinkPermission
  "The Permission class for link creation operations.

   The following table provides a summary description of what the permission
  allows, and discusses the risks of granting code the permission.



  Permission Target Name
  What the Permission Allows
  Risks of Allowing this Permission


    hard
     Ability to add an existing file to a directory. This is sometimes
    known as creating a link, or hard link.
     Extreme care should be taken when granting this permission. It allows
    linking to any file or directory in the file system thus allowing the
    attacker access to all files.


    symbolic
     Ability to create symbolic links.
     Extreme care should be taken when granting this permission. It allows
    linking to any file or directory in the file system thus allowing the
    attacker to access to all files."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file LinkPermission]))

(defn ->link-permission
  "Constructor.

  Constructs a LinkPermission with the specified name.

  name - the name of the permission; must be \"hard\" or \"symbolic\". - `java.lang.String`
  actions - the actions for the permission; must be the empty string or null - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if name is empty or invalid, or actions is a non-empty string"
  (^LinkPermission [^java.lang.String name ^java.lang.String actions]
    (new LinkPermission name actions))
  (^LinkPermission [^java.lang.String name]
    (new LinkPermission name)))

