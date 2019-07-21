(ns javax.swing.plaf.UIResource
  "This interface is used to mark objects created by ComponentUI delegates.
  The ComponentUI.installUI() and
  ComponentUI.uninstallUI() methods can use this interface
  to decide if a properties value has been overridden.  For example, the
  JList cellRenderer property is initialized by BasicListUI.installUI(),
  only if it's initial value is null:


  if (list.getCellRenderer() == null) {
      list.setCellRenderer((ListCellRenderer)(UIManager.get(\"List.cellRenderer\")));
  }
  At uninstallUI() time we reset the property to null if its value
  is an instance of UIResource:


  if (list.getCellRenderer() instanceof UIResource) {
      list.setCellRenderer(null);
  }
  This pattern applies to all properties except the java.awt.Component
  properties font, foreground, and background.  If one of these
  properties isn't initialized, or is explicitly set to null,
  its container provides the value.  For this reason the
  \"== null\" is unreliable when installUI() is called
  to dynamically change a components look and feel.  So at installUI()
  time we check to see if the current value is a UIResource:


  if (!(list.getFont() instanceof UIResource)) {
      list.setFont(UIManager.getFont(\"List.font\"));
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf UIResource]))

