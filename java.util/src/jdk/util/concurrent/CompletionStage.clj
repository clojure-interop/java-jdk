(ns jdk.util.concurrent.CompletionStage
  "A stage of a possibly asynchronous computation, that performs an
  action or computes a value when another CompletionStage completes.
  A stage completes upon termination of its computation, but this may
  in turn trigger other dependent stages.  The functionality defined
  in this interface takes only a few basic forms, which expand out to
  a larger set of methods to capture a range of usage styles:

  The computation performed by a stage may be expressed as a
  Function, Consumer, or Runnable (using methods with names including
  apply, accept, or run, respectively)
  depending on whether it requires arguments and/or produces results.
  For example, stage.thenApply(x -> square(x)).thenAccept(x ->
  System.out.print(x)).thenRun(() -> System.out.println()). An
  additional form (compose) applies functions of stages
  themselves, rather than their results.

   One stage's execution may be triggered by completion of a
  single stage, or both of two stages, or either of two stages.
  Dependencies on a single stage are arranged using methods with
  prefix then. Those triggered by completion of
  both of two stages may combine their results or
  effects, using correspondingly named methods. Those triggered by
  either of two stages make no guarantees about which of the
  results or effects are used for the dependent stage's
  computation.

   Dependencies among stages control the triggering of
  computations, but do not otherwise guarantee any particular
  ordering. Additionally, execution of a new stage's computations may
  be arranged in any of three ways: default execution, default
  asynchronous execution (using methods with suffix async
  that employ the stage's default asynchronous execution facility),
  or custom (via a supplied Executor).  The execution
  properties of default and async modes are specified by
  CompletionStage implementations, not this interface. Methods with
  explicit Executor arguments may have arbitrary execution
  properties, and might not even support concurrent execution, but
  are arranged for processing in a way that accommodates asynchrony.

   Two method forms support processing whether the triggering
  stage completed normally or exceptionally: Method whenComplete allows injection of an action
  regardless of outcome, otherwise preserving the outcome in its
  completion. Method handle additionally allows the
  stage to compute a replacement result that may enable further
  processing by other dependent stages.  In all other cases, if a
  stage's computation terminates abruptly with an (unchecked)
  exception or error, then all dependent stages requiring its
  completion complete exceptionally as well, with a CompletionException holding the exception as its cause.  If a
  stage is dependent on both of two stages, and both
  complete exceptionally, then the CompletionException may correspond
  to either one of these exceptions.  If a stage is dependent on
  either of two others, and only one of them completes
  exceptionally, no guarantees are made about whether the dependent
  stage completes normally or exceptionally. In the case of method
  whenComplete, when the supplied action itself encounters an
  exception, then the stage exceptionally completes with this
  exception if not already completed exceptionally.



  All methods adhere to the above triggering, execution, and
  exceptional completion specifications (which are not repeated in
  individual method specifications). Additionally, while arguments
  used to pass a completion result (that is, for parameters of type
  T) for methods accepting them may be null, passing a null
  value for any other parameter will result in a NullPointerException being thrown.

  This interface does not define methods for initially creating,
  forcibly completing normally or exceptionally, probing completion
  status or results, or awaiting completion of a stage.
  Implementations of CompletionStage may provide means of achieving
  such effects, as appropriate.  Method toCompletableFuture()
  enables interoperability among different implementations of this
  interface by providing a common conversion type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CompletionStage]))

(defn run-after-either-async
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, executes the given action
   using the supplied executor.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.runAfterEitherAsync other action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterEitherAsync other action))))

(defn handle
  "Returns a new CompletionStage that, when this stage completes
   either normally or exceptionally, is executed with this stage's
   result and exception as arguments to the supplied function.

   When this stage is complete, the given function is invoked
   with the result (or null if none) and the exception (or
   null if none) of this stage as arguments, and the
   function's result is used to complete the returned stage.

  fn - the function to use to compute the value of the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this fn]
    (-> this (.handle fn))))

(defn accept-either
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, is executed with the
   corresponding result as argument to the supplied action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `CompletionStage.T>`
  action - the action to perform before completing the returned CompletionStage - `CompletionStage.T>`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T> action]
    (-> this (.acceptEither other action))))

(defn run-after-both
  "Returns a new CompletionStage that, when this and the other
   given stage both complete normally, executes the given action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterBoth other action))))

(defn when-complete-async
  "Returns a new CompletionStage with the same result or exception as
   this stage, that executes the given action using the supplied
   Executor when this stage completes.

   When this stage is complete, the given action is invoked with the
   result (or null if none) and the exception (or null
   if none) of this stage as arguments.  The returned stage is completed
   when the action returns.  If the supplied action itself encounters an
   exception, then the returned stage exceptionally completes with this
   exception unless this stage also completed exceptionally.

  action - the action to perform - `java.lang.Throwable>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<CompletionStage.T>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Throwable> action ^java.util.concurrent.Executor executor]
    (-> this (.whenCompleteAsync action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Throwable> action]
    (-> this (.whenCompleteAsync action))))

(defn then-accept-async
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed using the supplied Executor, with this
   stage's result as the argument to the supplied action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  action - the action to perform before completing the returned CompletionStage - `CompletionStage.T>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> action ^java.util.concurrent.Executor executor]
    (-> this (.thenAcceptAsync action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> action]
    (-> this (.thenAcceptAsync action))))

(defn to-completable-future
  "Returns a CompletableFuture maintaining the same
   completion properties as this stage. If this stage is already a
   CompletableFuture, this method may return this stage itself.
   Otherwise, invocation of this method may be equivalent in
   effect to thenApply(x -> x), but returning an instance
   of type CompletableFuture. A CompletionStage
   implementation that does not choose to interoperate with others
   may throw UnsupportedOperationException.

  returns: the CompletableFuture - `java.util.concurrent.CompletableFuture<CompletionStage.T>`

  throws: java.lang.UnsupportedOperationException - if this implementation does not interoperate with CompletableFuture"
  (^java.util.concurrent.CompletableFuture [^java.util.concurrent.CompletionStage this]
    (-> this (.toCompletableFuture))))

(defn then-accept-both
  "Returns a new CompletionStage that, when this and the other
   given stage both complete normally, is executed with the two
   results as arguments to the supplied action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `U>`
  action - the action to perform before completing the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<java.lang.Void>`"
  ([^java.util.concurrent.CompletionStage this other action]
    (-> this (.thenAcceptBoth other action))))

(defn then-run-async
  "Returns a new CompletionStage that, when this stage completes
   normally, executes the given action using the supplied Executor.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.thenRunAsync action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Runnable action]
    (-> this (.thenRunAsync action))))

(defn apply-to-either
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, is executed with the
   corresponding result as argument to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `CompletionStage.T>`
  fn - the function to use to compute the value of the returned CompletionStage - `CompletionStage.T,U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T,U> fn]
    (-> this (.applyToEither other fn))))

(defn then-apply
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed with this stage's result as the argument
   to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  fn - the function to use to compute the value of the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this fn]
    (-> this (.thenApply fn))))

(defn run-after-both-async
  "Returns a new CompletionStage that, when this and the other
   given stage complete normally, executes the given action using
   the supplied executor.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.runAfterBothAsync other action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterBothAsync other action))))

(defn accept-either-async
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, is executed using the
   supplied executor, with the corresponding result as argument to
   the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `CompletionStage.T>`
  action - the action to perform before completing the returned CompletionStage - `CompletionStage.T>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T> action ^java.util.concurrent.Executor executor]
    (-> this (.acceptEitherAsync other action executor)))
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T> action]
    (-> this (.acceptEitherAsync other action))))

(defn exceptionally
  "Returns a new CompletionStage that, when this stage completes
   exceptionally, is executed with this stage's exception as the
   argument to the supplied function.  Otherwise, if this stage
   completes normally, then the returned stage also completes
   normally with the same value.

  fn - the function to use to compute the value of the returned CompletionStage if this CompletionStage completed exceptionally - `CompletionStage.T>`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<CompletionStage.T>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> fn]
    (-> this (.exceptionally fn))))

(defn apply-to-either-async
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, is executed using the
   supplied executor, with the corresponding result as argument to
   the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `CompletionStage.T>`
  fn - the function to use to compute the value of the returned CompletionStage - `CompletionStage.T,U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T,U> fn ^java.util.concurrent.Executor executor]
    (-> this (.applyToEitherAsync other fn executor)))
  ([^java.util.concurrent.CompletionStage this ^CompletionStage.T> other ^CompletionStage.T,U> fn]
    (-> this (.applyToEitherAsync other fn))))

(defn when-complete
  "Returns a new CompletionStage with the same result or exception as
   this stage, that executes the given action when this stage completes.

   When this stage is complete, the given action is invoked with the
   result (or null if none) and the exception (or null
   if none) of this stage as arguments.  The returned stage is completed
   when the action returns.  If the supplied action itself encounters an
   exception, then the returned stage exceptionally completes with this
   exception unless this stage also completed exceptionally.

  action - the action to perform - `java.lang.Throwable>`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<CompletionStage.T>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Throwable> action]
    (-> this (.whenComplete action))))

(defn run-after-either
  "Returns a new CompletionStage that, when either this or the
   other given stage complete normally, executes the given action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterEither other action))))

(defn then-accept
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed with this stage's result as the argument
   to the supplied action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  action - the action to perform before completing the returned CompletionStage - `CompletionStage.T>`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^CompletionStage.T> action]
    (-> this (.thenAccept action))))

(defn then-compose-async
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed using the supplied Executor, with this
   stage's result as the argument to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  fn - the function returning a new CompletionStage - `java.util.concurrent.CompletionStage<U>>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage> fn ^java.util.concurrent.Executor executor]
    (-> this (.thenComposeAsync fn executor)))
  ([^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage> fn]
    (-> this (.thenComposeAsync fn))))

(defn then-combine-async
  "Returns a new CompletionStage that, when this and the other
   given stage complete normally, is executed using the supplied
   executor, with the two results as arguments to the supplied
   function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `U>`
  fn - the function to use to compute the value of the returned CompletionStage - `V>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U,V> java.util.concurrent.CompletionStage<V>`"
  ([^java.util.concurrent.CompletionStage this other fn ^java.util.concurrent.Executor executor]
    (-> this (.thenCombineAsync other fn executor)))
  ([^java.util.concurrent.CompletionStage this other fn]
    (-> this (.thenCombineAsync other fn))))

(defn then-accept-both-async
  "Returns a new CompletionStage that, when this and the other
   given stage complete normally, is executed using the supplied
   executor, with the two results as arguments to the supplied
   function.

  other - the other CompletionStage - `U>`
  action - the action to perform before completing the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<java.lang.Void>`"
  ([^java.util.concurrent.CompletionStage this other action ^java.util.concurrent.Executor executor]
    (-> this (.thenAcceptBothAsync other action executor)))
  ([^java.util.concurrent.CompletionStage this other action]
    (-> this (.thenAcceptBothAsync other action))))

(defn then-run
  "Returns a new CompletionStage that, when this stage completes
   normally, executes the given action.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletionStage<java.lang.Void>`"
  (^java.util.concurrent.CompletionStage [^java.util.concurrent.CompletionStage this ^java.lang.Runnable action]
    (-> this (.thenRun action))))

(defn handle-async
  "Returns a new CompletionStage that, when this stage completes
   either normally or exceptionally, is executed using the
   supplied executor, with this stage's result and exception as
   arguments to the supplied function.

   When this stage is complete, the given function is invoked
   with the result (or null if none) and the exception (or
   null if none) of this stage as arguments, and the
   function's result is used to complete the returned stage.

  fn - the function to use to compute the value of the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this fn ^java.util.concurrent.Executor executor]
    (-> this (.handleAsync fn executor)))
  ([^java.util.concurrent.CompletionStage this fn]
    (-> this (.handleAsync fn))))

(defn then-compose
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed with this stage as the argument
   to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  fn - the function returning a new CompletionStage - `java.util.concurrent.CompletionStage<U>>`

  returns: the CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this ^java.util.concurrent.CompletionStage> fn]
    (-> this (.thenCompose fn))))

(defn then-apply-async
  "Returns a new CompletionStage that, when this stage completes
   normally, is executed using the supplied Executor, with this
   stage's result as the argument to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  fn - the function to use to compute the value of the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletionStage<U>`"
  ([^java.util.concurrent.CompletionStage this fn ^java.util.concurrent.Executor executor]
    (-> this (.thenApplyAsync fn executor)))
  ([^java.util.concurrent.CompletionStage this fn]
    (-> this (.thenApplyAsync fn))))

(defn then-combine
  "Returns a new CompletionStage that, when this and the other
   given stage both complete normally, is executed with the two
   results as arguments to the supplied function.

   See the CompletionStage documentation for rules
   covering exceptional completion.

  other - the other CompletionStage - `U>`
  fn - the function to use to compute the value of the returned CompletionStage - `V>`

  returns: the new CompletionStage - `<U,V> java.util.concurrent.CompletionStage<V>`"
  ([^java.util.concurrent.CompletionStage this other fn]
    (-> this (.thenCombine other fn))))

