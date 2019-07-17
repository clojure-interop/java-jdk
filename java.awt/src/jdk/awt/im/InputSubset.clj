(ns jdk.awt.im.InputSubset
  "Defines additional Unicode subsets for use by input methods.  Unlike the
  UnicodeBlock subsets defined in the Character.UnicodeBlock class, these constants do not
  directly correspond to Unicode code blocks."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im InputSubset]))

(def *-latin
  "Static Constant.

  Constant for all Latin characters, including the characters
   in the BASIC_LATIN, LATIN_1_SUPPLEMENT, LATIN_EXTENDED_A,
   LATIN_EXTENDED_B Unicode character blocks.

  type: java.awt.im.InputSubset"
  InputSubset/LATIN)

(def *-latin-digits
  "Static Constant.

  Constant for the digits included in the BASIC_LATIN Unicode character
   block.

  type: java.awt.im.InputSubset"
  InputSubset/LATIN_DIGITS)

(def *-traditional-hanzi
  "Static Constant.

  Constant for all Han characters used in writing Traditional Chinese,
   including a subset of the CJK unified ideographs as well as Traditional
   Chinese Han characters that may be defined as surrogate characters.

  type: java.awt.im.InputSubset"
  InputSubset/TRADITIONAL_HANZI)

(def *-simplified-hanzi
  "Static Constant.

  Constant for all Han characters used in writing Simplified Chinese,
   including a subset of the CJK unified ideographs as well as Simplified
   Chinese Han characters that may be defined as surrogate characters.

  type: java.awt.im.InputSubset"
  InputSubset/SIMPLIFIED_HANZI)

(def *-kanji
  "Static Constant.

  Constant for all Han characters used in writing Japanese, including a
   subset of the CJK unified ideographs as well as Japanese Han characters
   that may be defined as surrogate characters.

  type: java.awt.im.InputSubset"
  InputSubset/KANJI)

(def *-hanja
  "Static Constant.

  Constant for all Han characters used in writing Korean, including a
   subset of the CJK unified ideographs as well as Korean Han characters
   that may be defined as surrogate characters.

  type: java.awt.im.InputSubset"
  InputSubset/HANJA)

(def *-halfwidth-katakana
  "Static Constant.

  Constant for the halfwidth katakana subset of the Unicode halfwidth and
   fullwidth forms character block.

  type: java.awt.im.InputSubset"
  InputSubset/HALFWIDTH_KATAKANA)

(def *-fullwidth-latin
  "Static Constant.

  Constant for the fullwidth ASCII variants subset of the Unicode halfwidth and
   fullwidth forms character block.

  type: java.awt.im.InputSubset"
  InputSubset/FULLWIDTH_LATIN)

(def *-fullwidth-digits
  "Static Constant.

  Constant for the fullwidth digits included in the Unicode halfwidth and
   fullwidth forms character block.

  type: java.awt.im.InputSubset"
  InputSubset/FULLWIDTH_DIGITS)

