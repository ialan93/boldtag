import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import random.GenerateWords as GenerateWords

if(GlobalVariable.moduleAccess == false){
	WebUI.callTestCase(findTestCase('Client Portal/Profile/Sub Test Case/search profile'), [('searchAction') : searchAction, ('profileName') : profileName
		, ('filterSearch') : filterSearch], FailureHandling.STOP_ON_FAILURE)
}

def randomWords = CustomKeywords.'random.GenerateWords.randomString'(5)

if(newprofileName.trim() != ''){
	if(randomWordAction.toLowerCase() == 'true'){
		newprofileName = (newprofileName + randomWords)
		println(newprofileName)
	}
}
//newprofileName = (newprofileName + randomWords)

WebUI.callTestCase(findTestCase('Client Portal/Profile/Sub Test Case/create profile'), [('profileName') : newprofileName
        , ('updateAction') : updateAction], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Client Portal/Profile/Sub Test Case/verify profile'), [('profileName') : newprofileName, ('filterSearch') : filterSearch], FailureHandling.STOP_ON_FAILURE)

