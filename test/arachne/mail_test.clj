(ns arachne.mail-test
  (:require [clojure.test :refer [deftest is testing]]
            [arachne.mail :as mail]))


(deftest test-apache-commons-base-config
  (let [config (mail/->ApacheCommons "host" 122 "test-auth" 42)]
    (is (= (class config) arachne.mail.ApacheCommons))
    (is (= (:hostname config) "host"))
    (is (= (:smtp-port config) 122))
    (is (= (:authenticator config) "test-auth")
    (is (= (:tls config) 42)))))

(deftest test-apache-commons-combined-config
  (let [config (mail/->ApacheCommons "host" 122 "test-auth" 42)
        big (mail/sendmail! config "admin@rubygeek.com" "tacos" "yummy tacos")] 
    (is (= (:tls big) 42))
    (is (= (:hostname big) "host"))
    (is (= (:subject big) "tacos"))
    (is (= (:body big) "yummy tacos"))))
              

(deftest test-amazon-ses-mail-config
  (let [config (mail/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)]
    (is (= (class config) arachne.mail.SesMailer))
    (is (= (:provider config) "aws"))
    (is (= (:access-key config) "access-key-number"))
    (is (= (:secret-key config) "secret-key-number"))
    (is (= (:region config)) :aws-east1)))

(deftest test-amazon-ses-mail-combined-config
  (let [config (mail/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)
        big (mail/sendmail! config "admin@rubygeek.com" "tacos" "yummy tacos")]
    (is (= (:access-key big) "access-key-number"))
    (is (= (:region big) :aws-east1))
    (is (= (:subject big) "tacos"))
    (is (= (:body big) "yummy tacos"))))
