(ns arachne.mailer-test
  (:require [clojure.test :refer [deftest is testing]]
            [arachne.mailer :as mailer]))


(deftest test-apache-commons-base-config
  (let [mailer (mailer/->ApacheCommons "host" 122 "test-auth" 42)]
    (is (= (class mailer) arachne.mailer.ApacheCommons))
    (is (= (:hostname mailer) "host"))
    (is (= (:smtp-port mailer) 122))
    (is (= (:authenticator mailer) "test-auth")
    (is (= (:tls mailer) 42)))))

(deftest test-apache-commons-combined-config
  (let [mailer (-> (mailer/->ApacheCommons "host" 122 "test-auth" 42)
                   (mailer/sendmail! "admin@rubygeek.com" "tacos" "yummy tacos"))] 
    (is (= (:tls mailer) 42))
    (is (= (:hostname mailer) "host"))
    (is (= (:subject mailer) "tacos"))
    (is (= (:body mailer) "yummy tacos"))))
              

(deftest test-amazon-ses-mail-config
  (let [mailer (mailer/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)]
    (is (= (class mailer) arachne.mailer.SesMailer))
    (is (= (:provider mailer) "aws"))
    (is (= (:access-key mailer) "access-key-number"))
    (is (= (:secret-key mailer) "secret-key-number"))
    (is (= (:region mailer) :aws-east1))))

(deftest test-amazon-ses-mail-combined-config
  (let [mailer (-> (mailer/->SesMailer "aws" "access-key-number" "secret-key-number" :aws-east1)
                   (mailer/sendmail! "admin@rubygeek.com" "tacos" "yummy tacos"))]
    (is (= (:access-key mailer) "access-key-number"))
    (is (= (:region mailer) :aws-east1))
    (is (= (:subject mailer) "tacos"))
    (is (= (:body mailer) "yummy tacos"))))
