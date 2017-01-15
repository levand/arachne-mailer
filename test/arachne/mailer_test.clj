(ns arachne.mailer-test
  (:require [clojure.test :refer [deftest is testing]]
            [arachne.core :as core]
            [arachne.mailer :as mailer]
            [arachne.mailer.dsl :as mailer-dsl]
            [arachne.core.dsl :as core-dsl]
            [com.stuartsierra.component :as c]))

(defn apache-cfg []
  (mailer-dsl/apache-mailer "localhost" "32" "user/pass" "100"))

(deftest apache-config-test
  (let [cfg (core/build-config [:arachne-mailer] '(arachne.mailer-test/apache-cfg))
        rt (core/runtime cfg :test/rt)
        rt (c/start rt)]
    (is (= "blah" (class rt)))))


