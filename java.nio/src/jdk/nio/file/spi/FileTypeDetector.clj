(ns jdk.nio.file.spi.FileTypeDetector
  "A file type detector for probing a file to guess its file type.

   A file type detector is a concrete implementation of this class, has a
  zero-argument constructor, and implements the abstract methods specified
  below.

   The means by which a file type detector determines the file type is
  highly implementation specific. A simple implementation might examine the
  file extension (a convention used in some platforms) and map it to
  a file type. In other cases, the file type may be stored as a file  attribute or the bytes in a
  file may be examined to guess its file type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.spi FileTypeDetector]))

(defn probe-content-type
  "Probes the given file to guess its content type.

    The means by which this method determines the file type is highly
   implementation specific. It may simply examine the file name, it may use
   a file attribute,
   or it may examines bytes in the file.

    The probe result is the string form of the value of a
   Multipurpose Internet Mail Extension (MIME) content type as
   defined by RFC 2045:
   Multipurpose Internet Mail Extensions (MIME) Part One: Format of Internet
   Message Bodies. The string must be parsable according to the
   grammar in the RFC 2045.

  path - the path to the file to probe - `java.nio.file.Path`

  returns: The content type or null if the file type is not
            recognized - `java.lang.String`

  throws: java.io.IOException - An I/O error occurs"
  ([^java.nio.file.spi.FileTypeDetector this ^java.nio.file.Path path]
    (-> this (.probeContentType path))))

