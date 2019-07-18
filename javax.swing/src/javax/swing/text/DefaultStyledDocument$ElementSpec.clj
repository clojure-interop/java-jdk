(ns javax.swing.text.DefaultStyledDocument$ElementSpec
  "Specification for building elements.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultStyledDocument$ElementSpec]))

(defn ->element-spec
  "Constructor.

  Constructor for creating a spec externally for batch
   input of content and markup into the document.

  a - the attributes for the element - `javax.swing.text.AttributeSet`
  type - the type of the element (StartTagType, EndTagType, ContentType) - `short`
  txt - the text for the element - `char[]`
  offs - the offset into the text >= 0 - `int`
  len - the length of the text >= 0 - `int`"
  (^DefaultStyledDocument$ElementSpec [^javax.swing.text.AttributeSet a ^Short type txt ^Integer offs ^Integer len]
    (new DefaultStyledDocument$ElementSpec a type txt offs len))
  (^DefaultStyledDocument$ElementSpec [^javax.swing.text.AttributeSet a ^Short type ^Integer len]
    (new DefaultStyledDocument$ElementSpec a type len))
  (^DefaultStyledDocument$ElementSpec [^javax.swing.text.AttributeSet a ^Short type]
    (new DefaultStyledDocument$ElementSpec a type)))

(def *-start-tag-type
  "Static Constant.

  A possible value for getType.  This specifies
   that this record type is a start tag and
   represents markup that specifies the start
   of an element.

  type: short"
  DefaultStyledDocument$ElementSpec/StartTagType)

(def *-end-tag-type
  "Static Constant.

  A possible value for getType.  This specifies
   that this record type is a end tag and
   represents markup that specifies the end
   of an element.

  type: short"
  DefaultStyledDocument$ElementSpec/EndTagType)

(def *-content-type
  "Static Constant.

  A possible value for getType.  This specifies
   that this record type represents content.

  type: short"
  DefaultStyledDocument$ElementSpec/ContentType)

(def *-join-previous-direction
  "Static Constant.

  A possible value for getDirection.  This specifies
   that the data associated with this record should
   be joined to what precedes it.

  type: short"
  DefaultStyledDocument$ElementSpec/JoinPreviousDirection)

(def *-join-next-direction
  "Static Constant.

  A possible value for getDirection.  This specifies
   that the data associated with this record should
   be joined to what follows it.

  type: short"
  DefaultStyledDocument$ElementSpec/JoinNextDirection)

(def *-originate-direction
  "Static Constant.

  A possible value for getDirection.  This specifies
   that the data associated with this record should
   be used to originate a new element.  This would be
   the normal value.

  type: short"
  DefaultStyledDocument$ElementSpec/OriginateDirection)

(def *-join-fracture-direction
  "Static Constant.

  A possible value for getDirection.  This specifies
   that the data associated with this record should
   be joined to the fractured element.

  type: short"
  DefaultStyledDocument$ElementSpec/JoinFractureDirection)

(defn set-direction
  "Sets the direction.

  direction - the direction (JoinPreviousDirection, JoinNextDirection) - `short`"
  ([^DefaultStyledDocument$ElementSpec this ^Short direction]
    (-> this (.setDirection direction))))

(defn get-type
  "Gets the element type.

  returns: the type of the element (StartTagType, EndTagType,
    ContentType) - `short`"
  (^Short [^DefaultStyledDocument$ElementSpec this]
    (-> this (.getType))))

(defn set-type
  "Sets the element type.

  type - the type of the element (StartTagType, EndTagType, ContentType) - `short`"
  ([^DefaultStyledDocument$ElementSpec this ^Short type]
    (-> this (.setType type))))

(defn to-string
  "Converts the element to a string.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^DefaultStyledDocument$ElementSpec this]
    (-> this (.toString))))

(defn get-direction
  "Gets the direction.

  returns: the direction (JoinPreviousDirection, JoinNextDirection) - `short`"
  (^Short [^DefaultStyledDocument$ElementSpec this]
    (-> this (.getDirection))))

(defn get-offset
  "Gets the starting offset.

  returns: the offset >= 0 - `int`"
  (^Integer [^DefaultStyledDocument$ElementSpec this]
    (-> this (.getOffset))))

(defn get-array
  "Gets the array of characters.

  returns: the array - `char[]`"
  ([^DefaultStyledDocument$ElementSpec this]
    (-> this (.getArray))))

(defn get-length
  "Gets the length.

  returns: the length >= 0 - `int`"
  (^Integer [^DefaultStyledDocument$ElementSpec this]
    (-> this (.getLength))))

(defn get-attributes
  "Gets the element attributes.

  returns: the attribute set - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^DefaultStyledDocument$ElementSpec this]
    (-> this (.getAttributes))))

