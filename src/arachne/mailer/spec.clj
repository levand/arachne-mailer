(ns arachne.mailer.spec
  (:require [clojure.spec :as s]))

(def Mailer (s/cat :from string? :to string? :body string?))
