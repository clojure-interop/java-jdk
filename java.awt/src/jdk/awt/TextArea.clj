(ns jdk.awt.TextArea
  "A TextArea object is a multi-line region
  that displays text. It can be set to allow editing or
  to be read-only.

  The following image shows the appearance of a text area:



  This text area could be created by the following line of code:



  new TextArea(\"Hello\", 5, 40);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt TextArea]))

(defn ->text-area
  "Constructor.

  Constructs a new text area with the specified text,
   and with the rows, columns, and scroll bar visibility
   as specified.  All TextArea constructors defer to
   this one.

   The TextArea class defines several constants
   that can be supplied as values for the
   scrollbars argument:

   SCROLLBARS_BOTH,
   SCROLLBARS_VERTICAL_ONLY,
   SCROLLBARS_HORIZONTAL_ONLY,
   SCROLLBARS_NONE.

   Any other value for the
   scrollbars argument is invalid and will result in
   this text area being created with scrollbar visibility equal to
   the default value of SCROLLBARS_BOTH.

  text - the text to be displayed; if text is null, the empty string \"\" will be displayed - `java.lang.String`
  rows - the number of rows; if rows is less than 0, rows is set to 0 - `int`
  columns - the number of columns; if columns is less than 0, columns is set to 0 - `int`
  scrollbars - a constant that determines what scrollbars are created to view the text area - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  (^TextArea [^java.lang.String text ^Integer rows ^Integer columns ^Integer scrollbars]
    (new TextArea text rows columns scrollbars))
  (^TextArea [^java.lang.String text ^Integer rows ^Integer columns]
    (new TextArea text rows columns))
  (^TextArea [^Integer rows ^Integer columns]
    (new TextArea rows columns))
  (^TextArea [^java.lang.String text]
    (new TextArea text))
  (^TextArea []
    (new TextArea )))

(def *-scrollbars-both
  "Static Constant.

  Create and display both vertical and horizontal scrollbars.

  type: int"
  TextArea/SCROLLBARS_BOTH)

(def *-scrollbars-vertical-only
  "Static Constant.

  Create and display vertical scrollbar only.

  type: int"
  TextArea/SCROLLBARS_VERTICAL_ONLY)

(def *-scrollbars-horizontal-only
  "Static Constant.

  Create and display horizontal scrollbar only.

  type: int"
  TextArea/SCROLLBARS_HORIZONTAL_ONLY)

(def *-scrollbars-none
  "Static Constant.

  Do not create or display any scrollbars for the text area.

  type: int"
  TextArea/SCROLLBARS_NONE)

(defn get-minimum-size
  "Determines the minimum size of a text area with the specified
   number of rows and columns.

  rows - the number of rows - `int`
  columns - the number of columns - `int`

  returns: the minimum dimensions required to display
                         the text area with the specified
                         number of rows and columns - `java.awt.Dimension`"
  (^java.awt.Dimension [^TextArea this ^Integer rows ^Integer columns]
    (-> this (.getMinimumSize rows columns)))
  (^java.awt.Dimension [^TextArea this]
    (-> this (.getMinimumSize))))

(defn set-columns
  "Sets the number of columns for this text area.

  columns - the number of columns - `int`

  throws: java.lang.IllegalArgumentException - if the value supplied for columns is less than 0"
  ([^TextArea this ^Integer columns]
    (-> this (.setColumns columns))))

(defn get-columns
  "Returns the number of columns in this text area.

  returns: the number of columns in the text area - `int`"
  (^Integer [^TextArea this]
    (-> this (.getColumns))))

(defn add-notify
  "Creates the TextArea's peer.  The peer allows us to modify
   the appearance of the TextArea without changing any of its
   functionality."
  ([^TextArea this]
    (-> this (.addNotify))))

(defn get-scrollbar-visibility
  "Returns an enumerated value that indicates which scroll bars
   the text area uses.

   The TextArea class defines four integer constants
   that are used to specify which scroll bars are available.
   TextArea has one constructor that gives the
   application discretion over scroll bars.

  returns: an integer that indicates which scroll bars are used - `int`"
  (^Integer [^TextArea this]
    (-> this (.getScrollbarVisibility))))

(defn preferred-size
  "Deprecated. As of JDK version 1.1,
   replaced by getPreferredSize(int, int).

  rows - `int`
  columns - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^TextArea this ^Integer rows ^Integer columns]
    (-> this (.preferredSize rows columns)))
  (^java.awt.Dimension [^TextArea this]
    (-> this (.preferredSize))))

(defn get-rows
  "Returns the number of rows in the text area.

  returns: the number of rows in the text area - `int`"
  (^Integer [^TextArea this]
    (-> this (.getRows))))

(defn get-accessible-context
  "Returns the AccessibleContext associated with
   this TextArea. For text areas, the
   AccessibleContext takes the form of an
   AccessibleAWTTextArea.
   A new AccessibleAWTTextArea instance is created if necessary.

  returns: an AccessibleAWTTextArea that serves as the
           AccessibleContext of this TextArea - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^TextArea this]
    (-> this (.getAccessibleContext))))

(defn replace-text
  "Deprecated. As of JDK version 1.1,
   replaced by replaceRange(String, int, int).

  str - `java.lang.String`
  start - `int`
  end - `int`"
  ([^TextArea this ^java.lang.String str ^Integer start ^Integer end]
    (-> this (.replaceText str start end))))

(defn append
  "Appends the given text to the text area's current text.
   Note that passing null or inconsistent
   parameters is invalid and will result in unspecified
   behavior.

  str - the non-null text to append - `java.lang.String`"
  ([^TextArea this ^java.lang.String str]
    (-> this (.append str))))

(defn insert-text
  "Deprecated. As of JDK version 1.1,
   replaced by insert(String, int).

  str - `java.lang.String`
  pos - `int`"
  ([^TextArea this ^java.lang.String str ^Integer pos]
    (-> this (.insertText str pos))))

(defn insert
  "Inserts the specified text at the specified position
   in this text area.
   Note that passing null or inconsistent
   parameters is invalid and will result in unspecified
   behavior.

  str - the non-null text to insert - `java.lang.String`
  pos - the position at which to insert - `int`"
  ([^TextArea this ^java.lang.String str ^Integer pos]
    (-> this (.insert str pos))))

(defn replace-range
  "Replaces text between the indicated start and end positions
   with the specified replacement text.  The text at the end
   position will not be replaced.  The text at the start
   position will be replaced (unless the start position is the
   same as the end position).
   The text position is zero-based.  The inserted substring may be
   of a different length than the text it replaces.
   Note that passing null or inconsistent
   parameters is invalid and will result in unspecified
   behavior.

  str - the non-null text to use as the replacement - `java.lang.String`
  start - the start position - `int`
  end - the end position - `int`"
  ([^TextArea this ^java.lang.String str ^Integer start ^Integer end]
    (-> this (.replaceRange str start end))))

(defn append-text
  "Deprecated. As of JDK version 1.1,
   replaced by append(String).

  str - `java.lang.String`"
  ([^TextArea this ^java.lang.String str]
    (-> this (.appendText str))))

(defn set-rows
  "Sets the number of rows for this text area.

  rows - the number of rows - `int`

  throws: java.lang.IllegalArgumentException - if the value supplied for rows is less than 0"
  ([^TextArea this ^Integer rows]
    (-> this (.setRows rows))))

(defn minimum-size
  "Deprecated. As of JDK version 1.1,
   replaced by getMinimumSize(int, int).

  rows - `int`
  columns - `int`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^TextArea this ^Integer rows ^Integer columns]
    (-> this (.minimumSize rows columns)))
  (^java.awt.Dimension [^TextArea this]
    (-> this (.minimumSize))))

(defn get-preferred-size
  "Determines the preferred size of a text area with the specified
   number of rows and columns.

  rows - the number of rows - `int`
  columns - the number of columns - `int`

  returns: the preferred dimensions required to display
                         the text area with the specified
                         number of rows and columns - `java.awt.Dimension`"
  (^java.awt.Dimension [^TextArea this ^Integer rows ^Integer columns]
    (-> this (.getPreferredSize rows columns)))
  (^java.awt.Dimension [^TextArea this]
    (-> this (.getPreferredSize))))

