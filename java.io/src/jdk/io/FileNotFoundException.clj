(ns jdk.io.FileNotFoundException
  "Signals that an attempt to open the file denoted by a specified pathname
  has failed.

   This exception will be thrown by the FileInputStream, FileOutputStream, and RandomAccessFile constructors when a file
  with the specified pathname does not exist.  It will also be thrown by these
  constructors if the file does exist but for some reason is inaccessible, for
  example when an attempt is made to open a read-only file for writing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileNotFoundException]))

(defn ->file-not-found-exception
  "Constructor.

  Constructs a FileNotFoundException with the
   specified detail message. The string s can be
   retrieved later by the
   Throwable.getMessage()
   method of class java.lang.Throwable.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new FileNotFoundException s))
  ([]
    (new FileNotFoundException )))

