(ns jdk.util.concurrent.RecursiveTask
  "A recursive result-bearing ForkJoinTask.

  For a classic example, here is a task computing Fibonacci numbers:



  class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    Fibonacci(int n) { this.n = n; }
    Integer compute() {
      if (n <= 1)
        return n;
      Fibonacci f1 = new Fibonacci(n - 1);
      f1.fork();
      Fibonacci f2 = new Fibonacci(n - 2);
      return f2.compute()  f1.join();
    }
  }

  However, besides being a dumb way to compute Fibonacci functions
  (there is a simple fast linear algorithm that you'd use in
  practice), this is likely to perform poorly because the smallest
  subtasks are too small to be worthwhile splitting up. Instead, as
  is the case for nearly all fork/join applications, you'd pick some
  minimum granularity size (for example 10 here) for which you always
  sequentially solve rather than subdividing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent RecursiveTask]))

(defn ->recursive-task
  "Constructor."
  (^RecursiveTask []
    (new RecursiveTask )))

(defn get-raw-result
  "Description copied from class: ForkJoinTask

  returns: the result, or null if not completed - `V`"
  ([^RecursiveTask this]
    (-> this (.getRawResult))))

