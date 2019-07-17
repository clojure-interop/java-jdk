(ns javax.swing.KeyStroke
  "A KeyStroke represents a key action on the keyboard, or equivalent input
  device. KeyStrokes can correspond to only a press or release of a particular
  key, just as KEY_PRESSED and KEY_RELEASED KeyEvents do; alternately, they
  can correspond to typing a specific Java character, just as KEY_TYPED
  KeyEvents do. In all cases, KeyStrokes can specify modifiers (alt, shift,
  control, meta, altGraph, or a combination thereof) which must be present during the
  action for an exact match.

  KeyStrokes are used to define high-level (semantic) action events. Instead
  of trapping every keystroke and throwing away the ones you are not
  interested in, those keystrokes you care about automatically initiate
  actions on the Components with which they are registered.

  KeyStrokes are immutable, and are intended to be unique. Client code cannot
  create a KeyStroke; a variant of getKeyStroke must be used
  instead. These factory methods allow the KeyStroke implementation to cache
  and share instances efficiently.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing KeyStroke]))

(defn *get-key-stroke
  "Returns a shared instance of a KeyStroke, given a numeric key code and a
   set of modifiers, specifying whether the key is activated when it is
   pressed or released.

   The `virtual key` constants defined in java.awt.event.KeyEvent can be
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
  on-key-release - true if the KeyStroke should represent a key release; false otherwise. - `boolean`

  returns: a KeyStroke object for that key - `javax.swing.KeyStroke`"
  (^javax.swing.KeyStroke [^Integer key-code ^Integer modifiers ^Boolean on-key-release]
    (KeyStroke/getKeyStroke key-code modifiers on-key-release))
  (^javax.swing.KeyStroke [^java.lang.Character key-char ^Integer modifiers]
    (KeyStroke/getKeyStroke key-char modifiers))
  (^javax.swing.KeyStroke [^Character key-char]
    (KeyStroke/getKeyStroke key-char)))

(defn *get-key-stroke-for-event
  "Returns a KeyStroke which represents the stroke which generated a given
   KeyEvent.

   This method obtains the keyChar from a KeyTyped event, and the keyCode
   from a KeyPressed or KeyReleased event. The KeyEvent modifiers are
   obtained for all three types of KeyEvent.

  an-event - the KeyEvent from which to obtain the KeyStroke - `java.awt.event.KeyEvent`

  returns: the KeyStroke that precipitated the event - `javax.swing.KeyStroke`

  throws: java.lang.NullPointerException - if anEvent is null"
  (^javax.swing.KeyStroke [^java.awt.event.KeyEvent an-event]
    (KeyStroke/getKeyStrokeForEvent an-event)))

