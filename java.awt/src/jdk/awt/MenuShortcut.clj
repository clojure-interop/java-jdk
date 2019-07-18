(ns jdk.awt.MenuShortcut
  "The MenuShortcutclass represents a keyboard accelerator
  for a MenuItem.

  Menu shortcuts are created using virtual keycodes, not characters.
  For example, a menu shortcut for Ctrl-a (assuming that Control is
  the accelerator key) would be created with code like the following:

  MenuShortcut ms = new MenuShortcut(KeyEvent.VK_A, false);
   or alternatively

  MenuShortcut ms = new MenuShortcut(KeyEvent.getExtendedKeyCodeForChar('A'), false);

  Menu shortcuts may also be constructed for a wider set of keycodes
  using the java.awt.event.KeyEvent.getExtendedKeyCodeForChar call.
  For example, a menu shortcut for `Ctrl+cyrillic ef` is created by

  MenuShortcut ms = new MenuShortcut(KeyEvent.getExtendedKeyCodeForChar('?'), false);

  Note that shortcuts created with a keycode or an extended keycode defined as a constant in KeyEvent
  work regardless of the current keyboard layout. However, a shortcut made of
  an extended keycode not listed in KeyEvent
  only work if the current keyboard layout produces a corresponding letter.

  The accelerator key is platform-dependent and may be obtained
  via Toolkit.getMenuShortcutKeyMask()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuShortcut]))

(defn ->menu-shortcut
  "Constructor.

  Constructs a new MenuShortcut for the specified virtual keycode.

  key - the raw keycode for this MenuShortcut, as would be returned in the keyCode field of a KeyEvent if this key were pressed. - `int`
  use-shift-modifier - indicates whether this MenuShortcut is invoked with the SHIFT key down. - `boolean`"
  (^MenuShortcut [^Integer key ^Boolean use-shift-modifier]
    (new MenuShortcut key use-shift-modifier))
  (^MenuShortcut [^Integer key]
    (new MenuShortcut key)))

(defn get-key
  "Returns the raw keycode of this MenuShortcut.

  returns: the raw keycode of this MenuShortcut. - `int`"
  (^Integer [^MenuShortcut this]
    (-> this (.getKey))))

(defn uses-shift-modifier
  "Returns whether this MenuShortcut must be invoked using the SHIFT key.

  returns: true if this MenuShortcut must be invoked using the
   SHIFT key, false otherwise. - `boolean`"
  (^Boolean [^MenuShortcut this]
    (-> this (.usesShiftModifier))))

(defn equals
  "Returns whether this MenuShortcut is the same as another:
   equality is defined to mean that both MenuShortcuts use the same key
   and both either use or don't use the SHIFT key.

  s - the MenuShortcut to compare with this. - `java.awt.MenuShortcut`

  returns: true if this MenuShortcut is the same as another,
   false otherwise. - `boolean`"
  (^Boolean [^MenuShortcut this ^java.awt.MenuShortcut s]
    (-> this (.equals s))))

(defn hash-code
  "Returns the hashcode for this MenuShortcut.

  returns: the hashcode for this MenuShortcut. - `int`"
  (^Integer [^MenuShortcut this]
    (-> this (.hashCode))))

(defn to-string
  "Returns an internationalized description of the MenuShortcut.

  returns: a string representation of this MenuShortcut. - `java.lang.String`"
  (^java.lang.String [^MenuShortcut this]
    (-> this (.toString))))

