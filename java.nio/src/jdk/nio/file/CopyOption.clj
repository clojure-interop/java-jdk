(ns jdk.nio.file.CopyOption
  "An object that configures how to copy or move a file.

   Objects of this type may be used with the Files.copy(Path,Path,CopyOption...),
  Files.copy(InputStream,Path,CopyOption...) and Files.move(Path,Path,CopyOption...) methods to configure how a file is
  copied or moved.

   The StandardCopyOption enumeration type defines the
  standard options."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file CopyOption]))

