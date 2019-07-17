(ns jdk.util.zip.ZipEntry
  "This class is used to represent a ZIP file entry."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipEntry]))

(defn ->zip-entry
  "Constructor.

  Creates a new zip entry with the specified name.

  name - The entry name - `java.lang.String`

  throws: java.lang.NullPointerException - if the entry name is null"
  ([name]
    (new ZipEntry name)))

(def *-stored
  "Static Constant.

  Compression method for uncompressed entries.

  type: int"
  ZipEntry/STORED)

(def *-deflated
  "Static Constant.

  Compression method for compressed (deflated) entries.

  type: int"
  ZipEntry/DEFLATED)

(def *-locsig
  "Static Constant.

  type: long"
  ZipEntry/LOCSIG)

(def *-extsig
  "Static Constant.

  type: long"
  ZipEntry/EXTSIG)

(def *-censig
  "Static Constant.

  type: long"
  ZipEntry/CENSIG)

(def *-endsig
  "Static Constant.

  type: long"
  ZipEntry/ENDSIG)

(def *-lochdr
  "Static Constant.

  type: int"
  ZipEntry/LOCHDR)

(def *-exthdr
  "Static Constant.

  type: int"
  ZipEntry/EXTHDR)

(def *-cenhdr
  "Static Constant.

  type: int"
  ZipEntry/CENHDR)

(def *-endhdr
  "Static Constant.

  type: int"
  ZipEntry/ENDHDR)

(def *-locver
  "Static Constant.

  type: int"
  ZipEntry/LOCVER)

(def *-locflg
  "Static Constant.

  type: int"
  ZipEntry/LOCFLG)

(def *-lochow
  "Static Constant.

  type: int"
  ZipEntry/LOCHOW)

(def *-loctim
  "Static Constant.

  type: int"
  ZipEntry/LOCTIM)

(def *-loccrc
  "Static Constant.

  type: int"
  ZipEntry/LOCCRC)

(def *-locsiz
  "Static Constant.

  type: int"
  ZipEntry/LOCSIZ)

(def *-loclen
  "Static Constant.

  type: int"
  ZipEntry/LOCLEN)

(def *-locnam
  "Static Constant.

  type: int"
  ZipEntry/LOCNAM)

(def *-locext
  "Static Constant.

  type: int"
  ZipEntry/LOCEXT)

(def *-extcrc
  "Static Constant.

  type: int"
  ZipEntry/EXTCRC)

(def *-extsiz
  "Static Constant.

  type: int"
  ZipEntry/EXTSIZ)

(def *-extlen
  "Static Constant.

  type: int"
  ZipEntry/EXTLEN)

(def *-cenvem
  "Static Constant.

  type: int"
  ZipEntry/CENVEM)

(def *-cenver
  "Static Constant.

  type: int"
  ZipEntry/CENVER)

(def *-cenflg
  "Static Constant.

  type: int"
  ZipEntry/CENFLG)

(def *-cenhow
  "Static Constant.

  type: int"
  ZipEntry/CENHOW)

(def *-centim
  "Static Constant.

  type: int"
  ZipEntry/CENTIM)

(def *-cencrc
  "Static Constant.

  type: int"
  ZipEntry/CENCRC)

(def *-censiz
  "Static Constant.

  type: int"
  ZipEntry/CENSIZ)

(def *-cenlen
  "Static Constant.

  type: int"
  ZipEntry/CENLEN)

(def *-cennam
  "Static Constant.

  type: int"
  ZipEntry/CENNAM)

(def *-cenext
  "Static Constant.

  type: int"
  ZipEntry/CENEXT)

(def *-cencom
  "Static Constant.

  type: int"
  ZipEntry/CENCOM)

(def *-cendsk
  "Static Constant.

  type: int"
  ZipEntry/CENDSK)

(def *-cenatt
  "Static Constant.

  type: int"
  ZipEntry/CENATT)

(def *-cenatx
  "Static Constant.

  type: int"
  ZipEntry/CENATX)

(def *-cenoff
  "Static Constant.

  type: int"
  ZipEntry/CENOFF)

(def *-endsub
  "Static Constant.

  type: int"
  ZipEntry/ENDSUB)

(def *-endtot
  "Static Constant.

  type: int"
  ZipEntry/ENDTOT)

(def *-endsiz
  "Static Constant.

  type: int"
  ZipEntry/ENDSIZ)

(def *-endoff
  "Static Constant.

  type: int"
  ZipEntry/ENDOFF)

(def *-endcom
  "Static Constant.

  type: int"
  ZipEntry/ENDCOM)

(defn set-crc
  "Sets the CRC-32 checksum of the uncompressed entry data.

  crc - the CRC-32 value - `long`

  throws: java.lang.IllegalArgumentException - if the specified CRC-32 value is less than 0 or greater than 0xFFFFFFFF"
  ([this crc]
    (-> this (.setCrc crc))))

(defn set-time
  "Sets the last modification time of the entry.

    If the entry is output to a ZIP file or ZIP file formatted
   output stream the last modification time set by this method will
   be stored into the date and time fields of the zip file
   entry and encoded in standard MS-DOS date and time format.
   The default TimeZone is
   used to convert the epoch time to the MS-DOS data and time.

  time - The last modification time of the entry in milliseconds since the epoch - `long`"
  ([this time]
    (-> this (.setTime time))))

(defn set-compressed-size
  "Sets the size of the compressed entry data.

  csize - the compressed size to set to - `long`"
  ([this csize]
    (-> this (.setCompressedSize csize))))

(defn set-method
  "Sets the compression method for the entry.

  method - the compression method, either STORED or DEFLATED - `int`

  throws: java.lang.IllegalArgumentException - if the specified compression method is invalid"
  ([this method]
    (-> this (.setMethod method))))

(defn set-comment
  "Sets the optional comment string for the entry.

   ZIP entry comments have maximum length of 0xffff. If the length of the
   specified comment string is greater than 0xFFFF bytes after encoding, only
   the first 0xFFFF bytes are output to the ZIP file entry.

  comment - the comment string - `java.lang.String`"
  ([this comment]
    (-> this (.setComment comment))))

(defn set-extra
  "Sets the optional extra field data for the entry.

    Invoking this method may change this entry's last modification
   time, last access time and creation time, if the extra field
   data includes the extensible timestamp fields, such as NTFS tag
   0x0001 or Info-ZIP Extended Timestamp, as specified in
   Info-ZIP
   Application Note 970311.

  extra - The extra field data bytes - `byte[]`

  throws: java.lang.IllegalArgumentException - if the length of the specified extra field data is greater than 0xFFFF bytes"
  ([this extra]
    (-> this (.setExtra extra))))

(defn get-compressed-size
  "Returns the size of the compressed entry data.

    In the case of a stored entry, the compressed size will be the same
   as the uncompressed size of the entry.

  returns: the size of the compressed entry data, or -1 if not known - `long`"
  ([this]
    (-> this (.getCompressedSize))))

(defn set-creation-time
  "Sets the creation time of the entry.

    If set, the creation time will be stored into the extended
   timestamp fields of entry's optional extra data, when
   output to a ZIP file or ZIP file formatted stream.

  time - The creation time of the entry - `java.nio.file.attribute.FileTime`

  returns: This zip entry - `java.util.zip.ZipEntry`

  throws: java.lang.NullPointerException - if the time is null"
  ([this time]
    (-> this (.setCreationTime time))))

(defn get-crc
  "Returns the CRC-32 checksum of the uncompressed entry data.

  returns: the CRC-32 checksum of the uncompressed entry data, or -1 if
   not known - `long`"
  ([this]
    (-> this (.getCrc))))

(defn to-string
  "Returns a string representation of the ZIP entry.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-name
  "Returns the name of the entry.

  returns: the name of the entry - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn directory?
  "Returns true if this is a directory entry. A directory entry is
   defined to be one whose name ends with a '/'.

  returns: true if this is a directory entry - `boolean`"
  ([this]
    (-> this (.isDirectory))))

(defn get-extra
  "Returns the extra field data for the entry.

  returns: the extra field data for the entry, or null if none - `byte[]`"
  ([this]
    (-> this (.getExtra))))

(defn get-comment
  "Returns the comment string for the entry.

  returns: the comment string for the entry, or null if none - `java.lang.String`"
  ([this]
    (-> this (.getComment))))

(defn set-last-modified-time
  "Sets the last modification time of the entry.

    When output to a ZIP file or ZIP file formatted output stream
   the last modification time set by this method will be stored into
   zip file entry's date and time fields in standard
   MS-DOS date and time format), and the extended timestamp fields
   in optional extra data in UTC time.

  time - The last modification time of the entry - `java.nio.file.attribute.FileTime`

  returns: This zip entry - `java.util.zip.ZipEntry`

  throws: java.lang.NullPointerException - if the time is null"
  ([this time]
    (-> this (.setLastModifiedTime time))))

(defn set-last-access-time
  "Sets the last access time of the entry.

    If set, the last access time will be stored into the extended
   timestamp fields of entry's optional extra data, when output
   to a ZIP file or ZIP file formatted stream.

  time - The last access time of the entry - `java.nio.file.attribute.FileTime`

  returns: This zip entry - `java.util.zip.ZipEntry`

  throws: java.lang.NullPointerException - if the time is null"
  ([this time]
    (-> this (.setLastAccessTime time))))

(defn get-last-modified-time
  "Returns the last modification time of the entry.

    If the entry is read from a ZIP file or ZIP file formatted
   input stream, this is the last modification time from the zip
   file entry's optional extra data if the extended timestamp
   fields are present. Otherwise the last modification time is read
   from the entry's date and time fields, the default TimeZone is used to convert
   the standard MS-DOS formatted date and time to the epoch time.

  returns: The last modification time of the entry, null if not specified - `java.nio.file.attribute.FileTime`"
  ([this]
    (-> this (.getLastModifiedTime))))

(defn set-size
  "Sets the uncompressed size of the entry data.

  size - the uncompressed size in bytes - `long`

  throws: java.lang.IllegalArgumentException - if the specified size is less than 0, is greater than 0xFFFFFFFF when ZIP64 format is not supported, or is less than 0 when ZIP64 is supported"
  ([this size]
    (-> this (.setSize size))))

(defn clone
  "Returns a copy of this entry.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this entry.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-method
  "Returns the compression method of the entry.

  returns: the compression method of the entry, or -1 if not specified - `int`"
  ([this]
    (-> this (.getMethod))))

(defn get-last-access-time
  "Returns the last access time of the entry.

    The last access time is from the extended timestamp fields
   of entry's optional extra data when read from a ZIP file
   or ZIP file formatted stream.

  returns: The last access time of the entry, null if not specified - `java.nio.file.attribute.FileTime`"
  ([this]
    (-> this (.getLastAccessTime))))

(defn get-time
  "Returns the last modification time of the entry.

    If the entry is read from a ZIP file or ZIP file formatted
   input stream, this is the last modification time from the date and time fields of the zip file entry. The
   default TimeZone is used
   to convert the standard MS-DOS formatted date and time to the
   epoch time.

  returns: The last modification time of the entry in milliseconds
            since the epoch, or -1 if not specified - `long`"
  ([this]
    (-> this (.getTime))))

(defn get-size
  "Returns the uncompressed size of the entry data.

  returns: the uncompressed size of the entry data, or -1 if not known - `long`"
  ([this]
    (-> this (.getSize))))

(defn get-creation-time
  "Returns the creation time of the entry.

    The creation time is from the extended timestamp fields of
   entry's optional extra data when read from a ZIP file
   or ZIP file formatted stream.

  returns: the creation time of the entry, null if not specified - `java.nio.file.attribute.FileTime`"
  ([this]
    (-> this (.getCreationTime))))

