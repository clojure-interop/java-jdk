(ns jdk.awt.font.TextLayout$CaretPolicy
  "Defines a policy for determining the strong caret location.
  This class contains one method, getStrongCaret, which
  is used to specify the policy that determines the strong caret in
  dual-caret text.  The strong caret is used to move the caret to the
  left or right. Instances of this class can be passed to
  getCaretShapes, getNextLeftHit and
  getNextRightHit to customize strong caret
  selection.

  To specify alternate caret policies, subclass CaretPolicy
  and override getStrongCaret.  getStrongCaret
  should inspect the two TextHitInfo arguments and choose
  one of them as the strong caret.

  Most clients do not need to use this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font TextLayout$CaretPolicy]))

(defn ->caret-policy
  "Constructor.

  Constructs a CaretPolicy."
  ([]
    (new TextLayout$CaretPolicy )))

(defn get-strong-caret
  "Chooses one of the specified TextHitInfo instances as
   a strong caret in the specified TextLayout.

  hit-1 - a valid hit in layout - `java.awt.font.TextHitInfo`
  hit-2 - a valid hit in layout - `java.awt.font.TextHitInfo`
  layout - the TextLayout in which hit1 and hit2 are used - `java.awt.font.TextLayout`

  returns: hit1 or hit2
          (or an equivalent TextHitInfo), indicating the
          strong caret. - `java.awt.font.TextHitInfo`"
  ([^java.awt.font.TextLayout$CaretPolicy this ^java.awt.font.TextHitInfo hit-1 ^java.awt.font.TextHitInfo hit-2 ^java.awt.font.TextLayout layout]
    (-> this (.getStrongCaret hit-1 hit-2 layout))))

