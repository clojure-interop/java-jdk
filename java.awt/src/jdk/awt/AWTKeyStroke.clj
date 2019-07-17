(ns jdk.awt.AWTKeyStroke
  "An AWTKeyStroke represents a key action on the
  keyboard, or equivalent input device. AWTKeyStrokes
  can correspond to only a press or release of a
  particular key, just as KEY_PRESSED and
  KEY_RELEASED KeyEvents do;
  alternately, they can correspond to typing a specific Java character, just
  as KEY_TYPED KeyEvents do.
  In all cases, AWTKeyStrokes can specify modifiers
  (alt, shift, control, meta, altGraph, or a combination thereof) which must be present
  during the action for an exact match.

  AWTKeyStrokes are immutable, and are intended
  to be unique. Client code should never create an
  AWTKeyStroke on its own, but should instead use
  a variant of getAWTKeyStroke. Client use of these factory
  methods allows the AWTKeyStroke implementation
  to cache and share instances efficiently."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AWTKeyStroke]))

(defn *get-awt-key-stroke
  "Returns a shared instance of an AWTKeyStroke,
   given a numeric key code and a set of modifiers, specifying
   whether the key is activated when it is pressed or released.

   The `virtual key` constants defined in
   java.awt.event.KeyEvent can be
   used to specify the key code. For example:
   java.awt.event.KeyEvent.VK_ENTER
   java.awt.event.KeyEvent.VK_TAB
   java.awt.event.KeyEvent.VK_SPACE

   Alternatively, the key code may be obtained by calling
   java.awt.event.KeyEvent.getExtendedKeyCodeForChar.

   The modifiers consist of any combination of:
   java.awt.event.InputEvent.SHIFT_DOWN_MASK
   java.awt.event.InputEvent.CTRL_DOWN_MASK
   java.awt.event.InputEvent.META_DOWN_MASK
   java.awt.event.InputEvent.ALT_DOWN_MASK
   java.awt.event.InputEvent.ALT_GRAPH_DOWN_MASK

   The old modifiers
   java.awt.event.InputEvent.SHIFT_MASK
   java.awt.event.InputEvent.CTRL_MASK
   java.awt.event.InputEvent.META_MASK
   java.awt.event.InputEvent.ALT_MASK
   java.awt.event.InputEvent.ALT_GRAPH_MASK

   also can be used, but they are mapped to _DOWN_ modifiers.

   Since these numbers are all different powers of two, any combination of
   them is an integer in which each bit represents a different modifier
   key. Use 0 to specify no modifiers.

  key-code - an int specifying the numeric code for a keyboard key - `int`
  modifiers - a bitwise-ored combination of any modifiers - `int`
  on-key-release - true if the AWTKeyStroke should represent a key release; false otherwise - `boolean`

  returns: an AWTKeyStroke object for that key - `java.awt.AWTKeyStroke`"
  (^java.awt.AWTKeyStroke [^Integer key-code ^Integer modifiers ^Boolean on-key-release]
    (AWTKeyStroke/getAWTKeyStroke key-code modifiers on-key-release))
  (^java.awt.AWTKeyStroke [^java.lang.Character key-char ^Integer modifiers]
    (AWTKeyStroke/getAWTKeyStroke key-char modifiers))
  (^java.awt.AWTKeyStroke [^Character key-char]
    (AWTKeyStroke/getAWTKeyStroke key-char)))

(defn *get-awt-key-stroke-for-event
  "Returns an AWTKeyStroke which represents the
   stroke which generated a given KeyEvent.

   This method obtains the keyChar from a KeyTyped
   event, and the keyCode from a KeyPressed or
   KeyReleased event. The KeyEvent modifiers are
   obtained for all three types of KeyEvent.

  an-event - the KeyEvent from which to obtain the AWTKeyStroke - `java.awt.event.KeyEvent`

  returns: the AWTKeyStroke that precipitated the event - `java.awt.AWTKeyStroke`

  throws: java.lang.NullPointerException - if anEvent is null"
  (^java.awt.AWTKeyStroke [^java.awt.event.KeyEvent an-event]
    (AWTKeyStroke/getAWTKeyStrokeForEvent an-event)))

(defn get-key-char
  "Returns the character for this AWTKeyStroke.

  returns: a char value - `char`"
  (^Character [^java.awt.AWTKeyStroke this]
    (-> this (.getKeyChar))))

(defn get-key-code
  "Returns the numeric key code for this AWTKeyStroke.

  returns: an int containing the key code value - `int`"
  (^Integer [^java.awt.AWTKeyStroke this]
    (-> this (.getKeyCode))))

(defn get-modifiers
  "Returns the modifier keys for this AWTKeyStroke.

  returns: an int containing the modifiers - `int`"
  (^Integer [^java.awt.AWTKeyStroke this]
    (-> this (.getModifiers))))

(defn on-key-release?
  "Returns whether this AWTKeyStroke represents a key release.

  returns: true if this AWTKeyStroke
            represents a key release; false otherwise - `boolean`"
  (^Boolean [^java.awt.AWTKeyStroke this]
    (-> this (.isOnKeyRelease))))

(defn get-key-event-type
  "Returns the type of KeyEvent which corresponds to
   this AWTKeyStroke.

  returns: KeyEvent.KEY_PRESSED,
           KeyEvent.KEY_TYPED,
           or KeyEvent.KEY_RELEASED - `int`"
  (^Integer [^java.awt.AWTKeyStroke this]
    (-> this (.getKeyEventType))))

(defn hash-code
  "Returns a numeric value for this object that is likely to be unique,
   making it a good choice as the index value in a hash table.

  returns: an int that represents this object - `int`"
  (^Integer [^java.awt.AWTKeyStroke this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if this object is identical to the specified object.

  an-object - the Object to compare this object to - `java.lang.Object`

  returns: true if the objects are identical - `boolean`"
  (^Boolean [^java.awt.AWTKeyStroke this ^java.lang.Object an-object]
    (-> this (.equals an-object))))

(defn to-string
  "Returns a string that displays and identifies this object's properties.
   The String returned by this method can be passed
   as a parameter to getAWTKeyStroke(String) to produce
   a key stroke equal to this key stroke.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^java.awt.AWTKeyStroke this]
    (-> this (.toString))))

