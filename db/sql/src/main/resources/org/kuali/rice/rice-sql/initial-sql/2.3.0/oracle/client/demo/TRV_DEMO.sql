--
-- Copyright 2005-2018 The Kuali Foundation
--
-- Licensed under the Educational Community License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
-- http://www.opensource.org/licenses/ecl2.php
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-----------------------------------------------------------------------------
-- TRV_ACCT_FO
-----------------------------------------------------------------------------
INSERT INTO TRV_ACCT_FO (ACCT_FO_ID,ACCT_FO_USER_NAME,VER_NBR)
  VALUES (1,'fred',0)
/
INSERT INTO TRV_ACCT_FO (ACCT_FO_ID,ACCT_FO_USER_NAME,VER_NBR)
  VALUES (2,'fran',0)
/
INSERT INTO TRV_ACCT_FO (ACCT_FO_ID,ACCT_FO_USER_NAME,VER_NBR)
  VALUES (3,'frank',0)
/

-----------------------------------------------------------------------------
-- TRV_ACCT
-----------------------------------------------------------------------------
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (1,'a1','a1',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (2,'a14','a14',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (2,'a2','a2',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,SUB_ACCT,SUB_ACCT_NAME,VER_NBR)
  VALUES (3,'a3','a3','a3-sub','sub-a3',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,SUB_ACCT,SUB_ACCT_NAME,VER_NBR)
  VALUES (2,'a6','a6','a6-sub','sub-a6',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (2,'a8','a8',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (2,'a9','a9',0)
/
INSERT INTO TRV_ACCT (ACCT_FO_ID,ACCT_NAME,ACCT_NUM,VER_NBR)
  VALUES (1,'a1','a1',0)
/

-----------------------------------------------------------------------------
-- TRAV_DOC_2_ACCOUNTS
-----------------------------------------------------------------------------
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2388')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2389')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2390')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2391')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2393')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2396')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2400')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2401')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2402')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2403')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2404')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2405')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2407')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2481')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2482')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2483')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2484')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2500')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2501')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2520')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2521')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2522')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2640')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2692')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2693')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2694')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2695')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a1','2701')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2123')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2387')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2388')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2389')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2390')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2391')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2393')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2396')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2400')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2401')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2402')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2403')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2404')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2405')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2407')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2481')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2482')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2483')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2500')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2501')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2520')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2521')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2522')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a2','2640')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a3','2387')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a3','2480')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2584')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2600')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2601')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2621')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2622')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a6','2623')
/
INSERT INTO TRAV_DOC_2_ACCOUNTS (ACCT_NUM,FDOC_NBR)
  VALUES ('a9','2480')
/

-----------------------------------------------------------------------------
-- TRV_ACCT_TYPE
-----------------------------------------------------------------------------
INSERT INTO TRV_ACCT_TYPE (ACCT_TYPE,ACCT_TYPE_NAME,VER_NBR)
  VALUES ('CAT','Clearing Account Type',0)
/
INSERT INTO TRV_ACCT_TYPE (ACCT_TYPE,ACCT_TYPE_NAME,VER_NBR)
  VALUES ('EAT','Expense Account Type',0)
/
INSERT INTO TRV_ACCT_TYPE (ACCT_TYPE,ACCT_TYPE_NAME,VER_NBR)
  VALUES ('IAT',' Income Account Type',0)
/

-----------------------------------------------------------------------------
-- TRV_ACCT_EXT
-----------------------------------------------------------------------------
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a1','IAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a14','CAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a2','EAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a3','IAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a6','CAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a8','EAT',0)
/
INSERT INTO TRV_ACCT_EXT (ACCT_NUM,ACCT_TYPE,VER_NBR)
  VALUES ('a9','CAT',0)
/

-----------------------------------------------------------------------------
-- TRV_DOC_2
-----------------------------------------------------------------------------
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('dre','2123','7BE537BD-643C-9F20-8A66-2FE1D398BADA','eb','TRT2','Eric',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2387','44C40877-A234-D6C5-1D3B-EFC98A11A8BF','here','TRT2','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2388','B2120A67-431C-1A9B-7B63-65DD544E910B','here','TRT2','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2389','86594949-89E0-8D63-AF50-B7E13D568B09','here','TRT1','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2390','9CFEB3AC-A4F5-4585-FCAB-0018F282364C','here','TRT1','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2391','5299F048-19E5-D56D-14EE-568EE3F85BA3','here','TRT1','nate',3)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2393','5D5E1CFD-EE46-73B4-700A-A9DD8E498EC2','here','TRT1','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2396','1D299A9B-C473-375A-69C4-C1E03CFBFC68','here','TRT2','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2400','3625336D-1D41-F979-B899-E8D7CF9E68AC','here','TRT1','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2401','D74C0680-F93C-7D41-62F3-E2C455AFC102','here','TRT2','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2402','55C56249-11AC-EE98-0256-5B71D5CAE40D','here','TRT1','sadf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('dsfgdsf','2403','BADEA3CA-19C7-BC2B-4E88-2A4777F11A55','dsffr','TRT1','asdf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('there','2404','38CC4CD9-A1F3-78DD-1E2C-35A81E989739','here','TRT2','nate',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('h','2405','A412B4FF-7D46-9212-05DA-B774F4370944','sdfq','TRT2','sdf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('dkl','2407','D4556EA2-EDA7-6BF9-1855-3040F14816CB','klj','TRT2','asdf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('3','2480','CA80CCD3-8C01-3D68-3830-A449AF528952','2','TRT2','1',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('lkj','2481','16422C26-6BEB-8AD7-0F51-9FEBADD37D0A','kj','TRT1','sdf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sdf','2482','56EA88B6-A372-1D39-831D-5B962962CA78','sadf','TRT2','dsf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('jkh','2483','C3C6C93C-5358-A267-F8AE-91E38BA39F05','jkh','TRT2','dsf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sdfs','2484','577CA8E5-1140-37BB-695E-0EB011E77D81','sadf','TRT1','dsf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('dfg','2500','E92080BD-902C-B68D-ECB4-C9D7DAFC4D86','dfgqdfg','TRT2','safd',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('saf','2501','1E53D48D-BFBA-FBF9-4B9F-1677CAD28B2E','sdf','TRT2','asdf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('df','2520','78085595-7BFC-A0CF-65E4-D1499166ECD8','dfgqdfg','TRT2','dsf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdf','2521','5CD9F7B7-07F7-0645-2F97-006E06B958A7','sadfsaf','TRT2','dsf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sdf','2522','5440866A-A30E-3860-F788-B45A4978C68A','sadf','TRT3','sdf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sdfdsfdsfsd','2584','397B1AD0-93E3-9827-52ED-A8D24B98C4F2','dsfdsfdsfds','TRT1','sadsadasdsa',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sadsadas','2600','502B559E-2A0E-0C58-3DBE-DF866D8CC503','asadasd','TRT1','sadsads',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdsadas','2601','3CDBACBF-4DEC-AE23-DC47-FCF79F2F42ED','asdsadsa','TRT1','asdsadsa',1)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdsadas','2621','956AC95F-7366-4241-215F-A910C2E5E4C6','asdsadsa','TRT1','asdsadsa',1)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdsadas','2622','132C00E3-B5FB-0527-BBF3-7129EF1158E1','asdsadsa','TRT1','asdsadsa',1)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdsadas','2623','CAB011C5-4090-A694-D2C5-49573918385B','asdsadsa','TRT1','asdsadsa',1)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('ettt','2640','39FC71CC-FB05-D612-D5B6-B3AAC6B26CF2','df','TRT1','asdf',4)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('sdaf','2692','BFBAF94B-E145-6303-045D-ABE304FFC7C8','asdf','TRT2','asdf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('daf','2693','70ADFFDB-0851-9BCF-013E-284A47A43A1A','asdf','TRT2','sdf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdasd','2694','7768CE1B-AF56-0711-E6CD-8744DA71A4D5','asd','TRT2','asdf',2)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdf','2695','BE8EC6F0-FA55-5532-883A-4553E3F289BB','asd','TRT2','ad',7)
/
INSERT INTO TRV_DOC_2 (DEST,FDOC_NBR,OBJ_ID,ORG,REQUEST_TRAV,TRAVELER,VER_NBR)
  VALUES ('asdf','2701','153C9F24-DDDC-ECFF-A3AE-D0A628939C23','asdf','TRT2','asdf',2)
/
