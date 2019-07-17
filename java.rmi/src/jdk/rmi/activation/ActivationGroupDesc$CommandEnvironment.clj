(ns jdk.rmi.activation.ActivationGroupDesc$CommandEnvironment
  "Startup options for ActivationGroup implementations.

  This class allows overriding default system properties and
  specifying implementation-defined options for ActivationGroups."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationGroupDesc$CommandEnvironment]))

(defn ->command-environment
  "Constructor.

  Create a CommandEnvironment with all the necessary
   information.

  cmdpath - the name of the java executable, including the full path, or null, meaning `use rmid's default`. The named program must be able to accept multiple -Dpropname=value options (as documented for the `java` tool) - `java.lang.String`
  argv - extra options which will be used in creating the ActivationGroup. Null has the same effect as an empty list. - `java.lang.String[]`"
  ([cmdpath argv]
    (new ActivationGroupDesc$CommandEnvironment cmdpath argv)))

(defn get-command-path
  "Fetch the configured path-qualified java command name.

  returns: the configured name, or null if configured to
   accept the default - `java.lang.String`"
  ([this]
    (-> this (.getCommandPath))))

(defn get-command-options
  "Fetch the configured java command options.

  returns: An array of the command options which will be passed
   to the new child command by rmid.
   Note that rmid may add other options before or after these
   options, or both.
   Never returns null. - `java.lang.String[]`"
  ([this]
    (-> this (.getCommandOptions))))

(defn equals
  "Compares two command environments for content equality.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Return identical values for similar
   CommandEnvironments.

  returns: an integer - `int`"
  ([this]
    (-> this (.hashCode))))

