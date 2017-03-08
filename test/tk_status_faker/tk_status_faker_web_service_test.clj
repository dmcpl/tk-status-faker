(ns tk-status-faker.tk-status-faker-web-service-test
  (:require [clojure.test :refer :all]
            [puppetlabs.trapperkeeper.app :as app]
            [puppetlabs.trapperkeeper.testutils.bootstrap :refer [with-app-with-config]]
            [puppetlabs.trapperkeeper.services.webserver.jetty9-service :refer [jetty9-service]]
            [puppetlabs.trapperkeeper.services.webrouting.webrouting-service :refer [webrouting-service]]
            [clj-http.client :as client]
            [tk-status-faker.tk-status-faker-service :as svc]
            [tk-status-faker.tk-status-faker-service :as web-svc]))

(deftest hello-web-service-test
  (testing "says hello to caller"
    (with-app-with-config app
      [svc/hello-service
       web-svc/hello-web-service
       jetty9-service
       webrouting-service]
      {:webserver {:host "localhost"
                   :port 8080}
       :web-router-service {
         :tk-status-faker.tk-status-faker-web-service/hello-web-service "/hello"}}
      (let [resp (client/get "http://localhost:8080/hello/foo" {:as :text})]
        (is (= "Hello, foo!" (:body resp)))))))
