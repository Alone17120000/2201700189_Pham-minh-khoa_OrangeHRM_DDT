import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com')

WebUI.setText(findTestObject('txt_Username'), username)
WebUI.setText(findTestObject('txt_Password'), password)
WebUI.click(findTestObject('btn_Login'))

if (expectedResult == 'Login Success') {
    WebUI.verifyElementPresent(findTestObject('lbl_Dashboard'), 5)
    WebUI.click(findTestObject('lnk_Logout'))
} else if (expectedResult == 'Invalid credentials') {
    WebUI.verifyElementPresent(findTestObject('lbl_Error'), 5)
} else if (expectedResult == 'Username cannot be empty') {
    WebUI.verifyElementPresent(findTestObject('lbl_ErrorUsername'), 5)
} else if (expectedResult == 'Password cannot be empty') {
    WebUI.verifyElementPresent(findTestObject('lbl_ErrorPassword'), 5)
}

WebUI.closeBrowser()