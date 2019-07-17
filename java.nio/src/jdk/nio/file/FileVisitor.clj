(ns jdk.nio.file.FileVisitor
  "A visitor of files. An implementation of this interface is provided to the
  Files.walkFileTree methods to visit each file in
  a file tree.

   Usage Examples:
  Suppose we want to delete a file tree. In that case, each directory should
  be deleted after the entries in the directory are deleted.


      Path start = ...
      Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException
          {
              Files.delete(file);
              return FileVisitResult.CONTINUE;
          }
          @Override
          public FileVisitResult postVisitDirectory(Path dir, IOException e)
              throws IOException
          {
              if (e == null) {
                  Files.delete(dir);
                  return FileVisitResult.CONTINUE;
              } else {
                  // directory iteration failed
                  throw e;
              }
          }
      });
   Furthermore, suppose we want to copy a file tree to a target location.
  In that case, symbolic links should be followed and the target directory
  should be created before the entries in the directory are copied.


      final Path source = ...
      final Path target = ...

      Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
          new SimpleFileVisitor<Path>() {
              @Override
              public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                  throws IOException
              {
                  Path targetdir = target.resolve(source.relativize(dir));
                  try {
                      Files.copy(dir, targetdir);
                  } catch (FileAlreadyExistsException e) {
                       if (!Files.isDirectory(targetdir))
                           throw e;
                  }
                  return CONTINUE;
              }
              @Override
              public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                  throws IOException
              {
                  Files.copy(file, target.resolve(source.relativize(file)));
                  return CONTINUE;
              }
          });"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileVisitor]))

(defn pre-visit-directory
  "Invoked for a directory before entries in the directory are visited.

    If this method returns CONTINUE,
   then entries in the directory are visited. If this method returns SKIP_SUBTREE or SKIP_SIBLINGS then entries in the
   directory (and any descendants) will not be visited.

  dir - a reference to the directory - `FileVisitor.T`
  attrs - the directory's basic attributes - `java.nio.file.attribute.BasicFileAttributes`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this dir attrs]
    (-> this (.preVisitDirectory dir attrs))))

(defn visit-file
  "Invoked for a file in a directory.

  file - a reference to the file - `FileVisitor.T`
  attrs - the file's basic attributes - `java.nio.file.attribute.BasicFileAttributes`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this file attrs]
    (-> this (.visitFile file attrs))))

(defn visit-file-failed
  "Invoked for a file that could not be visited. This method is invoked
   if the file's attributes could not be read, the file is a directory
   that could not be opened, and other reasons.

  file - a reference to the file - `FileVisitor.T`
  exc - the I/O exception that prevented the file from being visited - `java.io.IOException`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this file exc]
    (-> this (.visitFileFailed file exc))))

(defn post-visit-directory
  "Invoked for a directory after entries in the directory, and all of their
   descendants, have been visited. This method is also invoked when iteration
   of the directory completes prematurely (by a visitFile
   method returning SKIP_SIBLINGS,
   or an I/O error when iterating over the directory).

  dir - a reference to the directory - `FileVisitor.T`
  exc - null if the iteration of the directory completes without an error; otherwise the I/O exception that caused the iteration of the directory to complete prematurely - `java.io.IOException`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this dir exc]
    (-> this (.postVisitDirectory dir exc))))

