(ns jdk.nio.charset.StandardCharsets
  "Constant definitions for the standard Charsets. These
  charsets are guaranteed to be available on every implementation of the Java
  platform."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset StandardCharsets]))

(def *-us-ascii
  "Static Constant.

  Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the
   Unicode character set

  type: java.nio.charset.Charset"
  StandardCharsets/US_ASCII)

(def *-iso-8859-1
  "Static Constant.

  ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1

  type: java.nio.charset.Charset"
  StandardCharsets/ISO_8859_1)

(def *-utf-8
  "Static Constant.

  Eight-bit UCS Transformation Format

  type: java.nio.charset.Charset"
  StandardCharsets/UTF_8)

(def *-utf-16-be
  "Static Constant.

  Sixteen-bit UCS Transformation Format, big-endian byte order

  type: java.nio.charset.Charset"
  StandardCharsets/UTF_16BE)

(def *-utf-16-le
  "Static Constant.

  Sixteen-bit UCS Transformation Format, little-endian byte order

  type: java.nio.charset.Charset"
  StandardCharsets/UTF_16LE)

(def *-utf-16
  "Static Constant.

  Sixteen-bit UCS Transformation Format, byte order identified by an
   optional byte-order mark

  type: java.nio.charset.Charset"
  StandardCharsets/UTF_16)

