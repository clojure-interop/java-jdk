(ns javax.swing.plaf.OptionPaneUI
  "Pluggable look and feel interface for JOptionPane."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf OptionPaneUI]))

(defn ->option-pane-ui
  "Constructor."
  (^OptionPaneUI []
    (new OptionPaneUI )))

(defn select-initial-value
  "Requests the component representing the default value to have
   focus.

  op - `javax.swing.JOptionPane`"
  ([^OptionPaneUI this ^javax.swing.JOptionPane op]
    (-> this (.selectInitialValue op))))

(defn contains-custom-components
  "Returns true if the user has supplied instances of Component for
   either the options or message.

  op - `javax.swing.JOptionPane`

  returns: `boolean`"
  (^Boolean [^OptionPaneUI this ^javax.swing.JOptionPane op]
    (-> this (.containsCustomComponents op))))

