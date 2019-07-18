(ns javax.swing.UIManager$LookAndFeelInfo
  "Provides a little information about an installed
  LookAndFeel for the sake of configuring a menu or
  for initial application set up."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing UIManager$LookAndFeelInfo]))

(defn ->look-and-feel-info
  "Constructor.

  Constructs a UIManagers
   LookAndFeelInfo object.

  name - a String specifying the name of the look and feel - `java.lang.String`
  class-name - a String specifying the name of the class that implements the look and feel - `java.lang.String`"
  (^UIManager$LookAndFeelInfo [^java.lang.String name ^java.lang.String class-name]
    (new UIManager$LookAndFeelInfo name class-name)))

(defn get-name
  "Returns the name of the look and feel in a form suitable
   for a menu or other presentation

  returns: a String containing the name - `java.lang.String`"
  (^java.lang.String [^UIManager$LookAndFeelInfo this]
    (-> this (.getName))))

(defn get-class-name
  "Returns the name of the class that implements this look and feel.

  returns: the name of the class that implements this
                LookAndFeel - `java.lang.String`"
  (^java.lang.String [^UIManager$LookAndFeelInfo this]
    (-> this (.getClassName))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^UIManager$LookAndFeelInfo this]
    (-> this (.toString))))

