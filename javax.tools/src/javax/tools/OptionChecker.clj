(ns javax.tools.OptionChecker
  "Interface for recognizing options."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools OptionChecker]))

(defn is-supported-option
  "Determines if the given option is supported and if so, the
   number of arguments the option takes.

  option - an option - `java.lang.String`

  returns: the number of arguments the given option takes or -1 if
   the option is not supported - `int`"
  ([this option]
    (-> this (.isSupportedOption option))))

