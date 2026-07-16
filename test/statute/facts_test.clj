(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest ken-has-spec-basis
  (let [sb (facts/spec-basis "KEN")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://new.kenyalaw.org/") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["KEN" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["ken.data-protection-act-24-2019"]
         (mapv :statute/id (facts/by-topic "KEN" :privacy))))
  (is (empty? (facts/by-topic "KEN" :labor)))
  (is (empty? (facts/by-topic "ATL" :privacy))))
