(ns jdk.awt.dnd.DnDConstants
  "This class contains constant values representing
  the type of action(s) to be performed by a Drag and Drop operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DnDConstants]))

(def *-action-none
  "Static Constant.

  An int representing no action.

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_NONE)

(def *-action-copy
  "Static Constant.

  An int representing a `copy` action.

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_COPY)

(def *-action-move
  "Static Constant.

  An int representing a `move` action.

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_MOVE)

(def *-action-copy-or-move
  "Static Constant.

  An int representing a `copy` or
   `move` action.

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_COPY_OR_MOVE)

(def *-action-link
  "Static Constant.

  An int representing a `link` action.

   The link verb is found in many, if not all native DnD platforms, and the
   actual interpretation of LINK semantics is both platform
   and application dependent. Broadly speaking, the
   semantic is `do not copy, or move the operand, but create a reference
   to it`. Defining the meaning of `reference` is where ambiguity is
   introduced.

   The verb is provided for completeness, but its use is not recommended
   for DnD operations between logically distinct applications where
   misinterpretation of the operations semantics could lead to confusing
   results for the user.

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_LINK)

(def *-action-reference
  "Static Constant.

  An int representing a `reference`
   action (synonym for ACTION_LINK).

  type: java.lang.annotation.    int"
  DnDConstants/ACTION_REFERENCE)

