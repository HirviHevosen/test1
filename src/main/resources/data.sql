INSERT INTO "COMPANY" (ID, NAME) VALUES
(6, 'Phillips Van Heusen Corp.'),
(7, 'Avaya Inc.'),
(8, 'Laboratory Corporation of America Holdings'),
(9, 'AutoZone, Inc.'),
(10, 'Linens ''n Things Inc.');
INSERT INTO "CONTACT" (ID, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID) VALUES
(11, 'eula.lane@jigrormo.ye', 'Eula', 'Lane', 8),
(12, 'barry.rodriquez@zun.mm', 'Barry', 'Rodriquez', 7),
(13, 'eugenia.selvi@capfad.vn', 'Eugenia', 'Selvi', 6),
(14, 'alejandro.miles@dec.bn', 'Alejandro', 'Miles', 10),
(15, 'cora.tesi@bivo.yt', 'Cora', 'Tesi', 6),
(16, 'marguerite.ishii@judbilo.gn', 'Marguerite', 'Ishii', 10),
(17, 'mildred.jacobs@joraf.wf', 'Mildred', 'Jacobs', 8),
(18, 'gene.goodman@kem.tl', 'Gene', 'Goodman', 8),
(19, 'lettie.bennett@odeter.bb', 'Lettie', 'Bennett', 6),
(20, 'mabel.leach@lisohuje.vi', 'Mabel', 'Leach', 10),
(21, 'jordan.miccinesi@duod.gy', 'Jordan', 'Miccinesi', 8),
(22, 'marie.parkes@nowufpus.ph', 'Marie', 'Parkes', 7),
(23, 'rose.gray@kagu.hr', 'Rose', 'Gray', 9),
(24, 'garrett.stokes@fef.bg', 'Garrett', 'Stokes', 9),
(25, 'barbara.matthieu@derwogi.jm', 'Barbara', 'Matthieu', 7),
(26, 'jean.rhodes@wehovuce.gu', 'Jean', 'Rhodes', 7),
(27, 'jack.romoli@zamum.bw', 'Jack', 'Romoli', 6),
(28, 'pearl.holden@dunebuh.cr', 'Pearl', 'Holden', 8),
(29, 'belle.montero@repiwid.si', 'Belle', 'Montero', 9),
(30, 'olive.molina@razuppa.ga', 'Olive', 'Molina', 6),
(31, 'minerva.todd@kulmenim.ad', 'Minerva', 'Todd', 9),
(32, 'bobby.pearson@ib.kg', 'Bobby', 'Pearson', 9),
(33, 'larry.ciappi@ba.lk', 'Larry', 'Ciappi', 10),
(34, 'ronnie.salucci@tohhij.lv', 'Ronnie', 'Salucci', 9),
(35, 'walter.grossi@tuvo.sa', 'Walter', 'Grossi', 9);
INSERT INTO "CONTACT" (ID, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID) VALUES
(36, 'frances.koopmans@foga.tw', 'Frances', 'Koopmans', 7),
(37, 'frances.fujimoto@uswuzzub.jp', 'Frances', 'Fujimoto', 6),
(38, 'olivia.vidal@hivwerip.vc', 'Olivia', 'Vidal', 9),
(39, 'edna.henry@gugusu.rw', 'Edna', 'Henry', 8),
(40, 'lydia.brun@zedekak.md', 'Lydia', 'Brun', 7),
(41, 'jay.blake@ral.mk', 'Jay', 'Blake', 10),
(42, 'isabel.serafini@turuhu.bh', 'Isabel', 'Serafini', 10),
(43, 'rebecca.carter@omjo.et', 'Rebecca', 'Carter', 8),
(44, 'maurice.fabbrini@rig.bh', 'Maurice', 'Fabbrini', 9),
(45, 'ollie.turnbull@sicewap.org', 'Ollie', 'Turnbull', 6),
(46, 'jerry.hopkins@fo.mh', 'Jerry', 'Hopkins', 9),
(47, 'nora.lyons@gegijap.na', 'Nora', 'Lyons', 10),
(48, 'anne.weis@kuvesa.pe', 'Anne', 'Weis', 7),
(49, 'louise.gauthier@lapahu.mt', 'Louise', 'Gauthier', 6),
(50, 'lloyd.fani@zev.ru', 'Lloyd', 'Fani', 8),
(51, 'maud.dunn@nabeaga.ni', 'Maud', 'Dunn', 6),
(52, 'henry.gigli@kaot.ps', 'Henry', 'Gigli', 6),
(53, 'virgie.werner@tawuctuj.cf', 'Virgie', 'Werner', 10),
(54, 'gregory.cozzi@eh.ru', 'Gregory', 'Cozzi', 8),
(55, 'lucinda.gil@fajjusuz.kr', 'Lucinda', 'Gil', 7),
(56, 'gertrude.verbeek@pave.cc', 'Gertrude', 'Verbeek', 6),
(57, 'mattie.graham@ispaviw.gt', 'Mattie', 'Graham', 7),
(58, 'bryan.shaw@ha.ee', 'Bryan', 'Shaw', 9),
(59, 'essie.adams@iliat.cw', 'Essie', 'Adams', 8),
(60, 'gary.osborne@do.ga', 'Gary', 'Osborne', 7);



INSERT INTO CLOUD_SCHEMA (ID, NAME, SCHEMA_DATA) VALUES
(10, 'google', '{"title":"A registration form","description":"A simple form example.","type":"object","required":["firstName","lastName"],"properties":{"firstName":{"type":"string","title":"First name","default":"Chuck"},"lastName":{"type":"string","title":"Last name"},"age":{"type":"integer","title":"Age"},"bio":{"type":"string","title":"Bio"},"password":{"type":"string","title":"Password","minLength":3},"telephone":{"type":"string","title":"Telephone","minLength":10}}}'),
(11, 'amazon', '{"title":"A registration form2","description":"A simple form example.","type":"object","required":["firstName","lastName"],"properties":{"firstName":{"type":"string","title":"First name","default":"Chuck"},"lastName":{"type":"string","title":"Last name"},"age":{"type":"integer","title":"Age"},"bio":{"type":"string","title":"Bio"},"password":{"type":"string","title":"Password","minLength":3},"telephone":{"type":"string","title":"Telephone","minLength":10}}}');
INSERT INTO FORM_SUBMISSION (ID, DATA, USER_ID, CLOUD_SCHEMA_ID) VALUES
(10, '{}', 'user', 10),
(11, '{}', 'user', 11);