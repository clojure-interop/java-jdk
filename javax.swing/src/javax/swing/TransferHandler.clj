(ns javax.swing.TransferHandler
  "This class is used to handle the transfer of a Transferable
  to and from Swing components.  The Transferable is used to
  represent data that is exchanged via a cut, copy, or paste
  to/from a clipboard.  It is also used in drag-and-drop operations
  to represent a drag from a component, and a drop to a component.
  Swing provides functionality that automatically supports cut, copy,
  and paste keyboard bindings that use the functionality provided by
  an implementation of this class.  Swing also provides functionality
  that automatically supports drag and drop that uses the functionality
  provided by an implementation of this class.  The Swing developer can
  concentrate on specifying the semantics of a transfer primarily by setting
  the transferHandler property on a Swing component.

  This class is implemented to provide a default behavior of transferring
  a component property simply by specifying the name of the property in
  the constructor.  For example, to transfer the foreground color from
  one component to another either via the clipboard or a drag and drop operation
  a TransferHandler can be constructed with the string `foreground`.  The
  built in support will use the color returned by getForeground as the source
  of the transfer, and setForeground for the target of a transfer.

  Please see

  How to Use Drag and Drop and Data Transfer,
  a section in The Java Tutorial, for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing TransferHandler]))

(defn ->transfer-handler
  "Constructor.

  Constructs a transfer handler that can transfer a Java Bean property
   from one component to another via the clipboard or a drag and drop
   operation.

  property - the name of the property to transfer; this can be null if there is no property associated with the transfer handler (a subclass that performs some other kind of transfer, for example) - `java.lang.String`"
  ([property]
    (new TransferHandler property)))

(def *-none
  "Static Constant.

  An int representing no transfer action.

  type: int"
  TransferHandler/NONE)

(def *-copy
  "Static Constant.

  An int representing a `copy` transfer action.
   This value is used when data is copied to a clipboard
   or copied elsewhere in a drag and drop operation.

  type: int"
  TransferHandler/COPY)

(def *-move
  "Static Constant.

  An int representing a `move` transfer action.
   This value is used when data is moved to a clipboard (i.e. a cut)
   or moved elsewhere in a drag and drop operation.

  type: int"
  TransferHandler/MOVE)

(def *-copy-or-move
  "Static Constant.

  An int representing a source action capability of either
   `copy` or `move`.

  type: int"
  TransferHandler/COPY_OR_MOVE)

(def *-link
  "Static Constant.

  An int representing a `link` transfer action.
   This value is used to specify that data should be linked in a drag
   and drop operation.

  type: int"
  TransferHandler/LINK)

(defn *get-cut-action
  "Returns an Action that performs cut operations to the
   clipboard. When performed, this action operates on the JComponent
   source of the ActionEvent by invoking exportToClipboard,
   with a MOVE action, on the component's TransferHandler.

  returns: an Action for performing cuts to the clipboard - `javax.swing.Action`"
  ([]
    (TransferHandler/getCutAction )))

(defn *get-copy-action
  "Returns an Action that performs copy operations to the
   clipboard. When performed, this action operates on the JComponent
   source of the ActionEvent by invoking exportToClipboard,
   with a COPY action, on the component's TransferHandler.

  returns: an Action for performing copies to the clipboard - `javax.swing.Action`"
  ([]
    (TransferHandler/getCopyAction )))

(defn *get-paste-action
  "Returns an Action that performs paste operations from the
   clipboard. When performed, this action operates on the JComponent
   source of the ActionEvent by invoking importData,
   with the clipboard contents, on the component's TransferHandler.

  returns: an Action for performing pastes from the clipboard - `javax.swing.Action`"
  ([]
    (TransferHandler/getPasteAction )))

(defn can-import?
  "Indicates whether a component will accept an import of the given
   set of data flavors prior to actually attempting to import it.

   Note: Swing now calls the newer version of canImport
   that takes a TransferSupport, which in turn calls this
   method (only if the component in the TransferSupport is a
   JComponent). Developers are encouraged to call and override the
   newer version as it provides more information (and is the only
   version that supports use with a TransferHandler set directly
   on a JFrame or other non-JComponent).

  comp - the component to receive the transfer; provided to enable sharing of TransferHandlers - `javax.swing.JComponent`
  transfer-flavors - the data formats available - `java.awt.datatransfer.DataFlavor[]`

  returns: true if the data can be inserted into the component, false otherwise - `boolean`"
  ([this comp transfer-flavors]
    (-> this (.canImport comp transfer-flavors)))
  ([this support]
    (-> this (.canImport support))))

(defn set-drag-image-offset
  "Sets an anchor offset for the image to drag.
   It can not be null.

  p - a Point object that corresponds to coordinates of an anchor offset of the image relative to the upper left corner of the image - `java.awt.Point`"
  ([this p]
    (-> this (.setDragImageOffset p))))

(defn export-as-drag
  "Causes the Swing drag support to be initiated.  This is called by
   the various UI implementations in the javax.swing.plaf.basic
   package if the dragEnabled property is set on the component.
   This can be called by custom UI
   implementations to use the Swing drag support.  This method can also be called
   by a Swing extension written as a subclass of JComponent
   to take advantage of the Swing drag support.

   The transfer will not necessarily have been completed at the
   return of this call (i.e. the call does not block waiting for the drop).
   The transfer will take place through the Swing implementation of the
   java.awt.dnd mechanism, requiring no further effort
   from the developer. The exportDone method will be called
   when the transfer has completed.

  comp - the component holding the data to be transferred; provided to enable sharing of TransferHandlers - `javax.swing.JComponent`
  e - the event that triggered the transfer - `java.awt.event.InputEvent`
  action - the transfer action initially requested; either COPY, MOVE or LINK; the DnD system may change the action used during the course of the drag operation - `int`"
  ([this comp e action]
    (-> this (.exportAsDrag comp e action))))

(defn import-data
  "Causes a transfer to a component from a clipboard or a
   DND drop operation.  The Transferable represents
   the data to be imported into the component.

   Note: Swing now calls the newer version of importData
   that takes a TransferSupport, which in turn calls this
   method (if the component in the TransferSupport is a
   JComponent). Developers are encouraged to call and override the
   newer version as it provides more information (and is the only
   version that supports use with a TransferHandler set directly
   on a JFrame or other non-JComponent).

  comp - the component to receive the transfer; provided to enable sharing of TransferHandlers - `javax.swing.JComponent`
  t - the data to import - `java.awt.datatransfer.Transferable`

  returns: true if the data was inserted into the component, false otherwise - `boolean`"
  ([this comp t]
    (-> this (.importData comp t)))
  ([this support]
    (-> this (.importData support))))

(defn get-source-actions
  "Returns the type of transfer actions supported by the source;
   any bitwise-OR combination of COPY, MOVE
   and LINK.

   Some models are not mutable, so a transfer operation of MOVE
   should not be advertised in that case. Returning NONE
   disables transfers from the component.

  c - the component holding the data to be transferred; provided to enable sharing of TransferHandlers - `javax.swing.JComponent`

  returns: COPY if the transfer property can be found,
            otherwise returns NONE - `int`"
  ([this c]
    (-> this (.getSourceActions c))))

(defn get-visual-representation
  "Returns an object that establishes the look of a transfer.  This is
   useful for both providing feedback while performing a drag operation and for
   representing the transfer in a clipboard implementation that has a visual
   appearance.  The implementation of the Icon interface should
   not alter the graphics clip or alpha level.
   The icon implementation need not be rectangular or paint all of the
   bounding rectangle and logic that calls the icons paint method should
   not assume the all bits are painted. null is a valid return value
   for this method and indicates there is no visual representation provided.
   In that case, the calling logic is free to represent the
   transferable however it wants.

   The default Swing logic will not do an alpha blended drag animation if
   the return is null.

  t - the data to be transferred; this value is expected to have been created by the createTransferable method - `java.awt.datatransfer.Transferable`

  returns: null, indicating
      there is no default visual representation - `javax.swing.Icon`"
  ([this t]
    (-> this (.getVisualRepresentation t))))

(defn get-drag-image
  "Returns the drag image. If there is no image to drag,
   the returned value is null.

  returns: the reference to the drag image - `java.awt.Image`"
  ([this]
    (-> this (.getDragImage))))

(defn export-to-clipboard
  "Causes a transfer from the given component to the
   given clipboard.  This method is called by the default cut and
   copy actions registered in a component's action map.

   The transfer will take place using the java.awt.datatransfer
   mechanism, requiring no further effort from the developer. Any data
   transfer will be complete and the exportDone
   method will be called with the action that occurred, before this method
   returns. Should the clipboard be unavailable when attempting to place
   data on it, the IllegalStateException thrown by
   Clipboard.setContents(Transferable, ClipboardOwner) will
   be propagated through this method. However,
   exportDone will first be called with an action
   of NONE for consistency.

  comp - the component holding the data to be transferred; provided to enable sharing of TransferHandlers - `javax.swing.JComponent`
  clip - the clipboard to transfer the data into - `java.awt.datatransfer.Clipboard`
  action - the transfer action requested; this should be a value of either COPY or MOVE; the operation performed is the intersection of the transfer capabilities given by getSourceActions and the requested action; the intersection may result in an action of NONE if the requested action isn't supported - `int`

  throws: java.lang.IllegalStateException - if the clipboard is currently unavailable"
  ([this comp clip action]
    (-> this (.exportToClipboard comp clip action))))

(defn set-drag-image
  "Sets the drag image parameter. The image has to be prepared
   for rendering by the moment of the call. The image is stored
   by reference because of some performance reasons.

  img - an image to drag - `java.awt.Image`"
  ([this img]
    (-> this (.setDragImage img))))

(defn get-drag-image-offset
  "Returns an anchor offset for the image to drag.

  returns: a Point object that corresponds
   to coordinates of an anchor offset of the image
   relative to the upper left corner of the image.
   The point (0,0) returns by default. - `java.awt.Point`"
  ([this]
    (-> this (.getDragImageOffset))))

