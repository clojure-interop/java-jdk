(ns jdk.nio.channels.FileLock
  "A token representing a lock on a region of a file.

   A file-lock object is created each time a lock is acquired on a file via
  one of the lock or tryLock methods of the
  FileChannel class, or the lock
  or tryLock
  methods of the AsynchronousFileChannel class.

   A file-lock object is initially valid.  It remains valid until the lock
  is released by invoking the release method, by closing the
  channel that was used to acquire it, or by the termination of the Java
  virtual machine, whichever comes first.  The validity of a lock may be
  tested by invoking its isValid method.

   A file lock is either exclusive or shared.  A shared lock
  prevents other concurrently-running programs from acquiring an overlapping
  exclusive lock, but does allow them to acquire overlapping shared locks.  An
  exclusive lock prevents other programs from acquiring an overlapping lock of
  either type.  Once it is released, a lock has no further effect on the locks
  that may be acquired by other programs.

   Whether a lock is exclusive or shared may be determined by invoking its
  isShared method.  Some platforms do not support shared
  locks, in which case a request for a shared lock is automatically converted
  into a request for an exclusive lock.

   The locks held on a particular file by a single Java virtual machine do
  not overlap.  The overlaps method may be used to test
  whether a candidate lock range overlaps an existing lock.

   A file-lock object records the file channel upon whose file the lock is
  held, the type and validity of the lock, and the position and size of the
  locked region.  Only the validity of a lock is subject to change over time;
  all other aspects of a lock's state are immutable.

   File locks are held on behalf of the entire Java virtual machine.
  They are not suitable for controlling access to a file by multiple
  threads within the same virtual machine.

   File-lock objects are safe for use by multiple concurrent threads.


   Platform dependencies

   This file-locking API is intended to map directly to the native locking
  facility of the underlying operating system.  Thus the locks held on a file
  should be visible to all programs that have access to the file, regardless
  of the language in which those programs are written.

   Whether or not a lock actually prevents another program from accessing
  the content of the locked region is system-dependent and therefore
  unspecified.  The native file-locking facilities of some systems are merely
  advisory, meaning that programs must cooperatively observe a known
  locking protocol in order to guarantee data integrity.  On other systems
  native file locks are mandatory, meaning that if one program locks a
  region of a file then other programs are actually prevented from accessing
  that region in a way that would violate the lock.  On yet other systems,
  whether native file locks are advisory or mandatory is configurable on a
  per-file basis.  To ensure consistent and correct behavior across platforms,
  it is strongly recommended that the locks provided by this API be used as if
  they were advisory locks.

   On some systems, acquiring a mandatory lock on a region of a file
  prevents that region from being mapped into memory, and vice versa.  Programs that combine
  locking and mapping should be prepared for this combination to fail.

   On some systems, closing a channel releases all locks held by the Java
  virtual machine on the underlying file regardless of whether the locks were
  acquired via that channel or via another channel open on the same file.  It
  is strongly recommended that, within a program, a unique channel be used to
  acquire all locks on any given file.

   Some network filesystems permit file locking to be used with
  memory-mapped files only when the locked regions are page-aligned and a
  whole multiple of the underlying hardware's page size.  Some network
  filesystems do not implement file locks on regions that extend past a
  certain position, often 230 or 231.  In general, great
  care should be taken when locking files that reside on network filesystems."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels FileLock]))

(defn release
  "Releases this lock.

    If this lock object is valid then invoking this method releases the
   lock and renders the object invalid.  If this lock object is invalid
   then invoking this method has no effect.

  throws: java.nio.channels.ClosedChannelException - If the channel that was used to acquire this lock is no longer open"
  ([^java.nio.channels.FileLock this]
    (-> this (.release))))

(defn to-string
  "Returns a string describing the range, type, and validity of this lock.

  returns: A descriptive string - `java.lang.String`"
  (^java.lang.String [^java.nio.channels.FileLock this]
    (-> this (.toString))))

(defn overlaps
  "Tells whether or not this lock overlaps the given lock range.

  position - The starting position of the lock range - `long`
  size - The size of the lock range - `long`

  returns: true if, and only if, this lock and the given lock
            range overlap by at least one byte - `boolean`"
  (^Boolean [^java.nio.channels.FileLock this ^Long position ^Long size]
    (-> this (.overlaps position size))))

(defn position
  "Returns the position within the file of the first byte of the locked
   region.

    A locked region need not be contained within, or even overlap, the
   actual underlying file, so the value returned by this method may exceed
   the file's current size.

  returns: The position - `long`"
  (^Long [^java.nio.channels.FileLock this]
    (-> this (.position))))

(defn shared?
  "Tells whether this lock is shared.

  returns: true if lock is shared,
           false if it is exclusive - `boolean`"
  (^Boolean [^java.nio.channels.FileLock this]
    (-> this (.isShared))))

(defn acquired-by
  "Returns the channel upon whose file this lock was acquired.

  returns: The channel upon whose file this lock was acquired. - `java.nio.channels.Channel`"
  (^java.nio.channels.Channel [^java.nio.channels.FileLock this]
    (-> this (.acquiredBy))))

(defn close
  "This method invokes the release() method. It was added
   to the class so that it could be used in conjunction with the
   automatic resource management block construct.

  throws: java.io.IOException"
  ([^java.nio.channels.FileLock this]
    (-> this (.close))))

(defn valid?
  "Tells whether or not this lock is valid.

    A lock object remains valid until it is released or the associated
   file channel is closed, whichever comes first.

  returns: true if, and only if, this lock is valid - `boolean`"
  (^Boolean [^java.nio.channels.FileLock this]
    (-> this (.isValid))))

(defn channel
  "Returns the file channel upon whose file this lock was acquired.

    This method has been superseded by the acquiredBy
   method.

  returns: The file channel, or null if the file lock was not
            acquired by a file channel. - `java.nio.s.FileChannel`"
  (^java.nio.s.FileChannel [^java.nio.channels.FileLock this]
    (-> this (.channel))))

(defn size
  "Returns the size of the locked region in bytes.

    A locked region need not be contained within, or even overlap, the
   actual underlying file, so the value returned by this method may exceed
   the file's current size.

  returns: The size of the locked region - `long`"
  (^Long [^java.nio.channels.FileLock this]
    (-> this (.size))))

