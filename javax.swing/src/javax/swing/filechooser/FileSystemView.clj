(ns javax.swing.filechooser.FileSystemView
  "FileSystemView is JFileChooser's gateway to the
  file system. Since the JDK1.1 File API doesn't allow
  access to such information as root partitions, file type
  information, or hidden file bits, this class is designed
  to intuit as much OS-specific file system information as
  possible.



  Java Licensees may want to provide a different implementation of
  FileSystemView to better handle a given operating system."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.filechooser FileSystemView]))

(defn ->file-system-view
  "Constructor."
  ([]
    (new FileSystemView )))

(defn *get-file-system-view
  "returns: `javax.swing.filechooser.FileSystemView`"
  ([]
    (FileSystemView/getFileSystemView )))

(defn computer-node?
  "Used by UI classes to decide whether to display a special icon
   for a computer node, e.g. `My Computer` or a network server.

   The default implementation has no way of knowing, so always returns false.

  dir - a directory - `java.io.File`

  returns: false always - `boolean`"
  ([this dir]
    (-> this (.isComputerNode dir))))

(defn get-files
  "Gets the list of shown (i.e. not hidden) files.

  dir - `java.io.File`
  use-file-hiding - `boolean`

  returns: `java.io.File[]`"
  ([this dir use-file-hiding]
    (-> this (.getFiles dir use-file-hiding))))

(defn create-file-object
  "Returns a File object constructed in dir from the given filename.

  dir - `java.io.File`
  filename - `java.lang.String`

  returns: `java.io.File`"
  ([this dir filename]
    (-> this (.createFileObject dir filename)))
  ([this path]
    (-> this (.createFileObject path))))

(defn get-default-directory
  "Return the user's default starting directory for the file chooser.

  returns: a File object representing the default
           starting folder - `java.io.File`"
  ([this]
    (-> this (.getDefaultDirectory))))

(defn get-parent-directory
  "Returns the parent directory of dir.

  dir - the File being queried - `java.io.File`

  returns: the parent directory of dir, or
     null if dir is null - `java.io.File`"
  ([this dir]
    (-> this (.getParentDirectory dir))))

(defn get-system-display-name
  "Name of a file, directory, or folder as it would be displayed in
   a system file browser. Example from Windows: the `M:\` directory
   displays as `CD-ROM (M:)`

   The default implementation gets information from the ShellFolder class.

  f - a File object - `java.io.File`

  returns: the file name as it would be displayed by a native file chooser - `java.lang.String`"
  ([this f]
    (-> this (.getSystemDisplayName f))))

(defn get-home-directory
  "returns: `java.io.File`"
  ([this]
    (-> this (.getHomeDirectory))))

(defn file-system-root?
  "Is dir the root of a tree in the file system, such as a drive
   or partition. Example: Returns true for `C:\` on Windows 98.

  dir - a File object representing a directory - `java.io.File`

  returns: true if f is a root of a filesystem - `boolean`"
  ([this dir]
    (-> this (.isFileSystemRoot dir))))

(defn get-system-icon
  "Icon for a file, directory, or folder as it would be displayed in
   a system file browser. Example from Windows: the `M:\` directory
   displays a CD-ROM icon.

   The default implementation gets information from the ShellFolder class.

  f - a File object - `java.io.File`

  returns: an icon as it would be displayed by a native file chooser - `javax.swing.Icon`"
  ([this f]
    (-> this (.getSystemIcon f))))

(defn parent?
  "On Windows, a file can appear in multiple folders, other than its
   parent directory in the filesystem. Folder could for example be the
   `Desktop` folder which is not the same as file.getParentFile().

  folder - a File object representing a directory or special folder - `java.io.File`
  file - a File object - `java.io.File`

  returns: true if folder is a directory or special folder and contains file. - `boolean`"
  ([this folder file]
    (-> this (.isParent folder file))))

(defn floppy-drive?
  "Used by UI classes to decide whether to display a special icon
   for a floppy disk. Implies isDrive(dir).

   The default implementation has no way of knowing, so always returns false.

  dir - a directory - `java.io.File`

  returns: false always - `boolean`"
  ([this dir]
    (-> this (.isFloppyDrive dir))))

(defn traversable?
  "Returns true if the file (directory) can be visited.
   Returns false if the directory cannot be traversed.

  f - the File - `java.io.File`

  returns: true if the file/directory can be traversed, otherwise false - `java.lang.Boolean`"
  ([this f]
    (-> this (.isTraversable f))))

(defn get-system-type-description
  "Type description for a file, directory, or folder as it would be displayed in
   a system file browser. Example from Windows: the `Desktop` folder
   is described as `Desktop`.

   Override for platforms with native ShellFolder implementations.

  f - a File object - `java.io.File`

  returns: the file type description as it would be displayed by a native file chooser
   or null if no native information is available. - `java.lang.String`"
  ([this f]
    (-> this (.getSystemTypeDescription f))))

(defn get-child
  "parent - a File object representing a directory or special folder - `java.io.File`
  file-name - a name of a file or folder which exists in parent - `java.lang.String`

  returns: a File object. This is normally constructed with new
   File(parent, fileName) except when parent and child are both
   special folders, in which case the File is a wrapper containing
   a ShellFolder object. - `java.io.File`"
  ([this parent file-name]
    (-> this (.getChild parent file-name))))

(defn file-system?
  "Checks if f represents a real directory or file as opposed to a
   special folder such as `Desktop`. Used by UI classes to decide if
   a folder is selectable when doing directory choosing.

  f - a File object - `java.io.File`

  returns: true if f is a real file or directory. - `boolean`"
  ([this f]
    (-> this (.isFileSystem f))))

(defn get-roots
  "Returns all root partitions on this system. For example, on
   Windows, this would be the `Desktop` folder, while on DOS this
   would be the A: through Z: drives.

  returns: `java.io.File[]`"
  ([this]
    (-> this (.getRoots))))

(defn hidden-file?
  "Returns whether a file is hidden or not.

  f - `java.io.File`

  returns: `boolean`"
  ([this f]
    (-> this (.isHiddenFile f))))

(defn root?
  "Determines if the given file is a root in the navigable tree(s).
   Examples: Windows 98 has one root, the Desktop folder. DOS has one root
   per drive letter, C:\, D:\, etc. Unix has one root,
   the `/` directory.

   The default implementation gets information from the ShellFolder class.

  f - a File object representing a directory - `java.io.File`

  returns: true if f is a root in the navigable tree. - `boolean`"
  ([this f]
    (-> this (.isRoot f))))

(defn drive?
  "Used by UI classes to decide whether to display a special icon
   for drives or partitions, e.g. a `hard disk` icon.

   The default implementation has no way of knowing, so always returns false.

  dir - a directory - `java.io.File`

  returns: false always - `boolean`"
  ([this dir]
    (-> this (.isDrive dir))))

(defn create-new-folder
  "Creates a new folder with a default folder name.

  containing-dir - `java.io.File`

  returns: `java.io.File`

  throws: java.io.IOException"
  ([this containing-dir]
    (-> this (.createNewFolder containing-dir))))

