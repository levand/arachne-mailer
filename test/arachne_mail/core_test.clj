(ns arachne-mail.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [arachne-mail.core :as core]))

(deftest test-hello
  (is (= "hello world" (core/hello))))

(deftest test-apache-commons-config
  (let [config (core/->ApacheCommons "host" 122 "test-auth" 42)]
    (is (= (class config) arachne_mail.core.ApacheCommons))
    (is (= (:hostname config) "host"))
    (is (= (:smtp-port config) 122))
    (is (= (:authenticator config) "test-auth")
    (is (= (:tls config) 42)))

    (is (= (core/defaults config "admin@rubygeek.com" "tacos" "yummy tacos")
           "testing sending mail from: admin@rubygeek.com with subject: tacos")))

  (deftest test-amazon-ses-mail-config
    (let [config (core/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)]
      (is (= (class config) arachne_mail.core.SesMailer))
      (is (= (:provider config) "aws"))
      (is (= (:access-key config) "access-key-number"))
      (is (= (:secret-key config) "secret-key-number"))
      (is (= (:region config)) :aws-east1)

      (is (= (core/defaults config "admin@rubygeek.com" "tacos" "yummy tacos")
             "testing sending mail from: admin@rubygeek.com with subject: tacos")))))
