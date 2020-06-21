import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login berhasil'), [('username') : 'admin', ('password') : 'password', ('login_expected') : 'pass'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/a_Pasien'))

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/a_Tambah'))

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nama_name'), nama_pasien)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nomor Rekam Medis_medical_record_number'), 
    no_rekam_medis)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Nomor Telepon_phone_number'), tlpn)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Tanggal Lahir_dob'), ttl)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/textarea_Alamat_address'), alamat)

if (disabilitas == 'yes') {
    WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/label_Disabilitas'))
}

WebUI.click(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/button_Simpan'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/div_         Sukses          Berhasil menyi_650d4c'), 
    0)

WebUI.setText(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Search_form-control form-control-sm'), 
    nama_pasien)

WebUI.sendKeys(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/input_Search_form-control form-control-sm'), 
    Keys.chord(Keys.ENTER))

if (expected_tampil_pasien == 'pass') {
    WebUI.verifyElementPresent(findTestObject('Page_Sistem Antrian Disabilitas/td_Jarwo', [('text') : nama_pasien]), 0)
} else if (expected_tampil_pasien == 'fail') {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Sistem Antrian Disabilitas/td_No matching records found'), 
        0)
}

WebUI.closeBrowser()

