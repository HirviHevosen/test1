INSERT INTO CLOUD_SCHEMA (ID, NAME, SCHEMA_DATA) VALUES
(10, 'google', '{"title":"A registration form","description":"A simple form example.","type":"object","required":["firstName","lastName"],"properties":{"firstName":{"type":"string","title":"First name","default":"Chuck"},"lastName":{"type":"string","title":"Last name"},"age":{"type":"integer","title":"Age"},"bio":{"type":"string","title":"Bio"},"password":{"type":"string","title":"Password","minLength":3},"telephone":{"type":"string","title":"Telephone","minLength":10}}}'),
(11, 'amazon', '{"title":"A registration form2","description":"A simple form example.","type":"object","required":["firstName","lastName"],"properties":{"firstName":{"type":"string","title":"First name","default":"Chuck"},"lastName":{"type":"string","title":"Last name"},"age":{"type":"integer","title":"Age"},"bio":{"type":"string","title":"Bio"},"password":{"type":"string","title":"Password","minLength":3},"telephone":{"type":"string","title":"Telephone","minLength":10}}}');
INSERT INTO FORM_SUBMISSION (ID, DATA, USER_ID, CLOUD_SCHEMA_ID) VALUES
(10, '{}', 'user', 10),
(11, '{}', 'user', 11);