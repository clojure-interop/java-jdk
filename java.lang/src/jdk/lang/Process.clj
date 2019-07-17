(ns jdk.lang.Process
  "The ProcessBuilder.start() and
  Runtime.exec
  methods create a native process and return an instance of a
  subclass of Process that can be used to control the process
  and obtain information about it.  The class Process
  provides methods for performing input from the process, performing
  output to the process, waiting for the process to complete,
  checking the exit status of the process, and destroying (killing)
  the process.

  The methods that create processes may not work well for special
  processes on certain native platforms, such as native windowing
  processes, daemon processes, Win16/DOS processes on Microsoft
  Windows, or shell scripts.

  By default, the created subprocess does not have its own terminal
  or console.  All its standard I/O (i.e. stdin, stdout, stderr)
  operations will be redirected to the parent process, where they can
  be accessed via the streams obtained using the methods
  getOutputStream(),
  getInputStream(), and
  getErrorStream().
  The parent process uses these streams to feed input to and get output
  from the subprocess.  Because some native platforms only provide
  limited buffer size for standard input and output streams, failure
  to promptly write the input stream or read the output stream of
  the subprocess may cause the subprocess to block, or even deadlock.

  Where desired,
  subprocess I/O can also be redirected
  using methods of the ProcessBuilder class.

  The subprocess is not killed when there are no more references to
  the Process object, but rather the subprocess
  continues executing asynchronously.

  There is no requirement that a process represented by a Process object execute asynchronously or concurrently with respect
  to the Java process that owns the Process object.

  As of 1.5, ProcessBuilder.start() is the preferred way
  to create a Process."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Process]))

(defn ->process
  "Constructor."
  ([]
    (new Process )))

(defn get-output-stream
  "Returns the output stream connected to the normal input of the
   subprocess.  Output to the stream is piped into the standard
   input of the process represented by this Process object.

   If the standard input of the subprocess has been redirected using
   ProcessBuilder.redirectInput
   then this method will return a
   null output stream.

   Implementation note: It is a good idea for the returned
   output stream to be buffered.

  returns: the output stream connected to the normal input of the
           subprocess - `java.io.OutputStream`"
  ([^java.lang.Process this]
    (-> this (.getOutputStream))))

(defn get-input-stream
  "Returns the input stream connected to the normal output of the
   subprocess.  The stream obtains data piped from the standard
   output of the process represented by this Process object.

   If the standard output of the subprocess has been redirected using
   ProcessBuilder.redirectOutput
   then this method will return a
   null input stream.

   Otherwise, if the standard error of the subprocess has been
   redirected using
   ProcessBuilder.redirectErrorStream
   then the input stream returned by this method will receive the
   merged standard output and the standard error of the subprocess.

   Implementation note: It is a good idea for the returned
   input stream to be buffered.

  returns: the input stream connected to the normal output of the
           subprocess - `java.io.InputStream`"
  ([^java.lang.Process this]
    (-> this (.getInputStream))))

(defn get-error-stream
  "Returns the input stream connected to the error output of the
   subprocess.  The stream obtains data piped from the error output
   of the process represented by this Process object.

   If the standard error of the subprocess has been redirected using
   ProcessBuilder.redirectError or
   ProcessBuilder.redirectErrorStream
   then this method will return a
   null input stream.

   Implementation note: It is a good idea for the returned
   input stream to be buffered.

  returns: the input stream connected to the error output of
           the subprocess - `java.io.InputStream`"
  ([^java.lang.Process this]
    (-> this (.getErrorStream))))

(defn wait-for
  "Causes the current thread to wait, if necessary, until the
   subprocess represented by this Process object has
   terminated, or the specified waiting time elapses.

   If the subprocess has already terminated then this method returns
   immediately with the value true.  If the process has not
   terminated and the timeout value is less than, or equal to, zero, then
   this method returns immediately with the value false.

   The default implementation of this methods polls the exitValue
   to check if the process has terminated. Concrete implementations of this
   class are strongly encouraged to override this method with a more
   efficient implementation.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if the subprocess has exited and false if
           the waiting time elapsed before the subprocess has exited. - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted while waiting."
  ([^java.lang.Process this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.waitFor timeout unit)))
  ([^java.lang.Process this]
    (-> this (.waitFor))))

(defn exit-value
  "Returns the exit value for the subprocess.

  returns: the exit value of the subprocess represented by this
           Process object.  By convention, the value
           0 indicates normal termination. - `int`

  throws: java.lang.IllegalThreadStateException - if the subprocess represented by this Process object has not yet terminated"
  ([^java.lang.Process this]
    (-> this (.exitValue))))

(defn destroy
  "Kills the subprocess. Whether the subprocess represented by this
   Process object is forcibly terminated or not is
   implementation dependent."
  ([^java.lang.Process this]
    (-> this (.destroy))))

(defn destroy-forcibly
  "Kills the subprocess. The subprocess represented by this
   Process object is forcibly terminated.

   The default implementation of this method invokes destroy()
   and so may not forcibly terminate the process. Concrete implementations
   of this class are strongly encouraged to override this method with a
   compliant implementation.  Invoking this method on Process
   objects returned by ProcessBuilder.start() and
   Runtime.exec(java.lang.String) will forcibly terminate the process.

   Note: The subprocess may not terminate immediately.
   i.e. isAlive() may return true for a brief period
   after destroyForcibly() is called. This method
   may be chained to waitFor() if needed.

  returns: the Process object representing the
           subprocess to be forcibly destroyed. - `java.lang.Process`"
  ([^java.lang.Process this]
    (-> this (.destroyForcibly))))

(defn alive?
  "Tests whether the subprocess represented by this Process is
   alive.

  returns: true if the subprocess represented by this
           Process object has not yet terminated. - `boolean`"
  ([^java.lang.Process this]
    (-> this (.isAlive))))

