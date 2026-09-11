(ns culture.facts
  "Country-level regional-culture catalog for Kenya (KEN) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"KEN"
   [{:culture/id "ken.dish.nyama-choma"
     :culture/name "Nyama choma"
     :culture/country "KEN"
     :culture/kind :dish
     :culture/summary "Grilled or barbecued goat or cattle meat, considered the national dish of Kenya and Tanzania."
     :culture/url "https://en.wikipedia.org/wiki/Nyama_choma"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.dish.ugali"
     :culture/name "Ugali"
     :culture/country "KEN"
     :culture/kind :dish
     :culture/summary "Corn meal made from maize flour, a staple starch eaten across East Africa including Kenya, where it is typically served with vegetables or meat."
     :culture/url "https://en.wikipedia.org/wiki/Ugali"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.dish.sukuma-wiki"
     :culture/name "Sukuma wiki"
     :culture/country "KEN"
     :culture/kind :dish
     :culture/summary "East African dish of collard greens (sukuma) cooked with onions and spices, a staple in Kenya typically served alongside ugali."
     :culture/url "https://en.wikipedia.org/wiki/Sukuma_wiki"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.dish.githeri"
     :culture/name "Githeri"
     :culture/name-local "Gĩtheri"
     :culture/country "KEN"
     :culture/kind :dish
     :culture/summary "Traditional Kenyan meal of maize kernels and legumes (primarily beans) mixed and boiled together, a staple food for several Kenyan ethnic groups."
     :culture/url "https://en.wikipedia.org/wiki/Githeri"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.product.kenyan-tea"
     :culture/name "Kenyan tea"
     :culture/country "KEN"
     :culture/kind :product
     :culture/summary "Tea is a major Kenyan export crop; in 2018 Kenya was the world's largest exporter and producer of black tea, and it ranks third globally in tea exports after China and India."
     :culture/url "https://en.wikipedia.org/wiki/Tea_production_in_Kenya"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.product.kenyan-coffee"
     :culture/name "Kenyan coffee"
     :culture/country "KEN"
     :culture/kind :product
     :culture/summary "Kenya produces primarily Arabica coffee of the 'Colombia mild' classification; high-grade Kenyan coffee is among the most sought-after in the world for its intense flavor, full body and pleasant aroma."
     :culture/url "https://en.wikipedia.org/wiki/Coffee_production_in_Kenya"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.craft.kiondo"
     :culture/name "Kiondo"
     :culture/country "KEN"
     :culture/kind :craft
     :culture/summary "Handwoven bag made from indigenous vegetable twine with leather trimmings, originating from the Taita, Kikuyu and Kamba communities of Kenya."
     :culture/url "https://en.wikipedia.org/wiki/Kiondo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.heritage.lamu-old-town"
     :culture/name "Lamu Old Town"
     :culture/country "KEN"
     :culture/kind :heritage
     :culture/summary "The oldest and best-preserved Swahili settlement in East Africa, designated a UNESCO World Heritage Site in 2001."
     :culture/url "https://en.wikipedia.org/wiki/Lamu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ken.heritage.fort-jesus"
     :culture/name "Fort Jesus"
     :culture/country "KEN"
     :culture/kind :heritage
     :culture/summary "Fort on Mombasa Island, Kenya, built between 1593 and 1596 and declared a UNESCO World Heritage Site in 2011."
     :culture/url "https://en.wikipedia.org/wiki/Fort_Jesus"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-ken culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "KEN"))
                 " KEN entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
