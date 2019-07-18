(ns jdk.util.logging.Level
  "The Level class defines a set of standard logging levels that
  can be used to control logging output.  The logging Level objects
  are ordered and are specified by ordered integers.  Enabling logging
  at a given level also enables logging at all higher levels.

  Clients should normally use the predefined Level constants such
  as Level.SEVERE.

  The levels in descending order are:

  SEVERE (highest value)
  WARNING
  INFO
  CONFIG
  FINE
  FINER
  FINEST  (lowest value)

  In addition there is a level OFF that can be used to turn
  off logging, and a level ALL that can be used to enable
  logging of all messages.

  It is possible for third parties to define additional logging
  levels by subclassing Level.  In such cases subclasses should
  take care to chose unique integer level values and to ensure that
  they maintain the Object uniqueness property across serialization
  by defining a suitable readResolve method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging Level]))

(def *-off
  "Static Constant.

  OFF is a special level that can be used to turn off logging.
   This level is initialized to Integer.MAX_VALUE.

  type: java.util.logging.Level"
  Level/OFF)

(def *-severe
  "Static Constant.

  SEVERE is a message level indicating a serious failure.

   In general SEVERE messages should describe events that are
   of considerable importance and which will prevent normal
   program execution.   They should be reasonably intelligible
   to end users and to system administrators.
   This level is initialized to 1000.

  type: java.util.logging.Level"
  Level/SEVERE)

(def *-warning
  "Static Constant.

  WARNING is a message level indicating a potential problem.

   In general WARNING messages should describe events that will
   be of interest to end users or system managers, or which
   indicate potential problems.
   This level is initialized to 900.

  type: java.util.logging.Level"
  Level/WARNING)

(def *-info
  "Static Constant.

  INFO is a message level for informational messages.

   Typically INFO messages will be written to the console
   or its equivalent.  So the INFO level should only be
   used for reasonably significant messages that will
   make sense to end users and system administrators.
   This level is initialized to 800.

  type: java.util.logging.Level"
  Level/INFO)

(def *-config
  "Static Constant.

  CONFIG is a message level for static configuration messages.

   CONFIG messages are intended to provide a variety of static
   configuration information, to assist in debugging problems
   that may be associated with particular configurations.
   For example, CONFIG message might include the CPU type,
   the graphics depth, the GUI look-and-feel, etc.
   This level is initialized to 700.

  type: java.util.logging.Level"
  Level/CONFIG)

(def *-fine
  "Static Constant.

  FINE is a message level providing tracing information.

   All of FINE, FINER, and FINEST are intended for relatively
   detailed tracing.  The exact meaning of the three levels will
   vary between subsystems, but in general, FINEST should be used
   for the most voluminous detailed output, FINER for somewhat
   less detailed output, and FINE for the  lowest volume (and
   most important) messages.

   In general the FINE level should be used for information
   that will be broadly interesting to developers who do not have
   a specialized interest in the specific subsystem.

   FINE messages might include things like minor (recoverable)
   failures.  Issues indicating potential performance problems
   are also worth logging as FINE.
   This level is initialized to 500.

  type: java.util.logging.Level"
  Level/FINE)

(def *-finer
  "Static Constant.

  FINER indicates a fairly detailed tracing message.
   By default logging calls for entering, returning, or throwing
   an exception are traced at this level.
   This level is initialized to 400.

  type: java.util.logging.Level"
  Level/FINER)

(def *-finest
  "Static Constant.

  FINEST indicates a highly detailed tracing message.
   This level is initialized to 300.

  type: java.util.logging.Level"
  Level/FINEST)

(def *-all
  "Static Constant.

  ALL indicates that all messages should be logged.
   This level is initialized to Integer.MIN_VALUE.

  type: java.util.logging.Level"
  Level/ALL)

(defn *parse
  "Parse a level name string into a Level.

   The argument string may consist of either a level name
   or an integer value.

   For example:

        `SEVERE`
        `1000`

  name - string to be parsed - `java.lang.String`

  returns: The parsed value. Passing an integer that corresponds to a known name
   (e.g., 700) will return the associated name (e.g., CONFIG).
   Passing an integer that does not (e.g., 1) will return a new level name
   initialized to that value. - `java.util.logging.Level`

  throws: java.lang.NullPointerException - if the name is null"
  (^java.util.logging.Level [^java.lang.String name]
    (Level/parse name)))

(defn get-resource-bundle-name
  "Return the level's localization resource bundle name, or
   null if no localization bundle is defined.

  returns: localization resource bundle name - `java.lang.String`"
  (^java.lang.String [^Level this]
    (-> this (.getResourceBundleName))))

(defn get-name
  "Return the non-localized string name of the Level.

  returns: non-localized name - `java.lang.String`"
  (^java.lang.String [^Level this]
    (-> this (.getName))))

(defn get-localized-name
  "Return the localized string name of the Level, for
   the current default locale.

   If no localization information is available, the
   non-localized name is returned.

  returns: localized name - `java.lang.String`"
  (^java.lang.String [^Level this]
    (-> this (.getLocalizedName))))

(defn to-string
  "Returns a string representation of this Level.

  returns: the non-localized name of the Level, for example `INFO`. - `java.lang.String`"
  (^java.lang.String [^Level this]
    (-> this (.toString))))

(defn int-value
  "Get the integer value for this level.  This integer value
   can be used for efficient ordering comparisons between
   Level objects.

  returns: the integer value for this level. - `int`"
  (^Integer [^Level this]
    (-> this (.intValue))))

(defn equals
  "Compare two objects for value equality.

  ox - the reference object with which to compare. - `java.lang.Object`

  returns: true if and only if the two objects have the same level value. - `boolean`"
  (^Boolean [^Level this ^java.lang.Object ox]
    (-> this (.equals ox))))

(defn hash-code
  "Generate a hashcode.

  returns: a hashcode based on the level value - `int`"
  (^Integer [^Level this]
    (-> this (.hashCode))))

