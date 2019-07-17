(ns javax.tools.Diagnostic
  "Interface for diagnostics from tools.  A diagnostic usually reports
  a problem at a specific position in a source file.  However, not
  all diagnostics are associated with a position or a file.

  A position is a zero-based character offset from the beginning of
  a file.  Negative values (except NOPOS) are not valid
  positions.

  Line and column numbers begin at 1.  Negative values (except
  NOPOS) and 0 are not valid line or column numbers."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools Diagnostic]))

(defn get-kind
  "Gets the kind of this diagnostic, for example, error or
   warning.

  returns: the kind of this diagnostic - `javax.tools.Diagnostic.Kind`"
  ([this]
    (-> this (.getKind))))

(defn get-code
  "Gets a diagnostic code indicating the type of diagnostic.  The
   code is implementation-dependent and might be null.

  returns: a diagnostic code - `java.lang.String`"
  ([this]
    (-> this (.getCode))))

(defn get-position
  "Gets a character offset from the beginning of the source object
   associated with this diagnostic that indicates the location of
   the problem.  In addition, the following must be true:

   getStartPostion() <= getPosition()
   getPosition() <= getEndPosition()

  returns: character offset from beginning of source; NOPOS if getSource() would return null or if
   no location is suitable - `long`"
  ([this]
    (-> this (.getPosition))))

(defn get-column-number
  "Gets the column number of the character offset returned by
   getPosition().

  returns: a column number or NOPOS if and only if getPosition() returns NOPOS - `long`"
  ([this]
    (-> this (.getColumnNumber))))

(defn get-source
  "Gets the source object associated with this diagnostic.

  returns: the source object associated with this diagnostic.
   null if no source object is associated with the
   diagnostic. - `Diagnostic.S`"
  ([this]
    (-> this (.getSource))))

(defn get-start-position
  "Gets the character offset from the beginning of the file
   associated with this diagnostic that indicates the start of the
   problem.

  returns: offset from beginning of file; NOPOS if and
   only if getPosition() returns NOPOS - `long`"
  ([this]
    (-> this (.getStartPosition))))

(defn get-message
  "Gets a localized message for the given locale.  The actual
   message is implementation-dependent.  If the locale is null use the default locale.

  locale - a locale; might be null - `java.util.Locale`

  returns: a localized message - `java.lang.String`"
  ([this locale]
    (-> this (.getMessage locale))))

(defn get-end-position
  "Gets the character offset from the beginning of the file
   associated with this diagnostic that indicates the end of the
   problem.

  returns: offset from beginning of file; NOPOS if and
   only if getPosition() returns NOPOS - `long`"
  ([this]
    (-> this (.getEndPosition))))

(defn get-line-number
  "Gets the line number of the character offset returned by
   getPosition().

  returns: a line number or NOPOS if and only if getPosition() returns NOPOS - `long`"
  ([this]
    (-> this (.getLineNumber))))

