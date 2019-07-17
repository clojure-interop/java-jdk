(ns jdk.util.Locale$FilteringMode
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Locale$FilteringMode]))

(def AUTOSELECT_FILTERING
  "Enum Constant.

  Specifies automatic filtering mode based on the given Language
   Priority List consisting of language ranges. If all of the ranges
   are basic, basic filtering is selected. Otherwise, extended
   filtering is selected.

  type: java.util.Locale.FilteringMode"
  Locale$FilteringMode/AUTOSELECT_FILTERING)

(def EXTENDED_FILTERING
  "Enum Constant.

  Specifies extended filtering.

  type: java.util.Locale.FilteringMode"
  Locale$FilteringMode/EXTENDED_FILTERING)

(def IGNORE_EXTENDED_RANGES
  "Enum Constant.

  Specifies basic filtering: Note that any extended language ranges
   included in the given Language Priority List are ignored.

  type: java.util.Locale.FilteringMode"
  Locale$FilteringMode/IGNORE_EXTENDED_RANGES)

(def MAP_EXTENDED_RANGES
  "Enum Constant.

  Specifies basic filtering: If any extended language ranges are
   included in the given Language Priority List, they are mapped to the
   basic language range. Specifically, a language range starting with a
   subtag `*` is treated as a language range `*`. For
   example, `*-US` is treated as `*`. If `*` is
   not the first subtag, `*` and extra `-` are removed.
   For example, `ja-*-JP` is mapped to `ja-JP`.

  type: java.util.Locale.FilteringMode"
  Locale$FilteringMode/MAP_EXTENDED_RANGES)

(def REJECT_EXTENDED_RANGES
  "Enum Constant.

  Specifies basic filtering: If any extended language ranges are
   included in the given Language Priority List, the list is rejected
   and the filtering method throws IllegalArgumentException.

  type: java.util.Locale.FilteringMode"
  Locale$FilteringMode/REJECT_EXTENDED_RANGES)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Locale.FilteringMode c : Locale.FilteringMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.util.Locale.FilteringMode[]`"
  ([]
    (Locale$FilteringMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.util.Locale.FilteringMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (Locale$FilteringMode/valueOf name)))

