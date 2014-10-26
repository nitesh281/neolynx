package com.neolynx.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = -3283768669894206348L;

	@Getter
	private INVALID_REQUEST_CODE invalidRequestCode;

	private static Map<INVALID_REQUEST_CODE, InvalidRequestException> errorCodeToExMap = new HashMap<InvalidRequestException.INVALID_REQUEST_CODE, InvalidRequestException>(
			8);
	//private static Map<INVALID_REQUEST_CODE, TGetPromotedAppResponse> errorCodeToErrorResponse = new HashMap<InvalidRequestException.INVALID_REQUEST_CODE, TGetPromotedAppResponse>(8);

	public InvalidRequestException(INVALID_REQUEST_CODE invalidRequestCode) {
		this.invalidRequestCode = invalidRequestCode;
	}

	public enum INVALID_REQUEST_CODE {

		INVALID_FREQUENCY(1000), 
		INVALID_COUNTRY(1001), 
		INVALID_UUID_MAP(1002), 
		INVALID_DEVICE(1003), 
		UNSUPPORTED_DEVICE(1004), 
		REQUEST_PARAM_MISSING(1005), 
		INVALID_MESSAGE_BODY(1006);

		@Getter
		private int errorCode;

		private INVALID_REQUEST_CODE(int errorCode) {
			this.errorCode = errorCode;
		}

	}

	static {
		errorCodeToExMap.put(INVALID_REQUEST_CODE.INVALID_COUNTRY, new InvalidRequestException(INVALID_REQUEST_CODE.INVALID_COUNTRY));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.INVALID_FREQUENCY, new InvalidRequestException(INVALID_REQUEST_CODE.INVALID_FREQUENCY));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.INVALID_UUID_MAP, new InvalidRequestException(INVALID_REQUEST_CODE.INVALID_UUID_MAP));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.INVALID_DEVICE, new InvalidRequestException(INVALID_REQUEST_CODE.INVALID_DEVICE));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.UNSUPPORTED_DEVICE, new InvalidRequestException(INVALID_REQUEST_CODE.UNSUPPORTED_DEVICE));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.REQUEST_PARAM_MISSING, new InvalidRequestException(INVALID_REQUEST_CODE.REQUEST_PARAM_MISSING));
		errorCodeToExMap.put(INVALID_REQUEST_CODE.INVALID_MESSAGE_BODY, new InvalidRequestException(INVALID_REQUEST_CODE.INVALID_MESSAGE_BODY));
/*
		{
			TGetPromotedAppResponse getPromotedAppResponseInvalidCountry = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseInvalidCountry.setData(null);
			getPromotedAppResponseInvalidCountry.setErrorCode(INVALID_REQUEST_CODE.INVALID_COUNTRY.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.INVALID_COUNTRY, getPromotedAppResponseInvalidCountry);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseInvalidDevice = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseInvalidDevice.setData(null);
			getPromotedAppResponseInvalidDevice.setErrorCode(INVALID_REQUEST_CODE.INVALID_DEVICE.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.INVALID_DEVICE, getPromotedAppResponseInvalidDevice);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseInvaldUUIDMap = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseInvaldUUIDMap.setData(null);
			getPromotedAppResponseInvaldUUIDMap.setErrorCode(INVALID_REQUEST_CODE.INVALID_UUID_MAP.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.INVALID_UUID_MAP, getPromotedAppResponseInvaldUUIDMap);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseUnsupportedDevice = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseUnsupportedDevice.setData(null);
			getPromotedAppResponseUnsupportedDevice.setErrorCode(INVALID_REQUEST_CODE.UNSUPPORTED_DEVICE.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.UNSUPPORTED_DEVICE, getPromotedAppResponseUnsupportedDevice);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseMissingRequestParam = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseMissingRequestParam.setData(null);
			getPromotedAppResponseMissingRequestParam.setErrorCode(INVALID_REQUEST_CODE.REQUEST_PARAM_MISSING.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.REQUEST_PARAM_MISSING, getPromotedAppResponseMissingRequestParam);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseInvalidFrequency = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseInvalidFrequency.setData(null);
			getPromotedAppResponseInvalidFrequency.setErrorCode(INVALID_REQUEST_CODE.INVALID_FREQUENCY.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.INVALID_FREQUENCY, getPromotedAppResponseInvalidFrequency);
		}

		{
			TGetPromotedAppResponse getPromotedAppResponseInvalidMessageBody = new TGetPromotedAppResponse(false, 0l);
			getPromotedAppResponseInvalidMessageBody.setData(null);
			getPromotedAppResponseInvalidMessageBody.setErrorCode(INVALID_REQUEST_CODE.INVALID_MESSAGE_BODY.getErrorCode());

			errorCodeToErrorResponse.put(INVALID_REQUEST_CODE.INVALID_MESSAGE_BODY, getPromotedAppResponseInvalidMessageBody);
		}
*/
	}

	public static InvalidRequestException getException(INVALID_REQUEST_CODE invalidRequestCode) {
		return errorCodeToExMap.get(invalidRequestCode);
	}
/*
	public static TGetPromotedAppResponse getErrorResponse(INVALID_REQUEST_CODE invalidRequestCode) {
		return errorCodeToErrorResponse.get(invalidRequestCode);
	}*/
}
