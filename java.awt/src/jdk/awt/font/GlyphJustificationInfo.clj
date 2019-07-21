(ns jdk.awt.font.GlyphJustificationInfo
  "The GlyphJustificationInfo class represents information
  about the justification properties of a glyph.  A glyph is the visual
  representation of one or more characters.  Many different glyphs can
  be used to represent a single character or combination of characters.
  The four justification properties represented by
  GlyphJustificationInfo are weight, priority, absorb and
  limit.

  Weight is the overall 'weight' of the glyph in the line.  Generally it is
  proportional to the size of the font.  Glyphs with larger weight are
  allocated a correspondingly larger amount of the change in space.

  Priority determines the justification phase in which this glyph is used.
  All glyphs of the same priority are examined before glyphs of the next
  priority.  If all the change in space can be allocated to these glyphs
  without exceeding their limits, then glyphs of the next priority are not
  examined. There are four priorities, kashida, whitespace, interchar,
  and none.  KASHIDA is the first priority examined. NONE is the last
  priority examined.

  Absorb determines whether a glyph absorbs all change in space.  Within a
  given priority, some glyphs may absorb all the change in space.  If any of
  these glyphs are present, no glyphs of later priority are examined.

  Limit determines the maximum or minimum amount by which the glyph can
  change. Left and right sides of the glyph can have different limits.

  Each GlyphJustificationInfo represents two sets of
  metrics, which are growing and shrinking.  Growing
  metrics are used when the glyphs on a line are to be
  spread apart to fit a larger width.  Shrinking metrics are used when
  the glyphs are to be moved together to fit a smaller width."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font GlyphJustificationInfo]))

(defn ->glyph-justification-info
  "Constructor.

  Constructs information about the justification properties of a
   glyph.

  weight - the weight of this glyph when allocating space. Must be non-negative. - `float`
  grow-absorb - if true this glyph absorbs all extra space at this priority and lower priority levels when it grows - `boolean`
  grow-priority - the priority level of this glyph when it grows - `int`
  grow-left-limit - the maximum amount by which the left side of this glyph can grow. Must be non-negative. - `float`
  grow-right-limit - the maximum amount by which the right side of this glyph can grow. Must be non-negative. - `float`
  shrink-absorb - if true, this glyph absorbs all remaining shrinkage at this and lower priority levels when it shrinks - `boolean`
  shrink-priority - the priority level of this glyph when it shrinks - `int`
  shrink-left-limit - the maximum amount by which the left side of this glyph can shrink. Must be non-negative. - `float`
  shrink-right-limit - the maximum amount by which the right side of this glyph can shrink. Must be non-negative. - `float`"
  (^GlyphJustificationInfo [^Float weight ^Boolean grow-absorb ^Integer grow-priority ^Float grow-left-limit ^Float grow-right-limit ^Boolean shrink-absorb ^Integer shrink-priority ^Float shrink-left-limit ^Float shrink-right-limit]
    (new GlyphJustificationInfo weight grow-absorb grow-priority grow-left-limit grow-right-limit shrink-absorb shrink-priority shrink-left-limit shrink-right-limit)))

(def *-priority-kashida
  "Static Constant.

  The highest justification priority.

  type: int"
  GlyphJustificationInfo/PRIORITY_KASHIDA)

(def *-priority-whitespace
  "Static Constant.

  The second highest justification priority.

  type: int"
  GlyphJustificationInfo/PRIORITY_WHITESPACE)

(def *-priority-interchar
  "Static Constant.

  The second lowest justification priority.

  type: int"
  GlyphJustificationInfo/PRIORITY_INTERCHAR)

(def *-priority-none
  "Static Constant.

  The lowest justification priority.

  type: int"
  GlyphJustificationInfo/PRIORITY_NONE)

(defn weight
  "Instance Constant.

  The weight of this glyph.

  type: float"
  (^Float [^GlyphJustificationInfo this]
    (-> this .-weight)))

(defn grow-priority
  "Instance Constant.

  The priority level of this glyph as it is growing.

  type: int"
  (^Integer [^GlyphJustificationInfo this]
    (-> this .-growPriority)))

(defn grow-absorb
  "Instance Constant.

  If true, this glyph absorbs all extra
   space at this and lower priority levels when it grows.

  type: boolean"
  (^Boolean [^GlyphJustificationInfo this]
    (-> this .-growAbsorb)))

(defn grow-left-limit
  "Instance Constant.

  The maximum amount by which the left side of this glyph can grow.

  type: float"
  (^Float [^GlyphJustificationInfo this]
    (-> this .-growLeftLimit)))

(defn grow-right-limit
  "Instance Constant.

  The maximum amount by which the right side of this glyph can grow.

  type: float"
  (^Float [^GlyphJustificationInfo this]
    (-> this .-growRightLimit)))

(defn shrink-priority
  "Instance Constant.

  The priority level of this glyph as it is shrinking.

  type: int"
  (^Integer [^GlyphJustificationInfo this]
    (-> this .-shrinkPriority)))

(defn shrink-absorb
  "Instance Constant.

  If true,this glyph absorbs all remaining shrinkage at
   this and lower priority levels as it shrinks.

  type: boolean"
  (^Boolean [^GlyphJustificationInfo this]
    (-> this .-shrinkAbsorb)))

(defn shrink-left-limit
  "Instance Constant.

  The maximum amount by which the left side of this glyph can shrink
   (a positive number).

  type: float"
  (^Float [^GlyphJustificationInfo this]
    (-> this .-shrinkLeftLimit)))

(defn shrink-right-limit
  "Instance Constant.

  The maximum amount by which the right side of this glyph can shrink
   (a positive number).

  type: float"
  (^Float [^GlyphJustificationInfo this]
    (-> this .-shrinkRightLimit)))

