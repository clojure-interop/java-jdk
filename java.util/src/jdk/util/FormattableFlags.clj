(ns jdk.util.FormattableFlags
  "FomattableFlags are passed to the Formattable.formatTo() method and modify the output format for java.util.Formattables.  Implementations of Formattable are
  responsible for interpreting and validating any flags."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util FormattableFlags]))

(def *-left-justify
  "Static Constant.

  Left-justifies the output.  Spaces ('\\u0020') will be added
   at the end of the converted value as required to fill the minimum width
   of the field.  If this flag is not set then the output will be
   right-justified.

    This flag corresponds to '-' ('\\u002d') in
   the format specifier.

  type: int"
  FormattableFlags/LEFT_JUSTIFY)

(def *-uppercase
  "Static Constant.

  Converts the output to upper case according to the rules of the
   java.util.locale given during creation of the
   formatter argument of the formatTo() method.  The output should be equivalent the following
   invocation of String.toUpperCase(java.util.Locale)



       out.toUpperCase()

    This flag corresponds to 'S' ('\\u0053') in
   the format specifier.

  type: int"
  FormattableFlags/UPPERCASE)

(def *-alternate
  "Static Constant.

  Requires the output to use an alternate form.  The definition of the
   form is specified by the Formattable.

    This flag corresponds to '#' ('\\u0023') in
   the format specifier.

  type: int"
  FormattableFlags/ALTERNATE)

