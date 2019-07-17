(ns javax.xml.transform.ErrorListener
  "To provide customized error handling, implement this interface and
  use the setErrorListener method to register an instance of the
  implmentation with the Transformer.  The
  Transformer then reports all errors and warnings through this
  interface.

  If an application does not register its own custom
  ErrorListener, the default ErrorListener
  is used which reports all warnings and errors to System.err
  and does not throw any Exceptions.
  Applications are strongly encouraged to register and use
  ErrorListeners that insure proper behavior for warnings and
  errors.

  For transformation errors, a Transformer must use this
  interface instead of throwing an Exception: it is up to the
  application to decide whether to throw an Exception for
  different types of errors and warnings.  Note however that the
  Transformer is not required to continue with the transformation
  after a call to fatalError(TransformerException exception).

  Transformers may use this mechanism to report XML parsing
  errors as well as transformation errors."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform ErrorListener]))

(defn warning
  "Receive notification of a warning.

   Transformer can use this method to report
   conditions that are not errors or fatal errors.  The default behaviour
   is to take no action.

   After invoking this method, the Transformer must continue with
   the transformation. It should still be possible for the
   application to process the document through to the end.

  exception - The warning information encapsulated in a transformer exception. - `javax.xml.transform.TransformerException`

  throws: javax.xml.transform.TransformerException - if the application chooses to discontinue the transformation."
  ([^javax.xml.transform.ErrorListener this ^javax.xml.transform.TransformerException exception]
    (-> this (.warning exception))))

(defn error
  "Receive notification of a recoverable error.

   The transformer must continue to try and provide normal transformation
   after invoking this method.  It should still be possible for the
   application to process the document through to the end if no other errors
   are encountered.

  exception - The error information encapsulated in a transformer exception. - `javax.xml.transform.TransformerException`

  throws: javax.xml.transform.TransformerException - if the application chooses to discontinue the transformation."
  ([^javax.xml.transform.ErrorListener this ^javax.xml.transform.TransformerException exception]
    (-> this (.error exception))))

(defn fatal-error
  "Receive notification of a non-recoverable error.

   The processor may choose to continue, but will not normally
   proceed to a successful completion.

   The method should throw an exception if it is unable to
   process the error, or if it wishes execution to terminate
   immediately. The processor will not necessarily honor this
   request.

  exception - The error information encapsulated in a TransformerException. - `javax.xml.transform.TransformerException`

  throws: javax.xml.transform.TransformerException - if the application chooses to discontinue the transformation."
  ([^javax.xml.transform.ErrorListener this ^javax.xml.transform.TransformerException exception]
    (-> this (.fatalError exception))))

