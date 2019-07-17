(ns javax.swing.plaf.nimbus.State
  "Represents a built in, or custom, state in Nimbus.

  Synth provides several built in states, which are:

   Enabled
   Mouse Over
   Pressed
   Disabled
   Focused
   Selected
   Default


  However, there are many more states that could be described in a LookAndFeel, and it
  would be nice to style components differently based on these different states.
  For example, a progress bar could be `indeterminate`. It would be very convenient
  to allow this to be defined as a `state`.

  This class, State, is intended to be used for such situations.
  Simply implement the abstract #isInState method. It returns true if the given
  JComponent is `in this state`, false otherwise. This method will be called
  many times in performance sensitive loops. It must execute
  very quickly.

  For example, the following might be an implementation of a custom
  `Indeterminate` state for JProgressBars:



      public final class IndeterminateState extends State<JProgressBar> {
          public IndeterminateState() {
              super(`Indeterminate`);
          }

          @Override
          protected boolean isInState(JProgressBar c) {
              return c.isIndeterminate();
          }
      }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.nimbus State]))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.nimbus.State this]
    (-> this (.toString))))

