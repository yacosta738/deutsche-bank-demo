-- Date: 2023-02-27
-- Postgres Table Definition
CREATE TABLE NACE (
                      id SERIAL NOT NULL,
                      level INT NOT NULL,
                      code VARCHAR(10) NOT NULL,
                      parent VARCHAR(10) NOT NULL,
                      description TEXT NOT NULL,
                      includes TEXT NOT NULL,
                      also_includes VARCHAR(255) NOT NULL,
                      rulings VARCHAR(255) NOT NULL,
                      excludes TEXT NOT NULL,
                      reference VARCHAR(255) NOT NULL,
                      PRIMARY KEY (id)
);

-- Insert Demo Data
INSERT INTO NACE (level, code, parent, description, includes, also_includes, rulings, excludes, reference)
VALUES (1, 'A', '', 'AGRICULTURE, FORESTRY AND FISHING', 'This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.', '', '', 'A', '');
INSERT INTO NACE (level, code, parent, description, includes, also_includes, rulings, excludes, reference)
VALUES (2, '01', 'A', 'Crop and animal production, hunting and related service activities', 'This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture, the growing of genetically modified crops and the raising of genetically modified animals. This division includes growing of crops in open fields as well in greenhouses. Group 01.5 (Mixed farming) breaks with the usual principles for identifying main activity. It accepts that many agricultural holdings have reasonably balanced crop and animal production, and that it would be arbitrary to classify them in one category or the other.', 'This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities.', '', 'Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products)), beyond that needed to prepare them for the primary markets. The preparation of products for the primary markets is included here. The division excludes field construction (e.g. agricultural land terracing, drainage, preparing rice paddies etc.) classified in section F (Construction) and buyers and cooperative associations engaged in the marketing of farm products classified in section G. Also excluded is the landscape care and maintenance, which is classified in class 81.30.', '01');
INSERT INTO NACE (level, code, parent, description, includes, also_includes, rulings, excludes, reference)
VALUES (3, '01.1', '01', 'Growing of non-perennial crops', 'This group includes the growing of non-perennial crops, i.e. plants that do not last for more than two growing seasons. Included is the growing of these plants for the purpose of seed production.', '', '', '011', '011');
INSERT INTO NACE (level, code, parent, description, includes, also_includes, rulings, excludes, reference)
VALUES (4, '01.11', '01.1', 'Growing of cereals (except rice), leguminous crops and oil seeds', 'This class includes all forms of growing of cereals, leguminous crops and oil seeds in open fields. The growing of these crops is often combined within agricultural units. This class includes: - growing of cereals such as: . wheat . grain maize . sorghum . barley . rye . oats . millets . other cereals n.e.c. - growing of leguminous crops such as: . beans . broad beans . chick peas . cow peas . lentils . lupines . peas . pigeon peas . other leguminous crops - growing of oil seeds such as: . soya beans . groundnuts . castor bean . linseed . mustard seed . niger seed . rapeseed . safflower seed . sesame seed . sunflower seed . other oil seeds', '', '', 'This class excludes: - growing of rice, see 01.12 - growing of sweet corn, see 01.13 - growing of maize for fodder, see 01.19 - growing of oleaginous fruits, see 01.26', '0111');
