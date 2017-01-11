(ns arachne.mailer.dsl 
  (:require [arachne.core.config :as cfg]
            [arachne.core.config.init :as script :refer [defdsl]]
            [arachne.error :as e :refer [error deferror]]
            [clojure.spec :as s]))


