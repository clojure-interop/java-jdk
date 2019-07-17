(ns jdk.awt.Label
  "A Label object is a component for placing text in a
  container. A label displays a single line of read-only text.
  The text can be changed by the application, but a user cannot edit it
  directly.

  For example, the code . . .



  setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
  add(new Label(`Hi There!`));
  add(new Label(`Another Label`));

  produces the following labels:"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Label]))

(defn ->label
  "Constructor.

  Constructs a new label that presents the specified string of
   text with the specified alignment.
   Possible values for alignment are Label.LEFT,
   Label.RIGHT, and Label.CENTER.

  text - the string that the label presents. A null value will be accepted without causing a NullPointerException to be thrown. - `java.lang.String`
  alignment - the alignment value. - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.lang.String text ^Integer alignment]
    (new Label text alignment))
  ([^java.lang.String text]
    (new Label text))
  ([]
    (new Label )))

(def *-left
  "Static Constant.

  Indicates that the label should be left justified.

  type: int"
  Label/LEFT)

(def *-center
  "Static Constant.

  Indicates that the label should be centered.

  type: int"
  Label/CENTER)

(def *-right
  "Static Constant.

  Indicates that the label should be right justified.

  type: int"
  Label/RIGHT)

(defn add-notify
  "Creates the peer for this label.  The peer allows us to
   modify the appearance of the label without changing its
   functionality."
  ([^java.awt.Label this]
    (-> this (.addNotify))))

(defn get-alignment
  "Gets the current alignment of this label. Possible values are
   Label.LEFT, Label.RIGHT, and
   Label.CENTER.

  returns: `int`"
  ([^java.awt.Label this]
    (-> this (.getAlignment))))

(defn set-alignment
  "Sets the alignment for this label to the specified alignment.
   Possible values are Label.LEFT,
   Label.RIGHT, and Label.CENTER.

  alignment - the alignment to be set. - `int`

  throws: java.lang.IllegalArgumentException - if an improper value for alignment is given."
  ([^java.awt.Label this ^Integer alignment]
    (-> this (.setAlignment alignment))))

(defn get-text
  "Gets the text of this label.

  returns: the text of this label, or null if
               the text has been set to null. - `java.lang.String`"
  ([^java.awt.Label this]
    (-> this (.getText))))

(defn set-text
  "Sets the text for this label to the specified text.

  text - the text that this label displays. If text is null, it is treated for display purposes like an empty string ``. - `java.lang.String`"
  ([^java.awt.Label this ^java.lang.String text]
    (-> this (.setText text))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Label.
   For labels, the AccessibleContext takes the form of an
   AccessibleAWTLabel.
   A new AccessibleAWTLabel instance is created if necessary.

  returns: an AccessibleAWTLabel that serves as the
           AccessibleContext of this Label - `javax.accessibility.AccessibleContext`"
  ([^java.awt.Label this]
    (-> this (.getAccessibleContext))))

