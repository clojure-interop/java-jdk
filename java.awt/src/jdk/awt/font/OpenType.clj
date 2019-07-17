(ns jdk.awt.font.OpenType
  "The OpenType interface represents OpenType and
  TrueType fonts.  This interface makes it possible to obtain
  sfnt tables from the font.  A particular
  Font object can implement this interface.

  For more information on TrueType and OpenType fonts, see the
  OpenType specification.
  ( http://www.microsoft.com/typography/otspec/ )."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font OpenType]))

(defn get-version
  "Returns the version of the OpenType font.
   1.0 is represented as 0x00010000.

  returns: the version of the OpenType font. - `int`"
  (^Integer [^java.awt.font.OpenType this]
    (-> this (.getVersion))))

(defn get-font-table
  "Returns a subset of the table as an array of bytes
   for a specified tag.  Tags for sfnt tables include
   items like cmap, name and head.
   The byte array returned is a copy of the font data in
   memory.

  sfnt-tag - a four-character code as a 32-bit integer - `int`
  offset - index of first byte to return from table - `int`
  count - number of bytes to return from table - `int`

  returns: a subset of the table corresponding to
              sfntTag and containing the bytes
              starting at offset byte and including
              count bytes. - `byte[]`"
  ([^java.awt.font.OpenType this ^Integer sfnt-tag ^Integer offset ^Integer count]
    (-> this (.getFontTable sfnt-tag offset count)))
  ([^java.awt.font.OpenType this ^Integer sfnt-tag]
    (-> this (.getFontTable sfnt-tag))))

(defn get-font-table-size
  "Returns the size of the table for a specified tag. Tags for sfnt
   tables include items like cmap, name and head.

  sfnt-tag - a four-character code as a 32-bit integer - `int`

  returns: the size of the table corresponding to the specified
   tag. - `int`"
  (^Integer [^java.awt.font.OpenType this ^Integer sfnt-tag]
    (-> this (.getFontTableSize sfnt-tag))))

