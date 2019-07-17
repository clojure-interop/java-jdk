(ns jdk.text.Bidi
  "This class implements the Unicode Bidirectional Algorithm.

  A Bidi object provides information on the bidirectional reordering of the text
  used to create it.  This is required, for example, to properly display Arabic
  or Hebrew text.  These languages are inherently mixed directional, as they order
  numbers from left-to-right while ordering most other text from right-to-left.

  Once created, a Bidi object can be queried to see if the text it represents is
  all left-to-right or all right-to-left.  Such objects are very lightweight and
  this text is relatively easy to process.

  If there are multiple runs of text, information about the runs can be accessed
  by indexing to get the start, limit, and level of a run.  The level represents
  both the direction and the 'nesting level' of a directional run.  Odd levels
  are right-to-left, while even levels are left-to-right.  So for example level
  0 represents left-to-right text, while level 1 represents right-to-left text, and
  level 2 represents left-to-right text embedded in a right-to-left run."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text Bidi]))

(defn ->bidi
  "Constructor.

  Create Bidi from the given text, embedding, and direction information.
   The embeddings array may be null.  If present, the values represent embedding level
   information.  Negative values from -1 to -61 indicate overrides at the absolute value
   of the level.  Positive values from 1 to 61 indicate embeddings.  Where values are
   zero, the base embedding level as determined by the base direction is assumed.

  text - an array containing the paragraph of text to process. - `char[]`
  text-start - the index into the text array of the start of the paragraph. - `int`
  embeddings - an array containing embedding values for each character in the paragraph. This can be null, in which case it is assumed that there is no external embedding information. - `byte[]`
  emb-start - the index into the embedding array of the start of the paragraph. - `int`
  paragraph-length - the length of the paragraph in the text and embeddings arrays. - `int`
  flags - a collection of flags that control the algorithm. The algorithm understands the flags DIRECTION_LEFT_TO_RIGHT, DIRECTION_RIGHT_TO_LEFT, DIRECTION_DEFAULT_LEFT_TO_RIGHT, and DIRECTION_DEFAULT_RIGHT_TO_LEFT. Other values are reserved. - `int`"
  ([text ^Integer text-start embeddings ^Integer emb-start ^Integer paragraph-length ^Integer flags]
    (new Bidi text text-start embeddings emb-start paragraph-length flags))
  ([^java.lang.String paragraph ^Integer flags]
    (new Bidi paragraph flags))
  ([^java.text.AttributedCharacterIterator paragraph]
    (new Bidi paragraph)))

(def *-direction-left-to-right
  "Static Constant.

  Constant indicating base direction is left-to-right.

  type: int"
  Bidi/DIRECTION_LEFT_TO_RIGHT)

(def *-direction-right-to-left
  "Static Constant.

  Constant indicating base direction is right-to-left.

  type: int"
  Bidi/DIRECTION_RIGHT_TO_LEFT)

(def *-direction-default-left-to-right
  "Static Constant.

  Constant indicating that the base direction depends on the first strong
   directional character in the text according to the Unicode
   Bidirectional Algorithm.  If no strong directional character is present,
   the base direction is left-to-right.

  type: int"
  Bidi/DIRECTION_DEFAULT_LEFT_TO_RIGHT)

(def *-direction-default-right-to-left
  "Static Constant.

  Constant indicating that the base direction depends on the first strong
   directional character in the text according to the Unicode
   Bidirectional Algorithm.  If no strong directional character is present,
   the base direction is right-to-left.

  type: int"
  Bidi/DIRECTION_DEFAULT_RIGHT_TO_LEFT)

(defn *requires-bidi
  "Return true if the specified text requires bidi analysis.  If this returns false,
   the text will display left-to-right.  Clients can then avoid constructing a Bidi object.
   Text in the Arabic Presentation Forms area of Unicode is presumed to already be shaped
   and ordered for display, and so will not cause this function to return true.

  text - the text containing the characters to test - `char[]`
  start - the start of the range of characters to test - `int`
  limit - the limit of the range of characters to test - `int`

  returns: true if the range of characters requires bidi analysis - `boolean`"
  (^Boolean [text ^Integer start ^Integer limit]
    (Bidi/requiresBidi text start limit)))

(defn *reorder-visually
  "Reorder the objects in the array into visual order based on their levels.
   This is a utility function to use when you have a collection of objects
   representing runs of text in logical order, each run containing text
   at a single level.  The elements at index from
   objectStart up to objectStart  count
   in the objects array will be reordered into visual order assuming
   each run of text has the level indicated by the corresponding element
   in the levels array (at index - objectStart  levelStart).

  levels - an array representing the bidi level of each object - `byte[]`
  level-start - the start position in the levels array - `int`
  objects - the array of objects to be reordered into visual order - `java.lang.Object[]`
  object-start - the start position in the objects array - `int`
  count - the number of objects to reorder - `int`"
  ([levels ^Integer level-start objects ^Integer object-start ^Integer count]
    (Bidi/reorderVisually levels level-start objects object-start count)))

(defn get-run-limit
  "Return the index of the character past the end of the nth logical run in this line, as
   an offset from the start of the line.  For example, this will return the length
   of the line for the last run on the line.

  run - the index of the run, between 0 and getRunCount() - `int`

  returns: limit the limit of the run - `int`"
  (^Integer [^java.text.Bidi this ^Integer run]
    (-> this (.getRunLimit run))))

(defn left-to-right?
  "Return true if the line is all left-to-right text and the base direction is left-to-right.

  returns: true if the line is all left-to-right text and the base direction is left-to-right - `boolean`"
  (^Boolean [^java.text.Bidi this]
    (-> this (.isLeftToRight))))

(defn to-string
  "Display the bidi internal state, used in debugging.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.text.Bidi this]
    (-> this (.toString))))

(defn right-to-left?
  "Return true if the line is all right-to-left text, and the base direction is right-to-left.

  returns: true if the line is all right-to-left text, and the base direction is right-to-left - `boolean`"
  (^Boolean [^java.text.Bidi this]
    (-> this (.isRightToLeft))))

(defn get-level-at
  "Return the resolved level of the character at offset.  If offset is
   < 0 or ≥ the length of the line, return the base direction
   level.

  offset - the index of the character for which to return the level - `int`

  returns: the resolved level of the character at offset - `int`"
  (^Integer [^java.text.Bidi this ^Integer offset]
    (-> this (.getLevelAt offset))))

(defn get-run-start
  "Return the index of the character at the start of the nth logical run in this line, as
   an offset from the start of the line.

  run - the index of the run, between 0 and getRunCount() - `int`

  returns: the start of the run - `int`"
  (^Integer [^java.text.Bidi this ^Integer run]
    (-> this (.getRunStart run))))

(defn get-run-level
  "Return the level of the nth logical run in this line.

  run - the index of the run, between 0 and getRunCount() - `int`

  returns: the level of the run - `int`"
  (^Integer [^java.text.Bidi this ^Integer run]
    (-> this (.getRunLevel run))))

(defn mixed?
  "Return true if the line is not left-to-right or right-to-left.  This means it either has mixed runs of left-to-right
   and right-to-left text, or the base direction differs from the direction of the only run of text.

  returns: true if the line is not left-to-right or right-to-left. - `boolean`"
  (^Boolean [^java.text.Bidi this]
    (-> this (.isMixed))))

(defn get-run-count
  "Return the number of level runs.

  returns: the number of level runs - `int`"
  (^Integer [^java.text.Bidi this]
    (-> this (.getRunCount))))

(defn get-length
  "Return the length of text in the line.

  returns: the length of text in the line - `int`"
  (^Integer [^java.text.Bidi this]
    (-> this (.getLength))))

(defn create-line-bidi
  "Create a Bidi object representing the bidi information on a line of text within
   the paragraph represented by the current Bidi.  This call is not required if the
   entire paragraph fits on one line.

  line-start - the offset from the start of the paragraph to the start of the line. - `int`
  line-limit - the offset from the start of the paragraph to the limit of the line. - `int`

  returns: a Bidi object - `java.text.Bidi`"
  (^java.text.Bidi [^java.text.Bidi this ^Integer line-start ^Integer line-limit]
    (-> this (.createLineBidi line-start line-limit))))

(defn base-is-left-to-right
  "Return true if the base direction is left-to-right.

  returns: true if the base direction is left-to-right - `boolean`"
  (^Boolean [^java.text.Bidi this]
    (-> this (.baseIsLeftToRight))))

(defn get-base-level
  "Return the base level (0 if left-to-right, 1 if right-to-left).

  returns: the base level - `int`"
  (^Integer [^java.text.Bidi this]
    (-> this (.getBaseLevel))))

