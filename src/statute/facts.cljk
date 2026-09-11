(ns statute.facts
  "General-law compliance catalog for Kenya (KEN) -- extends this
  repo's existing `marketentry.facts` (narrow public-procurement
  scope) with a second, orthogonal catalog of statutes a company
  generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/-chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Reuses this session's already-verified capital/organization data
  from cloud-itonami-municipality-ken-nairobi (Kenya Q114, Nairobi
  Q3870, no P36 historical-capital bug).

  Both entries directly WebFetch-verified against new.kenyalaw.org
  (Kenya Law, the National Council for Law Reporting's official legal
  database -- the same domain used successfully for Nairobi's Finance
  Act 2023 one tick earlier; the OLD kenyalaw.org domain returned HTTP
  403 for Nairobi-level documents in that same tick, but the NEW
  domain worked cleanly here too). The Data Protection Act entry
  corrects a WebSearch-synthesis date confusion: the synthesized
  answer conflated the 8 November 2019 assent date with the 25
  November 2019 COMMENCEMENT date -- the primary source page states
  both explicitly and distinctly ('Assented to on 8 November 2019' /
  'Commenced on 25 November 2019'), and the assent date is used here
  per this project's convention of citing enactment/assent dates.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries."
  {"KEN"
   [{:statute/id "ken.companies-act-17-2015"
     :statute/title "Companies Act"
     :statute/jurisdiction "KEN"
     :statute/kind :law
     :statute/law-number "No. 17 of 2015 (Cap. 486)"
     :statute/url "https://new.kenyalaw.org/akn/ke/act/2015/17/eng@2024-12-27"
     :statute/url-provenance :official-kenyalaw-org
     :statute/enacted-date "2015-09-11"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "ken.data-protection-act-24-2019"
     :statute/title "Data Protection Act"
     :statute/jurisdiction "KEN"
     :statute/kind :law
     :statute/law-number "No. 24 of 2019 (Cap. 411C)"
     :statute/url "https://new.kenyalaw.org/akn/ke/act/2019/24/eng@2022-12-31"
     :statute/url-provenance :official-kenyalaw-org
     :statute/enacted-date "2019-11-08"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-ken statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "KEN")) " KEN statutes seeded with "
                 "official new.kenyalaw.org citations. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
