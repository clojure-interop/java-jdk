(ns javax.swing.plaf.nimbus.AbstractRegionPainter$PaintContext$CacheMode
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus AbstractRegionPainter$PaintContext$CacheMode]))

(def NO_CACHING
  "Enum Constant.

  type: javax.swing.plaf.nimbus.AbstractRegionPainter.PaintContext.CacheMode"
  AbstractRegionPainter$PaintContext$CacheMode/NO_CACHING)

(def FIXED_SIZES
  "Enum Constant.

  type: javax.swing.plaf.nimbus.AbstractRegionPainter.PaintContext.CacheMode"
  AbstractRegionPainter$PaintContext$CacheMode/FIXED_SIZES)

(def NINE_SQUARE_SCALE
  "Enum Constant.

  type: javax.swing.plaf.nimbus.AbstractRegionPainter.PaintContext.CacheMode"
  AbstractRegionPainter$PaintContext$CacheMode/NINE_SQUARE_SCALE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AbstractRegionPainter.PaintContext.CacheMode c : AbstractRegionPainter.PaintContext.CacheMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.plaf.nimbus.AbstractRegionPainter.PaintContext.CacheMode[]`"
  ([]
    (AbstractRegionPainter$PaintContext$CacheMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.plaf.nimbus.AbstractRegionPainter.PaintContext.CacheMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (AbstractRegionPainter$PaintContext$CacheMode/valueOf name)))

