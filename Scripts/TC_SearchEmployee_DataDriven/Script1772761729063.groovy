import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com')

WebUI.setText(findTestObject('txt_Username'), 'Admin')
WebUI.setText(findTestObject('txt_Password'), 'admin123')
WebUI.click(findTestObject('btn_Login'))

WebUI.click(findTestObject('mnu_PIM'))
WebUI.click(findTestObject('mnu_EmployeeList'))

WebUI.setText(findTestObject('txt_SearchName'), keyword)
WebUI.click(findTestObject('btn_Search'))

if (shouldFound == 'true') {
    def actualName = WebUI.getText(findTestObject('itm_FirstResult'))
    WebUI.verifyMatch(actualName, '.*' + expectedName + '.*', true)
} else {
    WebUI.verifyElementPresent(findTestObject('lbl_NoRecord'), 5)
}

WebUI.click(findTestObject('lnk_Logout'))
WebUI.closeBrowser()