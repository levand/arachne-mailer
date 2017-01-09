(ns arachne-mail.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [arachne-mail.core :as core]))


(deftest test-apache-commons-base-config
  (let [config (core/->ApacheCommons "host" 122 "test-auth" 42)]
    (is (= (class config) arachne_mail.core.ApacheCommons))
    (is (= (:hostname config) "host"))
    (is (= (:smtp-port config) 122))
    (is (= (:authenticator config) "test-auth")
    (is (= (:tls config) 42)))))

(deftest test-apache-commons-combined-config
  (let [config (core/->ApacheCommons "host" 122 "test-auth" 42)
        big (core/defaults config "admin@rubygeek.com" "tacos" "yummy tacos")] 
    (is (= (:tls big) 42))
    (is (= (:hostname big) "host"))
    (is (= (:subject big) "tacos"))
    (is (= (:body big) "yummy tacos"))))
              

(deftest test-amazon-ses-mail-config
  (let [config (core/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)]
    (is (= (class config) arachne_mail.core.SesMailer))
    (is (= (:provider config) "aws"))
    (is (= (:access-key config) "access-key-number"))
    (is (= (:secret-key config) "secret-key-number"))
    (is (= (:region config)) :aws-east1)))

(deftest test-amazon-ses-mail-combined-config
  (let [config (core/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)
        big (core/defaults config "admin@rubygeek.com" "tacos" "yummy tacos")]
    (is (= (:access-key big) "access-key-number"))
    (is (= (:region big) :aws-east1))
    (is (= (:subject big) "tacos"))
    (is (= (:body big) "yummy tacos"))))
