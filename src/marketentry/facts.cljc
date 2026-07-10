(ns marketentry.facts "Kenya market-entry catalog.")
(def catalog
  {"KEN" {:name "Kenya"
          :owner-authority "PPRA / IFMIS e-Procurement"
          :legal-basis "Public Procurement and Asset Disposal Act"
          :national-spec "IFMIS / supplier registration + KRA PIN"
          :provenance "https://www.ppra.go.ke/"
          :required-evidence ["KRA PIN record" "IFMIS/supplier registration record" "Business registration extract" "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / PPRA"
          :rep-legal-basis "Kenyan legal entity registration typically required for public awards"
          :rep-provenance "https://www.ppra.go.ke/"
          :corporate-number-owner-authority "BRS / KRA"
          :corporate-number-legal-basis "Company registration / PIN"
          :corporate-number-provenance "https://brs.go.ke/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR" :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "ZAF" {:name "South Africa" :owner-authority "CSD/eTender" :legal-basis "PFMA" :national-spec "CSD" :provenance "https://www.etenders.gov.za/"
          :required-evidence ["CSD registration" "CIPC record" "SARS tax clearance" "Authorized-representative record"]}
   "NGA" {:name "Nigeria" :owner-authority "BPP/NOCOPO" :legal-basis "PPA 2007" :national-spec "NOCOPO" :provenance "https://www.bpp.gov.ng/"
          :required-evidence ["CAC registration" "NOCOPO registration" "TIN record" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
