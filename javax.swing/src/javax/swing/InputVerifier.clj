(ns javax.swing.InputVerifier
  "The purpose of this class is to help clients support smooth focus
  navigation through GUIs with text fields. Such GUIs often need
  to ensure that the text entered by the user is valid (for example,
  that it's in
  the proper format) before allowing the user to navigate out of
  the text field. To do this, clients create a subclass of
  InputVerifier and, using JComponent's
  setInputVerifier method,
  attach an instance of their subclass to the JComponent whose input they
  want to validate. Before focus is transfered to another Swing component
  that requests it, the input verifier's shouldYieldFocus method is
  called.  Focus is transfered only if that method returns true.

  The following example has two text fields, with the first one expecting
  the string \"pass\" to be entered by the user. If that string is entered in
  the first text field, then the user can advance to the second text field
  either by clicking in it or by pressing TAB. However, if another string
  is entered in the first text field, then the user will be unable to
  transfer focus to the second text field.



  import java.awt.*;
  import java.util.*;
  import java.awt.event.*;
  import javax.swing.*;

  // This program demonstrates the use of the Swing InputVerifier class.
  // It creates two text fields; the first of the text fields expects the
  // string \"pass\" as input, and will allow focus to advance out of it
  // only after that string is typed in by the user.

  public class VerifierTest extends JFrame {
      public VerifierTest() {
          JTextField tf1 = new JTextField (\"Type \\\"pass\\\" here\");
          getContentPane().add (tf1, BorderLayout.NORTH);
          tf1.setInputVerifier(new PassVerifier());

          JTextField tf2 = new JTextField (\"TextField2\");
          getContentPane().add (tf2, BorderLayout.SOUTH);

          WindowListener l = new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          };
          addWindowListener(l);
      }

      class PassVerifier extends InputVerifier {
          public boolean verify(JComponent input) {
              JTextField tf = (JTextField) input;
              return \"pass\".equals(tf.getText());
          }
      }

      public static void main(String[] args) {
          Frame f = new VerifierTest();
          f.pack();
          f.setVisible(true);
      }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing InputVerifier]))

(defn ->input-verifier
  "Constructor."
  (^InputVerifier []
    (new InputVerifier )))

(defn verify
  "Checks whether the JComponent's input is valid. This method should
   have no side effects. It returns a boolean indicating the status
   of the argument's input.

  input - the JComponent to verify - `javax.swing.JComponent`

  returns: true when valid, false when invalid - `boolean`"
  (^Boolean [^InputVerifier this ^javax.swing.JComponent input]
    (-> this (.verify input))))

(defn should-yield-focus?
  "Calls verify(input) to ensure that the input is valid.
   This method can have side effects. In particular, this method
   is called when the user attempts to advance focus out of the
   argument component into another Swing component in this window.
   If this method returns true, then the focus is transfered
   normally; if it returns false, then the focus remains in
   the argument component.

  input - the JComponent to verify - `javax.swing.JComponent`

  returns: true when valid, false when invalid - `boolean`"
  (^Boolean [^InputVerifier this ^javax.swing.JComponent input]
    (-> this (.shouldYieldFocus input))))

