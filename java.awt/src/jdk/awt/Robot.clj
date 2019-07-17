(ns jdk.awt.Robot
  "This class is used to generate native system input events
  for the purposes of test automation, self-running demos, and
  other applications where control of the mouse and keyboard
  is needed. The primary purpose of Robot is to facilitate
  automated testing of Java platform implementations.

  Using the class to generate input events differs from posting
  events to the AWT event queue or AWT components in that the
  events are generated in the platform's native input
  queue. For example, Robot.mouseMove will actually move
  the mouse cursor instead of just generating mouse move events.

  Note that some platforms require special privileges or extensions
  to access low-level input control. If the current platform configuration
  does not allow input control, an AWTException will be thrown
  when trying to construct Robot objects. For example, X-Window systems
  will throw the exception if the XTEST 2.2 standard extension is not supported
  (or not enabled) by the X server.

  Applications that use Robot for purposes other than self-testing should
  handle these error conditions gracefully."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Robot]))

(defn ->robot
  "Constructor.

  Creates a Robot for the given screen device. Coordinates passed
   to Robot method calls like mouseMove and createScreenCapture will
   be interpreted as being in the same coordinate system as the
   specified screen. Note that depending on the platform configuration,
   multiple screens may either:

   share the same coordinate system to form a combined virtual screen
   use different coordinate systems to act as independent screens

   This constructor is meant for the latter case.

   If screen devices are reconfigured such that the coordinate system is
   affected, the behavior of existing Robot objects is undefined.

  screen - A screen GraphicsDevice indicating the coordinate system the Robot will operate in. - `java.awt.GraphicsDevice`

  throws: java.awt.AWTException - if the platform configuration does not allow low-level input control. This exception is always thrown when GraphicsEnvironment.isHeadless() returns true."
  ([screen]
    (new Robot screen))
  ([]
    (new Robot )))

(defn get-pixel-color
  "Returns the color of a pixel at the given screen coordinates.

  x - X position of pixel - `int`
  y - Y position of pixel - `int`

  returns: Color of the pixel - `java.awt.Color`"
  ([this x y]
    (-> this (.getPixelColor x y))))

(defn mouse-release
  "Releases one or more mouse buttons.

  buttons - the Button mask; a combination of one or more mouse button masks. It is allowed to use only a combination of valid values as a buttons parameter. A valid combination consists of InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK and values returned by the InputEvent.getMaskForButton(button) method. The valid combination also depends on a Toolkit.areExtraMouseButtonsEnabled() value as follows: If the support for extended mouse buttons is disabled by Java then it is allowed to use only the following standard button masks: InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK. If the support for extended mouse buttons is enabled by Java then it is allowed to use the standard button masks and masks for existing extended mouse buttons, if the mouse has more then three buttons. In that way, it is allowed to use the button masks corresponding to the buttons in the range from 1 to MouseInfo.getNumberOfButtons(). It is recommended to use the InputEvent.getMaskForButton(button) method to obtain the mask for any mouse button by its number. The following standard button masks are also accepted: InputEvent.BUTTON1_MASK InputEvent.BUTTON2_MASK InputEvent.BUTTON3_MASK However, it is recommended to use InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK instead. Either extended _DOWN_MASK or old _MASK values should be used, but both those models should not be mixed. - `int`

  throws: java.lang.IllegalArgumentException - if the buttons mask contains the mask for extra mouse button that does not exist on the mouse and support for extended mouse buttons is enabled by Java"
  ([this buttons]
    (-> this (.mouseRelease buttons))))

(defn get-auto-delay
  "Returns the number of milliseconds this Robot sleeps after generating an event.

  returns: `int`"
  ([this]
    (-> this (.getAutoDelay))))

(defn create-screen-capture
  "Creates an image containing pixels read from the screen.  This image does
   not include the mouse cursor.

  screen-rect - Rect to capture in screen coordinates - `java.awt.Rectangle`

  returns: The captured image - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if screenRect width and height are not greater than zero"
  ([this screen-rect]
    (-> this (.createScreenCapture screen-rect))))

(defn set-auto-wait-for-idle
  "Sets whether this Robot automatically invokes waitForIdle
   after generating an event.

  is-on - Whether waitForIdle is automatically invoked - `boolean`"
  ([this is-on]
    (-> this (.setAutoWaitForIdle is-on))))

(defn to-string
  "Returns a string representation of this Robot.

  returns: the string representation. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn key-press
  "Presses a given key.  The key should be released using the
   keyRelease method.

   Key codes that have more than one physical key associated with them
   (e.g. KeyEvent.VK_SHIFT could mean either the
   left or right shift key) will map to the left key.

  keycode - Key to press (e.g. KeyEvent.VK_A) - `int`

  throws: java.lang.IllegalArgumentException - if keycode is not a valid key"
  ([this keycode]
    (-> this (.keyPress keycode))))

(defn set-auto-delay
  "Sets the number of milliseconds this Robot sleeps after generating an event.

  ms - `int`

  throws: java.lang.IllegalArgumentException - If ms is not between 0 and 60,000 milliseconds inclusive"
  ([this ms]
    (-> this (.setAutoDelay ms))))

(defn mouse-move
  "Moves mouse pointer to given screen coordinates.

  x - X position - `int`
  y - Y position - `int`"
  ([this x y]
    (-> this (.mouseMove x y))))

(defn mouse-press
  "Presses one or more mouse buttons.  The mouse buttons should
   be released using the mouseRelease(int) method.

  buttons - the Button mask; a combination of one or more mouse button masks. It is allowed to use only a combination of valid values as a buttons parameter. A valid combination consists of InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK and values returned by the InputEvent.getMaskForButton(button) method. The valid combination also depends on a Toolkit.areExtraMouseButtonsEnabled() value as follows: If support for extended mouse buttons is disabled by Java then it is allowed to use only the following standard button masks: InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK. If support for extended mouse buttons is enabled by Java then it is allowed to use the standard button masks and masks for existing extended mouse buttons, if the mouse has more then three buttons. In that way, it is allowed to use the button masks corresponding to the buttons in the range from 1 to MouseInfo.getNumberOfButtons(). It is recommended to use the InputEvent.getMaskForButton(button) method to obtain the mask for any mouse button by its number. The following standard button masks are also accepted: InputEvent.BUTTON1_MASK InputEvent.BUTTON2_MASK InputEvent.BUTTON3_MASK However, it is recommended to use InputEvent.BUTTON1_DOWN_MASK, InputEvent.BUTTON2_DOWN_MASK, InputEvent.BUTTON3_DOWN_MASK instead. Either extended _DOWN_MASK or old _MASK values should be used, but both those models should not be mixed. - `int`

  throws: java.lang.IllegalArgumentException - if the buttons mask contains the mask for extra mouse button that does not exist on the mouse and support for extended mouse buttons is enabled by Java"
  ([this buttons]
    (-> this (.mousePress buttons))))

(defn key-release
  "Releases a given key.

   Key codes that have more than one physical key associated with them
   (e.g. KeyEvent.VK_SHIFT could mean either the
   left or right shift key) will map to the left key.

  keycode - Key to release (e.g. KeyEvent.VK_A) - `int`

  throws: java.lang.IllegalArgumentException - if keycode is not a valid key"
  ([this keycode]
    (-> this (.keyRelease keycode))))

(defn auto-wait-for-idle?
  "Returns whether this Robot automatically invokes waitForIdle
   after generating an event.

  returns: Whether waitForIdle is automatically called - `boolean`"
  ([this]
    (-> this (.isAutoWaitForIdle))))

(defn delay
  "Sleeps for the specified time.
   To catch any InterruptedExceptions that occur,
   Thread.sleep() may be used instead.

  ms - time to sleep in milliseconds - `int`

  throws: java.lang.IllegalArgumentException - if ms is not between 0 and 60,000 milliseconds inclusive"
  ([this ms]
    (-> this (.delay ms))))

(defn mouse-wheel
  "Rotates the scroll wheel on wheel-equipped mice.

  wheel-amt - number of `notches` to move the mouse wheel Negative values indicate movement up/away from the user, positive values indicate movement down/towards the user. - `int`"
  ([this wheel-amt]
    (-> this (.mouseWheel wheel-amt))))

(defn wait-for-idle
  "Waits until all events currently on the event queue have been processed.

  throws: java.lang.IllegalThreadStateException - if called on the AWT event dispatching thread"
  ([this]
    (-> this (.waitForIdle))))

