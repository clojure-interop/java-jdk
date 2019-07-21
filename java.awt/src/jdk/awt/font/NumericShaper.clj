(ns jdk.awt.font.NumericShaper
  "The NumericShaper class is used to convert Latin-1 (European)
  digits to other Unicode decimal digits.  Users of this class will
  primarily be people who wish to present data using
  national digit shapes, but find it more convenient to represent the
  data internally using Latin-1 (European) digits.  This does not
  interpret the deprecated numeric shape selector character (U+206E).

  Instances of NumericShaper are typically applied
  as attributes to text with the
  NUMERIC_SHAPING attribute
  of the TextAttribute class.
  For example, this code snippet causes a TextLayout to
  shape European digits to Arabic in an Arabic context:


  Map map = new HashMap();
  map.put(TextAttribute.NUMERIC_SHAPING,
      NumericShaper.getContextualShaper(NumericShaper.ARABIC));
  FontRenderContext frc = ...;
  TextLayout layout = new TextLayout(text, map, frc);
  layout.draw(g2d, x, y);

  It is also possible to perform numeric shaping explicitly using instances
  of NumericShaper, as this code snippet demonstrates:


  char[] text = ...;
  // shape all EUROPEAN digits (except zero) to ARABIC digits
  NumericShaper shaper = NumericShaper.getShaper(NumericShaper.ARABIC);
  shaper.shape(text, start, count);

  // shape European digits to ARABIC digits if preceding text is Arabic, or
  // shape European digits to TAMIL digits if preceding text is Tamil, or
  // leave European digits alone if there is no preceding text, or
  // preceding text is neither Arabic nor Tamil
  NumericShaper shaper =
      NumericShaper.getContextualShaper(NumericShaper.ARABIC |
                                          NumericShaper.TAMIL,
                                        NumericShaper.EUROPEAN);
  shaper.shape(text, start, count);

  Bit mask- and enum-based Unicode ranges

  This class supports two different programming interfaces to
  represent Unicode ranges for script-specific digits: bit
  mask-based ones, such as NumericShaper.ARABIC, and
  enum-based ones, such as NumericShaper.Range.ARABIC.
  Multiple ranges can be specified by ORing bit mask-based constants,
  such as:


  NumericShaper.ARABIC | NumericShaper.TAMIL
  or creating a Set with the NumericShaper.Range
  constants, such as:


  EnumSet.of(NumericShaper.Scirpt.ARABIC, NumericShaper.Range.TAMIL)
  The enum-based ranges are a super set of the bit mask-based ones.

  If the two interfaces are mixed (including serialization),
  Unicode range values are mapped to their counterparts where such
  mapping is possible, such as NumericShaper.Range.ARABIC
  from/to NumericShaper.ARABIC.  If any unmappable range
  values are specified, such as NumericShaper.Range.BALINESE,
  those ranges are ignored.

  Decimal Digits Precedence

  A Unicode range may have more than one set of decimal digits. If
  multiple decimal digits sets are specified for the same Unicode
  range, one of the sets will take precedence as follows.



        Unicode Range
        NumericShaper Constants
        Precedence


        Arabic
        NumericShaper.ARABIC
            NumericShaper.EASTERN_ARABIC
        NumericShaper.EASTERN_ARABIC


        NumericShaper.Range.ARABIC
            NumericShaper.Range.EASTERN_ARABIC
        NumericShaper.Range.EASTERN_ARABIC


        Tai Tham
        NumericShaper.Range.TAI_THAM_HORA
            NumericShaper.Range.TAI_THAM_THAM
        NumericShaper.Range.TAI_THAM_THAM"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font NumericShaper]))

(def *-european
  "Static Constant.

  Identifies the Latin-1 (European) and extended range, and
    Latin-1 (European) decimal base.

  type: int"
  NumericShaper/EUROPEAN)

(def *-arabic
  "Static Constant.

  Identifies the ARABIC range and decimal base.

  type: int"
  NumericShaper/ARABIC)

(def *-eastern-arabic
  "Static Constant.

  Identifies the ARABIC range and ARABIC_EXTENDED decimal base.

  type: int"
  NumericShaper/EASTERN_ARABIC)

(def *-devanagari
  "Static Constant.

  Identifies the DEVANAGARI range and decimal base.

  type: int"
  NumericShaper/DEVANAGARI)

(def *-bengali
  "Static Constant.

  Identifies the BENGALI range and decimal base.

  type: int"
  NumericShaper/BENGALI)

(def *-gurmukhi
  "Static Constant.

  Identifies the GURMUKHI range and decimal base.

  type: int"
  NumericShaper/GURMUKHI)

(def *-gujarati
  "Static Constant.

  Identifies the GUJARATI range and decimal base.

  type: int"
  NumericShaper/GUJARATI)

(def *-oriya
  "Static Constant.

  Identifies the ORIYA range and decimal base.

  type: int"
  NumericShaper/ORIYA)

(def *-tamil
  "Static Constant.

  Identifies the TAMIL range and decimal base.

  type: int"
  NumericShaper/TAMIL)

(def *-telugu
  "Static Constant.

  Identifies the TELUGU range and decimal base.

  type: int"
  NumericShaper/TELUGU)

(def *-kannada
  "Static Constant.

  Identifies the KANNADA range and decimal base.

  type: int"
  NumericShaper/KANNADA)

(def *-malayalam
  "Static Constant.

  Identifies the MALAYALAM range and decimal base.

  type: int"
  NumericShaper/MALAYALAM)

(def *-thai
  "Static Constant.

  Identifies the THAI range and decimal base.

  type: int"
  NumericShaper/THAI)

(def *-lao
  "Static Constant.

  Identifies the LAO range and decimal base.

  type: int"
  NumericShaper/LAO)

(def *-tibetan
  "Static Constant.

  Identifies the TIBETAN range and decimal base.

  type: int"
  NumericShaper/TIBETAN)

(def *-myanmar
  "Static Constant.

  Identifies the MYANMAR range and decimal base.

  type: int"
  NumericShaper/MYANMAR)

(def *-ethiopic
  "Static Constant.

  Identifies the ETHIOPIC range and decimal base.

  type: int"
  NumericShaper/ETHIOPIC)

(def *-khmer
  "Static Constant.

  Identifies the KHMER range and decimal base.

  type: int"
  NumericShaper/KHMER)

(def *-mongolian
  "Static Constant.

  Identifies the MONGOLIAN range and decimal base.

  type: int"
  NumericShaper/MONGOLIAN)

(def *-all-ranges
  "Static Constant.

  Identifies all ranges, for full contextual shaping.

   This constant specifies all of the bit mask-based
   ranges. Use EmunSet.allOf(NumericShaper.Range.class) to
   specify all of the enum-based ranges.

  type: int"
  NumericShaper/ALL_RANGES)

(defn *get-shaper
  "Returns a shaper for the provided unicode range.  All
   Latin-1 (EUROPEAN) digits are converted
   to the corresponding decimal unicode digits.

  single-range - the specified Unicode range - `int`

  returns: a non-contextual numeric shaper - `java.awt.font.NumericShaper`

  throws: java.lang.IllegalArgumentException - if the range is not a single range"
  (^java.awt.font.NumericShaper [^Integer single-range]
    (NumericShaper/getShaper single-range)))

(defn *get-contextual-shaper
  "Returns a contextual shaper for the provided unicode range(s).
   Latin-1 (EUROPEAN) digits will be converted to the decimal digits
   corresponding to the range of the preceding text, if the
   range is one of the provided ranges.  Multiple ranges are
   represented by or-ing the values together, for example,
   NumericShaper.ARABIC | NumericShaper.THAI.  The
   shaper uses defaultContext as the starting context.

  ranges - the specified Unicode ranges - `int`
  default-context - the starting context, such as NumericShaper.EUROPEAN - `int`

  returns: a shaper for the specified Unicode ranges. - `java.awt.font.NumericShaper`

  throws: java.lang.IllegalArgumentException - if the specified defaultContext is not a single valid range."
  (^java.awt.font.NumericShaper [^Integer ranges ^Integer default-context]
    (NumericShaper/getContextualShaper ranges default-context))
  (^java.awt.font.NumericShaper [^Integer ranges]
    (NumericShaper/getContextualShaper ranges)))

(defn shape
  "Converts the digits in the text that occur between start and
   start  count, using the provided context.
   Context is ignored if the shaper is not a contextual shaper.

  text - an array of characters - `char[]`
  start - the index into text to start converting - `int`
  count - the number of characters in text to convert - `int`
  context - the context to which to convert the characters, such as NumericShaper.EUROPEAN - `int`

  throws: java.lang.IndexOutOfBoundsException - if start or start count is out of bounds"
  ([^NumericShaper this text ^Integer start ^Integer count ^Integer context]
    (-> this (.shape text start count context)))
  ([^NumericShaper this text ^Integer start ^Integer count]
    (-> this (.shape text start count))))

(defn contextual?
  "Returns a boolean indicating whether or not
   this shaper shapes contextually.

  returns: true if this shaper is contextual;
           false otherwise. - `boolean`"
  (^Boolean [^NumericShaper this]
    (-> this (.isContextual))))

(defn get-ranges
  "Returns an int that ORs together the values for
   all the ranges that will be shaped.

   For example, to check if a shaper shapes to Arabic, you would use the
   following:

     if ((shaper.getRanges() & shaper.ARABIC) != 0) &#123; ...


   Note that this method supports only the bit mask-based
   ranges. Call getRangeSet() for the enum-based ranges.

  returns: the values for all the ranges to be shaped. - `int`"
  (^Integer [^NumericShaper this]
    (-> this (.getRanges))))

(defn get-range-set
  "Returns a Set representing all the Unicode ranges in
   this NumericShaper that will be shaped.

  returns: all the Unicode ranges to be shaped. - `java.util.Set<java.awt.font.NumericShaper$Range>`"
  (^java.util.Set [^NumericShaper this]
    (-> this (.getRangeSet))))

(defn hash-code
  "Returns a hash code for this shaper.

  returns: this shaper's hash code. - `int`"
  (^Integer [^NumericShaper this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if the specified object is an instance of
   NumericShaper and shapes identically to this one,
   regardless of the range representations, the bit mask or the
   enum. For example, the following code produces \"true\".


   NumericShaper ns1 = NumericShaper.getShaper(NumericShaper.ARABIC);
   NumericShaper ns2 = NumericShaper.getShaper(NumericShaper.Range.ARABIC);
   System.out.println(ns1.equals(ns2));

  o - the specified object to compare to this NumericShaper - `java.lang.Object`

  returns: true if o is an instance
           of NumericShaper and shapes in the same way;
           false otherwise. - `boolean`"
  (^Boolean [^NumericShaper this ^java.lang.Object o]
    (-> this (.equals o))))

(defn to-string
  "Returns a String that describes this shaper. This method
   is used for debugging purposes only.

  returns: a String describing this shaper. - `java.lang.String`"
  (^java.lang.String [^NumericShaper this]
    (-> this (.toString))))

