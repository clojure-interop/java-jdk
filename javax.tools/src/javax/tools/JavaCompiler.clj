(ns javax.tools.JavaCompiler
  "Interface to invoke Java™ programming language compilers from
  programs.

  The compiler might generate diagnostics during compilation (for
  example, error messages).  If a diagnostic listener is provided,
  the diagnostics will be supplied to the listener.  If no listener
  is provided, the diagnostics will be formatted in an unspecified
  format and written to the default output, which is System.err unless otherwise specified.  Even if a diagnostic
  listener is supplied, some diagnostics might not fit in a Diagnostic and will be written to the default output.

  A compiler tool has an associated standard file manager, which
  is the file manager that is native to the tool (or built-in).  The
  standard file manager can be obtained by calling getStandardFileManager.

  A compiler tool must function with any file manager as long as
  any additional requirements as detailed in the methods below are
  met.  If no file manager is provided, the compiler tool will use a
  standard file manager such as the one returned by getStandardFileManager.

  An instance implementing this interface must conform to
  The Java™ Language Specification
  and generate class files conforming to
  The Java™ Virtual Machine Specification.
  The versions of these
  specifications are defined in the javax.tools.Tool interface.

  Additionally, an instance of this interface supporting SourceVersion.RELEASE_6
  or higher must also support annotation processing.

  The compiler relies on two services: javax.tools.diagnostic listener and javax.tools.file manager.  Although most classes and
  interfaces in this package defines an API for compilers (and
  tools in general) the interfaces javax.tools.DiagnosticListener,
  javax.tools.JavaFileManager, javax.tools.FileObject, and
  javax.tools.JavaFileObject are not intended to be used in
  applications.  Instead these interfaces are intended to be
  implemented and used to provide customized services for a
  compiler and thus defines an SPI for compilers.

  There are a number of classes and interfaces in this package
  which are designed to ease the implementation of the SPI to
  customize the behavior of a compiler:


    StandardJavaFileManager


      Every compiler which implements this interface provides a
      standard file manager for operating on regular java.io.files.  The StandardJavaFileManager interface
      defines additional methods for creating file objects from
      regular files.

      The standard file manager serves two purposes:


        basic building block for customizing how a compiler reads
        and writes files
        sharing between multiple compilation tasks


      Reusing a file manager can potentially reduce overhead of
      scanning the file system and reading jar files.  Although there
      might be no reduction in overhead, a standard file manager must
      work with multiple sequential compilations making the following
      example a recommended coding pattern:



        File[] files1 = ... ; // input for first compilation task
        File[] files2 = ... ; // input for second compilation task

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

         Iterable<? extends JavaFileObject> compilationUnits1 =
            fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits1).call();

         Iterable<? extends JavaFileObject> compilationUnits2 =
            fileManager.getJavaFileObjects(files2); // use alternative method
        // reuse the same file manager to allow caching of jar files
        compiler.getTask(null, fileManager, null, null, null, compilationUnits2).call();

        fileManager.close();



    DiagnosticCollector

      Used to collect diagnostics in a list, for example:


         Iterable<? extends JavaFileObject> compilationUnits = ...;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
         DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

        for ( Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics())
            System.out.format(`Error on line %d in %s%n`,
                              diagnostic.getLineNumber(),
                              diagnostic.getSource().toUri());

        fileManager.close();



      ForwardingJavaFileManager, ForwardingFileObject, and
      ForwardingJavaFileObject



      Subclassing is not available for overriding the behavior of a
      standard file manager as it is created by calling a method on a
      compiler, not by invoking a constructor.  Instead forwarding
      (or delegation) should be used.  These classes makes it easy to
      forward most calls to a given file manager or file object while
      allowing customizing behavior.  For example, consider how to
      log all calls to JavaFileManager.flush():



        final java.util.logging.Logger logger = ...;
         Iterable<? extends JavaFileObject> compilationUnits = ...;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, null, null);
        JavaFileManager fileManager = new ForwardingJavaFileManager(stdFileManager) {
            public void flush() throws IOException {
                logger.entering(StandardJavaFileManager.class.getName(), `flush`);
                super.flush();
                logger.exiting(StandardJavaFileManager.class.getName(), `flush`);
            }
        };
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();


    SimpleJavaFileObject


      This class provides a basic file object implementation which
      can be used as building block for creating file objects.  For
      example, here is how to define a file object which represent
      source code stored in a string:



        /**
         * A file object used to represent source coming from a string.
          */
        public class JavaSourceFromString extends SimpleJavaFileObject {
            /**
             * The source code of this `file`.
              */
            final String code;

            /**
             * Constructs a new JavaSourceFromString.
             *  @param name the name of the compilation unit represented by this file object
             *  @param code the source code for the compilation unit represented by this file object
              */
            JavaSourceFromString(String name, String code) {
                super(URI.create(`string:///`  name.replace('.','/')  Kind.SOURCE.extension),
                      Kind.SOURCE);
                this.code = code;
            }

             @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return code;
            }
        }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaCompiler]))

(defn get-task
  "Creates a future for a compilation task with the given
   components and arguments.  The compilation might not have
   completed as described in the CompilationTask interface.

   If a file manager is provided, it must be able to handle all
   locations defined in StandardLocation.

   Note that annotation processing can process both the
   compilation units of source code to be compiled, passed with
   the compilationUnits parameter, as well as class
   files, whose names are passed with the classes
   parameter.

  out - a Writer for additional output from the compiler; use System.err if null - `java.io.Writer`
  file-manager - a file manager; if null use the compiler's standard filemanager - `javax.tools.JavaFileManager`
  diagnostic-listener - a diagnostic listener; if null use the compiler's default method for reporting diagnostics - `javax.tools.DiagnosticListener`
  options - compiler options, null means no options - `java.lang.Iterable`
  classes - names of classes to be processed by annotation processing, null means no class names - `java.lang.Iterable`
  compilation-units - the compilation units to compile, null means no compilation units - `java.lang.Iterable`

  returns: an object representing the compilation - `javax.tools.JavaCompiler$CompilationTask`

  throws: java.lang.RuntimeException - if an unrecoverable error occurred in a user supplied component. The cause will be the error in user code."
  (^javax.tools.JavaCompiler$CompilationTask [^JavaCompiler this ^java.io.Writer out ^javax.tools.JavaFileManager file-manager ^javax.tools.DiagnosticListener diagnostic-listener ^java.lang.Iterable options ^java.lang.Iterable classes ^java.lang.Iterable compilation-units]
    (-> this (.getTask out file-manager diagnostic-listener options classes compilation-units))))

(defn get-standard-file-manager
  "Gets a new instance of the standard file manager implementation
   for this tool.  The file manager will use the given diagnostic
   listener for producing any non-fatal diagnostics.  Fatal errors
   will be signaled with the appropriate exceptions.

   The standard file manager will be automatically reopened if
   it is accessed after calls to flush or close.
   The standard file manager must be usable with other tools.

  diagnostic-listener - a diagnostic listener for non-fatal diagnostics; if null use the compiler's default method for reporting diagnostics - `javax.tools.DiagnosticListener`
  locale - the locale to apply when formatting diagnostics; null means the default locale. - `java.util.Locale`
  charset - the character set used for decoding bytes; if null use the platform default - `java.nio.charset.Charset`

  returns: the standard file manager - `javax.tools.StandardJavaFileManager`"
  (^javax.tools.StandardJavaFileManager [^JavaCompiler this ^javax.tools.DiagnosticListener diagnostic-listener ^java.util.Locale locale ^java.nio.charset.Charset charset]
    (-> this (.getStandardFileManager diagnostic-listener locale charset))))

