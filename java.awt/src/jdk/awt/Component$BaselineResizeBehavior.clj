(ns jdk.awt.Component$BaselineResizeBehavior
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Component$BaselineResizeBehavior]))

(def CONSTANT_ASCENT
  "Enum Constant.

  Indicates the baseline remains fixed relative to the
   y-origin.  That is, getBaseline returns
   the same value regardless of the height or width.  For example, a
   JLabel containing non-empty text with a
   vertical alignment of TOP should have a
   baseline type of CONSTANT_ASCENT.

  type: java.awt.Component.BaselineResizeBehavior"
  Component$BaselineResizeBehavior/CONSTANT_ASCENT)

(def CONSTANT_DESCENT
  "Enum Constant.

  Indicates the baseline remains fixed relative to the height
   and does not change as the width is varied.  That is, for
   any height H the difference between H and
   getBaseline(w, H) is the same.  For example, a
   JLabel containing non-empty text with a
   vertical alignment of BOTTOM should have a
   baseline type of CONSTANT_DESCENT.

  type: java.awt.Component.BaselineResizeBehavior"
  Component$BaselineResizeBehavior/CONSTANT_DESCENT)

(def CENTER_OFFSET
  "Enum Constant.

  Indicates the baseline remains a fixed distance from
   the center of the component.  That is, for any height H the
   difference between getBaseline(w, H) and
   H / 2 is the same (plus or minus one depending upon
   rounding error).

   Because of possible rounding errors it is recommended
   you ask for the baseline with two consecutive heights and use
   the return value to determine if you need to pad calculations
   by 1.  The following shows how to calculate the baseline for
   any height:


     Dimension preferredSize = component.getPreferredSize();
     int baseline = getBaseline(preferredSize.width,
                                preferredSize.height);
     int nextBaseline = getBaseline(preferredSize.width,
                                    preferredSize.height  1);
     // Amount to add to height when calculating where baseline
     // lands for a particular height:
     int padding = 0;
     // Where the baseline is relative to the mid point
     int baselineOffset = baseline - height / 2;
     if (preferredSize.height % 2 == 0 &&
         baseline != nextBaseline) {
         padding = 1;
     }
     else if (preferredSize.height % 2 == 1 &&
              baseline == nextBaseline) {
         baselineOffset--;
         padding = 1;
     }
     // The following calculates where the baseline lands for
     // the height z:
     int calculatedBaseline = (z  padding) / 2  baselineOffset;

  type: java.awt.Component.BaselineResizeBehavior"
  Component$BaselineResizeBehavior/CENTER_OFFSET)

(def OTHER
  "Enum Constant.

  Indicates the baseline resize behavior can not be expressed using
   any of the other constants.  This may also indicate the baseline
   varies with the width of the component.  This is also returned
   by components that do not have a baseline.

  type: java.awt.Component.BaselineResizeBehavior"
  Component$BaselineResizeBehavior/OTHER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Component.BaselineResizeBehavior c : Component.BaselineResizeBehavior.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.Component.BaselineResizeBehavior[]`"
  ([]
    (Component$BaselineResizeBehavior/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Component$BaselineResizeBehavior/valueOf name)))

