import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable

class HandsOn{
	@AfterTestCase
	def AfterTestCase(TestCaseContext testCaseContext) {
		if(testCaseContext.getTestCaseStatus()=='PASSED') {
			GlobalVariable.numOfPasses++
		}
		if(testCaseContext.getTestCaseStatus()=='FAILED') {
			GlobalVariable.numOfFails++
		}
	}

	@AfterTestSuite
	def AfterTestSuite(TestSuiteContext testSuiteContext) {
		println ("Passes:" + GlobalVariable.numOfPasses)
		println ("Failures:" + GlobalVariable.numOfFails)
	}
}