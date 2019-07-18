(ns jdk.awt.Event
  "NOTE: The Event class is obsolete and is
  available only for backwards compatibility.  It has been replaced
  by the AWTEvent class and its subclasses.

  Event is a platform-independent class that
  encapsulates events from the platform's Graphical User
  Interface in the Java 1.0 event model. In Java 1.1
  and later versions, the Event class is maintained
  only for backwards compatibility. The information in this
  class description is provided to assist programmers in
  converting Java 1.0 programs to the new event model.

  In the Java 1.0 event model, an event contains an
  id field
  that indicates what type of event it is and which other
  Event variables are relevant for the event.

  For keyboard events, key
  contains a value indicating which key was activated, and
  modifiers contains the
  modifiers for that event.  For the KEY_PRESS and KEY_RELEASE
  event ids, the value of key is the unicode
  character code for the key. For KEY_ACTION and
  KEY_ACTION_RELEASE, the value of key is
  one of the defined action-key identifiers in the
  Event class (PGUP,
  PGDN, F1, F2, etc)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Event]))

(defn ->event
  "Constructor.

  NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Creates an instance of Event with the specified target
   component, time stamp, event type, x and y
   coordinates, keyboard key, state of the modifier keys, and
   argument.

  target - the target component. - `java.lang.Object`
  when - the time stamp. - `long`
  id - the event type. - `int`
  x - the x coordinate. - `int`
  y - the y coordinate. - `int`
  key - the key pressed in a keyboard event. - `int`
  modifiers - the state of the modifier keys. - `int`
  arg - the specified argument. - `java.lang.Object`"
  (^Event [^java.lang.Object target ^Long when ^Integer id ^Integer x ^Integer y ^Integer key ^Integer modifiers ^java.lang.Object arg]
    (new Event target when id x y key modifiers arg))
  (^Event [^java.lang.Object target ^Long when ^Integer id ^Integer x ^Integer y ^Integer key ^Integer modifiers]
    (new Event target when id x y key modifiers))
  (^Event [^java.lang.Object target ^Integer id ^java.lang.Object arg]
    (new Event target id arg)))

(def *-shift-mask
  "Static Constant.

  This flag indicates that the Shift key was down when the event
   occurred.

  type: int"
  Event/SHIFT_MASK)

(def *-ctrl-mask
  "Static Constant.

  This flag indicates that the Control key was down when the event
   occurred.

  type: int"
  Event/CTRL_MASK)

(def *-meta-mask
  "Static Constant.

  This flag indicates that the Meta key was down when the event
   occurred. For mouse events, this flag indicates that the right
   button was pressed or released.

  type: int"
  Event/META_MASK)

(def *-alt-mask
  "Static Constant.

  This flag indicates that the Alt key was down when
   the event occurred. For mouse events, this flag indicates that the
   middle mouse button was pressed or released.

  type: int"
  Event/ALT_MASK)

(def *-home
  "Static Constant.

  The Home key, a non-ASCII action key.

  type: int"
  Event/HOME)

(def *-end
  "Static Constant.

  The End key, a non-ASCII action key.

  type: int"
  Event/END)

(def *-pgup
  "Static Constant.

  The Page Up key, a non-ASCII action key.

  type: int"
  Event/PGUP)

(def *-pgdn
  "Static Constant.

  The Page Down key, a non-ASCII action key.

  type: int"
  Event/PGDN)

(def *-up
  "Static Constant.

  The Up Arrow key, a non-ASCII action key.

  type: int"
  Event/UP)

(def *-down
  "Static Constant.

  The Down Arrow key, a non-ASCII action key.

  type: int"
  Event/DOWN)

(def *-left
  "Static Constant.

  The Left Arrow key, a non-ASCII action key.

  type: int"
  Event/LEFT)

(def *-right
  "Static Constant.

  The Right Arrow key, a non-ASCII action key.

  type: int"
  Event/RIGHT)

(def *-f-1
  "Static Constant.

  The F1 function key, a non-ASCII action key.

  type: int"
  Event/F1)

(def *-f-2
  "Static Constant.

  The F2 function key, a non-ASCII action key.

  type: int"
  Event/F2)

(def *-f-3
  "Static Constant.

  The F3 function key, a non-ASCII action key.

  type: int"
  Event/F3)

(def *-f-4
  "Static Constant.

  The F4 function key, a non-ASCII action key.

  type: int"
  Event/F4)

(def *-f-5
  "Static Constant.

  The F5 function key, a non-ASCII action key.

  type: int"
  Event/F5)

(def *-f-6
  "Static Constant.

  The F6 function key, a non-ASCII action key.

  type: int"
  Event/F6)

(def *-f-7
  "Static Constant.

  The F7 function key, a non-ASCII action key.

  type: int"
  Event/F7)

(def *-f-8
  "Static Constant.

  The F8 function key, a non-ASCII action key.

  type: int"
  Event/F8)

(def *-f-9
  "Static Constant.

  The F9 function key, a non-ASCII action key.

  type: int"
  Event/F9)

(def *-f-10
  "Static Constant.

  The F10 function key, a non-ASCII action key.

  type: int"
  Event/F10)

(def *-f-11
  "Static Constant.

  The F11 function key, a non-ASCII action key.

  type: int"
  Event/F11)

(def *-f-12
  "Static Constant.

  The F12 function key, a non-ASCII action key.

  type: int"
  Event/F12)

(def *-print-screen
  "Static Constant.

  The Print Screen key, a non-ASCII action key.

  type: int"
  Event/PRINT_SCREEN)

(def *-scroll-lock
  "Static Constant.

  The Scroll Lock key, a non-ASCII action key.

  type: int"
  Event/SCROLL_LOCK)

(def *-caps-lock
  "Static Constant.

  The Caps Lock key, a non-ASCII action key.

  type: int"
  Event/CAPS_LOCK)

(def *-num-lock
  "Static Constant.

  The Num Lock key, a non-ASCII action key.

  type: int"
  Event/NUM_LOCK)

(def *-pause
  "Static Constant.

  The Pause key, a non-ASCII action key.

  type: int"
  Event/PAUSE)

(def *-insert
  "Static Constant.

  The Insert key, a non-ASCII action key.

  type: int"
  Event/INSERT)

(def *-enter
  "Static Constant.

  The Enter key.

  type: int"
  Event/ENTER)

(def *-back-space
  "Static Constant.

  The BackSpace key.

  type: int"
  Event/BACK_SPACE)

(def *-tab
  "Static Constant.

  The Tab key.

  type: int"
  Event/TAB)

(def *-escape
  "Static Constant.

  The Escape key.

  type: int"
  Event/ESCAPE)

(def *-delete
  "Static Constant.

  The Delete key.

  type: int"
  Event/DELETE)

(def *-window-destroy
  "Static Constant.

  The user has asked the window manager to kill the window.

  type: int"
  Event/WINDOW_DESTROY)

(def *-window-expose
  "Static Constant.

  The user has asked the window manager to expose the window.

  type: int"
  Event/WINDOW_EXPOSE)

(def *-window-iconify
  "Static Constant.

  The user has asked the window manager to iconify the window.

  type: int"
  Event/WINDOW_ICONIFY)

(def *-window-deiconify
  "Static Constant.

  The user has asked the window manager to de-iconify the window.

  type: int"
  Event/WINDOW_DEICONIFY)

(def *-window-moved
  "Static Constant.

  The user has asked the window manager to move the window.

  type: int"
  Event/WINDOW_MOVED)

(def *-key-press
  "Static Constant.

  The user has pressed a normal key.

  type: int"
  Event/KEY_PRESS)

(def *-key-release
  "Static Constant.

  The user has released a normal key.

  type: int"
  Event/KEY_RELEASE)

(def *-key-action
  "Static Constant.

  The user has pressed a non-ASCII action key.
   The key field contains a value that indicates
   that the event occurred on one of the action keys, which
   comprise the 12 function keys, the arrow (cursor) keys,
   Page Up, Page Down, Home, End, Print Screen, Scroll Lock,
   Caps Lock, Num Lock, Pause, and Insert.

  type: int"
  Event/KEY_ACTION)

(def *-key-action-release
  "Static Constant.

  The user has released a non-ASCII action key.
   The key field contains a value that indicates
   that the event occurred on one of the action keys, which
   comprise the 12 function keys, the arrow (cursor) keys,
   Page Up, Page Down, Home, End, Print Screen, Scroll Lock,
   Caps Lock, Num Lock, Pause, and Insert.

  type: int"
  Event/KEY_ACTION_RELEASE)

(def *-mouse-down
  "Static Constant.

  The user has pressed the mouse button. The ALT_MASK
   flag indicates that the middle button has been pressed.
   The META_MASKflag indicates that the
   right button has been pressed.

  type: int"
  Event/MOUSE_DOWN)

(def *-mouse-up
  "Static Constant.

  The user has released the mouse button. The ALT_MASK
   flag indicates that the middle button has been released.
   The META_MASKflag indicates that the
   right button has been released.

  type: int"
  Event/MOUSE_UP)

(def *-mouse-move
  "Static Constant.

  The mouse has moved with no button pressed.

  type: int"
  Event/MOUSE_MOVE)

(def *-mouse-enter
  "Static Constant.

  The mouse has entered a component.

  type: int"
  Event/MOUSE_ENTER)

(def *-mouse-exit
  "Static Constant.

  The mouse has exited a component.

  type: int"
  Event/MOUSE_EXIT)

(def *-mouse-drag
  "Static Constant.

  The user has moved the mouse with a button pressed. The
   ALT_MASK flag indicates that the middle
   button is being pressed. The META_MASK flag indicates
   that the right button is being pressed.

  type: int"
  Event/MOUSE_DRAG)

(def *-scroll-line-up
  "Static Constant.

  The user has activated the line up
   area of a scroll bar.

  type: int"
  Event/SCROLL_LINE_UP)

(def *-scroll-line-down
  "Static Constant.

  The user has activated the line down
   area of a scroll bar.

  type: int"
  Event/SCROLL_LINE_DOWN)

(def *-scroll-page-up
  "Static Constant.

  The user has activated the page up
   area of a scroll bar.

  type: int"
  Event/SCROLL_PAGE_UP)

(def *-scroll-page-down
  "Static Constant.

  The user has activated the page down
   area of a scroll bar.

  type: int"
  Event/SCROLL_PAGE_DOWN)

(def *-scroll-absolute
  "Static Constant.

  The user has moved the bubble (thumb) in a scroll bar,
   moving to an `absolute` position, rather than to
   an offset from the last position.

  type: int"
  Event/SCROLL_ABSOLUTE)

(def *-scroll-begin
  "Static Constant.

  The scroll begin event.

  type: int"
  Event/SCROLL_BEGIN)

(def *-scroll-end
  "Static Constant.

  The scroll end event.

  type: int"
  Event/SCROLL_END)

(def *-list-select
  "Static Constant.

  An item in a list has been selected.

  type: int"
  Event/LIST_SELECT)

(def *-list-deselect
  "Static Constant.

  An item in a list has been deselected.

  type: int"
  Event/LIST_DESELECT)

(def *-action-event
  "Static Constant.

  This event indicates that the user wants some action to occur.

  type: int"
  Event/ACTION_EVENT)

(def *-load-file
  "Static Constant.

  A file loading event.

  type: int"
  Event/LOAD_FILE)

(def *-save-file
  "Static Constant.

  A file saving event.

  type: int"
  Event/SAVE_FILE)

(def *-got-focus
  "Static Constant.

  A component gained the focus.

  type: int"
  Event/GOT_FOCUS)

(def *-lost-focus
  "Static Constant.

  A component lost the focus.

  type: int"
  Event/LOST_FOCUS)

(defn -target
  "Instance Field.

  The target component. This indicates the component over which the
   event occurred or with which the event is associated.
   This object has been replaced by AWTEvent.getSource()

  type: java.lang.Object"
  [this]
  (-> this .-target))

(defn -when
  "Instance Field.

  The time stamp.
   Replaced by InputEvent.getWhen().

  type: long"
  [this]
  (-> this .-when))

(defn -id
  "Instance Field.

  Indicates which type of event the event is, and which
   other Event variables are relevant for the event.
   This has been replaced by AWTEvent.getID()

  type: int"
  [this]
  (-> this .-id))

(defn -x
  "Instance Field.

  The x coordinate of the event.
   Replaced by MouseEvent.getX()

  type: int"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The y coordinate of the event.
   Replaced by MouseEvent.getY()

  type: int"
  [this]
  (-> this .-y))

(defn -key
  "Instance Field.

  The key code of the key that was pressed in a keyboard event.
   This has been replaced by KeyEvent.getKeyCode()

  type: int"
  [this]
  (-> this .-key))

(defn -modifiers
  "Instance Field.

  The state of the modifier keys.
   This is replaced with InputEvent.getModifiers()
   In java 1.1 MouseEvent and KeyEvent are subclasses
   of InputEvent.

  type: int"
  [this]
  (-> this .-modifiers))

(defn -click-count
  "Instance Field.

  For MOUSE_DOWN events, this field indicates the
   number of consecutive clicks. For other events, its value is
   0.
   This field has been replaced by MouseEvent.getClickCount().

  type: int"
  [this]
  (-> this .-clickCount))

(defn -arg
  "Instance Field.

  An arbitrary argument of the event. The value of this field
   depends on the type of event.
   arg has been replaced by event specific property.

  type: java.lang.Object"
  [this]
  (-> this .-arg))

(defn -evt
  "Instance Field.

  The next event. This field is set when putting events into a
   linked list.
   This has been replaced by EventQueue.

  type: java.awt.Event"
  [this]
  (-> this .-evt))

(defn translate
  "NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Translates this event so that its x and y
   coordinates are increased by dx and dy,
   respectively.

   This method translates an event relative to the given component.
   This involves, at a minimum, translating the coordinates into the
   local coordinate system of the given component. It may also involve
   translating a region in the case of an expose event.

  dx - the distance to translate the x coordinate. - `int`
  dy - the distance to translate the y coordinate. - `int`"
  ([^Event this ^Integer dx ^Integer dy]
    (-> this (.translate dx dy))))

(defn shift-down
  "NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Checks if the Shift key is down.

  returns: true if the key is down;
              false otherwise. - `boolean`"
  (^Boolean [^Event this]
    (-> this (.shiftDown))))

(defn control-down
  "NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Checks if the Control key is down.

  returns: true if the key is down;
              false otherwise. - `boolean`"
  (^Boolean [^Event this]
    (-> this (.controlDown))))

(defn meta-down
  "NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Checks if the Meta key is down.

  returns: true if the key is down;
              false otherwise. - `boolean`"
  (^Boolean [^Event this]
    (-> this (.metaDown))))

(defn to-string
  "NOTE: The Event class is obsolete and is
   available only for backwards compatibility.  It has been replaced
   by the AWTEvent class and its subclasses.

   Returns a representation of this event's values as a string.

  returns: a string that represents the event and the values
                   of its member fields. - `java.lang.String`"
  (^java.lang.String [^Event this]
    (-> this (.toString))))

