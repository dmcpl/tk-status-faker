(ns tk-status-faker.tk-status-faker-core-test
  (:require [clojure.test :refer :all]
            [tk-status-faker.tk-status-faker-core :refer :all]))

(deftest hello-test
  (testing "says hello to caller"
    (is (= "Hello, foo!" (hello "foo")))))
