package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CustomerPaymentProfileMaskedType;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetCustomerPaymentProfileControllerTest extends ApiCoreTestBase {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApiCoreTestBase.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ApiCoreTestBase.tearDownAfterClass();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void mockGetCustomerPaymentProfileControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetCustomerPaymentProfileRequest, GetCustomerPaymentProfileResponse> mockController = getMockController();
		
		final GetCustomerPaymentProfileRequest mockRequest = factory.createGetCustomerPaymentProfileRequest();
		mockRequest.setRefId(refId);
		
		CustomerPaymentProfileMaskedType paymentProfile = factory.createCustomerPaymentProfileMaskedType();
		paymentProfile.setCustomerPaymentProfileId(counterStr);
		
		final GetCustomerPaymentProfileResponse   mockResponse = factory.createGetCustomerPaymentProfileResponse();
		mockResponse.setPaymentProfile( paymentProfile);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetCustomerPaymentProfileResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getPaymentProfile());
		Assert.assertNotNull(controllerResponse.getPaymentProfile().getCustomerPaymentProfileId());
		logger.info(String.format("GetCustomerPaymentProfile: Details:%s", controllerResponse.getPaymentProfile().getCustomerPaymentProfileId()));
	}
}
