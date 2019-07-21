(ns jdk.awt.CheckboxGroup
  "The CheckboxGroup class is used to group together
  a set of Checkbox buttons.

  Exactly one check box button in a CheckboxGroup can
  be in the \"on\" state at any given time. Pushing any
  button sets its state to \"on\" and forces any other button that
  is in the \"on\" state into the \"off\" state.

  The following code example produces a new check box group,
  with three check boxes:



  setLayout(new GridLayout(3, 1));
  CheckboxGroup cbg = new CheckboxGroup();
  add(new Checkbox(\"one\", cbg, true));
  add(new Checkbox(\"two\", cbg, false));
  add(new Checkbox(\"three\", cbg, false));

  This image depicts the check box group created by this example:"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt CheckboxGroup]))

(defn ->checkbox-group
  "Constructor.

  Creates a new instance of CheckboxGroup."
  (^CheckboxGroup []
    (new CheckboxGroup )))

(defn get-selected-checkbox
  "Gets the current choice from this check box group.
   The current choice is the check box in this
   group that is currently in the \"on\" state,
   or null if all check boxes in the
   group are off.

  returns: the check box that is currently in the
                   \"on\" state, or null. - `java.awt.Checkbox`"
  (^java.awt.Checkbox [^CheckboxGroup this]
    (-> this (.getSelectedCheckbox))))

(defn get-current
  "Deprecated. As of JDK version 1.1,
   replaced by getSelectedCheckbox().

  returns: `java.awt.Checkbox`"
  (^java.awt.Checkbox [^CheckboxGroup this]
    (-> this (.getCurrent))))

(defn set-selected-checkbox
  "Sets the currently selected check box in this group
   to be the specified check box.
   This method sets the state of that check box to \"on\" and
   sets all other check boxes in the group to be off.

   If the check box argument is null, all check boxes
   in this check box group are deselected. If the check box argument
   belongs to a different check box group, this method does
   nothing.

  box - the Checkbox to set as the current selection. - `java.awt.Checkbox`"
  ([^CheckboxGroup this ^java.awt.Checkbox box]
    (-> this (.setSelectedCheckbox box))))

(defn set-current
  "Deprecated. As of JDK version 1.1,
   replaced by setSelectedCheckbox(Checkbox).

  box - `java.awt.Checkbox`"
  ([^CheckboxGroup this ^java.awt.Checkbox box]
    (-> this (.setCurrent box))))

(defn to-string
  "Returns a string representation of this check box group,
   including the value of its current selection.

  returns: a string representation of this check box group. - `java.lang.String`"
  (^java.lang.String [^CheckboxGroup this]
    (-> this (.toString))))

